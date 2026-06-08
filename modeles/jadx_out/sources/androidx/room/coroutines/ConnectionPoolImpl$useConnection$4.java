package androidx.room.coroutines;

import d7.p;
import kotlin.jvm.internal.x;
import o7.a0;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.room.coroutines.ConnectionPoolImpl$useConnection$4", f = "ConnectionPoolImpl.kt", l = {147}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ConnectionPoolImpl$useConnection$4 extends i implements p {
    final /* synthetic */ p $block;
    final /* synthetic */ x $connection;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectionPoolImpl$useConnection$4(p pVar, x xVar, c cVar) {
        super(2, cVar);
        this.$block = pVar;
        this.$connection = xVar;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new ConnectionPoolImpl$useConnection$4(this.$block, this.$connection, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((ConnectionPoolImpl$useConnection$4) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                p6.a.e(obj);
                return obj;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        p pVar = this.$block;
        Object obj2 = this.$connection.f7024a;
        this.label = 1;
        Object invoke = pVar.invoke(obj2, this);
        u6.a aVar = u6.a.f10762a;
        return invoke == aVar ? aVar : invoke;
    }
}
