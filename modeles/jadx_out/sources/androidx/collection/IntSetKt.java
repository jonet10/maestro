package androidx.collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class IntSetKt {
    private static final MutableIntSet EmptyIntSet = new MutableIntSet(0);
    private static final int[] EmptyIntArray = new int[0];

    public static final IntSet emptyIntSet() {
        return EmptyIntSet;
    }

    public static final int[] getEmptyIntArray() {
        return EmptyIntArray;
    }

    public static final int hash(int i) {
        int i6 = i * ScatterMapKt.MurmurHashC1;
        return i6 ^ (i6 << 16);
    }

    public static final IntSet intSetOf(int... iArr) {
        iArr.getClass();
        MutableIntSet mutableIntSet = new MutableIntSet(iArr.length);
        mutableIntSet.plusAssign(iArr);
        return mutableIntSet;
    }

    public static final MutableIntSet mutableIntSetOf(int i, int i6, int i10) {
        MutableIntSet mutableIntSet = new MutableIntSet(3);
        mutableIntSet.plusAssign(i);
        mutableIntSet.plusAssign(i6);
        mutableIntSet.plusAssign(i10);
        return mutableIntSet;
    }

    public static final IntSet intSetOf(int i) {
        return mutableIntSetOf(i);
    }

    public static final IntSet intSetOf(int i, int i6) {
        return mutableIntSetOf(i, i6);
    }

    public static final IntSet intSetOf(int i, int i6, int i10) {
        return mutableIntSetOf(i, i6, i10);
    }

    public static final IntSet intSetOf() {
        return EmptyIntSet;
    }

    public static final MutableIntSet mutableIntSetOf(int i) {
        MutableIntSet mutableIntSet = new MutableIntSet(1);
        mutableIntSet.plusAssign(i);
        return mutableIntSet;
    }

    public static final MutableIntSet mutableIntSetOf(int i, int i6) {
        MutableIntSet mutableIntSet = new MutableIntSet(2);
        mutableIntSet.plusAssign(i);
        mutableIntSet.plusAssign(i6);
        return mutableIntSet;
    }

    public static final MutableIntSet mutableIntSetOf() {
        return new MutableIntSet(0, 1, null);
    }

    public static final MutableIntSet mutableIntSetOf(int... iArr) {
        iArr.getClass();
        MutableIntSet mutableIntSet = new MutableIntSet(iArr.length);
        mutableIntSet.plusAssign(iArr);
        return mutableIntSet;
    }
}
