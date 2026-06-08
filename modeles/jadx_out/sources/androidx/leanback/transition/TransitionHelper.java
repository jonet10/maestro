package androidx.leanback.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Rect;
import android.transition.AutoTransition;
import android.transition.ChangeTransform;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TransitionHelper {
    public static final int FADE_IN = 1;
    public static final int FADE_OUT = 2;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class TransitionStub {
    }

    private TransitionHelper() {
    }

    @SuppressLint({"ReferencesDeprecated"})
    public static void addSharedElement(FragmentTransaction fragmentTransaction, View view, String str) {
        fragmentTransaction.addSharedElement(view, str);
    }

    public static void addTarget(Object obj, View view) {
        ((Transition) obj).addTarget(view);
    }

    public static void addTransition(Object obj, Object obj2) {
        ((TransitionSet) obj).addTransition((Transition) obj2);
    }

    public static void addTransitionListener(Object obj, final TransitionListener transitionListener) {
        if (transitionListener == null) {
            return;
        }
        Transition.TransitionListener transitionListener2 = new Transition.TransitionListener() { // from class: androidx.leanback.transition.TransitionHelper.1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                TransitionListener.this.onTransitionCancel(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                TransitionListener.this.onTransitionEnd(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                TransitionListener.this.onTransitionPause(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                TransitionListener.this.onTransitionResume(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                TransitionListener.this.onTransitionStart(transition);
            }
        };
        transitionListener.mImpl = transitionListener2;
        ((Transition) obj).addListener(transitionListener2);
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static Object createAutoTransition() {
        return new AutoTransition();
    }

    public static Object createChangeBounds(boolean z9) {
        CustomChangeBounds customChangeBounds = new CustomChangeBounds();
        customChangeBounds.setReparent(z9);
        return customChangeBounds;
    }

    public static Object createChangeTransform() {
        return new ChangeTransform();
    }

    public static Object createDefaultInterpolator(Context context) {
        return AnimationUtils.loadInterpolator(context, 17563663);
    }

    public static Object createFadeAndShortSlide(int i, float f) {
        FadeAndShortSlide fadeAndShortSlide = new FadeAndShortSlide(i);
        fadeAndShortSlide.setDistance(f);
        return fadeAndShortSlide;
    }

    public static Object createFadeTransition(int i) {
        return new Fade(i);
    }

    public static Object createScale() {
        return new ChangeTransform();
    }

    public static Object createScene(ViewGroup viewGroup, Runnable runnable) {
        Scene scene = new Scene(viewGroup);
        scene.setEnterAction(runnable);
        return scene;
    }

    public static Object createSlide(int i) {
        SlideKitkat slideKitkat = new SlideKitkat();
        slideKitkat.setSlideEdge(i);
        return slideKitkat;
    }

    public static Object createTransitionSet(boolean z9) {
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(z9 ? 1 : 0);
        return transitionSet;
    }

    public static void exclude(Object obj, int i, boolean z9) {
        ((Transition) obj).excludeTarget(i, z9);
    }

    public static void excludeChildren(Object obj, int i, boolean z9) {
        ((Transition) obj).excludeChildren(i, z9);
    }

    public static Object getEnterTransition(Window window) {
        return window.getEnterTransition();
    }

    public static Object getExitTransition(Window window) {
        return window.getExitTransition();
    }

    public static Object getReenterTransition(Window window) {
        return window.getReenterTransition();
    }

    public static Object getReturnTransition(Window window) {
        return window.getReturnTransition();
    }

    public static Object getSharedElementEnterTransition(Window window) {
        return window.getSharedElementEnterTransition();
    }

    public static Object getSharedElementExitTransition(Window window) {
        return window.getSharedElementExitTransition();
    }

    public static Object getSharedElementReenterTransition(Window window) {
        return window.getSharedElementReenterTransition();
    }

    public static Object getSharedElementReturnTransition(Window window) {
        return window.getSharedElementReturnTransition();
    }

    public static void include(Object obj, int i) {
        ((Transition) obj).addTarget(i);
    }

    public static Object loadTransition(Context context, int i) {
        return TransitionInflater.from(context).inflateTransition(i);
    }

    public static void removeTransitionListener(Object obj, TransitionListener transitionListener) {
        Object obj2;
        if (transitionListener == null || (obj2 = transitionListener.mImpl) == null) {
            return;
        }
        ((Transition) obj).removeListener((Transition.TransitionListener) obj2);
        transitionListener.mImpl = null;
    }

    public static void runTransition(Object obj, Object obj2) {
        TransitionManager.go((Scene) obj, (Transition) obj2);
    }

    public static void setChangeBoundsDefaultStartDelay(Object obj, int i) {
        ((CustomChangeBounds) obj).setDefaultStartDelay(i);
    }

    public static void setChangeBoundsStartDelay(Object obj, View view, int i) {
        ((CustomChangeBounds) obj).setStartDelay(view, i);
    }

    public static void setDuration(Object obj, long j) {
        ((Transition) obj).setDuration(j);
    }

    public static void setEnterTransition(Window window, Object obj) {
        window.setEnterTransition((Transition) obj);
    }

    public static void setEpicenterCallback(Object obj, final TransitionEpicenterCallback transitionEpicenterCallback) {
        if (transitionEpicenterCallback == null) {
            ((Transition) obj).setEpicenterCallback(null);
        } else {
            ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() { // from class: androidx.leanback.transition.TransitionHelper.2
                @Override // android.transition.Transition.EpicenterCallback
                public Rect onGetEpicenter(Transition transition) {
                    return TransitionEpicenterCallback.this.onGetEpicenter(transition);
                }
            });
        }
    }

    @SuppressLint({"ReferencesDeprecated"})
    public static void setExitTransition(Fragment fragment, Object obj) {
        fragment.setExitTransition((Transition) obj);
    }

    public static void setInterpolator(Object obj, Object obj2) {
        ((Transition) obj).setInterpolator((TimeInterpolator) obj2);
    }

    public static void setReturnTransition(Window window, Object obj) {
        window.setReturnTransition((Transition) obj);
    }

    public static void setSharedElementEnterTransition(Window window, Object obj) {
        window.setSharedElementEnterTransition((Transition) obj);
    }

    public static void setSharedElementReturnTransition(Window window, Object obj) {
        window.setSharedElementReturnTransition((Transition) obj);
    }

    public static void setStartDelay(Object obj, long j) {
        ((Transition) obj).setStartDelay(j);
    }

    public static void setTransitionGroup(ViewGroup viewGroup, boolean z9) {
        viewGroup.setTransitionGroup(z9);
    }

    public static boolean systemSupportsEntranceTransitions() {
        return true;
    }

    public static void exclude(Object obj, View view, boolean z9) {
        ((Transition) obj).excludeTarget(view, z9);
    }

    public static void excludeChildren(Object obj, View view, boolean z9) {
        ((Transition) obj).excludeChildren(view, z9);
    }

    public static void include(Object obj, View view) {
        ((Transition) obj).addTarget(view);
    }

    public static void setChangeBoundsStartDelay(Object obj, int i, int i6) {
        ((CustomChangeBounds) obj).setStartDelay(i, i6);
    }

    @SuppressLint({"ReferencesDeprecated"})
    public static void setEnterTransition(Fragment fragment, Object obj) {
        fragment.setEnterTransition((Transition) obj);
    }

    @SuppressLint({"ReferencesDeprecated"})
    public static void setSharedElementEnterTransition(Fragment fragment, Object obj) {
        fragment.setSharedElementEnterTransition((Transition) obj);
    }

    public static void setChangeBoundsStartDelay(Object obj, String str, int i) {
        ((CustomChangeBounds) obj).setStartDelay(str, i);
    }

    public static Object createFadeAndShortSlide(int i) {
        return new FadeAndShortSlide(i);
    }
}
