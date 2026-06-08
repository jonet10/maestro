package w8;

import com.google.android.gms.internal.measurement.i5;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10944a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f10945b;

    /* renamed from: l, reason: collision with root package name */
    public final Object f10946l;

    public c(InputStream inputStream, i0 i0Var) {
        inputStream.getClass();
        this.f10945b = inputStream;
        this.f10946l = i0Var;
    }

    @Override // w8.g0
    public final i0 a() {
        switch (this.f10944a) {
            case 0:
                return (f0) this.f10945b;
            default:
                return (i0) this.f10946l;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f10944a) {
            case 0:
                f0 f0Var = (f0) this.f10945b;
                c cVar = (c) this.f10946l;
                f0Var.h();
                try {
                    cVar.close();
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
                ((InputStream) this.f10945b).close();
                return;
        }
    }

    @Override // w8.g0
    public final long p(h hVar, long j) {
        int i = this.f10944a;
        hVar.getClass();
        switch (i) {
            case 0:
                f0 f0Var = (f0) this.f10945b;
                c cVar = (c) this.f10946l;
                f0Var.h();
                try {
                    long p10 = cVar.p(hVar, j);
                    if (f0Var.i()) {
                        throw f0Var.k(null);
                    }
                    return p10;
                } catch (IOException e10) {
                    if (f0Var.i()) {
                        throw f0Var.k(e10);
                    }
                    throw e10;
                } finally {
                    f0Var.i();
                }
            default:
                if (j == 0) {
                    return 0L;
                }
                if (j < 0) {
                    s1.o.o(a4.x.h(j, "byteCount < 0: "));
                    return 0L;
                }
                try {
                    ((i0) this.f10946l).f();
                    b0 u7 = hVar.u(1);
                    int read = ((InputStream) this.f10945b).read(u7.f10939a, u7.f10941c, (int) Math.min(j, 8192 - u7.f10941c));
                    if (read == -1) {
                        if (u7.f10940b == u7.f10941c) {
                            hVar.f10960a = u7.a();
                            c0.a(u7);
                        }
                        return -1L;
                    }
                    u7.f10941c += read;
                    long j6 = read;
                    hVar.f10961b += j6;
                    return j6;
                } catch (AssertionError e11) {
                    if (i5.y(e11)) {
                        throw new IOException(e11);
                    }
                    throw e11;
                }
        }
    }

    public final String toString() {
        switch (this.f10944a) {
            case 0:
                return "AsyncTimeout.source(" + ((c) this.f10946l) + ')';
            default:
                return "source(" + ((InputStream) this.f10945b) + ')';
        }
    }

    public c(f0 f0Var, c cVar) {
        this.f10945b = f0Var;
        this.f10946l = cVar;
    }
}
