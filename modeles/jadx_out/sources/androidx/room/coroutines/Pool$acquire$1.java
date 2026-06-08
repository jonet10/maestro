package androidx.room.coroutines;

import v6.c;
import v6.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.room.coroutines.Pool", f = "ConnectionPoolImpl.kt", l = {212}, m = "acquire")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Pool$acquire$1 extends c {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Pool this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Pool$acquire$1(Pool pool, t6.c cVar) {
        super(cVar);
        this.this$0 = pool;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.acquire(this);
    }
}
