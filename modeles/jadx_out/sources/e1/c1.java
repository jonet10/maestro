package e1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c1 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public final u4 f3843a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3844b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3845c;

    public c1(u4 u4Var) {
        k0.y.g(u4Var);
        this.f3843a = u4Var;
    }

    public final void a() {
        u4 u4Var = this.f3843a;
        u4Var.l0();
        u4Var.b().g();
        u4Var.b().g();
        if (this.f3844b) {
            u4Var.a().f4346w.b("Unregistering connectivity change receiver");
            this.f3844b = false;
            this.f3845c = false;
            try {
                u4Var.f4316u.f4259a.unregisterReceiver(this);
            } catch (IllegalArgumentException e10) {
                u4Var.a().f4339o.c(e10, "Failed to unregister the network broadcast receiver");
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        u4 u4Var = this.f3843a;
        u4Var.l0();
        String action = intent.getAction();
        u4Var.a().f4346w.c(action, "NetworkBroadcastReceiver received action");
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            u4Var.a().f4342r.c(action, "NetworkBroadcastReceiver received unknown action");
            return;
        }
        a1 a1Var = u4Var.f4306b;
        u4.U(a1Var);
        boolean A = a1Var.A();
        if (this.f3845c != A) {
            this.f3845c = A;
            u4Var.b().p(new a4.f(this, A));
        }
    }
}
