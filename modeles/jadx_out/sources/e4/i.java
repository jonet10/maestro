package e4;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final w4.j f4555a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.a f4556b;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f4557l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f4558m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f4559n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(View view, w4.j jVar, w4.a aVar) {
        super(view);
        aVar.getClass();
        this.f4555a = jVar;
        this.f4556b = aVar;
        this.f4557l = (ImageView) view.findViewById(2131362356);
        TextView textView = (TextView) view.findViewById(2131364354);
        this.f4558m = textView;
        TextView textView2 = (TextView) view.findViewById(2131364040);
        this.f4559n = textView2;
        textView.setTypeface(f4.c.f4882w);
        textView2.setTypeface(f4.c.f4882w);
    }
}
