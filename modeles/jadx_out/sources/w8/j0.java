package w8;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j0 extends o {

    /* renamed from: e, reason: collision with root package name */
    public static final y f10966e;

    /* renamed from: b, reason: collision with root package name */
    public final y f10967b;

    /* renamed from: c, reason: collision with root package name */
    public final o f10968c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f10969d;

    static {
        String str = y.f11004b;
        f10966e = q1.a.j("/", false);
    }

    public j0(y yVar, o oVar, LinkedHashMap linkedHashMap) {
        oVar.getClass();
        this.f10967b = yVar;
        this.f10968c = oVar;
        this.f10969d = linkedHashMap;
    }

    @Override // w8.o
    public final void a(y yVar, y yVar2) {
        yVar2.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // w8.o
    public final void b(y yVar) {
        throw new IOException("zip file systems are read-only");
    }

    @Override // w8.o
    public final void c(y yVar) {
        throw new IOException("zip file systems are read-only");
    }

    @Override // w8.o
    public final n e(y yVar) {
        a0 a0Var;
        yVar.getClass();
        y yVar2 = f10966e;
        yVar2.getClass();
        x8.g gVar = (x8.g) this.f10969d.get(x8.c.b(yVar2, yVar, true));
        Throwable th = null;
        if (gVar == null) {
            return null;
        }
        long j = gVar.g;
        boolean z9 = gVar.f11560b;
        n nVar = new n(!z9, z9, z9 ? null : Long.valueOf(gVar.f11562d), null, gVar.f, null);
        if (j == -1) {
            return nVar;
        }
        u f = this.f10968c.f(this.f10967b);
        try {
            a0Var = new a0(f.c(j));
            try {
                f.close();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (f != null) {
                try {
                    f.close();
                } catch (Throwable th4) {
                    p6.a.a(th3, th4);
                }
            }
            a0Var = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        a0Var.getClass();
        n f10 = x8.b.f(a0Var, nVar);
        f10.getClass();
        return f10;
    }

    @Override // w8.o
    public final u f(y yVar) {
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // w8.o
    public final u g(y yVar) {
        throw new IOException("zip entries are not writable");
    }

    @Override // w8.o
    public final g0 h(y yVar) {
        a0 a0Var;
        Throwable th;
        yVar.getClass();
        y yVar2 = f10966e;
        yVar2.getClass();
        x8.g gVar = (x8.g) this.f10969d.get(x8.c.b(yVar2, yVar, true));
        if (gVar == null) {
            s1.o.p(yVar, "no such file: ");
            return null;
        }
        long j = gVar.f11562d;
        u f = this.f10968c.f(this.f10967b);
        try {
            a0Var = new a0(f.c(gVar.g));
            try {
                f.close();
                th = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            if (f != null) {
                try {
                    f.close();
                } catch (Throwable th4) {
                    p6.a.a(th3, th4);
                }
            }
            a0Var = null;
            th = th3;
        }
        if (th != null) {
            throw th;
        }
        a0Var.getClass();
        x8.b.f(a0Var, null);
        if (gVar.f11563e == 0) {
            return new x8.e(a0Var, j, true);
        }
        return new x8.e(new t(new a0(new x8.e(a0Var, gVar.f11561c, true)), new Inflater(true)), j, false);
    }
}
