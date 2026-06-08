package x4;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d1 implements Parcelable {
    public static Parcelable.Creator<d1> CREATOR = new i0.l(15);
    public long A;
    public long B;
    public String C;
    public String D;
    public String E;
    public String F;
    public int G;

    /* renamed from: a, reason: collision with root package name */
    public long f11091a;

    /* renamed from: b, reason: collision with root package name */
    public String f11092b;

    /* renamed from: l, reason: collision with root package name */
    public long f11093l;

    /* renamed from: m, reason: collision with root package name */
    public String f11094m;

    /* renamed from: n, reason: collision with root package name */
    public int f11095n;

    /* renamed from: o, reason: collision with root package name */
    public String f11096o;

    /* renamed from: p, reason: collision with root package name */
    public int f11097p;

    /* renamed from: q, reason: collision with root package name */
    public String f11098q;

    /* renamed from: r, reason: collision with root package name */
    public String f11099r;

    /* renamed from: s, reason: collision with root package name */
    public String f11100s;

    /* renamed from: t, reason: collision with root package name */
    public long f11101t;

    /* renamed from: u, reason: collision with root package name */
    public String f11102u;
    public int v;

    /* renamed from: w, reason: collision with root package name */
    public String f11103w;

    /* renamed from: x, reason: collision with root package name */
    public long f11104x;

    /* renamed from: y, reason: collision with root package name */
    public String f11105y;

    /* renamed from: z, reason: collision with root package name */
    public String f11106z;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeLong(this.f11091a);
        parcel.writeString(this.f11092b);
        parcel.writeLong(this.f11093l);
        parcel.writeString(this.f11094m);
        parcel.writeInt(this.f11095n);
        parcel.writeString(this.f11096o);
        parcel.writeInt(this.f11097p);
        parcel.writeString(this.f11098q);
        parcel.writeString(this.f11099r);
        parcel.writeString(this.f11100s);
        parcel.writeLong(this.f11101t);
        parcel.writeString(this.f11102u);
        parcel.writeInt(this.v);
        parcel.writeString(this.f11103w);
        parcel.writeLong(this.f11104x);
        parcel.writeString(this.f11105y);
        parcel.writeString(this.f11106z);
        parcel.writeLong(this.A);
        parcel.writeLong(this.B);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeInt(this.G);
    }
}
