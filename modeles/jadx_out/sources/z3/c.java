package z3;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.k;
import c4.wd;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends d {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f11931q = 0;

    /* renamed from: a, reason: collision with root package name */
    public final f f11932a;

    /* renamed from: b, reason: collision with root package name */
    public final y3.d f11933b;

    /* renamed from: l, reason: collision with root package name */
    public final y3.e f11934l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f11935m;

    /* renamed from: n, reason: collision with root package name */
    public d7.a f11936n;

    /* renamed from: o, reason: collision with root package name */
    public final LinkedHashSet f11937o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f11938p;

    public c(Context context, wd wdVar) {
        super(context, null, 0);
        f fVar = new f(context, wdVar);
        this.f11932a = fVar;
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        y3.d dVar = new y3.d(applicationContext);
        this.f11933b = dVar;
        y3.e eVar = new y3.e();
        this.f11934l = eVar;
        this.f11936n = new k(21);
        this.f11937o = new LinkedHashSet();
        this.f11938p = true;
        addView(fVar, new FrameLayout.LayoutParams(-1, -1));
        g gVar = fVar.f11942l;
        gVar.a(eVar);
        gVar.a(new a(this, 0));
        gVar.a(new a(this, 1));
        dVar.f11798b.add(new b(this));
    }

    public final void a(w3.a aVar, boolean z9, k9.b bVar, String str) {
        if (this.f11935m) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("This YouTubePlayerView has already been initialized.");
            return;
        }
        if (z9) {
            this.f11933b.a();
        }
        androidx.work.impl.utils.f fVar = new androidx.work.impl.utils.f(this, bVar, str, aVar, 1);
        this.f11936n = fVar;
        if (z9) {
            return;
        }
        fVar.invoke();
    }

    public final boolean getCanPlay$core_release() {
        return this.f11938p;
    }

    public final f getWebViewYouTubePlayer$core_release() {
        return this.f11932a;
    }

    public final void setCustomPlayerUi(View view) {
        view.getClass();
        removeViews(1, getChildCount() - 1);
        addView(view);
    }

    public final void setYouTubePlayerReady$core_release(boolean z9) {
        this.f11935m = z9;
    }
}
