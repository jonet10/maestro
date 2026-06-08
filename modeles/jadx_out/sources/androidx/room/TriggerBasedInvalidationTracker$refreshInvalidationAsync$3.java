package androidx.room;

import d7.p;
import o7.a0;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.TriggerBasedInvalidationTracker$refreshInvalidationAsync$3", f = "InvalidationTracker.kt", l = {389}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TriggerBasedInvalidationTracker$refreshInvalidationAsync$3 extends i implements p {
    final /* synthetic */ d7.a $onRefreshCompleted;
    int label;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, d7.a aVar, t6.c cVar) {
        super(2, cVar);
        this.this$0 = triggerBasedInvalidationTracker;
        this.$onRefreshCompleted = aVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(this.this$0, this.$onRefreshCompleted, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((TriggerBasedInvalidationTracker$refreshInvalidationAsync$3) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        try {
            if (i == 0) {
                p6.a.e(obj);
                TriggerBasedInvalidationTracker triggerBasedInvalidationTracker = this.this$0;
                this.label = 1;
                obj = triggerBasedInvalidationTracker.notifyInvalidation(this);
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
            this.$onRefreshCompleted.invoke();
            return x.f8463a;
        } catch (Throwable th) {
            this.$onRefreshCompleted.invoke();
            throw th;
        }
    }
}
