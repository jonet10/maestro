package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.Pair;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.progressindicator.DrawingDelegate;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private static final float QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH = 0.5522848f;
    private static final float ROUND_CAP_RAMP_DOWN_THRESHHOLD = 0.01f;
    private float adjustedRadius;
    private float adjustedWavelength;
    private final RectF arcBounds;
    private float cachedAmplitude;
    private float cachedRadius;
    private int cachedWavelength;
    private float displayedAmplitude;
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    private boolean drawingDeterminateIndicator;
    private final Pair<DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint, DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint> endPoints;

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    private float totalTrackLengthFraction;

    public CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.arcBounds = new RectF();
        this.endPoints = new Pair<>(new DrawingDelegate.PathPoint(), new DrawingDelegate.PathPoint());
    }

    private void appendCubicPerHalfCycle(@NonNull Path path, @NonNull DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint, @NonNull DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint2) {
        float f = (this.adjustedWavelength / 2.0f) * 0.48f;
        DrawingDelegate.PathPoint pathPoint3 = new DrawingDelegate.PathPoint(this, pathPoint);
        DrawingDelegate.PathPoint pathPoint4 = new DrawingDelegate.PathPoint(this, pathPoint2);
        pathPoint3.moveAlong(f);
        pathPoint4.moveAlong(-f);
        float[] fArr = pathPoint3.posVec;
        float f10 = fArr[0];
        float f11 = fArr[1];
        float[] fArr2 = pathPoint4.posVec;
        float f12 = fArr2[0];
        float f13 = fArr2[1];
        float[] fArr3 = pathPoint2.posVec;
        path.cubicTo(f10, f11, f12, f13, fArr3[0], fArr3[1]);
    }

    private void calculateDisplayedPath(@NonNull PathMeasure pathMeasure, @NonNull Path path, @NonNull Pair<DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint, DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint> pair, float f, float f10, float f11, float f12) {
        float f13 = this.displayedAmplitude * f11;
        boolean z9 = this.drawingDeterminateIndicator;
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.spec;
        int i = z9 ? circularProgressIndicatorSpec.wavelengthDeterminate : circularProgressIndicatorSpec.wavelengthIndeterminate;
        float f14 = this.adjustedRadius;
        if (f14 != this.cachedRadius || (pathMeasure == this.activePathMeasure && (f13 != this.cachedAmplitude || i != this.cachedWavelength))) {
            this.cachedAmplitude = f13;
            this.cachedWavelength = i;
            this.cachedRadius = f14;
            invalidateCachedPaths();
        }
        path.rewind();
        float f15 = 0.0f;
        float clamp = MathUtils.clamp(f10, 0.0f, 1.0f);
        if (((CircularProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator)) {
            float f16 = f12 / ((float) ((this.adjustedRadius * 6.283185307179586d) / this.adjustedWavelength));
            f += f16;
            f15 = 0.0f - (f16 * 360.0f);
        }
        float f17 = f % 1.0f;
        float length = (pathMeasure.getLength() * f17) / 2.0f;
        float length2 = (pathMeasure.getLength() * (f17 + clamp)) / 2.0f;
        pathMeasure.getSegment(length, length2, path, true);
        DrawingDelegate.PathPoint pathPoint = (DrawingDelegate.PathPoint) pair.first;
        pathPoint.reset();
        pathMeasure.getPosTan(length, pathPoint.posVec, pathPoint.tanVec);
        DrawingDelegate.PathPoint pathPoint2 = (DrawingDelegate.PathPoint) pair.second;
        pathPoint2.reset();
        pathMeasure.getPosTan(length2, pathPoint2.posVec, pathPoint2.tanVec);
        this.transform.reset();
        this.transform.setRotate(f15);
        pathPoint.rotate(f15);
        pathPoint2.rotate(f15);
        path.transform(this.transform);
    }

    private void createWavyPath(@NonNull PathMeasure pathMeasure, @NonNull Path path, float f) {
        path.rewind();
        float length = pathMeasure.getLength();
        boolean z9 = this.drawingDeterminateIndicator;
        CircularProgressIndicatorSpec circularProgressIndicatorSpec = (CircularProgressIndicatorSpec) this.spec;
        int max = Math.max(3, (int) ((length / (z9 ? circularProgressIndicatorSpec.wavelengthDeterminate : circularProgressIndicatorSpec.wavelengthIndeterminate)) / 2.0f)) * 2;
        this.adjustedWavelength = length / max;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < max; i++) {
            DrawingDelegate.PathPoint pathPoint = new DrawingDelegate.PathPoint();
            float f10 = i;
            pathMeasure.getPosTan(this.adjustedWavelength * f10, pathPoint.posVec, pathPoint.tanVec);
            DrawingDelegate.PathPoint pathPoint2 = new DrawingDelegate.PathPoint();
            float f11 = this.adjustedWavelength;
            pathMeasure.getPosTan((f11 / 2.0f) + (f10 * f11), pathPoint2.posVec, pathPoint2.tanVec);
            arrayList.add(pathPoint);
            pathPoint2.moveAcross(f * 2.0f);
            arrayList.add(pathPoint2);
        }
        arrayList.add((DrawingDelegate.PathPoint) arrayList.get(0));
        DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint3 = (DrawingDelegate.PathPoint) arrayList.get(0);
        float[] fArr = pathPoint3.posVec;
        int i6 = 1;
        path.moveTo(fArr[0], fArr[1]);
        while (i6 < arrayList.size()) {
            DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint4 = (DrawingDelegate.PathPoint) arrayList.get(i6);
            appendCubicPerHalfCycle(path, pathPoint3, pathPoint4);
            i6++;
            pathPoint3 = pathPoint4;
        }
    }

    private void drawArc(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f10, @ColorInt int i, @Px int i6, @Px int i10, float f11, float f12, boolean z9) {
        float f13 = f10 >= f ? f10 - f : (f10 + 1.0f) - f;
        float f14 = f % 1.0f;
        if (f14 < 0.0f) {
            f14 += 1.0f;
        }
        if (this.totalTrackLengthFraction < 1.0f) {
            float f15 = f14 + f13;
            if (f15 > 1.0f) {
                drawArc(canvas, paint, f14, 1.0f, i, i6, 0, f11, f12, z9);
                drawArc(canvas, paint, 1.0f, f15, i, 0, i10, f11, f12, z9);
                return;
            }
        }
        float degrees = (float) Math.toDegrees(this.displayedCornerRadius / this.adjustedRadius);
        float f16 = f13 - 0.99f;
        if (f16 >= 0.0f) {
            float f17 = ((f16 * degrees) / 180.0f) / ROUND_CAP_RAMP_DOWN_THRESHHOLD;
            f13 += f17;
            if (!z9) {
                f14 -= f17 / 2.0f;
            }
        }
        float lerp = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, f14);
        float lerp2 = com.google.android.material.math.MathUtils.lerp(0.0f, this.totalTrackLengthFraction, f13);
        float degrees2 = (float) Math.toDegrees(i6 / this.adjustedRadius);
        float degrees3 = ((lerp2 * 360.0f) - degrees2) - ((float) Math.toDegrees(i10 / this.adjustedRadius));
        float f18 = (lerp * 360.0f) + degrees2;
        if (degrees3 <= 0.0f) {
            return;
        }
        boolean z10 = ((CircularProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator) && z9 && f11 > 0.0f;
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(this.displayedTrackThickness);
        float f19 = this.displayedCornerRadius * 2.0f;
        float f20 = degrees * 2.0f;
        if (degrees3 < f20) {
            float f21 = degrees3 / f20;
            float f22 = (degrees * f21) + f18;
            DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint = new DrawingDelegate.PathPoint();
            if (z10) {
                float length = (this.activePathMeasure.getLength() * (f22 / 360.0f)) / 2.0f;
                float f23 = this.displayedAmplitude * f11;
                float f24 = this.adjustedRadius;
                if (f24 != this.cachedRadius || f23 != this.cachedAmplitude) {
                    this.cachedAmplitude = f23;
                    this.cachedRadius = f24;
                    invalidateCachedPaths();
                }
                this.activePathMeasure.getPosTan(length, pathPoint.posVec, pathPoint.tanVec);
            } else {
                pathPoint.rotate(f22 + 90.0f);
                pathPoint.moveAcross(-this.adjustedRadius);
            }
            paint.setStyle(Paint.Style.FILL);
            drawRoundedBlock(canvas, paint, pathPoint, f19, this.displayedTrackThickness, f21);
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(((CircularProgressIndicatorSpec) this.spec).useStrokeCap() ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        float f25 = f18 + degrees;
        float f26 = degrees3 - f20;
        ((DrawingDelegate.PathPoint) this.endPoints.first).reset();
        ((DrawingDelegate.PathPoint) this.endPoints.second).reset();
        if (z10) {
            calculateDisplayedPath(this.activePathMeasure, this.displayedActivePath, this.endPoints, f25 / 360.0f, f26 / 360.0f, f11, f12);
            canvas.drawPath(this.displayedActivePath, paint);
        } else {
            ((DrawingDelegate.PathPoint) this.endPoints.first).rotate(f25 + 90.0f);
            ((DrawingDelegate.PathPoint) this.endPoints.first).moveAcross(-this.adjustedRadius);
            ((DrawingDelegate.PathPoint) this.endPoints.second).rotate(f25 + f26 + 90.0f);
            ((DrawingDelegate.PathPoint) this.endPoints.second).moveAcross(-this.adjustedRadius);
            RectF rectF = this.arcBounds;
            float f27 = this.adjustedRadius;
            rectF.set(-f27, -f27, f27, f27);
            canvas.drawArc(this.arcBounds, f25, f26, false, paint);
        }
        if (((CircularProgressIndicatorSpec) this.spec).useStrokeCap() || this.displayedCornerRadius <= 0.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        drawRoundedBlock(canvas, paint, (DrawingDelegate.PathPoint) this.endPoints.first, f19, this.displayedTrackThickness);
        drawRoundedBlock(canvas, paint, (DrawingDelegate.PathPoint) this.endPoints.second, f19, this.displayedTrackThickness);
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint, float f, float f10, float f11) {
        float min = Math.min(f10, this.displayedTrackThickness);
        float f12 = f / 2.0f;
        float min2 = Math.min(f12, (this.displayedCornerRadius * min) / this.displayedTrackThickness);
        RectF rectF = new RectF((-f) / 2.0f, (-min) / 2.0f, f12, min / 2.0f);
        canvas.save();
        float[] fArr = pathPoint.posVec;
        canvas.translate(fArr[0], fArr[1]);
        canvas.rotate(vectorToCanvasRotation(pathPoint.tanVec));
        canvas.scale(f11, f11);
        canvas.drawRoundRect(rectF, min2, min2, paint);
        canvas.restore();
    }

    private int getSize() {
        S s6 = this.spec;
        return (((CircularProgressIndicatorSpec) s6).indicatorInset * 2) + ((CircularProgressIndicatorSpec) s6).indicatorSize;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = 1.0d) float f, boolean z9, boolean z10) {
        float width = rect.width() / getPreferredWidth();
        float height = rect.height() / getPreferredHeight();
        S s6 = this.spec;
        float f10 = (((CircularProgressIndicatorSpec) s6).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) s6).indicatorInset;
        canvas.translate((f10 * width) + rect.left, (f10 * height) + rect.top);
        canvas.rotate(-90.0f);
        canvas.scale(width, height);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorDirection != 0) {
            canvas.scale(1.0f, -1.0f);
            if (Build.VERSION.SDK_INT == 29) {
                canvas.rotate(0.1f);
            }
        }
        float f11 = -f10;
        canvas.clipRect(f11, f11, f10, f10);
        S s9 = this.spec;
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) s9).trackThickness * f;
        this.displayedCornerRadius = Math.min(((CircularProgressIndicatorSpec) s9).trackThickness / 2, ((CircularProgressIndicatorSpec) s9).getTrackCornerRadiusInPx()) * f;
        S s10 = this.spec;
        this.displayedAmplitude = ((CircularProgressIndicatorSpec) s10).waveAmplitude * f;
        float f12 = (((CircularProgressIndicatorSpec) s10).indicatorSize - ((CircularProgressIndicatorSpec) s10).trackThickness) / 2.0f;
        this.adjustedRadius = f12;
        if (z9 || z10) {
            float f13 = ((1.0f - f) * ((CircularProgressIndicatorSpec) s10).trackThickness) / 2.0f;
            if ((z9 && ((CircularProgressIndicatorSpec) s10).showAnimationBehavior == 2) || (z10 && ((CircularProgressIndicatorSpec) s10).hideAnimationBehavior == 1)) {
                this.adjustedRadius = f12 + f13;
            } else if ((z9 && ((CircularProgressIndicatorSpec) s10).showAnimationBehavior == 1) || (z10 && ((CircularProgressIndicatorSpec) s10).hideAnimationBehavior == 2)) {
                this.adjustedRadius = f12 - f13;
            }
        }
        if (z10 && ((CircularProgressIndicatorSpec) s10).hideAnimationBehavior == 3) {
            this.totalTrackLengthFraction = f;
        } else {
            this.totalTrackLengthFraction = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, @IntRange(from = 0, to = 255) int i) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i);
        canvas.save();
        canvas.rotate(activeIndicator.rotationDegree);
        this.drawingDeterminateIndicator = activeIndicator.isDeterminate;
        float f = activeIndicator.startFraction;
        float f10 = activeIndicator.endFraction;
        int i6 = activeIndicator.gapSize;
        drawArc(canvas, paint, f, f10, compositeARGBWithAlpha, i6, i6, activeIndicator.amplitudeFraction, activeIndicator.phaseFraction, true);
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f10, @ColorInt int i, @IntRange(from = 0, to = 255) int i6, int i10) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i, i6);
        this.drawingDeterminateIndicator = false;
        drawArc(canvas, paint, f, f10, compositeARGBWithAlpha, i10, i10, 0.0f, 0.0f, false);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void invalidateCachedPaths() {
        this.cachedActivePath.rewind();
        this.cachedActivePath.moveTo(1.0f, 0.0f);
        for (int i = 0; i < 2; i++) {
            this.cachedActivePath.cubicTo(1.0f, QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, 1.0f, 0.0f, 1.0f);
            this.cachedActivePath.cubicTo(-0.5522848f, 1.0f, -1.0f, QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, -1.0f, 0.0f);
            this.cachedActivePath.cubicTo(-1.0f, -0.5522848f, -0.5522848f, -1.0f, 0.0f, -1.0f);
            this.cachedActivePath.cubicTo(QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, -1.0f, 1.0f, -0.5522848f, 1.0f, 0.0f);
        }
        this.transform.reset();
        Matrix matrix = this.transform;
        float f = this.adjustedRadius;
        matrix.setScale(f, f);
        this.cachedActivePath.transform(this.transform);
        if (((CircularProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator)) {
            this.activePathMeasure.setPath(this.cachedActivePath, false);
            createWavyPath(this.activePathMeasure, this.cachedActivePath, this.cachedAmplitude);
        }
        this.activePathMeasure.setPath(this.cachedActivePath, false);
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint, float f, float f10) {
        drawRoundedBlock(canvas, paint, pathPoint, f, f10, 1.0f);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i, @IntRange(from = 0, to = 255) int i6) {
    }
}
