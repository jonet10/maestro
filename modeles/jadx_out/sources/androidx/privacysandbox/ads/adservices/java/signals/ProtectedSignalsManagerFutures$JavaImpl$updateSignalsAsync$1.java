package androidx.privacysandbox.ads.adservices.java.signals;

import androidx.privacysandbox.ads.adservices.java.signals.ProtectedSignalsManagerFutures;
import androidx.privacysandbox.ads.adservices.signals.ProtectedSignalsManager;
import androidx.privacysandbox.ads.adservices.signals.UpdateSignalsRequest;
import d7.p;
import o7.a0;
import p6.a;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.privacysandbox.ads.adservices.java.signals.ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1", f = "ProtectedSignalsManagerFutures.kt", l = {111}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1 extends i implements p {
    final /* synthetic */ UpdateSignalsRequest $request;
    int label;
    final /* synthetic */ ProtectedSignalsManagerFutures.JavaImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1(ProtectedSignalsManagerFutures.JavaImpl javaImpl, UpdateSignalsRequest updateSignalsRequest, c cVar) {
        super(2, cVar);
        this.this$0 = javaImpl;
        this.$request = updateSignalsRequest;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        return new ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1(this.this$0, this.$request, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        ProtectedSignalsManager protectedSignalsManager;
        int i = this.label;
        if (i == 0) {
            a.e(obj);
            protectedSignalsManager = this.this$0.mProtectedSignalsManager;
            protectedSignalsManager.getClass();
            UpdateSignalsRequest updateSignalsRequest = this.$request;
            this.label = 1;
            Object updateSignals = protectedSignalsManager.updateSignals(updateSignalsRequest, this);
            u6.a aVar = u6.a.f10762a;
            if (updateSignals == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            a.e(obj);
        }
        return x.f8463a;
    }
}
