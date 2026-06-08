package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class NavigationRailFrameLayout extends FrameLayout {
    int paddingTop;
    boolean scrollingEnabled;

    public NavigationRailFrameLayout(@NonNull Context context) {
        super(context);
        this.paddingTop = 0;
        this.scrollingEnabled = false;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z9, int i, int i6, int i10, int i11) {
        super.onLayout(z9, i, i6, i10, i11);
        int childCount = getChildCount();
        int i12 = this.paddingTop;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int max = Math.max(i12, childAt.getTop()) + layoutParams.topMargin;
            childAt.layout(childAt.getLeft(), max, childAt.getRight(), childAt.getMeasuredHeight() + max);
            i12 = max + childAt.getMeasuredHeight() + layoutParams.bottomMargin;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i6) {
        super.onMeasure(i, i6);
        int childCount = getChildCount();
        int i10 = 0;
        View childAt = getChildAt(0);
        int size = View.MeasureSpec.getSize(i6);
        if (childCount > 1) {
            View childAt2 = getChildAt(0);
            measureChild(childAt2, i, i6);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt2.getLayoutParams();
            i10 = layoutParams.topMargin + childAt2.getMeasuredHeight() + layoutParams.bottomMargin;
            int i11 = (size - i10) - this.paddingTop;
            childAt = getChildAt(1);
            if (!this.scrollingEnabled) {
                i6 = View.MeasureSpec.makeMeasureSpec(i11, Integer.MIN_VALUE);
            }
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        measureChild(childAt, i, i6);
        setMeasuredDimension(getMeasuredWidth(), Math.max(size, this.paddingTop + i10 + childAt.getMeasuredHeight() + layoutParams2.bottomMargin + layoutParams2.topMargin));
    }

    public void setPaddingTop(int i) {
        this.paddingTop = i;
    }

    public void setScrollingEnabled(boolean z9) {
        this.scrollingEnabled = z9;
    }
}
