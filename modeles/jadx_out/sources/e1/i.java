package e1;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i extends l0.a {
    public static final Parcelable.Creator<i> CREATOR = new android.support.v4.media.f(12);

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f4030a;

    public i(Bundle bundle) {
        this.f4030a = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.Q(1, this.f4030a, parcel);
        a.a.a0(parcel, Y);
    }
}
