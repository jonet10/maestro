package androidx.collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LongListKt {
    private static final LongList EmptyLongList = new MutableLongList(0);

    public static final LongList emptyLongList() {
        return EmptyLongList;
    }

    public static final LongList longListOf(long... jArr) {
        jArr.getClass();
        MutableLongList mutableLongList = new MutableLongList(jArr.length);
        mutableLongList.plusAssign(jArr);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf(long j, long j6, long j10) {
        MutableLongList mutableLongList = new MutableLongList(3);
        mutableLongList.add(j);
        mutableLongList.add(j6);
        mutableLongList.add(j10);
        return mutableLongList;
    }

    public static final LongList longListOf(long j) {
        return mutableLongListOf(j);
    }

    public static final LongList longListOf(long j, long j6) {
        return mutableLongListOf(j, j6);
    }

    public static final LongList longListOf(long j, long j6, long j10) {
        return mutableLongListOf(j, j6, j10);
    }

    public static final LongList longListOf() {
        return EmptyLongList;
    }

    public static final MutableLongList mutableLongListOf(long j) {
        MutableLongList mutableLongList = new MutableLongList(1);
        mutableLongList.add(j);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf(long j, long j6) {
        MutableLongList mutableLongList = new MutableLongList(2);
        mutableLongList.add(j);
        mutableLongList.add(j6);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf() {
        return new MutableLongList(0, 1, null);
    }

    public static final MutableLongList mutableLongListOf(long... jArr) {
        jArr.getClass();
        MutableLongList mutableLongList = new MutableLongList(jArr.length);
        mutableLongList.plusAssign(jArr);
        return mutableLongList;
    }
}
