package m5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.util.views.UsernameTextView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q0 extends RecyclerView.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7525a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.d f7526b;

    /* renamed from: l, reason: collision with root package name */
    public final ImageView f7527l;

    /* renamed from: m, reason: collision with root package name */
    public final UsernameTextView f7528m;

    /* renamed from: n, reason: collision with root package name */
    public final ImageView f7529n;

    /* renamed from: o, reason: collision with root package name */
    public final TextView f7530o;

    /* renamed from: p, reason: collision with root package name */
    public final TextView f7531p;

    /* renamed from: q, reason: collision with root package name */
    public final LinearLayout f7532q;

    /* renamed from: r, reason: collision with root package name */
    public final ImageView f7533r;

    /* renamed from: s, reason: collision with root package name */
    public final TextView f7534s;

    /* renamed from: t, reason: collision with root package name */
    public final ImageView f7535t;

    /* renamed from: u, reason: collision with root package name */
    public final ImageView f7536u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(a3.d dVar, Context context, View view) {
        super(view);
        context.getClass();
        dVar.getClass();
        this.f7525a = context;
        this.f7526b = dVar;
        View findViewById = view.findViewById(2131362304);
        findViewById.getClass();
        this.f7527l = (ImageView) findViewById;
        View findViewById2 = view.findViewById(2131364527);
        findViewById2.getClass();
        UsernameTextView usernameTextView = (UsernameTextView) findViewById2;
        this.f7528m = usernameTextView;
        View findViewById3 = view.findViewById(2131362299);
        findViewById3.getClass();
        this.f7529n = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(2131363751);
        findViewById4.getClass();
        TextView textView = (TextView) findViewById4;
        this.f7530o = textView;
        View findViewById5 = view.findViewById(2131363682);
        findViewById5.getClass();
        TextView textView2 = (TextView) findViewById5;
        this.f7531p = textView2;
        View findViewById6 = view.findViewById(2131362678);
        findViewById6.getClass();
        this.f7532q = (LinearLayout) findViewById6;
        View findViewById7 = view.findViewById(2131362404);
        findViewById7.getClass();
        this.f7533r = (ImageView) findViewById7;
        View findViewById8 = view.findViewById(2131363960);
        findViewById8.getClass();
        TextView textView3 = (TextView) findViewById8;
        this.f7534s = textView3;
        View findViewById9 = view.findViewById(2131362528);
        findViewById9.getClass();
        ImageView imageView = (ImageView) findViewById9;
        this.f7535t = imageView;
        View findViewById10 = view.findViewById(2131362363);
        findViewById10.getClass();
        this.f7536u = (ImageView) findViewById10;
        usernameTextView.setTypeface(f4.c.f4882w);
        textView.setTypeface(f4.c.f4883x);
        textView2.setTypeface(f4.c.f4883x);
        textView3.setTypeface(f4.c.f4883x);
        imageView.setVisibility(8);
    }
}
