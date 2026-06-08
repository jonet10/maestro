package com.google.android.material.carousel;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class HeroCarouselStrategy extends CarouselStrategy {
    private int keylineCount = 0;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {0, 1};

    @Override // com.google.android.material.carousel.CarouselStrategy
    @NonNull
    public KeylineState onFirstChildMeasuredWithMargins(@NonNull Carousel carousel, @NonNull View view) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        float f = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        float measuredWidth = view.getMeasuredWidth() * 2;
        if (carousel.isHorizontal()) {
            f = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            measuredWidth = view.getMeasuredHeight() * 2;
        }
        float smallItemSizeMin = getSmallItemSizeMin() + f;
        float max = Math.max(getSmallItemSizeMax() + f, smallItemSizeMin);
        float f10 = containerHeight;
        float min = Math.min(measuredWidth + f, f10);
        float clamp = MathUtils.clamp((measuredWidth / 3.0f) + f, smallItemSizeMin + f, max + f);
        float f11 = (min + clamp) / 2.0f;
        int i = 0;
        int[] iArr = f10 < 2.0f * smallItemSizeMin ? new int[]{0} : SMALL_COUNTS;
        int max2 = (int) Math.max(1.0d, Math.floor((f10 - (CarouselStrategyHelper.maxValue(r1) * max)) / min));
        int ceil = (((int) Math.ceil(f10 / min)) - max2) + 1;
        int[] iArr2 = new int[ceil];
        for (int i6 = 0; i6 < ceil; i6++) {
            iArr2[i6] = max2 + i6;
        }
        int i10 = carousel.getCarouselAlignment() == 1 ? 1 : 0;
        Arrangement findLowestCostArrangement = Arrangement.findLowestCostArrangement(f10, clamp, smallItemSizeMin, max, i10 != 0 ? CarouselStrategy.doubleCounts(iArr) : iArr, f11, i10 != 0 ? CarouselStrategy.doubleCounts(MEDIUM_COUNTS) : MEDIUM_COUNTS, min, iArr2);
        this.keylineCount = findLowestCostArrangement.getItemCount();
        if (findLowestCostArrangement.getItemCount() > carousel.getItemCount()) {
            findLowestCostArrangement = Arrangement.findLowestCostArrangement(f10, clamp, smallItemSizeMin, max, iArr, f11, MEDIUM_COUNTS, min, iArr2);
        } else {
            i = i10;
        }
        return CarouselStrategyHelper.createKeylineState(view.getContext(), f, containerHeight, findLowestCostArrangement, i);
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public boolean shouldRefreshKeylineState(@NonNull Carousel carousel, int i) {
        if (carousel.getCarouselAlignment() == 1) {
            return (i < this.keylineCount && carousel.getItemCount() >= this.keylineCount) || (i >= this.keylineCount && carousel.getItemCount() < this.keylineCount);
        }
        return false;
    }
}
