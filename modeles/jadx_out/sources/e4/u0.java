package e4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final w4.c f4702a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.a f4703b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f4704c;

    public u0(w4.c cVar, w4.a aVar) {
        cVar.getClass();
        aVar.getClass();
        this.f4702a = cVar;
        this.f4703b = aVar;
        this.f4704c = new ArrayList();
    }

    public final void a(ArrayList arrayList) {
        arrayList.getClass();
        ArrayList arrayList2 = this.f4704c;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4704c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.getClass();
        t0 t0Var = (t0) viewHolder;
        Object obj = this.f4704c.get(i);
        obj.getClass();
        x4.g gVar = (x4.g) obj;
        int i6 = i + 1;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) t0Var.itemView.getContext().getResources().getDimension(2131166555), -2);
        View view = t0Var.itemView;
        Context context = view.getContext();
        context.getClass();
        u0 u0Var = t0Var.f4698s;
        m5.e.a(layoutParams, context, i6, u0Var.f4704c.size());
        view.setLayoutParams(layoutParams);
        View view2 = t0Var.itemView;
        view2.getClass();
        m5.e.b(view2, t0Var.f4690b, gVar);
        t0Var.itemView.setOnLongClickListener(new d4.d(u0Var, gVar, i6, 5));
        m5.e.f(gVar, t0Var.f4693n, t0Var.f4694o);
        t0Var.e(t0Var.f4691l, gVar.h());
        t0Var.c(gVar, t0Var.f4692m, t0Var.f4691l, t0Var.f4694o, t0Var.f4695p, t0Var.f4697r, t0Var.f4696q);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558451, viewGroup, false);
        s6.getClass();
        return new t0(this, s6, this.f4702a);
    }
}
