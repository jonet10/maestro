package com.google.android.material.dockedtoolbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class DockedToolbarLayout extends FrameLayout {
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_DockedToolbar;
    private static final String TAG = "DockedToolbarLayout";
    private Boolean paddingBottomSystemWindowInsets;
    private Boolean paddingTopSystemWindowInsets;

    public DockedToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i6) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i6), attributeSet, i);
        Context context2 = getContext();
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.DockedToolbar, i, i6, new int[0]);
        if (obtainTintedStyledAttributes.hasValue(R.styleable.DockedToolbar_backgroundTint)) {
            int color = obtainTintedStyledAttributes.getColor(R.styleable.DockedToolbar_backgroundTint, 0);
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(context2, attributeSet, i, i6).build());
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
            setBackground(materialShapeDrawable);
        }
        if (obtainTintedStyledAttributes.hasValue(R.styleable.DockedToolbar_paddingTopSystemWindowInsets)) {
            this.paddingTopSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(R.styleable.DockedToolbar_paddingTopSystemWindowInsets, true));
        }
        if (obtainTintedStyledAttributes.hasValue(R.styleable.DockedToolbar_paddingBottomSystemWindowInsets)) {
            this.paddingBottomSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(R.styleable.DockedToolbar_paddingBottomSystemWindowInsets, true));
        }
        ViewUtils.doOnApplyWindowInsets(this, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.dockedtoolbar.DockedToolbarLayout.1
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            @NonNull
            public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
                if (DockedToolbarLayout.this.paddingTopSystemWindowInsets != null && DockedToolbarLayout.this.paddingBottomSystemWindowInsets != null && !DockedToolbarLayout.this.paddingTopSystemWindowInsets.booleanValue() && !DockedToolbarLayout.this.paddingBottomSystemWindowInsets.booleanValue()) {
                    return windowInsetsCompat;
                }
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout() | WindowInsetsCompat.Type.ime());
                int i10 = insets.bottom;
                int i11 = insets.top;
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                int i12 = (DockedToolbarLayout.this.hasGravity(layoutParams, 48) && DockedToolbarLayout.this.paddingTopSystemWindowInsets == null && DockedToolbarLayout.this.getFitsSystemWindows()) ? i11 : 0;
                int i13 = (DockedToolbarLayout.this.hasGravity(layoutParams, 80) && DockedToolbarLayout.this.paddingBottomSystemWindowInsets == null && DockedToolbarLayout.this.getFitsSystemWindows()) ? i10 : 0;
                if (DockedToolbarLayout.this.paddingBottomSystemWindowInsets != null) {
                    if (!DockedToolbarLayout.this.paddingBottomSystemWindowInsets.booleanValue()) {
                        i10 = 0;
                    }
                    i13 = i10;
                }
                if (DockedToolbarLayout.this.paddingTopSystemWindowInsets != null) {
                    if (!DockedToolbarLayout.this.paddingTopSystemWindowInsets.booleanValue()) {
                        i11 = 0;
                    }
                    i12 = i11;
                }
                relativePadding.top += i12;
                relativePadding.bottom += i13;
                relativePadding.applyToView(view);
                return windowInsetsCompat;
            }
        });
        setImportantForAccessibility(1);
        obtainTintedStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasGravity(ViewGroup.LayoutParams layoutParams, int i) {
        return layoutParams instanceof CoordinatorLayout.LayoutParams ? (((CoordinatorLayout.LayoutParams) layoutParams).gravity & i) == i : (layoutParams instanceof FrameLayout.LayoutParams) && (((FrameLayout.LayoutParams) layoutParams).gravity & i) == i;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i6) {
        super.onMeasure(i, i6);
        if (View.MeasureSpec.getMode(i6) != 1073741824) {
            int childCount = getChildCount();
            int max = Math.max(getMeasuredHeight(), getPaddingBottom() + getPaddingTop() + getSuggestedMinimumHeight());
            for (int i10 = 0; i10 < childCount; i10++) {
                measureChild(getChildAt(i10), i, View.MeasureSpec.makeMeasureSpec(max, BasicMeasure.EXACTLY));
            }
            setMeasuredDimension(getMeasuredWidth(), max);
        }
    }

    public DockedToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dockedToolbarStyle);
    }

    public DockedToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        this(context, attributeSet, i, DEF_STYLE_RES);
    }

    public DockedToolbarLayout(@NonNull Context context) {
        this(context, null);
    }
}
