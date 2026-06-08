package androidx.collection;

import a3.b;
import a4.x;
import androidx.annotation.IntRange;
import d7.l;
import e7.a;
import i7.d;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.g;
import q6.j;
import q6.m;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MutableObjectList<E> extends ObjectList<E> {
    private ObjectListMutableList<E> list;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class MutableObjectListIterator<T> implements ListIterator<T>, a {
        private final List<T> list;
        private int prevIndex;

        public MutableObjectListIterator(List<T> list, int i) {
            list.getClass();
            this.list = list;
            this.prevIndex = i - 1;
        }

        @Override // java.util.ListIterator
        public void add(T t9) {
            List<T> list = this.list;
            int i = this.prevIndex + 1;
            this.prevIndex = i;
            list.add(i, t9);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.prevIndex < this.list.size() - 1;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.prevIndex >= 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            List<T> list = this.list;
            int i = this.prevIndex + 1;
            this.prevIndex = i;
            return list.get(i);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.prevIndex + 1;
        }

        @Override // java.util.ListIterator
        public T previous() {
            List<T> list = this.list;
            int i = this.prevIndex;
            this.prevIndex = i - 1;
            return list.get(i);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.prevIndex;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.list.remove(this.prevIndex);
            this.prevIndex--;
        }

        @Override // java.util.ListIterator
        public void set(T t9) {
            this.list.set(this.prevIndex, t9);
        }
    }

    public /* synthetic */ MutableObjectList(int i, int i6, g gVar) {
        this((i6 & 1) != 0 ? 16 : i);
    }

    public static /* synthetic */ void trim$default(MutableObjectList mutableObjectList, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = mutableObjectList._size;
        }
        mutableObjectList.trim(i);
    }

    public final void add(@IntRange(from = 0) int i, E e10) {
        int i6;
        if (i < 0 || i > (i6 = this._size)) {
            com.google.gson.internal.a.g(this._size, x.p(i, "Index ", " must be in 0.."));
            return;
        }
        ensureCapacity(i6 + 1);
        Object[] objArr = this.content;
        int i10 = this._size;
        if (i != i10) {
            j.W(i + 1, i, i10, objArr, objArr);
        }
        objArr[i] = e10;
        this._size++;
    }

    public final boolean addAll(@IntRange(from = 0) int i, Collection<? extends E> collection) {
        collection.getClass();
        if (i < 0 || i > this._size) {
            com.google.gson.internal.a.g(this._size, x.p(i, "Index ", " must be in 0.."));
            return false;
        }
        int i6 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        ensureCapacity(collection.size() + this._size);
        Object[] objArr = this.content;
        if (i != this._size) {
            j.W(collection.size() + i, i, this._size, objArr, objArr);
        }
        for (Object obj : collection) {
            int i10 = i6 + 1;
            if (i6 < 0) {
                m.h0();
                throw null;
            }
            objArr[i6 + i] = obj;
            i6 = i10;
        }
        this._size = collection.size() + this._size;
        return true;
    }

    @Override // androidx.collection.ObjectList
    public List<E> asList() {
        return asMutableList();
    }

    public final List<E> asMutableList() {
        ObjectListMutableList<E> objectListMutableList = this.list;
        if (objectListMutableList != null) {
            return objectListMutableList;
        }
        ObjectListMutableList<E> objectListMutableList2 = new ObjectListMutableList<>(this);
        this.list = objectListMutableList2;
        return objectListMutableList2;
    }

    public final void clear() {
        j.e0(null, this.content, 0, this._size);
        this._size = 0;
    }

    public final void ensureCapacity(int i) {
        Object[] objArr = this.content;
        if (objArr.length < i) {
            this.content = Arrays.copyOf(objArr, Math.max(i, (objArr.length * 3) / 2));
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ScatterSet<E> scatterSet) {
        scatterSet.getClass();
        Object[] objArr = scatterSet.elements;
        long[] jArr = scatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j) < 128) {
                        remove(objArr[(i << 3) + i10]);
                    }
                    j >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ScatterSet<E> scatterSet) {
        scatterSet.getClass();
        if (scatterSet.isEmpty()) {
            return;
        }
        ensureCapacity(scatterSet.getSize() + this._size);
        Object[] objArr = scatterSet.elements;
        long[] jArr = scatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j) < 128) {
                        add(objArr[(i << 3) + i10]);
                    }
                    j >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final boolean remove(E e10) {
        int indexOf = indexOf(e10);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(E[] eArr) {
        eArr.getClass();
        int i = this._size;
        for (E e10 : eArr) {
            remove(e10);
        }
        return i != this._size;
    }

    public final E removeAt(@IntRange(from = 0) int i) {
        int i6;
        if (i < 0 || i >= (i6 = this._size)) {
            com.google.gson.internal.a.g(this._size - 1, x.p(i, "Index ", " must be in 0.."));
            return null;
        }
        Object[] objArr = this.content;
        E e10 = (E) objArr[i];
        if (i != i6 - 1) {
            j.W(i, i + 1, i6, objArr, objArr);
        }
        int i10 = this._size - 1;
        this._size = i10;
        objArr[i10] = null;
        return e10;
    }

    public final void removeIf(l lVar) {
        lVar.getClass();
        int i = this._size;
        Object[] objArr = this.content;
        int i6 = 0;
        d K = f.K(0, i);
        int i10 = K.f5695a;
        int i11 = K.f5696b;
        if (i10 <= i11) {
            while (true) {
                objArr[i10 - i6] = objArr[i10];
                if (((Boolean) lVar.invoke(objArr[i10])).booleanValue()) {
                    i6++;
                }
                if (i10 == i11) {
                    break;
                } else {
                    i10++;
                }
            }
        }
        j.e0(null, objArr, i - i6, i);
        this._size -= i6;
    }

    public final void removeRange(@IntRange(from = 0) int i, @IntRange(from = 0) int i6) {
        int i10;
        if (i < 0 || i > (i10 = this._size) || i6 < 0 || i6 > i10) {
            b.j(i, i6, this._size);
            return;
        }
        if (i6 < i) {
            com.google.gson.internal.a.j("Start (", i, ") is more than end (", i6, 41);
            return;
        }
        if (i6 != i) {
            if (i6 < i10) {
                Object[] objArr = this.content;
                j.W(i, i6, i10, objArr, objArr);
            }
            int i11 = this._size;
            int i12 = i11 - (i6 - i);
            j.e0(null, this.content, i12, i11);
            this._size = i12;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0031, code lost:
    
        if (r4 < 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        if (r3 != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        removeAt(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean retainAll(k7.f r11) {
        /*
            r10 = this;
            r11.getClass()
            int r0 = r10._size
            java.lang.Object[] r1 = r10.content
            int r2 = r0 + (-1)
        L9:
            r3 = 0
            r4 = -1
            r5 = 1
            if (r4 >= r2) goto L3c
            r6 = r1[r2]
            java.util.Iterator r7 = r11.iterator()
            r8 = r3
        L15:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L31
            java.lang.Object r9 = r7.next()
            if (r8 < 0) goto L2c
            boolean r9 = kotlin.jvm.internal.l.a(r6, r9)
            if (r9 == 0) goto L29
            r4 = r8
            goto L31
        L29:
            int r8 = r8 + 1
            goto L15
        L2c:
            q6.m.h0()
            r11 = 0
            throw r11
        L31:
            if (r4 < 0) goto L34
            r3 = r5
        L34:
            if (r3 != 0) goto L39
            r10.removeAt(r2)
        L39:
            int r2 = r2 + (-1)
            goto L9
        L3c:
            int r11 = r10._size
            if (r0 == r11) goto L41
            return r5
        L41:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableObjectList.retainAll(k7.f):boolean");
    }

    public final E set(@IntRange(from = 0) int i, E e10) {
        if (i < 0 || i >= this._size) {
            com.google.gson.internal.a.g(this._size - 1, x.p(i, "set index ", " must be between 0 .. "));
            return null;
        }
        Object[] objArr = this.content;
        E e11 = (E) objArr[i];
        objArr[i] = e10;
        return e11;
    }

    public final void trim(int i) {
        int max = Math.max(i, this._size);
        Object[] objArr = this.content;
        if (objArr.length > max) {
            this.content = Arrays.copyOf(objArr, max);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class ObjectListMutableList<T> implements List<T>, e7.b {
        private final MutableObjectList<T> objectList;

        public ObjectListMutableList(MutableObjectList<T> mutableObjectList) {
            mutableObjectList.getClass();
            this.objectList = mutableObjectList;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T t9) {
            return this.objectList.add(t9);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> collection) {
            collection.getClass();
            return this.objectList.addAll(collection);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.objectList.clear();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.objectList.contains(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> collection) {
            collection.getClass();
            return this.objectList.containsAll(collection);
        }

        @Override // java.util.List
        public T get(int i) {
            ObjectListKt.checkIndex(this, i);
            return this.objectList.get(i);
        }

        public int getSize() {
            return this.objectList.getSize();
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.objectList.indexOf(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.objectList.isEmpty();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.objectList.lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            return this.objectList.remove(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> collection) {
            collection.getClass();
            return this.objectList.removeAll(collection);
        }

        public T removeAt(int i) {
            ObjectListKt.checkIndex(this, i);
            return this.objectList.removeAt(i);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> collection) {
            collection.getClass();
            return this.objectList.retainAll((Collection<? extends T>) collection);
        }

        @Override // java.util.List
        public T set(int i, T t9) {
            ObjectListKt.checkIndex(this, i);
            return this.objectList.set(i, t9);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public List<T> subList(int i, int i6) {
            ObjectListKt.checkSubIndex(this, i, i6);
            return new SubList(this, i, i6);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            tArr.getClass();
            return (T[]) kotlin.jvm.internal.l.k(this, tArr);
        }

        @Override // java.util.List
        public void add(int i, T t9) {
            this.objectList.add(i, t9);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int i) {
            return new MutableObjectListIterator(this, i);
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i) {
            return removeAt(i);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return kotlin.jvm.internal.l.j(this);
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends T> collection) {
            collection.getClass();
            return this.objectList.addAll(i, collection);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class SubList<T> implements List<T>, e7.b {
        private int end;
        private final List<T> list;
        private final int start;

        public SubList(List<T> list, int i, int i6) {
            list.getClass();
            this.list = list;
            this.start = i;
            this.end = i6;
        }

        @Override // java.util.List
        public void add(int i, T t9) {
            this.list.add(i + this.start, t9);
            this.end++;
        }

        @Override // java.util.List
        public boolean addAll(int i, Collection<? extends T> collection) {
            collection.getClass();
            this.list.addAll(i + this.start, collection);
            this.end = collection.size() + this.end;
            return collection.size() > 0;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i = this.end - 1;
            int i6 = this.start;
            if (i6 <= i) {
                while (true) {
                    this.list.remove(i);
                    if (i == i6) {
                        break;
                    } else {
                        i--;
                    }
                }
            }
            this.end = this.start;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            int i = this.end;
            for (int i6 = this.start; i6 < i; i6++) {
                if (kotlin.jvm.internal.l.a(this.list.get(i6), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection<? extends Object> collection) {
            collection.getClass();
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public T get(int i) {
            ObjectListKt.checkIndex(this, i);
            return this.list.get(i + this.start);
        }

        public int getSize() {
            return this.end - this.start;
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int i = this.end;
            for (int i6 = this.start; i6 < i; i6++) {
                if (kotlin.jvm.internal.l.a(this.list.get(i6), obj)) {
                    return i6 - this.start;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.end == this.start;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int i = this.end - 1;
            int i6 = this.start;
            if (i6 > i) {
                return -1;
            }
            while (!kotlin.jvm.internal.l.a(this.list.get(i), obj)) {
                if (i == i6) {
                    return -1;
                }
                i--;
            }
            return i - this.start;
        }

        @Override // java.util.List
        public ListIterator<T> listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            int i = this.end;
            for (int i6 = this.start; i6 < i; i6++) {
                if (kotlin.jvm.internal.l.a(this.list.get(i6), obj)) {
                    this.list.remove(i6);
                    this.end--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection<? extends Object> collection) {
            collection.getClass();
            int i = this.end;
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i != this.end;
        }

        public T removeAt(int i) {
            ObjectListKt.checkIndex(this, i);
            this.end--;
            return this.list.remove(i + this.start);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection<? extends Object> collection) {
            collection.getClass();
            int i = this.end;
            int i6 = i - 1;
            int i10 = this.start;
            if (i10 <= i6) {
                while (true) {
                    if (!collection.contains(this.list.get(i6))) {
                        this.list.remove(i6);
                        this.end--;
                    }
                    if (i6 == i10) {
                        break;
                    }
                    i6--;
                }
            }
            return i != this.end;
        }

        @Override // java.util.List
        public T set(int i, T t9) {
            ObjectListKt.checkIndex(this, i);
            return this.list.set(i + this.start, t9);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.List
        public List<T> subList(int i, int i6) {
            ObjectListKt.checkSubIndex(this, i, i6);
            return new SubList(this, i, i6);
        }

        @Override // java.util.List, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            tArr.getClass();
            return (T[]) kotlin.jvm.internal.l.k(this, tArr);
        }

        @Override // java.util.List
        public ListIterator<T> listIterator(int i) {
            return new MutableObjectListIterator(this, i);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return kotlin.jvm.internal.l.j(this);
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(T t9) {
            List<T> list = this.list;
            int i = this.end;
            this.end = i + 1;
            list.add(i, t9);
            return true;
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection<? extends T> collection) {
            collection.getClass();
            this.list.addAll(this.end, collection);
            this.end = collection.size() + this.end;
            return collection.size() > 0;
        }

        @Override // java.util.List
        public final /* bridge */ T remove(int i) {
            return removeAt(i);
        }
    }

    public MutableObjectList() {
        this(0, 1, null);
    }

    public MutableObjectList(int i) {
        super(i, null);
    }

    public final boolean removeAll(ObjectList<E> objectList) {
        objectList.getClass();
        int i = this._size;
        minusAssign((ObjectList) objectList);
        return i != this._size;
    }

    public final boolean removeAll(ScatterSet<E> scatterSet) {
        scatterSet.getClass();
        int i = this._size;
        minusAssign((ScatterSet) scatterSet);
        return i != this._size;
    }

    public final boolean removeAll(List<? extends E> list) {
        list.getClass();
        int i = this._size;
        minusAssign((List) list);
        return i != this._size;
    }

    public final boolean removeAll(Iterable<? extends E> iterable) {
        iterable.getClass();
        int i = this._size;
        minusAssign((Iterable) iterable);
        return i != this._size;
    }

    public final boolean removeAll(k7.f fVar) {
        fVar.getClass();
        int i = this._size;
        minusAssign(fVar);
        return i != this._size;
    }

    public final boolean add(E e10) {
        ensureCapacity(this._size + 1);
        Object[] objArr = this.content;
        int i = this._size;
        objArr[i] = e10;
        this._size = i + 1;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean retainAll(ObjectList<E> objectList) {
        objectList.getClass();
        int i = this._size;
        Object[] objArr = this.content;
        for (int i6 = i - 1; -1 < i6; i6--) {
            if (!objectList.contains(objArr[i6])) {
                removeAt(i6);
            }
        }
        return i != this._size;
    }

    public final void minusAssign(List<? extends E> list) {
        list.getClass();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            remove(list.get(i));
        }
    }

    public final boolean retainAll(Collection<? extends E> collection) {
        collection.getClass();
        int i = this._size;
        Object[] objArr = this.content;
        for (int i6 = i - 1; -1 < i6; i6--) {
            if (!collection.contains(objArr[i6])) {
                removeAt(i6);
            }
        }
        return i != this._size;
    }

    public final void minusAssign(E[] eArr) {
        eArr.getClass();
        for (E e10 : eArr) {
            remove(e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(ObjectList<E> objectList) {
        objectList.getClass();
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i6 = 0; i6 < i; i6++) {
            remove(objArr[i6]);
        }
    }

    public final boolean retainAll(Iterable<? extends E> iterable) {
        iterable.getClass();
        int i = this._size;
        Object[] objArr = this.content;
        for (int i6 = i - 1; -1 < i6; i6--) {
            if (!q6.l.o0(iterable, objArr[i6])) {
                removeAt(i6);
            }
        }
        return i != this._size;
    }

    public final void minusAssign(E e10) {
        remove(e10);
    }

    public final void minusAssign(Iterable<? extends E> iterable) {
        iterable.getClass();
        Iterator<? extends E> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(k7.f fVar) {
        fVar.getClass();
        Iterator it = fVar.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    public final boolean retainAll(E[] eArr) {
        eArr.getClass();
        int i = this._size;
        Object[] objArr = this.content;
        for (int i6 = i - 1; -1 < i6; i6--) {
            if (j.j0(eArr, objArr[i6]) < 0) {
                removeAt(i6);
            }
        }
        return i != this._size;
    }

    public final void plusAssign(ObjectList<E> objectList) {
        objectList.getClass();
        if (objectList.isEmpty()) {
            return;
        }
        ensureCapacity(this._size + objectList._size);
        j.W(this._size, 0, objectList._size, objectList.content, this.content);
        this._size += objectList._size;
    }

    public final void plusAssign(E[] eArr) {
        eArr.getClass();
        if (eArr.length == 0) {
            return;
        }
        ensureCapacity(this._size + eArr.length);
        j.c0(eArr, this.content, this._size, 0, 0, 12);
        this._size += eArr.length;
    }

    public final boolean addAll(@IntRange(from = 0) int i, E[] eArr) {
        int i6;
        eArr.getClass();
        if (i >= 0 && i <= (i6 = this._size)) {
            if (eArr.length == 0) {
                return false;
            }
            ensureCapacity(i6 + eArr.length);
            Object[] objArr = this.content;
            int i10 = this._size;
            if (i != i10) {
                j.W(eArr.length + i, i, i10, objArr, objArr);
            }
            j.c0(eArr, objArr, i, 0, 0, 12);
            this._size += eArr.length;
            return true;
        }
        com.google.gson.internal.a.g(this._size, x.p(i, "Index ", " must be in 0.."));
        return false;
    }

    public final void plusAssign(List<? extends E> list) {
        list.getClass();
        if (list.isEmpty()) {
            return;
        }
        int i = this._size;
        ensureCapacity(list.size() + i);
        Object[] objArr = this.content;
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            objArr[i6 + i] = list.get(i6);
        }
        this._size = list.size() + this._size;
    }

    public final void plusAssign(E e10) {
        add(e10);
    }

    public final void plusAssign(Iterable<? extends E> iterable) {
        iterable.getClass();
        Iterator<? extends E> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(k7.f fVar) {
        fVar.getClass();
        Iterator it = fVar.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public final boolean addAll(@IntRange(from = 0) int i, ObjectList<E> objectList) {
        objectList.getClass();
        if (i >= 0 && i <= this._size) {
            if (objectList.isEmpty()) {
                return false;
            }
            ensureCapacity(this._size + objectList._size);
            Object[] objArr = this.content;
            int i6 = this._size;
            if (i != i6) {
                j.W(objectList._size + i, i, i6, objArr, objArr);
            }
            j.W(i, 0, objectList._size, objectList.content, objArr);
            this._size += objectList._size;
            return true;
        }
        com.google.gson.internal.a.g(this._size, x.p(i, "Index ", " must be in 0.."));
        return false;
    }

    public final boolean addAll(ObjectList<E> objectList) {
        objectList.getClass();
        int i = this._size;
        plusAssign((ObjectList) objectList);
        return i != this._size;
    }

    public final boolean addAll(ScatterSet<E> scatterSet) {
        scatterSet.getClass();
        int i = this._size;
        plusAssign((ScatterSet) scatterSet);
        return i != this._size;
    }

    public final boolean addAll(E[] eArr) {
        eArr.getClass();
        int i = this._size;
        plusAssign((Object[]) eArr);
        return i != this._size;
    }

    public final boolean addAll(List<? extends E> list) {
        list.getClass();
        int i = this._size;
        plusAssign((List) list);
        return i != this._size;
    }

    public final boolean addAll(Iterable<? extends E> iterable) {
        iterable.getClass();
        int i = this._size;
        plusAssign((Iterable) iterable);
        return i != this._size;
    }

    public final boolean addAll(k7.f fVar) {
        fVar.getClass();
        int i = this._size;
        plusAssign(fVar);
        return i != this._size;
    }
}
