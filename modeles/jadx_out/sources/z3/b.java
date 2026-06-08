package z3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f11930a;

    public b(c cVar) {
        this.f11930a = cVar;
    }

    public final void a() {
        c cVar = this.f11930a;
        if (!cVar.f11935m) {
            cVar.f11936n.invoke();
            return;
        }
        y3.e eVar = cVar.f11934l;
        v3.e youtubePlayer$core_release = cVar.getWebViewYouTubePlayer$core_release().getYoutubePlayer$core_release();
        eVar.getClass();
        youtubePlayer$core_release.getClass();
        String str = eVar.f11804d;
        if (str == null) {
            return;
        }
        boolean z9 = eVar.f11802b;
        v3.c cVar2 = v3.c.f10827l;
        if (z9 && eVar.f11803c == cVar2) {
            boolean z10 = eVar.f11801a;
            float f = eVar.f11805e;
            if (z10) {
                ((g) youtubePlayer$core_release).d(str, f);
            } else {
                ((g) youtubePlayer$core_release).b(str, f);
            }
        } else if (!z9 && eVar.f11803c == cVar2) {
            ((g) youtubePlayer$core_release).b(str, eVar.f11805e);
        }
        eVar.f11803c = null;
    }
}
