package p3;

import a4.x;
import androidx.lifecycle.l;
import com.google.android.gms.internal.measurement.i5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f8421a = Logger.getLogger(c.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f8422b = Pattern.compile("^[0-1]*$", 2);

    public static ArrayList a(String str) {
        if (f8422b.matcher(str).matches()) {
            int i = 12;
            if (str.length() >= 12) {
                ArrayList arrayList = new ArrayList();
                int a8 = e.a(str.substring(0, 12));
                int i6 = 0;
                for (int i10 = 0; i10 < a8; i10++) {
                    int i11 = i + 1;
                    boolean k5 = i5.k(str.substring(i, i11));
                    Logger logger = f8421a;
                    if (k5) {
                        int indexOf = str.indexOf("11", i11) + 2;
                        int a10 = b.a(str.substring(i11, indexOf)) + i6;
                        int indexOf2 = str.indexOf("11", indexOf) + 2;
                        int a11 = b.a(str.substring(indexOf, indexOf2)) + a10;
                        if ((a11 - a10) + arrayList.size() > 8192) {
                            logger.warning("FibonacciIntegerRange has too many values");
                            return arrayList;
                        }
                        while (a10 <= a11) {
                            arrayList.add(Integer.valueOf(a10));
                            a10++;
                        }
                        i6 = a11;
                        i = indexOf2;
                    } else {
                        i = str.indexOf("11", i11) + 2;
                        int a12 = b.a(str.substring(i11, i)) + i6;
                        if (arrayList.size() == 8192) {
                            logger.warning("FibonacciIntegerRange has too many values");
                            return arrayList;
                        }
                        arrayList.add(Integer.valueOf(a12));
                        i6 = a12;
                    }
                }
                return arrayList;
            }
        }
        throw new q3.a(l.w("Undecodable FibonacciIntegerRange '", str, "'"));
    }

    public static String b(List list) {
        Collections.sort(list);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < list.size()) {
            int i6 = i;
            while (i6 < list.size() - 1) {
                int i10 = i6 + 1;
                if (((Integer) list.get(i6)).intValue() + 1 == ((Integer) list.get(i10)).intValue()) {
                    i6 = i10;
                }
            }
            int i11 = i6 + 1;
            arrayList.add(list.subList(i, i11));
            i = i11;
        }
        String b7 = e.b(arrayList.size(), 12);
        int i12 = 0;
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            if (((List) arrayList.get(i13)).size() == 1) {
                int intValue = ((Integer) ((List) arrayList.get(i13)).get(0)).intValue() - i12;
                i12 = ((Integer) ((List) arrayList.get(i13)).get(0)).intValue();
                StringBuilder u7 = x.u(b7, "0");
                u7.append(b.b(intValue));
                b7 = u7.toString();
            } else {
                int intValue2 = ((Integer) ((List) arrayList.get(i13)).get(0)).intValue() - i12;
                int intValue3 = ((Integer) ((List) arrayList.get(i13)).get(((List) arrayList.get(i13)).size() - 1)).intValue() - ((Integer) ((List) arrayList.get(i13)).get(0)).intValue();
                i12 = ((Integer) ((List) arrayList.get(i13)).get(((List) arrayList.get(i13)).size() - 1)).intValue();
                StringBuilder u9 = x.u(b7, "1");
                u9.append(b.b(intValue2));
                u9.append(b.b(intValue3));
                b7 = u9.toString();
            }
        }
        return b7;
    }
}
