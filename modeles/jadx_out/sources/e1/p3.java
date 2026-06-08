package e1;

import android.os.Parcel;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p3 extends com.google.android.gms.internal.measurement.y implements m0 {
    public final /* synthetic */ AtomicReference i;
    public final /* synthetic */ w3 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p3(w3 w3Var, AtomicReference atomicReference) {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
        this.i = atomicReference;
        this.j = w3Var;
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final boolean a(int i, Parcel parcel, Parcel parcel2) {
        if (i != 2) {
            return false;
        }
        o4 o4Var = (o4) com.google.android.gms.internal.measurement.z.a(parcel, o4.CREATOR);
        com.google.android.gms.internal.measurement.z.d(parcel);
        q(o4Var);
        return true;
    }

    @Override // e1.m0
    public final void q(o4 o4Var) {
        AtomicReference atomicReference = this.i;
        synchronized (atomicReference) {
            w0 w0Var = this.j.f3875a.f4264o;
            t1.m(w0Var);
            w0Var.f4346w.c(Integer.valueOf(o4Var.f4180a.size()), "[sgtm] Got upload batches from service. count");
            atomicReference.set(o4Var);
            atomicReference.notifyAll();
        }
    }
}
