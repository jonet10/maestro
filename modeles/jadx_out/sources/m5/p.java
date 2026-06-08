package m5;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f7499a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f7500b;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f7501l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f7502m;

    public p(View view) {
        super(view);
        View findViewById = view.findViewById(2131364029);
        findViewById.getClass();
        TextView textView = (TextView) findViewById;
        this.f7499a = textView;
        View findViewById2 = view.findViewById(2131363764);
        findViewById2.getClass();
        TextView textView2 = (TextView) findViewById2;
        this.f7500b = textView2;
        View findViewById3 = view.findViewById(2131362415);
        findViewById3.getClass();
        this.f7501l = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(2131363910);
        findViewById4.getClass();
        TextView textView3 = (TextView) findViewById4;
        this.f7502m = textView3;
        textView.setTypeface(f4.c.f4882w);
        textView2.setTypeface(f4.c.f4883x);
        textView3.setTypeface(f4.c.f4882w);
    }
}
