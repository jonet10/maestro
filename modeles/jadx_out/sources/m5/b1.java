package m5;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b1 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f7317a;

    public b1(View view, String str) {
        super(view);
        View findViewById = view.findViewById(2131364353);
        findViewById.getClass();
        TextView textView = (TextView) findViewById;
        this.f7317a = textView;
        textView.setTypeface(f4.c.f4882w);
        textView.setText(str);
    }

    public final void a() {
        this.f7317a.setVisibility(0);
    }
}
