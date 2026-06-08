package c3;

import android.util.Log;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x0 extends v6.i implements d7.q {

    /* renamed from: a, reason: collision with root package name */
    public int f1345a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ r7.i f1346b;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Throwable f1347l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d1 f1348m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(d1 d1Var, t6.c cVar) {
        super(3, cVar);
        this.f1348m = d1Var;
    }

    @Override // d7.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        x0 x0Var = new x0(this.f1348m, (t6.c) obj3);
        x0Var.f1346b = (r7.i) obj;
        x0Var.f1347l = (Throwable) obj2;
        return x0Var.invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1345a;
        if (i == 0) {
            p6.a.e(obj);
            r7.i iVar = this.f1346b;
            Throwable th = this.f1347l;
            n0 a8 = this.f1348m.f1223b.a(null);
            i0 i0Var = new i0(a8, null, null);
            Log.d("FirebaseSessions", "Init session datastore failed with exception message: " + th.getMessage() + ". Emit fallback session " + a8.f1290a);
            this.f1346b = null;
            this.f1345a = 1;
            Object emit = iVar.emit(i0Var, this);
            u6.a aVar = u6.a.f10762a;
            if (emit == aVar) {
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
    }
}
