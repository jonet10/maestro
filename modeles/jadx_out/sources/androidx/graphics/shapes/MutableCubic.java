package androidx.graphics.shapes;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MutableCubic extends Cubic {
    public MutableCubic() {
        super(null, 1, null);
    }

    private final void transformOnePoint(PointTransformer pointTransformer, int i) {
        int i6 = i + 1;
        long mo68transformXgqJiTY = pointTransformer.mo68transformXgqJiTY(getPoints$graphics_shapes_release()[i], getPoints$graphics_shapes_release()[i6]);
        getPoints$graphics_shapes_release()[i] = Float.intBitsToFloat((int) (mo68transformXgqJiTY >> 32));
        getPoints$graphics_shapes_release()[i6] = Float.intBitsToFloat((int) (mo68transformXgqJiTY & 4294967295L));
    }

    public final void interpolate(Cubic cubic, Cubic cubic2, float f) {
        cubic.getClass();
        cubic2.getClass();
        for (int i = 0; i < 8; i++) {
            getPoints$graphics_shapes_release()[i] = Utils.interpolate(cubic.getPoints$graphics_shapes_release()[i], cubic2.getPoints$graphics_shapes_release()[i], f);
        }
    }

    public final void transform(PointTransformer pointTransformer) {
        pointTransformer.getClass();
        transformOnePoint(pointTransformer, 0);
        transformOnePoint(pointTransformer, 2);
        transformOnePoint(pointTransformer, 4);
        transformOnePoint(pointTransformer, 6);
    }
}
