package h1;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.f;
import k0.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends l0.a {
    public static final Parcelable.Creator<e> CREATOR = new f(28);

    /* renamed from: a, reason: collision with root package name */
    public final int f5453a;

    /* renamed from: b, reason: collision with root package name */
    public final h0.b f5454b;

    /* renamed from: l, reason: collision with root package name */
    public final s f5455l;

    public e(int i, h0.b bVar, s sVar) {
        this.f5453a = i;
        this.f5454b = bVar;
        this.f5455l = sVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 4);
        parcel.writeInt(this.f5453a);
        a.a.S(parcel, 2, this.f5454b, i);
        a.a.S(parcel, 3, this.f5455l, i);
        a.a.a0(parcel, Y);
    }
}
