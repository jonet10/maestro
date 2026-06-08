package n;

import a4.x;
import androidx.lifecycle.ViewModel;
import c.j;
import h8.i;
import h9.g;
import h9.k;
import h9.t;
import j9.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import l8.n;
import q6.l;
import u5.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class e extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final m f7889a;

    /* renamed from: b, reason: collision with root package name */
    public final n f7890b;

    /* renamed from: c, reason: collision with root package name */
    public final l8.m f7891c;

    /* renamed from: d, reason: collision with root package name */
    public final f f7892d;

    /* renamed from: e, reason: collision with root package name */
    public final i f7893e;
    public final List f;
    public final List g;
    public final List h;
    public final List i;
    public int j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7894k;

    /* renamed from: l, reason: collision with root package name */
    public final int f7895l;

    public e(m mVar, n nVar, l8.m mVar2, f fVar, i iVar, List list, List list2, List list3, List list4) {
        mVar2.getClass();
        fVar.getClass();
        list.getClass();
        list2.getClass();
        list3.getClass();
        list4.getClass();
        this.f7889a = mVar;
        this.f7890b = nVar;
        this.f7891c = mVar2;
        this.f7892d = fVar;
        this.f7893e = iVar;
        this.f = list;
        this.g = list2;
        this.h = list3;
        this.i = list4;
        this.j = 1;
        this.f7895l = 4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String a(Set set, int i) {
        Set J0;
        h8.d dVar;
        set.getClass();
        Map map = null;
        map = null;
        map = null;
        map = null;
        map = null;
        if (i == 0) {
            throw null;
        }
        int c9 = j.c(i);
        m mVar = this.f7889a;
        if (c9 == 0) {
            J0 = l.J0(this.f);
            h8.c cVar = mVar.f10737a;
            if (cVar != null) {
                map = cVar.f5462d;
            }
        } else if (c9 == 1) {
            J0 = l.J0(this.g);
            h8.c cVar2 = mVar.f10737a;
            if (cVar2 != null) {
                map = cVar2.f5463e;
            }
        } else if (c9 == 2) {
            J0 = l.J0(this.h);
            h8.c cVar3 = mVar.f10737a;
            if (cVar3 != null) {
                map = cVar3.f;
            }
        } else if (c9 == 3) {
            J0 = l.J0(this.i);
            h8.c cVar4 = mVar.f10737a;
            if (cVar4 != null) {
                map = cVar4.g;
            }
        } else {
            if (c9 != 4) {
                com.google.gson.internal.a.b();
                return null;
            }
            J0 = l.J0(set);
            h8.c cVar5 = mVar.f10737a;
            if (cVar5 != null) {
                map = cVar5.j;
            }
        }
        TreeSet treeSet = new TreeSet();
        l.E0(set, treeSet);
        ArrayList arrayList = new ArrayList();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (J0.contains((Integer) next)) {
                arrayList.add(next);
            }
        }
        int size = arrayList.size();
        String str = "";
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            Integer num = (Integer) obj;
            if (map != null && (dVar = (h8.d) map.get(String.valueOf(num))) != null) {
                StringBuilder t9 = x.t(str);
                t9.append(String.format("• %s.", Arrays.copyOf(new Object[]{dVar.f5466b}, 1)));
                t9.append('\n');
                str = t9.toString();
            }
        }
        return str;
    }

    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.Iterable, java.lang.Object] */
    public final ArrayList b(String str) {
        ArrayList f;
        c.i iVar;
        boolean z9;
        Set set;
        int i;
        int i6;
        h8.c cVar;
        LinkedHashMap linkedHashMap;
        int i10;
        int i11;
        int i12;
        Set set2;
        str.getClass();
        int c9 = j.c(this.j);
        int i13 = 2;
        i iVar2 = this.f7893e;
        m mVar = this.f7889a;
        int i14 = 0;
        if (c9 != 0) {
            f = c9 != 1 ? c9 != 2 ? new ArrayList() : f() : d();
        } else {
            f = f();
            f.addAll(d());
            if ((iVar2 == null ? null : iVar2.f5475e) == null || iVar2.f5475e.isEmpty()) {
                iVar = null;
            } else {
                i iVar3 = this.f7893e;
                if (iVar3 != null && (set = iVar3.f5475e) != null) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        if (!kotlin.jvm.internal.l.a(mVar.f10753w.get(((Number) it.next()).intValue()), Boolean.TRUE)) {
                            z9 = false;
                            break;
                        }
                    }
                }
                z9 = true;
                iVar = new c.i(iVar3, Boolean.valueOf(z9), 0, 4, null, null, 116);
            }
            if (iVar != null) {
                f.add(0, iVar);
            }
        }
        f.add(0, new c.i(null, null, 3, 0, e().h, null, 91));
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, new c.i(null, null, 3, 0, e().g, null, 91));
        LinkedHashMap g = g();
        if (g == null) {
            i6 = 0;
            i = 5;
        } else {
            for (Map.Entry entry : g.entrySet()) {
                int i15 = ((h8.f) entry.getValue()).f5465a;
                int i16 = this.j;
                if (!(i16 == 1 || i16 == i13) || (cVar = mVar.f10737a) == null || (linkedHashMap = cVar.h) == null) {
                    i10 = i14;
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                        if (((i) entry2.getValue()).f5476k == null) {
                            linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                    Iterator it2 = linkedHashMap2.entrySet().iterator();
                    i10 = i14;
                    while (it2.hasNext()) {
                        Set set3 = ((i) ((Map.Entry) it2.next()).getValue()).f5475e;
                        if (set3 == null || !set3.isEmpty()) {
                            Iterator it3 = set3.iterator();
                            i11 = i14;
                            while (it3.hasNext()) {
                                if (((Number) it3.next()).intValue() == i15 && (i11 = i11 + 1) < 0) {
                                    q6.m.g0();
                                    throw null;
                                }
                            }
                        } else {
                            i11 = i14;
                        }
                        i10 += i11;
                    }
                }
                int i17 = this.j;
                if (i17 == 1 || i17 == 3) {
                    Iterator it4 = this.f7890b.f7239n.f7212t.f7228a.iterator();
                    while (it4.hasNext()) {
                        ArrayList arrayList2 = ((l8.l) it4.next()).g;
                        if (arrayList2.isEmpty()) {
                            i12 = i14;
                        } else {
                            int size = arrayList2.size();
                            int i18 = i14;
                            i12 = i18;
                            while (i18 < size) {
                                Object obj = arrayList2.get(i18);
                                i18++;
                                if (((Number) obj).intValue() == i15 && (i12 = i12 + 1) < 0) {
                                    q6.m.g0();
                                    throw null;
                                }
                            }
                        }
                        i10 += i12;
                        i14 = 0;
                    }
                }
                if (this.j == 1 && iVar2 != null && (set2 = iVar2.f5475e) != null && set2.contains(Integer.valueOf(i15))) {
                    i10++;
                }
                if (i10 > 0) {
                    arrayList.add(new c.i((h8.d) entry.getValue(), mVar.f10750s.get(((h8.f) entry.getValue()).f5465a), 0, 5, this.f7892d.f().f5587d, Integer.valueOf(i10), 4));
                }
                i13 = 2;
                i14 = 0;
            }
            i = 5;
            i6 = i14;
        }
        f.addAll(i6, arrayList);
        if (str.length() <= 0) {
            return f;
        }
        ArrayList arrayList3 = new ArrayList();
        int size2 = f.size();
        int i19 = i6;
        while (i19 < size2) {
            Object obj2 = f.get(i19);
            i19++;
            c.i iVar4 = (c.i) obj2;
            if (iVar4.f1163d != i && l7.m.q0(iVar4.f1160a.f5466b, str, true)) {
                arrayList3.add(obj2);
            }
        }
        return new ArrayList(arrayList3);
    }

    public final LinkedHashSet c() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList b7 = b("");
        int size = b7.size();
        int i = 0;
        while (i < size) {
            Object obj = b7.get(i);
            i++;
            Boolean bool = ((c.i) obj).f1161b;
            if (bool != null) {
                linkedHashSet.add(bool);
            }
        }
        return linkedHashSet;
    }

    public final ArrayList d() {
        LinkedHashMap linkedHashMap;
        ArrayList arrayList = new ArrayList();
        m mVar = this.f7889a;
        h8.c cVar = mVar.f10737a;
        if (cVar != null && (linkedHashMap = cVar.h) != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (((i) entry.getValue()).f5476k == null) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                if (!((i) entry2.getValue()).f5475e.isEmpty()) {
                    arrayList.add(new c.i((h8.d) entry2.getValue(), mVar.C.get(((i) entry2.getValue()).f5465a), 0, 0, null, null, 124));
                }
            }
        }
        return arrayList;
    }

    public final h9.j e() {
        f fVar = this.f7892d;
        fVar.i();
        t tVar = fVar.f;
        if (tVar == null) {
            kotlin.jvm.internal.l.i("translationsText");
            throw null;
        }
        g gVar = tVar.f5606a;
        String str = gVar.f5524r;
        String str2 = gVar.G;
        String str3 = gVar.K;
        String str4 = gVar.L;
        String str5 = gVar.M;
        k kVar = tVar.f5608c;
        return new h9.j(str, str2, str3, str4, str5, kVar.f5549b, gVar.Q, gVar.f5523q, kVar.f5551d, kVar.f5552e, fVar.b());
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Iterable, java.lang.Object] */
    public final ArrayList f() {
        ArrayList arrayList = new ArrayList();
        for (l8.l lVar : this.f7891c.f7228a) {
            if (!lVar.g.isEmpty()) {
                arrayList.add(new c.i(lVar.a(), this.f7889a.D.get(lVar.f7223a), 0, 2, null, null, 116));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.Map] */
    public final LinkedHashMap g() {
        m mVar = this.f7889a;
        h8.c cVar = mVar.f10737a;
        if (cVar == null) {
            return null;
        }
        ?? r12 = cVar.f5462d;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : r12.entrySet()) {
            if (mVar.f10750s.contains(((h8.f) entry.getValue()).f5465a)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (mVar.h.equals("DE")) {
            return linkedHashMap;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            if (((h8.f) entry2.getValue()).f5465a != 1) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        return linkedHashMap2;
    }
}
