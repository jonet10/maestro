package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import d7.l;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final /* synthetic */ class RelationUtil__RelationUtil_androidKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchArrayMap(ArrayMap<K, V> arrayMap, boolean z9, l lVar) {
        arrayMap.getClass();
        lVar.getClass();
        ArrayMap arrayMap2 = new ArrayMap(999);
        int size = arrayMap.size();
        int i = 0;
        int i6 = 0;
        while (i < size) {
            if (z9) {
                arrayMap2.put(arrayMap.keyAt(i), arrayMap.valueAt(i));
            } else {
                arrayMap2.put(arrayMap.keyAt(i), null);
            }
            i++;
            i6++;
            if (i6 == 999) {
                lVar.invoke(arrayMap2);
                if (!z9) {
                    arrayMap.putAll((Map) arrayMap2);
                }
                arrayMap2.clear();
                i6 = 0;
            }
        }
        if (i6 > 0) {
            lVar.invoke(arrayMap2);
            if (z9) {
                return;
            }
            arrayMap.putAll((Map) arrayMap2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchHashMap(HashMap<K, V> hashMap, boolean z9, l lVar) {
        int i;
        hashMap.getClass();
        lVar.getClass();
        HashMap hashMap2 = new HashMap(999);
        loop0: while (true) {
            i = 0;
            for (K k5 : hashMap.keySet()) {
                k5.getClass();
                if (z9) {
                    hashMap2.put(k5, hashMap.get(k5));
                } else {
                    hashMap2.put(k5, null);
                }
                i++;
                if (i == 999) {
                    lVar.invoke(hashMap2);
                    if (!z9) {
                        hashMap.putAll(hashMap2);
                    }
                    hashMap2.clear();
                }
            }
            break loop0;
        }
        if (i > 0) {
            lVar.invoke(hashMap2);
            if (z9) {
                return;
            }
            hashMap.putAll(hashMap2);
        }
    }
}
