package t4;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f10008a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f10009b;

    /* renamed from: l, reason: collision with root package name */
    public final RelativeLayout f10010l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f10011m;

    /* renamed from: n, reason: collision with root package name */
    public final ViewPager2 f10012n;

    public n(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView, ViewPager2 viewPager2) {
        this.f10008a = relativeLayout;
        this.f10009b = imageView;
        this.f10010l = relativeLayout2;
        this.f10011m = textView;
        this.f10012n = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f10008a;
    }
}
