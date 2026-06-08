package j$.util.concurrent;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class b implements Collection, Serializable {
    private static final long serialVersionUID = 7249069246763182397L;

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f5994a;

    @Override // java.util.Collection
    public abstract boolean contains(Object obj);

    @Override // java.util.Collection, java.lang.Iterable
    public abstract Iterator iterator();

    @Override // java.util.Collection
    public abstract boolean remove(Object obj);

    public b(ConcurrentHashMap concurrentHashMap) {
        this.f5994a = concurrentHashMap;
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f5994a.clear();
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f5994a.size();
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f5994a.isEmpty();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        long j = this.f5994a.j();
        if (j < 0) {
            j = 0;
        }
        if (j > 2147483639) {
            throw new OutOfMemoryError("Required array size too large");
        }
        int i = (int) j;
        Object[] objArr = new Object[i];
        Iterator it = iterator();
        int i6 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            if (i6 == i) {
                if (i >= 2147483639) {
                    throw new OutOfMemoryError("Required array size too large");
                }
                int i10 = i < 1073741819 ? (i >>> 1) + 1 + i : 2147483639;
                objArr = Arrays.copyOf(objArr, i10);
                i = i10;
            }
            objArr[i6] = next;
            i6++;
        }
        return i6 == i ? objArr : Arrays.copyOf(objArr, i6);
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        long j = this.f5994a.j();
        if (j < 0) {
            j = 0;
        }
        if (j > 2147483639) {
            throw new OutOfMemoryError("Required array size too large");
        }
        int i = (int) j;
        Object[] objArr2 = objArr.length >= i ? objArr : (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
        int length = objArr2.length;
        Iterator it = iterator();
        int i6 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            if (i6 == length) {
                if (length >= 2147483639) {
                    throw new OutOfMemoryError("Required array size too large");
                }
                int i10 = length < 1073741819 ? (length >>> 1) + 1 + length : 2147483639;
                objArr2 = Arrays.copyOf(objArr2, i10);
                length = i10;
            }
            objArr2[i6] = next;
            i6++;
        }
        if (objArr != objArr2 || i6 >= length) {
            return i6 == length ? objArr2 : Arrays.copyOf(objArr2, i6);
        }
        objArr2[i6] = null;
        return objArr2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        if (it.hasNext()) {
            while (true) {
                Object next = it.next();
                if (next == this) {
                    next = "(this Collection)";
                }
                sb.append(next);
                if (!it.hasNext()) {
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        if (collection == this) {
            return true;
        }
        for (Object obj : collection) {
            if (obj == null || !contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        collection.getClass();
        l[] lVarArr = this.f5994a.f5984a;
        boolean z9 = false;
        if (lVarArr == null) {
            return false;
        }
        if ((collection instanceof Set) && collection.size() > lVarArr.length) {
            Iterator it = iterator();
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    it.remove();
                    z9 = true;
                }
            }
            return z9;
        }
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            z9 |= remove(it2.next());
        }
        return z9;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        Iterator it = iterator();
        boolean z9 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z9 = true;
            }
        }
        return z9;
    }
}
