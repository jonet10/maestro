package m8;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final a f7718a;

    /* renamed from: b, reason: collision with root package name */
    public final Proxy f7719b;

    /* renamed from: c, reason: collision with root package name */
    public final InetSocketAddress f7720c;

    public f0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            com.google.gson.internal.a.i("address == null");
            throw null;
        }
        if (inetSocketAddress == null) {
            com.google.gson.internal.a.i("inetSocketAddress == null");
            throw null;
        }
        this.f7718a = aVar;
        this.f7719b = proxy;
        this.f7720c = inetSocketAddress;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return f0Var.f7718a.equals(this.f7718a) && f0Var.f7719b.equals(this.f7719b) && f0Var.f7720c.equals(this.f7720c);
    }

    public final int hashCode() {
        return this.f7720c.hashCode() + ((this.f7719b.hashCode() + ((this.f7718a.hashCode() + 527) * 31)) * 31);
    }

    public final String toString() {
        return "Route{" + this.f7720c + "}";
    }
}
