package androidx.datastore.core;

import d7.p;
import o7.a0;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.MultiProcessCoordinator$withLazyCounter$2", f = "MultiProcessCoordinator.android.kt", l = {163}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MultiProcessCoordinator$withLazyCounter$2 extends i implements p {
    final /* synthetic */ p $block;
    int label;
    final /* synthetic */ MultiProcessCoordinator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiProcessCoordinator$withLazyCounter$2(p pVar, MultiProcessCoordinator multiProcessCoordinator, c cVar) {
        super(2, cVar);
        this.$block = pVar;
        this.this$0 = multiProcessCoordinator;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new MultiProcessCoordinator$withLazyCounter$2(this.$block, this.this$0, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((MultiProcessCoordinator$withLazyCounter$2) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        SharedCounter sharedCounter;
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                p6.a.e(obj);
                return obj;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        p pVar = this.$block;
        sharedCounter = this.this$0.getSharedCounter();
        this.label = 1;
        Object invoke = pVar.invoke(sharedCounter, this);
        u6.a aVar = u6.a.f10762a;
        return invoke == aVar ? aVar : invoke;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        SharedCounter sharedCounter;
        p pVar = this.$block;
        sharedCounter = this.this$0.getSharedCounter();
        return pVar.invoke(sharedCounter, this);
    }
}
