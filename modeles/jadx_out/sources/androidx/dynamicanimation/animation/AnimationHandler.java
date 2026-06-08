package androidx.dynamicanimation.animation;

import android.animation.ValueAnimator;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.SimpleArrayMap;
import androidx.dynamicanimation.animation.AnimationHandler;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class AnimationHandler {
    private static final ThreadLocal<AnimationHandler> sAnimatorHandler = new ThreadLocal<>();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public DurationScaleChangeListener mDurationScaleChangeListener;
    private FrameCallbackScheduler mScheduler;
    private final SimpleArrayMap<AnimationFrameCallback, Long> mDelayedCallbackStartTime = new SimpleArrayMap<>();
    final ArrayList<AnimationFrameCallback> mAnimationCallbacks = new ArrayList<>();
    private final AnimationCallbackDispatcher mCallbackDispatcher = new AnimationCallbackDispatcher();
    private final Runnable mRunnable = new Runnable() { // from class: androidx.dynamicanimation.animation.a
        @Override // java.lang.Runnable
        public final void run() {
            AnimationHandler.this.lambda$new$0();
        }
    };
    long mCurrentFrameTime = 0;
    private boolean mListDirty = false;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public float mDurationScale = 1.0f;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public class AnimationCallbackDispatcher {
        private AnimationCallbackDispatcher() {
        }

        public void dispatchAnimationFrame() {
            AnimationHandler.this.mCurrentFrameTime = SystemClock.uptimeMillis();
            AnimationHandler animationHandler = AnimationHandler.this;
            animationHandler.doAnimationFrame(animationHandler.mCurrentFrameTime);
            if (AnimationHandler.this.mAnimationCallbacks.size() > 0) {
                AnimationHandler.this.mScheduler.postFrameCallback(AnimationHandler.this.mRunnable);
            }
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface AnimationFrameCallback {
        boolean doAnimationFrame(long j);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting
    public interface DurationScaleChangeListener {
        boolean register();

        boolean unregister();
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @VisibleForTesting
    @RequiresApi(api = 33)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public class DurationScaleChangeListener33 implements DurationScaleChangeListener {
        ValueAnimator.DurationScaleChangeListener mListener;

        public DurationScaleChangeListener33() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$register$0(float f) {
            AnimationHandler.this.mDurationScale = f;
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.DurationScaleChangeListener
        public boolean register() {
            if (this.mListener != null) {
                return true;
            }
            ValueAnimator.DurationScaleChangeListener durationScaleChangeListener = new ValueAnimator.DurationScaleChangeListener() { // from class: androidx.dynamicanimation.animation.b
                @Override // android.animation.ValueAnimator.DurationScaleChangeListener
                public final void onChanged(float f) {
                    AnimationHandler.DurationScaleChangeListener33.this.lambda$register$0(f);
                }
            };
            this.mListener = durationScaleChangeListener;
            return ValueAnimator.registerDurationScaleChangeListener(durationScaleChangeListener);
        }

        @Override // androidx.dynamicanimation.animation.AnimationHandler.DurationScaleChangeListener
        public boolean unregister() {
            boolean unregisterDurationScaleChangeListener = ValueAnimator.unregisterDurationScaleChangeListener(this.mListener);
            this.mListener = null;
            return unregisterDurationScaleChangeListener;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class FrameCallbackScheduler16 implements FrameCallbackScheduler {
        private final Choreographer mChoreographer = Choreographer.getInstance();
        private final Looper mLooper = Looper.myLooper();

        @Override // androidx.dynamicanimation.animation.FrameCallbackScheduler
        public boolean isCurrentThread() {
            return Thread.currentThread() == this.mLooper.getThread();
        }

        @Override // androidx.dynamicanimation.animation.FrameCallbackScheduler
        public void postFrameCallback(final Runnable runnable) {
            this.mChoreographer.postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.dynamicanimation.animation.c
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j) {
                    runnable.run();
                }
            });
        }
    }

    public AnimationHandler(FrameCallbackScheduler frameCallbackScheduler) {
        this.mScheduler = frameCallbackScheduler;
    }

    private void cleanUpList() {
        ArrayList<AnimationFrameCallback> arrayList;
        if (this.mListDirty) {
            int size = this.mAnimationCallbacks.size();
            while (true) {
                size--;
                arrayList = this.mAnimationCallbacks;
                if (size < 0) {
                    break;
                } else if (arrayList.get(size) == null) {
                    this.mAnimationCallbacks.remove(size);
                }
            }
            if (arrayList.size() == 0 && Build.VERSION.SDK_INT >= 33) {
                this.mDurationScaleChangeListener.unregister();
            }
            this.mListDirty = false;
        }
    }

    public static AnimationHandler getInstance() {
        ThreadLocal<AnimationHandler> threadLocal = sAnimatorHandler;
        if (threadLocal.get() == null) {
            threadLocal.set(new AnimationHandler(new FrameCallbackScheduler16()));
        }
        return threadLocal.get();
    }

    private boolean isCallbackDue(AnimationFrameCallback animationFrameCallback, long j) {
        Long l10 = this.mDelayedCallbackStartTime.get(animationFrameCallback);
        if (l10 == null) {
            return true;
        }
        if (l10.longValue() >= j) {
            return false;
        }
        this.mDelayedCallbackStartTime.remove(animationFrameCallback);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        this.mCallbackDispatcher.dispatchAnimationFrame();
    }

    public void addAnimationFrameCallback(AnimationFrameCallback animationFrameCallback, long j) {
        if (this.mAnimationCallbacks.size() == 0) {
            this.mScheduler.postFrameCallback(this.mRunnable);
            if (Build.VERSION.SDK_INT >= 33) {
                this.mDurationScale = ValueAnimator.getDurationScale();
                if (this.mDurationScaleChangeListener == null) {
                    this.mDurationScaleChangeListener = new DurationScaleChangeListener33();
                }
                this.mDurationScaleChangeListener.register();
            }
        }
        if (!this.mAnimationCallbacks.contains(animationFrameCallback)) {
            this.mAnimationCallbacks.add(animationFrameCallback);
        }
        if (j > 0) {
            this.mDelayedCallbackStartTime.put(animationFrameCallback, Long.valueOf(SystemClock.uptimeMillis() + j));
        }
    }

    public void doAnimationFrame(long j) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i = 0; i < this.mAnimationCallbacks.size(); i++) {
            AnimationFrameCallback animationFrameCallback = this.mAnimationCallbacks.get(i);
            if (animationFrameCallback != null && isCallbackDue(animationFrameCallback, uptimeMillis)) {
                animationFrameCallback.doAnimationFrame(j);
            }
        }
        cleanUpList();
    }

    @VisibleForTesting
    public float getDurationScale() {
        return this.mDurationScale;
    }

    public FrameCallbackScheduler getScheduler() {
        return this.mScheduler;
    }

    public boolean isCurrentThread() {
        return this.mScheduler.isCurrentThread();
    }

    public void removeCallback(AnimationFrameCallback animationFrameCallback) {
        this.mDelayedCallbackStartTime.remove(animationFrameCallback);
        int indexOf = this.mAnimationCallbacks.indexOf(animationFrameCallback);
        if (indexOf >= 0) {
            this.mAnimationCallbacks.set(indexOf, null);
            this.mListDirty = true;
        }
    }
}
