package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Half;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class HalfKt {
    @RequiresApi(26)
    public static final Half toHalf(double d10) {
        return Half.valueOf((float) d10);
    }

    @RequiresApi(26)
    public static final Half toHalf(float f) {
        return Half.valueOf(f);
    }

    @RequiresApi(26)
    public static final Half toHalf(String str) {
        return Half.valueOf(str);
    }

    @RequiresApi(26)
    public static final Half toHalf(short s6) {
        return Half.valueOf(s6);
    }
}
