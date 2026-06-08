package p8;

import a2.q;
import g5.f;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import m8.f0;
import m8.u;
import m8.z;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final m8.a f8480a;

    /* renamed from: b, reason: collision with root package name */
    public final f f8481b;

    /* renamed from: c, reason: collision with root package name */
    public final m8.b f8482c;

    /* renamed from: d, reason: collision with root package name */
    public final List f8483d;

    /* renamed from: e, reason: collision with root package name */
    public int f8484e;
    public List f;
    public final ArrayList g;

    public c(m8.a aVar, f fVar, z zVar, m8.b bVar) {
        List list = Collections.EMPTY_LIST;
        this.f8483d = list;
        this.f = list;
        this.g = new ArrayList();
        this.f8480a = aVar;
        this.f8481b = fVar;
        this.f8482c = bVar;
        List<Proxy> select = aVar.g.select(aVar.f7668a.l());
        this.f8483d = (select == null || select.isEmpty()) ? n8.c.l(Proxy.NO_PROXY) : n8.c.k(select);
        this.f8484e = 0;
    }

    public final void a(f0 f0Var, IOException iOException) {
        m8.a aVar;
        ProxySelector proxySelector;
        if (f0Var.f7719b.type() != Proxy.Type.DIRECT && (proxySelector = (aVar = this.f8480a).g) != null) {
            proxySelector.connectFailed(aVar.f7668a.l(), f0Var.f7719b.address(), iOException);
        }
        f fVar = this.f8481b;
        synchronized (fVar) {
            ((LinkedHashSet) fVar.f5309b).add(f0Var);
        }
    }

    public final q b() {
        String str;
        int i;
        boolean contains;
        if (this.f8484e >= this.f8483d.size() && this.g.isEmpty()) {
            com.google.gson.internal.a.l();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (this.f8484e < this.f8483d.size()) {
            m8.a aVar = this.f8480a;
            if (this.f8484e >= this.f8483d.size()) {
                throw new SocketException("No route to " + aVar.f7668a.f7795d + "; exhausted proxy configurations: " + this.f8483d);
            }
            List list = this.f8483d;
            int i6 = this.f8484e;
            this.f8484e = i6 + 1;
            Proxy proxy = (Proxy) list.get(i6);
            m8.b bVar = this.f8482c;
            this.f = new ArrayList();
            if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                u uVar = aVar.f7668a;
                str = uVar.f7795d;
                i = uVar.f7796e;
            } else {
                SocketAddress address = proxy.address();
                if (!(address instanceof InetSocketAddress)) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.r(address.getClass(), "Proxy.address() is not an InetSocketAddress: ");
                    return null;
                }
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                InetAddress address2 = inetSocketAddress.getAddress();
                str = address2 == null ? inetSocketAddress.getHostName() : address2.getHostAddress();
                i = inetSocketAddress.getPort();
            }
            if (i < 1 || i > 65535) {
                throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
            }
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f.add(InetSocketAddress.createUnresolved(str, i));
            } else {
                bVar.getClass();
                aVar.f7669b.getClass();
                if (str == null) {
                    throw new UnknownHostException("hostname == null");
                }
                try {
                    List asList = Arrays.asList(InetAddress.getAllByName(str));
                    if (asList.isEmpty()) {
                        throw new UnknownHostException(aVar.f7669b + " returned no addresses for " + str);
                    }
                    int size = asList.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        this.f.add(new InetSocketAddress((InetAddress) asList.get(i10), i));
                    }
                } catch (NullPointerException e10) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(str));
                    unknownHostException.initCause(e10);
                    throw unknownHostException;
                }
            }
            int size2 = this.f.size();
            for (int i11 = 0; i11 < size2; i11++) {
                f0 f0Var = new f0(this.f8480a, proxy, (InetSocketAddress) this.f.get(i11));
                f fVar = this.f8481b;
                synchronized (fVar) {
                    contains = ((LinkedHashSet) fVar.f5309b).contains(f0Var);
                }
                if (contains) {
                    this.g.add(f0Var);
                } else {
                    arrayList.add(f0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.g);
            this.g.clear();
        }
        return new q(arrayList);
    }
}
