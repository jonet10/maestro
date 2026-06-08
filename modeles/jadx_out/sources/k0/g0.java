package k0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g0 extends l0.a {
    public static final Parcelable.Creator<g0> CREATOR = new i0.l(6);

    /* renamed from: a, reason: collision with root package name */
    public Bundle f6876a;

    /* renamed from: b, reason: collision with root package name */
    public h0.d[] f6877b;

    /* renamed from: l, reason: collision with root package name */
    public int f6878l;

    /* renamed from: m, reason: collision with root package name */
    public f f6879m;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.Q(1, this.f6876a, parcel);
        a.a.U(parcel, 2, this.f6877b, i);
        int i6 = this.f6878l;
        a.a.X(parcel, 3, 4);
        parcel.writeInt(i6);
        a.a.S(parcel, 4, this.f6879m, i);
        a.a.a0(parcel, Y);
    }
}
