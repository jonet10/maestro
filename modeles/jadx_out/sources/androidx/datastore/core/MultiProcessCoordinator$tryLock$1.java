package androidx.datastore.core;

import v6.c;
import v6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.MultiProcessCoordinator", f = "MultiProcessCoordinator.android.kt", l = {62, 87}, m = "tryLock")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MultiProcessCoordinator$tryLock$1<T> extends c {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiProcessCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiProcessCoordinator$tryLock$1(MultiProcessCoordinator multiProcessCoordinator, t6.c cVar) {
        super(cVar);
        this.this$0 = multiProcessCoordinator;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.tryLock(null, this);
    }
}
