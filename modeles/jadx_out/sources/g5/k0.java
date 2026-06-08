package g5;

import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.lifecycle.LifecycleOwnerKt;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k0 implements OnItemViewSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n0 f5328a;

    public k0(n0 n0Var) {
        this.f5328a = n0Var;
    }

    @Override // androidx.leanback.widget.BaseOnItemViewSelectedListener
    public final void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj != null) {
            n0 n0Var = this.f5328a;
            ArrayObjectAdapter arrayObjectAdapter = n0Var.f5339a;
            arrayObjectAdapter.getClass();
            int indexOf = arrayObjectAdapter.indexOf(obj);
            int i = n0Var.f5341l;
            if (indexOf >= i || indexOf < i - 5 || n0Var.f5342m) {
                return;
            }
            o7.c0.s(LifecycleOwnerKt.getLifecycleScope(n0Var), null, null, new l0(n0Var, null, 1), 3);
        }
    }
}
