package com.google.android.material.resources;

import android.content.Context;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class TypefaceUtils {
    private TypefaceUtils() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x0006, code lost:
    
        r0 = r2.fontWeightAdjustment;
     */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface maybeCopyWithFontWeightAdjustment(@androidx.annotation.NonNull android.content.res.Configuration r2, @androidx.annotation.NonNull android.graphics.Typeface r3) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            if (r0 < r1) goto L2c
            int r0 = c2.a.b(r2)
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L2c
            if (r0 == 0) goto L2c
            if (r3 == 0) goto L2c
            int r0 = r3.getWeight()
            int r2 = c2.a.b(r2)
            int r0 = r0 + r2
            r2 = 1
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = androidx.core.math.MathUtils.clamp(r0, r2, r1)
            boolean r0 = r3.isItalic()
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r3, r2, r0)
            return r2
        L2c:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.resources.TypefaceUtils.maybeCopyWithFontWeightAdjustment(android.content.res.Configuration, android.graphics.Typeface):android.graphics.Typeface");
    }

    @Nullable
    public static Typeface maybeCopyWithFontWeightAdjustment(@NonNull Context context, @NonNull Typeface typeface) {
        return maybeCopyWithFontWeightAdjustment(context.getResources().getConfiguration(), typeface);
    }
}
