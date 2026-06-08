package e1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends d2 {

    /* renamed from: b, reason: collision with root package name */
    public Boolean f3977b;

    /* renamed from: l, reason: collision with root package name */
    public String f3978l;

    /* renamed from: m, reason: collision with root package name */
    public f f3979m;

    /* renamed from: n, reason: collision with root package name */
    public Boolean f3980n;

    public final boolean h(String str) {
        return "1".equals(this.f3979m.d(str, "gaia_collection_enabled"));
    }

    public final boolean i(String str) {
        return "1".equals(this.f3979m.d(str, "measurement.event_sampling_enabled"));
    }

    public final boolean j() {
        if (this.f3977b == null) {
            Boolean s6 = s("app_measurement_lite");
            this.f3977b = s6;
            if (s6 == null) {
                this.f3977b = Boolean.FALSE;
            }
        }
        return this.f3977b.booleanValue() || !this.f3875a.f4260b;
    }

    public final String k(String str) {
        t1 t1Var = this.f3875a;
        try {
            String str2 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, "");
            k0.y.g(str2);
            return str2;
        } catch (ClassNotFoundException e10) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.c(e10, "Could not find SystemProperties class");
            return "";
        } catch (IllegalAccessException e11) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4339o.c(e11, "Could not access SystemProperties.get()");
            return "";
        } catch (NoSuchMethodException e12) {
            w0 w0Var3 = t1Var.f4264o;
            t1.m(w0Var3);
            w0Var3.f4339o.c(e12, "Could not find SystemProperties.get() method");
            return "";
        } catch (InvocationTargetException e13) {
            w0 w0Var4 = t1Var.f4264o;
            t1.m(w0Var4);
            w0Var4.f4339o.c(e13, "SystemProperties.get() threw an exception");
            return "";
        }
    }

    public final void l() {
        this.f3875a.getClass();
    }

    public final String m(String str, e0 e0Var) {
        return TextUtils.isEmpty(str) ? (String) e0Var.a(null) : (String) e0Var.a(this.f3979m.d(str, e0Var.f3893a));
    }

    public final long n(String str, e0 e0Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Long) e0Var.a(null)).longValue();
        }
        String d10 = this.f3979m.d(str, e0Var.f3893a);
        if (TextUtils.isEmpty(d10)) {
            return ((Long) e0Var.a(null)).longValue();
        }
        try {
            return ((Long) e0Var.a(Long.valueOf(Long.parseLong(d10)))).longValue();
        } catch (NumberFormatException unused) {
            return ((Long) e0Var.a(null)).longValue();
        }
    }

    public final int o(String str, e0 e0Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Integer) e0Var.a(null)).intValue();
        }
        String d10 = this.f3979m.d(str, e0Var.f3893a);
        if (TextUtils.isEmpty(d10)) {
            return ((Integer) e0Var.a(null)).intValue();
        }
        try {
            return ((Integer) e0Var.a(Integer.valueOf(Integer.parseInt(d10)))).intValue();
        } catch (NumberFormatException unused) {
            return ((Integer) e0Var.a(null)).intValue();
        }
    }

    public final double p(String str, e0 e0Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Double) e0Var.a(null)).doubleValue();
        }
        String d10 = this.f3979m.d(str, e0Var.f3893a);
        if (TextUtils.isEmpty(d10)) {
            return ((Double) e0Var.a(null)).doubleValue();
        }
        try {
            return ((Double) e0Var.a(Double.valueOf(Double.parseDouble(d10)))).doubleValue();
        } catch (NumberFormatException unused) {
            return ((Double) e0Var.a(null)).doubleValue();
        }
    }

    public final boolean q(String str, e0 e0Var) {
        if (TextUtils.isEmpty(str)) {
            return ((Boolean) e0Var.a(null)).booleanValue();
        }
        String d10 = this.f3979m.d(str, e0Var.f3893a);
        return TextUtils.isEmpty(d10) ? ((Boolean) e0Var.a(null)).booleanValue() : ((Boolean) e0Var.a(Boolean.valueOf("1".equals(d10)))).booleanValue();
    }

    public final Bundle r() {
        t1 t1Var = this.f3875a;
        try {
            Context context = t1Var.f4259a;
            Context context2 = t1Var.f4259a;
            w0 w0Var = t1Var.f4264o;
            if (context.getPackageManager() == null) {
                t1.m(w0Var);
                w0Var.f4339o.b("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo a8 = r0.c.a(context2).a(128, context2.getPackageName());
            if (a8 != null) {
                return a8.metaData;
            }
            t1.m(w0Var);
            w0Var.f4339o.b("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4339o.c(e10, "Failed to load metadata: Package name not found");
            return null;
        }
    }

    public final Boolean s(String str) {
        k0.y.d(str);
        Bundle r9 = r();
        if (r9 != null) {
            if (r9.containsKey(str)) {
                return Boolean.valueOf(r9.getBoolean(str));
            }
            return null;
        }
        w0 w0Var = this.f3875a.f4264o;
        t1.m(w0Var);
        w0Var.f4339o.b("Failed to load metadata: Metadata bundle is null");
        return null;
    }

    public final boolean t() {
        this.f3875a.getClass();
        Boolean s6 = s("firebase_analytics_collection_deactivated");
        return s6 != null && s6.booleanValue();
    }

    public final boolean u() {
        Boolean s6 = s("google_analytics_automatic_screen_reporting_enabled");
        return s6 == null || s6.booleanValue();
    }

    public final g2 v(String str, boolean z9) {
        Object obj;
        k0.y.d(str);
        Bundle r9 = r();
        t1 t1Var = this.f3875a;
        if (r9 == null) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.b("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = r9.get(str);
        }
        g2 g2Var = g2.UNINITIALIZED;
        if (obj == null) {
            return g2Var;
        }
        if (Boolean.TRUE.equals(obj)) {
            return g2.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return g2.DENIED;
        }
        if (z9 && "eu_consent_policy".equals(obj)) {
            return g2.POLICY;
        }
        w0 w0Var2 = t1Var.f4264o;
        t1.m(w0Var2);
        w0Var2.f4342r.c(str, "Invalid manifest metadata for");
        return g2Var;
    }
}
