package i5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.google.android.gms.internal.measurement.z3;
import n4.i;
import x4.q2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends Presenter.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5676a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f5677b;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f5678l;

    /* renamed from: m, reason: collision with root package name */
    public final TextView f5679m;

    /* renamed from: n, reason: collision with root package name */
    public final TextView f5680n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(View view, Context context) {
        super(view);
        context.getClass();
        this.f5676a = context;
        this.f5677b = (ImageView) view.findViewById(2131362426);
        TextView textView = (TextView) view.findViewById(2131364048);
        this.f5678l = textView;
        TextView textView2 = (TextView) view.findViewById(2131363774);
        this.f5679m = textView2;
        TextView textView3 = (TextView) view.findViewById(2131364337);
        this.f5680n = textView3;
        if (textView != null) {
            textView.setTypeface(f4.c.f4882w);
        }
        if (textView2 != null) {
            textView2.setTypeface(f4.c.f4883x);
        }
        if (textView3 != null) {
            textView3.setTypeface(f4.c.f4883x);
        }
    }

    public final boolean a(x4.e eVar) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = this.f5676a.getPackageManager();
            packageManager.getClass();
            String str = eVar.f11123l;
            str.getClass();
            applicationInfo = i.b(packageManager, str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        return eVar.v == 0 && applicationInfo != null && applicationInfo.enabled;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.d.b(java.lang.Object):void");
    }

    public final void c(q2 q2Var, TextView textView, TextView textView2) {
        Context context = this.f5676a;
        if (q2Var == null || q2Var.c()) {
            textView.setText(context.getString(2131952622));
            textView.setTextColor(ContextCompat.getColor(context, 2131099813));
            textView.setBackground(ContextCompat.getDrawable(context, 2131230859));
        } else {
            textView.setText(context.getString(2131952624));
            z3.N(textView);
        }
        textView.setVisibility(0);
        textView2.setVisibility(8);
    }

    public final void d() {
        ImageView imageView = this.f5677b;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        TextView textView = this.f5678l;
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
        TextView textView2 = this.f5679m;
        if (textView2 != null) {
            textView2.setText((CharSequence) null);
        }
        TextView textView3 = this.f5680n;
        if (textView3 != null) {
            textView3.setText((CharSequence) null);
        }
    }
}
