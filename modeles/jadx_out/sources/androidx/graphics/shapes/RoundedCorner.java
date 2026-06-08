package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import java.util.List;
import kotlin.jvm.internal.g;
import q6.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class RoundedCorner {
    private long center;
    private final float cornerRadius;
    private final float cosAngle;
    private final long d1;

    /* renamed from: d2, reason: collision with root package name */
    private final long f426d2;
    private final float expectedRoundCut;

    /* renamed from: p0, reason: collision with root package name */
    private final long f427p0;

    /* renamed from: p1, reason: collision with root package name */
    private final long f428p1;

    /* renamed from: p2, reason: collision with root package name */
    private final long f429p2;
    private final CornerRounding rounding;
    private final float sinAngle;
    private final float smoothing;

    private RoundedCorner(long j, long j6, long j10, CornerRounding cornerRounding) {
        this.f427p0 = j;
        this.f428p1 = j6;
        this.f429p2 = j10;
        this.rounding = cornerRounding;
        long m56getDirectionDnnuFBc = PointKt.m56getDirectionDnnuFBc(PointKt.m62minusybeJwSQ(j, j6));
        this.d1 = m56getDirectionDnnuFBc;
        long m56getDirectionDnnuFBc2 = PointKt.m56getDirectionDnnuFBc(PointKt.m62minusybeJwSQ(j10, j6));
        this.f426d2 = m56getDirectionDnnuFBc2;
        float radius = cornerRounding != null ? cornerRounding.getRadius() : 0.0f;
        this.cornerRadius = radius;
        this.smoothing = cornerRounding != null ? cornerRounding.getSmoothing() : 0.0f;
        float m55dotProductybeJwSQ = PointKt.m55dotProductybeJwSQ(m56getDirectionDnnuFBc, m56getDirectionDnnuFBc2);
        this.cosAngle = m55dotProductybeJwSQ;
        float f = 1;
        float sqrt = (float) Math.sqrt(f - Utils.square(m55dotProductybeJwSQ));
        this.sinAngle = sqrt;
        this.expectedRoundCut = ((double) sqrt) > 0.001d ? ((m55dotProductybeJwSQ + f) * radius) / sqrt : 0.0f;
        this.center = FloatFloatPair.m9constructorimpl(0.0f, 0.0f);
    }

    private final float calculateActualSmoothingValue(float f) {
        if (f > getExpectedCut()) {
            return this.smoothing;
        }
        float f10 = this.expectedRoundCut;
        if (f <= f10) {
            return 0.0f;
        }
        return ((f - f10) * this.smoothing) / (getExpectedCut() - this.expectedRoundCut);
    }

    /* renamed from: computeFlankingCurve-oAJzIJU, reason: not valid java name */
    private final Cubic m69computeFlankingCurveoAJzIJU(float f, float f10, long j, long j6, long j10, long j11, long j12, float f11) {
        long m56getDirectionDnnuFBc = PointKt.m56getDirectionDnnuFBc(PointKt.m62minusybeJwSQ(j6, j));
        long m63plusybeJwSQ = PointKt.m63plusybeJwSQ(j, PointKt.m65timesso9K2fw(PointKt.m65timesso9K2fw(m56getDirectionDnnuFBc, f), 1 + f10));
        long j13 = j10;
        long m61interpolatedLqxh1s = PointKt.m61interpolatedLqxh1s(j13, PointKt.m53divso9K2fw(PointKt.m63plusybeJwSQ(j10, j11), 2.0f), f10);
        long m63plusybeJwSQ2 = PointKt.m63plusybeJwSQ(j12, PointKt.m65timesso9K2fw(Utils.directionVector(PointKt.m59getXDnnuFBc(m61interpolatedLqxh1s) - PointKt.m59getXDnnuFBc(j12), PointKt.m60getYDnnuFBc(m61interpolatedLqxh1s) - PointKt.m60getYDnnuFBc(j12)), f11));
        FloatFloatPair m70lineIntersectionCBFvKDc = m70lineIntersectionCBFvKDc(j6, m56getDirectionDnnuFBc, m63plusybeJwSQ2, Utils.m80rotate90DnnuFBc(PointKt.m62minusybeJwSQ(m63plusybeJwSQ2, j12)));
        if (m70lineIntersectionCBFvKDc != null) {
            j13 = m70lineIntersectionCBFvKDc.m17unboximpl();
        }
        return new Cubic(m63plusybeJwSQ, PointKt.m53divso9K2fw(PointKt.m63plusybeJwSQ(m63plusybeJwSQ, PointKt.m65timesso9K2fw(j13, 2.0f)), 3.0f), j13, m63plusybeJwSQ2, null);
    }

    public static /* synthetic */ List getCubics$default(RoundedCorner roundedCorner, float f, float f10, int i, Object obj) {
        if ((i & 2) != 0) {
            f10 = f;
        }
        return roundedCorner.getCubics(f, f10);
    }

    /* renamed from: lineIntersection-CBFvKDc, reason: not valid java name */
    private final FloatFloatPair m70lineIntersectionCBFvKDc(long j, long j6, long j10, long j11) {
        long m80rotate90DnnuFBc = Utils.m80rotate90DnnuFBc(j11);
        float m55dotProductybeJwSQ = PointKt.m55dotProductybeJwSQ(j6, m80rotate90DnnuFBc);
        if (Math.abs(m55dotProductybeJwSQ) < 1.0E-4f) {
            return null;
        }
        float m55dotProductybeJwSQ2 = PointKt.m55dotProductybeJwSQ(PointKt.m62minusybeJwSQ(j10, j), m80rotate90DnnuFBc);
        if (Math.abs(m55dotProductybeJwSQ) < Math.abs(m55dotProductybeJwSQ2) * 1.0E-4f) {
            return null;
        }
        return FloatFloatPair.m6boximpl(PointKt.m63plusybeJwSQ(j, PointKt.m65timesso9K2fw(j6, m55dotProductybeJwSQ2 / m55dotProductybeJwSQ)));
    }

    /* renamed from: getCenter-1ufDz9w, reason: not valid java name */
    public final long m71getCenter1ufDz9w() {
        return this.center;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final float getCosAngle() {
        return this.cosAngle;
    }

    public final List<Cubic> getCubics(float f, float f10) {
        float min = Math.min(f, f10);
        float f11 = this.expectedRoundCut;
        if (f11 < 1.0E-4f || min < 1.0E-4f || this.cornerRadius < 1.0E-4f) {
            long j = this.f428p1;
            this.center = j;
            return a.a.H(Cubic.Companion.straightLine(PointKt.m59getXDnnuFBc(j), PointKt.m60getYDnnuFBc(this.f428p1), PointKt.m59getXDnnuFBc(this.f428p1), PointKt.m60getYDnnuFBc(this.f428p1)));
        }
        float min2 = Math.min(min, f11);
        float calculateActualSmoothingValue = calculateActualSmoothingValue(f);
        float calculateActualSmoothingValue2 = calculateActualSmoothingValue(f10);
        float f12 = (this.cornerRadius * min2) / this.expectedRoundCut;
        this.center = PointKt.m63plusybeJwSQ(this.f428p1, PointKt.m65timesso9K2fw(PointKt.m56getDirectionDnnuFBc(PointKt.m53divso9K2fw(PointKt.m63plusybeJwSQ(this.d1, this.f426d2), 2.0f)), (float) Math.sqrt(Utils.square(min2) + Utils.square(f12))));
        long m63plusybeJwSQ = PointKt.m63plusybeJwSQ(this.f428p1, PointKt.m65timesso9K2fw(this.d1, min2));
        long m63plusybeJwSQ2 = PointKt.m63plusybeJwSQ(this.f428p1, PointKt.m65timesso9K2fw(this.f426d2, min2));
        Cubic m69computeFlankingCurveoAJzIJU = m69computeFlankingCurveoAJzIJU(min2, calculateActualSmoothingValue, this.f428p1, this.f427p0, m63plusybeJwSQ, m63plusybeJwSQ2, this.center, f12);
        Cubic reverse = m69computeFlankingCurveoAJzIJU(min2, calculateActualSmoothingValue2, this.f428p1, this.f429p2, m63plusybeJwSQ2, m63plusybeJwSQ, this.center, f12).reverse();
        return m.d0(m69computeFlankingCurveoAJzIJU, Cubic.Companion.circularArc(PointKt.m59getXDnnuFBc(this.center), PointKt.m60getYDnnuFBc(this.center), m69computeFlankingCurveoAJzIJU.getAnchor1X(), m69computeFlankingCurveoAJzIJU.getAnchor1Y(), reverse.getAnchor0X(), reverse.getAnchor0Y()), reverse);
    }

    /* renamed from: getD1-1ufDz9w, reason: not valid java name */
    public final long m72getD11ufDz9w() {
        return this.d1;
    }

    /* renamed from: getD2-1ufDz9w, reason: not valid java name */
    public final long m73getD21ufDz9w() {
        return this.f426d2;
    }

    public final float getExpectedCut() {
        return (1 + this.smoothing) * this.expectedRoundCut;
    }

    public final float getExpectedRoundCut() {
        return this.expectedRoundCut;
    }

    /* renamed from: getP0-1ufDz9w, reason: not valid java name */
    public final long m74getP01ufDz9w() {
        return this.f427p0;
    }

    /* renamed from: getP1-1ufDz9w, reason: not valid java name */
    public final long m75getP11ufDz9w() {
        return this.f428p1;
    }

    /* renamed from: getP2-1ufDz9w, reason: not valid java name */
    public final long m76getP21ufDz9w() {
        return this.f429p2;
    }

    public final CornerRounding getRounding() {
        return this.rounding;
    }

    public final float getSinAngle() {
        return this.sinAngle;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    /* renamed from: setCenter-DnnuFBc, reason: not valid java name */
    public final void m77setCenterDnnuFBc(long j) {
        this.center = j;
    }

    public /* synthetic */ RoundedCorner(long j, long j6, long j10, CornerRounding cornerRounding, g gVar) {
        this(j, j6, j10, cornerRounding);
    }

    public /* synthetic */ RoundedCorner(long j, long j6, long j10, CornerRounding cornerRounding, int i, g gVar) {
        this(j, j6, j10, (i & 8) != 0 ? null : cornerRounding, null);
    }

    public final List<Cubic> getCubics(float f) {
        return getCubics$default(this, f, 0.0f, 2, null);
    }
}
