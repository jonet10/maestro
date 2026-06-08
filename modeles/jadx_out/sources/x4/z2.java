package x4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z2 implements Parcelable {
    public static Parcelable.Creator<z2> CREATOR = new i0.l(24);

    /* renamed from: a, reason: collision with root package name */
    public long f11481a;

    /* renamed from: b, reason: collision with root package name */
    public String f11482b;

    /* renamed from: l, reason: collision with root package name */
    public String f11483l;

    /* renamed from: m, reason: collision with root package name */
    public String f11484m;

    /* renamed from: n, reason: collision with root package name */
    public String f11485n;

    /* renamed from: o, reason: collision with root package name */
    public int f11486o;

    /* renamed from: p, reason: collision with root package name */
    public String f11487p;

    /* renamed from: q, reason: collision with root package name */
    public long f11488q;

    /* renamed from: r, reason: collision with root package name */
    public int f11489r;

    /* renamed from: s, reason: collision with root package name */
    public final ArrayList f11490s = new ArrayList();

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList f11491t = new ArrayList();

    public z2(Parcel parcel) {
        this.f11481a = parcel.readLong();
        this.f11482b = parcel.readString();
        this.f11483l = parcel.readString();
        this.f11484m = parcel.readString();
        this.f11485n = parcel.readString();
        this.f11486o = parcel.readInt();
        this.f11487p = parcel.readString();
        this.f11488q = parcel.readLong();
        this.f11489r = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeLong(this.f11481a);
        parcel.writeString(this.f11482b);
        parcel.writeString(this.f11483l);
        parcel.writeString(this.f11484m);
        parcel.writeString(this.f11485n);
        parcel.writeInt(this.f11486o);
        parcel.writeString(this.f11487p);
        parcel.writeLong(this.f11488q);
        parcel.writeInt(this.f11489r);
    }

    public z2() {
    }
}
