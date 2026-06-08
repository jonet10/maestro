package com.google.gson.internal;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p extends t {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f3250b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3251c;

    public p(Object obj, Method method) {
        this.f3250b = method;
        this.f3251c = obj;
    }

    @Override // com.google.gson.internal.t
    public final Object a(Class cls) {
        String q9 = a3.d.q(cls);
        if (q9 == null) {
            return this.f3250b.invoke(this.f3251c, cls);
        }
        s1.o.j("UnsafeAllocator is used for non-instantiable type: ".concat(q9));
        return null;
    }
}
