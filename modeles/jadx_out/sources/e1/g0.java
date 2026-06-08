package e1;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g0 extends com.google.android.gms.internal.measurement.x implements i0 {
    public g0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService", 0);
    }

    @Override // e1.i0
    public final void A(x4 x4Var, c5 c5Var) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, x4Var);
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        H(G, 2);
    }

    @Override // e1.i0
    public final void B(c5 c5Var) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        H(G, 18);
    }

    @Override // e1.i0
    public final void C(c5 c5Var) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        H(G, 27);
    }

    @Override // e1.i0
    public final void D(Bundle bundle, c5 c5Var) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, bundle);
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        H(G, 19);
    }

    @Override // e1.i0
    public final List E(String str, String str2, boolean z9, c5 c5Var) {
        Parcel G = G();
        G.writeString(str);
        G.writeString(str2);
        ClassLoader classLoader = com.google.android.gms.internal.measurement.z.f2922a;
        G.writeInt(z9 ? 1 : 0);
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        Parcel d10 = d(G, 14);
        ArrayList createTypedArrayList = d10.createTypedArrayList(x4.CREATOR);
        d10.recycle();
        return createTypedArrayList;
    }

    @Override // e1.i0
    public final i f(c5 c5Var) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        Parcel d10 = d(G, 21);
        i iVar = (i) com.google.android.gms.internal.measurement.z.a(d10, i.CREATOR);
        d10.recycle();
        return iVar;
    }

    @Override // e1.i0
    public final void g(c5 c5Var, n4 n4Var, m0 m0Var) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        com.google.android.gms.internal.measurement.z.b(G, n4Var);
        com.google.android.gms.internal.measurement.z.c(G, m0Var);
        H(G, 29);
    }

    @Override // e1.i0
    public final List h(String str, String str2, String str3, boolean z9) {
        Parcel G = G();
        G.writeString(null);
        G.writeString(str2);
        G.writeString(str3);
        ClassLoader classLoader = com.google.android.gms.internal.measurement.z.f2922a;
        G.writeInt(z9 ? 1 : 0);
        Parcel d10 = d(G, 15);
        ArrayList createTypedArrayList = d10.createTypedArrayList(x4.CREATOR);
        d10.recycle();
        return createTypedArrayList;
    }

    @Override // e1.i0
    public final void i(c5 c5Var) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        H(G, 20);
    }

    @Override // e1.i0
    public final void j(long j, String str, String str2, String str3) {
        Parcel G = G();
        G.writeLong(j);
        G.writeString(str);
        G.writeString(str2);
        G.writeString(str3);
        H(G, 10);
    }

    @Override // e1.i0
    public final void l(c5 c5Var, Bundle bundle, k0 k0Var) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        com.google.android.gms.internal.measurement.z.b(G, bundle);
        com.google.android.gms.internal.measurement.z.c(G, k0Var);
        H(G, 31);
    }

    @Override // e1.i0
    public final void m(c5 c5Var) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        H(G, 25);
    }

    @Override // e1.i0
    public final byte[] n(u uVar, String str) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, uVar);
        G.writeString(str);
        Parcel d10 = d(G, 9);
        byte[] createByteArray = d10.createByteArray();
        d10.recycle();
        return createByteArray;
    }

    @Override // e1.i0
    public final List o(String str, String str2, String str3) {
        Parcel G = G();
        G.writeString(null);
        G.writeString(str2);
        G.writeString(str3);
        Parcel d10 = d(G, 17);
        ArrayList createTypedArrayList = d10.createTypedArrayList(e.CREATOR);
        d10.recycle();
        return createTypedArrayList;
    }

    @Override // e1.i0
    public final void p(c5 c5Var) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        H(G, 4);
    }

    @Override // e1.i0
    public final void r(c5 c5Var) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        H(G, 6);
    }

    @Override // e1.i0
    public final void s(c5 c5Var) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        H(G, 26);
    }

    @Override // e1.i0
    public final void u(c5 c5Var, d dVar) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        com.google.android.gms.internal.measurement.z.b(G, dVar);
        H(G, 30);
    }

    @Override // e1.i0
    public final void v(u uVar, c5 c5Var) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, uVar);
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        H(G, 1);
    }

    @Override // e1.i0
    public final void w(e eVar, c5 c5Var) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, eVar);
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        H(G, 12);
    }

    @Override // e1.i0
    public final List y(String str, String str2, c5 c5Var) {
        Parcel G = G();
        G.writeString(str);
        G.writeString(str2);
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        Parcel d10 = d(G, 16);
        ArrayList createTypedArrayList = d10.createTypedArrayList(e.CREATOR);
        d10.recycle();
        return createTypedArrayList;
    }

    @Override // e1.i0
    public final String z(c5 c5Var) {
        Parcel G = G();
        com.google.android.gms.internal.measurement.z.b(G, c5Var);
        Parcel d10 = d(G, 11);
        String readString = d10.readString();
        d10.recycle();
        return readString;
    }
}
