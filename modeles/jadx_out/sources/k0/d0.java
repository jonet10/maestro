package k0;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final int f6837a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f6838b;

    public d0(e eVar, int i) {
        this.f6838b = eVar;
        this.f6837a = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e eVar = this.f6838b;
        if (iBinder == null) {
            eVar.y();
            return;
        }
        synchronized (eVar.f6846q) {
            try {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                eVar.f6847r = (queryLocalInterface == null || !(queryLocalInterface instanceof u)) ? new u(iBinder) : (u) queryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        e eVar2 = this.f6838b;
        int i = this.f6837a;
        eVar2.getClass();
        f0 f0Var = new f0(eVar2, 0, null);
        b0 b0Var = eVar2.f6844o;
        b0Var.sendMessage(b0Var.obtainMessage(7, i, -1, f0Var));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        e eVar = this.f6838b;
        synchronized (eVar.f6846q) {
            eVar.f6847r = null;
        }
        e eVar2 = this.f6838b;
        int i = this.f6837a;
        b0 b0Var = eVar2.f6844o;
        b0Var.sendMessage(b0Var.obtainMessage(6, i, 1));
    }
}
