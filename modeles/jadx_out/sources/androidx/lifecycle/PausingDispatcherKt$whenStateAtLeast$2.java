package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import d7.p;
import o7.a0;
import o7.c0;
import o7.e1;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.jvm.kt", l = {213}, m = "invokeSuspend", v = 1)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PausingDispatcherKt$whenStateAtLeast$2 extends v6.i implements p {
    final /* synthetic */ p $block;
    final /* synthetic */ Lifecycle.State $minState;
    final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, p pVar, t6.c cVar) {
        super(2, cVar);
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = state;
        this.$block = pVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, cVar);
        pausingDispatcherKt$whenStateAtLeast$2.L$0 = obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        LifecycleController lifecycleController;
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            e1 e1Var = (e1) ((a0) this.L$0).getCoroutineContext().get(o7.x.f8327b);
            if (e1Var == null) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("when[State] methods should have a parent job");
                return null;
            }
            PausingDispatcher pausingDispatcher = new PausingDispatcher();
            LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, e1Var);
            try {
                p pVar = this.$block;
                this.L$0 = lifecycleController2;
                this.label = 1;
                obj = c0.C(pVar, pausingDispatcher, this);
                u6.a aVar = u6.a.f10762a;
                if (obj == aVar) {
                    return aVar;
                }
                lifecycleController = lifecycleController2;
            } catch (Throwable th) {
                th = th;
                lifecycleController = lifecycleController2;
                lifecycleController.finish();
                throw th;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            lifecycleController = (LifecycleController) this.L$0;
            try {
                p6.a.e(obj);
            } catch (Throwable th2) {
                th = th2;
                lifecycleController.finish();
                throw th;
            }
        }
        lifecycleController.finish();
        return obj;
    }
}
