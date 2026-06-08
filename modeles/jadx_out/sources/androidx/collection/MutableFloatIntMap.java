package androidx.collection;

import com.google.gson.internal.a;
import d7.p;
import kotlin.jvm.internal.g;
import q6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MutableFloatIntMap extends FloatIntMap {
    private int growthLimit;

    public MutableFloatIntMap(int i) {
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

    private final int findInsertIndex(float f) {
        int floatToIntBits = Float.floatToIntBits(f) * ScatterMapKt.MurmurHashC1;
        int i = floatToIntBits ^ (floatToIntBits << 16);
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
            int i16 = i13;
            long j10 = j ^ (j6 * ScatterMapKt.BitmaskLsb);
            for (long j11 = (~j10) & (j10 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j11 != 0; j11 &= j11 - 1) {
                int numberOfTrailingZeros = ((Long.numberOfTrailingZeros(j11) >> 3) + i12) & i11;
                if (this.keys[numberOfTrailingZeros] == f) {
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
                return ~findFirstAvailableSlot;
            }
            i13 = i16 + 8;
            i12 = (i12 + i13) & i11;
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
        this.keys = new float[max];
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
        MutableFloatIntMap mutableFloatIntMap = this;
        long[] jArr2 = mutableFloatIntMap.metadata;
        float[] fArr = mutableFloatIntMap.keys;
        int[] iArr = mutableFloatIntMap.values;
        int i6 = mutableFloatIntMap._capacity;
        initializeStorage(i);
        float[] fArr2 = mutableFloatIntMap.keys;
        int[] iArr2 = mutableFloatIntMap.values;
        int i10 = 0;
        while (i10 < i6) {
            if (((jArr2[i10 >> 3] >> ((i10 & 7) << 3)) & 255) < 128) {
                float f = fArr[i10];
                int floatToIntBits = Float.floatToIntBits(f) * ScatterMapKt.MurmurHashC1;
                int i11 = floatToIntBits ^ (floatToIntBits << 16);
                int findFirstAvailableSlot = mutableFloatIntMap.findFirstAvailableSlot(i11 >>> 7);
                long j = i11 & 127;
                long[] jArr3 = mutableFloatIntMap.metadata;
                int i12 = findFirstAvailableSlot >> 3;
                int i13 = (findFirstAvailableSlot & 7) << 3;
                jArr3[i12] = (jArr3[i12] & (~(255 << i13))) | (j << i13);
                int i14 = mutableFloatIntMap._capacity;
                int i15 = ((findFirstAvailableSlot - 7) & i14) + (i14 & 7);
                int i16 = i15 >> 3;
                int i17 = (i15 & 7) << 3;
                jArr = jArr2;
                jArr3[i16] = ((~(255 << i17)) & jArr3[i16]) | (j << i17);
                fArr2[findFirstAvailableSlot] = f;
                iArr2[findFirstAvailableSlot] = iArr[i10];
            } else {
                jArr = jArr2;
            }
            i10++;
            mutableFloatIntMap = this;
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

    public final int getOrPut(float f, d7.a aVar) {
        aVar.getClass();
        int findKeyIndex = findKeyIndex(f);
        if (findKeyIndex >= 0) {
            return this.values[findKeyIndex];
        }
        int intValue = ((Number) aVar.invoke()).intValue();
        put(f, intValue);
        return intValue;
    }

    public final void minusAssign(FloatSet floatSet) {
        floatSet.getClass();
        float[] fArr = floatSet.elements;
        long[] jArr = floatSet.metadata;
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
                        remove(fArr[(i << 3) + i10]);
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

    public final void plusAssign(FloatIntMap floatIntMap) {
        floatIntMap.getClass();
        putAll(floatIntMap);
    }

    public final int put(float f, int i, int i6) {
        int findInsertIndex = findInsertIndex(f);
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        } else {
            i6 = this.values[findInsertIndex];
        }
        this.keys[findInsertIndex] = f;
        this.values[findInsertIndex] = i;
        return i6;
    }

    public final void putAll(FloatIntMap floatIntMap) {
        floatIntMap.getClass();
        float[] fArr = floatIntMap.keys;
        int[] iArr = floatIntMap.values;
        long[] jArr = floatIntMap.metadata;
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
                        set(fArr[i11], iArr[i11]);
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

    public final boolean remove(float f, int i) {
        int findKeyIndex = findKeyIndex(f);
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
                        if (((Boolean) pVar.invoke(Float.valueOf(this.keys[i11]), Integer.valueOf(this.values[i11]))).booleanValue()) {
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

    public final void set(float f, int i) {
        int findInsertIndex = findInsertIndex(f);
        if (findInsertIndex < 0) {
            findInsertIndex = ~findInsertIndex;
        }
        this.keys[findInsertIndex] = f;
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

    public final void remove(float f) {
        int findKeyIndex = findKeyIndex(f);
        if (findKeyIndex >= 0) {
            removeValueAt(findKeyIndex);
        }
    }

    public /* synthetic */ MutableFloatIntMap(int i, int i6, g gVar) {
        this((i6 & 1) != 0 ? 6 : i);
    }

    public final void put(float f, int i) {
        set(f, i);
    }

    public MutableFloatIntMap() {
        this(0, 1, null);
    }

    public final void minusAssign(float[] fArr) {
        fArr.getClass();
        for (float f : fArr) {
            remove(f);
        }
    }

    public final void minusAssign(float f) {
        remove(f);
    }

    public final void minusAssign(FloatList floatList) {
        floatList.getClass();
        float[] fArr = floatList.content;
        int i = floatList._size;
        for (int i6 = 0; i6 < i; i6++) {
            remove(fArr[i6]);
        }
    }
}
