package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class MediaBrowserCompat$MediaItem implements Parcelable {
    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new f(0);

    /* renamed from: a, reason: collision with root package name */
    public final int f224a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaDescriptionCompat f225b;

    public MediaBrowserCompat$MediaItem(Parcel parcel) {
        this.f224a = parcel.readInt();
        this.f225b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "MediaItem{mFlags=" + this.f224a + ", mDescription=" + this.f225b + '}';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f224a);
        this.f225b.writeToParcel(parcel, i);
    }
}
