package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d7.p;
import o7.a0;
import o7.e1;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", f = "Lifecycle.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LifecycleCoroutineScopeImpl$register$1 extends v6.i implements p {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LifecycleCoroutineScopeImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LifecycleCoroutineScopeImpl$register$1(LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl, t6.c cVar) {
        super(2, cVar);
        this.this$0 = lifecycleCoroutineScopeImpl;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        LifecycleCoroutineScopeImpl$register$1 lifecycleCoroutineScopeImpl$register$1 = new LifecycleCoroutineScopeImpl$register$1(this.this$0, cVar);
        lifecycleCoroutineScopeImpl$register$1.L$0 = obj;
        return lifecycleCoroutineScopeImpl$register$1;
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((LifecycleCoroutineScopeImpl$register$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        if (this.label != 0) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        a0 a0Var = (a0) this.L$0;
        if (this.this$0.getLifecycle$lifecycle_common().getCurrentState().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
            this.this$0.getLifecycle$lifecycle_common().addObserver(this.this$0);
        } else {
            e1 e1Var = (e1) a0Var.getCoroutineContext().get(o7.x.f8327b);
            if (e1Var != null) {
                e1Var.c(null);
            }
        }
        return x.f8463a;
    }
}
