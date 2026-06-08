package w8;

import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public byte f10989a;

    /* renamed from: b, reason: collision with root package name */
    public final a0 f10990b;

    /* renamed from: l, reason: collision with root package name */
    public final Inflater f10991l;

    /* renamed from: m, reason: collision with root package name */
    public final t f10992m;

    /* renamed from: n, reason: collision with root package name */
    public final CRC32 f10993n;

    public s(g0 g0Var) {
        g0Var.getClass();
        a0 a0Var = new a0(g0Var);
        this.f10990b = a0Var;
        Inflater inflater = new Inflater(true);
        this.f10991l = inflater;
        this.f10992m = new t(a0Var, inflater);
        this.f10993n = new CRC32();
    }

    public static void b(int i, int i6, String str) {
        if (i6 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i6), Integer.valueOf(i)}, 3)));
        }
    }

    @Override // w8.g0
    public final i0 a() {
        return this.f10990b.f10933a.a();
    }

    public final void c(h hVar, long j, long j6) {
        b0 b0Var = hVar.f10960a;
        b0Var.getClass();
        while (true) {
            int i = b0Var.f10941c;
            int i6 = b0Var.f10940b;
            if (j < i - i6) {
                break;
            }
            j -= i - i6;
            b0Var = b0Var.f;
            b0Var.getClass();
        }
        while (j6 > 0) {
            int min = (int) Math.min(b0Var.f10941c - r6, j6);
            this.f10993n.update(b0Var.f10939a, (int) (b0Var.f10940b + j), min);
            j6 -= min;
            b0Var = b0Var.f;
            b0Var.getClass();
            j = 0;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f10992m.close();
    }

    @Override // w8.g0
    public final long p(h hVar, long j) {
        s sVar = this;
        hVar.getClass();
        if (j < 0) {
            s1.o.o(a4.x.h(j, "byteCount < 0: "));
            return 0L;
        }
        if (j == 0) {
            return 0L;
        }
        byte b7 = sVar.f10989a;
        CRC32 crc32 = sVar.f10993n;
        a0 a0Var = sVar.f10990b;
        if (b7 == 0) {
            a0Var.t(10L);
            h hVar2 = a0Var.f10934b;
            byte d10 = hVar2.d(3L);
            boolean z9 = ((d10 >> 1) & 1) == 1;
            if (z9) {
                sVar.c(hVar2, 0L, 10L);
            }
            b(8075, a0Var.readShort(), "ID1ID2");
            a0Var.skip(8L);
            if (((d10 >> 2) & 1) == 1) {
                a0Var.t(2L);
                if (z9) {
                    c(hVar2, 0L, 2L);
                }
                long n10 = hVar2.n() & 65535;
                a0Var.t(n10);
                if (z9) {
                    c(hVar2, 0L, n10);
                }
                a0Var.skip(n10);
            }
            if (((d10 >> 3) & 1) == 1) {
                long c9 = a0Var.c((byte) 0, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
                if (c9 == -1) {
                    s1.o.d();
                    return 0L;
                }
                if (z9) {
                    c(hVar2, 0L, c9 + 1);
                }
                a0Var.skip(c9 + 1);
            }
            if (((d10 >> 4) & 1) == 1) {
                long c10 = a0Var.c((byte) 0, 0L, LocationRequestCompat.PASSIVE_INTERVAL);
                if (c10 == -1) {
                    s1.o.d();
                    return 0L;
                }
                if (z9) {
                    sVar = this;
                    sVar.c(hVar2, 0L, c10 + 1);
                } else {
                    sVar = this;
                }
                a0Var.skip(c10 + 1);
            } else {
                sVar = this;
            }
            if (z9) {
                b(a0Var.i(), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            sVar.f10989a = (byte) 1;
        }
        if (sVar.f10989a == 1) {
            long j6 = hVar.f10961b;
            long p10 = sVar.f10992m.p(hVar, j);
            if (p10 != -1) {
                sVar.c(hVar, j6, p10);
                return p10;
            }
            sVar.f10989a = (byte) 2;
        }
        if (sVar.f10989a == 2) {
            b(a0Var.f(), (int) crc32.getValue(), "CRC");
            b(a0Var.f(), (int) sVar.f10991l.getBytesWritten(), "ISIZE");
            sVar.f10989a = (byte) 3;
            if (!a0Var.b()) {
                com.google.gson.internal.a.n("gzip finished without exhausting source");
                return 0L;
            }
        }
        return -1L;
    }
}
