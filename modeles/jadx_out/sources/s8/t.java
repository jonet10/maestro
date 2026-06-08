package s8;

import java.io.InterruptedIOException;
import w8.e0;
import w8.i0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final w8.h f9454a = new w8.h();

    /* renamed from: b, reason: collision with root package name */
    public boolean f9455b;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9456l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ w f9457m;

    public t(w wVar) {
        this.f9457m = wVar;
    }

    @Override // w8.e0
    public final i0 a() {
        return this.f9457m.j;
    }

    public final void b(boolean z9) {
        w wVar;
        long min;
        w wVar2;
        synchronized (this.f9457m) {
            this.f9457m.j.h();
            while (true) {
                try {
                    wVar = this.f9457m;
                    if (wVar.f9466b > 0 || this.f9456l || this.f9455b || wVar.f9470k != 0) {
                        break;
                    }
                    try {
                        wVar.wait();
                    } catch (InterruptedException unused) {
                        throw new InterruptedIOException();
                    }
                } finally {
                    this.f9457m.j.k();
                }
            }
            wVar.j.k();
            this.f9457m.b();
            min = Math.min(this.f9457m.f9466b, this.f9454a.f10961b);
            wVar2 = this.f9457m;
            wVar2.f9466b -= min;
        }
        wVar2.j.h();
        try {
            w wVar3 = this.f9457m;
            wVar3.f9468d.i(wVar3.f9467c, z9 && min == this.f9454a.f10961b, this.f9454a, min);
            this.f9457m.j.k();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // w8.e0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f9457m) {
            try {
                if (this.f9455b) {
                    return;
                }
                w wVar = this.f9457m;
                if (!wVar.h.f9456l) {
                    if (this.f9454a.f10961b > 0) {
                        while (this.f9454a.f10961b > 0) {
                            b(true);
                        }
                    } else {
                        wVar.f9468d.i(wVar.f9467c, true, null, 0L);
                    }
                }
                synchronized (this.f9457m) {
                    this.f9455b = true;
                }
                this.f9457m.f9468d.flush();
                this.f9457m.a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // w8.e0, java.io.Flushable
    public final void flush() {
        synchronized (this.f9457m) {
            this.f9457m.b();
        }
        while (this.f9454a.f10961b > 0) {
            b(false);
            this.f9457m.f9468d.flush();
        }
    }

    @Override // w8.e0
    public final void l(w8.h hVar, long j) {
        w8.h hVar2 = this.f9454a;
        hVar2.l(hVar, j);
        while (hVar2.f10961b >= 16384) {
            b(false);
        }
    }
}
