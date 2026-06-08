package t4;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f9772a;

    /* renamed from: b, reason: collision with root package name */
    public final View f9773b;

    /* renamed from: l, reason: collision with root package name */
    public final RecyclerView f9774l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f9775m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f9776n;

    public f(FrameLayout frameLayout, View view, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.f9772a = frameLayout;
        this.f9773b = view;
        this.f9774l = recyclerView;
        this.f9775m = textView;
        this.f9776n = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f9772a;
    }
}
