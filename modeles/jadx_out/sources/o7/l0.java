package o7;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l0 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final w f8282a;

    public l0(w wVar) {
        this.f8282a = wVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        w wVar = this.f8282a;
        t6.i iVar = t6.i.f10314a;
        if (wVar.isDispatchNeeded(iVar)) {
            wVar.dispatch(iVar, runnable);
        } else {
            runnable.run();
        }
    }

    public final String toString() {
        return this.f8282a.toString();
    }
}
