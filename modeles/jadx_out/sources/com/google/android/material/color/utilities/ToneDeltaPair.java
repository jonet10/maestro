package com.google.android.material.color.utilities;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ToneDeltaPair {
    private final double delta;
    private final TonePolarity polarity;
    private final DynamicColor roleA;
    private final DynamicColor roleB;
    private final boolean stayTogether;

    public ToneDeltaPair(@NonNull DynamicColor dynamicColor, @NonNull DynamicColor dynamicColor2, double d10, @NonNull TonePolarity tonePolarity, boolean z9) {
        this.roleA = dynamicColor;
        this.roleB = dynamicColor2;
        this.delta = d10;
        this.polarity = tonePolarity;
        this.stayTogether = z9;
    }

    public double getDelta() {
        return this.delta;
    }

    @NonNull
    public TonePolarity getPolarity() {
        return this.polarity;
    }

    @NonNull
    public DynamicColor getRoleA() {
        return this.roleA;
    }

    @NonNull
    public DynamicColor getRoleB() {
        return this.roleB;
    }

    public boolean getStayTogether() {
        return this.stayTogether;
    }
}
