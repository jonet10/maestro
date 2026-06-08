package i3;

import j$.util.DesugarTimeZone;
import java.util.TimeZone;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeZone f5652a = DesugarTimeZone.getTimeZone("UTC");

    public static boolean a(String str, int i, char c9) {
        return i < str.length() && str.charAt(i) == c9;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f7 A[Catch: IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, TRY_LEAVE, TryCatch #2 {IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:18:0x005b, B:20:0x006b, B:21:0x006d, B:23:0x0079, B:24:0x007c, B:26:0x0082, B:30:0x008c, B:35:0x009c, B:37:0x00a4, B:38:0x00a8, B:40:0x00ae, B:44:0x00bb, B:48:0x00c6, B:53:0x00f1, B:55:0x00f7, B:59:0x01a9, B:64:0x0109, B:65:0x0124, B:66:0x0125, B:69:0x0142, B:71:0x014f, B:74:0x0158, B:76:0x0177, B:79:0x0186, B:80:0x01a8, B:81:0x0131, B:82:0x01da, B:83:0x01e1, B:84:0x00d6, B:85:0x00d9, B:88:0x00c2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01da A[Catch: IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, TryCatch #2 {IllegalArgumentException -> 0x004e, IndexOutOfBoundsException -> 0x0051, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:18:0x005b, B:20:0x006b, B:21:0x006d, B:23:0x0079, B:24:0x007c, B:26:0x0082, B:30:0x008c, B:35:0x009c, B:37:0x00a4, B:38:0x00a8, B:40:0x00ae, B:44:0x00bb, B:48:0x00c6, B:53:0x00f1, B:55:0x00f7, B:59:0x01a9, B:64:0x0109, B:65:0x0124, B:66:0x0125, B:69:0x0142, B:71:0x014f, B:74:0x0158, B:76:0x0177, B:79:0x0186, B:80:0x01a8, B:81:0x0131, B:82:0x01da, B:83:0x01e1, B:84:0x00d6, B:85:0x00d9, B:88:0x00c2), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date b(java.lang.String r17, java.text.ParsePosition r18) {
        /*
            Method dump skipped, instructions count: 579
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.a.b(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static int c(int i, int i6, String str) {
        int i10;
        int i11;
        if (i < 0 || i6 > str.length() || i > i6) {
            throw new NumberFormatException(str);
        }
        if (i < i6) {
            i11 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: ".concat(str.substring(i, i6)));
            }
            i10 = -digit;
        } else {
            i10 = 0;
            i11 = i;
        }
        while (i11 < i6) {
            int i12 = i11 + 1;
            int digit2 = Character.digit(str.charAt(i11), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: ".concat(str.substring(i, i6)));
            }
            i10 = (i10 * 10) - digit2;
            i11 = i12;
        }
        return -i10;
    }
}
