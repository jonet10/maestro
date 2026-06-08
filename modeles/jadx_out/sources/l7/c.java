package l7;

import a4.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f7157a;

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f7158b;

    static {
        int[] iArr = new int[256];
        int i = 0;
        for (int i6 = 0; i6 < 256; i6++) {
            iArr[i6] = "0123456789abcdef".charAt(i6 & 15) | ("0123456789abcdef".charAt(i6 >> 4) << '\b');
        }
        f7157a = iArr;
        int[] iArr2 = new int[256];
        for (int i10 = 0; i10 < 256; i10++) {
            iArr2[i10] = "0123456789ABCDEF".charAt(i10 & 15) | ("0123456789ABCDEF".charAt(i10 >> 4) << '\b');
        }
        int[] iArr3 = new int[256];
        for (int i11 = 0; i11 < 256; i11++) {
            iArr3[i11] = -1;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < "0123456789abcdef".length()) {
            iArr3["0123456789abcdef".charAt(i12)] = i13;
            i12++;
            i13++;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < "0123456789ABCDEF".length()) {
            iArr3["0123456789ABCDEF".charAt(i14)] = i15;
            i14++;
            i15++;
        }
        long[] jArr = new long[256];
        for (int i16 = 0; i16 < 256; i16++) {
            jArr[i16] = -1;
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < "0123456789abcdef".length()) {
            jArr["0123456789abcdef".charAt(i17)] = i18;
            i17++;
            i18++;
        }
        int i19 = 0;
        while (i < "0123456789ABCDEF".length()) {
            jArr["0123456789ABCDEF".charAt(i)] = i19;
            i++;
            i19++;
        }
        f7158b = jArr;
    }

    public static final void a(int i, int i6, String str) {
        int i10 = i6 - i;
        if (i10 < 1) {
            throw new NumberFormatException("Expected at least 1 hexadecimal digits at index " + i + ", but was \"" + str.substring(i, i6) + "\" of length " + i10);
        }
        if (i10 > 16) {
            int i11 = (i10 + i) - 16;
            while (i < i11) {
                if (str.charAt(i) != '0') {
                    StringBuilder p10 = x.p(i, "Expected the hexadecimal digit '0' at index ", ", but was '");
                    p10.append(str.charAt(i));
                    p10.append("'.\nThe result won't fit the type being parsed.");
                    throw new NumberFormatException(p10.toString());
                }
                i++;
            }
        }
    }

    public static long b(int i, int i6, String str) {
        f fVar = f.f7162d;
        fVar.getClass();
        q6.b bVar = q6.e.Companion;
        int length = str.length();
        bVar.getClass();
        q6.b.a(i, i6, length);
        if (fVar.f7165c.f7161a) {
            a(i, i6, str);
            return c(i, i6, str);
        }
        if (i6 - i <= 0) {
            throw new NumberFormatException("Expected a hexadecimal number with prefix \"\" and suffix \"\", but was ".concat(str.substring(i, i6)));
        }
        a(i, i6, str);
        return c(i, i6, str);
    }

    public static final long c(int i, int i6, String str) {
        long j = 0;
        while (i < i6) {
            long j6 = j << 4;
            char charAt = str.charAt(i);
            if ((charAt >>> '\b') == 0) {
                long j10 = f7158b[charAt];
                if (j10 >= 0) {
                    j = j6 | j10;
                    i++;
                }
            }
            StringBuilder p10 = x.p(i, "Expected a hexadecimal digit at index ", ", but was ");
            p10.append(str.charAt(i));
            throw new NumberFormatException(p10.toString());
        }
        return j;
    }
}
