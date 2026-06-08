package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import androidx.leanback.R;
import com.google.gson.internal.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class FadeAndShortSlide extends Visibility {
    private static final String PROPNAME_SCREEN_POSITION = "android:fadeAndShortSlideTransition:screenPosition";
    private float mDistance;
    private Visibility mFade;
    private CalculateSlide mSlideCalculator;
    final CalculateSlide sCalculateTopBottom;
    private static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
    static final CalculateSlide sCalculateStart = new CalculateSlide() { // from class: androidx.leanback.transition.FadeAndShortSlide.1
        @Override // androidx.leanback.transition.FadeAndShortSlide.CalculateSlide
        public float getGoneX(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            if (viewGroup.getLayoutDirection() != 1) {
                return view.getTranslationX() - fadeAndShortSlide.getHorizontalDistance(viewGroup);
            }
            return fadeAndShortSlide.getHorizontalDistance(viewGroup) + view.getTranslationX();
        }
    };
    static final CalculateSlide sCalculateEnd = new CalculateSlide() { // from class: androidx.leanback.transition.FadeAndShortSlide.2
        @Override // androidx.leanback.transition.FadeAndShortSlide.CalculateSlide
        public float getGoneX(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            if (viewGroup.getLayoutDirection() == 1) {
                return view.getTranslationX() - fadeAndShortSlide.getHorizontalDistance(viewGroup);
            }
            return fadeAndShortSlide.getHorizontalDistance(viewGroup) + view.getTranslationX();
        }
    };
    static final CalculateSlide sCalculateStartEnd = new CalculateSlide() { // from class: androidx.leanback.transition.FadeAndShortSlide.3
        @Override // androidx.leanback.transition.FadeAndShortSlide.CalculateSlide
        public float getGoneX(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            int centerX;
            int width = (view.getWidth() / 2) + iArr[0];
            viewGroup.getLocationOnScreen(iArr);
            Rect epicenter = fadeAndShortSlide.getEpicenter();
            if (epicenter == null) {
                centerX = (viewGroup.getWidth() / 2) + iArr[0];
            } else {
                centerX = epicenter.centerX();
            }
            if (width < centerX) {
                return view.getTranslationX() - fadeAndShortSlide.getHorizontalDistance(viewGroup);
            }
            return fadeAndShortSlide.getHorizontalDistance(viewGroup) + view.getTranslationX();
        }
    };
    static final CalculateSlide sCalculateBottom = new CalculateSlide() { // from class: androidx.leanback.transition.FadeAndShortSlide.4
        @Override // androidx.leanback.transition.FadeAndShortSlide.CalculateSlide
        public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return fadeAndShortSlide.getVerticalDistance(viewGroup) + view.getTranslationY();
        }
    };
    static final CalculateSlide sCalculateTop = new CalculateSlide() { // from class: androidx.leanback.transition.FadeAndShortSlide.5
        @Override // androidx.leanback.transition.FadeAndShortSlide.CalculateSlide
        public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationY() - fadeAndShortSlide.getVerticalDistance(viewGroup);
        }
    };

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class CalculateSlide {
        public float getGoneX(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationX();
        }

        public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
            return view.getTranslationY();
        }
    }

    public FadeAndShortSlide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFade = new Fade();
        this.mDistance = -1.0f;
        this.sCalculateTopBottom = new CalculateSlide() { // from class: androidx.leanback.transition.FadeAndShortSlide.6
            @Override // androidx.leanback.transition.FadeAndShortSlide.CalculateSlide
            public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
                int centerY;
                int height = (view.getHeight() / 2) + iArr[1];
                viewGroup.getLocationOnScreen(iArr);
                Rect epicenter = FadeAndShortSlide.this.getEpicenter();
                if (epicenter == null) {
                    centerY = (viewGroup.getHeight() / 2) + iArr[1];
                } else {
                    centerY = epicenter.centerY();
                }
                if (height < centerY) {
                    return view.getTranslationY() - fadeAndShortSlide.getVerticalDistance(viewGroup);
                }
                return fadeAndShortSlide.getVerticalDistance(viewGroup) + view.getTranslationY();
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbSlide);
        setSlideEdge(obtainStyledAttributes.getInt(R.styleable.lbSlide_lb_slideEdge, GravityCompat.START));
        obtainStyledAttributes.recycle();
    }

    private void captureValues(TransitionValues transitionValues) {
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_POSITION, iArr);
    }

    @Override // android.transition.Transition
    public Transition addListener(Transition.TransitionListener transitionListener) {
        this.mFade.addListener(transitionListener);
        return super.addListener(transitionListener);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        this.mFade.captureEndValues(transitionValues);
        super.captureEndValues(transitionValues);
        captureValues(transitionValues);
    }

    @Override // android.transition.Visibility, android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        this.mFade.captureStartValues(transitionValues);
        super.captureStartValues(transitionValues);
        captureValues(transitionValues);
    }

    @Override // android.transition.Transition
    public Transition clone() {
        FadeAndShortSlide fadeAndShortSlide = (FadeAndShortSlide) super.clone();
        fadeAndShortSlide.mFade = (Visibility) this.mFade.clone();
        return fadeAndShortSlide;
    }

    public float getDistance() {
        return this.mDistance;
    }

    public float getHorizontalDistance(ViewGroup viewGroup) {
        float f = this.mDistance;
        return f >= 0.0f ? f : viewGroup.getWidth() / 4;
    }

    public float getVerticalDistance(ViewGroup viewGroup) {
        float f = this.mDistance;
        return f >= 0.0f ? f : viewGroup.getHeight() / 4;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null || viewGroup == view) {
            return null;
        }
        int[] iArr = (int[]) transitionValues2.values.get(PROPNAME_SCREEN_POSITION);
        int i = iArr[0];
        int i6 = iArr[1];
        float translationX = view.getTranslationX();
        Animator createAnimation = TranslationAnimationCreator.createAnimation(view, transitionValues2, i, i6, this.mSlideCalculator.getGoneX(this, viewGroup, view, iArr), this.mSlideCalculator.getGoneY(this, viewGroup, view, iArr), translationX, view.getTranslationY(), sDecelerate, this);
        Animator onAppear = this.mFade.onAppear(viewGroup, view, transitionValues, transitionValues2);
        if (createAnimation == null) {
            return onAppear;
        }
        if (onAppear == null) {
            return createAnimation;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(createAnimation).with(onAppear);
        return animatorSet;
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || viewGroup == view) {
            return null;
        }
        int[] iArr = (int[]) transitionValues.values.get(PROPNAME_SCREEN_POSITION);
        Animator createAnimation = TranslationAnimationCreator.createAnimation(view, transitionValues, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.mSlideCalculator.getGoneX(this, viewGroup, view, iArr), this.mSlideCalculator.getGoneY(this, viewGroup, view, iArr), sDecelerate, this);
        Animator onDisappear = this.mFade.onDisappear(viewGroup, view, transitionValues, transitionValues2);
        if (createAnimation == null) {
            return onDisappear;
        }
        if (onDisappear == null) {
            return createAnimation;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(createAnimation).with(onDisappear);
        return animatorSet;
    }

    @Override // android.transition.Transition
    public Transition removeListener(Transition.TransitionListener transitionListener) {
        this.mFade.removeListener(transitionListener);
        return super.removeListener(transitionListener);
    }

    public void setDistance(float f) {
        this.mDistance = f;
    }

    @Override // android.transition.Transition
    public void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        this.mFade.setEpicenterCallback(epicenterCallback);
        super.setEpicenterCallback(epicenterCallback);
    }

    public void setSlideEdge(int i) {
        if (i == 48) {
            this.mSlideCalculator = sCalculateTop;
            return;
        }
        if (i == 80) {
            this.mSlideCalculator = sCalculateBottom;
            return;
        }
        if (i == 112) {
            this.mSlideCalculator = this.sCalculateTopBottom;
            return;
        }
        if (i == 8388611) {
            this.mSlideCalculator = sCalculateStart;
            return;
        }
        if (i == 8388613) {
            this.mSlideCalculator = sCalculateEnd;
        } else if (i == 8388615) {
            this.mSlideCalculator = sCalculateStartEnd;
        } else {
            a.p("Invalid slide direction");
        }
    }

    public FadeAndShortSlide(int i) {
        this.mFade = new Fade();
        this.mDistance = -1.0f;
        this.sCalculateTopBottom = new CalculateSlide() { // from class: androidx.leanback.transition.FadeAndShortSlide.6
            @Override // androidx.leanback.transition.FadeAndShortSlide.CalculateSlide
            public float getGoneY(FadeAndShortSlide fadeAndShortSlide, ViewGroup viewGroup, View view, int[] iArr) {
                int centerY;
                int height = (view.getHeight() / 2) + iArr[1];
                viewGroup.getLocationOnScreen(iArr);
                Rect epicenter = FadeAndShortSlide.this.getEpicenter();
                if (epicenter == null) {
                    centerY = (viewGroup.getHeight() / 2) + iArr[1];
                } else {
                    centerY = epicenter.centerY();
                }
                if (height < centerY) {
                    return view.getTranslationY() - fadeAndShortSlide.getVerticalDistance(viewGroup);
                }
                return fadeAndShortSlide.getVerticalDistance(viewGroup) + view.getTranslationY();
            }
        };
        setSlideEdge(i);
    }

    public FadeAndShortSlide() {
        this(GravityCompat.START);
    }
}
