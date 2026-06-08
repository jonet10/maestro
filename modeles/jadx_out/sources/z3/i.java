package z3;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i extends w3.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11951a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ YouTubePlayerView f11952b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f11953c;

    public i(String str, YouTubePlayerView youTubePlayerView, boolean z9) {
        this.f11951a = str;
        this.f11952b = youTubePlayerView;
        this.f11953c = z9;
    }

    @Override // w3.a
    public final void c(v3.e eVar) {
        eVar.getClass();
        String str = this.f11951a;
        if (str != null) {
            if (this.f11952b.f3285b.getCanPlay$core_release() && this.f11953c) {
                ((g) eVar).d(str, 0.0f);
            } else {
                ((g) eVar).b(str, 0.0f);
            }
        }
        g gVar = (g) eVar;
        synchronized (gVar.f11948c) {
            gVar.f11949d.remove(this);
        }
    }
}
