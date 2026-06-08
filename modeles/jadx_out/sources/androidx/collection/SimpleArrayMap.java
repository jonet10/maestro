package androidx.collection;

import a3.b;
import androidx.collection.internal.ContainerHelpersKt;
import java.util.Arrays;
import java.util.Map;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import q6.j;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class SimpleArrayMap<K, V> {
    private Object[] array;
    private int[] hashes;
    private int size;

    public SimpleArrayMap(int i) {
        this.hashes = i == 0 ? ContainerHelpersKt.EMPTY_INTS : new int[i];
        this.array = i == 0 ? ContainerHelpersKt.EMPTY_OBJECTS : new Object[i << 1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends V> T getOrDefaultInternal(Object obj, T t9) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? (T) this.array[(indexOfKey << 1) + 1] : t9;
    }

    private final int indexOf(K k5, int i) {
        int i6 = this.size;
        if (i6 == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpersKt.binarySearch(this.hashes, i6, i);
        if (binarySearch < 0 || l.a(k5, this.array[binarySearch << 1])) {
            return binarySearch;
        }
        int i10 = binarySearch + 1;
        while (i10 < i6 && this.hashes[i10] == i) {
            if (l.a(k5, this.array[i10 << 1])) {
                return i10;
            }
            i10++;
        }
        for (int i11 = binarySearch - 1; i11 >= 0 && this.hashes[i11] == i; i11--) {
            if (l.a(k5, this.array[i11 << 1])) {
                return i11;
            }
        }
        return ~i10;
    }

    private final int indexOfNull() {
        int i = this.size;
        if (i == 0) {
            return -1;
        }
        int binarySearch = ContainerHelpersKt.binarySearch(this.hashes, i, 0);
        if (binarySearch < 0 || this.array[binarySearch << 1] == null) {
            return binarySearch;
        }
        int i6 = binarySearch + 1;
        while (i6 < i && this.hashes[i6] == 0) {
            if (this.array[i6 << 1] == null) {
                return i6;
            }
            i6++;
        }
        for (int i10 = binarySearch - 1; i10 >= 0 && this.hashes[i10] == 0; i10--) {
            if (this.array[i10 << 1] == null) {
                return i10;
            }
        }
        return ~i6;
    }

    public final int __restricted$indexOfValue(V v) {
        int i = this.size * 2;
        Object[] objArr = this.array;
        if (v == null) {
            for (int i6 = 1; i6 < i; i6 += 2) {
                if (objArr[i6] == null) {
                    return i6 >> 1;
                }
            }
            return -1;
        }
        for (int i10 = 1; i10 < i; i10 += 2) {
            if (v.equals(objArr[i10])) {
                return i10 >> 1;
            }
        }
        return -1;
    }

    public void clear() {
        if (this.size > 0) {
            this.hashes = ContainerHelpersKt.EMPTY_INTS;
            this.array = ContainerHelpersKt.EMPTY_OBJECTS;
            this.size = 0;
        }
        if (this.size <= 0) {
            return;
        }
        b.i();
    }

    public boolean containsKey(K k5) {
        return indexOfKey(k5) >= 0;
    }

    public boolean containsValue(V v) {
        return __restricted$indexOfValue(v) >= 0;
    }

    public void ensureCapacity(int i) {
        int i6 = this.size;
        int[] iArr = this.hashes;
        if (iArr.length < i) {
            this.hashes = Arrays.copyOf(iArr, i);
            this.array = Arrays.copyOf(this.array, i * 2);
        }
        if (this.size == i6) {
            return;
        }
        b.i();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                if (size() != ((SimpleArrayMap) obj).size()) {
                    return false;
                }
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                int i = this.size;
                for (int i6 = 0; i6 < i; i6++) {
                    K keyAt = keyAt(i6);
                    V valueAt = valueAt(i6);
                    Object obj2 = simpleArrayMap.get(keyAt);
                    if (valueAt == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                            return false;
                        }
                    } else if (!valueAt.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || size() != ((Map) obj).size()) {
                return false;
            }
            int i10 = this.size;
            for (int i11 = 0; i11 < i10; i11++) {
                K keyAt2 = keyAt(i11);
                V valueAt2 = valueAt(i11);
                Object obj3 = ((Map) obj).get(keyAt2);
                if (valueAt2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(keyAt2)) {
                        return false;
                    }
                } else if (!valueAt2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public V get(K k5) {
        int indexOfKey = indexOfKey(k5);
        if (indexOfKey >= 0) {
            return (V) this.array[(indexOfKey << 1) + 1];
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V getOrDefault(Object obj, V v) {
        int indexOfKey = indexOfKey(obj);
        return indexOfKey >= 0 ? (V) this.array[(indexOfKey << 1) + 1] : v;
    }

    public int hashCode() {
        int[] iArr = this.hashes;
        Object[] objArr = this.array;
        int i = this.size;
        int i6 = 1;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i) {
            Object obj = objArr[i6];
            i11 += (obj != null ? obj.hashCode() : 0) ^ iArr[i10];
            i10++;
            i6 += 2;
        }
        return i11;
    }

    public int indexOfKey(K k5) {
        return k5 == null ? indexOfNull() : indexOf(k5, k5.hashCode());
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public K keyAt(int i) {
        if (i >= 0 && i < this.size) {
            return (K) this.array[i << 1];
        }
        o.o(androidx.lifecycle.l.u(i, "Expected index to be within 0..size()-1, but was "));
        return null;
    }

    public V put(K k5, V v) {
        int i = this.size;
        int hashCode = k5 != null ? k5.hashCode() : 0;
        int indexOf = k5 != null ? indexOf(k5, hashCode) : indexOfNull();
        if (indexOf >= 0) {
            int i6 = (indexOf << 1) + 1;
            Object[] objArr = this.array;
            V v9 = (V) objArr[i6];
            objArr[i6] = v;
            return v9;
        }
        int i10 = ~indexOf;
        int[] iArr = this.hashes;
        if (i >= iArr.length) {
            int i11 = 8;
            if (i >= 8) {
                i11 = (i >> 1) + i;
            } else if (i < 4) {
                i11 = 4;
            }
            this.hashes = Arrays.copyOf(iArr, i11);
            this.array = Arrays.copyOf(this.array, i11 << 1);
            if (i != this.size) {
                b.i();
                return null;
            }
        }
        if (i10 < i) {
            int[] iArr2 = this.hashes;
            int i12 = i10 + 1;
            j.X(i12, i10, iArr2, iArr2, i);
            Object[] objArr2 = this.array;
            j.W(i12 << 1, i10 << 1, this.size << 1, objArr2, objArr2);
        }
        int i13 = this.size;
        if (i == i13) {
            int[] iArr3 = this.hashes;
            if (i10 < iArr3.length) {
                iArr3[i10] = hashCode;
                Object[] objArr3 = this.array;
                int i14 = i10 << 1;
                objArr3[i14] = k5;
                objArr3[i14 + 1] = v;
                this.size = i13 + 1;
                return null;
            }
        }
        b.i();
        return null;
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        simpleArrayMap.getClass();
        int i = simpleArrayMap.size;
        ensureCapacity(this.size + i);
        if (this.size != 0) {
            for (int i6 = 0; i6 < i; i6++) {
                put(simpleArrayMap.keyAt(i6), simpleArrayMap.valueAt(i6));
            }
        } else if (i > 0) {
            j.X(0, 0, simpleArrayMap.hashes, this.hashes, i);
            j.W(0, 0, i << 1, simpleArrayMap.array, this.array);
            this.size = i;
        }
    }

    public V putIfAbsent(K k5, V v) {
        V v9 = get(k5);
        return v9 == null ? put(k5, v) : v9;
    }

    public boolean remove(K k5, V v) {
        int indexOfKey = indexOfKey(k5);
        if (indexOfKey < 0 || !l.a(v, valueAt(indexOfKey))) {
            return false;
        }
        removeAt(indexOfKey);
        return true;
    }

    public V removeAt(int i) {
        int i6;
        if (i < 0 || i >= (i6 = this.size)) {
            o.o(androidx.lifecycle.l.u(i, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        Object[] objArr = this.array;
        int i10 = i << 1;
        V v = (V) objArr[i10 + 1];
        if (i6 <= 1) {
            clear();
            return v;
        }
        int i11 = i6 - 1;
        int[] iArr = this.hashes;
        if (iArr.length <= 8 || i6 >= iArr.length / 3) {
            if (i < i11) {
                int i12 = i + 1;
                j.X(i, i12, iArr, iArr, i6);
                Object[] objArr2 = this.array;
                j.W(i10, i12 << 1, i6 << 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.array;
            int i13 = i11 << 1;
            objArr3[i13] = null;
            objArr3[i13 + 1] = null;
        } else {
            int i14 = i6 > 8 ? i6 + (i6 >> 1) : 8;
            this.hashes = Arrays.copyOf(iArr, i14);
            this.array = Arrays.copyOf(this.array, i14 << 1);
            if (i6 != this.size) {
                b.i();
                return null;
            }
            if (i > 0) {
                j.X(0, 0, iArr, this.hashes, i);
                j.W(0, 0, i10, objArr, this.array);
            }
            if (i < i11) {
                int i15 = i + 1;
                j.X(i, i15, iArr, this.hashes, i6);
                j.W(i10, i15 << 1, i6 << 1, objArr, this.array);
            }
        }
        if (i6 == this.size) {
            this.size = i11;
            return v;
        }
        b.i();
        return null;
    }

    public boolean replace(K k5, V v, V v9) {
        int indexOfKey = indexOfKey(k5);
        if (indexOfKey < 0 || !l.a(v, valueAt(indexOfKey))) {
            return false;
        }
        setValueAt(indexOfKey, v9);
        return true;
    }

    public V setValueAt(int i, V v) {
        if (i < 0 || i >= this.size) {
            o.o(androidx.lifecycle.l.u(i, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        int i6 = (i << 1) + 1;
        Object[] objArr = this.array;
        V v9 = (V) objArr[i6];
        objArr[i6] = v;
        return v9;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.size * 28);
        sb.append('{');
        int i = this.size;
        for (int i6 = 0; i6 < i; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            K keyAt = keyAt(i6);
            if (keyAt != sb) {
                sb.append(keyAt);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V valueAt = valueAt(i6);
            if (valueAt != sb) {
                sb.append(valueAt);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public V valueAt(int i) {
        if (i >= 0 && i < this.size) {
            return (V) this.array[(i << 1) + 1];
        }
        o.o(androidx.lifecycle.l.u(i, "Expected index to be within 0..size()-1, but was "));
        return null;
    }

    public V remove(K k5) {
        int indexOfKey = indexOfKey(k5);
        if (indexOfKey >= 0) {
            return removeAt(indexOfKey);
        }
        return null;
    }

    public V replace(K k5, V v) {
        int indexOfKey = indexOfKey(k5);
        if (indexOfKey >= 0) {
            return setValueAt(indexOfKey, v);
        }
        return null;
    }

    public SimpleArrayMap() {
        this(0, 1, null);
    }

    public /* synthetic */ SimpleArrayMap(int i, int i6, g gVar) {
        this((i6 & 1) != 0 ? 0 : i);
    }

    public SimpleArrayMap(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this(0, 1, null);
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }
}
