package t4;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f9667a;

    /* renamed from: b, reason: collision with root package name */
    public final View f9668b;

    /* renamed from: l, reason: collision with root package name */
    public final RecyclerView f9669l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f9670m;

    public c0(RelativeLayout relativeLayout, View view, RecyclerView recyclerView, TextView textView) {
        this.f9667a = relativeLayout;
        this.f9668b = view;
        this.f9669l = recyclerView;
        this.f9670m = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f9667a;
    }
}
