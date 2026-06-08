package x4;

import android.os.Parcel;
import android.os.Parcelable;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d3 implements Parcelable {
    public static Parcelable.Creator<d3> CREATOR = new i0.l(26);

    /* renamed from: a, reason: collision with root package name */
    public String f11119a;

    /* renamed from: b, reason: collision with root package name */
    public String f11120b;

    public final String a() {
        String str = this.f11120b;
        if (str == null) {
            return null;
        }
        float f = UptodownApp.I;
        return a4.x.k(str, UptodownApp.L, ":webp");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeString(this.f11119a);
        parcel.writeString(this.f11120b);
    }
}
