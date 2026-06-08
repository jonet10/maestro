package e4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.internal.measurement.i5;
import com.uptodown.UptodownApp;
import com.uptodown.util.views.UsernameTextView;
import java.util.ArrayList;
import x4.u2;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4496a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.h f4497b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4498c;

    public c(ArrayList arrayList, w4.h hVar) {
        arrayList.getClass();
        hVar.getClass();
        this.f4496a = arrayList;
        this.f4497b = hVar;
    }

    public final void a(boolean z9) {
        this.f4498c = z9;
        if (z9) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4496a.size() + (this.f4498c ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        ArrayList arrayList = this.f4496a;
        if (i == arrayList.size()) {
            return 2;
        }
        Object obj = arrayList.get(i);
        obj.getClass();
        return kotlin.jvm.internal.l.a(((x4.d1) obj).f11092b, "subscription") ? 1 : 0;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.getClass();
        boolean z9 = viewHolder instanceof m5.l;
        ArrayList arrayList = this.f4496a;
        if (!z9) {
            if (viewHolder instanceof m5.n) {
                final m5.n nVar = (m5.n) viewHolder;
                Object obj = arrayList.get(i);
                obj.getClass();
                final x4.d1 d1Var = (x4.d1) obj;
                a4.g0 d10 = a4.g0.d();
                String str = d1Var.f11098q;
                a4.l0 e10 = d10.e(str != null ? a4.x.k(str, UptodownApp.R, ":webp") : null);
                float f = UptodownApp.I;
                Context context = nVar.f7482l;
                context.getClass();
                e10.h(b4.d.x(context));
                g2.e eVar = nVar.f7480a;
                ImageView imageView = (ImageView) eVar.f5119l;
                ImageView imageView2 = (ImageView) eVar.f5120m;
                TextView textView = (TextView) eVar.f5124q;
                UsernameTextView usernameTextView = (UsernameTextView) eVar.f5126s;
                e10.e(imageView, null);
                ((ImageView) eVar.f5121n).setImageDrawable(ContextCompat.getDrawable(context, 2131231337));
                final int i6 = 0;
                ((RelativeLayout) eVar.f5122o).setOnClickListener(new View.OnClickListener() { // from class: m5.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i6) {
                            case 0:
                                nVar.f7481b.j(d1Var.f11093l);
                                break;
                            default:
                                nVar.f7481b.j(d1Var.f11093l);
                                break;
                        }
                    }
                });
                int i10 = d1Var.f11097p;
                ImageView imageView3 = (ImageView) eVar.f5119l;
                if (i10 == 1) {
                    int dimension = (int) imageView3.getContext().getResources().getDimension(2131165270);
                    imageView3.setForeground(ContextCompat.getDrawable(imageView3.getContext(), 2131231271));
                    imageView3.setPadding(dimension, dimension, dimension, dimension);
                    imageView2.setVisibility(0);
                } else {
                    imageView3.setForeground(null);
                    imageView3.setPadding(0, 0, 0, 0);
                    imageView2.setVisibility(8);
                }
                usernameTextView.setText(d1Var.f11094m);
                int i11 = UsernameTextView.f3452s;
                final int i12 = 1;
                i5.g(usernameTextView, d1Var.f11097p == 1, d1Var.f11100s);
                usernameTextView.setOnClickListener(new View.OnClickListener() { // from class: m5.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        switch (i12) {
                            case 0:
                                nVar.f7481b.j(d1Var.f11093l);
                                break;
                            default:
                                nVar.f7481b.j(d1Var.f11093l);
                                break;
                        }
                    }
                });
                ((TextView) eVar.f5123p).setText(d1Var.f11096o);
                ((TextView) eVar.f5125r).setText(d1Var.f11099r);
                w2 h = u2.h(context);
                if (h == null || !h.d()) {
                    textView.setVisibility(8);
                    return;
                } else {
                    textView.setOnClickListener(new c4.d(nVar, 27));
                    textView.setVisibility(0);
                    return;
                }
            }
            return;
        }
        final m5.l lVar = (m5.l) viewHolder;
        Object obj2 = arrayList.get(i);
        obj2.getClass();
        final x4.d1 d1Var2 = (x4.d1) obj2;
        Context context2 = lVar.f7453l;
        g2.e eVar2 = lVar.f7451a;
        a4.g0 d11 = a4.g0.d();
        String str2 = d1Var2.f11098q;
        a4.l0 e11 = d11.e(str2 != null ? a4.x.k(str2, UptodownApp.J, ":webp") : null);
        float f10 = UptodownApp.I;
        context2.getClass();
        e11.g(b4.d.f(context2));
        e11.h(b4.d.y(context2));
        ImageView imageView4 = (ImageView) eVar2.f5120m;
        ImageView imageView5 = (ImageView) eVar2.f5121n;
        ImageView imageView6 = (ImageView) eVar2.f5123p;
        FrameLayout frameLayout = (FrameLayout) eVar2.f5119l;
        UsernameTextView usernameTextView2 = (UsernameTextView) eVar2.f5126s;
        e11.e(imageView4, null);
        final int i13 = 4;
        ((ImageView) eVar2.f5120m).setOnClickListener(new View.OnClickListener() { // from class: m5.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i13) {
                    case 0:
                        w4.h hVar = lVar.f7452b;
                        x4.d1 d1Var3 = d1Var2;
                        hVar.z(d1Var3.B, d1Var3.D);
                        break;
                    case 1:
                        lVar.f7452b.v(d1Var2);
                        break;
                    case 2:
                        w4.h hVar2 = lVar.f7452b;
                        x4.d1 d1Var4 = d1Var2;
                        hVar2.z(d1Var4.B, d1Var4.D);
                        break;
                    case 3:
                        w4.h hVar3 = lVar.f7452b;
                        x4.d1 d1Var5 = d1Var2;
                        hVar3.t(d1Var5.f11093l, d1Var5.f11094m);
                        break;
                    case 4:
                        lVar.f7452b.j(d1Var2.f11093l);
                        break;
                    case 5:
                        lVar.f7452b.j(d1Var2.f11093l);
                        break;
                    case 6:
                        lVar.f7452b.w(d1Var2.f11093l);
                        break;
                    default:
                        w4.h hVar4 = lVar.f7452b;
                        x4.d1 d1Var6 = d1Var2;
                        hVar4.z(d1Var6.B, d1Var6.D);
                        break;
                }
            }
        });
        int i14 = d1Var2.f11097p;
        ImageView imageView7 = (ImageView) eVar2.f5122o;
        if (i14 == 1) {
            imageView7.setVisibility(0);
        } else {
            imageView7.setVisibility(8);
        }
        usernameTextView2.setText(d1Var2.f11094m);
        int i15 = UsernameTextView.f3452s;
        i5.g(usernameTextView2, d1Var2.f11097p == 1, d1Var2.f11100s);
        final int i16 = 5;
        usernameTextView2.setOnClickListener(new View.OnClickListener() { // from class: m5.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i16) {
                    case 0:
                        w4.h hVar = lVar.f7452b;
                        x4.d1 d1Var3 = d1Var2;
                        hVar.z(d1Var3.B, d1Var3.D);
                        break;
                    case 1:
                        lVar.f7452b.v(d1Var2);
                        break;
                    case 2:
                        w4.h hVar2 = lVar.f7452b;
                        x4.d1 d1Var4 = d1Var2;
                        hVar2.z(d1Var4.B, d1Var4.D);
                        break;
                    case 3:
                        w4.h hVar3 = lVar.f7452b;
                        x4.d1 d1Var5 = d1Var2;
                        hVar3.t(d1Var5.f11093l, d1Var5.f11094m);
                        break;
                    case 4:
                        lVar.f7452b.j(d1Var2.f11093l);
                        break;
                    case 5:
                        lVar.f7452b.j(d1Var2.f11093l);
                        break;
                    case 6:
                        lVar.f7452b.w(d1Var2.f11093l);
                        break;
                    default:
                        w4.h hVar4 = lVar.f7452b;
                        x4.d1 d1Var6 = d1Var2;
                        hVar4.z(d1Var6.B, d1Var6.D);
                        break;
                }
            }
        });
        ((TextView) eVar2.f5124q).setText(d1Var2.f11096o);
        ((TextView) eVar2.f5125r).setText(d1Var2.f11099r);
        frameLayout.setVisibility(0);
        imageView5.setVisibility(8);
        frameLayout.removeAllViews();
        String str3 = d1Var2.f11092b;
        if (str3 != null) {
            switch (str3.hashCode()) {
                case -1268958287:
                    if (str3.equals("follow")) {
                        imageView6.setImageDrawable(ContextCompat.getDrawable(context2, 2131231334));
                        frameLayout.setVisibility(8);
                        imageView5.setVisibility(0);
                        final int i17 = 6;
                        imageView5.setOnClickListener(new View.OnClickListener() { // from class: m5.k
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                switch (i17) {
                                    case 0:
                                        w4.h hVar = lVar.f7452b;
                                        x4.d1 d1Var3 = d1Var2;
                                        hVar.z(d1Var3.B, d1Var3.D);
                                        break;
                                    case 1:
                                        lVar.f7452b.v(d1Var2);
                                        break;
                                    case 2:
                                        w4.h hVar2 = lVar.f7452b;
                                        x4.d1 d1Var4 = d1Var2;
                                        hVar2.z(d1Var4.B, d1Var4.D);
                                        break;
                                    case 3:
                                        w4.h hVar3 = lVar.f7452b;
                                        x4.d1 d1Var5 = d1Var2;
                                        hVar3.t(d1Var5.f11093l, d1Var5.f11094m);
                                        break;
                                    case 4:
                                        lVar.f7452b.j(d1Var2.f11093l);
                                        break;
                                    case 5:
                                        lVar.f7452b.j(d1Var2.f11093l);
                                        break;
                                    case 6:
                                        lVar.f7452b.w(d1Var2.f11093l);
                                        break;
                                    default:
                                        w4.h hVar4 = lVar.f7452b;
                                        x4.d1 d1Var6 = d1Var2;
                                        hVar4.z(d1Var6.B, d1Var6.D);
                                        break;
                                }
                            }
                        });
                        break;
                    }
                    break;
                case -938102371:
                    if (str3.equals("rating")) {
                        g2.e c9 = g2.e.c(LayoutInflater.from(context2));
                        TextView textView2 = (TextView) c9.f5125r;
                        RelativeLayout relativeLayout = (RelativeLayout) c9.f5118b;
                        a4.g0 d12 = a4.g0.d();
                        String str4 = d1Var2.F;
                        a4.l0 e12 = d12.e(str4 != null ? a4.x.k(str4, UptodownApp.K, ":webp") : null);
                        e12.g(b4.d.f(context2));
                        e12.h(b4.d.x(context2));
                        e12.e((ImageView) c9.f5119l, null);
                        imageView6.setImageDrawable(ContextCompat.getDrawable(context2, 2131231336));
                        final int i18 = 7;
                        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: m5.k
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                switch (i18) {
                                    case 0:
                                        w4.h hVar = lVar.f7452b;
                                        x4.d1 d1Var3 = d1Var2;
                                        hVar.z(d1Var3.B, d1Var3.D);
                                        break;
                                    case 1:
                                        lVar.f7452b.v(d1Var2);
                                        break;
                                    case 2:
                                        w4.h hVar2 = lVar.f7452b;
                                        x4.d1 d1Var4 = d1Var2;
                                        hVar2.z(d1Var4.B, d1Var4.D);
                                        break;
                                    case 3:
                                        w4.h hVar3 = lVar.f7452b;
                                        x4.d1 d1Var5 = d1Var2;
                                        hVar3.t(d1Var5.f11093l, d1Var5.f11094m);
                                        break;
                                    case 4:
                                        lVar.f7452b.j(d1Var2.f11093l);
                                        break;
                                    case 5:
                                        lVar.f7452b.j(d1Var2.f11093l);
                                        break;
                                    case 6:
                                        lVar.f7452b.w(d1Var2.f11093l);
                                        break;
                                    default:
                                        w4.h hVar4 = lVar.f7452b;
                                        x4.d1 d1Var6 = d1Var2;
                                        hVar4.z(d1Var6.B, d1Var6.D);
                                        break;
                                }
                            }
                        });
                        textView2.setTypeface(f4.c.f4882w);
                        textView2.setText(d1Var2.C);
                        ((TextView) c9.f5126s).setVisibility(8);
                        lVar.a(d1Var2, c9);
                        frameLayout.addView(relativeLayout);
                        break;
                    }
                    break;
                case 950398559:
                    if (str3.equals("comment")) {
                        g2.e c10 = g2.e.c(LayoutInflater.from(context2));
                        RelativeLayout relativeLayout2 = (RelativeLayout) c10.f5118b;
                        TextView textView3 = (TextView) c10.f5126s;
                        TextView textView4 = (TextView) c10.f5125r;
                        ImageView imageView8 = (ImageView) c10.f5119l;
                        a4.g0 d13 = a4.g0.d();
                        String str5 = d1Var2.F;
                        a4.l0 e13 = d13.e(str5 != null ? a4.x.k(str5, UptodownApp.K, ":webp") : null);
                        e13.g(b4.d.f(context2));
                        e13.h(b4.d.x(context2));
                        e13.e(imageView8, null);
                        imageView6.setImageDrawable(ContextCompat.getDrawable(context2, 2131231336));
                        final int i19 = 0;
                        imageView8.setOnClickListener(new View.OnClickListener() { // from class: m5.k
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                switch (i19) {
                                    case 0:
                                        w4.h hVar = lVar.f7452b;
                                        x4.d1 d1Var3 = d1Var2;
                                        hVar.z(d1Var3.B, d1Var3.D);
                                        break;
                                    case 1:
                                        lVar.f7452b.v(d1Var2);
                                        break;
                                    case 2:
                                        w4.h hVar2 = lVar.f7452b;
                                        x4.d1 d1Var4 = d1Var2;
                                        hVar2.z(d1Var4.B, d1Var4.D);
                                        break;
                                    case 3:
                                        w4.h hVar3 = lVar.f7452b;
                                        x4.d1 d1Var5 = d1Var2;
                                        hVar3.t(d1Var5.f11093l, d1Var5.f11094m);
                                        break;
                                    case 4:
                                        lVar.f7452b.j(d1Var2.f11093l);
                                        break;
                                    case 5:
                                        lVar.f7452b.j(d1Var2.f11093l);
                                        break;
                                    case 6:
                                        lVar.f7452b.w(d1Var2.f11093l);
                                        break;
                                    default:
                                        w4.h hVar4 = lVar.f7452b;
                                        x4.d1 d1Var6 = d1Var2;
                                        hVar4.z(d1Var6.B, d1Var6.D);
                                        break;
                                }
                            }
                        });
                        textView4.setTypeface(f4.c.f4882w);
                        textView4.setText(d1Var2.C);
                        textView3.setTypeface(f4.c.f4883x);
                        textView3.setText(d1Var2.f11102u);
                        final int i20 = 1;
                        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: m5.k
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                switch (i20) {
                                    case 0:
                                        w4.h hVar = lVar.f7452b;
                                        x4.d1 d1Var3 = d1Var2;
                                        hVar.z(d1Var3.B, d1Var3.D);
                                        break;
                                    case 1:
                                        lVar.f7452b.v(d1Var2);
                                        break;
                                    case 2:
                                        w4.h hVar2 = lVar.f7452b;
                                        x4.d1 d1Var4 = d1Var2;
                                        hVar2.z(d1Var4.B, d1Var4.D);
                                        break;
                                    case 3:
                                        w4.h hVar3 = lVar.f7452b;
                                        x4.d1 d1Var5 = d1Var2;
                                        hVar3.t(d1Var5.f11093l, d1Var5.f11094m);
                                        break;
                                    case 4:
                                        lVar.f7452b.j(d1Var2.f11093l);
                                        break;
                                    case 5:
                                        lVar.f7452b.j(d1Var2.f11093l);
                                        break;
                                    case 6:
                                        lVar.f7452b.w(d1Var2.f11093l);
                                        break;
                                    default:
                                        w4.h hVar4 = lVar.f7452b;
                                        x4.d1 d1Var6 = d1Var2;
                                        hVar4.z(d1Var6.B, d1Var6.D);
                                        break;
                                }
                            }
                        });
                        lVar.a(d1Var2, c10);
                        frameLayout.addView(relativeLayout2);
                        break;
                    }
                    break;
                case 1345968512:
                    if (str3.equals("list_add")) {
                        View inflate = LayoutInflater.from(context2).inflate(2131558549, (ViewGroup) null, false);
                        int i21 = 2131362377;
                        ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362377);
                        if (imageView9 != null) {
                            i21 = 2131363642;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate, 2131363642);
                            if (textView5 != null) {
                                i21 = 2131363653;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(inflate, 2131363653);
                                if (textView6 != null) {
                                    i21 = 2131363966;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(inflate, 2131363966);
                                    if (textView7 != null) {
                                        RelativeLayout relativeLayout3 = (RelativeLayout) inflate;
                                        a4.g0 d14 = a4.g0.d();
                                        String str6 = d1Var2.F;
                                        a4.l0 e14 = d14.e(str6 != null ? a4.x.k(str6, UptodownApp.K, ":webp") : null);
                                        e14.h(b4.d.x(context2));
                                        e14.g(b4.d.f(context2));
                                        e14.e(imageView9, null);
                                        imageView6.setImageDrawable(ContextCompat.getDrawable(context2, 2131231335));
                                        final int i22 = 2;
                                        relativeLayout3.setOnClickListener(new View.OnClickListener() { // from class: m5.k
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view) {
                                                switch (i22) {
                                                    case 0:
                                                        w4.h hVar = lVar.f7452b;
                                                        x4.d1 d1Var3 = d1Var2;
                                                        hVar.z(d1Var3.B, d1Var3.D);
                                                        break;
                                                    case 1:
                                                        lVar.f7452b.v(d1Var2);
                                                        break;
                                                    case 2:
                                                        w4.h hVar2 = lVar.f7452b;
                                                        x4.d1 d1Var4 = d1Var2;
                                                        hVar2.z(d1Var4.B, d1Var4.D);
                                                        break;
                                                    case 3:
                                                        w4.h hVar3 = lVar.f7452b;
                                                        x4.d1 d1Var5 = d1Var2;
                                                        hVar3.t(d1Var5.f11093l, d1Var5.f11094m);
                                                        break;
                                                    case 4:
                                                        lVar.f7452b.j(d1Var2.f11093l);
                                                        break;
                                                    case 5:
                                                        lVar.f7452b.j(d1Var2.f11093l);
                                                        break;
                                                    case 6:
                                                        lVar.f7452b.w(d1Var2.f11093l);
                                                        break;
                                                    default:
                                                        w4.h hVar4 = lVar.f7452b;
                                                        x4.d1 d1Var6 = d1Var2;
                                                        hVar4.z(d1Var6.B, d1Var6.D);
                                                        break;
                                                }
                                            }
                                        });
                                        textView7.setTypeface(f4.c.f4882w);
                                        final int i23 = 3;
                                        textView7.setOnClickListener(new View.OnClickListener() { // from class: m5.k
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view) {
                                                switch (i23) {
                                                    case 0:
                                                        w4.h hVar = lVar.f7452b;
                                                        x4.d1 d1Var3 = d1Var2;
                                                        hVar.z(d1Var3.B, d1Var3.D);
                                                        break;
                                                    case 1:
                                                        lVar.f7452b.v(d1Var2);
                                                        break;
                                                    case 2:
                                                        w4.h hVar2 = lVar.f7452b;
                                                        x4.d1 d1Var4 = d1Var2;
                                                        hVar2.z(d1Var4.B, d1Var4.D);
                                                        break;
                                                    case 3:
                                                        w4.h hVar3 = lVar.f7452b;
                                                        x4.d1 d1Var5 = d1Var2;
                                                        hVar3.t(d1Var5.f11093l, d1Var5.f11094m);
                                                        break;
                                                    case 4:
                                                        lVar.f7452b.j(d1Var2.f11093l);
                                                        break;
                                                    case 5:
                                                        lVar.f7452b.j(d1Var2.f11093l);
                                                        break;
                                                    case 6:
                                                        lVar.f7452b.w(d1Var2.f11093l);
                                                        break;
                                                    default:
                                                        w4.h hVar4 = lVar.f7452b;
                                                        x4.d1 d1Var6 = d1Var2;
                                                        hVar4.z(d1Var6.B, d1Var6.D);
                                                        break;
                                                }
                                            }
                                        });
                                        textView5.setTypeface(f4.c.f4882w);
                                        textView5.setText(d1Var2.C);
                                        textView6.setTypeface(f4.c.f4883x);
                                        textView6.setText(d1Var2.E);
                                        frameLayout.addView(relativeLayout3);
                                        break;
                                    }
                                }
                            }
                        }
                        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i21)));
                        break;
                    }
                    break;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        w4.h hVar = this.f4497b;
        int i6 = 2131364525;
        if (i == 0) {
            View b7 = c.j.b(viewGroup, 2131558548, viewGroup, false);
            int i10 = 2131362183;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(b7, 2131362183);
            if (frameLayout != null) {
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(b7, 2131362301);
                if (imageView != null) {
                    i10 = 2131362362;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(b7, 2131362362);
                    if (imageView2 != null) {
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(b7, 2131362525);
                        if (imageView3 != null) {
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(b7, 2131362531);
                            if (imageView4 == null) {
                                i6 = 2131362531;
                            } else if (((RelativeLayout) ViewBindings.findChildViewById(b7, 2131363175)) != null) {
                                TextView textView = (TextView) ViewBindings.findChildViewById(b7, 2131363619);
                                if (textView != null) {
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(b7, 2131364362);
                                    if (textView2 != null) {
                                        UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(b7, 2131364525);
                                        if (usernameTextView != null) {
                                            return new m5.l(new g2.e((RelativeLayout) b7, frameLayout, imageView, imageView2, imageView3, imageView4, textView, textView2, usernameTextView, 2), hVar);
                                        }
                                    } else {
                                        i6 = 2131364362;
                                    }
                                } else {
                                    i6 = 2131363619;
                                }
                            } else {
                                i6 = 2131363175;
                            }
                        } else {
                            i6 = 2131362525;
                        }
                    }
                } else {
                    i6 = 2131362301;
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(b7.getResources().getResourceName(i6)));
                return null;
            }
            i6 = i10;
            com.google.gson.internal.a.i("Missing required view with ID: ".concat(b7.getResources().getResourceName(i6)));
            return null;
        }
        if (i != 1) {
            if (i != 2) {
                com.google.gson.internal.a.p("viewType unknown");
                return null;
            }
            View b10 = c.j.b(viewGroup, 2131558768, viewGroup, false);
            b10.getClass();
            return new m5.c0(b10);
        }
        View b11 = c.j.b(viewGroup, 2131558551, viewGroup, false);
        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(b11, 2131362301);
        if (imageView5 != null) {
            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(b11, 2131362525);
            if (imageView6 != null) {
                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(b11, 2131362531);
                if (imageView7 != null) {
                    int i11 = 2131363121;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(b11, 2131363121);
                    if (relativeLayout != null) {
                        if (((RelativeLayout) ViewBindings.findChildViewById(b11, 2131363175)) != null) {
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(b11, 2131363619);
                            if (textView3 != null) {
                                i11 = 2131364343;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(b11, 2131364343);
                                if (textView4 != null) {
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(b11, 2131364362);
                                    if (textView5 != null) {
                                        UsernameTextView usernameTextView2 = (UsernameTextView) ViewBindings.findChildViewById(b11, 2131364525);
                                        if (usernameTextView2 != null) {
                                            return new m5.n(new g2.e((RelativeLayout) b11, imageView5, imageView6, imageView7, relativeLayout, textView3, textView4, textView5, usernameTextView2, 4), hVar);
                                        }
                                    } else {
                                        i6 = 2131364362;
                                    }
                                }
                            } else {
                                i6 = 2131363619;
                            }
                        } else {
                            i6 = 2131363175;
                        }
                    }
                    i6 = i11;
                } else {
                    i6 = 2131362531;
                }
            } else {
                i6 = 2131362525;
            }
        } else {
            i6 = 2131362301;
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(b11.getResources().getResourceName(i6)));
        return null;
    }
}
