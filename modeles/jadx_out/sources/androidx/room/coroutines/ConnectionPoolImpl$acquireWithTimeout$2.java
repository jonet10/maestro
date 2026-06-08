package androidx.room.coroutines;

import d7.p;
import kotlin.jvm.internal.x;
import o7.a0;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.room.coroutines.ConnectionPoolImpl$acquireWithTimeout$2", f = "ConnectionPoolImpl.kt", l = {171}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ConnectionPoolImpl$acquireWithTimeout$2 extends i implements p {
    final /* synthetic */ x $connection;
    final /* synthetic */ Pool $this_acquireWithTimeout;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectionPoolImpl$acquireWithTimeout$2(x xVar, Pool pool, c cVar) {
        super(2, cVar);
        this.$connection = xVar;
        this.$this_acquireWithTimeout = pool;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new ConnectionPoolImpl$acquireWithTimeout$2(this.$connection, this.$this_acquireWithTimeout, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((ConnectionPoolImpl$acquireWithTimeout$2) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        x xVar;
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            xVar = this.$connection;
            Pool pool = this.$this_acquireWithTimeout;
            this.L$0 = xVar;
            this.label = 1;
            obj = pool.acquire(this);
            u6.a aVar = u6.a.f10762a;
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            xVar = (x) this.L$0;
            p6.a.e(obj);
        }
        xVar.f7024a = obj;
        return p6.x.f8463a;
    }
}
