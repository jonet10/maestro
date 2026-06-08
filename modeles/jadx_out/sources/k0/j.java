package k0;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j extends l0.a {

    @NonNull
    public static final Parcelable.Creator<j> CREATOR = new i0.l(2);

    /* renamed from: a, reason: collision with root package name */
    public final int f6890a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6891b;

    /* renamed from: l, reason: collision with root package name */
    public final int f6892l;

    /* renamed from: m, reason: collision with root package name */
    public final long f6893m;

    /* renamed from: n, reason: collision with root package name */
    public final long f6894n;

    /* renamed from: o, reason: collision with root package name */
    public final String f6895o;

    /* renamed from: p, reason: collision with root package name */
    public final String f6896p;

    /* renamed from: q, reason: collision with root package name */
    public final int f6897q;

    /* renamed from: r, reason: collision with root package name */
    public final int f6898r;

    public j(int i, int i6, int i10, long j, long j6, String str, String str2, int i11, int i12) {
        this.f6890a = i;
        this.f6891b = i6;
        this.f6892l = i10;
        this.f6893m = j;
        this.f6894n = j6;
        this.f6895o = str;
        this.f6896p = str2;
        this.f6897q = i11;
        this.f6898r = i12;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 4);
        parcel.writeInt(this.f6890a);
        a.a.X(parcel, 2, 4);
        parcel.writeInt(this.f6891b);
        a.a.X(parcel, 3, 4);
        parcel.writeInt(this.f6892l);
        a.a.X(parcel, 4, 8);
        parcel.writeLong(this.f6893m);
        a.a.X(parcel, 5, 8);
        parcel.writeLong(this.f6894n);
        a.a.T(parcel, 6, this.f6895o);
        a.a.T(parcel, 7, this.f6896p);
        a.a.X(parcel, 8, 4);
        parcel.writeInt(this.f6897q);
        a.a.X(parcel, 9, 4);
        parcel.writeInt(this.f6898r);
        a.a.a0(parcel, Y);
    }
}
