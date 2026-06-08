package t0;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j extends x {
    public final s0.a J(s0.b bVar, String str, int i, s0.b bVar2) {
        Parcel G = G();
        z0.g.b(G, bVar);
        G.writeString(str);
        G.writeInt(i);
        z0.g.b(G, bVar2);
        Parcel c9 = c(G, 2);
        s0.a I = s0.b.I(c9.readStrongBinder());
        c9.recycle();
        return I;
    }

    public final s0.a K(s0.b bVar, String str, int i, s0.b bVar2) {
        Parcel G = G();
        z0.g.b(G, bVar);
        G.writeString(str);
        G.writeInt(i);
        z0.g.b(G, bVar2);
        Parcel c9 = c(G, 3);
        s0.a I = s0.b.I(c9.readStrongBinder());
        c9.recycle();
        return I;
    }
}
