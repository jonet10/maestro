package p8;

import androidx.core.location.LocationRequestCompat;
import androidx.lifecycle.l;
import e1.u0;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import m8.b0;
import m8.c0;
import m8.f0;
import m8.j;
import m8.r;
import m8.u;
import m8.y;
import r8.g;
import s8.m;
import s8.q;
import s8.w;
import u8.h;
import w8.a0;
import w8.i;
import w8.x;
import w8.z;
import y2.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends m {

    /* renamed from: b, reason: collision with root package name */
    public final m8.m f8469b;

    /* renamed from: c, reason: collision with root package name */
    public final f0 f8470c;

    /* renamed from: d, reason: collision with root package name */
    public Socket f8471d;

    /* renamed from: e, reason: collision with root package name */
    public Socket f8472e;
    public r f;
    public y g;
    public q h;
    public a0 i;
    public z j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f8473k;

    /* renamed from: l, reason: collision with root package name */
    public int f8474l;

    /* renamed from: m, reason: collision with root package name */
    public int f8475m = 1;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f8476n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public long f8477o = LocationRequestCompat.PASSIVE_INTERVAL;

    public a(m8.m mVar, f0 f0Var) {
        this.f8469b = mVar;
        this.f8470c = f0Var;
    }

    @Override // s8.m
    public final void a(q qVar) {
        synchronized (this.f8469b) {
            this.f8475m = qVar.e();
        }
    }

    @Override // s8.m
    public final void b(w wVar) {
        wVar.c(5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x007e, code lost:
    
        r10 = r9.f8470c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0084, code lost:
    
        if (r10.f7718a.h == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008e, code lost:
    
        if (r10.f7719b.type() != java.net.Proxy.Type.HTTP) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0092, code lost:
    
        if (r9.f8471d == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a1, code lost:
    
        throw new p8.b(new java.net.ProtocolException("Too many tunnel connections attempted: 21"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a4, code lost:
    
        if (r9.h == null) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a6, code lost:
    
        r10 = r9.f8469b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a8, code lost:
    
        monitor-enter(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00a9, code lost:
    
        r9.f8475m = r9.h.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00b1, code lost:
    
        monitor-exit(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b6, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(int r10, int r11, int r12, boolean r13, m8.b r14) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p8.a.c(int, int, int, boolean, m8.b):void");
    }

    public final void d(int i, int i6, m8.b bVar) {
        f0 f0Var = this.f8470c;
        Proxy proxy = f0Var.f7719b;
        InetSocketAddress inetSocketAddress = f0Var.f7720c;
        this.f8471d = (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) ? f0Var.f7718a.f7670c.createSocket() : new Socket(proxy);
        bVar.getClass();
        this.f8471d.setSoTimeout(i6);
        try {
            h.f10783a.f(this.f8471d, inetSocketAddress, i);
            try {
                Socket socket = this.f8471d;
                Logger logger = x.f11003a;
                socket.getClass();
                w8.f0 f0Var2 = new w8.f0(socket);
                InputStream inputStream = socket.getInputStream();
                inputStream.getClass();
                this.i = new a0(new w8.c(f0Var2, new w8.c(inputStream, f0Var2)));
                Socket socket2 = this.f8471d;
                socket2.getClass();
                w8.f0 f0Var3 = new w8.f0(socket2);
                OutputStream outputStream = socket2.getOutputStream();
                outputStream.getClass();
                this.j = new z(new w8.b(0, f0Var3, new w8.b(1, outputStream, f0Var3)));
            } catch (NullPointerException e10) {
                if ("throw with null exception".equals(e10.getMessage())) {
                    throw new IOException(e10);
                }
            }
        } catch (ConnectException e11) {
            ConnectException connectException = new ConnectException("Failed to connect to " + inetSocketAddress);
            connectException.initCause(e11);
            throw connectException;
        }
    }

    public final void e(int i, int i6, int i10, m8.b bVar) {
        s sVar = new s(9);
        f0 f0Var = this.f8470c;
        u uVar = f0Var.f7718a.f7668a;
        if (uVar == null) {
            com.google.gson.internal.a.i("url == null");
            return;
        }
        sVar.f11756l = uVar;
        sVar.w("Host", n8.c.j(uVar, true));
        sVar.w("Proxy-Connection", "Keep-Alive");
        sVar.w("User-Agent", "okhttp/3.10.0");
        m8.a0 n10 = sVar.n();
        u uVar2 = n10.f7673a;
        d(i, i6, bVar);
        String str = "CONNECT " + n8.c.j(uVar2, true) + " HTTP/1.1";
        a0 a0Var = this.i;
        g gVar = new g(null, null, a0Var, this.j);
        a0Var.f10933a.a().g(i6);
        this.j.f11006a.a().g(i10);
        gVar.h(n10.f7675c, str);
        gVar.b();
        b0 c9 = gVar.c(false);
        c9.f7683a = n10;
        c0 a8 = c9.a();
        int i11 = a8.f7694l;
        long a10 = q8.c.a(a8);
        if (a10 == -1) {
            a10 = 0;
        }
        r8.e g = gVar.g(a10);
        n8.c.p(g, Integer.MAX_VALUE);
        g.close();
        if (i11 == 200) {
            if (this.i.f10934b.c() && this.j.f11007b.c()) {
                return;
            }
            com.google.gson.internal.a.n("TLS tunnel buffered too many bytes!");
            return;
        }
        if (i11 != 407) {
            com.google.gson.internal.a.n(l.u(i11, "Unexpected response code for CONNECT: "));
        } else {
            f0Var.f7718a.f7671d.getClass();
            com.google.gson.internal.a.n("Failed to authenticate with proxy");
        }
    }

    public final void f(u0 u0Var, m8.b bVar) {
        int i;
        SSLSocket sSLSocket;
        if (this.f8470c.f7718a.h == null) {
            this.g = y.HTTP_1_1;
            this.f8472e = this.f8471d;
            return;
        }
        bVar.getClass();
        m8.a aVar = this.f8470c.f7718a;
        SSLSocketFactory sSLSocketFactory = aVar.h;
        u uVar = aVar.f7668a;
        SSLSocket sSLSocket2 = null;
        try {
            try {
                i = 1;
                sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(this.f8471d, uVar.f7795d, uVar.f7796e, true);
            } catch (Throwable th) {
                th = th;
            }
        } catch (AssertionError e10) {
            e = e10;
        }
        try {
            boolean z9 = u0Var.a(sSLSocket).f7768b;
            if (z9) {
                h.f10783a.e(sSLSocket, uVar.f7795d, aVar.f7672e);
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            if ("NONE".equals(session.getProtocol()) || "SSL_NULL_WITH_NULL_NULL".equals(session.getCipherSuite())) {
                throw new IOException("a valid ssl session was not established");
            }
            r a8 = r.a(session);
            List list = a8.f7784c;
            int i6 = 0;
            if (!aVar.i.verify(uVar.f7795d, session)) {
                X509Certificate x509Certificate = (X509Certificate) list.get(0);
                throw new SSLPeerUnverifiedException("Hostname " + uVar.f7795d + " not verified:\n    certificate: " + j.b(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + v8.c.a(x509Certificate));
            }
            aVar.j.a(uVar.f7795d, list);
            String h = z9 ? h.f10783a.h(sSLSocket) : null;
            this.f8472e = sSLSocket;
            Logger logger = x.f11003a;
            w8.f0 f0Var = new w8.f0(sSLSocket);
            InputStream inputStream = sSLSocket.getInputStream();
            inputStream.getClass();
            this.i = new a0(new w8.c(f0Var, new w8.c(inputStream, f0Var)));
            Socket socket = this.f8472e;
            socket.getClass();
            w8.f0 f0Var2 = new w8.f0(socket);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.getClass();
            this.j = new z(new w8.b(i6, f0Var2, new w8.b(i, outputStream, f0Var2)));
            this.f = a8;
            this.g = h != null ? y.a(h) : y.HTTP_1_1;
            h.f10783a.a(sSLSocket);
            if (this.g == y.HTTP_2) {
                this.f8472e.setSoTimeout(0);
                g8.g gVar = new g8.g();
                gVar.f5386o = m.f9418a;
                gVar.f5381a = true;
                Socket socket2 = this.f8472e;
                String str = this.f8470c.f7718a.f7668a.f7795d;
                a0 a0Var = this.i;
                z zVar = this.j;
                gVar.f5382b = socket2;
                gVar.f5383l = str;
                gVar.f5384m = a0Var;
                gVar.f5385n = zVar;
                gVar.f5386o = this;
                q qVar = new q(gVar);
                this.h = qVar;
                s8.x xVar = qVar.A;
                synchronized (xVar) {
                    try {
                        if (xVar.f9476n) {
                            throw new IOException("closed");
                        }
                        if (xVar.f9473b) {
                            Logger logger2 = s8.x.f9471p;
                            if (logger2.isLoggable(Level.FINE)) {
                                String g = s8.e.f9393a.g();
                                byte[] bArr = n8.c.f8114a;
                                Locale locale = Locale.US;
                                logger2.fine(">> CONNECTION " + g);
                            }
                            i iVar = xVar.f9472a;
                            byte[] bArr2 = s8.e.f9393a.f10971a;
                            iVar.write(Arrays.copyOf(bArr2, bArr2.length));
                            xVar.f9472a.flush();
                        }
                    } finally {
                    }
                }
                qVar.A.j(qVar.f9439w);
                if (qVar.f9439w.c() != 65535) {
                    qVar.A.r(0, r11 - 65535);
                }
                new Thread(qVar.B).start();
            }
        } catch (AssertionError e11) {
            e = e11;
            if (!n8.c.n(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                h.f10783a.a(sSLSocket2);
            }
            n8.c.d(sSLSocket2);
            throw th;
        }
    }

    public final boolean g(m8.a aVar, f0 f0Var) {
        if (this.f8476n.size() >= this.f8475m || this.f8473k) {
            return false;
        }
        m8.b bVar = m8.b.f7682e;
        f0 f0Var2 = this.f8470c;
        m8.a aVar2 = f0Var2.f7718a;
        bVar.getClass();
        boolean a8 = aVar2.a(aVar);
        u uVar = aVar.f7668a;
        if (!a8) {
            return false;
        }
        if (uVar.f7795d.equals(f0Var2.f7718a.f7668a.f7795d)) {
            return true;
        }
        if (this.h == null || f0Var == null) {
            return false;
        }
        Proxy.Type type = f0Var.f7719b.type();
        Proxy.Type type2 = Proxy.Type.DIRECT;
        if (type != type2 || f0Var2.f7719b.type() != type2 || !f0Var2.f7720c.equals(f0Var.f7720c) || f0Var.f7718a.i != v8.c.f10904a || !j(uVar)) {
            return false;
        }
        try {
            aVar.j.a(uVar.f7795d, this.f.f7784c);
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean h(boolean z9) {
        boolean z10;
        if (!this.f8472e.isClosed() && !this.f8472e.isInputShutdown() && !this.f8472e.isOutputShutdown()) {
            q qVar = this.h;
            if (qVar != null) {
                synchronized (qVar) {
                    z10 = qVar.f9433p;
                }
                return !z10;
            }
            if (z9) {
                try {
                    int soTimeout = this.f8472e.getSoTimeout();
                    try {
                        this.f8472e.setSoTimeout(1);
                        boolean b7 = this.i.b();
                        Socket socket = this.f8472e;
                        if (b7) {
                            socket.setSoTimeout(soTimeout);
                            return false;
                        }
                        socket.setSoTimeout(soTimeout);
                        return true;
                    } catch (Throwable th) {
                        this.f8472e.setSoTimeout(soTimeout);
                        throw th;
                    }
                } catch (SocketTimeoutException unused) {
                } catch (IOException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public final q8.a i(m8.x xVar, q8.d dVar, e eVar) {
        int i = dVar.j;
        if (this.h != null) {
            return new s8.g(dVar, eVar, this.h);
        }
        this.f8472e.setSoTimeout(i);
        this.i.f10933a.a().g(i);
        this.j.f11006a.a().g(dVar.f8791k);
        return new g(xVar, eVar, this.i, this.j);
    }

    public final boolean j(u uVar) {
        int i = uVar.f7796e;
        String str = uVar.f7795d;
        u uVar2 = this.f8470c.f7718a.f7668a;
        if (i == uVar2.f7796e) {
            if (str.equals(uVar2.f7795d)) {
                return true;
            }
            r rVar = this.f;
            if (rVar != null && v8.c.c(str, (X509Certificate) rVar.f7784c.get(0))) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Connection{");
        f0 f0Var = this.f8470c;
        sb.append(f0Var.f7718a.f7668a.f7795d);
        sb.append(":");
        sb.append(f0Var.f7718a.f7668a.f7796e);
        sb.append(", proxy=");
        sb.append(f0Var.f7719b);
        sb.append(" hostAddress=");
        sb.append(f0Var.f7720c);
        sb.append(" cipherSuite=");
        r rVar = this.f;
        sb.append(rVar != null ? rVar.f7783b : "none");
        sb.append(" protocol=");
        sb.append(this.g);
        sb.append('}');
        return sb.toString();
    }
}
