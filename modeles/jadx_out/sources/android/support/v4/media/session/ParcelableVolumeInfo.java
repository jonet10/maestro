package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new android.support.v4.media.f(7);

    /* renamed from: a, reason: collision with root package name */
    public int f259a;

    /* renamed from: b, reason: collision with root package name */
    public int f260b;

    /* renamed from: l, reason: collision with root package name */
    public int f261l;

    /* renamed from: m, reason: collision with root package name */
    public int f262m;

    /* renamed from: n, reason: collision with root package name */
    public int f263n;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f259a);
        parcel.writeInt(this.f261l);
        parcel.writeInt(this.f262m);
        parcel.writeInt(this.f263n);
        parcel.writeInt(this.f260b);
    }
}
