package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {

    @Px
    private int itemMinimumHeight;

    @Px
    private int itemSpacing;
    private final FrameLayout.LayoutParams layoutParams;

    public NavigationRailMenuView(@NonNull Context context) {
        super(context);
        this.itemMinimumHeight = -1;
        this.itemSpacing = 0;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.layoutParams = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    private int makeSharedHeightSpec(int i, int i6, int i10) {
        int max = i6 / Math.max(1, i10);
        int i11 = this.itemMinimumHeight;
        if (i11 == -1) {
            i11 = View.MeasureSpec.getSize(i);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(i11, max), 0);
    }

    private int measureChildHeight(View view, int i, int i6) {
        view.measure(i, i6);
        if (view.getVisibility() != 8) {
            return view.getMeasuredHeight();
        }
        return 0;
    }

    private int measureSharedChildHeights(int i, int i6, int i10, View view) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6, 0);
        int childCount = getChildCount();
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (!(childAt instanceof NavigationBarItemView)) {
                int measureChildHeight = measureChildHeight(childAt, i, makeMeasureSpec);
                i6 -= measureChildHeight;
                i11 += measureChildHeight;
            }
        }
        int makeSharedHeightSpec = view == null ? makeSharedHeightSpec(i, Math.max(i6, 0), i10) : View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt2 = getChildAt(i14);
            if (childAt2.getVisibility() == 0) {
                i13++;
            }
            if ((childAt2 instanceof NavigationBarItemView) && childAt2 != view) {
                i11 += measureChildHeight(childAt2, i, makeSharedHeightSpec);
            }
        }
        return (Math.max(0, i13 - 1) * this.itemSpacing) + i11;
    }

    private int measureShiftingChildHeights(int i, int i6, int i10) {
        int i11;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            i11 = measureChildHeight(childAt, i, makeSharedHeightSpec(i, i6, i10));
            i6 -= i11;
            i10--;
        } else {
            i11 = 0;
        }
        return i11 + measureSharedChildHeights(i, i6, i10, childAt);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    public NavigationBarItemView createNavigationBarItemView(@NonNull Context context) {
        return new NavigationRailItemView(context);
    }

    @Px
    public int getItemMinimumHeight() {
        return this.itemMinimumHeight;
    }

    @Px
    public int getItemSpacing() {
        return this.itemSpacing;
    }

    public int getMenuGravity() {
        return this.layoutParams.gravity;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z9, int i, int i6, int i10, int i11) {
        int childCount = getChildCount();
        int i12 = i10 - i;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                i14 += childAt.getMeasuredHeight();
                i13++;
            }
        }
        int max = i13 <= 1 ? 0 : Math.max(0, Math.min((getMeasuredHeight() - i14) / (i13 - 1), this.itemSpacing));
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt2 = getChildAt(i17);
            if (childAt2.getVisibility() != 8) {
                int measuredHeight = childAt2.getMeasuredHeight();
                childAt2.layout(0, i16, i12, measuredHeight + i16);
                i16 += measuredHeight + max;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i6) {
        int size = View.MeasureSpec.getSize(i6);
        int currentVisibleContentItemCount = getCurrentVisibleContentItemCount();
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.resolveSizeAndState((currentVisibleContentItemCount <= 1 || !isShifting(getLabelVisibilityMode(), currentVisibleContentItemCount)) ? measureSharedChildHeights(i, size, currentVisibleContentItemCount, null) : measureShiftingChildHeights(i, size, currentVisibleContentItemCount), i6, 0));
    }

    public void setItemMinimumHeight(@Px int i) {
        if (this.itemMinimumHeight != i) {
            this.itemMinimumHeight = i;
            requestLayout();
        }
    }

    public void setItemSpacing(@Px int i) {
        if (this.itemSpacing != i) {
            this.itemSpacing = i;
            requestLayout();
        }
    }

    public void setMenuGravity(int i) {
        FrameLayout.LayoutParams layoutParams = this.layoutParams;
        if (layoutParams.gravity != i) {
            layoutParams.gravity = i;
            setLayoutParams(layoutParams);
        }
    }
}
