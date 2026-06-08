package androidx.concurrent.futures;

import java.util.concurrent.ExecutionException;
import m1.b;
import o7.l;
import p6.d;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ListenableFutureKt {
    public static final <T> Object await(b bVar, c cVar) {
        try {
            if (bVar.isDone()) {
                return AbstractResolvableFuture.getUninterruptibly(bVar);
            }
            l lVar = new l(1, d0.b.I(cVar));
            bVar.addListener(new ToContinuation(bVar, lVar), DirectExecutor.INSTANCE);
            lVar.u(new ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1(bVar));
            return lVar.r();
        } catch (ExecutionException e10) {
            throw nonNullCause(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable nonNullCause(ExecutionException executionException) {
        Throwable cause = executionException.getCause();
        if (cause != null) {
            return cause;
        }
        d dVar = new d();
        kotlin.jvm.internal.l.e(dVar, kotlin.jvm.internal.l.class.getName());
        throw dVar;
    }
}
