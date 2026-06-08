package com.google.gson.internal;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r extends t {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f3254b;

    public r(Method method) {
        this.f3254b = method;
    }

    @Override // com.google.gson.internal.t
    public final Object a(Class cls) {
        String q9 = a3.d.q(cls);
        if (q9 == null) {
            return this.f3254b.invoke(null, cls, Object.class);
        }
        s1.o.j("UnsafeAllocator is used for non-instantiable type: ".concat(q9));
        return null;
    }
}
