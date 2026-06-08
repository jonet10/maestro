package o7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class u0 implements Runnable, Comparable, o0 {
    private volatile Object _heap;

    /* renamed from: a, reason: collision with root package name */
    public long f8316a;

    /* renamed from: b, reason: collision with root package name */
    public int f8317b = -1;

    public u0(long j) {
        this.f8316a = j;
    }

    public final t7.x b() {
        Object obj = this._heap;
        if (obj instanceof t7.x) {
            return (t7.x) obj;
        }
        return null;
    }

    public final int c(long j, v0 v0Var, w0 w0Var) {
        synchronized (this) {
            if (this._heap == c0.f8244b) {
                return 2;
            }
            synchronized (v0Var) {
                try {
                    u0[] u0VarArr = v0Var.f10363a;
                    u0 u0Var = u0VarArr != null ? u0VarArr[0] : null;
                    if (w0.f8324p.get(w0Var) != 0) {
                        return 1;
                    }
                    if (u0Var == null) {
                        v0Var.f8320c = j;
                    } else {
                        long j6 = u0Var.f8316a;
                        if (j6 - j < 0) {
                            j = j6;
                        }
                        if (j - v0Var.f8320c > 0) {
                            v0Var.f8320c = j;
                        }
                    }
                    long j10 = this.f8316a;
                    long j11 = v0Var.f8320c;
                    if (j10 - j11 < 0) {
                        this.f8316a = j11;
                    }
                    v0Var.a(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j = this.f8316a - ((u0) obj).f8316a;
        if (j > 0) {
            return 1;
        }
        return j < 0 ? -1 : 0;
    }

    public final void d(v0 v0Var) {
        if (this._heap != c0.f8244b) {
            this._heap = v0Var;
        } else {
            com.google.gson.internal.a.p("Failed requirement.");
        }
    }

    @Override // o7.o0
    public final void dispose() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                f8.w wVar = c0.f8244b;
                if (obj == wVar) {
                    return;
                }
                v0 v0Var = obj instanceof v0 ? (v0) obj : null;
                if (v0Var != null) {
                    v0Var.b(this);
                }
                this._heap = wVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return "Delayed[nanos=" + this.f8316a + ']';
    }
}
