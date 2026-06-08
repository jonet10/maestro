package e4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public w4.j f4638a;

    /* renamed from: b, reason: collision with root package name */
    public w4.a f4639b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f4640c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4640c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        TextView textView;
        LinearLayout linearLayout;
        m5.c cVar = (m5.c) viewHolder;
        cVar.getClass();
        Object obj = this.f4640c.get(i);
        obj.getClass();
        x4.g gVar = (x4.g) obj;
        RelativeLayout relativeLayout = cVar.f7325m;
        m5.e.b(relativeLayout, cVar.f7323b, gVar);
        relativeLayout.setOnLongClickListener(new d4.d(cVar, gVar, i, 6));
        TextView textView2 = cVar.f7327o;
        TextView textView3 = cVar.f7328p;
        m5.e.f(gVar, textView2, textView3);
        cVar.e(cVar.f7326n, gVar.i());
        ProgressBar progressBar = cVar.f7330r;
        if (progressBar == null || (textView = cVar.f7331s) == null || (linearLayout = cVar.f7332t) == null) {
            cVar.d(gVar.F, cVar.f7329q, textView3);
        } else {
            cVar.c(gVar, progressBar, cVar.f7326n, cVar.f7328p, textView, cVar.f7329q, linearLayout);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558436, viewGroup, false);
        s6.getClass();
        return new m5.c(s6, this.f4638a, this.f4639b);
    }
}
