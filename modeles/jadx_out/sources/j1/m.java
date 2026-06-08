package j1;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m implements n, f, e, c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6554a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f6555b;

    /* renamed from: l, reason: collision with root package name */
    public final Object f6556l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f6557m;

    public m(Executor executor, c cVar) {
        this.f6554a = 0;
        this.f6556l = new Object();
        this.f6555b = executor;
        this.f6557m = cVar;
    }

    private final void b(p pVar) {
        synchronized (this.f6556l) {
        }
        this.f6555b.execute(new m1.a(this, pVar, 24, false));
    }

    private final void d(p pVar) {
        if (pVar.i() || pVar.f6563d) {
            return;
        }
        synchronized (this.f6556l) {
            try {
                if (((e) this.f6557m) == null) {
                    return;
                }
                this.f6555b.execute(new m1.a(this, pVar, 25, false));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void e(p pVar) {
        if (pVar.i()) {
            synchronized (this.f6556l) {
                try {
                    if (((f) this.f6557m) == null) {
                        return;
                    }
                    this.f6555b.execute(new m1.a(this, pVar, 26, false));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // j1.n
    public final void a(p pVar) {
        switch (this.f6554a) {
            case 0:
                if (pVar.f6563d) {
                    synchronized (this.f6556l) {
                        try {
                            if (((c) this.f6557m) != null) {
                                this.f6555b.execute(new a4.f(this, 19));
                            }
                        } finally {
                        }
                    }
                    return;
                }
                return;
            case 1:
                b(pVar);
                return;
            case 2:
                d(pVar);
                return;
            case 3:
                e(pVar);
                return;
            default:
                this.f6555b.execute(new m1.a(this, pVar, 27, false));
                return;
        }
    }

    @Override // j1.f
    public void c(Object obj) {
        ((p) this.f6557m).k(obj);
    }

    @Override // j1.c
    public void f() {
        ((p) this.f6557m).n();
    }

    @Override // j1.e
    public void i(Exception exc) {
        ((p) this.f6557m).m(exc);
    }

    public m(Executor executor, d dVar) {
        this.f6554a = 1;
        this.f6556l = new Object();
        this.f6555b = executor;
        this.f6557m = dVar;
    }

    public m(Executor executor, e eVar) {
        this.f6554a = 2;
        this.f6556l = new Object();
        this.f6555b = executor;
        this.f6557m = eVar;
    }

    public m(Executor executor, f fVar) {
        this.f6554a = 3;
        this.f6556l = new Object();
        this.f6555b = executor;
        this.f6557m = fVar;
    }

    public m(Executor executor, h hVar, p pVar) {
        this.f6554a = 4;
        this.f6555b = executor;
        this.f6556l = hVar;
        this.f6557m = pVar;
    }
}
