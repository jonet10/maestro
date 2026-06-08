package r7;

import c4.dd;
import c4.j1;
import c4.ya;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class d implements s7.i {

    /* renamed from: a, reason: collision with root package name */
    public final t6.h f8963a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8964b;

    /* renamed from: l, reason: collision with root package name */
    public final q7.a f8965l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f8966m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f8967n;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(h hVar, t6.h hVar2, int i, q7.a aVar, int i6) {
        this((Object) hVar, (i6 & 2) != 0 ? t6.i.f10314a : hVar2, (i6 & 4) != 0 ? -3 : i, (i6 & 8) != 0 ? q7.a.f8729a : aVar, 1);
        this.f8966m = 1;
    }

    @Override // s7.i
    public final h a(t6.h hVar, int i, q7.a aVar) {
        t6.h hVar2 = this.f8963a;
        t6.h plus = hVar.plus(hVar2);
        q7.a aVar2 = q7.a.f8729a;
        q7.a aVar3 = this.f8965l;
        int i6 = this.f8964b;
        if (aVar == aVar2) {
            if (i6 != -3) {
                if (i != -3) {
                    if (i6 != -2) {
                        if (i != -2) {
                            i += i6;
                            if (i < 0) {
                                i = Integer.MAX_VALUE;
                            }
                        }
                    }
                }
                i = i6;
            }
            aVar = aVar3;
        }
        return (kotlin.jvm.internal.l.a(plus, hVar2) && i == i6 && aVar == aVar3) ? this : d(plus, i, aVar);
    }

    public final Object b(i iVar, t6.c cVar) {
        Object i = o7.c0.i(new b6.g(iVar, this, null, 23), cVar);
        return i == u6.a.f10762a ? i : p6.x.f8463a;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [d7.p, v6.i] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Iterable, java.lang.Object] */
    public Object c(q7.s sVar, t6.c cVar) {
        switch (this.f8966m) {
            case 0:
                Object invoke = ((v6.i) this.f8967n).invoke(sVar, cVar);
                return invoke == u6.a.f10762a ? invoke : p6.x.f8463a;
            case 1:
                Object collect = ((h) this.f8967n).collect(new s7.o(sVar), cVar);
                p6.x xVar = p6.x.f8463a;
                u6.a aVar = u6.a.f10762a;
                if (collect != aVar) {
                    collect = xVar;
                }
                return collect == aVar ? collect : xVar;
            default:
                s7.o oVar = new s7.o(sVar);
                Iterator it = this.f8967n.iterator();
                while (it.hasNext()) {
                    o7.c0.s(sVar, null, null, new ya((h) it.next(), oVar, (t6.c) null, 28), 3);
                }
                return p6.x.f8463a;
        }
    }

    @Override // r7.h
    public Object collect(i iVar, t6.c cVar) {
        Object b7;
        switch (this.f8966m) {
            case 1:
                int i = this.f8964b;
                u6.a aVar = u6.a.f10762a;
                p6.x xVar = p6.x.f8463a;
                if (i == -3) {
                    t6.h context = cVar.getContext();
                    Boolean bool = Boolean.FALSE;
                    j1 j1Var = new j1(9);
                    t6.h hVar = this.f8963a;
                    t6.h plus = !((Boolean) hVar.fold(bool, j1Var)).booleanValue() ? context.plus(hVar) : o7.c0.l(context, hVar, false);
                    if (kotlin.jvm.internal.l.a(plus, context)) {
                        b7 = ((h) this.f8967n).collect(iVar, cVar);
                        if (b7 != aVar) {
                            b7 = xVar;
                        }
                        if (b7 != aVar) {
                            return xVar;
                        }
                    } else {
                        t6.d dVar = t6.d.f10313a;
                        if (kotlin.jvm.internal.l.a(plus.get(dVar), context.get(dVar))) {
                            t6.h context2 = cVar.getContext();
                            if (!(iVar instanceof s7.o) && !(iVar instanceof s7.k)) {
                                iVar = new dd(iVar, context2);
                            }
                            b7 = s7.c.b(plus, iVar, t7.a.k(plus), new ya(this, null, 27), cVar);
                            if (b7 != aVar) {
                                return xVar;
                            }
                        }
                    }
                    return b7;
                }
                b7 = b(iVar, cVar);
                if (b7 != aVar) {
                    return xVar;
                }
                return b7;
            default:
                return b(iVar, cVar);
        }
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [d7.p, v6.i] */
    public d d(t6.h hVar, int i, q7.a aVar) {
        switch (this.f8966m) {
            case 0:
                return new d((v6.i) this.f8967n, hVar, i, aVar);
            case 1:
                return new d(this.f8967n, hVar, i, aVar, 1);
            default:
                return new d(this.f8967n, hVar, i, aVar, 2);
        }
    }

    public final String e() {
        ArrayList arrayList = new ArrayList(4);
        t6.i iVar = t6.i.f10314a;
        t6.h hVar = this.f8963a;
        if (hVar != iVar) {
            arrayList.add("context=" + hVar);
        }
        int i = this.f8964b;
        if (i != -3) {
            arrayList.add("capacity=" + i);
        }
        q7.a aVar = q7.a.f8729a;
        q7.a aVar2 = this.f8965l;
        if (aVar2 != aVar) {
            arrayList.add("onBufferOverflow=" + aVar2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        return a4.x.m(sb, q6.l.x0(arrayList, ", ", null, null, null, 62), ']');
    }

    public String toString() {
        switch (this.f8966m) {
            case 0:
                return "block[" + ((v6.i) this.f8967n) + "] -> " + e();
            case 1:
                return ((h) this.f8967n) + " -> " + e();
            default:
                return e();
        }
    }

    public d(t6.h hVar, int i, q7.a aVar) {
        this.f8963a = hVar;
        this.f8964b = i;
        this.f8965l = aVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(Object obj, t6.h hVar, int i, q7.a aVar, int i6) {
        this(hVar, i, aVar);
        this.f8966m = i6;
        this.f8967n = obj;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(d7.p pVar, t6.h hVar, int i, q7.a aVar) {
        this(hVar, i, aVar);
        this.f8966m = 0;
        this.f8967n = (v6.i) pVar;
    }
}
