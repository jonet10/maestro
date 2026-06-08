package r8;

import f8.o;
import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import m8.b0;
import m8.c0;
import m8.d0;
import m8.s;
import m8.u;
import m8.x;
import m8.y;
import w8.a0;
import w8.e0;
import w8.i;
import w8.j;
import w8.z;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements q8.a {

    /* renamed from: a, reason: collision with root package name */
    public final x f9099a;

    /* renamed from: b, reason: collision with root package name */
    public final p8.e f9100b;

    /* renamed from: c, reason: collision with root package name */
    public final j f9101c;

    /* renamed from: d, reason: collision with root package name */
    public final i f9102d;

    /* renamed from: e, reason: collision with root package name */
    public int f9103e = 0;
    public long f = 262144;

    public g(x xVar, p8.e eVar, a0 a0Var, z zVar) {
        this.f9099a = xVar;
        this.f9100b = eVar;
        this.f9101c = a0Var;
        this.f9102d = zVar;
    }

    @Override // q8.a
    public final void a(m8.a0 a0Var) {
        Proxy.Type type = this.f9100b.a().f8470c.f7719b.type();
        StringBuilder sb = new StringBuilder();
        sb.append(a0Var.f7674b);
        sb.append(' ');
        u uVar = a0Var.f7673a;
        if (uVar.f7792a.equals("https") || type != Proxy.Type.HTTP) {
            String str = uVar.i;
            int indexOf = str.indexOf(47, uVar.f7792a.length() + 3);
            String substring = str.substring(indexOf, n8.c.g(indexOf, str.length(), str, "?#"));
            String e10 = uVar.e();
            if (e10 != null) {
                substring = substring + '?' + e10;
            }
            sb.append(substring);
        } else {
            sb.append(uVar);
        }
        sb.append(" HTTP/1.1");
        h(a0Var.f7675c, sb.toString());
    }

    @Override // q8.a
    public final void b() {
        this.f9102d.flush();
    }

    @Override // q8.a
    public final b0 c(boolean z9) {
        j jVar = this.f9101c;
        int i = this.f9103e;
        if (i != 1 && i != 3) {
            com.google.gson.internal.a.f(this.f9103e, "state: ");
            return null;
        }
        try {
            String k5 = jVar.k(this.f);
            this.f -= k5.length();
            o d10 = o.d(k5);
            int i6 = d10.f4961c;
            b0 b0Var = new b0();
            b0Var.f7684b = (y) d10.f4960b;
            b0Var.f7685c = i6;
            b0Var.f7686d = (String) d10.f4962d;
            g5.f fVar = new g5.f(9);
            while (true) {
                String k10 = jVar.k(this.f);
                this.f -= k10.length();
                if (k10.length() == 0) {
                    break;
                }
                m8.b.f7682e.getClass();
                fVar.n(k10);
            }
            ArrayList arrayList = (ArrayList) fVar.f5309b;
            String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            g5.f fVar2 = new g5.f(9);
            Collections.addAll((ArrayList) fVar2.f5309b, strArr);
            b0Var.f = fVar2;
            if (z9 && i6 == 100) {
                return null;
            }
            if (i6 == 100) {
                this.f9103e = 3;
                return b0Var;
            }
            this.f9103e = 4;
            return b0Var;
        } catch (EOFException e10) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f9100b);
            iOException.initCause(e10);
            throw iOException;
        }
    }

    @Override // q8.a
    public final void d() {
        this.f9102d.flush();
    }

    @Override // q8.a
    public final d0 e(c0 c0Var) {
        p8.e eVar = this.f9100b;
        eVar.f8490e.getClass();
        c0Var.c("Content-Type");
        if (!q8.c.b(c0Var)) {
            return new d0(0L, new a0(g(0L)), 1);
        }
        if ("chunked".equalsIgnoreCase(c0Var.c("Transfer-Encoding"))) {
            u uVar = c0Var.f7692a.f7673a;
            if (this.f9103e == 4) {
                this.f9103e = 5;
                return new d0(-1L, new a0(new c(this, uVar)), 1);
            }
            com.google.gson.internal.a.f(this.f9103e, "state: ");
            return null;
        }
        long a8 = q8.c.a(c0Var);
        if (a8 != -1) {
            return new d0(a8, new a0(g(a8)), 1);
        }
        if (this.f9103e != 4) {
            com.google.gson.internal.a.f(this.f9103e, "state: ");
            return null;
        }
        this.f9103e = 5;
        eVar.e();
        return new d0(-1L, new a0(new f(this)), 1);
    }

    @Override // q8.a
    public final e0 f(m8.a0 a0Var, long j) {
        if ("chunked".equalsIgnoreCase(a0Var.f7675c.a("Transfer-Encoding"))) {
            if (this.f9103e == 1) {
                this.f9103e = 2;
                return new b(this);
            }
            com.google.gson.internal.a.f(this.f9103e, "state: ");
            return null;
        }
        if (j == -1) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Cannot stream a request body without chunked encoding or a known content length!");
            return null;
        }
        if (this.f9103e == 1) {
            this.f9103e = 2;
            return new d(this, j);
        }
        com.google.gson.internal.a.f(this.f9103e, "state: ");
        return null;
    }

    public final e g(long j) {
        if (this.f9103e != 4) {
            com.google.gson.internal.a.f(this.f9103e, "state: ");
            return null;
        }
        this.f9103e = 5;
        e eVar = new e(this);
        eVar.f9097n = j;
        if (j == 0) {
            eVar.b(true, null);
        }
        return eVar;
    }

    public final void h(s sVar, String str) {
        if (this.f9103e != 0) {
            com.google.gson.internal.a.f(this.f9103e, "state: ");
            return;
        }
        i iVar = this.f9102d;
        iVar.m(str).m("\r\n");
        int d10 = sVar.d();
        for (int i = 0; i < d10; i++) {
            iVar.m(sVar.b(i)).m(": ").m(sVar.e(i)).m("\r\n");
        }
        iVar.m("\r\n");
        this.f9103e = 1;
    }
}
