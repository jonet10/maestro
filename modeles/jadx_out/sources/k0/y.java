package k0;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f6936a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f6937b;

    /* renamed from: c, reason: collision with root package name */
    public static int f6938c;

    public static void a(String str, boolean z9) {
        if (z9) {
            return;
        }
        com.google.gson.internal.a.p(str);
    }

    public static void b(boolean z9) {
        if (z9) {
            return;
        }
        s1.o.n();
    }

    public static void c(Handler handler) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != handler.getLooper()) {
            String name = myLooper != null ? myLooper.getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + String.valueOf(name2).length() + 35 + 1);
            a4.x.B(sb, "Must be called on ", name2, " thread, but got ", name);
            sb.append(".");
            throw new IllegalStateException(sb.toString());
        }
    }

    public static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            com.google.gson.internal.a.p("Given String is empty or null");
        }
    }

    public static void e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.google.gson.internal.a.p(str2);
        }
    }

    public static void f(String str) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i(str);
    }

    public static void g(Object obj) {
        if (obj != null) {
            return;
        }
        com.google.gson.internal.a.i("null reference");
    }

    public static void h(Object obj, String str) {
        if (obj != null) {
            return;
        }
        com.google.gson.internal.a.i(str);
    }

    public static void i(boolean z9, String str) {
        if (z9) {
            return;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i(str);
    }

    public static boolean j(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }
}
