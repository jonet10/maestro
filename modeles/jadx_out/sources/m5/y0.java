package m5;

import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.z3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y0 extends e {

    /* renamed from: b, reason: collision with root package name */
    public final t4.v0 f7639b;

    /* renamed from: l, reason: collision with root package name */
    public final w4.c f7640l;

    /* renamed from: m, reason: collision with root package name */
    public final w4.d f7641m;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public y0(t4.v0 r3, w4.c r4, w4.d r5) {
        /*
            r2 = this;
            r4.getClass()
            r5.getClass()
            android.widget.RelativeLayout r0 = r3.f10159a
            r0.getClass()
            android.content.Context r1 = r0.getContext()
            r1.getClass()
            r2.<init>(r0, r1)
            r2.f7639b = r3
            r2.f7640l = r4
            r2.f7641m = r5
            android.widget.TextView r4 = r3.f10166q
            android.graphics.Typeface r5 = f4.c.f4882w
            r4.setTypeface(r5)
            android.widget.TextView r4 = r3.f10165p
            android.graphics.Typeface r5 = f4.c.f4883x
            r4.setTypeface(r5)
            android.widget.TextView r4 = r3.f10168s
            android.graphics.Typeface r5 = f4.c.f4883x
            r4.setTypeface(r5)
            android.widget.TextView r4 = r3.f10164o
            android.graphics.Typeface r5 = f4.c.f4882w
            r4.setTypeface(r5)
            android.widget.TextView r4 = r3.f10167r
            android.graphics.Typeface r5 = f4.c.f4883x
            r4.setTypeface(r5)
            android.widget.TextView r3 = r3.f10169t
            android.graphics.Typeface r4 = f4.c.f4883x
            r3.setTypeface(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.y0.<init>(t4.v0, w4.c, w4.d):void");
    }

    public final void g() {
        t4.v0 v0Var = this.f7639b;
        t0.f.s(v0Var.f10162m, v0Var.f10161l);
        v0Var.f10163n.setVisibility(8);
        v0Var.f10169t.setVisibility(8);
        v0Var.f10165p.setVisibility(0);
        v0Var.f10164o.setVisibility(0);
    }

    public final void h(String str) {
        g();
        t4.v0 v0Var = this.f7639b;
        v0Var.f10164o.setText(str);
        z3.J(v0Var.f10164o);
    }

    public final void i(int i, long j) {
        t4.v0 v0Var = this.f7639b;
        ProgressBar progressBar = v0Var.f10162m;
        ProgressBar progressBar2 = v0Var.f10162m;
        t0.f.I(progressBar, v0Var.f10161l);
        v0Var.f10164o.setVisibility(8);
        TextView textView = v0Var.f10165p;
        textView.setVisibility(0);
        v0Var.f10160b.setVisibility(0);
        v0Var.f10163n.setVisibility(0);
        v0Var.f10169t.setVisibility(0);
        TextView textView2 = v0Var.f10167r;
        if (i == 0) {
            textView2.setVisibility(0);
            textView2.setText(this.itemView.getContext().getString(2131952625));
            Context context = this.itemView.getContext();
            Context context2 = this.itemView.getContext();
            context2.getClass();
            textView.setText(context.getString(2131952467, 0, i5.H(context2, j)));
            progressBar2.setIndeterminate(true);
            return;
        }
        textView2.setVisibility(8);
        Context context3 = this.itemView.getContext();
        Integer valueOf = Integer.valueOf(i);
        Context context4 = this.itemView.getContext();
        context4.getClass();
        textView.setText(context3.getString(2131952467, valueOf, i5.H(context4, j)));
        progressBar2.setProgress(i);
        progressBar2.setIndeterminate(false);
    }

    public final void j(x4.g gVar, int i) {
        g();
        t4.v0 v0Var = this.f7639b;
        v0Var.f10164o.setText(2131952428);
        TextView textView = v0Var.f10164o;
        textView.setOnClickListener(new x0(this, gVar, i, 1));
        z3.J(textView);
    }

    public final void k() {
        t4.v0 v0Var = this.f7639b;
        t0.f.I(v0Var.f10162m, v0Var.f10161l);
        v0Var.f10164o.setVisibility(8);
        v0Var.f10165p.setVisibility(8);
        v0Var.f10160b.setVisibility(0);
        TextView textView = v0Var.f10167r;
        textView.setVisibility(0);
        v0Var.f10169t.setVisibility(0);
        textView.setText(this.itemView.getContext().getString(2131952095));
        v0Var.f10162m.setIndeterminate(true);
    }
}
