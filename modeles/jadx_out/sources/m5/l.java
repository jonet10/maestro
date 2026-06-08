package m5;

import android.content.Context;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final g2.e f7451a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.h f7452b;

    /* renamed from: l, reason: collision with root package name */
    public final Context f7453l;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public l(g2.e r2, w4.h r3) {
        /*
            r1 = this;
            r3.getClass()
            java.lang.Object r0 = r2.f5118b
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r1.<init>(r0)
            r1.f7451a = r2
            r1.f7452b = r3
            android.content.Context r3 = r0.getContext()
            r1.f7453l = r3
            java.lang.Object r3 = r2.f5126s
            com.uptodown.util.views.UsernameTextView r3 = (com.uptodown.util.views.UsernameTextView) r3
            android.graphics.Typeface r0 = f4.c.f4882w
            r3.setTypeface(r0)
            java.lang.Object r3 = r2.f5124q
            android.widget.TextView r3 = (android.widget.TextView) r3
            android.graphics.Typeface r0 = f4.c.f4883x
            r3.setTypeface(r0)
            java.lang.Object r2 = r2.f5125r
            android.widget.TextView r2 = (android.widget.TextView) r2
            android.graphics.Typeface r3 = f4.c.f4883x
            r2.setTypeface(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m5.l.<init>(g2.e, w4.h):void");
    }

    public final void a(x4.d1 d1Var, g2.e eVar) {
        ImageView imageView = (ImageView) eVar.f5121n;
        ImageView imageView2 = (ImageView) eVar.f5122o;
        ImageView imageView3 = (ImageView) eVar.f5123p;
        ImageView imageView4 = (ImageView) eVar.f5124q;
        int i = d1Var.f11097p;
        ImageView imageView5 = (ImageView) eVar.f5120m;
        Context context = this.f7453l;
        if (i == 1) {
            imageView5.setImageDrawable(ContextCompat.getDrawable(context, 2131231442));
            imageView.setImageDrawable(ContextCompat.getDrawable(context, 2131231440));
            imageView2.setImageDrawable(ContextCompat.getDrawable(context, 2131231440));
            imageView3.setImageDrawable(ContextCompat.getDrawable(context, 2131231440));
            imageView4.setImageDrawable(ContextCompat.getDrawable(context, 2131231440));
            if (d1Var.v >= 1) {
                imageView5.setImageDrawable(ContextCompat.getDrawable(context, 2131231442));
            }
            if (d1Var.v >= 2) {
                imageView.setImageDrawable(ContextCompat.getDrawable(context, 2131231442));
            }
            if (d1Var.v >= 3) {
                imageView2.setImageDrawable(ContextCompat.getDrawable(context, 2131231442));
            }
            if (d1Var.v >= 4) {
                imageView3.setImageDrawable(ContextCompat.getDrawable(context, 2131231442));
            }
            if (d1Var.v == 5) {
                imageView4.setImageDrawable(ContextCompat.getDrawable(context, 2131231442));
                return;
            }
            return;
        }
        imageView5.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
        imageView.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
        imageView2.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
        imageView3.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
        imageView4.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
        if (d1Var.v >= 1) {
            imageView5.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
        }
        if (d1Var.v >= 2) {
            imageView.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
        }
        if (d1Var.v >= 3) {
            imageView2.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
        }
        if (d1Var.v >= 4) {
            imageView3.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
        }
        if (d1Var.v == 5) {
            imageView4.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
        }
    }
}
