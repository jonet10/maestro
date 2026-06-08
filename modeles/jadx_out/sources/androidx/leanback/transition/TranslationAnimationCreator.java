package androidx.leanback.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.Property;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.leanback.R;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class TranslationAnimationCreator {
    private TranslationAnimationCreator() {
    }

    public static Animator createAnimation(View view, TransitionValues transitionValues, int i, int i6, float f, float f10, float f11, float f12, TimeInterpolator timeInterpolator, Transition transition) {
        float f13 = f10;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        if (((int[]) transitionValues.view.getTag(R.id.transitionPosition)) != null) {
            f = (r2[0] - i) + translationX;
            f13 = (r2[1] - i6) + translationY;
        }
        int round = Math.round(f - translationX) + i;
        int round2 = Math.round(f13 - translationY) + i6;
        view.setTranslationX(f);
        view.setTranslationY(f13);
        if (f == f11 && f13 == f12) {
            return null;
        }
        Path path = new Path();
        path.moveTo(f, f13);
        path.lineTo(f11, f12);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_X, (Property<View, Float>) View.TRANSLATION_Y, path);
        TransitionPositionListener transitionPositionListener = new TransitionPositionListener(view, transitionValues.view, round, round2, translationX, translationY);
        transition.addListener(transitionPositionListener);
        ofFloat.addListener(transitionPositionListener);
        ofFloat.addPauseListener(transitionPositionListener);
        ofFloat.setInterpolator(timeInterpolator);
        return ofFloat;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class TransitionPositionListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        private final View mMovingView;
        private float mPausedX;
        private float mPausedY;
        private final int mStartX;
        private final int mStartY;
        private final float mTerminalX;
        private final float mTerminalY;
        private int[] mTransitionPosition;
        private final View mViewInHierarchy;

        public TransitionPositionListener(View view, View view2, int i, int i6, float f, float f10) {
            this.mMovingView = view;
            this.mViewInHierarchy = view2;
            this.mStartX = i - Math.round(view.getTranslationX());
            this.mStartY = i6 - Math.round(view.getTranslationY());
            this.mTerminalX = f;
            this.mTerminalY = f10;
            int[] iArr = (int[]) view2.getTag(R.id.transitionPosition);
            this.mTransitionPosition = iArr;
            if (iArr != null) {
                view2.setTag(R.id.transitionPosition, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.mTransitionPosition == null) {
                this.mTransitionPosition = new int[2];
            }
            this.mTransitionPosition[0] = Math.round(this.mMovingView.getTranslationX() + this.mStartX);
            this.mTransitionPosition[1] = Math.round(this.mMovingView.getTranslationY() + this.mStartY);
            this.mViewInHierarchy.setTag(R.id.transitionPosition, this.mTransitionPosition);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }
    }
}
