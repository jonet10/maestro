package e4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.UptodownApp;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a1 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4479a;

    /* renamed from: b, reason: collision with root package name */
    public final f0.i f4480b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4481c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4482d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4483e;
    public int f;

    public a1(ArrayList arrayList, f0.i iVar, int i, int i6, boolean z9, int i10) {
        i6 = (i10 & 8) != 0 ? 0 : i6;
        z9 = (i10 & 16) != 0 ? false : z9;
        iVar.getClass();
        this.f4479a = arrayList;
        this.f4480b = iVar;
        this.f4481c = i;
        this.f4482d = i6;
        this.f4483e = z9;
        this.f = -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4479a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.getClass();
        Object obj = this.f4479a.get(i);
        obj.getClass();
        x4.i iVar = (x4.i) obj;
        if (!(viewHolder instanceof z0)) {
            if (viewHolder instanceof y0) {
                y0 y0Var = (y0) viewHolder;
                boolean z9 = this.f == i;
                a4.l0 e10 = a4.g0.d().e(iVar.a());
                float f = UptodownApp.I;
                Context context = y0Var.f4725l;
                e10.h(b4.d.x(context));
                e10.g(b4.d.f(context));
                a4.d0 d0Var = y0Var.f4723a;
                ImageView imageView = (ImageView) d0Var.f82l;
                ImageView imageView2 = (ImageView) d0Var.f83m;
                e10.e(imageView, null);
                ((ImageView) d0Var.f82l).setOnClickListener(new e0(y0Var, iVar, i, r4));
                RelativeLayout relativeLayout = (RelativeLayout) d0Var.f85o;
                if (z9) {
                    relativeLayout.setBackground(ContextCompat.getDrawable(context, 2131231190));
                    imageView2.setVisibility(0);
                } else {
                    relativeLayout.setBackground(null);
                    imageView2.setVisibility(8);
                }
                boolean z10 = y0Var.f4726m.f4483e;
                ImageView imageView3 = (ImageView) d0Var.f84n;
                if (z10) {
                    imageView3.setVisibility(8);
                    return;
                } else {
                    imageView3.setVisibility(0);
                    return;
                }
            }
            return;
        }
        z0 z0Var = (z0) viewHolder;
        r4 = this.f != i ? 0 : 1;
        a4.l0 e11 = a4.g0.d().e(iVar.a());
        float f10 = UptodownApp.I;
        Context context2 = z0Var.f4732l;
        e11.h(b4.d.x(context2));
        e11.g(b4.d.f(context2));
        y2.s sVar = z0Var.f4730a;
        ImageView imageView4 = (ImageView) sVar.f11756l;
        RelativeLayout relativeLayout2 = (RelativeLayout) sVar.f11758n;
        ImageView imageView5 = (ImageView) sVar.f11757m;
        RelativeLayout relativeLayout3 = (RelativeLayout) sVar.f11755b;
        e11.e(imageView4, null);
        ((ImageView) sVar.f11756l).setOnClickListener(new e0(z0Var, iVar, i, 2));
        int i6 = this.f4482d;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i6, i6);
        int dimension = (int) context2.getResources().getDimension(2131166251);
        if (r4 != 0) {
            layoutParams.setMargins(dimension, dimension, dimension, dimension);
            relativeLayout3.setLayoutParams(layoutParams);
            relativeLayout3.animate().scaleX(1.2f).scaleY(1.2f).setDuration(200L).start();
            imageView5.setVisibility(0);
            relativeLayout2.setBackground(ContextCompat.getDrawable(context2, 2131231189));
            return;
        }
        layoutParams.setMargins(dimension, dimension, dimension, dimension);
        relativeLayout3.setLayoutParams(layoutParams);
        relativeLayout3.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200L).start();
        relativeLayout2.setBackground(null);
        imageView5.setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        f0.i iVar = this.f4480b;
        int i6 = 2131363256;
        int i10 = 2131362321;
        int i11 = this.f4481c;
        if (i11 == 0) {
            View b7 = c.j.b(viewGroup, 2131558864, viewGroup, false);
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(b7, 2131362303);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(b7, 2131362321);
                if (imageView2 != null) {
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(b7, 2131363256);
                    if (relativeLayout != null) {
                        y2.s sVar = new y2.s((RelativeLayout) b7, imageView, imageView2, relativeLayout, 16);
                        Context context = viewGroup.getContext();
                        context.getClass();
                        return new z0(sVar, iVar, context);
                    }
                } else {
                    i6 = 2131362321;
                }
            } else {
                i6 = 2131362303;
            }
            com.google.gson.internal.a.i("Missing required view with ID: ".concat(b7.getResources().getResourceName(i6)));
            return null;
        }
        if (i11 != 1) {
            com.google.gson.internal.a.p("ViewHolder unknown!!");
            return null;
        }
        View b10 = c.j.b(viewGroup, 2131558866, viewGroup, false);
        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(b10, 2131362303);
        if (imageView3 != null) {
            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(b10, 2131362321);
            if (imageView4 != null) {
                i10 = 2131362409;
                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(b10, 2131362409);
                if (imageView5 != null) {
                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(b10, 2131363256);
                    if (relativeLayout2 != null) {
                        a4.d0 d0Var = new a4.d0((RelativeLayout) b10, imageView3, imageView4, imageView5, relativeLayout2, 11);
                        Context context2 = viewGroup.getContext();
                        context2.getClass();
                        return new y0(this, d0Var, iVar, context2);
                    }
                }
            }
            i6 = i10;
        } else {
            i6 = 2131362303;
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(b10.getResources().getResourceName(i6)));
        return null;
    }
}
