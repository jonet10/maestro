package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class EdgeTreatment {
    public boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float f, float f10, @NonNull ShapePath shapePath) {
        getEdgePath(f, f / 2.0f, f10, shapePath);
    }

    public void getEdgePath(float f, float f10, float f11, @NonNull ShapePath shapePath) {
        shapePath.lineTo(f, 0.0f);
    }
}
