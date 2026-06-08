package s8;

import java.io.IOException;
import java.io.InterruptedIOException;
import w8.g0;
import w8.i0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public final w8.h f9458a = new w8.h();

    /* renamed from: b, reason: collision with root package name */
    public final w8.h f9459b = new w8.h();

    /* renamed from: l, reason: collision with root package name */
    public final long f9460l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9461m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f9462n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ w f9463o;

    public u(w wVar, long j) {
        this.f9463o = wVar;
        this.f9460l = j;
    }

    @Override // w8.g0
    public final i0 a() {
        return this.f9463o.i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        synchronized (this.f9463o) {
            this.f9461m = true;
            w8.h hVar = this.f9459b;
            hVar.skip(hVar.f10961b);
            this.f9463o.notifyAll();
        }
        this.f9463o.a();
    }

    @Override // w8.g0
    public final long p(w8.h hVar, long j) {
        if (j < 0) {
            com.google.gson.internal.a.p(a4.x.h(j, "byteCount < 0: "));
            return 0L;
        }
        synchronized (this.f9463o) {
            try {
                w wVar = this.f9463o;
                wVar.i.h();
                while (this.f9459b.f10961b == 0 && !this.f9462n && !this.f9461m && wVar.f9470k == 0) {
                    try {
                        try {
                            wVar.wait();
                        } catch (InterruptedException unused) {
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        wVar.i.k();
                        throw th;
                    }
                }
                wVar.i.k();
                if (this.f9461m) {
                    throw new IOException("stream closed");
                }
                int i = this.f9463o.f9470k;
                if (i != 0) {
                    throw new a0(i);
                }
                w8.h hVar2 = this.f9459b;
                long j6 = hVar2.f10961b;
                if (j6 == 0) {
                    return -1L;
                }
                long p10 = hVar2.p(hVar, Math.min(j, j6));
                w wVar2 = this.f9463o;
                long j10 = wVar2.f9465a + p10;
                wVar2.f9465a = j10;
                if (j10 >= wVar2.f9468d.f9439w.c() / 2) {
                    w wVar3 = this.f9463o;
                    wVar3.f9468d.n(wVar3.f9467c, wVar3.f9465a);
                    this.f9463o.f9465a = 0L;
                }
                synchronized (this.f9463o.f9468d) {
                    try {
                        q qVar = this.f9463o.f9468d;
                        long j11 = qVar.f9438u + p10;
                        qVar.f9438u = j11;
                        if (j11 >= qVar.f9439w.c() / 2) {
                            q qVar2 = this.f9463o.f9468d;
                            qVar2.n(0, qVar2.f9438u);
                            this.f9463o.f9468d.f9438u = 0L;
                        }
                    } finally {
                    }
                }
                return p10;
            } finally {
            }
        }
    }
}
