package c;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class d extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f1135a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f1136b;

    /* renamed from: l, reason: collision with root package name */
    public final n9.a f1137l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f1138m;

    /* renamed from: n, reason: collision with root package name */
    public final View f1139n;

    public d(View view, Integer num, Integer num2, n9.a aVar) {
        super(view);
        this.f1135a = num;
        this.f1136b = num2;
        this.f1137l = aVar;
        View findViewById = view.findViewById(2131364347);
        findViewById.getClass();
        this.f1138m = (TextView) findViewById;
        View findViewById2 = view.findViewById(2131362284);
        findViewById2.getClass();
        this.f1139n = findViewById2;
    }
}
