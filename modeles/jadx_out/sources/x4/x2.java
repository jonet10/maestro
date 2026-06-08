package x4;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x2 implements Parcelable {
    public static Parcelable.Creator<x2> CREATOR = new i0.l(23);

    /* renamed from: a, reason: collision with root package name */
    public String f11453a;

    /* renamed from: b, reason: collision with root package name */
    public int f11454b;

    /* renamed from: l, reason: collision with root package name */
    public int f11455l;

    /* renamed from: m, reason: collision with root package name */
    public int f11456m;

    /* renamed from: n, reason: collision with root package name */
    public int f11457n;

    /* renamed from: o, reason: collision with root package name */
    public int f11458o;

    /* renamed from: p, reason: collision with root package name */
    public int f11459p;

    /* renamed from: q, reason: collision with root package name */
    public int f11460q;

    /* renamed from: r, reason: collision with root package name */
    public int f11461r;

    /* renamed from: s, reason: collision with root package name */
    public int f11462s;

    /* renamed from: t, reason: collision with root package name */
    public int f11463t;

    /* renamed from: u, reason: collision with root package name */
    public long f11464u;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.f11453a);
        parcel.writeInt(this.f11454b);
        parcel.writeInt(this.f11455l);
        parcel.writeInt(this.f11456m);
        parcel.writeInt(this.f11457n);
        parcel.writeInt(this.f11458o);
        parcel.writeInt(this.f11459p);
        parcel.writeInt(this.f11460q);
    }
}
