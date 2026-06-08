package com.uptodown.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class FullWidthImageView extends AppCompatImageView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FullWidthImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i6) {
        if (getDrawable() == null) {
            super.onMeasure(i, i6);
        } else {
            setMeasuredDimension(View.MeasureSpec.getSize(i), (int) Math.ceil((r3 * getDrawable().getIntrinsicHeight()) / getDrawable().getIntrinsicWidth()));
        }
    }
}
