package t4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10059a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f10060b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f10061l;

    public /* synthetic */ q(LinearLayout linearLayout, TextView textView, int i) {
        this.f10059a = i;
        this.f10060b = linearLayout;
        this.f10061l = textView;
    }

    public static q a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(2131558769, (ViewGroup) null, false);
        TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131364053);
        if (textView != null) {
            return new q((LinearLayout) inflate, textView, 1);
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(2131364053)));
        return null;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        switch (this.f10059a) {
        }
        return this.f10060b;
    }
}
