package m5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final w4.j f7629a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f7630b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f7631l;

    /* renamed from: m, reason: collision with root package name */
    public final e4.u0 f7632m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(View view, w4.j jVar, w4.a aVar) {
        super(view);
        jVar.getClass();
        aVar.getClass();
        this.f7629a = jVar;
        View findViewById = view.findViewById(2131363271);
        findViewById.getClass();
        this.f7630b = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(2131364402);
        findViewById2.getClass();
        TextView textView = (TextView) findViewById2;
        this.f7631l = textView;
        View findViewById3 = view.findViewById(2131363327);
        findViewById3.getClass();
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        e4.u0 u0Var = new e4.u0(jVar, aVar);
        this.f7632m = u0Var;
        textView.setTypeface(f4.c.f4882w);
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(u0Var);
    }
}
