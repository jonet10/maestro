package androidx.leanback.widget;

import android.animation.TimeAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.leanback.graphics.ColorOverlayDimmer;
import androidx.leanback.widget.ItemBridgeAdapter;
import androidx.leanback.widget.RowHeaderPresenter;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class FocusHighlightHelper {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class BrowseItemFocusHighlight implements FocusHighlightHandler {
        private static final int DURATION_MS = 150;
        private int mScaleIndex;
        private final boolean mUseDimmer;

        public BrowseItemFocusHighlight(int i, boolean z9) {
            if (!FocusHighlightHelper.isValidZoomIndex(i)) {
                com.google.gson.internal.a.p("Unhandled zoom index");
                throw null;
            }
            this.mScaleIndex = i;
            this.mUseDimmer = z9;
        }

        private FocusAnimator getOrCreateAnimator(View view) {
            FocusAnimator focusAnimator = (FocusAnimator) view.getTag(androidx.leanback.R.id.lb_focus_animator);
            if (focusAnimator != null) {
                return focusAnimator;
            }
            FocusAnimator focusAnimator2 = new FocusAnimator(view, getScale(view.getResources()), this.mUseDimmer, DURATION_MS);
            view.setTag(androidx.leanback.R.id.lb_focus_animator, focusAnimator2);
            return focusAnimator2;
        }

        private float getScale(Resources resources) {
            int i = this.mScaleIndex;
            if (i == 0) {
                return 1.0f;
            }
            return resources.getFraction(FocusHighlightHelper.getResId(i), 1, 1);
        }

        @Override // androidx.leanback.widget.FocusHighlightHandler
        public void onInitializeView(View view) {
            getOrCreateAnimator(view).animateFocus(false, true);
        }

        @Override // androidx.leanback.widget.FocusHighlightHandler
        public void onItemFocused(View view, boolean z9) {
            view.setSelected(z9);
            getOrCreateAnimator(view).animateFocus(z9, false);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class FocusAnimator implements TimeAnimator.TimeListener {
        private final TimeAnimator mAnimator;
        private final ColorOverlayDimmer mDimmer;
        private final int mDuration;
        private float mFocusLevel = 0.0f;
        private float mFocusLevelDelta;
        private float mFocusLevelStart;
        private final Interpolator mInterpolator;
        private final float mScaleDiff;
        private final View mView;
        private final ShadowOverlayContainer mWrapper;

        public FocusAnimator(View view, float f, boolean z9, int i) {
            TimeAnimator timeAnimator = new TimeAnimator();
            this.mAnimator = timeAnimator;
            this.mInterpolator = new AccelerateDecelerateInterpolator();
            this.mView = view;
            this.mDuration = i;
            this.mScaleDiff = f - 1.0f;
            if (view instanceof ShadowOverlayContainer) {
                this.mWrapper = (ShadowOverlayContainer) view;
            } else {
                this.mWrapper = null;
            }
            timeAnimator.setTimeListener(this);
            if (z9) {
                this.mDimmer = ColorOverlayDimmer.createDefault(view.getContext());
            } else {
                this.mDimmer = null;
            }
        }

        public void animateFocus(boolean z9, boolean z10) {
            endAnimation();
            float f = z9 ? 1.0f : 0.0f;
            if (z10) {
                setFocusLevel(f);
                return;
            }
            float f10 = this.mFocusLevel;
            if (f10 != f) {
                this.mFocusLevelStart = f10;
                this.mFocusLevelDelta = f - f10;
                this.mAnimator.start();
            }
        }

        public void endAnimation() {
            this.mAnimator.end();
        }

        public float getFocusLevel() {
            return this.mFocusLevel;
        }

        @Override // android.animation.TimeAnimator.TimeListener
        public void onTimeUpdate(TimeAnimator timeAnimator, long j, long j6) {
            float f;
            int i = this.mDuration;
            if (j >= i) {
                this.mAnimator.end();
                f = 1.0f;
            } else {
                f = (float) (j / i);
            }
            Interpolator interpolator = this.mInterpolator;
            if (interpolator != null) {
                f = interpolator.getInterpolation(f);
            }
            setFocusLevel((f * this.mFocusLevelDelta) + this.mFocusLevelStart);
        }

        public void setFocusLevel(float f) {
            this.mFocusLevel = f;
            float f10 = (this.mScaleDiff * f) + 1.0f;
            this.mView.setScaleX(f10);
            this.mView.setScaleY(f10);
            ShadowOverlayContainer shadowOverlayContainer = this.mWrapper;
            if (shadowOverlayContainer != null) {
                shadowOverlayContainer.setShadowFocusLevel(f);
            } else {
                ShadowOverlayHelper.setNoneWrapperShadowFocusLevel(this.mView, f);
            }
            ColorOverlayDimmer colorOverlayDimmer = this.mDimmer;
            if (colorOverlayDimmer != null) {
                colorOverlayDimmer.setActiveLevel(f);
                int color = this.mDimmer.getPaint().getColor();
                ShadowOverlayContainer shadowOverlayContainer2 = this.mWrapper;
                if (shadowOverlayContainer2 != null) {
                    shadowOverlayContainer2.setOverlayColor(color);
                } else {
                    ShadowOverlayHelper.setNoneWrapperOverlayColor(this.mView, color);
                }
            }
        }
    }

    @SuppressLint({"PrivateConstructorForUtilityClass"})
    @Deprecated
    public FocusHighlightHelper() {
    }

    public static int getResId(int i) {
        if (i == 1) {
            return androidx.leanback.R.fraction.lb_focus_zoom_factor_small;
        }
        if (i == 2) {
            return androidx.leanback.R.fraction.lb_focus_zoom_factor_medium;
        }
        if (i == 3) {
            return androidx.leanback.R.fraction.lb_focus_zoom_factor_large;
        }
        if (i != 4) {
            return 0;
        }
        return androidx.leanback.R.fraction.lb_focus_zoom_factor_xsmall;
    }

    public static boolean isValidZoomIndex(int i) {
        return i == 0 || getResId(i) > 0;
    }

    public static void setupBrowseItemFocusHighlight(ItemBridgeAdapter itemBridgeAdapter, int i, boolean z9) {
        if (i != 0 || z9) {
            itemBridgeAdapter.setFocusHighlight(new BrowseItemFocusHighlight(i, z9));
        } else {
            itemBridgeAdapter.setFocusHighlight(null);
        }
    }

    @Deprecated
    public static void setupHeaderItemFocusHighlight(VerticalGridView verticalGridView, boolean z9) {
        if (verticalGridView == null || !(verticalGridView.getAdapter() instanceof ItemBridgeAdapter)) {
            return;
        }
        ((ItemBridgeAdapter) verticalGridView.getAdapter()).setFocusHighlight(z9 ? new HeaderItemFocusHighlight() : null);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class HeaderItemFocusHighlight implements FocusHighlightHandler {
        private int mDuration;
        private boolean mInitialized;
        private float mSelectScale;

        /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
        public static class HeaderFocusAnimator extends FocusAnimator {
            ItemBridgeAdapter.ViewHolder mViewHolder;

            public HeaderFocusAnimator(View view, float f, int i) {
                super(view, f, false, i);
                ViewParent parent = view.getParent();
                while (parent != null && !(parent instanceof RecyclerView)) {
                    parent = parent.getParent();
                }
                if (parent != null) {
                    this.mViewHolder = (ItemBridgeAdapter.ViewHolder) ((RecyclerView) parent).getChildViewHolder(view);
                }
            }

            @Override // androidx.leanback.widget.FocusHighlightHelper.FocusAnimator
            public void setFocusLevel(float f) {
                Presenter presenter = this.mViewHolder.getPresenter();
                if (presenter instanceof RowHeaderPresenter) {
                    ((RowHeaderPresenter) presenter).setSelectLevel((RowHeaderPresenter.ViewHolder) this.mViewHolder.getViewHolder(), f);
                }
                super.setFocusLevel(f);
            }
        }

        private void viewFocused(View view, boolean z9) {
            lazyInit(view);
            view.setSelected(z9);
            FocusAnimator focusAnimator = (FocusAnimator) view.getTag(androidx.leanback.R.id.lb_focus_animator);
            if (focusAnimator == null) {
                focusAnimator = new HeaderFocusAnimator(view, this.mSelectScale, this.mDuration);
                view.setTag(androidx.leanback.R.id.lb_focus_animator, focusAnimator);
            }
            focusAnimator.animateFocus(z9, false);
        }

        public void lazyInit(View view) {
            if (this.mInitialized) {
                return;
            }
            Resources resources = view.getResources();
            TypedValue typedValue = new TypedValue();
            resources.getValue(androidx.leanback.R.dimen.lb_browse_header_select_scale, typedValue, true);
            this.mSelectScale = typedValue.getFloat();
            resources.getValue(androidx.leanback.R.dimen.lb_browse_header_select_duration, typedValue, true);
            this.mDuration = typedValue.data;
            this.mInitialized = true;
        }

        @Override // androidx.leanback.widget.FocusHighlightHandler
        public void onItemFocused(View view, boolean z9) {
            viewFocused(view, z9);
        }

        @Override // androidx.leanback.widget.FocusHighlightHandler
        public void onInitializeView(View view) {
        }
    }

    @Deprecated
    public static void setupHeaderItemFocusHighlight(VerticalGridView verticalGridView) {
        setupHeaderItemFocusHighlight(verticalGridView, true);
    }

    public static void setupHeaderItemFocusHighlight(ItemBridgeAdapter itemBridgeAdapter) {
        setupHeaderItemFocusHighlight(itemBridgeAdapter, true);
    }

    public static void setupHeaderItemFocusHighlight(ItemBridgeAdapter itemBridgeAdapter, boolean z9) {
        itemBridgeAdapter.setFocusHighlight(z9 ? new HeaderItemFocusHighlight() : null);
    }
}
