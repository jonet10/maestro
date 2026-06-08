package o9;

import d7.p;
import f9.h;
import f9.k;
import j8.f;
import java.util.ArrayList;
import l.g;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public int f8377a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f8378b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f8379l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar, boolean z9, t6.c cVar) {
        super(2, cVar);
        this.f8378b = eVar;
        this.f8379l = z9;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new d(this.f8378b, this.f8379l, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return new d(this.f8378b, this.f8379l, (t6.c) obj2).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        int i = this.f8377a;
        if (i == 0) {
            p6.a.e(obj);
            e eVar = this.f8378b;
            h hVar = eVar.f8384e;
            Boolean valueOf = Boolean.valueOf(!this.f8379l);
            String j = eVar.f8380a.j(37);
            Boolean bool = Boolean.TRUE;
            this.f8377a = 1;
            hVar.getClass();
            l9.a aVar = hVar.f;
            ArrayList arrayList2 = hVar.h;
            String str = valueOf.equals(bool) ? "All" : "Reject";
            String str2 = valueOf.equals(bool) ? "none" : "all";
            String e10 = g.e();
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(arrayList2);
            if (g.f7044a) {
                arrayList = new ArrayList();
                g.f7045b.forEach(new f(arrayList, 1));
            } else {
                arrayList = null;
            }
            k kVar = new k(arrayList3, str, str2, null, null, null, null, null, j, e10, arrayList, null, 2296);
            if (bool.equals(bool)) {
                aVar.g(78, true);
            }
            if (e10 == null) {
                e10 = "";
            }
            aVar.f(93, e10);
            arrayList2.clear();
            Object b7 = hVar.b(3, kVar, f9.d.USP, this);
            u6.a aVar2 = u6.a.f10762a;
            if (b7 == aVar2) {
                return aVar2;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return x.f8463a;
    }
}
