package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button actionView;
    private final TimeInterpolator contentInterpolator;
    private int maxInlineActionWidth;
    private TextView messageView;

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.contentInterpolator = MotionUtils.resolveThemeInterpolator(context, R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    private static void updateTopBottomPadding(@NonNull View view, int i, int i6) {
        if (view.isPaddingRelative()) {
            view.setPaddingRelative(view.getPaddingStart(), i, view.getPaddingEnd(), i6);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i6);
        }
    }

    private boolean updateViewsWithinLayout(int i, int i6, int i10) {
        boolean z9;
        if (i != getOrientation()) {
            setOrientation(i);
            z9 = true;
        } else {
            z9 = false;
        }
        if (this.messageView.getPaddingTop() == i6 && this.messageView.getPaddingBottom() == i10) {
            return z9;
        }
        updateTopBottomPadding(this.messageView, i6, i10);
        return true;
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentIn(int i, int i6) {
        this.messageView.setAlpha(0.0f);
        long j = i6;
        long j6 = i;
        this.messageView.animate().alpha(1.0f).setDuration(j).setInterpolator(this.contentInterpolator).setStartDelay(j6).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(0.0f);
            this.actionView.animate().alpha(1.0f).setDuration(j).setInterpolator(this.contentInterpolator).setStartDelay(j6).start();
        }
    }

    @Override // com.google.android.material.snackbar.ContentViewCallback
    public void animateContentOut(int i, int i6) {
        this.messageView.setAlpha(1.0f);
        long j = i6;
        long j6 = i;
        this.messageView.animate().alpha(0.0f).setDuration(j).setInterpolator(this.contentInterpolator).setStartDelay(j6).start();
        if (this.actionView.getVisibility() == 0) {
            this.actionView.setAlpha(1.0f);
            this.actionView.animate().alpha(0.0f).setDuration(j).setInterpolator(this.contentInterpolator).setStartDelay(j6).start();
        }
    }

    public Button getActionView() {
        return this.actionView;
    }

    public TextView getMessageView() {
        return this.messageView;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.messageView = (TextView) findViewById(R.id.snackbar_text);
        this.actionView = (Button) findViewById(R.id.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i6) {
        super.onMeasure(i, i6);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
        Layout layout = this.messageView.getLayout();
        boolean z9 = layout != null && layout.getLineCount() > 1;
        if (!z9 || this.maxInlineActionWidth <= 0 || this.actionView.getMeasuredWidth() <= this.maxInlineActionWidth) {
            if (!z9) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!updateViewsWithinLayout(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!updateViewsWithinLayout(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i, i6);
    }

    public void setMaxInlineActionWidth(int i) {
        this.maxInlineActionWidth = i;
    }

    public void updateActionTextColorAlphaIfNeeded(float f) {
        if (f != 1.0f) {
            this.actionView.setTextColor(MaterialColors.layer(MaterialColors.getColor(this, R.attr.colorSurface), this.actionView.getCurrentTextColor(), f));
        }
    }

    public SnackbarContentLayout(@NonNull Context context) {
        this(context, null);
    }
}
