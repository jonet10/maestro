package m5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7578a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f7579b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f7580l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f7581m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(View view, Context context) {
        super(view);
        context.getClass();
        this.f7578a = context;
        View findViewById = view.findViewById(2131362413);
        findViewById.getClass();
        this.f7579b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(2131363637);
        findViewById2.getClass();
        TextView textView = (TextView) findViewById2;
        this.f7580l = textView;
        View findViewById3 = view.findViewById(2131363656);
        findViewById3.getClass();
        TextView textView2 = (TextView) findViewById3;
        this.f7581m = textView2;
        textView.setTypeface(f4.c.f4882w);
        textView2.setTypeface(f4.c.f4883x);
    }
}
