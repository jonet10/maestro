package r4;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import f0.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final i f8901a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f8902b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f8903l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f8904m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f8905n;

    /* renamed from: o, reason: collision with root package name */
    public final CheckBox f8906o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View view, i iVar) {
        super(view);
        iVar.getClass();
        this.f8901a = iVar;
        View findViewById = view.findViewById(2131362378);
        findViewById.getClass();
        this.f8902b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(2131364041);
        findViewById2.getClass();
        TextView textView = (TextView) findViewById2;
        this.f8903l = textView;
        View findViewById3 = view.findViewById(2131363746);
        findViewById3.getClass();
        TextView textView2 = (TextView) findViewById3;
        this.f8904m = textView2;
        View findViewById4 = view.findViewById(2131364304);
        findViewById4.getClass();
        TextView textView3 = (TextView) findViewById4;
        this.f8905n = textView3;
        View findViewById5 = view.findViewById(2131362001);
        findViewById5.getClass();
        this.f8906o = (CheckBox) findViewById5;
        textView.setTypeface(f4.c.f4883x);
        textView2.setTypeface(f4.c.f4883x);
        textView3.setTypeface(f4.c.f4882w);
    }
}
