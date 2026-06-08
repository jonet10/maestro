package c3;

import android.util.Log;
import androidx.datastore.core.DataStore;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1355a;

    /* renamed from: b, reason: collision with root package name */
    public int f1356b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ d1 f1357l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ z0(d1 d1Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f1355a = i;
        this.f1357l = d1Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1355a) {
            case 0:
                return new z0(this.f1357l, cVar, 0);
            default:
                return new z0(this.f1357l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1355a) {
        }
        return ((z0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1355a) {
            case 0:
                int i = this.f1356b;
                if (i == 0) {
                    p6.a.e(obj);
                    d1 d1Var = this.f1357l;
                    r7.o oVar = new r7.o(d1Var.f1226e.getData(), new x0(d1Var, null), 1);
                    y0 y0Var = new y0(d1Var, 0);
                    this.f1356b = 1;
                    Object collect = oVar.collect(y0Var, this);
                    u6.a aVar = u6.a.f10762a;
                    if (collect == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    p6.a.e(obj);
                }
                return p6.x.f8463a;
            default:
                int i6 = this.f1356b;
                t6.c cVar = null;
                d1 d1Var2 = this.f1357l;
                try {
                    if (i6 == 0) {
                        p6.a.e(obj);
                        DataStore dataStore = d1Var2.f1226e;
                        b1 b1Var = new b1(d1Var2, cVar, 0);
                        this.f1356b = 1;
                        Object updateData = dataStore.updateData(b1Var, this);
                        u6.a aVar2 = u6.a.f10762a;
                        if (updateData == aVar2) {
                            return aVar2;
                        }
                    } else {
                        if (i6 != 1) {
                            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        p6.a.e(obj);
                    }
                } catch (Exception e10) {
                    Log.d("FirebaseSessions", "App backgrounded, failed to update data. Message: " + e10.getMessage());
                    i0 i0Var = d1Var2.h;
                    if (i0Var == null) {
                        kotlin.jvm.internal.l.i("localSessionData");
                        throw null;
                    }
                    d1Var2.f1225d.getClass();
                    d1Var2.h = i0.a(i0Var, null, h1.a(), null, 5);
                }
                return p6.x.f8463a;
        }
    }
}
