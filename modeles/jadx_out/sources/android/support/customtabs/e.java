package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.i5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class e extends Binder implements f {
    static final int TRANSACTION_extraCommand = 5;
    static final int TRANSACTION_isEngagementSignalsApiAvailable = 13;
    static final int TRANSACTION_mayLaunchUrl = 4;
    static final int TRANSACTION_newSession = 3;
    static final int TRANSACTION_newSessionWithExtras = 10;
    static final int TRANSACTION_postMessage = 8;
    static final int TRANSACTION_receiveFile = 12;
    static final int TRANSACTION_requestPostMessageChannel = 7;
    static final int TRANSACTION_requestPostMessageChannelWithExtras = 11;
    static final int TRANSACTION_setEngagementSignalsCallback = 14;
    static final int TRANSACTION_updateVisuals = 6;
    static final int TRANSACTION_validateRelationship = 9;
    static final int TRANSACTION_warmup = 2;

    public e() {
        attachInterface(this, f.f220b);
    }

    public static f asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface(f.f220b);
        if (queryLocalInterface != null && (queryLocalInterface instanceof f)) {
            return (f) queryLocalInterface;
        }
        d dVar = new d();
        dVar.i = iBinder;
        return dVar;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i6) throws RemoteException {
        String str = f.f220b;
        if (i >= 1 && i <= 16777215) {
            parcel.enforceInterface(str);
        }
        if (i == 1598968902) {
            parcel2.writeString(str);
            return true;
        }
        switch (i) {
            case 2:
                boolean warmup = warmup(parcel.readLong());
                parcel2.writeNoException();
                parcel2.writeInt(warmup ? 1 : 0);
                return true;
            case 3:
                boolean newSession = newSession(b.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                parcel2.writeInt(newSession ? 1 : 0);
                return true;
            case 4:
                c asInterface = b.asInterface(parcel.readStrongBinder());
                Uri uri = (Uri) i5.e(parcel, Uri.CREATOR);
                Parcelable.Creator creator = Bundle.CREATOR;
                boolean mayLaunchUrl = mayLaunchUrl(asInterface, uri, (Bundle) i5.e(parcel, creator), parcel.createTypedArrayList(creator));
                parcel2.writeNoException();
                parcel2.writeInt(mayLaunchUrl ? 1 : 0);
                return true;
            case 5:
                Bundle extraCommand = extraCommand(parcel.readString(), (Bundle) i5.e(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                i5.Q(parcel2, extraCommand, 1);
                return true;
            case 6:
                boolean updateVisuals = updateVisuals(b.asInterface(parcel.readStrongBinder()), (Bundle) i5.e(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(updateVisuals ? 1 : 0);
                return true;
            case 7:
                boolean requestPostMessageChannel = requestPostMessageChannel(b.asInterface(parcel.readStrongBinder()), (Uri) i5.e(parcel, Uri.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(requestPostMessageChannel ? 1 : 0);
                return true;
            case 8:
                int postMessage = postMessage(b.asInterface(parcel.readStrongBinder()), parcel.readString(), (Bundle) i5.e(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(postMessage);
                return true;
            case 9:
                boolean validateRelationship = validateRelationship(b.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Uri) i5.e(parcel, Uri.CREATOR), (Bundle) i5.e(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(validateRelationship ? 1 : 0);
                return true;
            case 10:
                boolean newSessionWithExtras = newSessionWithExtras(b.asInterface(parcel.readStrongBinder()), (Bundle) i5.e(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(newSessionWithExtras ? 1 : 0);
                return true;
            case 11:
                boolean requestPostMessageChannelWithExtras = requestPostMessageChannelWithExtras(b.asInterface(parcel.readStrongBinder()), (Uri) i5.e(parcel, Uri.CREATOR), (Bundle) i5.e(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(requestPostMessageChannelWithExtras ? 1 : 0);
                return true;
            case 12:
                boolean receiveFile = receiveFile(b.asInterface(parcel.readStrongBinder()), (Uri) i5.e(parcel, Uri.CREATOR), parcel.readInt(), (Bundle) i5.e(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(receiveFile ? 1 : 0);
                return true;
            case 13:
                boolean isEngagementSignalsApiAvailable = isEngagementSignalsApiAvailable(b.asInterface(parcel.readStrongBinder()), (Bundle) i5.e(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(isEngagementSignalsApiAvailable ? 1 : 0);
                return true;
            case 14:
                boolean engagementSignalsCallback = setEngagementSignalsCallback(b.asInterface(parcel.readStrongBinder()), parcel.readStrongBinder(), (Bundle) i5.e(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                parcel2.writeInt(engagementSignalsCallback ? 1 : 0);
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
