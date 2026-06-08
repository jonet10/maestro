package p9;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b2.t1;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final List f8515a;

    public e(List list) {
        list.getClass();
        this.f8515a = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f8515a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        h hVar = (h) viewHolder;
        hVar.getClass();
        TextView textView = hVar.f8522b;
        g gVar = (g) this.f8515a.get(i);
        gVar.getClass();
        TextView textView2 = hVar.f8531t;
        textView2.setText(gVar.f8516a);
        TextView textView3 = hVar.f8530s;
        textView3.setText(gVar.f8517b);
        TextView textView4 = hVar.f8529r;
        textView4.setText(gVar.f8518l);
        TextView textView5 = hVar.f8528q;
        textView5.setText(gVar.f8519m);
        TextView textView6 = hVar.f8527p;
        textView6.setText(gVar.f8520n);
        h9.d dVar = m9.c.f7860d;
        if (dVar != null) {
            Integer num = dVar.i;
            if (num != null) {
                int intValue = num.intValue();
                textView2.setTextColor(intValue);
                hVar.f8526o.setTextColor(intValue);
                textView3.setTextColor(intValue);
                hVar.f8525n.setTextColor(intValue);
                textView4.setTextColor(intValue);
                hVar.f8524m.setTextColor(intValue);
                textView5.setTextColor(intValue);
                hVar.f8523l.setTextColor(intValue);
                textView6.setTextColor(intValue);
                textView.setTextColor(intValue);
            }
            Integer num2 = dVar.f5495a;
            if (num2 != null) {
                hVar.f8521a.setBackgroundColor(num2.intValue());
            }
        }
        t1.f(o6.e.f8227d, hVar.f8531t, hVar.f8526o, hVar.f8530s, hVar.f8525n, hVar.f8529r, hVar.f8524m, hVar.f8528q, hVar.f8523l, hVar.f8527p);
        t1.f(o6.e.f8226c, textView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558664, viewGroup, false);
        s6.getClass();
        return new h(s6);
    }
}
