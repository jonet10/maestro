package w0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import j0.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class b extends Binder implements IInterface {
    public final /* synthetic */ int i;

    public b(String str, int i) {
        this.i = i;
        switch (i) {
            case 2:
                attachInterface(this, str);
                break;
            default:
                attachInterface(this, str);
                break;
        }
    }

    public abstract boolean G(int i, Parcel parcel, Parcel parcel2);

    public boolean H(int i, Parcel parcel, Parcel parcel2) {
        return false;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        int i = this.i;
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) {
        switch (this.i) {
            case 0:
                if (i <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i, parcel, parcel2, i6)) {
                    return true;
                }
                return G(i, parcel, parcel2);
            case 1:
                if (i <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i, parcel, parcel2, i6)) {
                    return true;
                }
                t tVar = (t) this;
                switch (i) {
                    case 3:
                        x0.a.b(parcel);
                        break;
                    case 4:
                        x0.a.b(parcel);
                        break;
                    case 5:
                    default:
                        return false;
                    case 6:
                        x0.a.b(parcel);
                        break;
                    case 7:
                        x0.a.b(parcel);
                        break;
                    case 8:
                        h1.e eVar = (h1.e) x0.a.a(parcel, h1.e.CREATOR);
                        x0.a.b(parcel);
                        tVar.f6527k.post(new m1.a(tVar, eVar, 21, false));
                        break;
                    case 9:
                        x0.a.b(parcel);
                        break;
                }
                parcel2.writeNoException();
                return true;
            default:
                if (i <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i, parcel, parcel2, i6)) {
                    return true;
                }
                return H(i, parcel, parcel2);
        }
    }
}
