package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public interface PointProvider {
    double distance(double[] dArr, double[] dArr2);

    double[] fromInt(int i);

    int toInt(double[] dArr);
}
