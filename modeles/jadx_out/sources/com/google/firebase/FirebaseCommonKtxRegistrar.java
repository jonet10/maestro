package com.google.firebase;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import j9.u;
import java.util.List;
import java.util.concurrent.Executor;
import n1.g;
import o7.w;
import q6.m;
import r1.b;
import r1.c;
import r1.d;
import s1.a;
import s1.i;
import s1.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Keep
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<a> getComponents() {
        u b7 = a.b(new r(r1.a.class, w.class));
        b7.c(new i(new r(r1.a.class, Executor.class), 1, 0));
        b7.f = g.f7913b;
        a d10 = b7.d();
        u b10 = a.b(new r(c.class, w.class));
        b10.c(new i(new r(c.class, Executor.class), 1, 0));
        b10.f = g.f7914l;
        a d11 = b10.d();
        u b11 = a.b(new r(b.class, w.class));
        b11.c(new i(new r(b.class, Executor.class), 1, 0));
        b11.f = g.f7915m;
        a d12 = b11.d();
        u b12 = a.b(new r(d.class, w.class));
        b12.c(new i(new r(d.class, Executor.class), 1, 0));
        b12.f = g.f7916n;
        return m.d0(d10, d11, d12, b12.d());
    }
}
