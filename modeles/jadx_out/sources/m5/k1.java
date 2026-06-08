package m5;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k1 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final w4.b f7444a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f7445b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f7446l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f7447m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f7448n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f7449o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f7450p;

    public k1(View view, w4.b bVar) {
        super(view);
        this.f7444a = bVar;
        View findViewById = view.findViewById(2131362381);
        findViewById.getClass();
        this.f7445b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(2131364051);
        findViewById2.getClass();
        TextView textView = (TextView) findViewById2;
        this.f7446l = textView;
        View findViewById3 = view.findViewById(2131364567);
        findViewById3.getClass();
        TextView textView2 = (TextView) findViewById3;
        this.f7447m = textView2;
        View findViewById4 = view.findViewById(2131364306);
        findViewById4.getClass();
        TextView textView3 = (TextView) findViewById4;
        this.f7448n = textView3;
        View findViewById5 = view.findViewById(2131363946);
        findViewById5.getClass();
        TextView textView4 = (TextView) findViewById5;
        this.f7449o = textView4;
        View findViewById6 = view.findViewById(2131363859);
        findViewById6.getClass();
        TextView textView5 = (TextView) findViewById6;
        this.f7450p = textView5;
        View findViewById7 = view.findViewById(2131363204);
        findViewById7.getClass();
        textView.setTypeface(f4.c.f4882w);
        textView2.setTypeface(f4.c.f4882w);
        textView3.setTypeface(f4.c.f4883x);
        textView4.setTypeface(f4.c.f4883x);
        textView5.setTypeface(f4.c.f4882w);
        ((RelativeLayout) findViewById7).setOnClickListener(new u0(this, 1));
    }
}
