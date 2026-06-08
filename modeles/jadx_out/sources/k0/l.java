package k0;

import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l implements d, b, c {

    /* renamed from: b, reason: collision with root package name */
    public static l f6905b;

    /* renamed from: l, reason: collision with root package name */
    public static final m f6906l = new m(0, 0, 0, false, false);

    /* renamed from: a, reason: collision with root package name */
    public Object f6907a;

    public l(e eVar) {
        Objects.requireNonNull(eVar);
        this.f6907a = eVar;
    }

    public static synchronized l b() {
        l lVar;
        synchronized (l.class) {
            try {
                if (f6905b == null) {
                    f6905b = new l();
                }
                lVar = f6905b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    @Override // k0.c
    public void a(h0.b bVar) {
        ((i0.f) this.f6907a).a(bVar);
    }

    @Override // k0.b
    public void c(int i) {
        ((i0.e) this.f6907a).c(i);
    }

    @Override // k0.b
    public void d() {
        ((i0.e) this.f6907a).d();
    }

    @Override // k0.d
    public void g(h0.b bVar) {
        boolean z9 = bVar.f5395b == 0;
        e eVar = (e) this.f6907a;
        if (z9) {
            eVar.h(null, eVar.s());
            return;
        }
        c cVar = eVar.f6853y;
        if (cVar != null) {
            cVar.a(bVar);
        }
    }

    public /* synthetic */ l(Object obj) {
        this.f6907a = obj;
    }
}
