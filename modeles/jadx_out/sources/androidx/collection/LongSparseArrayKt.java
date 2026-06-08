package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import androidx.lifecycle.l;
import d7.a;
import d7.p;
import java.util.Arrays;
import java.util.Iterator;
import q6.j;
import q6.y;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LongSparseArrayKt {
    private static final Object DELETED = new Object();

    public static final <E> void commonAppend(LongSparseArray<E> longSparseArray, long j, E e10) {
        longSparseArray.getClass();
        int i = longSparseArray.size;
        if (i != 0 && j <= longSparseArray.keys[i - 1]) {
            longSparseArray.put(j, e10);
            return;
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            if (i >= jArr.length) {
                Object[] objArr = longSparseArray.values;
                int i6 = 0;
                for (int i10 = 0; i10 < i; i10++) {
                    Object obj = objArr[i10];
                    if (obj != DELETED) {
                        if (i10 != i6) {
                            jArr[i6] = jArr[i10];
                            objArr[i6] = obj;
                            objArr[i10] = null;
                        }
                        i6++;
                    }
                }
                longSparseArray.garbage = false;
                longSparseArray.size = i6;
            }
        }
        int i11 = longSparseArray.size;
        if (i11 >= longSparseArray.keys.length) {
            int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i11 + 1);
            longSparseArray.keys = Arrays.copyOf(longSparseArray.keys, idealLongArraySize);
            longSparseArray.values = Arrays.copyOf(longSparseArray.values, idealLongArraySize);
        }
        longSparseArray.keys[i11] = j;
        longSparseArray.values[i11] = e10;
        longSparseArray.size = i11 + 1;
    }

    public static final <E> void commonClear(LongSparseArray<E> longSparseArray) {
        longSparseArray.getClass();
        int i = longSparseArray.size;
        Object[] objArr = longSparseArray.values;
        for (int i6 = 0; i6 < i; i6++) {
            objArr[i6] = null;
        }
        longSparseArray.size = 0;
        longSparseArray.garbage = false;
    }

    public static final <E> boolean commonContainsKey(LongSparseArray<E> longSparseArray, long j) {
        longSparseArray.getClass();
        return longSparseArray.indexOfKey(j) >= 0;
    }

    public static final <E> boolean commonContainsValue(LongSparseArray<E> longSparseArray, E e10) {
        longSparseArray.getClass();
        return longSparseArray.indexOfValue(e10) >= 0;
    }

    public static final <E> void commonGc(LongSparseArray<E> longSparseArray) {
        longSparseArray.getClass();
        int i = longSparseArray.size;
        long[] jArr = longSparseArray.keys;
        Object[] objArr = longSparseArray.values;
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            Object obj = objArr[i10];
            if (obj != DELETED) {
                if (i10 != i6) {
                    jArr[i6] = jArr[i10];
                    objArr[i6] = obj;
                    objArr[i10] = null;
                }
                i6++;
            }
        }
        longSparseArray.garbage = false;
        longSparseArray.size = i6;
    }

    public static final <E> E commonGet(LongSparseArray<E> longSparseArray, long j) {
        longSparseArray.getClass();
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
        if (binarySearch < 0 || longSparseArray.values[binarySearch] == DELETED) {
            return null;
        }
        return (E) longSparseArray.values[binarySearch];
    }

    public static final <T extends E, E> T commonGetInternal(LongSparseArray<E> longSparseArray, long j, T t9) {
        longSparseArray.getClass();
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
        return (binarySearch < 0 || longSparseArray.values[binarySearch] == DELETED) ? t9 : (T) longSparseArray.values[binarySearch];
    }

    public static final <E> int commonIndexOfKey(LongSparseArray<E> longSparseArray, long j) {
        longSparseArray.getClass();
        if (longSparseArray.garbage) {
            int i = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i6 = 0;
            for (int i10 = 0; i10 < i; i10++) {
                Object obj = objArr[i10];
                if (obj != DELETED) {
                    if (i10 != i6) {
                        jArr[i6] = jArr[i10];
                        objArr[i6] = obj;
                        objArr[i10] = null;
                    }
                    i6++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i6;
        }
        return ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
    }

    public static final <E> int commonIndexOfValue(LongSparseArray<E> longSparseArray, E e10) {
        longSparseArray.getClass();
        if (longSparseArray.garbage) {
            int i = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i6 = 0;
            for (int i10 = 0; i10 < i; i10++) {
                Object obj = objArr[i10];
                if (obj != DELETED) {
                    if (i10 != i6) {
                        jArr[i6] = jArr[i10];
                        objArr[i6] = obj;
                        objArr[i10] = null;
                    }
                    i6++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i6;
        }
        int i11 = longSparseArray.size;
        for (int i12 = 0; i12 < i11; i12++) {
            if (longSparseArray.values[i12] == e10) {
                return i12;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(LongSparseArray<E> longSparseArray) {
        longSparseArray.getClass();
        return longSparseArray.size() == 0;
    }

    public static final <E> long commonKeyAt(LongSparseArray<E> longSparseArray, int i) {
        int i6;
        longSparseArray.getClass();
        if (i < 0 || i >= (i6 = longSparseArray.size)) {
            o.o(l.u(i, "Expected index to be within 0..size()-1, but was "));
            return 0L;
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i10 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                Object obj = objArr[i11];
                if (obj != DELETED) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i10;
        }
        return longSparseArray.keys[i];
    }

    public static final <E> void commonPut(LongSparseArray<E> longSparseArray, long j, E e10) {
        longSparseArray.getClass();
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
        if (binarySearch >= 0) {
            longSparseArray.values[binarySearch] = e10;
            return;
        }
        int i = ~binarySearch;
        if (i < longSparseArray.size && longSparseArray.values[i] == DELETED) {
            longSparseArray.keys[i] = j;
            longSparseArray.values[i] = e10;
            return;
        }
        if (longSparseArray.garbage) {
            int i6 = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            if (i6 >= jArr.length) {
                Object[] objArr = longSparseArray.values;
                int i10 = 0;
                for (int i11 = 0; i11 < i6; i11++) {
                    Object obj = objArr[i11];
                    if (obj != DELETED) {
                        if (i11 != i10) {
                            jArr[i10] = jArr[i11];
                            objArr[i10] = obj;
                            objArr[i11] = null;
                        }
                        i10++;
                    }
                }
                longSparseArray.garbage = false;
                longSparseArray.size = i10;
                i = ~ContainerHelpersKt.binarySearch(longSparseArray.keys, i10, j);
            }
        }
        int i12 = longSparseArray.size;
        if (i12 >= longSparseArray.keys.length) {
            int idealLongArraySize = ContainerHelpersKt.idealLongArraySize(i12 + 1);
            longSparseArray.keys = Arrays.copyOf(longSparseArray.keys, idealLongArraySize);
            longSparseArray.values = Arrays.copyOf(longSparseArray.values, idealLongArraySize);
        }
        int i13 = longSparseArray.size;
        if (i13 - i != 0) {
            long[] jArr2 = longSparseArray.keys;
            int i14 = i + 1;
            j.a0(jArr2, jArr2, i14, i, i13);
            Object[] objArr2 = longSparseArray.values;
            j.W(i14, i, longSparseArray.size, objArr2, objArr2);
        }
        longSparseArray.keys[i] = j;
        longSparseArray.values[i] = e10;
        longSparseArray.size++;
    }

    public static final <E> void commonPutAll(LongSparseArray<E> longSparseArray, LongSparseArray<? extends E> longSparseArray2) {
        longSparseArray.getClass();
        longSparseArray2.getClass();
        int size = longSparseArray2.size();
        for (int i = 0; i < size; i++) {
            longSparseArray.put(longSparseArray2.keyAt(i), longSparseArray2.valueAt(i));
        }
    }

    public static final <E> E commonPutIfAbsent(LongSparseArray<E> longSparseArray, long j, E e10) {
        longSparseArray.getClass();
        E e11 = longSparseArray.get(j);
        if (e11 == null) {
            longSparseArray.put(j, e10);
        }
        return e11;
    }

    public static final <E> void commonRemove(LongSparseArray<E> longSparseArray, long j) {
        longSparseArray.getClass();
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
        if (binarySearch < 0 || longSparseArray.values[binarySearch] == DELETED) {
            return;
        }
        longSparseArray.values[binarySearch] = DELETED;
        longSparseArray.garbage = true;
    }

    public static final <E> void commonRemoveAt(LongSparseArray<E> longSparseArray, int i) {
        longSparseArray.getClass();
        if (longSparseArray.values[i] != DELETED) {
            longSparseArray.values[i] = DELETED;
            longSparseArray.garbage = true;
        }
    }

    public static final <E> boolean commonReplace(LongSparseArray<E> longSparseArray, long j, E e10, E e11) {
        longSparseArray.getClass();
        int indexOfKey = longSparseArray.indexOfKey(j);
        if (indexOfKey < 0 || !kotlin.jvm.internal.l.a(longSparseArray.values[indexOfKey], e10)) {
            return false;
        }
        longSparseArray.values[indexOfKey] = e11;
        return true;
    }

    public static final <E> void commonSetValueAt(LongSparseArray<E> longSparseArray, int i, E e10) {
        int i6;
        longSparseArray.getClass();
        if (i < 0 || i >= (i6 = longSparseArray.size)) {
            o.o(l.u(i, "Expected index to be within 0..size()-1, but was "));
            return;
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i10 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                Object obj = objArr[i11];
                if (obj != DELETED) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i10;
        }
        longSparseArray.values[i] = e10;
    }

    public static final <E> int commonSize(LongSparseArray<E> longSparseArray) {
        longSparseArray.getClass();
        if (longSparseArray.garbage) {
            int i = longSparseArray.size;
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i6 = 0;
            for (int i10 = 0; i10 < i; i10++) {
                Object obj = objArr[i10];
                if (obj != DELETED) {
                    if (i10 != i6) {
                        jArr[i6] = jArr[i10];
                        objArr[i6] = obj;
                        objArr[i10] = null;
                    }
                    i6++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i6;
        }
        return longSparseArray.size;
    }

    public static final <E> String commonToString(LongSparseArray<E> longSparseArray) {
        longSparseArray.getClass();
        if (longSparseArray.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(longSparseArray.size * 28);
        sb.append('{');
        int i = longSparseArray.size;
        for (int i6 = 0; i6 < i; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(longSparseArray.keyAt(i6));
            sb.append('=');
            E valueAt = longSparseArray.valueAt(i6);
            if (valueAt != sb) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public static final <E> E commonValueAt(LongSparseArray<E> longSparseArray, int i) {
        int i6;
        longSparseArray.getClass();
        if (i < 0 || i >= (i6 = longSparseArray.size)) {
            o.o(l.u(i, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        if (longSparseArray.garbage) {
            long[] jArr = longSparseArray.keys;
            Object[] objArr = longSparseArray.values;
            int i10 = 0;
            for (int i11 = 0; i11 < i6; i11++) {
                Object obj = objArr[i11];
                if (obj != DELETED) {
                    if (i11 != i10) {
                        jArr[i10] = jArr[i11];
                        objArr[i10] = obj;
                        objArr[i11] = null;
                    }
                    i10++;
                }
            }
            longSparseArray.garbage = false;
            longSparseArray.size = i10;
        }
        return (E) longSparseArray.values[i];
    }

    public static final <T> boolean contains(LongSparseArray<T> longSparseArray, long j) {
        longSparseArray.getClass();
        return longSparseArray.containsKey(j);
    }

    public static final <T> void forEach(LongSparseArray<T> longSparseArray, p pVar) {
        longSparseArray.getClass();
        pVar.getClass();
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            pVar.invoke(Long.valueOf(longSparseArray.keyAt(i)), longSparseArray.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(LongSparseArray<T> longSparseArray, long j, T t9) {
        longSparseArray.getClass();
        return longSparseArray.get(j, t9);
    }

    public static final <T> T getOrElse(LongSparseArray<T> longSparseArray, long j, a aVar) {
        longSparseArray.getClass();
        aVar.getClass();
        T t9 = longSparseArray.get(j);
        return t9 == null ? (T) aVar.invoke() : t9;
    }

    public static final <T> int getSize(LongSparseArray<T> longSparseArray) {
        longSparseArray.getClass();
        return longSparseArray.size();
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> longSparseArray) {
        longSparseArray.getClass();
        return !longSparseArray.isEmpty();
    }

    public static final <T> y keyIterator(final LongSparseArray<T> longSparseArray) {
        longSparseArray.getClass();
        return new y() { // from class: androidx.collection.LongSparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // q6.y
            public long nextLong() {
                LongSparseArray<T> longSparseArray2 = longSparseArray;
                int i = this.index;
                this.index = i + 1;
                return longSparseArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> longSparseArray, LongSparseArray<T> longSparseArray2) {
        longSparseArray.getClass();
        longSparseArray2.getClass();
        LongSparseArray<T> longSparseArray3 = new LongSparseArray<>(longSparseArray2.size() + longSparseArray.size());
        longSparseArray3.putAll(longSparseArray);
        longSparseArray3.putAll(longSparseArray2);
        return longSparseArray3;
    }

    public static final /* synthetic */ boolean remove(LongSparseArray longSparseArray, long j, Object obj) {
        longSparseArray.getClass();
        return longSparseArray.remove(j, obj);
    }

    public static final <T> void set(LongSparseArray<T> longSparseArray, long j, T t9) {
        longSparseArray.getClass();
        longSparseArray.put(j, t9);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> longSparseArray) {
        longSparseArray.getClass();
        return new LongSparseArrayKt$valueIterator$1(longSparseArray);
    }

    public static /* synthetic */ void getSize$annotations(LongSparseArray longSparseArray) {
    }

    public static final <E> E commonReplace(LongSparseArray<E> longSparseArray, long j, E e10) {
        longSparseArray.getClass();
        int indexOfKey = longSparseArray.indexOfKey(j);
        if (indexOfKey < 0) {
            return null;
        }
        Object[] objArr = longSparseArray.values;
        E e11 = (E) objArr[indexOfKey];
        objArr[indexOfKey] = e10;
        return e11;
    }

    public static final <E> E commonGet(LongSparseArray<E> longSparseArray, long j, E e10) {
        longSparseArray.getClass();
        int binarySearch = ContainerHelpersKt.binarySearch(longSparseArray.keys, longSparseArray.size, j);
        return (binarySearch < 0 || longSparseArray.values[binarySearch] == DELETED) ? e10 : (E) longSparseArray.values[binarySearch];
    }

    public static final <E> boolean commonRemove(LongSparseArray<E> longSparseArray, long j, E e10) {
        longSparseArray.getClass();
        int indexOfKey = longSparseArray.indexOfKey(j);
        if (indexOfKey < 0 || !kotlin.jvm.internal.l.a(e10, longSparseArray.valueAt(indexOfKey))) {
            return false;
        }
        longSparseArray.removeAt(indexOfKey);
        return true;
    }
}
