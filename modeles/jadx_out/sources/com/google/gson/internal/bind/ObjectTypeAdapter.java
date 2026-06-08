package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.internal.l;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import k0.k;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ObjectTypeAdapter extends i {

    /* renamed from: c, reason: collision with root package name */
    public static final j f3155c = new AnonymousClass1(1);

    /* renamed from: a, reason: collision with root package name */
    public final com.google.gson.b f3156a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3157b;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: com.google.gson.internal.bind.ObjectTypeAdapter$1, reason: invalid class name */
    class AnonymousClass1 implements j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f3158a;

        public AnonymousClass1(int i) {
            this.f3158a = i;
        }

        @Override // com.google.gson.j
        public final i a(com.google.gson.b bVar, TypeToken typeToken) {
            if (typeToken.f3266a == Object.class) {
                return new ObjectTypeAdapter(bVar, this.f3158a);
            }
            return null;
        }
    }

    public ObjectTypeAdapter(com.google.gson.b bVar, int i) {
        this.f3156a = bVar;
        this.f3157b = i;
    }

    public static j d(int i) {
        return i == 1 ? f3155c : new AnonymousClass1(i);
    }

    @Override // com.google.gson.i
    public final Object b(k3.a aVar) {
        Object arrayList;
        Serializable arrayList2;
        int H = aVar.H();
        int c9 = c.j.c(H);
        if (c9 == 0) {
            aVar.b();
            arrayList = new ArrayList();
        } else if (c9 != 2) {
            arrayList = null;
        } else {
            aVar.c();
            arrayList = new l(true);
        }
        if (arrayList == null) {
            return e(H, aVar);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.n()) {
                String B = arrayList instanceof Map ? aVar.B() : null;
                int H2 = aVar.H();
                int c10 = c.j.c(H2);
                if (c10 == 0) {
                    aVar.b();
                    arrayList2 = new ArrayList();
                } else if (c10 != 2) {
                    arrayList2 = null;
                } else {
                    aVar.c();
                    arrayList2 = new l(true);
                }
                boolean z9 = arrayList2 != null;
                if (arrayList2 == null) {
                    arrayList2 = e(H2, aVar);
                }
                if (arrayList instanceof List) {
                    ((List) arrayList).add(arrayList2);
                } else {
                    ((Map) arrayList).put(B, arrayList2);
                }
                if (z9) {
                    arrayDeque.addLast(arrayList);
                    arrayList = arrayList2;
                }
            } else {
                if (arrayList instanceof List) {
                    aVar.f();
                } else {
                    aVar.h();
                }
                if (arrayDeque.isEmpty()) {
                    return arrayList;
                }
                arrayList = arrayDeque.removeLast();
            }
        }
    }

    @Override // com.google.gson.i
    public final void c(k3.b bVar, Object obj) {
        if (obj == null) {
            bVar.n();
            return;
        }
        Class<?> cls = obj.getClass();
        com.google.gson.b bVar2 = this.f3156a;
        bVar2.getClass();
        i c9 = bVar2.c(new TypeToken(cls));
        if (!(c9 instanceof ObjectTypeAdapter)) {
            c9.c(bVar, obj);
        } else {
            bVar.d();
            bVar.h();
        }
    }

    public final Serializable e(int i, k3.a aVar) {
        int c9 = c.j.c(i);
        if (c9 == 5) {
            return aVar.F();
        }
        if (c9 == 6) {
            return androidx.lifecycle.l.f(this.f3157b, aVar);
        }
        if (c9 == 7) {
            return Boolean.valueOf(aVar.u());
        }
        if (c9 == 8) {
            aVar.D();
            return null;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Unexpected token: ".concat(k.m(i)));
        return null;
    }
}
