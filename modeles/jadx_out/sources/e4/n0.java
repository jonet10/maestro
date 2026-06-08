package e4;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import m5.q1;
import x4.w1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4641a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.b f4642b;

    /* renamed from: c, reason: collision with root package name */
    public final a3.d f4643c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f4644d;

    public n0(ArrayList arrayList, Context context, w4.b bVar, a3.d dVar) {
        arrayList.getClass();
        bVar.getClass();
        dVar.getClass();
        this.f4641a = context;
        this.f4642b = bVar;
        this.f4643c = dVar;
        this.f4644d = new ArrayList();
        a().add("uptodown_protect");
        a().addAll(arrayList);
    }

    public final ArrayList a() {
        ArrayList arrayList = this.f4644d;
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
    public final int getItemViewType(int i) {
        Object obj = a().get(i);
        obj.getClass();
        if (obj instanceof x4.e) {
            return 0;
        }
        if (!(obj instanceof String)) {
            s1.o.n();
            return 0;
        }
        if (((String) obj).equals("uptodown_protect")) {
            return 3;
        }
        s1.o.n();
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.getClass();
        if (viewHolder instanceof m5.m0) {
            m5.m0 m0Var = (m5.m0) viewHolder;
            Object obj = a().get(i);
            obj.getClass();
            x4.e eVar = (x4.e) obj;
            Context context = m0Var.f7473b;
            ConcurrentHashMap concurrentHashMap = j5.t.f6708a;
            m0Var.f7474l.setImageDrawable(j5.t.b(context, eVar.f11123l));
            m0Var.f7475m.setText(eVar.f11122b);
            m0Var.f7476n.setText(eVar.f11125n);
            if (eVar.D != null) {
                String string = context.getString(2131952819);
                string.getClass();
                w1 w1Var = eVar.D;
                w1Var.getClass();
                m0Var.f7477o.setText(String.format(string, Arrays.copyOf(new Object[]{String.valueOf(w1Var.f11428a)}, 1)));
                return;
            }
            return;
        }
        if (!(viewHolder instanceof q1)) {
            com.google.gson.internal.a.p("ViewHolder unknown!!");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = a().iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            if (next instanceof x4.e) {
                arrayList.add(next);
            }
        }
        q1 q1Var = (q1) viewHolder;
        TextView textView = q1Var.f7542n;
        TextView textView2 = q1Var.f7541m;
        ImageView imageView = q1Var.f7540l;
        ImageView imageView2 = q1Var.f7544p;
        Context context2 = this.f4641a;
        context2.getClass();
        q1Var.f7539b.setVisibility(0);
        RelativeLayout relativeLayout = q1Var.f7543o;
        relativeLayout.setOnClickListener(new g4.b0(19, q1Var, context2));
        if (arrayList.size() > 0) {
            imageView.setImageDrawable(ContextCompat.getDrawable(context2, 2131231429));
            textView2.setText(2131952473);
            textView.setText(2131952472);
            relativeLayout.setBackground(ContextCompat.getDrawable(context2, 2131231149));
            q1Var.itemView.setOnClickListener(new m5.u0(q1Var, 3));
        } else {
            imageView.setImageDrawable(ContextCompat.getDrawable(context2, 2131231430));
            textView2.setText(2131952388);
            textView.setText(2131952387);
            relativeLayout.setBackground(ContextCompat.getDrawable(context2, 2131231146));
            q1Var.itemView.setOnClickListener(new c4.e(28));
        }
        if (imageView2.getAnimation() == null || imageView2.getAnimation().getRepeatCount() == 0) {
            return;
        }
        imageView2.getAnimation().setRepeatCount(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        if (i == 0) {
            return new m5.m0(androidx.lifecycle.l.E(viewGroup, 2131558443, viewGroup, false), this.f4642b, this.f4641a);
        }
        if (i == 3) {
            return new q1(androidx.lifecycle.l.E(viewGroup, 2131558859, viewGroup, false), this.f4643c);
        }
        com.google.gson.internal.a.p("viewType unknown");
        return null;
    }
}
