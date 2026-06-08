package c4;

import android.view.ViewTreeObserver;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.lifecycle.ViewModelKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.RepliesActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class k7 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1792a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k0 f1793b;

    public /* synthetic */ k7(k0 k0Var, int i) {
        this.f1792a = i;
        this.f1793b = k0Var;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        int i = this.f1792a;
        k0 k0Var = this.f1793b;
        switch (i) {
            case 0:
                PublicProfileActivity publicProfileActivity = (PublicProfileActivity) k0Var;
                int i6 = PublicProfileActivity.R;
                int scrollY = publicProfileActivity.y0().f9971t.getScrollY();
                float dimension = publicProfileActivity.getResources().getDimension(2131166522) * 0.7f;
                int alphaComponent = ColorUtils.setAlphaComponent(ContextCompat.getColor(publicProfileActivity, 2131099686), (int) (t0.f.i(scrollY / dimension, 0.0f, 1.0f) * 255));
                if (scrollY >= dimension * 0.5d) {
                    publicProfileActivity.y0().f9972u.setNavigationIcon(ContextCompat.getDrawable(publicProfileActivity, 2131230922));
                } else {
                    publicProfileActivity.y0().f9972u.setNavigationIcon(ContextCompat.getDrawable(publicProfileActivity, 2131231302));
                }
                publicProfileActivity.y0().f9972u.setBackgroundColor(alphaComponent);
                if (scrollY <= publicProfileActivity.y0().f9963l.getBottom()) {
                    publicProfileActivity.y0().G.setVisibility(8);
                    break;
                } else {
                    publicProfileActivity.y0().G.setVisibility(0);
                    break;
                }
            default:
                RepliesActivity repliesActivity = (RepliesActivity) k0Var;
                int i10 = RepliesActivity.S;
                if (!repliesActivity.z0().f2225r && !repliesActivity.z0().f2226s && repliesActivity.y0().v.getLayoutManager() != null) {
                    RecyclerView.LayoutManager layoutManager = repliesActivity.y0().v.getLayoutManager();
                    layoutManager.getClass();
                    int childCount = layoutManager.getChildCount();
                    RecyclerView.LayoutManager layoutManager2 = repliesActivity.y0().v.getLayoutManager();
                    layoutManager2.getClass();
                    int itemCount = layoutManager2.getItemCount();
                    RecyclerView.LayoutManager layoutManager3 = repliesActivity.y0().v.getLayoutManager();
                    layoutManager3.getClass();
                    if (((LinearLayoutManager) layoutManager3).findFirstVisibleItemPosition() + childCount >= itemCount - 10) {
                        e4.h0 h0Var = repliesActivity.Q;
                        if (h0Var != null) {
                            h0Var.a(true);
                        }
                        v8 z02 = repliesActivity.z0();
                        Object value = repliesActivity.z0().f2220m.getValue();
                        value.getClass();
                        long j = ((x4.k2) value).f11258a;
                        e4.h0 h0Var2 = repliesActivity.Q;
                        h0Var2.getClass();
                        int itemCount2 = h0Var2.getItemCount();
                        z02.getClass();
                        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
                        v7.e eVar = o7.m0.f8288a;
                        o7.c0.s(viewModelScope, v7.d.f10884a, null, new t8(z02, repliesActivity, j, itemCount2, null), 2);
                        break;
                    }
                }
                break;
        }
    }
}
