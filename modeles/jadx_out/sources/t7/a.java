package t7;

import c4.j1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import o7.a2;
import o7.c0;
import o7.e1;
import o7.r0;
import o7.v1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final f8.w f10315a = new f8.w("CLOSED");

    /* renamed from: b, reason: collision with root package name */
    public static final f8.w f10316b = new f8.w("UNDEFINED");

    /* renamed from: c, reason: collision with root package name */
    public static final f8.w f10317c = new f8.w("REUSABLE_CLAIMED");

    /* renamed from: d, reason: collision with root package name */
    public static final f8.w f10318d = new f8.w("NO_THREAD_ELEMENTS");

    /* renamed from: e, reason: collision with root package name */
    public static final j1 f10319e = new j1(15);
    public static final j1 f = new j1(16);
    public static final j1 g = new j1(17);

    public static final void a(int i) {
        if (i >= 1) {
            return;
        }
        s1.o.o(androidx.lifecycle.l.u(i, "Expected positive parallelism level, but got "));
    }

    public static final Object b(s sVar, long j, d7.p pVar) {
        while (true) {
            if (sVar.f10355c >= j && !sVar.d()) {
                return sVar;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = b.f10320a;
            Object obj = atomicReferenceFieldUpdater.get(sVar);
            f8.w wVar = f10315a;
            if (obj == wVar) {
                return wVar;
            }
            s sVar2 = (s) ((b) obj);
            if (sVar2 == null) {
                sVar2 = (s) pVar.invoke(Long.valueOf(sVar.f10355c + 1), sVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(sVar, null, sVar2)) {
                    if (atomicReferenceFieldUpdater.get(sVar) != null) {
                        break;
                    }
                }
                if (sVar.d()) {
                    sVar.e();
                }
            }
            sVar = sVar2;
        }
    }

    public static final s c(Object obj) {
        if (obj != f10315a) {
            return (s) obj;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Does not contain segment");
        return null;
    }

    public static final void d(Throwable th, t6.h hVar) {
        Throwable runtimeException;
        Iterator it = d.f10323a.iterator();
        while (it.hasNext()) {
            try {
                ((o7.y) it.next()).n(th);
            } catch (Throwable th2) {
                if (th == th2) {
                    runtimeException = th;
                } else {
                    runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                    p6.a.a(runtimeException, th);
                }
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, runtimeException);
            }
        }
        try {
            p6.a.a(th, new e(hVar));
        } catch (Throwable unused) {
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }

    public static final boolean e(Object obj) {
        return obj == f10315a;
    }

    public static final Object f(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    public static final void g(t6.h hVar, Object obj) {
        if (obj == f10318d) {
            return;
        }
        if (!(obj instanceof y)) {
            Object fold = hVar.fold(null, f);
            fold.getClass();
            ((v) fold).f10359b.set(obj);
            return;
        }
        y yVar = (y) obj;
        v[] vVarArr = yVar.f10366c;
        int length = vVarArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            v vVar = vVarArr[length];
            vVar.getClass();
            vVar.f10359b.set(yVar.f10365b[length]);
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }

    public static final void h(Object obj, t6.c cVar) {
        if (!(cVar instanceof f)) {
            cVar.resumeWith(obj);
            return;
        }
        f fVar = (f) cVar;
        o7.w wVar = fVar.f10326m;
        t6.c cVar2 = fVar.f10327n;
        Throwable a8 = p6.k.a(obj);
        Object uVar = a8 == null ? obj : new o7.u(false, a8);
        if (wVar.isDispatchNeeded(cVar2.getContext())) {
            fVar.f10328o = uVar;
            fVar.f8272l = 1;
            wVar.dispatch(cVar2.getContext(), fVar);
            return;
        }
        r0 a10 = v1.a();
        if (a10.f8302a >= 4294967296L) {
            fVar.f10328o = uVar;
            fVar.f8272l = 1;
            a10.z(fVar);
            return;
        }
        a10.A(true);
        try {
            e1 e1Var = (e1) cVar2.getContext().get(o7.x.f8327b);
            if (e1Var == null || e1Var.b()) {
                Object obj2 = fVar.f10329p;
                t6.h context = cVar2.getContext();
                Object l10 = l(context, obj2);
                a2 B = l10 != f10318d ? c0.B(cVar2, context, l10) : null;
                try {
                    cVar2.resumeWith(obj);
                } finally {
                    if (B == null || B.g0()) {
                        g(context, l10);
                    }
                }
            } else {
                fVar.resumeWith(p6.a.b(e1Var.j()));
            }
            while (a10.C()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static final long i(long j, long j6, long j10, String str) {
        String str2;
        int i = u.f10357a;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException unused) {
            str2 = null;
        }
        if (str2 == null) {
            return j;
        }
        Long i02 = l7.t.i0(str2);
        if (i02 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + str2 + '\'').toString());
        }
        long longValue = i02.longValue();
        if (j6 <= longValue && longValue <= j10) {
            return longValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j6 + ".." + j10 + ", but is '" + longValue + '\'').toString());
    }

    public static int j(int i, int i6, String str) {
        return (int) i(i, 1, (i6 & 8) != 0 ? Integer.MAX_VALUE : 2097150, str);
    }

    public static final Object k(t6.h hVar) {
        Object fold = hVar.fold(0, f10319e);
        fold.getClass();
        return fold;
    }

    public static final Object l(t6.h hVar, Object obj) {
        if (obj == null) {
            obj = k(hVar);
        }
        if (obj == 0) {
            return f10318d;
        }
        if (obj instanceof Integer) {
            return hVar.fold(new y(((Number) obj).intValue(), hVar), g);
        }
        v vVar = (v) obj;
        ThreadLocal threadLocal = vVar.f10359b;
        Object obj2 = threadLocal.get();
        threadLocal.set(vVar.f10358a);
        return obj2;
    }
}
