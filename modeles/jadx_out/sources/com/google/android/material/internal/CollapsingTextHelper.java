package com.google.android.material.internal;

import a4.x;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TypefaceUtils;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;

    @Nullable
    private static final Paint DEBUG_DRAW_PAINT = null;
    private static final String ELLIPSIS_NORMAL = "…";
    private static final float FADE_MODE_THRESHOLD_FRACTION_RELATIVE = 0.5f;
    private static final int ONE_LINE = 1;
    public static final int SEMITRANSPARENT_MAGENTA = 1090453759;
    private static final String TAG = "CollapsingTextHelper";
    private boolean alignBaselineAtBottom;
    private boolean boundsChanged;

    @NonNull
    private final Rect collapsedBounds;

    @Nullable
    private Rect collapsedBoundsForPlacement;
    private float collapsedDrawX;
    private float collapsedDrawY;
    private CancelableFontCallback collapsedFontCallback;
    private float collapsedLetterSpacing;
    private ColorStateList collapsedShadowColor;
    private float collapsedShadowDx;
    private float collapsedShadowDy;
    private float collapsedShadowRadius;
    private float collapsedTextBlend;
    private ColorStateList collapsedTextColor;
    private float collapsedTextWidth;
    private Typeface collapsedTypeface;
    private Typeface collapsedTypefaceBold;
    private Typeface collapsedTypefaceDefault;

    @NonNull
    private final RectF currentBounds;
    private float currentDrawX;
    private float currentDrawY;
    private float currentLetterSpacing;
    private int currentMaxLines;
    private int currentOffsetY;
    private int currentShadowColor;
    private float currentShadowDx;
    private float currentShadowDy;
    private float currentShadowRadius;
    private float currentTextSize;
    private Typeface currentTypeface;

    @NonNull
    private final Rect expandedBounds;
    private float expandedDrawX;
    private float expandedDrawY;
    private CancelableFontCallback expandedFontCallback;
    private float expandedFraction;
    private float expandedLetterSpacing;
    private int expandedLineCount;
    private ColorStateList expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private float expandedTextBlend;
    private ColorStateList expandedTextColor;
    private Typeface expandedTypeface;
    private Typeface expandedTypefaceBold;
    private Typeface expandedTypefaceDefault;
    private boolean fadeModeEnabled;
    private float fadeModeStartFraction;
    private float fadeModeThresholdFraction;
    private boolean isRtl;
    private TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;

    @Nullable
    private StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer;

    @Nullable
    private CharSequence text;
    private StaticLayout textLayout;

    @NonNull
    private final TextPaint textPaint;
    private TimeInterpolator textSizeInterpolator;

    @Nullable
    private CharSequence textToDraw;
    private CharSequence textToDrawCollapsed;

    @NonNull
    private final TextPaint tmpPaint;
    private final View view;
    private int expandedTextGravity = 16;
    private int collapsedTextGravity = 16;
    private float expandedTextSize = 15.0f;
    private float collapsedTextSize = 15.0f;
    private TextUtils.TruncateAt titleTextEllipsize = TextUtils.TruncateAt.END;
    private boolean isRtlTextDirectionHeuristicsEnabled = true;
    private int expandedMaxLines = 1;
    private int collapsedMaxLines = 1;
    private float lineSpacingAdd = 0.0f;
    private float lineSpacingMultiplier = 1.0f;
    private int hyphenationFrequency = StaticLayoutBuilderCompat.DEFAULT_HYPHENATION_FREQUENCY;
    private int collapsedHeight = -1;
    private int expandedHeight = -1;

    public CollapsingTextHelper(View view) {
        this.view = view;
        TextPaint textPaint = new TextPaint(129);
        this.textPaint = textPaint;
        this.tmpPaint = new TextPaint(textPaint);
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
        maybeUpdateFontWeightAdjustment(view.getContext().getResources().getConfiguration());
    }

    @ColorInt
    private static int blendARGB(@ColorInt int i, @ColorInt int i6, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        float f10 = 1.0f - f;
        return Color.argb(Math.round((Color.alpha(i6) * f) + (Color.alpha(i) * f10)), Math.round((Color.red(i6) * f) + (Color.red(i) * f10)), Math.round((Color.green(i6) * f) + (Color.green(i) * f10)), Math.round((Color.blue(i6) * f) + (Color.blue(i) * f10)));
    }

    private void calculateBaseOffsets(boolean z9) {
        float measureTextWidth;
        calculateUsingTextSize(1.0f, z9);
        if (this.textToDraw != null && this.textLayout != null) {
            boolean shouldTruncateCollapsedToSingleLine = shouldTruncateCollapsedToSingleLine();
            CharSequence charSequence = this.textToDraw;
            if (shouldTruncateCollapsedToSingleLine) {
                charSequence = TextUtils.ellipsize(charSequence, this.textPaint, this.textLayout.getWidth(), this.titleTextEllipsize);
            }
            this.textToDrawCollapsed = charSequence;
        }
        CharSequence charSequence2 = this.textToDrawCollapsed;
        if (charSequence2 != null) {
            this.collapsedTextWidth = measureTextWidth(this.textPaint, charSequence2);
        } else {
            this.collapsedTextWidth = 0.0f;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl ? 1 : 0);
        Rect rect = this.collapsedBoundsForPlacement;
        if (rect == null) {
            rect = this.collapsedBounds;
        }
        int i = absoluteGravity & 112;
        if (i == 48) {
            this.collapsedDrawY = rect.top;
        } else if (i != 80) {
            this.collapsedDrawY = rect.centerY() - ((this.textPaint.descent() - this.textPaint.ascent()) / 2.0f);
        } else {
            this.collapsedDrawY = this.textPaint.ascent() + rect.bottom;
        }
        int i6 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i6 == 1) {
            this.collapsedDrawX = rect.centerX() - (this.collapsedTextWidth / 2.0f);
        } else if (i6 != 5) {
            this.collapsedDrawX = rect.left;
        } else {
            this.collapsedDrawX = rect.right - this.collapsedTextWidth;
        }
        if (this.collapsedTextWidth <= this.collapsedBounds.width()) {
            float f = this.collapsedDrawX;
            float max = Math.max(0.0f, this.collapsedBounds.left - f) + f;
            this.collapsedDrawX = max;
            this.collapsedDrawX = Math.min(0.0f, this.collapsedBounds.right - (this.collapsedTextWidth + max)) + max;
        }
        if (getCollapsedFullSingleLineHeight() <= this.collapsedBounds.height()) {
            float f10 = this.collapsedDrawY;
            float max2 = Math.max(0.0f, this.collapsedBounds.top - f10) + f10;
            this.collapsedDrawY = max2;
            this.collapsedDrawY = Math.min(0.0f, this.collapsedBounds.bottom - (getCollapsedTextHeight() + max2)) + max2;
        }
        calculateUsingTextSize(0.0f, z9);
        float height = this.textLayout != null ? r11.getHeight() : 0.0f;
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout == null || this.expandedMaxLines <= 1) {
            CharSequence charSequence3 = this.textToDraw;
            measureTextWidth = charSequence3 != null ? measureTextWidth(this.textPaint, charSequence3) : 0.0f;
        } else {
            measureTextWidth = staticLayout.getWidth();
        }
        StaticLayout staticLayout2 = this.textLayout;
        this.expandedLineCount = staticLayout2 != null ? staticLayout2.getLineCount() : 0;
        int absoluteGravity2 = Gravity.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0);
        int i10 = absoluteGravity2 & 112;
        if (i10 != 48) {
            Rect rect2 = this.expandedBounds;
            if (i10 != 80) {
                this.expandedDrawY = rect2.centerY() - (height / 2.0f);
            } else {
                this.expandedDrawY = (rect2.bottom - height) + (this.alignBaselineAtBottom ? this.textPaint.descent() : 0.0f);
            }
        } else {
            this.expandedDrawY = this.expandedBounds.top;
        }
        int i11 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i11 != 1) {
            Rect rect3 = this.expandedBounds;
            if (i11 != 5) {
                this.expandedDrawX = rect3.left;
            } else {
                this.expandedDrawX = rect3.right - measureTextWidth;
            }
        } else {
            this.expandedDrawX = this.expandedBounds.centerX() - (measureTextWidth / 2.0f);
        }
        setInterpolatedTextSize(this.expandedFraction);
    }

    private void calculateCurrentOffsets() {
        calculateOffsets(this.expandedFraction);
    }

    private float calculateFadeModeTextAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float f10 = this.fadeModeThresholdFraction;
        return f <= f10 ? AnimationUtils.lerp(1.0f, 0.0f, this.fadeModeStartFraction, f10, f) : AnimationUtils.lerp(0.0f, 1.0f, f10, 1.0f, f);
    }

    private float calculateFadeModeThresholdFraction() {
        float f = this.fadeModeStartFraction;
        return x.f(1.0f, f, 0.5f, f);
    }

    private boolean calculateIsRtl(@NonNull CharSequence charSequence) {
        boolean isDefaultIsRtl = isDefaultIsRtl();
        return this.isRtlTextDirectionHeuristicsEnabled ? isTextDirectionHeuristicsIsRtl(charSequence, isDefaultIsRtl) : isDefaultIsRtl;
    }

    private void calculateOffsets(float f) {
        float f10;
        interpolateBounds(f);
        if (!this.fadeModeEnabled) {
            this.currentDrawX = lerp(this.expandedDrawX, this.collapsedDrawX, f, this.positionInterpolator);
            this.currentDrawY = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
            setInterpolatedTextSize(f);
            f10 = f;
        } else if (f < this.fadeModeThresholdFraction) {
            this.currentDrawX = this.expandedDrawX;
            this.currentDrawY = this.expandedDrawY;
            setInterpolatedTextSize(0.0f);
            f10 = 0.0f;
        } else {
            this.currentDrawX = this.collapsedDrawX;
            this.currentDrawY = this.collapsedDrawY - Math.max(0, this.currentOffsetY);
            setInterpolatedTextSize(1.0f);
            f10 = 1.0f;
        }
        TimeInterpolator timeInterpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        setCollapsedTextBlend(1.0f - lerp(0.0f, 1.0f, 1.0f - f, timeInterpolator));
        setExpandedTextBlend(lerp(1.0f, 0.0f, f, timeInterpolator));
        ColorStateList colorStateList = this.collapsedTextColor;
        ColorStateList colorStateList2 = this.expandedTextColor;
        TextPaint textPaint = this.textPaint;
        if (colorStateList != colorStateList2) {
            textPaint.setColor(blendARGB(getCurrentExpandedTextColor(), getCurrentCollapsedTextColor(), f10));
        } else {
            textPaint.setColor(getCurrentCollapsedTextColor());
        }
        float f11 = this.collapsedLetterSpacing;
        float f12 = this.expandedLetterSpacing;
        TextPaint textPaint2 = this.textPaint;
        if (f11 != f12) {
            textPaint2.setLetterSpacing(lerp(f12, f11, f, timeInterpolator));
        } else {
            textPaint2.setLetterSpacing(f11);
        }
        this.currentShadowRadius = lerp(this.expandedShadowRadius, this.collapsedShadowRadius, f, null);
        this.currentShadowDx = lerp(this.expandedShadowDx, this.collapsedShadowDx, f, null);
        this.currentShadowDy = lerp(this.expandedShadowDy, this.collapsedShadowDy, f, null);
        int blendARGB = blendARGB(getCurrentColor(this.expandedShadowColor), getCurrentColor(this.collapsedShadowColor), f);
        this.currentShadowColor = blendARGB;
        this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, blendARGB);
        if (this.fadeModeEnabled) {
            this.textPaint.setAlpha((int) (calculateFadeModeTextAlpha(f) * this.textPaint.getAlpha()));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint3 = this.textPaint;
                textPaint3.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, textPaint3.getAlpha()));
            }
        }
        this.view.postInvalidateOnAnimation();
    }

    private void calculateUsingTextSize(float f, boolean z9) {
        Typeface typeface;
        float f10;
        float f11;
        if (this.text == null) {
            return;
        }
        float width = this.collapsedBounds.width();
        float width2 = this.expandedBounds.width();
        if (isClose(f, 1.0f)) {
            f10 = shouldTruncateCollapsedToSingleLine() ? this.collapsedTextSize : this.expandedTextSize;
            f11 = shouldTruncateCollapsedToSingleLine() ? this.collapsedLetterSpacing : this.expandedLetterSpacing;
            this.scale = shouldTruncateCollapsedToSingleLine() ? 1.0f : lerp(this.expandedTextSize, this.collapsedTextSize, f, this.textSizeInterpolator) / this.expandedTextSize;
            if (!shouldTruncateCollapsedToSingleLine()) {
                width = width2;
            }
            typeface = this.collapsedTypeface;
            width2 = width;
        } else {
            float f12 = this.expandedTextSize;
            float f13 = this.expandedLetterSpacing;
            typeface = this.expandedTypeface;
            if (isClose(f, 0.0f)) {
                this.scale = 1.0f;
            } else {
                this.scale = lerp(this.expandedTextSize, this.collapsedTextSize, f, this.textSizeInterpolator) / this.expandedTextSize;
            }
            float f14 = this.collapsedTextSize / this.expandedTextSize;
            float f15 = width2 * f14;
            if (!z9 && !this.fadeModeEnabled && f15 > width && shouldTruncateCollapsedToSingleLine()) {
                width2 = Math.min(width / f14, width2);
            }
            f10 = f12;
            f11 = f13;
        }
        int i = f < 0.5f ? this.expandedMaxLines : this.collapsedMaxLines;
        if (width2 > 0.0f) {
            boolean z10 = this.currentTextSize != f10;
            boolean z11 = this.currentLetterSpacing != f11;
            boolean z12 = this.currentTypeface != typeface;
            StaticLayout staticLayout = this.textLayout;
            boolean z13 = z10 || z11 || (staticLayout != null && (width2 > ((float) staticLayout.getWidth()) ? 1 : (width2 == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z12 || (this.currentMaxLines != i) || this.boundsChanged;
            this.currentTextSize = f10;
            this.currentLetterSpacing = f11;
            this.currentTypeface = typeface;
            this.boundsChanged = false;
            this.currentMaxLines = i;
            this.textPaint.setLinearText(this.scale != 1.0f);
            r5 = z13;
        }
        if (this.textToDraw == null || r5) {
            this.textPaint.setTextSize(this.currentTextSize);
            this.textPaint.setTypeface(this.currentTypeface);
            this.textPaint.setLetterSpacing(this.currentLetterSpacing);
            this.isRtl = calculateIsRtl(this.text);
            StaticLayout createStaticLayout = createStaticLayout(shouldDrawMultiline() ? i : 1, this.textPaint, this.text, width2 * (shouldTruncateCollapsedToSingleLine() ? 1.0f : this.scale), this.isRtl);
            this.textLayout = createStaticLayout;
            this.textToDraw = createStaticLayout.getText();
        }
    }

    private StaticLayout createStaticLayout(int i, TextPaint textPaint, CharSequence charSequence, float f, boolean z9) {
        StaticLayout staticLayout;
        try {
            staticLayout = StaticLayoutBuilderCompat.obtain(charSequence, textPaint, (int) f).setEllipsize(this.titleTextEllipsize).setIsRtl(z9).setAlignment(i == 1 ? Layout.Alignment.ALIGN_NORMAL : getMultilineTextLayoutAlignment()).setIncludePad(false).setMaxLines(i).setLineSpacing(this.lineSpacingAdd, this.lineSpacingMultiplier).setHyphenationFrequency(this.hyphenationFrequency).setStaticLayoutBuilderConfigurer(this.staticLayoutBuilderConfigurer).build();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e10) {
            Log.e(TAG, e10.getCause().getMessage(), e10);
            staticLayout = null;
        }
        return (StaticLayout) Preconditions.checkNotNull(staticLayout);
    }

    private void drawMultilineTransition(@NonNull Canvas canvas, float f, float f10) {
        int alpha = this.textPaint.getAlpha();
        canvas.translate(f, f10);
        if (!this.fadeModeEnabled) {
            this.textPaint.setAlpha((int) (this.expandedTextBlend * alpha));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint = this.textPaint;
                textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, textPaint.getAlpha()));
            }
            this.textLayout.draw(canvas);
        }
        if (!this.fadeModeEnabled) {
            this.textPaint.setAlpha((int) (this.collapsedTextBlend * alpha));
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            TextPaint textPaint2 = this.textPaint;
            textPaint2.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, textPaint2.getAlpha()));
        }
        int lineBaseline = this.textLayout.getLineBaseline(0);
        CharSequence charSequence = this.textToDrawCollapsed;
        float f11 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f11, this.textPaint);
        if (i >= 31) {
            this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, this.currentShadowColor);
        }
        if (this.fadeModeEnabled) {
            return;
        }
        String trim = this.textToDrawCollapsed.toString().trim();
        if (trim.endsWith(ELLIPSIS_NORMAL)) {
            trim = trim.substring(0, trim.length() - 1);
        }
        String str = trim;
        this.textPaint.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.textLayout.getLineEnd(0), str.length()), 0.0f, f11, (Paint) this.textPaint);
    }

    private float getCollapsedTextLeftBound(int i, int i6) {
        if (i6 == 17 || (i6 & 7) == 1) {
            return (i / 2.0f) - (this.collapsedTextWidth / 2.0f);
        }
        if ((i6 & GravityCompat.END) == 8388613 || (i6 & 5) == 5) {
            boolean z9 = this.isRtl;
            Rect rect = this.collapsedBounds;
            return z9 ? rect.left : rect.right - this.collapsedTextWidth;
        }
        boolean z10 = this.isRtl;
        Rect rect2 = this.collapsedBounds;
        return z10 ? rect2.right - this.collapsedTextWidth : rect2.left;
    }

    private float getCollapsedTextRightBound(@NonNull RectF rectF, int i, int i6) {
        if (i6 == 17 || (i6 & 7) == 1) {
            return (this.collapsedTextWidth / 2.0f) + (i / 2.0f);
        }
        return ((i6 & GravityCompat.END) == 8388613 || (i6 & 5) == 5) ? this.isRtl ? rectF.left + this.collapsedTextWidth : this.collapsedBounds.right : this.isRtl ? this.collapsedBounds.right : rectF.left + this.collapsedTextWidth;
    }

    @ColorInt
    private int getCurrentColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.state;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    @ColorInt
    private int getCurrentExpandedTextColor() {
        return getCurrentColor(this.expandedTextColor);
    }

    private Layout.Alignment getMultilineTextLayoutAlignment() {
        int absoluteGravity = Gravity.getAbsoluteGravity(this.expandedTextGravity, this.isRtl ? 1 : 0) & 7;
        if (absoluteGravity == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        boolean z9 = this.isRtl;
        return absoluteGravity != 5 ? z9 ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : z9 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE;
    }

    private void getTextPaintCollapsed(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.collapsedTextSize);
        textPaint.setTypeface(this.collapsedTypeface);
        textPaint.setLetterSpacing(this.collapsedLetterSpacing);
    }

    private void getTextPaintExpanded(@NonNull TextPaint textPaint) {
        textPaint.setTextSize(this.expandedTextSize);
        textPaint.setTypeface(this.expandedTypeface);
        textPaint.setLetterSpacing(this.expandedLetterSpacing);
    }

    private void interpolateBounds(float f) {
        boolean z9 = this.fadeModeEnabled;
        RectF rectF = this.currentBounds;
        if (z9) {
            rectF.set(f < this.fadeModeThresholdFraction ? this.expandedBounds : this.collapsedBounds);
            return;
        }
        rectF.left = lerp(this.expandedBounds.left, this.collapsedBounds.left, f, this.positionInterpolator);
        this.currentBounds.top = lerp(this.expandedDrawY, this.collapsedDrawY, f, this.positionInterpolator);
        this.currentBounds.right = lerp(this.expandedBounds.right, this.collapsedBounds.right, f, this.positionInterpolator);
        this.currentBounds.bottom = lerp(this.expandedBounds.bottom, this.collapsedBounds.bottom, f, this.positionInterpolator);
    }

    private static boolean isClose(float f, float f10) {
        return Math.abs(f - f10) < 1.0E-5f;
    }

    private boolean isDefaultIsRtl() {
        return this.view.getLayoutDirection() == 1;
    }

    private boolean isTextDirectionHeuristicsIsRtl(@NonNull CharSequence charSequence, boolean z9) {
        return (z9 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    private static float lerp(float f, float f10, float f11, @Nullable TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f11 = timeInterpolator.getInterpolation(f11);
        }
        return AnimationUtils.lerp(f, f10, f11);
    }

    private float measureTextWidth(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private static boolean rectEquals(@NonNull Rect rect, int i, int i6, int i10, int i11) {
        return rect.left == i && rect.top == i6 && rect.right == i10 && rect.bottom == i11;
    }

    private void setCollapsedTextBlend(float f) {
        this.collapsedTextBlend = f;
        this.view.postInvalidateOnAnimation();
    }

    private boolean setCollapsedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.collapsedTypefaceDefault == typeface) {
            return false;
        }
        this.collapsedTypefaceDefault = typeface;
        Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), typeface);
        this.collapsedTypefaceBold = maybeCopyWithFontWeightAdjustment;
        if (maybeCopyWithFontWeightAdjustment == null) {
            maybeCopyWithFontWeightAdjustment = this.collapsedTypefaceDefault;
        }
        this.collapsedTypeface = maybeCopyWithFontWeightAdjustment;
        return true;
    }

    private void setExpandedTextBlend(float f) {
        this.expandedTextBlend = f;
        this.view.postInvalidateOnAnimation();
    }

    private boolean setExpandedTypefaceInternal(Typeface typeface) {
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        if (this.expandedTypefaceDefault == typeface) {
            return false;
        }
        this.expandedTypefaceDefault = typeface;
        Typeface maybeCopyWithFontWeightAdjustment = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), typeface);
        this.expandedTypefaceBold = maybeCopyWithFontWeightAdjustment;
        if (maybeCopyWithFontWeightAdjustment == null) {
            maybeCopyWithFontWeightAdjustment = this.expandedTypefaceDefault;
        }
        this.expandedTypeface = maybeCopyWithFontWeightAdjustment;
        return true;
    }

    private void setInterpolatedTextSize(float f) {
        calculateUsingTextSize(f);
        this.view.postInvalidateOnAnimation();
    }

    private boolean shouldDrawMultiline() {
        if (this.expandedMaxLines > 1 || this.collapsedMaxLines > 1) {
            return !this.isRtl || this.fadeModeEnabled;
        }
        return false;
    }

    private boolean shouldTruncateCollapsedToSingleLine() {
        return this.collapsedMaxLines == 1;
    }

    public void draw(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (this.textToDraw == null || this.currentBounds.width() <= 0.0f || this.currentBounds.height() <= 0.0f) {
            return;
        }
        this.textPaint.setTextSize(this.currentTextSize);
        float f = this.currentDrawX;
        float f10 = this.currentDrawY;
        float f11 = this.scale;
        if (f11 != 1.0f && !this.fadeModeEnabled) {
            canvas.scale(f11, f11, f, f10);
        }
        if (shouldDrawMultiline() && shouldTruncateCollapsedToSingleLine() && (!this.fadeModeEnabled || this.expandedFraction > this.fadeModeThresholdFraction)) {
            drawMultilineTransition(canvas, this.currentDrawX - this.textLayout.getLineStart(0), f10);
        } else {
            canvas.translate(f, f10);
            this.textLayout.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    public float getCollapsedFullSingleLineHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return this.tmpPaint.descent() + (-this.tmpPaint.ascent());
    }

    public float getCollapsedSingleLineHeight() {
        getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public void getCollapsedTextBottomTextBounds(@NonNull RectF rectF, int i, int i6) {
        this.isRtl = calculateIsRtl(this.text);
        rectF.left = Math.max(getCollapsedTextLeftBound(i, i6), this.collapsedBounds.left);
        rectF.top = this.collapsedBounds.top;
        rectF.right = Math.min(getCollapsedTextRightBound(rectF, i, i6), this.collapsedBounds.right);
        rectF.bottom = getCollapsedTextHeight() + this.collapsedBounds.top;
        if (this.textLayout == null || shouldTruncateCollapsedToSingleLine()) {
            return;
        }
        float lineWidth = (this.collapsedTextSize / this.expandedTextSize) * this.textLayout.getLineWidth(r4.getLineCount() - 1);
        if (this.isRtl) {
            rectF.left = rectF.right - lineWidth;
        } else {
            rectF.right = rectF.left + lineWidth;
        }
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public float getCollapsedTextHeight() {
        int i = this.collapsedHeight;
        return i != -1 ? i : getCollapsedSingleLineHeight();
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public Typeface getCollapsedTypeface() {
        Typeface typeface = this.collapsedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    @ColorInt
    public int getCurrentCollapsedTextColor() {
        return getCurrentColor(this.collapsedTextColor);
    }

    public int getExpandedLineCount() {
        return this.expandedLineCount;
    }

    public int getExpandedMaxLines() {
        return this.expandedMaxLines;
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public float getExpandedTextFullSingleLineHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return this.tmpPaint.descent() + (-this.tmpPaint.ascent());
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public float getExpandedTextHeight() {
        int i = this.expandedHeight;
        return i != -1 ? i : getExpandedTextSingleLineHeight();
    }

    public float getExpandedTextSingleLineHeight() {
        getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    public Typeface getExpandedTypeface() {
        Typeface typeface = this.expandedTypeface;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public float getFadeModeThresholdFraction() {
        return this.fadeModeThresholdFraction;
    }

    @RequiresApi(23)
    public int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.textLayout;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    @RequiresApi(23)
    public float getLineSpacingAdd() {
        return this.textLayout.getSpacingAdd();
    }

    @RequiresApi(23)
    public float getLineSpacingMultiplier() {
        return this.textLayout.getSpacingMultiplier();
    }

    @Nullable
    public TimeInterpolator getPositionInterpolator() {
        return this.positionInterpolator;
    }

    @Nullable
    public CharSequence getText() {
        return this.text;
    }

    @NonNull
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.titleTextEllipsize;
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.isRtlTextDirectionHeuristicsEnabled;
    }

    public final boolean isStateful() {
        ColorStateList colorStateList = this.collapsedTextColor;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.expandedTextColor;
        return colorStateList2 != null && colorStateList2.isStateful();
    }

    public void maybeUpdateFontWeightAdjustment(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.collapsedTypefaceDefault;
            if (typeface != null) {
                this.collapsedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(configuration, typeface);
            }
            Typeface typeface2 = this.expandedTypefaceDefault;
            if (typeface2 != null) {
                this.expandedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(configuration, typeface2);
            }
            Typeface typeface3 = this.collapsedTypefaceBold;
            if (typeface3 == null) {
                typeface3 = this.collapsedTypefaceDefault;
            }
            this.collapsedTypeface = typeface3;
            Typeface typeface4 = this.expandedTypefaceBold;
            if (typeface4 == null) {
                typeface4 = this.expandedTypefaceDefault;
            }
            this.expandedTypeface = typeface4;
            recalculate(true);
        }
    }

    public void recalculate(boolean z9) {
        if ((this.view.getHeight() <= 0 || this.view.getWidth() <= 0) && !z9) {
            return;
        }
        calculateBaseOffsets(z9);
        calculateCurrentOffsets();
    }

    public void setCollapsedAndExpandedTextColor(@Nullable ColorStateList colorStateList) {
        if (this.collapsedTextColor == colorStateList && this.expandedTextColor == colorStateList) {
            return;
        }
        this.collapsedTextColor = colorStateList;
        this.expandedTextColor = colorStateList;
        recalculate();
    }

    public void setCollapsedBounds(int i, int i6, int i10, int i11) {
        if (rectEquals(this.collapsedBounds, i, i6, i10, i11)) {
            return;
        }
        this.collapsedBounds.set(i, i6, i10, i11);
        this.boundsChanged = true;
    }

    public void setCollapsedBoundsForOffsets(int i, int i6, int i10, int i11) {
        if (this.collapsedBoundsForPlacement == null) {
            this.collapsedBoundsForPlacement = new Rect(i, i6, i10, i11);
            this.boundsChanged = true;
        }
        if (rectEquals(this.collapsedBoundsForPlacement, i, i6, i10, i11)) {
            return;
        }
        this.collapsedBoundsForPlacement.set(i, i6, i10, i11);
        this.boundsChanged = true;
    }

    public void setCollapsedMaxLines(int i) {
        if (i != this.collapsedMaxLines) {
            this.collapsedMaxLines = i;
            recalculate();
        }
    }

    public void setCollapsedTextAppearance(int i) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i);
        if (textAppearance.getTextColor() != null) {
            this.collapsedTextColor = textAppearance.getTextColor();
        }
        if (textAppearance.getTextSize() != 0.0f) {
            this.collapsedTextSize = textAppearance.getTextSize();
        }
        ColorStateList colorStateList = textAppearance.shadowColor;
        if (colorStateList != null) {
            this.collapsedShadowColor = colorStateList;
        }
        this.collapsedShadowDx = textAppearance.shadowDx;
        this.collapsedShadowDy = textAppearance.shadowDy;
        this.collapsedShadowRadius = textAppearance.shadowRadius;
        this.collapsedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.collapsedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.collapsedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.1
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setCollapsedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        recalculate();
    }

    public void setCollapsedTextColor(ColorStateList colorStateList) {
        if (this.collapsedTextColor != colorStateList) {
            this.collapsedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setCollapsedTextGravity(int i) {
        if (this.collapsedTextGravity != i) {
            this.collapsedTextGravity = i;
            recalculate();
        }
    }

    public void setCollapsedTextSize(float f) {
        if (this.collapsedTextSize != f) {
            this.collapsedTextSize = f;
            recalculate();
        }
    }

    public void setCollapsedTypeface(Typeface typeface) {
        if (setCollapsedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setCurrentOffsetY(int i) {
        this.currentOffsetY = i;
    }

    public void setExpandedBounds(int i, int i6, int i10, int i11, boolean z9) {
        if (rectEquals(this.expandedBounds, i, i6, i10, i11) && z9 == this.alignBaselineAtBottom) {
            return;
        }
        this.expandedBounds.set(i, i6, i10, i11);
        this.boundsChanged = true;
        this.alignBaselineAtBottom = z9;
    }

    public void setExpandedLetterSpacing(float f) {
        if (this.expandedLetterSpacing != f) {
            this.expandedLetterSpacing = f;
            recalculate();
        }
    }

    public void setExpandedMaxLines(int i) {
        if (i != this.expandedMaxLines) {
            this.expandedMaxLines = i;
            recalculate();
        }
    }

    public void setExpandedTextAppearance(int i) {
        TextAppearance textAppearance = new TextAppearance(this.view.getContext(), i);
        if (textAppearance.getTextColor() != null) {
            this.expandedTextColor = textAppearance.getTextColor();
        }
        if (textAppearance.getTextSize() != 0.0f) {
            this.expandedTextSize = textAppearance.getTextSize();
        }
        ColorStateList colorStateList = textAppearance.shadowColor;
        if (colorStateList != null) {
            this.expandedShadowColor = colorStateList;
        }
        this.expandedShadowDx = textAppearance.shadowDx;
        this.expandedShadowDy = textAppearance.shadowDy;
        this.expandedShadowRadius = textAppearance.shadowRadius;
        this.expandedLetterSpacing = textAppearance.letterSpacing;
        CancelableFontCallback cancelableFontCallback = this.expandedFontCallback;
        if (cancelableFontCallback != null) {
            cancelableFontCallback.cancel();
        }
        this.expandedFontCallback = new CancelableFontCallback(new CancelableFontCallback.ApplyFont() { // from class: com.google.android.material.internal.CollapsingTextHelper.2
            @Override // com.google.android.material.resources.CancelableFontCallback.ApplyFont
            public void apply(Typeface typeface) {
                CollapsingTextHelper.this.setExpandedTypeface(typeface);
            }
        }, textAppearance.getFallbackFont());
        textAppearance.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        recalculate();
    }

    public void setExpandedTextColor(ColorStateList colorStateList) {
        if (this.expandedTextColor != colorStateList) {
            this.expandedTextColor = colorStateList;
            recalculate();
        }
    }

    public void setExpandedTextGravity(int i) {
        if (this.expandedTextGravity != i) {
            this.expandedTextGravity = i;
            recalculate();
        }
    }

    public void setExpandedTextSize(float f) {
        if (this.expandedTextSize != f) {
            this.expandedTextSize = f;
            recalculate();
        }
    }

    public void setExpandedTypeface(Typeface typeface) {
        if (setExpandedTypefaceInternal(typeface)) {
            recalculate();
        }
    }

    public void setExpansionFraction(float f) {
        float clamp = MathUtils.clamp(f, 0.0f, 1.0f);
        if (clamp != this.expandedFraction) {
            this.expandedFraction = clamp;
            calculateCurrentOffsets();
        }
    }

    public void setFadeModeEnabled(boolean z9) {
        this.fadeModeEnabled = z9;
    }

    public void setFadeModeStartFraction(float f) {
        this.fadeModeStartFraction = f;
        this.fadeModeThresholdFraction = calculateFadeModeThresholdFraction();
    }

    @RequiresApi(23)
    public void setHyphenationFrequency(int i) {
        this.hyphenationFrequency = i;
    }

    @RequiresApi(23)
    public void setLineSpacingAdd(float f) {
        this.lineSpacingAdd = f;
    }

    @RequiresApi(23)
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f) {
        this.lineSpacingMultiplier = f;
    }

    public void setPositionInterpolator(TimeInterpolator timeInterpolator) {
        this.positionInterpolator = timeInterpolator;
        recalculate();
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z9) {
        this.isRtlTextDirectionHeuristicsEnabled = z9;
    }

    public final boolean setState(int[] iArr) {
        this.state = iArr;
        if (!isStateful()) {
            return false;
        }
        recalculate();
        return true;
    }

    @RequiresApi(23)
    public void setStaticLayoutBuilderConfigurer(@Nullable StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer) {
        if (this.staticLayoutBuilderConfigurer != staticLayoutBuilderConfigurer) {
            this.staticLayoutBuilderConfigurer = staticLayoutBuilderConfigurer;
            recalculate(true);
        }
    }

    public void setText(@Nullable CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.text, charSequence)) {
            this.text = charSequence;
            this.textToDraw = null;
            recalculate();
        }
    }

    public void setTextSizeInterpolator(TimeInterpolator timeInterpolator) {
        this.textSizeInterpolator = timeInterpolator;
        recalculate();
    }

    public void setTitleTextEllipsize(@NonNull TextUtils.TruncateAt truncateAt) {
        this.titleTextEllipsize = truncateAt;
        recalculate();
    }

    public void setTypefaces(Typeface typeface) {
        boolean collapsedTypefaceInternal = setCollapsedTypefaceInternal(typeface);
        boolean expandedTypefaceInternal = setExpandedTypefaceInternal(typeface);
        if (collapsedTypefaceInternal || expandedTypefaceInternal) {
            recalculate();
        }
    }

    public void updateTextHeights(int i) {
        getTextPaintCollapsed(this.tmpPaint);
        float f = i;
        this.collapsedHeight = createStaticLayout(this.collapsedMaxLines, this.tmpPaint, this.text, (this.collapsedTextSize / this.expandedTextSize) * f, this.isRtl).getHeight();
        getTextPaintExpanded(this.tmpPaint);
        this.expandedHeight = createStaticLayout(this.expandedMaxLines, this.tmpPaint, this.text, f, this.isRtl).getHeight();
    }

    public void setCollapsedBounds(@NonNull Rect rect) {
        setCollapsedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void recalculate() {
        recalculate(false);
    }

    public void setExpandedBounds(int i, int i6, int i10, int i11) {
        setExpandedBounds(i, i6, i10, i11, true);
    }

    public void setExpandedBounds(@NonNull Rect rect) {
        setExpandedBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void calculateUsingTextSize(float f) {
        calculateUsingTextSize(f, false);
    }
}
