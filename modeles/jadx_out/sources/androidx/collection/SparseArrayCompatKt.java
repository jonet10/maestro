package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import kotlin.jvm.internal.l;
import q6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SparseArrayCompatKt {
    private static final Object DELETED = new Object();

    public static final <E> void commonAppend(SparseArrayCompat<E> sparseArrayCompat, int i, E e10) {
        sparseArrayCompat.getClass();
        int i6 = sparseArrayCompat.size;
        if (i6 != 0 && i <= sparseArrayCompat.keys[i6 - 1]) {
            sparseArrayCompat.put(i, e10);
            return;
        }
        if (sparseArrayCompat.garbage && i6 >= sparseArrayCompat.keys.length) {
            gc(sparseArrayCompat);
        }
        int i10 = sparseArrayCompat.size;
        if (i10 >= sparseArrayCompat.keys.length) {
            int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i10 + 1);
            sparseArrayCompat.keys = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
            sparseArrayCompat.values = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
        }
        sparseArrayCompat.keys[i10] = i;
        sparseArrayCompat.values[i10] = e10;
        sparseArrayCompat.size = i10 + 1;
    }

    public static final <E> void commonClear(SparseArrayCompat<E> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        int i = sparseArrayCompat.size;
        Object[] objArr = sparseArrayCompat.values;
        for (int i6 = 0; i6 < i; i6++) {
            objArr[i6] = null;
        }
        sparseArrayCompat.size = 0;
        sparseArrayCompat.garbage = false;
    }

    public static final <E> boolean commonContainsKey(SparseArrayCompat<E> sparseArrayCompat, int i) {
        sparseArrayCompat.getClass();
        return sparseArrayCompat.indexOfKey(i) >= 0;
    }

    public static final <E> boolean commonContainsValue(SparseArrayCompat<E> sparseArrayCompat, E e10) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        int i = sparseArrayCompat.size;
        int i6 = 0;
        while (true) {
            if (i6 >= i) {
                i6 = -1;
                break;
            }
            if (sparseArrayCompat.values[i6] == e10) {
                break;
            }
            i6++;
        }
        return i6 >= 0;
    }

    public static final <E> E commonGet(SparseArrayCompat<E> sparseArrayCompat, int i) {
        E e10;
        sparseArrayCompat.getClass();
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        if (binarySearch < 0 || (e10 = (E) sparseArrayCompat.values[binarySearch]) == DELETED) {
            return null;
        }
        return e10;
    }

    public static final <E> int commonIndexOfKey(SparseArrayCompat<E> sparseArrayCompat, int i) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
    }

    public static final <E> int commonIndexOfValue(SparseArrayCompat<E> sparseArrayCompat, E e10) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        int i = sparseArrayCompat.size;
        for (int i6 = 0; i6 < i; i6++) {
            if (sparseArrayCompat.values[i6] == e10) {
                return i6;
            }
        }
        return -1;
    }

    public static final <E> boolean commonIsEmpty(SparseArrayCompat<E> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        return sparseArrayCompat.size() == 0;
    }

    public static final <E> int commonKeyAt(SparseArrayCompat<E> sparseArrayCompat, int i) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.keys[i];
    }

    public static final <E> void commonPut(SparseArrayCompat<E> sparseArrayCompat, int i, E e10) {
        sparseArrayCompat.getClass();
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        if (binarySearch >= 0) {
            sparseArrayCompat.values[binarySearch] = e10;
            return;
        }
        int i6 = ~binarySearch;
        if (i6 < sparseArrayCompat.size && sparseArrayCompat.values[i6] == DELETED) {
            sparseArrayCompat.keys[i6] = i;
            sparseArrayCompat.values[i6] = e10;
            return;
        }
        if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
            gc(sparseArrayCompat);
            i6 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        }
        int i10 = sparseArrayCompat.size;
        if (i10 >= sparseArrayCompat.keys.length) {
            int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i10 + 1);
            sparseArrayCompat.keys = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
            sparseArrayCompat.values = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
        }
        int i11 = sparseArrayCompat.size;
        if (i11 - i6 != 0) {
            int[] iArr = sparseArrayCompat.keys;
            int i12 = i6 + 1;
            j.X(i12, i6, iArr, iArr, i11);
            Object[] objArr = sparseArrayCompat.values;
            j.W(i12, i6, sparseArrayCompat.size, objArr, objArr);
        }
        sparseArrayCompat.keys[i6] = i;
        sparseArrayCompat.values[i6] = e10;
        sparseArrayCompat.size++;
    }

    public static final <E> void commonPutAll(SparseArrayCompat<E> sparseArrayCompat, SparseArrayCompat<? extends E> sparseArrayCompat2) {
        sparseArrayCompat.getClass();
        sparseArrayCompat2.getClass();
        int size = sparseArrayCompat2.size();
        for (int i = 0; i < size; i++) {
            int keyAt = sparseArrayCompat2.keyAt(i);
            E valueAt = sparseArrayCompat2.valueAt(i);
            int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, keyAt);
            if (binarySearch >= 0) {
                sparseArrayCompat.values[binarySearch] = valueAt;
            } else {
                int i6 = ~binarySearch;
                if (i6 >= sparseArrayCompat.size || sparseArrayCompat.values[i6] != DELETED) {
                    if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                        gc(sparseArrayCompat);
                        i6 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, keyAt);
                    }
                    int i10 = sparseArrayCompat.size;
                    if (i10 >= sparseArrayCompat.keys.length) {
                        int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i10 + 1);
                        sparseArrayCompat.keys = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
                        sparseArrayCompat.values = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
                    }
                    int i11 = sparseArrayCompat.size;
                    if (i11 - i6 != 0) {
                        int[] iArr = sparseArrayCompat.keys;
                        int i12 = i6 + 1;
                        j.X(i12, i6, iArr, iArr, i11);
                        Object[] objArr = sparseArrayCompat.values;
                        j.W(i12, i6, sparseArrayCompat.size, objArr, objArr);
                    }
                    sparseArrayCompat.keys[i6] = keyAt;
                    sparseArrayCompat.values[i6] = valueAt;
                    sparseArrayCompat.size++;
                } else {
                    sparseArrayCompat.keys[i6] = keyAt;
                    sparseArrayCompat.values[i6] = valueAt;
                }
            }
        }
    }

    public static final <E> E commonPutIfAbsent(SparseArrayCompat<E> sparseArrayCompat, int i, E e10) {
        sparseArrayCompat.getClass();
        E e11 = (E) commonGet(sparseArrayCompat, i);
        if (e11 == null) {
            int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
            if (binarySearch >= 0) {
                sparseArrayCompat.values[binarySearch] = e10;
                return e11;
            }
            int i6 = ~binarySearch;
            if (i6 < sparseArrayCompat.size && sparseArrayCompat.values[i6] == DELETED) {
                sparseArrayCompat.keys[i6] = i;
                sparseArrayCompat.values[i6] = e10;
                return e11;
            }
            if (sparseArrayCompat.garbage && sparseArrayCompat.size >= sparseArrayCompat.keys.length) {
                gc(sparseArrayCompat);
                i6 = ~ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
            }
            int i10 = sparseArrayCompat.size;
            if (i10 >= sparseArrayCompat.keys.length) {
                int idealIntArraySize = ContainerHelpersKt.idealIntArraySize(i10 + 1);
                sparseArrayCompat.keys = Arrays.copyOf(sparseArrayCompat.keys, idealIntArraySize);
                sparseArrayCompat.values = Arrays.copyOf(sparseArrayCompat.values, idealIntArraySize);
            }
            int i11 = sparseArrayCompat.size;
            if (i11 - i6 != 0) {
                int[] iArr = sparseArrayCompat.keys;
                int i12 = i6 + 1;
                j.X(i12, i6, iArr, iArr, i11);
                Object[] objArr = sparseArrayCompat.values;
                j.W(i12, i6, sparseArrayCompat.size, objArr, objArr);
            }
            sparseArrayCompat.keys[i6] = i;
            sparseArrayCompat.values[i6] = e10;
            sparseArrayCompat.size++;
        }
        return e11;
    }

    public static final <E> void commonRemove(SparseArrayCompat<E> sparseArrayCompat, int i) {
        sparseArrayCompat.getClass();
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        if (binarySearch >= 0) {
            Object[] objArr = sparseArrayCompat.values;
            Object obj = objArr[binarySearch];
            Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[binarySearch] = obj2;
                sparseArrayCompat.garbage = true;
            }
        }
    }

    public static final <E> void commonRemoveAt(SparseArrayCompat<E> sparseArrayCompat, int i) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.values[i] != DELETED) {
            sparseArrayCompat.values[i] = DELETED;
            sparseArrayCompat.garbage = true;
        }
    }

    public static final <E> void commonRemoveAtRange(SparseArrayCompat<E> sparseArrayCompat, int i, int i6) {
        sparseArrayCompat.getClass();
        int min = Math.min(i6, i + i6);
        while (i < min) {
            sparseArrayCompat.removeAt(i);
            i++;
        }
    }

    public static final <E> boolean commonReplace(SparseArrayCompat<E> sparseArrayCompat, int i, E e10, E e11) {
        sparseArrayCompat.getClass();
        int indexOfKey = sparseArrayCompat.indexOfKey(i);
        if (indexOfKey < 0 || !l.a(sparseArrayCompat.values[indexOfKey], e10)) {
            return false;
        }
        sparseArrayCompat.values[indexOfKey] = e11;
        return true;
    }

    public static final <E> void commonSetValueAt(SparseArrayCompat<E> sparseArrayCompat, int i, E e10) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        sparseArrayCompat.values[i] = e10;
    }

    public static final <E> int commonSize(SparseArrayCompat<E> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return sparseArrayCompat.size;
    }

    public static final <E> String commonToString(SparseArrayCompat<E> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(sparseArrayCompat.size * 28);
        sb.append('{');
        int i = sparseArrayCompat.size;
        for (int i6 = 0; i6 < i; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(sparseArrayCompat.keyAt(i6));
            sb.append('=');
            E valueAt = sparseArrayCompat.valueAt(i6);
            if (valueAt != sparseArrayCompat) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public static final <E> E commonValueAt(SparseArrayCompat<E> sparseArrayCompat, int i) {
        sparseArrayCompat.getClass();
        if (sparseArrayCompat.garbage) {
            gc(sparseArrayCompat);
        }
        return (E) sparseArrayCompat.values[i];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> void gc(SparseArrayCompat<E> sparseArrayCompat) {
        int i = sparseArrayCompat.size;
        int[] iArr = sparseArrayCompat.keys;
        Object[] objArr = sparseArrayCompat.values;
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            Object obj = objArr[i10];
            if (obj != DELETED) {
                if (i10 != i6) {
                    iArr[i6] = iArr[i10];
                    objArr[i6] = obj;
                    objArr[i10] = null;
                }
                i6++;
            }
        }
        sparseArrayCompat.garbage = false;
        sparseArrayCompat.size = i6;
    }

    private static final <E, T extends E> T internalGet(SparseArrayCompat<E> sparseArrayCompat, int i, T t9) {
        T t10;
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        return (binarySearch < 0 || (t10 = (T) sparseArrayCompat.values[binarySearch]) == DELETED) ? t9 : t10;
    }

    public static final <E> E commonGet(SparseArrayCompat<E> sparseArrayCompat, int i, E e10) {
        E e11;
        sparseArrayCompat.getClass();
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i);
        return (binarySearch < 0 || (e11 = (E) sparseArrayCompat.values[binarySearch]) == DELETED) ? e10 : e11;
    }

    public static final <E> boolean commonRemove(SparseArrayCompat<E> sparseArrayCompat, int i, Object obj) {
        sparseArrayCompat.getClass();
        int indexOfKey = sparseArrayCompat.indexOfKey(i);
        if (indexOfKey < 0 || !l.a(obj, sparseArrayCompat.valueAt(indexOfKey))) {
            return false;
        }
        sparseArrayCompat.removeAt(indexOfKey);
        return true;
    }

    public static final <E> E commonReplace(SparseArrayCompat<E> sparseArrayCompat, int i, E e10) {
        sparseArrayCompat.getClass();
        int indexOfKey = sparseArrayCompat.indexOfKey(i);
        if (indexOfKey < 0) {
            return null;
        }
        Object[] objArr = sparseArrayCompat.values;
        E e11 = (E) objArr[indexOfKey];
        objArr[indexOfKey] = e10;
        return e11;
    }
}
