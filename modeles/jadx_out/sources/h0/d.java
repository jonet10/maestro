package h0;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Arrays;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends l0.a {

    @NonNull
    public static final Parcelable.Creator<d> CREATOR = new android.support.v4.media.f(24);

    /* renamed from: a, reason: collision with root package name */
    public final String f5402a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5403b;

    /* renamed from: l, reason: collision with root package name */
    public final long f5404l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f5405m;

    public d(String str, int i, long j, boolean z9) {
        this.f5402a = str;
        this.f5403b = i;
        this.f5404l = j;
        this.f5405m = z9;
    }

    public final long c() {
        long j = this.f5404l;
        return j == -1 ? this.f5403b : j;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (y.j(this.f5402a, dVar.f5402a) && c() == dVar.c() && this.f5405m == dVar.f5405m) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5402a, Long.valueOf(c()), Boolean.valueOf(this.f5405m)});
    }

    public final String toString() {
        android.support.v4.media.g gVar = new android.support.v4.media.g(this);
        gVar.p(this.f5402a, "name");
        gVar.p(Long.valueOf(c()), "version");
        gVar.p(Boolean.valueOf(this.f5405m), "is_fully_rolled_out");
        return gVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.T(parcel, 1, this.f5402a);
        a.a.X(parcel, 2, 4);
        parcel.writeInt(this.f5403b);
        long c9 = c();
        a.a.X(parcel, 3, 8);
        parcel.writeLong(c9);
        a.a.X(parcel, 4, 4);
        parcel.writeInt(this.f5405m ? 1 : 0);
        a.a.a0(parcel, Y);
    }
}
