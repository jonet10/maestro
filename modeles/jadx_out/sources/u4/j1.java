package u4;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j1 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m1 f10511a;

    public j1(m1 m1Var) {
        this.f10511a = m1Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i6) {
        recyclerView.getClass();
        if (i6 > 0) {
            m1 m1Var = this.f10511a;
            if (m1Var.f10545r || !m1Var.f10546s || recyclerView.canScrollVertically(1)) {
                return;
            }
            o7.c0.s(LifecycleOwnerKt.getLifecycleScope(m1Var), null, null, new p9.c(m1Var, (t6.c) null, 12), 3);
        }
    }
}
