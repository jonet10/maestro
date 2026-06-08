package androidx.room;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.ObservedTableVersions", f = "InvalidationTracker.kt", l = {TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE}, m = "collect")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ObservedTableVersions$collect$1 extends v6.c {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObservedTableVersions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservedTableVersions$collect$1(ObservedTableVersions observedTableVersions, t6.c cVar) {
        super(cVar);
        this.this$0 = observedTableVersions;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.collect(null, this);
    }
}
