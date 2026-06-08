package e1;

import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c4 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final long f3847a;

    /* renamed from: b, reason: collision with root package name */
    public final long f3848b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ android.support.v4.media.g f3849l;

    public c4(android.support.v4.media.g gVar, long j, long j6) {
        Objects.requireNonNull(gVar);
        this.f3849l = gVar;
        this.f3847a = j;
        this.f3848b = j6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q1 q1Var = ((f4) this.f3849l.f248l).f3875a.f4265p;
        t1.m(q1Var);
        q1Var.p(new a4.f(this, 7));
    }
}
