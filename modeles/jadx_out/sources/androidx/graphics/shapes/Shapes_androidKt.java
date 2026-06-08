package androidx.graphics.shapes;

import android.graphics.Matrix;
import android.graphics.Path;
import androidx.collection.FloatFloatPair;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Shapes_androidKt {
    private static final void pathFromCubics(Path path, List<? extends Cubic> list) {
        path.rewind();
        int size = list.size();
        boolean z9 = true;
        for (int i = 0; i < size; i++) {
            Cubic cubic = list.get(i);
            if (z9) {
                path.moveTo(cubic.getAnchor0X(), cubic.getAnchor0Y());
                z9 = false;
            }
            path.cubicTo(cubic.getControl0X(), cubic.getControl0Y(), cubic.getControl1X(), cubic.getControl1Y(), cubic.getAnchor1X(), cubic.getAnchor1Y());
        }
        path.close();
    }

    public static final Path toPath(RoundedPolygon roundedPolygon, Path path) {
        roundedPolygon.getClass();
        path.getClass();
        pathFromCubics(path, roundedPolygon.getCubics());
        return path;
    }

    public static /* synthetic */ Path toPath$default(RoundedPolygon roundedPolygon, Path path, int i, Object obj) {
        if ((i & 1) != 0) {
            path = new Path();
        }
        return toPath(roundedPolygon, path);
    }

    public static final RoundedPolygon transformed(RoundedPolygon roundedPolygon, final Matrix matrix) {
        roundedPolygon.getClass();
        matrix.getClass();
        final float[] fArr = new float[2];
        return roundedPolygon.transformed(new PointTransformer() { // from class: androidx.graphics.shapes.Shapes_androidKt$transformed$1
            @Override // androidx.graphics.shapes.PointTransformer
            /* renamed from: transform-XgqJiTY */
            public final long mo68transformXgqJiTY(float f, float f10) {
                float[] fArr2 = fArr;
                fArr2[0] = f;
                fArr2[1] = f10;
                matrix.mapPoints(fArr2);
                float[] fArr3 = fArr;
                return FloatFloatPair.m9constructorimpl(fArr3[0], fArr3[1]);
            }
        });
    }

    public static final Path toPath(RoundedPolygon roundedPolygon) {
        roundedPolygon.getClass();
        return toPath$default(roundedPolygon, null, 1, null);
    }

    public static /* synthetic */ Path toPath$default(Morph morph, float f, Path path, int i, Object obj) {
        if ((i & 2) != 0) {
            path = new Path();
        }
        return toPath(morph, f, path);
    }

    public static final Path toPath(Morph morph, float f, Path path) {
        morph.getClass();
        path.getClass();
        pathFromCubics(path, morph.asCubics(f));
        return path;
    }
}
