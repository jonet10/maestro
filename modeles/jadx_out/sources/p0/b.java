package p0;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import h0.g;
import h0.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f8404a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f8405b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f8406c;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f8407d;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f8408e;
    public static Boolean f;

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean b(Context context, int i) {
        if (d(context, i, "com.google.android.gms")) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 64);
                h a8 = h.a(context);
                a8.getClass();
                if (packageInfo != null) {
                    if (!h.c(packageInfo, false)) {
                        if (h.c(packageInfo, true)) {
                            if (!g.a(a8.f5416a)) {
                                Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                            }
                        }
                    }
                    return true;
                }
                return false;
            } catch (PackageManager.NameNotFoundException unused) {
                if (Log.isLoggable("UidVerifier", 3)) {
                    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
                }
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f8406c == null) {
            f8406c = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        if (f8406c.booleanValue() && Build.VERSION.SDK_INT < 24) {
            return true;
        }
        if (f8407d == null) {
            f8407d = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        if (f8407d.booleanValue()) {
            return !a() || Build.VERSION.SDK_INT >= 30;
        }
        return false;
    }

    public static boolean d(Context context, int i, String str) {
        r0.b a8 = r0.c.a(context);
        a8.getClass();
        try {
            AppOpsManager appOpsManager = (AppOpsManager) a8.f8855a.getSystemService("appops");
            if (appOpsManager == null) {
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            appOpsManager.checkPackage(i, str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
