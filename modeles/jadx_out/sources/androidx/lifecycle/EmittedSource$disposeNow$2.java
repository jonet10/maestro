package androidx.lifecycle;

import d7.p;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.lifecycle.EmittedSource$disposeNow$2", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend", v = 1)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class EmittedSource$disposeNow$2 extends v6.i implements p {
    int label;
    final /* synthetic */ EmittedSource this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmittedSource$disposeNow$2(EmittedSource emittedSource, t6.c cVar) {
        super(2, cVar);
        this.this$0 = emittedSource;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new EmittedSource$disposeNow$2(this.this$0, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((EmittedSource$disposeNow$2) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        if (this.label != 0) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        this.this$0.removeSource();
        return x.f8463a;
    }
}
