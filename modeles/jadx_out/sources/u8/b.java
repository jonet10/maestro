package u8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b implements v8.d {

    /* renamed from: a, reason: collision with root package name */
    public final X509TrustManager f10770a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f10771b;

    public b(X509TrustManager x509TrustManager, Method method) {
        this.f10771b = method;
        this.f10770a = x509TrustManager;
    }

    @Override // v8.d
    public final X509Certificate a(X509Certificate x509Certificate) {
        try {
            TrustAnchor trustAnchor = (TrustAnchor) this.f10771b.invoke(this.f10770a, x509Certificate);
            if (trustAnchor != null) {
                return trustAnchor.getTrustedCert();
            }
            return null;
        } catch (IllegalAccessException e10) {
            throw n8.c.a("unable to get issues and signature", e10);
        } catch (InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f10770a.equals(bVar.f10770a) && this.f10771b.equals(bVar.f10771b);
    }

    public final int hashCode() {
        return (this.f10771b.hashCode() * 31) + this.f10770a.hashCode();
    }
}
