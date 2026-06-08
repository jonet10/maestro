package e1;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r0 extends k0.e {
    @Override // k0.e
    public final int i() {
        return 12451000;
    }

    @Override // k0.e
    public final /* synthetic */ IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return queryLocalInterface instanceof i0 ? (i0) queryLocalInterface : new g0(iBinder);
    }

    @Override // k0.e
    public final String u() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // k0.e
    public final String v() {
        return "com.google.android.gms.measurement.START";
    }
}
