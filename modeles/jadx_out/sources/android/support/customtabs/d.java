package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.i5;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class d implements f {
    public IBinder i;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.i;
    }

    @Override // android.support.customtabs.f
    public final Bundle extraCommand(String str, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f220b);
            obtain.writeString(str);
            i5.Q(obtain, bundle, 0);
            this.i.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            return (Bundle) i5.e(obtain2, Bundle.CREATOR);
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean isEngagementSignalsApiAvailable(c cVar, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f220b);
            obtain.writeStrongInterface(cVar);
            i5.Q(obtain, bundle, 0);
            this.i.transact(13, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean mayLaunchUrl(c cVar, Uri uri, Bundle bundle, List list) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f220b);
            obtain.writeStrongInterface(cVar);
            i5.Q(obtain, uri, 0);
            i5.Q(obtain, bundle, 0);
            if (list == null) {
                obtain.writeInt(-1);
            } else {
                int size = list.size();
                obtain.writeInt(size);
                for (int i = 0; i < size; i++) {
                    i5.Q(obtain, (Parcelable) list.get(i), 0);
                }
            }
            this.i.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean newSession(c cVar) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f220b);
            obtain.writeStrongInterface(cVar);
            this.i.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean newSessionWithExtras(c cVar, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f220b);
            obtain.writeStrongInterface(cVar);
            i5.Q(obtain, bundle, 0);
            this.i.transact(10, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final int postMessage(c cVar, String str, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f220b);
            obtain.writeStrongInterface(cVar);
            obtain.writeString(str);
            i5.Q(obtain, bundle, 0);
            this.i.transact(8, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean receiveFile(c cVar, Uri uri, int i, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f220b);
            obtain.writeStrongInterface(cVar);
            i5.Q(obtain, uri, 0);
            obtain.writeInt(i);
            i5.Q(obtain, bundle, 0);
            this.i.transact(12, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean requestPostMessageChannel(c cVar, Uri uri) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f220b);
            obtain.writeStrongInterface(cVar);
            i5.Q(obtain, uri, 0);
            this.i.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean requestPostMessageChannelWithExtras(c cVar, Uri uri, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f220b);
            obtain.writeStrongInterface(cVar);
            i5.Q(obtain, uri, 0);
            i5.Q(obtain, bundle, 0);
            this.i.transact(11, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean setEngagementSignalsCallback(c cVar, IBinder iBinder, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f220b);
            obtain.writeStrongInterface(cVar);
            obtain.writeStrongBinder(iBinder);
            i5.Q(obtain, bundle, 0);
            this.i.transact(14, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean updateVisuals(c cVar, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f220b);
            obtain.writeStrongInterface(cVar);
            i5.Q(obtain, bundle, 0);
            this.i.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean validateRelationship(c cVar, int i, Uri uri, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f220b);
            obtain.writeStrongInterface(cVar);
            obtain.writeInt(i);
            i5.Q(obtain, uri, 0);
            i5.Q(obtain, bundle, 0);
            this.i.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.f
    public final boolean warmup(long j) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f220b);
            obtain.writeLong(j);
            this.i.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt() != 0;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
