package e4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
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
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4505a;

    /* renamed from: b, reason: collision with root package name */
    public final f0.i f4506b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4507c;

    public d(ArrayList arrayList, f0.i iVar) {
        arrayList.getClass();
        iVar.getClass();
        this.f4505a = arrayList;
        this.f4506b = iVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4505a.size() + (this.f4507c ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        return i == this.f4505a.size() ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.getClass();
        if (viewHolder instanceof m5.q) {
            m5.q qVar = (m5.q) viewHolder;
            Object obj = this.f4505a.get(i);
            obj.getClass();
            w2 w2Var = (w2) obj;
            Context context = qVar.f7524l;
            a4.d0 d0Var = qVar.f7522a;
            a4.g0 d10 = a4.g0.d();
            String str = w2Var.f11433l;
            a4.l0 e10 = d10.e(str != null ? a4.x.k(str, UptodownApp.R, ":webp") : null);
            float f = UptodownApp.I;
            context.getClass();
            e10.h(b4.d.x(context));
            e10.g(b4.d.f(context));
            ImageView imageView = (ImageView) d0Var.f82l;
            UsernameTextView usernameTextView = (UsernameTextView) d0Var.f85o;
            ImageView imageView2 = (ImageView) d0Var.f83m;
            TextView textView = (TextView) d0Var.f84n;
            e10.e(imageView, null);
            ((RelativeLayout) d0Var.f81b).setOnClickListener(new g4.b0(6, qVar, w2Var));
            boolean d11 = w2Var.d();
            ImageView imageView3 = (ImageView) d0Var.f82l;
            if (d11) {
                int dimension = (int) imageView3.getContext().getResources().getDimension(2131165270);
                imageView3.setForeground(ContextCompat.getDrawable(imageView3.getContext(), 2131231271));
                imageView3.setPadding(dimension, dimension, dimension, dimension);
                imageView2.setVisibility(0);
            } else {
                imageView3.setForeground(null);
                imageView3.setPadding(0, 0, 0, 0);
                imageView2.setVisibility(8);
            }
            usernameTextView.setText(w2Var.f11434m);
            int i6 = UsernameTextView.f3452s;
            i5.g(usernameTextView, w2Var.d(), w2Var.f11436o);
            textView.setOnClickListener(new g4.a(i, qVar, 1, w2Var));
            int i10 = w2Var.f11439r;
            if (i10 == 1) {
                textView.setVisibility(0);
                textView.setText(context.getString(2131952034));
                textView.setBackground(ContextCompat.getDrawable(context, 2131231156));
                textView.setTextColor(ContextCompat.getColor(context, 2131099713));
                return;
            }
            if (i10 != 0) {
                if (i10 == -1) {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(0);
                textView.setText(context.getString(2131952031));
                textView.setBackground(ContextCompat.getDrawable(context, 2131231146));
                textView.setTextColor(ContextCompat.getColor(context, 2131100824));
            }
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
        View b10 = c.j.b(viewGroup, 2131558558, viewGroup, false);
        int i6 = 2131362302;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(b10, 2131362302);
        if (imageView != null) {
            i6 = 2131362526;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(b10, 2131362526);
            if (imageView2 != null) {
                i6 = 2131363620;
                TextView textView = (TextView) ViewBindings.findChildViewById(b10, 2131363620);
                if (textView != null) {
                    i6 = 2131364526;
                    UsernameTextView usernameTextView = (UsernameTextView) ViewBindings.findChildViewById(b10, 2131364526);
                    if (usernameTextView != null) {
                        return new m5.q(new a4.d0((RelativeLayout) b10, imageView, imageView2, textView, usernameTextView, 8), this.f4506b);
                    }
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(b10.getResources().getResourceName(i6)));
        return null;
    }
}
