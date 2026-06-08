package p3;

import androidx.lifecycle.l;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f8424a = Pattern.compile("^[0-1]*$", 2);

    public static int a(String str) {
        if (!f8424a.matcher(str).matches()) {
            throw new q3.a(l.w("Undecodable FixedInteger '", str, "'"));
        }
        int i = 0;
        int i6 = 0;
        while (i < str.length()) {
            int i10 = i + 1;
            if (str.charAt(str.length() - i10) == '1') {
                i6 += 1 << i;
            }
            i = i10;
        }
        return i6;
    }

    public static String b(int i, int i6) {
        String str = "";
        while (i > 0) {
            str = (i & 1) == 1 ? "1".concat(str) : "0".concat(str);
            i >>= 1;
        }
        if (str.length() <= i6) {
            while (str.length() < i6) {
                str = "0".concat(str);
            }
            return str;
        }
        throw new a1.b("Numeric value '" + i + "' is too large for a bit string length of '" + i6 + "'");
    }
}
