package androidx.lifecycle;

import d7.p;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {110}, m = "invokeSuspend", v = 1)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 extends v6.i implements p {
    final /* synthetic */ p $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(p pVar, t6.c cVar) {
        super(2, cVar);
        this.$block = pVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(this.$block, cVar);
        repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1;
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            a0 a0Var = (a0) this.L$0;
            p pVar = this.$block;
            this.label = 1;
            Object invoke = pVar.invoke(a0Var, this);
            u6.a aVar = u6.a.f10762a;
            if (invoke == aVar) {
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
