package p6;

import java.lang.reflect.Method;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final u6.a f8432a = u6.a.f10762a;

    public static void a(Throwable th, Throwable th2) {
        th.getClass();
        th2.getClass();
        if (th != th2) {
            Integer num = y6.a.f11807a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = x6.a.f11515a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static final j b(Throwable th) {
        th.getClass();
        return new j(th);
    }

    public static f c(g gVar, d7.a aVar) {
        u uVar = u.f8460a;
        int ordinal = gVar.ordinal();
        if (ordinal == 0) {
            return new m(aVar);
        }
        if (ordinal == 1) {
            l lVar = new l();
            lVar.f8446a = aVar;
            lVar.f8447b = uVar;
            return lVar;
        }
        if (ordinal != 2) {
            com.google.gson.internal.a.b();
            return null;
        }
        y yVar = new y();
        yVar.f8464a = aVar;
        yVar.f8465b = uVar;
        return yVar;
    }

    public static m d(d7.a aVar) {
        aVar.getClass();
        return new m(aVar);
    }

    public static final void e(Object obj) {
        if (obj instanceof j) {
            throw ((j) obj).f8443a;
        }
    }
}
