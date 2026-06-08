package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private int keylineCount = 0;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {1, 0};

    public boolean ensureArrangementFitsItemCount(Arrangement arrangement, int i) {
        int itemCount = arrangement.getItemCount() - i;
        boolean z9 = itemCount > 0 && (arrangement.smallCount > 0 || arrangement.mediumCount > 1);
        while (itemCount > 0) {
            int i6 = arrangement.smallCount;
            if (i6 > 0) {
                arrangement.smallCount = i6 - 1;
            } else {
                int i10 = arrangement.mediumCount;
                if (i10 > 1) {
                    arrangement.mediumCount = i10 - 1;
                }
            }
            itemCount--;
        }
        return z9;
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        boolean z9;
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredHeight = view.getMeasuredHeight();
        if (carousel.isHorizontal()) {
            f = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredHeight = view.getMeasuredWidth();
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f;
        float max = Math.max(getSmallItemSizeMax() + f, smallItemSizeMin);
        float f10 = containerHeight;
        float min = Math.min(measuredHeight + f, f10);
        float clamp = MathUtils.clamp((measuredHeight / 3.0f) + f, smallItemSizeMin + f, max + f);
        float f11 = (min + clamp) / 2.0f;
        int[] iArr = SMALL_COUNTS;
        float f12 = 2.0f * smallItemSizeMin;
        if (f10 <= f12) {
            iArr = new int[]{0};
        }
        int[] iArr2 = MEDIUM_COUNTS;
        if (carousel.getCarouselAlignment() == 1) {
            iArr = CarouselStrategy.doubleCounts(iArr);
            iArr2 = CarouselStrategy.doubleCounts(iArr2);
        }
        int[] iArr3 = iArr2;
        int[] iArr4 = iArr;
        float f13 = f;
        int max2 = (int) Math.max(1.0d, Math.floor(((f10 - (CarouselStrategyHelper.maxValue(iArr3) * f11)) - (CarouselStrategyHelper.maxValue(iArr4) * max)) / min));
        int ceil = (int) Math.ceil(f10 / min);
        int i = (ceil - max2) + 1;
        int[] iArr5 = new int[i];
        for (int i6 = 0; i6 < i; i6++) {
            iArr5[i6] = ceil - i6;
        }
        Arrangement findLowestCostArrangement = Arrangement.findLowestCostArrangement(f10, clamp, smallItemSizeMin, max, iArr4, f11, iArr3, min, iArr5);
        this.keylineCount = findLowestCostArrangement.getItemCount();
        boolean ensureArrangementFitsItemCount = ensureArrangementFitsItemCount(findLowestCostArrangement, carousel.getItemCount());
        int i10 = findLowestCostArrangement.mediumCount;
        if (i10 == 0 && findLowestCostArrangement.smallCount == 0 && f10 > f12) {
            findLowestCostArrangement.smallCount = 1;
            z9 = true;
        } else {
            z9 = ensureArrangementFitsItemCount;
        }
        if (z9) {
            findLowestCostArrangement = Arrangement.findLowestCostArrangement(f10, clamp, smallItemSizeMin, max, new int[]{findLowestCostArrangement.smallCount}, f11, new int[]{i10}, min, new int[]{findLowestCostArrangement.largeCount});
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f13, containerHeight, findLowestCostArrangement, carousel.getCarouselAlignment());
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(@NonNull Carousel carousel, int i) {
        if (i >= this.keylineCount || carousel.getItemCount() < this.keylineCount) {
            return i >= this.keylineCount && carousel.getItemCount() < this.keylineCount;
        }
        return true;
    }
}
