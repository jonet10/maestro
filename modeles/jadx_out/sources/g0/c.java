package g0;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5073a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f5073a) {
            case 0:
                int L = t0.f.L(parcel);
                Intent intent = null;
                while (parcel.dataPosition() < L) {
                    int readInt = parcel.readInt();
                    if (((char) readInt) != 1) {
                        t0.f.H(parcel, readInt);
                    } else {
                        intent = (Intent) t0.f.o(parcel, readInt, Intent.CREATOR);
                    }
                }
                t0.f.t(parcel, L);
                return new a(intent);
            default:
                return new g(parcel.readStrongBinder());
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.f5073a) {
            case 0:
                return new a[i];
            default:
                return new g[i];
        }
    }
}
