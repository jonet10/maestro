package c4;

import com.uptodown.UptodownApp;
import com.uptodown.activities.Updates;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class oa implements w4.b, w4.n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1962a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Updates f1963b;

    public /* synthetic */ oa(Updates updates, int i) {
        this.f1962a = i;
        this.f1963b = updates;
    }

    @Override // w4.n
    public void a(int i) {
        int i6 = Updates.n0;
        Updates updates = this.f1963b;
        if (updates.W0(i)) {
            e4.x0 x0Var = updates.f3356c0;
            x0Var.getClass();
            Object obj = x0Var.a().get(i);
            obj.getClass();
            ((e4.v0) obj).f4708a.E = true;
            e4.x0 x0Var2 = updates.f3356c0;
            x0Var2.getClass();
            x0Var2.notifyItemChanged(i);
        }
    }

    @Override // w4.b
    public final void b(int i) {
        int i6 = this.f1962a;
        x4.e eVar = null;
        Updates updates = this.f1963b;
        switch (i6) {
            case 0:
                float f = UptodownApp.I;
                if (b4.d.t()) {
                    e4.x0 x0Var = updates.f3356c0;
                    boolean z9 = (x0Var != null ? x0Var.a().get(i) : null) instanceof e4.v0;
                    e4.x0 x0Var2 = updates.f3356c0;
                    if (z9) {
                        x0Var2.getClass();
                        Object obj = x0Var2.a().get(i);
                        obj.getClass();
                        eVar = ((e4.v0) obj).f4708a;
                    } else {
                        if ((x0Var2 != null ? x0Var2.a().get(i) : null) instanceof x4.e) {
                            e4.x0 x0Var3 = updates.f3356c0;
                            x0Var3.getClass();
                            Object obj2 = x0Var3.a().get(i);
                            obj2.getClass();
                            eVar = (x4.e) obj2;
                        }
                    }
                    if (eVar != null) {
                        updates.B0(eVar, i);
                        break;
                    }
                }
                break;
            default:
                float f10 = UptodownApp.I;
                if (b4.d.t()) {
                    e4.x0 x0Var4 = updates.f3356c0;
                    if ((x0Var4 != null ? x0Var4.a().get(i) : null) instanceof e4.v0) {
                        e4.x0 x0Var5 = updates.f3356c0;
                        x0Var5.getClass();
                        Object obj3 = x0Var5.a().get(i);
                        obj3.getClass();
                        updates.B0(((e4.v0) obj3).f4708a, i);
                        break;
                    }
                }
                break;
        }
    }

    @Override // w4.n
    public void c(int i) {
        float f = UptodownApp.I;
        if (b4.d.t()) {
            int i6 = Updates.n0;
            Updates updates = this.f1963b;
            if (updates.W0(i)) {
                e4.x0 x0Var = updates.f3356c0;
                x0Var.getClass();
                Object obj = x0Var.a().get(i);
                obj.getClass();
                x4.e eVar = ((e4.v0) obj).f4708a;
                updates.I0(eVar);
                String str = eVar.f11123l;
                if (str != null) {
                    ArrayList arrayList = updates.f3357d0;
                    if (arrayList == null || !arrayList.isEmpty()) {
                        int size = arrayList.size();
                        int i10 = 0;
                        while (i10 < size) {
                            Object obj2 = arrayList.get(i10);
                            i10++;
                            if (kotlin.jvm.internal.l.a(((x4.e) obj2).f11123l, str)) {
                                break;
                            }
                        }
                    }
                    updates.f3357d0.add(eVar);
                    updates.Z0(updates.f3357d0.size() - 1);
                }
                updates.a1();
                e4.x0 x0Var2 = updates.f3356c0;
                x0Var2.getClass();
                x0Var2.notifyItemChanged(i);
            }
        }
    }

    @Override // w4.n
    public void d(int i) {
        float f = UptodownApp.I;
        if (b4.d.t()) {
            int i6 = Updates.n0;
            Updates updates = this.f1963b;
            updates.O0(i);
            e4.x0 x0Var = updates.f3356c0;
            if (x0Var != null) {
                x0Var.h = false;
            }
        }
    }

    @Override // w4.n
    public void e(int i) {
        int i6 = Updates.n0;
        Updates updates = this.f1963b;
        if (updates.W0(i)) {
            e4.x0 x0Var = updates.f3356c0;
            x0Var.getClass();
            Object obj = x0Var.a().get(i);
            obj.getClass();
            ((e4.v0) obj).f4708a.E = false;
            e4.x0 x0Var2 = updates.f3356c0;
            x0Var2.getClass();
            x0Var2.notifyItemChanged(i);
        }
    }
}
