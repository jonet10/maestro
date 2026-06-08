package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PointKt {
    /* renamed from: clockwise-ybeJwSQ, reason: not valid java name */
    public static final boolean m50clockwiseybeJwSQ(long j, long j6) {
        return (m60getYDnnuFBc(j6) * m59getXDnnuFBc(j)) - (m59getXDnnuFBc(j6) * m60getYDnnuFBc(j)) > 0.0f;
    }

    /* renamed from: copy-5P9i7ZU, reason: not valid java name */
    public static final long m51copy5P9i7ZU(long j, float f, float f10) {
        return FloatFloatPair.m9constructorimpl(f, f10);
    }

    /* renamed from: copy-5P9i7ZU$default, reason: not valid java name */
    public static /* synthetic */ long m52copy5P9i7ZU$default(long j, float f, float f10, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Float.intBitsToFloat((int) (j >> 32));
        }
        if ((i & 2) != 0) {
            f10 = Float.intBitsToFloat((int) (4294967295L & j));
        }
        return m51copy5P9i7ZU(j, f, f10);
    }

    /* renamed from: div-so9K2fw, reason: not valid java name */
    public static final long m53divso9K2fw(long j, float f) {
        return FloatFloatPair.m9constructorimpl(m59getXDnnuFBc(j) / f, m60getYDnnuFBc(j) / f);
    }

    /* renamed from: dotProduct-5P9i7ZU, reason: not valid java name */
    public static final float m54dotProduct5P9i7ZU(long j, float f, float f10) {
        return (m60getYDnnuFBc(j) * f10) + (m59getXDnnuFBc(j) * f);
    }

    /* renamed from: dotProduct-ybeJwSQ, reason: not valid java name */
    public static final float m55dotProductybeJwSQ(long j, long j6) {
        return (m60getYDnnuFBc(j6) * m60getYDnnuFBc(j)) + (m59getXDnnuFBc(j6) * m59getXDnnuFBc(j));
    }

    /* renamed from: getDirection-DnnuFBc, reason: not valid java name */
    public static final long m56getDirectionDnnuFBc(long j) {
        float m57getDistanceDnnuFBc = m57getDistanceDnnuFBc(j);
        if (m57getDistanceDnnuFBc > 0.0f) {
            return m53divso9K2fw(j, m57getDistanceDnnuFBc);
        }
        com.google.gson.internal.a.p("Can't get the direction of a 0-length vector");
        return 0L;
    }

    /* renamed from: getDistance-DnnuFBc, reason: not valid java name */
    public static final float m57getDistanceDnnuFBc(long j) {
        return (float) Math.sqrt((m60getYDnnuFBc(j) * m60getYDnnuFBc(j)) + (m59getXDnnuFBc(j) * m59getXDnnuFBc(j)));
    }

    /* renamed from: getDistanceSquared-DnnuFBc, reason: not valid java name */
    public static final float m58getDistanceSquaredDnnuFBc(long j) {
        return (m60getYDnnuFBc(j) * m60getYDnnuFBc(j)) + (m59getXDnnuFBc(j) * m59getXDnnuFBc(j));
    }

    /* renamed from: getX-DnnuFBc, reason: not valid java name */
    public static final float m59getXDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getY-DnnuFBc, reason: not valid java name */
    public static final float m60getYDnnuFBc(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: interpolate-dLqxh1s, reason: not valid java name */
    public static final long m61interpolatedLqxh1s(long j, long j6, float f) {
        return FloatFloatPair.m9constructorimpl(Utils.interpolate(m59getXDnnuFBc(j), m59getXDnnuFBc(j6), f), Utils.interpolate(m60getYDnnuFBc(j), m60getYDnnuFBc(j6), f));
    }

    /* renamed from: minus-ybeJwSQ, reason: not valid java name */
    public static final long m62minusybeJwSQ(long j, long j6) {
        return FloatFloatPair.m9constructorimpl(m59getXDnnuFBc(j) - m59getXDnnuFBc(j6), m60getYDnnuFBc(j) - m60getYDnnuFBc(j6));
    }

    /* renamed from: plus-ybeJwSQ, reason: not valid java name */
    public static final long m63plusybeJwSQ(long j, long j6) {
        return FloatFloatPair.m9constructorimpl(m59getXDnnuFBc(j6) + m59getXDnnuFBc(j), m60getYDnnuFBc(j6) + m60getYDnnuFBc(j));
    }

    /* renamed from: rem-so9K2fw, reason: not valid java name */
    public static final long m64remso9K2fw(long j, float f) {
        return FloatFloatPair.m9constructorimpl(m59getXDnnuFBc(j) % f, m60getYDnnuFBc(j) % f);
    }

    /* renamed from: times-so9K2fw, reason: not valid java name */
    public static final long m65timesso9K2fw(long j, float f) {
        return FloatFloatPair.m9constructorimpl(m59getXDnnuFBc(j) * f, m60getYDnnuFBc(j) * f);
    }

    /* renamed from: transformed-so9K2fw, reason: not valid java name */
    public static final long m66transformedso9K2fw(long j, PointTransformer pointTransformer) {
        pointTransformer.getClass();
        long mo68transformXgqJiTY = pointTransformer.mo68transformXgqJiTY(m59getXDnnuFBc(j), m60getYDnnuFBc(j));
        return FloatFloatPair.m9constructorimpl(Float.intBitsToFloat((int) (mo68transformXgqJiTY >> 32)), Float.intBitsToFloat((int) (mo68transformXgqJiTY & 4294967295L)));
    }

    /* renamed from: unaryMinus-DnnuFBc, reason: not valid java name */
    public static final long m67unaryMinusDnnuFBc(long j) {
        return FloatFloatPair.m9constructorimpl(-m59getXDnnuFBc(j), -m60getYDnnuFBc(j));
    }
}
