package androidx.transition;

import a4.x;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ArcMotion extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = (float) Math.tan(Math.toRadians(35.0d));
    private static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    private float mMaximumAngle;
    private float mMaximumTangent;
    private float mMinimumHorizontalAngle;
    private float mMinimumHorizontalTangent;
    private float mMinimumVerticalAngle;
    private float mMinimumVerticalTangent;

    public ArcMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.ARC_MOTION);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, DEFAULT_MAX_ANGLE_DEGREES));
        obtainStyledAttributes.recycle();
    }

    private static float toTangent(float f) {
        if (f >= 0.0f && f <= 90.0f) {
            return (float) Math.tan(Math.toRadians(f / 2.0f));
        }
        com.google.gson.internal.a.p("Arc must be between 0 and 90 degrees");
        return 0.0f;
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    @Override // androidx.transition.PathMotion
    @NonNull
    public Path getPath(float f, float f10, float f11, float f12) {
        float f13;
        float f14;
        float f15;
        Path path = new Path();
        path.moveTo(f, f10);
        float f16 = f11 - f;
        float f17 = f12 - f10;
        float f18 = (f17 * f17) + (f16 * f16);
        float f19 = (f + f11) / 2.0f;
        float f20 = (f10 + f12) / 2.0f;
        float f21 = 0.25f * f18;
        boolean z9 = f10 > f12;
        if (Math.abs(f16) < Math.abs(f17)) {
            float abs = Math.abs(f18 / (f17 * 2.0f));
            if (z9) {
                f14 = abs + f12;
                f13 = f11;
            } else {
                f14 = abs + f10;
                f13 = f;
            }
            f15 = this.mMinimumVerticalTangent;
        } else {
            float f22 = f18 / (f16 * 2.0f);
            if (z9) {
                f14 = f10;
                f13 = f22 + f;
            } else {
                f13 = f11 - f22;
                f14 = f12;
            }
            f15 = this.mMinimumHorizontalTangent;
        }
        float f23 = f21 * f15 * f15;
        float f24 = f19 - f13;
        float f25 = f20 - f14;
        float f26 = (f25 * f25) + (f24 * f24);
        float f27 = this.mMaximumTangent;
        float f28 = f21 * f27 * f27;
        if (f26 >= f23) {
            f23 = f26 > f28 ? f28 : 0.0f;
        }
        if (f23 != 0.0f) {
            float sqrt = (float) Math.sqrt(f23 / f26);
            f13 = x.f(f13, f19, sqrt, f19);
            f14 = x.f(f14, f20, sqrt, f20);
        }
        path.cubicTo((f + f13) / 2.0f, (f10 + f14) / 2.0f, (f13 + f11) / 2.0f, (f14 + f12) / 2.0f, f11, f12);
        return path;
    }

    public void setMaximumAngle(float f) {
        this.mMaximumAngle = f;
        this.mMaximumTangent = toTangent(f);
    }

    public void setMinimumHorizontalAngle(float f) {
        this.mMinimumHorizontalAngle = f;
        this.mMinimumHorizontalTangent = toTangent(f);
    }

    public void setMinimumVerticalAngle(float f) {
        this.mMinimumVerticalAngle = f;
        this.mMinimumVerticalTangent = toTangent(f);
    }

    public ArcMotion() {
        this.mMinimumHorizontalAngle = 0.0f;
        this.mMinimumVerticalAngle = 0.0f;
        this.mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
        this.mMinimumHorizontalTangent = 0.0f;
        this.mMinimumVerticalTangent = 0.0f;
        this.mMaximumTangent = DEFAULT_MAX_TANGENT;
    }
}
