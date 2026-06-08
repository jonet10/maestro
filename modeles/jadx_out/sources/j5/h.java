package j5;

import a4.x;
import java.net.ProtocolException;
import m8.a0;
import m8.b0;
import m8.c0;
import m8.e0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h implements m8.v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6689a;

    public /* synthetic */ h(int i) {
        this.f6689a = i;
    }

    @Override // m8.v
    public final c0 a(q8.d dVar) {
        switch (this.f6689a) {
            case 0:
                c0 a8 = dVar.a(dVar.f);
                if (a8.f7700r == null) {
                    e0 e0Var = a8.f7698p;
                    long b7 = e0Var != null ? e0Var.b() : -1L;
                    if (b7 > 0) {
                        j.a(2, b7);
                    }
                }
                return a8;
            default:
                q8.a aVar = dVar.f8788c;
                p8.e eVar = dVar.f8787b;
                a0 a0Var = dVar.f;
                long currentTimeMillis = System.currentTimeMillis();
                dVar.h.getClass();
                aVar.a(a0Var);
                t0.f.B(a0Var.f7674b);
                aVar.b();
                b0 c9 = aVar.c(false);
                c9.f7683a = a0Var;
                c9.f7687e = eVar.a().f;
                c9.f7688k = currentTimeMillis;
                c9.f7689l = System.currentTimeMillis();
                c0 a10 = c9.a();
                int i = a10.f7694l;
                if (i == 100) {
                    b0 c10 = aVar.c(false);
                    c10.f7683a = a0Var;
                    c10.f7687e = eVar.a().f;
                    c10.f7688k = currentTimeMillis;
                    c10.f7689l = System.currentTimeMillis();
                    a10 = c10.a();
                    i = a10.f7694l;
                }
                b0 d10 = a10.d();
                d10.g = aVar.e(a10);
                c0 a11 = d10.a();
                e0 e0Var2 = a11.f7698p;
                if ("close".equalsIgnoreCase(a11.f7692a.f7675c.a("Connection")) || "close".equalsIgnoreCase(a11.c("Connection"))) {
                    eVar.e();
                }
                if ((i != 204 && i != 205) || e0Var2.b() <= 0) {
                    return a11;
                }
                StringBuilder p10 = x.p(i, "HTTP ", " had non-zero Content-Length: ");
                p10.append(e0Var2.b());
                throw new ProtocolException(p10.toString());
        }
    }
}
