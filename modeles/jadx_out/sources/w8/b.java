package w8;

import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10936a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f10937b;

    /* renamed from: l, reason: collision with root package name */
    public final Object f10938l;

    public /* synthetic */ b(int i, Object obj, Object obj2) {
        this.f10936a = i;
        this.f10937b = obj;
        this.f10938l = obj2;
    }

    @Override // w8.e0
    public final i0 a() {
        switch (this.f10936a) {
            case 0:
                return (f0) this.f10937b;
            default:
                return (i0) this.f10938l;
        }
    }

    @Override // w8.e0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f10936a) {
            case 0:
                f0 f0Var = (f0) this.f10937b;
                b bVar = (b) this.f10938l;
                f0Var.h();
                try {
                    bVar.close();
                    if (f0Var.i()) {
                        throw f0Var.k(null);
                    }
                    return;
                } catch (IOException e10) {
                    if (!f0Var.i()) {
                        throw e10;
                    }
                    throw f0Var.k(e10);
                } finally {
                    f0Var.i();
                }
            default:
                ((OutputStream) this.f10937b).close();
                return;
        }
    }

    @Override // w8.e0, java.io.Flushable
    public final void flush() {
        switch (this.f10936a) {
            case 0:
                f0 f0Var = (f0) this.f10937b;
                b bVar = (b) this.f10938l;
                f0Var.h();
                try {
                    bVar.flush();
                    if (f0Var.i()) {
                        throw f0Var.k(null);
                    }
                    return;
                } catch (IOException e10) {
                    if (!f0Var.i()) {
                        throw e10;
                    }
                    throw f0Var.k(e10);
                } finally {
                    f0Var.i();
                }
            default:
                ((OutputStream) this.f10937b).flush();
                return;
        }
    }

    @Override // w8.e0
    public final void l(h hVar, long j) {
        switch (this.f10936a) {
            case 0:
                a.a.o(hVar.f10961b, 0L, j);
                long j6 = j;
                while (true) {
                    long j10 = 0;
                    if (j6 <= 0) {
                        return;
                    }
                    b0 b0Var = hVar.f10960a;
                    b0Var.getClass();
                    while (true) {
                        if (j10 < 65536) {
                            j10 += b0Var.f10941c - b0Var.f10940b;
                            if (j10 >= j6) {
                                j10 = j6;
                            } else {
                                b0Var = b0Var.f;
                                b0Var.getClass();
                            }
                        }
                    }
                    f0 f0Var = (f0) this.f10937b;
                    b bVar = (b) this.f10938l;
                    f0Var.h();
                    try {
                        try {
                            bVar.l(hVar, j10);
                            if (f0Var.i()) {
                                throw f0Var.k(null);
                            }
                            j6 -= j10;
                        } catch (IOException e10) {
                            if (!f0Var.i()) {
                                throw e10;
                            }
                            throw f0Var.k(e10);
                        }
                    } catch (Throwable th) {
                        f0Var.i();
                        throw th;
                    }
                }
            default:
                a.a.o(hVar.f10961b, 0L, j);
                while (j > 0) {
                    ((i0) this.f10938l).f();
                    b0 b0Var2 = hVar.f10960a;
                    b0Var2.getClass();
                    int min = (int) Math.min(j, b0Var2.f10941c - b0Var2.f10940b);
                    ((OutputStream) this.f10937b).write(b0Var2.f10939a, b0Var2.f10940b, min);
                    int i = b0Var2.f10940b + min;
                    b0Var2.f10940b = i;
                    long j11 = min;
                    j -= j11;
                    hVar.f10961b -= j11;
                    if (i == b0Var2.f10941c) {
                        hVar.f10960a = b0Var2.a();
                        c0.a(b0Var2);
                    }
                }
                return;
        }
    }

    public final String toString() {
        switch (this.f10936a) {
            case 0:
                return "AsyncTimeout.sink(" + ((b) this.f10938l) + ')';
            default:
                return "sink(" + ((OutputStream) this.f10937b) + ')';
        }
    }
}
