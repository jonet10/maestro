package x4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t1 implements Parcelable {
    public static Parcelable.Creator<t1> CREATOR = new i0.l(16);

    /* renamed from: a, reason: collision with root package name */
    public String f11396a;

    /* renamed from: b, reason: collision with root package name */
    public long f11397b;

    /* renamed from: l, reason: collision with root package name */
    public String f11398l;

    /* renamed from: m, reason: collision with root package name */
    public long f11399m;

    /* renamed from: n, reason: collision with root package name */
    public String f11400n;

    /* renamed from: o, reason: collision with root package name */
    public String f11401o;

    /* renamed from: p, reason: collision with root package name */
    public String f11402p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f11403q;

    /* renamed from: r, reason: collision with root package name */
    public ArrayList f11404r;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.f11396a);
        parcel.writeString(this.f11398l);
        parcel.writeLong(this.f11399m);
        parcel.writeString(this.f11400n);
        parcel.writeString(this.f11401o);
        parcel.writeString(this.f11402p);
        parcel.writeLong(this.f11397b);
    }
}
