package androidx.core.view;

import android.view.MotionEvent;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private final float[] mMovements = new float[20];
    private final long[] mEventTimes = new long[20];
    private float mLastComputedVelocity = 0.0f;
    private int mDataPointsBufferSize = 0;
    private int mDataPointsBufferLastUsedIndex = 0;

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private float getCurrentVelocity() {
        long[] jArr;
        long j;
        int i;
        int i6 = this.mDataPointsBufferSize;
        if (i6 < 2) {
            return 0.0f;
        }
        int i10 = this.mDataPointsBufferLastUsedIndex;
        int i11 = ((i10 + 20) - (i6 - 1)) % 20;
        long j6 = this.mEventTimes[i10];
        while (true) {
            jArr = this.mEventTimes;
            j = jArr[i11];
            long j10 = j6 - j;
            i = this.mDataPointsBufferSize;
            if (j10 <= RANGE_MS) {
                break;
            }
            this.mDataPointsBufferSize = i - 1;
            i11 = (i11 + 1) % 20;
        }
        if (i < 2) {
            return 0.0f;
        }
        if (i == 2) {
            int i12 = (i11 + 1) % 20;
            if (j == jArr[i12]) {
                return 0.0f;
            }
            return this.mMovements[i12] / (r2 - j);
        }
        float f = 0.0f;
        int i13 = 0;
        for (int i14 = 0; i14 < this.mDataPointsBufferSize - 1; i14++) {
            int i15 = i14 + i11;
            long[] jArr2 = this.mEventTimes;
            long j11 = jArr2[i15 % 20];
            int i16 = (i15 + 1) % 20;
            if (jArr2[i16] != j11) {
                i13++;
                float kineticEnergyToVelocity = kineticEnergyToVelocity(f);
                float f10 = this.mMovements[i16] / (this.mEventTimes[i16] - j11);
                float abs = (Math.abs(f10) * (f10 - kineticEnergyToVelocity)) + f;
                if (i13 == 1) {
                    abs *= 0.5f;
                }
                f = abs;
            }
        }
        return kineticEnergyToVelocity(f);
    }

    private static float kineticEnergyToVelocity(float f) {
        return (f < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f) * 2.0f));
    }

    public void addMovement(@NonNull MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.mDataPointsBufferSize != 0 && eventTime - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > ASSUME_POINTER_STOPPED_MS) {
            clear();
        }
        int i = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        this.mDataPointsBufferLastUsedIndex = i;
        int i6 = this.mDataPointsBufferSize;
        if (i6 != 20) {
            this.mDataPointsBufferSize = i6 + 1;
        }
        this.mMovements[i] = motionEvent.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = eventTime;
    }

    public void computeCurrentVelocity(int i, float f) {
        float currentVelocity = getCurrentVelocity() * i;
        this.mLastComputedVelocity = currentVelocity;
        if (currentVelocity < (-Math.abs(f))) {
            this.mLastComputedVelocity = -Math.abs(f);
        } else if (this.mLastComputedVelocity > Math.abs(f)) {
            this.mLastComputedVelocity = Math.abs(f);
        }
    }

    public float getAxisVelocity(int i) {
        if (i != 26) {
            return 0.0f;
        }
        return this.mLastComputedVelocity;
    }

    public void computeCurrentVelocity(int i) {
        computeCurrentVelocity(i, Float.MAX_VALUE);
    }
}
