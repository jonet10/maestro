package a9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import q2.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f213a = Pattern.compile("[\\\\&]");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f214b = Pattern.compile("\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f215c;

    /* renamed from: d, reason: collision with root package name */
    public static final e f216d;

    static {
        Pattern.compile("(%[a-fA-F0-9]{0,2}|[^:/?#@!$&'()*+,;=a-zA-Z0-9\\-._~])");
        f215c = Pattern.compile("[ \t\r\n]+");
        f216d = new e(4);
    }

    public static String a(String str) {
        if (!f213a.matcher(str).find()) {
            return str;
        }
        Matcher matcher = f214b.matcher(str);
        if (!matcher.find()) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length() + 16);
        int i = 0;
        do {
            sb.append((CharSequence) str, i, matcher.start());
            String group = matcher.group();
            f216d.getClass();
            if (group.charAt(0) == '\\') {
                sb.append((CharSequence) group, 1, group.length());
            } else {
                sb.append(b.a(group));
            }
            i = matcher.end();
        } while (matcher.find());
        if (i != str.length()) {
            sb.append((CharSequence) str, i, str.length());
        }
        return sb.toString();
    }
}
