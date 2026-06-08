package e4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.internal.measurement.i5;
import com.uptodown.UptodownApp;
import com.uptodown.views.FullWidthImageView;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public a3.d f4489a;

    /* renamed from: b, reason: collision with root package name */
    public String f4490b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f4491c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4492d;

    public final void a(boolean z9) {
        this.f4492d = z9;
        if (z9) {
            notifyItemInserted(getItemCount());
        } else {
            notifyItemRemoved(getItemCount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4491c.size() + (this.f4492d ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        if (i == this.f4491c.size()) {
            return 6;
        }
        return ((t) this.f4491c.get(i)).f4689b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.getClass();
        if (!(viewHolder instanceof x)) {
            if (viewHolder instanceof a0) {
                ArrayList arrayList = (ArrayList) ((t) this.f4491c.get(i)).a();
                z zVar = ((a0) viewHolder).f4478b;
                zVar.getClass();
                zVar.f4729c = arrayList;
                zVar.notifyDataSetChanged();
                return;
            }
            if (viewHolder instanceof w) {
                ArrayList arrayList2 = (ArrayList) ((t) this.f4491c.get(i)).a();
                v vVar = ((w) viewHolder).f4710b;
                vVar.getClass();
                vVar.f4707c = arrayList2;
                vVar.notifyDataSetChanged();
                return;
            }
            if (viewHolder instanceof m5.g1) {
                ((m5.g1) viewHolder).g((x4.g) ((t) this.f4491c.get(i)).a(), i);
                return;
            } else {
                if (viewHolder instanceof m5.b1) {
                    ((m5.b1) viewHolder).a();
                    return;
                }
                return;
            }
        }
        x xVar = (x) viewHolder;
        x4.g gVar = (x4.g) ((t) this.f4491c.get(i)).a();
        Context context = xVar.f4714m;
        t4.e0 e0Var = xVar.f4712b;
        String e10 = gVar.e();
        PackageInfo packageInfo = null;
        if (e10 == null || e10.length() == 0) {
            e0Var.f9751b.setImageDrawable(ContextCompat.getDrawable(context, 2131231216));
        } else {
            a4.l0 e11 = a4.g0.d().e(gVar.e());
            float f = UptodownApp.I;
            e11.h(b4.d.w(context));
            e11.e(e0Var.f9751b, null);
        }
        View view = xVar.itemView;
        view.getClass();
        m5.e.b(view, xVar.f4713l, gVar);
        TextView textView = e0Var.f9759s;
        ImageView imageView = e0Var.f9752l;
        TextView textView2 = e0Var.f9756p;
        m5.e.f(gVar, textView, textView2);
        e0Var.v.setText(String.valueOf(gVar.f11194y / 10.0d));
        e0Var.f9758r.setText(context.getString(2131951973, i5.D(gVar.f11181r)));
        xVar.e(imageView, gVar.i());
        String str = gVar.F;
        if (str != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageInfo = n4.i.e(packageManager, str, 0);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        TextView textView3 = e0Var.f9757q;
        if (packageInfo != null) {
            textView3.setVisibility(8);
        } else {
            textView3.setOnClickListener(new c.e(25, xVar, gVar));
        }
        xVar.c(gVar, e0Var.f9754n, imageView, textView2, e0Var.f9755o, e0Var.f9760t, e0Var.f9753m);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        a3.d dVar = this.f4489a;
        viewGroup.getClass();
        switch (i) {
            case 1:
                View b7 = c.j.b(viewGroup, 2131558763, viewGroup, false);
                int i6 = 2131362517;
                FullWidthImageView fullWidthImageView = (FullWidthImageView) ViewBindings.findChildViewById(b7, 2131362517);
                if (fullWidthImageView != null) {
                    i6 = 2131362518;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(b7, 2131362518);
                    if (imageView != null) {
                        i6 = 2131362718;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(b7, 2131362718);
                        if (linearLayout != null) {
                            i6 = 2131362746;
                            if (((LinearLayout) ViewBindings.findChildViewById(b7, 2131362746)) != null) {
                                i6 = 2131363016;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(b7, 2131363016);
                                if (progressBar != null) {
                                    i6 = 2131363226;
                                    if (((RelativeLayout) ViewBindings.findChildViewById(b7, 2131363226)) != null) {
                                        i6 = 2131364197;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(b7, 2131364197);
                                        if (textView != null) {
                                            i6 = 2131364458;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(b7, 2131364458);
                                            if (textView2 != null) {
                                                i6 = 2131364459;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(b7, 2131364459);
                                                if (textView3 != null) {
                                                    i6 = 2131364460;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(b7, 2131364460);
                                                    if (textView4 != null) {
                                                        i6 = 2131364461;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(b7, 2131364461);
                                                        if (textView5 != null) {
                                                            i6 = 2131364462;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(b7, 2131364462);
                                                            if (textView6 != null) {
                                                                i6 = 2131364463;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(b7, 2131364463);
                                                                if (textView7 != null) {
                                                                    i6 = 2131364464;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(b7, 2131364464);
                                                                    if (textView8 != null) {
                                                                        i6 = 2131364554;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(b7, 2131364554);
                                                                        if (textView9 != null) {
                                                                            t4.e0 e0Var = new t4.e0((RelativeLayout) b7, fullWidthImageView, imageView, linearLayout, progressBar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
                                                                            Context context = viewGroup.getContext();
                                                                            context.getClass();
                                                                            return new x(e0Var, dVar, context);
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
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(b7.getResources().getResourceName(i6)));
                return null;
            case 2:
                View b10 = c.j.b(viewGroup, 2131558764, viewGroup, false);
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(b10, 2131363355);
                if (recyclerView == null) {
                    com.google.gson.internal.a.i("Missing required view with ID: ".concat(b10.getResources().getResourceName(2131363355)));
                    return null;
                }
                m8.q qVar = new m8.q(13, (LinearLayout) b10, recyclerView);
                Context context2 = viewGroup.getContext();
                context2.getClass();
                return new a0(this, qVar, dVar, context2);
            case 3:
                View b11 = c.j.b(viewGroup, 2131558762, viewGroup, false);
                int i10 = 2131363330;
                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(b11, 2131363330);
                if (recyclerView2 != null) {
                    i10 = 2131364009;
                    TextView textView10 = (TextView) ViewBindings.findChildViewById(b11, 2131364009);
                    if (textView10 != null) {
                        b5.m mVar = new b5.m((LinearLayout) b11, recyclerView2, textView10, 28);
                        a3.d dVar2 = this.f4489a;
                        Context context3 = viewGroup.getContext();
                        context3.getClass();
                        return new w(this, mVar, dVar2, context3, this.f4490b);
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(b11.getResources().getResourceName(i10)));
                return null;
            case 4:
                View b12 = c.j.b(viewGroup, 2131558825, viewGroup, false);
                b12.getClass();
                String string = viewGroup.getContext().getString(2131952440, this.f4490b);
                string.getClass();
                return new m5.b1(b12, string);
            case 5:
                View b13 = c.j.b(viewGroup, 2131558441, viewGroup, false);
                b13.getClass();
                return new m5.g1(b13, dVar, null, false);
            case 6:
                View b14 = c.j.b(viewGroup, 2131558768, viewGroup, false);
                b14.getClass();
                return new m5.c0(b14);
            default:
                com.google.gson.internal.a.p("viewType unknown");
                return null;
        }
    }
}
