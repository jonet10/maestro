package androidx.room;

import kotlin.jvm.internal.k;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public /* synthetic */ class InvalidationTracker$setAutoCloser$1 extends k implements d7.a {
    public InvalidationTracker$setAutoCloser$1(Object obj) {
        super(0, obj, InvalidationTracker.class, "onAutoCloseCallback", "onAutoCloseCallback()V", 0);
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m83invoke() {
        ((InvalidationTracker) this.receiver).onAutoCloseCallback();
    }

    @Override // d7.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m83invoke();
        return x.f8463a;
    }
}
