package p3;

import androidx.lifecycle.l;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f8430a = Pattern.compile("^[0-1]*$", 2);

    public static ArrayList a(String str) {
        if (!f8430a.matcher(str).matches() || str.length() < 12) {
            throw new q3.a(l.w("Undecodable FixedIntegerRange '", str, "'"));
        }
        if (str.charAt(16) == '1') {
            return g.a(str.substring(17));
        }
        ArrayList arrayList = new ArrayList();
        ArrayList a8 = d.a(str.substring(17));
        for (int i = 0; i < a8.size(); i++) {
            if (((Boolean) a8.get(i)).booleanValue()) {
                arrayList.add(Integer.valueOf(i + 1));
            }
        }
        return arrayList;
    }

    public static String b(List list) {
        int intValue = list.size() > 0 ? ((Integer) list.get(list.size() - 1)).intValue() : 0;
        String b7 = g.b(list);
        if (b7.length() <= intValue) {
            return e.b(intValue, 16) + "1" + b7;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i6 = 0; i6 < intValue; i6++) {
            if (i6 == ((Integer) list.get(i)).intValue() - 1) {
                arrayList.add(Boolean.TRUE);
                i++;
            } else {
                arrayList.add(Boolean.FALSE);
            }
        }
        return e.b(intValue, 16) + "0" + d.b(intValue, arrayList);
    }
}
