package com.uptodown.views;

import a2.s;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ScrollableAllCapsTextView extends AppCompatTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableAllCapsTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        if (getText().toString().length() > 0) {
            setSingleLine();
            setEllipsize(TextUtils.TruncateAt.MARQUEE);
            setMarqueeRepeatLimit(1);
            setFocusable(true);
            setFocusableInTouchMode(true);
            setHorizontallyScrolling(true);
            postDelayed(new s(this, 16), 3000L);
            setAllCaps(true);
        }
    }
}
