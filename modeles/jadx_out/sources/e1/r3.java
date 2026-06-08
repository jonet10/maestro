package e1;

import android.os.RemoteException;
import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4238a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c5 f4239b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ w3 f4240l;

    public r3(w3 w3Var, c5 c5Var) {
        this.f4238a = 4;
        this.f4239b = c5Var;
        Objects.requireNonNull(w3Var);
        this.f4240l = w3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4238a) {
            case 0:
                w3 w3Var = this.f4240l;
                i0 i0Var = w3Var.f4359m;
                t1 t1Var = w3Var.f3875a;
                if (i0Var != null) {
                    try {
                        i0Var.B(this.f4239b);
                    } catch (RemoteException e10) {
                        w0 w0Var = t1Var.f4264o;
                        t1.m(w0Var);
                        w0Var.f4339o.c(e10, "Failed to reset data on the service: remote exception");
                    }
                    w3Var.t();
                    break;
                } else {
                    w0 w0Var2 = t1Var.f4264o;
                    t1.m(w0Var2);
                    w0Var2.f4339o.b("Failed to reset data on the service: not connected to service");
                    break;
                }
            case 1:
                w3 w3Var2 = this.f4240l;
                i0 i0Var2 = w3Var2.f4359m;
                t1 t1Var2 = w3Var2.f3875a;
                if (i0Var2 == null) {
                    w0 w0Var3 = t1Var2.f4264o;
                    t1.m(w0Var3);
                    w0Var3.f4339o.b("Discarding data. Failed to send app launch");
                    break;
                } else {
                    try {
                        c5 c5Var = this.f4239b;
                        g gVar = t1Var2.f4262m;
                        e0 e0Var = f0.f3919c1;
                        if (gVar.q(null, e0Var)) {
                            w3Var2.y(i0Var2, null, c5Var);
                        }
                        i0Var2.p(c5Var);
                        t1Var2.o().l();
                        t1Var2.f4262m.q(null, e0Var);
                        w3Var2.y(i0Var2, null, c5Var);
                        w3Var2.t();
                        break;
                    } catch (RemoteException e11) {
                        w0 w0Var4 = t1Var2.f4264o;
                        t1.m(w0Var4);
                        w0Var4.f4339o.c(e11, "Failed to send app launch to the service");
                        return;
                    }
                }
            case 2:
                w3 w3Var3 = this.f4240l;
                i0 i0Var3 = w3Var3.f4359m;
                t1 t1Var3 = w3Var3.f3875a;
                if (i0Var3 == null) {
                    w0 w0Var5 = t1Var3.f4264o;
                    t1.m(w0Var5);
                    w0Var5.f4342r.b("Failed to send app backgrounded");
                    break;
                } else {
                    try {
                        i0Var3.C(this.f4239b);
                        w3Var3.t();
                        break;
                    } catch (RemoteException e12) {
                        w0 w0Var6 = t1Var3.f4264o;
                        t1.m(w0Var6);
                        w0Var6.f4339o.c(e12, "Failed to send app backgrounded to the service");
                        return;
                    }
                }
            case 3:
                w3 w3Var4 = this.f4240l;
                i0 i0Var4 = w3Var4.f4359m;
                t1 t1Var4 = w3Var4.f3875a;
                if (i0Var4 == null) {
                    w0 w0Var7 = t1Var4.f4264o;
                    t1.m(w0Var7);
                    w0Var7.f4339o.b("Failed to send measurementEnabled to service");
                    break;
                } else {
                    try {
                        i0Var4.r(this.f4239b);
                        w3Var4.t();
                        break;
                    } catch (RemoteException e13) {
                        w0 w0Var8 = t1Var4.f4264o;
                        t1.m(w0Var8);
                        w0Var8.f4339o.c(e13, "Failed to send measurementEnabled to the service");
                        return;
                    }
                }
            default:
                w3 w3Var5 = this.f4240l;
                i0 i0Var5 = w3Var5.f4359m;
                t1 t1Var5 = w3Var5.f3875a;
                if (i0Var5 == null) {
                    w0 w0Var9 = t1Var5.f4264o;
                    t1.m(w0Var9);
                    w0Var9.f4339o.b("Failed to send consent settings to service");
                    break;
                } else {
                    try {
                        i0Var5.i(this.f4239b);
                        w3Var5.t();
                        break;
                    } catch (RemoteException e14) {
                        w0 w0Var10 = t1Var5.f4264o;
                        t1.m(w0Var10);
                        w0Var10.f4339o.c(e14, "Failed to send consent settings to the service");
                    }
                }
        }
    }

    public /* synthetic */ r3(w3 w3Var, c5 c5Var, int i) {
        this.f4238a = i;
        this.f4239b = c5Var;
        this.f4240l = w3Var;
    }
}
