package androidx.collection;

import a3.b;
import com.google.gson.internal.a;
import kotlin.jvm.internal.g;
import q6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CircularArray<E> {
    private int capacityBitmask;
    private E[] elements;
    private int head;
    private int tail;

    public CircularArray(int i) {
        if (i < 1) {
            a.p("capacity must be >= 1");
            throw null;
        }
        if (i > 1073741824) {
            a.p("capacity must be <= 2^30");
            throw null;
        }
        i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
        this.capacityBitmask = i - 1;
        this.elements = (E[]) new Object[i];
    }

    private final void doubleCapacity() {
        E[] eArr = this.elements;
        int length = eArr.length;
        int i = this.head;
        int i6 = length - i;
        int i10 = length << 1;
        if (i10 < 0) {
            b.n("Max array capacity exceeded");
            return;
        }
        E[] eArr2 = (E[]) new Object[i10];
        j.W(0, i, length, eArr, eArr2);
        j.W(i6, 0, this.head, this.elements, eArr2);
        this.elements = eArr2;
        this.head = 0;
        this.tail = length;
        this.capacityBitmask = i10 - 1;
    }

    public final void addFirst(E e10) {
        int i = (this.head - 1) & this.capacityBitmask;
        this.head = i;
        this.elements[i] = e10;
        if (i == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(E e10) {
        E[] eArr = this.elements;
        int i = this.tail;
        eArr[i] = e10;
        int i6 = this.capacityBitmask & (i + 1);
        this.tail = i6;
        if (i6 == this.head) {
            doubleCapacity();
        }
    }

    public final void clear() {
        removeFromStart(size());
    }

    public final E get(int i) {
        if (i < 0 || i >= size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e10 = this.elements[this.capacityBitmask & (this.head + i)];
        e10.getClass();
        return e10;
    }

    public final E getFirst() {
        int i = this.head;
        if (i == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e10 = this.elements[i];
        e10.getClass();
        return e10;
    }

    public final E getLast() {
        int i = this.head;
        int i6 = this.tail;
        if (i == i6) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e10 = this.elements[(i6 - 1) & this.capacityBitmask];
        e10.getClass();
        return e10;
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    public final E popFirst() {
        int i = this.head;
        if (i == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E[] eArr = this.elements;
        E e10 = eArr[i];
        eArr[i] = null;
        this.head = (i + 1) & this.capacityBitmask;
        return e10;
    }

    public final E popLast() {
        int i = this.head;
        int i6 = this.tail;
        if (i == i6) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i10 = this.capacityBitmask & (i6 - 1);
        E[] eArr = this.elements;
        E e10 = eArr[i10];
        eArr[i10] = null;
        this.tail = i10;
        return e10;
    }

    public final void removeFromEnd(int i) {
        if (i <= 0) {
            return;
        }
        if (i > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i6 = this.tail;
        int i10 = i < i6 ? i6 - i : 0;
        for (int i11 = i10; i11 < i6; i11++) {
            this.elements[i11] = null;
        }
        int i12 = this.tail;
        int i13 = i12 - i10;
        int i14 = i - i13;
        this.tail = i12 - i13;
        if (i14 > 0) {
            int length = this.elements.length;
            this.tail = length;
            int i15 = length - i14;
            for (int i16 = i15; i16 < length; i16++) {
                this.elements[i16] = null;
            }
            this.tail = i15;
        }
    }

    public final void removeFromStart(int i) {
        if (i <= 0) {
            return;
        }
        if (i > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int length = this.elements.length;
        int i6 = this.head;
        if (i < length - i6) {
            length = i6 + i;
        }
        while (i6 < length) {
            this.elements[i6] = null;
            i6++;
        }
        int i10 = this.head;
        int i11 = length - i10;
        int i12 = i - i11;
        this.head = this.capacityBitmask & (i10 + i11);
        if (i12 > 0) {
            for (int i13 = 0; i13 < i12; i13++) {
                this.elements[i13] = null;
            }
            this.head = i12;
        }
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public CircularArray() {
        this(0, 1, null);
    }

    public /* synthetic */ CircularArray(int i, int i6, g gVar) {
        this((i6 & 1) != 0 ? 8 : i);
    }
}
