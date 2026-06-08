package j1;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ o f6558b = new o(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6559a;

    public /* synthetic */ o(int i) {
        this.f6559a = i;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f6559a) {
            case 0:
                runnable.run();
                break;
            default:
                runnable.run();
                break;
        }
    }
}
