package l7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class u extends t {
    public static String j0(byte[] bArr) {
        bArr.getClass();
        return new String(bArr, a.f7151a);
    }

    public static boolean k0(String str, String str2, boolean z9) {
        str.getClass();
        return !z9 ? str.endsWith(str2) : str.regionMatches(true, str.length() - str2.length(), str2, 0, str2.length());
    }

    public static boolean m0(String str, String str2, boolean z9) {
        return str == null ? str2 == null : !z9 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static String n0(int i) {
        if (i < 0) {
            s1.o.f(i, 46, "Count 'n' must be non-negative, but was ");
            return null;
        }
        if (i == 0) {
            return "";
        }
        if (i == 1) {
            return "0";
        }
        char charAt = "0".charAt(0);
        char[] cArr = new char[i];
        for (int i6 = 0; i6 < i; i6++) {
            cArr[i6] = charAt;
        }
        return new String(cArr);
    }

    public static String o0(String str, String str2, String str3, boolean z9) {
        str.getClass();
        str3.getClass();
        int i = 0;
        int v02 = m.v0(str, str2, 0, z9);
        if (v02 < 0) {
            return str;
        }
        int length = str2.length();
        int i6 = length >= 1 ? length : 1;
        int length2 = str3.length() + (str.length() - length);
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i, v02);
            sb.append(str3);
            i = v02 + length;
            if (v02 >= str.length()) {
                break;
            }
            v02 = m.v0(str, str2, v02 + i6, z9);
        } while (v02 > 0);
        sb.append((CharSequence) str, i, str.length());
        return sb.toString();
    }

    public static boolean p0(String str, String str2, boolean z9) {
        str.getClass();
        str2.getClass();
        if (!z9) {
            return str.startsWith(str2);
        }
        int length = str2.length();
        return !z9 ? str.regionMatches(0, str2, 0, length) : str.regionMatches(z9, 0, str2, 0, length);
    }
}
