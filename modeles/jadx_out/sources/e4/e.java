package e4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.measurement.i5;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4513a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.b f4514b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f4515c;

    public e(ArrayList arrayList, Context context, w4.b bVar) {
        bVar.getClass();
        this.f4513a = context;
        this.f4514b = bVar;
        this.f4515c = arrayList;
        notifyDataSetChanged();
    }

    public final ArrayList a() {
        ArrayList arrayList = this.f4515c;
        if (arrayList != null) {
            return arrayList;
        }
        kotlin.jvm.internal.l.i("data");
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return a().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.getClass();
        if (!(viewHolder instanceof m5.s)) {
            com.google.gson.internal.a.p("ViewHolder unknown!!");
            return;
        }
        m5.s sVar = (m5.s) viewHolder;
        Object obj = a().get(i);
        obj.getClass();
        x4.e eVar = (x4.e) obj;
        sVar.f7558n.setText(eVar.f11122b);
        TextView textView = sVar.f7559o;
        Context context = sVar.f7556l;
        context.getClass();
        textView.setText(i5.H(context, eVar.f11133w));
        ConcurrentHashMap concurrentHashMap = j5.t.f6708a;
        sVar.f7557m.setImageDrawable(j5.t.b(context, eVar.f11123l));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View s6 = androidx.lifecycle.l.s(viewGroup, 2131558559, viewGroup, false);
        s6.getClass();
        return new m5.s(s6, this.f4514b, this.f4513a);
    }
}
