package com.google.android.material.slider;

import androidx.annotation.NonNull;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class BasicLabelFormatter implements LabelFormatter {
    private static final int BILLION = 1000000000;
    private static final int MILLION = 1000000;
    private static final int THOUSAND = 1000;
    private static final long TRILLION = 1000000000000L;

    @Override // com.google.android.material.slider.LabelFormatter
    @NonNull
    public String getFormattedValue(float f) {
        return f >= 1.0E12f ? String.format(Locale.US, "%.1fT", Float.valueOf(f / 1.0E12f)) : f >= 1.0E9f ? String.format(Locale.US, "%.1fB", Float.valueOf(f / 1.0E9f)) : f >= 1000000.0f ? String.format(Locale.US, "%.1fM", Float.valueOf(f / 1000000.0f)) : f >= 1000.0f ? String.format(Locale.US, "%.1fK", Float.valueOf(f / 1000.0f)) : String.format(Locale.US, "%.0f", Float.valueOf(f));
    }
}
