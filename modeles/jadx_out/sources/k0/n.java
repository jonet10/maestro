package k0;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n extends l0.a {

    @NonNull
    public static final Parcelable.Creator<n> CREATOR = new i0.l(1);

    /* renamed from: a, reason: collision with root package name */
    public final int f6913a;

    /* renamed from: b, reason: collision with root package name */
    public List f6914b;

    public n(int i, List list) {
        this.f6913a = i;
        this.f6914b = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 4);
        parcel.writeInt(this.f6913a);
        a.a.V(parcel, 2, this.f6914b);
        a.a.a0(parcel, Y);
    }
}
