package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class a5 implements Iterable, Serializable {

    /* renamed from: l, reason: collision with root package name */
    public static final a5 f2490l = new a5(r5.f2779b);

    /* renamed from: a, reason: collision with root package name */
    public int f2491a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2492b;

    static {
        int i = u4.f2819a;
    }

    public a5(byte[] bArr) {
        bArr.getClass();
        this.f2492b = bArr;
    }

    public static a5 e(int i, int i6, byte[] bArr) {
        g(i, i + i6, bArr.length);
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, i, bArr2, 0, i6);
        return new a5(bArr2);
    }

    public static int g(int i, int i6, int i10) {
        int i11 = i6 - i;
        if ((i | i6 | i11 | (i10 - i6)) >= 0) {
            return i11;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i6 < i) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 44 + String.valueOf(i6).length());
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i6);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(i6).length() + 15 + String.valueOf(i10).length());
        sb3.append("End index: ");
        sb3.append(i6);
        sb3.append(" >= ");
        sb3.append(i10);
        throw new IndexOutOfBoundsException(sb3.toString());
    }

    public byte b(int i) {
        return this.f2492b[i];
    }

    public byte c(int i) {
        return this.f2492b[i];
    }

    public int d() {
        return this.f2492b.length;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof a5) && d() == ((a5) obj).d()) {
            if (d() == 0) {
                return true;
            }
            if (!(obj instanceof a5)) {
                return obj.equals(this);
            }
            a5 a5Var = (a5) obj;
            int i = this.f2491a;
            int i6 = a5Var.f2491a;
            if (i == 0 || i6 == 0 || i == i6) {
                int d10 = d();
                if (d10 > a5Var.d()) {
                    int d11 = d();
                    StringBuilder sb = new StringBuilder(String.valueOf(d10).length() + 18 + String.valueOf(d11).length());
                    sb.append("Length too large: ");
                    sb.append(d10);
                    sb.append(d11);
                    throw new IllegalArgumentException(sb.toString());
                }
                if (d10 <= a5Var.d()) {
                    byte[] bArr = a5Var.f2492b;
                    int i10 = 0;
                    int i11 = 0;
                    while (i10 < d10) {
                        if (this.f2492b[i10] == bArr[i11]) {
                            i10++;
                            i11++;
                        }
                    }
                    return true;
                }
                int d12 = a5Var.d();
                StringBuilder sb2 = new StringBuilder(String.valueOf(d10).length() + 27 + String.valueOf(d12).length());
                sb2.append("Ran off end of other: 0, ");
                sb2.append(d10);
                sb2.append(", ");
                sb2.append(d12);
                throw new IllegalArgumentException(sb2.toString());
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f2491a;
        if (i != 0) {
            return i;
        }
        int d10 = d();
        int i6 = d10;
        for (int i10 = 0; i10 < d10; i10++) {
            i6 = (i6 * 31) + this.f2492b[i10];
        }
        if (i6 == 0) {
            i6 = 1;
        }
        this.f2491a = i6;
        return i6;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new y4(this);
    }

    public final String toString() {
        String concat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int d10 = d();
        if (d() <= 50) {
            concat = t0.f.N(this);
        } else {
            int g = g(0, 47, d());
            concat = t0.f.N(g == 0 ? f2490l : new z4(this.f2492b, g)).concat("...");
        }
        StringBuilder sb = new StringBuilder("<ByteString@");
        sb.append(hexString);
        sb.append(" size=");
        sb.append(d10);
        sb.append(" contents=\"");
        return a4.x.n(sb, concat, "\">");
    }
}
