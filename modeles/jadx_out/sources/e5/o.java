package e5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.google.android.gms.internal.measurement.i5;
import java.io.File;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import l7.u;
import x4.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o extends Presenter {

    /* renamed from: a, reason: collision with root package name */
    public int f4751a;

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        if (obj instanceof r) {
            r rVar = (r) obj;
            i5.f fVar = (i5.f) viewHolder;
            Context context = viewHolder.view.getContext();
            TextView textView = fVar.f5683a;
            TextView textView2 = fVar.f5684b;
            ProgressBar progressBar = fVar.f5686m;
            TextView textView3 = fVar.f5685l;
            if (context != null) {
                textView.setText(rVar.f11366w + " " + rVar.f11359o);
                textView.setTypeface(f4.c.f4883x);
                textView2.setTypeface(f4.c.f4883x);
                textView3.setTypeface(f4.c.f4883x);
                if (rVar.i() > 0 && rVar.i() < 100) {
                    textView2.setText(String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(rVar.i())}, 1)));
                    textView3.setVisibility(8);
                    progressBar.setProgress(rVar.i());
                    progressBar.setVisibility(0);
                    return;
                }
                l4.a c9 = f4.a.f4869a.c();
                if (c9 != null && u.m0(c9.f7095a, rVar.f11355b, true)) {
                    long j = rVar.f11358n;
                    if (j > 0 && c9.f7096b == j) {
                        progressBar.setIndeterminate(true);
                        progressBar.setVisibility(0);
                        textView3.setText(2131952095);
                        textView2.setText(i5.H(context, rVar.j()));
                        return;
                    }
                }
                File g = rVar.g();
                if (g != null) {
                    long lastModified = g.lastModified();
                    DateFormat dateTimeInstance = DateFormat.getDateTimeInstance();
                    textView3.setVisibility(0);
                    textView3.setText(dateTimeInstance.format(new Date(lastModified)));
                    textView2.setText(i5.H(context, rVar.k()));
                    progressBar.setVisibility(4);
                }
            }
        }
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558841, viewGroup, false);
        this.f4751a = ContextCompat.getColor(viewGroup.getContext(), 2131099686);
        ContextCompat.getColor(viewGroup.getContext(), 2131099714);
        s6.setFocusable(true);
        s6.setFocusableInTouchMode(true);
        s6.setBackgroundColor(this.f4751a);
        return new i5.f(s6);
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
    }
}
