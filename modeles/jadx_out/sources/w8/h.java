package w8;

import androidx.core.location.LocationRequestCompat;
import androidx.work.WorkRequest;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h implements j, i, Cloneable, ByteChannel {

    /* renamed from: a, reason: collision with root package name */
    public b0 f10960a;

    /* renamed from: b, reason: collision with root package name */
    public long f10961b;

    public final void A(int i) {
        b0 u7 = u(1);
        byte[] bArr = u7.f10939a;
        int i6 = u7.f10941c;
        u7.f10941c = i6 + 1;
        bArr[i6] = (byte) i;
        this.f10961b++;
    }

    public final void B(long j) {
        boolean z9;
        if (j == 0) {
            A(48);
            return;
        }
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                G("-9223372036854775808");
                return;
            }
            z9 = true;
        } else {
            z9 = false;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= WorkRequest.MIN_BACKOFF_MILLIS) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z9) {
            i++;
        }
        b0 u7 = u(i);
        byte[] bArr = u7.f10939a;
        int i6 = u7.f10941c + i;
        while (j != 0) {
            long j6 = 10;
            i6--;
            bArr[i6] = x8.a.f11545a[(int) (j % j6)];
            j /= j6;
        }
        if (z9) {
            bArr[i6 - 1] = 45;
        }
        u7.f10941c += i;
        this.f10961b += i;
    }

    public final void C(long j) {
        if (j == 0) {
            A(48);
            return;
        }
        long j6 = (j >>> 1) | j;
        long j10 = j6 | (j6 >>> 2);
        long j11 = j10 | (j10 >>> 4);
        long j12 = j11 | (j11 >>> 8);
        long j13 = j12 | (j12 >>> 16);
        long j14 = j13 | (j13 >>> 32);
        long j15 = j14 - ((j14 >>> 1) & 6148914691236517205L);
        long j16 = ((j15 >>> 2) & 3689348814741910323L) + (j15 & 3689348814741910323L);
        long j17 = ((j16 >>> 4) + j16) & 1085102592571150095L;
        long j18 = j17 + (j17 >>> 8);
        long j19 = j18 + (j18 >>> 16);
        int i = (int) ((((j19 & 63) + ((j19 >>> 32) & 63)) + 3) / 4);
        b0 u7 = u(i);
        byte[] bArr = u7.f10939a;
        int i6 = u7.f10941c;
        for (int i10 = (i6 + i) - 1; i10 >= i6; i10--) {
            bArr[i10] = x8.a.f11545a[(int) (15 & j)];
            j >>>= 4;
        }
        u7.f10941c += i;
        this.f10961b += i;
    }

    public final void D(int i) {
        b0 u7 = u(4);
        byte[] bArr = u7.f10939a;
        int i6 = u7.f10941c;
        bArr[i6] = (byte) ((i >>> 24) & 255);
        bArr[i6 + 1] = (byte) ((i >>> 16) & 255);
        bArr[i6 + 2] = (byte) ((i >>> 8) & 255);
        bArr[i6 + 3] = (byte) (i & 255);
        u7.f10941c = i6 + 4;
        this.f10961b += 4;
    }

    public final void E(int i) {
        b0 u7 = u(2);
        byte[] bArr = u7.f10939a;
        int i6 = u7.f10941c;
        bArr[i6] = (byte) ((i >>> 8) & 255);
        bArr[i6 + 1] = (byte) (i & 255);
        u7.f10941c = i6 + 2;
        this.f10961b += 2;
    }

    public final void F(int i, int i6, String str) {
        char charAt;
        str.getClass();
        if (i < 0) {
            s1.o.o(androidx.lifecycle.l.u(i, "beginIndex < 0: "));
            return;
        }
        if (i6 < i) {
            s1.o.e(i6, i, " < ", "endIndex < beginIndex: ");
            return;
        }
        if (i6 > str.length()) {
            StringBuilder p10 = a4.x.p(i6, "endIndex > string.length: ", " > ");
            p10.append(str.length());
            throw new IllegalArgumentException(p10.toString().toString());
        }
        while (i < i6) {
            char charAt2 = str.charAt(i);
            if (charAt2 < 128) {
                b0 u7 = u(1);
                byte[] bArr = u7.f10939a;
                int i10 = u7.f10941c - i;
                int min = Math.min(i6, 8192 - i10);
                int i11 = i + 1;
                bArr[i + i10] = (byte) charAt2;
                while (true) {
                    i = i11;
                    if (i >= min || (charAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i11 = i + 1;
                    bArr[i + i10] = (byte) charAt;
                }
                int i12 = u7.f10941c;
                int i13 = (i10 + i) - i12;
                u7.f10941c = i12 + i13;
                this.f10961b += i13;
            } else {
                if (charAt2 < 2048) {
                    b0 u9 = u(2);
                    byte[] bArr2 = u9.f10939a;
                    int i14 = u9.f10941c;
                    bArr2[i14] = (byte) ((charAt2 >> 6) | 192);
                    bArr2[i14 + 1] = (byte) ((charAt2 & '?') | 128);
                    u9.f10941c = i14 + 2;
                    this.f10961b += 2;
                } else if (charAt2 < 55296 || charAt2 > 57343) {
                    b0 u10 = u(3);
                    byte[] bArr3 = u10.f10939a;
                    int i15 = u10.f10941c;
                    bArr3[i15] = (byte) ((charAt2 >> '\f') | 224);
                    bArr3[i15 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                    bArr3[i15 + 2] = (byte) ((charAt2 & '?') | 128);
                    u10.f10941c = i15 + 3;
                    this.f10961b += 3;
                } else {
                    int i16 = i + 1;
                    char charAt3 = i16 < i6 ? str.charAt(i16) : (char) 0;
                    if (charAt2 > 56319 || 56320 > charAt3 || charAt3 >= 57344) {
                        A(63);
                        i = i16;
                    } else {
                        int i17 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                        b0 u11 = u(4);
                        byte[] bArr4 = u11.f10939a;
                        int i18 = u11.f10941c;
                        bArr4[i18] = (byte) ((i17 >> 18) | 240);
                        bArr4[i18 + 1] = (byte) (((i17 >> 12) & 63) | 128);
                        bArr4[i18 + 2] = (byte) (((i17 >> 6) & 63) | 128);
                        bArr4[i18 + 3] = (byte) ((i17 & 63) | 128);
                        u11.f10941c = i18 + 4;
                        this.f10961b += 4;
                        i += 2;
                    }
                }
                i++;
            }
        }
    }

    public final void G(String str) {
        str.getClass();
        F(0, str.length(), str);
    }

    public final void H(int i) {
        String str;
        if (i < 128) {
            A(i);
            return;
        }
        if (i < 2048) {
            b0 u7 = u(2);
            byte[] bArr = u7.f10939a;
            int i6 = u7.f10941c;
            bArr[i6] = (byte) ((i >> 6) | 192);
            bArr[i6 + 1] = (byte) ((i & 63) | 128);
            u7.f10941c = i6 + 2;
            this.f10961b += 2;
            return;
        }
        if (55296 <= i && i < 57344) {
            A(63);
            return;
        }
        if (i < 65536) {
            b0 u9 = u(3);
            byte[] bArr2 = u9.f10939a;
            int i10 = u9.f10941c;
            bArr2[i10] = (byte) ((i >> 12) | 224);
            bArr2[i10 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i10 + 2] = (byte) ((i & 63) | 128);
            u9.f10941c = i10 + 3;
            this.f10961b += 3;
            return;
        }
        if (i <= 1114111) {
            b0 u10 = u(4);
            byte[] bArr3 = u10.f10939a;
            int i11 = u10.f10941c;
            bArr3[i11] = (byte) ((i >> 18) | 240);
            bArr3[i11 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i11 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i11 + 3] = (byte) ((i & 63) | 128);
            u10.f10941c = i11 + 4;
            this.f10961b += 4;
            return;
        }
        StringBuilder sb = new StringBuilder("Unexpected code point: 0x");
        if (i != 0) {
            char[] cArr = x8.b.f11546a;
            char[] cArr2 = {cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15], cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15]};
            int i12 = 0;
            while (i12 < 8 && cArr2[i12] == '0') {
                i12++;
            }
            q6.e.Companion.getClass();
            q6.b.a(i12, 8, 8);
            str = new String(cArr2, i12, 8 - i12);
        } else {
            str = "0";
        }
        sb.append(str);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // w8.g0
    public final i0 a() {
        return i0.f10962d;
    }

    public final void b(h hVar, long j, long j6) {
        hVar.getClass();
        long j10 = j;
        a.a.o(this.f10961b, j10, j6);
        if (j6 == 0) {
            return;
        }
        hVar.f10961b += j6;
        b0 b0Var = this.f10960a;
        while (true) {
            b0Var.getClass();
            long j11 = b0Var.f10941c - b0Var.f10940b;
            if (j10 < j11) {
                break;
            }
            j10 -= j11;
            b0Var = b0Var.f;
        }
        b0 b0Var2 = b0Var;
        long j12 = j6;
        while (j12 > 0) {
            b0Var2.getClass();
            b0 c9 = b0Var2.c();
            int i = c9.f10940b + ((int) j10);
            c9.f10940b = i;
            c9.f10941c = Math.min(i + ((int) j12), c9.f10941c);
            b0 b0Var3 = hVar.f10960a;
            if (b0Var3 == null) {
                c9.g = c9;
                c9.f = c9;
                hVar.f10960a = c9;
            } else {
                b0 b0Var4 = b0Var3.g;
                b0Var4.getClass();
                b0Var4.b(c9);
            }
            j12 -= c9.f10941c - c9.f10940b;
            b0Var2 = b0Var2.f;
            j10 = 0;
        }
    }

    public final boolean c() {
        return this.f10961b == 0;
    }

    public final Object clone() {
        h hVar = new h();
        if (this.f10961b == 0) {
            return hVar;
        }
        b0 b0Var = this.f10960a;
        b0Var.getClass();
        b0 c9 = b0Var.c();
        hVar.f10960a = c9;
        c9.g = c9;
        c9.f = c9;
        for (b0 b0Var2 = b0Var.f; b0Var2 != b0Var; b0Var2 = b0Var2.f) {
            b0 b0Var3 = c9.g;
            b0Var3.getClass();
            b0Var2.getClass();
            b0Var3.b(b0Var2.c());
        }
        hVar.f10961b = this.f10961b;
        return hVar;
    }

    public final byte d(long j) {
        a.a.o(this.f10961b, j, 1L);
        b0 b0Var = this.f10960a;
        b0Var.getClass();
        long j6 = this.f10961b;
        if (j6 - j < j) {
            while (j6 > j) {
                b0Var = b0Var.g;
                b0Var.getClass();
                j6 -= b0Var.f10941c - b0Var.f10940b;
            }
            return b0Var.f10939a[(int) ((b0Var.f10940b + j) - j6)];
        }
        long j10 = 0;
        while (true) {
            int i = b0Var.f10941c;
            int i6 = b0Var.f10940b;
            long j11 = (i - i6) + j10;
            if (j11 > j) {
                return b0Var.f10939a[(int) ((i6 + j) - j10)];
            }
            b0Var = b0Var.f;
            b0Var.getClass();
            j10 = j11;
        }
    }

    public final long e(byte b7, long j, long j6) {
        b0 b0Var;
        long j10 = 0;
        if (0 > j || j > j6) {
            throw new IllegalArgumentException(("size=" + this.f10961b + " fromIndex=" + j + " toIndex=" + j6).toString());
        }
        long j11 = this.f10961b;
        if (j6 > j11) {
            j6 = j11;
        }
        if (j == j6 || (b0Var = this.f10960a) == null) {
            return -1L;
        }
        if (j11 - j < j) {
            while (j11 > j) {
                b0Var = b0Var.g;
                b0Var.getClass();
                j11 -= b0Var.f10941c - b0Var.f10940b;
            }
            while (j11 < j6) {
                byte[] bArr = b0Var.f10939a;
                int min = (int) Math.min(b0Var.f10941c, (b0Var.f10940b + j6) - j11);
                for (int i = (int) ((b0Var.f10940b + j) - j11); i < min; i++) {
                    if (bArr[i] == b7) {
                        return (i - b0Var.f10940b) + j11;
                    }
                }
                j11 += b0Var.f10941c - b0Var.f10940b;
                b0Var = b0Var.f;
                b0Var.getClass();
                j = j11;
            }
            return -1L;
        }
        while (true) {
            long j12 = (b0Var.f10941c - b0Var.f10940b) + j10;
            if (j12 > j) {
                break;
            }
            b0Var = b0Var.f;
            b0Var.getClass();
            j10 = j12;
        }
        while (j10 < j6) {
            byte[] bArr2 = b0Var.f10939a;
            int min2 = (int) Math.min(b0Var.f10941c, (b0Var.f10940b + j6) - j10);
            for (int i6 = (int) ((b0Var.f10940b + j) - j10); i6 < min2; i6++) {
                if (bArr2[i6] == b7) {
                    return (i6 - b0Var.f10940b) + j10;
                }
            }
            j10 += b0Var.f10941c - b0Var.f10940b;
            b0Var = b0Var.f;
            b0Var.getClass();
            j = j10;
        }
        return -1L;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        long j = this.f10961b;
        h hVar = (h) obj;
        if (j != hVar.f10961b) {
            return false;
        }
        if (j == 0) {
            return true;
        }
        b0 b0Var = this.f10960a;
        b0Var.getClass();
        b0 b0Var2 = hVar.f10960a;
        b0Var2.getClass();
        int i = b0Var.f10940b;
        int i6 = b0Var2.f10940b;
        long j6 = 0;
        while (j6 < this.f10961b) {
            long min = Math.min(b0Var.f10941c - i, b0Var2.f10941c - i6);
            long j10 = 0;
            while (j10 < min) {
                int i10 = i + 1;
                int i11 = i6 + 1;
                if (b0Var.f10939a[i] != b0Var2.f10939a[i6]) {
                    return false;
                }
                j10++;
                i = i10;
                i6 = i11;
            }
            if (i == b0Var.f10941c) {
                b0Var = b0Var.f;
                b0Var.getClass();
                i = b0Var.f10940b;
            }
            if (i6 == b0Var2.f10941c) {
                b0Var2 = b0Var2.f;
                b0Var2.getClass();
                i6 = b0Var2.f10940b;
            }
            j6 += min;
        }
        return true;
    }

    public final long f(k kVar) {
        int i;
        int i6;
        kVar.getClass();
        b0 b0Var = this.f10960a;
        if (b0Var == null) {
            return -1L;
        }
        long j = this.f10961b;
        long j6 = 0;
        if (j < 0) {
            while (j > 0) {
                b0Var = b0Var.g;
                b0Var.getClass();
                j -= b0Var.f10941c - b0Var.f10940b;
            }
            if (kVar.f() == 2) {
                byte k5 = kVar.k(0);
                byte k10 = kVar.k(1);
                while (j < this.f10961b) {
                    byte[] bArr = b0Var.f10939a;
                    i = (int) ((b0Var.f10940b + j6) - j);
                    int i10 = b0Var.f10941c;
                    while (i < i10) {
                        byte b7 = bArr[i];
                        if (b7 != k5 && b7 != k10) {
                            i++;
                        }
                        i6 = b0Var.f10940b;
                    }
                    j6 = (b0Var.f10941c - b0Var.f10940b) + j;
                    b0Var = b0Var.f;
                    b0Var.getClass();
                    j = j6;
                }
                return -1L;
            }
            byte[] j10 = kVar.j();
            while (j < this.f10961b) {
                byte[] bArr2 = b0Var.f10939a;
                i = (int) ((b0Var.f10940b + j6) - j);
                int i11 = b0Var.f10941c;
                while (i < i11) {
                    byte b10 = bArr2[i];
                    for (byte b11 : j10) {
                        if (b10 == b11) {
                            i6 = b0Var.f10940b;
                        }
                    }
                    i++;
                }
                j6 = (b0Var.f10941c - b0Var.f10940b) + j;
                b0Var = b0Var.f;
                b0Var.getClass();
                j = j6;
            }
            return -1L;
        }
        j = 0;
        while (true) {
            long j11 = (b0Var.f10941c - b0Var.f10940b) + j;
            if (j11 > 0) {
                break;
            }
            b0Var = b0Var.f;
            b0Var.getClass();
            j = j11;
        }
        if (kVar.f() == 2) {
            byte k11 = kVar.k(0);
            byte k12 = kVar.k(1);
            while (j < this.f10961b) {
                byte[] bArr3 = b0Var.f10939a;
                i = (int) ((b0Var.f10940b + j6) - j);
                int i12 = b0Var.f10941c;
                while (i < i12) {
                    byte b12 = bArr3[i];
                    if (b12 != k11 && b12 != k12) {
                        i++;
                    }
                    i6 = b0Var.f10940b;
                }
                j6 = (b0Var.f10941c - b0Var.f10940b) + j;
                b0Var = b0Var.f;
                b0Var.getClass();
                j = j6;
            }
            return -1L;
        }
        byte[] j12 = kVar.j();
        while (j < this.f10961b) {
            byte[] bArr4 = b0Var.f10939a;
            i = (int) ((b0Var.f10940b + j6) - j);
            int i13 = b0Var.f10941c;
            while (i < i13) {
                byte b13 = bArr4[i];
                for (byte b14 : j12) {
                    if (b13 == b14) {
                        i6 = b0Var.f10940b;
                    }
                }
                i++;
            }
            j6 = (b0Var.f10941c - b0Var.f10940b) + j;
            b0Var = b0Var.f;
            b0Var.getClass();
            j = j6;
        }
        return -1L;
        return (i - i6) + j;
    }

    @Override // w8.j
    public final k g(long j) {
        if (j < 0 || j > 2147483647L) {
            s1.o.o(a4.x.h(j, "byteCount: "));
            return null;
        }
        if (this.f10961b < j) {
            s1.o.d();
            return null;
        }
        if (j < 4096) {
            return new k(i(j));
        }
        k s6 = s((int) j);
        skip(j);
        return s6;
    }

    public final boolean h(long j, k kVar) {
        kVar.getClass();
        int f = kVar.f();
        if (j >= 0 && f >= 0 && this.f10961b - j >= f && kVar.f() >= f) {
            for (int i = 0; i < f; i++) {
                if (d(i + j) == kVar.k(i)) {
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        b0 b0Var = this.f10960a;
        if (b0Var == null) {
            return 0;
        }
        int i = 1;
        do {
            int i6 = b0Var.f10941c;
            for (int i10 = b0Var.f10940b; i10 < i6; i10++) {
                i = (i * 31) + b0Var.f10939a[i10];
            }
            b0Var = b0Var.f;
            b0Var.getClass();
        } while (b0Var != this.f10960a);
        return i;
    }

    public final byte[] i(long j) {
        if (j < 0 || j > 2147483647L) {
            s1.o.o(a4.x.h(j, "byteCount: "));
            return null;
        }
        if (this.f10961b < j) {
            s1.o.d();
            return null;
        }
        int i = (int) j;
        byte[] bArr = new byte[i];
        int i6 = 0;
        while (i6 < i) {
            int read = read(bArr, i6, i - i6);
            if (read == -1) {
                s1.o.d();
                return null;
            }
            i6 += read;
        }
        return bArr;
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a0, code lost:
    
        r3 = r20.f10961b - r2;
        r20.f10961b = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a7, code lost:
    
        if (r9 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a9, code lost:
    
        r5 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ad, code lost:
    
        if (r2 >= r5) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b1, code lost:
    
        if (r3 == r18) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b3, code lost:
    
        if (r9 == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b5, code lost:
    
        r2 = "Expected a digit";
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ba, code lost:
    
        r2 = a4.x.u(r2, " but was 0x");
        r4 = d(r18);
        r6 = x8.b.f11546a;
        r5 = r6[(r4 >> 4) & 15];
        r4 = r6[r4 & 15];
        r1 = new char[2];
        r1[r16] = r5;
        r1[r17] = r4;
        r2.append(new java.lang.String(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e9, code lost:
    
        throw new java.lang.NumberFormatException(r2.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b8, code lost:
    
        r2 = "Expected a digit or '-'";
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ea, code lost:
    
        s1.o.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ef, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00f0, code lost:
    
        if (r9 == false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f2, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f4, code lost:
    
        return -r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ab, code lost:
    
        r5 = r17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long j() {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.h.j():long");
    }

    @Override // w8.j
    public final String k(long j) {
        if (j < 0) {
            s1.o.o(a4.x.h(j, "limit < 0: "));
            return null;
        }
        long j6 = LocationRequestCompat.PASSIVE_INTERVAL;
        if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
            j6 = j + 1;
        }
        long j10 = j6;
        long e10 = e((byte) 10, 0L, j10);
        if (e10 != -1) {
            return x8.a.a(this, e10);
        }
        if (j10 < this.f10961b && d(j10 - 1) == 13 && d(j10) == 10) {
            return x8.a.a(this, j10);
        }
        h hVar = new h();
        b(hVar, 0L, Math.min(32, this.f10961b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f10961b, j) + " content=" + hVar.g(hVar.f10961b).g() + (char) 8230);
    }

    @Override // w8.e0
    public final void l(h hVar, long j) {
        b0 b7;
        hVar.getClass();
        if (hVar == this) {
            com.google.gson.internal.a.p("source == this");
            return;
        }
        a.a.o(hVar.f10961b, 0L, j);
        while (j > 0) {
            b0 b0Var = hVar.f10960a;
            b0Var.getClass();
            int i = b0Var.f10941c;
            b0 b0Var2 = hVar.f10960a;
            b0Var2.getClass();
            long j6 = i - b0Var2.f10940b;
            int i6 = 0;
            if (j < j6) {
                b0 b0Var3 = this.f10960a;
                b0 b0Var4 = b0Var3 != null ? b0Var3.g : null;
                if (b0Var4 != null && b0Var4.f10943e) {
                    if ((b0Var4.f10941c + j) - (b0Var4.f10942d ? 0 : b0Var4.f10940b) <= 8192) {
                        b0 b0Var5 = hVar.f10960a;
                        b0Var5.getClass();
                        b0Var5.d(b0Var4, (int) j);
                        hVar.f10961b -= j;
                        this.f10961b += j;
                        return;
                    }
                }
                b0 b0Var6 = hVar.f10960a;
                b0Var6.getClass();
                int i10 = (int) j;
                if (i10 <= 0 || i10 > b0Var6.f10941c - b0Var6.f10940b) {
                    com.google.gson.internal.a.p("byteCount out of range");
                    return;
                }
                if (i10 >= 1024) {
                    b7 = b0Var6.c();
                } else {
                    b7 = c0.b();
                    byte[] bArr = b0Var6.f10939a;
                    byte[] bArr2 = b7.f10939a;
                    int i11 = b0Var6.f10940b;
                    q6.j.Y(bArr, 0, bArr2, i11, i11 + i10);
                }
                b7.f10941c = b7.f10940b + i10;
                b0Var6.f10940b += i10;
                b0 b0Var7 = b0Var6.g;
                b0Var7.getClass();
                b0Var7.b(b7);
                hVar.f10960a = b7;
            }
            b0 b0Var8 = hVar.f10960a;
            b0Var8.getClass();
            long j10 = b0Var8.f10941c - b0Var8.f10940b;
            hVar.f10960a = b0Var8.a();
            b0 b0Var9 = this.f10960a;
            if (b0Var9 == null) {
                this.f10960a = b0Var8;
                b0Var8.g = b0Var8;
                b0Var8.f = b0Var8;
            } else {
                b0 b0Var10 = b0Var9.g;
                b0Var10.getClass();
                b0Var10.b(b0Var8);
                b0 b0Var11 = b0Var8.g;
                if (b0Var11 == b0Var8) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("cannot compact");
                    return;
                }
                b0Var11.getClass();
                if (b0Var11.f10943e) {
                    int i12 = b0Var8.f10941c - b0Var8.f10940b;
                    b0 b0Var12 = b0Var8.g;
                    b0Var12.getClass();
                    int i13 = 8192 - b0Var12.f10941c;
                    b0 b0Var13 = b0Var8.g;
                    b0Var13.getClass();
                    if (!b0Var13.f10942d) {
                        b0 b0Var14 = b0Var8.g;
                        b0Var14.getClass();
                        i6 = b0Var14.f10940b;
                    }
                    if (i12 <= i13 + i6) {
                        b0 b0Var15 = b0Var8.g;
                        b0Var15.getClass();
                        b0Var8.d(b0Var15, i12);
                        b0Var8.a();
                        c0.a(b0Var8);
                    }
                }
            }
            hVar.f10961b -= j10;
            this.f10961b += j10;
            j -= j10;
        }
    }

    @Override // w8.i
    public final /* bridge */ /* synthetic */ i m(String str) {
        G(str);
        return this;
    }

    public final short n() {
        short readShort = readShort();
        return (short) (((readShort & 255) << 8) | ((65280 & readShort) >>> 8));
    }

    @Override // w8.i
    public final /* bridge */ /* synthetic */ i o(long j) {
        C(j);
        return this;
    }

    @Override // w8.g0
    public final long p(h hVar, long j) {
        hVar.getClass();
        if (j < 0) {
            s1.o.o(a4.x.h(j, "byteCount < 0: "));
            return 0L;
        }
        long j6 = this.f10961b;
        if (j6 == 0) {
            return -1L;
        }
        if (j > j6) {
            j = j6;
        }
        hVar.l(this, j);
        return j;
    }

    @Override // w8.j
    public final String q() {
        return k(LocationRequestCompat.PASSIVE_INTERVAL);
    }

    public final String r(long j, Charset charset) {
        charset.getClass();
        if (j < 0 || j > 2147483647L) {
            s1.o.o(a4.x.h(j, "byteCount: "));
            return null;
        }
        if (this.f10961b < j) {
            s1.o.d();
            return null;
        }
        if (j == 0) {
            return "";
        }
        b0 b0Var = this.f10960a;
        b0Var.getClass();
        int i = b0Var.f10940b;
        if (i + j > b0Var.f10941c) {
            return new String(i(j), charset);
        }
        int i6 = (int) j;
        String str = new String(b0Var.f10939a, i, i6, charset);
        int i10 = b0Var.f10940b + i6;
        b0Var.f10940b = i10;
        this.f10961b -= j;
        if (i10 == b0Var.f10941c) {
            this.f10960a = b0Var.a();
            c0.a(b0Var);
        }
        return str;
    }

    public final int read(byte[] bArr, int i, int i6) {
        a.a.o(bArr.length, i, i6);
        b0 b0Var = this.f10960a;
        if (b0Var == null) {
            return -1;
        }
        int min = Math.min(i6, b0Var.f10941c - b0Var.f10940b);
        byte[] bArr2 = b0Var.f10939a;
        int i10 = b0Var.f10940b;
        q6.j.Y(bArr2, i, bArr, i10, i10 + min);
        int i11 = b0Var.f10940b + min;
        b0Var.f10940b = i11;
        this.f10961b -= min;
        if (i11 == b0Var.f10941c) {
            this.f10960a = b0Var.a();
            c0.a(b0Var);
        }
        return min;
    }

    @Override // w8.j
    public final byte readByte() {
        if (this.f10961b == 0) {
            s1.o.d();
            return (byte) 0;
        }
        b0 b0Var = this.f10960a;
        b0Var.getClass();
        int i = b0Var.f10940b;
        int i6 = b0Var.f10941c;
        int i10 = i + 1;
        byte b7 = b0Var.f10939a[i];
        this.f10961b--;
        if (i10 != i6) {
            b0Var.f10940b = i10;
            return b7;
        }
        this.f10960a = b0Var.a();
        c0.a(b0Var);
        return b7;
    }

    @Override // w8.j
    public final int readInt() {
        if (this.f10961b < 4) {
            s1.o.d();
            return 0;
        }
        b0 b0Var = this.f10960a;
        b0Var.getClass();
        int i = b0Var.f10940b;
        int i6 = b0Var.f10941c;
        if (i6 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = b0Var.f10939a;
        int i10 = i + 3;
        int i11 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
        int i12 = i + 4;
        int i13 = (bArr[i10] & 255) | i11;
        this.f10961b -= 4;
        if (i12 != i6) {
            b0Var.f10940b = i12;
            return i13;
        }
        this.f10960a = b0Var.a();
        c0.a(b0Var);
        return i13;
    }

    @Override // w8.j
    public final short readShort() {
        if (this.f10961b < 2) {
            s1.o.d();
            return (short) 0;
        }
        b0 b0Var = this.f10960a;
        b0Var.getClass();
        int i = b0Var.f10940b;
        int i6 = b0Var.f10941c;
        if (i6 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = b0Var.f10939a;
        int i10 = i + 1;
        int i11 = (bArr[i] & 255) << 8;
        int i12 = i + 2;
        int i13 = (bArr[i10] & 255) | i11;
        this.f10961b -= 2;
        if (i12 == i6) {
            this.f10960a = b0Var.a();
            c0.a(b0Var);
        } else {
            b0Var.f10940b = i12;
        }
        return (short) i13;
    }

    public final k s(int i) {
        if (i == 0) {
            return k.f10970m;
        }
        a.a.o(this.f10961b, 0L, i);
        b0 b0Var = this.f10960a;
        int i6 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i) {
            b0Var.getClass();
            int i12 = b0Var.f10941c;
            int i13 = b0Var.f10940b;
            if (i12 == i13) {
                s1.o.j("s.limit == s.pos");
                return null;
            }
            i10 += i12 - i13;
            i11++;
            b0Var = b0Var.f;
        }
        byte[][] bArr = new byte[i11][];
        int[] iArr = new int[i11 * 2];
        b0 b0Var2 = this.f10960a;
        int i14 = 0;
        while (i6 < i) {
            b0Var2.getClass();
            bArr[i14] = b0Var2.f10939a;
            i6 += b0Var2.f10941c - b0Var2.f10940b;
            iArr[i14] = Math.min(i6, i);
            iArr[i14 + i11] = b0Var2.f10940b;
            b0Var2.f10942d = true;
            i14++;
            b0Var2 = b0Var2.f;
        }
        return new d0(bArr, iArr);
    }

    @Override // w8.j
    public final void skip(long j) {
        while (j > 0) {
            b0 b0Var = this.f10960a;
            if (b0Var == null) {
                s1.o.d();
                return;
            }
            int min = (int) Math.min(j, b0Var.f10941c - b0Var.f10940b);
            long j6 = min;
            this.f10961b -= j6;
            j -= j6;
            int i = b0Var.f10940b + min;
            b0Var.f10940b = i;
            if (i == b0Var.f10941c) {
                this.f10960a = b0Var.a();
                c0.a(b0Var);
            }
        }
    }

    @Override // w8.j
    public final void t(long j) {
        if (this.f10961b >= j) {
            return;
        }
        s1.o.d();
    }

    public final String toString() {
        long j = this.f10961b;
        if (j <= 2147483647L) {
            return s((int) j).toString();
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + this.f10961b).toString());
    }

    public final b0 u(int i) {
        if (i < 1 || i > 8192) {
            com.google.gson.internal.a.p("unexpected capacity");
            return null;
        }
        b0 b0Var = this.f10960a;
        if (b0Var == null) {
            b0 b7 = c0.b();
            this.f10960a = b7;
            b7.g = b7;
            b7.f = b7;
            return b7;
        }
        b0 b0Var2 = b0Var.g;
        b0Var2.getClass();
        if (b0Var2.f10941c + i <= 8192 && b0Var2.f10943e) {
            return b0Var2;
        }
        b0 b10 = c0.b();
        b0Var2.b(b10);
        return b10;
    }

    @Override // w8.i
    public final OutputStream v() {
        return new g(this, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6 A[EDGE_INSN: B:40:0x00a6->B:37:0x00a6 BREAK  A[LOOP:0: B:4:0x000c->B:39:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009e  */
    @Override // w8.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long w() {
        /*
            r15 = this;
            long r0 = r15.f10961b
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Lad
            r0 = 0
            r1 = r0
            r6 = r1
            r4 = r2
        Lc:
            w8.b0 r7 = r15.f10960a
            r7.getClass()
            byte[] r8 = r7.f10939a
            int r9 = r7.f10940b
            int r10 = r7.f10941c
        L17:
            if (r9 >= r10) goto L92
            r11 = r8[r9]
            r12 = 48
            if (r11 < r12) goto L26
            r12 = 57
            if (r11 > r12) goto L26
            int r12 = r11 + (-48)
            goto L3b
        L26:
            r12 = 97
            if (r11 < r12) goto L31
            r12 = 102(0x66, float:1.43E-43)
            if (r11 > r12) goto L31
            int r12 = r11 + (-87)
            goto L3b
        L31:
            r12 = 65
            if (r11 < r12) goto L6a
            r12 = 70
            if (r11 > r12) goto L6a
            int r12 = r11 + (-55)
        L3b:
            r13 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r13 = r13 & r4
            int r13 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r13 != 0) goto L4b
            r11 = 4
            long r4 = r4 << r11
            long r11 = (long) r12
            long r4 = r4 | r11
            int r9 = r9 + 1
            int r1 = r1 + 1
            goto L17
        L4b:
            w8.h r0 = new w8.h
            r0.<init>()
            r0.C(r4)
            r0.A(r11)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            long r2 = r0.f10961b
            java.nio.charset.Charset r4 = l7.a.f7151a
            java.lang.String r0 = r0.r(r2, r4)
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L6a:
            r6 = 1
            if (r1 == 0) goto L6e
            goto L92
        L6e:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            int r2 = r11 >> 4
            r2 = r2 & 15
            char[] r3 = x8.b.f11546a
            char r2 = r3[r2]
            r4 = r11 & 15
            char r3 = r3[r4]
            r4 = 2
            char[] r4 = new char[r4]
            r4[r0] = r2
            r4[r6] = r3
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        L92:
            if (r9 != r10) goto L9e
            w8.b0 r8 = r7.a()
            r15.f10960a = r8
            w8.c0.a(r7)
            goto La0
        L9e:
            r7.f10940b = r9
        La0:
            if (r6 != 0) goto La6
            w8.b0 r7 = r15.f10960a
            if (r7 != 0) goto Lc
        La6:
            long r2 = r15.f10961b
            long r0 = (long) r1
            long r2 = r2 - r0
            r15.f10961b = r2
            return r4
        Lad:
            s1.o.d()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.h.w():long");
    }

    public final void write(byte[] bArr, int i, int i6) {
        bArr.getClass();
        long j = i6;
        a.a.o(bArr.length, i, j);
        int i10 = i6 + i;
        while (i < i10) {
            b0 u7 = u(1);
            int min = Math.min(i10 - i, 8192 - u7.f10941c);
            int i11 = i + min;
            q6.j.Y(bArr, u7.f10941c, u7.f10939a, i, i11);
            u7.f10941c += min;
            i = i11;
        }
        this.f10961b += j;
    }

    @Override // w8.i
    public final /* bridge */ /* synthetic */ i writeByte(int i) {
        A(i);
        return this;
    }

    @Override // w8.i
    public final /* bridge */ /* synthetic */ i writeInt(int i) {
        D(i);
        return this;
    }

    @Override // w8.i
    public final /* bridge */ /* synthetic */ i writeShort(int i) {
        E(i);
        return this;
    }

    @Override // w8.j
    public final InputStream x() {
        return new f(this, 0);
    }

    public final void y(k kVar) {
        kVar.getClass();
        kVar.u(this, kVar.f());
    }

    public final void z(g0 g0Var) {
        g0Var.getClass();
        while (g0Var.p(this, 8192L) != -1) {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel, w8.e0
    public final void close() {
    }

    @Override // w8.i, w8.e0, java.io.Flushable
    public final void flush() {
    }

    @Override // w8.i
    public final i write(byte[] bArr) {
        write(bArr, 0, bArr.length);
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            b0 u7 = u(1);
            int min = Math.min(i, 8192 - u7.f10941c);
            byteBuffer.get(u7.f10939a, u7.f10941c, min);
            i -= min;
            u7.f10941c += min;
        }
        this.f10961b += remaining;
        return remaining;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        b0 b0Var = this.f10960a;
        if (b0Var == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), b0Var.f10941c - b0Var.f10940b);
        byteBuffer.put(b0Var.f10939a, b0Var.f10940b, min);
        int i = b0Var.f10940b + min;
        b0Var.f10940b = i;
        this.f10961b -= min;
        if (i == b0Var.f10941c) {
            this.f10960a = b0Var.a();
            c0.a(b0Var);
        }
        return min;
    }
}
