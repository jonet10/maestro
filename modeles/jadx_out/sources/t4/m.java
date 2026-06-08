package t4;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f9993a;

    /* renamed from: b, reason: collision with root package name */
    public final g4.v f9994b;

    /* renamed from: l, reason: collision with root package name */
    public final View f9995l;

    /* renamed from: m, reason: collision with root package name */
    public final RecyclerView f9996m;

    /* renamed from: n, reason: collision with root package name */
    public final Toolbar f9997n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f9998o;

    public m(RelativeLayout relativeLayout, g4.v vVar, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView) {
        this.f9993a = relativeLayout;
        this.f9994b = vVar;
        this.f9995l = view;
        this.f9996m = recyclerView;
        this.f9997n = toolbar;
        this.f9998o = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f9993a;
    }
}
