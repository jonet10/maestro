package android.support.v4.media.session;

import a4.x;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new android.support.v4.media.f(8);

    /* renamed from: a, reason: collision with root package name */
    public final int f264a;

    /* renamed from: b, reason: collision with root package name */
    public final long f265b;

    /* renamed from: l, reason: collision with root package name */
    public final long f266l;

    /* renamed from: m, reason: collision with root package name */
    public final float f267m;

    /* renamed from: n, reason: collision with root package name */
    public final long f268n;

    /* renamed from: o, reason: collision with root package name */
    public final int f269o;

    /* renamed from: p, reason: collision with root package name */
    public final CharSequence f270p;

    /* renamed from: q, reason: collision with root package name */
    public final long f271q;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f272r;

    /* renamed from: s, reason: collision with root package name */
    public final long f273s;

    /* renamed from: t, reason: collision with root package name */
    public final Bundle f274t;

    public PlaybackStateCompat(Parcel parcel) {
        this.f264a = parcel.readInt();
        this.f265b = parcel.readLong();
        this.f267m = parcel.readFloat();
        this.f271q = parcel.readLong();
        this.f266l = parcel.readLong();
        this.f268n = parcel.readLong();
        this.f270p = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f272r = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f273s = parcel.readLong();
        this.f274t = parcel.readBundle(m.class.getClassLoader());
        this.f269o = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {state=");
        sb.append(this.f264a);
        sb.append(", position=");
        sb.append(this.f265b);
        sb.append(", buffered position=");
        sb.append(this.f266l);
        sb.append(", speed=");
        sb.append(this.f267m);
        sb.append(", updated=");
        sb.append(this.f271q);
        sb.append(", actions=");
        sb.append(this.f268n);
        sb.append(", error code=");
        sb.append(this.f269o);
        sb.append(", error message=");
        sb.append(this.f270p);
        sb.append(", custom actions=");
        sb.append(this.f272r);
        sb.append(", active item id=");
        return x.l(sb, this.f273s, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f264a);
        parcel.writeLong(this.f265b);
        parcel.writeFloat(this.f267m);
        parcel.writeLong(this.f271q);
        parcel.writeLong(this.f266l);
        parcel.writeLong(this.f268n);
        TextUtils.writeToParcel(this.f270p, parcel, i);
        parcel.writeTypedList(this.f272r);
        parcel.writeLong(this.f273s);
        parcel.writeBundle(this.f274t);
        parcel.writeInt(this.f269o);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new n();

        /* renamed from: a, reason: collision with root package name */
        public final String f275a;

        /* renamed from: b, reason: collision with root package name */
        public final CharSequence f276b;

        /* renamed from: l, reason: collision with root package name */
        public final int f277l;

        /* renamed from: m, reason: collision with root package name */
        public final Bundle f278m;

        /* renamed from: n, reason: collision with root package name */
        public Object f279n;

        public CustomAction(Parcel parcel) {
            this.f275a = parcel.readString();
            this.f276b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f277l = parcel.readInt();
            this.f278m = parcel.readBundle(m.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.f276b) + ", mIcon=" + this.f277l + ", mExtras=" + this.f278m;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f275a);
            TextUtils.writeToParcel(this.f276b, parcel, i);
            parcel.writeInt(this.f277l);
            parcel.writeBundle(this.f278m);
        }

        public CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f275a = str;
            this.f276b = charSequence;
            this.f277l = i;
            this.f278m = bundle;
        }
    }

    public PlaybackStateCompat(int i, long j, long j6, float f, long j10, CharSequence charSequence, long j11, ArrayList arrayList, long j12, Bundle bundle) {
        this.f264a = i;
        this.f265b = j;
        this.f266l = j6;
        this.f267m = f;
        this.f268n = j10;
        this.f269o = 0;
        this.f270p = charSequence;
        this.f271q = j11;
        this.f272r = new ArrayList(arrayList);
        this.f273s = j12;
        this.f274t = bundle;
    }
}
