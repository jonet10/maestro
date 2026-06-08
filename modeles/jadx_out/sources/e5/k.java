package e5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.PageRow;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowHeaderPresenter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k extends RowHeaderPresenter {
    @Override // androidx.leanback.widget.RowHeaderPresenter, androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        if (obj == null) {
            return;
        }
        HeaderItem headerItem = ((PageRow) obj).getHeaderItem();
        headerItem.getClass();
        View view = viewHolder.view;
        view.setFocusable(true);
        View findViewById = view.findViewById(2131362380);
        findViewById.getClass();
        ((ImageView) findViewById).setImageDrawable(ContextCompat.getDrawable(view.getContext(), ((c5.a) headerItem).f2413a));
    }

    @Override // androidx.leanback.widget.RowHeaderPresenter, androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        viewGroup.getClass();
        Object systemService = viewGroup.getContext().getSystemService("layout_inflater");
        systemService.getClass();
        return new RowHeaderPresenter.ViewHolder(((LayoutInflater) systemService).inflate(2131558844, viewGroup, false));
    }
}
