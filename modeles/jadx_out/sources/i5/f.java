package i5;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends Presenter.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f5683a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f5684b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f5685l;

    /* renamed from: m, reason: collision with root package name */
    public final ProgressBar f5686m;

    public f(View view) {
        super(view);
        View findViewById = view.findViewById(2131364093);
        findViewById.getClass();
        TextView textView = (TextView) findViewById;
        this.f5683a = textView;
        View findViewById2 = view.findViewById(2131364301);
        findViewById2.getClass();
        TextView textView2 = (TextView) findViewById2;
        this.f5684b = textView2;
        View findViewById3 = view.findViewById(2131363744);
        findViewById3.getClass();
        TextView textView3 = (TextView) findViewById3;
        this.f5685l = textView3;
        View findViewById4 = view.findViewById(2131363051);
        findViewById4.getClass();
        this.f5686m = (ProgressBar) findViewById4;
        textView.setTypeface(f4.c.f4883x);
        textView2.setTypeface(f4.c.f4883x);
        textView3.setTypeface(f4.c.f4883x);
    }
}
