package com.google.android.material.carousel;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
abstract class CarouselOrientationHelper {
    final int orientation;

    private CarouselOrientationHelper(int i) {
        this.orientation = i;
    }

    private static CarouselOrientationHelper createHorizontalHelper(final CarouselLayoutManager carouselLayoutManager) {
        return new CarouselOrientationHelper(0) { // from class: com.google.android.material.carousel.CarouselOrientationHelper.2
            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void containMaskWithinBounds(RectF rectF, RectF rectF2, RectF rectF3) {
                float f = rectF2.left;
                float f10 = rectF3.left;
                if (f < f10 && rectF2.right > f10) {
                    float f11 = f10 - f;
                    rectF.left += f11;
                    rectF2.left += f11;
                }
                float f12 = rectF2.right;
                float f13 = rectF3.right;
                if (f12 <= f13 || rectF2.left >= f13) {
                    return;
                }
                float f14 = f12 - f13;
                rectF.right = Math.max(rectF.right - f14, rectF.left);
                rectF2.right = Math.max(rectF2.right - f14, rectF2.left);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public int getDecoratedCrossAxisMeasurement(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return carouselLayoutManager.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public float getMaskMargins(RecyclerView.LayoutParams layoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public RectF getMaskRect(float f, float f10, float f11, float f12) {
                return new RectF(f12, 0.0f, f10 - f12, f);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public int getParentBottom() {
                return carouselLayoutManager.getHeight() - carouselLayoutManager.getPaddingBottom();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public int getParentEnd() {
                return carouselLayoutManager.isLayoutRtl() ? getParentLeft() : getParentRight();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public int getParentLeft() {
                return 0;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public int getParentRight() {
                return carouselLayoutManager.getWidth();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public int getParentStart() {
                return carouselLayoutManager.isLayoutRtl() ? getParentRight() : getParentLeft();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public int getParentTop() {
                return carouselLayoutManager.getPaddingTop();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void layoutDecoratedWithMargins(View view, int i, int i6) {
                int parentTop = getParentTop();
                carouselLayoutManager.layoutDecoratedWithMargins(view, i, parentTop, i6, parentTop + getDecoratedCrossAxisMeasurement(view));
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void moveMaskOnEdgeOutsideBounds(RectF rectF, RectF rectF2, RectF rectF3) {
                if (rectF2.right <= rectF3.left) {
                    float floor = ((float) Math.floor(rectF.right)) - 1.0f;
                    rectF.right = floor;
                    rectF.left = Math.min(rectF.left, floor);
                }
                if (rectF2.left >= rectF3.right) {
                    float ceil = ((float) Math.ceil(rectF.left)) + 1.0f;
                    rectF.left = ceil;
                    rectF.right = Math.max(ceil, rectF.right);
                }
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void offsetChild(View view, Rect rect, float f, float f10) {
                view.offsetLeftAndRight((int) (f10 - (rect.left + f)));
            }
        };
    }

    public static CarouselOrientationHelper createOrientationHelper(CarouselLayoutManager carouselLayoutManager, int i) {
        if (i == 0) {
            return createHorizontalHelper(carouselLayoutManager);
        }
        if (i == 1) {
            return createVerticalHelper(carouselLayoutManager);
        }
        com.google.gson.internal.a.p("invalid orientation");
        return null;
    }

    private static CarouselOrientationHelper createVerticalHelper(final CarouselLayoutManager carouselLayoutManager) {
        return new CarouselOrientationHelper(1) { // from class: com.google.android.material.carousel.CarouselOrientationHelper.1
            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void containMaskWithinBounds(RectF rectF, RectF rectF2, RectF rectF3) {
                float f = rectF2.top;
                float f10 = rectF3.top;
                if (f < f10 && rectF2.bottom > f10) {
                    float f11 = f10 - f;
                    rectF.top += f11;
                    rectF3.top += f11;
                }
                float f12 = rectF2.bottom;
                float f13 = rectF3.bottom;
                if (f12 <= f13 || rectF2.top >= f13) {
                    return;
                }
                float f14 = f12 - f13;
                rectF.bottom = Math.max(rectF.bottom - f14, rectF.top);
                rectF2.bottom = Math.max(rectF2.bottom - f14, rectF2.top);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public int getDecoratedCrossAxisMeasurement(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return carouselLayoutManager.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public float getMaskMargins(RecyclerView.LayoutParams layoutParams) {
                return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public RectF getMaskRect(float f, float f10, float f11, float f12) {
                return new RectF(0.0f, f11, f10, f - f11);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public int getParentBottom() {
                return carouselLayoutManager.getHeight();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public int getParentEnd() {
                return getParentBottom();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public int getParentLeft() {
                return carouselLayoutManager.getPaddingLeft();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public int getParentRight() {
                return carouselLayoutManager.getWidth() - carouselLayoutManager.getPaddingRight();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public int getParentStart() {
                return getParentTop();
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public int getParentTop() {
                return 0;
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void layoutDecoratedWithMargins(View view, int i, int i6) {
                int parentLeft = getParentLeft();
                carouselLayoutManager.layoutDecoratedWithMargins(view, parentLeft, i, parentLeft + getDecoratedCrossAxisMeasurement(view), i6);
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void moveMaskOnEdgeOutsideBounds(RectF rectF, RectF rectF2, RectF rectF3) {
                if (rectF2.bottom <= rectF3.top) {
                    float floor = ((float) Math.floor(rectF.bottom)) - 1.0f;
                    rectF.bottom = floor;
                    rectF.top = Math.min(rectF.top, floor);
                }
                if (rectF2.top >= rectF3.bottom) {
                    float ceil = ((float) Math.ceil(rectF.top)) + 1.0f;
                    rectF.top = ceil;
                    rectF.bottom = Math.max(ceil, rectF.bottom);
                }
            }

            @Override // com.google.android.material.carousel.CarouselOrientationHelper
            public void offsetChild(View view, Rect rect, float f, float f10) {
                view.offsetTopAndBottom((int) (f10 - (rect.top + f)));
            }
        };
    }

    public abstract void containMaskWithinBounds(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract int getDecoratedCrossAxisMeasurement(View view);

    public abstract float getMaskMargins(RecyclerView.LayoutParams layoutParams);

    public abstract RectF getMaskRect(float f, float f10, float f11, float f12);

    public abstract int getParentBottom();

    public abstract int getParentEnd();

    public abstract int getParentLeft();

    public abstract int getParentRight();

    public abstract int getParentStart();

    public abstract int getParentTop();

    public abstract void layoutDecoratedWithMargins(View view, int i, int i6);

    public abstract void moveMaskOnEdgeOutsideBounds(RectF rectF, RectF rectF2, RectF rectF3);

    public abstract void offsetChild(View view, Rect rect, float f, float f10);
}
