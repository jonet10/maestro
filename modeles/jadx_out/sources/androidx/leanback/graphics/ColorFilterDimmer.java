package androidx.leanback.graphics;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.view.View;
import androidx.leanback.R;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ColorFilterDimmer {
    private final float mActiveLevel;
    private final ColorFilterCache mColorDimmer;
    private final float mDimmedLevel;
    private ColorFilter mFilter;
    private final Paint mPaint;

    private ColorFilterDimmer(ColorFilterCache colorFilterCache, float f, float f10) {
        this.mColorDimmer = colorFilterCache;
        f = f > 1.0f ? 1.0f : f;
        f = f < 0.0f ? 0.0f : f;
        f10 = f10 > 1.0f ? 1.0f : f10;
        float f11 = f10 >= 0.0f ? f10 : 0.0f;
        this.mActiveLevel = f;
        this.mDimmedLevel = f11;
        this.mPaint = new Paint();
    }

    public static ColorFilterDimmer create(ColorFilterCache colorFilterCache, float f, float f10) {
        return new ColorFilterDimmer(colorFilterCache, f, f10);
    }

    public static ColorFilterDimmer createDefault(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.LeanbackTheme);
        int color = obtainStyledAttributes.getColor(R.styleable.LeanbackTheme_overlayDimMaskColor, context.getResources().getColor(R.color.lb_view_dim_mask_color));
        float fraction = obtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimActiveLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_active_level, 1, 0));
        float fraction2 = obtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimDimmedLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_dimmed_level, 1, 1));
        obtainStyledAttributes.recycle();
        return new ColorFilterDimmer(ColorFilterCache.getColorFilterCache(color), fraction, fraction2);
    }

    public void applyFilterToView(View view) {
        if (this.mFilter != null) {
            view.setLayerType(2, this.mPaint);
        } else {
            view.setLayerType(0, null);
        }
        view.invalidate();
    }

    public ColorFilter getColorFilter() {
        return this.mFilter;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public void setActiveLevel(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        ColorFilterCache colorFilterCache = this.mColorDimmer;
        float f10 = this.mDimmedLevel;
        ColorFilter filterForLevel = colorFilterCache.getFilterForLevel(((this.mActiveLevel - f10) * f) + f10);
        this.mFilter = filterForLevel;
        this.mPaint.setColorFilter(filterForLevel);
    }
}
