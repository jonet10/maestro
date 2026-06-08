package androidx.core.view;

import androidx.annotation.Nullable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface NestedScrollingChild {
    boolean dispatchNestedFling(float f, float f10, boolean z9);

    boolean dispatchNestedPreFling(float f, float f10);

    boolean dispatchNestedPreScroll(int i, int i6, @Nullable int[] iArr, @Nullable int[] iArr2);

    boolean dispatchNestedScroll(int i, int i6, int i10, int i11, @Nullable int[] iArr);

    boolean hasNestedScrollingParent();

    boolean isNestedScrollingEnabled();

    void setNestedScrollingEnabled(boolean z9);

    boolean startNestedScroll(int i);

    void stopNestedScroll();
}
