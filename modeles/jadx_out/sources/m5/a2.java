package m5;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a2 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b2 f7307a;

    public a2(b2 b2Var) {
        this.f7307a = b2Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        recyclerView.getClass();
        super.onScrollStateChanged(recyclerView, i);
        b2 b2Var = this.f7307a;
        LinearLayoutManager linearLayoutManager = b2Var.f7321m;
        e4.m1 m1Var = b2Var.f7322n;
        if (!m1Var.f) {
            m1Var.f = true;
        }
        if (i == 0) {
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
            int i6 = m1Var.f4633k;
            if (findLastCompletelyVisibleItemPosition == linearLayoutManager.getItemCount() - 1 && findLastCompletelyVisibleItemPosition != m1Var.f4633k) {
                m1Var.f4633k = findLastCompletelyVisibleItemPosition;
                ArrayList arrayList = ((x4.g) m1Var.f4632e.get(i6)).Y;
                if (arrayList != null && !arrayList.isEmpty()) {
                    m1Var.notifyItemChanged(i6);
                }
                ArrayList arrayList2 = ((x4.g) m1Var.f4632e.get(findLastCompletelyVisibleItemPosition)).Y;
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    return;
                }
                m1Var.notifyItemChanged(findLastCompletelyVisibleItemPosition);
                return;
            }
            if (findFirstCompletelyVisibleItemPosition == -1 || findFirstCompletelyVisibleItemPosition == m1Var.f4633k) {
                return;
            }
            m1Var.f4633k = findFirstCompletelyVisibleItemPosition;
            ArrayList arrayList3 = ((x4.g) m1Var.f4632e.get(i6)).Y;
            if (arrayList3 != null && !arrayList3.isEmpty()) {
                m1Var.notifyItemChanged(i6);
            }
            ArrayList arrayList4 = ((x4.g) m1Var.f4632e.get(findFirstCompletelyVisibleItemPosition)).Y;
            if (arrayList4 == null || arrayList4.isEmpty()) {
                return;
            }
            m1Var.notifyItemChanged(findFirstCompletelyVisibleItemPosition);
        }
    }
}
