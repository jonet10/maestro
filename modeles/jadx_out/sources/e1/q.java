package e1;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final String f4193a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4194b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4195c;

    /* renamed from: d, reason: collision with root package name */
    public final long f4196d;

    /* renamed from: e, reason: collision with root package name */
    public final long f4197e;
    public final t f;

    public q(t1 t1Var, String str, String str2, String str3, long j, long j6, Bundle bundle) {
        t tVar;
        k0.y.d(str2);
        k0.y.d(str3);
        this.f4193a = str2;
        this.f4194b = str3;
        this.f4195c = true == TextUtils.isEmpty(str) ? null : str;
        this.f4196d = j;
        this.f4197e = j6;
        if (j6 != 0 && j6 > j) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.c(w0.o(str2), "Event created with reverse previous/current timestamps. appId");
        }
        if (bundle == null || bundle.isEmpty()) {
            tVar = new t(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    w0 w0Var2 = t1Var.f4264o;
                    t1.m(w0Var2);
                    w0Var2.f4339o.b("Param name can't be null");
                    it.remove();
                } else {
                    a5 a5Var = t1Var.f4267r;
                    t1.k(a5Var);
                    Object n10 = a5Var.n(bundle2.get(next), next);
                    if (n10 == null) {
                        w0 w0Var3 = t1Var.f4264o;
                        t1.m(w0Var3);
                        w0Var3.f4342r.c(t1Var.f4268s.b(next), "Param value can't be null");
                        it.remove();
                    } else {
                        a5 a5Var2 = t1Var.f4267r;
                        t1.k(a5Var2);
                        a5Var2.v(n10, next, bundle2);
                    }
                }
            }
            tVar = new t(bundle2);
        }
        this.f = tVar;
    }

    public final q a(t1 t1Var, long j) {
        return new q(t1Var, this.f4195c, this.f4193a, this.f4194b, this.f4196d, j, this.f);
    }

    public final String toString() {
        String tVar = this.f.toString();
        String str = this.f4193a;
        int length = String.valueOf(str).length();
        String str2 = this.f4194b;
        StringBuilder sb = new StringBuilder(length + 22 + String.valueOf(str2).length() + 10 + tVar.length() + 1);
        a4.x.B(sb, "Event{appId='", str, "', name='", str2);
        return a4.x.o(sb, "', params=", tVar, "}");
    }

    public q(t1 t1Var, String str, String str2, String str3, long j, long j6, t tVar) {
        k0.y.d(str2);
        k0.y.d(str3);
        k0.y.g(tVar);
        this.f4193a = str2;
        this.f4194b = str3;
        this.f4195c = true == TextUtils.isEmpty(str) ? null : str;
        this.f4196d = j;
        this.f4197e = j6;
        if (j6 != 0 && j6 > j) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.d(w0.o(str2), "Event created with reverse previous/current timestamps. appId, name", w0.o(str3));
        }
        this.f = tVar;
    }
}
