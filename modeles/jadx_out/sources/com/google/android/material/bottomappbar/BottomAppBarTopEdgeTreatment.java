package com.google.android.material.bottomappbar;

import a4.x;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private static final float ROUNDED_CORNER_FAB_OFFSET = 1.75f;
    private float cradleVerticalOffset;
    private float fabCornerSize = -1.0f;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f, float f10, float f11) {
        this.fabMargin = f;
        this.roundedCornerRadius = f10;
        setCradleVerticalOffset(f11);
        this.horizontalOffset = 0.0f;
    }

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f10, float f11, @NonNull ShapePath shapePath) {
        float f12;
        float f13;
        float f14 = this.fabDiameter;
        if (f14 == 0.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f15 = ((this.fabMargin * 2.0f) + f14) / 2.0f;
        float f16 = f11 * this.roundedCornerRadius;
        float f17 = f10 + this.horizontalOffset;
        float f18 = x.f(1.0f, f11, f15, this.cradleVerticalOffset * f11);
        if (f18 / f15 >= 1.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f19 = this.fabCornerSize;
        float f20 = f19 * f11;
        boolean z9 = f19 == -1.0f || Math.abs((f19 * 2.0f) - f14) < 0.1f;
        if (z9) {
            f12 = f18;
            f13 = 0.0f;
        } else {
            f13 = ROUNDED_CORNER_FAB_OFFSET;
            f12 = 0.0f;
        }
        float f21 = f15 + f16;
        float f22 = f12 + f16;
        float sqrt = (float) Math.sqrt((f21 * f21) - (f22 * f22));
        float f23 = f17 - sqrt;
        float f24 = f17 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f22));
        float f25 = (90.0f - degrees) + f13;
        shapePath.lineTo(f23, 0.0f);
        float f26 = f23 - f16;
        float f27 = f23 + f16;
        float f28 = f16 * 2.0f;
        shapePath.addArc(f26, 0.0f, f27, f28, 270.0f, degrees);
        if (z9) {
            shapePath.addArc(f17 - f15, (-f15) - f12, f17 + f15, f15 - f12, 180.0f - f25, (f25 * 2.0f) - 180.0f);
        } else {
            float f29 = this.fabMargin;
            float f30 = f20 * 2.0f;
            float f31 = f29 + f30;
            float f32 = f17 - f15;
            shapePath.addArc(f32, -(f20 + f29), f31 + f32, f29 + f20, 180.0f - f25, ((f25 * 2.0f) - 180.0f) / 2.0f);
            float f33 = f17 + f15;
            float f34 = this.fabMargin;
            shapePath.lineTo(f33 - ((f34 / 2.0f) + f20), f34 + f20);
            float f35 = this.fabMargin;
            shapePath.addArc(f33 - (f30 + f35), -(f20 + f35), f33, f35 + f20, 90.0f, f25 - 90.0f);
        }
        shapePath.addArc(f24 - f16, 0.0f, f24 + f16, f28, 270.0f - degrees, degrees);
        shapePath.lineTo(f, 0.0f);
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setCradleVerticalOffset(@FloatRange(from = 0.0d) float f) {
        if (f >= 0.0f) {
            this.cradleVerticalOffset = f;
        } else {
            com.google.gson.internal.a.p("cradleVerticalOffset must be positive.");
        }
    }

    public void setFabCornerSize(float f) {
        this.fabCornerSize = f;
    }

    public void setFabCradleMargin(float f) {
        this.fabMargin = f;
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        this.roundedCornerRadius = f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f) {
        this.fabDiameter = f;
    }

    public void setHorizontalOffset(float f) {
        this.horizontalOffset = f;
    }
}
