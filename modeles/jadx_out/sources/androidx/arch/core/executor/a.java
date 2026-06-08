package androidx.arch.core.executor;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f312a;

    public /* synthetic */ a(int i) {
        this.f312a = i;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f312a) {
            case 0:
                ArchTaskExecutor.lambda$static$0(runnable);
                break;
            case 1:
                ArchTaskExecutor.lambda$static$1(runnable);
                break;
            default:
                runnable.run();
                break;
        }
    }
}
