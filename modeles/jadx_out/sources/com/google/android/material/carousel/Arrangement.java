package com.google.android.material.carousel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.math.MathUtils;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class Arrangement {
    private static final float MEDIUM_ITEM_FLEX_PERCENTAGE = 0.1f;
    final float cost;
    final int largeCount;
    float largeSize;
    int mediumCount;
    float mediumSize;
    final int priority;
    int smallCount;
    float smallSize;

    public Arrangement(int i, float f, float f10, float f11, int i6, float f12, int i10, float f13, int i11, float f14) {
        this.priority = i;
        this.smallSize = MathUtils.clamp(f, f10, f11);
        this.smallCount = i6;
        this.mediumSize = f12;
        this.mediumCount = i10;
        this.largeSize = f13;
        this.largeCount = i11;
        fit(f14, f10, f11, f13);
        this.cost = cost(f13);
    }

    private float calculateLargeSize(float f, int i, float f10, int i6, int i10) {
        if (i <= 0) {
            f10 = 0.0f;
        }
        float f11 = i6 / 2.0f;
        return (f - ((i + f11) * f10)) / (i10 + f11);
    }

    private float cost(float f) {
        if (isValid()) {
            return Math.abs(f - this.largeSize) * this.priority;
        }
        return Float.MAX_VALUE;
    }

    @Nullable
    public static Arrangement findLowestCostArrangement(float f, float f10, float f11, float f12, @NonNull int[] iArr, float f13, @NonNull int[] iArr2, float f14, @NonNull int[] iArr3) {
        Arrangement arrangement = null;
        int i = 1;
        for (int i6 : iArr3) {
            int length = iArr2.length;
            int i10 = 0;
            while (i10 < length) {
                int i11 = iArr2[i10];
                int length2 = iArr.length;
                int i12 = 0;
                while (i12 < length2) {
                    int i13 = length;
                    int i14 = i10;
                    int i15 = i;
                    int i16 = length2;
                    int i17 = i12;
                    Arrangement arrangement2 = new Arrangement(i15, f10, f11, f12, iArr[i12], f13, i11, f14, i6, f);
                    if (arrangement == null || arrangement2.cost < arrangement.cost) {
                        if (arrangement2.cost == 0.0f) {
                            return arrangement2;
                        }
                        arrangement = arrangement2;
                    }
                    int i18 = i15 + 1;
                    i12 = i17 + 1;
                    i10 = i14;
                    i = i18;
                    length = i13;
                    length2 = i16;
                }
                i10++;
                i = i;
                length = length;
            }
        }
        return arrangement;
    }

    private void fit(float f, float f10, float f11, float f12) {
        float space = f - getSpace();
        int i = this.smallCount;
        if (i > 0 && space > 0.0f) {
            float f13 = this.smallSize;
            this.smallSize = Math.min(space / i, f11 - f13) + f13;
        } else if (i > 0 && space < 0.0f) {
            float f14 = this.smallSize;
            this.smallSize = Math.max(space / i, f10 - f14) + f14;
        }
        int i6 = this.smallCount;
        float f15 = i6 > 0 ? this.smallSize : 0.0f;
        this.smallSize = f15;
        float calculateLargeSize = calculateLargeSize(f, i6, f15, this.mediumCount, this.largeCount);
        this.largeSize = calculateLargeSize;
        float f16 = (this.smallSize + calculateLargeSize) / 2.0f;
        this.mediumSize = f16;
        int i10 = this.mediumCount;
        if (i10 <= 0 || calculateLargeSize == f12) {
            return;
        }
        float f17 = (f12 - calculateLargeSize) * this.largeCount;
        float min = Math.min(Math.abs(f17), f16 * 0.1f * i10);
        float f18 = this.mediumSize;
        if (f17 > 0.0f) {
            this.mediumSize = f18 - (min / this.mediumCount);
            this.largeSize = (min / this.largeCount) + this.largeSize;
        } else {
            this.mediumSize = (min / this.mediumCount) + f18;
            this.largeSize -= min / this.largeCount;
        }
    }

    private float getSpace() {
        return (this.smallSize * this.smallCount) + (this.mediumSize * this.mediumCount) + (this.largeSize * this.largeCount);
    }

    private boolean isValid() {
        int i = this.largeCount;
        if (i <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) {
            return i <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize;
        }
        float f = this.largeSize;
        float f10 = this.mediumSize;
        return f > f10 && f10 > this.smallSize;
    }

    public int getItemCount() {
        return this.smallCount + this.mediumCount + this.largeCount;
    }

    @NonNull
    public String toString() {
        return "Arrangement [priority=" + this.priority + ", smallCount=" + this.smallCount + ", smallSize=" + this.smallSize + ", mediumCount=" + this.mediumCount + ", mediumSize=" + this.mediumSize + ", largeCount=" + this.largeCount + ", largeSize=" + this.largeSize + ", cost=" + this.cost + "]";
    }
}
