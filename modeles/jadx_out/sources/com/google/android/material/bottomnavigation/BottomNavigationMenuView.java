package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private boolean itemHorizontalTranslationEnabled;
    private final List<Integer> tempChildWidths;

    public BottomNavigationMenuView(@NonNull Context context) {
        super(context);
        this.tempChildWidths = new ArrayList();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.inactiveItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    public NavigationBarItemView createNavigationBarItemView(@NonNull Context context) {
        return new BottomNavigationItemView(context);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z9, int i, int i6, int i10, int i11) {
        int childCount = getChildCount();
        int i12 = i10 - i;
        int i13 = i11 - i6;
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                if (getLayoutDirection() == 1) {
                    int i16 = i12 - i14;
                    childAt.layout(i16 - childAt.getMeasuredWidth(), 0, i16, i13);
                } else {
                    childAt.layout(i14, 0, childAt.getMeasuredWidth() + i14, i13);
                }
                i14 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i6) {
        int i10;
        int i11;
        int i12;
        int i13;
        int size = View.MeasureSpec.getSize(i);
        int currentVisibleContentItemCount = getCurrentVisibleContentItemCount();
        int childCount = getChildCount();
        this.tempChildWidths.clear();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i6), Integer.MIN_VALUE);
        int i14 = 0;
        if (getItemIconGravity() == 0) {
            if (isShifting(getLabelVisibilityMode(), currentVisibleContentItemCount) && isItemHorizontalTranslationEnabled()) {
                View childAt = getChildAt(getSelectedItemPosition());
                int i15 = this.activeItemMinWidth;
                if (childAt.getVisibility() != 8) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), makeMeasureSpec);
                    i15 = Math.max(i15, childAt.getMeasuredWidth());
                }
                int i16 = currentVisibleContentItemCount - (childAt.getVisibility() != 8 ? 1 : 0);
                int min = Math.min(size - (this.inactiveItemMinWidth * i16), Math.min(i15, this.activeItemMaxWidth));
                int i17 = size - min;
                int min2 = Math.min(i17 / (i16 != 0 ? i16 : 1), this.inactiveItemMaxWidth);
                int i18 = i17 - (i16 * min2);
                int i19 = 0;
                while (i19 < childCount) {
                    if (getChildAt(i19).getVisibility() != 8) {
                        i13 = i19 == getSelectedItemPosition() ? min : min2;
                        if (i18 > 0) {
                            i13++;
                            i18--;
                        }
                    } else {
                        i13 = 0;
                    }
                    this.tempChildWidths.add(Integer.valueOf(i13));
                    i19++;
                }
            } else {
                int min3 = Math.min(size / (currentVisibleContentItemCount != 0 ? currentVisibleContentItemCount : 1), this.activeItemMaxWidth);
                int i20 = size - (currentVisibleContentItemCount * min3);
                for (int i21 = 0; i21 < childCount; i21++) {
                    if (getChildAt(i21).getVisibility() == 8) {
                        i12 = 0;
                    } else if (i20 > 0) {
                        i12 = min3 + 1;
                        i20--;
                    } else {
                        i12 = min3;
                    }
                    this.tempChildWidths.add(Integer.valueOf(i12));
                }
            }
            i10 = 0;
            i11 = 0;
            while (i14 < childCount) {
                View childAt2 = getChildAt(i14);
                if (childAt2.getVisibility() != 8) {
                    childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths.get(i14).intValue(), BasicMeasure.EXACTLY), makeMeasureSpec);
                    childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                    int measuredWidth = childAt2.getMeasuredWidth() + i10;
                    i11 = Math.max(i11, childAt2.getMeasuredHeight());
                    i10 = measuredWidth;
                }
                i14++;
            }
        } else {
            if (currentVisibleContentItemCount == 0) {
                currentVisibleContentItemCount = 1;
            }
            float f = size;
            float min4 = Math.min((currentVisibleContentItemCount + 3) / 10.0f, 0.9f) * f;
            float f10 = currentVisibleContentItemCount;
            int round = Math.round(min4 / f10);
            int round2 = Math.round(f / f10);
            int i22 = 0;
            int i23 = 0;
            while (i14 < childCount) {
                View childAt3 = getChildAt(i14);
                if (childAt3.getVisibility() != 8) {
                    childAt3.measure(View.MeasureSpec.makeMeasureSpec(round2, Integer.MIN_VALUE), makeMeasureSpec);
                    if (childAt3.getMeasuredWidth() < round) {
                        childAt3.measure(View.MeasureSpec.makeMeasureSpec(round, BasicMeasure.EXACTLY), makeMeasureSpec);
                    }
                    int measuredWidth2 = childAt3.getMeasuredWidth() + i22;
                    i23 = Math.max(i23, childAt3.getMeasuredHeight());
                    i22 = measuredWidth2;
                }
                i14++;
            }
            i10 = i22;
            i11 = i23;
        }
        setMeasuredDimension(i10, Math.max(i11, getSuggestedMinimumHeight()));
    }

    public void setItemHorizontalTranslationEnabled(boolean z9) {
        this.itemHorizontalTranslationEnabled = z9;
    }
}
