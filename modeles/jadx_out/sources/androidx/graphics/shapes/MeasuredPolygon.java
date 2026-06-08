package androidx.graphics.shapes;

import androidx.annotation.FloatRange;
import androidx.collection.FloatList;
import androidx.collection.MutableFloatList;
import androidx.graphics.shapes.Feature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.g;
import p6.i;
import q6.e;
import q6.l;
import q6.m;
import q6.n;
import r6.c;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MeasuredPolygon extends e {
    public static final Companion Companion = new Companion(null);
    private final List<MeasuredCubic> cubics;
    private final List<ProgressableFeature> features;
    private final Measurer measurer;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public final class MeasuredCubic {
        private final Cubic cubic;
        private float endOutlineProgress;
        private final float measuredSize;
        private float startOutlineProgress;
        final /* synthetic */ MeasuredPolygon this$0;

        public MeasuredCubic(MeasuredPolygon measuredPolygon, @FloatRange(from = 0.0d, to = 1.0d) Cubic cubic, @FloatRange(from = 0.0d, to = 1.0d) float f, float f10) {
            cubic.getClass();
            this.this$0 = measuredPolygon;
            this.cubic = cubic;
            if (f10 < f) {
                com.google.gson.internal.a.p("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
                throw null;
            }
            this.measuredSize = measuredPolygon.measurer.measureCubic(cubic);
            this.startOutlineProgress = f;
            this.endOutlineProgress = f10;
        }

        public static /* synthetic */ void updateProgressRange$graphics_shapes_release$default(MeasuredCubic measuredCubic, float f, float f10, int i, Object obj) {
            if ((i & 1) != 0) {
                f = measuredCubic.startOutlineProgress;
            }
            if ((i & 2) != 0) {
                f10 = measuredCubic.endOutlineProgress;
            }
            measuredCubic.updateProgressRange$graphics_shapes_release(f, f10);
        }

        public final i cutAtProgress(float f) {
            String unused;
            float i = f.i(f, this.startOutlineProgress, this.endOutlineProgress);
            float f10 = this.endOutlineProgress;
            float f11 = this.startOutlineProgress;
            float findCubicCutPoint = this.this$0.measurer.findCubicCutPoint(this.cubic, ((i - f11) / (f10 - f11)) * this.measuredSize);
            if (0.0f > findCubicCutPoint || findCubicCutPoint > 1.0f) {
                com.google.gson.internal.a.p("Cubic cut point is expected to be between 0 and 1");
                return null;
            }
            unused = PolygonMeasureKt.LOG_TAG;
            i split = this.cubic.split(findCubicCutPoint);
            return new i(new MeasuredCubic(this.this$0, (Cubic) split.f8441a, this.startOutlineProgress, i), new MeasuredCubic(this.this$0, (Cubic) split.f8442b, i, this.endOutlineProgress));
        }

        public final Cubic getCubic() {
            return this.cubic;
        }

        public final float getEndOutlineProgress() {
            return this.endOutlineProgress;
        }

        public final float getMeasuredSize() {
            return this.measuredSize;
        }

        public final float getStartOutlineProgress() {
            return this.startOutlineProgress;
        }

        public String toString() {
            return "MeasuredCubic(outlineProgress=[" + this.startOutlineProgress + " .. " + this.endOutlineProgress + "], size=" + this.measuredSize + ", cubic=" + this.cubic + ')';
        }

        public final void updateProgressRange$graphics_shapes_release(float f, float f10) {
            if (f10 < f) {
                com.google.gson.internal.a.p("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
            } else {
                this.startOutlineProgress = f;
                this.endOutlineProgress = f10;
            }
        }
    }

    private MeasuredPolygon(Measurer measurer, List<ProgressableFeature> list, List<? extends Cubic> list2, FloatList floatList) {
        if (floatList.getSize() != list2.size() + 1) {
            com.google.gson.internal.a.p("Outline progress size is expected to be the cubics size + 1");
            throw null;
        }
        if (floatList.first() != 0.0f) {
            com.google.gson.internal.a.p("First outline progress value is expected to be zero");
            throw null;
        }
        if (floatList.last() != 1.0f) {
            com.google.gson.internal.a.p("Last outline progress value is expected to be one");
            throw null;
        }
        this.measurer = measurer;
        this.features = list;
        ArrayList arrayList = new ArrayList();
        int size = list2.size();
        int i = 0;
        float f = 0.0f;
        while (i < size) {
            int i6 = i + 1;
            if (floatList.get(i6) - floatList.get(i) > 1.0E-4f) {
                arrayList.add(new MeasuredCubic(this, list2.get(i), f, floatList.get(i6)));
                f = floatList.get(i6);
            }
            i = i6;
        }
        MeasuredCubic.updateProgressRange$graphics_shapes_release$default((MeasuredCubic) arrayList.get(arrayList.size() - 1), 0.0f, 1.0f, 1, null);
        this.cubics = arrayList;
    }

    @Override // q6.a, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return contains((MeasuredCubic) obj);
        }
        return false;
    }

    public final MeasuredPolygon cutAndShift(float f) {
        String unused;
        if (0.0f > f || f > 1.0f) {
            com.google.gson.internal.a.p("Cutting point is expected to be between 0 and 1");
            return null;
        }
        if (f < 1.0E-4f) {
            return this;
        }
        Iterator<MeasuredCubic> it = this.cubics.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            MeasuredCubic next = it.next();
            float startOutlineProgress = next.getStartOutlineProgress();
            if (f <= next.getEndOutlineProgress() && startOutlineProgress <= f) {
                break;
            }
            i++;
        }
        i cutAtProgress = this.cubics.get(i).cutAtProgress(f);
        MeasuredCubic measuredCubic = (MeasuredCubic) cutAtProgress.f8441a;
        MeasuredCubic measuredCubic2 = (MeasuredCubic) cutAtProgress.f8442b;
        unused = PolygonMeasureKt.LOG_TAG;
        ArrayList e02 = m.e0(measuredCubic2.getCubic());
        int size = this.cubics.size();
        for (int i6 = 1; i6 < size; i6++) {
            List<MeasuredCubic> list = this.cubics;
            e02.add(list.get((i6 + i) % list.size()).getCubic());
        }
        e02.add(measuredCubic.getCubic());
        MutableFloatList mutableFloatList = new MutableFloatList(this.cubics.size() + 2);
        int size2 = this.cubics.size() + 2;
        int i10 = 0;
        while (i10 < size2) {
            mutableFloatList.add(i10 == 0 ? 0.0f : i10 == this.cubics.size() + 1 ? 1.0f : Utils.positiveModulo(this.cubics.get(((i + i10) - 1) % this.cubics.size()).getEndOutlineProgress() - f, 1.0f));
            i10++;
        }
        c t9 = a.a.t();
        int size3 = this.features.size();
        for (int i11 = 0; i11 < size3; i11++) {
            t9.add(new ProgressableFeature(Utils.positiveModulo(this.features.get(i11).getProgress() - f, 1.0f), this.features.get(i11).getFeature()));
        }
        return new MeasuredPolygon(this.measurer, a.a.m(t9), e02, mutableFloatList);
    }

    @Override // java.util.List
    public MeasuredCubic get(int i) {
        return this.cubics.get(i);
    }

    public final List<ProgressableFeature> getFeatures() {
        return this.features;
    }

    @Override // q6.a
    public int getSize() {
        return this.cubics.size();
    }

    @Override // q6.e, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return indexOf((MeasuredCubic) obj);
        }
        return -1;
    }

    @Override // q6.e, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof MeasuredCubic) {
            return lastIndexOf((MeasuredCubic) obj);
        }
        return -1;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final MeasuredPolygon measurePolygon$graphics_shapes_release(Measurer measurer, RoundedPolygon roundedPolygon) {
            List list;
            String unused;
            measurer.getClass();
            roundedPolygon.getClass();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = roundedPolygon.getFeatures$graphics_shapes_release().size();
            for (int i = 0; i < size; i++) {
                Feature feature = roundedPolygon.getFeatures$graphics_shapes_release().get(i);
                int size2 = feature.getCubics().size();
                for (int i6 = 0; i6 < size2; i6++) {
                    if ((feature instanceof Feature.Corner) && i6 == feature.getCubics().size() / 2) {
                        arrayList2.add(new i(feature, Integer.valueOf(arrayList.size())));
                    }
                    arrayList.add(feature.getCubics().get(i6));
                }
            }
            Float valueOf = Float.valueOf(0.0f);
            int i02 = n.i0(arrayList, 9);
            if (i02 == 0) {
                list = a.a.H(valueOf);
            } else {
                ArrayList arrayList3 = new ArrayList(i02 + 1);
                arrayList3.add(valueOf);
                int size3 = arrayList.size();
                int i10 = 0;
                while (i10 < size3) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    float floatValue = valueOf.floatValue();
                    float measureCubic = measurer.measureCubic((Cubic) obj);
                    if (measureCubic < 0.0f) {
                        com.google.gson.internal.a.p("Measured cubic is expected to be greater or equal to zero");
                        return null;
                    }
                    valueOf = Float.valueOf(floatValue + measureCubic);
                    arrayList3.add(valueOf);
                }
                list = arrayList3;
            }
            float floatValue2 = ((Number) l.y0(list)).floatValue();
            MutableFloatList mutableFloatList = new MutableFloatList(list.size());
            int size4 = list.size();
            for (int i11 = 0; i11 < size4; i11++) {
                mutableFloatList.add(((Number) list.get(i11)).floatValue() / floatValue2);
            }
            unused = PolygonMeasureKt.LOG_TAG;
            c t9 = a.a.t();
            int size5 = arrayList2.size();
            for (int i12 = 0; i12 < size5; i12++) {
                int intValue = ((Number) ((i) arrayList2.get(i12)).f8442b).intValue();
                t9.add(new ProgressableFeature((mutableFloatList.get(intValue + 1) + mutableFloatList.get(intValue)) / 2, (Feature) ((i) arrayList2.get(i12)).f8441a));
            }
            return new MeasuredPolygon(measurer, a.a.m(t9), arrayList, mutableFloatList, null);
        }

        private Companion() {
        }
    }

    public /* bridge */ boolean contains(MeasuredCubic measuredCubic) {
        return super.contains((Object) measuredCubic);
    }

    public /* bridge */ int indexOf(MeasuredCubic measuredCubic) {
        return super.indexOf((Object) measuredCubic);
    }

    public /* bridge */ int lastIndexOf(MeasuredCubic measuredCubic) {
        return super.lastIndexOf((Object) measuredCubic);
    }

    public /* synthetic */ MeasuredPolygon(Measurer measurer, List list, List list2, FloatList floatList, g gVar) {
        this(measurer, list, list2, floatList);
    }
}
