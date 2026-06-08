package androidx.collection;

import a4.x;
import com.google.gson.internal.a;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ObjectListKt {
    private static final Object[] EmptyArray = new Object[0];
    private static final ObjectList<Object> EmptyObjectList = new MutableObjectList(0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkIndex(List<?> list, int i) {
        int size = list.size();
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index " + i + " is out of bounds. The list has " + size + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkSubIndex(List<?> list, int i, int i6) {
        int size = list.size();
        if (i > i6) {
            throw new IllegalArgumentException("Indices are out of order. fromIndex (" + i + ") is greater than toIndex (" + i6 + ").");
        }
        if (i < 0) {
            a.r(x.g(i, "fromIndex (", ") is less than 0."));
            return;
        }
        if (i6 <= size) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i6 + ") is more than than the list size (" + size + ')');
    }

    public static final <E> ObjectList<E> emptyObjectList() {
        ObjectList<E> objectList = (ObjectList<E>) EmptyObjectList;
        objectList.getClass();
        return objectList;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E e10, E e11, E e12) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(3);
        mutableObjectList.add(e10);
        mutableObjectList.add(e11);
        mutableObjectList.add(e12);
        return mutableObjectList;
    }

    public static final <E> ObjectList<E> objectListOf(E... eArr) {
        eArr.getClass();
        MutableObjectList mutableObjectList = new MutableObjectList(eArr.length);
        mutableObjectList.plusAssign((Object[]) eArr);
        return mutableObjectList;
    }

    public static final <E> ObjectList<E> objectListOf(E e10) {
        return mutableObjectListOf(e10);
    }

    public static final <E> ObjectList<E> objectListOf(E e10, E e11) {
        return mutableObjectListOf(e10, e11);
    }

    public static final <E> ObjectList<E> objectListOf(E e10, E e11, E e12) {
        return mutableObjectListOf(e10, e11, e12);
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E e10) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(1);
        mutableObjectList.add(e10);
        return mutableObjectList;
    }

    public static final <E> ObjectList<E> objectListOf() {
        ObjectList<E> objectList = (ObjectList<E>) EmptyObjectList;
        objectList.getClass();
        return objectList;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E e10, E e11) {
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(2);
        mutableObjectList.add(e10);
        mutableObjectList.add(e11);
        return mutableObjectList;
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf() {
        return new MutableObjectList<>(0, 1, null);
    }

    public static final <E> MutableObjectList<E> mutableObjectListOf(E... eArr) {
        eArr.getClass();
        MutableObjectList<E> mutableObjectList = new MutableObjectList<>(eArr.length);
        mutableObjectList.plusAssign((Object[]) eArr);
        return mutableObjectList;
    }
}
