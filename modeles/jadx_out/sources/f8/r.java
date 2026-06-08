package f8;

import d8.o0;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class r extends a {
    public final e8.t f;
    public final b8.e g;
    public int h;
    public boolean i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(e8.b bVar, e8.t tVar, String str, b8.e eVar) {
        super(bVar, str);
        bVar.getClass();
        this.f = tVar;
        this.g = eVar;
    }

    @Override // f8.a
    public e8.k b(String str) {
        str.getClass();
        return (e8.k) q6.a0.g0(q(), str);
    }

    @Override // f8.a, c8.e
    public final c8.c beginStructure(b8.e eVar) {
        eVar.getClass();
        b8.e eVar2 = this.g;
        if (eVar != eVar2) {
            return super.beginStructure(eVar);
        }
        e8.k c9 = c();
        String a8 = eVar2.a();
        if (c9 instanceof e8.t) {
            return new r(this.f4926c, (e8.t) c9, this.f4927d, eVar2);
        }
        throw m.e("Expected " + kotlin.jvm.internal.y.a(e8.t.class).c() + ", but had " + kotlin.jvm.internal.y.a(c9.getClass()).c() + " as the serialized body of " + a8 + " at element: " + s(), c9.toString(), -1);
    }

    @Override // c8.c
    public int decodeElementIndex(b8.e eVar) {
        eVar.getClass();
        while (this.h < eVar.e()) {
            int i = this.h;
            this.h = i + 1;
            String p10 = p(eVar, i);
            int i6 = this.h - 1;
            this.i = false;
            if (!q().containsKey(p10)) {
                boolean z9 = (this.f4926c.f4761a.f4770a || eVar.i(i6) || !eVar.h(i6).c()) ? false : true;
                this.i = z9;
                if (z9) {
                }
            }
            this.f4928e.getClass();
            return i6;
        }
        return -1;
    }

    @Override // f8.a, c8.e
    public final boolean decodeNotNullMark() {
        return !this.i && super.decodeNotNullMark();
    }

    @Override // f8.a, c8.c
    public void endStructure(b8.e eVar) {
        Set Z;
        eVar.getClass();
        e8.h hVar = this.f4928e;
        hVar.getClass();
        if (eVar.getKind() instanceof b8.c) {
            return;
        }
        e8.b bVar = this.f4926c;
        m.l(eVar, bVar);
        if (hVar.f4773d) {
            Set b7 = o0.b(eVar);
            a3.d dVar = bVar.f4763c;
            dVar.getClass();
            Map map = (Map) ((ConcurrentHashMap) dVar.f63b).get(eVar);
            Object obj = map != null ? map.get(m.f4957a) : null;
            if (obj == null) {
                obj = null;
            }
            Map map2 = (Map) obj;
            Set keySet = map2 != null ? map2.keySet() : null;
            if (keySet == null) {
                keySet = q6.v.f8726a;
            }
            Z = q6.b0.Z(b7, keySet);
        } else {
            Z = o0.b(eVar);
        }
        for (String str : q().f4784a.keySet()) {
            if (!Z.contains(str) && !kotlin.jvm.internal.l.a(str, this.f4927d)) {
                String tVar = q().toString();
                str.getClass();
                StringBuilder v = a4.x.v("Encountered an unknown key '", str, "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: ");
                v.append((Object) m.k(-1, tVar));
                throw m.d(-1, v.toString());
            }
        }
    }

    @Override // f8.a
    public String n(b8.e eVar, int i) {
        eVar.getClass();
        e8.b bVar = this.f4926c;
        m.l(eVar, bVar);
        String f = eVar.f(i);
        if (this.f4928e.f4773d && !q().f4784a.keySet().contains(f)) {
            a3.d dVar = bVar.f4763c;
            androidx.work.impl.utils.c cVar = new androidx.work.impl.utils.c(8, eVar, bVar);
            dVar.getClass();
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) dVar.f63b;
            Map map = (Map) concurrentHashMap.get(eVar);
            Object obj = null;
            n nVar = m.f4957a;
            Object obj2 = map != null ? map.get(nVar) : null;
            if (obj2 == null) {
                obj2 = null;
            }
            if (obj2 == null) {
                obj2 = cVar.invoke();
                Object obj3 = concurrentHashMap.get(eVar);
                if (obj3 == null) {
                    obj3 = new ConcurrentHashMap(2);
                    concurrentHashMap.put(eVar, obj3);
                }
                ((Map) obj3).put(nVar, obj2);
            }
            Map map2 = (Map) obj2;
            Iterator it = q().f4784a.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Integer num = (Integer) map2.get((String) next);
                if (num != null && num.intValue() == i) {
                    obj = next;
                    break;
                }
            }
            String str = (String) obj;
            if (str != null) {
                return str;
            }
        }
        return f;
    }

    @Override // f8.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public e8.t q() {
        return this.f;
    }

    public /* synthetic */ r(e8.b bVar, e8.t tVar, String str, int i) {
        this(bVar, tVar, (i & 4) != 0 ? null : str, (b8.e) null);
    }
}
