package p3;

import a4.x;
import androidx.lifecycle.l;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f8429a = Pattern.compile("^[0-1]*$", 2);

    public static String a(String str) {
        if (!f8429a.matcher(str).matches() || str.length() % 6 != 0) {
            throw new q3.a(l.w("Undecodable FixedString '", str, "'"));
        }
        String str2 = "";
        int i = 0;
        while (i < str.length()) {
            int i6 = i + 6;
            int a8 = e.a(str.substring(i, i6));
            if (a8 == 63) {
                str2 = str2.concat(" ");
            } else {
                StringBuilder t9 = x.t(str2);
                t9.append((char) (a8 + 65));
                str2 = t9.toString();
            }
            i = i6;
        }
        return str2.trim();
    }

    public static String b(String str) {
        while (str.length() < 2) {
            str = str.concat(" ");
        }
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == ' ') {
                str2 = str2.concat(e.b(63, 6));
            } else {
                if (charAt < 'A') {
                    throw new a1.b(l.w("Unencodable FixedString '", str, "'"));
                }
                str2 = str2.concat(e.b(str.charAt(i) - 'A', 6));
            }
        }
        return str2;
    }
}
