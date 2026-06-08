package p3;

import androidx.lifecycle.l;
import com.google.android.gms.internal.measurement.i5;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f8423a = Pattern.compile("^[0-1]*$", 2);

    public static ArrayList a(String str) {
        if (!f8423a.matcher(str).matches()) {
            throw new q3.a(l.w("Undecodable FixedBitfield '", str, "'"));
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < str.length()) {
            int i6 = i + 1;
            arrayList.add(Boolean.valueOf(i5.k(str.substring(i, i6))));
            i = i6;
        }
        return arrayList;
    }

    public static String b(int i, List list) {
        if (list.size() > i) {
            throw new a1.b("Too many values '" + list.size() + "'");
        }
        String str = "";
        for (int i6 = 0; i6 < list.size(); i6++) {
            str = str.concat(i5.p((Boolean) list.get(i6)));
        }
        while (str.length() < i) {
            str = str.concat("0");
        }
        return str;
    }
}
