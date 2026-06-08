package androidx.collection;

import androidx.annotation.IntRange;
import com.google.gson.internal.a;
import e7.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import k7.f;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import q6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MutableScatterSet<E> extends ScatterSet<E> {
    private int growthLimit;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public final class MutableSetWrapper extends ScatterSet<E>.SetWrapper implements Set<E>, b {
        public MutableSetWrapper() {
            super();
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean add(E e10) {
            return MutableScatterSet.this.add(e10);
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            collection.getClass();
            return MutableScatterSet.this.addAll(collection);
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public void clear() {
            MutableScatterSet.this.clear();
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return new MutableScatterSet$MutableSetWrapper$iterator$1(MutableScatterSet.this);
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            return MutableScatterSet.this.remove(obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean removeAll(Collection<? extends Object> collection) {
            collection.getClass();
            int size = MutableScatterSet.this.getSize();
            Iterator<? extends Object> it = collection.iterator();
            while (it.hasNext()) {
                MutableScatterSet.this.minusAssign((MutableScatterSet<E>) it.next());
            }
            return size != MutableScatterSet.this.getSize();
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean retainAll(Collection<? extends Object> collection) {
            collection.getClass();
            MutableScatterSet<E> mutableScatterSet = MutableScatterSet.this;
            long[] jArr = mutableScatterSet.metadata;
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
                            if (!collection.contains(mutableScatterSet.elements[i11])) {
                                mutableScatterSet.removeElementAt(i11);
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
    }

    public MutableScatterSet(int i) {
        super(null);
        if (i >= 0) {
            initializeStorage(ScatterMapKt.unloadedCapacity(i));
        } else {
            a.p("Capacity must be a positive value.");
            throw null;
        }
    }

    private final void adjustStorage() {
        int i = this._capacity;
        if (i <= 8 || Long.compare((this._size * 32) ^ Long.MIN_VALUE, (i * 25) ^ Long.MIN_VALUE) > 0) {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        } else {
            removeDeletedMarkers();
        }
    }

    private final int findAbsoluteInsertIndex(E e10) {
        int hashCode = (e10 != null ? e10.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i = hashCode ^ (hashCode << 16);
        int i6 = i >>> 7;
        int i10 = i & 127;
        int i11 = this._capacity;
        int i12 = i6 & i11;
        int i13 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i14 = i12 >> 3;
            int i15 = (i12 & 7) << 3;
            long j = ((jArr[i14 + 1] << (64 - i15)) & ((-i15) >> 63)) | (jArr[i14] >>> i15);
            long j6 = i10;
            int i16 = i10;
            long j10 = j ^ (j6 * ScatterMapKt.BitmaskLsb);
            for (long j11 = (~j10) & (j10 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j11 != 0; j11 &= j11 - 1) {
                int numberOfTrailingZeros = (i12 + (Long.numberOfTrailingZeros(j11) >> 3)) & i11;
                if (l.a(this.elements[numberOfTrailingZeros], e10)) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & (-9187201950435737472L)) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i6);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    findFirstAvailableSlot = findFirstAvailableSlot(i6);
                }
                this._size++;
                int i17 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i18 = findFirstAvailableSlot >> 3;
                long j12 = jArr2[i18];
                int i19 = (findFirstAvailableSlot & 7) << 3;
                this.growthLimit = i17 - (((j12 >> i19) & 255) == 128 ? 1 : 0);
                jArr2[i18] = (j12 & (~(255 << i19))) | (j6 << i19);
                int i20 = this._capacity;
                int i21 = ((findFirstAvailableSlot - 7) & i20) + (i20 & 7);
                int i22 = i21 >> 3;
                int i23 = (i21 & 7) << 3;
                jArr2[i22] = ((~(255 << i23)) & jArr2[i22]) | (j6 << i23);
                return findFirstAvailableSlot;
            }
            i13 += 8;
            i12 = (i12 + i13) & i11;
            i10 = i16;
        }
    }

    private final int findFirstAvailableSlot(int i) {
        int i6 = this._capacity;
        int i10 = i & i6;
        int i11 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i12 = i10 >> 3;
            int i13 = (i10 & 7) << 3;
            long j = ((jArr[i12 + 1] << (64 - i13)) & ((-i13) >> 63)) | (jArr[i12] >>> i13);
            long j6 = j & ((~j) << 7) & (-9187201950435737472L);
            if (j6 != 0) {
                return (i10 + (Long.numberOfTrailingZeros(j6) >> 3)) & i6;
            }
            i11 += 8;
            i10 = (i10 + i11) & i6;
        }
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(getCapacity()) - this._size;
    }

    private final void initializeMetadata(int i) {
        long[] jArr;
        if (i == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            jArr = new long[((i + 15) & (-8)) >> 3];
            j.f0(jArr);
        }
        this.metadata = jArr;
        int i6 = i >> 3;
        long j = 255 << ((i & 7) << 3);
        jArr[i6] = (jArr[i6] & (~j)) | j;
        initializeGrowth();
    }

    private final void initializeStorage(int i) {
        int max = i > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(i)) : 0;
        this._capacity = max;
        initializeMetadata(max);
        this.elements = new Object[max];
    }

    private final void removeDeletedMarkers() {
        long[] jArr = this.metadata;
        int i = this._capacity;
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            int i11 = i10 >> 3;
            int i12 = (i10 & 7) << 3;
            if (((jArr[i11] >> i12) & 255) == 254) {
                long[] jArr2 = this.metadata;
                jArr2[i11] = (128 << i12) | (jArr2[i11] & (~(255 << i12)));
                int i13 = this._capacity;
                int i14 = ((i10 - 7) & i13) + (i13 & 7);
                int i15 = i14 >> 3;
                int i16 = (i14 & 7) << 3;
                jArr2[i15] = ((~(255 << i16)) & jArr2[i15]) | (128 << i16);
                i6++;
            }
        }
        this.growthLimit += i6;
    }

    private final void resizeStorage(int i) {
        int i6;
        long[] jArr = this.metadata;
        Object[] objArr = this.elements;
        int i10 = this._capacity;
        initializeStorage(i);
        Object[] objArr2 = this.elements;
        int i11 = 0;
        while (i11 < i10) {
            if (((jArr[i11 >> 3] >> ((i11 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i11];
                int hashCode = (obj != null ? obj.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
                int i12 = hashCode ^ (hashCode << 16);
                int findFirstAvailableSlot = findFirstAvailableSlot(i12 >>> 7);
                long j = i12 & 127;
                long[] jArr2 = this.metadata;
                int i13 = findFirstAvailableSlot >> 3;
                int i14 = (findFirstAvailableSlot & 7) << 3;
                i6 = i11;
                jArr2[i13] = (jArr2[i13] & (~(255 << i14))) | (j << i14);
                int i15 = this._capacity;
                int i16 = ((findFirstAvailableSlot - 7) & i15) + (i15 & 7);
                int i17 = i16 >> 3;
                int i18 = (i16 & 7) << 3;
                jArr2[i17] = ((~(255 << i18)) & jArr2[i17]) | (j << i18);
                objArr2[findFirstAvailableSlot] = obj;
            } else {
                i6 = i11;
            }
            i11 = i6 + 1;
        }
    }

    private final void writeMetadata(int i, long j) {
        long[] jArr = this.metadata;
        int i6 = i >> 3;
        int i10 = (i & 7) << 3;
        jArr[i6] = (jArr[i6] & (~(255 << i10))) | (j << i10);
        int i11 = this._capacity;
        int i12 = ((i - 7) & i11) + (i11 & 7);
        int i13 = i12 >> 3;
        int i14 = (i12 & 7) << 3;
        jArr[i13] = (j << i14) | (jArr[i13] & (~(255 << i14)));
    }

    public final boolean add(E e10) {
        int size = getSize();
        this.elements[findAbsoluteInsertIndex(e10)] = e10;
        return getSize() != size;
    }

    public final boolean addAll(E[] eArr) {
        eArr.getClass();
        int size = getSize();
        plusAssign((Object[]) eArr);
        return size != getSize();
    }

    public final Set<E> asMutableSet() {
        return new MutableSetWrapper();
    }

    public final void clear() {
        this._size = 0;
        long[] jArr = this.metadata;
        if (jArr != ScatterMapKt.EmptyGroup) {
            j.f0(jArr);
            long[] jArr2 = this.metadata;
            int i = this._capacity;
            int i6 = i >> 3;
            long j = 255 << ((i & 7) << 3);
            jArr2[i6] = (jArr2[i6] & (~j)) | j;
        }
        j.e0(null, this.elements, 0, this._capacity);
        initializeGrowth();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
    
        if (((r4 & ((~r4) << 6)) & (-9187201950435737472L)) == 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        r10 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void minusAssign(E r14) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto L8
            int r1 = r14.hashCode()
            goto L9
        L8:
            r1 = r0
        L9:
            r2 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r1 = r1 * r2
            int r2 = r1 << 16
            r1 = r1 ^ r2
            r2 = r1 & 127(0x7f, float:1.78E-43)
            int r3 = r13._capacity
            int r1 = r1 >>> 7
        L16:
            r1 = r1 & r3
            long[] r4 = r13.metadata
            int r5 = r1 >> 3
            r6 = r1 & 7
            int r6 = r6 << 3
            r7 = r4[r5]
            long r7 = r7 >>> r6
            int r5 = r5 + 1
            r9 = r4[r5]
            int r4 = 64 - r6
            long r4 = r9 << r4
            long r9 = (long) r6
            long r9 = -r9
            r6 = 63
            long r9 = r9 >> r6
            long r4 = r4 & r9
            long r4 = r4 | r7
            long r6 = (long) r2
            r8 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r6 = r6 * r8
            long r6 = r6 ^ r4
            long r8 = r6 - r8
            long r6 = ~r6
            long r6 = r6 & r8
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
        L43:
            r10 = 0
            int r12 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r12 == 0) goto L62
            int r10 = java.lang.Long.numberOfTrailingZeros(r6)
            int r10 = r10 >> 3
            int r10 = r10 + r1
            r10 = r10 & r3
            java.lang.Object[] r11 = r13.elements
            r11 = r11[r10]
            boolean r11 = kotlin.jvm.internal.l.a(r11, r14)
            if (r11 == 0) goto L5c
            goto L6c
        L5c:
            r10 = 1
            long r10 = r6 - r10
            long r6 = r6 & r10
            goto L43
        L62:
            long r6 = ~r4
            r12 = 6
            long r6 = r6 << r12
            long r4 = r4 & r6
            long r4 = r4 & r8
            int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r4 == 0) goto L72
            r10 = -1
        L6c:
            if (r10 < 0) goto L71
            r13.removeElementAt(r10)
        L71:
            return
        L72:
            int r0 = r0 + 8
            int r1 = r1 + r0
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.minusAssign(java.lang.Object):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ScatterSet<E> scatterSet) {
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
                        plusAssign((MutableScatterSet<E>) objArr[(i << 3) + i10]);
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

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        if (((r7 & ((~r7) << 6)) & (-9187201950435737472L)) == 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0070, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean remove(E r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 0
            if (r1 == 0) goto Lc
            int r3 = r1.hashCode()
            goto Ld
        Lc:
            r3 = r2
        Ld:
            r4 = -862048943(0xffffffffcc9e2d51, float:-8.293031E7)
            int r3 = r3 * r4
            int r4 = r3 << 16
            r3 = r3 ^ r4
            r4 = r3 & 127(0x7f, float:1.78E-43)
            int r5 = r0._capacity
            int r3 = r3 >>> 7
            r3 = r3 & r5
            r6 = r2
        L1c:
            long[] r7 = r0.metadata
            int r8 = r3 >> 3
            r9 = r3 & 7
            int r9 = r9 << 3
            r10 = r7[r8]
            long r10 = r10 >>> r9
            r12 = 1
            int r8 = r8 + r12
            r13 = r7[r8]
            int r7 = 64 - r9
            long r7 = r13 << r7
            long r13 = (long) r9
            long r13 = -r13
            r9 = 63
            long r13 = r13 >> r9
            long r7 = r7 & r13
            long r7 = r7 | r10
            long r9 = (long) r4
            r13 = 72340172838076673(0x101010101010101, double:7.748604185489348E-304)
            long r9 = r9 * r13
            long r9 = r9 ^ r7
            long r13 = r9 - r13
            long r9 = ~r9
            long r9 = r9 & r13
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r13
        L48:
            r15 = 0
            int r11 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r11 == 0) goto L67
            int r11 = java.lang.Long.numberOfTrailingZeros(r9)
            int r11 = r11 >> 3
            int r11 = r11 + r3
            r11 = r11 & r5
            java.lang.Object[] r15 = r0.elements
            r15 = r15[r11]
            boolean r15 = kotlin.jvm.internal.l.a(r15, r1)
            if (r15 == 0) goto L61
            goto L71
        L61:
            r15 = 1
            long r15 = r9 - r15
            long r9 = r9 & r15
            goto L48
        L67:
            long r9 = ~r7
            r11 = 6
            long r9 = r9 << r11
            long r7 = r7 & r9
            long r7 = r7 & r13
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 == 0) goto L7a
            r11 = -1
        L71:
            if (r11 < 0) goto L74
            r2 = r12
        L74:
            if (r2 == 0) goto L79
            r0.removeElementAt(r11)
        L79:
            return r2
        L7a:
            int r6 = r6 + 8
            int r3 = r3 + r6
            r3 = r3 & r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet.remove(java.lang.Object):boolean");
    }

    public final boolean removeAll(E[] eArr) {
        eArr.getClass();
        int size = getSize();
        minusAssign((Object[]) eArr);
        return size != getSize();
    }

    public final void removeElementAt(int i) {
        this._size--;
        long[] jArr = this.metadata;
        int i6 = i >> 3;
        int i10 = (i & 7) << 3;
        jArr[i6] = (jArr[i6] & (~(255 << i10))) | (254 << i10);
        int i11 = this._capacity;
        int i12 = ((i - 7) & i11) + (i11 & 7);
        int i13 = i12 >> 3;
        int i14 = (i12 & 7) << 3;
        jArr[i13] = (jArr[i13] & (~(255 << i14))) | (254 << i14);
        this.elements[i] = null;
    }

    public final void removeIf(d7.l lVar) {
        lVar.getClass();
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
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
                        int i11 = (i << 3) + i10;
                        if (((Boolean) lVar.invoke(objArr[i11])).booleanValue()) {
                            removeElementAt(i11);
                        }
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

    @IntRange(from = 0)
    public final int trim() {
        int i = this._capacity;
        int normalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (normalizeCapacity >= i) {
            return 0;
        }
        resizeStorage(normalizeCapacity);
        return i - this._capacity;
    }

    public final boolean addAll(Iterable<? extends E> iterable) {
        iterable.getClass();
        int size = getSize();
        plusAssign((Iterable) iterable);
        return size != getSize();
    }

    public final boolean removeAll(f fVar) {
        fVar.getClass();
        int size = getSize();
        minusAssign(fVar);
        return size != getSize();
    }

    public /* synthetic */ MutableScatterSet(int i, int i6, g gVar) {
        this((i6 & 1) != 0 ? 6 : i);
    }

    public MutableScatterSet() {
        this(0, 1, null);
    }

    public final boolean addAll(f fVar) {
        fVar.getClass();
        int size = getSize();
        plusAssign(fVar);
        return size != getSize();
    }

    public final boolean removeAll(Iterable<? extends E> iterable) {
        iterable.getClass();
        int size = getSize();
        minusAssign((Iterable) iterable);
        return size != getSize();
    }

    public final boolean addAll(ScatterSet<E> scatterSet) {
        scatterSet.getClass();
        int size = getSize();
        plusAssign((ScatterSet) scatterSet);
        return size != getSize();
    }

    public final boolean removeAll(ScatterSet<E> scatterSet) {
        scatterSet.getClass();
        int size = getSize();
        minusAssign((ScatterSet) scatterSet);
        return size != getSize();
    }

    public final boolean addAll(ObjectList<E> objectList) {
        objectList.getClass();
        int size = getSize();
        plusAssign((ObjectList) objectList);
        return size != getSize();
    }

    public final boolean removeAll(ObjectList<E> objectList) {
        objectList.getClass();
        int size = getSize();
        minusAssign((ObjectList) objectList);
        return size != getSize();
    }

    public final void plusAssign(E[] eArr) {
        eArr.getClass();
        for (E e10 : eArr) {
            plusAssign((MutableScatterSet<E>) e10);
        }
    }

    public final void plusAssign(Iterable<? extends E> iterable) {
        iterable.getClass();
        Iterator<? extends E> it = iterable.iterator();
        while (it.hasNext()) {
            plusAssign((MutableScatterSet<E>) it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(f fVar) {
        fVar.getClass();
        Iterator it = fVar.iterator();
        while (it.hasNext()) {
            plusAssign((MutableScatterSet<E>) it.next());
        }
    }

    public final void plusAssign(E e10) {
        this.elements[findAbsoluteInsertIndex(e10)] = e10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(ObjectList<E> objectList) {
        objectList.getClass();
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i6 = 0; i6 < i; i6++) {
            plusAssign((MutableScatterSet<E>) objArr[i6]);
        }
    }

    public final void minusAssign(E[] eArr) {
        eArr.getClass();
        for (E e10 : eArr) {
            minusAssign((MutableScatterSet<E>) e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(f fVar) {
        fVar.getClass();
        Iterator it = fVar.iterator();
        while (it.hasNext()) {
            minusAssign((MutableScatterSet<E>) it.next());
        }
    }

    public final void minusAssign(Iterable<? extends E> iterable) {
        iterable.getClass();
        Iterator<? extends E> it = iterable.iterator();
        while (it.hasNext()) {
            minusAssign((MutableScatterSet<E>) it.next());
        }
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
                        minusAssign((MutableScatterSet<E>) objArr[(i << 3) + i10]);
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
    public final void minusAssign(ObjectList<E> objectList) {
        objectList.getClass();
        Object[] objArr = objectList.content;
        int i = objectList._size;
        for (int i6 = 0; i6 < i; i6++) {
            minusAssign((MutableScatterSet<E>) objArr[i6]);
        }
    }
}
