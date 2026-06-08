package e4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import x4.q2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f4602a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.c f4603b;

    /* renamed from: c, reason: collision with root package name */
    public final w4.d f4604c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4605d;

    public l0(ArrayList arrayList, w4.c cVar, w4.d dVar) {
        cVar.getClass();
        dVar.getClass();
        this.f4602a = arrayList;
        this.f4603b = cVar;
        this.f4604c = dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4602a.size() + (this.f4605d ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return i == this.f4602a.size() ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        x4.e eVar;
        x4.r K;
        viewHolder.getClass();
        if (viewHolder instanceof m5.y0) {
            Object obj = this.f4602a.get(i);
            obj.getClass();
            x4.g gVar = (x4.g) obj;
            m5.y0 y0Var = (m5.y0) viewHolder;
            t4.v0 v0Var = y0Var.f7639b;
            RelativeLayout relativeLayout = v0Var.f10159a;
            TextView textView = v0Var.f10164o;
            relativeLayout.getClass();
            m5.e.b(relativeLayout, y0Var.f7640l, gVar);
            m5.e.f(gVar, v0Var.f10166q, v0Var.f10165p);
            y0Var.e(v0Var.f10161l, gVar.i());
            textView.setOnClickListener(new m5.x0(y0Var, gVar, i, 0));
            v0Var.f10160b.setOnClickListener(new g4.a(i, y0Var, 2, gVar));
            e1.c0 c0Var = j5.g.D;
            Context context = y0Var.itemView.getContext();
            context.getClass();
            j5.g l10 = c0Var.l(context);
            l10.b();
            String str = gVar.F;
            q2 q2Var = null;
            if (str == null || str.length() == 0) {
                eVar = null;
            } else {
                String str2 = gVar.F;
                str2.getClass();
                eVar = l10.B(str2);
            }
            long j = gVar.f11158a;
            boolean z9 = a5.b.c(j) || a5.c.b(j);
            if (z9) {
                long j6 = gVar.f11158a;
                if (a5.b.c(j6)) {
                    K = a5.b.b();
                } else {
                    if (a5.c.b(j6)) {
                        K = a5.c.a();
                    }
                    K = null;
                }
            } else {
                String str3 = gVar.F;
                if (str3 != null && str3.length() != 0) {
                    String str4 = gVar.F;
                    str4.getClass();
                    K = l10.K(str4);
                }
                K = null;
            }
            if (eVar != null) {
                String str5 = gVar.F;
                if (str5 != null && str5.length() != 0) {
                    String str6 = gVar.F;
                    str6.getClass();
                    q2Var = l10.Y(str6);
                }
                l4.a c9 = f4.a.f4869a.c();
                if (c9 != null && l7.u.m0(c9.f7095a, eVar.f11123l, true)) {
                    y0Var.k();
                } else if (q2Var == null || q2Var.c() || eVar.v == 1) {
                    y0Var.g();
                    textView.setText(2131952419);
                    z3.J(textView);
                } else {
                    if (!z9 || K == null) {
                        float f = UptodownApp.I;
                        if (!b4.d.m(q2Var.f11344b)) {
                            String string = y0Var.itemView.getContext().getString(2131951657);
                            string.getClass();
                            y0Var.h(string);
                        }
                    }
                    K.getClass();
                    y0Var.i(K.i(), K.k());
                }
            } else if (K == null) {
                String string2 = y0Var.itemView.getContext().getString(2131952428);
                string2.getClass();
                y0Var.h(string2);
            } else if (K.n()) {
                y0Var.j(gVar, i);
            } else if (K.c()) {
                y0Var.j(gVar, i);
            } else if (z9 || K.m()) {
                y0Var.i(K.i(), K.k());
            } else {
                String string3 = y0Var.itemView.getContext().getString(2131952428);
                string3.getClass();
                y0Var.h(string3);
            }
            l10.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        if (i != 0) {
            if (i != 1) {
                com.google.gson.internal.a.p("viewType unknown");
                return null;
            }
            View b7 = c.j.b(viewGroup, 2131558768, viewGroup, false);
            b7.getClass();
            return new m5.c0(b7);
        }
        View b10 = c.j.b(viewGroup, 2131558812, null, false);
        int i6 = 2131362317;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(b10, 2131362317);
        if (imageView != null) {
            i6 = 2131362386;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(b10, 2131362386);
            if (imageView2 != null) {
                i6 = 2131363018;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(b10, 2131363018);
                if (progressBar != null) {
                    i6 = 2131363104;
                    if (((RelativeLayout) ViewBindings.findChildViewById(b10, 2131363104)) != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) b10;
                        i6 = 2131363133;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(b10, 2131363133);
                        if (relativeLayout2 != null) {
                            i6 = 2131363200;
                            if (((RelativeLayout) ViewBindings.findChildViewById(b10, 2131363200)) != null) {
                                i6 = 2131363623;
                                TextView textView = (TextView) ViewBindings.findChildViewById(b10, 2131363623);
                                if (textView != null) {
                                    i6 = 2131363777;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(b10, 2131363777);
                                    if (textView2 != null) {
                                        i6 = 2131364056;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(b10, 2131364056);
                                        if (textView3 != null) {
                                            i6 = 2131364154;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(b10, 2131364154);
                                            if (textView4 != null) {
                                                i6 = 2131364340;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(b10, 2131364340);
                                                if (textView5 != null) {
                                                    i6 = 2131364547;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(b10, 2131364547);
                                                    if (textView6 != null) {
                                                        return new m5.y0(new t4.v0(relativeLayout, imageView, imageView2, progressBar, relativeLayout2, textView, textView2, textView3, textView4, textView5, textView6), this.f4603b, this.f4604c);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(b10.getResources().getResourceName(i6)));
        return null;
    }
}
