package g0;

import java.util.concurrent.Executor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class h implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h f5080b = new h(0);

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ h f5081l = new h(1);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5082a;

    public /* synthetic */ h(int i) {
        this.f5082a = i;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f5082a) {
            case 0:
                runnable.run();
                break;
            default:
                runnable.run();
                break;
        }
    }
}
