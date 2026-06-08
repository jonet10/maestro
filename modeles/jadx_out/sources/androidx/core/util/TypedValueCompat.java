package androidx.core.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.l;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class TypedValueCompat {
    private static final float INCHES_PER_MM = 0.03937008f;
    private static final float INCHES_PER_PT = 0.013888889f;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresApi(34)
    public static class Api34Impl {
        private Api34Impl() {
        }

        @DoNotInline
        public static float deriveDimension(int i, float f, DisplayMetrics displayMetrics) {
            return TypedValue.deriveDimension(i, f, displayMetrics);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ComplexDimensionUnit {
    }

    private TypedValueCompat() {
    }

    public static float deriveDimension(int i, float f, @NonNull DisplayMetrics displayMetrics) {
        float f10;
        float f11;
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.deriveDimension(i, f, displayMetrics);
        }
        if (i == 0) {
            return f;
        }
        if (i == 1) {
            float f12 = displayMetrics.density;
            if (f12 == 0.0f) {
                return 0.0f;
            }
            return f / f12;
        }
        if (i == 2) {
            float f13 = displayMetrics.scaledDensity;
            if (f13 == 0.0f) {
                return 0.0f;
            }
            return f / f13;
        }
        if (i == 3) {
            float f14 = displayMetrics.xdpi;
            if (f14 == 0.0f) {
                return 0.0f;
            }
            f10 = f / f14;
            f11 = INCHES_PER_PT;
        } else {
            if (i == 4) {
                float f15 = displayMetrics.xdpi;
                if (f15 == 0.0f) {
                    return 0.0f;
                }
                return f / f15;
            }
            if (i != 5) {
                com.google.gson.internal.a.p(l.u(i, "Invalid unitToConvertTo "));
                return 0.0f;
            }
            float f16 = displayMetrics.xdpi;
            if (f16 == 0.0f) {
                return 0.0f;
            }
            f10 = f / f16;
            f11 = INCHES_PER_MM;
        }
        return f10 / f11;
    }

    public static float dpToPx(float f, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(1, f, displayMetrics);
    }

    @SuppressLint({"WrongConstant"})
    public static int getUnitFromComplexDimension(int i) {
        return i & 15;
    }

    public static float pxToDp(float f, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(1, f, displayMetrics);
    }

    public static float pxToSp(float f, @NonNull DisplayMetrics displayMetrics) {
        return deriveDimension(2, f, displayMetrics);
    }

    public static float spToPx(float f, @NonNull DisplayMetrics displayMetrics) {
        return TypedValue.applyDimension(2, f, displayMetrics);
    }
}
