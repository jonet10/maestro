package i5;

import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements View.OnFocusChangeListener {
    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z9) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        if (z9) {
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(), 2131100505));
            layoutParams.setMargins(12, 0, 12, 12);
        } else {
            view.setBackgroundColor(ContextCompat.getColor(view.getContext(), 2131100798));
            layoutParams.setMargins(12, 12, 12, 12);
        }
        view.setLayoutParams(layoutParams);
    }
}
