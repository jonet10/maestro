package w8;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class k implements Serializable, Comparable {

    /* renamed from: m, reason: collision with root package name */
    public static final k f10970m = new k(new byte[0]);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f10971a;

    /* renamed from: b, reason: collision with root package name */
    public transient int f10972b;

    /* renamed from: l, reason: collision with root package name */
    public transient String f10973l;

    public k(byte[] bArr) {
        bArr.getClass();
        this.f10971a = bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x007a, code lost:
    
        r6 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final w8.k c(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.k.c(java.lang.String):w8.k");
    }

    public static final void d(String str) {
        if (str.length() % 2 != 0) {
            s1.o.o("Unexpected hex string: ".concat(str));
            return;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i6 = i * 2;
            bArr[i] = (byte) (x8.b.a(str.charAt(i6 + 1)) + (x8.b.a(str.charAt(i6)) << 4));
        }
        new k(bArr);
    }

    public static int i(k kVar, k kVar2) {
        kVar.getClass();
        kVar2.getClass();
        return kVar.h(0, kVar2.j());
    }

    public static int m(k kVar, k kVar2) {
        kVar.getClass();
        kVar2.getClass();
        return kVar.l(kVar2.j());
    }

    public static final k n(byte... bArr) {
        bArr.getClass();
        return new k(Arrays.copyOf(bArr, bArr.length));
    }

    public static /* synthetic */ k r(k kVar, int i, int i6, int i10) {
        if ((i10 & 1) != 0) {
            i = 0;
        }
        if ((i10 & 2) != 0) {
            i6 = -1234567890;
        }
        return kVar.q(i, i6);
    }

    public String a() {
        byte[] bArr = a.f10932a;
        byte[] bArr2 = this.f10971a;
        bArr2.getClass();
        bArr.getClass();
        byte[] bArr3 = new byte[((bArr2.length + 2) / 3) * 4];
        int length = bArr2.length - (bArr2.length % 3);
        int i = 0;
        int i6 = 0;
        while (i < length) {
            byte b7 = bArr2[i];
            int i10 = i + 2;
            byte b10 = bArr2[i + 1];
            i += 3;
            byte b11 = bArr2[i10];
            bArr3[i6] = bArr[(b7 & 255) >> 2];
            bArr3[i6 + 1] = bArr[((b7 & 3) << 4) | ((b10 & 255) >> 4)];
            int i11 = i6 + 3;
            bArr3[i6 + 2] = bArr[((b10 & 15) << 2) | ((b11 & 255) >> 6)];
            i6 += 4;
            bArr3[i11] = bArr[b11 & 63];
        }
        int length2 = bArr2.length - length;
        if (length2 == 1) {
            byte b12 = bArr2[i];
            bArr3[i6] = bArr[(b12 & 255) >> 2];
            bArr3[i6 + 1] = bArr[(b12 & 3) << 4];
            bArr3[i6 + 2] = 61;
            bArr3[i6 + 3] = 61;
        } else if (length2 == 2) {
            int i12 = i + 1;
            byte b13 = bArr2[i];
            byte b14 = bArr2[i12];
            bArr3[i6] = bArr[(b13 & 255) >> 2];
            bArr3[i6 + 1] = bArr[((b13 & 3) << 4) | ((b14 & 255) >> 4)];
            bArr3[i6 + 2] = bArr[(b14 & 15) << 2];
            bArr3[i6 + 3] = 61;
        }
        return new String(bArr3, l7.a.f7151a);
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compareTo(k kVar) {
        kVar.getClass();
        int f = f();
        int f10 = kVar.f();
        int min = Math.min(f, f10);
        for (int i = 0; i < min; i++) {
            int k5 = k(i) & 255;
            int k10 = kVar.k(i) & 255;
            if (k5 != k10) {
                return k5 < k10 ? -1 : 1;
            }
        }
        if (f == f10) {
            return 0;
        }
        return f < f10 ? -1 : 1;
    }

    public k e(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f10971a, 0, f());
        byte[] digest = messageDigest.digest();
        digest.getClass();
        return new k(digest);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            int f = kVar.f();
            byte[] bArr = this.f10971a;
            if (f == bArr.length && kVar.p(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int f() {
        return this.f10971a.length;
    }

    public String g() {
        byte[] bArr = this.f10971a;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b7 : bArr) {
            int i6 = i + 1;
            char[] cArr2 = x8.b.f11546a;
            cArr[i] = cArr2[(b7 >> 4) & 15];
            i += 2;
            cArr[i6] = cArr2[b7 & 15];
        }
        return new String(cArr);
    }

    public int h(int i, byte[] bArr) {
        bArr.getClass();
        byte[] bArr2 = this.f10971a;
        int length = bArr2.length - bArr.length;
        int max = Math.max(i, 0);
        if (max > length) {
            return -1;
        }
        while (!a.a.k(bArr2, max, bArr, 0, bArr.length)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    public int hashCode() {
        int i = this.f10972b;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.f10971a);
        this.f10972b = hashCode;
        return hashCode;
    }

    public byte[] j() {
        return this.f10971a;
    }

    public byte k(int i) {
        return this.f10971a[i];
    }

    public int l(byte[] bArr) {
        bArr.getClass();
        int f = f();
        byte[] bArr2 = this.f10971a;
        for (int min = Math.min(f, bArr2.length - bArr.length); -1 < min; min--) {
            if (a.a.k(bArr2, min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public boolean o(int i, k kVar, int i6) {
        kVar.getClass();
        return kVar.p(0, this.f10971a, i, i6);
    }

    public boolean p(int i, byte[] bArr, int i6, int i10) {
        bArr.getClass();
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.f10971a;
        return i <= bArr2.length - i10 && i6 >= 0 && i6 <= bArr.length - i10 && a.a.k(bArr2, i, bArr, i6, i10);
    }

    public k q(int i, int i6) {
        if (i6 == -1234567890) {
            i6 = f();
        }
        if (i < 0) {
            com.google.gson.internal.a.p("beginIndex < 0");
            return null;
        }
        byte[] bArr = this.f10971a;
        if (i6 > bArr.length) {
            s1.o.f(bArr.length, 41, "endIndex > length(");
            return null;
        }
        if (i6 - i < 0) {
            com.google.gson.internal.a.p("endIndex < beginIndex");
            return null;
        }
        if (i == 0 && i6 == bArr.length) {
            return this;
        }
        t0.f.m(i6, bArr.length);
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i, i6);
        copyOfRange.getClass();
        return new k(copyOfRange);
    }

    public k s() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f10971a;
            if (i >= bArr.length) {
                return this;
            }
            byte b7 = bArr[i];
            if (b7 >= 65 && b7 <= 90) {
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                copyOf[i] = (byte) (b7 + 32);
                for (int i6 = i + 1; i6 < copyOf.length; i6++) {
                    byte b10 = copyOf[i6];
                    if (b10 >= 65 && b10 <= 90) {
                        copyOf[i6] = (byte) (b10 + 32);
                    }
                }
                return new k(copyOf);
            }
            i++;
        }
    }

    public final String t() {
        String str = this.f10973l;
        if (str != null) {
            return str;
        }
        byte[] j = j();
        j.getClass();
        String str2 = new String(j, l7.a.f7151a);
        this.f10973l = str2;
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x00f6, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0130, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0134, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00d6, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0173, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x017a, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x016c, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x01aa, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x01ad, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x01b0, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0140, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x01b3, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0096, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c4, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0085, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00fe, code lost:
    
        if (r6 == 64) goto L180;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 619
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w8.k.toString():java.lang.String");
    }

    public void u(h hVar, int i) {
        hVar.write(this.f10971a, 0, i);
    }
}
