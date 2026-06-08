package k0;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c0 extends w0.b {
    public e j;

    /* renamed from: k, reason: collision with root package name */
    public final int f6836k;

    public c0(e eVar, int i) {
        super("com.google.android.gms.common.internal.IGmsCallbacks", 2);
        this.j = eVar;
        this.f6836k = i;
    }

    @Override // w0.b
    public final boolean H(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            int readInt = parcel.readInt();
            IBinder readStrongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) z0.g.a(parcel, Bundle.CREATOR);
            z0.g.c(parcel);
            y.h(this.j, "onPostInitComplete can be called only once per call to getRemoteService");
            e eVar = this.j;
            int i6 = this.f6836k;
            eVar.getClass();
            e0 e0Var = new e0(eVar, readInt, readStrongBinder, bundle);
            b0 b0Var = eVar.f6844o;
            b0Var.sendMessage(b0Var.obtainMessage(1, i6, -1, e0Var));
            this.j = null;
        } else if (i == 2) {
            parcel.readInt();
            z0.g.c(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i != 3) {
                return false;
            }
            int readInt2 = parcel.readInt();
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            g0 g0Var = (g0) z0.g.a(parcel, g0.CREATOR);
            z0.g.c(parcel);
            e eVar2 = this.j;
            y.h(eVar2, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            y.g(g0Var);
            eVar2.E = g0Var;
            if (eVar2 instanceof v0.a) {
                f fVar = g0Var.f6879m;
                l b7 = l.b();
                m mVar = fVar == null ? null : fVar.f6855a;
                synchronized (b7) {
                    if (mVar == null) {
                        mVar = l.f6906l;
                    } else {
                        m mVar2 = (m) b7.f6907a;
                        if (mVar2 != null) {
                            if (mVar2.f6908a < mVar.f6908a) {
                            }
                        }
                    }
                    b7.f6907a = mVar;
                }
            }
            Bundle bundle2 = g0Var.f6876a;
            y.h(this.j, "onPostInitComplete can be called only once per call to getRemoteService");
            e eVar3 = this.j;
            int i10 = this.f6836k;
            eVar3.getClass();
            e0 e0Var2 = new e0(eVar3, readInt2, readStrongBinder2, bundle2);
            b0 b0Var2 = eVar3.f6844o;
            b0Var2.sendMessage(b0Var2.obtainMessage(1, i10, -1, e0Var2));
            this.j = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
