package e1;

import android.os.Handler;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class n {

    /* renamed from: d, reason: collision with root package name */
    public static volatile a4.c0 f4137d;

    /* renamed from: a, reason: collision with root package name */
    public final f2 f4138a;

    /* renamed from: b, reason: collision with root package name */
    public final m1.a f4139b;

    /* renamed from: c, reason: collision with root package name */
    public volatile long f4140c;

    public n(f2 f2Var) {
        k0.y.g(f2Var);
        this.f4138a = f2Var;
        this.f4139b = new m1.a(this, f2Var, 3, false);
    }

    public abstract void a();

    public final void b(long j) {
        c();
        if (j >= 0) {
            f2 f2Var = this.f4138a;
            f2Var.f().getClass();
            this.f4140c = System.currentTimeMillis();
            if (d().postDelayed(this.f4139b, j)) {
                return;
            }
            f2Var.a().f4339o.c(Long.valueOf(j), "Failed to schedule delayed post. time");
        }
    }

    public final void c() {
        this.f4140c = 0L;
        d().removeCallbacks(this.f4139b);
    }

    public final Handler d() {
        a4.c0 c0Var;
        if (f4137d != null) {
            return f4137d;
        }
        synchronized (n.class) {
            try {
                if (f4137d == null) {
                    f4137d = new a4.c0(this.f4138a.e().getMainLooper(), 3);
                }
                c0Var = f4137d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0Var;
    }
}
