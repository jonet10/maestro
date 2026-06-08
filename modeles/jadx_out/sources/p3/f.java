package p3;

import androidx.lifecycle.l;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f8425a = Pattern.compile("^[0-1]*$", 2);

    public static ArrayList a(int i, String str) {
        if (!f8425a.matcher(str).matches()) {
            throw new q3.a(l.w("Undecodable FixedIntegerList '", str, "'"));
        }
        int i6 = 2 * i;
        if (str.length() > i6) {
            throw new q3.a(l.w("Undecodable FixedIntegerList '", str, "'"));
        }
        if (str.length() % 2 != 0) {
            throw new q3.a(l.w("Undecodable FixedIntegerList '", str, "'"));
        }
        while (str.length() < i6) {
            str = str.concat("0");
        }
        if (str.length() > i6) {
            str = str.substring(0, i6);
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 < str.length()) {
            int i11 = i10 + 2;
            arrayList.add(Integer.valueOf(e.a(str.substring(i10, i11))));
            i10 = i11;
        }
        while (arrayList.size() < i) {
            arrayList.add(0);
        }
        return arrayList;
    }

    public static String b(int i, List list) {
        if (list.size() > i) {
            throw new a1.b("Too many values '" + list.size() + "'");
        }
        String str = "";
        for (int i6 = 0; i6 < list.size(); i6++) {
            str = str.concat(e.b(((Integer) list.get(i6)).intValue(), 2));
        }
        while (str.length() < 2 * i) {
            str = str.concat("0");
        }
        return str;
    }
}
