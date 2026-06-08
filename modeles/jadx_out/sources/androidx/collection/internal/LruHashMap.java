package androidx.collection.internal;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LruHashMap<K, V> {
    private final LinkedHashMap<K, V> map;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LruHashMap(LruHashMap<? extends K, V> lruHashMap) {
        this(0, 0.0f, 3, null);
        lruHashMap.getClass();
        for (Map.Entry<? extends K, V> entry : lruHashMap.getEntries()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public final V get(K k5) {
        k5.getClass();
        return this.map.get(k5);
    }

    public final Set<Map.Entry<K, V>> getEntries() {
        Set<Map.Entry<K, V>> entrySet = this.map.entrySet();
        entrySet.getClass();
        return entrySet;
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    public final V put(K k5, V v) {
        k5.getClass();
        v.getClass();
        return this.map.put(k5, v);
    }

    public final V remove(K k5) {
        k5.getClass();
        return this.map.remove(k5);
    }

    public LruHashMap(int i, float f) {
        this.map = new LinkedHashMap<>(i, f, true);
    }

    public /* synthetic */ LruHashMap(int i, float f, int i6, g gVar) {
        this((i6 & 1) != 0 ? 16 : i, (i6 & 2) != 0 ? 0.75f : f);
    }

    public LruHashMap() {
        this(0, 0.0f, 3, null);
    }
}
