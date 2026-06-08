package androidx.room;

import d7.l;
import java.util.Set;
import kotlin.jvm.internal.k;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public /* synthetic */ class InvalidationTracker$implementation$1 extends k implements l {
    public InvalidationTracker$implementation$1(Object obj) {
        super(1, obj, InvalidationTracker.class, "notifyInvalidatedObservers", "notifyInvalidatedObservers(Ljava/util/Set;)V", 0);
    }

    public final void invoke(Set<Integer> set) {
        set.getClass();
        ((InvalidationTracker) this.receiver).notifyInvalidatedObservers(set);
    }

    @Override // d7.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Set<Integer>) obj);
        return x.f8463a;
    }
}
