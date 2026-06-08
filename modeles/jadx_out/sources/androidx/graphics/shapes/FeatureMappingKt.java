package androidx.graphics.shapes;

import androidx.graphics.shapes.Feature;
import i7.c;
import i7.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import p6.i;
import q6.l;
import q6.m;
import q6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FeatureMappingKt {
    private static final String LOG_TAG = "FeatureMapping";

    public static final List<ProgressableFeature> doMapping(List<ProgressableFeature> list, List<ProgressableFeature> list2) {
        list.getClass();
        list2.getClass();
        Iterator it = new d(0, list2.size() - 1, 1).iterator();
        c cVar = (c) it;
        if (!cVar.f5700l) {
            com.google.gson.internal.a.l();
            return null;
        }
        x xVar = (x) it;
        int nextInt = xVar.nextInt();
        if (cVar.f5700l) {
            float featureDistSquared = featureDistSquared(list.get(0).getFeature(), list2.get(nextInt).getFeature());
            do {
                int nextInt2 = xVar.nextInt();
                float featureDistSquared2 = featureDistSquared(list.get(0).getFeature(), list2.get(nextInt2).getFeature());
                if (Float.compare(featureDistSquared, featureDistSquared2) > 0) {
                    nextInt = nextInt2;
                    featureDistSquared = featureDistSquared2;
                }
            } while (cVar.f5700l);
        }
        int size = list.size();
        int size2 = list2.size();
        ArrayList e02 = m.e0(list2.get(nextInt));
        int i = nextInt;
        for (int i6 = 1; i6 < size; i6++) {
            int i10 = nextInt - (size - i6);
            if (i10 <= i) {
                i10 += size2;
            }
            Iterator it2 = new d(i + 1, i10, 1).iterator();
            c cVar2 = (c) it2;
            if (!cVar2.f5700l) {
                com.google.gson.internal.a.l();
                return null;
            }
            x xVar2 = (x) it2;
            int nextInt3 = xVar2.nextInt();
            if (cVar2.f5700l) {
                float featureDistSquared3 = featureDistSquared(list.get(i6).getFeature(), list2.get(nextInt3 % size2).getFeature());
                do {
                    int nextInt4 = xVar2.nextInt();
                    float featureDistSquared4 = featureDistSquared(list.get(i6).getFeature(), list2.get(nextInt4 % size2).getFeature());
                    if (Float.compare(featureDistSquared3, featureDistSquared4) > 0) {
                        nextInt3 = nextInt4;
                        featureDistSquared3 = featureDistSquared4;
                    }
                } while (cVar2.f5700l);
            }
            i = nextInt3;
            e02.add(list2.get(i % size2));
        }
        return e02;
    }

    public static final float featureDistSquared(Feature feature, Feature feature2) {
        feature.getClass();
        feature2.getClass();
        if ((feature instanceof Feature.Corner) && (feature2 instanceof Feature.Corner) && ((Feature.Corner) feature).getConvex() != ((Feature.Corner) feature2).getConvex()) {
            return Float.MAX_VALUE;
        }
        float anchor1X = (((Cubic) l.y0(feature.getCubics())).getAnchor1X() + ((Cubic) l.q0(feature.getCubics())).getAnchor0X()) / 2.0f;
        float anchor1Y = (((Cubic) l.y0(feature.getCubics())).getAnchor1Y() + ((Cubic) l.q0(feature.getCubics())).getAnchor0Y()) / 2.0f;
        float anchor1X2 = (((Cubic) l.y0(feature2.getCubics())).getAnchor1X() + ((Cubic) l.q0(feature2.getCubics())).getAnchor0X()) / 2.0f;
        float f = anchor1X - anchor1X2;
        float anchor1Y2 = anchor1Y - ((((Cubic) l.y0(feature2.getCubics())).getAnchor1Y() + ((Cubic) l.q0(feature2.getCubics())).getAnchor0Y()) / 2.0f);
        return (anchor1Y2 * anchor1Y2) + (f * f);
    }

    public static final DoubleMapper featureMapper(List<ProgressableFeature> list, List<ProgressableFeature> list2) {
        list.getClass();
        list2.getClass();
        r6.c t9 = a.a.t();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getFeature() instanceof Feature.Corner) {
                t9.add(list.get(i));
            }
        }
        r6.c m10 = a.a.m(t9);
        r6.c t10 = a.a.t();
        int size2 = list2.size();
        for (int i6 = 0; i6 < size2; i6++) {
            if (list2.get(i6).getFeature() instanceof Feature.Corner) {
                t10.add(list2.get(i6));
            }
        }
        r6.c m11 = a.a.m(t10);
        i iVar = m10.c() > m11.c() ? new i(doMapping(m11, m10), m11) : new i(m10, doMapping(m10, m11));
        List list3 = (List) iVar.f8441a;
        List list4 = (List) iVar.f8442b;
        r6.c t11 = a.a.t();
        int size3 = list3.size();
        for (int i10 = 0; i10 < size3 && i10 != list4.size(); i10++) {
            t11.add(new i(Float.valueOf(((ProgressableFeature) list3.get(i10)).getProgress()), Float.valueOf(((ProgressableFeature) list4.get(i10)).getProgress())));
        }
        i[] iVarArr = (i[]) a.a.m(t11).toArray(new i[0]);
        return new DoubleMapper((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
    }
}
