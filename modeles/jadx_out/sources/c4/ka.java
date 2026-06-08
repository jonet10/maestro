package c4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBindings;
import com.uptodown.activities.Updates;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class ka implements d7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1798a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Updates f1799b;

    public /* synthetic */ ka(Updates updates, int i) {
        this.f1798a = i;
        this.f1799b = updates;
    }

    @Override // d7.a
    public final Object invoke() {
        int i = this.f1798a;
        Updates updates = this.f1799b;
        switch (i) {
            case 0:
                int i6 = Updates.n0;
                View inflate = updates.getLayoutInflater().inflate(2131558856, (ViewGroup) null, false);
                int i10 = 2131362819;
                View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362819);
                if (findChildViewById != null) {
                    i10 = 2131363023;
                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(inflate, 2131363023);
                    if (progressBar != null) {
                        i10 = 2131363128;
                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363128);
                        if (relativeLayout != null) {
                            i10 = 2131363129;
                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363129);
                            if (relativeLayout2 != null) {
                                i10 = 2131363278;
                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363278);
                                if (relativeLayout3 != null) {
                                    i10 = 2131363358;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(inflate, 2131363358);
                                    if (recyclerView != null) {
                                        i10 = 2131363454;
                                        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(inflate, 2131363454);
                                        if (swipeRefreshLayout != null) {
                                            i10 = 2131363570;
                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate, 2131363570);
                                            if (toolbar != null) {
                                                i10 = 2131363704;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363704);
                                                if (textView != null) {
                                                    i10 = 2131363796;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363796);
                                                    if (textView2 != null) {
                                                        i10 = 2131363908;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131363908);
                                                        if (textView3 != null) {
                                                            i10 = 2131364454;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364454);
                                                            if (textView4 != null) {
                                                                return new t4.y0((RelativeLayout) inflate, findChildViewById, progressBar, relativeLayout, relativeLayout2, relativeLayout3, recyclerView, swipeRefreshLayout, toolbar, textView, textView2, textView3, textView4);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
                return null;
            default:
                updates.f3358e0 = true;
                updates.Y0();
                return p6.x.f8463a;
        }
    }
}
