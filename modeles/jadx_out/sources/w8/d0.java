package w8;

import java.security.MessageDigest;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d0 extends k {

    /* renamed from: n, reason: collision with root package name */
    public final transient byte[][] f10953n;

    /* renamed from: o, reason: collision with root package name */
    public final transient int[] f10954o;

    public d0(byte[][] bArr, int[] iArr) {
        super(k.f10970m.f10971a);
        this.f10953n = bArr;
        this.f10954o = iArr;
    }

    @Override // w8.k
    public final String a() {
        throw null;
    }

    @Override // w8.k
    public final k e(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.f10953n;
        int length = bArr.length;
        int i = 0;
        int i6 = 0;
        while (i < length) {
            int[] iArr = this.f10954o;
            int i10 = iArr[length + i];
            int i11 = iArr[i];
            messageDigest.update(bArr[i], i10, i11 - i6);
            i++;
            i6 = i11;
        }
        byte[] digest = messageDigest.digest();
        digest.getClass();
        return new k(digest);
    }

    @Override // w8.k
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (kVar.f() == f() && o(0, kVar, f())) {
                return true;
            }
        }
        return false;
    }

    @Override // w8.k
    public final int f() {
        return this.f10954o[this.f10953n.length - 1];
    }

    @Override // w8.k
    public final String g() {
        return w().g();
    }

    @Override // w8.k
    public final int h(int i, byte[] bArr) {
        bArr.getClass();
        return w().h(i, bArr);
    }

    @Override // w8.k
    public final int hashCode() {
        int i = this.f10972b;
        if (i != 0) {
            return i;
        }
        byte[][] bArr = this.f10953n;
        int length = bArr.length;
        int i6 = 0;
        int i10 = 1;
        int i11 = 0;
        while (i6 < length) {
            int[] iArr = this.f10954o;
            int i12 = iArr[length + i6];
            int i13 = iArr[i6];
            byte[] bArr2 = bArr[i6];
            int i14 = (i13 - i11) + i12;
            while (i12 < i14) {
                i10 = (i10 * 31) + bArr2[i12];
                i12++;
            }
            i6++;
            i11 = i13;
        }
        this.f10972b = i10;
        return i10;
    }

    @Override // w8.k
    public final byte[] j() {
        return v();
    }

    @Override // w8.k
    public final byte k(int i) {
        byte[][] bArr = this.f10953n;
        int length = bArr.length - 1;
        int[] iArr = this.f10954o;
        a.a.o(iArr[length], i, 1L);
        int g = x8.b.g(this, i);
        return bArr[g][(i - (g == 0 ? 0 : iArr[g - 1])) + iArr[bArr.length + g]];
    }

    @Override // w8.k
    public final int l(byte[] bArr) {
        bArr.getClass();
        return w().l(bArr);
    }

    @Override // w8.k
    public final boolean o(int i, k kVar, int i6) {
        kVar.getClass();
        if (i >= 0 && i <= f() - i6) {
            int i10 = i6 + i;
            int g = x8.b.g(this, i);
            int i11 = 0;
            while (i < i10) {
                int[] iArr = this.f10954o;
                int i12 = g == 0 ? 0 : iArr[g - 1];
                int i13 = iArr[g] - i12;
                byte[][] bArr = this.f10953n;
                int i14 = iArr[bArr.length + g];
                int min = Math.min(i10, i13 + i12) - i;
                if (kVar.p(i11, bArr[g], (i - i12) + i14, min)) {
                    i11 += min;
                    i += min;
                    g++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // w8.k
    public final boolean p(int i, byte[] bArr, int i6, int i10) {
        bArr.getClass();
        if (i < 0 || i > f() - i10 || i6 < 0 || i6 > bArr.length - i10) {
            return false;
        }
        int i11 = i10 + i;
        int g = x8.b.g(this, i);
        while (i < i11) {
            int[] iArr = this.f10954o;
            int i12 = g == 0 ? 0 : iArr[g - 1];
            int i13 = iArr[g] - i12;
            byte[][] bArr2 = this.f10953n;
            int i14 = iArr[bArr2.length + g];
            int min = Math.min(i11, i13 + i12) - i;
            if (!a.a.k(bArr2[g], (i - i12) + i14, bArr, i6, min)) {
                return false;
            }
            i6 += min;
            i += min;
            g++;
        }
        return true;
    }

    @Override // w8.k
    public final k q(int i, int i6) {
        if (i6 == -1234567890) {
            i6 = f();
        }
        if (i < 0) {
            s1.o.o(a4.x.g(i, "beginIndex=", " < 0"));
            return null;
        }
        if (i6 > f()) {
            StringBuilder p10 = a4.x.p(i6, "endIndex=", " > length(");
            p10.append(f());
            p10.append(')');
            throw new IllegalArgumentException(p10.toString().toString());
        }
        int i10 = i6 - i;
        if (i10 < 0) {
            s1.o.e(i6, i, " < beginIndex=", "endIndex=");
            return null;
        }
        if (i == 0 && i6 == f()) {
            return this;
        }
        if (i == i6) {
            return k.f10970m;
        }
        int g = x8.b.g(this, i);
        int g3 = x8.b.g(this, i6 - 1);
        byte[][] bArr = this.f10953n;
        byte[][] bArr2 = (byte[][]) q6.j.d0(bArr, g, g3 + 1);
        int[] iArr = new int[bArr2.length * 2];
        int[] iArr2 = this.f10954o;
        if (g <= g3) {
            int i11 = g;
            int i12 = 0;
            while (true) {
                iArr[i12] = Math.min(iArr2[i11] - i, i10);
                int i13 = i12 + 1;
                iArr[i12 + bArr2.length] = iArr2[bArr.length + i11];
                if (i11 == g3) {
                    break;
                }
                i11++;
                i12 = i13;
            }
        }
        int i14 = g != 0 ? iArr2[g - 1] : 0;
        int length = bArr2.length;
        iArr[length] = (i - i14) + iArr[length];
        return new d0(bArr2, iArr);
    }

    @Override // w8.k
    public final k s() {
        return w().s();
    }

    @Override // w8.k
    public final String toString() {
        return w().toString();
    }

    @Override // w8.k
    public final void u(h hVar, int i) {
        int g = x8.b.g(this, 0);
        int i6 = 0;
        while (i6 < i) {
            int[] iArr = this.f10954o;
            int i10 = g == 0 ? 0 : iArr[g - 1];
            int i11 = iArr[g] - i10;
            byte[][] bArr = this.f10953n;
            int i12 = iArr[bArr.length + g];
            int min = Math.min(i, i11 + i10) - i6;
            int i13 = (i6 - i10) + i12;
            b0 b0Var = new b0(bArr[g], i13, i13 + min, true);
            b0 b0Var2 = hVar.f10960a;
            if (b0Var2 == null) {
                b0Var.g = b0Var;
                b0Var.f = b0Var;
                hVar.f10960a = b0Var;
            } else {
                b0 b0Var3 = b0Var2.g;
                b0Var3.getClass();
                b0Var3.b(b0Var);
            }
            i6 += min;
            g++;
        }
        hVar.f10961b += i;
    }

    public final byte[] v() {
        byte[] bArr = new byte[f()];
        byte[][] bArr2 = this.f10953n;
        int length = bArr2.length;
        int i = 0;
        int i6 = 0;
        int i10 = 0;
        while (i < length) {
            int[] iArr = this.f10954o;
            int i11 = iArr[length + i];
            int i12 = iArr[i];
            int i13 = i12 - i6;
            q6.j.Y(bArr2[i], i10, bArr, i11, i11 + i13);
            i10 += i13;
            i++;
            i6 = i12;
        }
        return bArr;
    }

    public final k w() {
        return new k(v());
    }
}
