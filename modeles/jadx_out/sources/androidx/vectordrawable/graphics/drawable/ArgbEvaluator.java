package androidx.vectordrawable.graphics.drawable;

import a4.x;
import android.animation.TypeEvaluator;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ArgbEvaluator implements TypeEvaluator {
    private static final ArgbEvaluator sInstance = new ArgbEvaluator();

    public static ArgbEvaluator getInstance() {
        return sInstance;
    }

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        float f10 = ((intValue >> 24) & 255) / 255.0f;
        int intValue2 = ((Integer) obj2).intValue();
        float f11 = ((intValue2 >> 24) & 255) / 255.0f;
        float pow = (float) Math.pow(((intValue >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((intValue >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((intValue & 255) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((intValue2 >> 16) & 255) / 255.0f, 2.2d);
        float pow5 = (float) Math.pow(((intValue2 >> 8) & 255) / 255.0f, 2.2d);
        float pow6 = (float) Math.pow((intValue2 & 255) / 255.0f, 2.2d);
        float f12 = x.f(f11, f10, f, f10);
        float f13 = x.f(pow4, pow, f, pow);
        float f14 = x.f(pow5, pow2, f, pow2);
        float f15 = x.f(pow6, pow3, f, pow3);
        float pow7 = ((float) Math.pow(f13, 0.45454545454545453d)) * 255.0f;
        float pow8 = ((float) Math.pow(f14, 0.45454545454545453d)) * 255.0f;
        return Integer.valueOf(Math.round(((float) Math.pow(f15, 0.45454545454545453d)) * 255.0f) | (Math.round(pow7) << 16) | (Math.round(f12 * 255.0f) << 24) | (Math.round(pow8) << 8));
    }
}
