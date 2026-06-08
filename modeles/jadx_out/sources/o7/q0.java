package o7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q0 implements b1 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f8299a;

    public q0(boolean z9) {
        this.f8299a = z9;
    }

    @Override // o7.b1
    public final boolean b() {
        return this.f8299a;
    }

    @Override // o7.b1
    public final o1 c() {
        return null;
    }

    public final String toString() {
        return a4.x.m(new StringBuilder("Empty{"), this.f8299a ? "Active" : "New", '}');
    }
}
