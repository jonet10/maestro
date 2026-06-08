package h1;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.f;
import com.google.android.gms.common.api.Status;
import i0.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends l0.a implements i {
    public static final Parcelable.Creator<d> CREATOR = new f(27);

    /* renamed from: a, reason: collision with root package name */
    public final List f5451a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5452b;

    public d(String str, ArrayList arrayList) {
        this.f5451a = arrayList;
        this.f5452b = str;
    }

    @Override // i0.i
    public final Status b() {
        return this.f5452b != null ? Status.f2469n : Status.f2473r;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        List<String> list = this.f5451a;
        if (list != null) {
            int Y2 = a.a.Y(parcel, 1);
            parcel.writeStringList(list);
            a.a.a0(parcel, Y2);
        }
        a.a.T(parcel, 2, this.f5452b);
        a.a.a0(parcel, Y);
    }
}
