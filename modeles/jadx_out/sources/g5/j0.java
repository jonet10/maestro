package g5;

import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j0 implements OnItemViewClickedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f5327a;

    public j0(n0 n0Var) {
        this.f5327a = n0Var;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof x4.g) {
            n0 n0Var = this.f5327a;
            if (n0Var.getActivity() == null || viewHolder == null) {
                return;
            }
            f5.a aVar = (f5.a) n0Var.getActivity();
            aVar.getClass();
            aVar.j((x4.g) obj, viewHolder);
        }
    }
}
