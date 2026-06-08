package t0;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i extends x {
    public final s0.a J(s0.b bVar, String str, int i) {
        Parcel G = G();
        z0.g.b(G, bVar);
        G.writeString(str);
        G.writeInt(i);
        Parcel c9 = c(G, 2);
        s0.a I = s0.b.I(c9.readStrongBinder());
        c9.recycle();
        return I;
    }

    public final s0.a K(s0.b bVar, String str, int i) {
        Parcel G = G();
        z0.g.b(G, bVar);
        G.writeString(str);
        G.writeInt(i);
        Parcel c9 = c(G, 4);
        s0.a I = s0.b.I(c9.readStrongBinder());
        c9.recycle();
        return I;
    }

    public final s0.a L(s0.b bVar, String str, boolean z9, long j) {
        Parcel G = G();
        z0.g.b(G, bVar);
        G.writeString(str);
        G.writeInt(z9 ? 1 : 0);
        G.writeLong(j);
        Parcel c9 = c(G, 7);
        s0.a I = s0.b.I(c9.readStrongBinder());
        c9.recycle();
        return I;
    }

    public final s0.a M(s0.b bVar, String str, int i, s0.b bVar2) {
        Parcel G = G();
        z0.g.b(G, bVar);
        G.writeString(str);
        G.writeInt(i);
        z0.g.b(G, bVar2);
        Parcel c9 = c(G, 8);
        s0.a I = s0.b.I(c9.readStrongBinder());
        c9.recycle();
        return I;
    }
}
