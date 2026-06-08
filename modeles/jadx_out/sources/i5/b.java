package i5;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends Presenter.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f5661a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f5662b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f5663l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f5664m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f5665n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f5666o;

    /* renamed from: p, reason: collision with root package name */
    public final ProgressBar f5667p;

    /* renamed from: q, reason: collision with root package name */
    public final LinearLayout f5668q;

    /* renamed from: r, reason: collision with root package name */
    public final RelativeLayout f5669r;

    public b(View view) {
        super(view);
        View findViewById = view.findViewById(2131364026);
        findViewById.getClass();
        this.f5661a = (TextView) findViewById;
        View findViewById2 = view.findViewById(2131364284);
        findViewById2.getClass();
        this.f5662b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(2131363783);
        findViewById3.getClass();
        this.f5663l = (TextView) findViewById3;
        View findViewById4 = view.findViewById(2131364157);
        findViewById4.getClass();
        this.f5664m = (TextView) findViewById4;
        View findViewById5 = view.findViewById(2131364556);
        findViewById5.getClass();
        this.f5665n = (TextView) findViewById5;
        View findViewById6 = view.findViewById(2131363669);
        findViewById6.getClass();
        this.f5666o = (TextView) findViewById6;
        View findViewById7 = view.findViewById(2131362996);
        findViewById7.getClass();
        this.f5667p = (ProgressBar) findViewById7;
        this.f5668q = (LinearLayout) view.findViewById(2131362732);
        View findViewById8 = view.findViewById(2131363141);
        findViewById8.getClass();
        this.f5669r = (RelativeLayout) findViewById8;
    }

    public final void a(int i) {
        TextView textView = this.f5664m;
        ProgressBar progressBar = this.f5667p;
        if (i <= 0) {
            progressBar.setVisibility(8);
            textView.setVisibility(8);
        } else {
            progressBar.setVisibility(0);
            progressBar.setProgress(i);
            textView.setVisibility(0);
            textView.setText(String.format("%s%%", Arrays.copyOf(new Object[]{String.valueOf(i)}, 1)));
        }
    }
}
