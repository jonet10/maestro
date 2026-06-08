package e4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.UptodownApp;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4534a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.b f4535b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4536c;

    public g0(ArrayList arrayList, w4.b bVar) {
        arrayList.getClass();
        this.f4534a = arrayList;
        this.f4535b = bVar;
        this.f4536c = arrayList.size() - 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4534a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        f0 f0Var = (f0) viewHolder;
        f0Var.getClass();
        Object obj = this.f4534a.get(i);
        obj.getClass();
        x4.g gVar = (x4.g) obj;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        g4.v vVar = f0Var.f4527b;
        RelativeLayout relativeLayout = (RelativeLayout) vVar.f5278n;
        Context context = f0Var.itemView.getContext();
        context.getClass();
        m5.e.a(layoutParams, context, i, f0Var.f4529m.f4536c);
        relativeLayout.setLayoutParams(layoutParams);
        a4.l0 e10 = a4.g0.d().e(gVar.f11187u);
        float f = UptodownApp.I;
        Context context2 = f0Var.itemView.getContext();
        context2.getClass();
        e10.g(b4.d.f(context2));
        Context context3 = f0Var.itemView.getContext();
        context3.getClass();
        e10.h(b4.d.x(context3));
        e10.e((ImageView) vVar.f5280p, null);
        a4.l0 e11 = a4.g0.d().e(gVar.f());
        Context context4 = f0Var.itemView.getContext();
        context4.getClass();
        e11.g(b4.d.f(context4));
        a4.k0 k0Var = e11.f135b;
        k0Var.f = true;
        k0Var.g = 17;
        e11.f136c = true;
        Context context5 = f0Var.itemView.getContext();
        context5.getClass();
        e11.h(b4.d.w(context5));
        e11.e((ImageView) vVar.f5279o, null);
        ((TextView) vVar.f5276l).setText(gVar.f11159b);
        ((TextView) vVar.f5275b).setText(gVar.f11175o);
        ((RelativeLayout) vVar.f5278n).setOnClickListener(new e0(f0Var, i, 0));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        return new f0(this, g4.v.f(LayoutInflater.from(viewGroup.getContext()), null), this.f4535b);
    }
}
