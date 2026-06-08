package e4;

import android.content.Context;
import android.content.Intent;
import android.text.Spanned;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.UptodownApp;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.UserCommentsActivity;
import java.util.ArrayList;
import m5.s1;
import x4.k2;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b1 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4493a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.d f4494b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4495c;

    public b1(ArrayList arrayList, a3.d dVar) {
        dVar.getClass();
        this.f4493a = arrayList;
        this.f4494b = dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4493a.size() + (this.f4495c ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return i == this.f4493a.size() ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        ImageView imageView;
        String str;
        viewHolder.getClass();
        if (viewHolder instanceof s1) {
            Object obj = this.f4493a.get(i);
            obj.getClass();
            k2 k2Var = (k2) obj;
            final s1 s1Var = (s1) viewHolder;
            ImageView imageView2 = s1Var.f7577z;
            ImageView imageView3 = s1Var.f7576y;
            ImageView imageView4 = s1Var.f7575x;
            ImageView imageView5 = s1Var.f7574w;
            TextView textView = s1Var.f7564l;
            LinearLayout linearLayout = s1Var.f7571s;
            LinearLayout linearLayout2 = s1Var.f7570r;
            ImageView imageView6 = s1Var.f7565m;
            TextView textView2 = s1Var.f7567o;
            Context context = s1Var.f7563b;
            String str2 = k2Var.f11269u;
            if (str2 != null && str2.length() != 0) {
                textView.setText(k2Var.f11269u);
            }
            String str3 = k2Var.f11261m;
            if ((str3 != null ? a4.x.k(str3, UptodownApp.K, ":webp") : null) != null) {
                a4.g0 d10 = a4.g0.d();
                String str4 = k2Var.f11261m;
                if (str4 != null) {
                    imageView = imageView2;
                    str = a4.x.k(str4, UptodownApp.K, ":webp");
                } else {
                    imageView = imageView2;
                    str = null;
                }
                a4.l0 e10 = d10.e(str);
                float f = UptodownApp.I;
                e10.g(b4.d.f(context));
                e10.h(b4.d.x(context));
                e10.e(imageView6, null);
            } else {
                imageView = imageView2;
                a4.l0 f10 = a4.g0.d().f();
                float f11 = UptodownApp.I;
                f10.h(b4.d.x(context));
                f10.e(imageView6, null);
            }
            String str5 = k2Var.f11266r;
            if (str5 != null) {
                s1Var.f7566n.setText(str5);
            }
            Spanned a8 = k2Var.a();
            final int i6 = 0;
            if (a8 == null || a8.length() == 0) {
                textView2.setVisibility(8);
                linearLayout2.setVisibility(8);
                linearLayout.setVisibility(8);
            } else {
                textView2.setText(k2Var.a());
                textView2.setVisibility(0);
                linearLayout2.setVisibility(0);
                linearLayout.setVisibility(0);
            }
            s1Var.f7569q.setText(String.valueOf(k2Var.f11267s));
            boolean contains = j5.t.f6709b.contains(Long.valueOf(k2Var.f11258a));
            ImageView imageView7 = s1Var.f7573u;
            if (contains) {
                imageView7.setImageDrawable(ContextCompat.getDrawable(context, 2131231344));
            } else {
                imageView7.setImageDrawable(ContextCompat.getDrawable(context, 2131231342));
            }
            int i10 = k2Var.f11265q;
            TextView textView3 = s1Var.f7572t;
            if (i10 == 0) {
                textView3.setText(context.getString(2131952537));
            } else {
                textView3.setText(String.valueOf(i10));
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: m5.r1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i11 = i6;
                    int i12 = i;
                    s1 s1Var2 = s1Var;
                    switch (i11) {
                        case 0:
                            a3.d dVar = s1Var2.f7562a;
                            dVar.getClass();
                            float f12 = UptodownApp.I;
                            if (b4.d.t()) {
                                UserCommentsActivity userCommentsActivity = (UserCommentsActivity) dVar.f63b;
                                e4.b1 b1Var = userCommentsActivity.Q;
                                b1Var.getClass();
                                userCommentsActivity.i0(((k2) b1Var.f4493a.get(i12)).f11262n);
                                break;
                            }
                            break;
                        case 1:
                            a3.d dVar2 = s1Var2.f7562a;
                            dVar2.getClass();
                            float f13 = UptodownApp.I;
                            if (b4.d.t()) {
                                UserCommentsActivity userCommentsActivity2 = (UserCommentsActivity) dVar2.f63b;
                                e4.b1 b1Var2 = userCommentsActivity2.Q;
                                b1Var2.getClass();
                                userCommentsActivity2.i0(((k2) b1Var2.f4493a.get(i12)).f11262n);
                                break;
                            }
                            break;
                        default:
                            UserCommentsActivity userCommentsActivity3 = (UserCommentsActivity) s1Var2.f7562a.f63b;
                            float f14 = UptodownApp.I;
                            if (b4.d.t() && userCommentsActivity3.T()) {
                                Intent intent = new Intent(userCommentsActivity3, (Class<?>) RepliesActivity.class);
                                e4.b1 b1Var3 = userCommentsActivity3.Q;
                                b1Var3.getClass();
                                Object obj2 = b1Var3.f4493a.get(i12);
                                obj2.getClass();
                                k2 k2Var2 = (k2) obj2;
                                k2Var2.v = ((w2) userCommentsActivity3.z0().f1437e.getValue()).d() ? 1 : 0;
                                k2Var2.f11270w = ((w2) userCommentsActivity3.z0().f1437e.getValue()).f11436o;
                                k2Var2.f11259b = ((w2) userCommentsActivity3.z0().f1437e.getValue()).f11431a;
                                intent.putExtra("review", k2Var2);
                                intent.putExtra("appId", k2Var2.f11262n);
                                intent.putExtra("username", ((w2) userCommentsActivity3.z0().f1437e.getValue()).f11434m);
                                intent.putExtra("appName", k2Var2.f11269u);
                                intent.putExtra("appIconUrl", k2Var2.f11261m);
                                intent.putExtra("userAvatarUrl", ((w2) userCommentsActivity3.z0().f1437e.getValue()).f11433l);
                                userCommentsActivity3.startActivity(intent, b4.d.a(userCommentsActivity3));
                                break;
                            }
                            break;
                    }
                }
            });
            final int i11 = 1;
            imageView6.setOnClickListener(new View.OnClickListener() { // from class: m5.r1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i112 = i11;
                    int i12 = i;
                    s1 s1Var2 = s1Var;
                    switch (i112) {
                        case 0:
                            a3.d dVar = s1Var2.f7562a;
                            dVar.getClass();
                            float f12 = UptodownApp.I;
                            if (b4.d.t()) {
                                UserCommentsActivity userCommentsActivity = (UserCommentsActivity) dVar.f63b;
                                e4.b1 b1Var = userCommentsActivity.Q;
                                b1Var.getClass();
                                userCommentsActivity.i0(((k2) b1Var.f4493a.get(i12)).f11262n);
                                break;
                            }
                            break;
                        case 1:
                            a3.d dVar2 = s1Var2.f7562a;
                            dVar2.getClass();
                            float f13 = UptodownApp.I;
                            if (b4.d.t()) {
                                UserCommentsActivity userCommentsActivity2 = (UserCommentsActivity) dVar2.f63b;
                                e4.b1 b1Var2 = userCommentsActivity2.Q;
                                b1Var2.getClass();
                                userCommentsActivity2.i0(((k2) b1Var2.f4493a.get(i12)).f11262n);
                                break;
                            }
                            break;
                        default:
                            UserCommentsActivity userCommentsActivity3 = (UserCommentsActivity) s1Var2.f7562a.f63b;
                            float f14 = UptodownApp.I;
                            if (b4.d.t() && userCommentsActivity3.T()) {
                                Intent intent = new Intent(userCommentsActivity3, (Class<?>) RepliesActivity.class);
                                e4.b1 b1Var3 = userCommentsActivity3.Q;
                                b1Var3.getClass();
                                Object obj2 = b1Var3.f4493a.get(i12);
                                obj2.getClass();
                                k2 k2Var2 = (k2) obj2;
                                k2Var2.v = ((w2) userCommentsActivity3.z0().f1437e.getValue()).d() ? 1 : 0;
                                k2Var2.f11270w = ((w2) userCommentsActivity3.z0().f1437e.getValue()).f11436o;
                                k2Var2.f11259b = ((w2) userCommentsActivity3.z0().f1437e.getValue()).f11431a;
                                intent.putExtra("review", k2Var2);
                                intent.putExtra("appId", k2Var2.f11262n);
                                intent.putExtra("username", ((w2) userCommentsActivity3.z0().f1437e.getValue()).f11434m);
                                intent.putExtra("appName", k2Var2.f11269u);
                                intent.putExtra("appIconUrl", k2Var2.f11261m);
                                intent.putExtra("userAvatarUrl", ((w2) userCommentsActivity3.z0().f1437e.getValue()).f11433l);
                                userCommentsActivity3.startActivity(intent, b4.d.a(userCommentsActivity3));
                                break;
                            }
                            break;
                    }
                }
            });
            linearLayout2.setOnClickListener(new g4.a(s1Var, i, k2Var));
            final int i12 = 2;
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: m5.r1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i112 = i12;
                    int i122 = i;
                    s1 s1Var2 = s1Var;
                    switch (i112) {
                        case 0:
                            a3.d dVar = s1Var2.f7562a;
                            dVar.getClass();
                            float f12 = UptodownApp.I;
                            if (b4.d.t()) {
                                UserCommentsActivity userCommentsActivity = (UserCommentsActivity) dVar.f63b;
                                e4.b1 b1Var = userCommentsActivity.Q;
                                b1Var.getClass();
                                userCommentsActivity.i0(((k2) b1Var.f4493a.get(i122)).f11262n);
                                break;
                            }
                            break;
                        case 1:
                            a3.d dVar2 = s1Var2.f7562a;
                            dVar2.getClass();
                            float f13 = UptodownApp.I;
                            if (b4.d.t()) {
                                UserCommentsActivity userCommentsActivity2 = (UserCommentsActivity) dVar2.f63b;
                                e4.b1 b1Var2 = userCommentsActivity2.Q;
                                b1Var2.getClass();
                                userCommentsActivity2.i0(((k2) b1Var2.f4493a.get(i122)).f11262n);
                                break;
                            }
                            break;
                        default:
                            UserCommentsActivity userCommentsActivity3 = (UserCommentsActivity) s1Var2.f7562a.f63b;
                            float f14 = UptodownApp.I;
                            if (b4.d.t() && userCommentsActivity3.T()) {
                                Intent intent = new Intent(userCommentsActivity3, (Class<?>) RepliesActivity.class);
                                e4.b1 b1Var3 = userCommentsActivity3.Q;
                                b1Var3.getClass();
                                Object obj2 = b1Var3.f4493a.get(i122);
                                obj2.getClass();
                                k2 k2Var2 = (k2) obj2;
                                k2Var2.v = ((w2) userCommentsActivity3.z0().f1437e.getValue()).d() ? 1 : 0;
                                k2Var2.f11270w = ((w2) userCommentsActivity3.z0().f1437e.getValue()).f11436o;
                                k2Var2.f11259b = ((w2) userCommentsActivity3.z0().f1437e.getValue()).f11431a;
                                intent.putExtra("review", k2Var2);
                                intent.putExtra("appId", k2Var2.f11262n);
                                intent.putExtra("username", ((w2) userCommentsActivity3.z0().f1437e.getValue()).f11434m);
                                intent.putExtra("appName", k2Var2.f11269u);
                                intent.putExtra("appIconUrl", k2Var2.f11261m);
                                intent.putExtra("userAvatarUrl", ((w2) userCommentsActivity3.z0().f1437e.getValue()).f11433l);
                                userCommentsActivity3.startActivity(intent, b4.d.a(userCommentsActivity3));
                                break;
                            }
                            break;
                    }
                }
            });
            Spanned a10 = k2Var.a();
            textView2.setText(a10 != null ? l7.m.K0(a10) : null);
            textView2.getViewTreeObserver().addOnPreDrawListener(new h1(s1Var, 1));
            s1Var.f7568p.setOnClickListener(new m5.u0(s1Var, 4));
            s1Var.v.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
            imageView5.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
            imageView4.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
            imageView3.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
            ImageView imageView8 = imageView;
            imageView8.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
            if (k2Var.f11264p >= 2) {
                imageView5.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
            }
            if (k2Var.f11264p >= 3) {
                imageView4.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
            }
            if (k2Var.f11264p >= 4) {
                imageView3.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
            }
            if (k2Var.f11264p == 5) {
                imageView8.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        if (i != 0) {
            if (i == 1) {
                return new m5.c0(androidx.lifecycle.l.E(viewGroup, 2131558768, viewGroup, false));
            }
            com.google.gson.internal.a.p("viewType unknown");
            return null;
        }
        View E = androidx.lifecycle.l.E(viewGroup, 2131558803, viewGroup, false);
        Context context = viewGroup.getContext();
        context.getClass();
        return new s1(this.f4494b, context, E);
    }
}
