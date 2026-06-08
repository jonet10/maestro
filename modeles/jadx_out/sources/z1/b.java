package z1;

import b2.t1;
import j1.p;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import y1.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f11903a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11904b = new Object();

    /* renamed from: l, reason: collision with root package name */
    public p f11905l = t1.x(null);

    public b(ExecutorService executorService) {
        this.f11903a = executorService;
    }

    public final p a(Runnable runnable) {
        p e10;
        synchronized (this.f11904b) {
            e10 = this.f11905l.e(this.f11903a, new v4.a(runnable, 10));
            this.f11905l = e10;
        }
        return e10;
    }

    public final p b(j jVar) {
        p e10;
        synchronized (this.f11904b) {
            e10 = this.f11905l.e(this.f11903a, new v4.a(jVar, 9));
            this.f11905l = e10;
        }
        return e10;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f11903a.execute(runnable);
    }
}
