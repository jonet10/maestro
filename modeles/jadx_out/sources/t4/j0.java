package t4;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f9902a;

    /* renamed from: b, reason: collision with root package name */
    public final FrameLayout f9903b;

    /* renamed from: l, reason: collision with root package name */
    public final View f9904l;

    /* renamed from: m, reason: collision with root package name */
    public final RecyclerView f9905m;

    /* renamed from: n, reason: collision with root package name */
    public final Toolbar f9906n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f9907o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f9908p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f9909q;

    public j0(RelativeLayout relativeLayout, FrameLayout frameLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.f9902a = relativeLayout;
        this.f9903b = frameLayout;
        this.f9904l = view;
        this.f9905m = recyclerView;
        this.f9906n = toolbar;
        this.f9907o = textView;
        this.f9908p = textView2;
        this.f9909q = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f9902a;
    }
}
