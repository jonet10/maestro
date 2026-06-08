package androidx.collection;

import a3.b;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.l;
import q6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ArraySetKt {
    public static final int ARRAY_SET_BASE_SIZE = 4;

    public static final <E> void addAllInternal(ArraySet<E> arraySet, ArraySet<? extends E> arraySet2) {
        arraySet.getClass();
        arraySet2.getClass();
        int i = arraySet2.get_size$collection();
        arraySet.ensureCapacity(arraySet.get_size$collection() + i);
        if (arraySet.get_size$collection() != 0) {
            for (int i6 = 0; i6 < i; i6++) {
                arraySet.add(arraySet2.valueAt(i6));
            }
        } else if (i > 0) {
            j.b0(0, i, arraySet2.getHashes$collection(), arraySet.getHashes$collection(), 6);
            j.c0(arraySet2.getArray$collection(), arraySet.getArray$collection(), 0, 0, i, 6);
            if (arraySet.get_size$collection() == 0) {
                arraySet.set_size$collection(i);
            } else {
                b.i();
            }
        }
    }

    public static final <E> boolean addInternal(ArraySet<E> arraySet, E e10) {
        int i;
        int indexOf;
        arraySet.getClass();
        int i6 = arraySet.get_size$collection();
        if (e10 == null) {
            indexOf = indexOfNull(arraySet);
            i = 0;
        } else {
            int hashCode = e10.hashCode();
            i = hashCode;
            indexOf = indexOf(arraySet, e10, hashCode);
        }
        if (indexOf >= 0) {
            return false;
        }
        int i10 = ~indexOf;
        if (i6 >= arraySet.getHashes$collection().length) {
            int i11 = 8;
            if (i6 >= 8) {
                i11 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i11 = 4;
            }
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i11);
            if (i6 != arraySet.get_size$collection()) {
                b.i();
                return false;
            }
            if (arraySet.getHashes$collection().length != 0) {
                j.b0(0, hashes$collection.length, hashes$collection, arraySet.getHashes$collection(), 6);
                j.c0(array$collection, arraySet.getArray$collection(), 0, 0, array$collection.length, 6);
            }
        }
        if (i10 < i6) {
            int i12 = i10 + 1;
            j.X(i12, i10, arraySet.getHashes$collection(), arraySet.getHashes$collection(), i6);
            j.W(i12, i10, i6, arraySet.getArray$collection(), arraySet.getArray$collection());
        }
        if (i6 != arraySet.get_size$collection() || i10 >= arraySet.getHashes$collection().length) {
            b.i();
            return false;
        }
        arraySet.getHashes$collection()[i10] = i;
        arraySet.getArray$collection()[i10] = e10;
        arraySet.set_size$collection(arraySet.get_size$collection() + 1);
        return true;
    }

    public static final <E> void allocArrays(ArraySet<E> arraySet, int i) {
        arraySet.getClass();
        arraySet.setHashes$collection(new int[i]);
        arraySet.setArray$collection(new Object[i]);
    }

    public static final <T> ArraySet<T> arraySetOf(T... tArr) {
        tArr.getClass();
        ArraySet<T> arraySet = new ArraySet<>(tArr.length);
        for (T t9 : tArr) {
            arraySet.add(t9);
        }
        return arraySet;
    }

    public static final <E> int binarySearchInternal(ArraySet<E> arraySet, int i) {
        arraySet.getClass();
        try {
            return ContainerHelpersKt.binarySearch(arraySet.getHashes$collection(), arraySet.get_size$collection(), i);
        } catch (IndexOutOfBoundsException unused) {
            b.i();
            return 0;
        }
    }

    public static final <E> void clearInternal(ArraySet<E> arraySet) {
        arraySet.getClass();
        if (arraySet.get_size$collection() != 0) {
            arraySet.setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            arraySet.setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            arraySet.set_size$collection(0);
        }
        if (arraySet.get_size$collection() == 0) {
            return;
        }
        b.i();
    }

    public static final <E> boolean containsAllInternal(ArraySet<E> arraySet, Collection<? extends E> collection) {
        arraySet.getClass();
        collection.getClass();
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            if (!arraySet.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static final <E> boolean containsInternal(ArraySet<E> arraySet, E e10) {
        arraySet.getClass();
        return arraySet.indexOf(e10) >= 0;
    }

    public static final <E> void ensureCapacityInternal(ArraySet<E> arraySet, int i) {
        arraySet.getClass();
        int i6 = arraySet.get_size$collection();
        if (arraySet.getHashes$collection().length < i) {
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i);
            if (arraySet.get_size$collection() > 0) {
                j.b0(0, arraySet.get_size$collection(), hashes$collection, arraySet.getHashes$collection(), 6);
                j.c0(array$collection, arraySet.getArray$collection(), 0, 0, arraySet.get_size$collection(), 6);
            }
        }
        if (arraySet.get_size$collection() == i6) {
            return;
        }
        b.i();
    }

    public static final <E> boolean equalsInternal(ArraySet<E> arraySet, Object obj) {
        arraySet.getClass();
        if (arraySet == obj) {
            return true;
        }
        if (!(obj instanceof Set) || arraySet.size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i = arraySet.get_size$collection();
            for (int i6 = 0; i6 < i; i6++) {
                if (!((Set) obj).contains(arraySet.valueAt(i6))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static final <E> int hashCodeInternal(ArraySet<E> arraySet) {
        arraySet.getClass();
        int[] hashes$collection = arraySet.getHashes$collection();
        int i = arraySet.get_size$collection();
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            i6 += hashes$collection[i10];
        }
        return i6;
    }

    public static final <E> int indexOf(ArraySet<E> arraySet, Object obj, int i) {
        arraySet.getClass();
        int i6 = arraySet.get_size$collection();
        if (i6 == 0) {
            return -1;
        }
        int binarySearchInternal = binarySearchInternal(arraySet, i);
        if (binarySearchInternal < 0 || l.a(obj, arraySet.getArray$collection()[binarySearchInternal])) {
            return binarySearchInternal;
        }
        int i10 = binarySearchInternal + 1;
        while (i10 < i6 && arraySet.getHashes$collection()[i10] == i) {
            if (l.a(obj, arraySet.getArray$collection()[i10])) {
                return i10;
            }
            i10++;
        }
        for (int i11 = binarySearchInternal - 1; i11 >= 0 && arraySet.getHashes$collection()[i11] == i; i11--) {
            if (l.a(obj, arraySet.getArray$collection()[i11])) {
                return i11;
            }
        }
        return ~i10;
    }

    public static final <E> int indexOfInternal(ArraySet<E> arraySet, Object obj) {
        arraySet.getClass();
        return obj == null ? indexOfNull(arraySet) : indexOf(arraySet, obj, obj.hashCode());
    }

    public static final <E> int indexOfNull(ArraySet<E> arraySet) {
        arraySet.getClass();
        return indexOf(arraySet, null, 0);
    }

    public static final <E> boolean isEmptyInternal(ArraySet<E> arraySet) {
        arraySet.getClass();
        return arraySet.get_size$collection() <= 0;
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> arraySet, ArraySet<? extends E> arraySet2) {
        arraySet.getClass();
        arraySet2.getClass();
        int i = arraySet2.get_size$collection();
        int i6 = arraySet.get_size$collection();
        for (int i10 = 0; i10 < i; i10++) {
            arraySet.remove(arraySet2.valueAt(i10));
        }
        return i6 != arraySet.get_size$collection();
    }

    public static final <E> E removeAtInternal(ArraySet<E> arraySet, int i) {
        int i6;
        arraySet.getClass();
        int i10 = arraySet.get_size$collection();
        E e10 = (E) arraySet.getArray$collection()[i];
        if (i10 <= 1) {
            arraySet.clear();
            return e10;
        }
        int i11 = i10 - 1;
        if (arraySet.getHashes$collection().length <= 8 || arraySet.get_size$collection() >= arraySet.getHashes$collection().length / 3) {
            if (i < i11) {
                int i12 = i + 1;
                j.X(i, i12, arraySet.getHashes$collection(), arraySet.getHashes$collection(), i10);
                j.W(i, i12, i10, arraySet.getArray$collection(), arraySet.getArray$collection());
            }
            arraySet.getArray$collection()[i11] = null;
        } else {
            int i13 = arraySet.get_size$collection() > 8 ? arraySet.get_size$collection() + (arraySet.get_size$collection() >> 1) : 8;
            int[] hashes$collection = arraySet.getHashes$collection();
            Object[] array$collection = arraySet.getArray$collection();
            allocArrays(arraySet, i13);
            if (i > 0) {
                j.b0(0, i, hashes$collection, arraySet.getHashes$collection(), 6);
                i6 = i;
                j.c0(array$collection, arraySet.getArray$collection(), 0, 0, i6, 6);
            } else {
                i6 = i;
            }
            if (i6 < i11) {
                int i14 = i6 + 1;
                j.X(i6, i14, hashes$collection, arraySet.getHashes$collection(), i10);
                j.W(i6, i14, i10, array$collection, arraySet.getArray$collection());
            }
        }
        if (i10 == arraySet.get_size$collection()) {
            arraySet.set_size$collection(i11);
            return e10;
        }
        b.i();
        return null;
    }

    public static final <E> boolean removeInternal(ArraySet<E> arraySet, E e10) {
        arraySet.getClass();
        int indexOf = arraySet.indexOf(e10);
        if (indexOf < 0) {
            return false;
        }
        arraySet.removeAt(indexOf);
        return true;
    }

    public static final <E> boolean retainAllInternal(ArraySet<E> arraySet, Collection<? extends E> collection) {
        arraySet.getClass();
        collection.getClass();
        boolean z9 = false;
        for (int i = arraySet.get_size$collection() - 1; -1 < i; i--) {
            if (!q6.l.o0(collection, arraySet.getArray$collection()[i])) {
                arraySet.removeAt(i);
                z9 = true;
            }
        }
        return z9;
    }

    public static final <E> String toStringInternal(ArraySet<E> arraySet) {
        arraySet.getClass();
        if (arraySet.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(arraySet.get_size$collection() * 14);
        sb.append('{');
        int i = arraySet.get_size$collection();
        for (int i6 = 0; i6 < i; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            E valueAt = arraySet.valueAt(i6);
            if (valueAt != arraySet) {
                sb.append(valueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public static final <E> E valueAtInternal(ArraySet<E> arraySet, int i) {
        arraySet.getClass();
        return (E) arraySet.getArray$collection()[i];
    }

    public static final <T> ArraySet<T> arraySetOf() {
        return new ArraySet<>(0, 1, null);
    }

    public static final <E> boolean removeAllInternal(ArraySet<E> arraySet, Collection<? extends E> collection) {
        arraySet.getClass();
        collection.getClass();
        Iterator<? extends E> it = collection.iterator();
        boolean z9 = false;
        while (it.hasNext()) {
            z9 |= arraySet.remove(it.next());
        }
        return z9;
    }

    public static final <E> boolean addAllInternal(ArraySet<E> arraySet, Collection<? extends E> collection) {
        arraySet.getClass();
        collection.getClass();
        arraySet.ensureCapacity(collection.size() + arraySet.get_size$collection());
        Iterator<? extends E> it = collection.iterator();
        boolean z9 = false;
        while (it.hasNext()) {
            z9 |= arraySet.add(it.next());
        }
        return z9;
    }
}
