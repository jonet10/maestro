package androidx.leanback.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Property;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.view.GravityCompat;
import androidx.leanback.R;
import androidx.leanback.widget.PagingIndicator;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Deprecated
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class OnboardingFragment extends Fragment {
    private static final boolean DEBUG = false;
    private static final long DESCRIPTION_START_DELAY_MS = 33;
    private static final long HEADER_ANIMATION_DURATION_MS = 417;
    private static final long HEADER_APPEAR_DELAY_MS = 500;
    private static final TimeInterpolator HEADER_APPEAR_INTERPOLATOR = new DecelerateInterpolator();
    private static final TimeInterpolator HEADER_DISAPPEAR_INTERPOLATOR = new AccelerateInterpolator();
    private static final String KEY_CURRENT_PAGE_INDEX = "leanback.onboarding.current_page_index";
    private static final String KEY_ENTER_ANIMATION_FINISHED = "leanback.onboarding.enter_animation_finished";
    private static final String KEY_LOGO_ANIMATION_FINISHED = "leanback.onboarding.logo_animation_finished";
    private static final long LOGO_SPLASH_PAUSE_DURATION_MS = 1333;
    private static final int SLIDE_DISTANCE = 60;
    private static final String TAG = "OnboardingF";
    private static int sSlideDistance;
    private AnimatorSet mAnimator;
    private boolean mArrowBackgroundColorSet;
    private boolean mArrowColorSet;
    int mCurrentPageIndex;
    TextView mDescriptionView;
    private boolean mDescriptionViewTextColorSet;
    private boolean mDotBackgroundColorSet;
    boolean mEnterAnimationFinished;
    private int mIconResourceId;
    boolean mIsLtr;
    boolean mLogoAnimationFinished;
    private int mLogoResourceId;
    private ImageView mLogoView;
    private ImageView mMainIconView;
    PagingIndicator mPageIndicator;
    View mStartButton;
    private CharSequence mStartButtonText;
    private boolean mStartButtonTextSet;
    private ContextThemeWrapper mThemeWrapper;
    TextView mTitleView;
    private boolean mTitleViewTextColorSet;

    @ColorInt
    private int mTitleViewTextColor = 0;

    @ColorInt
    private int mDescriptionViewTextColor = 0;

    @ColorInt
    private int mDotBackgroundColor = 0;

    @ColorInt
    private int mArrowColor = 0;

    @ColorInt
    private int mArrowBackgroundColor = 0;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: androidx.leanback.app.OnboardingFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnboardingFragment onboardingFragment = OnboardingFragment.this;
            if (onboardingFragment.mLogoAnimationFinished) {
                int i = onboardingFragment.mCurrentPageIndex;
                int pageCount = onboardingFragment.getPageCount() - 1;
                OnboardingFragment onboardingFragment2 = OnboardingFragment.this;
                if (i == pageCount) {
                    onboardingFragment2.onFinishFragment();
                } else {
                    onboardingFragment2.moveToNextPage();
                }
            }
        }
    };
    private final View.OnKeyListener mOnKeyListener = new View.OnKeyListener() { // from class: androidx.leanback.app.OnboardingFragment.2
        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (!OnboardingFragment.this.mLogoAnimationFinished) {
                return i != 4;
            }
            if (keyEvent.getAction() == 0) {
                return false;
            }
            if (i == 4) {
                OnboardingFragment onboardingFragment = OnboardingFragment.this;
                if (onboardingFragment.mCurrentPageIndex == 0) {
                    return false;
                }
                onboardingFragment.moveToPreviousPage();
                return true;
            }
            if (i == 21) {
                OnboardingFragment onboardingFragment2 = OnboardingFragment.this;
                if (onboardingFragment2.mIsLtr) {
                    onboardingFragment2.moveToPreviousPage();
                } else {
                    onboardingFragment2.moveToNextPage();
                }
                return true;
            }
            if (i != 22) {
                return false;
            }
            OnboardingFragment onboardingFragment3 = OnboardingFragment.this;
            if (onboardingFragment3.mIsLtr) {
                onboardingFragment3.moveToNextPage();
            } else {
                onboardingFragment3.moveToPreviousPage();
            }
            return true;
        }
    };

    private Animator createAnimator(View view, boolean z9, int i, long j) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        boolean z10 = getView().getLayoutDirection() == 0;
        boolean z11 = (z10 && i == 8388613) || (!z10 && i == 8388611) || i == 5;
        if (z9) {
            ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, z11 ? sSlideDistance : -sSlideDistance, 0.0f);
            TimeInterpolator timeInterpolator = HEADER_APPEAR_INTERPOLATOR;
            ofFloat.setInterpolator(timeInterpolator);
            ofFloat2.setInterpolator(timeInterpolator);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, 0.0f, z11 ? sSlideDistance : -sSlideDistance);
            TimeInterpolator timeInterpolator2 = HEADER_DISAPPEAR_INTERPOLATOR;
            ofFloat.setInterpolator(timeInterpolator2);
            ofFloat2.setInterpolator(timeInterpolator2);
        }
        ofFloat.setDuration(HEADER_ANIMATION_DURATION_MS);
        ofFloat.setTarget(view);
        ofFloat2.setDuration(HEADER_ANIMATION_DURATION_MS);
        ofFloat2.setTarget(view);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        if (j > 0) {
            animatorSet.setStartDelay(j);
        }
        return animatorSet;
    }

    private LayoutInflater getThemeInflater(LayoutInflater layoutInflater) {
        ContextThemeWrapper contextThemeWrapper = this.mThemeWrapper;
        return contextThemeWrapper == null ? layoutInflater : layoutInflater.cloneInContext(contextThemeWrapper);
    }

    private void onPageChangedInternal(int i) {
        OnboardingFragment onboardingFragment;
        Animator createAnimator;
        AnimatorSet animatorSet = this.mAnimator;
        if (animatorSet != null) {
            animatorSet.end();
        }
        this.mPageIndicator.onPageSelected(this.mCurrentPageIndex, true);
        ArrayList arrayList = new ArrayList();
        int currentPageIndex = getCurrentPageIndex();
        TextView textView = this.mTitleView;
        if (i < currentPageIndex) {
            onboardingFragment = this;
            arrayList.add(onboardingFragment.createAnimator(textView, false, GravityCompat.START, 0L));
            createAnimator = onboardingFragment.createAnimator(onboardingFragment.mDescriptionView, false, GravityCompat.START, DESCRIPTION_START_DELAY_MS);
            arrayList.add(createAnimator);
            arrayList.add(onboardingFragment.createAnimator(onboardingFragment.mTitleView, true, GravityCompat.END, HEADER_APPEAR_DELAY_MS));
            arrayList.add(onboardingFragment.createAnimator(onboardingFragment.mDescriptionView, true, GravityCompat.END, 533L));
        } else {
            onboardingFragment = this;
            arrayList.add(onboardingFragment.createAnimator(textView, false, GravityCompat.END, 0L));
            createAnimator = onboardingFragment.createAnimator(onboardingFragment.mDescriptionView, false, GravityCompat.END, DESCRIPTION_START_DELAY_MS);
            arrayList.add(createAnimator);
            arrayList.add(onboardingFragment.createAnimator(onboardingFragment.mTitleView, true, GravityCompat.START, HEADER_APPEAR_DELAY_MS));
            arrayList.add(onboardingFragment.createAnimator(onboardingFragment.mDescriptionView, true, GravityCompat.START, 533L));
        }
        final int currentPageIndex2 = getCurrentPageIndex();
        createAnimator.addListener(new AnimatorListenerAdapter() { // from class: androidx.leanback.app.OnboardingFragment.6
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                OnboardingFragment onboardingFragment2 = OnboardingFragment.this;
                onboardingFragment2.mTitleView.setText(onboardingFragment2.getPageTitle(currentPageIndex2));
                OnboardingFragment onboardingFragment3 = OnboardingFragment.this;
                onboardingFragment3.mDescriptionView.setText(onboardingFragment3.getPageDescription(currentPageIndex2));
            }
        });
        Context context = FragmentUtil.getContext(this);
        if (getCurrentPageIndex() == getPageCount() - 1) {
            onboardingFragment.mStartButton.setVisibility(0);
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_page_indicator_fade_out);
            loadAnimator.setTarget(onboardingFragment.mPageIndicator);
            loadAnimator.addListener(new AnimatorListenerAdapter() { // from class: androidx.leanback.app.OnboardingFragment.7
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    OnboardingFragment.this.mPageIndicator.setVisibility(8);
                }
            });
            arrayList.add(loadAnimator);
            Animator loadAnimator2 = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_start_button_fade_in);
            loadAnimator2.setTarget(onboardingFragment.mStartButton);
            arrayList.add(loadAnimator2);
        } else if (i == getPageCount() - 1) {
            onboardingFragment.mPageIndicator.setVisibility(0);
            Animator loadAnimator3 = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_page_indicator_fade_in);
            loadAnimator3.setTarget(onboardingFragment.mPageIndicator);
            arrayList.add(loadAnimator3);
            Animator loadAnimator4 = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_start_button_fade_out);
            loadAnimator4.setTarget(onboardingFragment.mStartButton);
            loadAnimator4.addListener(new AnimatorListenerAdapter() { // from class: androidx.leanback.app.OnboardingFragment.8
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    OnboardingFragment.this.mStartButton.setVisibility(8);
                }
            });
            arrayList.add(loadAnimator4);
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        onboardingFragment.mAnimator = animatorSet2;
        animatorSet2.playTogether(arrayList);
        onboardingFragment.mAnimator.start();
        onPageChanged(onboardingFragment.mCurrentPageIndex, i);
    }

    private void resolveTheme() {
        Context context = FragmentUtil.getContext(this);
        int onProvideTheme = onProvideTheme();
        if (onProvideTheme != -1) {
            this.mThemeWrapper = new ContextThemeWrapper(context, onProvideTheme);
            return;
        }
        int i = R.attr.onboardingTheme;
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            this.mThemeWrapper = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    @ColorInt
    public final int getArrowBackgroundColor() {
        return this.mArrowBackgroundColor;
    }

    @ColorInt
    public final int getArrowColor() {
        return this.mArrowColor;
    }

    public final int getCurrentPageIndex() {
        return this.mCurrentPageIndex;
    }

    @ColorInt
    public final int getDescriptionViewTextColor() {
        return this.mDescriptionViewTextColor;
    }

    @ColorInt
    public final int getDotBackgroundColor() {
        return this.mDotBackgroundColor;
    }

    public final int getIconResourceId() {
        return this.mIconResourceId;
    }

    public final int getLogoResourceId() {
        return this.mLogoResourceId;
    }

    public abstract int getPageCount();

    public abstract CharSequence getPageDescription(int i);

    public abstract CharSequence getPageTitle(int i);

    public final CharSequence getStartButtonText() {
        return this.mStartButtonText;
    }

    @ColorInt
    public final int getTitleViewTextColor() {
        return this.mTitleViewTextColor;
    }

    public void hideLogoView() {
        this.mLogoView.setVisibility(8);
        int i = this.mIconResourceId;
        if (i != 0) {
            this.mMainIconView.setImageResource(i);
            this.mMainIconView.setVisibility(0);
        }
        View view = getView();
        LayoutInflater themeInflater = getThemeInflater(LayoutInflater.from(FragmentUtil.getContext(this)));
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.background_container);
        View onCreateBackgroundView = onCreateBackgroundView(themeInflater, viewGroup);
        if (onCreateBackgroundView != null) {
            viewGroup.setVisibility(0);
            viewGroup.addView(onCreateBackgroundView);
        }
        ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.content_container);
        View onCreateContentView = onCreateContentView(themeInflater, viewGroup2);
        if (onCreateContentView != null) {
            viewGroup2.setVisibility(0);
            viewGroup2.addView(onCreateContentView);
        }
        ViewGroup viewGroup3 = (ViewGroup) view.findViewById(R.id.foreground_container);
        View onCreateForegroundView = onCreateForegroundView(themeInflater, viewGroup3);
        if (onCreateForegroundView != null) {
            viewGroup3.setVisibility(0);
            viewGroup3.addView(onCreateForegroundView);
        }
        view.findViewById(R.id.page_container).setVisibility(0);
        view.findViewById(R.id.content_container).setVisibility(0);
        if (getPageCount() > 1) {
            this.mPageIndicator.setPageCount(getPageCount());
            this.mPageIndicator.onPageSelected(this.mCurrentPageIndex, false);
        }
        if (this.mCurrentPageIndex == getPageCount() - 1) {
            this.mStartButton.setVisibility(0);
        } else {
            this.mPageIndicator.setVisibility(0);
        }
        this.mTitleView.setText(getPageTitle(this.mCurrentPageIndex));
        this.mDescriptionView.setText(getPageDescription(this.mCurrentPageIndex));
    }

    public final boolean isLogoAnimationFinished() {
        return this.mLogoAnimationFinished;
    }

    public void moveToNextPage() {
        if (this.mLogoAnimationFinished && this.mCurrentPageIndex < getPageCount() - 1) {
            int i = this.mCurrentPageIndex;
            this.mCurrentPageIndex = i + 1;
            onPageChangedInternal(i);
        }
    }

    public void moveToPreviousPage() {
        int i;
        if (this.mLogoAnimationFinished && (i = this.mCurrentPageIndex) > 0) {
            this.mCurrentPageIndex = i - 1;
            onPageChangedInternal(i);
        }
    }

    public abstract View onCreateBackgroundView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public abstract View onCreateContentView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public Animator onCreateDescriptionAnimator() {
        return AnimatorInflater.loadAnimator(FragmentUtil.getContext(this), R.animator.lb_onboarding_description_enter);
    }

    public Animator onCreateEnterAnimation() {
        return null;
    }

    public abstract View onCreateForegroundView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public Animator onCreateLogoAnimation() {
        return null;
    }

    public Animator onCreateTitleAnimator() {
        return AnimatorInflater.loadAnimator(FragmentUtil.getContext(this), R.animator.lb_onboarding_title_enter);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        resolveTheme();
        ViewGroup viewGroup2 = (ViewGroup) getThemeInflater(layoutInflater).inflate(R.layout.lb_onboarding_fragment, viewGroup, false);
        this.mIsLtr = getResources().getConfiguration().getLayoutDirection() == 0;
        PagingIndicator pagingIndicator = (PagingIndicator) viewGroup2.findViewById(R.id.page_indicator);
        this.mPageIndicator = pagingIndicator;
        pagingIndicator.setOnClickListener(this.mOnClickListener);
        this.mPageIndicator.setOnKeyListener(this.mOnKeyListener);
        View findViewById = viewGroup2.findViewById(R.id.button_start);
        this.mStartButton = findViewById;
        findViewById.setOnClickListener(this.mOnClickListener);
        this.mStartButton.setOnKeyListener(this.mOnKeyListener);
        this.mMainIconView = (ImageView) viewGroup2.findViewById(R.id.main_icon);
        this.mLogoView = (ImageView) viewGroup2.findViewById(R.id.logo);
        this.mTitleView = (TextView) viewGroup2.findViewById(R.id.title);
        this.mDescriptionView = (TextView) viewGroup2.findViewById(R.id.description);
        if (this.mTitleViewTextColorSet) {
            this.mTitleView.setTextColor(this.mTitleViewTextColor);
        }
        if (this.mDescriptionViewTextColorSet) {
            this.mDescriptionView.setTextColor(this.mDescriptionViewTextColor);
        }
        if (this.mDotBackgroundColorSet) {
            this.mPageIndicator.setDotBackgroundColor(this.mDotBackgroundColor);
        }
        if (this.mArrowColorSet) {
            this.mPageIndicator.setArrowColor(this.mArrowColor);
        }
        if (this.mArrowBackgroundColorSet) {
            this.mPageIndicator.setDotBackgroundColor(this.mArrowBackgroundColor);
        }
        if (this.mStartButtonTextSet) {
            ((Button) this.mStartButton).setText(this.mStartButtonText);
        }
        Context context = FragmentUtil.getContext(this);
        if (sSlideDistance == 0) {
            sSlideDistance = (int) (context.getResources().getDisplayMetrics().scaledDensity * 60.0f);
        }
        viewGroup2.requestFocus();
        return viewGroup2;
    }

    public void onLogoAnimationFinished() {
        startEnterAnimation(false);
    }

    public int onProvideTheme() {
        return -1;
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(KEY_CURRENT_PAGE_INDEX, this.mCurrentPageIndex);
        bundle.putBoolean(KEY_LOGO_ANIMATION_FINISHED, this.mLogoAnimationFinished);
        bundle.putBoolean(KEY_ENTER_ANIMATION_FINISHED, this.mEnterAnimationFinished);
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            this.mCurrentPageIndex = 0;
            this.mLogoAnimationFinished = false;
            this.mEnterAnimationFinished = false;
            this.mPageIndicator.onPageSelected(0, false);
            view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: androidx.leanback.app.OnboardingFragment.3
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    OnboardingFragment.this.getView().getViewTreeObserver().removeOnPreDrawListener(this);
                    if (!OnboardingFragment.this.startLogoAnimation()) {
                        OnboardingFragment onboardingFragment = OnboardingFragment.this;
                        onboardingFragment.mLogoAnimationFinished = true;
                        onboardingFragment.onLogoAnimationFinished();
                    }
                    return true;
                }
            });
            return;
        }
        this.mCurrentPageIndex = bundle.getInt(KEY_CURRENT_PAGE_INDEX);
        this.mLogoAnimationFinished = bundle.getBoolean(KEY_LOGO_ANIMATION_FINISHED);
        this.mEnterAnimationFinished = bundle.getBoolean(KEY_ENTER_ANIMATION_FINISHED);
        if (this.mLogoAnimationFinished) {
            onLogoAnimationFinished();
        } else {
            if (startLogoAnimation()) {
                return;
            }
            this.mLogoAnimationFinished = true;
            onLogoAnimationFinished();
        }
    }

    public void setArrowBackgroundColor(@ColorInt int i) {
        this.mArrowBackgroundColor = i;
        this.mArrowBackgroundColorSet = true;
        PagingIndicator pagingIndicator = this.mPageIndicator;
        if (pagingIndicator != null) {
            pagingIndicator.setArrowBackgroundColor(i);
        }
    }

    public void setArrowColor(@ColorInt int i) {
        this.mArrowColor = i;
        this.mArrowColorSet = true;
        PagingIndicator pagingIndicator = this.mPageIndicator;
        if (pagingIndicator != null) {
            pagingIndicator.setArrowColor(i);
        }
    }

    public void setDescriptionViewTextColor(@ColorInt int i) {
        this.mDescriptionViewTextColor = i;
        this.mDescriptionViewTextColorSet = true;
        TextView textView = this.mDescriptionView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setDotBackgroundColor(@ColorInt int i) {
        this.mDotBackgroundColor = i;
        this.mDotBackgroundColorSet = true;
        PagingIndicator pagingIndicator = this.mPageIndicator;
        if (pagingIndicator != null) {
            pagingIndicator.setDotBackgroundColor(i);
        }
    }

    public final void setIconResouceId(int i) {
        this.mIconResourceId = i;
        ImageView imageView = this.mMainIconView;
        if (imageView != null) {
            imageView.setImageResource(i);
            this.mMainIconView.setVisibility(0);
        }
    }

    public final void setLogoResourceId(int i) {
        this.mLogoResourceId = i;
    }

    public void setStartButtonText(CharSequence charSequence) {
        this.mStartButtonText = charSequence;
        this.mStartButtonTextSet = true;
        View view = this.mStartButton;
        if (view != null) {
            ((Button) view).setText(charSequence);
        }
    }

    public void setTitleViewTextColor(@ColorInt int i) {
        this.mTitleViewTextColor = i;
        this.mTitleViewTextColorSet = true;
        TextView textView = this.mTitleView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public final void startEnterAnimation(boolean z9) {
        Context context = FragmentUtil.getContext(this);
        if (context == null) {
            return;
        }
        hideLogoView();
        if (!this.mEnterAnimationFinished || z9) {
            ArrayList arrayList = new ArrayList();
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_page_indicator_enter);
            loadAnimator.setTarget(getPageCount() <= 1 ? this.mStartButton : this.mPageIndicator);
            arrayList.add(loadAnimator);
            Animator onCreateTitleAnimator = onCreateTitleAnimator();
            if (onCreateTitleAnimator != null) {
                onCreateTitleAnimator.setTarget(this.mTitleView);
                arrayList.add(onCreateTitleAnimator);
            }
            Animator onCreateDescriptionAnimator = onCreateDescriptionAnimator();
            if (onCreateDescriptionAnimator != null) {
                onCreateDescriptionAnimator.setTarget(this.mDescriptionView);
                arrayList.add(onCreateDescriptionAnimator);
            }
            Animator onCreateEnterAnimation = onCreateEnterAnimation();
            if (onCreateEnterAnimation != null) {
                arrayList.add(onCreateEnterAnimation);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.mAnimator = animatorSet;
            animatorSet.playTogether(arrayList);
            this.mAnimator.start();
            this.mAnimator.addListener(new AnimatorListenerAdapter() { // from class: androidx.leanback.app.OnboardingFragment.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    OnboardingFragment.this.mEnterAnimationFinished = true;
                }
            });
            getView().requestFocus();
        }
    }

    public boolean startLogoAnimation() {
        Animator animator;
        final Context context = FragmentUtil.getContext(this);
        if (context == null) {
            return false;
        }
        if (this.mLogoResourceId != 0) {
            this.mLogoView.setVisibility(0);
            this.mLogoView.setImageResource(this.mLogoResourceId);
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_logo_enter);
            Animator loadAnimator2 = AnimatorInflater.loadAnimator(context, R.animator.lb_onboarding_logo_exit);
            loadAnimator2.setStartDelay(LOGO_SPLASH_PAUSE_DURATION_MS);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(loadAnimator, loadAnimator2);
            animatorSet.setTarget(this.mLogoView);
            animator = animatorSet;
        } else {
            animator = onCreateLogoAnimation();
        }
        if (animator == null) {
            return false;
        }
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.leanback.app.OnboardingFragment.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                if (context != null) {
                    OnboardingFragment onboardingFragment = OnboardingFragment.this;
                    onboardingFragment.mLogoAnimationFinished = true;
                    onboardingFragment.onLogoAnimationFinished();
                }
            }
        });
        animator.start();
        return true;
    }

    public void onFinishFragment() {
    }

    public void onPageChanged(int i, int i6) {
    }
}
