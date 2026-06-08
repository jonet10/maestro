package c4;

import com.uptodown.activities.ListsActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f2 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1584a;

    /* renamed from: b, reason: collision with root package name */
    public int f1585b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ListsActivity f1586l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ h2 f1587m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f2(ListsActivity listsActivity, h2 h2Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f1584a = i;
        this.f1586l = listsActivity;
        this.f1587m = h2Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1584a) {
            case 0:
                return new f2(this.f1586l, this.f1587m, cVar, 0);
            default:
                return new f2(this.f1586l, this.f1587m, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1584a) {
        }
        return ((f2) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object f;
        Object c9;
        switch (this.f1584a) {
            case 0:
                h2 h2Var = this.f1587m;
                r7.o0 o0Var = h2Var.f1662a;
                int i = this.f1585b;
                if (i == 0) {
                    p6.a.e(obj);
                    e1.v4 v4Var = new e1.v4(this.f1586l, 4, false);
                    int i6 = h2Var.f1669m;
                    this.f1585b = 1;
                    f = v4Var.f(i6, 0, this);
                    u6.a aVar = u6.a.f10762a;
                    if (f == aVar) {
                        break;
                    }
                } else if (i != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    f = ((p6.k) obj).f8444a;
                }
                if (!(f instanceof p6.j)) {
                    s4.s0 s0Var = (s4.s0) f;
                    if (s0Var.f9289a.isEmpty()) {
                        j5.r rVar = new j5.r(new d2(new ArrayList(), 0));
                        o0Var.getClass();
                        o0Var.g(null, rVar);
                    } else {
                        j5.r rVar2 = new j5.r(new d2(s0Var.f9289a, s0Var.f9290b));
                        o0Var.getClass();
                        o0Var.g(null, rVar2);
                    }
                }
                if (p6.k.a(f) != null) {
                    j5.r rVar3 = new j5.r(new d2(new ArrayList(), 0));
                    o0Var.getClass();
                    o0Var.g(null, rVar3);
                }
                break;
            default:
                h2 h2Var2 = this.f1587m;
                r7.o0 o0Var2 = h2Var2.f1665d;
                int i10 = this.f1585b;
                if (i10 == 0) {
                    p6.a.e(obj);
                    e1.v4 v4Var2 = new e1.v4(this.f1586l, 3, false);
                    int i11 = h2Var2.f1669m;
                    this.f1585b = 1;
                    c9 = v4Var2.c(i11, 0, this);
                    u6.a aVar2 = u6.a.f10762a;
                    if (c9 == aVar2) {
                        break;
                    }
                } else if (i10 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                    c9 = ((p6.k) obj).f8444a;
                }
                if (!(c9 instanceof p6.j)) {
                    s4.f0 f0Var = (s4.f0) c9;
                    if (f0Var.f9198a.isEmpty()) {
                        j5.r rVar4 = new j5.r(new d2(new ArrayList(), 0));
                        o0Var2.getClass();
                        o0Var2.g(null, rVar4);
                    } else {
                        j5.r rVar5 = new j5.r(new d2(f0Var.f9198a, f0Var.f9200c));
                        o0Var2.getClass();
                        o0Var2.g(null, rVar5);
                    }
                }
                if (p6.k.a(c9) != null) {
                    j5.r rVar6 = new j5.r(new d2(new ArrayList(), 0));
                    o0Var2.getClass();
                    o0Var2.g(null, rVar6);
                }
                break;
        }
        return p6.x.f8463a;
    }
}
