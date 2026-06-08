package androidx.collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class IntListKt {
    private static final IntList EmptyIntList = new MutableIntList(0);

    public static final IntList emptyIntList() {
        return EmptyIntList;
    }

    public static final IntList intListOf(int... iArr) {
        iArr.getClass();
        MutableIntList mutableIntList = new MutableIntList(iArr.length);
        mutableIntList.plusAssign(iArr);
        return mutableIntList;
    }

    public static final MutableIntList mutableIntListOf(int i, int i6, int i10) {
        MutableIntList mutableIntList = new MutableIntList(3);
        mutableIntList.add(i);
        mutableIntList.add(i6);
        mutableIntList.add(i10);
        return mutableIntList;
    }

    public static final IntList intListOf(int i) {
        return mutableIntListOf(i);
    }

    public static final IntList intListOf(int i, int i6) {
        return mutableIntListOf(i, i6);
    }

    public static final IntList intListOf(int i, int i6, int i10) {
        return mutableIntListOf(i, i6, i10);
    }

    public static final IntList intListOf() {
        return EmptyIntList;
    }

    public static final MutableIntList mutableIntListOf(int i) {
        MutableIntList mutableIntList = new MutableIntList(1);
        mutableIntList.add(i);
        return mutableIntList;
    }

    public static final MutableIntList mutableIntListOf(int i, int i6) {
        MutableIntList mutableIntList = new MutableIntList(2);
        mutableIntList.add(i);
        mutableIntList.add(i6);
        return mutableIntList;
    }

    public static final MutableIntList mutableIntListOf() {
        return new MutableIntList(0, 1, null);
    }

    public static final MutableIntList mutableIntListOf(int... iArr) {
        iArr.getClass();
        MutableIntList mutableIntList = new MutableIntList(iArr.length);
        mutableIntList.plusAssign(iArr);
        return mutableIntList;
    }
}
