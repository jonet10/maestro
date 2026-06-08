package u4;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f10667a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f10668b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(f0 f0Var, t6.c cVar) {
        super(2, cVar);
        this.f10668b = f0Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new z(this.f10668b, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((z) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f10667a;
        if (i == 0) {
            p6.a.e(obj);
            Lifecycle.State state = Lifecycle.State.STARTED;
            f0 f0Var = this.f10668b;
            s4.e0 e0Var = new s4.e0(f0Var, (t6.c) null, 4);
            this.f10667a = 1;
            Object repeatOnLifecycle = RepeatOnLifecycleKt.repeatOnLifecycle(f0Var, state, e0Var, this);
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
