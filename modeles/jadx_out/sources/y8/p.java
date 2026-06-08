package y8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p extends d9.a {

    /* renamed from: a, reason: collision with root package name */
    public final b9.o f11878a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11879b;

    /* renamed from: c, reason: collision with root package name */
    public int f11880c;

    public p(b9.o oVar) {
        this.f11878a = oVar;
    }

    @Override // d9.a
    public final boolean b(b9.a aVar) {
        if (!(aVar instanceof b9.p)) {
            return false;
        }
        if (this.f11879b && this.f11880c == 1) {
            this.f11878a.f = false;
            this.f11879b = false;
        }
        return true;
    }

    @Override // d9.a
    public final b9.a d() {
        return this.f11878a;
    }

    @Override // d9.a
    public final boolean e() {
        return true;
    }

    @Override // d9.a
    public final a g(h hVar) {
        if (hVar.h) {
            this.f11879b = true;
            this.f11880c = 0;
        } else if (this.f11879b) {
            this.f11880c++;
        }
        return a.a(hVar.f11833b);
    }
}
