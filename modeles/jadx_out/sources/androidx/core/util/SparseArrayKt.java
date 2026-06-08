package androidx.core.util;

import android.util.SparseArray;
import d7.p;
import java.util.Iterator;
import kotlin.jvm.internal.l;
import q6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArray<T> sparseArray, int i) {
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsKey(SparseArray<T> sparseArray, int i) {
        return sparseArray.indexOfKey(i) >= 0;
    }

    public static final <T> boolean containsValue(SparseArray<T> sparseArray, T t9) {
        return sparseArray.indexOfValue(t9) >= 0;
    }

    public static final <T> void forEach(SparseArray<T> sparseArray, p pVar) {
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            pVar.invoke(Integer.valueOf(sparseArray.keyAt(i)), sparseArray.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(SparseArray<T> sparseArray, int i, T t9) {
        T t10 = sparseArray.get(i);
        return t10 == null ? t9 : t10;
    }

    public static final <T> T getOrElse(SparseArray<T> sparseArray, int i, d7.a aVar) {
        T t9 = sparseArray.get(i);
        return t9 == null ? (T) aVar.invoke() : t9;
    }

    public static final <T> int getSize(SparseArray<T> sparseArray) {
        return sparseArray.size();
    }

    public static final <T> boolean isEmpty(SparseArray<T> sparseArray) {
        return sparseArray.size() == 0;
    }

    public static final <T> boolean isNotEmpty(SparseArray<T> sparseArray) {
        return sparseArray.size() != 0;
    }

    public static final <T> x keyIterator(final SparseArray<T> sparseArray) {
        return new x() { // from class: androidx.core.util.SparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArray.size();
            }

            @Override // q6.x
            public int nextInt() {
                SparseArray<T> sparseArray2 = sparseArray;
                int i = this.index;
                this.index = i + 1;
                return sparseArray2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final <T> SparseArray<T> plus(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        SparseArray<T> sparseArray3 = new SparseArray<>(sparseArray2.size() + sparseArray.size());
        putAll(sparseArray3, sparseArray);
        putAll(sparseArray3, sparseArray2);
        return sparseArray3;
    }

    public static final <T> void putAll(SparseArray<T> sparseArray, SparseArray<T> sparseArray2) {
        int size = sparseArray2.size();
        for (int i = 0; i < size; i++) {
            sparseArray.put(sparseArray2.keyAt(i), sparseArray2.valueAt(i));
        }
    }

    public static final <T> boolean remove(SparseArray<T> sparseArray, int i, T t9) {
        int indexOfKey = sparseArray.indexOfKey(i);
        if (indexOfKey < 0 || !l.a(t9, sparseArray.valueAt(indexOfKey))) {
            return false;
        }
        sparseArray.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(SparseArray<T> sparseArray, int i, T t9) {
        sparseArray.put(i, t9);
    }

    public static final <T> Iterator<T> valueIterator(SparseArray<T> sparseArray) {
        return new SparseArrayKt$valueIterator$1(sparseArray);
    }
}
