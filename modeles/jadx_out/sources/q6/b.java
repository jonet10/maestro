package q6;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {
    public static void a(int i, int i6, int i10) {
        if (i < 0 || i6 > i10) {
            throw new IndexOutOfBoundsException("startIndex: " + i + ", endIndex: " + i6 + ", size: " + i10);
        }
        if (i <= i6) {
            return;
        }
        throw new IllegalArgumentException("startIndex: " + i + " > endIndex: " + i6);
    }

    public static void b(int i, int i6) {
        if (i < 0 || i >= i6) {
            com.google.gson.internal.a.e(i, i6, ", size: ", "index: ");
        }
    }

    public static void c(int i, int i6) {
        if (i < 0 || i > i6) {
            com.google.gson.internal.a.e(i, i6, ", size: ", "index: ");
        }
    }

    public static void d(int i, int i6, int i10) {
        if (i < 0 || i6 > i10) {
            throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i6 + ", size: " + i10);
        }
        if (i <= i6) {
            return;
        }
        throw new IllegalArgumentException("fromIndex: " + i + " > toIndex: " + i6);
    }

    public static int e(int i, int i6) {
        int i10 = i + (i >> 1);
        if (i10 - i6 < 0) {
            i10 = i6;
        }
        return i10 - 2147483639 > 0 ? i6 > 2147483639 ? Integer.MAX_VALUE : 2147483639 : i10;
    }
}
