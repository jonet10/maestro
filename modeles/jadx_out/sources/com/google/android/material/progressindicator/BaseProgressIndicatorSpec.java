package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.StyleRes;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.gson.internal.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class BaseProgressIndicatorSpec {
    public int hideAnimationBehavior;

    @FloatRange(from = 0.10000000149011612d, to = 10.0d)
    public float indeterminateAnimatorDurationScale;

    @NonNull
    public int[] indicatorColors = new int[0];

    @Px
    public int indicatorTrackGapSize;
    public int showAnimationBehavior;

    @ColorInt
    public int trackColor;

    @Px
    public int trackCornerRadius;
    public float trackCornerRadiusFraction;

    @Px
    public int trackThickness;
    public boolean useRelativeTrackCornerRadius;

    @Px
    public int waveAmplitude;

    @Px
    public int waveSpeed;

    @Px
    public int wavelengthDeterminate;

    @Px
    public int wavelengthIndeterminate;

    public BaseProgressIndicatorSpec(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i6) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.BaseProgressIndicator, i, i6, new int[0]);
        this.trackThickness = MaterialResources.getDimensionPixelSize(context, obtainStyledAttributes, R.styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.BaseProgressIndicator_trackCornerRadius);
        if (peekValue != null) {
            int i10 = peekValue.type;
            if (i10 == 5) {
                this.trackCornerRadius = Math.min(TypedValue.complexToDimensionPixelSize(peekValue.data, obtainStyledAttributes.getResources().getDisplayMetrics()), this.trackThickness / 2);
                this.useRelativeTrackCornerRadius = false;
            } else if (i10 == 6) {
                this.trackCornerRadiusFraction = Math.min(peekValue.getFraction(1.0f, 1.0f), 0.5f);
                this.useRelativeTrackCornerRadius = true;
            }
        }
        this.showAnimationBehavior = obtainStyledAttributes.getInt(R.styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.hideAnimationBehavior = obtainStyledAttributes.getInt(R.styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        this.indicatorTrackGapSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BaseProgressIndicator_indicatorTrackGapSize, 0);
        int abs = Math.abs(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BaseProgressIndicator_wavelength, 0));
        this.wavelengthDeterminate = Math.abs(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BaseProgressIndicator_wavelengthDeterminate, abs));
        this.wavelengthIndeterminate = Math.abs(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BaseProgressIndicator_wavelengthIndeterminate, abs));
        this.waveAmplitude = Math.abs(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BaseProgressIndicator_waveAmplitude, 0));
        this.waveSpeed = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BaseProgressIndicator_waveSpeed, 0);
        this.indeterminateAnimatorDurationScale = obtainStyledAttributes.getFloat(R.styleable.BaseProgressIndicator_indeterminateAnimatorDurationScale, 1.0f);
        loadIndicatorColors(context, obtainStyledAttributes);
        loadTrackColor(context, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    private void loadIndicatorColors(@NonNull Context context, @NonNull TypedArray typedArray) {
        if (!typedArray.hasValue(R.styleable.BaseProgressIndicator_indicatorColor)) {
            this.indicatorColors = new int[]{MaterialColors.getColor(context, androidx.appcompat.R.attr.colorPrimary, -1)};
            return;
        }
        if (typedArray.peekValue(R.styleable.BaseProgressIndicator_indicatorColor).type != 1) {
            this.indicatorColors = new int[]{typedArray.getColor(R.styleable.BaseProgressIndicator_indicatorColor, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(R.styleable.BaseProgressIndicator_indicatorColor, -1));
        this.indicatorColors = intArray;
        if (intArray.length != 0) {
            return;
        }
        a.p("indicatorColors cannot be empty when indicatorColor is not used.");
    }

    private void loadTrackColor(@NonNull Context context, @NonNull TypedArray typedArray) {
        if (typedArray.hasValue(R.styleable.BaseProgressIndicator_trackColor)) {
            this.trackColor = typedArray.getColor(R.styleable.BaseProgressIndicator_trackColor, -1);
            return;
        }
        this.trackColor = this.indicatorColors[0];
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
        float f = obtainStyledAttributes.getFloat(0, 0.2f);
        obtainStyledAttributes.recycle();
        this.trackColor = MaterialColors.compositeARGBWithAlpha(this.trackColor, (int) (f * 255.0f));
    }

    public int getTrackCornerRadiusInPx() {
        return this.useRelativeTrackCornerRadius ? (int) (this.trackThickness * this.trackCornerRadiusFraction) : this.trackCornerRadius;
    }

    public boolean hasWavyEffect(boolean z9) {
        if (this.waveAmplitude <= 0) {
            return false;
        }
        if (z9 || this.wavelengthIndeterminate <= 0) {
            return z9 && this.wavelengthDeterminate > 0;
        }
        return true;
    }

    public boolean isHideAnimationEnabled() {
        return this.hideAnimationBehavior != 0;
    }

    public boolean isShowAnimationEnabled() {
        return this.showAnimationBehavior != 0;
    }

    public boolean useStrokeCap() {
        return this.useRelativeTrackCornerRadius && this.trackCornerRadiusFraction == 0.5f;
    }

    @CallSuper
    public void validateSpec() {
        if (this.indicatorTrackGapSize >= 0) {
            return;
        }
        a.p("indicatorTrackGapSize must be >= 0.");
    }
}
