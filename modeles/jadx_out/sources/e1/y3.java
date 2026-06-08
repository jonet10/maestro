package e1;

import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.Pair;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y3 extends p4 {

    /* renamed from: m, reason: collision with root package name */
    public final HashMap f4418m;

    /* renamed from: n, reason: collision with root package name */
    public final e1 f4419n;

    /* renamed from: o, reason: collision with root package name */
    public final e1 f4420o;

    /* renamed from: p, reason: collision with root package name */
    public final e1 f4421p;

    /* renamed from: q, reason: collision with root package name */
    public final e1 f4422q;

    /* renamed from: r, reason: collision with root package name */
    public final e1 f4423r;

    /* renamed from: s, reason: collision with root package name */
    public final e1 f4424s;

    public y3(u4 u4Var) {
        super(u4Var);
        this.f4418m = new HashMap();
        g1 g1Var = this.f3875a.f4263n;
        t1.k(g1Var);
        this.f4419n = new e1(g1Var, "last_delete_stale", 0L);
        g1 g1Var2 = this.f3875a.f4263n;
        t1.k(g1Var2);
        this.f4420o = new e1(g1Var2, "last_delete_stale_batch", 0L);
        g1 g1Var3 = this.f3875a.f4263n;
        t1.k(g1Var3);
        this.f4421p = new e1(g1Var3, "backoff", 0L);
        g1 g1Var4 = this.f3875a.f4263n;
        t1.k(g1Var4);
        this.f4422q = new e1(g1Var4, "last_upload", 0L);
        g1 g1Var5 = this.f3875a.f4263n;
        t1.k(g1Var5);
        this.f4423r = new e1(g1Var5, "last_upload_attempt", 0L);
        g1 g1Var6 = this.f3875a.f4263n;
        t1.k(g1Var6);
        this.f4424s = new e1(g1Var6, "midnight_offset", 0L);
    }

    public final Pair k(String str) {
        c0.a aVar;
        x3 x3Var;
        g();
        t1 t1Var = this.f3875a;
        p0.a aVar2 = t1Var.f4269t;
        g gVar = t1Var.f4262m;
        aVar2.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        HashMap hashMap = this.f4418m;
        x3 x3Var2 = (x3) hashMap.get(str);
        if (x3Var2 != null && elapsedRealtime < x3Var2.f4400c) {
            return new Pair(x3Var2.f4398a, Boolean.valueOf(x3Var2.f4399b));
        }
        long n10 = gVar.n(str, f0.f3915b) + elapsedRealtime;
        try {
            try {
                aVar = c0.b.a(t1Var.f4259a);
            } catch (PackageManager.NameNotFoundException unused) {
                if (x3Var2 != null && elapsedRealtime < x3Var2.f4400c + gVar.n(str, f0.f3917c)) {
                    return new Pair(x3Var2.f4398a, Boolean.valueOf(x3Var2.f4399b));
                }
                aVar = null;
            }
        } catch (Exception e10) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.v.c(e10, "Unable to get advertising id");
            x3Var = new x3("", false, n10);
        }
        if (aVar == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String str2 = aVar.f1167b;
        x3Var = str2 != null ? new x3(str2, aVar.f1168c, n10) : new x3("", aVar.f1168c, n10);
        hashMap.put(str, x3Var);
        return new Pair(x3Var.f4398a, Boolean.valueOf(x3Var.f4399b));
    }

    public final String l(String str, boolean z9) {
        g();
        String str2 = z9 ? (String) k(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest x3 = a5.x();
        if (x3 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, x3.digest(str2.getBytes())));
    }

    @Override // e1.p4
    public final void j() {
    }
}
