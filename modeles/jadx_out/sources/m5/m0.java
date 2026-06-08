package m5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final w4.b f7472a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f7473b;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f7474l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f7475m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f7476n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f7477o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(View view, w4.b bVar, Context context) {
        super(view);
        context.getClass();
        this.f7472a = bVar;
        this.f7473b = context;
        View findViewById = view.findViewById(2131362383);
        findViewById.getClass();
        this.f7474l = (ImageView) findViewById;
        View findViewById2 = view.findViewById(2131364035);
        findViewById2.getClass();
        TextView textView = (TextView) findViewById2;
        this.f7475m = textView;
        View findViewById3 = view.findViewById(2131364559);
        findViewById3.getClass();
        TextView textView2 = (TextView) findViewById3;
        this.f7476n = textView2;
        View findViewById4 = view.findViewById(2131363731);
        findViewById4.getClass();
        TextView textView3 = (TextView) findViewById4;
        this.f7477o = textView3;
        view.setOnClickListener(new c4.d(this, 28));
        textView.setTypeface(f4.c.f4882w);
        textView2.setTypeface(f4.c.f4883x);
        textView3.setTypeface(f4.c.f4883x);
    }
}
