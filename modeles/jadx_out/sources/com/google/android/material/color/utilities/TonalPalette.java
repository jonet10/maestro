package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class TonalPalette {
    Map<Integer, Integer> cache = new HashMap();
    double chroma;
    double hue;
    Hct keyColor;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class KeyColor {
        private static final double MAX_CHROMA_VALUE = 200.0d;
        private final Map<Integer, Double> chromaCache = new HashMap();
        private final double hue;
        private final double requestedChroma;

        public KeyColor(double d10, double d11) {
            this.hue = d10;
            this.requestedChroma = d11;
        }

        private double maxChroma(int i) {
            if (this.chromaCache.get(Integer.valueOf(i)) == null) {
                this.chromaCache.put(Integer.valueOf(i), Double.valueOf(Hct.from(this.hue, MAX_CHROMA_VALUE, i).getChroma()));
            }
            return this.chromaCache.get(Integer.valueOf(i)).doubleValue();
        }

        public Hct create() {
            int i = 100;
            int i6 = 0;
            while (i6 < i) {
                int i10 = (i6 + i) / 2;
                int i11 = i10 + 1;
                boolean z9 = maxChroma(i10) < maxChroma(i11);
                if (maxChroma(i10) >= this.requestedChroma - 0.01d) {
                    if (Math.abs(i6 - 50) < Math.abs(i - 50)) {
                        i = i10;
                    } else {
                        if (i6 == i10) {
                            return Hct.from(this.hue, this.requestedChroma, i6);
                        }
                        i6 = i10;
                    }
                } else if (z9) {
                    i6 = i11;
                } else {
                    i = i10;
                }
            }
            return Hct.from(this.hue, this.requestedChroma, i6);
        }
    }

    private TonalPalette(double d10, double d11, Hct hct) {
        this.hue = d10;
        this.chroma = d11;
        this.keyColor = hct;
    }

    public static TonalPalette fromHct(Hct hct) {
        return new TonalPalette(hct.getHue(), hct.getChroma(), hct);
    }

    public static TonalPalette fromHueAndChroma(double d10, double d11) {
        return new TonalPalette(d10, d11, new KeyColor(d10, d11).create());
    }

    public static TonalPalette fromInt(int i) {
        return fromHct(Hct.fromInt(i));
    }

    public double getChroma() {
        return this.chroma;
    }

    public Hct getHct(double d10) {
        return Hct.from(this.hue, this.chroma, d10);
    }

    public double getHue() {
        return this.hue;
    }

    public Hct getKeyColor() {
        return this.keyColor;
    }

    public int tone(int i) {
        Integer num = this.cache.get(Integer.valueOf(i));
        if (num == null) {
            num = Integer.valueOf(Hct.from(this.hue, this.chroma, i).toInt());
            this.cache.put(Integer.valueOf(i), num);
        }
        return num.intValue();
    }
}
