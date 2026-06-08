package c4;

import com.uptodown.activities.SearchActivity;
import com.uptodown.views.InstantAutoCompleteTextView;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v9 implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f2227a;

    public v9(SearchActivity searchActivity) {
        this.f2227a = searchActivity;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        j5.s sVar = (j5.s) obj;
        boolean a8 = kotlin.jvm.internal.l.a(sVar, j5.p.f6705a);
        SearchActivity searchActivity = this.f2227a;
        if (a8) {
            e4.m0 m0Var = searchActivity.S;
            if (m0Var == null || m0Var.f4625a.isEmpty()) {
                searchActivity.z0().f10138l.setVisibility(0);
            }
        } else if (sVar instanceof j5.r) {
            if (searchActivity.S == null) {
                aa aaVar = (aa) ((j5.r) sVar).f6707a;
                if (!aaVar.f1388a.isEmpty() || ((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).getText().toString().length() <= 0) {
                    searchActivity.S = new e4.m0(aaVar.f1388a, searchActivity.V);
                    searchActivity.z0().f10139m.setAdapter(searchActivity.S);
                } else {
                    searchActivity.z0().f10142p.setVisibility(0);
                    searchActivity.z0().f10142p.setText(searchActivity.getString(2131951770, ((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).getText().toString()));
                    searchActivity.z0().f10139m.setVisibility(8);
                }
            } else if (((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).getText().toString().length() > 0) {
                if (searchActivity.z0().f10139m.getAdapter() == null) {
                    searchActivity.z0().f10139m.setAdapter(searchActivity.R);
                }
                aa aaVar2 = (aa) ((j5.r) sVar).f6707a;
                boolean z9 = aaVar2.f1389b;
                ArrayList arrayList = aaVar2.f1388a;
                if (z9) {
                    e4.m0 m0Var2 = searchActivity.S;
                    m0Var2.getClass();
                    m0Var2.f4625a = arrayList;
                    m0Var2.notifyDataSetChanged();
                    searchActivity.z0().f10139m.scrollToPosition(0);
                } else if (!arrayList.isEmpty()) {
                    e4.m0 m0Var3 = searchActivity.S;
                    m0Var3.getClass();
                    Iterator it = arrayList.iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        x4.j jVar = (x4.j) next;
                        if (!m0Var3.f4625a.contains(jVar)) {
                            m0Var3.f4625a.add(jVar);
                        }
                    }
                    m0Var3.notifyDataSetChanged();
                }
                e4.m0 m0Var4 = searchActivity.S;
                m0Var4.getClass();
                if (m0Var4.f4625a.isEmpty()) {
                    searchActivity.z0().f10142p.setVisibility(0);
                    searchActivity.z0().f10142p.setText(searchActivity.getString(2131951770, ((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).getText().toString()));
                    searchActivity.z0().f10139m.setVisibility(8);
                } else {
                    searchActivity.z0().f10142p.setVisibility(8);
                    searchActivity.z0().f10139m.setVisibility(0);
                }
            } else {
                e4.m0 m0Var5 = searchActivity.S;
                m0Var5.getClass();
                m0Var5.f4625a = new ArrayList();
                m0Var5.notifyDataSetChanged();
            }
            searchActivity.A0().f1478e = false;
            e4.m0 m0Var6 = searchActivity.S;
            if (m0Var6 != null) {
                m0Var6.f4627c = false;
                m0Var6.notifyItemRemoved(m0Var6.getItemCount());
            }
            searchActivity.z0().f10138l.setVisibility(8);
        } else if (!kotlin.jvm.internal.l.a(sVar, j5.q.f6706a)) {
            com.google.gson.internal.a.b();
            return null;
        }
        return p6.x.f8463a;
    }
}
