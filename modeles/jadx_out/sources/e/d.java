package e;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new f(9);

    /* renamed from: a, reason: collision with root package name */
    public b f3727a;

    public final void b(int i, Bundle bundle) {
        b bVar = this.f3727a;
        if (bVar != null) {
            try {
                bVar.F(i, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            try {
                if (this.f3727a == null) {
                    this.f3727a = new c(this);
                }
                parcel.writeStrongBinder(this.f3727a.asBinder());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i, Bundle bundle) {
    }
}
