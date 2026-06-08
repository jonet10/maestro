package o7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x1 extends t7.r implements Runnable {

    /* renamed from: n, reason: collision with root package name */
    public final long f8328n;

    public x1(long j, t6.c cVar) {
        super(cVar, cVar.getContext());
        this.f8328n = j;
    }

    @Override // o7.m1
    public final String S() {
        return super.S() + "(timeMillis=" + this.f8328n + ')';
    }

    @Override // java.lang.Runnable
    public final void run() {
        c0.n(this.f8229l);
        x(new w1("Timed out waiting for " + this.f8328n + " ms", this));
    }
}
