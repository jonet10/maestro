package androidx.work;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f532a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f533b;

    public /* synthetic */ a(AtomicBoolean atomicBoolean, int i) {
        this.f532a = i;
        this.f533b = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f532a) {
            case 0:
                this.f533b.set(true);
                break;
            default:
                this.f533b.set(true);
                break;
        }
    }
}
