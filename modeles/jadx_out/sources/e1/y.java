package e1;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y extends b0 {

    /* renamed from: b, reason: collision with root package name */
    public final ArrayMap f4408b;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayMap f4409l;

    /* renamed from: m, reason: collision with root package name */
    public long f4410m;

    public y(t1 t1Var) {
        super(t1Var);
        this.f4409l = new ArrayMap();
        this.f4408b = new ArrayMap();
    }

    public final void h(long j, String str) {
        t1 t1Var = this.f3875a;
        if (str == null || str.length() == 0) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.b("Ad unit id must be a non-empty string");
        } else {
            q1 q1Var = t1Var.f4265p;
            t1.m(q1Var);
            q1Var.p(new a(this, str, j, 0));
        }
    }

    public final void i(long j, String str) {
        t1 t1Var = this.f3875a;
        if (str == null || str.length() == 0) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.b("Ad unit id must be a non-empty string");
        } else {
            q1 q1Var = t1Var.f4265p;
            t1.m(q1Var);
            q1Var.p(new a(this, str, j, 1));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(long j) {
        m3 m3Var = this.f3875a.f4270u;
        t1.l(m3Var);
        j3 m10 = m3Var.m(false);
        ArrayMap arrayMap = this.f4408b;
        for (K k5 : arrayMap.keySet()) {
            l(k5, j - ((Long) arrayMap.get(k5)).longValue(), m10);
        }
        if (!arrayMap.isEmpty()) {
            k(j - this.f4410m, m10);
        }
        m(j);
    }

    public final void k(long j, j3 j3Var) {
        t1 t1Var = this.f3875a;
        if (j3Var == null) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4346w.b("Not logging ad exposure. No active activity");
        } else if (j < 1000) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4346w.c(Long.valueOf(j), "Not logging ad exposure. Less than 1000 ms. exposure");
        } else {
            Bundle bundle = new Bundle();
            bundle.putLong("_xt", j);
            a5.Y(j3Var, bundle, true);
            b3 b3Var = t1Var.v;
            t1.l(b3Var);
            b3Var.n("am", "_xa", bundle);
        }
    }

    public final void l(String str, long j, j3 j3Var) {
        t1 t1Var = this.f3875a;
        if (j3Var == null) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4346w.b("Not logging ad unit exposure. No active activity");
        } else {
            if (j < 1000) {
                w0 w0Var2 = t1Var.f4264o;
                t1.m(w0Var2);
                w0Var2.f4346w.c(Long.valueOf(j), "Not logging ad unit exposure. Less than 1000 ms. exposure");
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str);
            bundle.putLong("_xt", j);
            a5.Y(j3Var, bundle, true);
            b3 b3Var = t1Var.v;
            t1.l(b3Var);
            b3Var.n("am", "_xu", bundle);
        }
    }

    public final void m(long j) {
        ArrayMap arrayMap = this.f4408b;
        Iterator it = arrayMap.keySet().iterator();
        while (it.hasNext()) {
            arrayMap.put((String) it.next(), Long.valueOf(j));
        }
        if (arrayMap.isEmpty()) {
            return;
        }
        this.f4410m = j;
    }
}
