package z5;

import a4.x;
import androidx.lifecycle.ViewModel;
import c.j;
import h8.i;
import j9.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import l8.n;
import q6.l;
import u5.e;
import u5.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final f f11975a;

    /* renamed from: b, reason: collision with root package name */
    public final m f11976b;

    /* renamed from: c, reason: collision with root package name */
    public final n f11977c;

    /* renamed from: d, reason: collision with root package name */
    public final u5.d f11978d;

    /* renamed from: e, reason: collision with root package name */
    public final i f11979e;
    public final List f;
    public final List g;
    public final List h;
    public final List i;
    public int j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f11980k;

    /* renamed from: l, reason: collision with root package name */
    public final int f11981l;

    public d(f fVar, m mVar, n nVar, u5.d dVar, i iVar, List list, List list2, List list3, List list4) {
        fVar.getClass();
        dVar.getClass();
        list.getClass();
        list2.getClass();
        list3.getClass();
        list4.getClass();
        this.f11975a = fVar;
        this.f11976b = mVar;
        this.f11977c = nVar;
        this.f11978d = dVar;
        this.f11979e = iVar;
        this.f = list;
        this.g = list2;
        this.h = list3;
        this.i = list4;
        this.j = 1;
        this.f11981l = 3;
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
        m mVar = this.f11976b;
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

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : this.f11978d.f10710a.entrySet()) {
            m mVar = this.f11976b;
            if (mVar.B.get(((e) entry.getValue()).f10711a) != null) {
                e eVar = (e) entry.getValue();
                arrayList.add(new c.i(new i(eVar.f10711a, eVar.f10712b, null, null, null, null, null, null, null, eVar.f10713c, null, 0, null, null, null, null, null, 914940), mVar.B.get(((e) entry.getValue()).f10711a), 0, 3, null, null, 116));
            }
        }
        return arrayList;
    }

    public final ArrayList c(String str) {
        ArrayList e10;
        boolean z9;
        c.i iVar;
        str.getClass();
        int c9 = j.c(this.j);
        int i = 0;
        if (c9 == 0) {
            e10 = e();
            e10.addAll(d());
            e10.addAll(b());
            i iVar2 = this.f11979e;
            if (iVar2 == null) {
                iVar = null;
            } else {
                Set set = iVar2.f5474d;
                if (set != null) {
                    Iterator it = l.J0(set).iterator();
                    while (it.hasNext()) {
                        if (!kotlin.jvm.internal.l.a(this.f11976b.v.get(((Number) it.next()).intValue()), Boolean.TRUE)) {
                            z9 = false;
                            break;
                        }
                    }
                }
                z9 = true;
                iVar = new c.i(iVar2, Boolean.valueOf(z9), 0, 4, null, null, 116);
            }
            if (iVar != null) {
                e10.add(0, iVar);
            }
        } else if (c9 == 1) {
            e10 = d();
        } else if (c9 == 2) {
            e10 = e();
        } else {
            if (c9 != 3) {
                com.google.gson.internal.a.b();
                return null;
            }
            e10 = b();
        }
        e10.add(0, new c.i(null, null, 3, 0, this.f11975a.f().f5587d, null, 91));
        ArrayList arrayList = new ArrayList();
        int size = e10.size();
        while (i < size) {
            Object obj = e10.get(i);
            i++;
            if (l7.m.q0(((c.i) obj).f1160a.f5466b, str, true)) {
                arrayList.add(obj);
            }
        }
        return new ArrayList(arrayList);
    }

    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object, java.util.List] */
    public final ArrayList d() {
        LinkedHashMap linkedHashMap;
        ArrayList arrayList = new ArrayList();
        m mVar = this.f11976b;
        h8.c cVar = mVar.f10737a;
        if (cVar != null && (linkedHashMap = cVar.h) != null) {
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (mVar.f10756z.get(((i) entry.getValue()).f5465a) != null) {
                    Set set = ((i) entry.getValue()).f5474d;
                    ?? r62 = this.f11977c.f7239n.g;
                    if (set == null || !set.isEmpty()) {
                        Iterator it = set.iterator();
                        while (it.hasNext()) {
                            if (r62.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                                arrayList.add(new c.i((h8.d) entry.getValue(), mVar.f10756z.get(((i) entry.getValue()).f5465a), 0, 0, null, null, 124));
                                break;
                            }
                        }
                    }
                    arrayList.add(new c.i((h8.d) entry.getValue(), null, 0, 0, null, null, 124));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Iterable, java.lang.Object] */
    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (l8.l lVar : this.f11977c.f7239n.f7212t.f7228a) {
            m mVar = this.f11976b;
            if (mVar.A.get(lVar.f7223a) != null) {
                arrayList.add(new c.i(lVar.a(), mVar.A.get(lVar.f7223a), 0, 2, null, null, 116));
            }
        }
        return arrayList;
    }
}
