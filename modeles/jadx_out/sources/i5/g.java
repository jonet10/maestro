package i5;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends Presenter.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final RelativeLayout f5687a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f5688b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f5689l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f5690m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f5691n;

    /* renamed from: o, reason: collision with root package name */
    public final ProgressBar f5692o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f5693p;

    public g(View view) {
        super(view);
        View findViewById = view.findViewById(2131363274);
        findViewById.getClass();
        this.f5687a = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(2131362394);
        findViewById2.getClass();
        this.f5688b = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(2131364063);
        findViewById3.getClass();
        TextView textView = (TextView) findViewById3;
        this.f5689l = textView;
        View findViewById4 = view.findViewById(2131364316);
        findViewById4.getClass();
        TextView textView2 = (TextView) findViewById4;
        this.f5690m = textView2;
        View findViewById5 = view.findViewById(2131364556);
        findViewById5.getClass();
        TextView textView3 = (TextView) findViewById5;
        this.f5691n = textView3;
        View findViewById6 = view.findViewById(2131363052);
        findViewById6.getClass();
        this.f5692o = (ProgressBar) findViewById6;
        View findViewById7 = view.findViewById(2131363622);
        findViewById7.getClass();
        TextView textView4 = (TextView) findViewById7;
        this.f5693p = textView4;
        textView.setTypeface(f4.c.f4883x);
        textView2.setTypeface(f4.c.f4883x);
        textView3.setTypeface(f4.c.f4883x);
        textView4.setTypeface(f4.c.f4883x);
    }
}
