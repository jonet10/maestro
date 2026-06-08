package i4;

import android.net.nsd.NsdServiceInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.l;
import androidx.recyclerview.widget.RecyclerView;
import f0.i;
import g4.b0;
import java.util.ArrayList;
import l7.m;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f5653a;

    /* renamed from: b, reason: collision with root package name */
    public i f5654b;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        ArrayList arrayList = this.f5653a;
        arrayList.getClass();
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        r4.a aVar = (r4.a) viewHolder;
        aVar.getClass();
        TextView textView = aVar.f8900a;
        ArrayList arrayList = this.f5653a;
        arrayList.getClass();
        String serviceName = ((NsdServiceInfo) arrayList.get(i)).getServiceName();
        serviceName.getClass();
        textView.setText(serviceName.substring(0, m.y0(serviceName, "_d:_", 0, false, 6)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        View E = l.E(viewGroup, 2131558483, viewGroup, false);
        i iVar = this.f5654b;
        r4.a aVar = new r4.a(E);
        View findViewById = E.findViewById(2131363800);
        findViewById.getClass();
        TextView textView = (TextView) findViewById;
        aVar.f8900a = textView;
        E.setOnClickListener(new b0(27, iVar, aVar));
        textView.setTypeface(f4.c.f4883x);
        return aVar;
    }
}
