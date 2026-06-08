package t7;

import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c implements a0 {

    /* renamed from: a, reason: collision with root package name */
    public final t6.h f10322a;

    public c(t6.h hVar) {
        this.f10322a = hVar;
    }

    @Override // o7.a0
    public final t6.h getCoroutineContext() {
        return this.f10322a;
    }

    public final String toString() {
        return "CoroutineScope(coroutineContext=" + this.f10322a + ')';
    }
}
