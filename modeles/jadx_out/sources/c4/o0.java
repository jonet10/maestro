package c4;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.FeedActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o0 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f1932a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FeedActivity f1933b;

    public o0(LinearLayoutManager linearLayoutManager, FeedActivity feedActivity) {
        this.f1932a = linearLayoutManager;
        this.f1933b = feedActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i6) {
        recyclerView.getClass();
        if (i6 > 0) {
            LinearLayoutManager linearLayoutManager = this.f1932a;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            int i10 = FeedActivity.S;
            FeedActivity feedActivity = this.f1933b;
            if (feedActivity.z0().g || !feedActivity.z0().f || childCount + findFirstVisibleItemPosition < itemCount) {
                return;
            }
            e4.c cVar = feedActivity.Q;
            if (cVar != null) {
                cVar.a(true);
            }
            feedActivity.z0().a(feedActivity);
        }
    }
}
