package androidx.collection;

import e7.b;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.l;

/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MutableScatterMap$MutableMapWrapper$values$1<V> implements Collection<V>, b {
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    public MutableScatterMap$MutableMapWrapper$values$1(MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
    }

    @Override // java.util.Collection
    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends V> collection) {
        collection.getClass();
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public void clear() {
        this.this$0.clear();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return this.this$0.containsValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        collection.getClass();
        Collection<? extends Object> collection2 = collection;
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!mutableScatterMap.containsValue(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int getSize() {
        return this.this$0._size;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.this$0.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return new MutableScatterMap$MutableMapWrapper$values$1$iterator$1(this.this$0);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i - length)) >>> 31);
                    for (int i10 = 0; i10 < i6; i10++) {
                        if ((255 & j) < 128) {
                            int i11 = (i << 3) + i10;
                            if (l.a(mutableScatterMap.values[i11], obj)) {
                                mutableScatterMap.removeValueAt(i11);
                                return true;
                            }
                        }
                        j >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        collection.getClass();
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i = 0;
        boolean z9 = false;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j) < 128) {
                        int i11 = (i << 3) + i10;
                        if (q6.l.o0(collection, mutableScatterMap.values[i11])) {
                            mutableScatterMap.removeValueAt(i11);
                            z9 = true;
                        }
                    }
                    j >>= 8;
                }
                if (i6 != 8) {
                    return z9;
                }
            }
            if (i == length) {
                return z9;
            }
            i++;
        }
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        collection.getClass();
        MutableScatterMap<K, V> mutableScatterMap = this.this$0;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return false;
        }
        int i = 0;
        boolean z9 = false;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j) < 128) {
                        int i11 = (i << 3) + i10;
                        if (!q6.l.o0(collection, mutableScatterMap.values[i11])) {
                            mutableScatterMap.removeValueAt(i11);
                            z9 = true;
                        }
                    }
                    j >>= 8;
                }
                if (i6 != 8) {
                    return z9;
                }
            }
            if (i == length) {
                return z9;
            }
            i++;
        }
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        tArr.getClass();
        return (T[]) l.k(this, tArr);
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return l.j(this);
    }
}
