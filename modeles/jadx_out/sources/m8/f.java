package m8;

import androidx.core.location.LocationRequestCompat;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f {

    /* renamed from: k, reason: collision with root package name */
    public static final String f7711k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f7712l;

    /* renamed from: a, reason: collision with root package name */
    public final String f7713a;

    /* renamed from: b, reason: collision with root package name */
    public final s f7714b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7715c;

    /* renamed from: d, reason: collision with root package name */
    public final y f7716d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7717e;
    public final String f;
    public final s g;
    public final r h;
    public final long i;
    public final long j;

    static {
        u8.h hVar = u8.h.f10783a;
        hVar.getClass();
        f7711k = "OkHttp-Sent-Millis";
        hVar.getClass();
        f7712l = "OkHttp-Received-Millis";
    }

    public f(w8.g0 g0Var) {
        try {
            g0Var.getClass();
            w8.a0 a0Var = new w8.a0(g0Var);
            this.f7713a = a0Var.k(LocationRequestCompat.PASSIVE_INTERVAL);
            this.f7715c = a0Var.k(LocationRequestCompat.PASSIVE_INTERVAL);
            g5.f fVar = new g5.f(9);
            int b7 = g.b(a0Var);
            for (int i = 0; i < b7; i++) {
                fVar.n(a0Var.k(LocationRequestCompat.PASSIVE_INTERVAL));
            }
            this.f7714b = new s(fVar);
            f8.o d10 = f8.o.d(a0Var.k(LocationRequestCompat.PASSIVE_INTERVAL));
            this.f7716d = (y) d10.f4960b;
            this.f7717e = d10.f4961c;
            this.f = (String) d10.f4962d;
            g5.f fVar2 = new g5.f(9);
            int b10 = g.b(a0Var);
            for (int i6 = 0; i6 < b10; i6++) {
                fVar2.n(a0Var.k(LocationRequestCompat.PASSIVE_INTERVAL));
            }
            String str = f7711k;
            String C = fVar2.C(str);
            String str2 = f7712l;
            String C2 = fVar2.C(str2);
            fVar2.Q(str);
            fVar2.Q(str2);
            this.i = C != null ? Long.parseLong(C) : 0L;
            this.j = C2 != null ? Long.parseLong(C2) : 0L;
            this.g = new s(fVar2);
            if (this.f7713a.startsWith("https://")) {
                String k5 = a0Var.k(LocationRequestCompat.PASSIVE_INTERVAL);
                if (k5.length() > 0) {
                    throw new IOException("expected \"\" but was \"" + k5 + "\"");
                }
                this.h = new r(!a0Var.b() ? g0.a(a0Var.k(LocationRequestCompat.PASSIVE_INTERVAL)) : g0.SSL_3_0, l.a(a0Var.k(LocationRequestCompat.PASSIVE_INTERVAL)), n8.c.k(a(a0Var)), n8.c.k(a(a0Var)));
            } else {
                this.h = null;
            }
            g0Var.close();
        } catch (Throwable th) {
            g0Var.close();
            throw th;
        }
    }

    public static List a(w8.a0 a0Var) {
        int b7 = g.b(a0Var);
        if (b7 == -1) {
            return Collections.EMPTY_LIST;
        }
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            ArrayList arrayList = new ArrayList(b7);
            for (int i = 0; i < b7; i++) {
                String k5 = a0Var.k(LocationRequestCompat.PASSIVE_INTERVAL);
                w8.h hVar = new w8.h();
                hVar.y(w8.k.c(k5));
                arrayList.add(certificateFactory.generateCertificate(new w8.f(hVar, 0)));
            }
            return arrayList;
        } catch (CertificateException e10) {
            com.google.gson.internal.a.n(e10.getMessage());
            return null;
        }
    }

    public static void b(w8.z zVar, List list) {
        try {
            zVar.c(list.size());
            zVar.writeByte(10);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                zVar.m(w8.k.n(((Certificate) list.get(i)).getEncoded()).a());
                zVar.writeByte(10);
            }
        } catch (CertificateEncodingException e10) {
            com.google.gson.internal.a.n(e10.getMessage());
        }
    }

    public final void c(a2.t tVar) {
        w8.z zVar = new w8.z(tVar.j(0));
        String str = this.f7713a;
        zVar.m(str);
        zVar.writeByte(10);
        zVar.m(this.f7715c);
        zVar.writeByte(10);
        s sVar = this.f7714b;
        zVar.c(sVar.d());
        zVar.writeByte(10);
        int d10 = sVar.d();
        for (int i = 0; i < d10; i++) {
            zVar.m(sVar.b(i));
            zVar.m(": ");
            zVar.m(sVar.e(i));
            zVar.writeByte(10);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7716d == y.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f7717e);
        String str2 = this.f;
        if (str2 != null) {
            sb.append(' ');
            sb.append(str2);
        }
        zVar.m(sb.toString());
        zVar.writeByte(10);
        s sVar2 = this.g;
        zVar.c(sVar2.d() + 2);
        zVar.writeByte(10);
        int d11 = sVar2.d();
        for (int i6 = 0; i6 < d11; i6++) {
            zVar.m(sVar2.b(i6));
            zVar.m(": ");
            zVar.m(sVar2.e(i6));
            zVar.writeByte(10);
        }
        zVar.m(f7711k);
        zVar.m(": ");
        zVar.c(this.i);
        zVar.writeByte(10);
        zVar.m(f7712l);
        zVar.m(": ");
        zVar.c(this.j);
        zVar.writeByte(10);
        if (str.startsWith("https://")) {
            zVar.writeByte(10);
            r rVar = this.h;
            zVar.m(rVar.f7783b.f7756a);
            zVar.writeByte(10);
            b(zVar, rVar.f7784c);
            b(zVar, rVar.f7785d);
            zVar.m(rVar.f7782a.f7729a);
            zVar.writeByte(10);
        }
        zVar.close();
    }

    public f(c0 c0Var) {
        s sVar;
        a0 a0Var = c0Var.f7692a;
        this.f7713a = a0Var.f7673a.i;
        int i = q8.c.f8785a;
        s sVar2 = c0Var.f7699q.f7692a.f7675c;
        s sVar3 = c0Var.f7697o;
        Set f = q8.c.f(sVar3);
        if (f.isEmpty()) {
            sVar = new s(new g5.f(9));
        } else {
            g5.f fVar = new g5.f(9);
            int d10 = sVar2.d();
            for (int i6 = 0; i6 < d10; i6++) {
                String b7 = sVar2.b(i6);
                if (f.contains(b7)) {
                    String e10 = sVar2.e(i6);
                    g5.f.v(b7, e10);
                    fVar.o(b7, e10);
                }
            }
            sVar = new s(fVar);
        }
        this.f7714b = sVar;
        this.f7715c = a0Var.f7674b;
        this.f7716d = c0Var.f7693b;
        this.f7717e = c0Var.f7694l;
        this.f = c0Var.f7695m;
        this.g = sVar3;
        this.h = c0Var.f7696n;
        this.i = c0Var.f7702t;
        this.j = c0Var.f7703u;
    }
}
