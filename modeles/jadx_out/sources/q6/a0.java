package q6;

import b2.t1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a0 extends t1 {
    public static Object g0(Map map, Object obj) {
        map.getClass();
        if (map instanceof z) {
            return ((z) map).b();
        }
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        a3.b.m(obj, "Key ", " is missing in the map.");
        return null;
    }

    public static int h0(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static Map i0(p6.i... iVarArr) {
        if (iVarArr.length <= 0) {
            return u.f8725a;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(h0(iVarArr.length));
        j0(linkedHashMap, iVarArr);
        return linkedHashMap;
    }

    public static final void j0(HashMap hashMap, p6.i[] iVarArr) {
        for (p6.i iVar : iVarArr) {
            hashMap.put(iVar.f8441a, iVar.f8442b);
        }
    }

    public static Map k0(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return u.f8725a;
        }
        int i = 0;
        if (size == 1) {
            p6.i iVar = (p6.i) arrayList.get(0);
            iVar.getClass();
            Map singletonMap = Collections.singletonMap(iVar.f8441a, iVar.f8442b);
            singletonMap.getClass();
            return singletonMap;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(h0(arrayList.size()));
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj = arrayList.get(i);
            i++;
            p6.i iVar2 = (p6.i) obj;
            linkedHashMap.put(iVar2.f8441a, iVar2.f8442b);
        }
        return linkedHashMap;
    }

    public static Map l0(Map map) {
        map.getClass();
        int size = map.size();
        if (size == 0) {
            return u.f8725a;
        }
        if (size != 1) {
            return new LinkedHashMap(map);
        }
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        singletonMap.getClass();
        return singletonMap;
    }
}
