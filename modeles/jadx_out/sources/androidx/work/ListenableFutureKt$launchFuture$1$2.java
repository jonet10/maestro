package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import d7.p;
import java.util.concurrent.CancellationException;
import o7.a0;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.work.ListenableFutureKt$launchFuture$1$2", f = "ListenableFuture.kt", l = {42}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ListenableFutureKt$launchFuture$1$2 extends i implements p {
    final /* synthetic */ p $block;
    final /* synthetic */ CallbackToFutureAdapter.Completer<T> $completer;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListenableFutureKt$launchFuture$1$2(p pVar, CallbackToFutureAdapter.Completer<T> completer, t6.c cVar) {
        super(2, cVar);
        this.$block = pVar;
        this.$completer = completer;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        ListenableFutureKt$launchFuture$1$2 listenableFutureKt$launchFuture$1$2 = new ListenableFutureKt$launchFuture$1$2(this.$block, this.$completer, cVar);
        listenableFutureKt$launchFuture$1$2.L$0 = obj;
        return listenableFutureKt$launchFuture$1$2;
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((ListenableFutureKt$launchFuture$1$2) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        try {
            if (i == 0) {
                p6.a.e(obj);
                a0 a0Var = (a0) this.L$0;
                p pVar = this.$block;
                this.label = 1;
                obj = pVar.invoke(a0Var, this);
                u6.a aVar = u6.a.f10762a;
                if (obj == aVar) {
                    return aVar;
                }
            } else {
                if (i != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
            }
            this.$completer.set(obj);
        } catch (CancellationException unused) {
            this.$completer.setCancelled();
        } catch (Throwable th) {
            this.$completer.setException(th);
        }
        return x.f8463a;
    }
}
