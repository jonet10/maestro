package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class QuantizerWsmeans {
    private static final int MAX_ITERATIONS = 10;
    private static final double MIN_MOVEMENT_DISTANCE = 3.0d;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Distance implements Comparable<Distance> {
        int index = -1;
        double distance = -1.0d;

        @Override // java.lang.Comparable
        public int compareTo(Distance distance) {
            return Double.valueOf(this.distance).compareTo(Double.valueOf(distance.distance));
        }
    }

    private QuantizerWsmeans() {
    }

    public static Map<Integer, Integer> quantize(int[] iArr, int[] iArr2, int i) {
        boolean z9;
        double[] dArr;
        double[] dArr2;
        Random random = new Random(272008L);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        double[][] dArr3 = new double[iArr.length][];
        int[] iArr3 = new int[iArr.length];
        PointProviderLab pointProviderLab = new PointProviderLab();
        int i6 = 0;
        int i10 = 0;
        while (true) {
            z9 = true;
            if (i6 >= iArr.length) {
                break;
            }
            int i11 = iArr[i6];
            Integer num = (Integer) linkedHashMap.get(Integer.valueOf(i11));
            if (num == null) {
                dArr3[i10] = pointProviderLab.fromInt(i11);
                iArr3[i10] = i11;
                i10++;
                linkedHashMap.put(Integer.valueOf(i11), 1);
            } else {
                linkedHashMap.put(Integer.valueOf(i11), Integer.valueOf(num.intValue() + 1));
            }
            i6++;
        }
        int[] iArr4 = new int[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            iArr4[i12] = ((Integer) linkedHashMap.get(Integer.valueOf(iArr3[i12]))).intValue();
        }
        int min = Math.min(i, i10);
        if (iArr2.length != 0) {
            min = Math.min(min, iArr2.length);
        }
        double[][] dArr4 = new double[min][];
        int i13 = 0;
        for (int i14 = 0; i14 < iArr2.length; i14++) {
            dArr4[i14] = pointProviderLab.fromInt(iArr2[i14]);
            i13++;
        }
        int i15 = min - i13;
        if (i15 > 0) {
            for (int i16 = 0; i16 < i15; i16++) {
            }
        }
        int[] iArr5 = new int[i10];
        for (int i17 = 0; i17 < i10; i17++) {
            iArr5[i17] = random.nextInt(min);
        }
        int[][] iArr6 = new int[min][];
        for (int i18 = 0; i18 < min; i18++) {
            iArr6[i18] = new int[min];
        }
        Distance[][] distanceArr = new Distance[min][];
        for (int i19 = 0; i19 < min; i19++) {
            distanceArr[i19] = new Distance[min];
            for (int i20 = 0; i20 < min; i20++) {
                distanceArr[i19][i20] = new Distance();
            }
        }
        int[] iArr7 = new int[min];
        int i21 = 0;
        while (i21 < 10) {
            int i22 = 0;
            while (i22 < min) {
                int i23 = i22 + 1;
                int i24 = i23;
                while (i24 < min) {
                    int[] iArr8 = iArr4;
                    double distance = pointProviderLab.distance(dArr4[i22], dArr4[i24]);
                    Distance distance2 = distanceArr[i24][i22];
                    distance2.distance = distance;
                    distance2.index = i22;
                    Distance distance3 = distanceArr[i22][i24];
                    distance3.distance = distance;
                    distance3.index = i24;
                    i24++;
                    iArr4 = iArr8;
                    iArr5 = iArr5;
                    z9 = z9;
                }
                int[] iArr9 = iArr4;
                int[] iArr10 = iArr5;
                boolean z10 = z9;
                Arrays.sort(distanceArr[i22]);
                for (int i25 = 0; i25 < min; i25++) {
                    iArr6[i22][i25] = distanceArr[i22][i25].index;
                }
                iArr4 = iArr9;
                iArr5 = iArr10;
                i22 = i23;
                z9 = z10;
            }
            int[] iArr11 = iArr4;
            int[] iArr12 = iArr5;
            boolean z11 = z9;
            int i26 = 0;
            int i27 = 0;
            while (i26 < i10) {
                double[] dArr5 = dArr3[i26];
                int i28 = iArr12[i26];
                double distance4 = pointProviderLab.distance(dArr5, dArr4[i28]);
                int i29 = i26;
                double d10 = distance4;
                int i30 = -1;
                int i31 = 0;
                while (i31 < min) {
                    int i32 = i27;
                    int[][] iArr13 = iArr6;
                    if (distanceArr[i28][i31].distance < 4.0d * distance4) {
                        double distance5 = pointProviderLab.distance(dArr5, dArr4[i31]);
                        if (distance5 < d10) {
                            d10 = distance5;
                            i30 = i31;
                        }
                    }
                    i31++;
                    iArr6 = iArr13;
                    i27 = i32;
                }
                int i33 = i27;
                int[][] iArr14 = iArr6;
                if (i30 == -1 || Math.abs(Math.sqrt(d10) - Math.sqrt(distance4)) <= 3.0d) {
                    i27 = i33;
                } else {
                    i27 = i33 + 1;
                    iArr12[i29] = i30;
                }
                i26 = i29 + 1;
                iArr6 = iArr14;
            }
            int[][] iArr15 = iArr6;
            if (i27 == 0 && i21 != 0) {
                break;
            }
            double[] dArr6 = new double[min];
            double[] dArr7 = new double[min];
            double[] dArr8 = new double[min];
            boolean z12 = false;
            Arrays.fill(iArr7, 0);
            int i34 = 0;
            while (i34 < i10) {
                int i35 = iArr12[i34];
                double[] dArr9 = dArr3[i34];
                boolean z13 = z12;
                int i36 = iArr11[i34];
                iArr7[i35] = iArr7[i35] + i36;
                double d11 = i36;
                dArr6[i35] = (dArr9[z13 ? 1 : 0] * d11) + dArr6[i35];
                dArr7[i35] = (dArr9[z11 ? 1 : 0] * d11) + dArr7[i35];
                dArr8[i35] = (dArr9[2] * d11) + dArr8[i35];
                i34++;
                z12 = false;
            }
            int i37 = 0;
            while (i37 < min) {
                int i38 = iArr7[i37];
                if (i38 == 0) {
                    dArr4[i37] = new double[]{0.0d, 0.0d, 0.0d};
                    dArr = dArr6;
                    dArr2 = dArr7;
                } else {
                    double d12 = dArr6[i37];
                    dArr = dArr6;
                    dArr2 = dArr7;
                    double d13 = i38;
                    double d14 = d12 / d13;
                    double d15 = dArr2[i37] / d13;
                    double d16 = dArr8[i37] / d13;
                    double[] dArr10 = dArr4[i37];
                    dArr10[0] = d14;
                    dArr10[z11 ? 1 : 0] = d15;
                    dArr10[2] = d16;
                }
                i37++;
                dArr6 = dArr;
                dArr7 = dArr2;
            }
            i21++;
            iArr4 = iArr11;
            iArr5 = iArr12;
            z9 = z11 ? 1 : 0;
            iArr6 = iArr15;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (int i39 = 0; i39 < min; i39++) {
            int i40 = iArr7[i39];
            if (i40 != 0) {
                int i41 = pointProviderLab.toInt(dArr4[i39]);
                if (!linkedHashMap2.containsKey(Integer.valueOf(i41))) {
                    linkedHashMap2.put(Integer.valueOf(i41), Integer.valueOf(i40));
                }
            }
        }
        return linkedHashMap2;
    }
}
