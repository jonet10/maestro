package androidx.privacysandbox.ads.adservices.java.internal;

import a3.e;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import m1.b;
import o7.f0;
import o7.m1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CoroutineAdapterKt {
    public static final <T> b asListenableFuture(f0 f0Var, Object obj) {
        f0Var.getClass();
        b future = CallbackToFutureAdapter.getFuture(new e(1, f0Var, obj));
        future.getClass();
        return future;
    }

    public static /* synthetic */ b asListenableFuture$default(f0 f0Var, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return asListenableFuture(f0Var, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object asListenableFuture$lambda$0(f0 f0Var, Object obj, CallbackToFutureAdapter.Completer completer) {
        f0Var.getClass();
        completer.getClass();
        ((m1) f0Var).h(new CoroutineAdapterKt$asListenableFuture$1$1(completer, f0Var));
        return obj;
    }
}
