package e4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import m5.y1;
import x4.a3;
import x4.q2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e1 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4519a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f4520b;

    /* renamed from: c, reason: collision with root package name */
    public final f0.i f4521c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4522d;

    /* renamed from: e, reason: collision with root package name */
    public int f4523e;

    public e1(ArrayList arrayList, Context context, f0.i iVar) {
        arrayList.getClass();
        context.getClass();
        iVar.getClass();
        this.f4519a = arrayList;
        this.f4520b = context;
        this.f4521c = iVar;
        this.f4523e = -1;
    }

    public final void a(Context context, File file) {
        file.getClass();
        j5.g l10 = j5.g.D.l(context);
        l10.b();
        Iterator it = this.f4519a.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            int i6 = i + 1;
            a3 a3Var = (a3) it.next();
            String str = a3Var.f11049d;
            if (str != null && str.length() != 0) {
                String str2 = a3Var.f11049d;
                str2.getClass();
                q2 Y = l10.Y(str2);
                x4.r a8 = Y != null ? Y.a(context) : null;
                if (a8 != null && a8.F.size() == 1 && l7.u.m0(((x4.j0) a8.F.get(0)).f11240q, file.getAbsolutePath(), true)) {
                    break;
                }
            }
            i = i6;
        }
        l10.c();
        if (i >= 0) {
            notifyItemChanged(i);
        }
    }

    public final void b() {
        this.f4523e = -1;
        notifyDataSetChanged();
    }

    public final void c(Context context, File file) {
        j5.g l10 = j5.g.D.l(context);
        l10.b();
        Iterator it = this.f4519a.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int i6 = i + 1;
            a3 a3Var = (a3) it.next();
            String str = a3Var.f11049d;
            if (str != null && str.length() != 0) {
                String str2 = a3Var.f11049d;
                str2.getClass();
                q2 Y = l10.Y(str2);
                x4.r a8 = Y != null ? Y.a(context) : null;
                if (a8 != null && a8.F.size() == 1 && l7.u.m0(((x4.j0) a8.F.get(0)).f11240q, file.getAbsolutePath(), true)) {
                    this.f4523e = i;
                    break;
                }
            }
            i = i6;
        }
        l10.c();
        int i10 = this.f4523e;
        if (i10 >= 0) {
            notifyItemChanged(i10);
        }
    }

    public final void d(boolean z9) {
        this.f4522d = z9;
        if (z9) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4519a.size() + (this.f4522d ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return i == this.f4519a.size() ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        x4.e eVar;
        x4.r K;
        q2 q2Var;
        int i6;
        String str;
        viewHolder.getClass();
        if (viewHolder instanceof y1) {
            y1 y1Var = (y1) viewHolder;
            Object obj = this.f4519a.get(i);
            obj.getClass();
            a3 a3Var = (a3) obj;
            boolean z9 = this.f4523e == i;
            Context context = y1Var.f7643l;
            t4.g1 g1Var = y1Var.f7642b;
            LinearLayout linearLayout = g1Var.f9825n;
            ProgressBar progressBar = g1Var.f9826o;
            ImageView imageView = g1Var.f9823l;
            RelativeLayout relativeLayout = g1Var.f9828q;
            ImageView imageView2 = g1Var.f9824m;
            TextView textView = g1Var.f9830s;
            linearLayout.removeAllViews();
            ArrayList arrayList = a3Var.h;
            if (!arrayList.isEmpty()) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMarginStart((int) context.getResources().getDimension(2131166252));
                Iterator it = arrayList.iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    int i11 = i10 + 1;
                    x4.j jVar = (x4.j) it.next();
                    boolean z10 = z9;
                    Iterator it2 = it;
                    View inflate = LayoutInflater.from(context).inflate(2131558874, (ViewGroup) null);
                    inflate.getClass();
                    TextView textView2 = (TextView) inflate;
                    textView2.setText(jVar.f11225b);
                    textView2.setTypeface(f4.c.f4883x);
                    LinearLayout linearLayout2 = g1Var.f9825n;
                    if (i10 > 0) {
                        linearLayout2.addView(inflate, layoutParams);
                    } else {
                        linearLayout2.addView(inflate);
                    }
                    textView2.setOnClickListener(new c4.t(y1Var, a3Var, jVar, 15));
                    i10 = i11;
                    z9 = z10;
                    it = it2;
                }
            }
            boolean z11 = z9;
            a4.l0 e10 = a4.g0.d().e(a3Var.a());
            float f = UptodownApp.I;
            e10.g(b4.d.f(context));
            e10.h(b4.d.x(context));
            e10.e(imageView2, null);
            long j = a3Var.f;
            if (j == 13) {
                imageView.setImageDrawable(ContextCompat.getDrawable(context, 2131231407));
            } else if (j == 3) {
                imageView.setImageDrawable(ContextCompat.getDrawable(context, 2131231408));
            } else if (j == 1) {
                imageView.setImageDrawable(ContextCompat.getDrawable(context, 2131231409));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(context, 2131231216));
            }
            g1Var.f9832u.setText(a3Var.f11047b);
            textView.setVisibility(8);
            g1Var.f9831t.setText(a3Var.f11050e);
            j5.g l10 = j5.g.D.l(context);
            l10.b();
            String str2 = a3Var.f11049d;
            if (str2 == null || str2.length() == 0) {
                eVar = null;
            } else {
                String str3 = a3Var.f11049d;
                str3.getClass();
                eVar = l10.B(str3);
            }
            long j6 = a3Var.f11046a;
            boolean z12 = a5.b.c(j6) || a5.c.b(j6);
            if (z12) {
                long j10 = a3Var.f11046a;
                if (a5.b.c(j10)) {
                    K = a5.b.b();
                } else {
                    if (a5.c.b(j10)) {
                        K = a5.c.a();
                    }
                    K = null;
                }
            } else {
                String str4 = a3Var.f11049d;
                if (str4 != null && str4.length() != 0) {
                    String str5 = a3Var.f11049d;
                    str5.getClass();
                    K = l10.K(str5);
                }
                K = null;
            }
            if (eVar != null) {
                String str6 = a3Var.f11049d;
                if (str6 == null || str6.length() == 0) {
                    q2Var = null;
                } else {
                    String str7 = a3Var.f11049d;
                    str7.getClass();
                    q2Var = l10.Y(str7);
                }
                l4.a c9 = f4.a.f4869a.c();
                if (c9 != null) {
                    i6 = 1;
                    if (l7.u.m0(c9.f7095a, eVar.f11123l, true)) {
                        y1Var.e();
                    }
                } else {
                    i6 = 1;
                }
                if (q2Var == null || q2Var.c() || eVar.v == i6) {
                    y1Var.a(progressBar, imageView2);
                    z3.J(textView);
                    textView.setText(context.getString(2131952419));
                    relativeLayout.setVisibility(8);
                } else if (K == null || !z12) {
                    String string = context.getString(2131951657);
                    string.getClass();
                    y1Var.c(string);
                } else {
                    y1Var.d(K);
                }
            } else if (K == null) {
                String str8 = a3Var.f11049d;
                if (str8 == null || str8.length() == 0 || (str = a3Var.g) == null || str.equals("PreRegister") || str.equals("Discontinued") || str.equals("ExternalDownload") || str.equals("ReadingMode") || str.equals("AppNotAvailableInThisCountry")) {
                    textView.setVisibility(8);
                    relativeLayout.setVisibility(8);
                } else {
                    String string2 = context.getString(2131952428);
                    string2.getClass();
                    y1Var.c(string2);
                }
            } else if (K.n() || z11) {
                y1Var.e();
            } else if (K.c()) {
                y1Var.a(progressBar, imageView2);
                textView.setText(context.getString(2131952428));
                z3.J(textView);
                relativeLayout.setVisibility(8);
            } else if (z12 || K.m()) {
                y1Var.d(K);
            } else {
                y1Var.b(progressBar, imageView2);
                relativeLayout.setVisibility(0);
                g1Var.f9822b.setVisibility(0);
                g1Var.v.setVisibility(0);
                textView.setVisibility(8);
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
        Context context = this.f4520b;
        View inflate = LayoutInflater.from(context).inflate(2131558873, viewGroup, false);
        int i6 = 2131362255;
        if (((HorizontalScrollView) ViewBindings.findChildViewById(inflate, 2131362255)) != null) {
            i6 = 2131362319;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362319);
            if (imageView != null) {
                i6 = 2131362382;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362382);
                if (imageView2 != null) {
                    i6 = 2131362392;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(inflate, 2131362392);
                    if (imageView3 != null) {
                        i6 = 2131362673;
                        if (((LinearLayout) ViewBindings.findChildViewById(inflate, 2131362673)) != null) {
                            i6 = 2131362764;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362764);
                            if (linearLayout != null) {
                                i6 = 2131363020;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(inflate, 2131363020);
                                if (progressBar != null) {
                                    i6 = 2131363106;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363106);
                                    if (relativeLayout != null) {
                                        i6 = 2131363135;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363135);
                                        if (relativeLayout2 != null) {
                                            i6 = 2131363153;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363153);
                                            if (relativeLayout3 != null) {
                                                i6 = 2131363202;
                                                if (((RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363202)) != null) {
                                                    i6 = 2131363626;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363626);
                                                    if (textView != null) {
                                                        i6 = 2131363752;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363752);
                                                        if (textView2 != null) {
                                                            i6 = 2131364062;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364062);
                                                            if (textView3 != null) {
                                                                i6 = 2131364156;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364156);
                                                                if (textView4 != null) {
                                                                    i6 = 2131364627;
                                                                    View findChildViewById = ViewBindings.findChildViewById(inflate, 2131364627);
                                                                    if (findChildViewById != null) {
                                                                        return new y1(new t4.g1((RelativeLayout) inflate, imageView, imageView2, imageView3, linearLayout, progressBar, relativeLayout, relativeLayout2, relativeLayout3, textView, textView2, textView3, textView4), context, this.f4521c);
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
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i6)));
        return null;
    }
}
