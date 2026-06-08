package androidx.concurrent.futures;

import d7.l;
import kotlin.jvm.internal.m;
import m1.b;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1 extends m implements l {
    final /* synthetic */ b $this_await$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListenableFutureKt$await$$inlined$suspendCancellableCoroutine$lambda$1(b bVar) {
        super(1);
        this.$this_await$inlined = bVar;
    }

    @Override // d7.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return x.f8463a;
    }

    public final void invoke(Throwable th) {
        this.$this_await$inlined.cancel(false);
    }
}
