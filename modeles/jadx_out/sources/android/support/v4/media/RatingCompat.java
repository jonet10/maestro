package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new f(3);

    /* renamed from: a, reason: collision with root package name */
    public final int f236a;

    /* renamed from: b, reason: collision with root package name */
    public final float f237b;

    public RatingCompat(int i, float f) {
        this.f236a = i;
        this.f237b = f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return this.f236a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Rating:style=");
        sb.append(this.f236a);
        sb.append(" rating=");
        float f = this.f237b;
        sb.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f236a);
        parcel.writeFloat(this.f237b);
    }
}
