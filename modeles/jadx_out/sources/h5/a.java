package h5;

import android.view.View;
import android.widget.ImageView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends ImageView {
    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i6) {
        if (getDrawable() == null) {
            super.onMeasure(i, i6);
        } else {
            setMeasuredDimension((int) Math.ceil((r3 * getDrawable().getIntrinsicWidth()) / getDrawable().getIntrinsicHeight()), View.MeasureSpec.getSize(i6));
        }
    }
}
