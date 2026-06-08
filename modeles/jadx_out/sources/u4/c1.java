package u4;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c1 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f10440a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f1 f10441b;

    public c1(LinearLayoutManager linearLayoutManager, f1 f1Var) {
        this.f10440a = linearLayoutManager;
        this.f10441b = f1Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i6) {
        recyclerView.getClass();
        if (i6 > 0) {
            LinearLayoutManager linearLayoutManager = this.f10440a;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            f1 f1Var = this.f10441b;
            if (f1Var.b().g || !f1Var.b().f || childCount + findFirstVisibleItemPosition < itemCount) {
                return;
            }
            e4.c cVar = f1Var.f10489l;
            if (cVar != null) {
                cVar.a(true);
            }
            c4.t0 b7 = f1Var.b();
            Context requireContext = f1Var.requireContext();
            requireContext.getClass();
            b7.a(requireContext);
        }
    }
}
