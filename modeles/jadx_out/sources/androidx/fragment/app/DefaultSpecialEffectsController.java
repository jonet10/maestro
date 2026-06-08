package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class AnimationInfo extends SpecialEffectsInfo {

        @Nullable
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        public AnimationInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z9) {
            super(operation, cancellationSignal);
            this.mLoadedAnim = false;
            this.mIsPop = z9;
        }

        @Nullable
        public FragmentAnim.AnimationOrAnimator getAnimation(@NonNull Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.mIsPop);
            this.mAnimation = loadAnimation;
            this.mLoadedAnim = true;
            return loadAnimation;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class SpecialEffectsInfo {

        @NonNull
        private final SpecialEffectsController.Operation mOperation;

        @NonNull
        private final CancellationSignal mSignal;

        public SpecialEffectsInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        public void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        @NonNull
        public SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        @NonNull
        public CancellationSignal getSignal() {
            return this.mSignal;
        }

        public boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            if (from == finalState) {
                return true;
            }
            SpecialEffectsController.Operation.State state = SpecialEffectsController.Operation.State.VISIBLE;
            return (from == state || finalState == state) ? false : true;
        }
    }

    public DefaultSpecialEffectsController(@NonNull ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(@NonNull List<AnimationInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z9, @NonNull Map<SpecialEffectsController.Operation, Boolean> map) {
        final SpecialEffectsController.Operation operation;
        final AnimationInfo animationInfo;
        final View view;
        final ViewGroup container = getContainer();
        Context context = container.getContext();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z10 = false;
        for (final AnimationInfo animationInfo2 : list) {
            if (animationInfo2.isVisibilityUnchanged()) {
                animationInfo2.completeSpecialEffect();
            } else {
                FragmentAnim.AnimationOrAnimator animation = animationInfo2.getAnimation(context);
                if (animation == null) {
                    animationInfo2.completeSpecialEffect();
                } else {
                    final Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(animationInfo2);
                    } else {
                        final SpecialEffectsController.Operation operation2 = animationInfo2.getOperation();
                        Fragment fragment = operation2.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation2))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            animationInfo2.completeSpecialEffect();
                        } else {
                            final boolean z11 = operation2.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                            if (z11) {
                                list2.remove(operation2);
                            }
                            final View view2 = fragment.mView;
                            container.startViewTransition(view2);
                            final ViewGroup viewGroup = container;
                            container = viewGroup;
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.2
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator2) {
                                    viewGroup.endViewTransition(view2);
                                    if (z11) {
                                        operation2.getFinalState().applyState(view2);
                                    }
                                    animationInfo2.completeSpecialEffect();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v(FragmentManager.TAG, "Animator from operation " + operation2 + " has ended.");
                                    }
                                }
                            });
                            animator.setTarget(view2);
                            animator.start();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Animator from operation " + operation2 + " has started.");
                            }
                            animationInfo2.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.3
                                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                                public void onCancel() {
                                    animator.end();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v(FragmentManager.TAG, "Animator from operation " + operation2 + " has been canceled.");
                                    }
                                }
                            });
                            z10 = true;
                        }
                    }
                }
            }
        }
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            AnimationInfo animationInfo3 = (AnimationInfo) obj;
            SpecialEffectsController.Operation operation3 = animationInfo3.getOperation();
            Fragment fragment2 = operation3.getFragment();
            if (z9) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo3.completeSpecialEffect();
            } else if (z10) {
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo3.completeSpecialEffect();
            } else {
                View view3 = fragment2.mView;
                Animation animation2 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(animationInfo3.getAnimation(context))).animation);
                if (operation3.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view3.startAnimation(animation2);
                    animationInfo3.completeSpecialEffect();
                    operation = operation3;
                    animationInfo = animationInfo3;
                    view = view3;
                } else {
                    container.startViewTransition(view3);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, container, view3);
                    operation = operation3;
                    animationInfo = animationInfo3;
                    view = view3;
                    endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation3) {
                            container.post(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    container.endViewTransition(view);
                                    animationInfo.completeSpecialEffect();
                                }
                            });
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Animation from operation " + operation + " has ended.");
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation3) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Animation from operation " + operation + " has reached onAnimationStart.");
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation3) {
                        }
                    });
                    view.startAnimation(endViewTransitionAnimation);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Animation from operation " + operation + " has started.");
                    }
                }
                CancellationSignal signal = animationInfo.getSignal();
                final AnimationInfo animationInfo4 = animationInfo;
                final SpecialEffectsController.Operation operation4 = operation;
                final View view4 = view;
                signal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.5
                    @Override // androidx.core.os.CancellationSignal.OnCancelListener
                    public void onCancel() {
                        view4.clearAnimation();
                        container.endViewTransition(view4);
                        animationInfo4.completeSpecialEffect();
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v(FragmentManager.TAG, "Animation from operation " + operation4 + " has been cancelled.");
                        }
                    }
                });
            }
        }
    }

    @NonNull
    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(@NonNull List<TransitionInfo> list, @NonNull List<SpecialEffectsController.Operation> list2, boolean z9, @Nullable SpecialEffectsController.Operation operation, @Nullable SpecialEffectsController.Operation operation2) {
        String str;
        View view;
        ArrayList<View> arrayList;
        String str2;
        ArrayList<View> arrayList2;
        String str3;
        Object obj;
        Object obj2;
        ArrayList arrayList3;
        View view2;
        View view3;
        ArrayList<View> arrayList4;
        Object obj3;
        HashMap hashMap;
        boolean z10;
        SpecialEffectsController.Operation operation3;
        View view4;
        ArrayList<View> arrayList5;
        ArrayMap arrayMap;
        ArrayList<View> arrayList6;
        HashMap hashMap2;
        Rect rect;
        SharedElementCallback enterTransitionCallback;
        SharedElementCallback exitTransitionCallback;
        Rect rect2;
        int i;
        final Rect rect3;
        final View view5;
        String findKeyForValue;
        int i6;
        final boolean z11 = z9;
        final SpecialEffectsController.Operation operation4 = operation;
        final SpecialEffectsController.Operation operation5 = operation2;
        HashMap hashMap3 = new HashMap();
        final FragmentTransitionImpl fragmentTransitionImpl = null;
        for (TransitionInfo transitionInfo : list) {
            if (!transitionInfo.isVisibilityUnchanged()) {
                FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
                if (fragmentTransitionImpl == null) {
                    fragmentTransitionImpl = handlingImpl;
                } else if (handlingImpl != null && fragmentTransitionImpl != handlingImpl) {
                    StringBuilder sb = new StringBuilder("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                    sb.append(transitionInfo.getOperation().getFragment());
                    Object transition = transitionInfo.getTransition();
                    sb.append(" returned Transition ");
                    sb.append(transition);
                    sb.append(" which uses a different Transition  type than other Fragments.");
                    throw new IllegalArgumentException(sb.toString());
                }
            }
        }
        if (fragmentTransitionImpl == null) {
            for (TransitionInfo transitionInfo2 : list) {
                hashMap3.put(transitionInfo2.getOperation(), Boolean.FALSE);
                transitionInfo2.completeSpecialEffect();
            }
            return hashMap3;
        }
        View view6 = new View(getContainer().getContext());
        Rect rect4 = new Rect();
        ArrayList<View> arrayList7 = new ArrayList<>();
        ArrayList<View> arrayList8 = new ArrayList<>();
        ArrayMap arrayMap2 = new ArrayMap();
        Iterator<TransitionInfo> it = list.iterator();
        Object obj4 = null;
        View view7 = null;
        boolean z12 = false;
        while (true) {
            boolean hasNext = it.hasNext();
            str = FragmentManager.TAG;
            view = view7;
            if (!hasNext) {
                break;
            }
            TransitionInfo next = it.next();
            if (!next.hasSharedElementTransition() || operation4 == null || operation5 == null) {
                view4 = view6;
                arrayList5 = arrayList7;
                arrayMap = arrayMap2;
                arrayList6 = arrayList8;
                hashMap2 = hashMap3;
                rect = rect4;
            } else {
                Object wrapTransitionInSet = fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(next.getSharedElementTransition()));
                ArrayList<String> sharedElementSourceNames = operation5.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation4.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation4.getFragment().getSharedElementTargetNames();
                HashMap hashMap4 = hashMap3;
                int i10 = 0;
                while (i10 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i10));
                    ArrayList<String> arrayList9 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i10));
                    }
                    i10++;
                    sharedElementTargetNames = arrayList9;
                }
                ArrayList<String> sharedElementTargetNames2 = operation5.getFragment().getSharedElementTargetNames();
                if (z11) {
                    enterTransitionCallback = operation4.getFragment().getEnterTransitionCallback();
                    exitTransitionCallback = operation5.getFragment().getExitTransitionCallback();
                } else {
                    enterTransitionCallback = operation4.getFragment().getExitTransitionCallback();
                    exitTransitionCallback = operation5.getFragment().getEnterTransitionCallback();
                }
                View view8 = view6;
                int i11 = 0;
                for (int size = sharedElementSourceNames.size(); i11 < size; size = size) {
                    arrayMap2.put(sharedElementSourceNames.get(i11), sharedElementTargetNames2.get(i11));
                    i11++;
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v(FragmentManager.TAG, ">>> entering view names <<<");
                    rect2 = rect4;
                    int i12 = 0;
                    for (int size2 = sharedElementTargetNames2.size(); i12 < size2; size2 = size2) {
                        String str4 = sharedElementTargetNames2.get(i12);
                        Log.v(FragmentManager.TAG, "Name: " + str4);
                        i12++;
                    }
                    Log.v(FragmentManager.TAG, ">>> exiting view names <<<");
                    int i13 = 0;
                    for (int size3 = sharedElementSourceNames.size(); i13 < size3; size3 = size3) {
                        String str5 = sharedElementSourceNames.get(i13);
                        Log.v(FragmentManager.TAG, "Name: " + str5);
                        i13++;
                    }
                } else {
                    rect2 = rect4;
                }
                ArrayMap<String, View> arrayMap3 = new ArrayMap<>();
                findNamedViews(arrayMap3, operation4.getFragment().mView);
                arrayMap3.retainAll(sharedElementSourceNames);
                if (enterTransitionCallback != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Executing exit callback for operation " + operation4);
                    }
                    enterTransitionCallback.onMapSharedElements(sharedElementSourceNames, arrayMap3);
                    int size4 = sharedElementSourceNames.size() - 1;
                    while (size4 >= 0) {
                        String str6 = sharedElementSourceNames.get(size4);
                        View view9 = arrayMap3.get(str6);
                        if (view9 == null) {
                            arrayMap2.remove(str6);
                            i6 = size4;
                        } else {
                            i6 = size4;
                            if (!str6.equals(ViewCompat.getTransitionName(view9))) {
                                arrayMap2.put(ViewCompat.getTransitionName(view9), (String) arrayMap2.remove(str6));
                            }
                        }
                        size4 = i6 - 1;
                    }
                } else {
                    arrayMap2.retainAll(arrayMap3.keySet());
                }
                final ArrayMap<String, View> arrayMap4 = new ArrayMap<>();
                findNamedViews(arrayMap4, operation5.getFragment().mView);
                arrayMap4.retainAll(sharedElementTargetNames2);
                arrayMap4.retainAll(arrayMap2.values());
                if (exitTransitionCallback != null) {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v(FragmentManager.TAG, "Executing enter callback for operation " + operation5);
                    }
                    exitTransitionCallback.onMapSharedElements(sharedElementTargetNames2, arrayMap4);
                    for (int size5 = sharedElementTargetNames2.size() - 1; size5 >= 0; size5--) {
                        String str7 = sharedElementTargetNames2.get(size5);
                        View view10 = arrayMap4.get(str7);
                        if (view10 == null) {
                            String findKeyForValue2 = FragmentTransition.findKeyForValue(arrayMap2, str7);
                            if (findKeyForValue2 != null) {
                                arrayMap2.remove(findKeyForValue2);
                            }
                        } else if (!str7.equals(ViewCompat.getTransitionName(view10)) && (findKeyForValue = FragmentTransition.findKeyForValue(arrayMap2, str7)) != null) {
                            arrayMap2.put(findKeyForValue, ViewCompat.getTransitionName(view10));
                        }
                    }
                } else {
                    FragmentTransition.retainValues(arrayMap2, arrayMap4);
                }
                retainMatchingViews(arrayMap3, arrayMap2.keySet());
                retainMatchingViews(arrayMap4, arrayMap2.values());
                if (arrayMap2.isEmpty()) {
                    arrayList7.clear();
                    arrayList8.clear();
                    arrayList5 = arrayList7;
                    arrayMap = arrayMap2;
                    arrayList6 = arrayList8;
                    view7 = view;
                    hashMap2 = hashMap4;
                    view4 = view8;
                    rect = rect2;
                    obj4 = null;
                    z11 = z9;
                    rect4 = rect;
                    arrayList8 = arrayList6;
                    hashMap3 = hashMap2;
                    arrayMap2 = arrayMap;
                    view6 = view4;
                    arrayList7 = arrayList5;
                } else {
                    FragmentTransition.callSharedElementStartEnd(operation5.getFragment(), operation4.getFragment(), z11, arrayMap3, true);
                    OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FragmentTransition.callSharedElementStartEnd(operation5.getFragment(), operation4.getFragment(), z11, arrayMap4, false);
                        }
                    });
                    arrayList7.addAll(arrayMap3.values());
                    if (sharedElementSourceNames.isEmpty()) {
                        i = 0;
                    } else {
                        i = 0;
                        View view11 = arrayMap3.get(sharedElementSourceNames.get(0));
                        fragmentTransitionImpl.setEpicenter(wrapTransitionInSet, view11);
                        view = view11;
                    }
                    arrayList8.addAll(arrayMap4.values());
                    if (sharedElementTargetNames2.isEmpty() || (view5 = arrayMap4.get(sharedElementTargetNames2.get(i))) == null) {
                        rect3 = rect2;
                    } else {
                        rect3 = rect2;
                        OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.7
                            @Override // java.lang.Runnable
                            public void run() {
                                fragmentTransitionImpl.getBoundsOnScreen(view5, rect3);
                            }
                        });
                        z12 = true;
                    }
                    fragmentTransitionImpl.setSharedElementTargets(wrapTransitionInSet, view8, arrayList7);
                    Rect rect5 = rect3;
                    arrayList5 = arrayList7;
                    rect = rect5;
                    arrayMap = arrayMap2;
                    view4 = view8;
                    fragmentTransitionImpl.scheduleRemoveTargets(wrapTransitionInSet, null, null, null, null, wrapTransitionInSet, arrayList8);
                    arrayList6 = arrayList8;
                    Boolean bool = Boolean.TRUE;
                    hashMap2 = hashMap4;
                    hashMap2.put(operation4, bool);
                    hashMap2.put(operation5, bool);
                    obj4 = wrapTransitionInSet;
                }
            }
            view7 = view;
            z11 = z9;
            rect4 = rect;
            arrayList8 = arrayList6;
            hashMap3 = hashMap2;
            arrayMap2 = arrayMap;
            view6 = view4;
            arrayList7 = arrayList5;
        }
        ArrayList<View> arrayList10 = arrayList7;
        HashMap hashMap5 = hashMap3;
        Rect rect6 = rect4;
        ArrayList<View> arrayList11 = arrayList10;
        View view12 = view6;
        ArrayMap arrayMap5 = arrayMap2;
        ArrayList<View> arrayList12 = arrayList8;
        boolean z13 = true;
        ArrayList arrayList13 = new ArrayList();
        Object obj5 = null;
        Object obj6 = null;
        for (TransitionInfo transitionInfo3 : list) {
            if (transitionInfo3.isVisibilityUnchanged()) {
                hashMap5.put(transitionInfo3.getOperation(), Boolean.FALSE);
                transitionInfo3.completeSpecialEffect();
                z13 = true;
            } else {
                Object cloneTransition = fragmentTransitionImpl.cloneTransition(transitionInfo3.getTransition());
                SpecialEffectsController.Operation operation6 = transitionInfo3.getOperation();
                boolean z14 = obj4 != null && (operation6 == operation4 || operation6 == operation5);
                if (cloneTransition == null) {
                    if (!z14) {
                        hashMap5.put(operation6, Boolean.FALSE);
                        transitionInfo3.completeSpecialEffect();
                    }
                    view2 = view12;
                    str3 = str;
                    arrayList2 = arrayList11;
                    hashMap = hashMap5;
                    arrayList3 = arrayList13;
                    view3 = view;
                    z10 = true;
                    arrayList4 = arrayList12;
                } else {
                    HashMap hashMap6 = hashMap5;
                    final ArrayList<View> arrayList14 = new ArrayList<>();
                    ArrayList arrayList15 = arrayList13;
                    captureTransitioningViews(arrayList14, operation6.getFragment().mView);
                    if (z14) {
                        if (operation6 == operation4) {
                            arrayList14.removeAll(arrayList11);
                        } else {
                            arrayList14.removeAll(arrayList12);
                        }
                    }
                    if (arrayList14.isEmpty()) {
                        fragmentTransitionImpl.addTarget(cloneTransition, view12);
                        view2 = view12;
                        str3 = str;
                        arrayList2 = arrayList11;
                        operation3 = operation6;
                        obj2 = obj5;
                        obj = obj6;
                        view3 = view;
                        arrayList3 = arrayList15;
                        arrayList4 = arrayList12;
                        obj3 = cloneTransition;
                        hashMap = hashMap6;
                        z10 = true;
                    } else {
                        fragmentTransitionImpl.addTargets(cloneTransition, arrayList14);
                        arrayList2 = arrayList11;
                        str3 = str;
                        obj = obj6;
                        obj2 = obj5;
                        arrayList3 = arrayList15;
                        view2 = view12;
                        view3 = view;
                        arrayList4 = arrayList12;
                        obj3 = cloneTransition;
                        hashMap = hashMap6;
                        z10 = true;
                        fragmentTransitionImpl.scheduleRemoveTargets(obj3, cloneTransition, arrayList14, null, null, null, null);
                        if (operation6.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            operation3 = operation6;
                            list2.remove(operation3);
                            ArrayList<View> arrayList16 = new ArrayList<>(arrayList14);
                            arrayList16.remove(operation3.getFragment().mView);
                            fragmentTransitionImpl.scheduleHideFragmentView(obj3, operation3.getFragment().mView, arrayList16);
                            OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    FragmentTransition.setViewVisibility(arrayList14, 4);
                                }
                            });
                        } else {
                            operation3 = operation6;
                        }
                    }
                    if (operation3.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList3.addAll(arrayList14);
                        if (z12) {
                            fragmentTransitionImpl.setEpicenter(obj3, rect6);
                        }
                    } else {
                        fragmentTransitionImpl.setEpicenter(obj3, view3);
                    }
                    hashMap.put(operation3, Boolean.TRUE);
                    if (transitionInfo3.isOverlapAllowed()) {
                        obj2 = fragmentTransitionImpl.mergeTransitionsTogether(obj2, obj3, null);
                    } else {
                        obj = fragmentTransitionImpl.mergeTransitionsTogether(obj, obj3, null);
                    }
                    obj5 = obj2;
                    obj6 = obj;
                }
                operation4 = operation;
                operation5 = operation2;
                hashMap5 = hashMap;
                arrayList13 = arrayList3;
                arrayList12 = arrayList4;
                str = str3;
                z13 = z10;
                arrayList11 = arrayList2;
                view = view3;
                view12 = view2;
            }
        }
        String str8 = str;
        ArrayList<View> arrayList17 = arrayList12;
        ArrayList<View> arrayList18 = arrayList11;
        HashMap hashMap7 = hashMap5;
        ArrayList arrayList19 = arrayList13;
        boolean z15 = z13;
        Object mergeTransitionsInSequence = fragmentTransitionImpl.mergeTransitionsInSequence(obj5, obj6, obj4);
        if (mergeTransitionsInSequence == null) {
            return hashMap7;
        }
        for (final TransitionInfo transitionInfo4 : list) {
            if (!transitionInfo4.isVisibilityUnchanged()) {
                Object transition2 = transitionInfo4.getTransition();
                final SpecialEffectsController.Operation operation7 = transitionInfo4.getOperation();
                boolean z16 = (obj4 == null || !(operation7 == operation || operation7 == operation2)) ? false : z15;
                if (transition2 == null && !z16) {
                    str2 = str8;
                } else if (ViewCompat.isLaidOut(getContainer())) {
                    str2 = str8;
                    fragmentTransitionImpl.setListenerForTransitionEnd(transitionInfo4.getOperation().getFragment(), mergeTransitionsInSequence, transitionInfo4.getSignal(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.9
                        @Override // java.lang.Runnable
                        public void run() {
                            transitionInfo4.completeSpecialEffect();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v(FragmentManager.TAG, "Transition for operation " + operation7 + "has completed");
                            }
                        }
                    });
                } else {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        str2 = str8;
                        Log.v(str2, "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + operation7);
                    } else {
                        str2 = str8;
                    }
                    transitionInfo4.completeSpecialEffect();
                }
                str8 = str2;
            }
        }
        String str9 = str8;
        if (!ViewCompat.isLaidOut(getContainer())) {
            return hashMap7;
        }
        FragmentTransition.setViewVisibility(arrayList19, 4);
        ArrayList<String> prepareSetNameOverridesReordered = fragmentTransitionImpl.prepareSetNameOverridesReordered(arrayList17);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(str9, ">>>>> Beginning transition <<<<<");
            Log.v(str9, ">>>>> SharedElementFirstOutViews <<<<<");
            int size6 = arrayList18.size();
            int i14 = 0;
            while (i14 < size6) {
                View view13 = arrayList18.get(i14);
                i14++;
                View view14 = view13;
                Log.v(str9, "View: " + view14 + " Name: " + ViewCompat.getTransitionName(view14));
            }
            arrayList = arrayList18;
            Log.v(str9, ">>>>> SharedElementLastInViews <<<<<");
            int size7 = arrayList17.size();
            int i15 = 0;
            while (i15 < size7) {
                View view15 = arrayList17.get(i15);
                i15++;
                View view16 = view15;
                Log.v(str9, "View: " + view16 + " Name: " + ViewCompat.getTransitionName(view16));
            }
        } else {
            arrayList = arrayList18;
        }
        fragmentTransitionImpl.beginDelayedTransition(getContainer(), mergeTransitionsInSequence);
        fragmentTransitionImpl.setNameOverridesReordered(getContainer(), arrayList, arrayList17, prepareSetNameOverridesReordered, arrayMap5);
        FragmentTransition.setViewVisibility(arrayList19, 0);
        fragmentTransitionImpl.swapSharedElementTargets(obj4, arrayList, arrayList17);
        return hashMap7;
    }

    private void syncAnimations(@NonNull List<SpecialEffectsController.Operation> list) {
        Fragment fragment = list.get(list.size() - 1).getFragment();
        for (SpecialEffectsController.Operation operation : list) {
            operation.getFragment().mAnimationInfo.mEnterAnim = fragment.mAnimationInfo.mEnterAnim;
            operation.getFragment().mAnimationInfo.mExitAnim = fragment.mAnimationInfo.mExitAnim;
            operation.getFragment().mAnimationInfo.mPopEnterAnim = fragment.mAnimationInfo.mPopEnterAnim;
            operation.getFragment().mAnimationInfo.mPopExitAnim = fragment.mAnimationInfo.mPopExitAnim;
        }
    }

    public void applyContainerChanges(@NonNull SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    public void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                captureTransitioningViews(arrayList, childAt);
            }
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    public void executeOperations(@NonNull List<SpecialEffectsController.Operation> list, boolean z9) {
        int i;
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation operation3 : list) {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(operation3.getFragment().mView);
            int i6 = AnonymousClass10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[operation3.getFinalState().ordinal()];
            if (i6 == 1 || i6 == 2 || i6 == 3) {
                if (from == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                    operation = operation3;
                }
            } else if (i6 == 4 && from != SpecialEffectsController.Operation.State.VISIBLE) {
                operation2 = operation3;
            }
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Executing operations from " + operation + " to " + operation2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList(list);
        syncAnimations(list);
        Iterator<SpecialEffectsController.Operation> it = list.iterator();
        while (true) {
            i = 0;
            r11 = false;
            boolean z10 = false;
            if (!it.hasNext()) {
                break;
            }
            final SpecialEffectsController.Operation next = it.next();
            CancellationSignal cancellationSignal = new CancellationSignal();
            next.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new AnimationInfo(next, cancellationSignal, z9));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            next.markStartedSpecialEffect(cancellationSignal2);
            if (z9) {
                if (next != operation) {
                    arrayList2.add(new TransitionInfo(next, cancellationSignal2, z9, z10));
                    next.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(next)) {
                                arrayList3.remove(next);
                                DefaultSpecialEffectsController.this.applyContainerChanges(next);
                            }
                        }
                    });
                }
                z10 = true;
                arrayList2.add(new TransitionInfo(next, cancellationSignal2, z9, z10));
                next.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(next)) {
                            arrayList3.remove(next);
                            DefaultSpecialEffectsController.this.applyContainerChanges(next);
                        }
                    }
                });
            } else {
                if (next != operation2) {
                    arrayList2.add(new TransitionInfo(next, cancellationSignal2, z9, z10));
                    next.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(next)) {
                                arrayList3.remove(next);
                                DefaultSpecialEffectsController.this.applyContainerChanges(next);
                            }
                        }
                    });
                }
                z10 = true;
                arrayList2.add(new TransitionInfo(next, cancellationSignal2, z9, z10));
                next.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(next)) {
                            arrayList3.remove(next);
                            DefaultSpecialEffectsController.this.applyContainerChanges(next);
                        }
                    }
                });
            }
        }
        Map<SpecialEffectsController.Operation, Boolean> startTransitions = startTransitions(arrayList2, arrayList3, z9, operation, operation2);
        startAnimations(arrayList, arrayList3, startTransitions.containsValue(Boolean.TRUE), startTransitions);
        int size = arrayList3.size();
        while (i < size) {
            Object obj = arrayList3.get(i);
            i++;
            applyContainerChanges((SpecialEffectsController.Operation) obj);
        }
        arrayList3.clear();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(FragmentManager.TAG, "Completed executing operations from " + operation + " to " + operation2);
        }
    }

    public void findNamedViews(Map<String, View> map, @NonNull View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    public void retainMatchingViews(@NonNull ArrayMap<String, View> arrayMap, @NonNull Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;

        @Nullable
        private final Object mSharedElementTransition;

        @Nullable
        private final Object mTransition;

        public TransitionInfo(@NonNull SpecialEffectsController.Operation operation, @NonNull CancellationSignal cancellationSignal, boolean z9, boolean z10) {
            super(operation, cancellationSignal);
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                this.mTransition = z9 ? operation.getFragment().getReenterTransition() : operation.getFragment().getEnterTransition();
                this.mOverlapAllowed = z9 ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap();
            } else {
                this.mTransition = z9 ? operation.getFragment().getReturnTransition() : operation.getFragment().getExitTransition();
                this.mOverlapAllowed = true;
            }
            if (!z10) {
                this.mSharedElementTransition = null;
            } else if (z9) {
                this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        @Nullable
        public FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            StringBuilder sb = new StringBuilder("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
            sb.append(getOperation().getFragment());
            sb.append(" returned Transition ");
            sb.append(this.mTransition);
            Object obj = this.mSharedElementTransition;
            sb.append(" which uses a different Transition  type than its shared element transition ");
            sb.append(obj);
            throw new IllegalArgumentException(sb.toString());
        }

        @Nullable
        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        @Nullable
        public Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        public boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        @Nullable
        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            StringBuilder sb = new StringBuilder("Transition ");
            sb.append(obj);
            Fragment fragment = getOperation().getFragment();
            sb.append(" for fragment ");
            sb.append(fragment);
            sb.append(" is not a valid framework Transition or AndroidX Transition");
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
