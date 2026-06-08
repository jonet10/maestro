package c4;

import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.FollowListActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u0 extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f2144a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FollowListActivity f2145b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2146c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f2147d;

    public u0(LinearLayoutManager linearLayoutManager, FollowListActivity followListActivity, int i, String str) {
        this.f2144a = linearLayoutManager;
        this.f2145b = followListActivity;
        this.f2146c = i;
        this.f2147d = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i6) {
        recyclerView.getClass();
        if (i6 > 0) {
            LinearLayoutManager linearLayoutManager = this.f2144a;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            int i10 = FollowListActivity.S;
            FollowListActivity followListActivity = this.f2145b;
            if (followListActivity.z0().h || !followListActivity.z0().g || childCount + findFirstVisibleItemPosition < itemCount) {
                return;
            }
            e4.d dVar = followListActivity.Q;
            if (dVar != null) {
                dVar.f4507c = true;
                dVar.notifyItemInserted(dVar.getItemCount());
            }
            t6.c cVar = null;
            String str = this.f2147d;
            int i11 = this.f2146c;
            if (i11 == 1) {
                b1 z02 = followListActivity.z0();
                z02.getClass();
                str.getClass();
                o7.a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
                v7.e eVar = o7.m0.f8288a;
                o7.c0.s(viewModelScope, v7.d.f10884a, null, new a1(z02, followListActivity, str, cVar, 0), 2);
                return;
            }
            if (i11 == 2) {
                b1 z03 = followListActivity.z0();
                z03.getClass();
                str.getClass();
                o7.a0 viewModelScope2 = ViewModelKt.getViewModelScope(z03);
                v7.e eVar2 = o7.m0.f8288a;
                o7.c0.s(viewModelScope2, v7.d.f10884a, null, new a1(z03, followListActivity, str, cVar, 1), 2);
            }
        }
    }
}
