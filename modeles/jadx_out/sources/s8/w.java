package s8;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w {

    /* renamed from: b, reason: collision with root package name */
    public long f9466b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9467c;

    /* renamed from: d, reason: collision with root package name */
    public final q f9468d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f9469e;
    public boolean f;
    public final u g;
    public final t h;

    /* renamed from: a, reason: collision with root package name */
    public long f9465a = 0;
    public final v i = new v(this);
    public final v j = new v(this);

    /* renamed from: k, reason: collision with root package name */
    public int f9470k = 0;

    public w(int i, q qVar, boolean z9, boolean z10, ArrayList arrayList) {
        if (qVar == null) {
            com.google.gson.internal.a.i("connection == null");
            throw null;
        }
        this.f9467c = i;
        this.f9468d = qVar;
        this.f9466b = qVar.f9440x.c();
        u uVar = new u(this, qVar.f9439w.c());
        this.g = uVar;
        t tVar = new t(this);
        this.h = tVar;
        uVar.f9462n = z10;
        tVar.f9456l = z9;
    }

    public final void a() {
        boolean z9;
        boolean g;
        synchronized (this) {
            try {
                u uVar = this.g;
                if (!uVar.f9462n && uVar.f9461m) {
                    t tVar = this.h;
                    if (!tVar.f9456l) {
                        if (tVar.f9455b) {
                        }
                    }
                    z9 = true;
                    g = g();
                }
                z9 = false;
                g = g();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z9) {
            c(6);
        } else {
            if (g) {
                return;
            }
            this.f9468d.f(this.f9467c);
        }
    }

    public final void b() {
        t tVar = this.h;
        if (tVar.f9455b) {
            com.google.gson.internal.a.n("stream closed");
        } else {
            if (tVar.f9456l) {
                com.google.gson.internal.a.n("stream finished");
                return;
            }
            int i = this.f9470k;
            if (i != 0) {
                throw new a0(i);
            }
        }
    }

    public final void c(int i) {
        if (d(i)) {
            this.f9468d.A.i(this.f9467c, i);
        }
    }

    public final boolean d(int i) {
        synchronized (this) {
            try {
                if (this.f9470k != 0) {
                    return false;
                }
                if (this.g.f9462n && this.h.f9456l) {
                    return false;
                }
                this.f9470k = i;
                notifyAll();
                this.f9468d.f(this.f9467c);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final t e() {
        synchronized (this) {
            try {
                if (!this.f && !f()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.h;
    }

    public final boolean f() {
        return this.f9468d.f9427a == ((this.f9467c & 1) == 1);
    }

    public final synchronized boolean g() {
        try {
            if (this.f9470k != 0) {
                return false;
            }
            u uVar = this.g;
            if (!uVar.f9462n) {
                if (uVar.f9461m) {
                }
                return true;
            }
            t tVar = this.h;
            if (tVar.f9456l || tVar.f9455b) {
                if (this.f) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void h() {
        boolean g;
        synchronized (this) {
            this.g.f9462n = true;
            g = g();
            notifyAll();
        }
        if (g) {
            return;
        }
        this.f9468d.f(this.f9467c);
    }

    public final void i(ArrayList arrayList) {
        boolean z9;
        synchronized (this) {
            z9 = true;
            try {
                this.f = true;
                if (this.f9469e == null) {
                    this.f9469e = arrayList;
                    z9 = g();
                    notifyAll();
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.addAll(this.f9469e);
                    arrayList2.add(null);
                    arrayList2.addAll(arrayList);
                    this.f9469e = arrayList2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z9) {
            return;
        }
        this.f9468d.f(this.f9467c);
    }

    public final synchronized void j(int i) {
        if (this.f9470k == 0) {
            this.f9470k = i;
            notifyAll();
        }
    }
}
