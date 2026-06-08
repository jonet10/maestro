package q6;

import com.google.android.gms.internal.measurement.z3;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class b0 extends z3 {
    public static LinkedHashSet Z(Set set, Set set2) {
        set.getClass();
        set2.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet(a0.h0(set.size() + Integer.valueOf(set2.size()).intValue()));
        linkedHashSet.addAll(set);
        r.k0(set2, linkedHashSet);
        return linkedHashSet;
    }
}
