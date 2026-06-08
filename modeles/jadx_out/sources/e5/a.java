package e5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.Presenter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends Presenter {
    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        if (obj == null) {
            return;
        }
        View view = viewHolder.view;
        view.getClass();
        ((Button) view).setText(((Action) obj).getLabel1());
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new Presenter.ViewHolder(androidx.lifecycle.l.s(viewGroup, 2131558839, viewGroup, false));
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
    }
}
