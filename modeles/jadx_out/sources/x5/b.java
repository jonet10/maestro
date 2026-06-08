package x5;

import a4.x;
import android.os.Parcel;
import android.os.Parcelable;
import c.j;
import com.google.android.gms.internal.measurement.i5;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b implements Parcelable {
    public static final a CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f11492a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11493b;

    /* renamed from: l, reason: collision with root package name */
    public final String f11494l;

    /* renamed from: m, reason: collision with root package name */
    public final String f11495m;

    /* renamed from: n, reason: collision with root package name */
    public final String f11496n;

    /* renamed from: o, reason: collision with root package name */
    public final String f11497o;

    /* renamed from: p, reason: collision with root package name */
    public final String f11498p;

    /* renamed from: q, reason: collision with root package name */
    public final String f11499q;

    /* renamed from: r, reason: collision with root package name */
    public final String f11500r;

    /* renamed from: s, reason: collision with root package name */
    public final String f11501s;

    /* renamed from: t, reason: collision with root package name */
    public final String f11502t;

    /* renamed from: u, reason: collision with root package name */
    public final String f11503u;
    public final int v;

    /* renamed from: w, reason: collision with root package name */
    public final int f11504w;

    /* renamed from: x, reason: collision with root package name */
    public final String f11505x;

    /* renamed from: y, reason: collision with root package name */
    public final String f11506y;

    /* renamed from: z, reason: collision with root package name */
    public final String f11507z;

    public /* synthetic */ b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i, int i6, String str13, String str14, String str15, int i10) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4, (i10 & 16) != 0 ? "" : str5, (i10 & 32) != 0 ? "" : str6, (i10 & 64) != 0 ? "" : str7, (i10 & 128) != 0 ? "" : str8, (i10 & 256) != 0 ? "" : str9, (i10 & 512) != 0 ? "" : str10, (i10 & 1024) != 0 ? "" : str11, (i10 & 2048) != 0 ? "" : str12, (i10 & 4096) != 0 ? 0 : i, (i10 & 8192) != 0 ? 1 : i6, (i10 & 16384) != 0 ? "" : str13, (i10 & 32768) != 0 ? "" : str14, (i10 & 65536) != 0 ? "" : str15);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return l.a(this.f11492a, bVar.f11492a) && l.a(this.f11493b, bVar.f11493b) && l.a(this.f11494l, bVar.f11494l) && l.a(this.f11495m, bVar.f11495m) && l.a(this.f11496n, bVar.f11496n) && l.a(this.f11497o, bVar.f11497o) && l.a(this.f11498p, bVar.f11498p) && l.a(this.f11499q, bVar.f11499q) && l.a(this.f11500r, bVar.f11500r) && l.a(this.f11501s, bVar.f11501s) && l.a(this.f11502t, bVar.f11502t) && l.a(this.f11503u, bVar.f11503u) && this.v == bVar.v && this.f11504w == bVar.f11504w && l.a(this.f11505x, bVar.f11505x) && l.a(this.f11506y, bVar.f11506y) && l.a(this.f11507z, bVar.f11507z);
    }

    public final int hashCode() {
        int hashCode = this.f11492a.hashCode() * 31;
        String str = this.f11493b;
        return this.f11507z.hashCode() + i5.b(i5.b((j.c(this.f11504w) + ((this.v + i5.b(i5.b(i5.b(i5.b(i5.b(i5.b(i5.b(i5.b(i5.b(i5.b((hashCode + (str == null ? 0 : str.hashCode())) * 31, this.f11494l), this.f11495m), this.f11496n), this.f11497o), this.f11498p), this.f11499q), this.f11500r), this.f11501s), this.f11502t), this.f11503u)) * 31)) * 31, this.f11505x), this.f11506y);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PartnersDetailDialogArgs(name=");
        sb.append(this.f11492a);
        sb.append(", description=");
        sb.append((Object) this.f11493b);
        sb.append(", purposes=");
        sb.append(this.f11494l);
        sb.append(", legitimateInterests=");
        sb.append(this.f11495m);
        sb.append(", specialPurposes=");
        sb.append(this.f11496n);
        sb.append(", features=");
        sb.append(this.f11497o);
        sb.append(", specialFeatures=");
        sb.append(this.f11498p);
        sb.append(", dataDeclarations=");
        sb.append(this.f11499q);
        sb.append(", privacyPolicy=");
        sb.append(this.f11500r);
        sb.append(", cookieMaxAge=");
        sb.append(this.f11501s);
        sb.append(", usesNonCookieAccess=");
        sb.append(this.f11502t);
        sb.append(", dataRetention=");
        sb.append(this.f11503u);
        sb.append(", vendorId=");
        sb.append(this.v);
        sb.append(", switchItemType=");
        sb.append(j.d(this.f11504w));
        sb.append(", disclosuresUrl=");
        sb.append(this.f11505x);
        sb.append(", disclosuresErrorLabel=");
        sb.append(this.f11506y);
        sb.append(", legInterestPrivacyLink=");
        return x.m(sb, this.f11507z, ')');
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i6;
        parcel.getClass();
        parcel.writeString(this.f11492a);
        parcel.writeString(this.f11493b);
        parcel.writeString(this.f11494l);
        parcel.writeString(this.f11495m);
        parcel.writeString(this.f11496n);
        parcel.writeString(this.f11497o);
        parcel.writeString(this.f11498p);
        parcel.writeString(this.f11499q);
        parcel.writeString(this.f11500r);
        parcel.writeString(this.f11501s);
        parcel.writeString(this.f11502t);
        parcel.writeString(this.f11503u);
        parcel.writeInt(this.v);
        switch (this.f11504w) {
            case 1:
                i6 = 1;
                break;
            case 2:
                i6 = 2;
                break;
            case 3:
                i6 = 3;
                break;
            case 4:
                i6 = 4;
                break;
            case 5:
                i6 = 5;
                break;
            case 6:
                i6 = 6;
                break;
            case 7:
                i6 = 7;
                break;
            case 8:
                i6 = 8;
                break;
            case 9:
                i6 = 9;
                break;
            case 10:
                i6 = 10;
                break;
            case 11:
                i6 = 11;
                break;
            case 12:
                i6 = 12;
                break;
            default:
                throw null;
        }
        parcel.writeInt(i6);
        parcel.writeString(this.f11505x);
        parcel.writeString(this.f11506y);
        parcel.writeString(this.f11507z);
    }

    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, int i, int i6, String str13, String str14, String str15) {
        str.getClass();
        str3.getClass();
        str4.getClass();
        str5.getClass();
        str6.getClass();
        str7.getClass();
        str8.getClass();
        str9.getClass();
        str10.getClass();
        str11.getClass();
        str12.getClass();
        if (i6 == 0) {
            throw null;
        }
        str13.getClass();
        str14.getClass();
        str15.getClass();
        this.f11492a = str;
        this.f11493b = str2;
        this.f11494l = str3;
        this.f11495m = str4;
        this.f11496n = str5;
        this.f11497o = str6;
        this.f11498p = str7;
        this.f11499q = str8;
        this.f11500r = str9;
        this.f11501s = str10;
        this.f11502t = str11;
        this.f11503u = str12;
        this.v = i;
        this.f11504w = i6;
        this.f11505x = str13;
        this.f11506y = str14;
        this.f11507z = str15;
    }
}
