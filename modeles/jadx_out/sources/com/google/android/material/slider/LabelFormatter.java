package com.google.android.material.slider;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public interface LabelFormatter {
    public static final int LABEL_FLOATING = 0;
    public static final int LABEL_GONE = 2;
    public static final int LABEL_VISIBLE = 3;
    public static final int LABEL_WITHIN_BOUNDS = 1;

    @NonNull
    String getFormattedValue(float f);
}
