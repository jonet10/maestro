package com.google.android.material.transition.platform;

import a4.x;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(21)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
class FadeModeEvaluators {
    private static final FadeModeEvaluator IN = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.1
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f10, float f11, float f12) {
            return FadeModeResult.endOnTop(255, TransitionUtils.lerp(0, 255, f10, f11, f));
        }
    };
    private static final FadeModeEvaluator OUT = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.2
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f10, float f11, float f12) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f10, f11, f), 255);
        }
    };
    private static final FadeModeEvaluator CROSS = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.3
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f10, float f11, float f12) {
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f10, f11, f), TransitionUtils.lerp(0, 255, f10, f11, f));
        }
    };
    private static final FadeModeEvaluator THROUGH = new FadeModeEvaluator() { // from class: com.google.android.material.transition.platform.FadeModeEvaluators.4
        @Override // com.google.android.material.transition.platform.FadeModeEvaluator
        public FadeModeResult evaluate(float f, float f10, float f11, float f12) {
            float f13 = x.f(f11, f10, f12, f10);
            return FadeModeResult.startOnTop(TransitionUtils.lerp(255, 0, f10, f13, f), TransitionUtils.lerp(0, 255, f13, f11, f));
        }
    };

    private FadeModeEvaluators() {
    }

    public static FadeModeEvaluator get(int i, boolean z9) {
        if (i == 0) {
            return z9 ? IN : OUT;
        }
        if (i == 1) {
            return z9 ? OUT : IN;
        }
        if (i == 2) {
            return CROSS;
        }
        if (i == 3) {
            return THROUGH;
        }
        com.google.gson.internal.a.p(l.u(i, "Invalid fade mode: "));
        return null;
    }
}
