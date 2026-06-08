package androidx.core.view;

import android.view.View;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface NestedScrollingParent {
    int getNestedScrollAxes();

    boolean onNestedFling(@NonNull View view, float f, float f10, boolean z9);

    boolean onNestedPreFling(@NonNull View view, float f, float f10);

    void onNestedPreScroll(@NonNull View view, int i, int i6, @NonNull int[] iArr);

    void onNestedScroll(@NonNull View view, int i, int i6, int i10, int i11);

    void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i);

    boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i);

    void onStopNestedScroll(@NonNull View view);
}
