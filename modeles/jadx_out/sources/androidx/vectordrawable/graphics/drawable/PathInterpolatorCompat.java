package androidx.vectordrawable.graphics.drawable;

import a4.x;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import com.google.gson.internal.a;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class PathInterpolatorCompat implements Interpolator {
    public static final double EPSILON = 1.0E-5d;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;
    private float[] mX;
    private float[] mY;

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        parseInterpolatorFromTypeArray(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
    }

    private void initCubic(float f, float f10, float f11, float f12) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f10, f11, f12, 1.0f, 1.0f);
        initPath(path);
    }

    private void initPath(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        this.mX = new float[min];
        this.mY = new float[min];
        float[] fArr = new float[2];
        for (int i6 = 0; i6 < min; i6++) {
            pathMeasure.getPosTan((i6 * length) / (min - 1), fArr, null);
            this.mX[i6] = fArr[0];
            this.mY[i6] = fArr[1];
        }
        if (Math.abs(this.mX[0]) <= 1.0E-5d && Math.abs(this.mY[0]) <= 1.0E-5d) {
            int i10 = min - 1;
            if (Math.abs(this.mX[i10] - 1.0f) <= 1.0E-5d && Math.abs(this.mY[i10] - 1.0f) <= 1.0E-5d) {
                float f = 0.0f;
                int i11 = 0;
                while (i < min) {
                    float[] fArr2 = this.mX;
                    int i12 = i11 + 1;
                    float f10 = fArr2[i11];
                    if (f10 < f) {
                        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f10);
                    }
                    fArr2[i] = f10;
                    i++;
                    f = f10;
                    i11 = i12;
                }
                if (pathMeasure.nextContour()) {
                    a.p("The Path should be continuous, can't have 2+ contours");
                    return;
                }
                return;
            }
        }
        int i13 = min - 1;
        throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.mX[0] + "," + this.mY[0] + " end:" + this.mX[i13] + "," + this.mY[i13]);
    }

    private void initQuad(float f, float f10) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f10, 1.0f, 1.0f);
        initPath(path);
    }

    private void parseInterpolatorFromTypeArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
            String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 4);
            Path createPathFromPathData = PathParser.createPathFromPathData(namedString);
            if (createPathFromPathData == null) {
                throw new InflateException(x.j("The path is null, which is created from ", namedString));
            }
            initPath(createPathFromPathData);
            return;
        }
        if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float namedFloat2 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean hasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, "controlX2");
        if (hasAttribute != TypedArrayUtils.hasAttribute(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (hasAttribute) {
            initCubic(namedFloat, namedFloat2, TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX2", 2, 0.0f), TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        } else {
            initQuad(namedFloat, namedFloat2);
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        float[] fArr;
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i = 0;
        while (true) {
            int i6 = length - i;
            fArr = this.mX;
            if (i6 <= 1) {
                break;
            }
            int i10 = (i + length) / 2;
            if (f < fArr[i10]) {
                length = i10;
            } else {
                i = i10;
            }
        }
        float f10 = fArr[length];
        float f11 = fArr[i];
        float f12 = f10 - f11;
        float[] fArr2 = this.mY;
        if (f12 == 0.0f) {
            return fArr2[i];
        }
        float f13 = fArr2[i];
        return x.f(fArr2[length], f13, (f - f11) / f12, f13);
    }

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }
}
