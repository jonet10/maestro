package u4;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y0 implements w4.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z0 f10664a;

    public /* synthetic */ y0(z0 z0Var) {
        this.f10664a = z0Var;
    }

    @Override // w4.l
    public void c(x4.g gVar) {
        z0 z0Var = this.f10664a;
        if (z0Var.getActivity() instanceof MainActivity) {
            long j = gVar.f11158a;
            int i = gVar.f11191w0;
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(z0Var);
            v7.e eVar = o7.m0.f8288a;
            o7.c0.s(lifecycleScope, v7.d.f10884a, null, new c4.j0(z0Var, j, "impress", i, null, 9), 2);
        }
    }
}
