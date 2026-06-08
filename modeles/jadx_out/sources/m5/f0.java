package m5;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final w4.k f7376a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f7377b;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f7378l;

    public f0(View view, String str, w4.k kVar) {
        super(view);
        this.f7376a = kVar;
        View findViewById = view.findViewById(2131364025);
        findViewById.getClass();
        TextView textView = (TextView) findViewById;
        this.f7377b = textView;
        this.f7378l = (ImageView) view.findViewById(2131362438);
        textView.setTypeface(f4.c.f4882w);
        textView.setText(str);
    }
}
