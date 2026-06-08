package x4;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        parcel.getClass();
        g1 g1Var = new g1();
        g1Var.f11199a = parcel.readString();
        g1Var.f11200b = parcel.readString();
        g1Var.f11201l = parcel.readInt();
        g1Var.f11202m = parcel.readInt();
        return g1Var;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new g1[i];
    }
}
