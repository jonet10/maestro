package e4;

import android.content.Context;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.UptodownApp;
import com.uptodown.util.views.UsernameTextView;
import java.util.ArrayList;
import x4.k2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j1 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f4573a;

    /* renamed from: b, reason: collision with root package name */
    public b5.m f4574b;

    /* renamed from: c, reason: collision with root package name */
    public int f4575c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4573a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        int i6;
        final i1 i1Var = (i1) viewHolder;
        i1Var.getClass();
        Object obj = this.f4573a.get(i);
        obj.getClass();
        k2 k2Var = (k2) obj;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        t4.g gVar = i1Var.f4564b;
        RelativeLayout relativeLayout = gVar.f9801b;
        TextView textView = (TextView) gVar.f9815z;
        UsernameTextView usernameTextView = (UsernameTextView) gVar.f9814y;
        ImageView imageView = gVar.f9802l;
        LinearLayout linearLayout = gVar.f9807q;
        LinearLayout linearLayout2 = (LinearLayout) gVar.f9813x;
        TextView textView2 = gVar.f9808r;
        Context context = i1Var.itemView.getContext();
        context.getClass();
        m5.e.a(layoutParams, context, i, i1Var.f4566m.f4575c);
        relativeLayout.setLayoutParams(layoutParams);
        androidx.lifecycle.l.A(i1Var.itemView, 2131231441, gVar.f9804n);
        ImageView imageView2 = gVar.f9805o;
        androidx.lifecycle.l.A(i1Var.itemView, 2131231439, imageView2);
        ImageView imageView3 = gVar.f9806p;
        androidx.lifecycle.l.A(i1Var.itemView, 2131231439, imageView3);
        ImageView imageView4 = (ImageView) gVar.v;
        androidx.lifecycle.l.A(i1Var.itemView, 2131231439, imageView4);
        ImageView imageView5 = (ImageView) gVar.f9812w;
        androidx.lifecycle.l.A(i1Var.itemView, 2131231439, imageView5);
        if (k2Var.f11264p >= 2) {
            i6 = 2131231441;
            androidx.lifecycle.l.A(i1Var.itemView, 2131231441, imageView2);
        } else {
            i6 = 2131231441;
        }
        if (k2Var.f11264p >= 3) {
            androidx.lifecycle.l.A(i1Var.itemView, i6, imageView3);
        }
        if (k2Var.f11264p >= 4) {
            androidx.lifecycle.l.A(i1Var.itemView, i6, imageView4);
        }
        if (k2Var.f11264p == 5) {
            androidx.lifecycle.l.A(i1Var.itemView, i6, imageView5);
        }
        String str = k2Var.f11261m;
        if (str == null || str.length() == 0) {
            a4.l0 f = a4.g0.d().f();
            float f10 = UptodownApp.I;
            Context context2 = i1Var.itemView.getContext();
            context2.getClass();
            f.h(b4.d.y(context2));
            f.e(imageView, null);
        } else {
            a4.g0 d10 = a4.g0.d();
            String str2 = k2Var.f11261m;
            a4.l0 e10 = d10.e(str2 != null ? a4.x.k(str2, UptodownApp.K, ":webp") : null);
            float f11 = UptodownApp.I;
            Context context3 = i1Var.itemView.getContext();
            context3.getClass();
            e10.h(b4.d.x(context3));
            Context context4 = i1Var.itemView.getContext();
            context4.getClass();
            e10.g(b4.d.f(context4));
            e10.e(imageView, null);
        }
        String str3 = k2Var.f11269u;
        if (str3 != null && str3.length() != 0) {
            usernameTextView.setText(k2Var.f11269u);
        }
        final int i10 = 0;
        usernameTextView.setOnClickListener(new View.OnClickListener() { // from class: e4.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i10) {
                    case 0:
                        i1Var.f4565l.g(i);
                        break;
                    case 1:
                        i1Var.f4565l.g(i);
                        break;
                    default:
                        i1Var.f4565l.q(i);
                        break;
                }
            }
        });
        final int i11 = 1;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: e4.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i11) {
                    case 0:
                        i1Var.f4565l.g(i);
                        break;
                    case 1:
                        i1Var.f4565l.g(i);
                        break;
                    default:
                        i1Var.f4565l.q(i);
                        break;
                }
            }
        });
        boolean contains = j5.t.f6709b.contains(Long.valueOf(k2Var.f11258a));
        ImageView imageView6 = gVar.f9803m;
        View view = i1Var.itemView;
        if (contains) {
            androidx.lifecycle.l.A(view, 2131231344, imageView6);
        } else {
            androidx.lifecycle.l.A(view, 2131231342, imageView6);
        }
        String str4 = k2Var.f11266r;
        if (str4 != null) {
            gVar.f9809s.setText(str4);
        }
        Spanned a8 = k2Var.a();
        if (a8 == null || a8.length() == 0) {
            textView.setVisibility(8);
            textView2.setVisibility(4);
            linearLayout2.setVisibility(4);
            linearLayout.setVisibility(4);
            return;
        }
        Spanned a10 = k2Var.a();
        textView2.setText(a10 != null ? l7.m.K0(a10) : null);
        textView2.setVisibility(0);
        textView2.getViewTreeObserver().addOnPreDrawListener(new h1(i1Var, 0));
        final int i12 = 2;
        textView.setOnClickListener(new View.OnClickListener() { // from class: e4.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                switch (i12) {
                    case 0:
                        i1Var.f4565l.g(i);
                        break;
                    case 1:
                        i1Var.f4565l.g(i);
                        break;
                    default:
                        i1Var.f4565l.q(i);
                        break;
                }
            }
        });
        linearLayout2.setTag(Integer.valueOf(i));
        linearLayout2.setOnClickListener(new c4.d(i1Var, 16));
        int i13 = k2Var.f11265q;
        TextView textView3 = gVar.f9811u;
        if (i13 > 0) {
            textView3.setText(String.valueOf(i13));
        } else {
            textView3.setText(i1Var.itemView.getContext().getString(2131952537));
        }
        gVar.f9810t.setText(String.valueOf(k2Var.f11267s));
        linearLayout.setTag(Integer.valueOf(i));
        linearLayout.setOnClickListener(new c.e(27, i1Var, k2Var));
        linearLayout2.setVisibility(0);
        linearLayout.setVisibility(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558804, null, false);
        int i6 = 2131362304;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(s6, 2131362304);
        if (imageView != null) {
            i6 = 2131362404;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(s6, 2131362404);
            if (imageView2 != null) {
                i6 = 2131362485;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(s6, 2131362485);
                if (imageView3 != null) {
                    i6 = 2131362491;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(s6, 2131362491);
                    if (imageView4 != null) {
                        i6 = 2131362497;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(s6, 2131362497);
                        if (imageView5 != null) {
                            i6 = 2131362503;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(s6, 2131362503);
                            if (imageView6 != null) {
                                i6 = 2131362509;
                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(s6, 2131362509);
                                if (imageView7 != null) {
                                    i6 = 2131362678;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(s6, 2131362678);
                                    if (linearLayout != null) {
                                        i6 = 2131362728;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(s6, 2131362728);
                                        if (linearLayout2 != null) {
                                            i6 = 2131362743;
                                            if (((LinearLayout) ViewBindings.findChildViewById(s6, 2131362743)) != null) {
                                                i6 = 2131363646;
                                                UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(s6, 2131363646);
                                                if (usernameTextView != null) {
                                                    i6 = 2131363682;
                                                    TextView textView = (TextView) ViewBindings.findChildViewById(s6, 2131363682);
                                                    if (textView != null) {
                                                        i6 = 2131363751;
                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(s6, 2131363751);
                                                        if (textView2 != null) {
                                                            i6 = 2131363960;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(s6, 2131363960);
                                                            if (textView3 != null) {
                                                                i6 = 2131364226;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(s6, 2131364226);
                                                                if (textView4 != null) {
                                                                    i6 = 2131364288;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(s6, 2131364288);
                                                                    if (textView5 != null) {
                                                                        return new i1(this, new t4.g((RelativeLayout) s6, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, linearLayout, linearLayout2, usernameTextView, textView, textView2, textView3, textView4, textView5), this.f4574b);
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
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(s6.getResources().getResourceName(i6)));
        return null;
    }
}
