package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class y6 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2919a = 0;

    static {
        if (w6.f2890e && w6.f2889d) {
            int i = u4.f2819a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x007a A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0076 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(int r6, int r7, byte[] r8) {
        /*
        L0:
            if (r6 >= r7) goto L9
            r0 = r8[r6]
            if (r0 < 0) goto L9
            int r6 = r6 + 1
            goto L0
        L9:
            if (r6 < r7) goto Ld
            goto L7a
        Ld:
            if (r6 >= r7) goto L7a
            int r0 = r6 + 1
            r1 = r8[r6]
            if (r1 >= 0) goto L78
            r2 = -32
            r3 = -65
            if (r1 >= r2) goto L29
            if (r0 < r7) goto L1e
            goto L57
        L1e:
            r2 = -62
            if (r1 < r2) goto L76
            int r6 = r6 + 2
            r0 = r8[r0]
            if (r0 <= r3) goto Ld
            goto L76
        L29:
            r4 = -16
            if (r1 >= r4) goto L4f
            int r4 = r7 + (-1)
            if (r0 < r4) goto L36
            int r1 = d(r0, r7, r8)
            goto L57
        L36:
            int r4 = r6 + 2
            r0 = r8[r0]
            if (r0 > r3) goto L76
            r5 = -96
            if (r1 != r2) goto L42
            if (r0 < r5) goto L76
        L42:
            r2 = -19
            if (r1 != r2) goto L48
            if (r0 >= r5) goto L76
        L48:
            int r6 = r6 + 3
            r0 = r8[r4]
            if (r0 <= r3) goto Ld
            goto L76
        L4f:
            int r2 = r7 + (-2)
            if (r0 < r2) goto L5a
            int r1 = d(r0, r7, r8)
        L57:
            if (r1 == 0) goto L7a
            goto L76
        L5a:
            int r2 = r6 + 2
            r0 = r8[r0]
            if (r0 > r3) goto L76
            int r1 = r1 << 28
            int r0 = r0 + 112
            int r0 = r0 + r1
            int r0 = r0 >> 30
            if (r0 != 0) goto L76
            int r0 = r6 + 3
            r1 = r8[r2]
            if (r1 > r3) goto L76
            int r6 = r6 + 4
            r0 = r8[r0]
            if (r0 > r3) goto L76
            goto Ld
        L76:
            r6 = 0
            return r6
        L78:
            r6 = r0
            goto Ld
        L7a:
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.y6.a(int, int, byte[]):boolean");
    }

    public static int b(String str) {
        int length = str.length();
        int i = 0;
        int i6 = 0;
        while (i6 < length && str.charAt(i6) < 128) {
            i6++;
        }
        int i10 = length;
        while (true) {
            if (i6 >= length) {
                break;
            }
            char charAt = str.charAt(i6);
            if (charAt < 2048) {
                i10 += (127 - charAt) >>> 31;
                i6++;
            } else {
                int length2 = str.length();
                while (i6 < length2) {
                    char charAt2 = str.charAt(i6);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (charAt2 >= 55296 && charAt2 <= 57343) {
                            if (Character.codePointAt(str, i6) < 65536) {
                                throw new x6(i6, length2);
                            }
                            i6++;
                        }
                    }
                    i6++;
                }
                i10 += i;
            }
        }
        if (i10 >= length) {
            return i10;
        }
        long j = i10 + 4294967296L;
        StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 34);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001e, code lost:
    
        return r10 + r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(java.lang.String r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.y6.c(java.lang.String, byte[], int, int):int");
    }

    public static /* synthetic */ int d(int i, int i6, byte[] bArr) {
        int i10 = i6 - i;
        byte b7 = bArr[i - 1];
        if (i10 == 0) {
            if (b7 <= -12) {
                return b7;
            }
            return -1;
        }
        if (i10 == 1) {
            byte b10 = bArr[i];
            if (b7 > -12 || b10 > -65) {
                return -1;
            }
            return (b10 << 8) ^ b7;
        }
        if (i10 != 2) {
            throw new AssertionError();
        }
        byte b11 = bArr[i];
        byte b12 = bArr[i + 1];
        if (b7 > -12 || b11 > -65 || b12 > -65) {
            return -1;
        }
        return (b12 << 16) ^ ((b11 << 8) ^ b7);
    }
}
