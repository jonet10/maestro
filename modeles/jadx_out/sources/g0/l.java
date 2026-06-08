package g0;

import android.os.Bundle;
import android.util.Log;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final int f5092a;

    /* renamed from: b, reason: collision with root package name */
    public final j1.i f5093b = new j1.i();

    /* renamed from: c, reason: collision with root package name */
    public final int f5094c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f5095d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f5096e;

    public l(int i, int i6, Bundle bundle, int i10) {
        this.f5096e = i10;
        this.f5092a = i;
        this.f5094c = i6;
        this.f5095d = bundle;
    }

    public final boolean a() {
        switch (this.f5096e) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    public final void b(m mVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Failing " + toString() + " with " + mVar.toString());
        }
        this.f5093b.f6539a.m(mVar);
    }

    public final void c(Bundle bundle) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", "Finishing " + toString() + " with " + String.valueOf(bundle));
        }
        this.f5093b.a(bundle);
    }

    public final String toString() {
        return "Request { what=" + this.f5094c + " id=" + this.f5092a + " oneWay=" + a() + "}";
    }
}
