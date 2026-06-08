package androidx.core.view.animation;

import a4.x;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    public PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = (int) (length / 0.002f);
        int i6 = i + 1;
        this.mX = new float[i6];
        this.mY = new float[i6];
        float[] fArr = new float[2];
        for (int i10 = 0; i10 < i6; i10++) {
            pathMeasure.getPosTan((i10 * length) / i, fArr, null);
            this.mX[i10] = fArr[0];
            this.mY[i10] = fArr[1];
        }
    }

    private static Path createCubic(float f, float f10, float f11, float f12) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f10, f11, f12, 1.0f, 1.0f);
        return path;
    }

    private static Path createQuad(float f, float f10) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f10, 1.0f, 1.0f);
        return path;
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

    public PathInterpolatorApi14(float f, float f10) {
        this(createQuad(f, f10));
    }

    public PathInterpolatorApi14(float f, float f10, float f11, float f12) {
        this(createCubic(f, f10, f11, f12));
    }
}
