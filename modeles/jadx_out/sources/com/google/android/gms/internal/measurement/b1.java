package com.google.android.gms.internal.measurement;

import android.os.Parcel;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b1 extends y implements o0 {
    public final /* synthetic */ m1.a i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b1(x0 x0Var, m1.a aVar) {
        super("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
        this.i = aVar;
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final boolean a(int i, Parcel parcel, Parcel parcel2) {
        if (i != 2) {
            return false;
        }
        e();
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.o0
    public final void e() {
        this.i.run();
    }
}
