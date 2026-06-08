package e1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o4 extends l0.a {
    public static final Parcelable.Creator<o4> CREATOR = new android.support.v4.media.f(18);

    /* renamed from: a, reason: collision with root package name */
    public final List f4180a;

    public o4(ArrayList arrayList) {
        this.f4180a = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.V(parcel, 1, this.f4180a);
        a.a.a0(parcel, Y);
    }
}
