package c4;

import com.uptodown.activities.OldVersionsActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d6 implements r7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OldVersionsActivity f1511a;

    public d6(OldVersionsActivity oldVersionsActivity) {
        this.f1511a = oldVersionsActivity;
    }

    @Override // r7.i
    public final Object emit(Object obj, t6.c cVar) {
        j5.s sVar = (j5.s) obj;
        boolean a8 = kotlin.jvm.internal.l.a(sVar, j5.p.f6705a);
        OldVersionsActivity oldVersionsActivity = this.f1511a;
        if (a8) {
            int i = OldVersionsActivity.S;
            if (oldVersionsActivity.A0().f) {
                oldVersionsActivity.y0().f9668b.setVisibility(0);
            }
        } else if (sVar instanceof j5.r) {
            g6 g6Var = (g6) ((j5.r) sVar).f6707a;
            boolean z9 = g6Var.f1631d;
            x4.g gVar = g6Var.f1629b;
            if (z9) {
                int i6 = OldVersionsActivity.S;
                oldVersionsActivity.A0().f1680c.f(g6Var.f1628a);
                r7.o0 o0Var = oldVersionsActivity.A0().f1681d;
                o0Var.getClass();
                o0Var.g(null, gVar);
                ArrayList arrayList = g6Var.f1630c;
                if (arrayList != null) {
                    e4.s sVar2 = oldVersionsActivity.Q;
                    if (sVar2 == null) {
                        gVar.E0 = arrayList;
                        Object value = oldVersionsActivity.A0().f1681d.getValue();
                        value.getClass();
                        x4.g gVar2 = (x4.g) value;
                        x4.e eVar = (x4.e) oldVersionsActivity.A0().f1680c.getValue();
                        f0.i iVar = oldVersionsActivity.R;
                        Object value2 = oldVersionsActivity.A0().f1681d.getValue();
                        value2.getClass();
                        oldVersionsActivity.Q = new e4.s(gVar2, eVar, oldVersionsActivity, iVar, ((x4.g) value2).f11176o0);
                        oldVersionsActivity.y0().f9669l.setAdapter(oldVersionsActivity.Q);
                    } else {
                        int i10 = oldVersionsActivity.A0().h;
                        x4.e eVar2 = (x4.e) oldVersionsActivity.A0().f1680c.getValue();
                        sVar2.f4680a.E0 = arrayList;
                        sVar2.f = i10;
                        sVar2.f4681b = eVar2;
                        sVar2.notifyDataSetChanged();
                        oldVersionsActivity.y0().f9669l.post(new a2.s(oldVersionsActivity, 6));
                    }
                } else {
                    oldVersionsActivity.y0().f9670m.setVisibility(0);
                }
                oldVersionsActivity.A0().f = false;
                oldVersionsActivity.y0().f9668b.setVisibility(8);
                oldVersionsActivity.A0().f1682e = false;
            } else {
                int i11 = OldVersionsActivity.S;
                x4.g gVar3 = (x4.g) oldVersionsActivity.A0().f1681d.getValue();
                if (gVar3 != null) {
                    gVar3.E0 = null;
                }
                oldVersionsActivity.y0().f9670m.setVisibility(0);
                oldVersionsActivity.A0().f = false;
                oldVersionsActivity.y0().f9668b.setVisibility(8);
                oldVersionsActivity.A0().f1682e = false;
            }
        } else if (!kotlin.jvm.internal.l.a(sVar, j5.q.f6706a)) {
            com.google.gson.internal.a.b();
            return null;
        }
        return p6.x.f8463a;
    }
}
