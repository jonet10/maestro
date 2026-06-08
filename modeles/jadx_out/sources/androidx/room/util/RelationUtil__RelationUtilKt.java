package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import d7.l;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final /* synthetic */ class RelationUtil__RelationUtilKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <V> void recursiveFetchLongSparseArray(LongSparseArray<V> longSparseArray, boolean z9, l lVar) {
        longSparseArray.getClass();
        lVar.getClass();
        LongSparseArray<? extends V> longSparseArray2 = new LongSparseArray<>(999);
        int size = longSparseArray.size();
        int i = 0;
        int i6 = 0;
        while (i < size) {
            if (z9) {
                longSparseArray2.put(longSparseArray.keyAt(i), longSparseArray.valueAt(i));
            } else {
                longSparseArray2.put(longSparseArray.keyAt(i), null);
            }
            i++;
            i6++;
            if (i6 == 999) {
                lVar.invoke(longSparseArray2);
                if (!z9) {
                    longSparseArray.putAll(longSparseArray2);
                }
                longSparseArray2.clear();
                i6 = 0;
            }
        }
        if (i6 > 0) {
            lVar.invoke(longSparseArray2);
            if (z9) {
                return;
            }
            longSparseArray.putAll(longSparseArray2);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchMap(Map<K, V> map, boolean z9, l lVar) {
        int i;
        map.getClass();
        lVar.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        loop0: while (true) {
            i = 0;
            for (K k5 : map.keySet()) {
                if (z9) {
                    linkedHashMap.put(k5, map.get(k5));
                } else {
                    linkedHashMap.put(k5, null);
                }
                i++;
                if (i == 999) {
                    lVar.invoke(linkedHashMap);
                    if (!z9) {
                        map.putAll(linkedHashMap);
                    }
                    linkedHashMap.clear();
                }
            }
            break loop0;
        }
        if (i > 0) {
            lVar.invoke(linkedHashMap);
            if (z9) {
                return;
            }
            map.putAll(linkedHashMap);
        }
    }
}
