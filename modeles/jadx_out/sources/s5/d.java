package s5;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.inmobi.cmp.core.model.portalconfig.PrivacyEncodingMode;
import h8.g;
import h8.i;
import h9.r;
import j9.f;
import j9.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l8.l;
import l8.n;
import q6.v;
import u5.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final m f9334a;

    /* renamed from: b, reason: collision with root package name */
    public final n f9335b;

    /* renamed from: c, reason: collision with root package name */
    public final u5.d f9336c;

    /* renamed from: d, reason: collision with root package name */
    public final i f9337d;

    /* renamed from: e, reason: collision with root package name */
    public final h f9338e;
    public final f f;
    public final List g;
    public final List h;
    public final List i;
    public final List j;

    /* renamed from: k, reason: collision with root package name */
    public final k6.c f9339k;

    /* renamed from: l, reason: collision with root package name */
    public final int f9340l;

    /* renamed from: m, reason: collision with root package name */
    public final LinkedHashSet f9341m;

    /* renamed from: n, reason: collision with root package name */
    public final LinkedHashSet f9342n;

    /* renamed from: o, reason: collision with root package name */
    public final MutableLiveData f9343o;

    public d(m mVar, n nVar, u5.d dVar, i iVar, h hVar, f fVar, ArrayList arrayList, List list, List list2, List list3, k6.c cVar) {
        dVar.getClass();
        hVar.getClass();
        fVar.getClass();
        arrayList.getClass();
        list.getClass();
        list2.getClass();
        list3.getClass();
        this.f9334a = mVar;
        this.f9335b = nVar;
        this.f9336c = dVar;
        this.f9337d = iVar;
        this.f9338e = hVar;
        this.f = fVar;
        this.g = arrayList;
        this.h = list;
        this.i = list2;
        this.j = list3;
        this.f9339k = cVar;
        this.f9340l = 2;
        this.f9341m = new LinkedHashSet();
        this.f9342n = new LinkedHashSet();
        this.f9343o = new MutableLiveData();
    }

    public final c.i a(String str, Set set, int i) {
        i iVar;
        if (str.equals("ALL_VENDORS") && (iVar = this.f9337d) != null && set.contains(Integer.valueOf(i))) {
            return new c.i(iVar, null, 4, 10, iVar.f5466b, null, 82);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Iterable, java.lang.Object] */
    public final ArrayList b() {
        int i;
        int i6;
        LinkedHashMap linkedHashMap;
        int i10;
        Map map;
        g gVar;
        ArrayList arrayList = new ArrayList();
        m mVar = this.f9334a;
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
                LinkedHashSet linkedHashSet = this.f9341m;
                if (linkedHashSet.isEmpty()) {
                    Iterator it = this.j.iterator();
                    while (it.hasNext()) {
                        int intValue = ((Number) it.next()).intValue();
                        h8.c cVar2 = mVar.f10737a;
                        Collection collection = (cVar2 == null || (map = cVar2.i) == null || (gVar = (g) map.get(String.valueOf(intValue))) == null) ? null : gVar.f5469c;
                        if (collection == null) {
                            collection = v.f8726a;
                        }
                        linkedHashSet.addAll(collection);
                    }
                }
                if (!linkedHashSet.contains(Integer.valueOf(((h8.f) entry2.getValue()).f5465a))) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
                int i11 = ((h8.f) entry3.getValue()).f5465a;
                h8.c cVar3 = mVar.f10737a;
                if (cVar3 == null || (linkedHashMap = cVar3.h) == null) {
                    i = 0;
                } else {
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    for (Map.Entry entry4 : linkedHashMap.entrySet()) {
                        if (((i) entry4.getValue()).f5476k == null) {
                            linkedHashMap4.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    Iterator it2 = linkedHashMap4.entrySet().iterator();
                    i = 0;
                    while (it2.hasNext()) {
                        Set set = ((i) ((Map.Entry) it2.next()).getValue()).f5474d;
                        if (set == null || !set.isEmpty()) {
                            Iterator it3 = set.iterator();
                            i10 = 0;
                            while (it3.hasNext()) {
                                if (((Number) it3.next()).intValue() == i11 && (i10 = i10 + 1) < 0) {
                                    q6.m.g0();
                                    throw null;
                                }
                            }
                        } else {
                            i10 = 0;
                        }
                        i += i10;
                    }
                }
                n nVar = this.f9335b;
                Iterator it4 = nVar.f7239n.f7212t.f7228a.iterator();
                while (it4.hasNext()) {
                    ArrayList arrayList2 = ((l) it4.next()).f;
                    if (arrayList2.isEmpty()) {
                        i6 = 0;
                    } else {
                        int size = arrayList2.size();
                        i6 = 0;
                        int i12 = 0;
                        while (i12 < size) {
                            Object obj = arrayList2.get(i12);
                            i12++;
                            if (((Number) obj).intValue() == i11 && (i6 = i6 + 1) < 0) {
                                q6.m.g0();
                                throw null;
                            }
                        }
                    }
                    i += i6;
                }
                Iterator it5 = nVar.f7239n.f7204l.iterator();
                while (it5.hasNext()) {
                    if (((Number) it5.next()).intValue() == i11) {
                        i++;
                    }
                }
                if (i > 0) {
                    arrayList.add(new c.i((h8.d) entry3.getValue(), mVar.f10749r.get(((h8.f) entry3.getValue()).f5465a), 0, 5, this.f.f().f5587d, Integer.valueOf(i), 20));
                }
            }
        }
        arrayList.addAll(c());
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Iterable, java.lang.Object] */
    public final ArrayList c() {
        LinkedHashMap linkedHashMap;
        int i;
        Map map;
        g gVar;
        ArrayList arrayList = new ArrayList();
        m mVar = this.f9334a;
        h8.c cVar = mVar.f10737a;
        if (cVar != null) {
            ?? r32 = cVar.g;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : r32.entrySet()) {
                if (mVar.f10748q.contains(((h8.b) entry.getValue()).f5465a)) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                LinkedHashSet linkedHashSet = this.f9342n;
                if (linkedHashSet.isEmpty()) {
                    Iterator it = this.j.iterator();
                    while (it.hasNext()) {
                        int intValue = ((Number) it.next()).intValue();
                        h8.c cVar2 = mVar.f10737a;
                        Collection collection = (cVar2 == null || (map = cVar2.i) == null || (gVar = (g) map.get(String.valueOf(intValue))) == null) ? null : gVar.f5470d;
                        if (collection == null) {
                            collection = v.f8726a;
                        }
                        linkedHashSet.addAll(collection);
                    }
                }
                if (!linkedHashSet.contains(Integer.valueOf(((h8.b) entry2.getValue()).f5465a))) {
                    linkedHashMap3.put(entry2.getKey(), entry2.getValue());
                }
            }
            for (Map.Entry entry3 : linkedHashMap3.entrySet()) {
                int i6 = ((h8.b) entry3.getValue()).f5465a;
                h8.c cVar3 = mVar.f10737a;
                int i10 = 0;
                if (cVar3 != null && (linkedHashMap = cVar3.h) != null) {
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    for (Map.Entry entry4 : linkedHashMap.entrySet()) {
                        if (((i) entry4.getValue()).f5476k == null) {
                            linkedHashMap4.put(entry4.getKey(), entry4.getValue());
                        }
                    }
                    Iterator it2 = linkedHashMap4.entrySet().iterator();
                    int i11 = 0;
                    while (it2.hasNext()) {
                        Set set = ((i) ((Map.Entry) it2.next()).getValue()).i;
                        if (set == null || !set.isEmpty()) {
                            Iterator it3 = set.iterator();
                            i = 0;
                            while (it3.hasNext()) {
                                if (((Number) it3.next()).intValue() == i6 && (i = i + 1) < 0) {
                                    q6.m.g0();
                                    throw null;
                                }
                            }
                        } else {
                            i = 0;
                        }
                        i11 += i;
                    }
                    i10 = i11;
                }
                Iterator it4 = this.f9335b.f7239n.f7208p.iterator();
                while (it4.hasNext()) {
                    if (((Number) it4.next()).intValue() == i6) {
                        i10++;
                    }
                }
                if (i10 > 0) {
                    arrayList.add(new c.i((h8.d) entry3.getValue(), mVar.f10748q.get(((h8.b) entry3.getValue()).f5465a), 0, 8, this.f.f().f5587d, Integer.valueOf(i10), 20));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r10v23, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v16, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object, java.util.Map] */
    public final ArrayList d() {
        int i;
        LinkedHashMap linkedHashMap;
        int i6;
        int i10;
        LinkedHashMap linkedHashMap2;
        int i11;
        ArrayList arrayList = new ArrayList();
        m mVar = this.f9334a;
        h8.c cVar = mVar.f10737a;
        f fVar = this.f;
        n nVar = this.f9335b;
        if (cVar != null) {
            ?? r32 = cVar.f5463e;
            LinkedHashMap linkedHashMap3 = new LinkedHashMap();
            for (Map.Entry entry : r32.entrySet()) {
                if (this.h.contains(Integer.valueOf(((h8.f) entry.getValue()).f5465a)) || nVar.f7239n.f7206n.contains(Integer.valueOf(((h8.f) entry.getValue()).f5465a))) {
                    linkedHashMap3.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap3.entrySet()) {
                int i12 = ((h8.f) entry2.getValue()).f5465a;
                h8.c cVar2 = mVar.f10737a;
                if (cVar2 == null || (linkedHashMap2 = cVar2.h) == null) {
                    i10 = 0;
                } else {
                    LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                    for (Map.Entry entry3 : linkedHashMap2.entrySet()) {
                        if (((i) entry3.getValue()).f5476k == null) {
                            linkedHashMap4.put(entry3.getKey(), entry3.getValue());
                        }
                    }
                    Iterator it = linkedHashMap4.entrySet().iterator();
                    i10 = 0;
                    while (it.hasNext()) {
                        Set set = ((i) ((Map.Entry) it.next()).getValue()).g;
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
                        i10 += i11;
                    }
                }
                Iterator it3 = nVar.f7239n.f7206n.iterator();
                while (it3.hasNext()) {
                    if (((Number) it3.next()).intValue() == i12) {
                        i10++;
                    }
                }
                if (i10 > 0) {
                    arrayList.add(new c.i((h8.d) entry2.getValue(), null, 0, 6, fVar.f().f5587d, Integer.valueOf(i10), 22));
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        h8.c cVar3 = mVar.f10737a;
        if (cVar3 != null) {
            ?? r82 = cVar3.f;
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            for (Map.Entry entry4 : r82.entrySet()) {
                if (this.i.contains(Integer.valueOf(((h8.b) entry4.getValue()).f5465a)) || nVar.f7239n.f7207o.contains(Integer.valueOf(((h8.b) entry4.getValue()).f5465a))) {
                    linkedHashMap5.put(entry4.getKey(), entry4.getValue());
                }
            }
            for (Map.Entry entry5 : linkedHashMap5.entrySet()) {
                int i13 = ((h8.b) entry5.getValue()).f5465a;
                h8.c cVar4 = mVar.f10737a;
                if (cVar4 == null || (linkedHashMap = cVar4.h) == null) {
                    i = 0;
                } else {
                    LinkedHashMap linkedHashMap6 = new LinkedHashMap();
                    for (Map.Entry entry6 : linkedHashMap.entrySet()) {
                        if (((i) entry6.getValue()).f5476k == null) {
                            linkedHashMap6.put(entry6.getKey(), entry6.getValue());
                        }
                    }
                    Iterator it4 = linkedHashMap6.entrySet().iterator();
                    i = 0;
                    while (it4.hasNext()) {
                        Set set2 = ((i) ((Map.Entry) it4.next()).getValue()).h;
                        if (set2 == null || !set2.isEmpty()) {
                            Iterator it5 = set2.iterator();
                            i6 = 0;
                            while (it5.hasNext()) {
                                if (((Number) it5.next()).intValue() == i13 && (i6 = i6 + 1) < 0) {
                                    q6.m.g0();
                                    throw null;
                                }
                            }
                        } else {
                            i6 = 0;
                        }
                        i += i6;
                    }
                }
                Iterator it6 = nVar.f7239n.f7207o.iterator();
                while (it6.hasNext()) {
                    if (((Number) it6.next()).intValue() == i13) {
                        i++;
                    }
                }
                if (i > 0) {
                    arrayList2.add(new c.i((h8.d) entry5.getValue(), null, 0, 7, fVar.f().f5587d, Integer.valueOf(i), 22));
                }
            }
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    public final ArrayList e() {
        Map map;
        Map map2;
        g gVar;
        LinkedHashMap linkedHashMap;
        ArrayList arrayList = new ArrayList();
        m mVar = this.f9334a;
        h8.c cVar = mVar.f10737a;
        if (cVar != null && (map = cVar.i) != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : map.entrySet()) {
                if (this.j.contains(Integer.valueOf(((g) entry.getValue()).f5465a))) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                ArrayList arrayList2 = ((g) entry2.getValue()).f5469c;
                int size = arrayList2.size();
                boolean z9 = false;
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    int intValue = ((Number) obj).intValue();
                    h8.c cVar2 = mVar.f10737a;
                    if (cVar2 != null && (linkedHashMap = cVar2.h) != null) {
                        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                            if (((i) entry3.getValue()).f5476k == null && ((i) entry3.getValue()).f5474d.contains(Integer.valueOf(intValue))) {
                                z9 = true;
                            }
                        }
                    }
                }
                if (z9) {
                    int i6 = ((g) entry2.getValue()).f5465a;
                    String str = ((g) entry2.getValue()).f5466b;
                    int i10 = ((g) entry2.getValue()).f5465a;
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    h8.c cVar3 = mVar.f10737a;
                    if (cVar3 != null && (map2 = cVar3.i) != null && (gVar = (g) map2.get(String.valueOf(i10))) != null) {
                        ArrayList arrayList3 = gVar.f5469c;
                        ArrayList arrayList4 = new ArrayList();
                        int size2 = arrayList3.size();
                        int i11 = 0;
                        while (i11 < size2) {
                            Object obj2 = arrayList3.get(i11);
                            i11++;
                            if (mVar.f10749r.contains(((Number) obj2).intValue())) {
                                arrayList4.add(obj2);
                            }
                        }
                        int size3 = arrayList4.size();
                        int i12 = 0;
                        while (i12 < size3) {
                            Object obj3 = arrayList4.get(i12);
                            i12++;
                            Boolean bool = mVar.f10749r.get(((Number) obj3).intValue());
                            linkedHashSet.add(Boolean.valueOf(bool == null ? false : bool.booleanValue()));
                        }
                        ArrayList arrayList5 = gVar.f5470d;
                        ArrayList arrayList6 = new ArrayList();
                        int size4 = arrayList5.size();
                        int i13 = 0;
                        while (i13 < size4) {
                            Object obj4 = arrayList5.get(i13);
                            i13++;
                            if (mVar.f10748q.contains(((Number) obj4).intValue())) {
                                arrayList6.add(obj4);
                            }
                        }
                        int size5 = arrayList6.size();
                        int i14 = 0;
                        while (i14 < size5) {
                            Object obj5 = arrayList6.get(i14);
                            i14++;
                            Boolean bool2 = mVar.f10748q.get(((Number) obj5).intValue());
                            linkedHashSet.add(Boolean.valueOf(bool2 == null ? false : bool2.booleanValue()));
                        }
                    }
                    Boolean bool3 = Boolean.TRUE;
                    boolean contains = linkedHashSet.contains(bool3);
                    f fVar = this.f;
                    arrayList.add(new r(str, i6, (contains && linkedHashSet.contains(Boolean.FALSE)) ? fVar.e().f5565l : linkedHashSet.contains(bool3) ? fVar.e().f5566m : fVar.e().f5564k));
                }
            }
        }
        return arrayList;
    }

    public final void f() {
        String str = this.f9335b.f7239n.f7198a;
        PrivacyEncodingMode privacyEncodingMode = PrivacyEncodingMode.GPP;
        boolean a8 = kotlin.jvm.internal.l.a(str, privacyEncodingMode.getValue());
        h hVar = this.f9338e;
        if (a8) {
            hVar.b(privacyEncodingMode, true, true);
            return;
        }
        PrivacyEncodingMode privacyEncodingMode2 = PrivacyEncodingMode.TCF;
        if (kotlin.jvm.internal.l.a(str, privacyEncodingMode2.getValue())) {
            hVar.b(privacyEncodingMode2, true, true);
        } else {
            hVar.b(PrivacyEncodingMode.TCF_AND_GPP, true, true);
        }
    }
}
