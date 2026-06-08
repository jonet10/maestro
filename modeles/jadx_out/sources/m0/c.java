package m0;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import g4.v;
import h0.d;
import j0.m;
import k0.h;
import k0.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends h {
    public final o I;

    public c(Context context, Looper looper, v vVar, o oVar, m mVar, m mVar2) {
        super(context, looper, SubsamplingScaleImageView.ORIENTATION_270, vVar, mVar, mVar2, 0);
        this.I = oVar;
    }

    @Override // k0.e
    public final int i() {
        return 203400000;
    }

    @Override // k0.e
    public final IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return queryLocalInterface instanceof a ? (a) queryLocalInterface : new a(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService", 2);
    }

    @Override // k0.e
    public final d[] q() {
        return x0.b.f11035b;
    }

    @Override // k0.e
    public final Bundle r() {
        o oVar = this.I;
        oVar.getClass();
        Bundle bundle = new Bundle();
        String str = oVar.f6916a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    @Override // k0.e
    public final String u() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // k0.e
    public final String v() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // k0.e
    public final boolean w() {
        return true;
    }
}
