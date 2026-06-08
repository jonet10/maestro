package c4;

import android.os.Bundle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.uptodown.UptodownApp;
import com.uptodown.activities.SearchActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r9 implements w4.d, w4.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f2055a;

    public /* synthetic */ r9(SearchActivity searchActivity) {
        this.f2055a = searchActivity;
    }

    @Override // w4.e
    public void a(x4.j jVar) {
        jVar.getClass();
        float f = UptodownApp.I;
        if (b4.d.t()) {
            this.f2055a.E0(jVar);
        }
    }

    @Override // w4.d
    public void b(x4.g gVar) {
        gVar.getClass();
        float f = UptodownApp.I;
        if (b4.d.t()) {
            Bundle e10 = k0.k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "search_item_action_button");
            e10.putString("appId", String.valueOf(gVar.f11158a));
            SearchActivity searchActivity = this.f2055a;
            android.support.v4.media.g gVar2 = searchActivity.E;
            if (gVar2 != null) {
                gVar2.E(e10, "clicked");
            }
            if (gVar.J == 0) {
                searchActivity.i0(gVar.f11158a);
                return;
            }
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(searchActivity);
            v7.e eVar = o7.m0.f8288a;
            o7.c0.s(lifecycleScope, t7.n.f10348a, null, new b.n(searchActivity, gVar, (t6.c) null, 28), 2);
        }
    }

    @Override // w4.d
    public void d(x4.g gVar, int i) {
        gVar.getClass();
        float f = UptodownApp.I;
        if (b4.d.t()) {
            long j = gVar.f11158a;
            String str = gVar.F;
            SearchActivity searchActivity = this.f2055a;
            d0.b.t(j, searchActivity, str);
            e4.l0 l0Var = searchActivity.R;
            if (l0Var != null) {
                l0Var.notifyItemChanged(i);
            }
        }
    }
}
