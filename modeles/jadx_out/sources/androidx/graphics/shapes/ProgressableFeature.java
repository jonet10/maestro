package androidx.graphics.shapes;

import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ProgressableFeature {
    private final Feature feature;
    private final float progress;

    public ProgressableFeature(float f, Feature feature) {
        feature.getClass();
        this.progress = f;
        this.feature = feature;
    }

    public static /* synthetic */ ProgressableFeature copy$default(ProgressableFeature progressableFeature, float f, Feature feature, int i, Object obj) {
        if ((i & 1) != 0) {
            f = progressableFeature.progress;
        }
        if ((i & 2) != 0) {
            feature = progressableFeature.feature;
        }
        return progressableFeature.copy(f, feature);
    }

    public final float component1() {
        return this.progress;
    }

    public final Feature component2() {
        return this.feature;
    }

    public final ProgressableFeature copy(float f, Feature feature) {
        feature.getClass();
        return new ProgressableFeature(f, feature);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgressableFeature)) {
            return false;
        }
        ProgressableFeature progressableFeature = (ProgressableFeature) obj;
        return Float.compare(this.progress, progressableFeature.progress) == 0 && l.a(this.feature, progressableFeature.feature);
    }

    public final Feature getFeature() {
        return this.feature;
    }

    public final float getProgress() {
        return this.progress;
    }

    public int hashCode() {
        return this.feature.hashCode() + (Float.floatToIntBits(this.progress) * 31);
    }

    public String toString() {
        return "ProgressableFeature(progress=" + this.progress + ", feature=" + this.feature + ')';
    }
}
