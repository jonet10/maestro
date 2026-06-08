package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.lifecycle.l;
import java.util.Arrays;
import kotlin.jvm.internal.g;
import q6.j;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class LongSparseArray<E> implements Cloneable {
    public /* synthetic */ boolean garbage;
    public /* synthetic */ long[] keys;
    public /* synthetic */ int size;
    public /* synthetic */ Object[] values;

    public LongSparseArray(int i) {
        if (i == 0) {
            this.keys = ContainerHelpersKt.EMPTY_LONGS;
            this.values = ContainerHelpersKt.EMPTY_OBJECTS;
        } else {
            int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i);
            this.keys = new long[idealLongArraySize];
            this.values = new Object[idealLongArraySize];
        }
    }

    public void append(long j, E e10) {
        int i = this.size;
        if (i != 0 && j <= this.keys[i - 1]) {
            put(j, e10);
            return;
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            if (i >= jArr.length) {
                Object[] objArr = this.values;
                int i6 = 0;
                for (int i10 = 0; i10 < i; i10++) {
                    Object obj = objArr[i10];
                    if (obj != LongSparseArrayKt.DELETED) {
                        if (i10 != i6) {
                            jArr[i6] = jArr[i10];
                            objArr[i6] = obj;
                            objArr[i10] = null;
                        }
                        i6++;
                    }
                }
                this.garbage = false;
                this.size = i6;
            }
        }
        int i11 = this.size;
        if (i11 >= this.keys.length) {
            int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i11 + 1);
            this.keys = Arrays.copyOf(this.keys, idealLongArraySize);
            this.values = Arrays.copyOf(this.values, idealLongArraySize);
        }
        this.keys[i11] = j;
        this.values[i11] = e10;
        this.size = i11 + 1;
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
    public LongSparseArray<E> m30clone() {
        Object clone = super.clone();
        clone.getClass();
        LongSparseArray<E> longSparseArray = (LongSparseArray) clone;
        longSparseArray.keys = (long[]) this.keys.clone();
        longSparseArray.values = (Object[]) this.values.clone();
        return longSparseArray;
    }

    public boolean containsKey(long j) {
        return indexOfKey(j) >= 0;
    }

    public boolean containsValue(E e10) {
        return indexOfValue(e10) >= 0;
    }

    public void delete(long j) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j);
        if (binarySearch < 0 || this.values[binarySearch] == LongSparseArrayKt.DELETED) {
            return;
        }
        this.values[binarySearch] = LongSparseArrayKt.DELETED;
        this.garbage = true;
    }

    public E get(long j) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j);
        if (binarySearch < 0 || this.values[binarySearch] == LongSparseArrayKt.DELETED) {
            return null;
        }
        return (E) this.values[binarySearch];
    }

    public int indexOfKey(long j) {
        if (this.garbage) {
            int i = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i6 = 0;
            for (int i10 = 0; i10 < i; i10++) {
                Object obj = objArr[i10];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i10 != i6) {
                        jArr[i6] = jArr[i10];
                        objArr[i6] = obj;
                        objArr[i10] = null;
                    }
                    i6++;
                }
            }
            this.garbage = false;
            this.size = i6;
        }
        return ContainerHelpersKt.binarySearch(this.keys, this.size, j);
    }

    public int indexOfValue(E e10) {
        if (this.garbage) {
            int i = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i6 = 0;
            for (int i10 = 0; i10 < i; i10++) {
                Object obj = objArr[i10];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i10 != i6) {
                        jArr[i6] = jArr[i10];
                        objArr[i6] = obj;
                        objArr[i10] = null;
                    }
                    i6++;
                }
            }
            this.garbage = false;
            this.size = i6;
        }
        int i11 = this.size;
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.values[i12] == e10) {
                return i12;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public long keyAt(int i) {
        int i6;
        if (i < 0 || i >= (i6 = this.size)) {
            o.o(l.u(i, "Expected index to be within 0..size()-1, but was "));
            return 0L;
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i10 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                Object obj = objArr[i11];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            this.garbage = false;
            this.size = i10;
        }
        return this.keys[i];
    }

    public void put(long j, E e10) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j);
        if (binarySearch >= 0) {
            this.values[binarySearch] = e10;
            return;
        }
        int i = ~binarySearch;
        if (i < this.size && this.values[i] == LongSparseArrayKt.DELETED) {
            this.keys[i] = j;
            this.values[i] = e10;
            return;
        }
        if (this.garbage) {
            int i6 = this.size;
            long[] jArr = this.keys;
            if (i6 >= jArr.length) {
                Object[] objArr = this.values;
                int i10 = 0;
                for (int i11 = 0; i11 < i6; i11++) {
                    Object obj = objArr[i11];
                    if (obj != LongSparseArrayKt.DELETED) {
                        if (i11 != i10) {
                            jArr[i10] = jArr[i11];
                            objArr[i10] = obj;
                            objArr[i11] = null;
                        }
                        i10++;
                    }
                }
                this.garbage = false;
                this.size = i10;
                i = ~ContainerHelpersKt.binarySearch(this.keys, i10, j);
            }
        }
        int i12 = this.size;
        if (i12 >= this.keys.length) {
            int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i12 + 1);
            this.keys = Arrays.copyOf(this.keys, idealLongArraySize);
            this.values = Arrays.copyOf(this.values, idealLongArraySize);
        }
        int i13 = this.size;
        if (i13 - i != 0) {
            long[] jArr2 = this.keys;
            int i14 = i + 1;
            j.a0(jArr2, jArr2, i14, i, i13);
            Object[] objArr2 = this.values;
            j.W(i14, i, this.size, objArr2, objArr2);
        }
        this.keys[i] = j;
        this.values[i] = e10;
        this.size++;
    }

    public void putAll(LongSparseArray<? extends E> longSparseArray) {
        longSparseArray.getClass();
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            put(longSparseArray.keyAt(i), longSparseArray.valueAt(i));
        }
    }

    public E putIfAbsent(long j, E e10) {
        E e11 = get(j);
        if (e11 == null) {
            put(j, e10);
        }
        return e11;
    }

    public void remove(long j) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j);
        if (binarySearch < 0 || this.values[binarySearch] == LongSparseArrayKt.DELETED) {
            return;
        }
        this.values[binarySearch] = LongSparseArrayKt.DELETED;
        this.garbage = true;
    }

    public void removeAt(int i) {
        if (this.values[i] != LongSparseArrayKt.DELETED) {
            this.values[i] = LongSparseArrayKt.DELETED;
            this.garbage = true;
        }
    }

    public boolean replace(long j, E e10, E e11) {
        int indexOfKey = indexOfKey(j);
        if (indexOfKey < 0 || !kotlin.jvm.internal.l.a(this.values[indexOfKey], e10)) {
            return false;
        }
        this.values[indexOfKey] = e11;
        return true;
    }

    public void setValueAt(int i, E e10) {
        int i6;
        if (i < 0 || i >= (i6 = this.size)) {
            o.o(l.u(i, "Expected index to be within 0..size()-1, but was "));
            return;
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i10 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                Object obj = objArr[i11];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            this.garbage = false;
            this.size = i10;
        }
        this.values[i] = e10;
    }

    public int size() {
        if (this.garbage) {
            int i = this.size;
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i6 = 0;
            for (int i10 = 0; i10 < i; i10++) {
                Object obj = objArr[i10];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i10 != i6) {
                        jArr[i6] = jArr[i10];
                        objArr[i6] = obj;
                        objArr[i10] = null;
                    }
                    i6++;
                }
            }
            this.garbage = false;
            this.size = i6;
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
            if (valueAt != sb) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public E valueAt(int i) {
        int i6;
        if (i < 0 || i >= (i6 = this.size)) {
            o.o(l.u(i, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        if (this.garbage) {
            long[] jArr = this.keys;
            Object[] objArr = this.values;
            int i10 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                Object obj = objArr[i11];
                if (obj != LongSparseArrayKt.DELETED) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            this.garbage = false;
            this.size = i10;
        }
        return (E) this.values[i];
    }

    public E replace(long j, E e10) {
        int indexOfKey = indexOfKey(j);
        if (indexOfKey < 0) {
            return null;
        }
        Object[] objArr = this.values;
        E e11 = (E) objArr[indexOfKey];
        objArr[indexOfKey] = e10;
        return e11;
    }

    public LongSparseArray() {
        this(0, 1, null);
    }

    public /* synthetic */ LongSparseArray(int i, int i6, g gVar) {
        this((i6 & 1) != 0 ? 10 : i);
    }

    public E get(long j, E e10) {
        int binarySearch = ContainerHelpersKt.binarySearch(this.keys, this.size, j);
        return (binarySearch < 0 || this.values[binarySearch] == LongSparseArrayKt.DELETED) ? e10 : (E) this.values[binarySearch];
    }

    public boolean remove(long j, E e10) {
        int indexOfKey = indexOfKey(j);
        if (indexOfKey < 0 || !kotlin.jvm.internal.l.a(e10, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }
}
