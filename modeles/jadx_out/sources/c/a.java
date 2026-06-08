package c;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class a extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f1126a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f1127b;

    /* renamed from: l, reason: collision with root package name */
    public final n9.a f1128l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f1129m;

    /* renamed from: n, reason: collision with root package name */
    public final View f1130n;

    public a(View view, Integer num, Integer num2, n9.a aVar) {
        super(view);
        this.f1126a = num;
        this.f1127b = num2;
        this.f1128l = aVar;
        View findViewById = view.findViewById(2131364094);
        findViewById.getClass();
        this.f1129m = (TextView) findViewById;
        View findViewById2 = view.findViewById(2131362284);
        findViewById2.getClass();
        this.f1130n = findViewById2;
    }
}
