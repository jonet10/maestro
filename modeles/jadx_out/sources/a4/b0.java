package a4;

import android.net.NetworkInfo;
import android.net.Uri;
import java.io.IOException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b0 extends n0 {

    /* renamed from: a, reason: collision with root package name */
    public final f0.i f73a;

    /* renamed from: b, reason: collision with root package name */
    public final o0 f74b;

    public b0(f0.i iVar, o0 o0Var) {
        this.f73a = iVar;
        this.f74b = o0Var;
    }

    @Override // a4.n0
    public final boolean b(k0 k0Var) {
        String scheme = ((Uri) k0Var.f127b).getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    @Override // a4.n0
    public final int d() {
        return 2;
    }

    @Override // a4.n0
    public final m0 e(k0 k0Var, int i) {
        m8.i iVar;
        if (i == 0) {
            iVar = null;
        } else if ((i & 4) != 0) {
            iVar = m8.i.f7734n;
        } else {
            m8.h hVar = new m8.h();
            if ((i & 1) != 0) {
                hVar.f7730a = true;
            }
            if ((i & 2) != 0) {
                hVar.f7731b = true;
            }
            iVar = new m8.i(hVar);
        }
        y2.s sVar = new y2.s(9);
        sVar.D(((Uri) k0Var.f127b).toString());
        if (iVar != null) {
            String iVar2 = iVar.toString();
            if (iVar2.isEmpty()) {
                ((g5.f) sVar.f11757m).Q("Cache-Control");
            } else {
                sVar.w("Cache-Control", iVar2);
            }
        }
        m8.a0 n10 = sVar.n();
        m8.x xVar = (m8.x) this.f73a.f4811b;
        m8.z zVar = new m8.z(xVar, n10);
        xVar.f7818o.getClass();
        zVar.f7838l = m8.b.f7681d;
        synchronized (zVar) {
            if (zVar.f7840n) {
                throw new IllegalStateException("Already Executed");
            }
            zVar.f7840n = true;
        }
        zVar.f7837b.f8794b = u8.h.f10783a.i();
        zVar.f7838l.getClass();
        try {
            try {
                xVar.f7813a.e(zVar);
                m8.c0 a8 = zVar.a();
                xVar.f7813a.f(zVar);
                m8.e0 e0Var = a8.f7698p;
                int i6 = a8.f7694l;
                if (i6 < 200 || i6 >= 300) {
                    e0Var.close();
                    throw new a0(androidx.lifecycle.l.u(a8.f7694l, "HTTP "));
                }
                int i10 = a8.f7700r == null ? 3 : 2;
                if (i10 == 2 && e0Var.b() == 0) {
                    e0Var.close();
                    throw new z("Received response with 0 content-length header.");
                }
                if (i10 == 3 && e0Var.b() > 0) {
                    o0 o0Var = this.f74b;
                    long b7 = e0Var.b();
                    n nVar = o0Var.f148b;
                    nVar.sendMessage(nVar.obtainMessage(4, Long.valueOf(b7)));
                }
                return new m0(e0Var.c(), i10);
            } catch (IOException e10) {
                zVar.f7838l.getClass();
                throw e10;
            }
        } catch (Throwable th) {
            zVar.f7836a.f7813a.f(zVar);
            throw th;
        }
    }

    @Override // a4.n0
    public final boolean f(NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }
}
