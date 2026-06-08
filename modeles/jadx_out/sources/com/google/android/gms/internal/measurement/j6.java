package com.google.android.gms.internal.measurement;

import j$.util.concurrent.ConcurrentHashMap;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j6 {

    /* renamed from: c, reason: collision with root package name */
    public static final j6 f2671c = new j6();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f2673b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final z5 f2672a = new z5(0);

    public final m6 a(Class cls) {
        m6 u7;
        Charset charset = r5.f2778a;
        if (cls == null) {
            com.google.gson.internal.a.i("messageType");
            return null;
        }
        ConcurrentHashMap concurrentHashMap = this.f2673b;
        m6 m6Var = (m6) concurrentHashMap.get(cls);
        if (m6Var != null) {
            return m6Var;
        }
        z5 z5Var = this.f2672a;
        z5Var.getClass();
        j5 j5Var = n6.f2726a;
        l5.class.isAssignableFrom(cls);
        l6 b7 = ((z5) z5Var.f2934a).b(cls);
        if ((b7.f2700d & 2) == 2) {
            j5 j5Var2 = n6.f2726a;
            j5 j5Var3 = e5.f2559a;
            u7 = new g6(j5Var2, b7.f2697a);
        } else {
            int i = h6.f2652a;
            int i6 = w5.f2885a;
            j5 j5Var4 = n6.f2726a;
            j5 j5Var5 = b7.a() + (-1) != 1 ? e5.f2559a : null;
            int i10 = c6.f2529a;
            u7 = f6.u(b7, j5Var4, j5Var5);
        }
        m6 m6Var2 = (m6) concurrentHashMap.putIfAbsent(cls, u7);
        return m6Var2 != null ? m6Var2 : u7;
    }
}
