package androidx.lifecycle;

import d7.p;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.lifecycle.BlockRunner$maybeRun$1", f = "CoroutineLiveData.kt", l = {170}, m = "invokeSuspend", v = 1)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class BlockRunner$maybeRun$1 extends v6.i implements p {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BlockRunner<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockRunner$maybeRun$1(BlockRunner<T> blockRunner, t6.c cVar) {
        super(2, cVar);
        this.this$0 = blockRunner;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        BlockRunner$maybeRun$1 blockRunner$maybeRun$1 = new BlockRunner$maybeRun$1(this.this$0, cVar);
        blockRunner$maybeRun$1.L$0 = obj;
        return blockRunner$maybeRun$1;
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((BlockRunner$maybeRun$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        CoroutineLiveData coroutineLiveData;
        p pVar;
        d7.a aVar;
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            a0 a0Var = (a0) this.L$0;
            coroutineLiveData = ((BlockRunner) this.this$0).liveData;
            LiveDataScopeImpl liveDataScopeImpl = new LiveDataScopeImpl(coroutineLiveData, a0Var.getCoroutineContext());
            pVar = ((BlockRunner) this.this$0).block;
            this.label = 1;
            Object invoke = pVar.invoke(liveDataScopeImpl, this);
            u6.a aVar2 = u6.a.f10762a;
            if (invoke == aVar2) {
                return aVar2;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        aVar = ((BlockRunner) this.this$0).onDone;
        aVar.invoke();
        return x.f8463a;
    }
}
