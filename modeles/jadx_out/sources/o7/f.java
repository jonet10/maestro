package o7;

import java.util.concurrent.locks.LockSupport;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends a {

    /* renamed from: m, reason: collision with root package name */
    public final Thread f8258m;

    /* renamed from: n, reason: collision with root package name */
    public final r0 f8259n;

    public f(t6.h hVar, Thread thread, r0 r0Var) {
        super(hVar, true);
        this.f8258m = thread;
        this.f8259n = r0Var;
    }

    @Override // o7.m1
    public final void t(Object obj) {
        Thread currentThread = Thread.currentThread();
        Thread thread = this.f8258m;
        if (kotlin.jvm.internal.l.a(currentThread, thread)) {
            return;
        }
        LockSupport.unpark(thread);
    }
}
