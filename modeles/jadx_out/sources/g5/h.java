package g5;

import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.uptodown.tv.ui.fragment.TvAppsListFragment;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h implements OnItemViewClickedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TvAppsListFragment f5320a;

    public h(TvAppsListFragment tvAppsListFragment) {
        this.f5320a = tvAppsListFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof x4.g) {
            TvAppsListFragment tvAppsListFragment = this.f5320a;
            if (tvAppsListFragment.getActivity() == null || viewHolder == null) {
                return;
            }
            f5.a aVar = (f5.a) tvAppsListFragment.getActivity();
            aVar.getClass();
            aVar.j((x4.g) obj, viewHolder);
        }
    }
}
