package u4;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e1 implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f1 f10468a;

    public e1(f1 f1Var) {
        this.f10468a = f1Var;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        j5.s sVar = (j5.s) obj;
        boolean z9 = sVar instanceof j5.p;
        f1 f1Var = this.f10468a;
        if (z9) {
            if (f1Var.f10489l == null) {
                f1Var.a().f9931o.setVisibility(0);
            }
            if (f1Var.a().f9936t.isRefreshing()) {
                f1Var.f10489l = null;
                f1Var.a().f9936t.setRefreshing(false);
            }
        } else if (sVar instanceof j5.r) {
            f1Var.b().g = false;
            if (f1Var.f10489l == null) {
                f1Var.f10489l = new e4.c((ArrayList) ((j5.r) sVar).f6707a, f1Var.f10491n);
                f1Var.a().f9935s.setAdapter(f1Var.f10489l);
            } else {
                Iterator it = ((ArrayList) ((j5.r) sVar).f6707a).iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    e4.c cVar2 = f1Var.f10489l;
                    cVar2.getClass();
                    cVar2.f4496a.add((x4.d1) next);
                    cVar2.notifyItemInserted(cVar2.getItemCount());
                }
            }
            e4.c cVar3 = f1Var.f10489l;
            if (cVar3 != null) {
                cVar3.a(false);
            }
            e4.c cVar4 = f1Var.f10489l;
            ArrayList arrayList = cVar4 != null ? cVar4.f4496a : null;
            if (arrayList == null || arrayList.isEmpty()) {
                f1Var.a().f9930n.setVisibility(0);
                f1Var.a().f9939x.setVisibility(0);
            } else {
                f1Var.a().f9935s.setVisibility(0);
                f1Var.a().f9930n.setVisibility(8);
                f1Var.a().f9939x.setVisibility(8);
            }
            f1Var.a().f9929m.setVisibility(8);
            f1Var.a().f9931o.setVisibility(8);
        } else if (!(sVar instanceof j5.q)) {
            com.google.gson.internal.a.b();
            return null;
        }
        return p6.x.f8463a;
    }
}
