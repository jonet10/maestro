package androidx.transition;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class RectEvaluator implements TypeEvaluator<Rect> {
    private Rect mRect;

    public RectEvaluator(Rect rect) {
        this.mRect = rect;
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        int i = rect.left + ((int) ((rect2.left - r0) * f));
        int i6 = rect.top + ((int) ((rect2.top - r1) * f));
        int i10 = rect.right + ((int) ((rect2.right - r2) * f));
        int i11 = rect.bottom + ((int) ((rect2.bottom - r6) * f));
        Rect rect3 = this.mRect;
        if (rect3 == null) {
            return new Rect(i, i6, i10, i11);
        }
        rect3.set(i, i6, i10, i11);
        return this.mRect;
    }

    public RectEvaluator() {
    }
}
