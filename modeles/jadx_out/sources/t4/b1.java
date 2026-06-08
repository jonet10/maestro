package t4;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b1 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f9645a;

    /* renamed from: b, reason: collision with root package name */
    public final View f9646b;

    /* renamed from: l, reason: collision with root package name */
    public final RecyclerView f9647l;

    /* renamed from: m, reason: collision with root package name */
    public final Toolbar f9648m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f9649n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f9650o;

    public b1(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f9645a = relativeLayout;
        this.f9646b = view;
        this.f9647l = recyclerView;
        this.f9648m = toolbar;
        this.f9649n = textView;
        this.f9650o = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f9645a;
    }
}
