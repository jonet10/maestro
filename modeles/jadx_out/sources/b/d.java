package b;

import androidx.work.PeriodicWorkRequest;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.core.model.Vector;
import java.util.ArrayList;
import java.util.UUID;
import kotlin.jvm.internal.u;
import o7.a0;
import o7.c0;
import o7.m0;
import p6.x;
import r7.o0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class d extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f654a;

    /* renamed from: b, reason: collision with root package name */
    public int f655b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i, t6.c cVar, int i6) {
        super(i, cVar);
        this.f654a = i6;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f654a) {
            case 0:
                return new d(2, cVar, 0);
            case 1:
                return new d(2, cVar, 1);
            case 2:
                return new d(2, cVar, 2);
            case 3:
                return new d(2, cVar, 3);
            case 4:
                return new d(2, cVar, 4);
            default:
                return new d(2, cVar, 5);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f654a) {
            case 0:
                return new d(2, cVar, 0).invokeSuspend(x.f8463a);
            case 1:
                return new d(2, cVar, 1).invokeSuspend(x.f8463a);
            case 2:
                return new d(2, cVar, 2).invokeSuspend(x.f8463a);
            case 3:
                return new d(2, cVar, 3).invokeSuspend(x.f8463a);
            case 4:
                return ((d) create(a0Var, cVar)).invokeSuspend(x.f8463a);
            default:
                return new d(2, cVar, 5).invokeSuspend(x.f8463a);
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        h hVar;
        Object dVar;
        h hVar2;
        h hVar3;
        Object value;
        String str;
        int i = 1;
        t6.c cVar = null;
        switch (this.f654a) {
            case 0:
                u6.a aVar = u6.a.f10762a;
                int i6 = this.f655b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                hVar = ChoiceCmp.g;
                if (hVar == null) {
                    kotlin.jvm.internal.l.i("viewModel");
                    throw null;
                }
                this.f655b = 1;
                if (hVar.f678p.f7239n.f7199b) {
                    v7.e eVar = m0.f8288a;
                    dVar = c0.C(new a(hVar, cVar, 4), v7.d.f10884a, this);
                } else {
                    dVar = new u5.d();
                }
                return dVar == aVar ? aVar : dVar;
            case 1:
                u6.a aVar2 = u6.a.f10762a;
                int i10 = this.f655b;
                if (i10 != 0) {
                    if (i10 == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                hVar2 = ChoiceCmp.g;
                if (hVar2 == null) {
                    kotlin.jvm.internal.l.i("viewModel");
                    throw null;
                }
                this.f655b = 1;
                v7.e eVar2 = m0.f8288a;
                Object C = c0.C(new a(hVar2, cVar, i), v7.d.f10884a, this);
                return C == aVar2 ? aVar2 : C;
            case 2:
                u6.a aVar3 = u6.a.f10762a;
                int i11 = this.f655b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                hVar3 = ChoiceCmp.g;
                if (hVar3 == null) {
                    kotlin.jvm.internal.l.i("viewModel");
                    throw null;
                }
                this.f655b = 1;
                v7.e eVar3 = m0.f8288a;
                Object C2 = c0.C(new a(hVar3, cVar, 5), v7.d.f10884a, this);
                return C2 == aVar3 ? aVar3 : C2;
            case 3:
                u6.a aVar4 = u6.a.f10762a;
                int i12 = this.f655b;
                if (i12 == 0) {
                    p6.a.e(obj);
                    ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
                    this.f655b = 1;
                    if (ChoiceCmp.access$showCMP(choiceCmp, this) == aVar4) {
                        return aVar4;
                    }
                } else {
                    if (i12 != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    p6.a.e(obj);
                }
                return x.f8463a;
            case 4:
                u6.a aVar5 = u6.a.f10762a;
                int i13 = this.f655b;
                if (i13 == 0) {
                    p6.a.e(obj);
                    this.f655b = 1;
                    if (c0.j(PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS, this) == aVar5) {
                        return aVar5;
                    }
                } else {
                    if (i13 != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    p6.a.e(obj);
                }
                synchronized (f4.a.f4869a) {
                    o0 o0Var = f4.a.f4871c;
                    value = o0Var.getValue();
                    if (value != null) {
                        o0Var.f(null);
                        f4.a.f = null;
                    }
                }
                l4.a aVar6 = (l4.a) value;
                if (aVar6 != null) {
                    f4.a.f4872d.n(new l4.h(aVar6));
                }
                return x.f8463a;
            default:
                x xVar = x.f8463a;
                u6.a aVar7 = u6.a.f10762a;
                int i14 = this.f655b;
                if (i14 == 0) {
                    p6.a.e(obj);
                    UUID uuid = f9.q.f5065a;
                    this.f655b = 1;
                    f9.h hVar4 = f9.q.f5066b;
                    hVar4.h("Confirm", "click");
                    ArrayList arrayList = hVar4.h;
                    f9.d dVar2 = f9.d.NR;
                    boolean z9 = l.g.f7044a;
                    ArrayList arrayList2 = new ArrayList();
                    Vector vector = l.g.f7045b;
                    vector.forEach(new j8.f(arrayList2, 1));
                    u uVar = new u();
                    uVar.f7021a = true;
                    vector.forEach(new l.f(uVar, 0));
                    if (uVar.f7021a) {
                        str = "All";
                    } else {
                        u uVar2 = new u();
                        uVar2.f7021a = true;
                        vector.forEach(new l.f(uVar2, 1));
                        str = uVar2.f7021a ? "Reject" : "Partial";
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.addAll(arrayList);
                    f9.m mVar = new f9.m(arrayList3, arrayList2, str);
                    arrayList.clear();
                    hVar4.f.f(93, str);
                    Object b7 = hVar4.b(3, mVar, dVar2, this);
                    if (b7 != aVar7) {
                        b7 = xVar;
                    }
                    if (b7 == aVar7) {
                        return aVar7;
                    }
                } else {
                    if (i14 != 1) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    p6.a.e(obj);
                }
                return xVar;
        }
    }
}
