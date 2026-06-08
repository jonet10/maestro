package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.collection.FloatFloatPair;
import androidx.graphics.shapes.RoundedPolygon;
import i7.c;
import i7.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q6.m;
import q6.r;
import q6.x;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ShapesKt {
    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i, float f, float f10, float f11) {
        companion.getClass();
        if (i >= 3) {
            return RoundedPolygonKt.RoundedPolygon$default(i, f / ((float) Math.cos(Utils.getFloatPi() / i)), f10, f11, new CornerRounding(f, 0.0f, 2, null), null, 32, null);
        }
        com.google.gson.internal.a.p("Circle must have at least three vertices");
        return null;
    }

    public static /* synthetic */ RoundedPolygon circle$default(RoundedPolygon.Companion companion, int i, float f, float f10, float f11, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = 8;
        }
        if ((i6 & 2) != 0) {
            f = 1.0f;
        }
        if ((i6 & 4) != 0) {
            f10 = 0.0f;
        }
        if ((i6 & 8) != 0) {
            f11 = 0.0f;
        }
        return circle(companion, i, f, f10, f11);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f, float f10, float f11, float f12, float f13) {
        companion.getClass();
        if (f <= 0.0f || f10 <= 0.0f) {
            com.google.gson.internal.a.p("Pill shapes must have positive width and height");
            return null;
        }
        float f14 = 2;
        float f15 = f / f14;
        float f16 = f10 / f14;
        float f17 = f15 + f12;
        float f18 = f16 + f13;
        float f19 = (-f15) + f12;
        float f20 = (-f16) + f13;
        return RoundedPolygonKt.RoundedPolygon$default(new float[]{f17, f18, f19, f18, f19, f20, f17, f20}, new CornerRounding(Math.min(f15, f16), f11), null, f12, f13, 4, null);
    }

    public static /* synthetic */ RoundedPolygon pill$default(RoundedPolygon.Companion companion, float f, float f10, float f11, float f12, float f13, int i, Object obj) {
        float f14;
        float f15;
        float f16;
        float f17;
        RoundedPolygon.Companion companion2;
        float f18;
        if ((i & 1) != 0) {
            f = 2.0f;
        }
        if ((i & 2) != 0) {
            f10 = 1.0f;
        }
        if ((i & 4) != 0) {
            f11 = 0.0f;
        }
        if ((i & 8) != 0) {
            f12 = 0.0f;
        }
        if ((i & 16) != 0) {
            f14 = 0.0f;
            f17 = f11;
            f15 = f12;
            f18 = f;
            f16 = f10;
            companion2 = companion;
        } else {
            f14 = f13;
            f15 = f12;
            f16 = f10;
            f17 = f11;
            companion2 = companion;
            f18 = f;
        }
        return pill(companion2, f18, f16, f17, f15, f14);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f11, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f12, @FloatRange(from = 0.0d, to = 1.0d) float f13, float f14, float f15) {
        List<CornerRounding> list2;
        companion.getClass();
        cornerRounding.getClass();
        if (f <= 0.0f || f10 <= 0.0f) {
            com.google.gson.internal.a.p("Pill shapes must have positive width and height");
            return null;
        }
        if (f11 <= 0.0f || f11 > 1.0f) {
            com.google.gson.internal.a.p("innerRadius must be between 0 and 1");
            return null;
        }
        if (list != null || cornerRounding2 == null) {
            list2 = list;
        } else {
            d K = f.K(0, i);
            list2 = new ArrayList<>();
            Iterator it = K.iterator();
            while (((c) it).f5700l) {
                ((x) it).nextInt();
                r.k0(m.d0(cornerRounding, cornerRounding2), list2);
            }
        }
        return RoundedPolygonKt.RoundedPolygon(pillStarVerticesFromNumVerts(i, f, f10, f11, f12, f13, f14, f15), cornerRounding, list2, f14, f15);
    }

    public static /* synthetic */ RoundedPolygon pillStar$default(RoundedPolygon.Companion companion, float f, float f10, int i, float f11, CornerRounding cornerRounding, CornerRounding cornerRounding2, List list, float f12, float f13, float f14, float f15, int i6, Object obj) {
        float f16;
        float f17;
        float f18;
        float f19;
        CornerRounding cornerRounding3;
        List list2;
        float f20;
        CornerRounding cornerRounding4;
        float f21;
        int i10;
        RoundedPolygon.Companion companion2;
        float f22;
        if ((i6 & 1) != 0) {
            f = 2.0f;
        }
        if ((i6 & 2) != 0) {
            f10 = 1.0f;
        }
        if ((i6 & 4) != 0) {
            i = 8;
        }
        if ((i6 & 8) != 0) {
            f11 = 0.5f;
        }
        if ((i6 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i6 & 32) != 0) {
            cornerRounding2 = null;
        }
        if ((i6 & 64) != 0) {
            list = null;
        }
        if ((i6 & 128) != 0) {
            f12 = 0.5f;
        }
        if ((i6 & 256) != 0) {
            f13 = 0.0f;
        }
        if ((i6 & 512) != 0) {
            f14 = 0.0f;
        }
        if ((i6 & 1024) != 0) {
            f16 = 0.0f;
            f19 = f13;
            f17 = f14;
            list2 = list;
            f18 = f12;
            cornerRounding4 = cornerRounding;
            cornerRounding3 = cornerRounding2;
            i10 = i;
            f20 = f11;
            f22 = f;
            f21 = f10;
            companion2 = companion;
        } else {
            f16 = f15;
            f17 = f14;
            f18 = f12;
            f19 = f13;
            cornerRounding3 = cornerRounding2;
            list2 = list;
            f20 = f11;
            cornerRounding4 = cornerRounding;
            f21 = f10;
            i10 = i;
            companion2 = companion;
            f22 = f;
        }
        return pillStar(companion2, f22, f21, i10, f20, cornerRounding4, cornerRounding3, list2, f18, f19, f17, f16);
    }

    private static final float[] pillStarVerticesFromNumVerts(int i, float f, float f10, float f11, float f12, float f13, float f14, float f15) {
        int i6;
        float f16;
        float f17;
        float f18;
        long m9constructorimpl;
        float min = Math.min(f, f10);
        float f19 = f10 - f;
        if (f19 < 0.0f) {
            f19 = 0.0f;
        }
        float f20 = f - f10;
        if (f20 < 0.0f) {
            f20 = 0.0f;
        }
        float f21 = 2;
        float f22 = f19 / f21;
        float f23 = f20 / f21;
        float interpolate = Utils.interpolate(f11, 1.0f, f12) * Utils.getTwoPi() * min;
        float f24 = (f21 * f19) + (f21 * f20) + interpolate;
        float f25 = interpolate / 4;
        float f26 = f22 + f25;
        float f27 = f26 + f20;
        float f28 = f27 + f25;
        float f29 = f28 + f19;
        float f30 = f29 + f25;
        float f31 = f30 + f20;
        float f32 = f31 + f25;
        float[] fArr = {0.0f, f22, f26, f27, f28, f29, f30, f31, f32, f32 + f22, f24};
        int i10 = i * 2;
        float f33 = f24 / i10;
        float f34 = f13 * f24;
        float[] fArr2 = new float[i * 4];
        float f35 = f20;
        long m9constructorimpl2 = FloatFloatPair.m9constructorimpl(f23, f22);
        float f36 = -f23;
        long m9constructorimpl3 = FloatFloatPair.m9constructorimpl(f36, f22);
        float f37 = -f22;
        long m9constructorimpl4 = FloatFloatPair.m9constructorimpl(f36, f37);
        long m9constructorimpl5 = FloatFloatPair.m9constructorimpl(f23, f37);
        float f38 = f19;
        float f39 = f22;
        int i11 = 0;
        float f40 = 0.0f;
        boolean z9 = false;
        int i12 = 0;
        int i13 = 0;
        while (i11 < i10) {
            float f41 = f34 % f24;
            if (f41 < f40) {
                i12 = 0;
            }
            while (true) {
                int i14 = (i12 + 1) % 11;
                float f42 = fArr[i14];
                if (f41 >= f42) {
                    f39 = fArr[(i14 + 1) % 11];
                    i12 = i14;
                    f40 = f42;
                } else {
                    float f43 = (f41 - f40) / (f39 - f40);
                    if (z9) {
                        i6 = i11;
                        f16 = min * f11;
                    } else {
                        i6 = i11;
                        f16 = min;
                    }
                    switch (i12) {
                        case 0:
                            f17 = f22;
                            float f44 = f16;
                            f18 = f23;
                            m9constructorimpl = FloatFloatPair.m9constructorimpl(f44, f43 * f17);
                            break;
                        case 1:
                            f17 = f22;
                            float f45 = f16;
                            f18 = f23;
                            m9constructorimpl = PointKt.m63plusybeJwSQ(Utils.m79radialToCartesianL6JJ3z0$default(f45, (Utils.getFloatPi() * f43) / f21, 0L, 4, null), m9constructorimpl2);
                            break;
                        case 2:
                            f17 = f22;
                            float f46 = f16;
                            f18 = f23;
                            m9constructorimpl = FloatFloatPair.m9constructorimpl(f18 - (f43 * f35), f46);
                            break;
                        case 3:
                            f17 = f22;
                            float f47 = f16;
                            f18 = f23;
                            m9constructorimpl = PointKt.m63plusybeJwSQ(Utils.m79radialToCartesianL6JJ3z0$default(f47, ((Utils.getFloatPi() * f43) / f21) + (Utils.getFloatPi() / f21), 0L, 4, null), m9constructorimpl3);
                            break;
                        case 4:
                            f17 = f22;
                            float f48 = f16;
                            f18 = f23;
                            m9constructorimpl = FloatFloatPair.m9constructorimpl(-f48, f17 - (f43 * f38));
                            break;
                        case 5:
                            f17 = f22;
                            float f49 = f16;
                            f18 = f23;
                            m9constructorimpl = PointKt.m63plusybeJwSQ(Utils.m79radialToCartesianL6JJ3z0$default(f49, ((Utils.getFloatPi() * f43) / f21) + Utils.getFloatPi(), 0L, 4, null), m9constructorimpl4);
                            break;
                        case 6:
                            f17 = f22;
                            float f50 = f16;
                            f18 = f23;
                            m9constructorimpl = FloatFloatPair.m9constructorimpl((f43 * f35) + f36, -f50);
                            break;
                        case 7:
                            f17 = f22;
                            float f51 = f16;
                            f18 = f23;
                            m9constructorimpl = PointKt.m63plusybeJwSQ(Utils.m79radialToCartesianL6JJ3z0$default(f51, ((Utils.getFloatPi() * f43) / f21) + (Utils.getFloatPi() * 1.5f), 0L, 4, null), m9constructorimpl5);
                            break;
                        default:
                            f17 = f22;
                            m9constructorimpl = FloatFloatPair.m9constructorimpl(f16, (f43 * f22) + f37);
                            f18 = f23;
                            break;
                    }
                    int i15 = i13 + 1;
                    fArr2[i13] = PointKt.m59getXDnnuFBc(m9constructorimpl) + f14;
                    i13 += 2;
                    fArr2[i15] = PointKt.m60getYDnnuFBc(m9constructorimpl) + f15;
                    f34 += f33;
                    z9 = !z9;
                    f23 = f18;
                    i11 = i6 + 1;
                    f22 = f17;
                }
            }
        }
        return fArr2;
    }

    public static final RoundedPolygon rectangle(RoundedPolygon.Companion companion, float f, float f10, CornerRounding cornerRounding, List<CornerRounding> list, float f11, float f12) {
        companion.getClass();
        cornerRounding.getClass();
        float f13 = 2;
        float f14 = f / f13;
        float f15 = f11 - f14;
        float f16 = f10 / f13;
        float f17 = f12 - f16;
        float f18 = f14 + f11;
        float f19 = f16 + f12;
        return RoundedPolygonKt.RoundedPolygon(new float[]{f18, f19, f15, f19, f15, f17, f18, f17}, cornerRounding, list, f11, f12);
    }

    public static /* synthetic */ RoundedPolygon rectangle$default(RoundedPolygon.Companion companion, float f, float f10, CornerRounding cornerRounding, List list, float f11, float f12, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 2.0f;
        }
        if ((i & 2) != 0) {
            f10 = 2.0f;
        }
        if ((i & 4) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i & 8) != 0) {
            list = null;
        }
        if ((i & 16) != 0) {
            f11 = 0.0f;
        }
        if ((i & 32) != 0) {
            f12 = 0.0f;
        }
        return rectangle(companion, f, f10, cornerRounding, list, f11, f12);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i, float f, float f10, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, float f11, float f12) {
        companion.getClass();
        cornerRounding.getClass();
        if (f <= 0.0f || f10 <= 0.0f) {
            com.google.gson.internal.a.p("Star radii must both be greater than 0");
            return null;
        }
        if (f10 >= f) {
            com.google.gson.internal.a.p("innerRadius must be less than radius");
            return null;
        }
        if (list == null && cornerRounding2 != null) {
            d K = f.K(0, i);
            ArrayList arrayList = new ArrayList();
            Iterator it = K.iterator();
            while (((c) it).f5700l) {
                ((x) it).nextInt();
                r.k0(m.d0(cornerRounding, cornerRounding2), arrayList);
            }
            list = arrayList;
        }
        return RoundedPolygonKt.RoundedPolygon(starVerticesFromNumVerts(i, f, f10, f11, f12), cornerRounding, list, f11, f12);
    }

    public static /* synthetic */ RoundedPolygon star$default(RoundedPolygon.Companion companion, int i, float f, float f10, CornerRounding cornerRounding, CornerRounding cornerRounding2, List list, float f11, float f12, int i6, Object obj) {
        return star(companion, i, (i6 & 2) != 0 ? 1.0f : f, (i6 & 4) != 0 ? 0.5f : f10, (i6 & 8) != 0 ? CornerRounding.Unrounded : cornerRounding, (i6 & 16) != 0 ? null : cornerRounding2, (i6 & 32) == 0 ? list : null, (i6 & 64) != 0 ? 0.0f : f11, (i6 & 128) != 0 ? 0.0f : f12);
    }

    private static final float[] starVerticesFromNumVerts(int i, float f, float f10, float f11, float f12) {
        float[] fArr = new float[i * 4];
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            float f13 = i;
            long m79radialToCartesianL6JJ3z0$default = Utils.m79radialToCartesianL6JJ3z0$default(f, (Utils.getFloatPi() / f13) * 2 * i10, 0L, 4, null);
            fArr[i6] = PointKt.m59getXDnnuFBc(m79radialToCartesianL6JJ3z0$default) + f11;
            fArr[i6 + 1] = PointKt.m60getYDnnuFBc(m79radialToCartesianL6JJ3z0$default) + f12;
            long m79radialToCartesianL6JJ3z0$default2 = Utils.m79radialToCartesianL6JJ3z0$default(f10, (Utils.getFloatPi() / f13) * ((i10 * 2) + 1), 0L, 4, null);
            int i11 = i6 + 3;
            fArr[i6 + 2] = PointKt.m59getXDnnuFBc(m79radialToCartesianL6JJ3z0$default2) + f11;
            i6 += 4;
            fArr[i11] = PointKt.m60getYDnnuFBc(m79radialToCartesianL6JJ3z0$default2) + f12;
        }
        return fArr;
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f) {
        companion.getClass();
        return pillStar$default(companion, f, 0.0f, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2046, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10) {
        companion.getClass();
        return pillStar$default(companion, f, f10, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2044, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i) {
        companion.getClass();
        return pillStar$default(companion, f, f10, i, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2040, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f11) {
        companion.getClass();
        return pillStar$default(companion, f, f10, i, f11, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2032, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f11, CornerRounding cornerRounding) {
        companion.getClass();
        cornerRounding.getClass();
        return pillStar$default(companion, f, f10, i, f11, cornerRounding, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2016, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f11, CornerRounding cornerRounding, CornerRounding cornerRounding2) {
        companion.getClass();
        cornerRounding.getClass();
        return pillStar$default(companion, f, f10, i, f11, cornerRounding, cornerRounding2, null, 0.0f, 0.0f, 0.0f, 0.0f, 1984, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f11, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list) {
        companion.getClass();
        cornerRounding.getClass();
        return pillStar$default(companion, f, f10, i, f11, cornerRounding, cornerRounding2, list, 0.0f, 0.0f, 0.0f, 0.0f, 1920, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f11, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f12) {
        companion.getClass();
        cornerRounding.getClass();
        return pillStar$default(companion, f, f10, i, f11, cornerRounding, cornerRounding2, list, f12, 0.0f, 0.0f, 0.0f, 1792, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f11, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f12, @FloatRange(from = 0.0d, to = 1.0d) float f13) {
        companion.getClass();
        cornerRounding.getClass();
        return pillStar$default(companion, f, f10, i, f11, cornerRounding, cornerRounding2, list, f12, f13, 0.0f, 0.0f, 1536, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion, float f, float f10, int i, @FloatRange(from = 0.0d, fromInclusive = false, to = 1.0d, toInclusive = false) float f11, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, @FloatRange(from = 0.0d, to = 1.0d) float f12, @FloatRange(from = 0.0d, to = 1.0d) float f13, float f14) {
        companion.getClass();
        cornerRounding.getClass();
        return pillStar$default(companion, f, f10, i, f11, cornerRounding, cornerRounding2, list, f12, f13, f14, 0.0f, 1024, null);
    }

    public static final RoundedPolygon pillStar(RoundedPolygon.Companion companion) {
        companion.getClass();
        return pillStar$default(companion, 0.0f, 0.0f, 0, 0.0f, null, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 2047, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i) {
        companion.getClass();
        return circle$default(companion, i, 0.0f, 0.0f, 0.0f, 14, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i, float f) {
        companion.getClass();
        return circle$default(companion, i, f, 0.0f, 0.0f, 12, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion, @IntRange(from = 3) int i, float f, float f10) {
        companion.getClass();
        return circle$default(companion, i, f, f10, 0.0f, 8, null);
    }

    public static final RoundedPolygon circle(RoundedPolygon.Companion companion) {
        companion.getClass();
        return circle$default(companion, 0, 0.0f, 0.0f, 0.0f, 15, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f) {
        companion.getClass();
        return pill$default(companion, f, 0.0f, 0.0f, 0.0f, 0.0f, 30, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f, float f10) {
        companion.getClass();
        return pill$default(companion, f, f10, 0.0f, 0.0f, 0.0f, 28, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f, float f10, float f11) {
        companion.getClass();
        return pill$default(companion, f, f10, f11, 0.0f, 0.0f, 24, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion, float f, float f10, float f11, float f12) {
        companion.getClass();
        return pill$default(companion, f, f10, f11, f12, 0.0f, 16, null);
    }

    public static final RoundedPolygon pill(RoundedPolygon.Companion companion) {
        companion.getClass();
        return pill$default(companion, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 31, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i, float f) {
        companion.getClass();
        return star$default(companion, i, f, 0.0f, null, null, null, 0.0f, 0.0f, 252, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i, float f, float f10) {
        companion.getClass();
        return star$default(companion, i, f, f10, null, null, null, 0.0f, 0.0f, 248, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i, float f, float f10, CornerRounding cornerRounding) {
        companion.getClass();
        cornerRounding.getClass();
        return star$default(companion, i, f, f10, cornerRounding, null, null, 0.0f, 0.0f, 240, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i, float f, float f10, CornerRounding cornerRounding, CornerRounding cornerRounding2) {
        companion.getClass();
        cornerRounding.getClass();
        return star$default(companion, i, f, f10, cornerRounding, cornerRounding2, null, 0.0f, 0.0f, 224, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i, float f, float f10, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list) {
        companion.getClass();
        cornerRounding.getClass();
        return star$default(companion, i, f, f10, cornerRounding, cornerRounding2, list, 0.0f, 0.0f, 192, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i, float f, float f10, CornerRounding cornerRounding, CornerRounding cornerRounding2, List<CornerRounding> list, float f11) {
        companion.getClass();
        cornerRounding.getClass();
        return star$default(companion, i, f, f10, cornerRounding, cornerRounding2, list, f11, 0.0f, 128, null);
    }

    public static final RoundedPolygon star(RoundedPolygon.Companion companion, int i) {
        companion.getClass();
        return star$default(companion, i, 0.0f, 0.0f, null, null, null, 0.0f, 0.0f, 254, null);
    }
}
