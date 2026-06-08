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
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f8426a = Logger.getLogger(g.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f8427b = Pattern.compile("^[0-1]*$", 2);

    public static ArrayList a(String str) {
        if (f8427b.matcher(str).matches()) {
            int i = 12;
            if (str.length() >= 12) {
                ArrayList arrayList = new ArrayList();
                int a8 = e.a(str.substring(0, 12));
                for (int i6 = 0; i6 < a8; i6++) {
                    int i10 = i + 1;
                    boolean k5 = i5.k(str.substring(i, i10));
                    Logger logger = f8426a;
                    if (k5) {
                        int i11 = i + 17;
                        int a10 = e.a(str.substring(i10, i11));
                        i += 33;
                        int a11 = e.a(str.substring(i11, i));
                        if (a11 < a10) {
                            throw new q3.a("FixedIntegerRange has invalid range");
                        }
                        if ((a11 - a10) + arrayList.size() > 8192) {
                            logger.warning("FixedIntegerRange has too many values");
                            return arrayList;
                        }
                        while (a10 <= a11) {
                            arrayList.add(Integer.valueOf(a10));
                            a10++;
                        }
                    } else {
                        i += 17;
                        int a12 = e.a(str.substring(i10, i));
                        if (arrayList.size() == 8192) {
                            logger.warning("FixedIntegerRange has too many values");
                            return arrayList;
                        }
                        arrayList.add(Integer.valueOf(a12));
                    }
                }
                return arrayList;
            }
        }
        throw new q3.a(l.w("Undecodable FixedIntegerRange '", str, "'"));
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
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            if (((List) arrayList.get(i12)).size() == 1) {
                StringBuilder u7 = x.u(b7, "0");
                u7.append(e.b(((Integer) ((List) arrayList.get(i12)).get(0)).intValue(), 16));
                b7 = u7.toString();
            } else {
                StringBuilder u9 = x.u(b7, "1");
                u9.append(e.b(((Integer) ((List) arrayList.get(i12)).get(0)).intValue(), 16));
                u9.append(e.b(((Integer) ((List) arrayList.get(i12)).get(((List) arrayList.get(i12)).size() - 1)).intValue(), 16));
                b7 = u9.toString();
            }
        }
        return b7;
    }
}
