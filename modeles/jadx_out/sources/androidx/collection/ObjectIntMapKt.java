package androidx.collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ObjectIntMapKt {
    private static final MutableObjectIntMap<Object> EmptyObjectIntMap = new MutableObjectIntMap<>(0);

    public static final <K> ObjectIntMap<K> emptyObjectIntMap() {
        MutableObjectIntMap<Object> mutableObjectIntMap = EmptyObjectIntMap;
        mutableObjectIntMap.getClass();
        return mutableObjectIntMap;
    }

    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf(K k5, int i, K k10, int i6, K k11, int i10, K k12, int i11, K k13, int i12) {
        MutableObjectIntMap<K> mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
        mutableObjectIntMap.set(k5, i);
        mutableObjectIntMap.set(k10, i6);
        mutableObjectIntMap.set(k11, i10);
        mutableObjectIntMap.set(k12, i11);
        mutableObjectIntMap.set(k13, i12);
        return mutableObjectIntMap;
    }

    public static final <K> ObjectIntMap<K> objectIntMap() {
        MutableObjectIntMap<Object> mutableObjectIntMap = EmptyObjectIntMap;
        mutableObjectIntMap.getClass();
        return mutableObjectIntMap;
    }

    public static final <K> ObjectIntMap<K> objectIntMapOf(K k5, int i, K k10, int i6, K k11, int i10, K k12, int i11, K k13, int i12) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
        mutableObjectIntMap.set(k5, i);
        mutableObjectIntMap.set(k10, i6);
        mutableObjectIntMap.set(k11, i10);
        mutableObjectIntMap.set(k12, i11);
        mutableObjectIntMap.set(k13, i12);
        return mutableObjectIntMap;
    }

    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf(K k5, int i) {
        MutableObjectIntMap<K> mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
        mutableObjectIntMap.set(k5, i);
        return mutableObjectIntMap;
    }

    public static final <K> ObjectIntMap<K> objectIntMapOf(K k5, int i, K k10, int i6) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
        mutableObjectIntMap.set(k5, i);
        mutableObjectIntMap.set(k10, i6);
        return mutableObjectIntMap;
    }

    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf(K k5, int i, K k10, int i6) {
        MutableObjectIntMap<K> mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
        mutableObjectIntMap.set(k5, i);
        mutableObjectIntMap.set(k10, i6);
        return mutableObjectIntMap;
    }

    public static final <K> ObjectIntMap<K> objectIntMapOf(K k5, int i, K k10, int i6, K k11, int i10) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
        mutableObjectIntMap.set(k5, i);
        mutableObjectIntMap.set(k10, i6);
        mutableObjectIntMap.set(k11, i10);
        return mutableObjectIntMap;
    }

    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf(K k5, int i, K k10, int i6, K k11, int i10) {
        MutableObjectIntMap<K> mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
        mutableObjectIntMap.set(k5, i);
        mutableObjectIntMap.set(k10, i6);
        mutableObjectIntMap.set(k11, i10);
        return mutableObjectIntMap;
    }

    public static final <K> ObjectIntMap<K> objectIntMapOf(K k5, int i, K k10, int i6, K k11, int i10, K k12, int i11) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
        mutableObjectIntMap.set(k5, i);
        mutableObjectIntMap.set(k10, i6);
        mutableObjectIntMap.set(k11, i10);
        mutableObjectIntMap.set(k12, i11);
        return mutableObjectIntMap;
    }

    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf(K k5, int i, K k10, int i6, K k11, int i10, K k12, int i11) {
        MutableObjectIntMap<K> mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
        mutableObjectIntMap.set(k5, i);
        mutableObjectIntMap.set(k10, i6);
        mutableObjectIntMap.set(k11, i10);
        mutableObjectIntMap.set(k12, i11);
        return mutableObjectIntMap;
    }

    public static final <K> ObjectIntMap<K> objectIntMapOf(K k5, int i) {
        MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
        mutableObjectIntMap.set(k5, i);
        return mutableObjectIntMap;
    }

    public static final <K> MutableObjectIntMap<K> mutableObjectIntMapOf() {
        return new MutableObjectIntMap<>(0, 1, null);
    }
}
