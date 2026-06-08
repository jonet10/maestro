package com.google.android.material.carousel;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.color.utilities.Contrast;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
interface Maskable {
    @NonNull
    RectF getMaskRectF();

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    @Deprecated
    float getMaskXPercentage();

    void setMaskRectF(@NonNull RectF rectF);

    @Deprecated
    void setMaskXPercentage(@FloatRange(from = 0.0d, to = 1.0d) float f);

    void setOnMaskChangedListener(@Nullable OnMaskChangedListener onMaskChangedListener);
}
