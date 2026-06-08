package e1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n4 extends l0.a {
    public static final Parcelable.Creator<n4> CREATOR = new android.support.v4.media.f(17);

    /* renamed from: a, reason: collision with root package name */
    public final List f4166a;

    public n4(ArrayList arrayList) {
        this.f4166a = arrayList;
    }

    public static n4 c(i3... i3VarArr) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Integer.valueOf(i3VarArr[0].f4046a));
        return new n4(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        List list = this.f4166a;
        if (list != null) {
            int Y2 = a.a.Y(parcel, 1);
            int size = list.size();
            parcel.writeInt(size);
            for (int i6 = 0; i6 < size; i6++) {
                parcel.writeInt(((Integer) list.get(i6)).intValue());
            }
            a.a.a0(parcel, Y2);
        }
        a.a.a0(parcel, Y);
    }
}
