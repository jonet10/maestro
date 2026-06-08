package j$.time.format;

import j$.util.stream.y6;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final Map f5859a;

    public void b(y6 y6Var) {
        ((EnumMap) this.f5859a).put((EnumMap) y6Var, (y6) 1);
    }

    public r(int i, Map map) {
        switch (i) {
            case 1:
                this.f5859a = map;
                break;
            default:
                this.f5859a = map;
                HashMap hashMap = new HashMap();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    HashMap hashMap2 = new HashMap();
                    for (Map.Entry entry2 : ((Map) entry.getValue()).entrySet()) {
                        String str = (String) entry2.getValue();
                        String str2 = (String) entry2.getValue();
                        Long l10 = (Long) entry2.getKey();
                        q qVar = b.f5824b;
                        hashMap2.put(str, new AbstractMap.SimpleImmutableEntry(str2, l10));
                    }
                    ArrayList arrayList2 = new ArrayList(hashMap2.values());
                    Collections.sort(arrayList2, b.f5824b);
                    hashMap.put((v) entry.getKey(), arrayList2);
                    arrayList.addAll(arrayList2);
                    hashMap.put(null, arrayList);
                }
                Collections.sort(arrayList, b.f5824b);
                break;
        }
    }

    public String a(long j, v vVar) {
        Map map = (Map) this.f5859a.get(vVar);
        if (map != null) {
            return (String) map.get(Long.valueOf(j));
        }
        return null;
    }
}
