package l6;

import androidx.lifecycle.ViewModel;
import c.i;
import h8.d;
import h9.g;
import h9.k;
import h9.s;
import h9.t;
import j9.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.l;
import l8.n;
import u5.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final m f7148a;

    /* renamed from: b, reason: collision with root package name */
    public final n f7149b;

    /* renamed from: c, reason: collision with root package name */
    public final f f7150c;

    public c(m mVar, n nVar, f fVar) {
        fVar.getClass();
        this.f7148a = mVar;
        this.f7149b = nVar;
        this.f7150c = fVar;
    }

    public final s a() {
        f fVar = this.f7150c;
        fVar.i();
        t tVar = fVar.f;
        if (tVar == null) {
            l.i("translationsText");
            throw null;
        }
        g gVar = tVar.f5606a;
        String str = gVar.Q;
        String str2 = gVar.A;
        String str3 = gVar.f5514c;
        k kVar = tVar.f5608c;
        return new s(str, str2, str3, kVar.f5549b, kVar.f5554l, fVar.b());
    }

    public final LinkedHashSet b(int i) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList c9 = c(i);
        c9.addAll(d(i));
        int size = c9.size();
        int i6 = 0;
        while (i6 < size) {
            Object obj = c9.get(i6);
            i6++;
            Boolean bool = ((i) obj).f1161b;
            if (bool != null) {
                linkedHashSet.add(bool);
            }
        }
        return linkedHashSet;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Iterable, java.lang.Object] */
    public final ArrayList c(int i) {
        int i6;
        int i10;
        LinkedHashMap linkedHashMap;
        int i11;
        Map map;
        h8.g gVar;
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        m mVar = this.f7148a;
        h8.c cVar = mVar.f10737a;
        if (cVar != null) {
            ?? r32 = cVar.f5462d;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : r32.entrySet()) {
                if (mVar.f10749r.contains(((h8.f) entry.getValue()).f5465a)) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                h8.c cVar2 = mVar.f10737a;
                if (cVar2 != null && (map = cVar2.i) != null && (gVar = (h8.g) map.get(String.valueOf(i))) != null && (arrayList = gVar.f5469c) != null && arrayList.contains(Integer.valueOf(((h8.f) entry2.getValue()).f5465a))) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
                int i12 = ((h8.f) entry3.getValue()).f5465a;
                h8.c cVar3 = mVar.f10737a;
                if (cVar3 == null || (linkedHashMap = cVar3.h) == null) {
                    i6 = 0;
                } else {
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    for (Map.Entry entry4 : linkedHashMap.entrySet()) {
                        if (((h8.i) entry4.getValue()).f5476k == null) {
                            linkedHashMap4.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    Iterator it = linkedHashMap4.entrySet().iterator();
                    i6 = 0;
                    while (it.hasNext()) {
                        Set set = ((h8.i) ((Map.Entry) it.next()).getValue()).f5474d;
                        if (set == null || !set.isEmpty()) {
                            Iterator it2 = set.iterator();
                            i11 = 0;
                            while (it2.hasNext()) {
                                if (((Number) it2.next()).intValue() == i12 && (i11 = i11 + 1) < 0) {
                                    q6.m.g0();
                                    throw null;
                                }
                            }
                        } else {
                            i11 = 0;
                        }
                        i6 += i11;
                    }
                }
                Iterator it3 = this.f7149b.f7239n.f7212t.f7228a.iterator();
                while (it3.hasNext()) {
                    ArrayList arrayList3 = ((l8.l) it3.next()).f;
                    if (arrayList3.isEmpty()) {
                        i10 = 0;
                    } else {
                        int size = arrayList3.size();
                        i10 = 0;
                        int i13 = 0;
                        while (i13 < size) {
                            Object obj = arrayList3.get(i13);
                            i13++;
                            if (((Number) obj).intValue() == i12 && (i10 = i10 + 1) < 0) {
                                q6.m.g0();
                                throw null;
                            }
                        }
                    }
                    i6 += i10;
                }
                if (i6 > 0) {
                    arrayList2.add(new i((d) entry3.getValue(), mVar.f10749r.get(((h8.f) entry3.getValue()).f5465a), 0, 5, this.f7150c.f().f5587d, Integer.valueOf(i6), 20));
                }
            }
        }
        return arrayList2;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.Map] */
    public final ArrayList d(int i) {
        LinkedHashMap linkedHashMap;
        int i6;
        Map map;
        h8.g gVar;
        ArrayList arrayList;
        ArrayList arrayList2 = new ArrayList();
        m mVar = this.f7148a;
        h8.c cVar = mVar.f10737a;
        if (cVar != null) {
            ?? r22 = cVar.g;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : r22.entrySet()) {
                if (mVar.f10748q.contains(((h8.b) entry.getValue()).f5465a)) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                h8.c cVar2 = mVar.f10737a;
                if (cVar2 != null && (map = cVar2.i) != null && (gVar = (h8.g) map.get(String.valueOf(i))) != null && (arrayList = gVar.f5470d) != null && arrayList.contains(Integer.valueOf(((h8.b) entry2.getValue()).f5465a))) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
                int i10 = ((h8.b) entry3.getValue()).f5465a;
                h8.c cVar3 = mVar.f10737a;
                int i11 = 0;
                if (cVar3 != null && (linkedHashMap = cVar3.h) != null) {
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    for (Map.Entry entry4 : linkedHashMap.entrySet()) {
                        if (((h8.i) entry4.getValue()).f5476k == null) {
                            linkedHashMap4.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    Iterator it = linkedHashMap4.entrySet().iterator();
                    int i12 = 0;
                    while (it.hasNext()) {
                        Set set = ((h8.i) ((Map.Entry) it.next()).getValue()).i;
                        if (set == null || !set.isEmpty()) {
                            Iterator it2 = set.iterator();
                            i6 = 0;
                            while (it2.hasNext()) {
                                if (((Number) it2.next()).intValue() == i10 && (i6 = i6 + 1) < 0) {
                                    q6.m.g0();
                                    throw null;
                                }
                            }
                        } else {
                            i6 = 0;
                        }
                        i12 += i6;
                    }
                    i11 = i12;
                }
                if (i11 > 0) {
                    arrayList2.add(new i((d) entry3.getValue(), mVar.f10748q.get(((h8.b) entry3.getValue()).f5465a), 0, 8, this.f7150c.f().f5587d, Integer.valueOf(i11), 20));
                }
            }
        }
        return arrayList2;
    }
}
