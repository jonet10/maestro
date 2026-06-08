package androidx.collection;

import p6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ScatterMapKt {
    public static final long AllEmpty = -9187201950435737472L;
    public static final long BitmaskLsb = 72340172838076673L;
    public static final long BitmaskMsb = -9187201950435737472L;
    public static final int ClonedMetadataCount = 7;
    public static final int DefaultScatterCapacity = 6;
    public static final long Deleted = 254;
    public static final long Empty = 128;
    public static final long[] EmptyGroup = {-9187201950435737345L, -1};
    private static final MutableScatterMap EmptyScatterMap = new MutableScatterMap(0);
    public static final int GroupWidth = 8;
    public static final int MurmurHashC1 = -862048943;
    public static final long Sentinel = 255;

    public static final <K, V> ScatterMap<K, V> emptyScatterMap() {
        MutableScatterMap mutableScatterMap = EmptyScatterMap;
        mutableScatterMap.getClass();
        return mutableScatterMap;
    }

    public static final int get(long j) {
        return Long.numberOfTrailingZeros(j) >> 3;
    }

    public static final long group(long[] jArr, int i) {
        jArr.getClass();
        int i6 = i >> 3;
        int i10 = (i & 7) << 3;
        return (((-i10) >> 63) & (jArr[i6 + 1] << (64 - i10))) | (jArr[i6] >>> i10);
    }

    public static final int h1(int i) {
        return i >>> 7;
    }

    public static final int h2(int i) {
        return i & 127;
    }

    public static final boolean hasNext(long j) {
        return j != 0;
    }

    public static final int hash(Object obj) {
        int hashCode = (obj != null ? obj.hashCode() : 0) * MurmurHashC1;
        return hashCode ^ (hashCode << 16);
    }

    public static final boolean isDeleted(long[] jArr, int i) {
        jArr.getClass();
        return ((jArr[i >> 3] >> ((i & 7) << 3)) & 255) == 254;
    }

    public static final boolean isEmpty(long[] jArr, int i) {
        jArr.getClass();
        return ((jArr[i >> 3] >> ((i & 7) << 3)) & 255) == 128;
    }

    public static final boolean isFull(long[] jArr, int i) {
        jArr.getClass();
        return ((jArr[i >> 3] >> ((i & 7) << 3)) & 255) < 128;
    }

    public static final int loadedCapacity(int i) {
        if (i == 7) {
            return 6;
        }
        return i - (i / 8);
    }

    public static final int lowestBitSet(long j) {
        return Long.numberOfTrailingZeros(j) >> 3;
    }

    public static final long maskEmpty(long j) {
        return j & ((~j) << 6) & (-9187201950435737472L);
    }

    public static final long maskEmptyOrDeleted(long j) {
        return j & ((~j) << 7) & (-9187201950435737472L);
    }

    public static final long match(long j, int i) {
        long j6 = j ^ (i * BitmaskLsb);
        return (~j6) & (j6 - BitmaskLsb) & (-9187201950435737472L);
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf(i... iVarArr) {
        iVarArr.getClass();
        MutableScatterMap<K, V> mutableScatterMap = new MutableScatterMap<>(iVarArr.length);
        mutableScatterMap.putAll(iVarArr);
        return mutableScatterMap;
    }

    public static final long next(long j) {
        return j & (j - 1);
    }

    public static final int nextCapacity(int i) {
        if (i == 0) {
            return 6;
        }
        return (i * 2) + 1;
    }

    public static final int normalizeCapacity(int i) {
        if (i > 0) {
            return (-1) >>> Integer.numberOfLeadingZeros(i);
        }
        return 0;
    }

    public static final long readRawMetadata(long[] jArr, int i) {
        jArr.getClass();
        return (jArr[i >> 3] >> ((i & 7) << 3)) & 255;
    }

    public static final int unloadedCapacity(int i) {
        if (i == 7) {
            return 8;
        }
        return ((i - 1) / 7) + i;
    }

    public static final void writeRawMetadata(long[] jArr, int i, long j) {
        jArr.getClass();
        int i6 = i >> 3;
        int i10 = (i & 7) << 3;
        jArr[i6] = (j << i10) | (jArr[i6] & (~(255 << i10)));
    }

    public static final <K, V> MutableScatterMap<K, V> mutableScatterMapOf() {
        return new MutableScatterMap<>(0, 1, null);
    }

    public static /* synthetic */ void getBitmaskLsb$annotations() {
    }

    public static /* synthetic */ void getBitmaskMsb$annotations() {
    }

    public static /* synthetic */ void getSentinel$annotations() {
    }

    public static final boolean isFull(long j) {
        return j < 128;
    }
}
