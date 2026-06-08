package androidx.transition;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class VelocityTracker1D {
    private static final int ASSUME_POINTER_MOVE_STOPPED_MILLIS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final int HORIZON_MILLIS = 100;
    private float[] mDataSamples = new float[20];
    private int mIndex = 0;
    private long[] mTimeSamples;

    public VelocityTracker1D() {
        long[] jArr = new long[20];
        this.mTimeSamples = jArr;
        Arrays.fill(jArr, Long.MIN_VALUE);
    }

    private float kineticEnergyToVelocity(float f) {
        return (float) (Math.sqrt(Math.abs(f) * 2.0f) * Math.signum(f));
    }

    public void addDataPoint(long j, float f) {
        int i = (this.mIndex + 1) % 20;
        this.mIndex = i;
        this.mTimeSamples[i] = j;
        this.mDataSamples[i] = f;
    }

    public float calculateVelocity() {
        int i = this.mIndex;
        if (i == 0 && this.mTimeSamples[i] == Long.MIN_VALUE) {
            return 0.0f;
        }
        long j = this.mTimeSamples[i];
        int i6 = 0;
        long j6 = j;
        while (true) {
            long j10 = this.mTimeSamples[i];
            if (j10 == Long.MIN_VALUE) {
                break;
            }
            float f = j - j10;
            float abs = Math.abs(j10 - j6);
            if (f > 100.0f || abs > 40.0f) {
                break;
            }
            if (i == 0) {
                i = 20;
            }
            i--;
            i6++;
            if (i6 >= 20) {
                break;
            }
            j6 = j10;
        }
        if (i6 < 2) {
            return 0.0f;
        }
        int i10 = this.mIndex;
        if (i6 == 2) {
            int i11 = i10 == 0 ? 19 : i10 - 1;
            long[] jArr = this.mTimeSamples;
            float f10 = jArr[i10] - jArr[i11];
            if (f10 == 0.0f) {
                return 0.0f;
            }
            float[] fArr = this.mDataSamples;
            return ((fArr[i10] - fArr[i11]) / f10) * 1000.0f;
        }
        int i12 = ((i10 - i6) + 21) % 20;
        int i13 = (i10 + 21) % 20;
        long j11 = this.mTimeSamples[i12];
        float f11 = this.mDataSamples[i12];
        int i14 = i12 + 1;
        float f12 = 0.0f;
        for (int i15 = i14 % 20; i15 != i13; i15 = (i15 + 1) % 20) {
            long j12 = this.mTimeSamples[i15];
            float f13 = j12 - j11;
            if (f13 != 0.0f) {
                float f14 = this.mDataSamples[i15];
                float f15 = (f14 - f11) / f13;
                float abs2 = (Math.abs(f15) * (f15 - kineticEnergyToVelocity(f12))) + f12;
                if (i15 == i14) {
                    abs2 *= 0.5f;
                }
                f12 = abs2;
                f11 = f14;
                j11 = j12;
            }
        }
        return kineticEnergyToVelocity(f12) * 1000.0f;
    }

    public void resetTracking() {
        this.mIndex = 0;
        Arrays.fill(this.mTimeSamples, Long.MIN_VALUE);
        Arrays.fill(this.mDataSamples, 0.0f);
    }
}
