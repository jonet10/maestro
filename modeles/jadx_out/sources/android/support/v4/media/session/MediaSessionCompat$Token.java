package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MediaSessionCompat$Token implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new android.support.v4.media.f(6);

    /* renamed from: a, reason: collision with root package name */
    public final Object f257a;

    /* renamed from: b, reason: collision with root package name */
    public d f258b;

    public MediaSessionCompat$Token(Object obj, d dVar) {
        this.f257a = obj;
        this.f258b = dVar;
    }

    public static MediaSessionCompat$Token a(Parcelable parcelable, d dVar) {
        if (parcelable == null) {
            return null;
        }
        if (parcelable instanceof MediaSession.Token) {
            return new MediaSessionCompat$Token(parcelable, dVar);
        }
        com.google.gson.internal.a.p("token is not a valid MediaSession.Token object");
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionCompat$Token)) {
            return false;
        }
        Object obj2 = ((MediaSessionCompat$Token) obj).f257a;
        Object obj3 = this.f257a;
        if (obj3 == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f257a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable((Parcelable) this.f257a, i);
    }
}
