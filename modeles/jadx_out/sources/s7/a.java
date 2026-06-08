package s7;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends CancellationException {

    /* renamed from: a, reason: collision with root package name */
    public final transient Object f9344a;

    public a(r7.i iVar) {
        super("Flow was aborted, no more elements needed");
        this.f9344a = iVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
