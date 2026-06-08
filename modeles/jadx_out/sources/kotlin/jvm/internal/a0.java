package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a0 {
    public static Collection a(ArrayList arrayList) {
        if (!(arrayList instanceof e7.a) || (arrayList instanceof e7.b)) {
            return arrayList;
        }
        e(arrayList, "kotlin.collections.MutableCollection");
        throw null;
    }

    public static void b(int i, Object obj) {
        if (obj == null || c(i, obj)) {
            return;
        }
        e(obj, "kotlin.jvm.functions.Function" + i);
        throw null;
    }

    public static boolean c(int i, Object obj) {
        if (obj instanceof p6.c) {
            if ((obj instanceof i ? ((i) obj).getArity() : obj instanceof d7.a ? 0 : obj instanceof d7.l ? 1 : obj instanceof d7.p ? 2 : obj instanceof d7.q ? 3 : obj instanceof d7.r ? 4 : obj instanceof d7.t ? 6 : -1) == i) {
                return true;
            }
        }
        return false;
    }

    public static final b d(Object[] objArr) {
        objArr.getClass();
        return new b(objArr);
    }

    public static void e(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(a4.x.k(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        l.e(classCastException, a0.class.getName());
        throw classCastException;
    }
}
