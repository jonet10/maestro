package androidx.leanback.util;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MathUtil {
    private MathUtil() {
    }

    public static int safeLongToInt(long j) {
        int i = (int) j;
        if (i == j) {
            return i;
        }
        throw new ArithmeticException("Input overflows int.\n");
    }
}
