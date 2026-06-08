package x4;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j0 implements Parcelable {
    public static Parcelable.Creator<j0> CREATOR = new i0.l(13);

    /* renamed from: m, reason: collision with root package name */
    public String f11236m;

    /* renamed from: o, reason: collision with root package name */
    public long f11238o;

    /* renamed from: p, reason: collision with root package name */
    public String f11239p;

    /* renamed from: q, reason: collision with root package name */
    public String f11240q;

    /* renamed from: r, reason: collision with root package name */
    public int f11241r;

    /* renamed from: s, reason: collision with root package name */
    public long f11242s;

    /* renamed from: a, reason: collision with root package name */
    public long f11233a = -1;

    /* renamed from: b, reason: collision with root package name */
    public long f11234b = -1;

    /* renamed from: l, reason: collision with root package name */
    public long f11235l = -1;

    /* renamed from: n, reason: collision with root package name */
    public long f11237n = -1;

    public final long a() {
        return this.f11237n;
    }

    public final void b(String str) {
        this.f11240q = str;
    }

    public final void c(long j) {
        this.f11238o = j;
    }

    public final void d(long j) {
        this.f11237n = j;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    public final String toString() {
        long j = this.f11233a;
        long j6 = this.f11234b;
        long j10 = this.f11235l;
        String str = this.f11236m;
        long j11 = this.f11237n;
        long j12 = this.f11238o;
        String str2 = this.f11239p;
        String str3 = this.f11240q;
        int i = this.f11241r;
        long j13 = this.f11242s;
        StringBuilder sb = new StringBuilder("{id='");
        sb.append(j);
        sb.append("', downloadId='");
        sb.append(j6);
        sb.append("', fileId='");
        sb.append(j10);
        sb.append("', type=");
        sb.append(str);
        sb.append(", sizeExpected='");
        sb.append(j11);
        sb.append("', sizeDownloaded='");
        sb.append(j12);
        sb.append("', filehashExpected='");
        a4.x.B(sb, str2, "', absolutePath='", str3, "', attempts=");
        sb.append(i);
        sb.append(", nextAttemptTimeStamp=");
        sb.append(j13);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeLong(this.f11233a);
        parcel.writeLong(this.f11234b);
        parcel.writeLong(this.f11235l);
        parcel.writeString(this.f11236m);
        parcel.writeLong(this.f11237n);
        parcel.writeLong(this.f11238o);
        parcel.writeString(this.f11239p);
        parcel.writeString(this.f11240q);
        parcel.writeInt(this.f11241r);
        parcel.writeLong(this.f11242s);
    }
}
