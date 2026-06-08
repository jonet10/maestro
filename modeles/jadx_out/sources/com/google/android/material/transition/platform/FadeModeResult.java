package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(21)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
class FadeModeResult {
    final int endAlpha;
    final boolean endOnTop;
    final int startAlpha;

    private FadeModeResult(int i, int i6, boolean z9) {
        this.startAlpha = i;
        this.endAlpha = i6;
        this.endOnTop = z9;
    }

    public static FadeModeResult endOnTop(int i, int i6) {
        return new FadeModeResult(i, i6, true);
    }

    public static FadeModeResult startOnTop(int i, int i6) {
        return new FadeModeResult(i, i6, false);
    }
}
