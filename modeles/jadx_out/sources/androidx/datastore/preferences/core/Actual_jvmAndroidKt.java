package androidx.datastore.preferences.core;

import androidx.annotation.RestrictTo;
import j$.util.DesugarCollections;
import java.util.Map;
import java.util.Set;
import o7.m0;
import o7.w;
import q6.l;
import v7.d;
import v7.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Actual_jvmAndroidKt {
    public static final <T> Set<T> immutableCopyOfSet(Set<? extends T> set) {
        set.getClass();
        Set<T> unmodifiableSet = DesugarCollections.unmodifiableSet(l.J0(set));
        unmodifiableSet.getClass();
        return unmodifiableSet;
    }

    public static final <K, V> Map<K, V> immutableMap(Map<K, ? extends V> map) {
        map.getClass();
        Map<K, V> unmodifiableMap = DesugarCollections.unmodifiableMap(map);
        unmodifiableMap.getClass();
        return unmodifiableMap;
    }

    public static final w ioDispatcher() {
        e eVar = m0.f8288a;
        return d.f10884a;
    }
}
