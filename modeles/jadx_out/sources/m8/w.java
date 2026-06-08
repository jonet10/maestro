package m8;

import androidx.leanback.media.MediaPlayerGlue;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.List;
import javax.net.SocketFactory;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w {
    public g i;

    /* renamed from: m, reason: collision with root package name */
    public final b f7804m;

    /* renamed from: n, reason: collision with root package name */
    public final b f7805n;

    /* renamed from: o, reason: collision with root package name */
    public final m f7806o;

    /* renamed from: p, reason: collision with root package name */
    public final b f7807p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f7808q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f7809r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f7810s;

    /* renamed from: t, reason: collision with root package name */
    public final int f7811t;

    /* renamed from: u, reason: collision with root package name */
    public final int f7812u;
    public final int v;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f7800d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f7801e = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public final q f7797a = new q(0);

    /* renamed from: b, reason: collision with root package name */
    public final List f7798b = x.H;

    /* renamed from: c, reason: collision with root package name */
    public final List f7799c = x.I;
    public final b f = new b();
    public final ProxySelector g = ProxySelector.getDefault();
    public final b h = b.f7679b;
    public final SocketFactory j = SocketFactory.getDefault();

    /* renamed from: k, reason: collision with root package name */
    public final v8.c f7802k = v8.c.f10904a;

    /* renamed from: l, reason: collision with root package name */
    public final j f7803l = j.f7743c;

    public w() {
        b bVar = b.f7678a;
        this.f7804m = bVar;
        this.f7805n = bVar;
        this.f7806o = new m();
        this.f7807p = b.f7680c;
        this.f7808q = true;
        this.f7809r = true;
        this.f7810s = true;
        this.f7811t = MediaPlayerGlue.FAST_FORWARD_REWIND_STEP;
        this.f7812u = MediaPlayerGlue.FAST_FORWARD_REWIND_STEP;
        this.v = MediaPlayerGlue.FAST_FORWARD_REWIND_STEP;
    }
}
