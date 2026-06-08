package g8;

import d7.l;
import j0.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements h, k0.d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5381a;

    /* renamed from: b, reason: collision with root package name */
    public Object f5382b = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    public Object f5383l = new HashMap();

    /* renamed from: m, reason: collision with root package name */
    public Object f5384m = new HashMap();

    /* renamed from: n, reason: collision with root package name */
    public Object f5385n = new HashMap();

    /* renamed from: o, reason: collision with root package name */
    public Object f5386o = new HashMap();

    @Override // g8.h
    public void a(j7.c cVar, j7.c cVar2, z7.b bVar) {
        j(cVar, cVar2, bVar, false);
    }

    @Override // g8.h
    public void b(j7.c cVar, l lVar) {
        cVar.getClass();
        k(cVar, new b(lVar), false);
    }

    public d c() {
        return new d((HashMap) this.f5382b, (HashMap) this.f5383l, (HashMap) this.f5384m, (HashMap) this.f5385n, (HashMap) this.f5386o, this.f5381a);
    }

    @Override // g8.h
    public void d(j7.c cVar, z7.b bVar) {
        bVar.getClass();
        k(cVar, new a(bVar), false);
    }

    @Override // g8.h
    public void e(j7.c cVar, l lVar) {
        h(cVar, lVar, false);
    }

    @Override // g8.h
    public void f(j7.c cVar, l lVar) {
        i(cVar, lVar, false);
    }

    @Override // k0.d
    public void g(h0.b bVar) {
        ((j0.e) this.f5386o).v.post(new m1.a(this, bVar, 20, false));
    }

    public void h(j7.c cVar, l lVar, boolean z9) {
        HashMap hashMap = (HashMap) this.f5386o;
        l lVar2 = (l) hashMap.get(cVar);
        if (lVar2 == null || lVar2.equals(lVar) || z9) {
            hashMap.put(cVar, lVar);
        } else {
            androidx.privacysandbox.ads.adservices.customaudience.a.t("Default deserializers provider for ", cVar, " is already registered: ", lVar2);
        }
    }

    public void i(j7.c cVar, l lVar, boolean z9) {
        HashMap hashMap = (HashMap) this.f5384m;
        l lVar2 = (l) hashMap.get(cVar);
        if (lVar2 == null || lVar2.equals(lVar) || z9) {
            hashMap.put(cVar, lVar);
        } else {
            androidx.privacysandbox.ads.adservices.customaudience.a.t("Default serializers provider for ", cVar, " is already registered: ", lVar2);
        }
    }

    public void j(j7.c cVar, j7.c cVar2, z7.b bVar, boolean z9) {
        Object obj;
        String a8 = bVar.getDescriptor().a();
        HashMap hashMap = (HashMap) this.f5383l;
        Object obj2 = hashMap.get(cVar);
        if (obj2 == null) {
            obj2 = new HashMap();
            hashMap.put(cVar, obj2);
        }
        Map map = (Map) obj2;
        z7.b bVar2 = (z7.b) map.get(cVar2);
        HashMap hashMap2 = (HashMap) this.f5385n;
        Object obj3 = hashMap2.get(cVar);
        if (obj3 == null) {
            obj3 = new HashMap();
            hashMap2.put(cVar, obj3);
        }
        Map map2 = (Map) obj3;
        if (z9) {
            if (bVar2 != null) {
                map2.remove(bVar2.getDescriptor().a());
            }
            map.put(cVar2, bVar);
            map2.put(a8, bVar);
            return;
        }
        if (bVar2 != null) {
            if (!bVar2.equals(bVar)) {
                throw new e("Serializer for " + cVar2 + " already registered in the scope of " + cVar);
            }
        }
        z7.b bVar3 = (z7.b) map2.get(a8);
        if (bVar3 == null) {
            map.put(cVar2, bVar);
            map2.put(a8, bVar);
            return;
        }
        Object obj4 = hashMap.get(cVar);
        obj4.getClass();
        Set entrySet = ((Map) obj4).entrySet();
        entrySet.getClass();
        Iterator it = entrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((Map.Entry) obj).getValue() == bVar3) {
                    break;
                }
            }
        }
        throw new IllegalArgumentException("Multiple polymorphic serializers for base class '" + cVar + "' have the same serial name '" + a8 + "': '" + cVar2 + "' and '" + ((Map.Entry) obj) + '\'');
    }

    public void k(j7.c cVar, c cVar2, boolean z9) {
        c cVar3;
        HashMap hashMap = (HashMap) this.f5382b;
        cVar.getClass();
        if (!z9 && (cVar3 = (c) hashMap.get(cVar)) != null && !cVar3.equals(cVar2)) {
            throw new e("Contextual serializer or serializer provider for " + cVar + " already registered in this module");
        }
        hashMap.put(cVar, cVar2);
        if (d0.b.F(cVar).isInterface()) {
            this.f5381a = true;
        }
    }

    public void l(h0.b bVar) {
        m mVar = (m) ((j0.e) this.f5386o).f6499s.get((j0.a) this.f5383l);
        if (mVar != null) {
            mVar.p(bVar);
        }
    }
}
