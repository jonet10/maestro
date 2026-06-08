package x4;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b3 implements Parcelable {
    public static Parcelable.Creator<b3> CREATOR = new i0.l(25);

    /* renamed from: a, reason: collision with root package name */
    public long f11065a;

    /* renamed from: b, reason: collision with root package name */
    public String f11066b;

    /* renamed from: l, reason: collision with root package name */
    public int f11067l;

    /* renamed from: m, reason: collision with root package name */
    public int f11068m;

    /* renamed from: n, reason: collision with root package name */
    public int f11069n;

    /* renamed from: o, reason: collision with root package name */
    public int f11070o;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeLong(this.f11065a);
        parcel.writeString(this.f11066b);
        parcel.writeInt(this.f11068m);
        parcel.writeInt(this.f11069n);
        parcel.writeInt(this.f11067l);
        parcel.writeInt(this.f11070o);
    }
}
