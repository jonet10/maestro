package u4;

import android.content.Context;
import androidx.core.content.ContextCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10613a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f10614b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(f0 f0Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f10613a = i;
        this.f10614b = f0Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f10613a) {
            case 0:
                return new u(this.f10614b, cVar, 0);
            case 1:
                return new u(this.f10614b, cVar, 1);
            case 2:
                return new u(this.f10614b, cVar, 2);
            case 3:
                return new u(this.f10614b, cVar, 3);
            default:
                return new u(this.f10614b, cVar, 4);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f10613a) {
            case 0:
                u uVar = (u) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                uVar.invokeSuspend(xVar);
                return xVar;
            case 1:
                u uVar2 = (u) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                uVar2.invokeSuspend(xVar2);
                return xVar2;
            case 2:
                u uVar3 = (u) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                uVar3.invokeSuspend(xVar3);
                return xVar3;
            case 3:
                u uVar4 = (u) create(a0Var, cVar);
                p6.x xVar4 = p6.x.f8463a;
                uVar4.invokeSuspend(xVar4);
                return xVar4;
            default:
                u uVar5 = (u) create(a0Var, cVar);
                p6.x xVar5 = p6.x.f8463a;
                uVar5.invokeSuspend(xVar5);
                return xVar5;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        String str;
        int i = this.f10613a;
        p6.x xVar = p6.x.f8463a;
        f0 f0Var = this.f10614b;
        switch (i) {
            case 0:
                p6.a.e(obj);
                if (f0Var.getContext() != null && (str = f0Var.B().F) != null && str.length() != 0) {
                    e1.c0 c0Var = j5.g.D;
                    Context requireContext = f0Var.requireContext();
                    requireContext.getClass();
                    j5.g l10 = c0Var.l(requireContext);
                    l10.b();
                    String str2 = f0Var.B().F;
                    str2.getClass();
                    x4.e B = l10.B(str2);
                    if (B != null) {
                        r7.o0 o0Var = f0Var.G().C;
                        o0Var.getClass();
                        o0Var.g(null, B);
                        break;
                    }
                }
                break;
            case 1:
                p6.a.e(obj);
                if (f0Var.G().C.getValue() != null) {
                    Object value = f0Var.G().C.getValue();
                    value.getClass();
                    if (((x4.e) value).v == 0) {
                        String string = f0Var.getString(2131952395);
                        string.getClass();
                        f0.h(f0Var, 2131361876, string);
                        break;
                    }
                }
                String string2 = f0Var.getString(2131952417);
                string2.getClass();
                f0.h(f0Var, 2131361876, string2);
                break;
            case 2:
                p6.a.e(obj);
                if (!f0Var.B().l()) {
                    String string3 = f0Var.getString(2131951692);
                    string3.getClass();
                    f0Var.b0(string3);
                    break;
                } else {
                    f0.j(f0Var);
                    break;
                }
            case 3:
                p6.a.e(obj);
                if (f0Var.B().C0 != 1) {
                    String string4 = f0Var.getString(2131951658);
                    string4.getClass();
                    f0.h(f0Var, 2131361890, string4);
                    t4.b bVar = f0Var.f10473b;
                    bVar.getClass();
                    bVar.U.setBackground(ContextCompat.getDrawable(f0Var.requireContext(), 2131231143));
                    t4.b bVar2 = f0Var.f10473b;
                    bVar2.getClass();
                    k0.k.l(f0Var, 2131231307, bVar2.f9622r);
                    t4.b bVar3 = f0Var.f10473b;
                    bVar3.getClass();
                    bVar3.A0.setTextColor(ContextCompat.getColor(f0Var.requireContext(), 2131100790));
                    t4.b bVar4 = f0Var.f10473b;
                    bVar4.getClass();
                    bVar4.A0.setText(f0Var.getString(2131951658));
                    break;
                } else {
                    String string5 = f0Var.getString(2131952531);
                    string5.getClass();
                    f0.h(f0Var, 2131361890, string5);
                    t4.b bVar5 = f0Var.f10473b;
                    bVar5.getClass();
                    bVar5.U.setBackground(ContextCompat.getDrawable(f0Var.requireContext(), 2131231146));
                    t4.b bVar6 = f0Var.f10473b;
                    bVar6.getClass();
                    k0.k.l(f0Var, 2131231308, bVar6.f9622r);
                    t4.b bVar7 = f0Var.f10473b;
                    bVar7.getClass();
                    bVar7.A0.setTextColor(ContextCompat.getColor(f0Var.requireContext(), 2131100824));
                    t4.b bVar8 = f0Var.f10473b;
                    bVar8.getClass();
                    bVar8.A0.setText(f0Var.getString(2131952531));
                    break;
                }
            default:
                p6.a.e(obj);
                if (f0Var.B().B0 != 1) {
                    String string6 = f0Var.getString(2131951689);
                    string6.getClass();
                    f0.h(f0Var, 2131361898, string6);
                    t4.b bVar9 = f0Var.f10473b;
                    bVar9.getClass();
                    bVar9.Z.setBackground(ContextCompat.getDrawable(f0Var.requireContext(), 2131231143));
                    t4.b bVar10 = f0Var.f10473b;
                    bVar10.getClass();
                    k0.k.l(f0Var, 2131231345, bVar10.f9624s);
                    t4.b bVar11 = f0Var.f10473b;
                    bVar11.getClass();
                    bVar11.L0.setTextColor(ContextCompat.getColor(f0Var.requireContext(), 2131100790));
                    t4.b bVar12 = f0Var.f10473b;
                    bVar12.getClass();
                    bVar12.L0.setText(f0Var.getString(2131951689));
                    break;
                } else {
                    String string7 = f0Var.getString(2131951696);
                    string7.getClass();
                    f0.h(f0Var, 2131361898, string7);
                    t4.b bVar13 = f0Var.f10473b;
                    bVar13.getClass();
                    bVar13.Z.setBackground(ContextCompat.getDrawable(f0Var.requireContext(), 2131231146));
                    t4.b bVar14 = f0Var.f10473b;
                    bVar14.getClass();
                    k0.k.l(f0Var, 2131231346, bVar14.f9624s);
                    t4.b bVar15 = f0Var.f10473b;
                    bVar15.getClass();
                    bVar15.L0.setTextColor(ContextCompat.getColor(f0Var.requireContext(), 2131100824));
                    t4.b bVar16 = f0Var.f10473b;
                    bVar16.getClass();
                    bVar16.L0.setText(f0Var.getString(2131951696));
                    break;
                }
        }
        return xVar;
    }
}
