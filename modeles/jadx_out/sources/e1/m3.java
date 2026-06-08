package e1;

import android.os.Bundle;
import android.os.SystemClock;
import j$.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m3 extends h0 {

    /* renamed from: l, reason: collision with root package name */
    public volatile j3 f4120l;

    /* renamed from: m, reason: collision with root package name */
    public volatile j3 f4121m;

    /* renamed from: n, reason: collision with root package name */
    public j3 f4122n;

    /* renamed from: o, reason: collision with root package name */
    public final ConcurrentHashMap f4123o;

    /* renamed from: p, reason: collision with root package name */
    public com.google.android.gms.internal.measurement.w0 f4124p;

    /* renamed from: q, reason: collision with root package name */
    public volatile boolean f4125q;

    /* renamed from: r, reason: collision with root package name */
    public volatile j3 f4126r;

    /* renamed from: s, reason: collision with root package name */
    public j3 f4127s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4128t;

    /* renamed from: u, reason: collision with root package name */
    public final Object f4129u;

    public m3(t1 t1Var) {
        super(t1Var);
        this.f4129u = new Object();
        this.f4123o = new ConcurrentHashMap();
    }

    @Override // e1.h0
    public final boolean j() {
        return false;
    }

    public final void k(j3 j3Var, boolean z9, long j) {
        t1 t1Var = this.f3875a;
        y yVar = t1Var.f4271w;
        t1.j(yVar);
        t1Var.f4269t.getClass();
        yVar.j(SystemClock.elapsedRealtime());
        boolean z10 = j3Var != null && j3Var.f4060d;
        f4 f4Var = t1Var.f4266q;
        t1.l(f4Var);
        if (!f4Var.f3975o.a(z10, z9, j) || j3Var == null) {
            return;
        }
        j3Var.f4060d = false;
    }

    public final j3 l(com.google.android.gms.internal.measurement.w0 w0Var) {
        k0.y.g(w0Var);
        Integer valueOf = Integer.valueOf(w0Var.f2882a);
        ConcurrentHashMap concurrentHashMap = this.f4123o;
        j3 j3Var = (j3) concurrentHashMap.get(valueOf);
        if (j3Var == null) {
            String n10 = n(w0Var.f2883b);
            a5 a5Var = this.f3875a.f4267r;
            t1.k(a5Var);
            j3 j3Var2 = new j3(a5Var.d0(), null, n10);
            concurrentHashMap.put(valueOf, j3Var2);
            j3Var = j3Var2;
        }
        return this.f4126r != null ? this.f4126r : j3Var;
    }

    public final j3 m(boolean z9) {
        h();
        g();
        j3 j3Var = this.f4122n;
        return !z9 ? j3Var : j3Var != null ? j3Var : this.f4127s;
    }

    public final String n(String str) {
        if (str == null) {
            return "Activity";
        }
        String[] split = str.split("\\.");
        int length = split.length;
        String str2 = length > 0 ? split[length - 1] : "";
        int length2 = str2.length();
        t1 t1Var = this.f3875a;
        t1Var.f4262m.getClass();
        if (length2 <= 500) {
            return str2;
        }
        t1Var.f4262m.getClass();
        return str2.substring(0, 500);
    }

    public final void o(com.google.android.gms.internal.measurement.w0 w0Var, Bundle bundle) {
        Bundle bundle2;
        if (!this.f3875a.f4262m.u() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f4123o.put(Integer.valueOf(w0Var.f2882a), new j3(bundle2.getLong("id"), bundle2.getString("name"), bundle2.getString("referrer_name")));
    }

    public final void p(String str, j3 j3Var, boolean z9) {
        j3 j3Var2;
        j3 j3Var3 = this.f4120l == null ? this.f4121m : this.f4120l;
        if (j3Var.f4058b == null) {
            j3Var2 = new j3(j3Var.f4057a, str != null ? n(str) : null, j3Var.f4059c, j3Var.f4061e, j3Var.f);
        } else {
            j3Var2 = j3Var;
        }
        this.f4121m = this.f4120l;
        this.f4120l = j3Var2;
        t1 t1Var = this.f3875a;
        t1Var.f4269t.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        q1 q1Var = t1Var.f4265p;
        t1.m(q1Var);
        q1Var.p(new k3(this, j3Var2, j3Var3, elapsedRealtime, z9));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(e1.j3 r18, e1.j3 r19, long r20, boolean r22, android.os.Bundle r23) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m3.q(e1.j3, e1.j3, long, boolean, android.os.Bundle):void");
    }
}
