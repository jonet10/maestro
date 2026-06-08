package t7;

import o7.c0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class r extends o7.a implements v6.d {

    /* renamed from: m, reason: collision with root package name */
    public final t6.c f10353m;

    public r(t6.c cVar, t6.h hVar) {
        super(hVar, true);
        this.f10353m = cVar;
    }

    @Override // o7.m1
    public final boolean P() {
        return true;
    }

    @Override // v6.d
    public final v6.d getCallerFrame() {
        t6.c cVar = this.f10353m;
        if (cVar instanceof v6.d) {
            return (v6.d) cVar;
        }
        return null;
    }

    @Override // o7.m1
    public void t(Object obj) {
        a.h(c0.u(obj), d0.b.I(this.f10353m));
    }

    @Override // o7.m1
    public void v(Object obj) {
        this.f10353m.resumeWith(c0.u(obj));
    }
}
