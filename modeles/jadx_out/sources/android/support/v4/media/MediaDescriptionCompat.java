package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new f(1);

    /* renamed from: a, reason: collision with root package name */
    public final String f226a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f227b;

    /* renamed from: l, reason: collision with root package name */
    public final CharSequence f228l;

    /* renamed from: m, reason: collision with root package name */
    public final CharSequence f229m;

    /* renamed from: n, reason: collision with root package name */
    public final Bitmap f230n;

    /* renamed from: o, reason: collision with root package name */
    public final Uri f231o;

    /* renamed from: p, reason: collision with root package name */
    public final Bundle f232p;

    /* renamed from: q, reason: collision with root package name */
    public final Uri f233q;

    /* renamed from: r, reason: collision with root package name */
    public Object f234r;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f226a = str;
        this.f227b = charSequence;
        this.f228l = charSequence2;
        this.f229m = charSequence3;
        this.f230n = bitmap;
        this.f231o = uri;
        this.f232p = bundle;
        this.f233q = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r14) {
        /*
            r0 = 0
            if (r14 == 0) goto L5a
            r1 = r14
            android.media.MediaDescription r1 = (android.media.MediaDescription) r1
            java.lang.String r3 = r1.getMediaId()
            java.lang.CharSequence r4 = r1.getTitle()
            java.lang.CharSequence r5 = r1.getSubtitle()
            java.lang.CharSequence r6 = r1.getDescription()
            android.graphics.Bitmap r7 = r1.getIconBitmap()
            android.net.Uri r8 = r1.getIconUri()
            android.os.Bundle r2 = r1.getExtras()
            java.lang.String r9 = "android.support.v4.media.description.MEDIA_URI"
            if (r2 == 0) goto L30
            android.support.v4.media.session.m.a(r2)
            android.os.Parcelable r10 = r2.getParcelable(r9)
            android.net.Uri r10 = (android.net.Uri) r10
            goto L31
        L30:
            r10 = r0
        L31:
            if (r10 == 0) goto L4a
            java.lang.String r11 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r12 = r2.containsKey(r11)
            if (r12 == 0) goto L44
            int r12 = r2.size()
            r13 = 2
            if (r12 != r13) goto L44
            r9 = r0
            goto L4b
        L44:
            r2.remove(r9)
            r2.remove(r11)
        L4a:
            r9 = r2
        L4b:
            if (r10 == 0) goto L4e
            goto L52
        L4e:
            android.net.Uri r10 = r1.getMediaUri()
        L52:
            android.support.v4.media.MediaDescriptionCompat r2 = new android.support.v4.media.MediaDescriptionCompat
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r2.f234r = r14
            return r2
        L5a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.f227b) + ", " + ((Object) this.f228l) + ", " + ((Object) this.f229m);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Object obj = this.f234r;
        if (obj == null) {
            MediaDescription.Builder builder = new MediaDescription.Builder();
            builder.setMediaId(this.f226a);
            builder.setTitle(this.f227b);
            builder.setSubtitle(this.f228l);
            builder.setDescription(this.f229m);
            builder.setIconBitmap(this.f230n);
            builder.setIconUri(this.f231o);
            builder.setExtras(this.f232p);
            builder.setMediaUri(this.f233q);
            obj = builder.build();
            this.f234r = obj;
        }
        ((MediaDescription) obj).writeToParcel(parcel, i);
    }
}
