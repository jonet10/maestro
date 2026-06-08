package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import androidx.leanback.R;
import com.google.gson.internal.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class SlideKitkat extends Visibility {
    private static final String TAG = "SlideKitkat";
    private CalculateSlide mSlideCalculator;
    private int mSlideEdge;
    private static final TimeInterpolator sDecelerate = new DecelerateInterpolator();
    private static final TimeInterpolator sAccelerate = new AccelerateInterpolator();
    private static final CalculateSlide sCalculateLeft = new CalculateSlideHorizontal() { // from class: androidx.leanback.transition.SlideKitkat.1
        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public float getGone(View view) {
            return view.getTranslationX() - view.getWidth();
        }
    };
    private static final CalculateSlide sCalculateTop = new CalculateSlideVertical() { // from class: androidx.leanback.transition.SlideKitkat.2
        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public float getGone(View view) {
            return view.getTranslationY() - view.getHeight();
        }
    };
    private static final CalculateSlide sCalculateRight = new CalculateSlideHorizontal() { // from class: androidx.leanback.transition.SlideKitkat.3
        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public float getGone(View view) {
            return view.getTranslationX() + view.getWidth();
        }
    };
    private static final CalculateSlide sCalculateBottom = new CalculateSlideVertical() { // from class: androidx.leanback.transition.SlideKitkat.4
        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public float getGone(View view) {
            return view.getTranslationY() + view.getHeight();
        }
    };
    private static final CalculateSlide sCalculateStart = new CalculateSlideHorizontal() { // from class: androidx.leanback.transition.SlideKitkat.5
        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public float getGone(View view) {
            return view.getLayoutDirection() == 1 ? view.getTranslationX() + view.getWidth() : view.getTranslationX() - view.getWidth();
        }
    };
    private static final CalculateSlide sCalculateEnd = new CalculateSlideHorizontal() { // from class: androidx.leanback.transition.SlideKitkat.6
        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public float getGone(View view) {
            return view.getLayoutDirection() == 1 ? view.getTranslationX() - view.getWidth() : view.getTranslationX() + view.getWidth();
        }
    };

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface CalculateSlide {
        float getGone(View view);

        float getHere(View view);

        Property<View, Float> getProperty();
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class CalculateSlideHorizontal implements CalculateSlide {
        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public float getHere(View view) {
            return view.getTranslationX();
        }

        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public Property<View, Float> getProperty() {
            return View.TRANSLATION_X;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class CalculateSlideVertical implements CalculateSlide {
        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public float getHere(View view) {
            return view.getTranslationY();
        }

        @Override // androidx.leanback.transition.SlideKitkat.CalculateSlide
        public Property<View, Float> getProperty() {
            return View.TRANSLATION_Y;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class SlideAnimatorListener extends AnimatorListenerAdapter {
        private boolean mCanceled = false;
        private final float mEndValue;
        private final int mFinalVisibility;
        private float mPausedValue;
        private final Property<View, Float> mProp;
        private final float mTerminalValue;
        private final View mView;

        public SlideAnimatorListener(View view, Property<View, Float> property, float f, float f10, int i) {
            this.mProp = property;
            this.mView = view;
            this.mTerminalValue = f;
            this.mEndValue = f10;
            this.mFinalVisibility = i;
            view.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.mView.setTag(R.id.lb_slide_transition_value, new float[]{this.mView.getTranslationX(), this.mView.getTranslationY()});
            this.mProp.set(this.mView, Float.valueOf(this.mTerminalValue));
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.mCanceled) {
                this.mProp.set(this.mView, Float.valueOf(this.mTerminalValue));
            }
            this.mView.setVisibility(this.mFinalVisibility);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.mPausedValue = this.mProp.get(this.mView).floatValue();
            this.mProp.set(this.mView, Float.valueOf(this.mEndValue));
            this.mView.setVisibility(this.mFinalVisibility);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.mProp.set(this.mView, Float.valueOf(this.mPausedValue));
            this.mView.setVisibility(0);
        }
    }

    public SlideKitkat(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lbSlide);
        setSlideEdge(obtainStyledAttributes.getInt(R.styleable.lbSlide_lb_slideEdge, 80));
        long j = obtainStyledAttributes.getInt(R.styleable.lbSlide_android_duration, -1);
        if (j >= 0) {
            setDuration(j);
        }
        long j6 = obtainStyledAttributes.getInt(R.styleable.lbSlide_android_startDelay, -1);
        if (j6 > 0) {
            setStartDelay(j6);
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.lbSlide_android_interpolator, 0);
        if (resourceId > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        obtainStyledAttributes.recycle();
    }

    private Animator createAnimation(View view, Property<View, Float> property, float f, float f10, float f11, TimeInterpolator timeInterpolator, int i) {
        float[] fArr = (float[]) view.getTag(R.id.lb_slide_transition_value);
        if (fArr != null) {
            f = View.TRANSLATION_Y == property ? fArr[1] : fArr[0];
            view.setTag(R.id.lb_slide_transition_value, null);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, f, f10);
        SlideAnimatorListener slideAnimatorListener = new SlideAnimatorListener(view, property, f11, f10, i);
        ofFloat.addListener(slideAnimatorListener);
        ofFloat.addPauseListener(slideAnimatorListener);
        ofFloat.setInterpolator(timeInterpolator);
        return ofFloat;
    }

    public int getSlideEdge() {
        return this.mSlideEdge;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i6) {
        View view = transitionValues2 != null ? transitionValues2.view : null;
        if (view == null) {
            return null;
        }
        float here = this.mSlideCalculator.getHere(view);
        return createAnimation(view, this.mSlideCalculator.getProperty(), this.mSlideCalculator.getGone(view), here, here, sDecelerate, 0);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i6) {
        View view = transitionValues != null ? transitionValues.view : null;
        if (view == null) {
            return null;
        }
        float here = this.mSlideCalculator.getHere(view);
        return createAnimation(view, this.mSlideCalculator.getProperty(), here, this.mSlideCalculator.getGone(view), here, sAccelerate, 4);
    }

    public void setSlideEdge(int i) {
        if (i == 3) {
            this.mSlideCalculator = sCalculateLeft;
        } else if (i == 5) {
            this.mSlideCalculator = sCalculateRight;
        } else if (i == 48) {
            this.mSlideCalculator = sCalculateTop;
        } else if (i == 80) {
            this.mSlideCalculator = sCalculateBottom;
        } else if (i == 8388611) {
            this.mSlideCalculator = sCalculateStart;
        } else {
            if (i != 8388613) {
                a.p("Invalid slide direction");
                return;
            }
            this.mSlideCalculator = sCalculateEnd;
        }
        this.mSlideEdge = i;
    }

    public SlideKitkat() {
        setSlideEdge(80);
    }
}
