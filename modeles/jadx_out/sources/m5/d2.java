package m5;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c4.ra;
import j$.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d2 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final LinearLayout f7368a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d2(View view, ra raVar) {
        super(view);
        raVar.getClass();
        View findViewById = view.findViewById(2131362694);
        findViewById.getClass();
        this.f7368a = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(2131364092);
        findViewById2.getClass();
        TextView textView = (TextView) findViewById2;
        View findViewById3 = view.findViewById(2131363890);
        findViewById3.getClass();
        TextView textView2 = (TextView) findViewById3;
        textView.setTypeface(f4.c.f4883x);
        ConcurrentHashMap concurrentHashMap = j5.t.f6708a;
        textView.setText(j5.t.a(view.getContext().getString(2131952043)));
        textView2.setTypeface(f4.c.f4882w);
        textView2.setOnClickListener(new u0(raVar, 6));
    }
}
