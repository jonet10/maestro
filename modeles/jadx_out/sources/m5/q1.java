package m5;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q1 extends RecyclerView.ViewHolder {

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f7537s = 0;

    /* renamed from: a, reason: collision with root package name */
    public final a3.d f7538a;

    /* renamed from: b, reason: collision with root package name */
    public final LinearLayout f7539b;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f7540l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f7541m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f7542n;

    /* renamed from: o, reason: collision with root package name */
    public final RelativeLayout f7543o;

    /* renamed from: p, reason: collision with root package name */
    public final ImageView f7544p;

    /* renamed from: q, reason: collision with root package name */
    public final int f7545q;

    /* renamed from: r, reason: collision with root package name */
    public long f7546r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q1(View view, a3.d dVar) {
        super(view);
        dVar.getClass();
        this.f7538a = dVar;
        View findViewById = view.findViewById(2131362761);
        findViewById.getClass();
        this.f7539b = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(2131364512);
        findViewById2.getClass();
        View findViewById3 = view.findViewById(2131362475);
        findViewById3.getClass();
        this.f7540l = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(2131364363);
        findViewById4.getClass();
        TextView textView = (TextView) findViewById4;
        this.f7541m = textView;
        View findViewById5 = view.findViewById(2131364010);
        findViewById5.getClass();
        TextView textView2 = (TextView) findViewById5;
        this.f7542n = textView2;
        View findViewById6 = view.findViewById(2131363248);
        findViewById6.getClass();
        this.f7543o = (RelativeLayout) findViewById6;
        View findViewById7 = view.findViewById(2131362459);
        findViewById7.getClass();
        this.f7544p = (ImageView) findViewById7;
        this.f7545q = 600;
        ((TextView) findViewById2).setTypeface(f4.c.f4882w);
        textView.setTypeface(f4.c.f4883x);
        textView2.setTypeface(f4.c.f4883x);
    }
}
