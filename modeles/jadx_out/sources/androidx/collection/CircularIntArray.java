package androidx.collection;

import a3.b;
import com.google.gson.internal.a;
import kotlin.jvm.internal.g;
import q6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CircularIntArray {
    private int capacityBitmask;
    private int[] elements;
    private int head;
    private int tail;

    public CircularIntArray(int i) {
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
        this.elements = new int[i];
    }

    private final void doubleCapacity() {
        int[] iArr = this.elements;
        int length = iArr.length;
        int i = this.head;
        int i6 = length - i;
        int i10 = length << 1;
        if (i10 < 0) {
            b.n("Max array capacity exceeded");
            return;
        }
        int[] iArr2 = new int[i10];
        j.X(0, i, iArr, iArr2, length);
        j.X(i6, 0, this.elements, iArr2, this.head);
        this.elements = iArr2;
        this.head = 0;
        this.tail = length;
        this.capacityBitmask = i10 - 1;
    }

    public final void addFirst(int i) {
        int i6 = (this.head - 1) & this.capacityBitmask;
        this.head = i6;
        this.elements[i6] = i;
        if (i6 == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(int i) {
        int[] iArr = this.elements;
        int i6 = this.tail;
        iArr[i6] = i;
        int i10 = this.capacityBitmask & (i6 + 1);
        this.tail = i10;
        if (i10 == this.head) {
            doubleCapacity();
        }
    }

    public final void clear() {
        this.tail = this.head;
    }

    public final int get(int i) {
        if (i < 0 || i >= size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.elements[this.capacityBitmask & (this.head + i)];
    }

    public final int getFirst() {
        int i = this.head;
        if (i != this.tail) {
            return this.elements[i];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int getLast() {
        int i = this.head;
        int i6 = this.tail;
        if (i != i6) {
            return this.elements[(i6 - 1) & this.capacityBitmask];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final boolean isEmpty() {
        return this.head == this.tail;
    }

    public final int popFirst() {
        int i = this.head;
        if (i == this.tail) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i6 = this.elements[i];
        this.head = (i + 1) & this.capacityBitmask;
        return i6;
    }

    public final int popLast() {
        int i = this.head;
        int i6 = this.tail;
        if (i == i6) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        int i10 = this.capacityBitmask & (i6 - 1);
        int i11 = this.elements[i10];
        this.tail = i10;
        return i11;
    }

    public final void removeFromEnd(int i) {
        if (i <= 0) {
            return;
        }
        if (i > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        this.tail = this.capacityBitmask & (this.tail - i);
    }

    public final void removeFromStart(int i) {
        if (i <= 0) {
            return;
        }
        if (i > size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        this.head = this.capacityBitmask & (this.head + i);
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public CircularIntArray() {
        this(0, 1, null);
    }

    public /* synthetic */ CircularIntArray(int i, int i6, g gVar) {
        this((i6 & 1) != 0 ? 8 : i);
    }
}
