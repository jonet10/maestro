package androidx.datastore.core;

import d7.p;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.SingleProcessCoordinator$updateNotifications$1", f = "SingleProcessCoordinator.kt", l = {}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SingleProcessCoordinator$updateNotifications$1 extends i implements p {
    int label;

    public SingleProcessCoordinator$updateNotifications$1(c cVar) {
        super(2, cVar);
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new SingleProcessCoordinator$updateNotifications$1(cVar);
    }

    @Override // d7.p
    public final Object invoke(r7.i iVar, c cVar) {
        return ((SingleProcessCoordinator$updateNotifications$1) create(iVar, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        if (this.label == 0) {
            p6.a.e(obj);
            return x.f8463a;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
        return null;
    }
}
