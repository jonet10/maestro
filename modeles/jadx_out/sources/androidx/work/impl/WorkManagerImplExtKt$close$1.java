package androidx.work.impl;

import d7.p;
import o7.a0;
import o7.e1;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.work.impl.WorkManagerImplExtKt$close$1", f = "WorkManagerImplExt.kt", l = {121}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkManagerImplExtKt$close$1 extends v6.i implements p {
    final /* synthetic */ WorkManagerImpl $this_close;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkManagerImplExtKt$close$1(WorkManagerImpl workManagerImpl, t6.c cVar) {
        super(2, cVar);
        this.$this_close = workManagerImpl;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new WorkManagerImplExtKt$close$1(this.$this_close, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((WorkManagerImplExtKt$close$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        x xVar = x.f8463a;
        if (i != 0) {
            if (i == 1) {
                p6.a.e(obj);
                return xVar;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        t6.f fVar = this.$this_close.getWorkManagerScope().getCoroutineContext().get(o7.x.f8327b);
        fVar.getClass();
        e1 e1Var = (e1) fVar;
        this.label = 1;
        e1Var.c(null);
        Object r9 = e1Var.r(this);
        u6.a aVar = u6.a.f10762a;
        if (r9 != aVar) {
            r9 = xVar;
        }
        return r9 == aVar ? aVar : xVar;
    }
}
