package com.google.android.material.progressindicator;

import a4.x;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {
    static final float WAVE_SMOOTHNESS = 0.48f;
    final PathMeasure activePathMeasure;
    final Path cachedActivePath;
    final Path displayedActivePath;
    S spec;
    final Matrix transform;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class ActiveIndicator {

        @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
        float amplitudeFraction = 1.0f;

        @ColorInt
        int color;

        @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
        float endFraction;

        @Px
        int gapSize;
        boolean isDeterminate;

        @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
        float phaseFraction;
        float rotationDegree;

        @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
        float startFraction;
    }

    public DrawingDelegate(S s6) {
        Path path = new Path();
        this.cachedActivePath = path;
        this.displayedActivePath = new Path();
        this.activePathMeasure = new PathMeasure(path, false);
        this.spec = s6;
        this.transform = new Matrix();
    }

    public abstract void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = -1.0d, to = 1.0d) float f, boolean z9, boolean z10);

    public abstract void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i, @IntRange(from = 0, to = 255) int i6);

    public abstract void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull ActiveIndicator activeIndicator, @IntRange(from = 0, to = 255) int i);

    public abstract void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f10, @ColorInt int i, @IntRange(from = 0, to = 255) int i6, @Px int i10);

    public abstract int getPreferredHeight();

    public abstract int getPreferredWidth();

    public abstract void invalidateCachedPaths();

    public void validateSpecAndAdjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = 1.0d) float f, boolean z9, boolean z10) {
        this.spec.validateSpec();
        adjustCanvas(canvas, rect, f, z9, z10);
    }

    public float vectorToCanvasRotation(float[] fArr) {
        return (float) Math.toDegrees(Math.atan2(fArr[1], fArr[0]));
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public class PathPoint {
        float[] posVec;
        float[] tanVec;
        final Matrix transform;

        public PathPoint(float[] fArr, float[] fArr2) {
            float[] fArr3 = new float[2];
            this.posVec = fArr3;
            this.tanVec = new float[2];
            System.arraycopy(fArr, 0, fArr3, 0, 2);
            System.arraycopy(fArr2, 0, this.tanVec, 0, 2);
            this.transform = new Matrix();
        }

        public float distance(DrawingDelegate<S>.PathPoint pathPoint) {
            float f = pathPoint.posVec[0];
            float[] fArr = this.posVec;
            return (float) Math.hypot(f - fArr[0], r5[1] - fArr[1]);
        }

        public void moveAcross(float f) {
            float[] fArr = this.tanVec;
            float atan2 = (float) (Math.atan2(fArr[1], fArr[0]) + 1.5707963267948966d);
            double d10 = f;
            double d11 = atan2;
            this.posVec[0] = (float) ((Math.cos(d11) * d10) + r2[0]);
            this.posVec[1] = (float) x.e(d11, d10, r14[1]);
        }

        public void moveAlong(float f) {
            float[] fArr = this.tanVec;
            float atan2 = (float) Math.atan2(fArr[1], fArr[0]);
            double d10 = f;
            double d11 = atan2;
            this.posVec[0] = (float) ((Math.cos(d11) * d10) + r2[0]);
            this.posVec[1] = (float) x.e(d11, d10, r14[1]);
        }

        public void reset() {
            Arrays.fill(this.posVec, 0.0f);
            Arrays.fill(this.tanVec, 0.0f);
            this.tanVec[0] = 1.0f;
            this.transform.reset();
        }

        public void rotate(float f) {
            this.transform.reset();
            this.transform.setRotate(f);
            this.transform.mapPoints(this.posVec);
            this.transform.mapPoints(this.tanVec);
        }

        public void scale(float f, float f10) {
            float[] fArr = this.posVec;
            fArr[0] = fArr[0] * f;
            fArr[1] = fArr[1] * f10;
            float[] fArr2 = this.tanVec;
            fArr2[0] = fArr2[0] * f;
            fArr2[1] = fArr2[1] * f10;
        }

        public void translate(float f, float f10) {
            float[] fArr = this.posVec;
            fArr[0] = fArr[0] + f;
            fArr[1] = fArr[1] + f10;
        }

        public PathPoint(DrawingDelegate drawingDelegate, DrawingDelegate<S>.PathPoint pathPoint) {
            this(pathPoint.posVec, pathPoint.tanVec);
        }

        public PathPoint() {
            this.posVec = new float[2];
            this.tanVec = new float[]{1.0f, 0.0f};
            this.transform = new Matrix();
        }
    }
}
