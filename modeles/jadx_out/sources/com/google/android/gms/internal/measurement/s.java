package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2789a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f2790b;

    public s(int i) {
        this.f2790b = i;
    }

    public static m c(y2.s sVar, List list) {
        w wVar = w.ADD;
        b2.t1.U("FN", 2, list);
        n c9 = ((t) sVar.f11756l).c(sVar, (n) list.get(0));
        n c10 = ((t) sVar.f11756l).c(sVar, (n) list.get(1));
        if (!(c10 instanceof d)) {
            com.google.gson.internal.a.p(a4.x.j("FN requires an ArrayValue of parameter names found ", c10.getClass().getCanonicalName()));
            return null;
        }
        List m10 = ((d) c10).m();
        List arrayList = new ArrayList();
        if (list.size() > 2) {
            arrayList = list.subList(2, list.size());
        }
        return new m(c9.f(), (ArrayList) m10, arrayList, sVar);
    }

    public static boolean d(n nVar, n nVar2) {
        if (nVar instanceof j) {
            nVar = new q(nVar.f());
        }
        if (nVar2 instanceof j) {
            nVar2 = new q(nVar2.f());
        }
        if ((nVar instanceof q) && (nVar2 instanceof q)) {
            return ((q) nVar).f2753a.compareTo(((q) nVar2).f2753a) < 0;
        }
        double doubleValue = nVar.g().doubleValue();
        double doubleValue2 = nVar2.g().doubleValue();
        return (Double.isNaN(doubleValue) || Double.isNaN(doubleValue2) || (doubleValue == 0.0d && doubleValue2 == 0.0d) || ((doubleValue == 0.0d && doubleValue2 == 0.0d) || Double.compare(doubleValue, doubleValue2) >= 0)) ? false : true;
    }

    public static n e(v vVar, n nVar, n nVar2) {
        if (nVar instanceof Iterable) {
            return g(vVar, ((Iterable) nVar).iterator(), nVar2);
        }
        com.google.gson.internal.a.p("Non-iterable type in for...of loop.");
        return null;
    }

    public static boolean f(n nVar, n nVar2) {
        if (nVar.getClass().equals(nVar2.getClass())) {
            if ((nVar instanceof r) || (nVar instanceof l)) {
                return true;
            }
            return nVar instanceof g ? (Double.isNaN(nVar.g().doubleValue()) || Double.isNaN(nVar2.g().doubleValue()) || nVar.g().doubleValue() != nVar2.g().doubleValue()) ? false : true : nVar instanceof q ? nVar.f().equals(nVar2.f()) : nVar instanceof e ? nVar.e().equals(nVar2.e()) : nVar == nVar2;
        }
        if (((nVar instanceof r) || (nVar instanceof l)) && ((nVar2 instanceof r) || (nVar2 instanceof l))) {
            return true;
        }
        boolean z9 = nVar instanceof g;
        if (z9 && (nVar2 instanceof q)) {
            return f(nVar, new g(nVar2.g()));
        }
        boolean z10 = nVar instanceof q;
        if (z10 && (nVar2 instanceof g)) {
            return f(new g(nVar.g()), nVar2);
        }
        if (nVar instanceof e) {
            return f(new g(nVar.g()), nVar2);
        }
        if (nVar2 instanceof e) {
            return f(nVar, new g(nVar2.g()));
        }
        if ((z10 || z9) && (nVar2 instanceof j)) {
            return f(nVar, new q(nVar2.f()));
        }
        if ((nVar instanceof j) && ((nVar2 instanceof q) || (nVar2 instanceof g))) {
            return f(new q(nVar.f()), nVar2);
        }
        return false;
    }

    public static n g(v vVar, Iterator it, n nVar) {
        y2.s L;
        if (it != null) {
            while (it.hasNext()) {
                n nVar2 = (n) it.next();
                switch (vVar.f2833a) {
                    case 0:
                        L = vVar.f2834b.L();
                        String str = vVar.f2835c;
                        L.O(str, nVar2);
                        ((HashMap) L.f11758n).put(str, Boolean.TRUE);
                        break;
                    case 1:
                        L = vVar.f2834b.L();
                        L.O(vVar.f2835c, nVar2);
                        break;
                    default:
                        L = vVar.f2834b;
                        L.O(vVar.f2835c, nVar2);
                        break;
                }
                n J = L.J((d) nVar);
                if (J instanceof f) {
                    f fVar = (f) J;
                    String str2 = fVar.f2568b;
                    if ("break".equals(str2)) {
                        return n.f2717c;
                    }
                    if ("return".equals(str2)) {
                        return fVar;
                    }
                }
            }
        }
        return n.f2717c;
    }

    public static boolean h(n nVar, n nVar2) {
        if (nVar instanceof j) {
            nVar = new q(nVar.f());
        }
        if (nVar2 instanceof j) {
            nVar2 = new q(nVar2.f());
        }
        return (((nVar instanceof q) && (nVar2 instanceof q)) || !(Double.isNaN(nVar.g().doubleValue()) || Double.isNaN(nVar2.g().doubleValue()))) && !d(nVar2, nVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:505:0x0baf  */
    /* JADX WARN: Removed duplicated region for block: B:507:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v101, types: [com.google.android.gms.internal.measurement.n] */
    /* JADX WARN: Type inference failed for: r12v104, types: [com.google.android.gms.internal.measurement.n] */
    /* JADX WARN: Type inference failed for: r12v320 */
    /* JADX WARN: Type inference failed for: r12v325 */
    /* JADX WARN: Type inference failed for: r12v344, types: [com.google.android.gms.internal.measurement.d] */
    /* JADX WARN: Type inference failed for: r12v351, types: [com.google.android.gms.internal.measurement.k] */
    /* JADX WARN: Type inference failed for: r12v386 */
    /* JADX WARN: Type inference failed for: r12v387 */
    /* JADX WARN: Type inference failed for: r13v0, types: [y2.s] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.n a(java.lang.String r12, y2.s r13, java.util.ArrayList r14) {
        /*
            Method dump skipped, instructions count: 3810
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.s.a(java.lang.String, y2.s, java.util.ArrayList):com.google.android.gms.internal.measurement.n");
    }

    public final void b(String str) {
        if (!this.f2789a.contains(b2.t1.Y(str))) {
            throw new IllegalArgumentException("Command not supported");
        }
        throw new UnsupportedOperationException("Command not implemented: ".concat(String.valueOf(str)));
    }
}
