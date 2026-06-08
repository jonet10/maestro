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

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final w4.b f7295a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f7296b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f7297l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f7298m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f7299n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f7300o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f7301p;

    public a(View view, w4.b bVar) {
        super(view);
        this.f7295a = bVar;
        View findViewById = view.findViewById(2131362381);
        findViewById.getClass();
        this.f7296b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(2131364051);
        findViewById2.getClass();
        TextView textView = (TextView) findViewById2;
        this.f7297l = textView;
        View findViewById3 = view.findViewById(2131364567);
        findViewById3.getClass();
        TextView textView2 = (TextView) findViewById3;
        this.f7298m = textView2;
        View findViewById4 = view.findViewById(2131364306);
        findViewById4.getClass();
        TextView textView3 = (TextView) findViewById4;
        this.f7299n = textView3;
        View findViewById5 = view.findViewById(2131363946);
        findViewById5.getClass();
        TextView textView4 = (TextView) findViewById5;
        this.f7300o = textView4;
        View findViewById6 = view.findViewById(2131363859);
        findViewById6.getClass();
        TextView textView5 = (TextView) findViewById6;
        this.f7301p = textView5;
        View findViewById7 = view.findViewById(2131363204);
        findViewById7.getClass();
        textView.setTypeface(f4.c.f4882w);
        textView2.setTypeface(f4.c.f4882w);
        textView3.setTypeface(f4.c.f4883x);
        textView4.setTypeface(f4.c.f4883x);
        textView5.setTypeface(f4.c.f4882w);
        ((RelativeLayout) findViewById7).setOnClickListener(new c4.d(this, 25));
    }

    public final void a(x4.e eVar) {
        boolean z9 = eVar.K;
        View view = this.itemView;
        if (z9) {
            view.setAlpha(0.3f);
        } else {
            view.setAlpha(1.0f);
        }
        ConcurrentHashMap concurrentHashMap = j5.t.f6708a;
        Context context = this.itemView.getContext();
        context.getClass();
        this.f7296b.setImageDrawable(j5.t.b(context, eVar.f11123l));
        this.f7297l.setText(eVar.f11122b);
        this.f7298m.setText(eVar.f11125n);
        long j = eVar.f11133w;
        Context context2 = this.itemView.getContext();
        context2.getClass();
        this.f7299n.setText(i5.H(context2, j));
        long j6 = eVar.f11134x;
        this.f7300o.setText(j6 <= 0 ? null : new SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(new Date(j6)));
        float f = UptodownApp.I;
        String string = this.itemView.getContext().getString(2131951954);
        TextView textView = this.f7301p;
        textView.setText(string);
        textView.setVisibility(0);
    }
}
