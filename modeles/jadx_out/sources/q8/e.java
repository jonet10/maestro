package q8;

import javax.net.ssl.SSLSocketFactory;
import m8.c0;
import m8.j;
import m8.u;
import m8.v;
import m8.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e implements v {

    /* renamed from: a, reason: collision with root package name */
    public final x f8793a;

    /* renamed from: b, reason: collision with root package name */
    public Object f8794b;

    public e(x xVar) {
        this.f8793a = xVar;
    }

    public static boolean d(c0 c0Var, u uVar) {
        u uVar2 = c0Var.f7692a.f7673a;
        return uVar2.f7795d.equals(uVar.f7795d) && uVar2.f7796e == uVar.f7796e && uVar2.f7792a.equals(uVar.f7792a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:109:0x00e0, code lost:
    
        if (((r3 != null && r3.matches("\\d+")) ? java.lang.Integer.valueOf(r3).intValue() : Integer.MAX_VALUE) == 0) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x00f6, code lost:
    
        if (r10.equals("HEAD") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x009e, code lost:
    
        if ((r3 == null ? 0 : r3.matches("\\d+") ? java.lang.Integer.valueOf(r3).intValue() : Integer.MAX_VALUE) > 0) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x017d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0124  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [m8.e0, p8.a, q8.a] */
    /* JADX WARN: Type inference failed for: r10v4 */
    @Override // m8.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final m8.c0 a(q8.d r18) {
        /*
            Method dump skipped, instructions count: 520
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.e.a(q8.d):m8.c0");
    }

    public final m8.a b(u uVar) {
        SSLSocketFactory sSLSocketFactory;
        v8.c cVar;
        j jVar;
        boolean equals = uVar.f7792a.equals("https");
        x xVar = this.f8793a;
        if (equals) {
            sSLSocketFactory = xVar.f7823t;
            cVar = xVar.v;
            jVar = xVar.f7825w;
        } else {
            sSLSocketFactory = null;
            cVar = null;
            jVar = null;
        }
        return new m8.a(uVar.f7795d, uVar.f7796e, xVar.A, xVar.f7822s, sSLSocketFactory, cVar, jVar, xVar.f7826x, xVar.f7814b, xVar.f7815l, xVar.f7819p);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        if (r5 == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(java.io.IOException r3, p8.e r4, boolean r5, m8.a0 r6) {
        /*
            r2 = this;
            r4.g(r3)
            m8.x r0 = r2.f8793a
            boolean r0 = r0.D
            r1 = 0
            if (r0 != 0) goto Lb
            goto L2c
        Lb:
            if (r5 == 0) goto L10
            r6.getClass()
        L10:
            boolean r6 = r3 instanceof java.net.ProtocolException
            if (r6 == 0) goto L15
            return r1
        L15:
            boolean r6 = r3 instanceof java.io.InterruptedIOException
            if (r6 == 0) goto L20
            boolean r3 = r3 instanceof java.net.SocketTimeoutException
            if (r3 == 0) goto L2c
            if (r5 != 0) goto L2c
            goto L32
        L20:
            boolean r5 = r3 instanceof javax.net.ssl.SSLHandshakeException
            if (r5 == 0) goto L2d
            java.lang.Throwable r5 = r3.getCause()
            boolean r5 = r5 instanceof java.security.cert.CertificateException
            if (r5 == 0) goto L2d
        L2c:
            return r1
        L2d:
            boolean r3 = r3 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r3 == 0) goto L32
            return r1
        L32:
            m8.f0 r3 = r4.f8488c
            if (r3 != 0) goto L5c
            a2.q r3 = r4.f8487b
            if (r3 == 0) goto L45
            int r5 = r3.f44b
            java.util.ArrayList r3 = r3.f43a
            int r3 = r3.size()
            if (r5 >= r3) goto L45
            goto L5c
        L45:
            p8.c r3 = r4.g
            int r4 = r3.f8484e
            java.util.List r5 = r3.f8483d
            int r5 = r5.size()
            if (r4 >= r5) goto L52
            goto L5c
        L52:
            java.util.ArrayList r3 = r3.g
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L5b
            goto L5c
        L5b:
            return r1
        L5c:
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: q8.e.c(java.io.IOException, p8.e, boolean, m8.a0):boolean");
    }
}
