package androidx.core.content.res;

import java.lang.reflect.Array;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class GrowingArrayUtils {
    private GrowingArrayUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, java.lang.Object[]] */
    public static <T> T[] append(T[] tArr, int i, T t9) {
        if (i + 1 > tArr.length) {
            ?? r02 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i));
            System.arraycopy(tArr, 0, r02, 0, i);
            tArr = r02;
        }
        tArr[i] = t9;
        return tArr;
    }

    public static int growSize(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }

    public static <T> T[] insert(T[] tArr, int i, int i6, T t9) {
        if (i + 1 <= tArr.length) {
            System.arraycopy(tArr, i6, tArr, i6 + 1, i - i6);
            tArr[i6] = t9;
            return tArr;
        }
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i)));
        System.arraycopy(tArr, 0, tArr2, 0, i6);
        tArr2[i6] = t9;
        System.arraycopy(tArr, i6, tArr2, i6 + 1, tArr.length - i6);
        return tArr2;
    }

    public static int[] append(int[] iArr, int i, int i6) {
        if (i + 1 > iArr.length) {
            int[] iArr2 = new int[growSize(i)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr = iArr2;
        }
        iArr[i] = i6;
        return iArr;
    }

    public static long[] append(long[] jArr, int i, long j) {
        if (i + 1 > jArr.length) {
            long[] jArr2 = new long[growSize(i)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            jArr = jArr2;
        }
        jArr[i] = j;
        return jArr;
    }

    public static boolean[] append(boolean[] zArr, int i, boolean z9) {
        if (i + 1 > zArr.length) {
            boolean[] zArr2 = new boolean[growSize(i)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            zArr = zArr2;
        }
        zArr[i] = z9;
        return zArr;
    }

    public static int[] insert(int[] iArr, int i, int i6, int i10) {
        if (i + 1 <= iArr.length) {
            System.arraycopy(iArr, i6, iArr, i6 + 1, i - i6);
            iArr[i6] = i10;
            return iArr;
        }
        int[] iArr2 = new int[growSize(i)];
        System.arraycopy(iArr, 0, iArr2, 0, i6);
        iArr2[i6] = i10;
        System.arraycopy(iArr, i6, iArr2, i6 + 1, iArr.length - i6);
        return iArr2;
    }

    public static long[] insert(long[] jArr, int i, int i6, long j) {
        if (i + 1 <= jArr.length) {
            System.arraycopy(jArr, i6, jArr, i6 + 1, i - i6);
            jArr[i6] = j;
            return jArr;
        }
        long[] jArr2 = new long[growSize(i)];
        System.arraycopy(jArr, 0, jArr2, 0, i6);
        jArr2[i6] = j;
        System.arraycopy(jArr, i6, jArr2, i6 + 1, jArr.length - i6);
        return jArr2;
    }

    public static boolean[] insert(boolean[] zArr, int i, int i6, boolean z9) {
        if (i + 1 <= zArr.length) {
            System.arraycopy(zArr, i6, zArr, i6 + 1, i - i6);
            zArr[i6] = z9;
            return zArr;
        }
        boolean[] zArr2 = new boolean[growSize(i)];
        System.arraycopy(zArr, 0, zArr2, 0, i6);
        zArr2[i6] = z9;
        System.arraycopy(zArr, i6, zArr2, i6 + 1, zArr.length - i6);
        return zArr2;
    }
}
