package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class Score {
    private static final int BLUE_500 = -12417548;
    private static final double CUTOFF_CHROMA = 5.0d;
    private static final double CUTOFF_EXCITED_PROPORTION = 0.01d;
    private static final int MAX_COLOR_COUNT = 4;
    private static final double TARGET_CHROMA = 48.0d;
    private static final double WEIGHT_CHROMA_ABOVE = 0.3d;
    private static final double WEIGHT_CHROMA_BELOW = 0.1d;
    private static final double WEIGHT_PROPORTION = 0.7d;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class ScoredHCT {
        public final Hct hct;
        public final double score;

        public ScoredHCT(Hct hct, double d10) {
            this.hct = hct;
            this.score = d10;
        }
    }

    private Score() {
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i, int i6, boolean z9) {
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[360];
        double d10 = 0.0d;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Hct fromInt = Hct.fromInt(entry.getKey().intValue());
            arrayList.add(fromInt);
            int floor = (int) Math.floor(fromInt.getHue());
            int intValue = entry.getValue().intValue();
            iArr[floor] = iArr[floor] + intValue;
            d10 += intValue;
        }
        double[] dArr = new double[360];
        int i10 = 0;
        for (int i11 = 0; i11 < 360; i11++) {
            double d11 = iArr[i11] / d10;
            for (int i12 = i11 - 14; i12 < i11 + 16; i12++) {
                int sanitizeDegreesInt = MathUtils.sanitizeDegreesInt(i12);
                dArr[sanitizeDegreesInt] = dArr[sanitizeDegreesInt] + d11;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i13 = 0;
        while (i13 < size) {
            Object obj = arrayList.get(i13);
            i13++;
            Hct hct = (Hct) obj;
            double d12 = dArr[MathUtils.sanitizeDegreesInt((int) Math.round(hct.getHue()))];
            if (!z9 || (hct.getChroma() >= CUTOFF_CHROMA && d12 > CUTOFF_EXCITED_PROPORTION)) {
                arrayList2.add(new ScoredHCT(hct, ((hct.getChroma() - TARGET_CHROMA) * (hct.getChroma() < TARGET_CHROMA ? WEIGHT_CHROMA_BELOW : WEIGHT_CHROMA_ABOVE)) + (d12 * 100.0d * WEIGHT_PROPORTION)));
            }
        }
        Collections.sort(arrayList2, new ScoredComparator());
        ArrayList arrayList3 = new ArrayList();
        for (int i14 = 90; i14 >= 15; i14--) {
            arrayList3.clear();
            int size2 = arrayList2.size();
            int i15 = 0;
            while (i15 < size2) {
                Object obj2 = arrayList2.get(i15);
                i15++;
                Hct hct2 = ((ScoredHCT) obj2).hct;
                int size3 = arrayList3.size();
                int i16 = 0;
                while (true) {
                    if (i16 >= size3) {
                        arrayList3.add(hct2);
                        break;
                    }
                    Object obj3 = arrayList3.get(i16);
                    i16++;
                    if (MathUtils.differenceDegrees(hct2.getHue(), ((Hct) obj3).getHue()) < i14) {
                        break;
                    }
                }
                if (arrayList3.size() >= i) {
                    break;
                }
            }
            if (arrayList3.size() >= i) {
                break;
            }
        }
        ArrayList arrayList4 = new ArrayList();
        if (arrayList3.isEmpty()) {
            arrayList4.add(Integer.valueOf(i6));
            return arrayList4;
        }
        int size4 = arrayList3.size();
        while (i10 < size4) {
            Object obj4 = arrayList3.get(i10);
            i10++;
            arrayList4.add(Integer.valueOf(((Hct) obj4).toInt()));
        }
        return arrayList4;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class ScoredComparator implements Comparator<ScoredHCT> {
        @Override // java.util.Comparator
        public int compare(ScoredHCT scoredHCT, ScoredHCT scoredHCT2) {
            return Double.compare(scoredHCT2.score, scoredHCT.score);
        }
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i) {
        return score(map, i, BLUE_500, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map, int i, int i6) {
        return score(map, i, i6, true);
    }

    public static List<Integer> score(Map<Integer, Integer> map) {
        return score(map, 4, BLUE_500, true);
    }
}
