package i5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.google.android.gms.internal.measurement.z3;
import n4.i;
import x4.q2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends Presenter.ViewHolder {

    /* renamed from: a, reason: collision with root package name */
    public Context f5670a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f5671b;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f5672l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f5673m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f5674n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f5675o;

    public final boolean a(x4.e eVar) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = this.f5670a.getPackageManager();
            packageManager.getClass();
            String str = eVar.f11123l;
            str.getClass();
            applicationInfo = i.b(packageManager, str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        return eVar.v == 0 && applicationInfo != null && applicationInfo.enabled;
    }

    public final void b(q2 q2Var, TextView textView, TextView textView2) {
        Context context = this.f5670a;
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
}
