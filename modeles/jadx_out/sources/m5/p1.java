package m5;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p1 extends RecyclerView.ViewHolder {
    public String A;
    public o1 B;
    public ValueAnimator C;

    /* renamed from: a, reason: collision with root package name */
    public final w4.n f7506a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f7507b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f7508l;

    /* renamed from: m, reason: collision with root package name */
    public final ProgressBar f7509m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f7510n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f7511o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f7512p;

    /* renamed from: q, reason: collision with root package name */
    public final TextView f7513q;

    /* renamed from: r, reason: collision with root package name */
    public final TextView f7514r;

    /* renamed from: s, reason: collision with root package name */
    public final RelativeLayout f7515s;

    /* renamed from: t, reason: collision with root package name */
    public final TextView f7516t;

    /* renamed from: u, reason: collision with root package name */
    public final ImageView f7517u;
    public final RelativeLayout v;

    /* renamed from: w, reason: collision with root package name */
    public final TextView f7518w;

    /* renamed from: x, reason: collision with root package name */
    public final RelativeLayout f7519x;

    /* renamed from: y, reason: collision with root package name */
    public final TextView f7520y;

    /* renamed from: z, reason: collision with root package name */
    public final ImageView f7521z;

    public p1(View view, w4.n nVar) {
        super(view);
        this.f7506a = nVar;
        View findViewById = view.findViewById(2131362390);
        findViewById.getClass();
        this.f7507b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(2131364059);
        findViewById2.getClass();
        TextView textView = (TextView) findViewById2;
        this.f7508l = textView;
        View findViewById3 = view.findViewById(2131363019);
        findViewById3.getClass();
        this.f7509m = (ProgressBar) findViewById3;
        View findViewById4 = view.findViewById(2131364579);
        findViewById4.getClass();
        TextView textView2 = (TextView) findViewById4;
        this.f7510n = textView2;
        View findViewById5 = view.findViewById(2131364314);
        findViewById5.getClass();
        TextView textView3 = (TextView) findViewById5;
        this.f7511o = textView3;
        View findViewById6 = view.findViewById(2131363947);
        findViewById6.getClass();
        TextView textView4 = (TextView) findViewById6;
        this.f7512p = textView4;
        View findViewById7 = view.findViewById(2131364548);
        findViewById7.getClass();
        TextView textView5 = (TextView) findViewById7;
        this.f7513q = textView5;
        View findViewById8 = view.findViewById(2131363625);
        findViewById8.getClass();
        TextView textView6 = (TextView) findViewById8;
        this.f7514r = textView6;
        View findViewById9 = view.findViewById(2131363105);
        findViewById9.getClass();
        this.f7515s = (RelativeLayout) findViewById9;
        View findViewById10 = view.findViewById(2131363860);
        findViewById10.getClass();
        TextView textView7 = (TextView) findViewById10;
        this.f7516t = textView7;
        View findViewById11 = view.findViewById(2131362545);
        findViewById11.getClass();
        this.f7517u = (ImageView) findViewById11;
        View findViewById12 = view.findViewById(2131363290);
        findViewById12.getClass();
        this.v = (RelativeLayout) findViewById12;
        View findViewById13 = view.findViewById(2131364564);
        findViewById13.getClass();
        TextView textView8 = (TextView) findViewById13;
        this.f7518w = textView8;
        View findViewById14 = view.findViewById(2131363151);
        findViewById14.getClass();
        View findViewById15 = view.findViewById(2131363134);
        findViewById15.getClass();
        this.f7519x = (RelativeLayout) findViewById15;
        View findViewById16 = view.findViewById(2131364155);
        findViewById16.getClass();
        TextView textView9 = (TextView) findViewById16;
        this.f7520y = textView9;
        View findViewById17 = view.findViewById(2131362318);
        findViewById17.getClass();
        ImageView imageView = (ImageView) findViewById17;
        this.f7521z = imageView;
        this.B = o1.f7494a;
        final int i = 0;
        ((RelativeLayout) findViewById14).setOnClickListener(new View.OnClickListener(this) { // from class: m5.m1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p1 f7479b;

            {
                this.f7479b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                switch (i) {
                    case 0:
                        p1 p1Var = this.f7479b;
                        w4.n nVar2 = p1Var.f7506a;
                        if (nVar2 != null && (bindingAdapterPosition = p1Var.getBindingAdapterPosition()) != -1) {
                            nVar2.b(bindingAdapterPosition);
                            break;
                        }
                        break;
                    case 1:
                        p1 p1Var2 = this.f7479b;
                        w4.n nVar3 = p1Var2.f7506a;
                        if (nVar3 != null) {
                            nVar3.c(p1Var2.getBindingAdapterPosition());
                            break;
                        }
                        break;
                    default:
                        p1 p1Var3 = this.f7479b;
                        w4.n nVar4 = p1Var3.f7506a;
                        if (nVar4 != null) {
                            nVar4.d(p1Var3.getBindingAdapterPosition());
                            break;
                        }
                        break;
                }
            }
        });
        final int i6 = 1;
        textView6.setOnClickListener(new View.OnClickListener(this) { // from class: m5.m1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p1 f7479b;

            {
                this.f7479b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                switch (i6) {
                    case 0:
                        p1 p1Var = this.f7479b;
                        w4.n nVar2 = p1Var.f7506a;
                        if (nVar2 != null && (bindingAdapterPosition = p1Var.getBindingAdapterPosition()) != -1) {
                            nVar2.b(bindingAdapterPosition);
                            break;
                        }
                        break;
                    case 1:
                        p1 p1Var2 = this.f7479b;
                        w4.n nVar3 = p1Var2.f7506a;
                        if (nVar3 != null) {
                            nVar3.c(p1Var2.getBindingAdapterPosition());
                            break;
                        }
                        break;
                    default:
                        p1 p1Var3 = this.f7479b;
                        w4.n nVar4 = p1Var3.f7506a;
                        if (nVar4 != null) {
                            nVar4.d(p1Var3.getBindingAdapterPosition());
                            break;
                        }
                        break;
                }
            }
        });
        final int i10 = 2;
        imageView.setOnClickListener(new View.OnClickListener(this) { // from class: m5.m1

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p1 f7479b;

            {
                this.f7479b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int bindingAdapterPosition;
                switch (i10) {
                    case 0:
                        p1 p1Var = this.f7479b;
                        w4.n nVar2 = p1Var.f7506a;
                        if (nVar2 != null && (bindingAdapterPosition = p1Var.getBindingAdapterPosition()) != -1) {
                            nVar2.b(bindingAdapterPosition);
                            break;
                        }
                        break;
                    case 1:
                        p1 p1Var2 = this.f7479b;
                        w4.n nVar3 = p1Var2.f7506a;
                        if (nVar3 != null) {
                            nVar3.c(p1Var2.getBindingAdapterPosition());
                            break;
                        }
                        break;
                    default:
                        p1 p1Var3 = this.f7479b;
                        w4.n nVar4 = p1Var3.f7506a;
                        if (nVar4 != null) {
                            nVar4.d(p1Var3.getBindingAdapterPosition());
                            break;
                        }
                        break;
                }
            }
        });
        textView.setTypeface(f4.c.f4882w);
        textView2.setTypeface(f4.c.f4882w);
        textView3.setTypeface(f4.c.f4883x);
        textView5.setTypeface(f4.c.f4883x);
        textView9.setTypeface(f4.c.f4882w);
        textView8.setTypeface(f4.c.f4883x);
        textView7.setTypeface(f4.c.f4882w);
        textView6.setTypeface(f4.c.f4882w);
        textView4.setTypeface(f4.c.f4883x);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0331  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(e4.v0 r23, boolean r24, boolean r25) {
        /*
            Method dump skipped, instructions count: 1001
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.p1.a(e4.v0, boolean, boolean):void");
    }

    public final void b(e4.v0 v0Var) {
        o1 o1Var;
        if (!kotlin.jvm.internal.l.a(this.A, v0Var.f4708a.f11123l)) {
            this.f7509m.setVisibility(8);
            return;
        }
        o1 o1Var2 = this.B;
        if (o1Var2 == o1.f7494a || o1Var2 == (o1Var = o1.f7497m)) {
            return;
        }
        this.B = o1Var;
        ValueAnimator valueAnimator = this.C;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(10, 0);
        ofInt.setStartDelay(200L);
        ofInt.setDuration(300L);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new n1(this, 1));
        ofInt.addListener(new k0(this, 1));
        ofInt.start();
        this.C = ofInt;
        this.f7507b.animate().scaleX(1.0f).scaleY(1.0f).setStartDelay(200L).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator()).start();
    }

    public final void c(e4.v0 v0Var) {
        o1 o1Var;
        if (kotlin.jvm.internal.l.a(this.A, v0Var.f4708a.f11123l)) {
            o1 o1Var2 = this.B;
            ProgressBar progressBar = this.f7509m;
            o1 o1Var3 = o1.f7496l;
            if (o1Var2 == o1Var3) {
                progressBar.setVisibility(0);
                return;
            }
            if (o1Var2 == o1Var3 || o1Var2 == (o1Var = o1.f7495b)) {
                return;
            }
            this.B = o1Var;
            progressBar.setVisibility(0);
            ValueAnimator valueAnimator = this.C;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 10);
            ofInt.setDuration(300L);
            ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
            ofInt.addUpdateListener(new n1(this, 0));
            ofInt.start();
            this.C = ofInt;
            this.f7507b.animate().scaleX(0.6f).scaleY(0.6f).setDuration(300L).setInterpolator(new AccelerateDecelerateInterpolator()).withEndAction(new a2.s(this, 15)).start();
        }
    }
}
