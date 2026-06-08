package androidx.work.impl.utils;

import android.support.v4.media.g;
import android.util.Log;
import b5.m;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import y1.l;
import y1.q;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class d implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f637a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f638b;

    public /* synthetic */ d(Object obj, int i) {
        this.f637a = i;
        this.f638b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Integer nextAlarmManagerId$lambda$1;
        switch (this.f637a) {
            case 0:
                nextAlarmManagerId$lambda$1 = IdGenerator.nextAlarmManagerId$lambda$1((IdGenerator) this.f638b);
                return nextAlarmManagerId$lambda$1;
            case 1:
                g2.e eVar = (g2.e) ((g) this.f638b).f248l;
                g2.a aVar = (g2.a) eVar.f5123p;
                g2.f fVar = (g2.f) eVar.f5119l;
                String str = aVar.f5107a;
                z1.e.b();
                try {
                    HashMap b7 = g2.a.b(fVar);
                    m mVar = new m(str, b7);
                    mVar.E("User-Agent", "Crashlytics Android SDK/20.0.4");
                    mVar.E("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
                    g2.a.a(mVar, fVar);
                    String concat = "Requesting settings from ".concat(str);
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", concat, null);
                    }
                    String str2 = "Settings query params were: " + b7;
                    if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", str2, null);
                    }
                    return aVar.c(mVar.C());
                } catch (IOException e10) {
                    Log.e("FirebaseCrashlytics", "Settings request failed.", e10);
                    return null;
                }
            default:
                l lVar = ((q) this.f638b).g;
                lVar.getClass();
                z1.e.a();
                m8.q qVar = lVar.f11638c;
                e2.d dVar = (e2.d) qVar.f7781l;
                String str3 = (String) qVar.f7780b;
                dVar.getClass();
                boolean z9 = true;
                if (new File((File) dVar.f4468m, str3).exists()) {
                    if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                        Log.v("FirebaseCrashlytics", "Found previous crash marker.", null);
                    }
                    e2.d dVar2 = (e2.d) qVar.f7781l;
                    dVar2.getClass();
                    new File((File) dVar2.f4468m, str3).delete();
                } else if (lVar.e() == null || !lVar.j.c()) {
                    z9 = false;
                }
                return Boolean.valueOf(z9);
        }
    }
}
