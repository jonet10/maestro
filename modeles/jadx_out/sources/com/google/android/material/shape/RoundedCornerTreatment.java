package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class RoundedCornerTreatment extends CornerTreatment {
    float radius;

    public RoundedCornerTreatment() {
        this.radius = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath shapePath, float f, float f10, float f11) {
        float f12 = f11 * f10;
        shapePath.reset(0.0f, f12, 180.0f, 180.0f - f);
        float f13 = f12 * 2.0f;
        shapePath.addArc(0.0f, 0.0f, f13, f13, 180.0f, f);
    }

    @Deprecated
    public RoundedCornerTreatment(float f) {
        this.radius = f;
    }
}
