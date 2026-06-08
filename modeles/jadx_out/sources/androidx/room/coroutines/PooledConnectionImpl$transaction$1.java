package androidx.room.coroutines;

import v6.c;
import v6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.room.coroutines.PooledConnectionImpl", f = "ConnectionPoolImpl.kt", l = {376, 380, 393, 393, 393}, m = "transaction")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PooledConnectionImpl$transaction$1<R> extends c {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PooledConnectionImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PooledConnectionImpl$transaction$1(PooledConnectionImpl pooledConnectionImpl, t6.c cVar) {
        super(cVar);
        this.this$0 = pooledConnectionImpl;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.transaction(null, null, this);
    }
}
