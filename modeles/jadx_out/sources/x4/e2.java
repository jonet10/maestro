package x4;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e2 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        parcel.getClass();
        f2 f2Var = new f2();
        f2Var.f11151a = parcel.readString();
        f2Var.f11153l = parcel.readInt();
        f2Var.f11154m = parcel.readInt();
        f2Var.f11155n = parcel.readString();
        ArrayList arrayList = f2Var.f11156o;
        if (arrayList == null || arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            f2Var.f11156o = arrayList2;
            parcel.readList(arrayList2, g1.class.getClassLoader());
        }
        f2Var.f11152b = parcel.readString();
        f2Var.f11157p = parcel.readString();
        return f2Var;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new f2[i];
    }
}
