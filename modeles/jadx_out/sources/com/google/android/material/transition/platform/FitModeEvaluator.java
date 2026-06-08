package com.google.android.material.transition.platform;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(21)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
interface FitModeEvaluator {
    void applyMask(RectF rectF, float f, FitModeResult fitModeResult);

    FitModeResult evaluate(float f, float f10, float f11, float f12, float f13, float f14, float f15);

    boolean shouldMaskStartBounds(FitModeResult fitModeResult);
}
