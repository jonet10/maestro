package k0;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m extends l0.a {

    @NonNull
    public static final Parcelable.Creator<m> CREATOR = new i0.l(5);

    /* renamed from: a, reason: collision with root package name */
    public final int f6908a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6909b;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f6910l;

    /* renamed from: m, reason: collision with root package name */
    public final int f6911m;

    /* renamed from: n, reason: collision with root package name */
    public final int f6912n;

    public m(int i, int i6, int i10, boolean z9, boolean z10) {
        this.f6908a = i;
        this.f6909b = z9;
        this.f6910l = z10;
        this.f6911m = i6;
        this.f6912n = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 4);
        parcel.writeInt(this.f6908a);
        a.a.X(parcel, 2, 4);
        parcel.writeInt(this.f6909b ? 1 : 0);
        a.a.X(parcel, 3, 4);
        parcel.writeInt(this.f6910l ? 1 : 0);
        a.a.X(parcel, 4, 4);
        parcel.writeInt(this.f6911m);
        a.a.X(parcel, 5, 4);
        parcel.writeInt(this.f6912n);
        a.a.a0(parcel, Y);
    }
}
