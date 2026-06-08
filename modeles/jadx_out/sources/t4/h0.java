package t4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h0 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9840a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f9841b;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f9842l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f9843m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f9844n;

    public h0(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.f9841b = relativeLayout;
        this.f9842l = imageView;
        this.f9843m = textView;
        this.f9844n = textView2;
    }

    public static h0 a(View view) {
        int i = 2131362454;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, 2131362454);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            int i6 = 2131364172;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, 2131364172);
            if (textView != null) {
                i6 = 2131364173;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, 2131364173);
                if (textView2 != null) {
                    return new h0(relativeLayout, imageView, textView, textView2);
                }
            }
            i = i6;
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static h0 b(LayoutInflater layoutInflater) {
        return a(layoutInflater.inflate(2131558778, (ViewGroup) null, false));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        switch (this.f9840a) {
        }
        return this.f9841b;
    }

    public h0(RelativeLayout relativeLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f9841b = relativeLayout;
        this.f9842l = imageView;
        this.f9843m = textView;
        this.f9844n = textView2;
    }
}
