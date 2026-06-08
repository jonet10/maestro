package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import j$.util.Comparator$CC;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class TemperatureCache {
    private final Hct input;
    private Hct precomputedComplement;
    private List<Hct> precomputedHctsByHue;
    private List<Hct> precomputedHctsByTemp;
    private Map<Hct, Double> precomputedTempsByHct;

    private TemperatureCache() {
        throw new UnsupportedOperationException();
    }

    private Hct getColdest() {
        return getHctsByTemp().get(0);
    }

    private List<Hct> getHctsByHue() {
        List<Hct> list = this.precomputedHctsByHue;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (double d10 = 0.0d; d10 <= 360.0d; d10 += 1.0d) {
            arrayList.add(Hct.from(d10, this.input.getChroma(), this.input.getTone()));
        }
        List<Hct> unmodifiableList = DesugarCollections.unmodifiableList(arrayList);
        this.precomputedHctsByHue = unmodifiableList;
        return unmodifiableList;
    }

    private List<Hct> getHctsByTemp() {
        List<Hct> list = this.precomputedHctsByTemp;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(getHctsByHue());
        arrayList.add(this.input);
        Collections.sort(arrayList, Comparator$CC.comparing(new a(this, 2), new androidx.constraintlayout.core.utils.a(1)));
        this.precomputedHctsByTemp = arrayList;
        return arrayList;
    }

    private Map<Hct, Double> getTempsByHct() {
        Map<Hct, Double> map = this.precomputedTempsByHct;
        if (map != null) {
            return map;
        }
        ArrayList arrayList = new ArrayList(getHctsByHue());
        arrayList.add(this.input);
        HashMap hashMap = new HashMap();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Hct hct = (Hct) obj;
            hashMap.put(hct, Double.valueOf(rawTemperature(hct)));
        }
        this.precomputedTempsByHct = hashMap;
        return hashMap;
    }

    private Hct getWarmest() {
        return getHctsByTemp().get(getHctsByTemp().size() - 1);
    }

    private static boolean isBetween(double d10, double d11, double d12) {
        return d11 < d12 ? d11 <= d10 && d10 <= d12 : d11 <= d10 || d10 <= d12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Double lambda$getHctsByTemp$0(Hct hct) {
        return getTempsByHct().get(hct);
    }

    public static double rawTemperature(Hct hct) {
        double[] labFromArgb = ColorUtils.labFromArgb(hct.toInt());
        double sanitizeDegreesDouble = MathUtils.sanitizeDegreesDouble(Math.toDegrees(Math.atan2(labFromArgb[2], labFromArgb[1])));
        return (Math.cos(Math.toRadians(MathUtils.sanitizeDegreesDouble(sanitizeDegreesDouble - 50.0d))) * (Math.pow(Math.hypot(labFromArgb[1], labFromArgb[2]), 1.07d) * 0.02d)) - 0.5d;
    }

    public List<Hct> getAnalogousColors(int i, int i6) {
        int round = (int) Math.round(this.input.getHue());
        Hct hct = getHctsByHue().get(round);
        double relativeTemperature = getRelativeTemperature(hct);
        ArrayList arrayList = new ArrayList();
        arrayList.add(hct);
        double d10 = 0.0d;
        double d11 = 0.0d;
        int i10 = 0;
        while (i10 < 360) {
            double relativeTemperature2 = getRelativeTemperature(getHctsByHue().get(MathUtils.sanitizeDegreesInt(round + i10)));
            d11 += Math.abs(relativeTemperature2 - relativeTemperature);
            i10++;
            relativeTemperature = relativeTemperature2;
        }
        double d12 = d11 / i6;
        double relativeTemperature3 = getRelativeTemperature(hct);
        int i11 = 1;
        while (true) {
            if (arrayList.size() >= i6) {
                break;
            }
            Hct hct2 = getHctsByHue().get(MathUtils.sanitizeDegreesInt(round + i11));
            double relativeTemperature4 = getRelativeTemperature(hct2);
            d10 += Math.abs(relativeTemperature4 - relativeTemperature3);
            boolean z9 = d10 >= ((double) arrayList.size()) * d12;
            int i12 = 1;
            while (z9 && arrayList.size() < i6) {
                arrayList.add(hct2);
                int i13 = i11;
                z9 = d10 >= ((double) (arrayList.size() + i12)) * d12;
                i12++;
                i11 = i13;
            }
            i11++;
            if (i11 > 360) {
                while (arrayList.size() < i6) {
                    arrayList.add(hct2);
                }
            } else {
                relativeTemperature3 = relativeTemperature4;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.input);
        int floor = (int) Math.floor((i - 1.0d) / 2.0d);
        for (int i14 = 1; i14 < floor + 1; i14++) {
            int i15 = 0 - i14;
            while (i15 < 0) {
                i15 += arrayList.size();
            }
            if (i15 >= arrayList.size()) {
                i15 %= arrayList.size();
            }
            arrayList2.add(0, (Hct) arrayList.get(i15));
        }
        int i16 = i - floor;
        for (int i17 = 1; i17 < i16; i17++) {
            int i18 = i17;
            while (i18 < 0) {
                i18 += arrayList.size();
            }
            if (i18 >= arrayList.size()) {
                i18 %= arrayList.size();
            }
            arrayList2.add((Hct) arrayList.get(i18));
        }
        return arrayList2;
    }

    public Hct getComplement() {
        double d10;
        Hct hct = this.precomputedComplement;
        if (hct != null) {
            return hct;
        }
        double hue = getColdest().getHue();
        double doubleValue = getTempsByHct().get(getColdest()).doubleValue();
        double hue2 = getWarmest().getHue();
        double doubleValue2 = getTempsByHct().get(getWarmest()).doubleValue() - doubleValue;
        boolean isBetween = isBetween(this.input.getHue(), hue, hue2);
        double d11 = isBetween ? hue2 : hue;
        double d12 = isBetween ? hue : hue2;
        Hct hct2 = getHctsByHue().get((int) Math.round(this.input.getHue()));
        double d13 = 1.0d;
        double relativeTemperature = 1.0d - getRelativeTemperature(this.input);
        double d14 = 1000.0d;
        double d15 = 0.0d;
        while (d15 <= 360.0d) {
            double sanitizeDegreesDouble = MathUtils.sanitizeDegreesDouble((d13 * d15) + d11);
            if (isBetween(sanitizeDegreesDouble, d11, d12)) {
                d10 = d13;
                Hct hct3 = getHctsByHue().get((int) Math.round(sanitizeDegreesDouble));
                double abs = Math.abs(relativeTemperature - ((getTempsByHct().get(hct3).doubleValue() - doubleValue) / doubleValue2));
                if (abs < d14) {
                    hct2 = hct3;
                    d14 = abs;
                }
            } else {
                d10 = d13;
            }
            d15 += d10;
            d13 = d10;
        }
        this.precomputedComplement = hct2;
        return hct2;
    }

    public double getRelativeTemperature(Hct hct) {
        double doubleValue = getTempsByHct().get(getWarmest()).doubleValue() - getTempsByHct().get(getColdest()).doubleValue();
        double doubleValue2 = getTempsByHct().get(hct).doubleValue() - getTempsByHct().get(getColdest()).doubleValue();
        if (doubleValue == 0.0d) {
            return 0.5d;
        }
        return doubleValue2 / doubleValue;
    }

    public TemperatureCache(Hct hct) {
        this.input = hct;
    }

    public List<Hct> getAnalogousColors() {
        return getAnalogousColors(5, 12);
    }
}
