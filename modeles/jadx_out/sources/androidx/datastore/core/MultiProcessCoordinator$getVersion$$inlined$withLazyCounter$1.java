package androidx.datastore.core;

import d7.p;
import o7.a0;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1", f = "MultiProcessCoordinator.android.kt", l = {}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1 extends i implements p {
    int label;
    final /* synthetic */ MultiProcessCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(MultiProcessCoordinator multiProcessCoordinator, c cVar) {
        super(2, cVar);
        this.this$0 = multiProcessCoordinator;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1(this.this$0, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((MultiProcessCoordinator$getVersion$$inlined$withLazyCounter$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        SharedCounter sharedCounter;
        if (this.label != 0) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        sharedCounter = this.this$0.getSharedCounter();
        return new Integer(sharedCounter.getValue());
    }
}
