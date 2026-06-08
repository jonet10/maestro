package androidx.collection;

import com.google.gson.internal.a;
import d7.p;
import kotlin.jvm.internal.g;
import q6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MutableLongIntMap extends LongIntMap {
    private int growthLimit;

    public MutableLongIntMap(int i) {
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

    private final int findInsertIndex(long j) {
        int i = ((int) (j ^ (j >>> 32))) * ScatterMapKt.MurmurHashC1;
        int i6 = i ^ (i << 16);
        int i10 = i6 >>> 7;
        int i11 = i6 & 127;
        int i12 = this._capacity;
        int i13 = i10 & i12;
        int i14 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i15 = i13 >> 3;
            int i16 = (i13 & 7) << 3;
            long j6 = ((jArr[i15 + 1] << (64 - i16)) & ((-i16) >> 63)) | (jArr[i15] >>> i16);
            long j10 = i11;
            int i17 = i14;
            long j11 = j6 ^ (j10 * ScatterMapKt.BitmaskLsb);
            for (long j12 = (~j11) & (j11 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j12 != 0; j12 &= j12 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j12) >> 3) + i13) & i12;
                if (this.keys[numberOfTrailingZeros] == j) {
                    return numberOfTrailingZeros;
                }
            }
            if ((((~j6) << 6) & j6 & (-9187201950435737472L)) != 0) {
                int findFirstAvailableSlot = findFirstAvailableSlot(i10);
                if (this.growthLimit == 0 && ((this.metadata[findFirstAvailableSlot >> 3] >> ((findFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    findFirstAvailableSlot = findFirstAvailableSlot(i10);
                }
                this._size++;
                int i18 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i19 = findFirstAvailableSlot >> 3;
                long j13 = jArr2[i19];
                int i20 = (findFirstAvailableSlot & 7) << 3;
                this.growthLimit = i18 - (((j13 >> i20) & 255) == 128 ? 1 : 0);
                jArr2[i19] = (j13 & (~(255 << i20))) | (j10 << i20);
                int i21 = this._capacity;
                int i22 = ((findFirstAvailableSlot - 7) & i21) + (i21 & 7);
                int i23 = i22 >> 3;
                int i24 = (i22 & 7) << 3;
                jArr2[i23] = ((~(255 << i24)) & jArr2[i23]) | (j10 << i24);
                return ~findFirstAvailableSlot;
            }
            i14 = i17 + 8;
            i13 = (i13 + i14) & i12;
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
        this.keys = new long[max];
        this.values = new int[max];
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
        MutableLongIntMap mutableLongIntMap = this;
        long[] jArr2 = mutableLongIntMap.metadata;
        long[] jArr3 = mutableLongIntMap.keys;
        int[] iArr = mutableLongIntMap.values;
        int i6 = mutableLongIntMap._capacity;
        initializeStorage(i);
        long[] jArr4 = mutableLongIntMap.keys;
        int[] iArr2 = mutableLongIntMap.values;
        int i10 = 0;
        while (i10 < i6) {
            if (((jArr2[i10 >> 3] >> ((i10 & 7) << 3)) & 255) < 128) {
                long j = jArr3[i10];
                int i11 = ((int) ((j >>> 32) ^ j)) * ScatterMapKt.MurmurHashC1;
                int i12 = i11 ^ (i11 << 16);
                int findFirstAvailableSlot = mutableLongIntMap.findFirstAvailableSlot(i12 >>> 7);
                long j6 = i12 & 127;
                long[] jArr5 = mutableLongIntMap.metadata;
                int i13 = findFirstAvailableSlot >> 3;
                int i14 = (findFirstAvailableSlot & 7) << 3;
                jArr5[i13] = (jArr5[i13] & (~(255 << i14))) | (j6 << i14);
                int i15 = mutableLongIntMap._capacity;
                int i16 = ((findFirstAvailableSlot - 7) & i15) + (i15 & 7);
                int i17 = i16 >> 3;
                int i18 = (i16 & 7) << 3;
                jArr = jArr2;
                jArr5[i17] = (jArr5[i17] & (~(255 << i18))) | (j6 << i18);
                jArr4[findFirstAvailableSlot] = j;
                iArr2[findFirstAvailableSlot] = iArr[i10];
            } else {
                jArr = jArr2;
            }
            i10++;
            mutableLongIntMap = this;
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

    public final int getOrPut(long j, d7.a aVar) {
        aVar.getClass();
        int findKeyIndex = findKeyIndex(j);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        int intValue = ((Number) aVar.invoke()).intValue();
        put(j, intValue);
        return intValue;
    }

    public final void minusAssign(LongSet longSet) {
        longSet.getClass();
        long[] jArr = longSet.elements;
        long[] jArr2 = longSet.metadata;
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
                        remove(jArr[(i << 3) + i10]);
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

    public final void plusAssign(LongIntMap longIntMap) {
        longIntMap.getClass();
        putAll(longIntMap);
    }

    public final int put(long j, int i, int i6) {
        int findInsertIndex = findInsertIndex(j);
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        } else {
            i6 = this.values[findInsertIndex];
        }
        this.keys[findInsertIndex] = j;
        this.values[findInsertIndex] = i;
        return i6;
    }

    public final void putAll(LongIntMap longIntMap) {
        longIntMap.getClass();
        long[] jArr = longIntMap.keys;
        int[] iArr = longIntMap.values;
        long[] jArr2 = longIntMap.metadata;
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
                        set(jArr[i11], iArr[i11]);
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

    public final boolean remove(long j, int i) {
        int findKeyIndex = findKeyIndex(j);
        if (findKeyIndex < 0 || this.values[findKeyIndex] != i) {
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
                        if (((Boolean) pVar.invoke(Long.valueOf(this.keys[i11]), Integer.valueOf(this.values[i11]))).booleanValue()) {
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

    public final void set(long j, int i) {
        int findInsertIndex = findInsertIndex(j);
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        }
        this.keys[findInsertIndex] = j;
        this.values[findInsertIndex] = i;
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

    public final void remove(long j) {
        int findKeyIndex = findKeyIndex(j);
        if (findKeyIndex >= 0) {
            removeValueAt(findKeyIndex);
        }
    }

    public /* synthetic */ MutableLongIntMap(int i, int i6, g gVar) {
        this((i6 & 1) != 0 ? 6 : i);
    }

    public final void put(long j, int i) {
        set(j, i);
    }

    public MutableLongIntMap() {
        this(0, 1, null);
    }

    public final void minusAssign(long[] jArr) {
        jArr.getClass();
        for (long j : jArr) {
            remove(j);
        }
    }

    public final void minusAssign(long j) {
        remove(j);
    }

    public final void minusAssign(LongList longList) {
        longList.getClass();
        long[] jArr = longList.content;
        int i = longList._size;
        for (int i6 = 0; i6 < i; i6++) {
            remove(jArr[i6]);
        }
    }
}
