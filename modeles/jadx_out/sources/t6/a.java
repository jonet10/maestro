package t6;

import d7.p;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a implements f {
    private final g key;

    public a(g gVar) {
        this.key = gVar;
    }

    @Override // t6.h
    public <R> R fold(R r9, p pVar) {
        return (R) a.a.x(this, r9, pVar);
    }

    @Override // t6.h
    public f get(g gVar) {
        return a.a.z(this, gVar);
    }

    @Override // t6.f
    public g getKey() {
        return this.key;
    }

    @Override // t6.h
    public h minusKey(g gVar) {
        return a.a.K(this, gVar);
    }

    @Override // t6.h
    public h plus(h hVar) {
        return a.a.L(this, hVar);
    }
}
