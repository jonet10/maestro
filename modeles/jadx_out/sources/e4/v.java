package e4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public w4.c f4705a;

    /* renamed from: b, reason: collision with root package name */
    public Context f4706b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f4707c;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4707c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        u uVar = (u) viewHolder;
        uVar.getClass();
        boolean a8 = kotlin.jvm.internal.l.a(this.f4707c.get(i), q6.l.y0(this.f4707c));
        ArrayList arrayList = this.f4707c;
        if (a8) {
            Object obj = arrayList.get(i);
            obj.getClass();
            uVar.g((x4.g) obj, true);
        } else {
            Object obj2 = arrayList.get(i);
            obj2.getClass();
            uVar.g((x4.g) obj2, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        return new u(this, g4.v.f(LayoutInflater.from(viewGroup.getContext()), viewGroup), this.f4705a, this.f4706b);
    }
}
