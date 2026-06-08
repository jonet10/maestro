package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import d7.l;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RelationUtil {
    public static final int MAX_BIND_PARAMETER_CNT = 999;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchArrayMap(ArrayMap<K, V> arrayMap, boolean z9, l lVar) {
        RelationUtil__RelationUtil_androidKt.recursiveFetchArrayMap(arrayMap, z9, lVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchHashMap(HashMap<K, V> hashMap, boolean z9, l lVar) {
        RelationUtil__RelationUtil_androidKt.recursiveFetchHashMap(hashMap, z9, lVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <V> void recursiveFetchLongSparseArray(LongSparseArray<V> longSparseArray, boolean z9, l lVar) {
        RelationUtil__RelationUtilKt.recursiveFetchLongSparseArray(longSparseArray, z9, lVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <K, V> void recursiveFetchMap(Map<K, V> map, boolean z9, l lVar) {
        RelationUtil__RelationUtilKt.recursiveFetchMap(map, z9, lVar);
    }
}
