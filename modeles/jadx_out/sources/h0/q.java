package h0;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.z3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q extends l0.a {
    public static final Parcelable.Creator<q> CREATOR = new android.support.v4.media.f(25);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5438a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5439b;

    /* renamed from: l, reason: collision with root package name */
    public final int f5440l;

    /* renamed from: m, reason: collision with root package name */
    public final int f5441m;

    /* renamed from: n, reason: collision with root package name */
    public final long f5442n;

    public q(boolean z9, String str, int i, int i6, long j) {
        this.f5438a = z9;
        this.f5439b = str;
        this.f5440l = i5.R(i) - 1;
        this.f5441m = z3.T(i6) - 1;
        this.f5442n = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 4);
        parcel.writeInt(this.f5438a ? 1 : 0);
        a.a.T(parcel, 2, this.f5439b);
        a.a.X(parcel, 3, 4);
        parcel.writeInt(this.f5440l);
        a.a.X(parcel, 4, 4);
        parcel.writeInt(this.f5441m);
        a.a.X(parcel, 5, 8);
        parcel.writeLong(this.f5442n);
        a.a.a0(parcel, Y);
    }
}
