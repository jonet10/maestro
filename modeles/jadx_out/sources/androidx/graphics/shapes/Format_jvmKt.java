package androidx.graphics.shapes;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Format_jvmKt {
    public static final String toStringWithLessPrecision(float f) {
        return String.format("%.3f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
    }
}
