package y2;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v {

    /* renamed from: d, reason: collision with root package name */
    public static WeakReference f11767d;

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f11768a;

    /* renamed from: b, reason: collision with root package name */
    public a4.d0 f11769b;

    /* renamed from: c, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f11770c;

    public v(SharedPreferences sharedPreferences, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        this.f11770c = scheduledThreadPoolExecutor;
        this.f11768a = sharedPreferences;
    }

    public final synchronized u a() {
        u uVar;
        String m10 = this.f11769b.m();
        Pattern pattern = u.f11763d;
        uVar = null;
        if (!TextUtils.isEmpty(m10)) {
            String[] split = m10.split("!", -1);
            if (split.length == 2) {
                uVar = new u(split[0], split[1]);
            }
        }
        return uVar;
    }

    public final synchronized void b() {
        this.f11769b = a4.d0.i(this.f11768a, this.f11770c);
    }

    public final synchronized void c(u uVar) {
        this.f11769b.n(uVar.f11766c);
    }
}
