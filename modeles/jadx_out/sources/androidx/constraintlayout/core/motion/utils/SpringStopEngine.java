package androidx.constraintlayout.core.motion.utils;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class SpringStopEngine implements StopEngine {
    private static final double UNSET = Double.MAX_VALUE;
    private float mLastTime;
    private double mLastVelocity;
    private float mMass;
    private float mPos;
    private double mStiffness;
    private float mStopThreshold;
    private double mTargetPos;
    private float mV;
    double mDamping = 0.5d;
    private boolean mInitialized = false;
    private int mBoundaryMode = 0;

    private void compute(double d10) {
        if (d10 <= 0.0d) {
            return;
        }
        double d11 = this.mStiffness;
        double d12 = this.mDamping;
        int sqrt = (int) ((9.0d / ((Math.sqrt(d11 / this.mMass) * d10) * 4.0d)) + 1.0d);
        double d13 = d10 / sqrt;
        int i = 0;
        while (i < sqrt) {
            float f = this.mPos;
            double d14 = this.mTargetPos;
            float f10 = this.mV;
            double d15 = d11;
            double d16 = ((-d11) * (f - d14)) - (f10 * d12);
            float f11 = this.mMass;
            double d17 = d12;
            double d18 = (((d16 / f11) * d13) / 2.0d) + f10;
            double d19 = ((((-((((d13 * d18) / 2.0d) + f) - d14)) * d15) - (d18 * d17)) / f11) * d13;
            double d20 = (d19 / 2.0d) + f10;
            float f12 = f10 + ((float) d19);
            this.mV = f12;
            float f13 = f + ((float) (d20 * d13));
            this.mPos = f13;
            int i6 = this.mBoundaryMode;
            if (i6 > 0) {
                if (f13 < 0.0f && (i6 & 1) == 1) {
                    this.mPos = -f13;
                    this.mV = -f12;
                }
                float f14 = this.mPos;
                if (f14 > 1.0f && (i6 & 2) == 2) {
                    this.mPos = 2.0f - f14;
                    this.mV = -this.mV;
                }
            }
            i++;
            d11 = d15;
            d12 = d17;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f) {
        return null;
    }

    public float getAcceleration() {
        return ((float) (((-this.mStiffness) * (this.mPos - this.mTargetPos)) - (this.mDamping * this.mV))) / this.mMass;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f) {
        compute(f - this.mLastTime);
        this.mLastTime = f;
        if (isStopped()) {
            this.mPos = (float) this.mTargetPos;
        }
        return this.mPos;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f) {
        return this.mV;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double d10 = this.mPos - this.mTargetPos;
        double d11 = this.mStiffness;
        double d12 = this.mV;
        return Math.sqrt((((d11 * d10) * d10) + ((d12 * d12) * ((double) this.mMass))) / d11) <= ((double) this.mStopThreshold);
    }

    public void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "() ";
        System.out.println(str2 + str);
    }

    public void springConfig(float f, float f10, float f11, float f12, float f13, float f14, float f15, int i) {
        this.mTargetPos = f10;
        this.mDamping = f14;
        this.mInitialized = false;
        this.mPos = f;
        this.mLastVelocity = f11;
        this.mStiffness = f13;
        this.mMass = f12;
        this.mStopThreshold = f15;
        this.mBoundaryMode = i;
        this.mLastTime = 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return 0.0f;
    }
}
