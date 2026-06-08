package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static boolean onNestedFling(ViewParent viewParent, View view, float f, float f10, boolean z9) {
            return viewParent.onNestedFling(view, f, f10, z9);
        }

        @DoNotInline
        public static boolean onNestedPreFling(ViewParent viewParent, View view, float f, float f10) {
            return viewParent.onNestedPreFling(view, f, f10);
        }

        @DoNotInline
        public static void onNestedPreScroll(ViewParent viewParent, View view, int i, int i6, int[] iArr) {
            viewParent.onNestedPreScroll(view, i, i6, iArr);
        }

        @DoNotInline
        public static void onNestedScroll(ViewParent viewParent, View view, int i, int i6, int i10, int i11) {
            viewParent.onNestedScroll(view, i, i6, i10, i11);
        }

        @DoNotInline
        public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i) {
            viewParent.onNestedScrollAccepted(view, view2, i);
        }

        @DoNotInline
        public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i) {
            return viewParent.onStartNestedScroll(view, view2, i);
        }

        @DoNotInline
        public static void onStopNestedScroll(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    private ViewParentCompat() {
    }

    private static int[] getTempNestedScrollConsumed() {
        int[] iArr = sTempNestedScrollConsumed;
        if (iArr == null) {
            sTempNestedScrollConsumed = new int[2];
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
        }
        return sTempNestedScrollConsumed;
    }

    public static void notifySubtreeAccessibilityStateChanged(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i) {
        viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i);
    }

    public static boolean onNestedFling(@NonNull ViewParent viewParent, @NonNull View view, float f, float f10, boolean z9) {
        try {
            return Api21Impl.onNestedFling(viewParent, view, f, f10, z9);
        } catch (AbstractMethodError e10) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedFling", e10);
            return false;
        }
    }

    public static boolean onNestedPreFling(@NonNull ViewParent viewParent, @NonNull View view, float f, float f10) {
        try {
            return Api21Impl.onNestedPreFling(viewParent, view, f, f10);
        } catch (AbstractMethodError e10) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e10);
            return false;
        }
    }

    public static void onNestedPreScroll(@NonNull ViewParent viewParent, @NonNull View view, int i, int i6, @NonNull int[] iArr, int i10) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, i, i6, iArr, i10);
            return;
        }
        if (i10 == 0) {
            try {
                Api21Impl.onNestedPreScroll(viewParent, view, i, i6, iArr);
            } catch (AbstractMethodError e10) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e10);
            }
        }
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i, int i6, int i10, int i11, int i12, @NonNull int[] iArr) {
        if (viewParent instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) viewParent).onNestedScroll(view, i, i6, i10, i11, i12, iArr);
            return;
        }
        iArr[0] = iArr[0] + i10;
        iArr[1] = iArr[1] + i11;
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScroll(view, i, i6, i10, i11, i12);
            return;
        }
        if (i12 == 0) {
            try {
                Api21Impl.onNestedScroll(viewParent, view, i, i6, i10, i11);
            } catch (AbstractMethodError e10) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e10);
            }
        }
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i, int i6) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, i, i6);
            return;
        }
        if (i6 == 0) {
            try {
                Api21Impl.onNestedScrollAccepted(viewParent, view, view2, i);
            } catch (AbstractMethodError e10) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e10);
            }
        }
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i, int i6) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, i, i6);
        }
        if (i6 != 0) {
            return false;
        }
        try {
            return Api21Impl.onStartNestedScroll(viewParent, view, view2, i);
        } catch (AbstractMethodError e10) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e10);
            return false;
        }
    }

    public static void onStopNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onStopNestedScroll(view, i);
            return;
        }
        if (i == 0) {
            try {
                Api21Impl.onStopNestedScroll(viewParent, view);
            } catch (AbstractMethodError e10) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e10);
            }
        }
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public static void onNestedScrollAccepted(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i) {
        onNestedScrollAccepted(viewParent, view, view2, i, 0);
    }

    public static void onStopNestedScroll(@NonNull ViewParent viewParent, @NonNull View view) {
        onStopNestedScroll(viewParent, view, 0);
    }

    public static void onNestedPreScroll(@NonNull ViewParent viewParent, @NonNull View view, int i, int i6, @NonNull int[] iArr) {
        onNestedPreScroll(viewParent, view, i, i6, iArr, 0);
    }

    public static boolean onStartNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, @NonNull View view2, int i) {
        return onStartNestedScroll(viewParent, view, view2, i, 0);
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i, int i6, int i10, int i11, int i12) {
        onNestedScroll(viewParent, view, i, i6, i10, i11, i12, getTempNestedScrollConsumed());
    }

    public static void onNestedScroll(@NonNull ViewParent viewParent, @NonNull View view, int i, int i6, int i10, int i11) {
        onNestedScroll(viewParent, view, i, i6, i10, i11, 0, getTempNestedScrollConsumed());
    }
}
