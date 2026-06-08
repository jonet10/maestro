package s8;

import com.google.android.gms.internal.measurement.z3;
import java.io.IOException;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final w8.k f9393a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f9394b;

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f9395c;

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f9396d;

    static {
        w8.k kVar = w8.k.f10970m;
        f9393a = z3.m("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f9394b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f9395c = new String[64];
        f9396d = new String[256];
        int i = 0;
        int i6 = 0;
        while (true) {
            String[] strArr = f9396d;
            if (i6 >= strArr.length) {
                break;
            }
            Object[] objArr = {Integer.toBinaryString(i6)};
            byte[] bArr = n8.c.f8114a;
            strArr[i6] = String.format(Locale.US, "%8s", objArr).replace(' ', '0');
            i6++;
        }
        String[] strArr2 = f9395c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i10 = iArr[0];
        strArr2[i10 | 8] = a4.x.n(new StringBuilder(), strArr2[i10], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i11 = 0; i11 < 3; i11++) {
            int i12 = iArr2[i11];
            int i13 = iArr[0];
            String[] strArr3 = f9395c;
            int i14 = i13 | i12;
            strArr3[i14] = strArr3[i13] + '|' + strArr3[i12];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i13]);
            sb.append('|');
            strArr3[i14 | 8] = a4.x.n(sb, strArr3[i12], "|PADDED");
        }
        while (true) {
            String[] strArr4 = f9395c;
            if (i >= strArr4.length) {
                return;
            }
            if (strArr4[i] == null) {
                strArr4[i] = f9396d[i];
            }
            i++;
        }
    }

    public static String a(boolean z9, int i, int i6, byte b7, byte b10) {
        String format;
        String str;
        String[] strArr = f9394b;
        if (b7 < strArr.length) {
            format = strArr[b7];
        } else {
            Object[] objArr = {Byte.valueOf(b7)};
            byte[] bArr = n8.c.f8114a;
            format = String.format(Locale.US, "0x%02x", objArr);
        }
        if (b10 == 0) {
            str = "";
        } else {
            String[] strArr2 = f9396d;
            if (b7 != 2 && b7 != 3) {
                if (b7 == 4 || b7 == 6) {
                    str = b10 == 1 ? "ACK" : strArr2[b10];
                } else if (b7 != 7 && b7 != 8) {
                    String[] strArr3 = f9395c;
                    String str2 = b10 < strArr3.length ? strArr3[b10] : strArr2[b10];
                    str = (b7 != 5 || (b10 & 4) == 0) ? (b7 != 0 || (b10 & 32) == 0) ? str2 : str2.replace("PRIORITY", "COMPRESSED") : str2.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            str = strArr2[b10];
        }
        Object[] objArr2 = {z9 ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i6), format, str};
        byte[] bArr2 = n8.c.f8114a;
        return String.format(Locale.US, "%s 0x%08x %5d %-13s %s", objArr2);
    }

    public static void b(String str, Object... objArr) {
        byte[] bArr = n8.c.f8114a;
        throw new IllegalArgumentException(String.format(Locale.US, str, objArr));
    }

    public static void c(String str, Object... objArr) {
        byte[] bArr = n8.c.f8114a;
        throw new IOException(String.format(Locale.US, str, objArr));
    }
}
