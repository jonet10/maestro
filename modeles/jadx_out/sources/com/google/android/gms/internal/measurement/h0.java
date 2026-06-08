package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h0 extends y implements m0 {
    public final AtomicReference i;
    public boolean j;

    public h0() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        this.i = new AtomicReference();
    }

    public static final Object d(Class cls, Bundle bundle) {
        Object obj;
        if (bundle == null || (obj = bundle.get("r")) == null) {
            return null;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e10) {
            Log.w("AM", "Unexpected object type. Expected, Received: " + cls.getCanonicalName() + ", " + obj.getClass().getCanonicalName(), e10);
            throw e10;
        }
    }

    @Override // com.google.android.gms.internal.measurement.y
    public final boolean a(int i, Parcel parcel, Parcel parcel2) {
        if (i != 1) {
            return false;
        }
        Bundle bundle = (Bundle) z.a(parcel, Bundle.CREATOR);
        z.d(parcel);
        t(bundle);
        parcel2.writeNoException();
        return true;
    }

    public final Bundle c(long j) {
        Bundle bundle;
        AtomicReference atomicReference = this.i;
        synchronized (atomicReference) {
            if (!this.j) {
                try {
                    atomicReference.wait(j);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = (Bundle) this.i.get();
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.measurement.m0
    public final void t(Bundle bundle) {
        AtomicReference atomicReference = this.i;
        synchronized (atomicReference) {
            try {
                try {
                    atomicReference.set(bundle);
                    this.j = true;
                } finally {
                    this.i.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
