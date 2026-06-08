package com.google.android.material.transition.platform;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(21)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
class FitModeEvaluators {
    private static final FitModeEvaluator WIDTH = new FitModeEvaluator() { // from class: com.google.android.material.transition.platform.FitModeEvaluators.1
        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public void applyMask(RectF rectF, float f, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.currentEndHeight - fitModeResult.currentStartHeight) * f;
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public FitModeResult evaluate(float f, float f10, float f11, float f12, float f13, float f14, float f15) {
            float lerp = TransitionUtils.lerp(f12, f14, f10, f11, f, true);
            float f16 = lerp / f12;
            float f17 = lerp / f14;
            return new FitModeResult(f16, f17, lerp, f13 * f16, lerp, f15 * f17);
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            return fitModeResult.currentStartHeight > fitModeResult.currentEndHeight;
        }
    };
    private static final FitModeEvaluator HEIGHT = new FitModeEvaluator() { // from class: com.google.android.material.transition.platform.FitModeEvaluators.2
        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public void applyMask(RectF rectF, float f, FitModeResult fitModeResult) {
            float abs = (Math.abs(fitModeResult.currentEndWidth - fitModeResult.currentStartWidth) / 2.0f) * f;
            rectF.left += abs;
            rectF.right -= abs;
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public FitModeResult evaluate(float f, float f10, float f11, float f12, float f13, float f14, float f15) {
            float lerp = TransitionUtils.lerp(f13, f15, f10, f11, f, true);
            float f16 = lerp / f13;
            float f17 = lerp / f15;
            return new FitModeResult(f16, f17, f12 * f16, lerp, f14 * f17, lerp);
        }

        @Override // com.google.android.material.transition.platform.FitModeEvaluator
        public boolean shouldMaskStartBounds(FitModeResult fitModeResult) {
            return fitModeResult.currentStartWidth > fitModeResult.currentEndWidth;
        }
    };

    private FitModeEvaluators() {
    }

    public static FitModeEvaluator get(int i, boolean z9, RectF rectF, RectF rectF2) {
        if (i == 0) {
            return shouldAutoFitToWidth(z9, rectF, rectF2) ? WIDTH : HEIGHT;
        }
        if (i == 1) {
            return WIDTH;
        }
        if (i == 2) {
            return HEIGHT;
        }
        com.google.gson.internal.a.p(l.u(i, "Invalid fit mode: "));
        return null;
    }

    private static boolean shouldAutoFitToWidth(boolean z9, RectF rectF, RectF rectF2) {
        float width = rectF.width();
        float height = rectF.height();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        return z9 ? (height2 * width) / width2 >= height : (width2 * height) / width >= height2;
    }
}
