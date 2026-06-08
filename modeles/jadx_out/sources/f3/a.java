package f3;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.i5;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements o {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f4832a;

    public a(Context context) {
        context.getClass();
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        this.f4832a = bundle == null ? Bundle.EMPTY : bundle;
    }

    @Override // f3.o
    public final Boolean a() {
        Bundle bundle = this.f4832a;
        if (bundle.containsKey("firebase_sessions_enabled")) {
            return Boolean.valueOf(bundle.getBoolean("firebase_sessions_enabled"));
        }
        return null;
    }

    @Override // f3.o
    public final m7.a b() {
        Bundle bundle = this.f4832a;
        if (bundle.containsKey("firebase_sessions_sessions_restart_timeout")) {
            return new m7.a(i5.N(bundle.getInt("firebase_sessions_sessions_restart_timeout"), m7.c.SECONDS));
        }
        return null;
    }

    @Override // f3.o
    public final Object c(t6.c cVar) {
        return x.f8463a;
    }

    @Override // f3.o
    public final Double d() {
        Bundle bundle = this.f4832a;
        if (bundle.containsKey("firebase_sessions_sampling_rate")) {
            return Double.valueOf(bundle.getDouble("firebase_sessions_sampling_rate"));
        }
        return null;
    }
}
