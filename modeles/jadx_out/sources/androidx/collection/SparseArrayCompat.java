package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import q6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class SparseArrayCompat<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ int[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public SparseArrayCompat(int i) {
        if (i == 0) {
            this.keys = ContainerHelpersKt.EMPTY_INTS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i);
            this.keys = new int[idealIntArraySize];
            this.values = new Object[idealIntArraySize];
        }
    }

    public void append(int i, E e10) {
        int i6 = this.size;
        if (i6 != 0 && i <= this.keys[i6 - 1]) {
            put(i, e10);
            return;
        }
        if (this.garbage && i6 >= this.keys.length) {
            SparseArrayCompatKt.gc(this);
        }
        int i10 = this.size;
        if (i10 >= this.keys.length) {
            int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i10 + 1);
            this.keys = Arrays.copyOf(this.keys, idealIntArraySize);
            this.values = Arrays.copyOf(this.values, idealIntArraySize);
        }
        this.keys[i10] = i;
        this.values[i10] = e10;
        this.size = i10 + 1;
    }

    public void clear() {
        int i = this.size;
        Object[] objArr = this.values;
        for (int i6 = 0; i6 < i; i6++) {
            objArr[i6] = null;
        }
        this.size = 0;
        this.garbage = false;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SparseArrayCompat<E> m31clone() {
        Object clone = super.clone();
        clone.getClass();
        SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) clone;
        sparseArrayCompat.keys = (int[]) this.keys.clone();
        sparseArrayCompat.values = (Object[]) this.values.clone();
        return sparseArrayCompat;
    }

    public boolean containsKey(int i) {
        return indexOfKey(i) >= 0;
    }

    public boolean containsValue(E e10) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        int i = this.size;
        int i6 = 0;
        while (true) {
            if (i6 >= i) {
                i6 = -1;
                break;
            }
            if (this.values[i6] == e10) {
                break;
            }
            i6++;
        }
        return i6 >= 0;
    }

    public void delete(int i) {
        remove(i);
    }

    public E get(int i) {
        return (E) SparseArrayCompatKt.commonGet(this, i);
    }

    public final boolean getIsEmpty() {
        return isEmpty();
    }

    public int indexOfKey(int i) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, i);
    }

    public int indexOfValue(E e10) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        int i = this.size;
        for (int i6 = 0; i6 < i; i6++) {
            if (this.values[i6] == e10) {
                return i6;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int keyAt(int i) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.keys[i];
    }

    public void put(int i, E e10) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, i);
        if (binarySearch >= 0) {
            this.values[binarySearch] = e10;
            return;
        }
        int i6 = ~binarySearch;
        if (i6 < this.size && this.values[i6] == SparseArrayCompatKt.DELETED) {
            this.keys[i6] = i;
            this.values[i6] = e10;
            return;
        }
        if (this.garbage && this.size >= this.keys.length) {
            SparseArrayCompatKt.gc(this);
            i6 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, i);
        }
        int i10 = this.size;
        if (i10 >= this.keys.length) {
            int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i10 + 1);
            this.keys = Arrays.copyOf(this.keys, idealIntArraySize);
            this.values = Arrays.copyOf(this.values, idealIntArraySize);
        }
        int i11 = this.size;
        if (i11 - i6 != 0) {
            int[] iArr = this.keys;
            int i12 = i6 + 1;
            j.X(i12, i6, iArr, iArr, i11);
            Object[] objArr = this.values;
            j.W(i12, i6, this.size, objArr, objArr);
        }
        this.keys[i6] = i;
        this.values[i6] = e10;
        this.size++;
    }

    public void putAll(SparseArrayCompat<? extends E> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArrayCompat.keyAt(i);
            E valueAt = sparseArrayCompat.valueAt(i);
            int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, keyAt);
            if (binarySearch >= 0) {
                this.values[binarySearch] = valueAt;
            } else {
                int i6 = ~binarySearch;
                if (i6 >= this.size || this.values[i6] != SparseArrayCompatKt.DELETED) {
                    if (this.garbage && this.size >= this.keys.length) {
                        SparseArrayCompatKt.gc(this);
                        i6 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, keyAt);
                    }
                    int i10 = this.size;
                    if (i10 >= this.keys.length) {
                        int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i10 + 1);
                        this.keys = Arrays.copyOf(this.keys, idealIntArraySize);
                        this.values = Arrays.copyOf(this.values, idealIntArraySize);
                    }
                    int i11 = this.size;
                    if (i11 - i6 != 0) {
                        int[] iArr = this.keys;
                        int i12 = i6 + 1;
                        j.X(i12, i6, iArr, iArr, i11);
                        Object[] objArr = this.values;
                        j.W(i12, i6, this.size, objArr, objArr);
                    }
                    this.keys[i6] = keyAt;
                    this.values[i6] = valueAt;
                    this.size++;
                } else {
                    this.keys[i6] = keyAt;
                    this.values[i6] = valueAt;
                }
            }
        }
    }

    public E putIfAbsent(int i, E e10) {
        E e11 = (E) SparseArrayCompatKt.commonGet(this, i);
        if (e11 == null) {
            int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, i);
            if (binarySearch >= 0) {
                this.values[binarySearch] = e10;
                return e11;
            }
            int i6 = ~binarySearch;
            if (i6 < this.size && this.values[i6] == SparseArrayCompatKt.DELETED) {
                this.keys[i6] = i;
                this.values[i6] = e10;
                return e11;
            }
            if (this.garbage && this.size >= this.keys.length) {
                SparseArrayCompatKt.gc(this);
                i6 = ~ContainerHelpersKt.binarySearch(this.keys, this.size, i);
            }
            int i10 = this.size;
            if (i10 >= this.keys.length) {
                int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i10 + 1);
                this.keys = Arrays.copyOf(this.keys, idealIntArraySize);
                this.values = Arrays.copyOf(this.values, idealIntArraySize);
            }
            int i11 = this.size;
            if (i11 - i6 != 0) {
                int[] iArr = this.keys;
                int i12 = i6 + 1;
                j.X(i12, i6, iArr, iArr, i11);
                Object[] objArr = this.values;
                j.W(i12, i6, this.size, objArr, objArr);
            }
            this.keys[i6] = i;
            this.values[i6] = e10;
            this.size++;
        }
        return e11;
    }

    public boolean remove(int i, Object obj) {
        int indexOfKey = indexOfKey(i);
        if (indexOfKey < 0 || !l.a(obj, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public void removeAt(int i) {
        if (this.values[i] != SparseArrayCompatKt.DELETED) {
            this.values[i] = SparseArrayCompatKt.DELETED;
            this.garbage = true;
        }
    }

    public void removeAtRange(int i, int i6) {
        int min = Math.min(i6, i + i6);
        while (i < min) {
            removeAt(i);
            i++;
        }
    }

    public boolean replace(int i, E e10, E e11) {
        int indexOfKey = indexOfKey(i);
        if (indexOfKey < 0 || !l.a(this.values[indexOfKey], e10)) {
            return false;
        }
        this.values[indexOfKey] = e11;
        return true;
    }

    public void setValueAt(int i, E e10) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        this.values[i] = e10;
    }

    public int size() {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return this.size;
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i = this.size;
        for (int i6 = 0; i6 < i; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(keyAt(i6));
            sb.append('=');
            E valueAt = valueAt(i6);
            if (valueAt != this) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E valueAt(int i) {
        if (this.garbage) {
            SparseArrayCompatKt.gc(this);
        }
        return (E) this.values[i];
    }

    public E get(int i, E e10) {
        return (E) SparseArrayCompatKt.commonGet(this, i, e10);
    }

    public void remove(int i) {
        SparseArrayCompatKt.commonRemove(this, i);
    }

    public E replace(int i, E e10) {
        int indexOfKey = indexOfKey(i);
        if (indexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.values;
        E e11 = (E) objArr[indexOfKey];
        objArr[indexOfKey] = e10;
        return e11;
    }

    public SparseArrayCompat() {
        this(0, 1, null);
    }

    public /* synthetic */ SparseArrayCompat(int i, int i6, g gVar) {
        this((i6 & 1) != 0 ? 10 : i);
    }
}
