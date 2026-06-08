package t4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10124a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f10125b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f10126l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f10127m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f10128n;

    /* renamed from: o, reason: collision with root package name */
    public final View f10129o;

    public t0(RelativeLayout relativeLayout, View view, TextView textView, TextView textView2, TextView textView3) {
        this.f10125b = relativeLayout;
        this.f10129o = view;
        this.f10126l = textView;
        this.f10127m = textView2;
        this.f10128n = textView3;
    }

    public static t0 a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(2131558809, (ViewGroup) null, false);
        int i = 2131361960;
        View findChildViewById = ViewBindings.findChildViewById(inflate, 2131361960);
        if (findChildViewById != null) {
            i = 2131363630;
            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363630);
            if (textView != null) {
                i = 2131364583;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364583);
                if (textView2 != null) {
                    i = 2131364585;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364585);
                    if (textView3 != null) {
                        return new t0((RelativeLayout) inflate, findChildViewById, textView, textView2, textView3);
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        switch (this.f10124a) {
        }
        return this.f10125b;
    }

    public t0(RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, View view) {
        this.f10125b = relativeLayout;
        this.f10126l = textView;
        this.f10127m = textView2;
        this.f10128n = textView3;
        this.f10129o = view;
    }
}
