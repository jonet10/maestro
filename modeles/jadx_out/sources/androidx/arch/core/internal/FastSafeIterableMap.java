package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.arch.core.internal.SafeIterableMap;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    private final HashMap<K, SafeIterableMap.Entry<K, V>> mHashMap = new HashMap<>();

    @Nullable
    public Map.Entry<K, V> ceil(K k5) {
        if (contains(k5)) {
            return this.mHashMap.get(k5).mPrevious;
        }
        return null;
    }

    public boolean contains(K k5) {
        return this.mHashMap.containsKey(k5);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    @Nullable
    public SafeIterableMap.Entry<K, V> get(K k5) {
        return this.mHashMap.get(k5);
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V putIfAbsent(@NonNull K k5, @NonNull V v) {
        SafeIterableMap.Entry<K, V> entry = get(k5);
        if (entry != null) {
            return entry.mValue;
        }
        this.mHashMap.put(k5, put(k5, v));
        return null;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V remove(@NonNull K k5) {
        V v = (V) super.remove(k5);
        this.mHashMap.remove(k5);
        return v;
    }
}
