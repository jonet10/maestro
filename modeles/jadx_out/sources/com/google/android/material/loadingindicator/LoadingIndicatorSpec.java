package com.google.android.material.loadingindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.gson.internal.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class LoadingIndicatorSpec {

    @ColorInt
    int containerColor;

    @Px
    int containerHeight;

    @Px
    int containerWidth;

    @NonNull
    int[] indicatorColors;

    @Px
    int indicatorSize;
    boolean scaleToFit;

    public LoadingIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i6) {
        this.scaleToFit = false;
        this.indicatorColors = new int[0];
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.m3_loading_indicator_shape_size);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.m3_loading_indicator_container_size);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.LoadingIndicator, i, i6, new int[0]);
        this.indicatorSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LoadingIndicator_indicatorSize, dimensionPixelSize);
        this.containerWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LoadingIndicator_containerWidth, dimensionPixelSize2);
        this.containerHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LoadingIndicator_containerHeight, dimensionPixelSize2);
        loadIndicatorColors(context, obtainStyledAttributes);
        this.containerColor = obtainStyledAttributes.getColor(R.styleable.LoadingIndicator_containerColor, 0);
        obtainStyledAttributes.recycle();
    }

    private void loadIndicatorColors(@NonNull Context context, @NonNull TypedArray typedArray) {
        if (!typedArray.hasValue(R.styleable.LoadingIndicator_indicatorColor)) {
            this.indicatorColors = new int[]{MaterialColors.getColor(context, androidx.appcompat.R.attr.colorPrimary, -1)};
            return;
        }
        if (typedArray.peekValue(R.styleable.LoadingIndicator_indicatorColor).type != 1) {
            this.indicatorColors = new int[]{typedArray.getColor(R.styleable.LoadingIndicator_indicatorColor, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(R.styleable.LoadingIndicator_indicatorColor, -1));
        this.indicatorColors = intArray;
        if (intArray.length != 0) {
            return;
        }
        a.p("indicatorColors cannot be empty when indicatorColor is not used.");
    }

    public void setScaleToFit(boolean z9) {
        this.scaleToFit = z9;
    }

    public LoadingIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        this(context, attributeSet, i, LoadingIndicator.DEF_STYLE_RES);
    }

    public LoadingIndicatorSpec(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.loadingIndicatorStyle);
    }
}
