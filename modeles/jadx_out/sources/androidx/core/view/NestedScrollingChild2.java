package androidx.core.view;

import androidx.annotation.Nullable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface NestedScrollingChild2 extends NestedScrollingChild {
    boolean dispatchNestedPreScroll(int i, int i6, @Nullable int[] iArr, @Nullable int[] iArr2, int i10);

    boolean dispatchNestedScroll(int i, int i6, int i10, int i11, @Nullable int[] iArr, int i12);

    boolean hasNestedScrollingParent(int i);

    boolean startNestedScroll(int i, int i6);

    void stopNestedScroll(int i);
}
