package g0;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import b2.t1;
import j1.p;
import java.io.IOException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class d implements j1.a, j1.h {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ d f5074b = new d(0);

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ d f5075l = new d(1);

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ d f5076m = new d(2);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5077a;

    public /* synthetic */ d(int i) {
        this.f5077a = i;
    }

    @Override // j1.a
    public Object g(p pVar) {
        switch (this.f5077a) {
            case 0:
                if (pVar.i()) {
                    return (Bundle) pVar.g();
                }
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Error making request: ".concat(String.valueOf(pVar.f())));
                }
                throw new IOException("SERVICE_NOT_AVAILABLE", pVar.f());
            default:
                Intent intent = (Intent) ((Bundle) pVar.g()).getParcelable("notification_data");
                if (intent != null) {
                    return new a(intent);
                }
                return null;
        }
    }

    @Override // j1.h
    public p q(Object obj) {
        Bundle bundle = (Bundle) obj;
        int i = b.h;
        return (bundle == null || !bundle.containsKey("google.messenger")) ? t1.x(bundle) : t1.x(null);
    }
}
