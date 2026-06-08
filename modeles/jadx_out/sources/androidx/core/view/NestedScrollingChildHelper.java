package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class NestedScrollingChildHelper {
    private boolean mIsNestedScrollingEnabled;
    private ViewParent mNestedScrollingParentNonTouch;
    private ViewParent mNestedScrollingParentTouch;
    private int[] mTempNestedScrollConsumed;
    private final View mView;

    public NestedScrollingChildHelper(@NonNull View view) {
        this.mView = view;
    }

    private boolean dispatchNestedScrollInternal(int i, int i6, int i10, int i11, @Nullable int[] iArr, int i12, @Nullable int[] iArr2) {
        ViewParent nestedScrollingParentForType;
        int i13;
        int i14;
        int[] iArr3;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i12)) == null) {
            return false;
        }
        if (i == 0 && i6 == 0 && i10 == 0 && i11 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.mView.getLocationInWindow(iArr);
            i13 = iArr[0];
            i14 = iArr[1];
        } else {
            i13 = 0;
            i14 = 0;
        }
        if (iArr2 == null) {
            int[] tempNestedScrollConsumed = getTempNestedScrollConsumed();
            tempNestedScrollConsumed[0] = 0;
            tempNestedScrollConsumed[1] = 0;
            iArr3 = tempNestedScrollConsumed;
        } else {
            iArr3 = iArr2;
        }
        ViewParentCompat.onNestedScroll(nestedScrollingParentForType, this.mView, i, i6, i10, i11, i12, iArr3);
        if (iArr != null) {
            this.mView.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i13;
            iArr[1] = iArr[1] - i14;
        }
        return true;
    }

    private ViewParent getNestedScrollingParentForType(int i) {
        if (i == 0) {
            return this.mNestedScrollingParentTouch;
        }
        if (i != 1) {
            return null;
        }
        return this.mNestedScrollingParentNonTouch;
    }

    private int[] getTempNestedScrollConsumed() {
        if (this.mTempNestedScrollConsumed == null) {
            this.mTempNestedScrollConsumed = new int[2];
        }
        return this.mTempNestedScrollConsumed;
    }

    private void setNestedScrollingParentForType(int i, ViewParent viewParent) {
        if (i == 0) {
            this.mNestedScrollingParentTouch = viewParent;
        } else {
            if (i != 1) {
                return;
            }
            this.mNestedScrollingParentNonTouch = viewParent;
        }
    }

    public boolean dispatchNestedFling(float f, float f10, boolean z9) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedFling(nestedScrollingParentForType, this.mView, f, f10, z9);
    }

    public boolean dispatchNestedPreFling(float f, float f10) {
        ViewParent nestedScrollingParentForType;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(0)) == null) {
            return false;
        }
        return ViewParentCompat.onNestedPreFling(nestedScrollingParentForType, this.mView, f, f10);
    }

    public boolean dispatchNestedPreScroll(int i, int i6, @Nullable int[] iArr, @Nullable int[] iArr2, int i10) {
        ViewParent nestedScrollingParentForType;
        int i11;
        int i12;
        if (!isNestedScrollingEnabled() || (nestedScrollingParentForType = getNestedScrollingParentForType(i10)) == null) {
            return false;
        }
        if (i == 0 && i6 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            i11 = iArr2[0];
            i12 = iArr2[1];
        } else {
            i11 = 0;
            i12 = 0;
        }
        if (iArr == null) {
            iArr = getTempNestedScrollConsumed();
        }
        int[] iArr3 = iArr;
        iArr3[0] = 0;
        iArr3[1] = 0;
        ViewParentCompat.onNestedPreScroll(nestedScrollingParentForType, this.mView, i, i6, iArr3, i10);
        if (iArr2 != null) {
            this.mView.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i11;
            iArr2[1] = iArr2[1] - i12;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public boolean dispatchNestedScroll(int i, int i6, int i10, int i11, @Nullable int[] iArr) {
        return dispatchNestedScrollInternal(i, i6, i10, i11, iArr, 0, null);
    }

    public boolean hasNestedScrollingParent(int i) {
        return getNestedScrollingParentForType(i) != null;
    }

    public boolean isNestedScrollingEnabled() {
        return this.mIsNestedScrollingEnabled;
    }

    public void onDetachedFromWindow() {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void onStopNestedScroll(@NonNull View view) {
        ViewCompat.stopNestedScroll(this.mView);
    }

    public void setNestedScrollingEnabled(boolean z9) {
        if (this.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(this.mView);
        }
        this.mIsNestedScrollingEnabled = z9;
    }

    public boolean startNestedScroll(int i, int i6) {
        if (hasNestedScrollingParent(i6)) {
            return true;
        }
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        View view = this.mView;
        for (ViewParent parent = this.mView.getParent(); parent != null; parent = parent.getParent()) {
            if (ViewParentCompat.onStartNestedScroll(parent, view, this.mView, i, i6)) {
                setNestedScrollingParentForType(i6, parent);
                ViewParentCompat.onNestedScrollAccepted(parent, view, this.mView, i, i6);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public void stopNestedScroll(int i) {
        ViewParent nestedScrollingParentForType = getNestedScrollingParentForType(i);
        if (nestedScrollingParentForType != null) {
            ViewParentCompat.onStopNestedScroll(nestedScrollingParentForType, this.mView, i);
            setNestedScrollingParentForType(i, null);
        }
    }

    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    public boolean dispatchNestedScroll(int i, int i6, int i10, int i11, @Nullable int[] iArr, int i12) {
        return dispatchNestedScrollInternal(i, i6, i10, i11, iArr, i12, null);
    }

    public void dispatchNestedScroll(int i, int i6, int i10, int i11, @Nullable int[] iArr, int i12, @Nullable int[] iArr2) {
        dispatchNestedScrollInternal(i, i6, i10, i11, iArr, i12, iArr2);
    }

    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    public boolean dispatchNestedPreScroll(int i, int i6, @Nullable int[] iArr, @Nullable int[] iArr2) {
        return dispatchNestedPreScroll(i, i6, iArr, iArr2, 0);
    }
}
