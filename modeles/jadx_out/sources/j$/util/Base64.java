package j$.util;

import java.util.Arrays;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class Base64 {
    public static Decoder getUrlDecoder() {
        return Decoder.f5961c;
    }

    public static class Decoder {

        /* renamed from: a, reason: collision with root package name */
        public static final int[] f5959a;

        /* renamed from: b, reason: collision with root package name */
        public static final int[] f5960b;

        /* renamed from: c, reason: collision with root package name */
        public static final Decoder f5961c;

        static {
            int[] iArr = new int[256];
            f5959a = iArr;
            Arrays.fill(iArr, -1);
            for (int i = 0; i < 64; i++) {
                f5959a[c.f5973a[i]] = i;
            }
            f5959a[61] = -2;
            int[] iArr2 = new int[256];
            f5960b = iArr2;
            Arrays.fill(iArr2, -1);
            for (int i6 = 0; i6 < 64; i6++) {
                f5960b[c.f5974b[i6]] = i6;
            }
            f5960b[61] = -2;
            f5961c = new Decoder();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x00b8, code lost:
        
            if (r0[r2] == 61) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00bf, code lost:
        
            if (r9 != 18) goto L57;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public byte[] decode(java.lang.String r21) {
            /*
                Method dump skipped, instructions count: 326
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.util.Base64.Decoder.decode(java.lang.String):byte[]");
        }
    }
}
