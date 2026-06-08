package androidx.room;

import d7.p;
import o7.a0;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.InvalidationTracker$refreshVersionsSync$1", f = "InvalidationTracker.android.kt", l = {345}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class InvalidationTracker$refreshVersionsSync$1 extends i implements p {
    int label;
    final /* synthetic */ InvalidationTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidationTracker$refreshVersionsSync$1(InvalidationTracker invalidationTracker, t6.c cVar) {
        super(2, cVar);
        this.this$0 = invalidationTracker;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new InvalidationTracker$refreshVersionsSync$1(this.this$0, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((InvalidationTracker$refreshVersionsSync$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        TriggerBasedInvalidationTracker triggerBasedInvalidationTracker;
        d7.a aVar;
        d7.a aVar2;
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            triggerBasedInvalidationTracker = this.this$0.implementation;
            aVar = this.this$0.onRefreshScheduled;
            aVar2 = this.this$0.onRefreshCompleted;
            this.label = 1;
            Object refreshInvalidation$room_runtime_release = triggerBasedInvalidationTracker.refreshInvalidation$room_runtime_release(new String[0], aVar, aVar2, this);
            u6.a aVar3 = u6.a.f10762a;
            if (refreshInvalidation$room_runtime_release == aVar3) {
                return aVar3;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return x.f8463a;
    }
}
