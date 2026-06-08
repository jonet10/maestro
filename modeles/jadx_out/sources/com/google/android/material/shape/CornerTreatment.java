package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class CornerTreatment {
    public void getCornerPath(@NonNull ShapePath shapePath, float f, float f10, @NonNull RectF rectF, @NonNull CornerSize cornerSize) {
        getCornerPath(shapePath, f, f10, cornerSize.getCornerSize(rectF));
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f, float f10, float f11) {
        getCornerPath(f, f10, shapePath);
    }

    @Deprecated
    public void getCornerPath(float f, float f10, @NonNull ShapePath shapePath) {
    }
}
