package e1;

import android.content.Intent;
import android.os.SystemClock;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d4 extends n {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3876e;
    public final /* synthetic */ Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d4(Object obj, f2 f2Var, int i) {
        super(f2Var);
        this.f3876e = i;
        this.f = obj;
    }

    @Override // e1.n
    public final void a() {
        switch (this.f3876e) {
            case 0:
                e4 e4Var = (e4) this.f;
                f4 f4Var = e4Var.f3912d;
                f4Var.g();
                t1 t1Var = f4Var.f3875a;
                t1Var.f4269t.getClass();
                e4Var.a(false, false, SystemClock.elapsedRealtime());
                y yVar = t1Var.f4271w;
                t1.j(yVar);
                t1Var.f4269t.getClass();
                yVar.j(SystemClock.elapsedRealtime());
                break;
            case 1:
                k4 k4Var = (k4) this.f;
                k4Var.k();
                w0 w0Var = k4Var.f3875a.f4264o;
                t1.m(w0Var);
                w0Var.f4346w.b("Starting upload from DelayedRunnable");
                k4Var.f4092b.q();
                break;
            default:
                u4 u4Var = (u4) this.f;
                u4Var.b().g();
                String str = (String) u4Var.f4320z.pollFirst();
                if (str != null) {
                    u4Var.f().getClass();
                    u4Var.R = SystemClock.elapsedRealtime();
                    u4Var.a().f4346w.c(str, "Sending trigger URI notification to app");
                    Intent intent = new Intent();
                    intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
                    intent.setPackage(str);
                    u4.S(u4Var.f4316u.f4259a, intent);
                }
                u4Var.H();
                break;
        }
    }
}
