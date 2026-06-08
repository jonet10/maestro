package android.support.v4.media.session;

import a4.x;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MediaSessionCompat$QueueItem implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new android.support.v4.media.f(4);

    /* renamed from: a, reason: collision with root package name */
    public final MediaDescriptionCompat f253a;

    /* renamed from: b, reason: collision with root package name */
    public final long f254b;

    /* renamed from: l, reason: collision with root package name */
    public final Object f255l;

    public MediaSessionCompat$QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
        if (mediaDescriptionCompat == null) {
            com.google.gson.internal.a.p("Description cannot be null.");
            throw null;
        }
        if (j == -1) {
            com.google.gson.internal.a.p("Id cannot be QueueItem.UNKNOWN_ID");
            throw null;
        }
        this.f253a = mediaDescriptionCompat;
        this.f254b = j;
        this.f255l = obj;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MediaSession.QueueItem {Description=");
        sb.append(this.f253a);
        sb.append(", Id=");
        return x.l(sb, this.f254b, " }");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        this.f253a.writeToParcel(parcel, i);
        parcel.writeLong(this.f254b);
    }

    public MediaSessionCompat$QueueItem(Parcel parcel) {
        this.f253a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        this.f254b = parcel.readLong();
    }
}
