package u8;

import android.os.Build;
import android.util.Log;
import com.google.android.gms.internal.measurement.z3;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import m8.y;
import t4.n0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10775c = 1;

    /* renamed from: d, reason: collision with root package name */
    public final Object f10776d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f10777e;
    public final Object f;
    public final Object g;
    public final Object h;

    public d(n0 n0Var, n0 n0Var2, n0 n0Var3, n0 n0Var4) {
        Method method;
        Method method2;
        Method method3 = null;
        try {
            Class<?> cls = Class.forName("dalvik.system.CloseGuard");
            Method method4 = cls.getMethod("get", null);
            method = cls.getMethod("open", String.class);
            method2 = cls.getMethod("warnIfOpen", null);
            method3 = method4;
        } catch (Exception unused) {
            method = null;
            method2 = null;
        }
        this.h = new c(method3, method, method2);
        this.f10776d = n0Var;
        this.f10777e = n0Var2;
        this.f = n0Var3;
        this.g = n0Var4;
    }

    public static boolean m(String str, Class cls, Object obj) {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            try {
                return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", null).invoke(obj, null)).booleanValue();
            } catch (NoSuchMethodException unused2) {
                return true;
            }
        }
    }

    @Override // u8.h
    public void a(SSLSocket sSLSocket) {
        switch (this.f10775c) {
            case 1:
                try {
                    ((Method) this.f).invoke(null, sSLSocket);
                    return;
                } catch (IllegalAccessException | InvocationTargetException e10) {
                    throw n8.c.a("unable to remove alpn", e10);
                }
            default:
                return;
        }
    }

    @Override // u8.h
    public z3 c(X509TrustManager x509TrustManager) {
        switch (this.f10775c) {
            case 0:
                try {
                    Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
                    break;
                } catch (Exception unused) {
                    return super.c(x509TrustManager);
                }
        }
        return super.c(x509TrustManager);
    }

    @Override // u8.h
    public v8.d d(X509TrustManager x509TrustManager) {
        switch (this.f10775c) {
            case 0:
                try {
                    Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
                    declaredMethod.setAccessible(true);
                    return new b(x509TrustManager, declaredMethod);
                } catch (NoSuchMethodException unused) {
                    return new v8.b(x509TrustManager.getAcceptedIssuers());
                }
            default:
                return super.d(x509TrustManager);
        }
    }

    @Override // u8.h
    public final void e(SSLSocket sSLSocket, String str, List list) {
        int i = this.f10775c;
        Object obj = this.f10776d;
        Object obj2 = this.g;
        switch (i) {
            case 0:
                n0 n0Var = (n0) obj2;
                if (str != null) {
                    ((n0) obj).d(sSLSocket, Boolean.TRUE);
                    ((n0) this.f10777e).d(sSLSocket, str);
                }
                if (n0Var == null || n0Var.b(sSLSocket.getClass()) == null) {
                    return;
                }
                w8.h hVar = new w8.h();
                int size = list.size();
                for (int i6 = 0; i6 < size; i6++) {
                    y yVar = (y) list.get(i6);
                    if (yVar != y.HTTP_1_0) {
                        hVar.A(yVar.f7835a.length());
                        hVar.G(yVar.f7835a);
                    }
                }
                try {
                    n0Var.c(sSLSocket, hVar.i(hVar.f10961b));
                    return;
                } catch (InvocationTargetException e10) {
                    Throwable targetException = e10.getTargetException();
                    if (targetException instanceof RuntimeException) {
                        throw ((RuntimeException) targetException);
                    }
                    AssertionError assertionError = new AssertionError("Unexpected exception");
                    assertionError.initCause(targetException);
                    throw assertionError;
                }
            default:
                try {
                    ((Method) obj).invoke(null, sSLSocket, Proxy.newProxyInstance(h.class.getClassLoader(), new Class[]{(Class) obj2, (Class) this.h}, new g(h.b(list))));
                    return;
                } catch (IllegalAccessException | InvocationTargetException e11) {
                    throw n8.c.a("unable to set alpn", e11);
                }
        }
    }

    @Override // u8.h
    public void f(Socket socket, InetSocketAddress inetSocketAddress, int i) {
        switch (this.f10775c) {
            case 0:
                try {
                    socket.connect(inetSocketAddress, i);
                    return;
                } catch (AssertionError e10) {
                    if (!n8.c.n(e10)) {
                        throw e10;
                    }
                    throw new IOException(e10);
                } catch (ClassCastException e11) {
                    if (Build.VERSION.SDK_INT != 26) {
                        throw e11;
                    }
                    IOException iOException = new IOException("Exception in connect");
                    iOException.initCause(e11);
                    throw iOException;
                } catch (SecurityException e12) {
                    IOException iOException2 = new IOException("Exception in connect");
                    iOException2.initCause(e12);
                    throw iOException2;
                }
            default:
                super.f(socket, inetSocketAddress, i);
                return;
        }
    }

    @Override // u8.h
    public final String h(SSLSocket sSLSocket) {
        switch (this.f10775c) {
            case 0:
                n0 n0Var = (n0) this.f;
                if (n0Var == null || n0Var.b(sSLSocket.getClass()) == null) {
                    return null;
                }
                try {
                    byte[] bArr = (byte[]) n0Var.c(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, n8.c.f8117d);
                    }
                    return null;
                } catch (InvocationTargetException e10) {
                    Throwable targetException = e10.getTargetException();
                    if (targetException instanceof RuntimeException) {
                        throw ((RuntimeException) targetException);
                    }
                    AssertionError assertionError = new AssertionError("Unexpected exception");
                    assertionError.initCause(targetException);
                    throw assertionError;
                }
            default:
                try {
                    g gVar = (g) Proxy.getInvocationHandler(((Method) this.f10777e).invoke(null, sSLSocket));
                    boolean z9 = gVar.f10781b;
                    if (!z9 && gVar.f10782c == null) {
                        h.f10783a.k(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                        return null;
                    }
                    if (z9) {
                        return null;
                    }
                    return gVar.f10782c;
                } catch (IllegalAccessException e11) {
                    e = e11;
                    throw n8.c.a("unable to get selected protocol", e);
                } catch (InvocationTargetException e12) {
                    e = e12;
                    throw n8.c.a("unable to get selected protocol", e);
                }
        }
    }

    @Override // u8.h
    public Object i() {
        switch (this.f10775c) {
            case 0:
                c cVar = (c) this.h;
                Method method = cVar.f10772a;
                if (method == null) {
                    return null;
                }
                try {
                    Object invoke = method.invoke(null, null);
                    cVar.f10773b.invoke(invoke, "response.body().close()");
                    return invoke;
                } catch (Exception unused) {
                    return null;
                }
            default:
                return super.i();
        }
    }

    @Override // u8.h
    public boolean j(String str) {
        switch (this.f10775c) {
            case 0:
                try {
                    Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
                    return m(str, cls, cls.getMethod("getInstance", null).invoke(null, null));
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    return true;
                } catch (IllegalAccessException e10) {
                    e = e10;
                    throw n8.c.a("unable to determine cleartext support", e);
                } catch (IllegalArgumentException e11) {
                    e = e11;
                    throw n8.c.a("unable to determine cleartext support", e);
                } catch (InvocationTargetException e12) {
                    e = e12;
                    throw n8.c.a("unable to determine cleartext support", e);
                }
            default:
                return super.j(str);
        }
    }

    @Override // u8.h
    public void k(int i, String str, Throwable th) {
        int min;
        switch (this.f10775c) {
            case 0:
                int i6 = i != 5 ? 3 : 5;
                if (th != null) {
                    str = str + '\n' + Log.getStackTraceString(th);
                }
                int length = str.length();
                int i10 = 0;
                while (i10 < length) {
                    int indexOf = str.indexOf(10, i10);
                    if (indexOf == -1) {
                        indexOf = length;
                    }
                    while (true) {
                        min = Math.min(indexOf, i10 + 4000);
                        Log.println(i6, "OkHttp", str.substring(i10, min));
                        if (min >= indexOf) {
                            break;
                        } else {
                            i10 = min;
                        }
                    }
                    i10 = min + 1;
                }
                break;
            default:
                super.k(i, str, th);
                break;
        }
    }

    @Override // u8.h
    public void l(String str, Object obj) {
        switch (this.f10775c) {
            case 0:
                c cVar = (c) this.h;
                cVar.getClass();
                if (obj != null) {
                    try {
                        cVar.f10774c.invoke(obj, null);
                        break;
                    } catch (Exception unused) {
                    }
                }
                k(5, str, null);
                break;
            default:
                super.l(str, obj);
                break;
        }
    }

    public d(Method method, Method method2, Method method3, Class cls, Class cls2) {
        this.f10776d = method;
        this.f10777e = method2;
        this.f = method3;
        this.g = cls;
        this.h = cls2;
    }
}
