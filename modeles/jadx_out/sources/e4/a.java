package e4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.measurement.i5;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4476a;

    /* renamed from: b, reason: collision with root package name */
    public final a3.d f4477b;

    public a(ArrayList arrayList, a3.d dVar) {
        dVar.getClass();
        this.f4476a = arrayList;
        this.f4477b = dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList = this.f4476a;
        if (arrayList == null) {
            return 0;
        }
        arrayList.getClass();
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        m5.b bVar = (m5.b) viewHolder;
        bVar.getClass();
        ArrayList arrayList = this.f4476a;
        x4.e1 e1Var = arrayList != null ? (x4.e1) arrayList.get(i) : null;
        e1Var.getClass();
        bVar.f7309b.setOnClickListener(new g4.b0(3, bVar, e1Var));
        String a8 = e1Var.a();
        if (a8 != null) {
            bVar.f7310l.setText(a8.substring(l7.m.A0(".", a8, 6) + 1));
        }
        bVar.f7311m.setText(e1Var.a());
        TextView textView = bVar.f7312n;
        long j = e1Var.f11139b;
        Context context = bVar.itemView.getContext();
        context.getClass();
        textView.setText(i5.H(context, j));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558434, viewGroup, false);
        s6.getClass();
        a3.d dVar = this.f4477b;
        dVar.getClass();
        m5.b bVar = new m5.b(s6);
        bVar.f7308a = dVar;
        View findViewById = s6.findViewById(2131363111);
        findViewById.getClass();
        bVar.f7309b = (RelativeLayout) findViewById;
        View findViewById2 = s6.findViewById(2131364483);
        findViewById2.getClass();
        TextView textView = (TextView) findViewById2;
        bVar.f7310l = textView;
        View findViewById3 = s6.findViewById(2131364028);
        findViewById3.getClass();
        TextView textView2 = (TextView) findViewById3;
        bVar.f7311m = textView2;
        View findViewById4 = s6.findViewById(2131364299);
        findViewById4.getClass();
        TextView textView3 = (TextView) findViewById4;
        bVar.f7312n = textView3;
        textView.setTypeface(f4.c.f4883x);
        textView2.setTypeface(f4.c.f4882w);
        textView3.setTypeface(f4.c.f4883x);
        return bVar;
    }
}
