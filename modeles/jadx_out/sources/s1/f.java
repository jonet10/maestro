package s1;

import android.util.Log;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.z3;
import com.google.firebase.components.ComponentRegistrar;
import e1.c0;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements b, k2.a {

    /* renamed from: q, reason: collision with root package name */
    public static final e f9121q = new e(0);

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f9122a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f9123b;

    /* renamed from: l, reason: collision with root package name */
    public final HashMap f9124l;

    /* renamed from: m, reason: collision with root package name */
    public final HashSet f9125m;

    /* renamed from: n, reason: collision with root package name */
    public final k f9126n;

    /* renamed from: o, reason: collision with root package name */
    public final AtomicReference f9127o;

    /* renamed from: p, reason: collision with root package name */
    public final c0 f9128p;

    public f(ArrayList arrayList, ArrayList arrayList2, c0 c0Var) {
        t1.j jVar = t1.j.f9533a;
        this.f9122a = new HashMap();
        this.f9123b = new HashMap();
        this.f9124l = new HashMap();
        this.f9125m = new HashSet();
        this.f9127o = new AtomicReference();
        k kVar = new k();
        this.f9126n = kVar;
        this.f9128p = c0Var;
        ArrayList arrayList3 = new ArrayList();
        int i = 2;
        int i6 = 0;
        arrayList3.add(a.c(kVar, k.class, p2.c.class, p2.b.class));
        arrayList3.add(a.c(this, k2.a.class, new Class[0]));
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            a aVar = (a) obj;
            if (aVar != null) {
                arrayList3.add(aVar);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        int size2 = arrayList.size();
        int i11 = 0;
        while (i11 < size2) {
            Object obj2 = arrayList.get(i11);
            i11++;
            arrayList4.add(obj2);
        }
        ArrayList arrayList5 = new ArrayList();
        synchronized (this) {
            Iterator it = arrayList4.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((s2.b) it.next()).get();
                    if (componentRegistrar != null) {
                        arrayList3.addAll(this.f9128p.s(componentRegistrar));
                        it.remove();
                    }
                } catch (l e10) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e10);
                }
            }
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                Object[] array = ((a) it2.next()).f9114b.toArray();
                int length = array.length;
                int i12 = 0;
                while (true) {
                    if (i12 < length) {
                        Object obj3 = array[i12];
                        if (obj3.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f9125m.contains(obj3.toString())) {
                                it2.remove();
                                break;
                            }
                            this.f9125m.add(obj3.toString());
                        }
                        i12++;
                    }
                }
            }
            if (this.f9122a.isEmpty()) {
                z3.l(arrayList3);
            } else {
                ArrayList arrayList6 = new ArrayList(this.f9122a.keySet());
                arrayList6.addAll(arrayList3);
                z3.l(arrayList6);
            }
            int size3 = arrayList3.size();
            int i13 = 0;
            while (i13 < size3) {
                Object obj4 = arrayList3.get(i13);
                i13++;
                a aVar2 = (a) obj4;
                this.f9122a.put(aVar2, new m(new n1.b(i, this, aVar2)));
            }
            arrayList5.addAll(i(arrayList3));
            arrayList5.addAll(j());
            h();
        }
        int size4 = arrayList5.size();
        while (i6 < size4) {
            Object obj5 = arrayList5.get(i6);
            i6++;
            ((Runnable) obj5).run();
        }
        Boolean bool = (Boolean) this.f9127o.get();
        if (bool != null) {
            g(this.f9122a, bool.booleanValue());
        }
    }

    @Override // s1.b
    public final Object a(Class cls) {
        return e(r.a(cls));
    }

    @Override // s1.b
    public final synchronized s2.b b(r rVar) {
        i5.i(rVar, "Null interface requested.");
        return (s2.b) this.f9123b.get(rVar);
    }

    @Override // s1.b
    public final s2.b c(Class cls) {
        return b(r.a(cls));
    }

    @Override // s1.b
    public final Set d(r rVar) {
        s2.b bVar;
        synchronized (this) {
            bVar = (n) this.f9124l.get(rVar);
            if (bVar == null) {
                bVar = f9121q;
            }
        }
        return (Set) bVar.get();
    }

    @Override // s1.b
    public final Object e(r rVar) {
        s2.b b7 = b(rVar);
        if (b7 == null) {
            return null;
        }
        return b7.get();
    }

    @Override // s1.b
    public final p f(r rVar) {
        s2.b b7 = b(rVar);
        return b7 == null ? new p(p.f9146c, p.f9147d) : b7 instanceof p ? (p) b7 : new p(null, b7);
    }

    public final void g(HashMap hashMap, boolean z9) {
        ArrayDeque arrayDeque;
        for (Map.Entry entry : hashMap.entrySet()) {
            a aVar = (a) entry.getKey();
            s2.b bVar = (s2.b) entry.getValue();
            int i = aVar.f9116d;
            if (i == 1 || (i == 2 && z9)) {
                bVar.get();
            }
        }
        k kVar = this.f9126n;
        synchronized (kVar) {
            try {
                arrayDeque = kVar.f9138b;
                if (arrayDeque != null) {
                    kVar.f9138b = null;
                } else {
                    arrayDeque = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            if (it.hasNext()) {
                it.next().getClass();
                com.google.gson.internal.a.o();
            }
        }
    }

    public final void h() {
        HashMap hashMap = this.f9123b;
        HashMap hashMap2 = this.f9124l;
        for (a aVar : this.f9122a.keySet()) {
            for (i iVar : aVar.f9115c) {
                boolean z9 = iVar.f9135b == 2;
                r rVar = iVar.f9134a;
                if (z9 && !hashMap2.containsKey(rVar)) {
                    Set set = Collections.EMPTY_SET;
                    n nVar = new n();
                    nVar.f9144b = null;
                    nVar.f9143a = Collections.newSetFromMap(new ConcurrentHashMap());
                    nVar.f9143a.addAll(set);
                    hashMap2.put(rVar, nVar);
                } else if (hashMap.containsKey(rVar)) {
                    continue;
                } else {
                    int i = iVar.f9135b;
                    if (i == 1) {
                        throw new j("Unsatisfied dependency for component " + aVar + ": " + rVar);
                    }
                    if (i != 2) {
                        hashMap.put(rVar, new p(p.f9146c, p.f9147d));
                    }
                }
            }
        }
    }

    public final ArrayList i(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            a aVar = (a) obj;
            if (aVar.f9117e == 0) {
                s2.b bVar = (s2.b) this.f9122a.get(aVar);
                for (r rVar : aVar.f9114b) {
                    HashMap hashMap = this.f9123b;
                    if (hashMap.containsKey(rVar)) {
                        arrayList2.add(new androidx.browser.trusted.c(20, (p) ((s2.b) hashMap.get(rVar)), bVar));
                    } else {
                        hashMap.put(rVar, bVar);
                    }
                }
            }
        }
        return arrayList2;
    }

    public final ArrayList j() {
        HashMap hashMap = this.f9124l;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap2 = new HashMap();
        for (Map.Entry entry : this.f9122a.entrySet()) {
            a aVar = (a) entry.getKey();
            if (aVar.f9117e != 0) {
                s2.b bVar = (s2.b) entry.getValue();
                for (r rVar : aVar.f9114b) {
                    if (!hashMap2.containsKey(rVar)) {
                        hashMap2.put(rVar, new HashSet());
                    }
                    ((Set) hashMap2.get(rVar)).add(bVar);
                }
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (hashMap.containsKey(entry2.getKey())) {
                n nVar = (n) hashMap.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new androidx.browser.trusted.c(21, nVar, (s2.b) it.next()));
                }
            } else {
                r rVar2 = (r) entry2.getKey();
                Set set = (Set) ((Collection) entry2.getValue());
                n nVar2 = new n();
                nVar2.f9144b = null;
                nVar2.f9143a = Collections.newSetFromMap(new ConcurrentHashMap());
                nVar2.f9143a.addAll(set);
                hashMap.put(rVar2, nVar2);
            }
        }
        return arrayList;
    }
}
