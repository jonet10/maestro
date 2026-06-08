package k7;

import c4.w6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q6.t;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class i extends j {
    public static f h0(d7.l lVar, Object obj) {
        lVar.getClass();
        return obj == null ? b.f6986a : new d(new w6(obj, 19), lVar);
    }

    public static List i0(f fVar) {
        Iterator it = fVar.iterator();
        if (!it.hasNext()) {
            return t.f8724a;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return a.a.H(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
