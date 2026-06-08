package e4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l extends m5.e {

    /* renamed from: b, reason: collision with root package name */
    public final w4.c f4591b;

    /* renamed from: l, reason: collision with root package name */
    public final w4.a f4592l;

    /* renamed from: m, reason: collision with root package name */
    public final ImageView f4593m;

    /* renamed from: n, reason: collision with root package name */
    public final ProgressBar f4594n;

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f4595o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f4596p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f4597q;

    /* renamed from: r, reason: collision with root package name */
    public final TextView f4598r;

    /* renamed from: s, reason: collision with root package name */
    public final TextView f4599s;

    /* renamed from: t, reason: collision with root package name */
    public final LinearLayout f4600t;

    /* renamed from: u, reason: collision with root package name */
    public final TextView f4601u;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public l(android.view.View r5, w4.c r6, w4.a r7) {
        /*
            r4 = this;
            r6.getClass()
            r7.getClass()
            android.content.Context r0 = r5.getContext()
            r0.getClass()
            r4.<init>(r5, r0)
            r4.f4591b = r6
            r4.f4592l = r7
            r6 = 2131362371(0x7f0a0243, float:1.834452E38)
            android.view.View r6 = r5.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r4.f4593m = r6
            r6 = 2131363015(0x7f0a04c7, float:1.8345827E38)
            android.view.View r6 = r5.findViewById(r6)
            r6.getClass()
            android.widget.ProgressBar r6 = (android.widget.ProgressBar) r6
            r4.f4594n = r6
            r6 = 2131362427(0x7f0a027b, float:1.8344634E38)
            android.view.View r6 = r5.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r4.f4595o = r6
            r6 = 2131364049(0x7f0a08d1, float:1.8347924E38)
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            r4.f4596p = r6
            r7 = 2131364109(0x7f0a090d, float:1.8348046E38)
            android.view.View r7 = r5.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r4.f4597q = r7
            r0 = 2131363775(0x7f0a07bf, float:1.8347368E38)
            android.view.View r0 = r5.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r4.f4598r = r0
            r1 = 2131364196(0x7f0a0964, float:1.8348222E38)
            android.view.View r1 = r5.findViewById(r1)
            r1.getClass()
            android.widget.TextView r1 = (android.widget.TextView) r1
            r4.f4599s = r1
            r2 = 2131364553(0x7f0a0ac9, float:1.8348946E38)
            android.view.View r2 = r5.findViewById(r2)
            r2.getClass()
            android.widget.TextView r2 = (android.widget.TextView) r2
            r3 = 2131362717(0x7f0a039d, float:1.8345222E38)
            android.view.View r3 = r5.findViewById(r3)
            r3.getClass()
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r4.f4600t = r3
            r3 = 2131364338(0x7f0a09f2, float:1.834851E38)
            android.view.View r5 = r5.findViewById(r3)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r4.f4601u = r5
            android.graphics.Typeface r5 = f4.c.f4882w
            r6.setTypeface(r5)
            android.graphics.Typeface r5 = f4.c.f4882w
            r7.setTypeface(r5)
            android.graphics.Typeface r5 = f4.c.f4883x
            r0.setTypeface(r5)
            android.graphics.Typeface r5 = f4.c.f4883x
            r1.setTypeface(r5)
            android.graphics.Typeface r5 = f4.c.f4883x
            r2.setTypeface(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.l.<init>(android.view.View, w4.c, w4.a):void");
    }

    public final void g(x4.g gVar, int i, int i6, boolean z9) {
        int dimension = (int) this.itemView.getContext().getResources().getDimension(2131166251);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (z9) {
            layoutParams.setMargins(dimension, 0, dimension, dimension);
        } else {
            layoutParams.setMargins(dimension, 0, 0, dimension);
        }
        ImageView imageView = this.f4593m;
        ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
        layoutParams2.getClass();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        if (i == 1) {
            marginLayoutParams.setMarginStart((int) this.itemView.getContext().getResources().getDimension(2131166251));
        }
        imageView.setLayoutParams(marginLayoutParams);
        this.itemView.setLayoutParams(layoutParams);
        this.f4597q.setText(String.valueOf(i));
        String e10 = gVar.e();
        if (e10 == null || e10.length() == 0) {
            androidx.lifecycle.l.A(this.itemView, 2131231216, imageView);
        } else {
            a4.l0 e11 = a4.g0.d().e(gVar.f());
            float f = UptodownApp.I;
            Context context = this.itemView.getContext();
            context.getClass();
            e11.h(b4.d.w(context));
            a4.k0 k0Var = e11.f135b;
            k0Var.f = true;
            k0Var.g = 17;
            e11.f136c = true;
            Context context2 = imageView.getContext();
            context2.getClass();
            e11.g(b4.d.f(context2));
            e11.e(imageView, null);
        }
        View view = this.itemView;
        view.getClass();
        m5.e.b(view, this.f4591b, gVar);
        this.itemView.setOnLongClickListener(new d4.d(this, gVar, i6, 3));
        TextView textView = this.f4596p;
        textView.getClass();
        TextView textView2 = this.f4598r;
        textView2.getClass();
        m5.e.f(gVar, textView, textView2);
        ImageView imageView2 = this.f4595o;
        imageView2.getClass();
        e(imageView2, gVar.i());
        c(gVar, this.f4594n, imageView2, textView2, this.f4599s, this.f4601u, this.f4600t);
    }
}
