package m5;

import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.z3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y1 extends f {

    /* renamed from: b, reason: collision with root package name */
    public final t4.g1 f7642b;

    /* renamed from: l, reason: collision with root package name */
    public final Context f7643l;

    /* renamed from: m, reason: collision with root package name */
    public final f0.i f7644m;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public y1(t4.g1 r2, android.content.Context r3, f0.i r4) {
        /*
            r1 = this;
            r3.getClass()
            android.widget.RelativeLayout r0 = r2.f9821a
            r0.getClass()
            r1.<init>(r0)
            r1.f7642b = r2
            r1.f7643l = r3
            r1.f7644m = r4
            android.widget.RelativeLayout r3 = r2.f9829r
            m5.x1 r4 = new m5.x1
            r0 = 0
            r4.<init>(r1)
            r3.setOnClickListener(r4)
            m5.h r4 = new m5.h
            r0 = 1
            r4.<init>(r1, r0)
            r3.setOnLongClickListener(r4)
            android.widget.RelativeLayout r3 = r2.f9827p
            m5.x1 r4 = new m5.x1
            r4.<init>(r1)
            r3.setOnClickListener(r4)
            android.widget.ImageView r3 = r2.f9822b
            m5.x1 r4 = new m5.x1
            r0 = 2
            r4.<init>(r1)
            r3.setOnClickListener(r4)
            android.widget.TextView r3 = r2.f9830s
            android.graphics.Typeface r4 = f4.c.f4882w
            r3.setTypeface(r4)
            android.widget.TextView r3 = r2.f9832u
            android.graphics.Typeface r4 = f4.c.f4882w
            r3.setTypeface(r4)
            android.widget.TextView r3 = r2.f9831t
            android.graphics.Typeface r4 = f4.c.f4883x
            r3.setTypeface(r4)
            android.widget.TextView r2 = r2.v
            android.graphics.Typeface r3 = f4.c.f4883x
            r2.setTypeface(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.y1.<init>(t4.g1, android.content.Context, f0.i):void");
    }

    public final void c(String str) {
        t4.g1 g1Var = this.f7642b;
        a(g1Var.f9826o, g1Var.f9824m);
        TextView textView = g1Var.f9830s;
        z3.J(textView);
        textView.setText(str);
        g1Var.f9828q.setVisibility(8);
    }

    public final void d(x4.r rVar) {
        t4.g1 g1Var = this.f7642b;
        b(g1Var.f9826o, g1Var.f9824m);
        TextView textView = g1Var.v;
        textView.setVisibility(8);
        g1Var.f9831t.setText(this.itemView.getContext().getString(2131952467, Integer.valueOf(rVar.i()), i5.H(this.f7643l, rVar.k())));
        ProgressBar progressBar = g1Var.f9826o;
        int i = rVar.i();
        progressBar.setIndeterminate(false);
        progressBar.setProgress(i);
        g1Var.f9828q.setVisibility(0);
        g1Var.f9822b.setVisibility(0);
        textView.setVisibility(8);
        g1Var.f9830s.setVisibility(8);
    }

    public final void e() {
        t4.g1 g1Var = this.f7642b;
        b(g1Var.f9826o, g1Var.f9824m);
        g1Var.f9826o.setIndeterminate(true);
        TextView textView = g1Var.f9830s;
        Context context = this.f7643l;
        textView.setBackground(ContextCompat.getDrawable(context, 2131230859));
        textView.setTextColor(ContextCompat.getColor(context, 2131099813));
        g1Var.f9828q.setVisibility(0);
        g1Var.v.setText(context.getString(2131952095));
    }
}
