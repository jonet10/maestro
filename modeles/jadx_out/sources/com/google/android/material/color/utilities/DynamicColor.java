package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class DynamicColor {
    public final Function<DynamicScheme, DynamicColor> background;
    public final ContrastCurve contrastCurve;
    private final HashMap<DynamicScheme, Hct> hctCache;
    public final boolean isBackground;
    public final String name;
    public final Function<DynamicScheme, Double> opacity;
    public final Function<DynamicScheme, TonalPalette> palette;
    public final Function<DynamicScheme, DynamicColor> secondBackground;
    public final Function<DynamicScheme, Double> tone;
    public final Function<DynamicScheme, ToneDeltaPair> toneDeltaPair;

    public DynamicColor(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z9, @Nullable Function<DynamicScheme, DynamicColor> function3, @Nullable Function<DynamicScheme, DynamicColor> function4, @Nullable ContrastCurve contrastCurve, @Nullable Function<DynamicScheme, ToneDeltaPair> function5) {
        this.hctCache = new HashMap<>();
        this.name = str;
        this.palette = function;
        this.tone = function2;
        this.isBackground = z9;
        this.background = function3;
        this.secondBackground = function4;
        this.contrastCurve = contrastCurve;
        this.toneDeltaPair = function5;
        this.opacity = null;
    }

    public static double enableLightForeground(double d10) {
        if (!tonePrefersLightForeground(d10) || toneAllowsLightForeground(d10)) {
            return d10;
        }
        return 49.0d;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0045 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static double foregroundTone(double r10, double r12) {
        /*
            double r0 = com.google.android.material.color.utilities.Contrast.lighterUnsafe(r10, r12)
            double r2 = com.google.android.material.color.utilities.Contrast.darkerUnsafe(r10, r12)
            double r4 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r0, r10)
            double r6 = com.google.android.material.color.utilities.Contrast.ratioOfTones(r2, r10)
            boolean r10 = tonePrefersLightForeground(r10)
            if (r10 == 0) goto L3b
            double r10 = r4 - r6
            double r10 = java.lang.Math.abs(r10)
            r8 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            int r10 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r10 >= 0) goto L2f
            int r10 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r10 >= 0) goto L2f
            int r10 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r10 >= 0) goto L2f
            r10 = 1
            goto L30
        L2f:
            r10 = 0
        L30:
            int r11 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r11 >= 0) goto L44
            int r11 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r11 >= 0) goto L44
            if (r10 == 0) goto L45
            goto L44
        L3b:
            int r10 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r10 >= 0) goto L45
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 < 0) goto L44
            goto L45
        L44:
            return r0
        L45:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.utilities.DynamicColor.foregroundTone(double, double):double");
    }

    @NonNull
    public static DynamicColor fromArgb(@NonNull String str, int i) {
        return fromPalette(str, new a(TonalPalette.fromInt(i), 0), new a(Hct.fromInt(i), 1));
    }

    @NonNull
    public static DynamicColor fromPalette(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2) {
        return new DynamicColor(str, function, function2, false, null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$fromArgb$1(Hct hct, DynamicScheme dynamicScheme) {
        return Double.valueOf(hct.getTone());
    }

    public static boolean toneAllowsLightForeground(double d10) {
        return Math.round(d10) <= 49;
    }

    public static boolean tonePrefersLightForeground(double d10) {
        return Math.round(d10) < 60;
    }

    public int getArgb(@NonNull DynamicScheme dynamicScheme) {
        int i = getHct(dynamicScheme).toInt();
        Function<DynamicScheme, Double> function = this.opacity;
        if (function == null) {
            return i;
        }
        return (MathUtils.clampInt(0, 255, (int) Math.round(function.apply(dynamicScheme).doubleValue() * 255.0d)) << 24) | (i & ViewCompat.MEASURED_SIZE_MASK);
    }

    @NonNull
    public Hct getHct(@NonNull DynamicScheme dynamicScheme) {
        Hct hct = this.hctCache.get(dynamicScheme);
        if (hct != null) {
            return hct;
        }
        Hct hct2 = this.palette.apply(dynamicScheme).getHct(getTone(dynamicScheme));
        if (this.hctCache.size() > 4) {
            this.hctCache.clear();
        }
        this.hctCache.put(dynamicScheme, hct2);
        return hct2;
    }

    public double getTone(@NonNull DynamicScheme dynamicScheme) {
        double d10;
        double d11;
        double min;
        boolean z9 = false;
        boolean z10 = dynamicScheme.contrastLevel < 0.0d;
        Function<DynamicScheme, ToneDeltaPair> function = this.toneDeltaPair;
        if (function == null) {
            boolean z11 = z10;
            double doubleValue = this.tone.apply(dynamicScheme).doubleValue();
            Function<DynamicScheme, DynamicColor> function2 = this.background;
            if (function2 == null) {
                return doubleValue;
            }
            double tone = function2.apply(dynamicScheme).getTone(dynamicScheme);
            double d12 = this.contrastCurve.get(dynamicScheme.contrastLevel);
            if (Contrast.ratioOfTones(tone, doubleValue) < d12) {
                doubleValue = foregroundTone(tone, d12);
            }
            if (z11) {
                doubleValue = foregroundTone(tone, d12);
            }
            if (!this.isBackground || 50.0d > doubleValue || doubleValue >= 60.0d) {
                d10 = doubleValue;
            } else {
                d10 = 49.0d;
                if (Contrast.ratioOfTones(49.0d, tone) < d12) {
                    d10 = 60.0d;
                }
            }
            if (this.secondBackground != null) {
                double tone2 = this.background.apply(dynamicScheme).getTone(dynamicScheme);
                double tone3 = this.secondBackground.apply(dynamicScheme).getTone(dynamicScheme);
                double max = Math.max(tone2, tone3);
                double min2 = Math.min(tone2, tone3);
                if (Contrast.ratioOfTones(max, d10) < d12 || Contrast.ratioOfTones(min2, d10) < d12) {
                    double lighter = Contrast.lighter(max, d12);
                    double darker = Contrast.darker(min2, d12);
                    ArrayList arrayList = new ArrayList();
                    if (lighter != -1.0d) {
                        arrayList.add(Double.valueOf(lighter));
                    }
                    if (darker != -1.0d) {
                        arrayList.add(Double.valueOf(darker));
                    }
                    if (tonePrefersLightForeground(tone2) || tonePrefersLightForeground(tone3)) {
                        if (lighter == -1.0d) {
                            return 100.0d;
                        }
                        return lighter;
                    }
                    if (arrayList.size() == 1) {
                        return ((Double) arrayList.get(0)).doubleValue();
                    }
                    if (darker == -1.0d) {
                        return 0.0d;
                    }
                    return darker;
                }
            }
            return d10;
        }
        ToneDeltaPair apply = function.apply(dynamicScheme);
        DynamicColor roleA = apply.getRoleA();
        DynamicColor roleB = apply.getRoleB();
        double delta = apply.getDelta();
        TonePolarity polarity = apply.getPolarity();
        boolean stayTogether = apply.getStayTogether();
        double tone4 = this.background.apply(dynamicScheme).getTone(dynamicScheme);
        if (polarity == TonePolarity.NEARER || ((polarity == TonePolarity.LIGHTER && !dynamicScheme.isDark) || (polarity == TonePolarity.DARKER && dynamicScheme.isDark))) {
            z9 = true;
        }
        DynamicColor dynamicColor = z9 ? roleA : roleB;
        DynamicColor dynamicColor2 = z9 ? roleB : roleA;
        boolean equals = this.name.equals(dynamicColor.name);
        double d13 = dynamicScheme.isDark ? 1.0d : -1.0d;
        double d14 = dynamicColor.contrastCurve.get(dynamicScheme.contrastLevel);
        double d15 = dynamicColor2.contrastCurve.get(dynamicScheme.contrastLevel);
        double doubleValue2 = dynamicColor.tone.apply(dynamicScheme).doubleValue();
        if (Contrast.ratioOfTones(tone4, doubleValue2) < d14) {
            doubleValue2 = foregroundTone(tone4, d14);
        }
        boolean z12 = z10;
        double doubleValue3 = dynamicColor2.tone.apply(dynamicScheme).doubleValue();
        if (Contrast.ratioOfTones(tone4, doubleValue3) < d15) {
            doubleValue3 = foregroundTone(tone4, d15);
        }
        if (z12) {
            doubleValue2 = foregroundTone(tone4, d14);
            doubleValue3 = foregroundTone(tone4, d15);
        }
        if ((doubleValue3 - doubleValue2) * d13 < delta) {
            double d16 = delta * d13;
            double clampDouble = MathUtils.clampDouble(0.0d, 100.0d, doubleValue2 + d16);
            if ((clampDouble - doubleValue2) * d13 < delta) {
                doubleValue2 = MathUtils.clampDouble(0.0d, 100.0d, clampDouble - d16);
            }
            doubleValue3 = clampDouble;
        }
        if (50.0d > doubleValue2 || doubleValue2 >= 60.0d) {
            if (50.0d > doubleValue3 || doubleValue3 >= 60.0d) {
                d11 = doubleValue3;
            } else if (!stayTogether) {
                d11 = d13 > 0.0d ? 60.0d : 49.0d;
            } else if (d13 > 0.0d) {
                d11 = Math.max(doubleValue3, (delta * d13) + 60.0d);
                doubleValue2 = 60.0d;
            } else {
                min = Math.min(doubleValue3, (delta * d13) + 49.0d);
                d11 = min;
                doubleValue2 = 49.0d;
            }
        } else if (d13 > 0.0d) {
            d11 = Math.max(doubleValue3, (delta * d13) + 60.0d);
            doubleValue2 = 60.0d;
        } else {
            min = Math.min(doubleValue3, (delta * d13) + 49.0d);
            d11 = min;
            doubleValue2 = 49.0d;
        }
        return equals ? doubleValue2 : d11;
    }

    @NonNull
    public static DynamicColor fromPalette(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z9) {
        return new DynamicColor(str, function, function2, z9, null, null, null, null);
    }

    public DynamicColor(@NonNull String str, @NonNull Function<DynamicScheme, TonalPalette> function, @NonNull Function<DynamicScheme, Double> function2, boolean z9, @Nullable Function<DynamicScheme, DynamicColor> function3, @Nullable Function<DynamicScheme, DynamicColor> function4, @Nullable ContrastCurve contrastCurve, @Nullable Function<DynamicScheme, ToneDeltaPair> function5, @Nullable Function<DynamicScheme, Double> function6) {
        this.hctCache = new HashMap<>();
        this.name = str;
        this.palette = function;
        this.tone = function2;
        this.isBackground = z9;
        this.background = function3;
        this.secondBackground = function4;
        this.contrastCurve = contrastCurve;
        this.toneDeltaPair = function5;
        this.opacity = function6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TonalPalette lambda$fromArgb$0(TonalPalette tonalPalette, DynamicScheme dynamicScheme) {
        return tonalPalette;
    }
}
