package androidx.room;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.TriggerBasedInvalidationTracker", f = "InvalidationTracker.kt", l = {412}, m = "notifyInvalidation")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TriggerBasedInvalidationTracker$notifyInvalidation$1 extends v6.c {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TriggerBasedInvalidationTracker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TriggerBasedInvalidationTracker$notifyInvalidation$1(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, t6.c cVar) {
        super(cVar);
        this.this$0 = triggerBasedInvalidationTracker;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object notifyInvalidation;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        notifyInvalidation = this.this$0.notifyInvalidation(this);
        return notifyInvalidation;
    }
}
