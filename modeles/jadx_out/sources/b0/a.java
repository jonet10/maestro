package b0;

import a3.b;
import android.util.SparseArray;
import androidx.lifecycle.l;
import java.util.HashMap;
import o.d;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseArray f709a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public static final HashMap f710b;

    static {
        HashMap hashMap = new HashMap();
        f710b = hashMap;
        hashMap.put(d.f8126a, 0);
        hashMap.put(d.f8127b, 1);
        hashMap.put(d.f8128l, 2);
        for (d dVar : hashMap.keySet()) {
            f709a.append(((Integer) f710b.get(dVar)).intValue(), dVar);
        }
    }

    public static int a(d dVar) {
        Integer num = (Integer) f710b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        b.l(dVar, "PriorityMapping is missing known Priority value ");
        return 0;
    }

    public static d b(int i) {
        d dVar = (d) f709a.get(i);
        if (dVar != null) {
            return dVar;
        }
        com.google.gson.internal.a.p(l.u(i, "Unknown Priority for value "));
        return null;
    }
}
