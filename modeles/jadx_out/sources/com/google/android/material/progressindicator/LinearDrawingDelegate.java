package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.progressindicator.DrawingDelegate;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float adjustedWavelength;
    private int cachedWavelength;
    private float displayedAmplitude;
    private float displayedCornerRadius;
    private float displayedInnerCornerRadius;
    private float displayedTrackThickness;
    private boolean drawingDeterminateIndicator;
    Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> endPoints;

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    private float totalTrackLengthFraction;
    private float trackLength;

    public LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.trackLength = 300.0f;
        this.endPoints = new Pair<>(new DrawingDelegate.PathPoint(), new DrawingDelegate.PathPoint());
    }

    private void calculateDisplayedPath(@NonNull PathMeasure pathMeasure, @NonNull Path path, @NonNull Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair, float f, float f10, float f11, float f12) {
        boolean z9 = this.drawingDeterminateIndicator;
        LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) this.spec;
        int i = z9 ? linearProgressIndicatorSpec.wavelengthDeterminate : linearProgressIndicatorSpec.wavelengthIndeterminate;
        if (pathMeasure == this.activePathMeasure && i != this.cachedWavelength) {
            this.cachedWavelength = i;
            invalidateCachedPaths();
        }
        path.rewind();
        float f13 = (-this.trackLength) / 2.0f;
        boolean hasWavyEffect = ((LinearProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator);
        if (hasWavyEffect) {
            float f14 = this.trackLength;
            float f15 = this.adjustedWavelength;
            float f16 = f14 / f15;
            float f17 = f12 / f16;
            float f18 = f16 / (f16 + 1.0f);
            f = (f + f17) * f18;
            f10 = (f10 + f17) * f18;
            f13 -= f12 * f15;
        }
        float length = pathMeasure.getLength() * f;
        float length2 = pathMeasure.getLength() * f10;
        pathMeasure.getSegment(length, length2, path, true);
        DrawingDelegate.PathPoint pathPoint = (DrawingDelegate.PathPoint) pair.first;
        pathPoint.reset();
        pathMeasure.getPosTan(length, pathPoint.posVec, pathPoint.tanVec);
        DrawingDelegate.PathPoint pathPoint2 = (DrawingDelegate.PathPoint) pair.second;
        pathPoint2.reset();
        pathMeasure.getPosTan(length2, pathPoint2.posVec, pathPoint2.tanVec);
        this.transform.reset();
        this.transform.setTranslate(f13, 0.0f);
        pathPoint.translate(f13, 0.0f);
        pathPoint2.translate(f13, 0.0f);
        if (hasWavyEffect) {
            float f19 = this.displayedAmplitude * f11;
            this.transform.postScale(1.0f, f19);
            pathPoint.scale(1.0f, f19);
            pathPoint2.scale(1.0f, f19);
        }
        path.transform(this.transform);
    }

    private void drawLine(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f10, @ColorInt int i, @Px int i6, @Px int i10, float f11, float f12, boolean z9) {
        float f13;
        float f14;
        Paint paint2;
        Canvas canvas2;
        float clamp = MathUtils.clamp(f, 0.0f, 1.0f);
        float clamp2 = MathUtils.clamp(f10, 0.0f, 1.0f);
        float lerp = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, clamp);
        float lerp2 = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, clamp2);
        int clamp3 = (int) ((MathUtils.clamp(lerp, 0.0f, 0.01f) * i6) / 0.01f);
        float clamp4 = 1.0f - MathUtils.clamp(lerp2, 0.99f, 1.0f);
        float f15 = this.trackLength;
        int i11 = (int) ((lerp * f15) + clamp3);
        int i12 = (int) ((lerp2 * f15) - ((int) ((clamp4 * i10) / 0.01f)));
        float f16 = this.displayedCornerRadius;
        float f17 = this.displayedInnerCornerRadius;
        if (f16 != f17) {
            float max = Math.max(f16, f17);
            float f18 = this.trackLength;
            float f19 = max / f18;
            float lerp3 = com.google.android.material.math.MathUtils.lerp(this.displayedCornerRadius, this.displayedInnerCornerRadius, MathUtils.clamp(i11 / f18, 0.0f, f19) / f19);
            float f20 = this.displayedCornerRadius;
            float f21 = this.displayedInnerCornerRadius;
            float f22 = this.trackLength;
            f14 = com.google.android.material.math.MathUtils.lerp(f20, f21, MathUtils.clamp((f22 - i12) / f22, 0.0f, f19) / f19);
            f13 = lerp3;
        } else {
            f13 = f16;
            f14 = f13;
        }
        float f23 = (-this.trackLength) / 2.0f;
        boolean z10 = ((LinearProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator) && z9 && f11 > 0.0f;
        if (i11 <= i12) {
            float f24 = i11 + f13;
            float f25 = i12 - f14;
            float f26 = f13 * 2.0f;
            float f27 = 2.0f * f14;
            paint.setColor(i);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.displayedTrackThickness);
            ((DrawingDelegate.PathPoint) this.endPoints.first).reset();
            ((DrawingDelegate.PathPoint) this.endPoints.second).reset();
            ((DrawingDelegate.PathPoint) this.endPoints.first).translate(f24 + f23, 0.0f);
            ((DrawingDelegate.PathPoint) this.endPoints.second).translate(f23 + f25, 0.0f);
            if (i11 == 0 && f25 + f14 < f24 + f13) {
                Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair = this.endPoints;
                DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint = (DrawingDelegate.PathPoint) pair.first;
                float f28 = this.displayedTrackThickness;
                drawRoundedBlock(canvas, paint, pathPoint, f26, f28, f13, (DrawingDelegate.PathPoint) pair.second, f27, f28, f14, true);
                return;
            }
            if (f24 - f13 > f25 - f14) {
                Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair2 = this.endPoints;
                DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint2 = (DrawingDelegate.PathPoint) pair2.second;
                float f29 = this.displayedTrackThickness;
                drawRoundedBlock(canvas, paint, pathPoint2, f27, f29, f14, (DrawingDelegate.PathPoint) pair2.first, f26, f29, f13, false);
                return;
            }
            float f30 = f14;
            float f31 = f13;
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(((LinearProgressIndicatorSpec) this.spec).useStrokeCap() ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            if (z10) {
                paint2 = paint;
                PathMeasure pathMeasure = this.activePathMeasure;
                Path path = this.displayedActivePath;
                Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair3 = this.endPoints;
                float f32 = this.trackLength;
                calculateDisplayedPath(pathMeasure, path, pair3, f24 / f32, f25 / f32, f11, f12);
                canvas2 = canvas;
                canvas2.drawPath(this.displayedActivePath, paint2);
            } else {
                Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair4 = this.endPoints;
                Object obj = pair4.first;
                float f33 = ((DrawingDelegate.PathPoint) obj).posVec[0];
                float f34 = ((DrawingDelegate.PathPoint) obj).posVec[1];
                Object obj2 = pair4.second;
                canvas.drawLine(f33, f34, ((DrawingDelegate.PathPoint) obj2).posVec[0], ((DrawingDelegate.PathPoint) obj2).posVec[1], paint);
                paint2 = paint;
                canvas2 = canvas;
            }
            if (((LinearProgressIndicatorSpec) this.spec).useStrokeCap()) {
                return;
            }
            if (f24 > 0.0f && f31 > 0.0f) {
                drawRoundedBlock(canvas2, paint2, (DrawingDelegate.PathPoint) this.endPoints.first, f26, this.displayedTrackThickness, f31);
            }
            if (f25 >= this.trackLength || f30 <= 0.0f) {
                return;
            }
            drawRoundedBlock(canvas, paint, (DrawingDelegate.PathPoint) this.endPoints.second, f27, this.displayedTrackThickness, f30);
        }
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint, float f, float f10, float f11, @Nullable DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint2, float f12, float f13, float f14, boolean z9) {
        float f15;
        float f16;
        float min = Math.min(f10, this.displayedTrackThickness);
        float f17 = (-f) / 2.0f;
        float f18 = (-min) / 2.0f;
        float f19 = f / 2.0f;
        float f20 = min / 2.0f;
        RectF rectF = new RectF(f17, f18, f19, f20);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (pathPoint2 != null) {
            float min2 = Math.min(f13, this.displayedTrackThickness);
            float min3 = Math.min(f12 / 2.0f, (f14 * min2) / this.displayedTrackThickness);
            RectF rectF2 = new RectF();
            float[] fArr = pathPoint2.posVec;
            if (z9) {
                float f21 = (fArr[0] - min3) - (pathPoint.posVec[0] - f11);
                if (f21 > 0.0f) {
                    pathPoint2.translate((-f21) / 2.0f, 0.0f);
                    f16 = f12 + f21;
                } else {
                    f16 = f12;
                }
                rectF2.set(0.0f, f18, f19, f20);
            } else {
                float f22 = (fArr[0] + min3) - (pathPoint.posVec[0] + f11);
                if (f22 < 0.0f) {
                    pathPoint2.translate((-f22) / 2.0f, 0.0f);
                    f15 = f12 - f22;
                } else {
                    f15 = f12;
                }
                rectF2.set(f17, f18, 0.0f, f20);
                f16 = f15;
            }
            RectF rectF3 = new RectF((-f16) / 2.0f, (-min2) / 2.0f, f16 / 2.0f, min2 / 2.0f);
            float[] fArr2 = pathPoint2.posVec;
            canvas.translate(fArr2[0], fArr2[1]);
            canvas.rotate(vectorToCanvasRotation(pathPoint2.tanVec));
            Path path = new Path();
            path.addRoundRect(rectF3, min3, min3, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.rotate(-vectorToCanvasRotation(pathPoint2.tanVec));
            float[] fArr3 = pathPoint2.posVec;
            canvas.translate(-fArr3[0], -fArr3[1]);
            float[] fArr4 = pathPoint.posVec;
            canvas.translate(fArr4[0], fArr4[1]);
            canvas.rotate(vectorToCanvasRotation(pathPoint.tanVec));
            canvas.drawRect(rectF2, paint);
            canvas.drawRoundRect(rectF, f11, f11, paint);
        } else {
            float[] fArr5 = pathPoint.posVec;
            canvas.translate(fArr5[0], fArr5[1]);
            canvas.rotate(vectorToCanvasRotation(pathPoint.tanVec));
            canvas.drawRoundRect(rectF, f11, f11, paint);
        }
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = 1.0d) float f, boolean z9, boolean z10) {
        if (this.trackLength != rect.width()) {
            this.trackLength = rect.width();
            invalidateCachedPaths();
        }
        float preferredHeight = getPreferredHeight();
        canvas.translate((rect.width() / 2.0f) + rect.left, Math.max(0.0f, (rect.height() - preferredHeight) / 2.0f) + (rect.height() / 2.0f) + rect.top);
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f10 = this.trackLength / 2.0f;
        float f11 = preferredHeight / 2.0f;
        canvas.clipRect(-f10, -f11, f10, f11);
        S s6 = this.spec;
        this.displayedTrackThickness = ((LinearProgressIndicatorSpec) s6).trackThickness * f;
        this.displayedCornerRadius = Math.min(((LinearProgressIndicatorSpec) s6).trackThickness / 2, ((LinearProgressIndicatorSpec) s6).getTrackCornerRadiusInPx()) * f;
        S s9 = this.spec;
        this.displayedAmplitude = ((LinearProgressIndicatorSpec) s9).waveAmplitude * f;
        this.displayedInnerCornerRadius = Math.min(((LinearProgressIndicatorSpec) s9).trackThickness / 2.0f, ((LinearProgressIndicatorSpec) s9).getTrackInnerCornerRadiusInPx()) * f;
        if (z9 || z10) {
            if ((z9 && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (z10 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z9 || (z10 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 3)) {
                canvas.translate(0.0f, ((1.0f - f) * ((LinearProgressIndicatorSpec) this.spec).trackThickness) / 2.0f);
            }
        }
        if (z10 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 3) {
            this.totalTrackLengthFraction = f;
        } else {
            this.totalTrackLengthFraction = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i, @IntRange(from = 0, to = 255) int i6) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i, i6);
        this.drawingDeterminateIndicator = false;
        if (((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize <= 0 || compositeARGBWithAlpha == 0) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(compositeARGBWithAlpha);
        S s6 = this.spec;
        DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint = new DrawingDelegate.PathPoint(new float[]{(this.trackLength / 2.0f) - (((LinearProgressIndicatorSpec) s6).trackStopIndicatorPadding != null ? (((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize / 2.0f) + ((LinearProgressIndicatorSpec) s6).trackStopIndicatorPadding.floatValue() : this.displayedTrackThickness / 2.0f), 0.0f}, new float[]{1.0f, 0.0f});
        S s9 = this.spec;
        drawRoundedBlock(canvas, paint, pathPoint, ((LinearProgressIndicatorSpec) s9).trackStopIndicatorSize, ((LinearProgressIndicatorSpec) s9).trackStopIndicatorSize, (this.displayedCornerRadius * ((LinearProgressIndicatorSpec) s9).trackStopIndicatorSize) / this.displayedTrackThickness);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, int i) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i);
        this.drawingDeterminateIndicator = activeIndicator.isDeterminate;
        float f = activeIndicator.startFraction;
        float f10 = activeIndicator.endFraction;
        int i6 = activeIndicator.gapSize;
        drawLine(canvas, paint, f, f10, compositeARGBWithAlpha, i6, i6, activeIndicator.amplitudeFraction, activeIndicator.phaseFraction, true);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f10, int i, int i6, @Px int i10) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i, i6);
        this.drawingDeterminateIndicator = false;
        drawLine(canvas, paint, f, f10, compositeARGBWithAlpha, i10, i10, 0.0f, 0.0f, false);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        S s6 = this.spec;
        return (((LinearProgressIndicatorSpec) s6).waveAmplitude * 2) + ((LinearProgressIndicatorSpec) s6).trackThickness;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return -1;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void invalidateCachedPaths() {
        this.cachedActivePath.rewind();
        if (((LinearProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator)) {
            boolean z9 = this.drawingDeterminateIndicator;
            LinearProgressIndicatorSpec linearProgressIndicatorSpec = (LinearProgressIndicatorSpec) this.spec;
            int i = z9 ? linearProgressIndicatorSpec.wavelengthDeterminate : linearProgressIndicatorSpec.wavelengthIndeterminate;
            float f = this.trackLength;
            int i6 = (int) (f / i);
            this.adjustedWavelength = f / i6;
            for (int i10 = 0; i10 <= i6; i10++) {
                int i11 = i10 * 2;
                float f10 = i11 + 1;
                this.cachedActivePath.cubicTo(i11 + 0.48f, 0.0f, f10 - 0.48f, 1.0f, f10, 1.0f);
                float f11 = i11 + 2;
                this.cachedActivePath.cubicTo(f10 + 0.48f, 1.0f, f11 - 0.48f, 0.0f, f11, 0.0f);
            }
            this.transform.reset();
            this.transform.setScale(this.adjustedWavelength / 2.0f, -2.0f);
            this.transform.postTranslate(0.0f, 1.0f);
            this.cachedActivePath.transform(this.transform);
        } else {
            this.cachedActivePath.lineTo(this.trackLength, 0.0f);
        }
        this.activePathMeasure.setPath(this.cachedActivePath, false);
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint, float f, float f10, float f11) {
        drawRoundedBlock(canvas, paint, pathPoint, f, f10, f11, null, 0.0f, 0.0f, 0.0f, false);
    }
}
