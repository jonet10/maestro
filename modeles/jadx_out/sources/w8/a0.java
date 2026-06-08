package w8;

import androidx.core.location.LocationRequestCompat;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a0 implements j {

    /* renamed from: a, reason: collision with root package name */
    public final g0 f10933a;

    /* renamed from: b, reason: collision with root package name */
    public final h f10934b;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10935l;

    public a0(g0 g0Var) {
        g0Var.getClass();
        this.f10933a = g0Var;
        this.f10934b = new h();
    }

    @Override // w8.g0
    public final i0 a() {
        return this.f10933a.a();
    }

    public final boolean b() {
        if (this.f10935l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return false;
        }
        h hVar = this.f10934b;
        return hVar.c() && this.f10933a.p(hVar, 8192L) == -1;
    }

    public final long c(byte b7, long j, long j6) {
        if (this.f10935l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return 0L;
        }
        if (0 > j6) {
            s1.o.o(a4.x.h(j6, "fromIndex=0 toIndex="));
            return 0L;
        }
        long j10 = 0;
        while (j10 < j6) {
            h hVar = this.f10934b;
            byte b10 = b7;
            long j11 = j6;
            long e10 = hVar.e(b10, j10, j11);
            if (e10 == -1) {
                long j12 = hVar.f10961b;
                if (j12 >= j11 || this.f10933a.p(hVar, 8192L) == -1) {
                    break;
                }
                j10 = Math.max(j10, j12);
                b7 = b10;
                j6 = j11;
            } else {
                return e10;
            }
        }
        return -1L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.f10935l) {
            return;
        }
        this.f10935l = true;
        this.f10933a.close();
        h hVar = this.f10934b;
        hVar.skip(hVar.f10961b);
    }

    public final boolean d(long j, k kVar) {
        int i;
        kVar.getClass();
        int f = kVar.f();
        if (this.f10935l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return false;
        }
        if (j >= 0 && f >= 0 && kVar.f() >= f) {
            for (0; i < f; i + 1) {
                long j6 = i + j;
                i = (n(1 + j6) && this.f10934b.d(j6) == kVar.k(i)) ? i + 1 : 0;
            }
            return true;
        }
        return false;
    }

    public final void e(byte[] bArr) {
        h hVar = this.f10934b;
        int i = 0;
        try {
            t(bArr.length);
            while (i < bArr.length) {
                int read = hVar.read(bArr, i, bArr.length - i);
                if (read == -1) {
                    s1.o.d();
                    return;
                }
                i += read;
            }
        } catch (EOFException e10) {
            while (true) {
                long j = hVar.f10961b;
                if (j <= 0) {
                    throw e10;
                }
                int read2 = hVar.read(bArr, i, (int) j);
                if (read2 == -1) {
                    throw new AssertionError();
                }
                i += read2;
            }
        }
    }

    public final int f() {
        t(4L);
        int readInt = this.f10934b.readInt();
        return ((readInt & 255) << 24) | (((-16777216) & readInt) >>> 24) | ((16711680 & readInt) >>> 8) | ((65280 & readInt) << 8);
    }

    @Override // w8.j
    public final k g(long j) {
        t(j);
        return this.f10934b.g(j);
    }

    public final long h() {
        char c9;
        char c10;
        char c11;
        char c12;
        long j;
        t(8L);
        h hVar = this.f10934b;
        if (hVar.f10961b < 8) {
            s1.o.d();
            return 0L;
        }
        b0 b0Var = hVar.f10960a;
        b0Var.getClass();
        int i = b0Var.f10940b;
        int i6 = b0Var.f10941c;
        if (i6 - i < 8) {
            j = ((hVar.readInt() & 4294967295L) << 32) | (4294967295L & hVar.readInt());
            c11 = '8';
            c12 = '\b';
            c9 = 24;
            c10 = '(';
        } else {
            byte[] bArr = b0Var.f10939a;
            c9 = 24;
            c10 = '(';
            c11 = '8';
            c12 = '\b';
            int i10 = i + 7;
            long j6 = ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
            int i11 = i + 8;
            long j10 = j6 | (bArr[i10] & 255);
            hVar.f10961b -= 8;
            if (i11 == i6) {
                hVar.f10960a = b0Var.a();
                c0.a(b0Var);
            } else {
                b0Var.f10940b = i11;
            }
            j = j10;
        }
        return ((j & 255) << c11) | (((-72057594037927936L) & j) >>> c11) | ((71776119061217280L & j) >>> c10) | ((280375465082880L & j) >>> c9) | ((1095216660480L & j) >>> c12) | ((4278190080L & j) << c12) | ((16711680 & j) << c9) | ((65280 & j) << c10);
    }

    public final short i() {
        t(2L);
        return this.f10934b.n();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f10935l;
    }

    public final String j(long j) {
        t(j);
        return this.f10934b.r(j, l7.a.f7151a);
    }

    @Override // w8.j
    public final String k(long j) {
        if (j < 0) {
            s1.o.o(a4.x.h(j, "limit < 0: "));
            return null;
        }
        long j6 = j == LocationRequestCompat.PASSIVE_INTERVAL ? Long.MAX_VALUE : j + 1;
        long c9 = c((byte) 10, 0L, j6);
        h hVar = this.f10934b;
        if (c9 != -1) {
            return x8.a.a(hVar, c9);
        }
        if (j6 < LocationRequestCompat.PASSIVE_INTERVAL && n(j6) && hVar.d(j6 - 1) == 13 && n(j6 + 1) && hVar.d(j6) == 10) {
            return x8.a.a(hVar, j6);
        }
        h hVar2 = new h();
        hVar.b(hVar2, 0L, Math.min(32, hVar.f10961b));
        throw new EOFException("\\n not found: limit=" + Math.min(hVar.f10961b, j) + " content=" + hVar2.g(hVar2.f10961b).g() + (char) 8230);
    }

    public final boolean n(long j) {
        h hVar;
        if (j < 0) {
            s1.o.o(a4.x.h(j, "byteCount < 0: "));
            return false;
        }
        if (this.f10935l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return false;
        }
        do {
            hVar = this.f10934b;
            if (hVar.f10961b >= j) {
                return true;
            }
        } while (this.f10933a.p(hVar, 8192L) != -1);
        return false;
    }

    @Override // w8.g0
    public final long p(h hVar, long j) {
        hVar.getClass();
        if (j < 0) {
            s1.o.o(a4.x.h(j, "byteCount < 0: "));
            return 0L;
        }
        if (this.f10935l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return 0L;
        }
        h hVar2 = this.f10934b;
        if (hVar2.f10961b == 0 && this.f10933a.p(hVar2, 8192L) == -1) {
            return -1L;
        }
        return hVar2.p(hVar, Math.min(j, hVar2.f10961b));
    }

    @Override // w8.j
    public final String q() {
        return k(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        h hVar = this.f10934b;
        if (hVar.f10961b == 0 && this.f10933a.p(hVar, 8192L) == -1) {
            return -1;
        }
        return hVar.read(byteBuffer);
    }

    @Override // w8.j
    public final byte readByte() {
        t(1L);
        return this.f10934b.readByte();
    }

    @Override // w8.j
    public final int readInt() {
        t(4L);
        return this.f10934b.readInt();
    }

    @Override // w8.j
    public final short readShort() {
        t(2L);
        return this.f10934b.readShort();
    }

    @Override // w8.j
    public final void skip(long j) {
        if (this.f10935l) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("closed");
            return;
        }
        while (j > 0) {
            h hVar = this.f10934b;
            if (hVar.f10961b == 0 && this.f10933a.p(hVar, 8192L) == -1) {
                s1.o.d();
                return;
            } else {
                long min = Math.min(j, hVar.f10961b);
                hVar.skip(min);
                j -= min;
            }
        }
    }

    @Override // w8.j
    public final void t(long j) {
        if (n(j)) {
            return;
        }
        s1.o.d();
    }

    public final String toString() {
        return "buffer(" + this.f10933a + ')';
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0031, code lost:
    
        if (r0 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        d0.b.v(16);
        d0.b.v(16);
        r1 = java.lang.Integer.toString(r2, 16);
        r1.getClass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004e, code lost:
    
        throw new java.lang.NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x".concat(r1));
     */
    @Override // w8.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long w() {
        /*
            r6 = this;
            r0 = 1
            r6.t(r0)
            r0 = 0
        L6:
            int r1 = r0 + 1
            long r2 = (long) r1
            boolean r2 = r6.n(r2)
            w8.h r3 = r6.f10934b
            if (r2 == 0) goto L4f
            long r4 = (long) r0
            byte r2 = r3.d(r4)
            r4 = 48
            if (r2 < r4) goto L1e
            r4 = 57
            if (r2 <= r4) goto L2f
        L1e:
            r4 = 97
            if (r2 < r4) goto L26
            r4 = 102(0x66, float:1.43E-43)
            if (r2 <= r4) goto L2f
        L26:
            r4 = 65
            if (r2 < r4) goto L31
            r4 = 70
            if (r2 <= r4) goto L2f
            goto L31
        L2f:
            r0 = r1
            goto L6
        L31:
            if (r0 == 0) goto L34
            goto L4f
        L34:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = 16
            d0.b.v(r1)
            d0.b.v(r1)
            java.lang.String r1 = java.lang.Integer.toString(r2, r1)
            r1.getClass()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r1 = r2.concat(r1)
            r0.<init>(r1)
            throw r0
        L4f:
            long r0 = r3.w()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.a0.w():long");
    }

    @Override // w8.j
    public final InputStream x() {
        return new f(this, 1);
    }
}
