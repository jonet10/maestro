package androidx.graphics.shapes;

import androidx.graphics.shapes.MeasuredPolygon;
import d7.l;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;
import p6.i;
import r6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Morph {
    public static final Companion Companion = new Companion(null);
    private final List<i> _morphMatch;
    private final RoundedPolygon end;
    private final RoundedPolygon start;

    public Morph(RoundedPolygon roundedPolygon, RoundedPolygon roundedPolygon2) {
        roundedPolygon.getClass();
        roundedPolygon2.getClass();
        this.start = roundedPolygon;
        this.end = roundedPolygon2;
        this._morphMatch = Companion.match$graphics_shapes_release(roundedPolygon, roundedPolygon2);
    }

    public static /* synthetic */ float[] calculateBounds$default(Morph morph, float[] fArr, boolean z9, int i, Object obj) {
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        if ((i & 2) != 0) {
            z9 = true;
        }
        return morph.calculateBounds(fArr, z9);
    }

    public static /* synthetic */ float[] calculateMaxBounds$default(Morph morph, float[] fArr, int i, Object obj) {
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        return morph.calculateMaxBounds(fArr);
    }

    public static void forEachCubic$default(Morph morph, float f, MutableCubic mutableCubic, l lVar, int i, Object obj) {
        if ((i & 2) != 0) {
            mutableCubic = new MutableCubic();
        }
        mutableCubic.getClass();
        lVar.getClass();
        int size = morph.getMorphMatch().size();
        for (int i6 = 0; i6 < size; i6++) {
            mutableCubic.interpolate((Cubic) morph.getMorphMatch().get(i6).f8441a, (Cubic) morph.getMorphMatch().get(i6).f8442b, f);
            lVar.invoke(mutableCubic);
        }
    }

    public final List<Cubic> asCubics(float f) {
        c t9 = a.a.t();
        int size = this._morphMatch.size();
        Cubic cubic = null;
        Cubic cubic2 = null;
        int i = 0;
        while (i < size) {
            float[] fArr = new float[8];
            for (int i6 = 0; i6 < 8; i6++) {
                fArr[i6] = Utils.interpolate(((Cubic) this._morphMatch.get(i).f8441a).getPoints$graphics_shapes_release()[i6], ((Cubic) this._morphMatch.get(i).f8442b).getPoints$graphics_shapes_release()[i6], f);
            }
            Cubic cubic3 = new Cubic(fArr);
            if (cubic2 == null) {
                cubic2 = cubic3;
            }
            if (cubic != null) {
                t9.add(cubic);
            }
            i++;
            cubic = cubic3;
        }
        if (cubic != null && cubic2 != null) {
            t9.add(CubicKt.Cubic(cubic.getAnchor0X(), cubic.getAnchor0Y(), cubic.getControl0X(), cubic.getControl0Y(), cubic.getControl1X(), cubic.getControl1Y(), cubic2.getAnchor0X(), cubic2.getAnchor0Y()));
        }
        return a.a.m(t9);
    }

    public final float[] calculateBounds(float[] fArr, boolean z9) {
        fArr.getClass();
        this.start.calculateBounds(fArr, z9);
        float f = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[2];
        float f12 = fArr[3];
        this.end.calculateBounds(fArr, z9);
        fArr[0] = Math.min(f, fArr[0]);
        fArr[1] = Math.min(f10, fArr[1]);
        fArr[2] = Math.max(f11, fArr[2]);
        fArr[3] = Math.max(f12, fArr[3]);
        return fArr;
    }

    public final float[] calculateMaxBounds(float[] fArr) {
        fArr.getClass();
        this.start.calculateMaxBounds(fArr);
        float f = fArr[0];
        float f10 = fArr[1];
        float f11 = fArr[2];
        float f12 = fArr[3];
        this.end.calculateMaxBounds(fArr);
        fArr[0] = Math.min(f, fArr[0]);
        fArr[1] = Math.min(f10, fArr[1]);
        fArr[2] = Math.max(f11, fArr[2]);
        fArr[3] = Math.max(f12, fArr[3]);
        return fArr;
    }

    public final void forEachCubic(float f, l lVar) {
        lVar.getClass();
        MutableCubic mutableCubic = new MutableCubic();
        int size = getMorphMatch().size();
        for (int i = 0; i < size; i++) {
            mutableCubic.interpolate((Cubic) getMorphMatch().get(i).f8441a, (Cubic) getMorphMatch().get(i).f8442b, f);
            lVar.invoke(mutableCubic);
        }
    }

    public final List<i> getMorphMatch() {
        return this._morphMatch;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final List<i> match$graphics_shapes_release(RoundedPolygon roundedPolygon, RoundedPolygon roundedPolygon2) {
            i iVar;
            i iVar2;
            String unused;
            String unused2;
            String unused3;
            String unused4;
            String unused5;
            roundedPolygon.getClass();
            roundedPolygon2.getClass();
            MeasuredPolygon.Companion companion = MeasuredPolygon.Companion;
            MeasuredPolygon measurePolygon$graphics_shapes_release = companion.measurePolygon$graphics_shapes_release(new AngleMeasurer(roundedPolygon.getCenterX(), roundedPolygon.getCenterY()), roundedPolygon);
            MeasuredPolygon measurePolygon$graphics_shapes_release2 = companion.measurePolygon$graphics_shapes_release(new AngleMeasurer(roundedPolygon2.getCenterX(), roundedPolygon2.getCenterY()), roundedPolygon2);
            DoubleMapper featureMapper = FeatureMappingKt.featureMapper(measurePolygon$graphics_shapes_release.getFeatures(), measurePolygon$graphics_shapes_release2.getFeatures());
            float map = featureMapper.map(0.0f);
            unused = MorphKt.LOG_TAG;
            MeasuredPolygon cutAndShift = measurePolygon$graphics_shapes_release2.cutAndShift(map);
            ArrayList arrayList = new ArrayList();
            MeasuredPolygon.MeasuredCubic measuredCubic = (MeasuredPolygon.MeasuredCubic) q6.l.t0(measurePolygon$graphics_shapes_release, 0);
            MeasuredPolygon.MeasuredCubic measuredCubic2 = (MeasuredPolygon.MeasuredCubic) q6.l.t0(cutAndShift, 0);
            int i = 1;
            int i6 = 1;
            while (measuredCubic != null && measuredCubic2 != null) {
                float endOutlineProgress = i == measurePolygon$graphics_shapes_release.size() ? 1.0f : measuredCubic.getEndOutlineProgress();
                float mapBack = i6 == cutAndShift.size() ? 1.0f : featureMapper.mapBack(Utils.positiveModulo(measuredCubic2.getEndOutlineProgress() + map, 1.0f));
                float min = Math.min(endOutlineProgress, mapBack);
                unused2 = MorphKt.LOG_TAG;
                float f = 1.0E-6f + min;
                if (endOutlineProgress > f) {
                    unused3 = MorphKt.LOG_TAG;
                    iVar = measuredCubic.cutAtProgress(min);
                } else {
                    i iVar3 = new i(measuredCubic, q6.l.t0(measurePolygon$graphics_shapes_release, i));
                    i++;
                    iVar = iVar3;
                }
                MeasuredPolygon.MeasuredCubic measuredCubic3 = (MeasuredPolygon.MeasuredCubic) iVar.f8441a;
                measuredCubic = (MeasuredPolygon.MeasuredCubic) iVar.f8442b;
                if (mapBack > f) {
                    unused4 = MorphKt.LOG_TAG;
                    iVar2 = measuredCubic2.cutAtProgress(Utils.positiveModulo(featureMapper.map(min) - map, 1.0f));
                } else {
                    i iVar4 = new i(measuredCubic2, q6.l.t0(cutAndShift, i6));
                    i6++;
                    iVar2 = iVar4;
                }
                MeasuredPolygon.MeasuredCubic measuredCubic4 = (MeasuredPolygon.MeasuredCubic) iVar2.f8441a;
                measuredCubic2 = (MeasuredPolygon.MeasuredCubic) iVar2.f8442b;
                unused5 = MorphKt.LOG_TAG;
                arrayList.add(new i(measuredCubic3.getCubic(), measuredCubic4.getCubic()));
            }
            if (measuredCubic == null && measuredCubic2 == null) {
                return arrayList;
            }
            com.google.gson.internal.a.p("Expected both Polygon's Cubic to be fully matched");
            return null;
        }

        private Companion() {
        }
    }

    public static /* synthetic */ void getMorphMatch$annotations() {
    }

    public final void forEachCubic(float f, MutableCubic mutableCubic, l lVar) {
        mutableCubic.getClass();
        lVar.getClass();
        int size = getMorphMatch().size();
        for (int i = 0; i < size; i++) {
            mutableCubic.interpolate((Cubic) getMorphMatch().get(i).f8441a, (Cubic) getMorphMatch().get(i).f8442b, f);
            lVar.invoke(mutableCubic);
        }
    }

    public final float[] calculateBounds(float[] fArr) {
        fArr.getClass();
        return calculateBounds$default(this, fArr, false, 2, null);
    }

    public final float[] calculateBounds() {
        return calculateBounds$default(this, null, false, 3, null);
    }
}
