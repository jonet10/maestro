package r0;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Context f8853a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f8854b;

    public static synchronized boolean a(Context context) {
        Boolean bool;
        synchronized (a.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = f8853a;
            if (context2 != null && (bool = f8854b) != null && context2 == applicationContext) {
                return bool.booleanValue();
            }
            f8854b = null;
            if (p0.b.a()) {
                f8854b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    f8854b = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    f8854b = Boolean.FALSE;
                }
            }
            f8853a = applicationContext;
            return f8854b.booleanValue();
        }
    }
}
