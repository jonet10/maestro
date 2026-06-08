package e1;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class n2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4157a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b3 f4158b;

    public /* synthetic */ n2(b3 b3Var, int i) {
        this.f4157a = i;
        this.f4158b = b3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4157a) {
            case 0:
                this.f4158b.D();
                break;
            case 1:
                s1 s1Var = this.f4158b.A;
                t1 t1Var = s1Var.f4244a;
                q1 q1Var = t1Var.f4265p;
                b3 b3Var = t1Var.v;
                g1 g1Var = t1Var.f4263n;
                t1.m(q1Var);
                q1Var.g();
                if (s1Var.d()) {
                    if (s1Var.b()) {
                        t1.k(g1Var);
                        g1Var.F.o(null);
                        Bundle bundle = new Bundle();
                        bundle.putString("source", "(not set)");
                        bundle.putString("medium", "(not set)");
                        bundle.putString("_cis", "intent");
                        bundle.putLong("_cc", 1L);
                        t1.l(b3Var);
                        b3Var.n("auto", "_cmpx", bundle);
                    } else {
                        t1.k(g1Var);
                        a2.t tVar = g1Var.F;
                        String n10 = tVar.n();
                        if (TextUtils.isEmpty(n10)) {
                            w0 w0Var = t1Var.f4264o;
                            t1.m(w0Var);
                            w0Var.f4340p.b("Cache still valid but referrer not found");
                        } else {
                            long a8 = g1Var.G.a() / 3600000;
                            Uri parse = Uri.parse(n10);
                            Bundle bundle2 = new Bundle();
                            Pair pair = new Pair(parse.getPath(), bundle2);
                            for (String str : parse.getQueryParameterNames()) {
                                bundle2.putString(str, parse.getQueryParameter(str));
                            }
                            ((Bundle) pair.second).putLong("_cc", (a8 - 1) * 3600000);
                            Object obj = pair.first;
                            String str2 = obj == null ? "app" : (String) obj;
                            t1.l(b3Var);
                            b3Var.n(str2, "_cmp", (Bundle) pair.second);
                        }
                        tVar.o(null);
                    }
                    t1.k(g1Var);
                    g1Var.G.b(0L);
                    break;
                }
                break;
            case 2:
                b3 b3Var2 = this.f4158b;
                b3Var2.g();
                t1 t1Var2 = b3Var2.f3875a;
                g1 g1Var2 = t1Var2.f4263n;
                w0 w0Var2 = t1Var2.f4264o;
                t1.k(g1Var2);
                d1 d1Var = g1Var2.C;
                if (d1Var.a()) {
                    t1.m(w0Var2);
                    w0Var2.v.b("Deferred Deep Link already retrieved. Not fetching again.");
                    break;
                } else {
                    e1 e1Var = g1Var2.D;
                    long a10 = e1Var.a();
                    e1Var.b(1 + a10);
                    if (a10 >= 5) {
                        t1.m(w0Var2);
                        w0Var2.f4342r.b("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                        d1Var.b(true);
                        break;
                    } else {
                        if (b3Var2.C == null) {
                            b3Var2.C = new o2(b3Var2, t1Var2, 3);
                        }
                        b3Var2.C.b(0L);
                        break;
                    }
                }
            default:
                this.f4158b.D();
                break;
        }
    }
}
