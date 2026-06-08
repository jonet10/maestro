package e4;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u extends m5.e {

    /* renamed from: b, reason: collision with root package name */
    public final g4.v f4699b;

    /* renamed from: l, reason: collision with root package name */
    public final w4.c f4700l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ v f4701m;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public u(e4.v r1, g4.v r2, w4.c r3, android.content.Context r4) {
        /*
            r0 = this;
            r3.getClass()
            r4.getClass()
            r0.f4701m = r1
            java.lang.Object r1 = r2.f5278n
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            r1.getClass()
            r0.<init>(r1, r4)
            r0.f4699b = r2
            r0.f4700l = r3
            java.lang.Object r1 = r2.f5276l
            android.widget.TextView r1 = (android.widget.TextView) r1
            android.graphics.Typeface r3 = f4.c.f4882w
            r1.setTypeface(r3)
            java.lang.Object r1 = r2.f5275b
            android.widget.TextView r1 = (android.widget.TextView) r1
            android.graphics.Typeface r3 = f4.c.f4883x
            r1.setTypeface(r3)
            java.lang.Object r1 = r2.f5277m
            android.widget.TextView r1 = (android.widget.TextView) r1
            android.graphics.Typeface r2 = f4.c.f4883x
            r1.setTypeface(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.u.<init>(e4.v, g4.v, w4.c, android.content.Context):void");
    }

    public final void g(x4.g gVar, boolean z9) {
        Context context = this.f4701m.f4706b;
        int dimension = (int) context.getResources().getDimension(2131166251);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (z9) {
            layoutParams.setMargins(dimension, 0, dimension, dimension);
        } else {
            layoutParams.setMargins(dimension, 0, 0, dimension);
        }
        this.itemView.setLayoutParams(layoutParams);
        String e10 = gVar.e();
        g4.v vVar = this.f4699b;
        if (e10 != null && e10.length() != 0) {
            a4.l0 e11 = a4.g0.d().e(gVar.f());
            float f = UptodownApp.I;
            e11.h(b4.d.w(context));
            a4.k0 k0Var = e11.f135b;
            k0Var.f = true;
            k0Var.g = 17;
            e11.f136c = true;
            e11.g(b4.d.f(context));
            e11.e((ImageView) vVar.f5279o, null);
        }
        View view = this.itemView;
        view.getClass();
        m5.e.b(view, this.f4700l, gVar);
        TextView textView = (TextView) vVar.f5276l;
        TextView textView2 = (TextView) vVar.f5275b;
        m5.e.f(gVar, textView, textView2);
        d(gVar.F, (TextView) vVar.f5277m, textView2);
        e((ImageView) vVar.f5280p, gVar.i());
    }
}
