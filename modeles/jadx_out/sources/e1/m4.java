package e1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m4 extends l0.a {
    public static final Parcelable.Creator<m4> CREATOR = new android.support.v4.media.f(16);

    /* renamed from: a, reason: collision with root package name */
    public final long f4130a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f4131b;

    /* renamed from: l, reason: collision with root package name */
    public final String f4132l;

    /* renamed from: m, reason: collision with root package name */
    public final Bundle f4133m;

    /* renamed from: n, reason: collision with root package name */
    public final int f4134n;

    /* renamed from: o, reason: collision with root package name */
    public final long f4135o;

    /* renamed from: p, reason: collision with root package name */
    public String f4136p;

    public m4(long j, byte[] bArr, String str, Bundle bundle, int i, long j6, String str2) {
        this.f4130a = j;
        this.f4131b = bArr;
        this.f4132l = str;
        this.f4133m = bundle;
        this.f4134n = i;
        this.f4135o = j6;
        this.f4136p = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 8);
        parcel.writeLong(this.f4130a);
        byte[] bArr = this.f4131b;
        if (bArr != null) {
            int Y2 = a.a.Y(parcel, 2);
            parcel.writeByteArray(bArr);
            a.a.a0(parcel, Y2);
        }
        a.a.T(parcel, 3, this.f4132l);
        a.a.Q(4, this.f4133m, parcel);
        a.a.X(parcel, 5, 4);
        parcel.writeInt(this.f4134n);
        a.a.X(parcel, 6, 8);
        parcel.writeLong(this.f4135o);
        a.a.T(parcel, 7, this.f4136p);
        a.a.a0(parcel, Y);
    }
}
