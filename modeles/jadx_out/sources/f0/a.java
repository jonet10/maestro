package f0;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends l0.a {

    @NonNull
    public static final Parcelable.Creator<a> CREATOR = new android.support.v4.media.f(21);

    /* renamed from: a, reason: collision with root package name */
    public final int f4794a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4795b;

    /* renamed from: l, reason: collision with root package name */
    public final Bundle f4796l;

    public a(int i, int i6, Bundle bundle) {
        this.f4794a = i;
        this.f4795b = i6;
        this.f4796l = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 4);
        parcel.writeInt(this.f4794a);
        a.a.X(parcel, 2, 4);
        parcel.writeInt(this.f4795b);
        a.a.Q(3, this.f4796l, parcel);
        a.a.a0(parcel, Y);
    }
}
