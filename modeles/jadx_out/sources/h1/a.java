package h1;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import g4.v;
import i0.f;
import k0.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends h {
    public final boolean I;
    public final v J;
    public final Bundle K;
    public final Integer L;

    public a(Context context, Looper looper, v vVar, Bundle bundle, i0.e eVar, f fVar) {
        super(context, looper, 44, vVar, eVar, fVar, 0);
        this.I = true;
        this.J = vVar;
        this.K = bundle;
        this.L = (Integer) vVar.f5280p;
    }

    @Override // k0.e
    public final int i() {
        return 12451000;
    }

    @Override // k0.e, i0.b
    public final boolean l() {
        return this.I;
    }

    @Override // k0.e
    public final IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof c ? (c) queryLocalInterface : new c(iBinder, "com.google.android.gms.signin.internal.ISignInService", 2);
    }

    @Override // k0.e
    public final Bundle r() {
        v vVar = this.J;
        boolean equals = this.f6841l.getPackageName().equals((String) vVar.f5277m);
        Bundle bundle = this.K;
        if (!equals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", (String) vVar.f5277m);
        }
        return bundle;
    }

    @Override // k0.e
    public final String u() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // k0.e
    public final String v() {
        return "com.google.android.gms.signin.service.START";
    }
}
