package androidx.collection.internal;

import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ContainerHelpersKt {
    public static final int[] EMPTY_INTS = new int[0];
    public static final long[] EMPTY_LONGS = new long[0];
    public static final Object[] EMPTY_OBJECTS = new Object[0];

    public static final int binarySearch(long[] jArr, int i, long j) {
        jArr.getClass();
        int i6 = i - 1;
        int i10 = 0;
        while (i10 <= i6) {
            int i11 = (i10 + i6) >>> 1;
            long j6 = jArr[i11];
            if (j6 < j) {
                i10 = i11 + 1;
            } else {
                if (j6 <= j) {
                    return i11;
                }
                i6 = i11 - 1;
            }
        }
        return ~i10;
    }

    public static final boolean equal(Object obj, Object obj2) {
        return l.a(obj, obj2);
    }

    public static final int idealByteArraySize(int i) {
        for (int i6 = 4; i6 < 32; i6++) {
            int i10 = (1 << i6) - 12;
            if (i <= i10) {
                return i10;
            }
        }
        return i;
    }

    public static final int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    public static final int idealLongArraySize(int i) {
        return idealByteArraySize(i * 8) / 8;
    }

    public static final int binarySearch(int[] iArr, int i, int i6) {
        iArr.getClass();
        int i10 = i - 1;
        int i11 = 0;
        while (i11 <= i10) {
            int i12 = (i11 + i10) >>> 1;
            int i13 = iArr[i12];
            if (i13 < i6) {
                i11 = i12 + 1;
            } else {
                if (i13 <= i6) {
                    return i12;
                }
                i10 = i12 - 1;
            }
        }
        return ~i11;
    }
}
