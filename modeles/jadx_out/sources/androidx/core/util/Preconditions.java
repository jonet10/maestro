package androidx.core.util;

import a4.x;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Locale;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z9, @NonNull Object obj) {
        if (!z9) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static float checkArgumentFinite(float f, @NonNull String str) {
        if (Float.isNaN(f)) {
            com.google.gson.internal.a.p(x.C(str, " must not be NaN"));
            return 0.0f;
        }
        if (!Float.isInfinite(f)) {
            return f;
        }
        com.google.gson.internal.a.p(x.C(str, " must not be infinite"));
        return 0.0f;
    }

    public static int checkArgumentInRange(int i, int i6, int i10, @NonNull String str) {
        if (i < i6) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException(str + " is out of range of [" + i6 + ", " + i10 + "] (too low)");
        }
        if (i <= i10) {
            return i;
        }
        Locale locale2 = Locale.US;
        throw new IllegalArgumentException(str + " is out of range of [" + i6 + ", " + i10 + "] (too high)");
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i, @Nullable String str) {
        if (i >= 0) {
            return i;
        }
        com.google.gson.internal.a.p(str);
        return 0;
    }

    public static int checkFlagsArgument(int i, int i6) {
        if ((i & i6) == i) {
            return i;
        }
        throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i) + ", but only 0x" + Integer.toHexString(i6) + " are allowed");
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t9, @NonNull Object obj) {
        if (t9 != null) {
            return t9;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z9, @Nullable String str) {
        if (z9) {
            return;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i(str);
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t9, @NonNull Object obj) {
        if (TextUtils.isEmpty(t9)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return t9;
    }

    public static void checkState(boolean z9) {
        checkState(z9, null);
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i) {
        if (i >= 0) {
            return i;
        }
        o.n();
        return 0;
    }

    public static void checkArgument(boolean z9) {
        if (z9) {
            return;
        }
        o.n();
    }

    @NonNull
    public static <T> T checkNotNull(@Nullable T t9) {
        t9.getClass();
        return t9;
    }

    public static void checkArgument(boolean z9, @NonNull String str, @NonNull Object... objArr) {
        if (!z9) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t9) {
        if (!TextUtils.isEmpty(t9)) {
            return t9;
        }
        o.n();
        return null;
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(@Nullable T t9, @NonNull String str, @NonNull Object... objArr) {
        if (TextUtils.isEmpty(t9)) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
        return t9;
    }

    public static long checkArgumentInRange(long j, long j6, long j10, @NonNull String str) {
        if (j < j6) {
            Locale locale = Locale.US;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" is out of range of [");
            sb.append(j6);
            sb.append(", ");
            com.google.gson.internal.a.p(x.l(sb, j10, "] (too low)"));
            return 0L;
        }
        if (j <= j10) {
            return j;
        }
        Locale locale2 = Locale.US;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" is out of range of [");
        sb2.append(j6);
        sb2.append(", ");
        com.google.gson.internal.a.p(x.l(sb2, j10, "] (too high)"));
        return 0L;
    }

    public static float checkArgumentInRange(float f, float f10, float f11, @NonNull String str) {
        if (f < f10) {
            com.google.gson.internal.a.p(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Float.valueOf(f10), Float.valueOf(f11)));
            return 0.0f;
        }
        if (f <= f11) {
            return f;
        }
        com.google.gson.internal.a.p(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Float.valueOf(f10), Float.valueOf(f11)));
        return 0.0f;
    }

    public static double checkArgumentInRange(double d10, double d11, double d12, @NonNull String str) {
        if (d10 < d11) {
            com.google.gson.internal.a.p(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", str, Double.valueOf(d11), Double.valueOf(d12)));
            return 0.0d;
        }
        if (d10 <= d12) {
            return d10;
        }
        com.google.gson.internal.a.p(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", str, Double.valueOf(d11), Double.valueOf(d12)));
        return 0.0d;
    }
}
