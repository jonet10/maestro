package q0;

import android.os.Process;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8631a;

    /* renamed from: b, reason: collision with root package name */
    public final Runnable f8632b;

    public /* synthetic */ b(Runnable runnable, int i) {
        this.f8631a = i;
        this.f8632b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f8631a) {
            case 0:
                Process.setThreadPriority(0);
                this.f8632b.run();
                break;
            case 1:
                try {
                    this.f8632b.run();
                    break;
                } catch (Exception e10) {
                    a.a.v("Executor", "Background execution failure.", e10);
                    return;
                }
            default:
                this.f8632b.run();
                break;
        }
    }

    public String toString() {
        switch (this.f8631a) {
            case 2:
                return this.f8632b.toString();
            default:
                return super.toString();
        }
    }
}
