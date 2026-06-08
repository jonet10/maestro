package androidx.constraintlayout.core.motion.utils;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class Schlick extends Easing {
    private static final boolean DEBUG = false;
    double mEps;
    double mS;
    double mT;

    public Schlick(String str) {
        this.mStr = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.mS = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i = indexOf2 + 1;
        this.mT = Double.parseDouble(str.substring(i, str.indexOf(44, i)).trim());
    }

    private double dfunc(double d10) {
        double d11 = this.mT;
        double d12 = this.mS;
        if (d10 < d11) {
            return ((d12 * d11) * d11) / ((((d11 - d10) * d12) + d10) * (((d11 - d10) * d12) + d10));
        }
        double d13 = d11 - d10;
        return ((d11 - 1.0d) * ((d11 - 1.0d) * d12)) / (((((d11 - d10) * (-d12)) - d10) + 1.0d) * (((d13 * (-d12)) - d10) + 1.0d));
    }

    private double func(double d10) {
        double d11 = this.mT;
        double d12 = this.mS;
        if (d10 < d11) {
            return (d11 * d10) / (((d11 - d10) * d12) + d10);
        }
        return ((d10 - 1.0d) * (1.0d - d11)) / ((1.0d - d10) - ((d11 - d10) * d12));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double get(double d10) {
        return func(d10);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public double getDiff(double d10) {
        return dfunc(d10);
    }
}
