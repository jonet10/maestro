package android.support.customtabs;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.z3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class a implements c {
    public IBinder i;

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.i;
    }

    @Override // android.support.customtabs.c
    public final void extraCallback(String str, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(c.f219a);
            obtain.writeString(str);
            z3.d(obtain, bundle, 0);
            this.i.transact(3, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final Bundle extraCallbackWithResult(String str, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(c.f219a);
            obtain.writeString(str);
            z3.d(obtain, bundle, 0);
            this.i.transact(7, obtain, obtain2, 0);
            obtain2.readException();
            return (Bundle) z3.c(obtain2, Bundle.CREATOR);
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onActivityLayout(int i, int i6, int i10, int i11, int i12, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(c.f219a);
            obtain.writeInt(i);
            obtain.writeInt(i6);
            obtain.writeInt(i10);
            obtain.writeInt(i11);
            obtain.writeInt(i12);
            z3.d(obtain, bundle, 0);
            this.i.transact(10, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onActivityResized(int i, int i6, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(c.f219a);
            obtain.writeInt(i);
            obtain.writeInt(i6);
            z3.d(obtain, bundle, 0);
            this.i.transact(8, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onMessageChannelReady(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(c.f219a);
            z3.d(obtain, bundle, 0);
            this.i.transact(4, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onMinimized(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(c.f219a);
            z3.d(obtain, bundle, 0);
            this.i.transact(11, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onNavigationEvent(int i, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(c.f219a);
            obtain.writeInt(i);
            z3.d(obtain, bundle, 0);
            this.i.transact(2, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onPostMessage(String str, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(c.f219a);
            obtain.writeString(str);
            z3.d(obtain, bundle, 0);
            this.i.transact(5, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onRelationshipValidationResult(int i, Uri uri, boolean z9, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(c.f219a);
            obtain.writeInt(i);
            z3.d(obtain, uri, 0);
            obtain.writeInt(z9 ? 1 : 0);
            z3.d(obtain, bundle, 0);
            this.i.transact(6, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onUnminimized(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(c.f219a);
            z3.d(obtain, bundle, 0);
            this.i.transact(12, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.support.customtabs.c
    public final void onWarmupCompleted(Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(c.f219a);
            z3.d(obtain, bundle, 0);
            this.i.transact(9, obtain, null, 1);
        } finally {
            obtain.recycle();
        }
    }
}
