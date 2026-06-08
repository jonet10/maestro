package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d7.p;
import p6.x;
import q7.r;
import q7.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.lifecycle.LifecycleKt$eventFlow$1", f = "Lifecycle.kt", l = {376}, m = "invokeSuspend", v = 1)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LifecycleKt$eventFlow$1 extends v6.i implements p {
    final /* synthetic */ Lifecycle $this_eventFlow;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleKt$eventFlow$1(Lifecycle lifecycle, t6.c cVar) {
        super(2, cVar);
        this.$this_eventFlow = lifecycle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(s sVar, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        r rVar = (r) sVar;
        rVar.p(event);
        if (event == Lifecycle.Event.ON_DESTROY) {
            rVar.m(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x invokeSuspend$lambda$1(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
        lifecycle.removeObserver(lifecycleEventObserver);
        return x.f8463a;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        LifecycleKt$eventFlow$1 lifecycleKt$eventFlow$1 = new LifecycleKt$eventFlow$1(this.$this_eventFlow, cVar);
        lifecycleKt$eventFlow$1.L$0 = obj;
        return lifecycleKt$eventFlow$1;
    }

    @Override // d7.p
    public final Object invoke(s sVar, t6.c cVar) {
        return ((LifecycleKt$eventFlow$1) create(sVar, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            s sVar = (s) this.L$0;
            final g gVar = new g(sVar, 0);
            this.$this_eventFlow.addObserver(gVar);
            final Lifecycle lifecycle = this.$this_eventFlow;
            d7.a aVar = new d7.a() { // from class: androidx.lifecycle.h
                @Override // d7.a
                public final Object invoke() {
                    x invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = LifecycleKt$eventFlow$1.invokeSuspend$lambda$1(Lifecycle.this, gVar);
                    return invokeSuspend$lambda$1;
                }
            };
            this.label = 1;
            Object o10 = d0.b.o(sVar, aVar, this);
            u6.a aVar2 = u6.a.f10762a;
            if (o10 == aVar2) {
                return aVar2;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return x.f8463a;
    }
}
