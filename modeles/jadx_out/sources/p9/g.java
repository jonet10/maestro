package p9;

import a4.x;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.i5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements Parcelable {
    public static final f CREATOR = new f();

    /* renamed from: a, reason: collision with root package name */
    public final String f8516a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8517b;

    /* renamed from: l, reason: collision with root package name */
    public final String f8518l;

    /* renamed from: m, reason: collision with root package name */
    public final String f8519m;

    /* renamed from: n, reason: collision with root package name */
    public final String f8520n;

    public g(String str, String str2, String str3, String str4, String str5) {
        str3.getClass();
        this.f8516a = str;
        this.f8517b = str2;
        this.f8518l = str3;
        this.f8519m = str4;
        this.f8520n = str5;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f8516a.equals(gVar.f8516a) && this.f8517b.equals(gVar.f8517b) && kotlin.jvm.internal.l.a(this.f8518l, gVar.f8518l) && this.f8519m.equals(gVar.f8519m) && this.f8520n.equals(gVar.f8520n);
    }

    public final int hashCode() {
        return this.f8520n.hashCode() + androidx.lifecycle.l.o(i5.b(androidx.lifecycle.l.o(this.f8516a.hashCode() * 31, 31, this.f8517b), this.f8518l), 31, this.f8519m);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DisclosureInfo(name=");
        sb.append(this.f8516a);
        sb.append(", type=");
        sb.append(this.f8517b);
        sb.append(", maxAge=");
        sb.append(this.f8518l);
        sb.append(", domain=");
        sb.append(this.f8519m);
        sb.append(", purposes=");
        return x.m(sb, this.f8520n, ')');
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.f8516a);
        parcel.writeString(this.f8517b);
        parcel.writeString(this.f8518l);
        parcel.writeString(this.f8519m);
        parcel.writeString(this.f8520n);
    }
}
