package p3;

import androidx.lifecycle.l;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f8420a = Pattern.compile("^[0-1]*$", 2);

    public static int a(String str) {
        if (str.length() > 24) {
            throw new q3.a("FibonacciInteger too long");
        }
        if (!f8420a.matcher(str).matches() || str.length() < 2 || str.indexOf("11") != str.length() - 2) {
            throw new q3.a(l.w("Undecodable FibonacciInteger '", str, "'"));
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < str.length() - 1; i++) {
            if (i == 0) {
                arrayList.add(1);
            } else if (i == 1) {
                arrayList.add(2);
            } else {
                arrayList.add(Integer.valueOf(((Integer) arrayList.get(i - 2)).intValue() + ((Integer) arrayList.get(i - 1)).intValue()));
            }
        }
        int i6 = 0;
        for (int i10 = 0; i10 < str.length() - 1; i10++) {
            if (str.charAt(i10) == '1') {
                i6 = ((Integer) arrayList.get(i10)).intValue() + i6;
            }
        }
        return i6;
    }

    public static String b(int i) {
        ArrayList arrayList = new ArrayList();
        if (i >= 1) {
            arrayList.add(1);
            int i6 = 2;
            if (i >= 2) {
                arrayList.add(2);
                while (true) {
                    int i10 = i6 - 1;
                    int i11 = i6 - 2;
                    if (i < ((Integer) arrayList.get(i11)).intValue() + ((Integer) arrayList.get(i10)).intValue()) {
                        break;
                    }
                    arrayList.add(Integer.valueOf(((Integer) arrayList.get(i11)).intValue() + ((Integer) arrayList.get(i10)).intValue()));
                    i6++;
                }
            }
        }
        String str = "1";
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) arrayList.get(size)).intValue();
            if (i >= intValue) {
                str = "1".concat(str);
                i -= intValue;
            } else {
                str = "0".concat(str);
            }
        }
        return str;
    }
}
