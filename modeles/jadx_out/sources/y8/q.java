package y8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q extends d9.a {

    /* renamed from: a, reason: collision with root package name */
    public final b9.p f11881a = new b9.p();

    /* renamed from: b, reason: collision with root package name */
    public final int f11882b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11883c;

    public q(int i) {
        this.f11882b = i;
    }

    @Override // d9.a
    public final boolean b(b9.a aVar) {
        if (!this.f11883c) {
            return true;
        }
        b9.a aVar2 = (b9.a) this.f11881a.f1121a;
        if (!(aVar2 instanceof b9.o)) {
            return true;
        }
        ((b9.o) aVar2).f = false;
        return true;
    }

    @Override // d9.a
    public final b9.a d() {
        return this.f11881a;
    }

    @Override // d9.a
    public final boolean e() {
        return true;
    }

    @Override // d9.a
    public final a g(h hVar) {
        if (hVar.h) {
            if (this.f11881a.f1122b == null) {
                return null;
            }
            b9.a d10 = hVar.h().d();
            this.f11883c = (d10 instanceof b9.s) || (d10 instanceof b9.p);
            return a.a(hVar.f11836e);
        }
        int i = hVar.g;
        int i6 = this.f11882b;
        if (i >= i6) {
            return new a(-1, hVar.f11834c + i6, false);
        }
        return null;
    }
}
