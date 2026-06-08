package t4;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f10237a;

    /* renamed from: b, reason: collision with root package name */
    public final View f10238b;

    /* renamed from: l, reason: collision with root package name */
    public final g4.v f10239l;

    /* renamed from: m, reason: collision with root package name */
    public final NestedScrollView f10240m;

    /* renamed from: n, reason: collision with root package name */
    public final RecyclerView f10241n;

    /* renamed from: o, reason: collision with root package name */
    public final SearchView f10242o;

    /* renamed from: p, reason: collision with root package name */
    public final Toolbar f10243p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f10244q;

    public y(RelativeLayout relativeLayout, View view, g4.v vVar, NestedScrollView nestedScrollView, RecyclerView recyclerView, SearchView searchView, Toolbar toolbar, TextView textView) {
        this.f10237a = relativeLayout;
        this.f10238b = view;
        this.f10239l = vVar;
        this.f10240m = nestedScrollView;
        this.f10241n = recyclerView;
        this.f10242o = searchView;
        this.f10243p = toolbar;
        this.f10244q = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f10237a;
    }
}
