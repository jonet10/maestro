package c4;

import com.uptodown.activities.ListsActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a2 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1367a;

    /* renamed from: b, reason: collision with root package name */
    public int f1368b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ListsActivity f1369l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a2(ListsActivity listsActivity, t6.c cVar, int i) {
        super(2, cVar);
        this.f1367a = i;
        this.f1369l = listsActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1367a) {
            case 0:
                return new a2(this.f1369l, cVar, 0);
            case 1:
                return new a2(this.f1369l, cVar, 1);
            case 2:
                return new a2(this.f1369l, cVar, 2);
            default:
                return new a2(this.f1369l, cVar, 3);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1367a) {
            case 0:
                ((a2) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            case 1:
                ((a2) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            case 2:
                ((a2) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
            default:
                ((a2) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
                break;
        }
        return u6.a.f10762a;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1367a;
        u6.a aVar = u6.a.f10762a;
        ListsActivity listsActivity = this.f1369l;
        switch (i) {
            case 0:
                int i6 = this.f1368b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i10 = ListsActivity.S;
                r7.o0 o0Var = listsActivity.B0().f1663b;
                z1 z1Var = new z1(listsActivity, 0);
                this.f1368b = 1;
                o0Var.collect(z1Var, this);
                return aVar;
            case 1:
                int i11 = this.f1368b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i12 = ListsActivity.S;
                r7.o0 o0Var2 = listsActivity.B0().f1666e;
                z1 z1Var2 = new z1(listsActivity, 1);
                this.f1368b = 1;
                o0Var2.collect(z1Var2, this);
                return aVar;
            case 2:
                int i13 = this.f1368b;
                if (i13 != 0) {
                    if (i13 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i14 = ListsActivity.S;
                r7.o0 o0Var3 = listsActivity.B0().h;
                z1 z1Var3 = new z1(listsActivity, 2);
                this.f1368b = 1;
                o0Var3.collect(z1Var3, this);
                return aVar;
            default:
                int i15 = this.f1368b;
                if (i15 != 0) {
                    if (i15 == 1) {
                        throw androidx.lifecycle.l.q(obj);
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                int i16 = ListsActivity.S;
                r7.o0 o0Var4 = listsActivity.B0().f1667k;
                z1 z1Var4 = new z1(listsActivity, 3);
                this.f1368b = 1;
                o0Var4.collect(z1Var4, this);
                return aVar;
        }
    }
}
