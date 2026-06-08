package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f, boolean z9) {
        this.size = f;
        this.inside = z9;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f10, float f11, @NonNull ShapePath shapePath) {
        boolean z9 = this.inside;
        float f12 = this.size;
        if (!z9) {
            shapePath.lineTo(f10 - (f12 * f11), 0.0f, f10, (-f12) * f11);
            shapePath.lineTo((this.size * f11) + f10, 0.0f, f, 0.0f);
        } else {
            shapePath.lineTo(f10 - (f12 * f11), 0.0f);
            float f13 = this.size;
            shapePath.lineTo(f10, f13 * f11, (f13 * f11) + f10, 0.0f);
            shapePath.lineTo(f, 0.0f);
        }
    }
}
