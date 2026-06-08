package l5;

import android.text.Layout;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e implements View.OnTouchListener {
    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int action;
        view.getClass();
        motionEvent.getClass();
        TextView textView = (TextView) view;
        CharSequence text = textView.getText();
        text.getClass();
        if ((text instanceof Spanned) && ((action = motionEvent.getAction()) == 0 || action == 1)) {
            int x3 = (int) motionEvent.getX();
            int y9 = (int) motionEvent.getY();
            int totalPaddingLeft = x3 - textView.getTotalPaddingLeft();
            int totalPaddingTop = y9 - textView.getTotalPaddingTop();
            int scrollX = textView.getScrollX() + totalPaddingLeft;
            int scrollY = textView.getScrollY() + totalPaddingTop;
            Layout layout = textView.getLayout();
            layout.getClass();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            ClickableSpan[] clickableSpanArr = (ClickableSpan[]) ((Spanned) text).getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
            clickableSpanArr.getClass();
            if (!(clickableSpanArr.length == 0)) {
                if (action == 1) {
                    clickableSpanArr[0].onClick(textView);
                }
                return true;
            }
        }
        return false;
    }
}
