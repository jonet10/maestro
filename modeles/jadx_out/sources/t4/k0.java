package t4;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f9942a;

    /* renamed from: b, reason: collision with root package name */
    public final View f9943b;

    /* renamed from: l, reason: collision with root package name */
    public final RecyclerView f9944l;

    /* renamed from: m, reason: collision with root package name */
    public final Toolbar f9945m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f9946n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f9947o;

    public k0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2) {
        this.f9942a = relativeLayout;
        this.f9943b = view;
        this.f9944l = recyclerView;
        this.f9945m = toolbar;
        this.f9946n = textView;
        this.f9947o = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f9942a;
    }
}
