package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class DislikeAnalyzer {
    private DislikeAnalyzer() {
        throw new UnsupportedOperationException();
    }

    public static Hct fixIfDisliked(Hct hct) {
        return isDisliked(hct) ? Hct.from(hct.getHue(), hct.getChroma(), 70.0d) : hct;
    }

    public static boolean isDisliked(Hct hct) {
        return ((((double) Math.round(hct.getHue())) > 90.0d ? 1 : (((double) Math.round(hct.getHue())) == 90.0d ? 0 : -1)) >= 0 && (((double) Math.round(hct.getHue())) > 111.0d ? 1 : (((double) Math.round(hct.getHue())) == 111.0d ? 0 : -1)) <= 0) && ((((double) Math.round(hct.getChroma())) > 16.0d ? 1 : (((double) Math.round(hct.getChroma())) == 16.0d ? 0 : -1)) > 0) && ((((double) Math.round(hct.getTone())) > 65.0d ? 1 : (((double) Math.round(hct.getTone())) == 65.0d ? 0 : -1)) < 0);
    }
}
