package e1;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h1 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final String f4015a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i1 f4016b;

    public h1(i1 i1Var, String str) {
        Objects.requireNonNull(i1Var);
        this.f4016b = i1Var;
        this.f4015a = str;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        i1 i1Var = this.f4016b;
        if (iBinder == null) {
            w0 w0Var = i1Var.f4032b.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.b("Install Referrer connection returned with null binder");
            return;
        }
        try {
            int i = com.google.android.gms.internal.measurement.b0.i;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            com.google.android.gms.internal.measurement.c0 a0Var = queryLocalInterface instanceof com.google.android.gms.internal.measurement.c0 ? (com.google.android.gms.internal.measurement.c0) queryLocalInterface : new com.google.android.gms.internal.measurement.a0(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService", 0);
            t1 t1Var = i1Var.f4032b;
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4346w.b("Install Referrer Service connected");
            q1 q1Var = t1Var.f4265p;
            t1.m(q1Var);
            q1Var.p(new m1.a(this, a0Var, this));
        } catch (RuntimeException e10) {
            w0 w0Var3 = i1Var.f4032b.f4264o;
            t1.m(w0Var3);
            w0Var3.f4342r.c(e10, "Exception occurred while calling Install Referrer API");
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        w0 w0Var = this.f4016b.f4032b.f4264o;
        t1.m(w0Var);
        w0Var.f4346w.b("Install Referrer Service disconnected");
    }
}
