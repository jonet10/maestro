package e4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import m5.p1;
import x4.q2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final w4.b f4651a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.n f4652b;

    /* renamed from: c, reason: collision with root package name */
    public final w4.k f4653c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f4654d;

    /* renamed from: e, reason: collision with root package name */
    public int f4655e;

    public p(w4.b bVar, w4.n nVar, w4.k kVar) {
        bVar.getClass();
        kVar.getClass();
        this.f4651a = bVar;
        this.f4652b = nVar;
        this.f4653c = kVar;
        this.f4654d = new ArrayList();
        this.f4655e = -1;
    }

    public final void a(Context context, File file) {
        x4.e eVar;
        String str;
        file.getClass();
        j5.g l10 = j5.g.D.l(context);
        l10.b();
        Iterator it = this.f4654d.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            int i6 = i + 1;
            Object next = it.next();
            if ((next instanceof x4.e) && (str = (eVar = (x4.e) next).f11123l) != null && str.length() != 0) {
                String str2 = eVar.f11123l;
                str2.getClass();
                q2 Y = l10.Y(str2);
                x4.r a8 = Y != null ? Y.a(context) : null;
                if (a8 != null && a8.F.size() == 1 && l7.u.m0(((x4.j0) a8.F.get(0)).f11240q, file.getAbsolutePath(), true)) {
                    break;
                }
            }
            i = i6;
        }
        l10.c();
        if (i >= 0) {
            notifyItemChanged(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f4654d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        Object obj = this.f4654d.get(i);
        obj.getClass();
        if (obj instanceof v0) {
            return 1;
        }
        if (obj instanceof x4.e) {
            return 0;
        }
        if (!(obj instanceof String)) {
            s1.o.n();
            return 0;
        }
        String str = (String) obj;
        int hashCode = str.hashCode();
        if (hashCode != 1477891299) {
            if (hashCode != 1692569964) {
                if (hashCode == 2032679000 && str.equals("title_system_app")) {
                    return 2;
                }
            } else if (str.equals("title_system_service")) {
                return 3;
            }
        } else if (str.equals("title_disable_app")) {
            return 4;
        }
        s1.o.n();
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.getClass();
        if (viewHolder instanceof m5.d) {
            Object obj = this.f4654d.get(i);
            obj.getClass();
            ((m5.d) viewHolder).a((x4.e) obj);
            return;
        }
        if (viewHolder instanceof p1) {
            p1 p1Var = (p1) viewHolder;
            Object obj2 = this.f4654d.get(i);
            obj2.getClass();
            p1Var.a((v0) obj2, this.f4655e == i, false);
            return;
        }
        if (!(viewHolder instanceof m5.f0)) {
            com.google.gson.internal.a.p("ViewHolder unknown!!");
            return;
        }
        m5.f0 f0Var = (m5.f0) viewHolder;
        ImageView imageView = f0Var.f7378l;
        f0Var.f7377b.setVisibility(0);
        if (f0Var.f7376a == null) {
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        } else {
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (imageView != null) {
                imageView.setOnClickListener(new m5.e0(f0Var, 1));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        if (i == 0) {
            return new m5.d(androidx.lifecycle.l.E(viewGroup, 2131558582, viewGroup, false), this.f4651a);
        }
        if (i == 1) {
            return new p1(androidx.lifecycle.l.E(viewGroup, 2131558855, viewGroup, false), this.f4652b);
        }
        if (i == 2) {
            View E = androidx.lifecycle.l.E(viewGroup, 2131558848, viewGroup, false);
            String string = E.getContext().getString(2131952636);
            string.getClass();
            return new m5.f0(E, string, null);
        }
        if (i == 3) {
            View E2 = androidx.lifecycle.l.E(viewGroup, 2131558848, viewGroup, false);
            String string2 = E2.getContext().getString(2131952234);
            string2.getClass();
            return new m5.f0(E2, string2, null);
        }
        if (i != 4) {
            com.google.gson.internal.a.p("viewType unknown");
            return null;
        }
        View E3 = androidx.lifecycle.l.E(viewGroup, 2131558848, viewGroup, false);
        String string3 = E3.getContext().getString(2131951952);
        string3.getClass();
        return new m5.f0(E3, string3, this.f4653c);
    }
}
