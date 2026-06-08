package com.google.gson.internal.bind;

import c.j;
import com.google.gson.f;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import k0.k;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
class JsonElementTypeAdapter extends i {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonElementTypeAdapter f3147a = new JsonElementTypeAdapter();

    private JsonElementTypeAdapter() {
    }

    public static com.google.gson.d d(int i, k3.a aVar) {
        int c9 = j.c(i);
        if (c9 == 5) {
            return new h(aVar.F());
        }
        if (c9 == 6) {
            return new h(new com.google.gson.internal.h(aVar.F()));
        }
        if (c9 == 7) {
            return new h(Boolean.valueOf(aVar.u()));
        }
        if (c9 == 8) {
            aVar.D();
            return f.f3117a;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Unexpected token: ".concat(k.m(i)));
        return null;
    }

    public static void e(k3.b bVar, com.google.gson.d dVar) {
        if (dVar == null || (dVar instanceof f)) {
            bVar.n();
            return;
        }
        boolean z9 = dVar instanceof h;
        if (z9) {
            if (!z9) {
                a3.b.l(dVar, "Not a JSON Primitive: ");
                return;
            }
            h hVar = (h) dVar;
            Serializable serializable = hVar.f3119a;
            if (serializable instanceof Number) {
                bVar.B(hVar.c());
                return;
            } else if (serializable instanceof Boolean) {
                bVar.D(serializable instanceof Boolean ? ((Boolean) serializable).booleanValue() : Boolean.parseBoolean(hVar.d()));
                return;
            } else {
                bVar.C(hVar.d());
                return;
            }
        }
        boolean z10 = dVar instanceof com.google.gson.c;
        if (z10) {
            bVar.c();
            if (!z10) {
                a3.b.l(dVar, "Not a JSON Array: ");
                return;
            }
            ArrayList arrayList = ((com.google.gson.c) dVar).f3116a;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                e(bVar, (com.google.gson.d) obj);
            }
            bVar.f();
            return;
        }
        boolean z11 = dVar instanceof g;
        if (!z11) {
            androidx.privacysandbox.ads.adservices.customaudience.a.r(dVar.getClass(), "Couldn't write ");
            return;
        }
        bVar.d();
        if (!z11) {
            a3.b.l(dVar, "Not a JSON Object: ");
            return;
        }
        Iterator it = ((com.google.gson.internal.j) ((g) dVar).f3118a.entrySet()).iterator();
        while (((com.google.gson.internal.i) it).hasNext()) {
            com.google.gson.internal.k b7 = ((com.google.gson.internal.i) it).b();
            bVar.i((String) b7.getKey());
            e(bVar, (com.google.gson.d) b7.getValue());
        }
        bVar.h();
    }

    @Override // com.google.gson.i
    public final Object b(k3.a aVar) {
        com.google.gson.d cVar;
        com.google.gson.d cVar2;
        int H = aVar.H();
        int c9 = j.c(H);
        if (c9 == 0) {
            aVar.b();
            cVar = new com.google.gson.c();
        } else if (c9 != 2) {
            cVar = null;
        } else {
            aVar.c();
            cVar = new g();
        }
        if (cVar == null) {
            return d(H, aVar);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.n()) {
                String B = cVar instanceof g ? aVar.B() : null;
                int H2 = aVar.H();
                int c10 = j.c(H2);
                if (c10 == 0) {
                    aVar.b();
                    cVar2 = new com.google.gson.c();
                } else if (c10 != 2) {
                    cVar2 = null;
                } else {
                    aVar.c();
                    cVar2 = new g();
                }
                boolean z9 = cVar2 != null;
                if (cVar2 == null) {
                    cVar2 = d(H2, aVar);
                }
                if (cVar instanceof com.google.gson.c) {
                    ((com.google.gson.c) cVar).f3116a.add(cVar2);
                } else {
                    ((g) cVar).f3118a.put(B, cVar2);
                }
                if (z9) {
                    arrayDeque.addLast(cVar);
                    cVar = cVar2;
                }
            } else {
                if (cVar instanceof com.google.gson.c) {
                    aVar.f();
                } else {
                    aVar.h();
                }
                if (arrayDeque.isEmpty()) {
                    return cVar;
                }
                cVar = (com.google.gson.d) arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.i
    public final /* bridge */ /* synthetic */ void c(k3.b bVar, Object obj) {
        e(bVar, (com.google.gson.d) obj);
    }
}
