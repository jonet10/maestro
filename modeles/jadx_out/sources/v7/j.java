package v7;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.TimeUnit;
import t7.u;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10892a;

    /* renamed from: b, reason: collision with root package name */
    public static final long f10893b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f10894c;

    /* renamed from: d, reason: collision with root package name */
    public static final int f10895d;

    /* renamed from: e, reason: collision with root package name */
    public static final long f10896e;
    public static final g f;

    static {
        String str;
        int i = u.f10357a;
        try {
            str = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str == null) {
            str = "DefaultDispatcher";
        }
        f10892a = str;
        f10893b = t7.a.i(100000L, 1L, LocationRequestCompat.PASSIVE_INTERVAL, "kotlinx.coroutines.scheduler.resolution.ns");
        int i6 = u.f10357a;
        if (i6 < 2) {
            i6 = 2;
        }
        f10894c = t7.a.j(i6, 8, "kotlinx.coroutines.scheduler.core.pool.size");
        f10895d = t7.a.j(2097150, 4, "kotlinx.coroutines.scheduler.max.pool.size");
        f10896e = TimeUnit.SECONDS.toNanos(t7.a.i(60L, 1L, LocationRequestCompat.PASSIVE_INTERVAL, "kotlinx.coroutines.scheduler.keep.alive.sec"));
        f = g.f10888a;
    }
}
