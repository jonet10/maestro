package androidx.collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LongObjectMapKt {
    private static final MutableLongObjectMap EmptyLongObjectMap = new MutableLongObjectMap(0);

    public static final <V> LongObjectMap<V> emptyLongObjectMap() {
        MutableLongObjectMap mutableLongObjectMap = EmptyLongObjectMap;
        mutableLongObjectMap.getClass();
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v, long j6, V v9, long j10, V v10, long j11, V v11, long j12, V v12) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j6, v9);
        mutableLongObjectMap.set(j10, v10);
        mutableLongObjectMap.set(j11, v11);
        mutableLongObjectMap.set(j12, v12);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v, long j6, V v9, long j10, V v10, long j11, V v11, long j12, V v12) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j6, v9);
        mutableLongObjectMap.set(j10, v10);
        mutableLongObjectMap.set(j11, v11);
        mutableLongObjectMap.set(j12, v12);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v, long j6, V v9) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j6, v9);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v, long j6, V v9) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j6, v9);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v, long j6, V v9, long j10, V v10) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j6, v9);
        mutableLongObjectMap.set(j10, v10);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v, long j6, V v9, long j10, V v10) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j6, v9);
        mutableLongObjectMap.set(j10, v10);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf(long j, V v, long j6, V v9, long j10, V v10, long j11, V v11) {
        MutableLongObjectMap mutableLongObjectMap = new MutableLongObjectMap(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j6, v9);
        mutableLongObjectMap.set(j10, v10);
        mutableLongObjectMap.set(j11, v11);
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf(long j, V v, long j6, V v9, long j10, V v10, long j11, V v11) {
        MutableLongObjectMap<V> mutableLongObjectMap = new MutableLongObjectMap<>(0, 1, null);
        mutableLongObjectMap.set(j, v);
        mutableLongObjectMap.set(j6, v9);
        mutableLongObjectMap.set(j10, v10);
        mutableLongObjectMap.set(j11, v11);
        return mutableLongObjectMap;
    }

    public static final <V> LongObjectMap<V> longObjectMapOf() {
        MutableLongObjectMap mutableLongObjectMap = EmptyLongObjectMap;
        mutableLongObjectMap.getClass();
        return mutableLongObjectMap;
    }

    public static final <V> MutableLongObjectMap<V> mutableLongObjectMapOf() {
        return new MutableLongObjectMap<>(0, 1, null);
    }
}
