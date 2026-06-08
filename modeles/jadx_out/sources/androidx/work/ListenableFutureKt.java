package androidx.work;

import a2.s;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import d7.p;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import o7.b0;
import o7.c0;
import o7.e1;
import o7.x;
import t6.h;
import t6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ListenableFutureKt {
    public static final <V> m1.b executeAsync(Executor executor, String str, d7.a aVar) {
        executor.getClass();
        str.getClass();
        aVar.getClass();
        m1.b future = CallbackToFutureAdapter.getFuture(new androidx.transition.a(executor, str, aVar, 1));
        future.getClass();
        return future;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object executeAsync$lambda$4(Executor executor, String str, d7.a aVar, CallbackToFutureAdapter.Completer completer) {
        completer.getClass();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        completer.addCancellationListener(new a(atomicBoolean, 0), DirectExecutor.INSTANCE);
        executor.execute(new b(atomicBoolean, completer, aVar, 0));
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeAsync$lambda$4$lambda$3(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, d7.a aVar) {
        if (atomicBoolean.get()) {
            return;
        }
        try {
            completer.set(aVar.invoke());
        } catch (Throwable th) {
            completer.setException(th);
        }
    }

    public static final <T> m1.b launchFuture(h hVar, b0 b0Var, p pVar) {
        hVar.getClass();
        b0Var.getClass();
        pVar.getClass();
        m1.b future = CallbackToFutureAdapter.getFuture(new androidx.transition.a(hVar, b0Var, pVar, 2));
        future.getClass();
        return future;
    }

    public static /* synthetic */ m1.b launchFuture$default(h hVar, b0 b0Var, p pVar, int i, Object obj) {
        if ((i & 1) != 0) {
            hVar = i.f10314a;
        }
        if ((i & 2) != 0) {
            b0Var = b0.f8233a;
        }
        return launchFuture(hVar, b0Var, pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object launchFuture$lambda$1(h hVar, b0 b0Var, p pVar, CallbackToFutureAdapter.Completer completer) {
        completer.getClass();
        completer.addCancellationListener(new s((e1) hVar.get(x.f8327b), 4), DirectExecutor.INSTANCE);
        return c0.s(c0.b(hVar), null, b0Var, new ListenableFutureKt$launchFuture$1$2(pVar, completer, null), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchFuture$lambda$1$lambda$0(e1 e1Var) {
        if (e1Var != null) {
            e1Var.c(null);
        }
    }
}
