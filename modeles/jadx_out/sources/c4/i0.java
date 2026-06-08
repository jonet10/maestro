package c4;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f1707a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k0 f1708b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(k0 k0Var, t6.c cVar) {
        super(2, cVar);
        this.f1708b = k0Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new i0(this.f1708b, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((i0) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f1707a;
        if (i == 0) {
            p6.a.e(obj);
            Lifecycle.State state = Lifecycle.State.STARTED;
            k0 k0Var = this.f1708b;
            h0 h0Var = new h0(k0Var, null, 0);
            this.f1707a = 1;
            Object repeatOnLifecycle = RepeatOnLifecycleKt.repeatOnLifecycle(k0Var, state, h0Var, this);
            u6.a aVar = u6.a.f10762a;
            if (repeatOnLifecycle == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return p6.x.f8463a;
    }
}
