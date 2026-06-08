package com.google.gson.internal;

import com.google.android.gms.internal.measurement.z3;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class Excluder implements com.google.gson.j, Cloneable {

    /* renamed from: l, reason: collision with root package name */
    public static final Excluder f3120l = new Excluder();

    /* renamed from: a, reason: collision with root package name */
    public final List f3121a;

    /* renamed from: b, reason: collision with root package name */
    public final List f3122b;

    public Excluder() {
        List list = Collections.EMPTY_LIST;
        this.f3121a = list;
        this.f3122b = list;
    }

    @Override // com.google.gson.j
    public final com.google.gson.i a(final com.google.gson.b bVar, final TypeToken typeToken) {
        Class cls = typeToken.f3266a;
        final boolean b7 = b(cls, true);
        final boolean b10 = b(cls, false);
        if (b7 || b10) {
            return new com.google.gson.i() { // from class: com.google.gson.internal.Excluder.1

                /* renamed from: a, reason: collision with root package name */
                public volatile com.google.gson.i f3123a;

                @Override // com.google.gson.i
                public final Object b(k3.a aVar) {
                    if (b10) {
                        aVar.N();
                        return null;
                    }
                    com.google.gson.i iVar = this.f3123a;
                    if (iVar == null) {
                        iVar = bVar.d(Excluder.this, typeToken);
                        this.f3123a = iVar;
                    }
                    return iVar.b(aVar);
                }

                @Override // com.google.gson.i
                public final void c(k3.b bVar2, Object obj) {
                    if (b7) {
                        bVar2.n();
                        return;
                    }
                    com.google.gson.i iVar = this.f3123a;
                    if (iVar == null) {
                        iVar = bVar.d(Excluder.this, typeToken);
                        this.f3123a = iVar;
                    }
                    iVar.c(bVar2, obj);
                }
            };
        }
        return null;
    }

    public final boolean b(Class cls, boolean z9) {
        if (!z9 && !Enum.class.isAssignableFrom(cls)) {
            z3 z3Var = j3.c.f6566a;
            if (!Modifier.isStatic(cls.getModifiers()) && (cls.isAnonymousClass() || cls.isLocalClass())) {
                return true;
            }
        }
        Iterator it = (z9 ? this.f3121a : this.f3122b).iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next().getClass();
        a.o();
        return false;
    }

    public final Object clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException e10) {
            s1.o.j(e10);
            return null;
        }
    }
}
