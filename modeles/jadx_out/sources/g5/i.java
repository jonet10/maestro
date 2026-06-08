package g5;

import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.tv.ui.fragment.TvAppsListFragment;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i implements OnItemViewSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TvAppsListFragment f5322a;

    public i(TvAppsListFragment tvAppsListFragment) {
        this.f5322a = tvAppsListFragment;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public final void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj != null) {
            TvAppsListFragment tvAppsListFragment = this.f5322a;
            ArrayObjectAdapter arrayObjectAdapter = tvAppsListFragment.f3427a;
            arrayObjectAdapter.getClass();
            int indexOf = arrayObjectAdapter.indexOf(obj);
            int i = tvAppsListFragment.f3429l;
            if (indexOf >= i || indexOf < i - 5 || tvAppsListFragment.f3430m) {
                return;
            }
            o7.c0.s(LifecycleOwnerKt.getLifecycleScope(tvAppsListFragment), null, null, new j(tvAppsListFragment, null, 1), 3);
        }
    }
}
