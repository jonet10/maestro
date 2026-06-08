package g0;

import android.os.IBinder;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new c(1);

    /* renamed from: a, reason: collision with root package name */
    public final Messenger f5079a;

    public g(IBinder iBinder) {
        this.f5079a = new Messenger(iBinder);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Messenger messenger = this.f5079a;
            messenger.getClass();
            IBinder binder = messenger.getBinder();
            Messenger messenger2 = ((g) obj).f5079a;
            messenger2.getClass();
            return binder.equals(messenger2.getBinder());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        Messenger messenger = this.f5079a;
        messenger.getClass();
        return messenger.getBinder().hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.f5079a;
        messenger.getClass();
        parcel.writeStrongBinder(messenger.getBinder());
    }
}
