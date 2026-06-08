package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Deprecated
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ScrollerCompat {
    OverScroller mScroller;

    public ScrollerCompat(Context context, Interpolator interpolator) {
        this.mScroller = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @Deprecated
    public static ScrollerCompat create(Context context) {
        return create(context, null);
    }

    @Deprecated
    public void abortAnimation() {
        this.mScroller.abortAnimation();
    }

    @Deprecated
    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }

    @Deprecated
    public void fling(int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.mScroller.fling(i, i6, i10, i11, i12, i13, i14, i15, i16, i17);
    }

    @Deprecated
    public float getCurrVelocity() {
        return this.mScroller.getCurrVelocity();
    }

    @Deprecated
    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    @Deprecated
    public int getCurrY() {
        return this.mScroller.getCurrY();
    }

    @Deprecated
    public int getFinalX() {
        return this.mScroller.getFinalX();
    }

    @Deprecated
    public int getFinalY() {
        return this.mScroller.getFinalY();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    @Deprecated
    public boolean isOverScrolled() {
        return this.mScroller.isOverScrolled();
    }

    @Deprecated
    public void notifyHorizontalEdgeReached(int i, int i6, int i10) {
        this.mScroller.notifyHorizontalEdgeReached(i, i6, i10);
    }

    @Deprecated
    public void notifyVerticalEdgeReached(int i, int i6, int i10) {
        this.mScroller.notifyVerticalEdgeReached(i, i6, i10);
    }

    @Deprecated
    public boolean springBack(int i, int i6, int i10, int i11, int i12, int i13) {
        return this.mScroller.springBack(i, i6, i10, i11, i12, i13);
    }

    @Deprecated
    public void startScroll(int i, int i6, int i10, int i11, int i12) {
        this.mScroller.startScroll(i, i6, i10, i11, i12);
    }

    @Deprecated
    public static ScrollerCompat create(Context context, Interpolator interpolator) {
        return new ScrollerCompat(context, interpolator);
    }

    @Deprecated
    public void startScroll(int i, int i6, int i10, int i11) {
        this.mScroller.startScroll(i, i6, i10, i11);
    }

    @Deprecated
    public void fling(int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15) {
        this.mScroller.fling(i, i6, i10, i11, i12, i13, i14, i15);
    }
}
