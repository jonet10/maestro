package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Deprecated
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class Scheme {
    private int background;
    private int error;
    private int errorContainer;
    private int inverseOnSurface;
    private int inversePrimary;
    private int inverseSurface;
    private int onBackground;
    private int onError;
    private int onErrorContainer;
    private int onPrimary;
    private int onPrimaryContainer;
    private int onSecondary;
    private int onSecondaryContainer;
    private int onSurface;
    private int onSurfaceVariant;
    private int onTertiary;
    private int onTertiaryContainer;
    private int outline;
    private int outlineVariant;
    private int primary;
    private int primaryContainer;
    private int scrim;
    private int secondary;
    private int secondaryContainer;
    private int shadow;
    private int surface;
    private int surfaceVariant;
    private int tertiary;
    private int tertiaryContainer;

    public Scheme(int i, int i6, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36) {
        this.primary = i;
        this.onPrimary = i6;
        this.primaryContainer = i10;
        this.onPrimaryContainer = i11;
        this.secondary = i12;
        this.onSecondary = i13;
        this.secondaryContainer = i14;
        this.onSecondaryContainer = i15;
        this.tertiary = i16;
        this.onTertiary = i17;
        this.tertiaryContainer = i18;
        this.onTertiaryContainer = i19;
        this.error = i20;
        this.onError = i21;
        this.errorContainer = i22;
        this.onErrorContainer = i23;
        this.background = i24;
        this.onBackground = i25;
        this.surface = i26;
        this.onSurface = i27;
        this.surfaceVariant = i28;
        this.onSurfaceVariant = i29;
        this.outline = i30;
        this.outlineVariant = i31;
        this.shadow = i32;
        this.scrim = i33;
        this.inverseSurface = i34;
        this.inverseOnSurface = i35;
        this.inversePrimary = i36;
    }

    public static Scheme dark(int i) {
        return darkFromCorePalette(CorePalette.of(i));
    }

    public static Scheme darkContent(int i) {
        return darkFromCorePalette(CorePalette.contentOf(i));
    }

    private static Scheme darkFromCorePalette(CorePalette corePalette) {
        return new Scheme().withPrimary(corePalette.f2969a1.tone(80)).withOnPrimary(corePalette.f2969a1.tone(20)).withPrimaryContainer(corePalette.f2969a1.tone(30)).withOnPrimaryContainer(corePalette.f2969a1.tone(90)).withSecondary(corePalette.f2970a2.tone(80)).withOnSecondary(corePalette.f2970a2.tone(20)).withSecondaryContainer(corePalette.f2970a2.tone(30)).withOnSecondaryContainer(corePalette.f2970a2.tone(90)).withTertiary(corePalette.f2971a3.tone(80)).withOnTertiary(corePalette.f2971a3.tone(20)).withTertiaryContainer(corePalette.f2971a3.tone(30)).withOnTertiaryContainer(corePalette.f2971a3.tone(90)).withError(corePalette.error.tone(80)).withOnError(corePalette.error.tone(20)).withErrorContainer(corePalette.error.tone(30)).withOnErrorContainer(corePalette.error.tone(80)).withBackground(corePalette.f2972n1.tone(10)).withOnBackground(corePalette.f2972n1.tone(90)).withSurface(corePalette.f2972n1.tone(10)).withOnSurface(corePalette.f2972n1.tone(90)).withSurfaceVariant(corePalette.f2973n2.tone(30)).withOnSurfaceVariant(corePalette.f2973n2.tone(80)).withOutline(corePalette.f2973n2.tone(60)).withOutlineVariant(corePalette.f2973n2.tone(30)).withShadow(corePalette.f2972n1.tone(0)).withScrim(corePalette.f2972n1.tone(0)).withInverseSurface(corePalette.f2972n1.tone(90)).withInverseOnSurface(corePalette.f2972n1.tone(20)).withInversePrimary(corePalette.f2969a1.tone(40));
    }

    public static Scheme light(int i) {
        return lightFromCorePalette(CorePalette.of(i));
    }

    public static Scheme lightContent(int i) {
        return lightFromCorePalette(CorePalette.contentOf(i));
    }

    private static Scheme lightFromCorePalette(CorePalette corePalette) {
        return new Scheme().withPrimary(corePalette.f2969a1.tone(40)).withOnPrimary(corePalette.f2969a1.tone(100)).withPrimaryContainer(corePalette.f2969a1.tone(90)).withOnPrimaryContainer(corePalette.f2969a1.tone(10)).withSecondary(corePalette.f2970a2.tone(40)).withOnSecondary(corePalette.f2970a2.tone(100)).withSecondaryContainer(corePalette.f2970a2.tone(90)).withOnSecondaryContainer(corePalette.f2970a2.tone(10)).withTertiary(corePalette.f2971a3.tone(40)).withOnTertiary(corePalette.f2971a3.tone(100)).withTertiaryContainer(corePalette.f2971a3.tone(90)).withOnTertiaryContainer(corePalette.f2971a3.tone(10)).withError(corePalette.error.tone(40)).withOnError(corePalette.error.tone(100)).withErrorContainer(corePalette.error.tone(90)).withOnErrorContainer(corePalette.error.tone(10)).withBackground(corePalette.f2972n1.tone(99)).withOnBackground(corePalette.f2972n1.tone(10)).withSurface(corePalette.f2972n1.tone(99)).withOnSurface(corePalette.f2972n1.tone(10)).withSurfaceVariant(corePalette.f2973n2.tone(90)).withOnSurfaceVariant(corePalette.f2973n2.tone(30)).withOutline(corePalette.f2973n2.tone(50)).withOutlineVariant(corePalette.f2973n2.tone(80)).withShadow(corePalette.f2972n1.tone(0)).withScrim(corePalette.f2972n1.tone(0)).withInverseSurface(corePalette.f2972n1.tone(20)).withInverseOnSurface(corePalette.f2972n1.tone(95)).withInversePrimary(corePalette.f2969a1.tone(80));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scheme)) {
            return false;
        }
        Scheme scheme = (Scheme) obj;
        return this.primary == scheme.primary && this.onPrimary == scheme.onPrimary && this.primaryContainer == scheme.primaryContainer && this.onPrimaryContainer == scheme.onPrimaryContainer && this.secondary == scheme.secondary && this.onSecondary == scheme.onSecondary && this.secondaryContainer == scheme.secondaryContainer && this.onSecondaryContainer == scheme.onSecondaryContainer && this.tertiary == scheme.tertiary && this.onTertiary == scheme.onTertiary && this.tertiaryContainer == scheme.tertiaryContainer && this.onTertiaryContainer == scheme.onTertiaryContainer && this.error == scheme.error && this.onError == scheme.onError && this.errorContainer == scheme.errorContainer && this.onErrorContainer == scheme.onErrorContainer && this.background == scheme.background && this.onBackground == scheme.onBackground && this.surface == scheme.surface && this.onSurface == scheme.onSurface && this.surfaceVariant == scheme.surfaceVariant && this.onSurfaceVariant == scheme.onSurfaceVariant && this.outline == scheme.outline && this.outlineVariant == scheme.outlineVariant && this.shadow == scheme.shadow && this.scrim == scheme.scrim && this.inverseSurface == scheme.inverseSurface && this.inverseOnSurface == scheme.inverseOnSurface && this.inversePrimary == scheme.inversePrimary;
    }

    public int getBackground() {
        return this.background;
    }

    public int getError() {
        return this.error;
    }

    public int getErrorContainer() {
        return this.errorContainer;
    }

    public int getInverseOnSurface() {
        return this.inverseOnSurface;
    }

    public int getInversePrimary() {
        return this.inversePrimary;
    }

    public int getInverseSurface() {
        return this.inverseSurface;
    }

    public int getOnBackground() {
        return this.onBackground;
    }

    public int getOnError() {
        return this.onError;
    }

    public int getOnErrorContainer() {
        return this.onErrorContainer;
    }

    public int getOnPrimary() {
        return this.onPrimary;
    }

    public int getOnPrimaryContainer() {
        return this.onPrimaryContainer;
    }

    public int getOnSecondary() {
        return this.onSecondary;
    }

    public int getOnSecondaryContainer() {
        return this.onSecondaryContainer;
    }

    public int getOnSurface() {
        return this.onSurface;
    }

    public int getOnSurfaceVariant() {
        return this.onSurfaceVariant;
    }

    public int getOnTertiary() {
        return this.onTertiary;
    }

    public int getOnTertiaryContainer() {
        return this.onTertiaryContainer;
    }

    public int getOutline() {
        return this.outline;
    }

    public int getOutlineVariant() {
        return this.outlineVariant;
    }

    public int getPrimary() {
        return this.primary;
    }

    public int getPrimaryContainer() {
        return this.primaryContainer;
    }

    public int getScrim() {
        return this.scrim;
    }

    public int getSecondary() {
        return this.secondary;
    }

    public int getSecondaryContainer() {
        return this.secondaryContainer;
    }

    public int getShadow() {
        return this.shadow;
    }

    public int getSurface() {
        return this.surface;
    }

    public int getSurfaceVariant() {
        return this.surfaceVariant;
    }

    public int getTertiary() {
        return this.tertiary;
    }

    public int getTertiaryContainer() {
        return this.tertiaryContainer;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((System.identityHashCode(this) * 31) + this.primary) * 31) + this.onPrimary) * 31) + this.primaryContainer) * 31) + this.onPrimaryContainer) * 31) + this.secondary) * 31) + this.onSecondary) * 31) + this.secondaryContainer) * 31) + this.onSecondaryContainer) * 31) + this.tertiary) * 31) + this.onTertiary) * 31) + this.tertiaryContainer) * 31) + this.onTertiaryContainer) * 31) + this.error) * 31) + this.onError) * 31) + this.errorContainer) * 31) + this.onErrorContainer) * 31) + this.background) * 31) + this.onBackground) * 31) + this.surface) * 31) + this.onSurface) * 31) + this.surfaceVariant) * 31) + this.onSurfaceVariant) * 31) + this.outline) * 31) + this.outlineVariant) * 31) + this.shadow) * 31) + this.scrim) * 31) + this.inverseSurface) * 31) + this.inverseOnSurface) * 31) + this.inversePrimary;
    }

    public void setBackground(int i) {
        this.background = i;
    }

    public void setError(int i) {
        this.error = i;
    }

    public void setErrorContainer(int i) {
        this.errorContainer = i;
    }

    public void setInverseOnSurface(int i) {
        this.inverseOnSurface = i;
    }

    public void setInversePrimary(int i) {
        this.inversePrimary = i;
    }

    public void setInverseSurface(int i) {
        this.inverseSurface = i;
    }

    public void setOnBackground(int i) {
        this.onBackground = i;
    }

    public void setOnError(int i) {
        this.onError = i;
    }

    public void setOnErrorContainer(int i) {
        this.onErrorContainer = i;
    }

    public void setOnPrimary(int i) {
        this.onPrimary = i;
    }

    public void setOnPrimaryContainer(int i) {
        this.onPrimaryContainer = i;
    }

    public void setOnSecondary(int i) {
        this.onSecondary = i;
    }

    public void setOnSecondaryContainer(int i) {
        this.onSecondaryContainer = i;
    }

    public void setOnSurface(int i) {
        this.onSurface = i;
    }

    public void setOnSurfaceVariant(int i) {
        this.onSurfaceVariant = i;
    }

    public void setOnTertiary(int i) {
        this.onTertiary = i;
    }

    public void setOnTertiaryContainer(int i) {
        this.onTertiaryContainer = i;
    }

    public void setOutline(int i) {
        this.outline = i;
    }

    public void setOutlineVariant(int i) {
        this.outlineVariant = i;
    }

    public void setPrimary(int i) {
        this.primary = i;
    }

    public void setPrimaryContainer(int i) {
        this.primaryContainer = i;
    }

    public void setScrim(int i) {
        this.scrim = i;
    }

    public void setSecondary(int i) {
        this.secondary = i;
    }

    public void setSecondaryContainer(int i) {
        this.secondaryContainer = i;
    }

    public void setShadow(int i) {
        this.shadow = i;
    }

    public void setSurface(int i) {
        this.surface = i;
    }

    public void setSurfaceVariant(int i) {
        this.surfaceVariant = i;
    }

    public void setTertiary(int i) {
        this.tertiary = i;
    }

    public void setTertiaryContainer(int i) {
        this.tertiaryContainer = i;
    }

    public String toString() {
        return "Scheme{primary=" + this.primary + ", onPrimary=" + this.onPrimary + ", primaryContainer=" + this.primaryContainer + ", onPrimaryContainer=" + this.onPrimaryContainer + ", secondary=" + this.secondary + ", onSecondary=" + this.onSecondary + ", secondaryContainer=" + this.secondaryContainer + ", onSecondaryContainer=" + this.onSecondaryContainer + ", tertiary=" + this.tertiary + ", onTertiary=" + this.onTertiary + ", tertiaryContainer=" + this.tertiaryContainer + ", onTertiaryContainer=" + this.onTertiaryContainer + ", error=" + this.error + ", onError=" + this.onError + ", errorContainer=" + this.errorContainer + ", onErrorContainer=" + this.onErrorContainer + ", background=" + this.background + ", onBackground=" + this.onBackground + ", surface=" + this.surface + ", onSurface=" + this.onSurface + ", surfaceVariant=" + this.surfaceVariant + ", onSurfaceVariant=" + this.onSurfaceVariant + ", outline=" + this.outline + ", outlineVariant=" + this.outlineVariant + ", shadow=" + this.shadow + ", scrim=" + this.scrim + ", inverseSurface=" + this.inverseSurface + ", inverseOnSurface=" + this.inverseOnSurface + ", inversePrimary=" + this.inversePrimary + '}';
    }

    public Scheme withBackground(int i) {
        this.background = i;
        return this;
    }

    public Scheme withError(int i) {
        this.error = i;
        return this;
    }

    public Scheme withErrorContainer(int i) {
        this.errorContainer = i;
        return this;
    }

    public Scheme withInverseOnSurface(int i) {
        this.inverseOnSurface = i;
        return this;
    }

    public Scheme withInversePrimary(int i) {
        this.inversePrimary = i;
        return this;
    }

    public Scheme withInverseSurface(int i) {
        this.inverseSurface = i;
        return this;
    }

    public Scheme withOnBackground(int i) {
        this.onBackground = i;
        return this;
    }

    public Scheme withOnError(int i) {
        this.onError = i;
        return this;
    }

    public Scheme withOnErrorContainer(int i) {
        this.onErrorContainer = i;
        return this;
    }

    public Scheme withOnPrimary(int i) {
        this.onPrimary = i;
        return this;
    }

    public Scheme withOnPrimaryContainer(int i) {
        this.onPrimaryContainer = i;
        return this;
    }

    public Scheme withOnSecondary(int i) {
        this.onSecondary = i;
        return this;
    }

    public Scheme withOnSecondaryContainer(int i) {
        this.onSecondaryContainer = i;
        return this;
    }

    public Scheme withOnSurface(int i) {
        this.onSurface = i;
        return this;
    }

    public Scheme withOnSurfaceVariant(int i) {
        this.onSurfaceVariant = i;
        return this;
    }

    public Scheme withOnTertiary(int i) {
        this.onTertiary = i;
        return this;
    }

    public Scheme withOnTertiaryContainer(int i) {
        this.onTertiaryContainer = i;
        return this;
    }

    public Scheme withOutline(int i) {
        this.outline = i;
        return this;
    }

    public Scheme withOutlineVariant(int i) {
        this.outlineVariant = i;
        return this;
    }

    public Scheme withPrimary(int i) {
        this.primary = i;
        return this;
    }

    public Scheme withPrimaryContainer(int i) {
        this.primaryContainer = i;
        return this;
    }

    public Scheme withScrim(int i) {
        this.scrim = i;
        return this;
    }

    public Scheme withSecondary(int i) {
        this.secondary = i;
        return this;
    }

    public Scheme withSecondaryContainer(int i) {
        this.secondaryContainer = i;
        return this;
    }

    public Scheme withShadow(int i) {
        this.shadow = i;
        return this;
    }

    public Scheme withSurface(int i) {
        this.surface = i;
        return this;
    }

    public Scheme withSurfaceVariant(int i) {
        this.surfaceVariant = i;
        return this;
    }

    public Scheme withTertiary(int i) {
        this.tertiary = i;
        return this;
    }

    public Scheme withTertiaryContainer(int i) {
        this.tertiaryContainer = i;
        return this;
    }

    public Scheme() {
    }
}
