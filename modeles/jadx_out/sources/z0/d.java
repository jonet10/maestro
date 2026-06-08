package z0;

import b2.t1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends e {

    /* renamed from: l, reason: collision with root package name */
    public final transient int f11894l;

    /* renamed from: m, reason: collision with root package name */
    public final transient int f11895m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ e f11896n;

    public d(e eVar, int i, int i6) {
        this.f11896n = eVar;
        this.f11894l = i;
        this.f11895m = i6;
    }

    @Override // z0.a
    public final Object[] b() {
        return this.f11896n.b();
    }

    @Override // z0.a
    public final int c() {
        return this.f11896n.c() + this.f11894l;
    }

    @Override // z0.a
    public final int d() {
        return this.f11896n.c() + this.f11894l + this.f11895m;
    }

    @Override // java.util.List
    public final Object get(int i) {
        t1.T(i, this.f11895m);
        return this.f11896n.get(i + this.f11894l);
    }

    @Override // z0.e, java.util.List
    /* renamed from: h */
    public final e subList(int i, int i6) {
        t1.W(i, i6, this.f11895m);
        int i10 = this.f11894l;
        return this.f11896n.subList(i + i10, i6 + i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f11895m;
    }
}
