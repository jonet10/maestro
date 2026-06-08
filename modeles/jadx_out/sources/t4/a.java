package t4;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f9567a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f9568b;

    /* renamed from: l, reason: collision with root package name */
    public final Toolbar f9569l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f9570m;

    public a(LinearLayout linearLayout, LinearLayout linearLayout2, Toolbar toolbar, TextView textView) {
        this.f9567a = linearLayout;
        this.f9568b = linearLayout2;
        this.f9569l = toolbar;
        this.f9570m = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f9567a;
    }
}
