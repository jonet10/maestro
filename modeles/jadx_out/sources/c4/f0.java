package c4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1578a;

    /* renamed from: b, reason: collision with root package name */
    public int f1579b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ k0 f1580l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f0(k0 k0Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f1578a = i;
        this.f1580l = k0Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1578a) {
            case 0:
                return new f0(this.f1580l, cVar, 0);
            case 1:
                return new f0(this.f1580l, cVar, 1);
            case 2:
                return new f0(this.f1580l, cVar, 2);
            default:
                return new f0(this.f1580l, cVar, 3);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1578a) {
            case 0:
                ((f0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            case 1:
                ((f0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            case 2:
                ((f0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            default:
                ((f0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
        }
        return u6.a.f10762a;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f1578a) {
            case 0:
                int i = this.f1579b;
                if (i == 0) {
                    p6.a.e(obj);
                    r7.e0 e0Var = a5.b.f194b;
                    e0 e0Var2 = new e0(this.f1580l, 0);
                    this.f1579b = 1;
                    Object collect = e0Var.f8972a.collect(e0Var2, this);
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
                throw new a1.b();
            case 1:
                int i6 = this.f1579b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                r7.d0 d0Var = a5.b.f196d;
                e0 e0Var3 = new e0(this.f1580l, 1);
                this.f1579b = 1;
                d0Var.f8968a.collect(e0Var3, this);
                return u6.a.f10762a;
            case 2:
                int i10 = this.f1579b;
                if (i10 == 0) {
                    p6.a.e(obj);
                    r7.e0 e0Var4 = a5.c.f198b;
                    g0 g0Var = new g0();
                    this.f1579b = 1;
                    Object collect2 = e0Var4.f8972a.collect(g0Var, this);
                    u6.a aVar2 = u6.a.f10762a;
                    if (collect2 == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i10 != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    p6.a.e(obj);
                }
                throw new a1.b();
            default:
                int i11 = this.f1579b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                r7.d0 d0Var2 = a5.c.f200d;
                e0 e0Var5 = new e0(this.f1580l, 2);
                this.f1579b = 1;
                d0Var2.f8968a.collect(e0Var5, this);
                return u6.a.f10762a;
        }
    }
}
