package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.view.View;
import java.util.HashSet;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
abstract class KeyPositionBase extends Key {
    protected static final float SELECTION_SLOPE = 20.0f;
    int mCurveFit = Key.UNSET;

    public abstract void calcPosition(int i, int i6, float f, float f10, float f11, float f12);

    public abstract float getPositionX();

    public abstract float getPositionY();

    public abstract boolean intersects(int i, int i6, RectF rectF, RectF rectF2, float f, float f10);

    public abstract void positionAttributes(View view, RectF rectF, RectF rectF2, float f, float f10, String[] strArr, float[] fArr);

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
    }
}
