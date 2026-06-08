package f8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u extends v6.h implements d7.q {

    /* renamed from: a, reason: collision with root package name */
    public int f4969a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ p6.b f4970b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ q f4971l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(q qVar, t6.c cVar) {
        super(3, cVar);
        this.f4971l = qVar;
    }

    @Override // d7.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        u uVar = new u(this.f4971l, (t6.c) obj3);
        uVar.f4970b = (p6.b) obj;
        return uVar.invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        q qVar = this.f4971l;
        a0 a0Var = (a0) qVar.f4965c;
        int i = this.f4969a;
        if (i == 0) {
            p6.a.e(obj);
            p6.b bVar = this.f4970b;
            byte t9 = a0Var.t();
            if (t9 == 1) {
                return qVar.f(true);
            }
            if (t9 == 0) {
                return qVar.f(false);
            }
            if (t9 != 6) {
                if (t9 == 8) {
                    return qVar.e();
                }
                a0.p(a0Var, "Can't begin reading element, unexpected token", 0, null, 6);
                throw null;
            }
            this.f4969a = 1;
            obj = q.a(qVar, bVar, this);
            u6.a aVar = u6.a.f10762a;
            if (obj == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return (e8.k) obj;
    }
}
