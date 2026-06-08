package androidx.collection;

import d7.a;
import d7.p;
import java.util.Iterator;
import q6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(SparseArrayCompat<T> sparseArrayCompat, int i) {
        sparseArrayCompat.getClass();
        return sparseArrayCompat.containsKey(i);
    }

    public static final <T> void forEach(SparseArrayCompat<T> sparseArrayCompat, p pVar) {
        sparseArrayCompat.getClass();
        pVar.getClass();
        int size = sparseArrayCompat.size();
        for (int i = 0; i < size; i++) {
            pVar.invoke(Integer.valueOf(sparseArrayCompat.keyAt(i)), sparseArrayCompat.valueAt(i));
        }
    }

    public static final <T> T getOrDefault(SparseArrayCompat<T> sparseArrayCompat, int i, T t9) {
        sparseArrayCompat.getClass();
        return sparseArrayCompat.get(i, t9);
    }

    public static final <T> T getOrElse(SparseArrayCompat<T> sparseArrayCompat, int i, a aVar) {
        sparseArrayCompat.getClass();
        aVar.getClass();
        T t9 = sparseArrayCompat.get(i);
        return t9 == null ? (T) aVar.invoke() : t9;
    }

    public static final <T> int getSize(SparseArrayCompat<T> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        return sparseArrayCompat.size();
    }

    public static final <T> boolean isNotEmpty(SparseArrayCompat<T> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        return !sparseArrayCompat.isEmpty();
    }

    public static final <T> x keyIterator(final SparseArrayCompat<T> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        return new x() { // from class: androidx.collection.SparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArrayCompat.size();
            }

            @Override // q6.x
            public int nextInt() {
                SparseArrayCompat<T> sparseArrayCompat2 = sparseArrayCompat;
                int i = this.index;
                this.index = i + 1;
                return sparseArrayCompat2.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    public static final <T> SparseArrayCompat<T> plus(SparseArrayCompat<T> sparseArrayCompat, SparseArrayCompat<T> sparseArrayCompat2) {
        sparseArrayCompat.getClass();
        sparseArrayCompat2.getClass();
        SparseArrayCompat<T> sparseArrayCompat3 = new SparseArrayCompat<>(sparseArrayCompat2.size() + sparseArrayCompat.size());
        sparseArrayCompat3.putAll(sparseArrayCompat);
        sparseArrayCompat3.putAll(sparseArrayCompat2);
        return sparseArrayCompat3;
    }

    public static final /* synthetic */ boolean remove(SparseArrayCompat sparseArrayCompat, int i, Object obj) {
        sparseArrayCompat.getClass();
        return sparseArrayCompat.remove(i, obj);
    }

    public static final <T> void set(SparseArrayCompat<T> sparseArrayCompat, int i, T t9) {
        sparseArrayCompat.getClass();
        sparseArrayCompat.put(i, t9);
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> sparseArrayCompat) {
        sparseArrayCompat.getClass();
        return new SparseArrayKt$valueIterator$1(sparseArrayCompat);
    }
}
