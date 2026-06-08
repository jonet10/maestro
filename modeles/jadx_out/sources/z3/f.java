package z3;

import android.content.Context;
import android.webkit.WebView;
import c4.wd;
import java.util.Collection;
import java.util.List;
import q6.l;
import v3.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends WebView {

    /* renamed from: a, reason: collision with root package name */
    public final wd f11940a;

    /* renamed from: b, reason: collision with root package name */
    public final j f11941b;

    /* renamed from: l, reason: collision with root package name */
    public final g f11942l;

    /* renamed from: m, reason: collision with root package name */
    public androidx.room.b f11943m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f11944n;

    /* renamed from: o, reason: collision with root package name */
    public final v3.h f11945o;

    public f(Context context, wd wdVar) {
        super(context, null, 0);
        this.f11940a = wdVar;
        j jVar = new j();
        this.f11941b = jVar;
        this.f11942l = new g(this, jVar);
        this.f11945o = new v3.h(this);
    }

    @Override // android.webkit.WebView
    public final void destroy() {
        g gVar = this.f11942l;
        synchronized (gVar.f11948c) {
            gVar.f11949d.clear();
        }
        gVar.f11947b.removeCallbacksAndMessages(null);
        super.destroy();
    }

    public v3.e getInstance() {
        return this.f11942l;
    }

    public Collection<w3.a> getListeners() {
        List G0;
        g gVar = this.f11942l;
        synchronized (gVar.f11948c) {
            G0 = l.G0(gVar.f11949d);
        }
        return G0;
    }

    public final v3.e getYoutubePlayer$core_release() {
        return this.f11942l;
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onWindowVisibilityChanged(int i) {
        if (this.f11944n && (i == 8 || i == 4)) {
            return;
        }
        super.onWindowVisibilityChanged(i);
    }

    public final void setBackgroundPlaybackEnabled$core_release(boolean z9) {
        this.f11944n = z9;
    }
}
