package e1;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4252a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f4253b;

    /* renamed from: l, reason: collision with root package name */
    public final String f4254l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f4255m;

    /* renamed from: n, reason: collision with root package name */
    public final Object f4256n;

    /* renamed from: o, reason: collision with root package name */
    public final Object f4257o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f4258p;

    public /* synthetic */ t0(String str, y0 y0Var, int i, IOException iOException, byte[] bArr, Map map) {
        k0.y.g(y0Var);
        this.f4255m = y0Var;
        this.f4253b = i;
        this.f4256n = iOException;
        this.f4257o = bArr;
        this.f4254l = str;
        this.f4258p = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4252a) {
            case 0:
                w0 w0Var = (w0) this.f4258p;
                g1 g1Var = w0Var.f3875a.f4263n;
                t1.k(g1Var);
                if (!g1Var.f3903b) {
                    Log.println(6, w0Var.q(), "Persisted config not initialized. Not logging error/warn");
                    return;
                }
                if (w0Var.f4336l == 0) {
                    g gVar = w0Var.f3875a.f4262m;
                    if (gVar.f3980n == null) {
                        synchronized (gVar) {
                            try {
                                if (gVar.f3980n == null) {
                                    t1 t1Var = gVar.f3875a;
                                    ApplicationInfo applicationInfo = t1Var.f4259a.getApplicationInfo();
                                    String a8 = p0.c.a();
                                    if (applicationInfo != null) {
                                        String str = applicationInfo.processName;
                                        gVar.f3980n = Boolean.valueOf(str != null && str.equals(a8));
                                    }
                                    if (gVar.f3980n == null) {
                                        gVar.f3980n = Boolean.TRUE;
                                        w0 w0Var2 = t1Var.f4264o;
                                        t1.m(w0Var2);
                                        w0Var2.f4339o.b("My process not in the list of running processes");
                                    }
                                }
                            } finally {
                            }
                        }
                    }
                    if (gVar.f3980n.booleanValue()) {
                        w0Var.f4336l = 'C';
                    } else {
                        w0Var.f4336l = 'c';
                    }
                }
                if (w0Var.f4337m < 0) {
                    w0Var.f3875a.f4262m.l();
                    w0Var.f4337m = 133005L;
                }
                int i = this.f4253b;
                char c9 = w0Var.f4336l;
                long j = w0Var.f4337m;
                String str2 = this.f4254l;
                Object obj = this.f4255m;
                Object obj2 = this.f4256n;
                Object obj3 = this.f4257o;
                char charAt = "01VDIWEA?".charAt(i);
                String r9 = w0.r(true, str2, obj, obj2, obj3);
                StringBuilder sb = new StringBuilder(String.valueOf(charAt).length() + 1 + String.valueOf(c9).length() + String.valueOf(j).length() + 1 + r9.length());
                sb.append(ExifInterface.GPS_MEASUREMENT_2D);
                sb.append(charAt);
                sb.append(c9);
                sb.append(j);
                sb.append(":");
                sb.append(r9);
                String sb2 = sb.toString();
                if (sb2.length() > 1024) {
                    sb2 = str2.substring(0, 1024);
                }
                f1 f1Var = g1Var.f3983n;
                if (f1Var != null) {
                    String str3 = (String) f1Var.f3970d;
                    g1 g1Var2 = (g1) f1Var.f3971e;
                    g1Var2.g();
                    if (((g1) f1Var.f3971e).k().getLong((String) f1Var.f3968b, 0L) == 0) {
                        f1Var.b();
                    }
                    SharedPreferences k5 = g1Var2.k();
                    String str4 = (String) f1Var.f3969c;
                    long j6 = k5.getLong(str4, 0L);
                    if (j6 <= 0) {
                        SharedPreferences.Editor edit = g1Var2.k().edit();
                        edit.putString(str3, sb2);
                        edit.putLong(str4, 1L);
                        edit.apply();
                        return;
                    }
                    a5 a5Var = g1Var2.f3875a.f4267r;
                    t1.k(a5Var);
                    long nextLong = a5Var.e0().nextLong() & LocationRequestCompat.PASSIVE_INTERVAL;
                    long j10 = j6 + 1;
                    long j11 = LocationRequestCompat.PASSIVE_INTERVAL / j10;
                    SharedPreferences.Editor edit2 = g1Var2.k().edit();
                    if (nextLong < j11) {
                        edit2.putString(str3, sb2);
                    }
                    edit2.putLong(str4, j10);
                    edit2.apply();
                    return;
                }
                return;
            default:
                ((y0) this.f4255m).c(this.f4254l, this.f4253b, (Throwable) this.f4256n, (byte[]) this.f4257o, (Map) this.f4258p);
                return;
        }
    }

    public t0(w0 w0Var, int i, String str, Object obj, Object obj2, Object obj3) {
        this.f4253b = i;
        this.f4254l = str;
        this.f4255m = obj;
        this.f4256n = obj2;
        this.f4257o = obj3;
        this.f4258p = w0Var;
    }
}
