package b;

import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.core.cmpapi.status.CmpStatus;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class q extends v6.i implements d7.p {
    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new q(2, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        q qVar = new q(2, (t6.c) obj2);
        x xVar = x.f8463a;
        qVar.invokeSuspend(xVar);
        return xVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        p6.a.e(obj);
        ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
        k.a aVar = k.a.f6832a;
        choiceCmp.getClass();
        ChoiceCmpCallback callback = choiceCmp.getCallback();
        if (callback != null) {
            callback.onCmpLoaded(choiceCmp.ping$app_release(true, CmpStatus.LOADED, DisplayStatus.HIDDEN));
        }
        if (m9.c.f7857a != null) {
            choiceCmp.a(m9.c.b());
        }
        return x.f8463a;
    }
}
