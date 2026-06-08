package m5;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import x4.q2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class e extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7369a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(View view, Context context) {
        super(view);
        view.getClass();
        context.getClass();
        this.f7369a = context;
    }

    public static void a(RelativeLayout.LayoutParams layoutParams, Context context, int i, int i6) {
        context.getClass();
        int dimension = (int) context.getResources().getDimension(2131166251);
        String str = null;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("Language")) {
                str = sharedPreferences.getString("Language", null);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (!kotlin.jvm.internal.l.a(str, "ar")) {
            if (i == i6) {
                layoutParams.setMargins(dimension, 0, dimension, 0);
                return;
            } else {
                layoutParams.setMargins(dimension, 0, 0, 0);
                return;
            }
        }
        if (i == i6) {
            layoutParams.setMargins(dimension, 0, 0, 0);
        } else if (i == 1) {
            layoutParams.setMargins(dimension, 0, dimension, 0);
        } else {
            layoutParams.setMargins(dimension, 0, 0, 0);
        }
    }

    public static void b(View view, w4.c cVar, x4.g gVar) {
        view.getClass();
        cVar.getClass();
        gVar.getClass();
        view.setOnClickListener(new g4.b0(4, cVar, gVar));
    }

    public static void f(x4.g gVar, TextView textView, TextView textView2) {
        gVar.getClass();
        textView.getClass();
        textView2.getClass();
        textView.setText(gVar.f11159b);
        String str = gVar.f11175o;
        if (str == null || str.length() == 0) {
            str = gVar.f11190w;
        }
        textView2.setText(str);
    }

    public final void c(x4.g gVar, ProgressBar progressBar, ImageView imageView, TextView textView, TextView textView2, TextView textView3, LinearLayout linearLayout) {
        gVar.getClass();
        progressBar.getClass();
        imageView.getClass();
        textView.getClass();
        textView2.getClass();
        linearLayout.getClass();
        e1.c0 c0Var = j5.g.D;
        Context context = this.f7369a;
        j5.g l10 = c0Var.l(context);
        l10.b();
        String str = gVar.F;
        x4.r L = str != null ? l10.L(gVar.K, str) : null;
        long j = gVar.f11158a;
        boolean z9 = a5.b.c(j) || a5.c.b(j);
        boolean z10 = L != null && L.m();
        if (L == null || !(z9 || z10)) {
            String str2 = gVar.F;
            t0.f.s(progressBar, imageView);
            linearLayout.setVisibility(8);
            if (textView3 != null) {
                d(str2, textView3, textView);
                return;
            }
            return;
        }
        int i = L.i();
        long k5 = L.k();
        t0.f.I(progressBar, imageView);
        textView.setVisibility(8);
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
        linearLayout.setVisibility(0);
        if (i == 0) {
            progressBar.setIndeterminate(true);
            textView2.setText(context.getString(2131952625));
        } else {
            progressBar.setIndeterminate(false);
            progressBar.setProgress(i);
            textView2.setText(context.getString(2131952467, Integer.valueOf(i), i5.H(context, k5)));
        }
    }

    public final void d(String str, TextView textView, TextView textView2) {
        textView.getClass();
        textView2.getClass();
        Context context = this.f7369a;
        PackageInfo packageInfo = null;
        if (str != null && context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageInfo = n4.i.e(packageManager, str, 0);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (packageInfo == null) {
            textView.setVisibility(8);
            textView2.setVisibility(0);
            return;
        }
        j5.g l10 = j5.g.D.l(context);
        l10.b();
        str.getClass();
        q2 Y = l10.Y(str);
        x4.e B = l10.B(str);
        l10.c();
        if (B == null) {
            textView.setVisibility(0);
            textView2.setVisibility(8);
            return;
        }
        if (B.d()) {
            textView.setVisibility(8);
            textView2.setVisibility(0);
            return;
        }
        textView.setTypeface(f4.c.f4882w);
        if (B.K) {
            textView.setText(context.getString(2131951889));
            textView.setTextColor(ContextCompat.getColor(context, 2131100505));
            textView.setBackground(ContextCompat.getDrawable(context, 2131230859));
        } else if (Y == null || Y.c() || B.v != 0) {
            textView.setText(context.getString(2131952622));
            z3.J(textView);
        } else {
            textView.setText(context.getString(2131952624));
            z3.N(textView);
        }
        textView.setVisibility(0);
        textView2.setVisibility(8);
    }

    public final void e(ImageView imageView, String str) {
        imageView.getClass();
        Context context = this.f7369a;
        if (str == null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(context, 2131231296));
            return;
        }
        a4.l0 e10 = a4.g0.d().e(str);
        float f = UptodownApp.I;
        e10.g(b4.d.f(context));
        e10.h(b4.d.x(context));
        e10.e(imageView, null);
    }
}
