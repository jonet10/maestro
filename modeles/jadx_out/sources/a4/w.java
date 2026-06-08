package a4;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final InputStream f182a;

    /* renamed from: b, reason: collision with root package name */
    public long f183b;

    /* renamed from: l, reason: collision with root package name */
    public long f184l;

    /* renamed from: m, reason: collision with root package name */
    public long f185m;

    /* renamed from: n, reason: collision with root package name */
    public long f186n = -1;

    /* renamed from: o, reason: collision with root package name */
    public boolean f187o = true;

    /* renamed from: p, reason: collision with root package name */
    public final int f188p;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.BufferedInputStream] */
    public w(w8.f fVar) {
        this.f188p = -1;
        this.f182a = fVar.markSupported() ? fVar : new BufferedInputStream(fVar, 4096);
        this.f188p = 1024;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f182a.available();
    }

    public final void b(long j) {
        if (this.f183b > this.f185m || j < this.f184l) {
            com.google.gson.internal.a.n("Cannot reset");
            return;
        }
        this.f182a.reset();
        d(this.f184l, j);
        this.f183b = j;
    }

    public final void c(long j) {
        try {
            long j6 = this.f184l;
            long j10 = this.f183b;
            InputStream inputStream = this.f182a;
            if (j6 >= j10 || j10 > this.f185m) {
                this.f184l = j10;
                inputStream.mark((int) (j - j10));
            } else {
                inputStream.reset();
                inputStream.mark((int) (j - this.f184l));
                d(this.f184l, this.f183b);
            }
            this.f185m = j;
        } catch (IOException e10) {
            a3.b.l(e10, "Unable to mark: ");
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f182a.close();
    }

    public final void d(long j, long j6) {
        while (j < j6) {
            long skip = this.f182a.skip(j6 - j);
            if (skip == 0) {
                if (read() == -1) {
                    return;
                } else {
                    skip = 1;
                }
            }
            j += skip;
        }
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        long j = this.f183b + i;
        if (this.f185m < j) {
            c(j);
        }
        this.f186n = this.f183b;
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f182a.markSupported();
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr) {
        if (!this.f187o) {
            long j = this.f183b;
            if (bArr.length + j > this.f185m) {
                c(j + bArr.length + this.f188p);
            }
        }
        int read = this.f182a.read(bArr);
        if (read != -1) {
            this.f183b += read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public final void reset() {
        b(this.f186n);
    }

    @Override // java.io.InputStream
    public final long skip(long j) {
        if (!this.f187o) {
            long j6 = this.f183b + j;
            if (j6 > this.f185m) {
                c(j6 + this.f188p);
            }
        }
        long skip = this.f182a.skip(j);
        this.f183b += skip;
        return skip;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (!this.f187o) {
            long j = this.f183b + 1;
            long j6 = this.f185m;
            if (j > j6) {
                c(j6 + this.f188p);
            }
        }
        int read = this.f182a.read();
        if (read != -1) {
            this.f183b++;
        }
        return read;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i6) {
        if (!this.f187o) {
            long j = this.f183b + i6;
            if (j > this.f185m) {
                c(j + this.f188p);
            }
        }
        int read = this.f182a.read(bArr, i, i6);
        if (read != -1) {
            this.f183b += read;
        }
        return read;
    }
}
