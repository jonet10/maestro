package androidx.lifecycle;

import d7.p;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1", f = "Lifecycle.jvm.kt", l = {68}, m = "invokeSuspend", v = 1)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LifecycleCoroutineScope$launchWhenCreated$1 extends v6.i implements p {
    final /* synthetic */ p $block;
    int label;
    final /* synthetic */ LifecycleCoroutineScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleCoroutineScope$launchWhenCreated$1(LifecycleCoroutineScope lifecycleCoroutineScope, p pVar, t6.c cVar) {
        super(2, cVar);
        this.this$0 = lifecycleCoroutineScope;
        this.$block = pVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new LifecycleCoroutineScope$launchWhenCreated$1(this.this$0, this.$block, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((LifecycleCoroutineScope$launchWhenCreated$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            Lifecycle lifecycle$lifecycle_common = this.this$0.getLifecycle$lifecycle_common();
            p pVar = this.$block;
            this.label = 1;
            Object whenCreated = PausingDispatcherKt.whenCreated(lifecycle$lifecycle_common, pVar, this);
            u6.a aVar = u6.a.f10762a;
            if (whenCreated == aVar) {
                return aVar;
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
