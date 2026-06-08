package androidx.work.impl;

import androidx.annotation.RestrictTo;
import androidx.work.DirectExecutor;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class WorkerWrapperKt {
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkerWrapper");
        tagWithPrefix.getClass();
        TAG = tagWithPrefix;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T> Object awaitWithin(final m1.b bVar, final ListenableWorker listenableWorker, t6.c cVar) {
        try {
            if (bVar.isDone()) {
                return getUninterruptibly(bVar);
            }
            o7.l lVar = new o7.l(1, d0.b.I(cVar));
            lVar.s();
            bVar.addListener(new ToContinuation(bVar, lVar), DirectExecutor.INSTANCE);
            lVar.u(new d7.l() { // from class: androidx.work.impl.WorkerWrapperKt$awaitWithin$2$1
                public final void invoke(Throwable th) {
                    if (th instanceof WorkerStoppedException) {
                        ListenableWorker.this.stop(((WorkerStoppedException) th).getReason());
                    }
                    bVar.cancel(false);
                }

                @Override // d7.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return x.f8463a;
                }
            });
            return lVar.r();
        } catch (ExecutionException e10) {
            throw nonNullCause(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <V> V getUninterruptibly(Future<V> future) {
        V v;
        boolean z9 = false;
        while (true) {
            try {
                v = future.get();
                break;
            } catch (InterruptedException unused) {
                z9 = true;
            } catch (Throwable th) {
                if (z9) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z9) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable nonNullCause(ExecutionException executionException) {
        Throwable cause = executionException.getCause();
        cause.getClass();
        return cause;
    }
}
