package androidx.work;

import androidx.constraintlayout.widget.ConstraintLayout;
import d7.p;
import o7.a0;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CoroutineWorker$startWork$1 extends i implements p {
    int label;
    final /* synthetic */ CoroutineWorker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker$startWork$1(CoroutineWorker coroutineWorker, t6.c cVar) {
        super(2, cVar);
        this.this$0 = coroutineWorker;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new CoroutineWorker$startWork$1(this.this$0, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((CoroutineWorker$startWork$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
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
        CoroutineWorker coroutineWorker = this.this$0;
        this.label = 1;
        Object doWork = coroutineWorker.doWork(this);
        u6.a aVar = u6.a.f10762a;
        return doWork == aVar ? aVar : doWork;
    }
}
