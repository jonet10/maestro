package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface NestedScrollingParent2 extends NestedScrollingParent {
    void onNestedPreScroll(@NonNull View view, int i, int i6, @NonNull int[] iArr, int i10);

    void onNestedScroll(@NonNull View view, int i, int i6, int i10, int i11, int i12);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i, int i6);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i, int i6);

    void onStopNestedScroll(@NonNull View view, int i);
}
