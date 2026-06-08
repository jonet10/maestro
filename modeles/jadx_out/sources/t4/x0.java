package t4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f10228a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f10229b;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f10230l;

    /* renamed from: m, reason: collision with root package name */
    public final View f10231m;

    /* renamed from: n, reason: collision with root package name */
    public final RecyclerView f10232n;

    /* renamed from: o, reason: collision with root package name */
    public final Toolbar f10233o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f10234p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f10235q;

    /* renamed from: r, reason: collision with root package name */
    public final TextView f10236r;

    public x0(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, View view, RecyclerView recyclerView, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.f10228a = relativeLayout;
        this.f10229b = imageView;
        this.f10230l = imageView2;
        this.f10231m = view;
        this.f10232n = recyclerView;
        this.f10233o = toolbar;
        this.f10234p = textView;
        this.f10235q = textView2;
        this.f10236r = textView3;
    }

    public static x0 a(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(2131558828, (ViewGroup) null, false);
        int i = 2131362353;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362353);
        if (imageView != null) {
            i = 2131362474;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362474);
            if (imageView2 != null) {
                i = 2131362817;
                View findChildViewById = ViewBindings.findChildViewById(inflate, 2131362817);
                if (findChildViewById != null) {
                    i = 2131363085;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(inflate, 2131363085);
                    if (recyclerView != null) {
                        i = 2131363567;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(inflate, 2131363567);
                        if (toolbar != null) {
                            i = 2131364082;
                            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131364082);
                            if (textView != null) {
                                i = 2131364221;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364221);
                                if (textView2 != null) {
                                    i = 2131364453;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364453);
                                    if (textView3 != null) {
                                        return new x0((RelativeLayout) inflate, imageView, imageView2, findChildViewById, recyclerView, toolbar, textView, textView2, textView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f10228a;
    }
}
