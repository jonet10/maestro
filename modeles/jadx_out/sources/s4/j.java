package s4;

import java.util.ArrayList;
import java.util.Iterator;
import u4.z0;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9218a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y2.s f9219b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ArrayList f9220l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(ArrayList arrayList, y2.s sVar, t6.c cVar) {
        super(2, cVar);
        this.f9220l = arrayList;
        this.f9219b = sVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f9218a) {
            case 0:
                return new j(this.f9220l, this.f9219b, cVar);
            default:
                return new j(this.f9219b, this.f9220l, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f9218a) {
            case 0:
                j jVar = (j) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                jVar.invokeSuspend(xVar);
                return xVar;
            default:
                j jVar2 = (j) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                jVar2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        z0 z0Var;
        x4.j jVar;
        e4.h hVar;
        switch (this.f9218a) {
            case 0:
                p6.a.e(obj);
                ArrayList arrayList = this.f9220l;
                if (!arrayList.isEmpty()) {
                    u4.y0 y0Var = (u4.y0) this.f9219b.f11756l;
                    y0Var.getClass();
                    e4.h hVar2 = y0Var.f10664a.f10670b;
                    if (hVar2 != null && !arrayList.isEmpty()) {
                        e4.g gVar = new e4.g();
                        gVar.f4532a = arrayList;
                        gVar.f4533b = 7;
                        hVar2.f4544e.add(gVar);
                        hVar2.notifyItemInserted(hVar2.f4544e.size() - 1);
                    }
                }
                break;
            default:
                p6.a.e(obj);
                y2.s sVar = this.f9219b;
                if (((x4.j) sVar.f11757m).f11224a == 523) {
                    u4.y0 y0Var2 = (u4.y0) sVar.f11756l;
                    y0Var2.getClass();
                    ArrayList arrayList2 = this.f9220l;
                    arrayList2.getClass();
                    if (!arrayList2.isEmpty() && (jVar = (z0Var = y0Var2.f10664a).f10669a) != null && (hVar = z0Var.f10670b) != null) {
                        if (jVar.f11224a == 523) {
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 558);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 566);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 562);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 564);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 559);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 645);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 560);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 561);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 565);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 593);
                            }
                            if (!arrayList2.isEmpty()) {
                                hVar.a(arrayList2, 568);
                            }
                            if (!arrayList2.isEmpty()) {
                                Iterator it = arrayList2.iterator();
                                it.getClass();
                                while (it.hasNext()) {
                                    Object next = it.next();
                                    next.getClass();
                                    hVar.b((p2) next);
                                }
                            }
                        } else {
                            Iterator it2 = arrayList2.iterator();
                            it2.getClass();
                            while (it2.hasNext()) {
                                Object next2 = it2.next();
                                next2.getClass();
                                hVar.b((p2) next2);
                            }
                        }
                    }
                }
                break;
        }
        return p6.x.f8463a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(y2.s sVar, ArrayList arrayList, t6.c cVar) {
        super(2, cVar);
        this.f9219b = sVar;
        this.f9220l = arrayList;
    }
}
