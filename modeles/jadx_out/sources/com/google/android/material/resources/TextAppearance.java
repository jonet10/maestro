package com.google.android.material.resources;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class TextAppearance {
    private static final String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;
    private Typeface font;

    @Nullable
    public final String fontFamily;

    @FontRes
    private final int fontFamilyResourceId;

    @Nullable
    public String fontVariationSettings;
    public final boolean hasLetterSpacing;
    public final float letterSpacing;

    @Nullable
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;

    @Nullable
    private ColorStateList textColor;

    @Nullable
    public final ColorStateList textColorHint;

    @Nullable
    public final ColorStateList textColorLink;
    private float textSize;
    public final int textStyle;
    public final int typeface;
    private boolean fontResolved = false;
    private boolean systemFontLoadAttempted = false;

    public TextAppearance(@NonNull Context context, @StyleRes int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextAppearance);
        setTextSize(obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f));
        setTextColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor));
        this.textColorHint = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.textColorLink = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.textStyle = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.typeface = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int indexWithValue = MaterialResources.getIndexWithValue(obtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.fontFamilyResourceId = obtainStyledAttributes.getResourceId(indexWithValue, 0);
        this.fontFamily = obtainStyledAttributes.getString(indexWithValue);
        this.textAllCaps = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.shadowDx = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.shadowDy = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.shadowRadius = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i, com.google.android.material.R.styleable.MaterialTextAppearance);
        this.hasLetterSpacing = obtainStyledAttributes2.hasValue(com.google.android.material.R.styleable.MaterialTextAppearance_android_letterSpacing);
        this.letterSpacing = obtainStyledAttributes2.getFloat(com.google.android.material.R.styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
        if (Build.VERSION.SDK_INT >= 26) {
            this.fontVariationSettings = obtainStyledAttributes2.getString(MaterialResources.getIndexWithValue(obtainStyledAttributes2, com.google.android.material.R.styleable.MaterialTextAppearance_fontVariationSettings, com.google.android.material.R.styleable.MaterialTextAppearance_android_fontVariationSettings));
        }
        obtainStyledAttributes2.recycle();
    }

    private void createFallbackFont() {
        String str;
        if (this.font == null && (str = this.fontFamily) != null) {
            this.font = Typeface.create(str, this.textStyle);
        }
        if (this.font == null) {
            int i = this.typeface;
            if (i == 1) {
                this.font = Typeface.SANS_SERIF;
            } else if (i == 2) {
                this.font = Typeface.SERIF;
            } else if (i != 3) {
                this.font = Typeface.DEFAULT;
            } else {
                this.font = Typeface.MONOSPACE;
            }
            this.font = Typeface.create(this.font, this.textStyle);
        }
    }

    @Nullable
    private Typeface getSystemTypeface(Context context) {
        Typeface create;
        if (this.systemFontLoadAttempted) {
            return null;
        }
        this.systemFontLoadAttempted = true;
        String readFontProviderSystemFontFamily = readFontProviderSystemFontFamily(context, this.fontFamilyResourceId);
        if (readFontProviderSystemFontFamily == null || (create = Typeface.create(readFontProviderSystemFontFamily, 0)) == Typeface.DEFAULT) {
            return null;
        }
        return Typeface.create(create, this.textStyle);
    }

    private boolean maybeLoadFontSynchronously(Context context) {
        if (TextAppearanceConfig.shouldLoadFontSynchronously()) {
            getFont(context);
            return true;
        }
        if (this.fontResolved) {
            return true;
        }
        int i = this.fontFamilyResourceId;
        if (i == 0) {
            return false;
        }
        Typeface cachedFont = ResourcesCompat.getCachedFont(context, i);
        if (cachedFont != null) {
            this.font = cachedFont;
            this.fontResolved = true;
            return true;
        }
        Typeface systemTypeface = getSystemTypeface(context);
        if (systemTypeface == null) {
            return false;
        }
        this.font = systemTypeface;
        this.fontResolved = true;
        return true;
    }

    @Nullable
    @SuppressLint({"ResourceType"})
    private static String readFontProviderSystemFontFamily(Context context, @FontRes int i) {
        Resources resources = context.getResources();
        if (i != 0 && resources.getResourceTypeName(i).equals("font")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                while (xml.getEventType() != 1) {
                    if (xml.getEventType() == 2 && xml.getName().equals("font-family")) {
                        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xml), androidx.core.R.styleable.FontFamily);
                        String string = obtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderSystemFontFamily);
                        obtainAttributes.recycle();
                        return string;
                    }
                    xml.next();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public Typeface getFallbackFont() {
        createFallbackFont();
        return this.font;
    }

    @NonNull
    @VisibleForTesting
    public Typeface getFont(@NonNull Context context) {
        if (this.fontResolved) {
            return this.font;
        }
        if (!context.isRestricted()) {
            try {
                Typeface font = ResourcesCompat.getFont(context, this.fontFamilyResourceId);
                this.font = font;
                if (font != null) {
                    this.font = Typeface.create(font, this.textStyle);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e10) {
                Log.d(TAG, "Error loading font " + this.fontFamily, e10);
            }
        }
        createFallbackFont();
        this.fontResolved = true;
        return this.font;
    }

    public void getFontAsync(@NonNull Context context, @NonNull final TextAppearanceFontCallback textAppearanceFontCallback) {
        if (!maybeLoadFontSynchronously(context)) {
            createFallbackFont();
        }
        int i = this.fontFamilyResourceId;
        if (i == 0) {
            this.fontResolved = true;
        }
        if (this.fontResolved) {
            textAppearanceFontCallback.onFontRetrieved(this.font, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i, new ResourcesCompat.FontCallback() { // from class: com.google.android.material.resources.TextAppearance.1
                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                /* renamed from: onFontRetrievalFailed */
                public void lambda$callbackFailAsync$1(int i6) {
                    TextAppearance.this.fontResolved = true;
                    textAppearanceFontCallback.onFontRetrievalFailed(i6);
                }

                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                /* renamed from: onFontRetrieved */
                public void lambda$callbackSuccessAsync$0(@NonNull Typeface typeface) {
                    TextAppearance textAppearance = TextAppearance.this;
                    textAppearance.font = Typeface.create(typeface, textAppearance.textStyle);
                    TextAppearance.this.fontResolved = true;
                    textAppearanceFontCallback.onFontRetrieved(TextAppearance.this.font, false);
                }
            }, null);
        } catch (Resources.NotFoundException unused) {
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(1);
        } catch (Exception e10) {
            Log.d(TAG, "Error loading font " + this.fontFamily, e10);
            this.fontResolved = true;
            textAppearanceFontCallback.onFontRetrievalFailed(-3);
        }
    }

    @Nullable
    @RequiresApi(26)
    public String getFontVariationSettings() {
        return this.fontVariationSettings;
    }

    @Nullable
    public ColorStateList getTextColor() {
        return this.textColor;
    }

    public float getTextSize() {
        return this.textSize;
    }

    @RequiresApi(26)
    public void setFontVariationSettings(@Nullable String str) {
        this.fontVariationSettings = str;
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        this.textColor = colorStateList;
    }

    public void setTextSize(float f) {
        this.textSize = f;
    }

    public void updateDrawState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        updateMeasureState(context, textPaint, textAppearanceFontCallback);
        ColorStateList colorStateList = this.textColor;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : ViewCompat.MEASURED_STATE_MASK);
        float f = this.shadowRadius;
        float f10 = this.shadowDx;
        float f11 = this.shadowDy;
        ColorStateList colorStateList2 = this.shadowColor;
        textPaint.setShadowLayer(f, f10, f11, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void updateMeasureState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull TextAppearanceFontCallback textAppearanceFontCallback) {
        Typeface typeface;
        if (maybeLoadFontSynchronously(context) && this.fontResolved && (typeface = this.font) != null) {
            updateTextPaintMeasureState(context, textPaint, typeface);
        } else {
            getFontAsync(context, textPaint, textAppearanceFontCallback);
        }
    }

    public void updateTextPaintMeasureState(@NonNull Context context, @NonNull TextPaint textPaint, @NonNull Typeface typeface) {
        Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(context, typeface);
        if (maybeCopyWithFontWeightAdjustment != null) {
            typeface = maybeCopyWithFontWeightAdjustment;
        }
        textPaint.setTypeface(typeface);
        int i = this.textStyle & (~typeface.getStyle());
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.textSize);
        if (Build.VERSION.SDK_INT >= 26) {
            textPaint.setFontVariationSettings(this.fontVariationSettings);
        }
        if (this.hasLetterSpacing) {
            textPaint.setLetterSpacing(this.letterSpacing);
        }
    }

    public void getFontAsync(@NonNull final Context context, @NonNull final TextPaint textPaint, @NonNull final TextAppearanceFontCallback textAppearanceFontCallback) {
        updateTextPaintMeasureState(context, textPaint, getFallbackFont());
        getFontAsync(context, new TextAppearanceFontCallback() { // from class: com.google.android.material.resources.TextAppearance.2
            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void onFontRetrievalFailed(int i) {
                textAppearanceFontCallback.onFontRetrievalFailed(i);
            }

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void onFontRetrieved(@NonNull Typeface typeface, boolean z9) {
                TextAppearance.this.updateTextPaintMeasureState(context, textPaint, typeface);
                textAppearanceFontCallback.onFontRetrieved(typeface, z9);
            }
        });
    }
}
