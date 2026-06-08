package androidx.core.math;

import androidx.core.location.LocationRequestCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class MathUtils {
    private MathUtils() {
    }

    public static long addExact(long j, long j6) {
        long j10 = j + j6;
        if ((j >= 0) == (j6 >= 0)) {
            if ((j >= 0) != (j10 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j10;
    }

    public static double clamp(double d10, double d11, double d12) {
        return d10 < d11 ? d11 : d10 > d12 ? d12 : d10;
    }

    public static long decrementExact(long j) {
        if (j != Long.MIN_VALUE) {
            return j - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long incrementExact(long j) {
        if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
            return j + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long multiplyExact(long j, long j6) {
        long j10 = j * j6;
        if (j == 0 || j6 == 0 || (j10 / j == j6 && j10 / j6 == j)) {
            return j10;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long negateExact(long j) {
        if (j != Long.MIN_VALUE) {
            return -j;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static long subtractExact(long j, long j6) {
        long j10 = j - j6;
        if ((j < 0) != (j6 < 0)) {
            if ((j < 0) != (j10 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return j10;
    }

    public static int toIntExact(long j) {
        if (j > 2147483647L || j < -2147483648L) {
            throw new ArithmeticException("integer overflow");
        }
        return (int) j;
    }

    public static float clamp(float f, float f10, float f11) {
        return f < f10 ? f10 : f > f11 ? f11 : f;
    }

    public static int clamp(int i, int i6, int i10) {
        return i < i6 ? i6 : i > i10 ? i10 : i;
    }

    public static long clamp(long j, long j6, long j10) {
        return j < j6 ? j6 : j > j10 ? j10 : j;
    }

    public static int negateExact(int i) {
        if (i != Integer.MIN_VALUE) {
            return -i;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int decrementExact(int i) {
        if (i != Integer.MIN_VALUE) {
            return i - 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int incrementExact(int i) {
        if (i != Integer.MAX_VALUE) {
            return i + 1;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int multiplyExact(int i, int i6) {
        int i10 = i * i6;
        if (i == 0 || i6 == 0 || (i10 / i == i6 && i10 / i6 == i)) {
            return i10;
        }
        throw new ArithmeticException("integer overflow");
    }

    public static int addExact(int i, int i6) {
        int i10 = i + i6;
        if ((i >= 0) == (i6 >= 0)) {
            if ((i >= 0) != (i10 >= 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i10;
    }

    public static int subtractExact(int i, int i6) {
        int i10 = i - i6;
        if ((i < 0) != (i6 < 0)) {
            if ((i < 0) != (i10 < 0)) {
                throw new ArithmeticException("integer overflow");
            }
        }
        return i10;
    }
}
