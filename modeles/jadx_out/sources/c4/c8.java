package c4;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.RecommendedActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c8 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f1470a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecommendedActivity f1471b;

    public c8(LinearLayoutManager linearLayoutManager, RecommendedActivity recommendedActivity) {
        this.f1470a = linearLayoutManager;
        this.f1471b = recommendedActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i6) {
        recyclerView.getClass();
        if (i6 > 0) {
            LinearLayoutManager linearLayoutManager = this.f1470a;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            int i10 = RecommendedActivity.f3338g0;
            RecommendedActivity recommendedActivity = this.f1471b;
            if (recommendedActivity.O0().f || recommendedActivity.O0().f1729e || childCount + findFirstVisibleItemPosition < itemCount) {
                return;
            }
            e4.e1 e1Var = recommendedActivity.f3340c0;
            e1Var.getClass();
            e1Var.d(true);
            recommendedActivity.O0().a(recommendedActivity);
        }
    }
}
