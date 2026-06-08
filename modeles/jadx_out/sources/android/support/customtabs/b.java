package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.z3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class b extends Binder implements c {
    static final int TRANSACTION_extraCallback = 3;
    static final int TRANSACTION_extraCallbackWithResult = 7;
    static final int TRANSACTION_onActivityLayout = 10;
    static final int TRANSACTION_onActivityResized = 8;
    static final int TRANSACTION_onMessageChannelReady = 4;
    static final int TRANSACTION_onMinimized = 11;
    static final int TRANSACTION_onNavigationEvent = 2;
    static final int TRANSACTION_onPostMessage = 5;
    static final int TRANSACTION_onRelationshipValidationResult = 6;
    static final int TRANSACTION_onUnminimized = 12;
    static final int TRANSACTION_onWarmupCompleted = 9;

    public b() {
        attachInterface(this, c.f219a);
    }

    public static c asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(c.f219a);
        if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
            return (c) queryLocalInterface;
        }
        a aVar = new a();
        aVar.i = iBinder;
        return aVar;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
        String str = c.f219a;
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        switch (i) {
            case 2:
                onNavigationEvent(parcel.readInt(), (Bundle) z3.c(parcel, Bundle.CREATOR));
                return true;
            case 3:
                extraCallback(parcel.readString(), (Bundle) z3.c(parcel, Bundle.CREATOR));
                return true;
            case 4:
                onMessageChannelReady((Bundle) z3.c(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                onPostMessage(parcel.readString(), (Bundle) z3.c(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 6:
                onRelationshipValidationResult(parcel.readInt(), (Uri) z3.c(parcel, Uri.CREATOR), parcel.readInt() != 0, (Bundle) z3.c(parcel, Bundle.CREATOR));
                return true;
            case 7:
                Bundle extraCallbackWithResult = extraCallbackWithResult(parcel.readString(), (Bundle) z3.c(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                z3.d(parcel2, extraCallbackWithResult, 1);
                return true;
            case 8:
                onActivityResized(parcel.readInt(), parcel.readInt(), (Bundle) z3.c(parcel, Bundle.CREATOR));
                return true;
            case 9:
                onWarmupCompleted((Bundle) z3.c(parcel, Bundle.CREATOR));
                return true;
            case 10:
                onActivityLayout(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), (Bundle) z3.c(parcel, Bundle.CREATOR));
                return true;
            case 11:
                onMinimized((Bundle) z3.c(parcel, Bundle.CREATOR));
                return true;
            case 12:
                onUnminimized((Bundle) z3.c(parcel, Bundle.CREATOR));
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i6);
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }
}
