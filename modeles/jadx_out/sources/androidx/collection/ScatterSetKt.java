package androidx.collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ScatterSetKt {
    private static final MutableScatterSet<Object> EmptyScatterSet = new MutableScatterSet<>(0);

    public static final <E> ScatterSet<E> emptyScatterSet() {
        MutableScatterSet<Object> mutableScatterSet = EmptyScatterSet;
        mutableScatterSet.getClass();
        return mutableScatterSet;
    }

    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E e10, E e11, E e12) {
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(3);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e10);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e11);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e12);
        return mutableScatterSet;
    }

    public static final <E> ScatterSet<E> scatterSetOf(E... eArr) {
        eArr.getClass();
        MutableScatterSet mutableScatterSet = new MutableScatterSet(eArr.length);
        mutableScatterSet.plusAssign((Object[]) eArr);
        return mutableScatterSet;
    }

    public static final <E> ScatterSet<E> scatterSetOf(E e10) {
        return mutableScatterSetOf(e10);
    }

    public static final <E> ScatterSet<E> scatterSetOf(E e10, E e11) {
        return mutableScatterSetOf(e10, e11);
    }

    public static final <E> ScatterSet<E> scatterSetOf(E e10, E e11, E e12) {
        return mutableScatterSetOf(e10, e11, e12);
    }

    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E e10) {
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(1);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e10);
        return mutableScatterSet;
    }

    public static final <E> ScatterSet<E> scatterSetOf() {
        MutableScatterSet<Object> mutableScatterSet = EmptyScatterSet;
        mutableScatterSet.getClass();
        return mutableScatterSet;
    }

    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E e10, E e11) {
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(2);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e10);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e11);
        return mutableScatterSet;
    }

    public static final <E> MutableScatterSet<E> mutableScatterSetOf() {
        return new MutableScatterSet<>(0, 1, null);
    }

    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E... eArr) {
        eArr.getClass();
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(eArr.length);
        mutableScatterSet.plusAssign((Object[]) eArr);
        return mutableScatterSet;
    }
}
