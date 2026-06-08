package com.google.android.gms.internal.measurement;

import android.os.SystemClock;
import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class g1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final long f2592a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2593b;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f2594l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ k1 f2595m;

    public g1(k1 k1Var, boolean z9) {
        Objects.requireNonNull(k1Var);
        this.f2595m = k1Var;
        this.f2592a = System.currentTimeMillis();
        this.f2593b = SystemClock.elapsedRealtime();
        this.f2594l = z9;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        k1 k1Var = this.f2595m;
        if (k1Var.f2683e) {
            b();
            return;
        }
        try {
            a();
        } catch (Exception e10) {
            k1Var.b(e10, false, this.f2594l);
            b();
        }
    }

    public void b() {
    }
}
