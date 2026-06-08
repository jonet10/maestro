package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class e extends Binder implements f {
    static final int TRANSACTION_areNotificationsEnabled = 6;
    static final int TRANSACTION_cancelNotification = 3;
    static final int TRANSACTION_extraCommand = 9;
    static final int TRANSACTION_getActiveNotifications = 5;
    static final int TRANSACTION_getSmallIconBitmap = 7;
    static final int TRANSACTION_getSmallIconId = 4;
    static final int TRANSACTION_notifyNotificationWithChannel = 2;

    public static f asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(f.f);
        if (queryLocalInterface != null && (queryLocalInterface instanceof f)) {
            return (f) queryLocalInterface;
        }
        d dVar = new d();
        dVar.i = iBinder;
        return dVar;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
        String str = f.f;
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        switch (i) {
            case 2:
                Parcelable.Creator creator = Bundle.CREATOR;
                Bundle notifyNotificationWithChannel = notifyNotificationWithChannel((Bundle) d0.b.g(parcel));
                parcel2.writeNoException();
                d0.b.h(1, notifyNotificationWithChannel, parcel2);
                return true;
            case 3:
                Parcelable.Creator creator2 = Bundle.CREATOR;
                cancelNotification((Bundle) d0.b.g(parcel));
                parcel2.writeNoException();
                return true;
            case 4:
                int smallIconId = getSmallIconId();
                parcel2.writeNoException();
                parcel2.writeInt(smallIconId);
                return true;
            case 5:
                Bundle activeNotifications = getActiveNotifications();
                parcel2.writeNoException();
                d0.b.h(1, activeNotifications, parcel2);
                return true;
            case 6:
                Parcelable.Creator creator3 = Bundle.CREATOR;
                Bundle areNotificationsEnabled = areNotificationsEnabled((Bundle) d0.b.g(parcel));
                parcel2.writeNoException();
                d0.b.h(1, areNotificationsEnabled, parcel2);
                return true;
            case 7:
                Bundle smallIconBitmap = getSmallIconBitmap();
                parcel2.writeNoException();
                d0.b.h(1, smallIconBitmap, parcel2);
                return true;
            case 8:
            default:
                return super.onTransact(i, parcel, parcel2, i6);
            case 9:
                String readString = parcel.readString();
                Parcelable.Creator creator4 = Bundle.CREATOR;
                Bundle extraCommand = extraCommand(readString, (Bundle) d0.b.g(parcel), parcel.readStrongBinder());
                parcel2.writeNoException();
                d0.b.h(1, extraCommand, parcel2);
                return true;
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
