package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import com.google.android.material.R;
import j$.util.Objects;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class LinearProgressIndicator extends BaseProgressIndicator<LinearProgressIndicatorSpec> {
    public static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_LinearProgressIndicator;
    public static final int INDETERMINATE_ANIMATION_TYPE_CONTIGUOUS = 0;
    public static final int INDETERMINATE_ANIMATION_TYPE_DISJOINT = 1;
    public static final int INDICATOR_DIRECTION_END_TO_START = 3;
    public static final int INDICATOR_DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int INDICATOR_DIRECTION_RIGHT_TO_LEFT = 1;
    public static final int INDICATOR_DIRECTION_START_TO_END = 2;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndeterminateAnimationType {
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface IndicatorDirection {
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i, DEF_STYLE_RES);
        initializeDrawables();
        this.initialized = true;
    }

    private void initializeDrawables() {
        LinearDrawingDelegate linearDrawingDelegate = new LinearDrawingDelegate((LinearProgressIndicatorSpec) this.spec);
        setIndeterminateDrawable(IndeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.spec, linearDrawingDelegate));
        setProgressDrawable(DeterminateDrawable.createLinearDrawable(getContext(), (LinearProgressIndicatorSpec) this.spec, linearDrawingDelegate));
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public LinearProgressIndicatorSpec createSpec(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        return new LinearProgressIndicatorSpec(context, attributeSet);
    }

    public int getIndeterminateAnimationType() {
        return ((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType;
    }

    public int getIndicatorDirection() {
        return ((LinearProgressIndicatorSpec) this.spec).indicatorDirection;
    }

    @Px
    public int getTrackInnerCornerRadius() {
        return ((LinearProgressIndicatorSpec) this.spec).trackInnerCornerRadius;
    }

    @Nullable
    public Integer getTrackStopIndicatorPadding() {
        return ((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorPadding;
    }

    @Px
    public int getTrackStopIndicatorSize() {
        return ((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize;
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator, android.view.View
    public void onLayout(boolean z9, int i, int i6, int i10, int i11) {
        super.onLayout(z9, i, i6, i10, i11);
        S s6 = this.spec;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s6;
        boolean z10 = true;
        if (((LinearProgressIndicatorSpec) s6).indicatorDirection != 1 && ((getLayoutDirection() != 1 || ((LinearProgressIndicatorSpec) this.spec).indicatorDirection != 2) && (getLayoutDirection() != 0 || ((LinearProgressIndicatorSpec) this.spec).indicatorDirection != 3))) {
            z10 = false;
        }
        linearProgressIndicatorSpec.drawHorizontallyInverse = z10;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i, int i6, int i10, int i11) {
        int paddingRight = i - (getPaddingRight() + getPaddingLeft());
        int paddingBottom = i6 - (getPaddingBottom() + getPaddingTop());
        IndeterminateDrawable<LinearProgressIndicatorSpec> indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
        DeterminateDrawable<LinearProgressIndicatorSpec> progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingRight, paddingBottom);
        }
    }

    public void setIndeterminateAnimationType(int i) {
        if (((LinearProgressIndicatorSpec) this.spec).indeterminateAnimationType == i) {
            return;
        }
        if (visibleToUser() && isIndeterminate()) {
            a.i("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
            return;
        }
        S s6 = this.spec;
        ((LinearProgressIndicatorSpec) s6).indeterminateAnimationType = i;
        ((LinearProgressIndicatorSpec) s6).validateSpec();
        if (i == 0) {
            getIndeterminateDrawable().setAnimatorDelegate(new LinearIndeterminateContiguousAnimatorDelegate((LinearProgressIndicatorSpec) this.spec));
        } else {
            getIndeterminateDrawable().setAnimatorDelegate(new LinearIndeterminateDisjointAnimatorDelegate(getContext(), (LinearProgressIndicatorSpec) this.spec));
        }
        registerSwitchIndeterminateModeCallback();
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setIndicatorColor(@NonNull int... iArr) {
        super.setIndicatorColor(iArr);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
    }

    public void setIndicatorDirection(int i) {
        S s6 = this.spec;
        ((LinearProgressIndicatorSpec) s6).indicatorDirection = i;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) s6;
        boolean z9 = true;
        if (i != 1 && ((getLayoutDirection() != 1 || ((LinearProgressIndicatorSpec) this.spec).indicatorDirection != 2) && (getLayoutDirection() != 0 || i != 3))) {
            z9 = false;
        }
        linearProgressIndicatorSpec.drawHorizontallyInverse = z9;
        invalidate();
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setProgressCompat(int i, boolean z9) {
        S s6 = this.spec;
        if (s6 != 0 && ((LinearProgressIndicatorSpec) s6).indeterminateAnimationType == 0 && isIndeterminate()) {
            return;
        }
        super.setProgressCompat(i, z9);
    }

    @Override // com.google.android.material.progressindicator.BaseProgressIndicator
    public void setTrackCornerRadius(int i) {
        super.setTrackCornerRadius(i);
        ((LinearProgressIndicatorSpec) this.spec).validateSpec();
        invalidate();
    }

    public void setTrackInnerCornerRadius(@Px int i) {
        S s6 = this.spec;
        if (((LinearProgressIndicatorSpec) s6).trackInnerCornerRadius != i) {
            ((LinearProgressIndicatorSpec) s6).trackInnerCornerRadius = Math.round(Math.min(i, ((LinearProgressIndicatorSpec) s6).trackThickness / 2.0f));
            S s9 = this.spec;
            ((LinearProgressIndicatorSpec) s9).useRelativeTrackInnerCornerRadius = false;
            ((LinearProgressIndicatorSpec) s9).hasInnerCornerRadius = true;
            ((LinearProgressIndicatorSpec) s9).validateSpec();
            invalidate();
        }
    }

    public void setTrackInnerCornerRadiusFraction(float f) {
        S s6 = this.spec;
        if (((LinearProgressIndicatorSpec) s6).trackInnerCornerRadiusFraction != f) {
            ((LinearProgressIndicatorSpec) s6).trackInnerCornerRadiusFraction = Math.min(f, 0.5f);
            S s9 = this.spec;
            ((LinearProgressIndicatorSpec) s9).useRelativeTrackInnerCornerRadius = true;
            ((LinearProgressIndicatorSpec) s9).hasInnerCornerRadius = true;
            ((LinearProgressIndicatorSpec) s9).validateSpec();
            invalidate();
        }
    }

    public void setTrackStopIndicatorPadding(@Nullable Integer num) {
        if (Objects.equals(((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorPadding, num)) {
            return;
        }
        ((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorPadding = num;
        invalidate();
    }

    public void setTrackStopIndicatorSize(@Px int i) {
        S s6 = this.spec;
        if (((LinearProgressIndicatorSpec) s6).trackStopIndicatorSize != i) {
            ((LinearProgressIndicatorSpec) s6).trackStopIndicatorSize = Math.min(i, ((LinearProgressIndicatorSpec) s6).trackThickness);
            ((LinearProgressIndicatorSpec) this.spec).validateSpec();
            invalidate();
        }
    }

    public LinearProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    public LinearProgressIndicator(@NonNull Context context) {
        this(context, null);
    }
}
