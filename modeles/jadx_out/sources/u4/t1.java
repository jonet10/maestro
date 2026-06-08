package u4;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t1 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f10611a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z1 f10612b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t1(z1 z1Var, t6.c cVar) {
        super(2, cVar);
        this.f10612b = z1Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new t1(this.f10612b, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((t1) create((o7.a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f10611a;
        if (i == 0) {
            p6.a.e(obj);
            Lifecycle.State state = Lifecycle.State.STARTED;
            z1 z1Var = this.f10612b;
            s4.e0 e0Var = new s4.e0(z1Var, (t6.c) null, 7);
            this.f10611a = 1;
            Object repeatOnLifecycle = RepeatOnLifecycleKt.repeatOnLifecycle(z1Var, state, e0Var, this);
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
