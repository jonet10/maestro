package m5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.measurement.i5;
import com.uptodown.UptodownApp;
import j$.util.concurrent.ConcurrentHashMap;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import x4.q2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final w4.b f7337a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f7338b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f7339l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f7340m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f7341n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f7342o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f7343p;

    public d(View view, w4.b bVar) {
        super(view);
        this.f7337a = bVar;
        View findViewById = view.findViewById(2131362381);
        findViewById.getClass();
        this.f7338b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(2131364051);
        findViewById2.getClass();
        TextView textView = (TextView) findViewById2;
        this.f7339l = textView;
        View findViewById3 = view.findViewById(2131364567);
        findViewById3.getClass();
        TextView textView2 = (TextView) findViewById3;
        this.f7340m = textView2;
        View findViewById4 = view.findViewById(2131364306);
        findViewById4.getClass();
        TextView textView3 = (TextView) findViewById4;
        this.f7341n = textView3;
        View findViewById5 = view.findViewById(2131363946);
        findViewById5.getClass();
        TextView textView4 = (TextView) findViewById5;
        this.f7342o = textView4;
        View findViewById6 = view.findViewById(2131363859);
        findViewById6.getClass();
        TextView textView5 = (TextView) findViewById6;
        this.f7343p = textView5;
        View findViewById7 = view.findViewById(2131363204);
        findViewById7.getClass();
        textView.setTypeface(f4.c.f4882w);
        textView2.setTypeface(f4.c.f4882w);
        textView3.setTypeface(f4.c.f4883x);
        textView4.setTypeface(f4.c.f4883x);
        textView5.setTypeface(f4.c.f4882w);
        ((RelativeLayout) findViewById7).setOnClickListener(new c4.d(this, 26));
    }

    public final void a(x4.e eVar) {
        boolean z9 = eVar.K;
        View view = this.itemView;
        if (z9) {
            view.setAlpha(0.3f);
        } else {
            view.setAlpha(1.0f);
        }
        e1.c0 c0Var = j5.g.D;
        Context context = this.itemView.getContext();
        context.getClass();
        j5.g l10 = c0Var.l(context);
        l10.b();
        String str = eVar.f11123l;
        str.getClass();
        q2 Y = l10.Y(str);
        l10.c();
        ConcurrentHashMap concurrentHashMap = j5.t.f6708a;
        Context context2 = this.itemView.getContext();
        context2.getClass();
        this.f7338b.setImageDrawable(j5.t.b(context2, eVar.f11123l));
        this.f7339l.setText(eVar.f11122b);
        String str2 = eVar.f11125n;
        TextView textView = this.f7340m;
        textView.setText(str2);
        long j = eVar.f11133w;
        Context context3 = this.itemView.getContext();
        context3.getClass();
        this.f7341n.setText(i5.H(context3, j));
        long j6 = eVar.f11134x;
        this.f7342o.setText(j6 <= 0 ? null : new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date(j6)));
        float f = UptodownApp.I;
        l4.a c9 = f4.a.f4869a.c();
        if (l7.u.m0(c9 != null ? c9.f7095a : null, eVar.f11123l, true)) {
            textView.setText(2131952095);
        }
        int i = eVar.v;
        TextView textView2 = this.f7343p;
        if (i == 1) {
            textView2.setText(this.itemView.getContext().getString(2131951954));
            textView2.setVisibility(0);
        } else if (Y == null || Y.f11348o != 1) {
            textView2.setVisibility(8);
        } else {
            textView2.setText(this.itemView.getContext().getString(2131952609));
            textView2.setVisibility(0);
        }
    }
}
