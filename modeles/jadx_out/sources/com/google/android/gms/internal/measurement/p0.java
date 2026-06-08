package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p0 extends x implements r0 {
    public p0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy", 0);
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final int b() {
        Parcel d10 = d(G(), 2);
        int readInt = d10.readInt();
        d10.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.measurement.r0
    public final void k(long j, Bundle bundle, String str, String str2) {
        Parcel G = G();
        G.writeString(str);
        G.writeString(str2);
        z.b(G, bundle);
        G.writeLong(j);
        H(G, 1);
    }
}
