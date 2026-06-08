package t4;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f10037a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f10038b;

    /* renamed from: l, reason: collision with root package name */
    public final View f10039l;

    /* renamed from: m, reason: collision with root package name */
    public final RecyclerView f10040m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f10041n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f10042o;

    public p(FrameLayout frameLayout, LinearLayout linearLayout, View view, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f10037a = frameLayout;
        this.f10038b = linearLayout;
        this.f10039l = view;
        this.f10040m = recyclerView;
        this.f10041n = textView;
        this.f10042o = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f10037a;
    }
}
