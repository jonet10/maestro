package androidx.lifecycle;

import d7.p;
import o7.a0;
import o7.c0;
import o7.e1;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.lifecycle.BlockRunner$cancel$1", f = "CoroutineLiveData.kt", l = {182}, m = "invokeSuspend", v = 1)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class BlockRunner$cancel$1 extends v6.i implements p {
    int label;
    final /* synthetic */ BlockRunner<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockRunner$cancel$1(BlockRunner<T> blockRunner, t6.c cVar) {
        super(2, cVar);
        this.this$0 = blockRunner;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new BlockRunner$cancel$1(this.this$0, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((BlockRunner$cancel$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        long j;
        CoroutineLiveData coroutineLiveData;
        e1 e1Var;
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            j = ((BlockRunner) this.this$0).timeoutInMs;
            this.label = 1;
            Object j6 = c0.j(j, this);
            u6.a aVar = u6.a.f10762a;
            if (j6 == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        coroutineLiveData = ((BlockRunner) this.this$0).liveData;
        if (!coroutineLiveData.hasActiveObservers()) {
            e1Var = ((BlockRunner) this.this$0).runningJob;
            if (e1Var != null) {
                e1Var.c(null);
            }
            ((BlockRunner) this.this$0).runningJob = null;
        }
        return x.f8463a;
    }
}
