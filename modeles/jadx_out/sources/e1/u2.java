package e1;

import android.os.Bundle;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4300a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f4301b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ b3 f4302l;

    public u2(b3 b3Var, AtomicReference atomicReference, int i) {
        this.f4300a = i;
        switch (i) {
            case 1:
                this.f4301b = atomicReference;
                Objects.requireNonNull(b3Var);
                this.f4302l = b3Var;
                break;
            case 2:
                this.f4301b = atomicReference;
                Objects.requireNonNull(b3Var);
                this.f4302l = b3Var;
                break;
            case 3:
                this.f4301b = atomicReference;
                Objects.requireNonNull(b3Var);
                this.f4302l = b3Var;
                break;
            case 4:
                this.f4301b = atomicReference;
                Objects.requireNonNull(b3Var);
                this.f4302l = b3Var;
                break;
            default:
                this.f4301b = atomicReference;
                Objects.requireNonNull(b3Var);
                this.f4302l = b3Var;
                break;
        }
    }

    private final void a() {
        AtomicReference atomicReference = this.f4301b;
        synchronized (atomicReference) {
            try {
                try {
                    t1 t1Var = this.f4302l.f3875a;
                    atomicReference.set(t1Var.f4262m.m(t1Var.r().m(), f0.f3918c0));
                } finally {
                    this.f4301b.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void b() {
        AtomicReference atomicReference = this.f4301b;
        synchronized (atomicReference) {
            try {
                try {
                    t1 t1Var = this.f4302l.f3875a;
                    atomicReference.set(Long.valueOf(t1Var.f4262m.n(t1Var.r().m(), f0.f3921d0)));
                } finally {
                    this.f4301b.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void c() {
        AtomicReference atomicReference = this.f4301b;
        synchronized (atomicReference) {
            try {
                try {
                    t1 t1Var = this.f4302l.f3875a;
                    atomicReference.set(Integer.valueOf(t1Var.f4262m.o(t1Var.r().m(), f0.f3923e0)));
                } finally {
                    this.f4301b.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void d() {
        AtomicReference atomicReference = this.f4301b;
        synchronized (atomicReference) {
            try {
                try {
                    t1 t1Var = this.f4302l.f3875a;
                    atomicReference.set(Double.valueOf(t1Var.f4262m.p(t1Var.r().m(), f0.f3925f0)));
                } finally {
                    this.f4301b.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4300a) {
            case 0:
                AtomicReference atomicReference = this.f4301b;
                synchronized (atomicReference) {
                    try {
                        try {
                            t1 t1Var = this.f4302l.f3875a;
                            atomicReference.set(Boolean.valueOf(t1Var.f4262m.q(t1Var.r().m(), f0.f3916b0)));
                        } finally {
                            this.f4301b.notify();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 1:
                a();
                return;
            case 2:
                b();
                return;
            case 3:
                c();
                return;
            case 4:
                d();
                return;
            case 5:
                b3 b3Var = this.f4302l;
                g1 g1Var = b3Var.f3875a.f4263n;
                t1.k(g1Var);
                Bundle G = g1Var.f3991w.G();
                w3 p10 = b3Var.f3875a.p();
                AtomicReference atomicReference2 = this.f4301b;
                p10.g();
                p10.h();
                p10.u(new b2(p10, atomicReference2, p10.w(false), G, 6));
                return;
            default:
                w3 p11 = this.f4302l.f3875a.p();
                n4 c9 = n4.c(i3.SGTM_CLIENT);
                AtomicReference atomicReference3 = this.f4301b;
                p11.g();
                p11.h();
                p11.u(new b2(p11, atomicReference3, p11.w(false), c9));
                return;
        }
    }

    public /* synthetic */ u2(b3 b3Var, AtomicReference atomicReference, int i, boolean z9) {
        this.f4300a = i;
        this.f4302l = b3Var;
        this.f4301b = atomicReference;
    }
}
