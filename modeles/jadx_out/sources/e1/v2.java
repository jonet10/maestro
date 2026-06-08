package e1;

import android.os.Bundle;
import java.util.Iterator;
import java.util.TreeSet;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4325a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f4326b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ b3 f4327l;

    public /* synthetic */ v2(b3 b3Var, Bundle bundle, int i) {
        this.f4325a = i;
        this.f4326b = bundle;
        this.f4327l = b3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        switch (this.f4325a) {
            case 0:
                b3 b3Var = this.f4327l;
                b3Var.g();
                b3Var.h();
                Bundle bundle2 = this.f4326b;
                String string = bundle2.getString("name");
                String string2 = bundle2.getString("origin");
                k0.y.d(string);
                k0.y.d(string2);
                k0.y.g(bundle2.get("value"));
                t1 t1Var = b3Var.f3875a;
                if (!t1Var.d()) {
                    w0 w0Var = t1Var.f4264o;
                    t1.m(w0Var);
                    w0Var.f4346w.b("Conditional property not set since app measurement is disabled");
                    break;
                } else {
                    x4 x4Var = new x4(bundle2.getLong("triggered_timestamp"), bundle2.get("value"), string, string2);
                    try {
                        a5 a5Var = t1Var.f4267r;
                        t1.k(a5Var);
                        bundle2.getString("app_id");
                        u J = a5Var.J(bundle2.getString("triggered_event_name"), bundle2.getBundle("triggered_event_params"), string2, 0L, true);
                        t1.k(a5Var);
                        bundle2.getString("app_id");
                        u J2 = a5Var.J(bundle2.getString("timed_out_event_name"), bundle2.getBundle("timed_out_event_params"), string2, 0L, true);
                        bundle2.getString("app_id");
                        t1Var.p().z(new e(bundle2.getString("app_id"), string2, x4Var, bundle2.getLong("creation_timestamp"), false, bundle2.getString("trigger_event_name"), J2, bundle2.getLong("trigger_timeout"), J, bundle2.getLong("time_to_live"), a5Var.J(bundle2.getString("expired_event_name"), bundle2.getBundle("expired_event_params"), string2, 0L, true)));
                        break;
                    } catch (IllegalArgumentException unused) {
                        return;
                    }
                }
            case 1:
                b3 b3Var2 = this.f4327l;
                b3Var2.g();
                b3Var2.h();
                Bundle bundle3 = this.f4326b;
                String string3 = bundle3.getString("name");
                k0.y.d(string3);
                t1 t1Var2 = b3Var2.f3875a;
                if (!t1Var2.d()) {
                    w0 w0Var2 = t1Var2.f4264o;
                    t1.m(w0Var2);
                    w0Var2.f4346w.b("Conditional property not cleared since app measurement is disabled");
                    break;
                } else {
                    x4 x4Var2 = new x4(0L, null, string3, "");
                    try {
                        a5 a5Var2 = t1Var2.f4267r;
                        t1.k(a5Var2);
                        bundle3.getString("app_id");
                        t1Var2.p().z(new e(bundle3.getString("app_id"), "", x4Var2, bundle3.getLong("creation_timestamp"), bundle3.getBoolean("active"), bundle3.getString("trigger_event_name"), null, bundle3.getLong("trigger_timeout"), null, bundle3.getLong("time_to_live"), a5Var2.J(bundle3.getString("expired_event_name"), bundle3.getBundle("expired_event_params"), "", bundle3.getLong("creation_timestamp"), true)));
                        break;
                    } catch (IllegalArgumentException unused2) {
                        return;
                    }
                }
            default:
                b3 b3Var3 = this.f4327l;
                a3.d dVar = b3Var3.F;
                t1 t1Var3 = b3Var3.f3875a;
                Bundle bundle4 = this.f4326b;
                if (bundle4.isEmpty()) {
                    bundle = bundle4;
                } else {
                    g1 g1Var = t1Var3.f4263n;
                    a5 a5Var3 = t1Var3.f4267r;
                    g gVar = t1Var3.f4262m;
                    w0 w0Var3 = t1Var3.f4264o;
                    t1.k(g1Var);
                    bundle = new Bundle(g1Var.H.G());
                    for (String str : bundle4.keySet()) {
                        Object obj = bundle4.get(str);
                        if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                            t1.k(a5Var3);
                            if (a5.p0(obj)) {
                                a5.w(dVar, null, 27, null, null, 0);
                            }
                            t1.m(w0Var3);
                            w0Var3.f4344t.d(str, "Invalid default event parameter type. Name, value", obj);
                        } else if (a5.F(str)) {
                            t1.m(w0Var3);
                            w0Var3.f4344t.c(str, "Invalid default event parameter name. Name");
                        } else if (obj == null) {
                            bundle.remove(str);
                        } else {
                            t1.k(a5Var3);
                            gVar.getClass();
                            if (a5Var3.q0("param", str, 500, obj)) {
                                a5Var3.v(obj, str, bundle);
                            }
                        }
                    }
                    t1.k(a5Var3);
                    a5 a5Var4 = gVar.f3875a.f4267r;
                    t1.k(a5Var4);
                    int i = a5Var4.M(201500000) ? 100 : 25;
                    if (bundle.size() > i) {
                        Iterator it = new TreeSet(bundle.keySet()).iterator();
                        int i6 = 0;
                        while (it.hasNext()) {
                            String str2 = (String) it.next();
                            i6++;
                            if (i6 > i) {
                                bundle.remove(str2);
                            }
                        }
                        t1.k(a5Var3);
                        a5.w(dVar, null, 26, null, null, 0);
                        t1.m(w0Var3);
                        w0Var3.f4344t.b("Too many default event parameters set. Discarding beyond event parameter limit");
                    }
                }
                g1 g1Var2 = t1Var3.f4263n;
                t1.k(g1Var2);
                g1Var2.H.K(bundle);
                if (!bundle4.isEmpty() || t1Var3.f4262m.q(null, f0.X0)) {
                    t1Var3.p().l(bundle);
                    break;
                }
                break;
        }
    }
}
