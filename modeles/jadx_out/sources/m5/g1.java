package m5;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g1 extends e {

    /* renamed from: b, reason: collision with root package name */
    public final w4.c f7398b;

    /* renamed from: l, reason: collision with root package name */
    public final w4.a f7399l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f7400m;

    /* renamed from: n, reason: collision with root package name */
    public final RelativeLayout f7401n;

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f7402o;

    /* renamed from: p, reason: collision with root package name */
    public final ProgressBar f7403p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f7404q;

    /* renamed from: r, reason: collision with root package name */
    public final TextView f7405r;

    /* renamed from: s, reason: collision with root package name */
    public final TextView f7406s;

    /* renamed from: t, reason: collision with root package name */
    public final TextView f7407t;

    /* renamed from: u, reason: collision with root package name */
    public final TextView f7408u;
    public final LinearLayout v;

    /* renamed from: w, reason: collision with root package name */
    public final ImageView f7409w;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g1(android.view.View r5, w4.c r6, w4.a r7, boolean r8) {
        /*
            r4 = this;
            r6.getClass()
            android.content.Context r0 = r5.getContext()
            r0.getClass()
            r4.<init>(r5, r0)
            r4.f7398b = r6
            r4.f7399l = r7
            r4.f7400m = r8
            r6 = 2131363115(0x7f0a052b, float:1.834603E38)
            android.view.View r6 = r5.findViewById(r6)
            r6.getClass()
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            r4.f7401n = r6
            r6 = 2131362419(0x7f0a0273, float:1.8344618E38)
            android.view.View r6 = r5.findViewById(r6)
            r6.getClass()
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            r4.f7402o = r6
            r6 = 2131363009(0x7f0a04c1, float:1.8345815E38)
            android.view.View r6 = r5.findViewById(r6)
            r6.getClass()
            android.widget.ProgressBar r6 = (android.widget.ProgressBar) r6
            r4.f7403p = r6
            r6 = 2131364034(0x7f0a08c2, float:1.8347894E38)
            android.view.View r6 = r5.findViewById(r6)
            r6.getClass()
            android.widget.TextView r6 = (android.widget.TextView) r6
            r4.f7404q = r6
            r7 = 2131364107(0x7f0a090b, float:1.8348042E38)
            android.view.View r7 = r5.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r4.f7405r = r7
            r8 = 2131363767(0x7f0a07b7, float:1.8347352E38)
            android.view.View r8 = r5.findViewById(r8)
            r8.getClass()
            android.widget.TextView r8 = (android.widget.TextView) r8
            r4.f7406s = r8
            r0 = 2131364331(0x7f0a09eb, float:1.8348496E38)
            android.view.View r0 = r5.findViewById(r0)
            r0.getClass()
            android.widget.TextView r0 = (android.widget.TextView) r0
            r4.f7407t = r0
            r1 = 2131364190(0x7f0a095e, float:1.834821E38)
            android.view.View r1 = r5.findViewById(r1)
            r1.getClass()
            android.widget.TextView r1 = (android.widget.TextView) r1
            r4.f7408u = r1
            r2 = 2131364545(0x7f0a0ac1, float:1.834893E38)
            android.view.View r2 = r5.findViewById(r2)
            r2.getClass()
            android.widget.TextView r2 = (android.widget.TextView) r2
            r3 = 2131362712(0x7f0a0398, float:1.8345212E38)
            android.view.View r3 = r5.findViewById(r3)
            r3.getClass()
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r4.v = r3
            r3 = 2131362290(0x7f0a01f2, float:1.8344356E38)
            android.view.View r5 = r5.findViewById(r3)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r4.f7409w = r5
            android.graphics.Typeface r5 = f4.c.f4882w
            r6.setTypeface(r5)
            if (r7 == 0) goto Lb1
            android.graphics.Typeface r5 = f4.c.f4882w
            r7.setTypeface(r5)
        Lb1:
            android.graphics.Typeface r5 = f4.c.f4883x
            r8.setTypeface(r5)
            android.graphics.Typeface r5 = f4.c.f4883x
            r0.setTypeface(r5)
            android.graphics.Typeface r5 = f4.c.f4883x
            r1.setTypeface(r5)
            android.graphics.Typeface r5 = f4.c.f4883x
            r2.setTypeface(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.g1.<init>(android.view.View, w4.c, w4.a, boolean):void");
    }

    public final void g(x4.g gVar, int i) {
        gVar.getClass();
        w4.c cVar = this.f7398b;
        RelativeLayout relativeLayout = this.f7401n;
        e.b(relativeLayout, cVar, gVar);
        relativeLayout.setOnLongClickListener(new d4.d(this, gVar, i, 10));
        TextView textView = this.f7405r;
        if (i > 0) {
            if (textView != null) {
                textView.setText(this.itemView.getContext().getResources().getString(2131952659, String.valueOf(i)));
            }
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else if (textView != null) {
            textView.setVisibility(8);
        }
        ImageView imageView = this.f7409w;
        if (imageView != null) {
            imageView.setVisibility(this.f7400m ? 0 : 8);
        }
        if (imageView != null) {
            imageView.setOnClickListener(new g4.b0(this, gVar, i));
        }
        e.f(gVar, this.f7404q, this.f7406s);
        e(this.f7402o, gVar.i());
        c(gVar, this.f7403p, this.f7402o, this.f7406s, this.f7408u, this.f7407t, this.v);
    }
}
