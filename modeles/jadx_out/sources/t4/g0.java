package t4;

import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f9816a;

    /* renamed from: b, reason: collision with root package name */
    public final EditText f9817b;

    /* renamed from: l, reason: collision with root package name */
    public final EditText f9818l;

    /* renamed from: m, reason: collision with root package name */
    public final View f9819m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f9820n;

    public g0(RelativeLayout relativeLayout, EditText editText, EditText editText2, View view, TextView textView) {
        this.f9816a = relativeLayout;
        this.f9817b = editText;
        this.f9818l = editText2;
        this.f9819m = view;
        this.f9820n = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f9816a;
    }
}
