package androidx.datastore.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import v6.c;
import v6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.SingleProcessCoordinator", f = "SingleProcessCoordinator.kt", l = {ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT, 41}, m = "lock")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SingleProcessCoordinator$lock$1<T> extends c {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SingleProcessCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleProcessCoordinator$lock$1(SingleProcessCoordinator singleProcessCoordinator, t6.c cVar) {
        super(cVar);
        this.this$0 = singleProcessCoordinator;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.lock(null, this);
    }
}
