package androidx.room;

import d7.p;
import java.util.concurrent.Callable;
import o7.a0;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.CoroutinesRoom$Companion$execute$2", f = "CoroutinesRoom.android.kt", l = {}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CoroutinesRoom$Companion$execute$2 extends i implements p {
    final /* synthetic */ Callable<R> $callable;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$execute$2(Callable<R> callable, t6.c cVar) {
        super(2, cVar);
        this.$callable = callable;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new CoroutinesRoom$Companion$execute$2(this.$callable, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((CoroutinesRoom$Companion$execute$2) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        if (this.label == 0) {
            p6.a.e(obj);
            return this.$callable.call();
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
        return null;
    }
}
