package u8;

import com.google.android.gms.internal.measurement.z3;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import m8.x;
import m8.y;
import t4.n0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f10783a;

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f10784b;

    static {
        h hVar;
        n0 n0Var;
        n0 n0Var2;
        Class<byte[]> cls = byte[].class;
        d dVar = null;
        try {
            try {
                Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                hVar = null;
            }
        } catch (ClassNotFoundException unused2) {
            Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
        }
        n0 n0Var3 = new n0(dVar, "setUseSessionTickets", new Class[]{Boolean.TYPE});
        n0 n0Var4 = new n0(dVar, "setHostname", new Class[]{String.class});
        if (Security.getProvider("GMSCore_OpenSSL") == null) {
            try {
                Class.forName("android.net.Network");
            } catch (ClassNotFoundException unused3) {
                n0Var = null;
                n0Var2 = null;
            }
        }
        n0Var = new n0(cls, "getAlpnSelectedProtocol", new Class[0]);
        n0Var2 = new n0(dVar, "setAlpnProtocols", new Class[]{byte[].class});
        hVar = new d(n0Var3, n0Var4, n0Var, n0Var2);
        if (hVar == null) {
            if (!("conscrypt".equals(System.getProperty("okhttp.platform")) ? true : "Conscrypt".equals(Security.getProviders()[0].getName())) || (hVar = e.m()) == null) {
                try {
                    hVar = new f(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", null));
                } catch (NoSuchMethodException unused4) {
                    hVar = null;
                }
                if (hVar == null) {
                    try {
                        Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                        dVar = new d(cls2.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider")), cls2.getMethod("get", SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
                    } catch (ClassNotFoundException | NoSuchMethodException unused5) {
                    }
                    hVar = dVar != null ? dVar : new h();
                }
            }
        }
        f10783a = hVar;
        f10784b = Logger.getLogger(x.class.getName());
    }

    public static ArrayList b(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            y yVar = (y) list.get(i);
            if (yVar != y.HTTP_1_0) {
                arrayList.add(yVar.f7835a);
            }
        }
        return arrayList;
    }

    public z3 c(X509TrustManager x509TrustManager) {
        return new v8.a(d(x509TrustManager));
    }

    public v8.d d(X509TrustManager x509TrustManager) {
        return new v8.b(x509TrustManager.getAcceptedIssuers());
    }

    public void f(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        socket.connect(inetSocketAddress, i);
    }

    public SSLContext g() {
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException("No TLS provider", e10);
        }
    }

    public String h(SSLSocket sSLSocket) {
        return null;
    }

    public Object i() {
        if (f10784b.isLoggable(Level.FINE)) {
            return new Throwable("response.body().close()");
        }
        return null;
    }

    public boolean j(String str) {
        return true;
    }

    public void k(int i, String str, Throwable th) {
        f10784b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void l(String str, Object obj) {
        if (obj == null) {
            str = str.concat(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
        }
        k(5, str, (Throwable) obj);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void e(SSLSocket sSLSocket, String str, List list) {
    }
}
