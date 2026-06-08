package com.google.android.material.loadingindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.AnimatorDurationScaleProvider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class LoadingIndicator extends View implements Drawable.Callback {
    static final int DEF_STYLE_RES = R.style.Widget_Material3_LoadingIndicator;

    @NonNull
    private final LoadingIndicatorDrawable drawable;

    @NonNull
    private final LoadingIndicatorSpec specs;

    public LoadingIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        Context context2 = getContext();
        LoadingIndicatorDrawable create = LoadingIndicatorDrawable.create(context2, new LoadingIndicatorSpec(context2, attributeSet, i));
        this.drawable = create;
        create.setCallback(this);
        this.specs = create.getDrawingDelegate().specs;
        setAnimatorDurationScaleProvider(new AnimatorDurationScaleProvider());
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return ProgressBar.class.getName();
    }

    @ColorInt
    public int getContainerColor() {
        return this.specs.containerColor;
    }

    @Px
    public int getContainerHeight() {
        return this.specs.containerHeight;
    }

    @Px
    public int getContainerWidth() {
        return this.specs.containerWidth;
    }

    @NonNull
    public LoadingIndicatorDrawable getDrawable() {
        return this.drawable;
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.specs.indicatorColors;
    }

    @Px
    public int getIndicatorSize() {
        return this.specs.indicatorSize;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        invalidate();
    }

    public boolean isEffectivelyVisible() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        int save = canvas.save();
        if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingRight() + getPaddingLeft()), getHeight() - (getPaddingBottom() + getPaddingTop()));
        }
        this.drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i6) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i6);
        LoadingIndicatorDrawingDelegate drawingDelegate = this.drawable.getDrawingDelegate();
        int paddingRight = getPaddingRight() + getPaddingLeft() + drawingDelegate.getPreferredWidth();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + drawingDelegate.getPreferredHeight();
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(size, paddingRight), BasicMeasure.EXACTLY);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(paddingRight, BasicMeasure.EXACTLY);
        }
        if (mode2 == Integer.MIN_VALUE) {
            i6 = View.MeasureSpec.makeMeasureSpec(Math.min(size2, paddingBottom), BasicMeasure.EXACTLY);
        } else if (mode2 == 0) {
            i6 = View.MeasureSpec.makeMeasureSpec(paddingBottom, BasicMeasure.EXACTLY);
        }
        super.onMeasure(i, i6);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        this.drawable.setBounds(0, 0, i, i6);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        this.drawable.setVisible(visibleToUser(), false, i == 0);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.drawable.setVisible(visibleToUser(), false, i == 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void setAnimatorDurationScaleProvider(@NonNull AnimatorDurationScaleProvider animatorDurationScaleProvider) {
        this.drawable.animatorDurationScaleProvider = animatorDurationScaleProvider;
    }

    public void setContainerColor(@ColorInt int i) {
        LoadingIndicatorSpec loadingIndicatorSpec = this.specs;
        if (loadingIndicatorSpec.containerColor != i) {
            loadingIndicatorSpec.containerColor = i;
            invalidate();
        }
    }

    public void setContainerHeight(@Px int i) {
        LoadingIndicatorSpec loadingIndicatorSpec = this.specs;
        if (loadingIndicatorSpec.containerHeight != i) {
            loadingIndicatorSpec.containerHeight = i;
            requestLayout();
            invalidate();
        }
    }

    public void setContainerWidth(@Px int i) {
        LoadingIndicatorSpec loadingIndicatorSpec = this.specs;
        if (loadingIndicatorSpec.containerWidth != i) {
            loadingIndicatorSpec.containerWidth = i;
            requestLayout();
            invalidate();
        }
    }

    public void setIndicatorColor(@ColorInt int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{MaterialColors.getColor(getContext(), androidx.appcompat.R.attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.specs.indicatorColors = iArr;
        this.drawable.getAnimatorDelegate().invalidateSpecValues();
        invalidate();
    }

    public void setIndicatorSize(@Px int i) {
        LoadingIndicatorSpec loadingIndicatorSpec = this.specs;
        if (loadingIndicatorSpec.indicatorSize != i) {
            loadingIndicatorSpec.indicatorSize = i;
            requestLayout();
            invalidate();
        }
    }

    public boolean visibleToUser() {
        return isAttachedToWindow() && getWindowVisibility() == 0 && isEffectivelyVisible();
    }

    public LoadingIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.loadingIndicatorStyle);
    }

    public LoadingIndicator(@NonNull Context context) {
        this(context, null);
    }
}
