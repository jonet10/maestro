package e5;

import android.view.ViewGroup;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends Presenter {
    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        if (obj == null) {
            return;
        }
        TextView textView = (TextView) viewHolder.view.findViewById(2131364026);
        textView.setTypeface(f4.c.f4882w);
        textView.setText(((x4.j) obj).f11225b);
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new Presenter.ViewHolder(androidx.lifecycle.l.s(viewGroup, 2131558838, viewGroup, false));
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
    }
}
