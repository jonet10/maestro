package m5;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c4.ra;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l1 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final ra f7464a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f7465b;

    /* renamed from: l, reason: collision with root package name */
    public final LinearLayout f7466l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f7467m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f7468n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l1(View view, ra raVar) {
        super(view);
        raVar.getClass();
        this.f7464a = raVar;
        View findViewById = view.findViewById(2131364502);
        findViewById.getClass();
        TextView textView = (TextView) findViewById;
        this.f7465b = textView;
        View findViewById2 = view.findViewById(2131362693);
        findViewById2.getClass();
        this.f7466l = (LinearLayout) findViewById2;
        View findViewById3 = view.findViewById(2131363942);
        findViewById3.getClass();
        TextView textView2 = (TextView) findViewById3;
        this.f7467m = textView2;
        View findViewById4 = view.findViewById(2131363716);
        findViewById4.getClass();
        TextView textView3 = (TextView) findViewById4;
        this.f7468n = textView3;
        textView.setTypeface(f4.c.f4882w);
        textView2.setTypeface(f4.c.f4883x);
        textView3.setTypeface(f4.c.f4882w);
    }
}
