package q6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class m extends a.a {
    public static int c0(List list) {
        list.getClass();
        return list.size() - 1;
    }

    public static List d0(Object... objArr) {
        if (objArr.length <= 0) {
            return t.f8724a;
        }
        List asList = Arrays.asList(objArr);
        asList.getClass();
        return asList;
    }

    public static ArrayList e0(Object... objArr) {
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new h(objArr, true));
    }

    public static final List f0(List list) {
        int size = list.size();
        return size != 0 ? size != 1 ? list : a.a.H(list.get(0)) : t.f8724a;
    }

    public static void g0() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void h0() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
