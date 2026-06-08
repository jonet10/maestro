package c4;

import com.uptodown.activities.SearchActivity;
import com.uptodown.views.InstantAutoCompleteTextView;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t9 implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f2133a;

    public t9(SearchActivity searchActivity) {
        this.f2133a = searchActivity;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        j5.s sVar = (j5.s) obj;
        boolean a8 = kotlin.jvm.internal.l.a(sVar, j5.p.f6705a);
        SearchActivity searchActivity = this.f2133a;
        if (a8) {
            e4.l0 l0Var = searchActivity.R;
            if (l0Var == null || l0Var.f4602a.isEmpty()) {
                searchActivity.z0().f10138l.setVisibility(0);
            }
        } else if (sVar instanceof j5.r) {
            if (searchActivity.R == null) {
                z9 z9Var = (z9) ((j5.r) sVar).f6707a;
                if (!z9Var.f2402a.isEmpty() || ((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).getText().toString().length() <= 0) {
                    searchActivity.R = new e4.l0(z9Var.f2402a, searchActivity.U, searchActivity.W);
                    searchActivity.z0().f10139m.setAdapter(searchActivity.R);
                } else {
                    searchActivity.z0().f10142p.setVisibility(0);
                    searchActivity.z0().f10142p.setText(searchActivity.getString(2131951723, ((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).getText().toString()));
                    searchActivity.z0().f10139m.setVisibility(8);
                }
            } else if (((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).getText().toString().length() > 0) {
                if (searchActivity.z0().f10139m.getAdapter() == null) {
                    searchActivity.z0().f10139m.setAdapter(searchActivity.R);
                }
                z9 z9Var2 = (z9) ((j5.r) sVar).f6707a;
                boolean z9 = z9Var2.f2403b;
                ArrayList arrayList = z9Var2.f2402a;
                if (z9) {
                    e4.l0 l0Var2 = searchActivity.R;
                    l0Var2.getClass();
                    l0Var2.f4602a = arrayList;
                    l0Var2.notifyDataSetChanged();
                    searchActivity.z0().f10139m.scrollToPosition(0);
                } else if (!arrayList.isEmpty()) {
                    e4.l0 l0Var3 = searchActivity.R;
                    l0Var3.getClass();
                    Iterator it = arrayList.iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        x4.g gVar = (x4.g) next;
                        if (!l0Var3.f4602a.contains(gVar)) {
                            l0Var3.f4602a.add(gVar);
                        }
                    }
                    l0Var3.notifyDataSetChanged();
                }
                e4.l0 l0Var4 = searchActivity.R;
                l0Var4.getClass();
                if (l0Var4.f4602a.isEmpty()) {
                    searchActivity.z0().f10142p.setVisibility(0);
                    searchActivity.z0().f10142p.setText(searchActivity.getString(2131951723, ((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).getText().toString()));
                    searchActivity.z0().f10139m.setVisibility(8);
                } else {
                    searchActivity.z0().f10142p.setVisibility(8);
                    searchActivity.z0().f10139m.setVisibility(0);
                }
            } else {
                e4.l0 l0Var5 = searchActivity.R;
                l0Var5.getClass();
                l0Var5.f4602a = new ArrayList();
                l0Var5.notifyDataSetChanged();
            }
            searchActivity.A0().f1478e = false;
            e4.l0 l0Var6 = searchActivity.R;
            if (l0Var6 != null) {
                l0Var6.f4605d = false;
                l0Var6.notifyItemRemoved(l0Var6.getItemCount());
            }
            searchActivity.z0().f10138l.setVisibility(8);
        } else if (!kotlin.jvm.internal.l.a(sVar, j5.q.f6706a)) {
            com.google.gson.internal.a.b();
            return null;
        }
        return p6.x.f8463a;
    }
}
