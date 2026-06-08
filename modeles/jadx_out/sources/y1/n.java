package y1;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessaging;
import e1.x2;
import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11651a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11652b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f11653l;

    public /* synthetic */ n(q qVar, Exception exc) {
        this.f11651a = 1;
        Map map = Collections.EMPTY_MAP;
        this.f11652b = qVar;
        this.f11653l = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11651a) {
            case 0:
                q qVar = (q) this.f11652b;
                String str = (String) this.f11653l;
                l lVar = qVar.g;
                lVar.getClass();
                try {
                    ((a2.t) lVar.f11639d.f4469n).l("operation", str);
                    return;
                } catch (IllegalArgumentException e10) {
                    Context context = lVar.f11636a;
                    if (context != null && (context.getApplicationInfo().flags & 2) != 0) {
                        throw e10;
                    }
                    Log.e("FirebaseCrashlytics", "Attempting to set custom attribute with null key, ignoring.", null);
                    return;
                }
            case 1:
                q qVar2 = (q) this.f11652b;
                Exception exc = (Exception) this.f11653l;
                Map map = Collections.EMPTY_MAP;
                l lVar2 = qVar2.g;
                Thread currentThread = Thread.currentThread();
                lVar2.getClass();
                long currentTimeMillis = System.currentTimeMillis();
                s sVar = lVar2.f11644n;
                if (sVar == null || !sVar.f11678e.get()) {
                    long j = currentTimeMillis / 1000;
                    String e11 = lVar2.e();
                    if (e11 == null) {
                        Log.w("FirebaseCrashlytics", "Tried to write a non-fatal exception while no session was open.", null);
                        return;
                    }
                    a2.c cVar = new a2.c(e11, j, map);
                    e2.d dVar = lVar2.f11643m;
                    dVar.getClass();
                    String concat = "Persisting non-fatal event for session ".concat(e11);
                    if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", concat, null);
                    }
                    dVar.k(exc, currentThread, "error", cVar, false);
                    return;
                }
                return;
            case 2:
                ((x2) this.f11652b).a((Intent) this.f11653l);
                return;
            case 3:
                FirebaseMessaging firebaseMessaging = (FirebaseMessaging) this.f11652b;
                j1.i iVar = (j1.i) this.f11653l;
                try {
                    iVar.a(firebaseMessaging.a());
                    return;
                } catch (Exception e12) {
                    iVar.f6539a.m(e12);
                    return;
                }
            default:
                y2.m mVar = (y2.m) this.f11652b;
                j1.i iVar2 = (j1.i) this.f11653l;
                try {
                    iVar2.a(mVar.b());
                    return;
                } catch (Exception e13) {
                    iVar2.f6539a.m(e13);
                    return;
                }
        }
    }

    public /* synthetic */ n(int i, Object obj, Object obj2) {
        this.f11651a = i;
        this.f11652b = obj;
        this.f11653l = obj2;
    }
}
