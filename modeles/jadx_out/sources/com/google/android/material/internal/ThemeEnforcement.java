package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.appcompat.R;
import androidx.appcompat.widget.TintTypedArray;
import androidx.lifecycle.l;
import com.google.android.material.resources.MaterialAttributes;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ThemeEnforcement {
    private static final String APPCOMPAT_THEME_NAME = "Theme.AppCompat";
    private static final String MATERIAL_THEME_NAME = "Theme.MaterialComponents";
    private static final int[] APPCOMPAT_CHECK_ATTRS = {R.attr.colorPrimary};
    private static final int[] MATERIAL_CHECK_ATTRS = {com.google.android.material.R.attr.colorPrimaryVariant};

    private ThemeEnforcement() {
    }

    public static void checkAppCompatTheme(@NonNull Context context) {
        checkTheme(context, APPCOMPAT_CHECK_ATTRS, APPCOMPAT_THEME_NAME);
    }

    private static void checkCompatibleTheme(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i, @StyleRes int i6) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.ThemeEnforcement, i, i6);
        boolean z9 = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
        obtainStyledAttributes.recycle();
        if (z9) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(com.google.android.material.R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                checkMaterialTheme(context);
            }
        }
        checkAppCompatTheme(context);
    }

    public static void checkMaterialTheme(@NonNull Context context) {
        checkTheme(context, MATERIAL_CHECK_ATTRS, MATERIAL_THEME_NAME);
    }

    private static void checkTextAppearance(@NonNull Context context, AttributeSet attributeSet, @NonNull @StyleableRes int[] iArr, @AttrRes int i, @StyleRes int i6, @Nullable @StyleableRes int... iArr2) {
        boolean z9;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.ThemeEnforcement, i, i6);
        if (!obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.ThemeEnforcement_enforceTextAppearance, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            z9 = obtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1;
        } else {
            z9 = isCustomTextAppearanceValid(context, attributeSet, iArr, i, i6, iArr2);
        }
        obtainStyledAttributes.recycle();
        if (z9) {
            return;
        }
        com.google.gson.internal.a.p("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    }

    private static void checkTheme(@NonNull Context context, @NonNull int[] iArr, String str) {
        if (isTheme(context, iArr)) {
            return;
        }
        com.google.gson.internal.a.p(l.w("The style on this component requires your app theme to be ", str, " (or a descendant)."));
    }

    public static boolean isAppCompatTheme(@NonNull Context context) {
        return isTheme(context, APPCOMPAT_CHECK_ATTRS);
    }

    private static boolean isCustomTextAppearanceValid(@NonNull Context context, AttributeSet attributeSet, @NonNull @StyleableRes int[] iArr, @AttrRes int i, @StyleRes int i6, @NonNull @StyleableRes int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i6);
        for (int i10 : iArr2) {
            if (obtainStyledAttributes.getResourceId(i10, -1) == -1) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    public static boolean isMaterial3Theme(@NonNull Context context) {
        return MaterialAttributes.resolveBoolean(context, com.google.android.material.R.attr.isMaterial3Theme, false);
    }

    public static boolean isMaterialTheme(@NonNull Context context) {
        return isTheme(context, MATERIAL_CHECK_ATTRS);
    }

    private static boolean isTheme(@NonNull Context context, @NonNull int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i = 0; i < iArr.length; i++) {
            if (!obtainStyledAttributes.hasValue(i)) {
                obtainStyledAttributes.recycle();
                return false;
            }
        }
        obtainStyledAttributes.recycle();
        return true;
    }

    @NonNull
    public static TypedArray obtainStyledAttributes(@NonNull Context context, AttributeSet attributeSet, @NonNull @StyleableRes int[] iArr, @AttrRes int i, @StyleRes int i6, @StyleableRes int... iArr2) {
        checkCompatibleTheme(context, attributeSet, i, i6);
        checkTextAppearance(context, attributeSet, iArr, i, i6, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i6);
    }

    public static TintTypedArray obtainTintedStyledAttributes(@NonNull Context context, AttributeSet attributeSet, @NonNull @StyleableRes int[] iArr, @AttrRes int i, @StyleRes int i6, @StyleableRes int... iArr2) {
        checkCompatibleTheme(context, attributeSet, i, i6);
        checkTextAppearance(context, attributeSet, iArr, i, i6, iArr2);
        return TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i, i6);
    }
}
