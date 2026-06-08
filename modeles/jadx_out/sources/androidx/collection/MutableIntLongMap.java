package androidx.collection;

import com.google.gson.internal.a;
import d7.p;
import kotlin.jvm.internal.g;
import q6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MutableIntLongMap extends IntLongMap {
    private int growthLimit;

    public MutableIntLongMap(int i) {
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

    private final int findInsertIndex(int i) {
        int i6 = ScatterMapKt.MurmurHashC1 * i;
        int i10 = i6 ^ (i6 << 16);
        int i11 = i10 >>> 7;
        int i12 = i10 & 127;
        int i13 = this._capacity;
        int i14 = i11 & i13;
        int i15 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i16 = i14 >> 3;
            int i17 = (i14 & 7) << 3;
            long j = ((jArr[i16 + 1] << (64 - i17)) & ((-i17) >> 63)) | (jArr[i16] >>> i17);
            long j6 = i12;
            int i18 = i15;
            long j10 = j ^ (j6 * ScatterMapKt.BitmaskLsb);
            for (long j11 = (~j10) & (j10 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j11 != 0; j11 &= j11 - 1) {
                int numberOfTrailingZeros = (i14 + (Long.numberOfTrailingZeros(j11) >> 3)) & i13;
                if (this.keys[numberOfTrailingZeros] == i) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & (-9187201950435737472L)) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i11);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    findFirstAvailableSlot = findFirstAvailableSlot(i11);
                }
                this._size++;
                int i19 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i20 = findFirstAvailableSlot >> 3;
                long j12 = jArr2[i20];
                int i21 = (findFirstAvailableSlot & 7) << 3;
                this.growthLimit = i19 - (((j12 >> i21) & 255) == 128 ? 1 : 0);
                jArr2[i20] = (j12 & (~(255 << i21))) | (j6 << i21);
                int i22 = this._capacity;
                int i23 = ((findFirstAvailableSlot - 7) & i22) + (i22 & 7);
                int i24 = i23 >> 3;
                int i25 = (i23 & 7) << 3;
                jArr2[i24] = ((~(255 << i25)) & jArr2[i24]) | (j6 << i25);
                return ~findFirstAvailableSlot;
            }
            i15 = i18 + 8;
            i14 = (i14 + i15) & i13;
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
        this.keys = new int[max];
        this.values = new long[max];
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
        long[] jArr;
        MutableIntLongMap mutableIntLongMap = this;
        long[] jArr2 = mutableIntLongMap.metadata;
        int[] iArr = mutableIntLongMap.keys;
        long[] jArr3 = mutableIntLongMap.values;
        int i6 = mutableIntLongMap._capacity;
        initializeStorage(i);
        int[] iArr2 = mutableIntLongMap.keys;
        long[] jArr4 = mutableIntLongMap.values;
        int i10 = 0;
        while (i10 < i6) {
            if (((jArr2[i10 >> 3] >> ((i10 & 7) << 3)) & 255) < 128) {
                int i11 = iArr[i10];
                int i12 = ScatterMapKt.MurmurHashC1 * i11;
                int i13 = i12 ^ (i12 << 16);
                int findFirstAvailableSlot = mutableIntLongMap.findFirstAvailableSlot(i13 >>> 7);
                long j = i13 & 127;
                long[] jArr5 = mutableIntLongMap.metadata;
                int i14 = findFirstAvailableSlot >> 3;
                int i15 = (findFirstAvailableSlot & 7) << 3;
                jArr5[i14] = (jArr5[i14] & (~(255 << i15))) | (j << i15);
                int i16 = mutableIntLongMap._capacity;
                int i17 = ((findFirstAvailableSlot - 7) & i16) + (i16 & 7);
                int i18 = i17 >> 3;
                int i19 = (i17 & 7) << 3;
                jArr = jArr2;
                jArr5[i18] = ((~(255 << i19)) & jArr5[i18]) | (j << i19);
                iArr2[findFirstAvailableSlot] = i11;
                jArr4[findFirstAvailableSlot] = jArr3[i10];
            } else {
                jArr = jArr2;
            }
            i10++;
            mutableIntLongMap = this;
            jArr2 = jArr;
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
        initializeGrowth();
    }

    public final long getOrPut(int i, d7.a aVar) {
        aVar.getClass();
        int findKeyIndex = findKeyIndex(i);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        long longValue = ((Number) aVar.invoke()).longValue();
        put(i, longValue);
        return longValue;
    }

    public final void minusAssign(IntSet intSet) {
        intSet.getClass();
        int[] iArr = intSet.elements;
        long[] jArr = intSet.metadata;
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
                        remove(iArr[(i << 3) + i10]);
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

    public final void plusAssign(IntLongMap intLongMap) {
        intLongMap.getClass();
        putAll(intLongMap);
    }

    public final long put(int i, long j, long j6) {
        int findInsertIndex = findInsertIndex(i);
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        } else {
            j6 = this.values[findInsertIndex];
        }
        this.keys[findInsertIndex] = i;
        this.values[findInsertIndex] = j;
        return j6;
    }

    public final void putAll(IntLongMap intLongMap) {
        intLongMap.getClass();
        int[] iArr = intLongMap.keys;
        long[] jArr = intLongMap.values;
        long[] jArr2 = intLongMap.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr2[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j) < 128) {
                        int i11 = (i << 3) + i10;
                        set(iArr[i11], jArr[i11]);
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

    public final boolean remove(int i, long j) {
        int findKeyIndex = findKeyIndex(i);
        if (findKeyIndex < 0 || this.values[findKeyIndex] != j) {
            return false;
        }
        removeValueAt(findKeyIndex);
        return true;
    }

    public final void removeIf(p pVar) {
        pVar.getClass();
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
                        if (((Boolean) pVar.invoke(Integer.valueOf(this.keys[i11]), Long.valueOf(this.values[i11]))).booleanValue()) {
                            removeValueAt(i11);
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

    public final void removeValueAt(int i) {
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
    }

    public final void set(int i, long j) {
        int findInsertIndex = findInsertIndex(i);
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        }
        this.keys[findInsertIndex] = i;
        this.values[findInsertIndex] = j;
    }

    public final int trim() {
        int i = this._capacity;
        int normalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (normalizeCapacity >= i) {
            return 0;
        }
        resizeStorage(normalizeCapacity);
        return i - this._capacity;
    }

    public /* synthetic */ MutableIntLongMap(int i, int i6, g gVar) {
        this((i6 & 1) != 0 ? 6 : i);
    }

    public final void remove(int i) {
        int findKeyIndex = findKeyIndex(i);
        if (findKeyIndex >= 0) {
            removeValueAt(findKeyIndex);
        }
    }

    public MutableIntLongMap() {
        this(0, 1, null);
    }

    public final void put(int i, long j) {
        set(i, j);
    }

    public final void minusAssign(int[] iArr) {
        iArr.getClass();
        for (int i : iArr) {
            remove(i);
        }
    }

    public final void minusAssign(int i) {
        remove(i);
    }

    public final void minusAssign(IntList intList) {
        intList.getClass();
        int[] iArr = intList.content;
        int i = intList._size;
        for (int i6 = 0; i6 < i; i6++) {
            remove(iArr[i6]);
        }
    }
}
