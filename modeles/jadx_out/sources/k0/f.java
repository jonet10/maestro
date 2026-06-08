package k0;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends l0.a {

    @NonNull
    public static final Parcelable.Creator<f> CREATOR = new i0.l(7);

    /* renamed from: a, reason: collision with root package name */
    public final m f6855a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6856b;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f6857l;

    /* renamed from: m, reason: collision with root package name */
    public final int[] f6858m;

    /* renamed from: n, reason: collision with root package name */
    public final int f6859n;

    /* renamed from: o, reason: collision with root package name */
    public final int[] f6860o;

    public f(m mVar, boolean z9, boolean z10, int[] iArr, int i, int[] iArr2) {
        this.f6855a = mVar;
        this.f6856b = z9;
        this.f6857l = z10;
        this.f6858m = iArr;
        this.f6859n = i;
        this.f6860o = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.S(parcel, 1, this.f6855a, i);
        a.a.X(parcel, 2, 4);
        parcel.writeInt(this.f6856b ? 1 : 0);
        a.a.X(parcel, 3, 4);
        parcel.writeInt(this.f6857l ? 1 : 0);
        int[] iArr = this.f6858m;
        if (iArr != null) {
            int Y2 = a.a.Y(parcel, 4);
            parcel.writeIntArray(iArr);
            a.a.a0(parcel, Y2);
        }
        a.a.X(parcel, 5, 4);
        parcel.writeInt(this.f6859n);
        int[] iArr2 = this.f6860o;
        if (iArr2 != null) {
            int Y3 = a.a.Y(parcel, 6);
            parcel.writeIntArray(iArr2);
            a.a.a0(parcel, Y3);
        }
        a.a.a0(parcel, Y);
    }
}
