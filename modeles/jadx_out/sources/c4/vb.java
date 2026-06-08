package c4;

import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.UserCommentsActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class vb extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f2231a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserCommentsActivity f2232b;

    public vb(LinearLayoutManager linearLayoutManager, UserCommentsActivity userCommentsActivity) {
        this.f2231a = linearLayoutManager;
        this.f2232b = userCommentsActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i6) {
        recyclerView.getClass();
        if (i6 > 0) {
            LinearLayoutManager linearLayoutManager = this.f2231a;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            int i10 = UserCommentsActivity.S;
            UserCommentsActivity userCommentsActivity = this.f2232b;
            if (userCommentsActivity.z0().h || ((Boolean) userCommentsActivity.z0().f.getValue()).booleanValue() || childCount + findFirstVisibleItemPosition < itemCount) {
                return;
            }
            e4.b1 b1Var = userCommentsActivity.Q;
            if (b1Var != null) {
                b1Var.f4495c = true;
                b1Var.notifyItemInserted(b1Var.getItemCount());
            }
            bc z02 = userCommentsActivity.z0();
            z02.getClass();
            o7.a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
            v7.e eVar = o7.m0.f8288a;
            o7.c0.s(viewModelScope, v7.d.f10884a, null, new b6.a(z02, userCommentsActivity, null, 27), 2);
        }
    }
}
