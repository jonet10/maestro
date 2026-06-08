package p3;

import java.util.regex.Pattern;
import k0.k;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f8428a = Pattern.compile("^[0-1]*$", 2);

    public static String a(long j) {
        String str = "";
        while (j > 0) {
            str = (j & 1) == 1 ? "1".concat(str) : "0".concat(str);
            j >>= 1;
        }
        if (str.length() > 36) {
            throw new a1.b(k.g(j, "Numeric value '", "' is too large for a bit string length of '36'"));
        }
        while (str.length() < 36) {
            str = "0".concat(str);
        }
        return str;
    }
}
