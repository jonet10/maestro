package e1;

import android.util.Log;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4031a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final t1 f4032b;

    public i1(u4 u4Var) {
        this.f4032b = u4Var.f4316u;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a() {
        switch (this.f4031a) {
            case 0:
                t1 t1Var = this.f4032b;
                boolean z9 = false;
                try {
                    r0.b a8 = r0.c.a(t1Var.f4259a);
                    if (a8 == null) {
                        w0 w0Var = t1Var.f4264o;
                        t1.m(w0Var);
                        w0Var.f4346w.b("Failed to get PackageManager for Install Referrer Play Store compatibility check");
                        t1Var = t1Var;
                    } else {
                        int i = a8.b(128, "com.android.vending").versionCode;
                        t1Var = i;
                        if (i >= 80837300) {
                            z9 = true;
                            t1Var = i;
                        }
                    }
                } catch (Exception e10) {
                    w0 w0Var2 = t1Var.f4264o;
                    t1.m(w0Var2);
                    w0Var2.f4346w.c(e10, "Failed to retrieve Play Store version for Install Referrer");
                }
                return z9;
            default:
                w0 w0Var3 = this.f4032b.f4264o;
                t1.m(w0Var3);
                return Log.isLoggable(w0Var3.q(), 3);
        }
    }

    public i1(m2 m2Var, t1 t1Var) {
        this.f4032b = t1Var;
    }
}
