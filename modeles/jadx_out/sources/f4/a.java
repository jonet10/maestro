package f4;

import androidx.work.PeriodicWorkRequest;
import b.d;
import l4.m;
import o7.c0;
import o7.m0;
import o7.s1;
import o7.u1;
import r7.d0;
import r7.j0;
import r7.k0;
import r7.o0;
import t7.n;
import v7.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f4869a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final t7.c f4870b;

    /* renamed from: c, reason: collision with root package name */
    public static final o0 f4871c;

    /* renamed from: d, reason: collision with root package name */
    public static final j0 f4872d;

    /* renamed from: e, reason: collision with root package name */
    public static final d0 f4873e;
    public static s1 f;

    static {
        u1 d10 = c0.d();
        e eVar = m0.f8288a;
        f4870b = c0.b(a.a.L(d10, n.f10348a));
        f4871c = k0.b(null);
        j0 a8 = k0.a(0, 1);
        f4872d = a8;
        f4873e = new d0(a8);
    }

    public static void b(m mVar) {
        f4872d.n(mVar);
    }

    public final synchronized void a() {
        try {
            s1 s1Var = f;
            if (s1Var != null) {
                s1Var.c(null);
            }
            f = null;
            f4871c.f(null);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final l4.a c() {
        l4.a aVar = (l4.a) f4871c.getValue();
        if (aVar == null) {
            return null;
        }
        if (System.currentTimeMillis() - aVar.f7098d <= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            return aVar;
        }
        a();
        return null;
    }

    public final synchronized void d(long j, long j6, String str, String str2) {
        try {
            str.getClass();
            str2.getClass();
            s1 s1Var = f;
            t6.c cVar = null;
            if (s1Var != null) {
                s1Var.c(null);
            }
            l4.a aVar = new l4.a();
            aVar.f7099e = -1L;
            aVar.f7095a = str;
            aVar.f7096b = j;
            aVar.f7097c = str2;
            aVar.f7098d = System.currentTimeMillis();
            aVar.f7099e = j6;
            o0 o0Var = f4871c;
            o0Var.getClass();
            o0Var.g(null, aVar);
            f = c0.s(f4870b, null, null, new d(2, cVar, 4), 3);
        } catch (Throwable th) {
            throw th;
        }
    }
}
