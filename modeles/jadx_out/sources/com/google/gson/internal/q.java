package com.google.gson.internal;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q extends t {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Method f3252b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3253c;

    public q(int i, Method method) {
        this.f3252b = method;
        this.f3253c = i;
    }

    @Override // com.google.gson.internal.t
    public final Object a(Class cls) {
        String q9 = a3.d.q(cls);
        if (q9 == null) {
            return this.f3252b.invoke(null, cls, Integer.valueOf(this.f3253c));
        }
        s1.o.j("UnsafeAllocator is used for non-instantiable type: ".concat(q9));
        return null;
    }
}
