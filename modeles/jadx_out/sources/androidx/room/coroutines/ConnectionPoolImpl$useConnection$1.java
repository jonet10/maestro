package androidx.room.coroutines;

import v6.c;
import v6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.room.coroutines.ConnectionPoolImpl", f = "ConnectionPoolImpl.kt", l = {114, 118, 541, 147}, m = "useConnection")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ConnectionPoolImpl$useConnection$1<R> extends c {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConnectionPoolImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectionPoolImpl$useConnection$1(ConnectionPoolImpl connectionPoolImpl, t6.c cVar) {
        super(cVar);
        this.this$0 = connectionPoolImpl;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.useConnection(false, null, this);
    }
}
