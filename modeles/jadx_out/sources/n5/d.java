package n5;

import a4.g0;
import a4.l0;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import c4.k0;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import java.util.concurrent.atomic.AtomicBoolean;
import l7.u;
import x4.q2;
import x4.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public x4.g f8069a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f8070b;

    /* renamed from: c, reason: collision with root package name */
    public final android.support.v4.media.g f8071c;

    /* renamed from: d, reason: collision with root package name */
    public View f8072d;

    /* renamed from: e, reason: collision with root package name */
    public RelativeLayout f8073e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f8074k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f8075l;

    /* renamed from: m, reason: collision with root package name */
    public LinearLayout f8076m;

    /* renamed from: n, reason: collision with root package name */
    public ProgressBar f8077n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f8078o;

    /* renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f8079p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f8080q;

    public d(x4.g gVar, RelativeLayout relativeLayout, android.support.v4.media.g gVar2) {
        gVar.getClass();
        relativeLayout.getClass();
        this.f8069a = gVar;
        this.f8070b = relativeLayout;
        this.f8071c = gVar2;
        this.f8079p = new AtomicBoolean(false);
    }

    public static final void a(k0 k0Var, d dVar) {
        ImageView imageView = dVar.f8075l;
        if (imageView == null) {
            kotlin.jvm.internal.l.i("ivLikeAppInfoSelected");
            throw null;
        }
        imageView.setBackground(ContextCompat.getDrawable(k0Var, 2131231162));
        ImageView imageView2 = dVar.f8075l;
        if (imageView2 == null) {
            kotlin.jvm.internal.l.i("ivLikeAppInfoSelected");
            throw null;
        }
        imageView2.setImageResource(2131231343);
        ImageView imageView3 = dVar.f8075l;
        if (imageView3 != null) {
            imageView3.setVisibility(0);
        } else {
            kotlin.jvm.internal.l.i("ivLikeAppInfoSelected");
            throw null;
        }
    }

    public final void b(k0 k0Var) {
        x4.e eVar;
        r K;
        q2 q2Var;
        Throwable th;
        k0Var.getClass();
        j5.g l10 = j5.g.D.l(k0Var);
        l10.b();
        String str = this.f8069a.F;
        if (str == null || str.length() == 0) {
            eVar = null;
        } else {
            String str2 = this.f8069a.F;
            str2.getClass();
            eVar = l10.B(str2);
        }
        long j = this.f8069a.f11158a;
        boolean z9 = a5.b.c(j) || a5.c.b(j);
        x4.g gVar = this.f8069a;
        if (z9) {
            long j6 = gVar.f11158a;
            if (a5.b.c(j6)) {
                K = a5.b.b();
            } else {
                if (a5.c.b(j6)) {
                    K = a5.c.a();
                }
                K = null;
            }
        } else {
            String str3 = gVar.F;
            if (str3 != null && str3.length() != 0) {
                String str4 = this.f8069a.F;
                str4.getClass();
                K = l10.K(str4);
            }
            K = null;
        }
        if (eVar == null) {
            if (K != null) {
                if (K.n()) {
                    g();
                    return;
                }
                if (K.c()) {
                    String string = k0Var.getString(2131952428);
                    string.getClass();
                    f(string);
                    return;
                } else {
                    if (z9) {
                        e(K, k0Var);
                        return;
                    }
                    return;
                }
            }
            String str5 = this.f8069a.W;
            if (str5 != null && !str5.equals("PreRegister") && !str5.equals("Discontinued") && !str5.equals("ExternalDownload") && !str5.equals("ReadingMode") && !str5.equals("AppNotAvailableInThisCountry")) {
                String string2 = k0Var.getString(2131952428);
                string2.getClass();
                f(string2);
                return;
            }
            ProgressBar progressBar = this.f8077n;
            if (progressBar == null) {
                kotlin.jvm.internal.l.i("pbAppInfoSelected");
                throw null;
            }
            ImageView imageView = this.f;
            if (imageView == null) {
                kotlin.jvm.internal.l.i("ivLogoAppInfoSelected");
                throw null;
            }
            t0.f.s(progressBar, imageView);
            TextView textView = this.h;
            if (textView == null) {
                kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
                throw null;
            }
            textView.setVisibility(4);
            LinearLayout linearLayout = this.f8076m;
            if (linearLayout == null) {
                kotlin.jvm.internal.l.i("llAppInfoSelected");
                throw null;
            }
            linearLayout.setVisibility(8);
            TextView textView2 = this.i;
            if (textView2 != null) {
                textView2.setVisibility(0);
                return;
            } else {
                kotlin.jvm.internal.l.i("tvAuthorAppInfoSelected");
                throw null;
            }
        }
        String str6 = this.f8069a.F;
        if (str6 == null || str6.length() == 0) {
            q2Var = null;
        } else {
            String str7 = this.f8069a.F;
            str7.getClass();
            q2Var = l10.Y(str7);
        }
        l4.a c9 = f4.a.f4869a.c();
        if (c9 != null) {
            th = null;
            if (u.m0(c9.f7095a, eVar.f11123l, true)) {
                g();
                return;
            }
        } else {
            th = null;
        }
        if (q2Var != null && !q2Var.c() && eVar.v != 1) {
            if (!z9 || K == null) {
                float f = UptodownApp.I;
                if (!b4.d.m(q2Var.f11344b)) {
                    String string3 = k0Var.getString(2131951657);
                    string3.getClass();
                    f(string3);
                    return;
                }
            }
            K.getClass();
            e(K, k0Var);
            return;
        }
        ProgressBar progressBar2 = this.f8077n;
        if (progressBar2 == null) {
            kotlin.jvm.internal.l.i("pbAppInfoSelected");
            throw th;
        }
        ImageView imageView2 = this.f;
        if (imageView2 == null) {
            kotlin.jvm.internal.l.i("ivLogoAppInfoSelected");
            throw th;
        }
        t0.f.s(progressBar2, imageView2);
        TextView textView3 = this.h;
        if (textView3 == null) {
            kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
            throw th;
        }
        textView3.setText(this.f8070b.getContext().getString(2131952419));
        TextView textView4 = this.h;
        if (textView4 == null) {
            kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
            throw th;
        }
        z3.J(textView4);
        LinearLayout linearLayout2 = this.f8076m;
        if (linearLayout2 == null) {
            kotlin.jvm.internal.l.i("llAppInfoSelected");
            throw th;
        }
        linearLayout2.setVisibility(8);
        TextView textView5 = this.i;
        if (textView5 != null) {
            textView5.setVisibility(0);
        } else {
            kotlin.jvm.internal.l.i("tvAuthorAppInfoSelected");
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(c4.k0 r9) {
        /*
            r8 = this;
            java.lang.String r0 = "SettingsPreferences"
            java.lang.String r1 = "animations"
            r9.getClass()
            android.widget.RelativeLayout r2 = r8.f8070b
            int r3 = r2.getVisibility()
            r4 = 0
            if (r3 != 0) goto L78
            float r3 = com.uptodown.UptodownApp.I
            r3 = 1
            android.content.SharedPreferences r5 = r9.getSharedPreferences(r0, r4)     // Catch: java.lang.Exception -> L22
            boolean r6 = r5.contains(r1)     // Catch: java.lang.Exception -> L22
            if (r6 == 0) goto L22
            boolean r5 = r5.getBoolean(r1, r3)     // Catch: java.lang.Exception -> L22
            goto L23
        L22:
            r5 = r3
        L23:
            r6 = 0
            if (r5 == 0) goto L6a
            float r5 = com.uptodown.UptodownApp.I
            java.util.concurrent.atomic.AtomicBoolean r5 = r8.f8079p
            boolean r5 = r5.compareAndSet(r4, r3)
            if (r5 == 0) goto L6a
            n5.c r2 = new n5.c
            r2.<init>(r8, r4)
            android.widget.RelativeLayout r5 = r8.f8073e
            if (r5 == 0) goto L64
            c4.r3 r7 = new c4.r3
            r7.<init>(r9, r8, r2)
            r2 = 2130772034(0x7f010042, float:1.7147175E38)
            android.view.animation.Animation r2 = android.view.animation.AnimationUtils.loadAnimation(r9, r2)
            android.content.SharedPreferences r0 = r9.getSharedPreferences(r0, r4)     // Catch: java.lang.Exception -> L54
            boolean r4 = r0.contains(r1)     // Catch: java.lang.Exception -> L54
            if (r4 == 0) goto L54
            boolean r0 = r0.getBoolean(r1, r3)     // Catch: java.lang.Exception -> L54
            goto L55
        L54:
            r0 = r3
        L55:
            if (r0 == 0) goto L60
            float r0 = com.uptodown.UptodownApp.I
            r2.setAnimationListener(r7)
            r5.startAnimation(r2)
            goto L6f
        L60:
            r7.onAnimationEnd(r2)
            goto L6f
        L64:
            java.lang.String r9 = "rlAppInfoSelected"
            kotlin.jvm.internal.l.i(r9)
            throw r6
        L6a:
            r0 = 8
            r2.setVisibility(r0)
        L6f:
            boolean r0 = r9.isFinishing()
            if (r0 != 0) goto L77
            r9.L = r6
        L77:
            return r3
        L78:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: n5.d.c(c4.k0):boolean");
    }

    public final void d(k0 k0Var) {
        if (!this.f8080q) {
            l0 e10 = g0.d().e(this.f8069a.h());
            float f = UptodownApp.I;
            e10.g(b4.d.f(k0Var));
            e10.h(b4.d.x(k0Var));
            ImageView imageView = this.f;
            if (imageView == null) {
                kotlin.jvm.internal.l.i("ivLogoAppInfoSelected");
                throw null;
            }
            e10.e(imageView, new g5.f(this, 11));
        }
        TextView textView = this.g;
        if (textView == null) {
            kotlin.jvm.internal.l.i("tvNameAppInfoSelected");
            throw null;
        }
        textView.setText(this.f8069a.f11159b);
        TextView textView2 = this.i;
        if (textView2 == null) {
            kotlin.jvm.internal.l.i("tvAuthorAppInfoSelected");
            throw null;
        }
        textView2.setText(this.f8069a.f11190w);
        TextView textView3 = this.f8074k;
        if (textView3 == null) {
            kotlin.jvm.internal.l.i("tvValorationAppInfoSelected");
            throw null;
        }
        textView3.setText(String.valueOf(this.f8069a.f11194y / 10.0d));
        b(k0Var);
    }

    public final void e(r rVar, k0 k0Var) {
        ProgressBar progressBar = this.f8077n;
        if (progressBar == null) {
            kotlin.jvm.internal.l.i("pbAppInfoSelected");
            throw null;
        }
        ImageView imageView = this.f;
        if (imageView == null) {
            kotlin.jvm.internal.l.i("ivLogoAppInfoSelected");
            throw null;
        }
        t0.f.I(progressBar, imageView);
        TextView textView = this.i;
        if (textView == null) {
            kotlin.jvm.internal.l.i("tvAuthorAppInfoSelected");
            throw null;
        }
        textView.setVisibility(8);
        LinearLayout linearLayout = this.f8076m;
        if (linearLayout == null) {
            kotlin.jvm.internal.l.i("llAppInfoSelected");
            throw null;
        }
        int i = 0;
        linearLayout.setVisibility(0);
        TextView textView2 = this.h;
        if (textView2 == null) {
            kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
            throw null;
        }
        textView2.setText(2131952425);
        TextView textView3 = this.h;
        if (textView3 == null) {
            kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
            throw null;
        }
        textView3.setOnClickListener(new a(this, k0Var, i));
        TextView textView4 = this.h;
        if (textView4 == null) {
            kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
            throw null;
        }
        z3.K(textView4);
        if (rVar.i() == 0) {
            TextView textView5 = this.f8078o;
            if (textView5 == null) {
                kotlin.jvm.internal.l.i("tvProgressAppInfoSelected");
                throw null;
            }
            textView5.setText(k0Var.getString(2131952625));
            ProgressBar progressBar2 = this.f8077n;
            if (progressBar2 != null) {
                progressBar2.setIndeterminate(true);
                return;
            } else {
                kotlin.jvm.internal.l.i("pbAppInfoSelected");
                throw null;
            }
        }
        ProgressBar progressBar3 = this.f8077n;
        if (progressBar3 == null) {
            kotlin.jvm.internal.l.i("pbAppInfoSelected");
            throw null;
        }
        progressBar3.setIndeterminate(false);
        TextView textView6 = this.f8078o;
        if (textView6 == null) {
            kotlin.jvm.internal.l.i("tvProgressAppInfoSelected");
            throw null;
        }
        textView6.setText(k0Var.getString(2131952467, Integer.valueOf(rVar.i()), i5.H(k0Var, rVar.k())));
        ProgressBar progressBar4 = this.f8077n;
        if (progressBar4 != null) {
            progressBar4.setProgress(rVar.i());
        } else {
            kotlin.jvm.internal.l.i("pbAppInfoSelected");
            throw null;
        }
    }

    public final void f(String str) {
        ProgressBar progressBar = this.f8077n;
        if (progressBar == null) {
            kotlin.jvm.internal.l.i("pbAppInfoSelected");
            throw null;
        }
        ImageView imageView = this.f;
        if (imageView == null) {
            kotlin.jvm.internal.l.i("ivLogoAppInfoSelected");
            throw null;
        }
        t0.f.s(progressBar, imageView);
        TextView textView = this.h;
        if (textView == null) {
            kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
            throw null;
        }
        textView.setText(str);
        TextView textView2 = this.h;
        if (textView2 == null) {
            kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
            throw null;
        }
        z3.J(textView2);
        LinearLayout linearLayout = this.f8076m;
        if (linearLayout == null) {
            kotlin.jvm.internal.l.i("llAppInfoSelected");
            throw null;
        }
        linearLayout.setVisibility(8);
        TextView textView3 = this.i;
        if (textView3 != null) {
            textView3.setVisibility(0);
        } else {
            kotlin.jvm.internal.l.i("tvAuthorAppInfoSelected");
            throw null;
        }
    }

    public final void g() {
        ProgressBar progressBar = this.f8077n;
        if (progressBar == null) {
            kotlin.jvm.internal.l.i("pbAppInfoSelected");
            throw null;
        }
        ImageView imageView = this.f;
        if (imageView == null) {
            kotlin.jvm.internal.l.i("ivLogoAppInfoSelected");
            throw null;
        }
        t0.f.I(progressBar, imageView);
        TextView textView = this.i;
        if (textView == null) {
            kotlin.jvm.internal.l.i("tvAuthorAppInfoSelected");
            throw null;
        }
        textView.setVisibility(8);
        LinearLayout linearLayout = this.f8076m;
        if (linearLayout == null) {
            kotlin.jvm.internal.l.i("llAppInfoSelected");
            throw null;
        }
        linearLayout.setVisibility(0);
        TextView textView2 = this.i;
        if (textView2 == null) {
            kotlin.jvm.internal.l.i("tvAuthorAppInfoSelected");
            throw null;
        }
        textView2.setText(this.f8070b.getContext().getString(2131952095));
        TextView textView3 = this.h;
        if (textView3 == null) {
            kotlin.jvm.internal.l.i("tvActionAppInfoSelected");
            throw null;
        }
        textView3.setVisibility(8);
        ProgressBar progressBar2 = this.f8077n;
        if (progressBar2 != null) {
            progressBar2.setIndeterminate(true);
        } else {
            kotlin.jvm.internal.l.i("pbAppInfoSelected");
            throw null;
        }
    }

    public final void h(k0 k0Var) {
        ImageView imageView = this.f8075l;
        if (imageView == null) {
            kotlin.jvm.internal.l.i("ivLikeAppInfoSelected");
            throw null;
        }
        imageView.setBackground(ContextCompat.getDrawable(k0Var, 2131231163));
        ImageView imageView2 = this.f8075l;
        if (imageView2 == null) {
            kotlin.jvm.internal.l.i("ivLikeAppInfoSelected");
            throw null;
        }
        imageView2.setImageResource(2131231346);
        ImageView imageView3 = this.f8075l;
        if (imageView3 != null) {
            imageView3.setVisibility(0);
        } else {
            kotlin.jvm.internal.l.i("ivLikeAppInfoSelected");
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(x4.r r10, int r11, c4.k0 r12) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n5.d.i(x4.r, int, c4.k0):void");
    }
}
