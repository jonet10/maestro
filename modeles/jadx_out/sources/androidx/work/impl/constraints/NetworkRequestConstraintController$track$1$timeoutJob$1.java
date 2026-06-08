package androidx.work.impl.constraints;

import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import d7.p;
import o7.a0;
import o7.c0;
import p6.x;
import q7.r;
import q7.s;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.work.impl.constraints.NetworkRequestConstraintController$track$1$timeoutJob$1", f = "WorkConstraintsTracker.kt", l = {151}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class NetworkRequestConstraintController$track$1$timeoutJob$1 extends i implements p {
    final /* synthetic */ s $$this$callbackFlow;
    int label;
    final /* synthetic */ NetworkRequestConstraintController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkRequestConstraintController$track$1$timeoutJob$1(NetworkRequestConstraintController networkRequestConstraintController, s sVar, t6.c cVar) {
        super(2, cVar);
        this.this$0 = networkRequestConstraintController;
        this.$$this$callbackFlow = sVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new NetworkRequestConstraintController$track$1$timeoutJob$1(this.this$0, this.$$this$callbackFlow, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((NetworkRequestConstraintController$track$1$timeoutJob$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        long j;
        String str;
        long j6;
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            j = this.this$0.timeoutMs;
            this.label = 1;
            Object j10 = c0.j(j, this);
            u6.a aVar = u6.a.f10762a;
            if (j10 == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        Logger logger = Logger.get();
        str = WorkConstraintsTrackerKt.TAG;
        StringBuilder sb = new StringBuilder("NetworkRequestConstraintController didn't receive neither onCapabilitiesChanged/onLost callback, sending `ConstraintsNotMet` after ");
        j6 = this.this$0.timeoutMs;
        sb.append(j6);
        sb.append(" ms");
        logger.debug(str, sb.toString());
        ((r) this.$$this$callbackFlow).p(new ConstraintsState.ConstraintsNotMet(7));
        return x.f8463a;
    }
}
