package com.google.android.material.carousel;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.material.R;
import com.google.android.material.carousel.KeylineState;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
final class CarouselStrategyHelper {
    private CarouselStrategyHelper() {
    }

    public static float addEnd(float f, float f10, int i) {
        return (Math.max(0, i - 1) * f10) + f;
    }

    public static float addStart(float f, float f10, int i) {
        return i > 0 ? (f10 / 2.0f) + f : f;
    }

    public static KeylineState createCenterAlignedKeylineState(@NonNull Context context, float f, int i, @NonNull Arrangement arrangement) {
        float f10;
        float f11;
        float min = Math.min(getExtraSmallSize(context) + f, arrangement.largeSize);
        float f12 = min / 2.0f;
        float f13 = 0.0f - f12;
        float addStart = addStart(0.0f, arrangement.smallSize, arrangement.smallCount);
        float updateCurPosition = updateCurPosition(0.0f, addEnd(addStart, arrangement.smallSize, (int) Math.floor(arrangement.smallCount / 2.0f)), arrangement.smallSize, arrangement.smallCount);
        float addStart2 = addStart(updateCurPosition, arrangement.mediumSize, arrangement.mediumCount);
        float updateCurPosition2 = updateCurPosition(updateCurPosition, addEnd(addStart2, arrangement.mediumSize, (int) Math.floor(arrangement.mediumCount / 2.0f)), arrangement.mediumSize, arrangement.mediumCount);
        float addStart3 = addStart(updateCurPosition2, arrangement.largeSize, arrangement.largeCount);
        float updateCurPosition3 = updateCurPosition(updateCurPosition2, addEnd(addStart3, arrangement.largeSize, arrangement.largeCount), arrangement.largeSize, arrangement.largeCount);
        float addStart4 = addStart(updateCurPosition3, arrangement.mediumSize, arrangement.mediumCount);
        float addStart5 = addStart(updateCurPosition(updateCurPosition3, addEnd(addStart4, arrangement.mediumSize, (int) Math.ceil(arrangement.mediumCount / 2.0f)), arrangement.mediumSize, arrangement.mediumCount), arrangement.smallSize, arrangement.smallCount);
        float f14 = i + f12;
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(min, arrangement.largeSize, f);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(arrangement.smallSize, arrangement.largeSize, f);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(arrangement.mediumSize, arrangement.largeSize, f);
        KeylineState.Builder addAnchorKeyline = new KeylineState.Builder(arrangement.largeSize, i).addAnchorKeyline(f13, childMaskPercentage, min);
        if (arrangement.smallCount > 0) {
            f10 = 2.0f;
            f11 = childMaskPercentage;
            addAnchorKeyline.addKeylineRange(addStart, childMaskPercentage2, arrangement.smallSize, (int) Math.floor(r7 / 2.0f));
        } else {
            f10 = 2.0f;
            f11 = childMaskPercentage;
        }
        if (arrangement.mediumCount > 0) {
            addAnchorKeyline.addKeylineRange(addStart2, childMaskPercentage3, arrangement.mediumSize, (int) Math.floor(r4 / f10));
        }
        addAnchorKeyline.addKeylineRange(addStart3, 0.0f, arrangement.largeSize, arrangement.largeCount, true);
        if (arrangement.mediumCount > 0) {
            addAnchorKeyline.addKeylineRange(addStart4, childMaskPercentage3, arrangement.mediumSize, (int) Math.ceil(r4 / f10));
        }
        if (arrangement.smallCount > 0) {
            addAnchorKeyline.addKeylineRange(addStart5, childMaskPercentage2, arrangement.smallSize, (int) Math.ceil(r0 / f10));
        }
        addAnchorKeyline.addAnchorKeyline(f14, f11, min);
        return addAnchorKeyline.build();
    }

    public static KeylineState createKeylineState(@NonNull Context context, float f, int i, @NonNull Arrangement arrangement, int i6) {
        return i6 == 1 ? createCenterAlignedKeylineState(context, f, i, arrangement) : createLeftAlignedKeylineState(context, f, i, arrangement);
    }

    public static KeylineState createLeftAlignedKeylineState(@NonNull Context context, float f, int i, @NonNull Arrangement arrangement) {
        float min = Math.min(getExtraSmallSize(context) + f, arrangement.largeSize);
        float f10 = min / 2.0f;
        float f11 = 0.0f - f10;
        float addStart = addStart(0.0f, arrangement.largeSize, arrangement.largeCount);
        float updateCurPosition = updateCurPosition(0.0f, addEnd(addStart, arrangement.largeSize, arrangement.largeCount), arrangement.largeSize, arrangement.largeCount);
        float addStart2 = addStart(updateCurPosition, arrangement.mediumSize, arrangement.mediumCount);
        float addStart3 = addStart(updateCurPosition(updateCurPosition, addStart2, arrangement.mediumSize, arrangement.mediumCount), arrangement.smallSize, arrangement.smallCount);
        float f12 = i + f10;
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(min, arrangement.largeSize, f);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(arrangement.smallSize, arrangement.largeSize, f);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(arrangement.mediumSize, arrangement.largeSize, f);
        KeylineState.Builder addKeylineRange = new KeylineState.Builder(arrangement.largeSize, i).addAnchorKeyline(f11, childMaskPercentage, min).addKeylineRange(addStart, 0.0f, arrangement.largeSize, arrangement.largeCount, true);
        if (arrangement.mediumCount > 0) {
            addKeylineRange.addKeyline(addStart2, childMaskPercentage3, arrangement.mediumSize);
        }
        int i6 = arrangement.smallCount;
        if (i6 > 0) {
            addKeylineRange.addKeylineRange(addStart3, childMaskPercentage2, arrangement.smallSize, i6);
        }
        addKeylineRange.addAnchorKeyline(f12, childMaskPercentage, min);
        return addKeylineRange.build();
    }

    public static float getExtraSmallSize(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_gone_size);
    }

    public static float getSmallSizeMax(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
    }

    public static float getSmallSizeMin(@NonNull Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
    }

    public static int maxValue(int[] iArr) {
        int i = Integer.MIN_VALUE;
        for (int i6 : iArr) {
            if (i6 > i) {
                i = i6;
            }
        }
        return i;
    }

    public static float updateCurPosition(float f, float f10, float f11, int i) {
        return i > 0 ? (f11 / 2.0f) + f10 : f;
    }
}
