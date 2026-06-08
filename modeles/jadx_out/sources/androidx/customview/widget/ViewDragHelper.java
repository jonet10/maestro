package androidx.customview.widget;

import a3.b;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.google.gson.internal.a;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = new Interpolator() { // from class: androidx.customview.widget.ViewDragHelper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f10 = f - 1.0f;
            return (f10 * f10 * f10 * f10 * f10) + 1.0f;
        }
    };
    private final Callback mCallback;
    private View mCapturedView;
    private final int mDefaultEdgeSize;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private OverScroller mScroller;
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;
    private int mActivePointerId = -1;
    private final Runnable mSetIdleRunnable = new Runnable() { // from class: androidx.customview.widget.ViewDragHelper.2
        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.setDragState(0);
        }
    };

    private ViewDragHelper(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        if (viewGroup == null) {
            a.p("Parent view may not be null");
            throw null;
        }
        if (callback == null) {
            a.p("Callback may not be null");
            throw null;
        }
        this.mParentView = viewGroup;
        this.mCallback = callback;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.mDefaultEdgeSize = i;
        this.mEdgeSize = i;
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMaxVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mMinVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mScroller = new OverScroller(context, sInterpolator);
    }

    private boolean checkNewEdgeDrag(float f, float f10, int i, int i6) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f10);
        if ((this.mInitialEdgesTouched[i] & i6) == i6 && (this.mTrackingEdges & i6) != 0 && (this.mEdgeDragsLocked[i] & i6) != i6 && (this.mEdgeDragsInProgress[i] & i6) != i6) {
            int i10 = this.mTouchSlop;
            if (abs > i10 || abs2 > i10) {
                if (abs < abs2 * 0.5f && this.mCallback.onEdgeLock(i6)) {
                    int[] iArr = this.mEdgeDragsLocked;
                    iArr[i] = iArr[i] | i6;
                    return false;
                }
                if ((this.mEdgeDragsInProgress[i] & i6) == 0 && abs > this.mTouchSlop) {
                    return true;
                }
            }
        }
        return false;
    }

    private float clampMag(float f, float f10, float f11) {
        float abs = Math.abs(f);
        if (abs < f10) {
            return 0.0f;
        }
        return abs > f11 ? f > 0.0f ? f11 : -f11 : f;
    }

    private void clearMotionHistory(int i) {
        if (this.mInitialMotionX == null || !isPointerDown(i)) {
            return;
        }
        this.mInitialMotionX[i] = 0.0f;
        this.mInitialMotionY[i] = 0.0f;
        this.mLastMotionX[i] = 0.0f;
        this.mLastMotionY[i] = 0.0f;
        this.mInitialEdgesTouched[i] = 0;
        this.mEdgeDragsInProgress[i] = 0;
        this.mEdgeDragsLocked[i] = 0;
        this.mPointersDown = (~(1 << i)) & this.mPointersDown;
    }

    private int computeAxisDuration(int i, int i6, int i10) {
        if (i == 0) {
            return 0;
        }
        int width = this.mParentView.getWidth();
        float f = width / 2;
        float distanceInfluenceForSnapDuration = (distanceInfluenceForSnapDuration(Math.min(1.0f, Math.abs(i) / width)) * f) + f;
        int abs = Math.abs(i6);
        return Math.min(abs > 0 ? Math.round(Math.abs(distanceInfluenceForSnapDuration / abs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i10) + 1.0f) * 256.0f), 600);
    }

    private int computeSettleDuration(View view, int i, int i6, int i10, int i11) {
        float f;
        float f10;
        float f11;
        float f12;
        int clampMag = clampMag(i10, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int clampMag2 = clampMag(i11, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(clampMag);
        int abs4 = Math.abs(clampMag2);
        int i12 = abs3 + abs4;
        int i13 = abs + abs2;
        if (clampMag != 0) {
            f = abs3;
            f10 = i12;
        } else {
            f = abs;
            f10 = i13;
        }
        float f13 = f / f10;
        if (clampMag2 != 0) {
            f11 = abs4;
            f12 = i12;
        } else {
            f11 = abs2;
            f12 = i13;
        }
        return (int) ((computeAxisDuration(i6, clampMag2, this.mCallback.getViewVerticalDragRange(view)) * (f11 / f12)) + (computeAxisDuration(i, clampMag, this.mCallback.getViewHorizontalDragRange(view)) * f13));
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, float f, @NonNull Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.mTouchSlop = (int) ((1.0f / f) * create.mTouchSlop);
        return create;
    }

    private void dispatchViewReleased(float f, float f10) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, f, f10);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    private float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    private void dragTo(int i, int i6, int i10, int i11) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        if (i10 != 0) {
            i = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, i, i10);
            ViewCompat.offsetLeftAndRight(this.mCapturedView, i - left);
        }
        int i12 = i;
        if (i11 != 0) {
            i6 = this.mCallback.clampViewPositionVertical(this.mCapturedView, i6, i11);
            ViewCompat.offsetTopAndBottom(this.mCapturedView, i6 - top);
        }
        int i13 = i6;
        if (i10 == 0 && i11 == 0) {
            return;
        }
        this.mCallback.onViewPositionChanged(this.mCapturedView, i12, i13, i12 - left, i13 - top);
    }

    private void ensureMotionHistorySizeForId(int i) {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null || fArr.length <= i) {
            int i6 = i + 1;
            float[] fArr2 = new float[i6];
            float[] fArr3 = new float[i6];
            float[] fArr4 = new float[i6];
            float[] fArr5 = new float[i6];
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.mInitialMotionY;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.mLastMotionX;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.mLastMotionY;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.mInitialEdgesTouched;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.mEdgeDragsInProgress;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.mEdgeDragsLocked;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.mInitialMotionX = fArr2;
            this.mInitialMotionY = fArr3;
            this.mLastMotionX = fArr4;
            this.mLastMotionY = fArr5;
            this.mInitialEdgesTouched = iArr;
            this.mEdgeDragsInProgress = iArr2;
            this.mEdgeDragsLocked = iArr3;
        }
    }

    private boolean forceSettleCapturedViewAt(int i, int i6, int i10, int i11) {
        int left = this.mCapturedView.getLeft();
        int top = this.mCapturedView.getTop();
        int i12 = i - left;
        int i13 = i6 - top;
        if (i12 == 0 && i13 == 0) {
            this.mScroller.abortAnimation();
            setDragState(0);
            return false;
        }
        this.mScroller.startScroll(left, top, i12, i13, computeSettleDuration(this.mCapturedView, i12, i13, i10, i11));
        setDragState(2);
        return true;
    }

    private int getEdgesTouched(int i, int i6) {
        int i10 = i < this.mParentView.getLeft() + this.mEdgeSize ? 1 : 0;
        if (i6 < this.mParentView.getTop() + this.mEdgeSize) {
            i10 |= 4;
        }
        if (i > this.mParentView.getRight() - this.mEdgeSize) {
            i10 |= 2;
        }
        return i6 > this.mParentView.getBottom() - this.mEdgeSize ? i10 | 8 : i10;
    }

    private boolean isValidPointerForActionMove(int i) {
        if (isPointerDown(i)) {
            return true;
        }
        Log.e(TAG, "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r3v3, types: [androidx.customview.widget.ViewDragHelper$Callback] */
    private void reportNewEdgeDrags(float f, float f10, int i) {
        boolean checkNewEdgeDrag = checkNewEdgeDrag(f, f10, i, 1);
        boolean z9 = checkNewEdgeDrag;
        if (checkNewEdgeDrag(f10, f, i, 4)) {
            z9 = (checkNewEdgeDrag ? 1 : 0) | 4;
        }
        boolean z10 = z9;
        if (checkNewEdgeDrag(f, f10, i, 2)) {
            z10 = (z9 ? 1 : 0) | 2;
        }
        ?? r02 = z10;
        if (checkNewEdgeDrag(f10, f, i, 8)) {
            r02 = (z10 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.mEdgeDragsInProgress;
            iArr[i] = iArr[i] | r02;
            this.mCallback.onEdgeDragStarted(r02, i);
        }
    }

    private void saveInitialMotion(float f, float f10, int i) {
        ensureMotionHistorySizeForId(i);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.mInitialMotionY;
        this.mLastMotionY[i] = f10;
        fArr2[i] = f10;
        this.mInitialEdgesTouched[i] = getEdgesTouched((int) f, (int) f10);
        this.mPointersDown |= 1 << i;
    }

    private void saveLastMotion(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (isValidPointerForActionMove(pointerId)) {
                float x3 = motionEvent.getX(i);
                float y9 = motionEvent.getY(i);
                this.mLastMotionX[pointerId] = x3;
                this.mLastMotionY[pointerId] = y9;
            }
        }
    }

    public void abort() {
        cancel();
        if (this.mDragState == 2) {
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int currX2 = this.mScroller.getCurrX();
            int currY2 = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        setDragState(0);
    }

    public boolean canScroll(@NonNull View view, boolean z9, int i, int i6, int i10, int i11) {
        int i12;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i13 = i10 + scrollX;
                if (i13 >= childAt.getLeft() && i13 < childAt.getRight() && (i12 = i11 + scrollY) >= childAt.getTop() && i12 < childAt.getBottom() && canScroll(childAt, true, i, i6, i13 - childAt.getLeft(), i12 - childAt.getTop())) {
                    return true;
                }
            }
        }
        if (z9) {
            return view.canScrollHorizontally(-i) || view.canScrollVertically(-i6);
        }
        return false;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void captureChildView(@NonNull View view, int i) {
        if (view.getParent() != this.mParentView) {
            b.q(this.mParentView, "captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (", ")");
            return;
        }
        this.mCapturedView = view;
        this.mActivePointerId = i;
        this.mCallback.onViewCaptured(view, i);
        setDragState(1);
    }

    public boolean checkTouchSlop(int i, int i6) {
        if (!isPointerDown(i6)) {
            return false;
        }
        boolean z9 = (i & 1) == 1;
        boolean z10 = (i & 2) == 2;
        float f = this.mLastMotionX[i6] - this.mInitialMotionX[i6];
        float f10 = this.mLastMotionY[i6] - this.mInitialMotionY[i6];
        if (!z9 || !z10) {
            return z9 ? Math.abs(f) > ((float) this.mTouchSlop) : z10 && Math.abs(f10) > ((float) this.mTouchSlop);
        }
        float f11 = (f10 * f10) + (f * f);
        int i10 = this.mTouchSlop;
        return f11 > ((float) (i10 * i10));
    }

    public boolean continueSettling(boolean z9) {
        if (this.mDragState == 2) {
            boolean computeScrollOffset = this.mScroller.computeScrollOffset();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            int left = currX - this.mCapturedView.getLeft();
            int top = currY - this.mCapturedView.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.mCapturedView, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.mCapturedView, top);
            }
            if (left != 0 || top != 0) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.mScroller.getFinalX() && currY == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z9) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    setDragState(0);
                }
            }
        }
        return this.mDragState == 2;
    }

    @Nullable
    public View findTopChildUnder(int i, int i6) {
        for (int childCount = this.mParentView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i6 >= childAt.getTop() && i6 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i, int i6, int i10, int i11) {
        if (!this.mReleaseInProgress) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        } else {
            this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId), i, i10, i6, i11);
            setDragState(2);
        }
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    @Nullable
    public View getCapturedView() {
        return this.mCapturedView;
    }

    @Px
    public int getDefaultEdgeSize() {
        return this.mDefaultEdgeSize;
    }

    @Px
    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    @Px
    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public boolean isCapturedViewUnder(int i, int i6) {
        return isViewUnder(this.mCapturedView, i, i6);
    }

    public boolean isEdgeTouched(int i) {
        int length = this.mInitialEdgesTouched.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (isEdgeTouched(i, i6)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPointerDown(int i) {
        return ((1 << i) & this.mPointersDown) != 0;
    }

    public boolean isViewUnder(@Nullable View view, int i, int i6) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i6 >= view.getTop() && i6 < view.getBottom();
    }

    public void processTouchEvent(@NonNull MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i6 = 0;
        if (actionMasked == 0) {
            float x3 = motionEvent.getX();
            float y9 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View findTopChildUnder = findTopChildUnder((int) x3, (int) y9);
            saveInitialMotion(x3, y9, pointerId);
            tryCaptureViewForDrag(findTopChildUnder, pointerId);
            int i10 = this.mInitialEdgesTouched[pointerId];
            int i11 = this.mTrackingEdges;
            if ((i10 & i11) != 0) {
                this.mCallback.onEdgeTouched(i10 & i11, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.mDragState == 1) {
                releaseViewForPointerUp();
            }
            cancel();
            return;
        }
        if (actionMasked == 2) {
            if (this.mDragState == 1) {
                if (isValidPointerForActionMove(this.mActivePointerId)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    float x9 = motionEvent.getX(findPointerIndex);
                    float y10 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.mLastMotionX;
                    int i12 = this.mActivePointerId;
                    int i13 = (int) (x9 - fArr[i12]);
                    int i14 = (int) (y10 - this.mLastMotionY[i12]);
                    dragTo(this.mCapturedView.getLeft() + i13, this.mCapturedView.getTop() + i14, i13, i14);
                    saveLastMotion(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i6 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i6);
                if (isValidPointerForActionMove(pointerId2)) {
                    float x10 = motionEvent.getX(i6);
                    float y11 = motionEvent.getY(i6);
                    float f = x10 - this.mInitialMotionX[pointerId2];
                    float f10 = y11 - this.mInitialMotionY[pointerId2];
                    reportNewEdgeDrags(f, f10, pointerId2);
                    if (this.mDragState != 1) {
                        View findTopChildUnder2 = findTopChildUnder((int) x10, (int) y11);
                        if (checkTouchSlop(findTopChildUnder2, f, f10) && tryCaptureViewForDrag(findTopChildUnder2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i6++;
            }
            saveLastMotion(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.mDragState == 1) {
                dispatchViewReleased(0.0f, 0.0f);
            }
            cancel();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x11 = motionEvent.getX(actionIndex);
            float y12 = motionEvent.getY(actionIndex);
            saveInitialMotion(x11, y12, pointerId3);
            if (this.mDragState != 0) {
                if (isCapturedViewUnder((int) x11, (int) y12)) {
                    tryCaptureViewForDrag(this.mCapturedView, pointerId3);
                    return;
                }
                return;
            } else {
                tryCaptureViewForDrag(findTopChildUnder((int) x11, (int) y12), pointerId3);
                int i15 = this.mInitialEdgesTouched[pointerId3];
                int i16 = this.mTrackingEdges;
                if ((i15 & i16) != 0) {
                    this.mCallback.onEdgeTouched(i15 & i16, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.mDragState == 1 && pointerId4 == this.mActivePointerId) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i6 >= pointerCount2) {
                    i = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i6);
                if (pointerId5 != this.mActivePointerId) {
                    View findTopChildUnder3 = findTopChildUnder((int) motionEvent.getX(i6), (int) motionEvent.getY(i6));
                    View view = this.mCapturedView;
                    if (findTopChildUnder3 == view && tryCaptureViewForDrag(view, pointerId5)) {
                        i = this.mActivePointerId;
                        break;
                    }
                }
                i6++;
            }
            if (i == -1) {
                releaseViewForPointerUp();
            }
        }
        clearMotionHistory(pointerId4);
    }

    public void setDragState(int i) {
        this.mParentView.removeCallbacks(this.mSetIdleRunnable);
        if (this.mDragState != i) {
            this.mDragState = i;
            this.mCallback.onViewDragStateChanged(i);
            if (this.mDragState == 0) {
                this.mCapturedView = null;
            }
        }
    }

    public void setEdgeSize(@IntRange(from = 0) @Px int i) {
        this.mEdgeSize = i;
    }

    public void setEdgeTrackingEnabled(int i) {
        this.mTrackingEdges = i;
    }

    public void setMinVelocity(float f) {
        this.mMinVelocity = f;
    }

    public boolean settleCapturedViewAt(int i, int i6) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(i, i6, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e0, code lost:
    
        if (r12 != r11) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean shouldInterceptTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean smoothSlideViewTo(@NonNull View view, int i, int i6) {
        this.mCapturedView = view;
        this.mActivePointerId = -1;
        boolean forceSettleCapturedViewAt = forceSettleCapturedViewAt(i, i6, 0, 0);
        if (!forceSettleCapturedViewAt && this.mDragState == 0 && this.mCapturedView != null) {
            this.mCapturedView = null;
        }
        return forceSettleCapturedViewAt;
    }

    public boolean tryCaptureViewForDrag(View view, int i) {
        if (view == this.mCapturedView && this.mActivePointerId == i) {
            return true;
        }
        if (view == null || !this.mCallback.tryCaptureView(view, i)) {
            return false;
        }
        this.mActivePointerId = i;
        captureChildView(view, i);
        return true;
    }

    public static ViewDragHelper create(@NonNull ViewGroup viewGroup, @NonNull Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class Callback {
        public int clampViewPositionHorizontal(@NonNull View view, int i, int i6) {
            return 0;
        }

        public int clampViewPositionVertical(@NonNull View view, int i, int i6) {
            return 0;
        }

        public int getViewHorizontalDragRange(@NonNull View view) {
            return 0;
        }

        public int getViewVerticalDragRange(@NonNull View view) {
            return 0;
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public abstract boolean tryCaptureView(@NonNull View view, int i);

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onEdgeDragStarted(int i, int i6) {
        }

        public void onEdgeTouched(int i, int i6) {
        }

        public void onViewCaptured(@NonNull View view, int i) {
        }

        public void onViewReleased(@NonNull View view, float f, float f10) {
        }

        public void onViewPositionChanged(@NonNull View view, int i, int i6, @Px int i10, @Px int i11) {
        }
    }

    public boolean isEdgeTouched(int i, int i6) {
        return isPointerDown(i6) && (i & this.mInitialEdgesTouched[i6]) != 0;
    }

    private int clampMag(int i, int i6, int i10) {
        int abs = Math.abs(i);
        if (abs < i6) {
            return 0;
        }
        return abs > i10 ? i > 0 ? i10 : -i10 : i;
    }

    private void clearMotionHistory() {
        float[] fArr = this.mInitialMotionX;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.mInitialMotionY, 0.0f);
        Arrays.fill(this.mLastMotionX, 0.0f);
        Arrays.fill(this.mLastMotionY, 0.0f);
        Arrays.fill(this.mInitialEdgesTouched, 0);
        Arrays.fill(this.mEdgeDragsInProgress, 0);
        Arrays.fill(this.mEdgeDragsLocked, 0);
        this.mPointersDown = 0;
    }

    public boolean checkTouchSlop(int i) {
        int length = this.mInitialMotionX.length;
        for (int i6 = 0; i6 < length; i6++) {
            if (checkTouchSlop(i, i6)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkTouchSlop(View view, float f, float f10) {
        if (view == null) {
            return false;
        }
        boolean z9 = this.mCallback.getViewHorizontalDragRange(view) > 0;
        boolean z10 = this.mCallback.getViewVerticalDragRange(view) > 0;
        if (!z9 || !z10) {
            return z9 ? Math.abs(f) > ((float) this.mTouchSlop) : z10 && Math.abs(f10) > ((float) this.mTouchSlop);
        }
        float f11 = (f10 * f10) + (f * f);
        int i = this.mTouchSlop;
        return f11 > ((float) (i * i));
    }
}
