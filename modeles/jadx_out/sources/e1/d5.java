package e1;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.r7;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d5 {

    /* renamed from: a, reason: collision with root package name */
    public final String f3877a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3878b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.m3 f3879c;

    /* renamed from: d, reason: collision with root package name */
    public final BitSet f3880d;

    /* renamed from: e, reason: collision with root package name */
    public final BitSet f3881e;
    public final ArrayMap f;
    public final ArrayMap g;
    public final /* synthetic */ c h;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ d5(c cVar, String str, com.google.android.gms.internal.measurement.m3 m3Var, BitSet bitSet, BitSet bitSet2, ArrayMap arrayMap, ArrayMap arrayMap2) {
        this.h = cVar;
        this.f3877a = str;
        this.f3880d = bitSet;
        this.f3881e = bitSet2;
        this.f = arrayMap;
        this.g = new ArrayMap();
        for (K k5 : arrayMap2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) arrayMap2.get(k5));
            this.g.put(k5, arrayList);
        }
        this.f3878b = false;
        this.f3879c = m3Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(b bVar) {
        int p10;
        boolean z9;
        boolean u7;
        switch (bVar.g) {
            case 0:
                p10 = ((com.google.android.gms.internal.measurement.o1) bVar.i).p();
                break;
            default:
                p10 = ((com.google.android.gms.internal.measurement.v1) bVar.i).p();
                break;
        }
        if (bVar.f3781c != null) {
            this.f3881e.set(p10, true);
        }
        Boolean bool = bVar.f3782d;
        if (bool != null) {
            this.f3880d.set(p10, bool.booleanValue());
        }
        if (bVar.f3783e != null) {
            Integer valueOf = Integer.valueOf(p10);
            ArrayMap arrayMap = this.f;
            Long l10 = (Long) arrayMap.get(valueOf);
            long longValue = bVar.f3783e.longValue() / 1000;
            if (l10 == null || longValue > l10.longValue()) {
                arrayMap.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (bVar.f != null) {
            Integer valueOf2 = Integer.valueOf(p10);
            ArrayMap arrayMap2 = this.g;
            List list = (List) arrayMap2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                arrayMap2.put(valueOf2, list);
            }
            switch (bVar.g) {
                case 0:
                    z9 = false;
                    break;
                default:
                    z9 = true;
                    break;
            }
            if (z9) {
                list.clear();
            }
            r7.a();
            t1 t1Var = this.h.f3875a;
            g gVar = t1Var.f4262m;
            e0 e0Var = f0.G0;
            String str = this.f3877a;
            if (gVar.q(str, e0Var)) {
                switch (bVar.g) {
                    case 0:
                        u7 = ((com.google.android.gms.internal.measurement.o1) bVar.i).u();
                        break;
                    default:
                        u7 = false;
                        break;
                }
                if (u7) {
                    list.clear();
                }
            }
            r7.a();
            boolean q9 = t1Var.f4262m.q(str, e0Var);
            Long l11 = bVar.f;
            if (!q9) {
                list.add(Long.valueOf(l11.longValue() / 1000));
                return;
            }
            Long valueOf3 = Long.valueOf(l11.longValue() / 1000);
            if (list.contains(valueOf3)) {
                return;
            }
            list.add(valueOf3);
        }
    }

    public final com.google.android.gms.internal.measurement.t2 b(int i) {
        ArrayList arrayList;
        List list;
        com.google.android.gms.internal.measurement.s2 v = com.google.android.gms.internal.measurement.t2.v();
        v.b();
        ((com.google.android.gms.internal.measurement.t2) v.f2687b).w(i);
        v.b();
        ((com.google.android.gms.internal.measurement.t2) v.f2687b).z(this.f3878b);
        com.google.android.gms.internal.measurement.m3 m3Var = this.f3879c;
        if (m3Var != null) {
            v.b();
            ((com.google.android.gms.internal.measurement.t2) v.f2687b).y(m3Var);
        }
        com.google.android.gms.internal.measurement.l3 w2 = com.google.android.gms.internal.measurement.m3.w();
        ArrayList O = a1.O(this.f3880d);
        w2.b();
        ((com.google.android.gms.internal.measurement.m3) w2.f2687b).A(O);
        ArrayList O2 = a1.O(this.f3881e);
        w2.b();
        ((com.google.android.gms.internal.measurement.m3) w2.f2687b).y(O2);
        ArrayMap arrayMap = this.f;
        if (arrayMap == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(arrayMap.size());
            for (Integer num : arrayMap.keySet()) {
                int intValue = num.intValue();
                Long l10 = (Long) arrayMap.get(num);
                if (l10 != null) {
                    com.google.android.gms.internal.measurement.y2 s6 = com.google.android.gms.internal.measurement.z2.s();
                    s6.b();
                    ((com.google.android.gms.internal.measurement.z2) s6.f2687b).t(intValue);
                    long longValue = l10.longValue();
                    s6.b();
                    ((com.google.android.gms.internal.measurement.z2) s6.f2687b).u(longValue);
                    arrayList2.add((com.google.android.gms.internal.measurement.z2) s6.d());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            w2.b();
            ((com.google.android.gms.internal.measurement.m3) w2.f2687b).C(arrayList);
        }
        ArrayMap arrayMap2 = this.g;
        if (arrayMap2 == null) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList3 = new ArrayList(arrayMap2.size());
            for (Integer num2 : arrayMap2.keySet()) {
                com.google.android.gms.internal.measurement.n3 t9 = com.google.android.gms.internal.measurement.o3.t();
                int intValue2 = num2.intValue();
                t9.b();
                ((com.google.android.gms.internal.measurement.o3) t9.f2687b).u(intValue2);
                List list2 = (List) arrayMap2.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    t9.b();
                    ((com.google.android.gms.internal.measurement.o3) t9.f2687b).v(list2);
                }
                arrayList3.add((com.google.android.gms.internal.measurement.o3) t9.d());
            }
            list = arrayList3;
        }
        w2.b();
        ((com.google.android.gms.internal.measurement.m3) w2.f2687b).E(list);
        v.b();
        ((com.google.android.gms.internal.measurement.t2) v.f2687b).x((com.google.android.gms.internal.measurement.m3) w2.d());
        return (com.google.android.gms.internal.measurement.t2) v.d();
    }

    public /* synthetic */ d5(c cVar, String str) {
        this.h = cVar;
        this.f3877a = str;
        this.f3878b = true;
        this.f3880d = new BitSet();
        this.f3881e = new BitSet();
        this.f = new ArrayMap();
        this.g = new ArrayMap();
    }
}
