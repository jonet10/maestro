package m8;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final g0 f7782a;

    /* renamed from: b, reason: collision with root package name */
    public final l f7783b;

    /* renamed from: c, reason: collision with root package name */
    public final List f7784c;

    /* renamed from: d, reason: collision with root package name */
    public final List f7785d;

    public r(g0 g0Var, l lVar, List list, List list2) {
        this.f7782a = g0Var;
        this.f7783b = lVar;
        this.f7784c = list;
        this.f7785d = list2;
    }

    public static r a(SSLSession sSLSession) {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("cipherSuite == null");
            return null;
        }
        l a8 = l.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("tlsVersion == null");
            return null;
        }
        g0 a10 = g0.a(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            certificateArr = null;
        }
        List l10 = certificateArr != null ? n8.c.l(certificateArr) : Collections.EMPTY_LIST;
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new r(a10, a8, l10, localCertificates != null ? n8.c.l(localCertificates) : Collections.EMPTY_LIST);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f7782a.equals(rVar.f7782a) && this.f7783b.equals(rVar.f7783b) && this.f7784c.equals(rVar.f7784c) && this.f7785d.equals(rVar.f7785d);
    }

    public final int hashCode() {
        return this.f7785d.hashCode() + ((this.f7784c.hashCode() + ((this.f7783b.hashCode() + ((this.f7782a.hashCode() + 527) * 31)) * 31)) * 31);
    }
}
