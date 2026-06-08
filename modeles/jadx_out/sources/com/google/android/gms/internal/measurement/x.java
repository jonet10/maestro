package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class x implements IInterface {
    public final /* synthetic */ int i;
    public final IBinder j;

    /* renamed from: k, reason: collision with root package name */
    public final String f2893k;

    public /* synthetic */ x(IBinder iBinder, String str, int i) {
        this.i = i;
        this.j = iBinder;
        this.f2893k = str;
    }

    public Parcel G() {
        switch (this.i) {
            case 0:
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(this.f2893k);
                return obtain;
            default:
                Parcel obtain2 = Parcel.obtain();
                obtain2.writeInterfaceToken(this.f2893k);
                return obtain2;
        }
    }

    public void H(Parcel parcel, int i) {
        Parcel obtain = Parcel.obtain();
        try {
            this.j.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    public void I(Parcel parcel) {
        try {
            this.j.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }

    public void a(Parcel parcel, int i) {
        Parcel obtain = Parcel.obtain();
        try {
            this.j.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        switch (this.i) {
        }
        return this.j;
    }

    public Parcel c(Parcel parcel, int i) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.j.transact(i, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e10) {
                obtain.recycle();
                throw e10;
            }
        } finally {
            parcel.recycle();
        }
    }

    public Parcel d(Parcel parcel, int i) {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.j.transact(i, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e10) {
                obtain.recycle();
                throw e10;
            }
        } finally {
            parcel.recycle();
        }
    }
}
