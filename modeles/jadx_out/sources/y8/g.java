package y8;

import b9.w;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends d9.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11828a;

    /* renamed from: b, reason: collision with root package name */
    public final b9.a f11829b;

    public g(int i) {
        this.f11828a = i;
        switch (i) {
            case 1:
                this.f11829b = new w();
                break;
            default:
                this.f11829b = new b9.i(1);
                break;
        }
    }

    @Override // d9.a
    public void a(CharSequence charSequence) {
        int i = this.f11828a;
    }

    @Override // d9.a
    public boolean b(b9.a aVar) {
        switch (this.f11828a) {
            case 0:
                return true;
            default:
                return super.b(aVar);
        }
    }

    @Override // d9.a
    public final b9.a d() {
        switch (this.f11828a) {
            case 0:
                return (b9.i) this.f11829b;
            default:
                return (w) this.f11829b;
        }
    }

    @Override // d9.a
    public boolean e() {
        switch (this.f11828a) {
            case 0:
                return true;
            default:
                return super.e();
        }
    }

    @Override // d9.a
    public final a g(h hVar) {
        switch (this.f11828a) {
            case 0:
                return a.a(hVar.f11833b);
            default:
                return null;
        }
    }

    private final void h(CharSequence charSequence) {
    }
}
