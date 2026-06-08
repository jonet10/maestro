package androidx.room;

import d7.p;
import java.util.concurrent.Callable;
import o7.a0;
import o7.j;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.CoroutinesRoom$Companion$execute$4$job$1", f = "CoroutinesRoom.android.kt", l = {}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CoroutinesRoom$Companion$execute$4$job$1 extends i implements p {
    final /* synthetic */ Callable<R> $callable;
    final /* synthetic */ j $continuation;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutinesRoom$Companion$execute$4$job$1(Callable<R> callable, j jVar, t6.c cVar) {
        super(2, cVar);
        this.$callable = callable;
        this.$continuation = jVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new CoroutinesRoom$Companion$execute$4$job$1(this.$callable, this.$continuation, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((CoroutinesRoom$Companion$execute$4$job$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        if (this.label != 0) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        try {
            this.$continuation.resumeWith(this.$callable.call());
        } catch (Throwable th) {
            this.$continuation.resumeWith(new p6.j(th));
        }
        return x.f8463a;
    }
}
