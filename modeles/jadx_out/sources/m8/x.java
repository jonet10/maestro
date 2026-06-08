package m8;

import com.google.android.gms.internal.measurement.z3;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x implements Cloneable {
    public static final List H = n8.c.l(y.HTTP_2, y.HTTP_1_1);
    public static final List I = n8.c.l(o.f7766e, o.f);
    public final b A;
    public final boolean B;
    public final boolean C;
    public final boolean D;
    public final int E;
    public final int F;
    public final int G;

    /* renamed from: a, reason: collision with root package name */
    public final q f7813a;

    /* renamed from: b, reason: collision with root package name */
    public final List f7814b;

    /* renamed from: l, reason: collision with root package name */
    public final List f7815l;

    /* renamed from: m, reason: collision with root package name */
    public final List f7816m;

    /* renamed from: n, reason: collision with root package name */
    public final List f7817n;

    /* renamed from: o, reason: collision with root package name */
    public final b f7818o;

    /* renamed from: p, reason: collision with root package name */
    public final ProxySelector f7819p;

    /* renamed from: q, reason: collision with root package name */
    public final b f7820q;

    /* renamed from: r, reason: collision with root package name */
    public final g f7821r;

    /* renamed from: s, reason: collision with root package name */
    public final SocketFactory f7822s;

    /* renamed from: t, reason: collision with root package name */
    public final SSLSocketFactory f7823t;

    /* renamed from: u, reason: collision with root package name */
    public final z3 f7824u;
    public final v8.c v;

    /* renamed from: w, reason: collision with root package name */
    public final j f7825w;

    /* renamed from: x, reason: collision with root package name */
    public final b f7826x;

    /* renamed from: y, reason: collision with root package name */
    public final b f7827y;

    /* renamed from: z, reason: collision with root package name */
    public final m f7828z;

    static {
        b.f7682e = new b();
    }

    public x(w wVar) {
        boolean z9;
        this.f7813a = wVar.f7797a;
        this.f7814b = wVar.f7798b;
        List list = wVar.f7799c;
        this.f7815l = list;
        this.f7816m = n8.c.k(wVar.f7800d);
        this.f7817n = n8.c.k(wVar.f7801e);
        this.f7818o = wVar.f;
        this.f7819p = wVar.g;
        this.f7820q = wVar.h;
        this.f7821r = wVar.i;
        this.f7822s = wVar.j;
        Iterator it = list.iterator();
        loop0: while (true) {
            z9 = false;
            while (it.hasNext()) {
                z9 = (z9 || ((o) it.next()).f7767a) ? true : z9;
            }
        }
        if (z9) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((KeyStore) null);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers.length == 1) {
                    TrustManager trustManager = trustManagers[0];
                    if (trustManager instanceof X509TrustManager) {
                        X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                        try {
                            u8.h hVar = u8.h.f10783a;
                            SSLContext g = hVar.g();
                            g.init(null, new TrustManager[]{x509TrustManager}, null);
                            this.f7823t = g.getSocketFactory();
                            this.f7824u = hVar.c(x509TrustManager);
                        } catch (GeneralSecurityException e10) {
                            throw n8.c.a("No System TLS", e10);
                        }
                    }
                }
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            } catch (GeneralSecurityException e11) {
                throw n8.c.a("No System TLS", e11);
            }
        }
        this.f7823t = null;
        this.f7824u = null;
        this.v = wVar.f7802k;
        j jVar = wVar.f7803l;
        z3 z3Var = this.f7824u;
        this.f7825w = n8.c.i(jVar.f7745b, z3Var) ? jVar : new j(jVar.f7744a, z3Var);
        this.f7826x = wVar.f7804m;
        this.f7827y = wVar.f7805n;
        this.f7828z = wVar.f7806o;
        this.A = wVar.f7807p;
        this.B = wVar.f7808q;
        this.C = wVar.f7809r;
        this.D = wVar.f7810s;
        this.E = wVar.f7811t;
        this.F = wVar.f7812u;
        this.G = wVar.v;
        if (this.f7816m.contains(null)) {
            com.google.gson.internal.a.h(this.f7816m, "Null interceptor: ");
            throw null;
        }
        if (this.f7817n.contains(null)) {
            com.google.gson.internal.a.h(this.f7817n, "Null network interceptor: ");
            throw null;
        }
    }
}
