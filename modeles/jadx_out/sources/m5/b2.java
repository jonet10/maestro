package m5;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b2 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final w4.j f7318a;

    /* renamed from: b, reason: collision with root package name */
    public final RelativeLayout f7319b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f7320l;

    /* renamed from: m, reason: collision with root package name */
    public final LinearLayoutManager f7321m;

    /* renamed from: n, reason: collision with root package name */
    public final e4.m1 f7322n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b2(View view, w4.j jVar, w4.a aVar, String str) {
        super(view);
        jVar.getClass();
        aVar.getClass();
        str.getClass();
        this.f7318a = jVar;
        View findViewById = view.findViewById(2131363271);
        findViewById.getClass();
        this.f7319b = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(2131364402);
        findViewById2.getClass();
        TextView textView = (TextView) findViewById2;
        this.f7320l = textView;
        View findViewById3 = view.findViewById(2131363327);
        findViewById3.getClass();
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        boolean z9 = false;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), 0, false);
        this.f7321m = linearLayoutManager;
        Context context = view.getContext();
        context.getClass();
        e4.m1 m1Var = new e4.m1(jVar, aVar, context, str);
        this.f7322n = m1Var;
        new l5.b().attachToRecyclerView(recyclerView);
        textView.setTypeface(f4.c.f4882w);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(m1Var);
        Context context2 = view.getContext();
        context2.getClass();
        try {
            SharedPreferences sharedPreferences = context2.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("app_detail_inflate_view_failed")) {
                z9 = sharedPreferences.getBoolean("app_detail_inflate_view_failed", false);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            return;
        }
        recyclerView.addOnScrollListener(new a2(this));
    }
}
