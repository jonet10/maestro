package com.google.android.material.navigationrail;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarDividerView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.resources.MaterialResources;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class NavigationRailView extends NavigationBarView {
    static final int COLLAPSED_MAX_ITEM_COUNT = 7;
    private static final TimeInterpolator CUBIC_BEZIER_INTERPOLATOR = new PathInterpolator(0.38f, 1.21f, 0.22f, 1.0f);
    private static final int DEFAULT_HEADER_GRAVITY = 49;
    static final int DEFAULT_MENU_GRAVITY = 49;
    private static final int EXPAND_DURATION = 500;
    private static final int FADE_DURATION = 100;
    static final int NO_ITEM_MINIMUM_HEIGHT = -1;
    private int collapsedIconGravity;
    private int collapsedItemGravity;
    private int collapsedItemMinHeight;
    private int collapsedItemSpacing;
    private NavigationRailFrameLayout contentContainer;
    private final int contentMarginTop;
    private boolean expanded;
    private int expandedIconGravity;
    private int expandedItemGravity;
    private int expandedItemMinHeight;
    private int expandedItemSpacing;
    private final int headerMarginBottom;

    @Nullable
    private View headerView;
    private final int maxExpandedWidth;
    private final int minExpandedWidth;

    @Nullable
    private Boolean paddingBottomSystemWindowInsets;

    @Nullable
    private Boolean paddingStartSystemWindowInsets;

    @Nullable
    private Boolean paddingTopSystemWindowInsets;
    private final boolean scrollingEnabled;
    private boolean submenuDividersEnabled;

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i6) {
        super(context, attributeSet, i, i6);
        this.paddingTopSystemWindowInsets = null;
        this.paddingBottomSystemWindowInsets = null;
        this.paddingStartSystemWindowInsets = null;
        this.expanded = false;
        this.collapsedItemMinHeight = -1;
        this.collapsedIconGravity = 0;
        this.collapsedItemGravity = 49;
        Context context2 = getContext();
        this.expandedItemSpacing = getContext().getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_expanded_item_spacing);
        this.expandedItemGravity = NavigationBarView.ITEM_GRAVITY_START_CENTER;
        this.expandedIconGravity = 1;
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.NavigationRailView, i, i6, new int[0]);
        this.contentMarginTop = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_contentMarginTop, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin));
        this.headerMarginBottom = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_headerMarginBottom, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin));
        this.scrollingEnabled = obtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_scrollingEnabled, false);
        setSubmenuDividersEnabled(obtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_submenuDividersEnabled, false));
        addContentContainer();
        int resourceId = obtainTintedStyledAttributes.getResourceId(R.styleable.NavigationRailView_headerLayout, 0);
        if (resourceId != 0) {
            addHeaderView(resourceId);
        }
        setMenuGravity(obtainTintedStyledAttributes.getInt(R.styleable.NavigationRailView_menuGravity, 49));
        int dimensionPixelSize = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_itemMinHeight, -1);
        int dimensionPixelSize2 = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_itemMinHeight, -1);
        dimensionPixelSize = obtainTintedStyledAttributes.hasValue(R.styleable.NavigationRailView_collapsedItemMinHeight) ? obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_collapsedItemMinHeight, -1) : dimensionPixelSize;
        dimensionPixelSize2 = obtainTintedStyledAttributes.hasValue(R.styleable.NavigationRailView_expandedItemMinHeight) ? obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_expandedItemMinHeight, -1) : dimensionPixelSize2;
        setCollapsedItemMinimumHeight(dimensionPixelSize);
        setExpandedItemMinimumHeight(dimensionPixelSize2);
        this.minExpandedWidth = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_expandedMinWidth, context2.getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_min_expanded_width));
        this.maxExpandedWidth = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_expandedMaxWidth, context2.getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_max_expanded_width));
        if (obtainTintedStyledAttributes.hasValue(R.styleable.NavigationRailView_paddingTopSystemWindowInsets)) {
            this.paddingTopSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_paddingTopSystemWindowInsets, false));
        }
        if (obtainTintedStyledAttributes.hasValue(R.styleable.NavigationRailView_paddingBottomSystemWindowInsets)) {
            this.paddingBottomSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_paddingBottomSystemWindowInsets, false));
        }
        if (obtainTintedStyledAttributes.hasValue(R.styleable.NavigationRailView_paddingStartSystemWindowInsets)) {
            this.paddingStartSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_paddingStartSystemWindowInsets, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_top_with_large_font);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_bottom_with_large_font);
        float lerp = AnimationUtils.lerp(0.0f, 1.0f, 0.3f, 1.0f, MaterialResources.getFontScale(context2) - 1.0f);
        float lerp2 = AnimationUtils.lerp(getItemPaddingTop(), dimensionPixelOffset, lerp);
        float lerp3 = AnimationUtils.lerp(getItemPaddingBottom(), dimensionPixelOffset2, lerp);
        setItemPaddingTop(Math.round(lerp2));
        setItemPaddingBottom(Math.round(lerp3));
        setCollapsedItemSpacing(obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_itemSpacing, 0));
        setExpanded(obtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_expanded, false));
        obtainTintedStyledAttributes.recycle();
        applyWindowInsets();
    }

    private void addContentContainer() {
        View view = (View) getMenuView();
        NavigationRailFrameLayout navigationRailFrameLayout = new NavigationRailFrameLayout(getContext());
        this.contentContainer = navigationRailFrameLayout;
        navigationRailFrameLayout.setPaddingTop(this.contentMarginTop);
        this.contentContainer.setScrollingEnabled(this.scrollingEnabled);
        this.contentContainer.setClipChildren(false);
        this.contentContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.contentContainer.addView(view);
        if (!this.scrollingEnabled) {
            addView(this.contentContainer);
            return;
        }
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.addView(this.contentContainer);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(scrollView);
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.navigationrail.NavigationRailView.1
            @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
            @NonNull
            public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
                Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
                Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.displayCutout());
                NavigationRailView navigationRailView = NavigationRailView.this;
                if (navigationRailView.shouldApplyWindowInsetPadding(navigationRailView.paddingTopSystemWindowInsets)) {
                    relativePadding.top += insets.top;
                }
                NavigationRailView navigationRailView2 = NavigationRailView.this;
                if (navigationRailView2.shouldApplyWindowInsetPadding(navigationRailView2.paddingBottomSystemWindowInsets)) {
                    relativePadding.bottom += insets.bottom;
                }
                NavigationRailView navigationRailView3 = NavigationRailView.this;
                if (navigationRailView3.shouldApplyWindowInsetPadding(navigationRailView3.paddingStartSystemWindowInsets)) {
                    if (ViewUtils.isLayoutRtl(view)) {
                        relativePadding.start = Math.max(insets.right, insets2.right) + relativePadding.start;
                    } else {
                        relativePadding.start = Math.max(insets.left, insets2.left) + relativePadding.start;
                    }
                }
                relativePadding.applyToView(view);
                return windowInsetsCompat;
            }
        });
    }

    private int getMaxChildWidth() {
        int childCount = getNavigationRailMenuView().getChildCount();
        int i = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getNavigationRailMenuView().getChildAt(i6);
            if (childAt.getVisibility() != 8 && !(childAt instanceof NavigationBarDividerView)) {
                i = Math.max(i, childAt.getMeasuredWidth());
            }
        }
        return i;
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private int makeExpandedWidthMeasureSpec(int i, int i6) {
        int min = Math.min(this.minExpandedWidth, View.MeasureSpec.getSize(i));
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return i;
        }
        int max = Math.max(i6, min);
        View view = this.headerView;
        if (view != null) {
            max = Math.max(max, view.getMeasuredWidth());
        }
        return View.MeasureSpec.makeMeasureSpec(Math.max(getSuggestedMinimumWidth(), Math.min(max, this.maxExpandedWidth)), BasicMeasure.EXACTLY);
    }

    private int makeMinWidthSpec(int i) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), getPaddingRight() + getPaddingLeft() + suggestedMinimumWidth), BasicMeasure.EXACTLY);
    }

    private void setExpanded(boolean z9) {
        if (this.expanded == z9) {
            return;
        }
        startTransitionAnimation();
        this.expanded = z9;
        int i = this.collapsedIconGravity;
        int i6 = this.collapsedItemSpacing;
        int i10 = this.collapsedItemMinHeight;
        int i11 = this.collapsedItemGravity;
        if (z9) {
            i = this.expandedIconGravity;
            i6 = this.expandedItemSpacing;
            i10 = this.expandedItemMinHeight;
            i11 = this.expandedItemGravity;
        }
        getNavigationRailMenuView().setItemGravity(i11);
        super.setItemIconGravity(i);
        getNavigationRailMenuView().setItemSpacing(i6);
        getNavigationRailMenuView().setItemMinimumHeight(i10);
        getNavigationRailMenuView().setExpanded(z9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldApplyWindowInsetPadding(Boolean bool) {
        return bool != null ? bool.booleanValue() : getFitsSystemWindows();
    }

    private void startTransitionAnimation() {
        if (isLaidOut()) {
            Transition interpolator = new ChangeBounds().setDuration(500L).setInterpolator(CUBIC_BEZIER_INTERPOLATOR);
            Transition duration = new Fade().setDuration(100L);
            Transition duration2 = new Fade().setDuration(100L);
            LabelMoveTransition labelMoveTransition = new LabelMoveTransition();
            Transition duration3 = new Fade().setDuration(100L);
            int childCount = getNavigationRailMenuView().getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getNavigationRailMenuView().getChildAt(i);
                if (childAt instanceof NavigationBarItemView) {
                    NavigationBarItemView navigationBarItemView = (NavigationBarItemView) childAt;
                    interpolator.excludeTarget((View) navigationBarItemView.getLabelGroup(), true);
                    interpolator.excludeTarget((View) navigationBarItemView.getExpandedLabelGroup(), true);
                    if (this.expanded) {
                        duration2.addTarget(navigationBarItemView.getExpandedLabelGroup());
                        duration.addTarget(navigationBarItemView.getLabelGroup());
                    } else {
                        duration2.addTarget(navigationBarItemView.getLabelGroup());
                        duration.addTarget(navigationBarItemView.getExpandedLabelGroup());
                    }
                    labelMoveTransition.addTarget(navigationBarItemView.getExpandedLabelGroup());
                }
                duration3.addTarget(childAt);
            }
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.setOrdering(0);
            transitionSet.addTransition(interpolator).addTransition(duration).addTransition(labelMoveTransition);
            if (!this.expanded) {
                transitionSet.addTransition(duration3);
            }
            TransitionSet transitionSet2 = new TransitionSet();
            transitionSet2.setOrdering(0);
            transitionSet2.addTransition(duration2);
            if (this.expanded) {
                transitionSet2.addTransition(duration3);
            }
            TransitionSet transitionSet3 = new TransitionSet();
            transitionSet3.setOrdering(1);
            transitionSet3.addTransition(transitionSet2).addTransition(transitionSet);
            TransitionManager.beginDelayedTransition((ViewGroup) getParent(), transitionSet3);
        }
    }

    public void addHeaderView(@NonNull View view) {
        removeHeaderView();
        this.headerView = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.bottomMargin = this.headerMarginBottom;
        this.contentContainer.addView(view, 0, layoutParams);
    }

    public void collapse() {
        if (this.expanded) {
            setExpanded(false);
            announceForAccessibility(getResources().getString(R.string.nav_rail_collapsed_a11y_label));
        }
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationRailMenuView createNavigationBarMenuView(@NonNull Context context) {
        return new NavigationRailMenuView(context);
    }

    public void expand() {
        if (this.expanded) {
            return;
        }
        setExpanded(true);
        announceForAccessibility(getResources().getString(R.string.nav_rail_expanded_a11y_label));
    }

    public int getCollapsedItemMinimumHeight() {
        return this.collapsedItemMinHeight;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getCollapsedMaxItemCount() {
        return 7;
    }

    public int getExpandedItemMinimumHeight() {
        return this.expandedItemMinHeight;
    }

    @Nullable
    public View getHeaderView() {
        return this.headerView;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getItemGravity() {
        return getNavigationRailMenuView().getItemGravity();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getItemIconGravity() {
        return getNavigationRailMenuView().getItemIconGravity();
    }

    public int getItemMinimumHeight() {
        return getNavigationRailMenuView().getItemMinimumHeight();
    }

    public int getItemSpacing() {
        return getNavigationRailMenuView().getItemSpacing();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return Integer.MAX_VALUE;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public boolean getSubmenuDividersEnabled() {
        return this.submenuDividersEnabled;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public boolean isSubMenuSupported() {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i6) {
        int makeMinWidthSpec = makeMinWidthSpec(i);
        if (this.expanded) {
            measureChild(getNavigationRailMenuView(), i, i6);
            View view = this.headerView;
            if (view != null) {
                measureChild(view, i, i6);
            }
            makeMinWidthSpec = makeExpandedWidthMeasureSpec(i, getMaxChildWidth());
            if (getItemActiveIndicatorExpandedWidth() == -1) {
                getNavigationRailMenuView().updateActiveIndicator(View.MeasureSpec.getSize(makeMinWidthSpec));
            }
        }
        super.onMeasure(makeMinWidthSpec, i6);
        if (this.contentContainer.getMeasuredHeight() < getMeasuredHeight()) {
            measureChild(this.contentContainer, makeMinWidthSpec, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), BasicMeasure.EXACTLY));
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void removeHeaderView() {
        View view = this.headerView;
        if (view != null) {
            this.contentContainer.removeView(view);
            this.headerView = null;
        }
    }

    public void setCollapsedItemMinimumHeight(@Px int i) {
        this.collapsedItemMinHeight = i;
        if (this.expanded) {
            return;
        }
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i);
    }

    public void setCollapsedItemSpacing(@Px int i) {
        this.collapsedItemSpacing = i;
        if (this.expanded) {
            return;
        }
        getNavigationRailMenuView().setItemSpacing(i);
    }

    public void setExpandedItemMinimumHeight(@Px int i) {
        this.expandedItemMinHeight = i;
        if (this.expanded) {
            ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i);
        }
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public void setItemGravity(int i) {
        this.collapsedItemGravity = i;
        this.expandedItemGravity = i;
        super.setItemGravity(i);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public void setItemIconGravity(int i) {
        this.collapsedIconGravity = i;
        this.expandedIconGravity = i;
        super.setItemIconGravity(i);
    }

    public void setItemMinimumHeight(@Px int i) {
        this.collapsedItemMinHeight = i;
        this.expandedItemMinHeight = i;
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i);
    }

    public void setItemSpacing(@Px int i) {
        this.collapsedItemSpacing = i;
        this.expandedItemSpacing = i;
        getNavigationRailMenuView().setItemSpacing(i);
    }

    public void setMenuGravity(int i) {
        getNavigationRailMenuView().setMenuGravity(i);
    }

    public void setSubmenuDividersEnabled(boolean z9) {
        if (this.submenuDividersEnabled == z9) {
            return;
        }
        this.submenuDividersEnabled = z9;
        getNavigationRailMenuView().setSubmenuDividersEnabled(z9);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean shouldAddMenuView() {
        return true;
    }

    public void addHeaderView(@LayoutRes int i) {
        addHeaderView(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this, false));
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(@NonNull Context context) {
        this(context, null);
    }
}
