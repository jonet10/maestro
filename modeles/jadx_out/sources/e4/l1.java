package e4;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l1 extends m5.e {
    public final /* synthetic */ m1 A;

    /* renamed from: b, reason: collision with root package name */
    public final w4.j f4606b;

    /* renamed from: l, reason: collision with root package name */
    public final w4.a f4607l;

    /* renamed from: m, reason: collision with root package name */
    public final Context f4608m;

    /* renamed from: n, reason: collision with root package name */
    public final String f4609n;

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f4610o;

    /* renamed from: p, reason: collision with root package name */
    public final RelativeLayout f4611p;

    /* renamed from: q, reason: collision with root package name */
    public final ProgressBar f4612q;

    /* renamed from: r, reason: collision with root package name */
    public final ImageView f4613r;

    /* renamed from: s, reason: collision with root package name */
    public final TextView f4614s;

    /* renamed from: t, reason: collision with root package name */
    public final TextView f4615t;

    /* renamed from: u, reason: collision with root package name */
    public final TextView f4616u;
    public final TextView v;

    /* renamed from: w, reason: collision with root package name */
    public final LinearLayout f4617w;

    /* renamed from: x, reason: collision with root package name */
    public final CardView f4618x;

    /* renamed from: y, reason: collision with root package name */
    public final View f4619y;

    /* renamed from: z, reason: collision with root package name */
    public final int f4620z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(m1 m1Var, View view, w4.j jVar, w4.a aVar, Context context, String str) {
        super(view, context);
        jVar.getClass();
        aVar.getClass();
        context.getClass();
        str.getClass();
        this.A = m1Var;
        this.f4606b = jVar;
        this.f4607l = aVar;
        this.f4608m = context;
        this.f4609n = str;
        View findViewById = view.findViewById(2131362395);
        findViewById.getClass();
        this.f4610o = (ImageView) findViewById;
        View findViewById2 = view.findViewById(2131363293);
        findViewById2.getClass();
        this.f4611p = (RelativeLayout) findViewById2;
        View findViewById3 = view.findViewById(2131363021);
        findViewById3.getClass();
        this.f4612q = (ProgressBar) findViewById3;
        View findViewById4 = view.findViewById(2131362431);
        findViewById4.getClass();
        this.f4613r = (ImageView) findViewById4;
        View findViewById5 = view.findViewById(2131364064);
        findViewById5.getClass();
        TextView textView = (TextView) findViewById5;
        this.f4614s = textView;
        View findViewById6 = view.findViewById(2131363781);
        findViewById6.getClass();
        TextView textView2 = (TextView) findViewById6;
        this.f4615t = textView2;
        View findViewById7 = view.findViewById(2131364341);
        findViewById7.getClass();
        this.f4616u = (TextView) findViewById7;
        View findViewById8 = view.findViewById(2131364198);
        findViewById8.getClass();
        TextView textView3 = (TextView) findViewById8;
        this.v = textView3;
        View findViewById9 = view.findViewById(2131364555);
        findViewById9.getClass();
        View findViewById10 = view.findViewById(2131362719);
        findViewById10.getClass();
        this.f4617w = (LinearLayout) findViewById10;
        View findViewById11 = view.findViewById(2131362072);
        findViewById11.getClass();
        this.f4618x = (CardView) findViewById11;
        View findViewById12 = view.findViewById(2131364635);
        findViewById12.getClass();
        this.f4619y = findViewById12;
        this.f4620z = UptodownApp.Y;
        textView.setTypeface(f4.c.f4882w);
        textView2.setTypeface(f4.c.f4883x);
        textView3.setTypeface(f4.c.f4883x);
        ((TextView) findViewById9).setTypeface(f4.c.f4883x);
    }

    public static void h(ImageView imageView, x4.g gVar) {
        n5.g gVar2 = new n5.g((int) imageView.getContext().getResources().getDimension(2131165268));
        String e10 = gVar.e();
        if (e10 == null || e10.length() == 0) {
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), 2131231216));
            return;
        }
        if (UptodownApp.U <= 0) {
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            a4.l0 e11 = a4.g0.d().e(gVar.d());
            e11.f136c = true;
            e11.h(gVar2);
            e11.e(imageView, null);
            return;
        }
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, UptodownApp.U));
        a4.l0 e12 = a4.g0.d().e(gVar.d());
        e12.f135b.e(UptodownApp.V, UptodownApp.U);
        e12.h(gVar2);
        e12.e(imageView, null);
    }

    public final void g(x4.g gVar, int i) {
        this.f4618x.setVisibility(8);
        this.f4619y.setVisibility(8);
        ImageView imageView = this.f4610o;
        imageView.setVisibility(0);
        m5.e.f(gVar, this.f4614s, this.f4615t);
        RelativeLayout relativeLayout = this.f4611p;
        w4.j jVar = this.f4606b;
        m5.e.b(relativeLayout, jVar, gVar);
        h(imageView, gVar);
        e(this.f4613r, gVar.i());
        c(gVar, this.f4612q, this.f4613r, this.f4615t, this.v, this.f4616u, this.f4617w);
        relativeLayout.setOnLongClickListener(new k1(this, gVar, i, 1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f4620z, -1);
        View view = this.itemView;
        m5.e.a(layoutParams, this.f4608m, i, this.A.f4637o);
        view.setLayoutParams(layoutParams);
        m5.e.b(imageView, jVar, gVar);
    }
}
