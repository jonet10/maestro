package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CornerRounding {
    public static final Companion Companion;
    public static final CornerRounding Unrounded;
    private final float radius;
    private final float smoothing;

    static {
        g gVar = null;
        Companion = new Companion(gVar);
        float f = 0.0f;
        Unrounded = new CornerRounding(f, f, 3, gVar);
    }

    public /* synthetic */ CornerRounding(float f, float f10, int i, g gVar) {
        this((i & 1) != 0 ? 0.0f : f, (i & 2) != 0 ? 0.0f : f10);
    }

    public final float getRadius() {
        return this.radius;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }

    public CornerRounding(@FloatRange(from = 0.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.radius = f;
        this.smoothing = f10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public CornerRounding() {
        /*
            r3 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            r3.<init>(r2, r2, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.graphics.shapes.CornerRounding.<init>():void");
    }
}
