package t7;

import android.os.Looper;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public static final p7.c f10348a;

    static {
        String str;
        int i = u.f10357a;
        Object obj = null;
        try {
            str = System.getProperty("kotlinx.coroutines.fast.service.loader");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str != null) {
            Boolean.parseBoolean(str);
        }
        try {
            Iterator it = Arrays.asList(new p7.a()).iterator();
            it.getClass();
            Iterator it2 = k7.i.i0(new k7.a(new a7.e(it, 2))).iterator();
            if (it2.hasNext()) {
                obj = it2.next();
                if (it2.hasNext()) {
                    ((p7.a) obj).getClass();
                    do {
                        ((p7.a) it2.next()).getClass();
                    } while (it2.hasNext());
                }
            }
            if (((p7.a) obj) == null) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
                return;
            }
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                f10348a = new p7.c(p7.d.a(mainLooper), false);
            } else {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("The main looper is not available");
            }
        } catch (Throwable th) {
            throw new ServiceConfigurationError(th.getMessage(), th);
        }
    }
}
