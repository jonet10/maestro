package t4;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c1 implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9671a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f9672b;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f9673l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f9674m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f9675n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f9676o;

    public /* synthetic */ c1(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, int i) {
        this.f9671a = i;
        this.f9672b = relativeLayout;
        this.f9673l = imageView;
        this.f9674m = imageView2;
        this.f9675n = textView;
        this.f9676o = textView2;
    }

    public static c1 a(View view) {
        int i = 2131362344;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, 2131362344);
        if (imageView != null) {
            i = 2131362351;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, 2131362351);
            if (imageView2 != null) {
                i = 2131362672;
                if (((LinearLayout) ViewBindings.findChildViewById(view, 2131362672)) != null) {
                    i = 2131363950;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, 2131363950);
                    if (textView != null) {
                        i = 2131364061;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, 2131364061);
                        if (textView2 != null) {
                            return new c1((RelativeLayout) view, imageView, imageView2, textView, textView2, 1);
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        switch (this.f9671a) {
        }
        return this.f9672b;
    }
}
