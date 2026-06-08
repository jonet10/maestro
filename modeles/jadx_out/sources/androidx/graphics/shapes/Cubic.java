package androidx.graphics.shapes;

import a3.b;
import androidx.collection.FloatFloatPair;
import java.util.Arrays;
import kotlin.jvm.internal.g;
import p6.i;
import q6.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class Cubic {
    public static final Companion Companion = new Companion(null);
    private final float[] points;

    private Cubic(long j, long j6, long j10, long j11) {
        this(new float[]{PointKt.m59getXDnnuFBc(j), PointKt.m60getYDnnuFBc(j), PointKt.m59getXDnnuFBc(j6), PointKt.m60getYDnnuFBc(j6), PointKt.m59getXDnnuFBc(j10), PointKt.m60getYDnnuFBc(j10), PointKt.m59getXDnnuFBc(j11), PointKt.m60getYDnnuFBc(j11)});
    }

    public static /* synthetic */ void calculateBounds$graphics_shapes_release$default(Cubic cubic, float[] fArr, boolean z9, int i, Object obj) {
        if (obj != null) {
            b.r("Super calls with default arguments not supported in this target, function: calculateBounds");
            return;
        }
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        if ((i & 2) != 0) {
            z9 = false;
        }
        cubic.calculateBounds$graphics_shapes_release(fArr, z9);
    }

    public static final Cubic circularArc(float f, float f10, float f11, float f12, float f13, float f14) {
        return Companion.circularArc(f, f10, f11, f12, f13, f14);
    }

    public static final Cubic straightLine(float f, float f10, float f11, float f12) {
        return Companion.straightLine(f, f10, f11, f12);
    }

    private final boolean zeroIsh(float f) {
        return Math.abs(f) < 1.0E-4f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x01c0, code lost:
    
        if (r2 > r8) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x01c2, code lost:
    
        r8 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0211, code lost:
    
        if (r2 > r8) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void calculateBounds$graphics_shapes_release(float[] r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.graphics.shapes.Cubic.calculateBounds$graphics_shapes_release(float[], boolean):void");
    }

    public final Cubic div(float f) {
        return times(1.0f / f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Cubic) {
            return Arrays.equals(this.points, ((Cubic) obj).points);
        }
        return false;
    }

    public final float getAnchor0X() {
        return this.points[0];
    }

    public final float getAnchor0Y() {
        return this.points[1];
    }

    public final float getAnchor1X() {
        return this.points[6];
    }

    public final float getAnchor1Y() {
        return this.points[7];
    }

    public final float getControl0X() {
        return this.points[2];
    }

    public final float getControl0Y() {
        return this.points[3];
    }

    public final float getControl1X() {
        return this.points[4];
    }

    public final float getControl1Y() {
        return this.points[5];
    }

    public final float[] getPoints$graphics_shapes_release() {
        return this.points;
    }

    public int hashCode() {
        return Arrays.hashCode(this.points);
    }

    public final Cubic plus(Cubic cubic) {
        cubic.getClass();
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr[i] = this.points[i] + cubic.points[i];
        }
        return new Cubic(fArr);
    }

    /* renamed from: pointOnCurve-OOQOV4g$graphics_shapes_release, reason: not valid java name */
    public final long m47pointOnCurveOOQOV4g$graphics_shapes_release(float f) {
        float f10 = 1 - f;
        float f11 = f10 * f10 * f10;
        float f12 = 3 * f;
        float f13 = f12 * f10 * f10;
        float f14 = f12 * f * f10;
        float f15 = f * f * f;
        return FloatFloatPair.m9constructorimpl((getAnchor1X() * f15) + (getControl1X() * f14) + (getControl0X() * f13) + (getAnchor0X() * f11), (getAnchor1Y() * f15) + (getControl1Y() * f14) + (getControl0Y() * f13) + (getAnchor0Y() * f11));
    }

    public final Cubic reverse() {
        return CubicKt.Cubic(getAnchor1X(), getAnchor1Y(), getControl1X(), getControl1Y(), getControl0X(), getControl0Y(), getAnchor0X(), getAnchor0Y());
    }

    public final i split(float f) {
        float f10 = 1 - f;
        long m47pointOnCurveOOQOV4g$graphics_shapes_release = m47pointOnCurveOOQOV4g$graphics_shapes_release(f);
        float f11 = f10 * f10;
        float f12 = 2 * f10 * f;
        float f13 = f * f;
        return new i(CubicKt.Cubic(getAnchor0X(), getAnchor0Y(), (getAnchor0X() * f10) + (getControl0X() * f), (getAnchor0Y() * f10) + (getControl0Y() * f), (getControl1X() * f13) + (getControl0X() * f12) + (getAnchor0X() * f11), (getControl1Y() * f13) + (getControl0Y() * f12) + (getAnchor0Y() * f11), PointKt.m59getXDnnuFBc(m47pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m60getYDnnuFBc(m47pointOnCurveOOQOV4g$graphics_shapes_release)), CubicKt.Cubic(PointKt.m59getXDnnuFBc(m47pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m60getYDnnuFBc(m47pointOnCurveOOQOV4g$graphics_shapes_release), (getAnchor1X() * f13) + (getControl1X() * f12) + (getControl0X() * f11), (getAnchor1Y() * f13) + (getControl1Y() * f12) + (getControl0Y() * f11), (getAnchor1X() * f) + (getControl1X() * f10), (getAnchor1Y() * f) + (getControl1Y() * f10), getAnchor1X(), getAnchor1Y()));
    }

    public final Cubic times(float f) {
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr[i] = this.points[i] * f;
        }
        return new Cubic(fArr);
    }

    public String toString() {
        return "anchor0: (" + getAnchor0X() + ", " + getAnchor0Y() + ") control0: (" + getControl0X() + ", " + getControl0Y() + "), control1: (" + getControl1X() + ", " + getControl1Y() + "), anchor1: (" + getAnchor1X() + ", " + getAnchor1Y() + ')';
    }

    public final Cubic transformed(PointTransformer pointTransformer) {
        pointTransformer.getClass();
        MutableCubic mutableCubic = new MutableCubic();
        float[] fArr = this.points;
        j.Z(fArr, 0, mutableCubic.getPoints$graphics_shapes_release(), 0, fArr.length);
        mutableCubic.transform(pointTransformer);
        return mutableCubic;
    }

    public final boolean zeroLength$graphics_shapes_release() {
        return Math.abs(getAnchor0X() - getAnchor1X()) < 1.0E-4f && Math.abs(getAnchor0Y() - getAnchor1Y()) < 1.0E-4f;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final Cubic circularArc(float f, float f10, float f11, float f12, float f13, float f14) {
            float f15 = f11 - f;
            float f16 = f12 - f10;
            long directionVector = Utils.directionVector(f15, f16);
            float f17 = f13 - f;
            float f18 = f14 - f10;
            long directionVector2 = Utils.directionVector(f17, f18);
            long m80rotate90DnnuFBc = Utils.m80rotate90DnnuFBc(directionVector);
            long m80rotate90DnnuFBc2 = Utils.m80rotate90DnnuFBc(directionVector2);
            boolean z9 = PointKt.m54dotProduct5P9i7ZU(m80rotate90DnnuFBc, f17, f18) >= 0.0f;
            float m55dotProductybeJwSQ = PointKt.m55dotProductybeJwSQ(directionVector, directionVector2);
            if (m55dotProductybeJwSQ > 0.999f) {
                return straightLine(f11, f12, f13, f14);
            }
            float sqrt = (((((float) Math.sqrt(2 * r9)) - ((float) Math.sqrt(r5 - (m55dotProductybeJwSQ * m55dotProductybeJwSQ)))) * ((Utils.distance(f15, f16) * 4.0f) / 3.0f)) / (1 - m55dotProductybeJwSQ)) * (z9 ? 1.0f : -1.0f);
            return CubicKt.Cubic(f11, f12, (PointKt.m59getXDnnuFBc(m80rotate90DnnuFBc) * sqrt) + f11, (PointKt.m60getYDnnuFBc(m80rotate90DnnuFBc) * sqrt) + f12, f13 - (PointKt.m59getXDnnuFBc(m80rotate90DnnuFBc2) * sqrt), f14 - (PointKt.m60getYDnnuFBc(m80rotate90DnnuFBc2) * sqrt), f13, f14);
        }

        public final Cubic straightLine(float f, float f10, float f11, float f12) {
            return CubicKt.Cubic(f, f10, Utils.interpolate(f, f11, 0.33333334f), Utils.interpolate(f10, f12, 0.33333334f), Utils.interpolate(f, f11, 0.6666667f), Utils.interpolate(f10, f12, 0.6666667f), f11, f12);
        }

        private Companion() {
        }
    }

    public final Cubic div(int i) {
        return div(i);
    }

    public final Cubic times(int i) {
        return times(i);
    }

    public /* synthetic */ Cubic(long j, long j6, long j10, long j11, g gVar) {
        this(j, j6, j10, j11);
    }

    public Cubic(float[] fArr) {
        fArr.getClass();
        this.points = fArr;
        if (fArr.length == 8) {
            return;
        }
        com.google.gson.internal.a.p("Points array size should be 8");
        throw null;
    }

    public /* synthetic */ Cubic(float[] fArr, int i, g gVar) {
        this((i & 1) != 0 ? new float[8] : fArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Cubic() {
        this(null, 1, 0 == true ? 1 : 0);
    }
}
