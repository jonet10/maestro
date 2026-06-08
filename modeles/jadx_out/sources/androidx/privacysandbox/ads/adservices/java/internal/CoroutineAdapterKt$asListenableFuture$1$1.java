package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import d7.l;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.m;
import o7.f0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CoroutineAdapterKt$asListenableFuture$1$1 extends m implements l {
    final /* synthetic */ CallbackToFutureAdapter.Completer<T> $completer;
    final /* synthetic */ f0 $this_asListenableFuture;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineAdapterKt$asListenableFuture$1$1(CallbackToFutureAdapter.Completer<T> completer, f0 f0Var) {
        super(1);
        this.$completer = completer;
        this.$this_asListenableFuture = f0Var;
    }

    public final void invoke(Throwable th) {
        if (th == null) {
            this.$completer.set(this.$this_asListenableFuture.f());
            return;
        }
        boolean z9 = th instanceof CancellationException;
        CallbackToFutureAdapter.Completer<T> completer = this.$completer;
        if (z9) {
            completer.setCancelled();
        } else {
            completer.setException(th);
        }
    }

    @Override // d7.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f8463a;
    }
}
