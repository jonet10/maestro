package androidx.leanback.graphics;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.SparseArray;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ColorFilterCache {
    private static final SparseArray<ColorFilterCache> sColorToFiltersMap = new SparseArray<>();
    private final PorterDuffColorFilter[] mFilters = new PorterDuffColorFilter[256];

    private ColorFilterCache(int i, int i6, int i10) {
        for (int i11 = 0; i11 <= 255; i11++) {
            this.mFilters[i11] = new PorterDuffColorFilter(Color.argb(i11, i, i6, i10), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public static ColorFilterCache getColorFilterCache(int i) {
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        int rgb = Color.rgb(red, green, blue);
        SparseArray<ColorFilterCache> sparseArray = sColorToFiltersMap;
        ColorFilterCache colorFilterCache = sparseArray.get(rgb);
        if (colorFilterCache != null) {
            return colorFilterCache;
        }
        ColorFilterCache colorFilterCache2 = new ColorFilterCache(red, green, blue);
        sparseArray.put(rgb, colorFilterCache2);
        return colorFilterCache2;
    }

    public ColorFilter getFilterForLevel(float f) {
        if (f < 0.0f || f > 1.0d) {
            return null;
        }
        return this.mFilters[(int) (f * 255.0f)];
    }
}
