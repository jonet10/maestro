package u1;

import android.os.Bundle;
import android.util.Log;
import e1.c0;
import g5.f;
import g5.g;
import java.util.ArrayList;
import m8.q;
import t4.n0;
import y1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements x1.a, w1.a, s2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f10394a;

    public /* synthetic */ a(b bVar) {
        this.f10394a = bVar;
    }

    @Override // x1.a
    public void a(o oVar) {
        b bVar = this.f10394a;
        synchronized (bVar) {
            try {
                if (bVar.f10396b instanceof x1.b) {
                    bVar.f10397c.add(oVar);
                }
                bVar.f10396b.a(oVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // s2.a
    public void b(s2.b bVar) {
        b bVar2 = this.f10394a;
        v1.c cVar = v1.c.f10791a;
        cVar.b("AnalyticsConnector now available.");
        p1.a aVar = (p1.a) bVar.get();
        f fVar = new f(aVar, 16);
        q qVar = new q(15);
        p1.b bVar3 = (p1.b) aVar;
        c0 b7 = bVar3.b("clx", qVar);
        if (b7 == null) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Could not register AnalyticsConnectorListener with Crashlytics origin.", null);
            }
            b7 = bVar3.b("crash", qVar);
            if (b7 != null) {
                Log.w("FirebaseCrashlytics", "A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.", null);
            }
        }
        if (b7 == null) {
            cVar.d("Could not register Firebase Analytics listener; a listener is already registered.", null);
            return;
        }
        cVar.b("Registered Firebase Analytics listener.");
        g gVar = new g(15, false);
        n0 n0Var = new n0(fVar);
        synchronized (bVar2) {
            try {
                ArrayList arrayList = bVar2.f10397c;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    gVar.a((o) obj);
                }
                qVar.f7781l = gVar;
                qVar.f7780b = n0Var;
                bVar2.f10396b = gVar;
                bVar2.f10395a = n0Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // w1.a
    public void i(Bundle bundle) {
        this.f10394a.f10395a.i(bundle);
    }
}
