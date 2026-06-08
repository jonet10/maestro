package com.google.android.gms.internal.measurement;

import androidx.work.WorkInfo;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b5 {

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f2511e = Logger.getLogger(b5.class.getName());
    public static final boolean f = w6.f2890e;

    /* renamed from: a, reason: collision with root package name */
    public z5 f2512a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2513b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2514c;

    /* renamed from: d, reason: collision with root package name */
    public int f2515d;

    public b5(byte[] bArr, int i) {
        int length = bArr.length;
        if (((length - i) | i) < 0) {
            Locale locale = Locale.US;
            c2.a.f(length, i, ", offset=0, length=", "Array range is invalid. Buffer.length=");
            throw null;
        }
        this.f2513b = bArr;
        this.f2515d = 0;
        this.f2514c = i;
    }

    public static int a(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static int b(String str) {
        int length;
        try {
            length = y6.b(str);
        } catch (x6 unused) {
            length = str.getBytes(r5.f2778a).length;
        }
        return s(length) + length;
    }

    public static int s(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public final void c(int i, int i6) {
        m((i << 3) | i6);
    }

    public final void d(int i, int i6) {
        m(i << 3);
        l(i6);
    }

    public final void e(int i, int i6) {
        m(i << 3);
        m(i6);
    }

    public final void f(int i, int i6) {
        m((i << 3) | 5);
        n(i6);
    }

    public final void g(int i, long j) {
        m(i << 3);
        o(j);
    }

    public final void h(int i, long j) {
        m((i << 3) | 1);
        p(j);
    }

    public final void i(int i, a5 a5Var) {
        m((i << 3) | 2);
        j(a5Var);
    }

    public final void j(a5 a5Var) {
        m(a5Var.d());
        q(a5Var.d(), a5Var.f2492b);
    }

    public final void k(byte b7) {
        int i = this.f2515d;
        try {
            int i6 = i + 1;
            try {
                this.f2513b[i] = b7;
                this.f2515d = i6;
            } catch (IndexOutOfBoundsException e10) {
                e = e10;
                i = i6;
                throw new a7.b(i, this.f2514c, 1, e);
            }
        } catch (IndexOutOfBoundsException e11) {
            e = e11;
        }
    }

    public final void l(int i) {
        if (i >= 0) {
            m(i);
        } else {
            o(i);
        }
    }

    public final void m(int i) {
        int i6;
        int i10 = this.f2515d;
        while (true) {
            int i11 = i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
            byte[] bArr = this.f2513b;
            if (i11 == 0) {
                i6 = i10 + 1;
                bArr[i10] = (byte) i;
                this.f2515d = i6;
                return;
            } else {
                i6 = i10 + 1;
                try {
                    bArr[i10] = (byte) (i | 128);
                    i >>>= 7;
                    i10 = i6;
                } catch (IndexOutOfBoundsException e10) {
                    throw new a7.b(i6, this.f2514c, 1, e10);
                }
            }
            throw new a7.b(i6, this.f2514c, 1, e10);
        }
    }

    public final void n(int i) {
        int i6 = this.f2515d;
        try {
            byte[] bArr = this.f2513b;
            bArr[i6] = (byte) i;
            bArr[i6 + 1] = (byte) (i >> 8);
            bArr[i6 + 2] = (byte) (i >> 16);
            bArr[i6 + 3] = (byte) (i >> 24);
            this.f2515d = i6 + 4;
        } catch (IndexOutOfBoundsException e10) {
            throw new a7.b(i6, this.f2514c, 4, e10);
        }
    }

    public final void o(long j) {
        int i;
        int i6 = this.f2515d;
        byte[] bArr = this.f2513b;
        int i10 = this.f2514c;
        if (!f || i10 - i6 < 10) {
            while ((j & (-128)) != 0) {
                int i11 = i6 + 1;
                try {
                    bArr[i6] = (byte) (((int) j) | 128);
                    j >>>= 7;
                    i6 = i11;
                } catch (IndexOutOfBoundsException e10) {
                    e = e10;
                    i = i11;
                    throw new a7.b(i, i10, 1, e);
                }
            }
            i = i6 + 1;
            try {
                bArr[i6] = (byte) j;
            } catch (IndexOutOfBoundsException e11) {
                e = e11;
                throw new a7.b(i, i10, 1, e);
            }
        } else {
            while ((j & (-128)) != 0) {
                w6.f2888c.a(bArr, w6.f + i6, (byte) (((int) j) | 128));
                j >>>= 7;
                i6++;
            }
            i = i6 + 1;
            w6.f2888c.a(bArr, w6.f + i6, (byte) j);
        }
        this.f2515d = i;
    }

    public final void p(long j) {
        int i = this.f2515d;
        try {
            byte[] bArr = this.f2513b;
            bArr[i] = (byte) j;
            bArr[i + 1] = (byte) (j >> 8);
            bArr[i + 2] = (byte) (j >> 16);
            bArr[i + 3] = (byte) (j >> 24);
            bArr[i + 4] = (byte) (j >> 32);
            bArr[i + 5] = (byte) (j >> 40);
            bArr[i + 6] = (byte) (j >> 48);
            bArr[i + 7] = (byte) (j >> 56);
            this.f2515d = i + 8;
        } catch (IndexOutOfBoundsException e10) {
            throw new a7.b(i, this.f2514c, 8, e10);
        }
    }

    public final void q(int i, byte[] bArr) {
        try {
            System.arraycopy(bArr, 0, this.f2513b, this.f2515d, i);
            this.f2515d += i;
        } catch (IndexOutOfBoundsException e10) {
            throw new a7.b(this.f2515d, this.f2514c, i, e10);
        }
    }

    public final void r(String str) {
        int i = this.f2515d;
        try {
            int s6 = s(str.length() * 3);
            int s9 = s(str.length());
            int i6 = this.f2514c;
            byte[] bArr = this.f2513b;
            if (s9 != s6) {
                m(y6.b(str));
                int i10 = this.f2515d;
                this.f2515d = y6.c(str, bArr, i10, i6 - i10);
            } else {
                int i11 = i + s9;
                this.f2515d = i11;
                int c9 = y6.c(str, bArr, i11, i6 - i11);
                this.f2515d = i;
                m((c9 - i) - s9);
                this.f2515d = c9;
            }
        } catch (x6 e10) {
            this.f2515d = i;
            f2511e.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e10);
            byte[] bytes = str.getBytes(r5.f2778a);
            try {
                int length = bytes.length;
                m(length);
                q(length, bytes);
            } catch (IndexOutOfBoundsException e11) {
                throw new a7.b(e11);
            }
        } catch (IndexOutOfBoundsException e12) {
            throw new a7.b(e12);
        }
    }
}
