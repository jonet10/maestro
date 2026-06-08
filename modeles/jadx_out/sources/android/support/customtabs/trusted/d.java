package android.support.customtabs.trusted;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class d implements f {
    public IBinder i;

    @Override // android.support.customtabs.trusted.f
    public final Bundle areNotificationsEnabled(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f);
            d0.b.h(0, bundle, obtain);
            this.i.transact(6, obtain, obtain2, 0);
            obtain2.readException();
            Parcelable.Creator creator = Bundle.CREATOR;
            return (Bundle) d0.b.g(obtain2);
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.i;
    }

    @Override // android.support.customtabs.trusted.f
    public final void cancelNotification(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f);
            d0.b.h(0, bundle, obtain);
            this.i.transact(3, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.trusted.f
    public final Bundle extraCommand(String str, Bundle bundle, IBinder iBinder) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f);
            obtain.writeString(str);
            d0.b.h(0, bundle, obtain);
            obtain.writeStrongBinder(iBinder);
            this.i.transact(9, obtain, obtain2, 0);
            obtain2.readException();
            Parcelable.Creator creator = Bundle.CREATOR;
            return (Bundle) d0.b.g(obtain2);
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.trusted.f
    public final Bundle getActiveNotifications() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f);
            this.i.transact(5, obtain, obtain2, 0);
            obtain2.readException();
            Parcelable.Creator creator = Bundle.CREATOR;
            return (Bundle) d0.b.g(obtain2);
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.trusted.f
    public final Bundle getSmallIconBitmap() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f);
            this.i.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            Parcelable.Creator creator = Bundle.CREATOR;
            return (Bundle) d0.b.g(obtain2);
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.trusted.f
    public final int getSmallIconId() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f);
            this.i.transact(4, obtain, obtain2, 0);
            obtain2.readException();
            return obtain2.readInt();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.trusted.f
    public final Bundle notifyNotificationWithChannel(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(f.f);
            d0.b.h(0, bundle, obtain);
            this.i.transact(2, obtain, obtain2, 0);
            obtain2.readException();
            Parcelable.Creator creator = Bundle.CREATOR;
            return (Bundle) d0.b.g(obtain2);
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
