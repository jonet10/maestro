package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ContrastCurve {
    private final double high;
    private final double low;
    private final double medium;
    private final double normal;

    public ContrastCurve(double d10, double d11, double d12, double d13) {
        this.low = d10;
        this.normal = d11;
        this.medium = d12;
        this.high = d13;
    }

    public double get(double d10) {
        return d10 <= -1.0d ? this.low : d10 < 0.0d ? MathUtils.lerp(this.low, this.normal, (d10 - (-1.0d)) / 1.0d) : d10 < 0.5d ? MathUtils.lerp(this.normal, this.medium, (d10 - 0.0d) / 0.5d) : d10 < 1.0d ? MathUtils.lerp(this.medium, this.high, (d10 - 0.5d) / 0.5d) : this.high;
    }
}
