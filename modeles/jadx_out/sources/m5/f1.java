package m5;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.measurement.i5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f1 extends e {
    public final ProgressBar A;
    public final ImageView B;

    /* renamed from: b, reason: collision with root package name */
    public final w4.c f7379b;

    /* renamed from: l, reason: collision with root package name */
    public final w4.d f7380l;

    /* renamed from: m, reason: collision with root package name */
    public final w4.a f7381m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f7382n;

    /* renamed from: o, reason: collision with root package name */
    public final u4.p1 f7383o;

    /* renamed from: p, reason: collision with root package name */
    public final RelativeLayout f7384p;

    /* renamed from: q, reason: collision with root package name */
    public final ImageView f7385q;

    /* renamed from: r, reason: collision with root package name */
    public final TextView f7386r;

    /* renamed from: s, reason: collision with root package name */
    public final TextView f7387s;

    /* renamed from: t, reason: collision with root package name */
    public final TextView f7388t;

    /* renamed from: u, reason: collision with root package name */
    public final TextView f7389u;
    public final TextView v;

    /* renamed from: w, reason: collision with root package name */
    public final TextView f7390w;

    /* renamed from: x, reason: collision with root package name */
    public final LinearLayout f7391x;

    /* renamed from: y, reason: collision with root package name */
    public final LinearLayout f7392y;

    /* renamed from: z, reason: collision with root package name */
    public final TextView f7393z;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public f1(android.view.View r6, w4.c r7, w4.d r8, w4.a r9, boolean r10, u4.p1 r11) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.f1.<init>(android.view.View, w4.c, w4.d, w4.a, boolean, u4.p1):void");
    }

    public final void g(x4.g gVar, int i) {
        t0.f.s(this.A, this.f7385q);
        e1 e1Var = new e1(this, gVar, i, 3);
        TextView textView = this.f7389u;
        textView.setOnClickListener(e1Var);
        this.f7392y.setVisibility(8);
        this.f7388t.setVisibility(0);
        textView.setVisibility(0);
    }

    public final void h(x4.r rVar, x4.g gVar, int i) {
        ImageView imageView = this.f7385q;
        ProgressBar progressBar = this.A;
        t0.f.I(progressBar, imageView);
        LinearLayout linearLayout = this.f7391x;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        TextView textView = this.f7389u;
        textView.setText(2131952425);
        textView.setBackground(ContextCompat.getDrawable(this.itemView.getContext(), 2131231158));
        textView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), 2131099713));
        textView.setOnClickListener(new g4.a(i, this, 3, gVar));
        this.f7388t.setVisibility(8);
        this.f7392y.setVisibility(0);
        int i6 = rVar.i();
        TextView textView2 = this.f7393z;
        if (i6 == 0) {
            textView2.setText(this.itemView.getContext().getString(2131952625));
            progressBar.setIndeterminate(true);
            return;
        }
        progressBar.setIndeterminate(false);
        Context context = this.itemView.getContext();
        Integer valueOf = Integer.valueOf(rVar.i());
        long k5 = rVar.k();
        Context context2 = this.itemView.getContext();
        context2.getClass();
        textView2.setText(context.getString(2131952467, valueOf, i5.H(context2, k5)));
        progressBar.setProgress(rVar.i());
    }

    public final void i() {
        ImageView imageView = this.f7385q;
        ProgressBar progressBar = this.A;
        t0.f.I(progressBar, imageView);
        LinearLayout linearLayout = this.f7391x;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        this.f7389u.setVisibility(8);
        this.f7388t.setVisibility(8);
        this.f7392y.setVisibility(0);
        this.f7393z.setText(this.itemView.getContext().getString(2131952095));
        progressBar.setIndeterminate(true);
    }
}
