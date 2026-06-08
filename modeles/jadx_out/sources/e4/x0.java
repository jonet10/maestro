package e4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import c4.ra;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import m5.c2;
import m5.d2;
import m5.p1;
import x4.q2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x0 extends RecyclerView.Adapter {

    /* renamed from: a, reason: collision with root package name */
    public final w4.n f4715a;

    /* renamed from: b, reason: collision with root package name */
    public final w4.b f4716b;

    /* renamed from: c, reason: collision with root package name */
    public final ra f4717c;

    /* renamed from: d, reason: collision with root package name */
    public final w4.k f4718d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f4719e;
    public final w0 f;
    public int g;
    public boolean h;
    public int i;

    public x0(w4.n nVar, w4.b bVar, ra raVar, w4.k kVar) {
        nVar.getClass();
        bVar.getClass();
        raVar.getClass();
        kVar.getClass();
        this.f4715a = nVar;
        this.f4716b = bVar;
        this.f4717c = raVar;
        this.f4718d = kVar;
        this.f = new w0();
        this.g = -1;
    }

    public final ArrayList a() {
        ArrayList arrayList = this.f4719e;
        if (arrayList != null) {
            return arrayList;
        }
        kotlin.jvm.internal.l.i("data");
        throw null;
    }

    public final void b(Context context, File file) {
        x4.e eVar;
        String str;
        file.getClass();
        j5.g l10 = j5.g.D.l(context);
        l10.b();
        int i = -1;
        int i6 = 0;
        for (Object obj : a()) {
            int i10 = i6 + 1;
            if (!(obj instanceof x4.e) || (str = (eVar = (x4.e) obj).f11123l) == null || str.length() == 0) {
                if (obj instanceof v0) {
                    q2 q2Var = ((v0) obj).f4709b;
                    x4.r rVar = q2Var.f11352s;
                    if ((rVar != null ? rVar.F : null) != null) {
                        rVar.getClass();
                        if (rVar.F.size() > 0) {
                            x4.r rVar2 = q2Var.f11352s;
                            rVar2.getClass();
                            Iterator it = rVar2.F.iterator();
                            it.getClass();
                            while (it.hasNext()) {
                                Object next = it.next();
                                next.getClass();
                                if (l7.u.m0(((x4.j0) next).f11240q, file.getAbsolutePath(), true)) {
                                    i = i6;
                                    break;
                                }
                            }
                        }
                    }
                }
                i6 = i10;
            } else {
                String str2 = eVar.f11123l;
                str2.getClass();
                q2 Y = l10.Y(str2);
                x4.r a8 = Y != null ? Y.a(context) : null;
                if (a8 != null && a8.F.size() > 0) {
                    Iterator it2 = a8.F.iterator();
                    it2.getClass();
                    while (it2.hasNext()) {
                        Object next2 = it2.next();
                        next2.getClass();
                        if (l7.u.m0(((x4.j0) next2).f11240q, file.getAbsolutePath(), true)) {
                            i = i6;
                            break;
                            break;
                        }
                    }
                }
                i6 = i10;
            }
        }
        l10.c();
        if (i >= 0) {
            notifyItemChanged(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return a().size();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        Object obj = a().get(i);
        obj.getClass();
        if (obj instanceof x4.e) {
            return ((x4.e) obj).v == 1 ? 9 : 1;
        }
        if (obj instanceof v0) {
            v0 v0Var = (v0) obj;
            if (v0Var.f4708a.v == 1) {
                return 9;
            }
            return v0Var.f4709b.c() ? 10 : 0;
        }
        if (!(obj instanceof String)) {
            if (obj instanceof w0) {
                return 8;
            }
            s1.o.n();
            return 0;
        }
        String str = (String) obj;
        switch (str.hashCode()) {
            case -1764562172:
                if (str.equals("tracking_disabled")) {
                    return 4;
                }
                break;
            case -864119891:
                if (str.equals("title_recent_updates")) {
                    return 5;
                }
                break;
            case 446114743:
                if (str.equals("warning_not_space")) {
                    return 2;
                }
                break;
            case 903589355:
                if (str.equals("title_ignored")) {
                    return 6;
                }
                break;
            case 1477891299:
                if (str.equals("title_disable_app")) {
                    return 7;
                }
                break;
        }
        s1.o.n();
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01a1  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.ViewHolder r14, int r15) {
        /*
            Method dump skipped, instructions count: 649
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e4.x0.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        ra raVar = this.f4717c;
        w4.b bVar = this.f4716b;
        switch (i) {
            case 0:
                return new p1(androidx.lifecycle.l.E(viewGroup, 2131558855, viewGroup, false), this.f4715a);
            case 1:
                return new m5.d(androidx.lifecycle.l.E(viewGroup, 2131558582, viewGroup, false), bVar);
            case 2:
                return new c2(androidx.lifecycle.l.E(viewGroup, 2131558885, viewGroup, false));
            case 3:
            default:
                com.google.gson.internal.a.p("viewType unknown");
                return null;
            case 4:
                return new d2(androidx.lifecycle.l.E(viewGroup, 2131558830, viewGroup, false), raVar);
            case 5:
                View E = androidx.lifecycle.l.E(viewGroup, 2131558848, viewGroup, false);
                String string = viewGroup.getContext().getString(2131952512);
                string.getClass();
                return new m5.f0(E, string, null);
            case 6:
                View E2 = androidx.lifecycle.l.E(viewGroup, 2131558848, viewGroup, false);
                String string2 = viewGroup.getContext().getString(2131952706);
                string2.getClass();
                return new m5.f0(E2, string2, null);
            case 7:
                View E3 = androidx.lifecycle.l.E(viewGroup, 2131558848, viewGroup, false);
                String string3 = viewGroup.getContext().getString(2131951952);
                string3.getClass();
                return new m5.f0(E3, string3, this.f4718d);
            case 8:
                return new m5.l1(androidx.lifecycle.l.E(viewGroup, 2131558857, viewGroup, false), raVar);
            case 9:
                return new m5.a(androidx.lifecycle.l.E(viewGroup, 2131558582, viewGroup, false), bVar);
            case 10:
                return new m5.k1(androidx.lifecycle.l.E(viewGroup, 2131558582, viewGroup, false), bVar);
        }
    }
}
