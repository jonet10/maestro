package com.google.firebase.crashlytics;

import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import d3.d;
import j9.u;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import n1.f;
import r1.a;
import r1.b;
import r1.c;
import s1.i;
import s1.r;
import x7.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class CrashlyticsRegistrar implements ComponentRegistrar {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f3077d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final r f3078a = new r(a.class, ExecutorService.class);

    /* renamed from: b, reason: collision with root package name */
    public final r f3079b = new r(b.class, ExecutorService.class);

    /* renamed from: c, reason: collision with root package name */
    public final r f3080c = new r(c.class, ExecutorService.class);

    static {
        Map map = d3.c.f3552b;
        d dVar = d.f3553a;
        if (map.containsKey(dVar)) {
            Log.d("FirebaseSessions", "Dependency " + dVar + " already added.");
            return;
        }
        map.put(dVar, new d3.a(new g(true)));
        Log.d("FirebaseSessions", "Dependency to " + dVar + " added.");
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        u a8 = s1.a.a(u1.c.class);
        a8.f6817c = "fire-cls";
        a8.c(i.a(f.class));
        a8.c(i.a(t2.d.class));
        a8.c(new i(this.f3078a, 1, 0));
        a8.c(new i(this.f3079b, 1, 0));
        a8.c(new i(this.f3080c, 1, 0));
        a8.c(new i(0, 2, v1.b.class));
        a8.c(new i(0, 2, p1.a.class));
        a8.c(new i(0, 2, b3.a.class));
        a8.f = new androidx.core.view.inputmethod.a(this, 26);
        a8.e(2);
        return Arrays.asList(a8.d(), a.a.s("fire-cls", "20.0.4"));
    }
}
