package c4;

import androidx.lifecycle.ViewModel;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.RollbackActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l1 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1813a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1814b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ViewModel f1815l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ k0 f1816m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l1(boolean z9, ViewModel viewModel, k0 k0Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f1813a = i;
        this.f1814b = z9;
        this.f1815l = viewModel;
        this.f1816m = k0Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1813a) {
            case 0:
                return new l1(this.f1814b, (m1) this.f1815l, (FreeUpSpaceActivity) this.f1816m, cVar, 0);
            case 1:
                return new l1(this.f1814b, (y4) this.f1815l, (MyApps) this.f1816m, cVar, 1);
            default:
                return new l1(this.f1814b, (l9) this.f1815l, (RollbackActivity) this.f1816m, cVar, 2);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1813a) {
            case 0:
                l1 l1Var = (l1) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                l1Var.invokeSuspend(xVar);
                return xVar;
            case 1:
                l1 l1Var2 = (l1) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                l1Var2.invokeSuspend(xVar2);
                return xVar2;
            default:
                l1 l1Var3 = (l1) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                l1Var3.invokeSuspend(xVar3);
                return xVar3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x017b A[SYNTHETIC] */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.l1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
