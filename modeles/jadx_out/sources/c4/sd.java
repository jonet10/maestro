package c4;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.WishlistActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class sd extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayoutManager f2099a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WishlistActivity f2100b;

    public sd(LinearLayoutManager linearLayoutManager, WishlistActivity wishlistActivity) {
        this.f2099a = linearLayoutManager;
        this.f2100b = wishlistActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public final void onScrolled(RecyclerView recyclerView, int i, int i6) {
        recyclerView.getClass();
        if (i6 > 0) {
            LinearLayoutManager linearLayoutManager = this.f2099a;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int childCount = linearLayoutManager.getChildCount();
            int itemCount = linearLayoutManager.getItemCount();
            int i10 = WishlistActivity.f3367g0;
            WishlistActivity wishlistActivity = this.f2100b;
            if (wishlistActivity.O0().f2238d || wishlistActivity.O0().f2237c || childCount + findFirstVisibleItemPosition < itemCount) {
                return;
            }
            e4.e1 e1Var = wishlistActivity.f3369c0;
            e1Var.getClass();
            e1Var.d(true);
            wishlistActivity.O0().a(wishlistActivity);
        }
    }
}
