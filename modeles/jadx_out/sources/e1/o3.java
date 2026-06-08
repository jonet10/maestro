package e1;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o3 extends com.google.android.gms.internal.measurement.y implements k0 {
    public final /* synthetic */ AtomicReference i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o3(w3 w3Var, AtomicReference atomicReference) {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
        this.i = atomicReference;
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final boolean a(int i, Parcel parcel, Parcel parcel2) {
        if (i != 2) {
            return false;
        }
        ArrayList createTypedArrayList = parcel.createTypedArrayList(j4.CREATOR);
        com.google.android.gms.internal.measurement.z.d(parcel);
        x(createTypedArrayList);
        return true;
    }

    @Override // e1.k0
    public final void x(List list) {
        AtomicReference atomicReference = this.i;
        synchronized (atomicReference) {
            atomicReference.set(list);
            atomicReference.notifyAll();
        }
    }
}
