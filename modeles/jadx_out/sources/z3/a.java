package z3;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends w3.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11928a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f11929b;

    public /* synthetic */ a(c cVar, int i) {
        this.f11928a = i;
        this.f11929b = cVar;
    }

    @Override // w3.a
    public void c(v3.e eVar) {
        switch (this.f11928a) {
            case 1:
                eVar.getClass();
                c cVar = this.f11929b;
                cVar.setYouTubePlayerReady$core_release(true);
                Iterator it = cVar.f11937o.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    com.google.gson.internal.a.o();
                    return;
                }
                cVar.f11937o.clear();
                g gVar = (g) eVar;
                synchronized (gVar.f11948c) {
                    gVar.f11949d.remove(this);
                }
                return;
            default:
                super.c(eVar);
                return;
        }
    }

    @Override // w3.a
    public void d(v3.e eVar, v3.d dVar) {
        switch (this.f11928a) {
            case 0:
                eVar.getClass();
                if (dVar == v3.d.f10835m) {
                    c cVar = this.f11929b;
                    if (!cVar.f11938p && !cVar.f11932a.f11944n) {
                        ((g) eVar).e();
                        break;
                    }
                }
                break;
            default:
                super.d(eVar, dVar);
                break;
        }
    }
}
