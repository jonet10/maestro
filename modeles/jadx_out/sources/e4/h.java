package e4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.Iterator;
import m5.b2;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final w4.j f4540a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.a f4541b;

    /* renamed from: c, reason: collision with root package name */
    public final w4.l f4542c;

    /* renamed from: d, reason: collision with root package name */
    public final String f4543d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f4544e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;

    /* renamed from: k, reason: collision with root package name */
    public int f4545k;

    /* renamed from: l, reason: collision with root package name */
    public final int f4546l;

    /* renamed from: m, reason: collision with root package name */
    public int f4547m;

    /* renamed from: n, reason: collision with root package name */
    public int f4548n;

    public h(w4.j jVar, w4.a aVar, w4.l lVar, String str) {
        jVar.getClass();
        aVar.getClass();
        lVar.getClass();
        this.f4540a = jVar;
        this.f4541b = aVar;
        this.f4542c = lVar;
        this.f4543d = str;
        this.f4544e = new ArrayList();
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = -1;
        this.f4545k = -1;
        this.f4546l = -1;
        this.f4547m = -1;
        this.f4548n = -1;
    }

    public final void a(ArrayList arrayList, int i) {
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            p2 p2Var = (p2) next;
            if (p2Var.f11329a.f11224a == i) {
                b(p2Var);
                arrayList.remove(p2Var);
                return;
            }
        }
    }

    public final void b(p2 p2Var) {
        if (p2Var != null) {
            g gVar = new g();
            gVar.f4532a = p2Var;
            gVar.f4533b = p2Var.f11331c;
            this.f4544e.add(gVar);
            notifyItemInserted(this.f4544e.size() - 1);
        }
    }

    public final void c(p2 p2Var, int i) {
        if (i < 0 || i >= this.f4544e.size()) {
            return;
        }
        g gVar = new g();
        gVar.f4532a = p2Var;
        gVar.f4533b = p2Var.f11331c;
        this.f4544e.set(i, gVar);
        notifyItemChanged(i);
    }

    public final void d(String str, RecyclerView recyclerView) {
        str.getClass();
        recyclerView.getClass();
        int size = this.f4544e.size();
        for (int i = 0; i < size; i++) {
            RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i);
            Object obj = null;
            if (findViewHolderForAdapterPosition instanceof m5.x) {
                u0 u0Var = ((m5.x) findViewHolderForAdapterPosition).f7632m;
                ArrayList arrayList = u0Var.f4704c;
                int size2 = arrayList.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size2) {
                        break;
                    }
                    Object obj2 = arrayList.get(i6);
                    i6++;
                    if (kotlin.jvm.internal.l.a(((x4.g) obj2).F, str)) {
                        obj = obj2;
                        break;
                    }
                }
                u0Var.notifyItemChanged(q6.l.u0(u0Var.f4704c, (x4.g) obj));
            } else if (findViewHolderForAdapterPosition instanceof m5.w) {
                s0 s0Var = ((m5.w) findViewHolderForAdapterPosition).f7624m;
                ArrayList arrayList2 = s0Var.f4687c;
                int size3 = arrayList2.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size3) {
                        break;
                    }
                    Object obj3 = arrayList2.get(i10);
                    i10++;
                    if (kotlin.jvm.internal.l.a(((x4.g) obj3).F, str)) {
                        obj = obj3;
                        break;
                    }
                }
                s0Var.notifyItemChanged(q6.l.u0(s0Var.f4687c, (x4.g) obj));
            } else if (findViewHolderForAdapterPosition instanceof m5.d0) {
                if (kotlin.jvm.internal.l.a(((m5.d0) findViewHolderForAdapterPosition).f7354u, str)) {
                    notifyItemChanged(this.h);
                }
            } else if (findViewHolderForAdapterPosition instanceof b2) {
                m1 m1Var = ((b2) findViewHolderForAdapterPosition).f7322n;
                ArrayList arrayList3 = m1Var.f4632e;
                int size4 = arrayList3.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size4) {
                        break;
                    }
                    Object obj4 = arrayList3.get(i11);
                    i11++;
                    if (kotlin.jvm.internal.l.a(((x4.g) obj4).F, str)) {
                        obj = obj4;
                        break;
                    }
                }
                m1Var.notifyItemChanged(q6.l.u0(m1Var.f4632e, (x4.g) obj));
            } else if (findViewHolderForAdapterPosition instanceof m5.j1) {
                m mVar = ((m5.j1) findViewHolderForAdapterPosition).f7438m;
                ArrayList arrayList4 = mVar.f4623c;
                int size5 = arrayList4.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size5) {
                        break;
                    }
                    Object obj5 = arrayList4.get(i12);
                    i12++;
                    if (kotlin.jvm.internal.l.a(((x4.g) obj5).F, str)) {
                        obj = obj5;
                        break;
                    }
                }
                mVar.notifyItemChanged(q6.l.u0(mVar.f4623c, (x4.g) obj));
            } else if (findViewHolderForAdapterPosition instanceof m5.z) {
                n nVar = ((m5.z) findViewHolderForAdapterPosition).f7649n;
                ArrayList arrayList5 = nVar.f4640c;
                int size6 = arrayList5.size();
                int i13 = 0;
                while (true) {
                    if (i13 >= size6) {
                        break;
                    }
                    Object obj6 = arrayList5.get(i13);
                    i13++;
                    if (kotlin.jvm.internal.l.a(((x4.g) obj6).F, str)) {
                        obj = obj6;
                        break;
                    }
                }
                nVar.notifyItemChanged(q6.l.u0(nVar.f4640c, (x4.g) obj));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4544e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        g gVar = (g) this.f4544e.get(i);
        if (gVar != null) {
            return gVar.f4533b;
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Object a8;
        viewHolder.getClass();
        if (viewHolder instanceof m5.j) {
            return;
        }
        int i6 = 7;
        if (viewHolder instanceof m5.v) {
            m5.v vVar = (m5.v) viewHolder;
            g gVar = (g) this.f4544e.get(i);
            Object a10 = gVar != null ? gVar.a() : null;
            a10.getClass();
            f fVar = (f) a10;
            ViewGroup viewGroup = vVar.f7610n;
            RecyclerView recyclerView = vVar.f7608l;
            TextView textView = vVar.f7607b;
            String str = fVar.f4526c;
            if (str == null) {
                kotlin.jvm.internal.l.i("title");
                throw null;
            }
            textView.setText(str);
            ArrayList arrayList = fVar.f4524a;
            if (arrayList == null) {
                kotlin.jvm.internal.l.i("homeFeatures");
                throw null;
            }
            if (!arrayList.isEmpty()) {
                recyclerView.scrollToPosition(vVar.f7613q);
                recyclerView.smoothScrollBy(1, 0);
                j jVar = vVar.f7609m;
                ArrayList arrayList2 = fVar.f4524a;
                if (arrayList2 == null) {
                    kotlin.jvm.internal.l.i("homeFeatures");
                    throw null;
                }
                jVar.getClass();
                ArrayList arrayList3 = jVar.f4569c;
                arrayList3.clear();
                arrayList3.addAll(arrayList2);
                jVar.notifyDataSetChanged();
            }
            if (viewGroup.getChildCount() == 0) {
                ArrayList arrayList4 = fVar.f4525b;
                if (arrayList4 == null) {
                    kotlin.jvm.internal.l.i("categories");
                    throw null;
                }
                Iterator it = arrayList4.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    x4.j jVar2 = (x4.j) next;
                    View inflate = LayoutInflater.from(vVar.itemView.getContext()).inflate(2131558456, viewGroup, false);
                    inflate.getClass();
                    TextView textView2 = (TextView) inflate;
                    textView2.setTypeface(f4.c.f4882w);
                    textView2.setText(jVar2.f11225b);
                    if (jVar2.equals(q6.l.y0(arrayList4))) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins((int) vVar.itemView.getContext().getResources().getDimension(2131166251), 0, (int) vVar.itemView.getContext().getResources().getDimension(2131166251), 0);
                        textView2.setLayoutParams(layoutParams);
                    }
                    textView2.setOnClickListener(new g4.b0(i6, vVar, jVar2));
                    viewGroup.addView(textView2);
                }
                return;
            }
            return;
        }
        int i10 = 8;
        if (viewHolder instanceof m5.x) {
            g gVar2 = (g) this.f4544e.get(i);
            if ((gVar2 != null ? gVar2.a() : null) instanceof p2) {
                m5.x xVar = (m5.x) viewHolder;
                g gVar3 = (g) this.f4544e.get(i);
                a8 = gVar3 != null ? gVar3.a() : null;
                a8.getClass();
                p2 p2Var = (p2) a8;
                if (p2Var.f11330b.isEmpty()) {
                    xVar.itemView.setVisibility(8);
                    return;
                }
                xVar.f7630b.setOnClickListener(new g4.b0(9, xVar, p2Var));
                xVar.f7631l.setText(p2Var.f11329a.f11225b);
                xVar.f7632m.a(p2Var.f11330b);
                return;
            }
            return;
        }
        if (viewHolder instanceof m5.w) {
            g gVar4 = (g) this.f4544e.get(i);
            if ((gVar4 != null ? gVar4.a() : null) instanceof p2) {
                m5.w wVar = (m5.w) viewHolder;
                g gVar5 = (g) this.f4544e.get(i);
                a8 = gVar5 != null ? gVar5.a() : null;
                a8.getClass();
                p2 p2Var2 = (p2) a8;
                wVar.f7622b.setOnClickListener(new g4.b0(i10, wVar, p2Var2));
                wVar.f7623l.setText(p2Var2.f11329a.f11225b);
                s0 s0Var = wVar.f7624m;
                ArrayList arrayList5 = p2Var2.f11330b;
                s0Var.getClass();
                arrayList5.getClass();
                ArrayList arrayList6 = s0Var.f4687c;
                arrayList6.clear();
                arrayList6.addAll(arrayList5);
                s0Var.notifyDataSetChanged();
                return;
            }
            return;
        }
        if (viewHolder instanceof m5.d0) {
            m5.d0 d0Var = (m5.d0) viewHolder;
            g gVar6 = (g) this.f4544e.get(i);
            Object a11 = gVar6 != null ? gVar6.a() : null;
            a11.getClass();
            x4.g gVar7 = (x4.g) a11;
            d0Var.f7354u = gVar7.F;
            View view = d0Var.itemView;
            view.getClass();
            view.setOnClickListener(new g4.b0(12, d0Var, gVar7));
            d0Var.itemView.setOnLongClickListener(new d4.d(i6, d0Var, gVar7));
            a4.l0 e10 = a4.g0.d().e(gVar7.e());
            e10.f(2131100500);
            float f = UptodownApp.I;
            Context context = d0Var.itemView.getContext();
            context.getClass();
            e10.h(b4.d.w(context));
            e10.e(d0Var.f7348o, null);
            m5.e.f(gVar7, d0Var.f7349p, d0Var.f7350q);
            d0Var.e(d0Var.f7347n, gVar7.i());
            d0Var.c(gVar7, d0Var.f7346m, d0Var.f7347n, d0Var.f7350q, d0Var.f7352s, d0Var.f7351r, d0Var.f7353t);
            return;
        }
        if (viewHolder instanceof b2) {
            b2 b2Var = (b2) viewHolder;
            g gVar8 = (g) this.f4544e.get(i);
            a8 = gVar8 != null ? gVar8.a() : null;
            a8.getClass();
            p2 p2Var3 = (p2) a8;
            b2Var.f7319b.setOnClickListener(new g4.b0(20, b2Var, p2Var3));
            b2Var.f7320l.setText(p2Var3.f11329a.f11225b);
            m1 m1Var = b2Var.f7322n;
            ArrayList arrayList7 = p2Var3.f11330b;
            m1Var.getClass();
            arrayList7.getClass();
            ArrayList arrayList8 = m1Var.f4632e;
            arrayList8.clear();
            arrayList8.addAll(arrayList7);
            return;
        }
        if (viewHolder instanceof m5.j1) {
            m5.j1 j1Var = (m5.j1) viewHolder;
            g gVar9 = (g) this.f4544e.get(i);
            a8 = gVar9 != null ? gVar9.a() : null;
            a8.getClass();
            p2 p2Var4 = (p2) a8;
            j1Var.f7436b.setOnClickListener(new g4.b0(17, j1Var, p2Var4));
            j1Var.f7437l.setText(p2Var4.f11329a.f11225b);
            boolean a12 = kotlin.jvm.internal.l.a(p2Var4.f11329a.f11225b, j1Var.itemView.getContext().getResources().getString(2131952657));
            m mVar = j1Var.f7438m;
            ArrayList arrayList9 = p2Var4.f11330b;
            if (a12) {
                mVar.getClass();
                arrayList9.getClass();
                mVar.f4624d = true;
                mVar.f4623c = arrayList9;
                mVar.notifyDataSetChanged();
                return;
            }
            mVar.getClass();
            arrayList9.getClass();
            mVar.f4624d = false;
            mVar.f4623c = arrayList9;
            mVar.notifyDataSetChanged();
            return;
        }
        if (!(viewHolder instanceof m5.z)) {
            if (!(viewHolder instanceof m5.o)) {
                com.google.gson.internal.a.p("ViewHolder unknown!!");
                return;
            }
            m5.o oVar = (m5.o) viewHolder;
            g gVar10 = (g) this.f4544e.get(i);
            a8 = gVar10 != null ? gVar10.a() : null;
            a8.getClass();
            oVar.a((ArrayList) a8);
            return;
        }
        m5.z zVar = (m5.z) viewHolder;
        g gVar11 = (g) this.f4544e.get(i);
        a8 = gVar11 != null ? gVar11.a() : null;
        a8.getClass();
        p2 p2Var5 = (p2) a8;
        zVar.f7646b.setOnClickListener(new g4.b0(10, zVar, p2Var5));
        zVar.f7647l.setText(p2Var5.f11329a.f11225b);
        n nVar = zVar.f7649n;
        ArrayList arrayList10 = p2Var5.f11330b;
        nVar.getClass();
        arrayList10.getClass();
        ArrayList arrayList11 = nVar.f4640c;
        arrayList11.clear();
        arrayList11.addAll(arrayList10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        w4.a aVar = this.f4541b;
        w4.j jVar = this.f4540a;
        switch (i) {
            case -1:
                return new m5.j(androidx.lifecycle.l.E(viewGroup, 2131558543, viewGroup, false));
            case 0:
                return new m5.v(androidx.lifecycle.l.E(viewGroup, 2131558571, viewGroup, false), jVar, aVar, this.f4542c);
            case 1:
                return new m5.x(androidx.lifecycle.l.E(viewGroup, 2131558574, viewGroup, false), jVar, aVar);
            case 2:
            default:
                com.google.gson.internal.a.p("viewType unknown");
                return null;
            case 3:
                return new m5.d0(androidx.lifecycle.l.E(viewGroup, 2131558573, viewGroup, false), jVar, aVar);
            case 4:
                return new b2(androidx.lifecycle.l.E(viewGroup, 2131558574, viewGroup, false), jVar, aVar, this.f4543d);
            case 5:
                return new m5.j1(androidx.lifecycle.l.E(viewGroup, 2131558574, viewGroup, false), jVar, aVar);
            case 6:
                View E = androidx.lifecycle.l.E(viewGroup, 2131558574, viewGroup, false);
                jVar.getClass();
                aVar.getClass();
                m5.z zVar = new m5.z(E);
                zVar.f7645a = jVar;
                View findViewById = E.findViewById(2131363271);
                findViewById.getClass();
                zVar.f7646b = (RelativeLayout) findViewById;
                View findViewById2 = E.findViewById(2131364402);
                findViewById2.getClass();
                TextView textView = (TextView) findViewById2;
                zVar.f7647l = textView;
                View findViewById3 = E.findViewById(2131363327);
                findViewById3.getClass();
                RecyclerView recyclerView = (RecyclerView) findViewById3;
                GridLayoutManager gridLayoutManager = new GridLayoutManager(E.getContext(), 3, 0, false);
                zVar.f7648m = gridLayoutManager;
                n nVar = new n();
                nVar.f4638a = jVar;
                nVar.f4639b = aVar;
                nVar.f4640c = new ArrayList();
                zVar.f7649n = nVar;
                textView.setTypeface(f4.c.f4882w);
                recyclerView.setLayoutManager(gridLayoutManager);
                recyclerView.setAdapter(nVar);
                recyclerView.setItemAnimator(null);
                recyclerView.addItemDecoration(new m5.y(zVar));
                return zVar;
            case 7:
                return new m5.o(androidx.lifecycle.l.E(viewGroup, 2131558555, viewGroup, false), jVar);
            case 8:
                return new m5.w(androidx.lifecycle.l.E(viewGroup, 2131558574, viewGroup, false), jVar, aVar);
        }
    }
}
