package i4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.lifecycle.l;
import androidx.recyclerview.widget.RecyclerView;
import g4.b0;
import java.util.ArrayList;
import l4.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final k4.b f5659a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f5660b;

    public c(ArrayList arrayList, k4.b bVar) {
        this.f5659a = bVar;
        this.f5660b = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList = this.f5660b;
        arrayList.getClass();
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        r4.c cVar = (r4.c) viewHolder;
        cVar.getClass();
        CheckBox checkBox = cVar.f8907a;
        ArrayList arrayList = this.f5660b;
        arrayList.getClass();
        checkBox.setText(((n) arrayList.get(i)).f7124e);
        checkBox.setChecked(((n) arrayList.get(i)).f7121b);
        checkBox.setEnabled(((n) arrayList.get(i)).f7123d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = l.s(viewGroup, 2131558822, viewGroup, false);
        s6.getClass();
        k4.b bVar = this.f5659a;
        bVar.getClass();
        r4.c cVar = new r4.c(s6);
        View findViewById = s6.findViewById(2131362008);
        findViewById.getClass();
        CheckBox checkBox = (CheckBox) findViewById;
        cVar.f8907a = checkBox;
        s6.setOnClickListener(new b0(29, cVar, bVar));
        checkBox.setTypeface(f4.c.f4883x);
        return cVar;
    }
}
