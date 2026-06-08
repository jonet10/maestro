package androidx.graphics.shapes;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class AngleMeasurer implements Measurer {
    private final float centerX;
    private final float centerY;

    public AngleMeasurer(float f, float f10) {
        this.centerX = f;
        this.centerY = f10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float findCubicCutPoint$lambda$1(Cubic cubic, AngleMeasurer angleMeasurer, float f, float f10, float f11) {
        cubic.getClass();
        angleMeasurer.getClass();
        long m47pointOnCurveOOQOV4g$graphics_shapes_release = cubic.m47pointOnCurveOOQOV4g$graphics_shapes_release(f11);
        return Math.abs(Utils.positiveModulo(Utils.angle(PointKt.m59getXDnnuFBc(m47pointOnCurveOOQOV4g$graphics_shapes_release) - angleMeasurer.centerX, PointKt.m60getYDnnuFBc(m47pointOnCurveOOQOV4g$graphics_shapes_release) - angleMeasurer.centerY) - f, Utils.getTwoPi()) - f10);
    }

    @Override // androidx.graphics.shapes.Measurer
    public float findCubicCutPoint(final Cubic cubic, final float f) {
        cubic.getClass();
        final float angle = Utils.angle(cubic.getAnchor0X() - this.centerX, cubic.getAnchor0Y() - this.centerY);
        return Utils.findMinimum(0.0f, 1.0f, 1.0E-5f, new FindMinimumFunction() { // from class: androidx.graphics.shapes.a
            @Override // androidx.graphics.shapes.FindMinimumFunction
            public final float invoke(float f10) {
                float findCubicCutPoint$lambda$1;
                findCubicCutPoint$lambda$1 = AngleMeasurer.findCubicCutPoint$lambda$1(Cubic.this, this, angle, f, f10);
                return findCubicCutPoint$lambda$1;
            }
        });
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    @Override // androidx.graphics.shapes.Measurer
    public float measureCubic(Cubic cubic) {
        cubic.getClass();
        float positiveModulo = Utils.positiveModulo(Utils.angle(cubic.getAnchor1X() - this.centerX, cubic.getAnchor1Y() - this.centerY) - Utils.angle(cubic.getAnchor0X() - this.centerX, cubic.getAnchor0Y() - this.centerY), Utils.getTwoPi());
        if (positiveModulo > Utils.getTwoPi() - 1.0E-4f) {
            return 0.0f;
        }
        return positiveModulo;
    }
}
