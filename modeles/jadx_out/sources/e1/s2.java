package e1;

import android.os.SystemClock;
import android.text.TextUtils;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4245a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4246b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ b3 f4247l;

    public s2(b3 b3Var, long j, int i) {
        this.f4245a = i;
        switch (i) {
            case 1:
                this.f4246b = j;
                Objects.requireNonNull(b3Var);
                this.f4247l = b3Var;
                break;
            default:
                this.f4246b = j;
                Objects.requireNonNull(b3Var);
                this.f4247l = b3Var;
                break;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4245a) {
            case 0:
                t1 t1Var = this.f4247l.f3875a;
                g1 g1Var = t1Var.f4263n;
                t1.k(g1Var);
                e1 e1Var = g1Var.f3989t;
                long j = this.f4246b;
                e1Var.b(j);
                w0 w0Var = t1Var.f4264o;
                t1.m(w0Var);
                w0Var.v.c(Long.valueOf(j), "Session timeout duration set");
                break;
            default:
                b3 b3Var = this.f4247l;
                b3Var.g();
                b3Var.h();
                t1 t1Var2 = b3Var.f3875a;
                w0 w0Var2 = t1Var2.f4264o;
                t1.m(w0Var2);
                w0Var2.v.b("Resetting analytics data (FE)");
                f4 f4Var = t1Var2.f4266q;
                t1.l(f4Var);
                f4Var.g();
                e4 e4Var = f4Var.f3975o;
                e4Var.f3911c.c();
                e4Var.f3912d.f3875a.f4269t.getClass();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                e4Var.f3909a = elapsedRealtime;
                e4Var.f3910b = elapsedRealtime;
                t1Var2.r().l();
                boolean z9 = !t1Var2.d();
                g1 g1Var2 = t1Var2.f4263n;
                t1.k(g1Var2);
                g1Var2.f3984o.b(this.f4246b);
                t1 t1Var3 = g1Var2.f3875a;
                g1 g1Var3 = t1Var3.f4263n;
                t1.k(g1Var3);
                if (!TextUtils.isEmpty(g1Var3.E.n())) {
                    g1Var2.E.o(null);
                }
                g1Var2.f3993y.b(0L);
                g1Var2.f3994z.b(0L);
                if (!t1Var3.f4262m.t()) {
                    g1Var2.p(z9);
                }
                g1Var2.F.o(null);
                g1Var2.G.b(0L);
                g1Var2.H.K(null);
                w3 p10 = t1Var2.p();
                p10.g();
                p10.h();
                c5 w2 = p10.w(false);
                p10.s();
                p10.f3875a.o().k();
                p10.u(new r3(p10, w2, 0));
                t1.l(f4Var);
                f4Var.f3974n.G();
                b3Var.B = z9;
                t1Var2.p().k(new AtomicReference());
                break;
        }
    }
}
