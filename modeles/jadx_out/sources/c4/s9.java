package c4;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.SearchActivity;
import com.uptodown.views.InstantAutoCompleteTextView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s9 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f2090a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f2091b;

    public s9(LinearLayoutManager linearLayoutManager, SearchActivity searchActivity) {
        this.f2090a = linearLayoutManager;
        this.f2091b = searchActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i6) {
        recyclerView.getClass();
        if (i6 > 0) {
            LinearLayoutManager linearLayoutManager = this.f2090a;
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int i10 = SearchActivity.Y;
            SearchActivity searchActivity = this.f2091b;
            String y02 = SearchActivity.y0(searchActivity, ((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).getText().toString());
            if (y02.length() <= 2 || childCount + findFirstVisibleItemPosition < itemCount || searchActivity.A0().f1478e) {
                return;
            }
            o7.s1 s1Var = searchActivity.Q;
            if (s1Var == null || s1Var.O()) {
                int i11 = 1;
                t6.c cVar = null;
                if (searchActivity.R != null && searchActivity.A0().f.getValue() == ba.f1426a && ((Boolean) searchActivity.A0().g.getValue()).booleanValue()) {
                    searchActivity.A0().f1478e = true;
                    e4.l0 l0Var = searchActivity.R;
                    if (l0Var != null) {
                        l0Var.f4605d = true;
                        l0Var.notifyItemInserted(l0Var.getItemCount());
                    }
                    searchActivity.Q = o7.c0.s(LifecycleOwnerKt.getLifecycleScope(searchActivity), null, null, new w9(0, searchActivity, y02, cVar), 3);
                    return;
                }
                if (searchActivity.S != null && searchActivity.A0().f.getValue() == ba.f1427b && ((Boolean) searchActivity.A0().i.getValue()).booleanValue()) {
                    searchActivity.A0().f1478e = true;
                    e4.m0 m0Var = searchActivity.S;
                    if (m0Var != null) {
                        m0Var.f4627c = true;
                        m0Var.notifyItemInserted(m0Var.getItemCount());
                    }
                    searchActivity.Q = o7.c0.s(LifecycleOwnerKt.getLifecycleScope(searchActivity), null, null, new w9(i11, searchActivity, y02, cVar), 3);
                }
            }
        }
    }
}
