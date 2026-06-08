package e4;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import x4.k2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4560a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f4561b;

    /* renamed from: c, reason: collision with root package name */
    public final w4.m f4562c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4563d;

    public i0(ArrayList arrayList, Context context, w4.m mVar) {
        mVar.getClass();
        this.f4560a = arrayList;
        this.f4561b = context;
        this.f4562c = mVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4560a.size() + (this.f4563d ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        ArrayList arrayList = this.f4560a;
        if (i == arrayList.size()) {
            return 2;
        }
        return ((k2) arrayList.get(i)).b() ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.getClass();
        if (viewHolder instanceof m5.t0) {
            Object obj = this.f4560a.get(i);
            obj.getClass();
            k2 k2Var = (k2) obj;
            if (!k2Var.b()) {
                m5.t0 t0Var = (m5.t0) viewHolder;
                t0Var.a(k2Var, i);
                ImageView imageView = t0Var.v;
                Context context = t0Var.f7582a;
                imageView.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                ImageView imageView2 = t0Var.f7594w;
                imageView2.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                ImageView imageView3 = t0Var.f7595x;
                imageView3.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                ImageView imageView4 = t0Var.f7596y;
                imageView4.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                ImageView imageView5 = t0Var.f7597z;
                imageView5.setImageDrawable(ContextCompat.getDrawable(context, 2131231439));
                if (k2Var.f11264p >= 2) {
                    imageView2.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                }
                if (k2Var.f11264p >= 3) {
                    imageView3.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                }
                if (k2Var.f11264p >= 4) {
                    imageView4.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                }
                if (k2Var.f11264p == 5) {
                    imageView5.setImageDrawable(ContextCompat.getDrawable(context, 2131231441));
                    return;
                }
                return;
            }
            m5.t0 t0Var2 = (m5.t0) viewHolder;
            t0Var2.a(k2Var, i);
            ImageView imageView6 = t0Var2.v;
            Context context2 = t0Var2.f7582a;
            imageView6.setImageDrawable(ContextCompat.getDrawable(context2, 2131231442));
            ImageView imageView7 = t0Var2.f7594w;
            imageView7.setImageDrawable(ContextCompat.getDrawable(context2, 2131231440));
            ImageView imageView8 = t0Var2.f7595x;
            imageView8.setImageDrawable(ContextCompat.getDrawable(context2, 2131231440));
            ImageView imageView9 = t0Var2.f7596y;
            imageView9.setImageDrawable(ContextCompat.getDrawable(context2, 2131231440));
            ImageView imageView10 = t0Var2.f7597z;
            imageView10.setImageDrawable(ContextCompat.getDrawable(context2, 2131231440));
            if (k2Var.f11264p >= 2) {
                imageView7.setImageDrawable(ContextCompat.getDrawable(context2, 2131231442));
            }
            if (k2Var.f11264p >= 3) {
                imageView8.setImageDrawable(ContextCompat.getDrawable(context2, 2131231442));
            }
            if (k2Var.f11264p >= 4) {
                imageView9.setImageDrawable(ContextCompat.getDrawable(context2, 2131231442));
            }
            if (k2Var.f11264p == 5) {
                imageView10.setImageDrawable(ContextCompat.getDrawable(context2, 2131231442));
            }
            t0Var2.A.setVisibility(0);
            ImageView imageView11 = t0Var2.f7584l;
            imageView11.getClass();
            int dimension = (int) imageView11.getContext().getResources().getDimension(2131165270);
            imageView11.setForeground(ContextCompat.getDrawable(imageView11.getContext(), 2131231271));
            imageView11.setPadding(dimension, dimension, dimension, dimension);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        w4.m mVar = this.f4562c;
        Context context = this.f4561b;
        return i != 1 ? i != 2 ? new m5.t0(androidx.lifecycle.l.E(viewGroup, 2131558803, viewGroup, false), context, mVar) : new m5.c0(androidx.lifecycle.l.E(viewGroup, 2131558768, viewGroup, false)) : new m5.t0(androidx.lifecycle.l.E(viewGroup, 2131558805, viewGroup, false), context, mVar);
    }
}
