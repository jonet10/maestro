package m5;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j1 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final w4.j f7435a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f7436b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f7437l;

    /* renamed from: m, reason: collision with root package name */
    public final e4.m f7438m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(View view, w4.j jVar, w4.a aVar) {
        super(view);
        jVar.getClass();
        aVar.getClass();
        this.f7435a = jVar;
        View findViewById = view.findViewById(2131363271);
        findViewById.getClass();
        this.f7436b = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(2131364402);
        findViewById2.getClass();
        TextView textView = (TextView) findViewById2;
        this.f7437l = textView;
        e4.m mVar = new e4.m(jVar, aVar);
        this.f7438m = mVar;
        View findViewById3 = view.findViewById(2131363327);
        findViewById3.getClass();
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        textView.setTypeface(f4.c.f4882w);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(mVar);
    }
}
