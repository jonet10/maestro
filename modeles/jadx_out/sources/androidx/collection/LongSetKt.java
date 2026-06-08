package androidx.collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LongSetKt {
    private static final MutableLongSet EmptyLongSet = new MutableLongSet(0);
    private static final long[] EmptyLongArray = new long[0];

    public static final LongSet emptyLongSet() {
        return EmptyLongSet;
    }

    public static final long[] getEmptyLongArray() {
        return EmptyLongArray;
    }

    public static final int hash(long j) {
        int i = ((int) (j ^ (j >>> 32))) * ScatterMapKt.MurmurHashC1;
        return i ^ (i << 16);
    }

    public static final LongSet longSetOf(long... jArr) {
        jArr.getClass();
        MutableLongSet mutableLongSet = new MutableLongSet(jArr.length);
        mutableLongSet.plusAssign(jArr);
        return mutableLongSet;
    }

    public static final MutableLongSet mutableLongSetOf(long j, long j6, long j10) {
        MutableLongSet mutableLongSet = new MutableLongSet(3);
        mutableLongSet.plusAssign(j);
        mutableLongSet.plusAssign(j6);
        mutableLongSet.plusAssign(j10);
        return mutableLongSet;
    }

    public static final LongSet longSetOf(long j) {
        return mutableLongSetOf(j);
    }

    public static final LongSet longSetOf(long j, long j6) {
        return mutableLongSetOf(j, j6);
    }

    public static final LongSet longSetOf(long j, long j6, long j10) {
        return mutableLongSetOf(j, j6, j10);
    }

    public static final LongSet longSetOf() {
        return EmptyLongSet;
    }

    public static final MutableLongSet mutableLongSetOf(long j) {
        MutableLongSet mutableLongSet = new MutableLongSet(1);
        mutableLongSet.plusAssign(j);
        return mutableLongSet;
    }

    public static final MutableLongSet mutableLongSetOf(long j, long j6) {
        MutableLongSet mutableLongSet = new MutableLongSet(2);
        mutableLongSet.plusAssign(j);
        mutableLongSet.plusAssign(j6);
        return mutableLongSet;
    }

    public static final MutableLongSet mutableLongSetOf() {
        return new MutableLongSet(0, 1, null);
    }

    public static final MutableLongSet mutableLongSetOf(long... jArr) {
        jArr.getClass();
        MutableLongSet mutableLongSet = new MutableLongSet(jArr.length);
        mutableLongSet.plusAssign(jArr);
        return mutableLongSet;
    }
}
