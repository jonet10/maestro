package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    private static final int COLLAPSED_TITLE_GRAVITY_AVAILABLE_SPACE = 1;
    private static final int COLLAPSED_TITLE_GRAVITY_ENTIRE_SPACE = 0;
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_CollapsingToolbar;
    public static final int TITLE_COLLAPSE_MODE_FADE = 1;
    public static final int TITLE_COLLAPSE_MODE_SCALE = 0;
    private final int collapsedTitleGravityMode;

    @NonNull
    final CollapsingTextHelper collapsingSubtitleHelper;
    private boolean collapsingTitleEnabled;

    @NonNull
    final CollapsingTextHelper collapsingTitleHelper;

    @Nullable
    private Drawable contentScrim;
    int currentOffset;
    private boolean drawCollapsingTitle;
    private View dummyView;

    @NonNull
    final ElevationOverlayProvider elevationOverlayProvider;
    private int expandedMarginBottom;
    private int expandedMarginEnd;
    private int expandedMarginStart;
    private int expandedMarginTop;
    private int expandedTitleSpacing;
    private int extraHeightForTitles;
    private boolean extraMultilineHeightEnabled;
    private int extraMultilineSubtitleHeight;
    private int extraMultilineTitleHeight;
    private boolean forceApplySystemWindowInsetTop;

    @Nullable
    WindowInsetsCompat lastInsets;
    private AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
    private boolean refreshToolbar;
    private int screenOrientation;
    private int scrimAlpha;
    private long scrimAnimationDuration;
    private final TimeInterpolator scrimAnimationFadeInInterpolator;
    private final TimeInterpolator scrimAnimationFadeOutInterpolator;
    private ValueAnimator scrimAnimator;
    private int scrimVisibleHeightTrigger;
    private boolean scrimsAreShown;

    @Nullable
    Drawable statusBarScrim;
    private int titleCollapseMode;
    private final Rect tmpRect;

    @Nullable
    private ViewGroup toolbar;

    @Nullable
    private View toolbarDirectChild;
    private int toolbarId;
    private int topInsetApplied;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface CollapsedTitleGravityMode {
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        public OffsetUpdateListener() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            CollapsingToolbarLayout collapsingToolbarLayout;
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout2.currentOffset = i;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout2.lastInsets;
            int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            int i6 = 0;
            while (true) {
                collapsingToolbarLayout = CollapsingToolbarLayout.this;
                if (i6 >= childCount) {
                    break;
                }
                View childAt = collapsingToolbarLayout.getChildAt(i6);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(childAt);
                int i10 = layoutParams.collapseMode;
                if (i10 == 1) {
                    viewOffsetHelper.setTopAndBottomOffset(MathUtils.clamp(-i, 0, CollapsingToolbarLayout.this.getMaxOffsetForPinChild(childAt)));
                } else if (i10 == 2) {
                    viewOffsetHelper.setTopAndBottomOffset(Math.round((-i) * layoutParams.parallaxMult));
                }
                i6++;
            }
            collapsingToolbarLayout.updateScrimVisibility();
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout3.statusBarScrim != null && systemWindowInsetTop > 0) {
                collapsingToolbarLayout3.postInvalidateOnAnimation();
            }
            int height = CollapsingToolbarLayout.this.getHeight();
            int minimumHeight = (height - CollapsingToolbarLayout.this.getMinimumHeight()) - systemWindowInsetTop;
            int scrimVisibleHeightTrigger = height - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger();
            int i11 = CollapsingToolbarLayout.this.currentOffset + minimumHeight;
            float f = minimumHeight;
            float abs = Math.abs(i) / f;
            float f10 = scrimVisibleHeightTrigger / f;
            CollapsingToolbarLayout.this.collapsingTitleHelper.setFadeModeStartFraction(Math.min(1.0f, f10));
            CollapsingToolbarLayout.this.collapsingTitleHelper.setCurrentOffsetY(i11);
            CollapsingToolbarLayout.this.collapsingTitleHelper.setExpansionFraction(abs);
            CollapsingToolbarLayout.this.collapsingSubtitleHelper.setFadeModeStartFraction(Math.min(1.0f, f10));
            CollapsingToolbarLayout.this.collapsingSubtitleHelper.setCurrentOffsetY(i11);
            CollapsingToolbarLayout.this.collapsingSubtitleHelper.setExpansionFraction(abs);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface StaticLayoutBuilderConfigurer extends com.google.android.material.internal.StaticLayoutBuilderConfigurer {
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TitleCollapseMode {
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public CollapsingToolbarLayout(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            Method dump skipped, instructions count: 634
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void animateScrim(int i) {
        ensureToolbar();
        ValueAnimator valueAnimator = this.scrimAnimator;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.scrimAnimator = valueAnimator2;
            valueAnimator2.setInterpolator(i > this.scrimAlpha ? this.scrimAnimationFadeInInterpolator : this.scrimAnimationFadeOutInterpolator);
            this.scrimAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.appbar.CollapsingToolbarLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator3) {
                    CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator3.getAnimatedValue()).intValue());
                }
            });
        } else if (valueAnimator.isRunning()) {
            this.scrimAnimator.cancel();
        }
        this.scrimAnimator.setDuration(this.scrimAnimationDuration);
        this.scrimAnimator.setIntValues(this.scrimAlpha, i);
        this.scrimAnimator.start();
    }

    private TextUtils.TruncateAt convertEllipsizeToTruncateAt(int i) {
        return i != 0 ? i != 1 ? i != 3 ? TextUtils.TruncateAt.END : TextUtils.TruncateAt.MARQUEE : TextUtils.TruncateAt.MIDDLE : TextUtils.TruncateAt.START;
    }

    private void disableLiftOnScrollIfNeeded(AppBarLayout appBarLayout) {
        if (isTitleCollapseFadeMode()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    private void ensureToolbar() {
        if (this.refreshToolbar) {
            ViewGroup viewGroup = null;
            this.toolbar = null;
            this.toolbarDirectChild = null;
            int i = this.toolbarId;
            if (i != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i);
                this.toolbar = viewGroup2;
                if (viewGroup2 != null) {
                    this.toolbarDirectChild = findDirectChild(viewGroup2);
                }
            }
            if (this.toolbar == null) {
                int childCount = getChildCount();
                int i6 = 0;
                while (true) {
                    if (i6 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i6);
                    if (isToolbar(childAt)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                    i6++;
                }
                this.toolbar = viewGroup;
            }
            updateDummyView();
            this.refreshToolbar = false;
        }
    }

    @NonNull
    private View findDirectChild(@NonNull View view) {
        for (ViewParent parent = view.getParent(); parent != this && parent != null; parent = parent.getParent()) {
            if (parent instanceof View) {
                view = parent;
            }
        }
        return view;
    }

    @ColorInt
    private int getDefaultContentScrimColorForTitleCollapseFadeMode() {
        ColorStateList colorStateListOrNull = MaterialColors.getColorStateListOrNull(getContext(), R.attr.colorSurfaceContainer);
        if (colorStateListOrNull != null) {
            return colorStateListOrNull.getDefaultColor();
        }
        return this.elevationOverlayProvider.compositeOverlayWithThemeSurfaceColorIfNeeded(getResources().getDimension(R.dimen.design_appbar_elevation));
    }

    private static int getHeightWithMargins(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    @Nullable
    private static CharSequence getToolbarSubtitle(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getSubtitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getSubtitle();
        }
        return null;
    }

    @Nullable
    private static CharSequence getToolbarTitle(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    @NonNull
    public static ViewOffsetHelper getViewOffsetHelper(@NonNull View view) {
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(R.id.view_offset_helper);
        if (viewOffsetHelper != null) {
            return viewOffsetHelper;
        }
        ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view);
        view.setTag(R.id.view_offset_helper, viewOffsetHelper2);
        return viewOffsetHelper2;
    }

    private boolean isTitleCollapseFadeMode() {
        return this.titleCollapseMode == 1;
    }

    private static boolean isToolbar(View view) {
        return (view instanceof Toolbar) || (view instanceof android.widget.Toolbar);
    }

    private boolean isToolbarChild(View view) {
        View view2 = this.toolbarDirectChild;
        return (view2 == null || view2 == this) ? view == this.toolbar : view == view2;
    }

    private void updateCollapsedBounds(boolean z9) {
        int i;
        int i6;
        int i10;
        int i11;
        View view = this.toolbarDirectChild;
        if (view == null) {
            view = this.toolbar;
        }
        int maxOffsetForPinChild = getMaxOffsetForPinChild(view);
        DescendantOffsetUtils.getDescendantRect(this, this.dummyView, this.tmpRect);
        ViewGroup viewGroup = this.toolbar;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            i = toolbar.getTitleMarginStart();
            i10 = toolbar.getTitleMarginEnd();
            i11 = toolbar.getTitleMarginTop();
            i6 = toolbar.getTitleMarginBottom();
        } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
            i = 0;
            i6 = 0;
            i10 = 0;
            i11 = 0;
        } else {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            i = toolbar2.getTitleMarginStart();
            i10 = toolbar2.getTitleMarginEnd();
            i11 = toolbar2.getTitleMarginTop();
            i6 = toolbar2.getTitleMarginBottom();
        }
        Rect rect = this.tmpRect;
        int i12 = rect.left + (z9 ? i10 : i);
        int i13 = rect.right - (z9 ? i : i10);
        int i14 = rect.top + maxOffsetForPinChild + i11;
        int i15 = (rect.bottom + maxOffsetForPinChild) - i6;
        int collapsedFullSingleLineHeight = (int) (i15 - this.collapsingSubtitleHelper.getCollapsedFullSingleLineHeight());
        int collapsedFullSingleLineHeight2 = (int) (this.collapsingTitleHelper.getCollapsedFullSingleLineHeight() + i14);
        boolean isEmpty = TextUtils.isEmpty(this.collapsingSubtitleHelper.getText());
        CollapsingTextHelper collapsingTextHelper = this.collapsingTitleHelper;
        if (isEmpty) {
            collapsingTextHelper.setCollapsedBounds(i12, i14, i13, i15);
        } else {
            collapsingTextHelper.setCollapsedBounds(i12, i14, i13, collapsedFullSingleLineHeight);
            this.collapsingSubtitleHelper.setCollapsedBounds(i12, collapsedFullSingleLineHeight2, i13, i15);
        }
        if (this.collapsedTitleGravityMode == 0) {
            DescendantOffsetUtils.getDescendantRect(this, this, this.tmpRect);
            Rect rect2 = this.tmpRect;
            int i16 = rect2.left + (z9 ? i10 : i);
            int i17 = rect2.right;
            if (!z9) {
                i = i10;
            }
            int i18 = i17 - i;
            boolean isEmpty2 = TextUtils.isEmpty(this.collapsingSubtitleHelper.getText());
            CollapsingTextHelper collapsingTextHelper2 = this.collapsingTitleHelper;
            if (isEmpty2) {
                collapsingTextHelper2.setCollapsedBoundsForOffsets(i16, i14, i18, i15);
            } else {
                collapsingTextHelper2.setCollapsedBoundsForOffsets(i16, i14, i18, collapsedFullSingleLineHeight);
                this.collapsingSubtitleHelper.setCollapsedBoundsForOffsets(i16, collapsedFullSingleLineHeight2, i18, i15);
            }
        }
    }

    private void updateContentDescriptionFromTitle() {
        setContentDescription(getTitle());
    }

    private void updateContentScrimBounds(@NonNull Drawable drawable, @Nullable View view, int i, int i6) {
        if (isTitleCollapseFadeMode() && view != null && this.collapsingTitleEnabled) {
            i6 = view.getBottom();
        }
        drawable.setBounds(0, 0, i, i6);
    }

    private void updateDummyView() {
        View view;
        if (!this.collapsingTitleEnabled && (view = this.dummyView) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.dummyView);
            }
        }
        if (!this.collapsingTitleEnabled || this.toolbar == null) {
            return;
        }
        if (this.dummyView == null) {
            this.dummyView = new View(getContext());
        }
        if (this.dummyView.getParent() == null) {
            this.toolbar.addView(this.dummyView, -1, -1);
        }
    }

    private void updateTextBounds(int i, int i6, int i10, int i11, boolean z9) {
        View view;
        if (!this.collapsingTitleEnabled || (view = this.dummyView) == null) {
            return;
        }
        boolean z10 = view.isAttachedToWindow() && this.dummyView.getVisibility() == 0;
        this.drawCollapsingTitle = z10;
        if (z10 || z9) {
            boolean z11 = getLayoutDirection() == 1;
            updateCollapsedBounds(z11);
            int i12 = z11 ? this.expandedMarginEnd : this.expandedMarginStart;
            int i13 = this.tmpRect.top + this.expandedMarginTop;
            int i14 = (i10 - i) - (z11 ? this.expandedMarginStart : this.expandedMarginEnd);
            int i15 = (i11 - i6) - this.expandedMarginBottom;
            boolean isEmpty = TextUtils.isEmpty(this.collapsingSubtitleHelper.getText());
            CollapsingTextHelper collapsingTextHelper = this.collapsingTitleHelper;
            if (isEmpty) {
                collapsingTextHelper.setExpandedBounds(i12, i13, i14, i15);
                this.collapsingTitleHelper.recalculate(z9);
            } else {
                collapsingTextHelper.setExpandedBounds(i12, i13, i14, (int) ((i15 - (this.collapsingSubtitleHelper.getExpandedTextFullSingleLineHeight() + this.extraMultilineSubtitleHeight)) - this.expandedTitleSpacing), false);
                this.collapsingSubtitleHelper.setExpandedBounds(i12, (int) (this.collapsingTitleHelper.getExpandedTextFullSingleLineHeight() + this.extraMultilineTitleHeight + i13 + this.expandedTitleSpacing), i14, i15, false);
                this.collapsingTitleHelper.recalculate(z9);
                this.collapsingSubtitleHelper.recalculate(z9);
            }
        }
    }

    private void updateTitleFromToolbarIfNeeded() {
        ViewGroup viewGroup = this.toolbar;
        if (viewGroup == null || !this.collapsingTitleEnabled) {
            return;
        }
        CharSequence toolbarTitle = getToolbarTitle(viewGroup);
        if (TextUtils.isEmpty(this.collapsingTitleHelper.getText()) && !TextUtils.isEmpty(toolbarTitle)) {
            setTitle(toolbarTitle);
        }
        CharSequence toolbarSubtitle = getToolbarSubtitle(this.toolbar);
        if (!TextUtils.isEmpty(this.collapsingSubtitleHelper.getText()) || TextUtils.isEmpty(toolbarSubtitle)) {
            return;
        }
        setSubtitle(toolbarSubtitle);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        ensureToolbar();
        if (this.toolbar == null && (drawable = this.contentScrim) != null && this.scrimAlpha > 0) {
            drawable.mutate().setAlpha(this.scrimAlpha);
            this.contentScrim.draw(canvas);
        }
        if (this.collapsingTitleEnabled && this.drawCollapsingTitle) {
            if (this.toolbar == null || this.contentScrim == null || this.scrimAlpha <= 0 || !isTitleCollapseFadeMode() || this.collapsingTitleHelper.getExpansionFraction() >= this.collapsingTitleHelper.getFadeModeThresholdFraction()) {
                this.collapsingTitleHelper.draw(canvas);
                this.collapsingSubtitleHelper.draw(canvas);
            } else {
                int save = canvas.save();
                canvas.clipRect(this.contentScrim.getBounds(), Region.Op.DIFFERENCE);
                this.collapsingTitleHelper.draw(canvas);
                this.collapsingSubtitleHelper.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        if (this.statusBarScrim == null || this.scrimAlpha <= 0) {
            return;
        }
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.statusBarScrim.setBounds(0, -this.currentOffset, getWidth(), systemWindowInsetTop - this.currentOffset);
            this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
            this.statusBarScrim.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z9;
        if (this.contentScrim == null || this.scrimAlpha <= 0 || !isToolbarChild(view)) {
            z9 = false;
        } else {
            updateContentScrimBounds(this.contentScrim, view, getWidth(), getHeight());
            this.contentScrim.mutate().setAlpha(this.scrimAlpha);
            this.contentScrim.draw(canvas);
            z9 = true;
        }
        return super.drawChild(canvas, view, j) || z9;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.statusBarScrim;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        CollapsingTextHelper collapsingTextHelper = this.collapsingTitleHelper;
        if (collapsingTextHelper != null) {
            state |= collapsingTextHelper.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public float getCollapsedSubtitleTextSize() {
        return this.collapsingSubtitleHelper.getCollapsedTextSize();
    }

    @NonNull
    public Typeface getCollapsedSubtitleTypeface() {
        return this.collapsingSubtitleHelper.getCollapsedTypeface();
    }

    public int getCollapsedTitleGravity() {
        return this.collapsingTitleHelper.getCollapsedTextGravity();
    }

    public float getCollapsedTitleTextSize() {
        return this.collapsingTitleHelper.getCollapsedTextSize();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.collapsingTitleHelper.getCollapsedTypeface();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.contentScrim;
    }

    public float getExpandedSubtitleTextSize() {
        return this.collapsingSubtitleHelper.getExpandedTextSize();
    }

    @NonNull
    public Typeface getExpandedSubtitleTypeface() {
        return this.collapsingSubtitleHelper.getExpandedTypeface();
    }

    public int getExpandedTitleGravity() {
        return this.collapsingTitleHelper.getExpandedTextGravity();
    }

    public int getExpandedTitleMarginBottom() {
        return this.expandedMarginBottom;
    }

    public int getExpandedTitleMarginEnd() {
        return this.expandedMarginEnd;
    }

    public int getExpandedTitleMarginStart() {
        return this.expandedMarginStart;
    }

    public int getExpandedTitleMarginTop() {
        return this.expandedMarginTop;
    }

    public int getExpandedTitleSpacing() {
        return this.expandedTitleSpacing;
    }

    public float getExpandedTitleTextSize() {
        return this.collapsingTitleHelper.getExpandedTextSize();
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.collapsingTitleHelper.getExpandedTypeface();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getHyphenationFrequency() {
        return this.collapsingTitleHelper.getHyphenationFrequency();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLineCount() {
        return this.collapsingTitleHelper.getLineCount();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingAdd() {
        return this.collapsingTitleHelper.getLineSpacingAdd();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingMultiplier() {
        return this.collapsingTitleHelper.getLineSpacingMultiplier();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.collapsingTitleHelper.getExpandedMaxLines();
    }

    public final int getMaxOffsetForPinChild(@NonNull View view) {
        return ((getHeight() - getViewOffsetHelper(view).getLayoutTop()) - view.getHeight()) - ((FrameLayout.LayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    public int getScrimAlpha() {
        return this.scrimAlpha;
    }

    public long getScrimAnimationDuration() {
        return this.scrimAnimationDuration;
    }

    public int getScrimVisibleHeightTrigger() {
        int i = this.scrimVisibleHeightTrigger;
        if (i >= 0) {
            return i + this.topInsetApplied + this.extraMultilineTitleHeight + this.extraMultilineSubtitleHeight + this.extraHeightForTitles;
        }
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int minimumHeight = getMinimumHeight();
        return minimumHeight > 0 ? Math.min((minimumHeight * 2) + systemWindowInsetTop, getHeight()) : getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.statusBarScrim;
    }

    @Nullable
    public CharSequence getSubtitle() {
        if (this.collapsingTitleEnabled) {
            return this.collapsingSubtitleHelper.getText();
        }
        return null;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.collapsingTitleEnabled) {
            return this.collapsingTitleHelper.getText();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.titleCollapseMode;
    }

    @Nullable
    public TimeInterpolator getTitlePositionInterpolator() {
        return this.collapsingTitleHelper.getPositionInterpolator();
    }

    @NonNull
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.collapsingTitleHelper.getTitleTextEllipsize();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isExtraMultilineHeightEnabled() {
        return this.extraMultilineHeightEnabled;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isForceApplySystemWindowInsetTop() {
        return this.forceApplySystemWindowInsetTop;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.collapsingTitleHelper.isRtlTextDirectionHeuristicsEnabled();
    }

    public boolean isTitleEnabled() {
        return this.collapsingTitleEnabled;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            disableLiftOnScrollIfNeeded(appBarLayout);
            setFitsSystemWindows(appBarLayout.getFitsSystemWindows());
            if (this.onOffsetChangedListener == null) {
                this.onOffsetChangedListener = new OffsetUpdateListener();
            }
            appBarLayout.addOnOffsetChangedListener(this.onOffsetChangedListener);
            requestApplyInsets();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.collapsingTitleHelper.maybeUpdateFontWeightAdjustment(configuration);
        if (this.screenOrientation != configuration.orientation && this.extraMultilineHeightEnabled && this.collapsingTitleHelper.getExpansionFraction() == 1.0f) {
            ViewParent parent = getParent();
            if (parent instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) parent;
                if (appBarLayout.getPendingAction() == 0) {
                    appBarLayout.setPendingAction(2);
                }
            }
        }
        this.screenOrientation = configuration.orientation;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.onOffsetChangedListener;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z9, int i, int i6, int i10, int i11) {
        super.onLayout(z9, i, i6, i10, i11);
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        if (windowInsetsCompat != null) {
            int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            int childCount = getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (!childAt.getFitsSystemWindows() && childAt.getTop() < systemWindowInsetTop) {
                    ViewCompat.offsetTopAndBottom(childAt, systemWindowInsetTop);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i13 = 0; i13 < childCount2; i13++) {
            getViewOffsetHelper(getChildAt(i13)).onViewLayout();
        }
        updateTextBounds(i, i6, i10, i11, false);
        updateTitleFromToolbarIfNeeded();
        updateScrimVisibility();
        int childCount3 = getChildCount();
        for (int i14 = 0; i14 < childCount3; i14++) {
            getViewOffsetHelper(getChildAt(i14)).applyOffsets();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i6) {
        CollapsingToolbarLayout collapsingToolbarLayout;
        ensureToolbar();
        super.onMeasure(i, i6);
        int mode = View.MeasureSpec.getMode(i6);
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        int systemWindowInsetTop = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if ((mode == 0 || this.forceApplySystemWindowInsetTop) && systemWindowInsetTop > 0) {
            this.topInsetApplied = systemWindowInsetTop;
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + systemWindowInsetTop, BasicMeasure.EXACTLY));
        }
        updateTitleFromToolbarIfNeeded();
        if (!this.collapsingTitleEnabled || TextUtils.isEmpty(this.collapsingTitleHelper.getText())) {
            collapsingToolbarLayout = this;
        } else {
            int measuredHeight = getMeasuredHeight();
            collapsingToolbarLayout = this;
            collapsingToolbarLayout.updateTextBounds(0, 0, getMeasuredWidth(), measuredHeight, true);
            int expandedTextFullSingleLineHeight = (int) (collapsingToolbarLayout.collapsingTitleHelper.getExpandedTextFullSingleLineHeight() + collapsingToolbarLayout.topInsetApplied + collapsingToolbarLayout.expandedMarginTop + (TextUtils.isEmpty(collapsingToolbarLayout.collapsingSubtitleHelper.getText()) ? 0.0f : collapsingToolbarLayout.expandedTitleSpacing + collapsingToolbarLayout.collapsingSubtitleHelper.getExpandedTextFullSingleLineHeight()) + collapsingToolbarLayout.expandedMarginBottom);
            if (expandedTextFullSingleLineHeight > measuredHeight) {
                collapsingToolbarLayout.extraHeightForTitles = expandedTextFullSingleLineHeight - measuredHeight;
            } else {
                collapsingToolbarLayout.extraHeightForTitles = 0;
            }
            if (collapsingToolbarLayout.extraMultilineHeightEnabled) {
                if (collapsingToolbarLayout.collapsingTitleHelper.getExpandedMaxLines() > 1) {
                    int expandedLineCount = collapsingToolbarLayout.collapsingTitleHelper.getExpandedLineCount();
                    if (expandedLineCount > 1) {
                        collapsingToolbarLayout.extraMultilineTitleHeight = (expandedLineCount - 1) * Math.round(collapsingToolbarLayout.collapsingTitleHelper.getExpandedTextFullSingleLineHeight());
                    } else {
                        collapsingToolbarLayout.extraMultilineTitleHeight = 0;
                    }
                }
                if (collapsingToolbarLayout.collapsingSubtitleHelper.getExpandedMaxLines() > 1) {
                    int expandedLineCount2 = collapsingToolbarLayout.collapsingSubtitleHelper.getExpandedLineCount();
                    if (expandedLineCount2 > 1) {
                        collapsingToolbarLayout.extraMultilineSubtitleHeight = (expandedLineCount2 - 1) * Math.round(collapsingToolbarLayout.collapsingSubtitleHelper.getExpandedTextFullSingleLineHeight());
                    } else {
                        collapsingToolbarLayout.extraMultilineSubtitleHeight = 0;
                    }
                }
            }
            int i10 = collapsingToolbarLayout.extraHeightForTitles;
            int i11 = collapsingToolbarLayout.extraMultilineTitleHeight;
            int i12 = collapsingToolbarLayout.extraMultilineSubtitleHeight;
            if (i10 + i11 + i12 > 0) {
                super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(measuredHeight + i10 + i11 + i12, BasicMeasure.EXACTLY));
            }
        }
        ViewGroup viewGroup = collapsingToolbarLayout.toolbar;
        if (viewGroup != null) {
            View view = collapsingToolbarLayout.toolbarDirectChild;
            if (view == null || view == collapsingToolbarLayout) {
                setMinimumHeight(getHeightWithMargins(viewGroup));
            } else {
                setMinimumHeight(getHeightWithMargins(view));
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        Drawable drawable = this.contentScrim;
        if (drawable != null) {
            updateContentScrimBounds(drawable, i, i6);
        }
    }

    public WindowInsetsCompat onWindowInsetChanged(@NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = getFitsSystemWindows() ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.lastInsets, windowInsetsCompat2)) {
            this.lastInsets = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    public void setCollapsedSubtitleTextAppearance(@StyleRes int i) {
        this.collapsingSubtitleHelper.setCollapsedTextAppearance(i);
    }

    public void setCollapsedSubtitleTextColor(@ColorInt int i) {
        setCollapsedSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedSubtitleTextSize(float f) {
        this.collapsingSubtitleHelper.setCollapsedTextSize(f);
    }

    public void setCollapsedSubtitleTypeface(@Nullable Typeface typeface) {
        this.collapsingSubtitleHelper.setCollapsedTypeface(typeface);
    }

    public void setCollapsedTitleGravity(int i) {
        this.collapsingTitleHelper.setCollapsedTextGravity(i);
        this.collapsingSubtitleHelper.setCollapsedTextGravity(i);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i) {
        this.collapsingTitleHelper.setCollapsedTextAppearance(i);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setCollapsedTitleTextSize(float f) {
        this.collapsingTitleHelper.setCollapsedTextSize(f);
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.collapsingTitleHelper.setCollapsedTypeface(typeface);
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.contentScrim;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.contentScrim = mutate;
            if (mutate != null) {
                updateContentScrimBounds(mutate, getWidth(), getHeight());
                this.contentScrim.setCallback(this);
                this.contentScrim.setAlpha(this.scrimAlpha);
            }
            postInvalidateOnAnimation();
        }
    }

    public void setContentScrimColor(@ColorInt int i) {
        setContentScrim(new ColorDrawable(i));
    }

    public void setContentScrimResource(@DrawableRes int i) {
        setContentScrim(getContext().getDrawable(i));
    }

    public void setExpandedSubtitleColor(@ColorInt int i) {
        setExpandedSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedSubtitleTextAppearance(@StyleRes int i) {
        this.collapsingSubtitleHelper.setExpandedTextAppearance(i);
    }

    public void setExpandedSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.collapsingSubtitleHelper.setExpandedTextColor(colorStateList);
    }

    public void setExpandedSubtitleTextSize(float f) {
        this.collapsingSubtitleHelper.setExpandedTextSize(f);
    }

    public void setExpandedSubtitleTypeface(@Nullable Typeface typeface) {
        this.collapsingSubtitleHelper.setExpandedTypeface(typeface);
    }

    public void setExpandedTitleColor(@ColorInt int i) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i));
    }

    public void setExpandedTitleGravity(int i) {
        this.collapsingTitleHelper.setExpandedTextGravity(i);
        this.collapsingSubtitleHelper.setExpandedTextGravity(i);
    }

    public void setExpandedTitleMargin(int i, int i6, int i10, int i11) {
        this.expandedMarginStart = i;
        this.expandedMarginTop = i6;
        this.expandedMarginEnd = i10;
        this.expandedMarginBottom = i11;
        requestLayout();
    }

    public void setExpandedTitleMarginBottom(int i) {
        this.expandedMarginBottom = i;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i) {
        this.expandedMarginEnd = i;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i) {
        this.expandedMarginStart = i;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i) {
        this.expandedMarginTop = i;
        requestLayout();
    }

    public void setExpandedTitleSpacing(int i) {
        this.expandedTitleSpacing = i;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i) {
        this.collapsingTitleHelper.setExpandedTextAppearance(i);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.collapsingTitleHelper.setExpandedTextColor(colorStateList);
    }

    public void setExpandedTitleTextSize(float f) {
        this.collapsingTitleHelper.setExpandedTextSize(f);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.collapsingTitleHelper.setExpandedTypeface(typeface);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean z9) {
        this.extraMultilineHeightEnabled = z9;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean z9) {
        this.forceApplySystemWindowInsetTop = z9;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHyphenationFrequency(int i) {
        this.collapsingTitleHelper.setHyphenationFrequency(i);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingAdd(float f) {
        this.collapsingTitleHelper.setLineSpacingAdd(f);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f) {
        this.collapsingTitleHelper.setLineSpacingMultiplier(f);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i) {
        this.collapsingTitleHelper.setExpandedMaxLines(i);
        this.collapsingSubtitleHelper.setExpandedMaxLines(i);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean z9) {
        this.collapsingTitleHelper.setRtlTextDirectionHeuristicsEnabled(z9);
    }

    public void setScrimAlpha(int i) {
        ViewGroup viewGroup;
        if (i != this.scrimAlpha) {
            if (this.contentScrim != null && (viewGroup = this.toolbar) != null) {
                viewGroup.postInvalidateOnAnimation();
            }
            this.scrimAlpha = i;
            postInvalidateOnAnimation();
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j) {
        this.scrimAnimationDuration = j;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i) {
        if (this.scrimVisibleHeightTrigger != i) {
            this.scrimVisibleHeightTrigger = i;
            updateScrimVisibility();
        }
    }

    public void setScrimsShown(boolean z9, boolean z10) {
        if (this.scrimsAreShown != z9) {
            if (z10) {
                animateScrim(z9 ? 255 : 0);
            } else {
                setScrimAlpha(z9 ? 255 : 0);
            }
            this.scrimsAreShown = z9;
        }
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStaticLayoutBuilderConfigurer(@Nullable StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer) {
        this.collapsingTitleHelper.setStaticLayoutBuilderConfigurer(staticLayoutBuilderConfigurer);
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.statusBarScrim;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.statusBarScrim = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.statusBarScrim.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.statusBarScrim, getLayoutDirection());
                this.statusBarScrim.setVisible(getVisibility() == 0, false);
                this.statusBarScrim.setCallback(this);
                this.statusBarScrim.setAlpha(this.scrimAlpha);
            }
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i) {
        setStatusBarScrim(new ColorDrawable(i));
    }

    public void setStatusBarScrimResource(@DrawableRes int i) {
        setStatusBarScrim(getContext().getDrawable(i));
    }

    public void setSubtitle(@Nullable CharSequence charSequence) {
        this.collapsingSubtitleHelper.setText(charSequence);
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.collapsingTitleHelper.setText(charSequence);
        updateContentDescriptionFromTitle();
    }

    public void setTitleCollapseMode(int i) {
        this.titleCollapseMode = i;
        boolean isTitleCollapseFadeMode = isTitleCollapseFadeMode();
        this.collapsingTitleHelper.setFadeModeEnabled(isTitleCollapseFadeMode);
        this.collapsingSubtitleHelper.setFadeModeEnabled(isTitleCollapseFadeMode);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            disableLiftOnScrollIfNeeded((AppBarLayout) parent);
        }
        if (isTitleCollapseFadeMode && this.contentScrim == null) {
            setContentScrimColor(getDefaultContentScrimColorForTitleCollapseFadeMode());
        }
    }

    public void setTitleEllipsize(@NonNull TextUtils.TruncateAt truncateAt) {
        this.collapsingTitleHelper.setTitleTextEllipsize(truncateAt);
    }

    public void setTitleEnabled(boolean z9) {
        if (z9 != this.collapsingTitleEnabled) {
            this.collapsingTitleEnabled = z9;
            updateContentDescriptionFromTitle();
            updateDummyView();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.collapsingTitleHelper.setPositionInterpolator(timeInterpolator);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z9 = i == 0;
        Drawable drawable = this.statusBarScrim;
        if (drawable != null && drawable.isVisible() != z9) {
            this.statusBarScrim.setVisible(z9, false);
        }
        Drawable drawable2 = this.contentScrim;
        if (drawable2 == null || drawable2.isVisible() == z9) {
            return;
        }
        this.contentScrim.setVisible(z9, false);
    }

    public final void updateScrimVisibility() {
        if (this.contentScrim == null && this.statusBarScrim == null) {
            return;
        }
        setScrimsShown(getHeight() + this.currentOffset < getScrimVisibleHeightTrigger());
    }

    @Override // android.view.View
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.contentScrim || drawable == this.statusBarScrim;
    }

    public void setCollapsedSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.collapsingSubtitleHelper.setCollapsedTextColor(colorStateList);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.collapsingTitleHelper.setCollapsedTextColor(colorStateList);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    private void updateContentScrimBounds(@NonNull Drawable drawable, int i, int i6) {
        updateContentScrimBounds(drawable, this.toolbar, i, i6);
    }

    public void setScrimsShown(boolean z9) {
        setScrimsShown(z9, isLaidOut() && !isInEditMode());
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int collapseMode;
        float parallaxMult;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = obtainStyledAttributes.getInt(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            setParallaxMultiplier(obtainStyledAttributes.getFloat(R.styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public int getCollapseMode() {
            return this.collapseMode;
        }

        public float getParallaxMultiplier() {
            return this.parallaxMult;
        }

        public void setCollapseMode(int i) {
            this.collapseMode = i;
        }

        public void setParallaxMultiplier(float f) {
            this.parallaxMult = f;
        }

        public LayoutParams(int i, int i6) {
            super(i, i6);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(int i, int i6, int i10) {
            super(i, i6, i10);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(@NonNull FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super((FrameLayout.LayoutParams) layoutParams);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
            this.collapseMode = layoutParams.collapseMode;
            this.parallaxMult = layoutParams.parallaxMult;
        }
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.collapsingToolbarLayoutStyle);
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, null);
    }
}
