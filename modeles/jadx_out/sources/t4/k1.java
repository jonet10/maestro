package t4;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k1 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f9948a;

    /* renamed from: b, reason: collision with root package name */
    public final View f9949b;

    /* renamed from: l, reason: collision with root package name */
    public final RecyclerView f9950l;

    /* renamed from: m, reason: collision with root package name */
    public final Toolbar f9951m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f9952n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f9953o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f9954p;

    public k1(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.f9948a = relativeLayout;
        this.f9949b = view;
        this.f9950l = recyclerView;
        this.f9951m = toolbar;
        this.f9952n = textView;
        this.f9953o = textView2;
        this.f9954p = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f9948a;
    }
}
