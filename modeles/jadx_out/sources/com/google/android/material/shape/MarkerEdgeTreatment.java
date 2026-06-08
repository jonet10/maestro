package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class MarkerEdgeTreatment extends EdgeTreatment {
    private final float radius;

    public MarkerEdgeTreatment(float f) {
        this.radius = f - 0.001f;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public boolean forceIntersection() {
        return true;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f10, float f11, @NonNull ShapePath shapePath) {
        float sqrt = (float) ((Math.sqrt(2.0d) * this.radius) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow(this.radius, 2.0d) - Math.pow(sqrt, 2.0d));
        shapePath.reset(f10 - sqrt, ((float) (-((Math.sqrt(2.0d) * this.radius) - this.radius))) + sqrt2);
        shapePath.lineTo(f10, (float) (-((Math.sqrt(2.0d) * this.radius) - this.radius)));
        shapePath.lineTo(f10 + sqrt, ((float) (-((Math.sqrt(2.0d) * this.radius) - this.radius))) + sqrt2);
    }
}
