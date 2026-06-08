package com.google.android.material.theme.overlay;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.ContextThemeWrapper;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class MaterialThemeOverlay {
    private static final int[] ANDROID_THEME_OVERLAY_ATTRS = {R.attr.theme, androidx.appcompat.R.attr.theme};
    private static final int[] MATERIAL_THEME_OVERLAY_ATTR = {com.google.android.material.R.attr.materialThemeOverlay};

    private MaterialThemeOverlay() {
    }

    @StyleRes
    private static int obtainAndroidThemeOverlayId(@NonNull Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ANDROID_THEME_OVERLAY_ATTRS);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    @NonNull
    private static int[] obtainMaterialOverlayIds(@NonNull Context context, @Nullable AttributeSet attributeSet, @NonNull int[] iArr, @AttrRes int i, @StyleRes int i6) {
        int[] iArr2 = new int[iArr.length];
        if (iArr.length > 0) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i6);
            for (int i10 = 0; i10 < iArr.length; i10++) {
                iArr2[i10] = obtainStyledAttributes.getResourceId(i10, 0);
            }
            obtainStyledAttributes.recycle();
        }
        return iArr2;
    }

    @StyleRes
    private static int obtainMaterialThemeOverlayId(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i6) {
        return obtainMaterialOverlayIds(context, attributeSet, MATERIAL_THEME_OVERLAY_ATTR, i, i6)[0];
    }

    @NonNull
    public static Context wrap(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i6, @NonNull int[] iArr) {
        int obtainMaterialThemeOverlayId = obtainMaterialThemeOverlayId(context, attributeSet, i, i6);
        boolean z9 = (context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).getThemeResId() == obtainMaterialThemeOverlayId;
        if (obtainMaterialThemeOverlayId == 0 || z9) {
            return context;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, obtainMaterialThemeOverlayId);
        for (int i10 : obtainMaterialOverlayIds(context, attributeSet, iArr, i, i6)) {
            if (i10 != 0) {
                contextThemeWrapper.getTheme().applyStyle(i10, true);
            }
        }
        int obtainAndroidThemeOverlayId = obtainAndroidThemeOverlayId(context, attributeSet);
        if (obtainAndroidThemeOverlayId != 0) {
            contextThemeWrapper.getTheme().applyStyle(obtainAndroidThemeOverlayId, true);
        }
        return contextThemeWrapper;
    }

    @NonNull
    public static Context wrap(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i6) {
        return wrap(context, attributeSet, i, i6, new int[0]);
    }
}
