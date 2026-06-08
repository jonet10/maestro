package p8;

import a2.q;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import m8.f0;
import m8.m;
import m8.z;
import s8.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final m8.a f8486a;

    /* renamed from: b, reason: collision with root package name */
    public q f8487b;

    /* renamed from: c, reason: collision with root package name */
    public f0 f8488c;

    /* renamed from: d, reason: collision with root package name */
    public final m f8489d;

    /* renamed from: e, reason: collision with root package name */
    public final m8.b f8490e;
    public final Object f;
    public final c g;
    public int h;
    public a i;
    public boolean j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8491k;

    /* renamed from: l, reason: collision with root package name */
    public q8.a f8492l;

    public e(m mVar, m8.a aVar, z zVar, m8.b bVar, Object obj) {
        this.f8489d = mVar;
        this.f8486a = aVar;
        this.f8490e = bVar;
        m8.b.f7682e.getClass();
        this.g = new c(aVar, mVar.f7761e, zVar, bVar);
        this.f = obj;
    }

    public final synchronized a a() {
        return this.i;
    }

    public final Socket b(boolean z9, boolean z10, boolean z11) {
        Socket socket;
        if (z11) {
            this.f8492l = null;
        }
        if (z10) {
            this.f8491k = true;
        }
        a aVar = this.i;
        if (aVar != null) {
            if (z9) {
                aVar.f8473k = true;
            }
            if (this.f8492l == null && (this.f8491k || aVar.f8473k)) {
                ArrayList arrayList = aVar.f8476n;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    if (((Reference) arrayList.get(i)).get() == this) {
                        arrayList.remove(i);
                        if (this.i.f8476n.isEmpty()) {
                            this.i.f8477o = System.nanoTime();
                            m8.b bVar = m8.b.f7682e;
                            a aVar2 = this.i;
                            bVar.getClass();
                            m mVar = this.f8489d;
                            mVar.getClass();
                            if (aVar2.f8473k || mVar.f7757a == 0) {
                                mVar.f7760d.remove(aVar2);
                                socket = this.i.f8472e;
                                this.i = null;
                                return socket;
                            }
                            mVar.notifyAll();
                        }
                        socket = null;
                        this.i = null;
                        return socket;
                    }
                }
                throw new IllegalStateException();
            }
        }
        return null;
    }

    public final a c(int i, int i6, int i10, boolean z9) {
        a aVar;
        boolean z10;
        Socket socket;
        Socket b7;
        a aVar2;
        boolean z11;
        f0 f0Var;
        boolean z12;
        q qVar;
        synchronized (this.f8489d) {
            try {
                if (this.f8491k) {
                    throw new IllegalStateException("released");
                }
                if (this.f8492l != null) {
                    throw new IllegalStateException("codec != null");
                }
                aVar = this.i;
                z10 = true;
                socket = null;
                b7 = (aVar == null || !aVar.f8473k) ? null : b(false, false, true);
                aVar2 = this.i;
                if (aVar2 != null) {
                    aVar = null;
                } else {
                    aVar2 = null;
                }
                if (!this.j) {
                    aVar = null;
                }
                if (aVar2 == null) {
                    m8.b bVar = m8.b.f7682e;
                    m mVar = this.f8489d;
                    m8.a aVar3 = this.f8486a;
                    bVar.getClass();
                    m8.b.b(mVar, aVar3, this, null);
                    a aVar4 = this.i;
                    if (aVar4 != null) {
                        z11 = true;
                        aVar2 = aVar4;
                    } else {
                        f0Var = this.f8488c;
                        z11 = false;
                    }
                } else {
                    z11 = false;
                }
                f0Var = null;
            } finally {
            }
        }
        n8.c.d(b7);
        if (aVar != null) {
            this.f8490e.getClass();
        }
        if (z11) {
            this.f8490e.getClass();
        }
        if (aVar2 != null) {
            return aVar2;
        }
        if (f0Var != null || ((qVar = this.f8487b) != null && qVar.f44b < qVar.f43a.size())) {
            z12 = false;
        } else {
            this.f8487b = this.g.b();
            z12 = true;
        }
        synchronized (this.f8489d) {
            if (z12) {
                try {
                    q qVar2 = this.f8487b;
                    qVar2.getClass();
                    ArrayList arrayList = new ArrayList(qVar2.f43a);
                    int size = arrayList.size();
                    int i11 = 0;
                    while (true) {
                        if (i11 >= size) {
                            break;
                        }
                        f0 f0Var2 = (f0) arrayList.get(i11);
                        m8.b bVar2 = m8.b.f7682e;
                        m mVar2 = this.f8489d;
                        m8.a aVar5 = this.f8486a;
                        bVar2.getClass();
                        m8.b.b(mVar2, aVar5, this, f0Var2);
                        a aVar6 = this.i;
                        if (aVar6 != null) {
                            this.f8488c = f0Var2;
                            z11 = true;
                            aVar2 = aVar6;
                            break;
                        }
                        i11++;
                    }
                } finally {
                }
            }
            if (!z11) {
                if (f0Var == null) {
                    q qVar3 = this.f8487b;
                    if (!(qVar3.f44b < qVar3.f43a.size())) {
                        throw new NoSuchElementException();
                    }
                    ArrayList arrayList2 = qVar3.f43a;
                    int i12 = qVar3.f44b;
                    qVar3.f44b = i12 + 1;
                    f0Var = (f0) arrayList2.get(i12);
                }
                this.f8488c = f0Var;
                this.h = 0;
                aVar2 = new a(this.f8489d, f0Var);
                if (this.i != null) {
                    throw new IllegalStateException();
                }
                this.i = aVar2;
                this.j = false;
                aVar2.f8476n.add(new d(this, this.f));
            }
        }
        if (z11) {
            this.f8490e.getClass();
            return aVar2;
        }
        aVar2.c(i, i6, i10, z9, this.f8490e);
        m8.b bVar3 = m8.b.f7682e;
        m mVar3 = this.f8489d;
        bVar3.getClass();
        mVar3.f7761e.w(aVar2.f8470c);
        synchronized (this.f8489d) {
            try {
                this.j = true;
                m8.b bVar4 = m8.b.f7682e;
                m mVar4 = this.f8489d;
                bVar4.getClass();
                if (!mVar4.f) {
                    mVar4.f = true;
                    m.g.execute(mVar4.f7759c);
                }
                mVar4.f7760d.add(aVar2);
                if (aVar2.h == null) {
                    z10 = false;
                }
                if (z10) {
                    m8.b bVar5 = m8.b.f7682e;
                    m mVar5 = this.f8489d;
                    m8.a aVar7 = this.f8486a;
                    bVar5.getClass();
                    socket = m8.b.a(mVar5, aVar7, this);
                    aVar2 = this.i;
                }
            } finally {
            }
        }
        n8.c.d(socket);
        this.f8490e.getClass();
        return aVar2;
    }

    public final a d(int i, int i6, int i10, boolean z9, boolean z10) {
        while (true) {
            a c9 = c(i, i6, i10, z9);
            synchronized (this.f8489d) {
                try {
                    if (c9.f8474l == 0) {
                        return c9;
                    }
                    if (c9.h(z10)) {
                        return c9;
                    }
                    e();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void e() {
        a aVar;
        Socket b7;
        synchronized (this.f8489d) {
            aVar = this.i;
            b7 = b(true, false, false);
            if (this.i != null) {
                aVar = null;
            }
        }
        n8.c.d(b7);
        if (aVar != null) {
            this.f8490e.getClass();
        }
    }

    public final void f() {
        a aVar;
        Socket b7;
        synchronized (this.f8489d) {
            aVar = this.i;
            b7 = b(false, true, false);
            if (this.i != null) {
                aVar = null;
            }
        }
        n8.c.d(b7);
        if (aVar != null) {
            this.f8490e.getClass();
        }
    }

    public final void g(IOException iOException) {
        a aVar;
        boolean z9;
        Socket b7;
        synchronized (this.f8489d) {
            try {
                aVar = null;
                if (iOException instanceof a0) {
                    int i = ((a0) iOException).f9380a;
                    if (i == 5) {
                        this.h++;
                    }
                    if (i != 5 || this.h > 1) {
                        this.f8488c = null;
                        z9 = true;
                    }
                    z9 = false;
                } else {
                    a aVar2 = this.i;
                    if (aVar2 != null) {
                        if (!(aVar2.h != null) || (iOException instanceof s8.a)) {
                            if (aVar2.f8474l == 0) {
                                f0 f0Var = this.f8488c;
                                if (f0Var != null && iOException != null) {
                                    this.g.a(f0Var, iOException);
                                }
                                this.f8488c = null;
                            }
                            z9 = true;
                        }
                    }
                    z9 = false;
                }
                a aVar3 = this.i;
                b7 = b(z9, false, true);
                if (this.i == null && this.j) {
                    aVar = aVar3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        n8.c.d(b7);
        if (aVar != null) {
            this.f8490e.getClass();
        }
    }

    public final void h(boolean z9, q8.a aVar, IOException iOException) {
        a aVar2;
        Socket b7;
        boolean z10;
        this.f8490e.getClass();
        synchronized (this.f8489d) {
            try {
                if (aVar != this.f8492l) {
                    throw new IllegalStateException("expected " + this.f8492l + " but was " + aVar);
                }
                if (!z9) {
                    this.i.f8474l++;
                }
                aVar2 = this.i;
                b7 = b(z9, false, true);
                if (this.i != null) {
                    aVar2 = null;
                }
                z10 = this.f8491k;
            } catch (Throwable th) {
                throw th;
            }
        }
        n8.c.d(b7);
        if (aVar2 != null) {
            this.f8490e.getClass();
        }
        if (iOException != null) {
            this.f8490e.getClass();
        } else if (z10) {
            this.f8490e.getClass();
        }
    }

    public final String toString() {
        a a8 = a();
        return a8 != null ? a8.toString() : this.f8486a.toString();
    }
}
