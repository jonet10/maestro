package l7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class t extends s {
    public static final void g0(String str) {
        throw new NumberFormatException("Invalid number format: '" + str + '\'');
    }

    public static Integer h0(String str) {
        boolean z9;
        int i;
        int i6;
        str.getClass();
        d0.b.v(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i10 = 0;
        char charAt = str.charAt(0);
        int i11 = -2147483647;
        if (kotlin.jvm.internal.l.c(charAt, 48) < 0) {
            i = 1;
            if (length == 1) {
                return null;
            }
            if (charAt == '+') {
                z9 = false;
            } else {
                if (charAt != '-') {
                    return null;
                }
                i11 = Integer.MIN_VALUE;
                z9 = true;
            }
        } else {
            z9 = false;
            i = 0;
        }
        int i12 = -59652323;
        while (i < length) {
            int digit = Character.digit((int) str.charAt(i), 10);
            if (digit < 0) {
                return null;
            }
            if ((i10 < i12 && (i12 != -59652323 || i10 < (i12 = i11 / 10))) || (i6 = i10 * 10) < i11 + digit) {
                return null;
            }
            i10 = i6 - digit;
            i++;
        }
        return z9 ? Integer.valueOf(i10) : Integer.valueOf(-i10);
    }

    public static Long i0(String str) {
        boolean z9;
        str.getClass();
        d0.b.v(10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i = 0;
        char charAt = str.charAt(0);
        long j = -9223372036854775807L;
        if (kotlin.jvm.internal.l.c(charAt, 48) < 0) {
            z9 = true;
            if (length == 1) {
                return null;
            }
            if (charAt == '+') {
                z9 = false;
                i = 1;
            } else {
                if (charAt != '-') {
                    return null;
                }
                j = Long.MIN_VALUE;
                i = 1;
            }
        } else {
            z9 = false;
        }
        long j6 = 0;
        long j10 = -256204778801521550L;
        while (i < length) {
            int digit = Character.digit((int) str.charAt(i), 10);
            if (digit < 0) {
                return null;
            }
            if (j6 < j10) {
                if (j10 != -256204778801521550L) {
                    return null;
                }
                j10 = j / 10;
                if (j6 < j10) {
                    return null;
                }
            }
            long j11 = j6 * 10;
            long j12 = digit;
            if (j11 < j + j12) {
                return null;
            }
            j6 = j11 - j12;
            i++;
        }
        return z9 ? Long.valueOf(j6) : Long.valueOf(-j6);
    }
}
