package q6;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i extends f {

    /* renamed from: m, reason: collision with root package name */
    public static final Object[] f8719m = new Object[0];

    /* renamed from: a, reason: collision with root package name */
    public int f8720a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f8721b = f8719m;

    /* renamed from: l, reason: collision with root package name */
    public int f8722l;

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        int i6;
        b bVar = e.Companion;
        int i10 = this.f8722l;
        bVar.getClass();
        b.c(i, i10);
        if (i == this.f8722l) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        n();
        g(this.f8722l + 1);
        int m10 = m(this.f8720a + i);
        int i11 = this.f8722l;
        if (i < ((i11 + 1) >> 1)) {
            if (m10 == 0) {
                Object[] objArr = this.f8721b;
                objArr.getClass();
                i6 = objArr.length - 1;
            } else {
                i6 = m10 - 1;
            }
            int i12 = this.f8720a;
            if (i12 == 0) {
                Object[] objArr2 = this.f8721b;
                objArr2.getClass();
                i12 = objArr2.length;
            }
            int i13 = i12 - 1;
            int i14 = this.f8720a;
            Object[] objArr3 = this.f8721b;
            if (i6 >= i14) {
                objArr3[i13] = objArr3[i14];
                j.W(i14, i14 + 1, i6 + 1, objArr3, objArr3);
            } else {
                j.W(i14 - 1, i14, objArr3.length, objArr3, objArr3);
                Object[] objArr4 = this.f8721b;
                objArr4[objArr4.length - 1] = objArr4[0];
                j.W(0, 1, i6 + 1, objArr4, objArr4);
            }
            this.f8721b[i6] = obj;
            this.f8720a = i13;
        } else {
            int m11 = m(i11 + this.f8720a);
            Object[] objArr5 = this.f8721b;
            if (m10 < m11) {
                j.W(m10 + 1, m10, m11, objArr5, objArr5);
            } else {
                j.W(1, 0, m11, objArr5, objArr5);
                Object[] objArr6 = this.f8721b;
                objArr6[0] = objArr6[objArr6.length - 1];
                j.W(m10 + 1, m10, objArr6.length - 1, objArr6, objArr6);
            }
            this.f8721b[m10] = obj;
        }
        this.f8722l++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        collection.getClass();
        b bVar = e.Companion;
        int i6 = this.f8722l;
        bVar.getClass();
        b.c(i, i6);
        if (collection.isEmpty()) {
            return false;
        }
        if (i == this.f8722l) {
            return addAll(collection);
        }
        n();
        g(collection.size() + this.f8722l);
        int m10 = m(this.f8722l + this.f8720a);
        int m11 = m(this.f8720a + i);
        int size = collection.size();
        if (i >= ((this.f8722l + 1) >> 1)) {
            int i10 = m11 + size;
            Object[] objArr = this.f8721b;
            if (m11 < m10) {
                int i11 = size + m10;
                if (i11 <= objArr.length) {
                    j.W(i10, m11, m10, objArr, objArr);
                } else if (i10 >= objArr.length) {
                    j.W(i10 - objArr.length, m11, m10, objArr, objArr);
                } else {
                    int length = m10 - (i11 - objArr.length);
                    j.W(0, length, m10, objArr, objArr);
                    Object[] objArr2 = this.f8721b;
                    j.W(i10, m11, length, objArr2, objArr2);
                }
            } else {
                j.W(size, 0, m10, objArr, objArr);
                Object[] objArr3 = this.f8721b;
                if (i10 >= objArr3.length) {
                    j.W(i10 - objArr3.length, m11, objArr3.length, objArr3, objArr3);
                } else {
                    j.W(0, objArr3.length - size, objArr3.length, objArr3, objArr3);
                    Object[] objArr4 = this.f8721b;
                    j.W(i10, m11, objArr4.length - size, objArr4, objArr4);
                }
            }
            e(m11, collection);
            return true;
        }
        int i12 = this.f8720a;
        int i13 = i12 - size;
        Object[] objArr5 = this.f8721b;
        if (m11 < i12) {
            j.W(i13, i12, objArr5.length, objArr5, objArr5);
            Object[] objArr6 = this.f8721b;
            if (size >= m11) {
                j.W(objArr6.length - size, 0, m11, objArr6, objArr6);
            } else {
                j.W(objArr6.length - size, 0, size, objArr6, objArr6);
                Object[] objArr7 = this.f8721b;
                j.W(0, size, m11, objArr7, objArr7);
            }
        } else if (i13 >= 0) {
            j.W(i13, i12, m11, objArr5, objArr5);
        } else {
            i13 += objArr5.length;
            int i14 = m11 - i12;
            int length2 = objArr5.length - i13;
            if (length2 >= i14) {
                j.W(i13, i12, m11, objArr5, objArr5);
            } else {
                j.W(i13, i12, i12 + length2, objArr5, objArr5);
                Object[] objArr8 = this.f8721b;
                j.W(0, this.f8720a + length2, m11, objArr8, objArr8);
            }
        }
        this.f8720a = i13;
        e(k(m11 - size), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        n();
        g(this.f8722l + 1);
        int i = this.f8720a;
        if (i == 0) {
            Object[] objArr = this.f8721b;
            objArr.getClass();
            i = objArr.length;
        }
        int i6 = i - 1;
        this.f8720a = i6;
        this.f8721b[i6] = obj;
        this.f8722l++;
    }

    public final void addLast(Object obj) {
        n();
        g(c() + 1);
        this.f8721b[m(c() + this.f8720a)] = obj;
        this.f8722l = c() + 1;
    }

    @Override // q6.f
    public final int c() {
        return this.f8722l;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        if (!isEmpty()) {
            n();
            l(this.f8720a, m(c() + this.f8720a));
        }
        this.f8720a = 0;
        this.f8722l = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // q6.f
    public final Object d(int i) {
        b bVar = e.Companion;
        int i6 = this.f8722l;
        bVar.getClass();
        b.b(i, i6);
        if (i == c() - 1) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        n();
        int m10 = m(this.f8720a + i);
        Object[] objArr = this.f8721b;
        Object obj = objArr[m10];
        int i10 = this.f8722l >> 1;
        int i11 = this.f8720a;
        if (i < i10) {
            if (m10 >= i11) {
                j.W(i11 + 1, i11, m10, objArr, objArr);
            } else {
                j.W(1, 0, m10, objArr, objArr);
                Object[] objArr2 = this.f8721b;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i12 = this.f8720a;
                j.W(i12 + 1, i12, objArr2.length - 1, objArr2, objArr2);
            }
            Object[] objArr3 = this.f8721b;
            int i13 = this.f8720a;
            objArr3[i13] = null;
            this.f8720a = h(i13);
        } else {
            int m11 = m((c() - 1) + i11);
            Object[] objArr4 = this.f8721b;
            if (m10 <= m11) {
                j.W(m10, m10 + 1, m11 + 1, objArr4, objArr4);
            } else {
                j.W(m10, m10 + 1, objArr4.length, objArr4, objArr4);
                Object[] objArr5 = this.f8721b;
                objArr5[objArr5.length - 1] = objArr5[0];
                j.W(0, 1, m11 + 1, objArr5, objArr5);
            }
            this.f8721b[m11] = null;
        }
        this.f8722l--;
        return obj;
    }

    public final void e(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f8721b.length;
        while (i < length && it.hasNext()) {
            this.f8721b[i] = it.next();
            i++;
        }
        int i6 = this.f8720a;
        for (int i10 = 0; i10 < i6 && it.hasNext(); i10++) {
            this.f8721b[i10] = it.next();
        }
        this.f8722l = collection.size() + this.f8722l;
    }

    public final void g(int i) {
        if (i < 0) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Deque is too big.");
            return;
        }
        Object[] objArr = this.f8721b;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == f8719m) {
            if (i < 10) {
                i = 10;
            }
            this.f8721b = new Object[i];
            return;
        }
        b bVar = e.Companion;
        int length = objArr.length;
        bVar.getClass();
        Object[] objArr2 = new Object[b.e(length, i)];
        Object[] objArr3 = this.f8721b;
        j.W(0, this.f8720a, objArr3.length, objArr3, objArr2);
        Object[] objArr4 = this.f8721b;
        int length2 = objArr4.length;
        int i6 = this.f8720a;
        j.W(length2 - i6, 0, i6, objArr4, objArr2);
        this.f8720a = 0;
        this.f8721b = objArr2;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        b bVar = e.Companion;
        int i6 = this.f8722l;
        bVar.getClass();
        b.b(i, i6);
        return this.f8721b[m(this.f8720a + i)];
    }

    public final int h(int i) {
        this.f8721b.getClass();
        if (i == r0.length - 1) {
            return 0;
        }
        return i + 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        int i;
        int m10 = m(c() + this.f8720a);
        int i6 = this.f8720a;
        if (i6 < m10) {
            while (i6 < m10) {
                if (kotlin.jvm.internal.l.a(obj, this.f8721b[i6])) {
                    i = this.f8720a;
                } else {
                    i6++;
                }
            }
            return -1;
        }
        if (i6 < m10) {
            return -1;
        }
        int length = this.f8721b.length;
        while (true) {
            if (i6 >= length) {
                for (int i10 = 0; i10 < m10; i10++) {
                    if (kotlin.jvm.internal.l.a(obj, this.f8721b[i10])) {
                        i6 = i10 + this.f8721b.length;
                        i = this.f8720a;
                    }
                }
                return -1;
            }
            if (kotlin.jvm.internal.l.a(obj, this.f8721b[i6])) {
                i = this.f8720a;
                break;
            }
            i6++;
        }
        return i6 - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return c() == 0;
    }

    public final int k(int i) {
        return i < 0 ? i + this.f8721b.length : i;
    }

    public final void l(int i, int i6) {
        Object[] objArr = this.f8721b;
        if (i < i6) {
            j.e0(null, objArr, i, i6);
        } else {
            j.e0(null, objArr, i, objArr.length);
            j.e0(null, this.f8721b, 0, i6);
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int length;
        int i;
        int m10 = m(this.f8722l + this.f8720a);
        int i6 = this.f8720a;
        if (i6 < m10) {
            length = m10 - 1;
            if (i6 <= length) {
                while (!kotlin.jvm.internal.l.a(obj, this.f8721b[length])) {
                    if (length != i6) {
                        length--;
                    }
                }
                i = this.f8720a;
                return length - i;
            }
            return -1;
        }
        if (i6 > m10) {
            while (true) {
                m10--;
                Object[] objArr = this.f8721b;
                if (-1 >= m10) {
                    objArr.getClass();
                    length = objArr.length - 1;
                    int i10 = this.f8720a;
                    if (i10 <= length) {
                        while (!kotlin.jvm.internal.l.a(obj, this.f8721b[length])) {
                            if (length != i10) {
                                length--;
                            }
                        }
                        i = this.f8720a;
                    }
                } else if (kotlin.jvm.internal.l.a(obj, objArr[m10])) {
                    length = m10 + this.f8721b.length;
                    i = this.f8720a;
                    break;
                }
            }
        }
        return -1;
    }

    public final int m(int i) {
        Object[] objArr = this.f8721b;
        return i >= objArr.length ? i - objArr.length : i;
    }

    public final void n() {
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        d(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean removeAll(Collection collection) {
        int m10;
        Object[] objArr;
        collection.getClass();
        boolean z9 = false;
        z9 = false;
        z9 = false;
        if (!isEmpty() && this.f8721b.length != 0) {
            int m11 = m(c() + this.f8720a);
            int i = this.f8720a;
            if (i < m11) {
                m10 = i;
                while (true) {
                    objArr = this.f8721b;
                    if (i >= m11) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        z9 = true;
                    } else {
                        this.f8721b[m10] = obj;
                        m10++;
                    }
                    i++;
                }
                j.e0(null, objArr, m10, m11);
            } else {
                int length = this.f8721b.length;
                boolean z10 = false;
                int i6 = i;
                while (i < length) {
                    Object[] objArr2 = this.f8721b;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        z10 = true;
                    } else {
                        this.f8721b[i6] = obj2;
                        i6++;
                    }
                    i++;
                }
                m10 = m(i6);
                for (int i10 = 0; i10 < m11; i10++) {
                    Object[] objArr3 = this.f8721b;
                    Object obj3 = objArr3[i10];
                    objArr3[i10] = null;
                    if (collection.contains(obj3)) {
                        z10 = true;
                    } else {
                        this.f8721b[m10] = obj3;
                        m10 = h(m10);
                    }
                }
                z9 = z10;
            }
            if (z9) {
                n();
                this.f8722l = k(m10 - this.f8720a);
            }
        }
        return z9;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            androidx.privacysandbox.ads.adservices.customaudience.a.s("ArrayDeque is empty.");
            return null;
        }
        n();
        Object[] objArr = this.f8721b;
        int i = this.f8720a;
        Object obj = objArr[i];
        objArr[i] = null;
        this.f8720a = h(i);
        this.f8722l = c() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            androidx.privacysandbox.ads.adservices.customaudience.a.s("ArrayDeque is empty.");
            return null;
        }
        n();
        int m10 = m((size() - 1) + this.f8720a);
        Object[] objArr = this.f8721b;
        Object obj = objArr[m10];
        objArr[m10] = null;
        this.f8722l = c() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i, int i6) {
        b bVar = e.Companion;
        int i10 = this.f8722l;
        bVar.getClass();
        b.d(i, i6, i10);
        int i11 = i6 - i;
        if (i11 == 0) {
            return;
        }
        if (i11 == this.f8722l) {
            clear();
            return;
        }
        if (i11 == 1) {
            d(i);
            return;
        }
        n();
        int i12 = this.f8722l - i6;
        int i13 = this.f8720a;
        if (i < i12) {
            int m10 = m((i - 1) + i13);
            int m11 = m(this.f8720a + (i6 - 1));
            while (i > 0) {
                int i14 = m10 + 1;
                int min = Math.min(i, Math.min(i14, m11 + 1));
                Object[] objArr = this.f8721b;
                int i15 = m11 - min;
                int i16 = m10 - min;
                j.W(i15 + 1, i16 + 1, i14, objArr, objArr);
                m10 = k(i16);
                m11 = k(i15);
                i -= min;
            }
            int m12 = m(this.f8720a + i11);
            l(this.f8720a, m12);
            this.f8720a = m12;
        } else {
            int m13 = m(i13 + i6);
            int m14 = m(this.f8720a + i);
            int i17 = this.f8722l;
            while (true) {
                i17 -= i6;
                if (i17 <= 0) {
                    break;
                }
                Object[] objArr2 = this.f8721b;
                i6 = Math.min(i17, Math.min(objArr2.length - m13, objArr2.length - m14));
                Object[] objArr3 = this.f8721b;
                int i18 = m13 + i6;
                j.W(m14, m13, i18, objArr3, objArr3);
                m13 = m(i18);
                m14 = m(m14 + i6);
            }
            int m15 = m(this.f8722l + this.f8720a);
            l(k(m15 - i11), m15);
        }
        this.f8722l -= i11;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean retainAll(Collection collection) {
        int m10;
        Object[] objArr;
        collection.getClass();
        boolean z9 = false;
        z9 = false;
        z9 = false;
        if (!isEmpty() && this.f8721b.length != 0) {
            int m11 = m(c() + this.f8720a);
            int i = this.f8720a;
            if (i < m11) {
                m10 = i;
                while (true) {
                    objArr = this.f8721b;
                    if (i >= m11) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        this.f8721b[m10] = obj;
                        m10++;
                    } else {
                        z9 = true;
                    }
                    i++;
                }
                j.e0(null, objArr, m10, m11);
            } else {
                int length = this.f8721b.length;
                boolean z10 = false;
                int i6 = i;
                while (i < length) {
                    Object[] objArr2 = this.f8721b;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        this.f8721b[i6] = obj2;
                        i6++;
                    } else {
                        z10 = true;
                    }
                    i++;
                }
                m10 = m(i6);
                for (int i10 = 0; i10 < m11; i10++) {
                    Object[] objArr3 = this.f8721b;
                    Object obj3 = objArr3[i10];
                    objArr3[i10] = null;
                    if (collection.contains(obj3)) {
                        this.f8721b[m10] = obj3;
                        m10 = h(m10);
                    } else {
                        z10 = true;
                    }
                }
                z9 = z10;
            }
            if (z9) {
                n();
                this.f8722l = k(m10 - this.f8720a);
            }
        }
        return z9;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        b bVar = e.Companion;
        int i6 = this.f8722l;
        bVar.getClass();
        b.b(i, i6);
        int m10 = m(this.f8720a + i);
        Object[] objArr = this.f8721b;
        Object obj2 = objArr[m10];
        objArr[m10] = obj;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray(Object[] objArr) {
        objArr.getClass();
        int length = objArr.length;
        int i = this.f8722l;
        if (length < i) {
            Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), i);
            newInstance.getClass();
            objArr = (Object[]) newInstance;
        }
        Object[] objArr2 = objArr;
        int m10 = m(this.f8722l + this.f8720a);
        int i6 = this.f8720a;
        if (i6 < m10) {
            j.c0(this.f8721b, objArr2, 0, i6, m10, 2);
        } else if (!isEmpty()) {
            Object[] objArr3 = this.f8721b;
            j.W(0, this.f8720a, objArr3.length, objArr3, objArr2);
            Object[] objArr4 = this.f8721b;
            j.W(objArr4.length - this.f8720a, 0, m10, objArr4, objArr2);
        }
        int i10 = this.f8722l;
        if (i10 < objArr2.length) {
            objArr2[i10] = null;
        }
        return objArr2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final Object[] toArray() {
        return toArray(new Object[c()]);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        collection.getClass();
        if (collection.isEmpty()) {
            return false;
        }
        n();
        g(collection.size() + c());
        e(m(c() + this.f8720a), collection);
        return true;
    }
}
