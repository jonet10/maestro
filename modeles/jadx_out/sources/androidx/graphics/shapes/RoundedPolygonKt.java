package androidx.graphics.shapes;

import androidx.annotation.IntRange;
import androidx.collection.FloatFloatPair;
import androidx.collection.MutableFloatList;
import androidx.graphics.shapes.Feature;
import i7.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p6.i;
import q6.l;
import q6.n;
import q6.x;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RoundedPolygonKt {
    public static final RoundedPolygon RoundedPolygon(float[] fArr, CornerRounding cornerRounding, List<CornerRounding> list, float f, float f10) {
        CornerRounding cornerRounding2;
        Float valueOf = Float.valueOf(1.0f);
        fArr.getClass();
        cornerRounding.getClass();
        if (fArr.length < 6) {
            com.google.gson.internal.a.p("Polygons must have at least 3 vertices");
            return null;
        }
        int i = 2;
        int i6 = 1;
        if (fArr.length % 2 == 1) {
            com.google.gson.internal.a.p("The vertices array should have even size");
            return null;
        }
        if (list != null && list.size() * 2 != fArr.length) {
            com.google.gson.internal.a.p("perVertexRounding list should be either null or the same size as the number of vertices (vertices.size / 2)");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = fArr.length / 2;
        ArrayList arrayList2 = new ArrayList();
        int i10 = 0;
        int i11 = 0;
        while (i11 < length) {
            CornerRounding cornerRounding3 = (list == null || (cornerRounding2 = list.get(i11)) == null) ? cornerRounding : cornerRounding2;
            int i12 = (((i11 + length) - 1) % length) * 2;
            int i13 = i11 + 1;
            int i14 = (i13 % length) * 2;
            int i15 = i11 * 2;
            arrayList2.add(new RoundedCorner(FloatFloatPair.m9constructorimpl(fArr[i12], fArr[i12 + 1]), FloatFloatPair.m9constructorimpl(fArr[i15], fArr[i15 + 1]), FloatFloatPair.m9constructorimpl(fArr[i14], fArr[i14 + 1]), cornerRounding3, null));
            i11 = i13;
        }
        d K = f.K(0, length);
        ArrayList arrayList3 = new ArrayList(n.i0(K, 10));
        Iterator it = K.iterator();
        while (it.hasNext()) {
            int nextInt = ((x) it).nextInt();
            int i16 = (nextInt + 1) % length;
            float expectedRoundCut = ((RoundedCorner) arrayList2.get(nextInt)).getExpectedRoundCut() + ((RoundedCorner) arrayList2.get(i16)).getExpectedRoundCut();
            float expectedCut = ((RoundedCorner) arrayList2.get(nextInt)).getExpectedCut() + ((RoundedCorner) arrayList2.get(i16)).getExpectedCut();
            int i17 = nextInt * 2;
            int i18 = i16 * 2;
            float distance = Utils.distance(fArr[i17] - fArr[i18], fArr[i17 + 1] - fArr[i18 + 1]);
            arrayList3.add(expectedRoundCut > distance ? new i(Float.valueOf(distance / expectedRoundCut), Float.valueOf(0.0f)) : expectedCut > distance ? new i(valueOf, Float.valueOf((distance - expectedRoundCut) / (expectedCut - expectedRoundCut))) : new i(valueOf, valueOf));
        }
        for (int i19 = 0; i19 < length; i19++) {
            MutableFloatList mutableFloatList = new MutableFloatList(2);
            for (int i20 = 0; i20 < 2; i20++) {
                i iVar = (i) arrayList3.get((((i19 + length) - 1) + i20) % length);
                mutableFloatList.add(((((RoundedCorner) arrayList2.get(i19)).getExpectedCut() - ((RoundedCorner) arrayList2.get(i19)).getExpectedRoundCut()) * ((Number) iVar.f8442b).floatValue()) + (((RoundedCorner) arrayList2.get(i19)).getExpectedRoundCut() * ((Number) iVar.f8441a).floatValue()));
            }
            arrayList.add(((RoundedCorner) arrayList2.get(i19)).getCubics(mutableFloatList.get(0), mutableFloatList.get(1)));
        }
        ArrayList arrayList4 = new ArrayList();
        while (i10 < length) {
            int i21 = i10 + 1;
            int i22 = i21 % length;
            int i23 = i10 * 2;
            long m9constructorimpl = FloatFloatPair.m9constructorimpl(fArr[i23], fArr[i23 + i6]);
            int i24 = (((i10 + length) - i6) % length) * i;
            long m9constructorimpl2 = FloatFloatPair.m9constructorimpl(fArr[i24], fArr[i24 + i6]);
            int i25 = i22 * 2;
            arrayList4.add(new Feature.Corner((List) arrayList.get(i10), m9constructorimpl, ((RoundedCorner) arrayList2.get(i10)).m71getCenter1ufDz9w(), PointKt.m50clockwiseybeJwSQ(PointKt.m62minusybeJwSQ(m9constructorimpl, m9constructorimpl2), PointKt.m62minusybeJwSQ(FloatFloatPair.m9constructorimpl(fArr[i25], fArr[i25 + i6]), m9constructorimpl)), null));
            arrayList4.add(new Feature.Edge(a.a.H(Cubic.Companion.straightLine(((Cubic) l.y0((List) arrayList.get(i10))).getAnchor1X(), ((Cubic) l.y0((List) arrayList.get(i10))).getAnchor1Y(), ((Cubic) l.q0((List) arrayList.get(i22))).getAnchor0X(), ((Cubic) l.q0((List) arrayList.get(i22))).getAnchor0Y()))));
            i10 = i21;
            i = 2;
            i6 = 1;
        }
        long calculateCenter = (f == Float.MIN_VALUE || f10 == Float.MIN_VALUE) ? calculateCenter(fArr) : FloatFloatPair.m9constructorimpl(f, f10);
        return new RoundedPolygon(arrayList4, Float.intBitsToFloat((int) (calculateCenter >> 32)), Float.intBitsToFloat((int) (calculateCenter & 4294967295L)));
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(int i, float f, float f10, float f11, CornerRounding cornerRounding, List list, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            f = 1.0f;
        }
        if ((i6 & 4) != 0) {
            f10 = 0.0f;
        }
        if ((i6 & 8) != 0) {
            f11 = 0.0f;
        }
        if ((i6 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i6 & 32) != 0) {
            list = null;
        }
        List list2 = list;
        return RoundedPolygon(i, f, f10, f11, cornerRounding, list2);
    }

    private static final long calculateCenter(float[] fArr) {
        float f = 0.0f;
        int i = 0;
        float f10 = 0.0f;
        while (i < fArr.length) {
            int i6 = i + 1;
            f += fArr[i];
            i += 2;
            f10 += fArr[i6];
        }
        float f11 = 2;
        return FloatFloatPair.m9constructorimpl((f / fArr.length) / f11, (f10 / fArr.length) / f11);
    }

    private static final float[] verticesFromNumVerts(int i, float f, float f10, float f11) {
        float[] fArr = new float[i * 2];
        int i6 = 0;
        int i10 = 0;
        while (i6 < i) {
            float f12 = f;
            long m63plusybeJwSQ = PointKt.m63plusybeJwSQ(Utils.m79radialToCartesianL6JJ3z0$default(f12, (Utils.getFloatPi() / i) * 2 * i6, 0L, 4, null), FloatFloatPair.m9constructorimpl(f10, f11));
            int i11 = i10 + 1;
            fArr[i10] = PointKt.m59getXDnnuFBc(m63plusybeJwSQ);
            i10 += 2;
            fArr[i11] = PointKt.m60getYDnnuFBc(m63plusybeJwSQ);
            i6++;
            f = f12;
        }
        return fArr;
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(float[] fArr, CornerRounding cornerRounding, List list, float f, float f10, int i, Object obj) {
        if ((i & 2) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            f = Float.MIN_VALUE;
        }
        if ((i & 16) != 0) {
            f10 = Float.MIN_VALUE;
        }
        return RoundedPolygon(fArr, cornerRounding, (List<CornerRounding>) list, f, f10);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i, float f) {
        return RoundedPolygon$default(i, f, 0.0f, 0.0f, null, null, 60, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i, float f, float f10) {
        return RoundedPolygon$default(i, f, f10, 0.0f, null, null, 56, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i, float f, float f10, float f11) {
        return RoundedPolygon$default(i, f, f10, f11, null, null, 48, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i, float f, float f10, float f11, CornerRounding cornerRounding) {
        cornerRounding.getClass();
        return RoundedPolygon$default(i, f, f10, f11, cornerRounding, null, 32, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] fArr) {
        fArr.getClass();
        return RoundedPolygon$default(fArr, null, null, 0.0f, 0.0f, 30, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] fArr, CornerRounding cornerRounding) {
        fArr.getClass();
        cornerRounding.getClass();
        return RoundedPolygon$default(fArr, cornerRounding, null, 0.0f, 0.0f, 28, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] fArr, CornerRounding cornerRounding, List<CornerRounding> list) {
        fArr.getClass();
        cornerRounding.getClass();
        return RoundedPolygon$default(fArr, cornerRounding, list, 0.0f, 0.0f, 24, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] fArr, CornerRounding cornerRounding, List<CornerRounding> list, float f) {
        fArr.getClass();
        cornerRounding.getClass();
        return RoundedPolygon$default(fArr, cornerRounding, list, f, 0.0f, 16, null);
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i, float f, float f10, float f11, CornerRounding cornerRounding, List<CornerRounding> list) {
        cornerRounding.getClass();
        return RoundedPolygon(verticesFromNumVerts(i, f, f10, f11), cornerRounding, list, f10, f11);
    }

    public static final RoundedPolygon RoundedPolygon(RoundedPolygon roundedPolygon) {
        roundedPolygon.getClass();
        return new RoundedPolygon(roundedPolygon.getFeatures$graphics_shapes_release(), roundedPolygon.getCenterX(), roundedPolygon.getCenterY());
    }

    public static final RoundedPolygon RoundedPolygon(@IntRange(from = 3) int i) {
        return RoundedPolygon$default(i, 0.0f, 0.0f, 0.0f, null, null, 62, null);
    }
}
