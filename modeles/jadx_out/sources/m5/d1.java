package m5;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d1 extends e {

    /* renamed from: b, reason: collision with root package name */
    public final w4.c f7355b;

    /* renamed from: l, reason: collision with root package name */
    public final w4.d f7356l;

    /* renamed from: m, reason: collision with root package name */
    public final w4.a f7357m;

    /* renamed from: n, reason: collision with root package name */
    public final RelativeLayout f7358n;

    /* renamed from: o, reason: collision with root package name */
    public final ImageView f7359o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f7360p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f7361q;

    /* renamed from: r, reason: collision with root package name */
    public final TextView f7362r;

    /* renamed from: s, reason: collision with root package name */
    public final TextView f7363s;

    /* renamed from: t, reason: collision with root package name */
    public final TextView f7364t;

    /* renamed from: u, reason: collision with root package name */
    public final TextView f7365u;
    public final LinearLayout v;

    /* renamed from: w, reason: collision with root package name */
    public final LinearLayout f7366w;

    /* renamed from: x, reason: collision with root package name */
    public final ProgressBar f7367x;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d1(android.view.View r7, w4.c r8, w4.d r9, w4.a r10) {
        /*
            r6 = this;
            r8.getClass()
            r9.getClass()
            r10.getClass()
            android.content.Context r0 = r7.getContext()
            r0.getClass()
            r6.<init>(r7, r0)
            r6.f7355b = r8
            r6.f7356l = r9
            r6.f7357m = r10
            r8 = 2131363114(0x7f0a052a, float:1.8346028E38)
            android.view.View r8 = r7.findViewById(r8)
            r8.getClass()
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            r6.f7358n = r8
            r8 = 2131362418(0x7f0a0272, float:1.8344616E38)
            android.view.View r8 = r7.findViewById(r8)
            r8.getClass()
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r6.f7359o = r8
            r8 = 2131364033(0x7f0a08c1, float:1.8347892E38)
            android.view.View r8 = r7.findViewById(r8)
            r8.getClass()
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6.f7360p = r8
            r9 = 2131364106(0x7f0a090a, float:1.834804E38)
            android.view.View r9 = r7.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r6.f7361q = r9
            r10 = 2131363766(0x7f0a07b6, float:1.834735E38)
            android.view.View r10 = r7.findViewById(r10)
            r10.getClass()
            android.widget.TextView r10 = (android.widget.TextView) r10
            r6.f7362r = r10
            r0 = 2131363616(0x7f0a0720, float:1.8347046E38)
            android.view.View r0 = r7.findViewById(r0)
            r0.getClass()
            android.widget.TextView r0 = (android.widget.TextView) r0
            r6.f7363s = r0
            r1 = 2131364538(0x7f0a0aba, float:1.8348916E38)
            android.view.View r1 = r7.findViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r6.f7364t = r1
            r2 = 2131363840(0x7f0a0800, float:1.83475E38)
            android.view.View r2 = r7.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r6.f7365u = r2
            r3 = 2131362668(0x7f0a036c, float:1.8345123E38)
            android.view.View r3 = r7.findViewById(r3)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r6.v = r3
            r3 = 2131362646(0x7f0a0356, float:1.8345078E38)
            android.view.View r3 = r7.findViewById(r3)
            r3.getClass()
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            r6.f7366w = r3
            r3 = 2131364189(0x7f0a095d, float:1.8348208E38)
            android.view.View r3 = r7.findViewById(r3)
            r3.getClass()
            android.widget.TextView r3 = (android.widget.TextView) r3
            r4 = 2131363008(0x7f0a04c0, float:1.8345813E38)
            android.view.View r4 = r7.findViewById(r4)
            r4.getClass()
            android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
            r6.f7367x = r4
            r4 = 2131364544(0x7f0a0ac0, float:1.8348928E38)
            android.view.View r4 = r7.findViewById(r4)
            r4.getClass()
            android.widget.TextView r4 = (android.widget.TextView) r4
            r5 = 2131363675(0x7f0a075b, float:1.8347166E38)
            android.view.View r7 = r7.findViewById(r5)
            android.widget.TextView r7 = (android.widget.TextView) r7
            android.graphics.Typeface r5 = f4.c.f4882w
            r8.setTypeface(r5)
            if (r9 == 0) goto Ld4
            android.graphics.Typeface r8 = f4.c.f4882w
            r9.setTypeface(r8)
        Ld4:
            if (r1 == 0) goto Ldb
            android.graphics.Typeface r8 = f4.c.f4883x
            r1.setTypeface(r8)
        Ldb:
            if (r2 == 0) goto Le2
            android.graphics.Typeface r8 = f4.c.f4883x
            r2.setTypeface(r8)
        Le2:
            android.graphics.Typeface r8 = f4.c.f4883x
            r10.setTypeface(r8)
            android.graphics.Typeface r8 = f4.c.f4882w
            r0.setTypeface(r8)
            android.graphics.Typeface r8 = f4.c.f4883x
            r4.setTypeface(r8)
            android.graphics.Typeface r8 = f4.c.f4883x
            r3.setTypeface(r8)
            if (r7 == 0) goto Lfd
            android.graphics.Typeface r8 = f4.c.f4883x
            r7.setTypeface(r8)
        Lfd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.d1.<init>(android.view.View, w4.c, w4.d, w4.a):void");
    }
}
