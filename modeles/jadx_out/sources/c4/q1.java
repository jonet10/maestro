package c4;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.uptodown.UptodownApp;
import com.uptodown.activities.Gallery;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q1 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Gallery f2007a;

    public q1(Gallery gallery) {
        this.f2007a = gallery;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList = this.f2007a.P;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        p1 p1Var = (p1) viewHolder;
        p1Var.getClass();
        ArrayList arrayList = this.f2007a.P;
        arrayList.getClass();
        Object obj = arrayList.get(i);
        obj.getClass();
        Gallery gallery = p1Var.f1977b.f2007a;
        b5.m mVar = p1Var.f1976a;
        ((ProgressBar) mVar.f1063m).setVisibility(0);
        o1 o1Var = new o1(p1Var);
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) mVar.f1062l;
        subsamplingScaleImageView.setTag(o1Var);
        a4.g0 d10 = a4.g0.d();
        String str = ((x4.l2) obj).f11277a;
        a4.l0 e10 = d10.e(str != null ? a4.x.k(str, UptodownApp.P, ":webp") : null);
        a4.g0 g0Var = e10.f134a;
        float f = UptodownApp.I;
        e10.g(b4.d.f(gallery));
        long nanoTime = System.nanoTime();
        StringBuilder sb = a4.t0.f177a;
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Method call should happen from the main thread.");
            return;
        }
        if (e10.f136c) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Fit cannot be used with a Target.");
            return;
        }
        a4.k0 k0Var = e10.f135b;
        int i6 = 1;
        if (((Uri) k0Var.f127b) == null && k0Var.f128c == 0) {
            g0Var.a(o1Var);
            e10.d();
        } else {
            a4.k0 a8 = e10.a(nanoTime);
            StringBuilder sb2 = a4.t0.f177a;
            String a10 = a4.t0.a(a8, sb2);
            sb2.setLength(0);
            Bitmap g = g0Var.g(a10);
            if (g != null) {
                g0Var.a(o1Var);
                o1Var.a(g, 1);
            } else {
                e10.d();
                g0Var.c(new a4.s(g0Var, o1Var, a8, a10, 1));
            }
        }
        subsamplingScaleImageView.setOnClickListener(new n1(gallery, i6));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558562, viewGroup, false);
        int i6 = 2131362396;
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) ViewBindings.findChildViewById(s6, 2131362396);
        if (subsamplingScaleImageView != null) {
            i6 = 2131362999;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(s6, 2131362999);
            if (progressBar != null) {
                return new p1(this, new b5.m((RelativeLayout) s6, subsamplingScaleImageView, progressBar, 27));
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(s6.getResources().getResourceName(i6)));
        return null;
    }
}
