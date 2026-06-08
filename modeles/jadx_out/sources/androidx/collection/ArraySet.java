package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import e7.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.g;
import q6.j;
import q6.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E>, b {
    private int _size;
    private Object[] array;
    private int[] hashes;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public final class ElementIterator extends IndexBasedArrayIterator<E> {
        public ElementIterator() {
            super(ArraySet.this.get_size$collection());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public E elementAt(int i) {
            return ArraySet.this.valueAt(i);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        public void removeAt(int i) {
            ArraySet.this.removeAt(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ArraySet(E[] eArr) {
        this(0);
        if (eArr != null) {
            kotlin.jvm.internal.b bVar = new kotlin.jvm.internal.b(eArr);
            while (bVar.hasNext()) {
                add(bVar.next());
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e10) {
        int i;
        int indexOf;
        int i6 = get_size$collection();
        if (e10 == null) {
            indexOf = ArraySetKt.indexOfNull(this);
            i = 0;
        } else {
            int hashCode = e10.hashCode();
            i = hashCode;
            indexOf = ArraySetKt.indexOf(this, e10, hashCode);
        }
        if (indexOf >= 0) {
            return false;
        }
        int i10 = ~indexOf;
        if (i6 >= getHashes$collection().length) {
            int i11 = 8;
            if (i6 >= 8) {
                i11 = (i6 >> 1) + i6;
            } else if (i6 < 4) {
                i11 = 4;
            }
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i11);
            if (i6 != get_size$collection()) {
                a3.b.i();
                return false;
            }
            if (getHashes$collection().length != 0) {
                j.b0(0, hashes$collection.length, hashes$collection, getHashes$collection(), 6);
                j.c0(array$collection, getArray$collection(), 0, 0, array$collection.length, 6);
            }
        }
        if (i10 < i6) {
            int i12 = i10 + 1;
            j.X(i12, i10, getHashes$collection(), getHashes$collection(), i6);
            j.W(i12, i10, i6, getArray$collection(), getArray$collection());
        }
        if (i6 != get_size$collection() || i10 >= getHashes$collection().length) {
            a3.b.i();
            return false;
        }
        getHashes$collection()[i10] = i;
        getArray$collection()[i10] = e10;
        set_size$collection(get_size$collection() + 1);
        return true;
    }

    public final void addAll(ArraySet<? extends E> arraySet) {
        arraySet.getClass();
        int i = arraySet.get_size$collection();
        ensureCapacity(get_size$collection() + i);
        if (get_size$collection() != 0) {
            for (int i6 = 0; i6 < i; i6++) {
                add(arraySet.valueAt(i6));
            }
        } else if (i > 0) {
            j.b0(0, i, arraySet.getHashes$collection(), getHashes$collection(), 6);
            j.c0(arraySet.getArray$collection(), getArray$collection(), 0, 0, i, 6);
            if (get_size$collection() == 0) {
                set_size$collection(i);
            } else {
                a3.b.i();
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (get_size$collection() != 0) {
            setHashes$collection(ContainerHelpersKt.EMPTY_INTS);
            setArray$collection(ContainerHelpersKt.EMPTY_OBJECTS);
            set_size$collection(0);
        }
        if (get_size$collection() == 0) {
            return;
        }
        a3.b.i();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> collection) {
        collection.getClass();
        Iterator<? extends Object> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final void ensureCapacity(int i) {
        int i6 = get_size$collection();
        if (getHashes$collection().length < i) {
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i);
            if (get_size$collection() > 0) {
                j.b0(0, get_size$collection(), hashes$collection, getHashes$collection(), 6);
                j.c0(array$collection, getArray$collection(), 0, 0, get_size$collection(), 6);
            }
        }
        if (get_size$collection() == i6) {
            return;
        }
        a3.b.i();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int i = get_size$collection();
            for (int i6 = 0; i6 < i; i6++) {
                if (!((Set) obj).contains(valueAt(i6))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final Object[] getArray$collection() {
        return this.array;
    }

    public final int[] getHashes$collection() {
        return this.hashes;
    }

    public int getSize() {
        return this._size;
    }

    public final int get_size$collection() {
        return this._size;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] hashes$collection = getHashes$collection();
        int i = get_size$collection();
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            i6 += hashes$collection[i10];
        }
        return i6;
    }

    public final int indexOf(Object obj) {
        return obj == null ? ArraySetKt.indexOfNull(this) : ArraySetKt.indexOf(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return get_size$collection() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(ArraySet<? extends E> arraySet) {
        arraySet.getClass();
        int i = arraySet.get_size$collection();
        int i6 = get_size$collection();
        for (int i10 = 0; i10 < i; i10++) {
            remove(arraySet.valueAt(i10));
        }
        return i6 != get_size$collection();
    }

    public final E removeAt(int i) {
        int i6;
        int i10 = get_size$collection();
        E e10 = (E) getArray$collection()[i];
        if (i10 <= 1) {
            clear();
            return e10;
        }
        int i11 = i10 - 1;
        if (getHashes$collection().length <= 8 || get_size$collection() >= getHashes$collection().length / 3) {
            if (i < i11) {
                int i12 = i + 1;
                j.X(i, i12, getHashes$collection(), getHashes$collection(), i10);
                j.W(i, i12, i10, getArray$collection(), getArray$collection());
            }
            getArray$collection()[i11] = null;
        } else {
            int i13 = get_size$collection() > 8 ? get_size$collection() + (get_size$collection() >> 1) : 8;
            int[] hashes$collection = getHashes$collection();
            Object[] array$collection = getArray$collection();
            ArraySetKt.allocArrays(this, i13);
            if (i > 0) {
                j.b0(0, i, hashes$collection, getHashes$collection(), 6);
                i6 = i;
                j.c0(array$collection, getArray$collection(), 0, 0, i6, 6);
            } else {
                i6 = i;
            }
            if (i6 < i11) {
                int i14 = i6 + 1;
                j.X(i6, i14, hashes$collection, getHashes$collection(), i10);
                j.W(i6, i14, i10, array$collection, getArray$collection());
            }
        }
        if (i10 == get_size$collection()) {
            set_size$collection(i11);
            return e10;
        }
        a3.b.i();
        return null;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        collection.getClass();
        boolean z9 = false;
        for (int i = get_size$collection() - 1; -1 < i; i--) {
            if (!l.o0(collection, getArray$collection()[i])) {
                removeAt(i);
                z9 = true;
            }
        }
        return z9;
    }

    public final void setArray$collection(Object[] objArr) {
        objArr.getClass();
        this.array = objArr;
    }

    public final void setHashes$collection(int[] iArr) {
        iArr.getClass();
        this.hashes = iArr;
    }

    public final void set_size$collection(int i) {
        this._size = i;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] tArr) {
        tArr.getClass();
        T[] tArr2 = (T[]) ArraySetJvmUtil.resizeForToArray(tArr, this._size);
        j.W(0, 0, this._size, this.array, tArr2);
        return tArr2;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(get_size$collection() * 14);
        sb.append('{');
        int i = get_size$collection();
        for (int i6 = 0; i6 < i; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            E valueAt = valueAt(i6);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public final E valueAt(int i) {
        return (E) getArray$collection()[i];
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return j.d0(this.array, 0, this._size);
    }

    public ArraySet(int i) {
        this.hashes = ContainerHelpersKt.EMPTY_INTS;
        this.array = ContainerHelpersKt.EMPTY_OBJECTS;
        if (i > 0) {
            ArraySetKt.allocArrays(this, i);
        }
    }

    public /* synthetic */ ArraySet(int i, int i6, g gVar) {
        this((i6 & 1) != 0 ? 0 : i);
    }

    public ArraySet(ArraySet<? extends E> arraySet) {
        this(0);
        if (arraySet != null) {
            addAll((ArraySet) arraySet);
        }
    }

    public ArraySet(Collection<? extends E> collection) {
        this(0);
        if (collection != null) {
            addAll(collection);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        collection.getClass();
        Iterator<? extends Object> it = collection.iterator();
        boolean z9 = false;
        while (it.hasNext()) {
            z9 |= remove(it.next());
        }
        return z9;
    }

    public ArraySet() {
        this(0, 1, null);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        collection.getClass();
        ensureCapacity(collection.size() + get_size$collection());
        Iterator<? extends E> it = collection.iterator();
        boolean z9 = false;
        while (it.hasNext()) {
            z9 |= add(it.next());
        }
        return z9;
    }
}
