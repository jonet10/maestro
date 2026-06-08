package androidx.collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class IntObjectMapKt {
    private static final MutableIntObjectMap EmptyIntObjectMap = new MutableIntObjectMap(0);

    public static final <V> IntObjectMap<V> emptyIntObjectMap() {
        MutableIntObjectMap mutableIntObjectMap = EmptyIntObjectMap;
        mutableIntObjectMap.getClass();
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i, V v, int i6, V v9, int i10, V v10, int i11, V v11, int i12, V v12) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i, v);
        mutableIntObjectMap.set(i6, v9);
        mutableIntObjectMap.set(i10, v10);
        mutableIntObjectMap.set(i11, v11);
        mutableIntObjectMap.set(i12, v12);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i, V v, int i6, V v9, int i10, V v10, int i11, V v11, int i12, V v12) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i, v);
        mutableIntObjectMap.set(i6, v9);
        mutableIntObjectMap.set(i10, v10);
        mutableIntObjectMap.set(i11, v11);
        mutableIntObjectMap.set(i12, v12);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i, V v) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i, v);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i, V v) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i, v);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i, V v, int i6, V v9) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i, v);
        mutableIntObjectMap.set(i6, v9);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i, V v, int i6, V v9) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i, v);
        mutableIntObjectMap.set(i6, v9);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i, V v, int i6, V v9, int i10, V v10) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i, v);
        mutableIntObjectMap.set(i6, v9);
        mutableIntObjectMap.set(i10, v10);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i, V v, int i6, V v9, int i10, V v10) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i, v);
        mutableIntObjectMap.set(i6, v9);
        mutableIntObjectMap.set(i10, v10);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf(int i, V v, int i6, V v9, int i10, V v10, int i11, V v11) {
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, null);
        mutableIntObjectMap.set(i, v);
        mutableIntObjectMap.set(i6, v9);
        mutableIntObjectMap.set(i10, v10);
        mutableIntObjectMap.set(i11, v11);
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i, V v, int i6, V v9, int i10, V v10, int i11, V v11) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i, v);
        mutableIntObjectMap.set(i6, v9);
        mutableIntObjectMap.set(i10, v10);
        mutableIntObjectMap.set(i11, v11);
        return mutableIntObjectMap;
    }

    public static final <V> IntObjectMap<V> intObjectMapOf() {
        MutableIntObjectMap mutableIntObjectMap = EmptyIntObjectMap;
        mutableIntObjectMap.getClass();
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf() {
        return new MutableIntObjectMap<>(0, 1, null);
    }
}
