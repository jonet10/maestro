package e5;

import android.R;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.google.android.gms.internal.measurement.i5;
import java.util.Arrays;
import java.util.Locale;
import l7.u;
import x4.r;
import x4.t1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p extends Presenter {

    /* renamed from: a, reason: collision with root package name */
    public String f4752a;

    /* renamed from: b, reason: collision with root package name */
    public x4.e f4753b;

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        if (obj == null) {
            return;
        }
        t1 t1Var = (t1) obj;
        i5.g gVar = (i5.g) viewHolder;
        Context context = viewHolder.view.getContext();
        context.getClass();
        String str = this.f4752a;
        x4.e eVar = this.f4753b;
        RelativeLayout relativeLayout = gVar.f5687a;
        ImageView imageView = gVar.f5688b;
        TextView textView = gVar.f5689l;
        ProgressBar progressBar = gVar.f5692o;
        TextView textView2 = gVar.f5690m;
        TextView textView3 = gVar.f5691n;
        TextView textView4 = gVar.f5693p;
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getClass();
            str.getClass();
            ApplicationInfo applicationInfo = n4.i.e(packageManager, str, 0).applicationInfo;
            imageView.setImageDrawable(applicationInfo != null ? applicationInfo.loadIcon(context.getPackageManager()) : null);
        } catch (Exception unused) {
            imageView.setImageDrawable(ContextCompat.getDrawable(context, 2131231475));
        }
        textView.setTypeface(f4.c.f4883x);
        textView2.setTypeface(f4.c.f4883x);
        textView3.setTypeface(f4.c.f4883x);
        textView.setText(eVar != null ? eVar.f11122b : null);
        textView3.setText(t1Var.f11396a);
        progressBar.setVisibility(4);
        textView4.setVisibility(0);
        textView.setTextColor(ContextCompat.getColor(context, 2131100504));
        textView2.setTextColor(ContextCompat.getColor(context, 2131100504));
        textView3.setTextColor(ContextCompat.getColor(context, 2131100504));
        relativeLayout.setBackgroundColor(ContextCompat.getColor(context, 2131100824));
        if ((eVar != null ? Long.valueOf(eVar.f11124m) : null) != null && eVar.f11124m == t1Var.f11399m) {
            textView.setTextColor(ContextCompat.getColor(context, 2131100824));
            textView2.setTextColor(ContextCompat.getColor(context, 2131100824));
            textView3.setTextColor(ContextCompat.getColor(context, 2131100824));
            relativeLayout.setBackgroundColor(ContextCompat.getColor(context, 2131100500));
            textView4.setVisibility(8);
            return;
        }
        j5.g l10 = j5.g.D.l(context);
        l10.b();
        String str2 = t1Var.f11402p;
        str2.getClass();
        r I = l10.I(str2);
        l10.c();
        boolean z9 = I != null && I.i() > 0 && I.i() < 100;
        if (I == null) {
            textView4.setText(2131952712);
            textView4.setBackgroundColor(ContextCompat.getColor(context, 2131099673));
            return;
        }
        if (z9) {
            textView2.setText(String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(I.i())}, 1)));
            textView3.setVisibility(8);
            progressBar.setProgress(I.i());
            progressBar.setVisibility(0);
            textView4.setText(R.string.cancel);
            textView4.setBackgroundColor(ContextCompat.getColor(context, 2131100505));
            return;
        }
        textView3.setVisibility(0);
        long j = t1Var.f11397b;
        if (j > 0) {
            textView2.setText(i5.H(context, j));
        }
        l4.a c9 = f4.a.f4869a.c();
        if (!u.m0(c9 != null ? c9.f7095a : null, I.f11355b, true)) {
            textView4.setText(2131952428);
            textView4.setBackgroundColor(ContextCompat.getColor(context, 2131100500));
        } else {
            progressBar.setIndeterminate(true);
            progressBar.setVisibility(0);
            textView3.setText(2131952095);
            textView2.setText("");
        }
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        viewGroup.getClass();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2131558849, viewGroup, false);
        inflate.setFocusable(true);
        inflate.setFocusableInTouchMode(true);
        inflate.setBackgroundColor(ContextCompat.getColor(viewGroup.getContext(), 2131100824));
        return new i5.g(inflate);
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
    }
}
