package e1;

import android.os.RemoteException;
import j$.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4392a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4393b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f4394l;

    /* renamed from: m, reason: collision with root package name */
    public final Object f4395m;

    public x1(w3 w3Var, AtomicReference atomicReference, c5 c5Var) {
        this.f4392a = 5;
        this.f4395m = atomicReference;
        this.f4393b = c5Var;
        Objects.requireNonNull(w3Var);
        this.f4394l = w3Var;
    }

    private final void a() {
        AtomicReference atomicReference;
        w3 w3Var;
        t1 t1Var;
        g1 g1Var;
        AtomicReference atomicReference2 = (AtomicReference) this.f4395m;
        synchronized (atomicReference2) {
            try {
                try {
                    w3Var = (w3) this.f4394l;
                    t1Var = w3Var.f3875a;
                    g1Var = t1Var.f4263n;
                    t1.k(g1Var);
                } catch (RemoteException e10) {
                    w0 w0Var = ((w3) this.f4394l).f3875a.f4264o;
                    t1.m(w0Var);
                    w0Var.f4339o.c(e10, "Failed to get app instance id");
                    atomicReference = (AtomicReference) this.f4395m;
                }
                if (g1Var.n().i(i2.ANALYTICS_STORAGE)) {
                    i0 i0Var = w3Var.f4359m;
                    if (i0Var != null) {
                        atomicReference2.set(i0Var.z((c5) this.f4393b));
                        String str = (String) atomicReference2.get();
                        if (str != null) {
                            b3 b3Var = w3Var.f3875a.v;
                            t1.l(b3Var);
                            b3Var.f3813p.set(str);
                            g1 g1Var2 = t1Var.f4263n;
                            t1.k(g1Var2);
                            g1Var2.f3985p.o(str);
                        }
                        w3Var.t();
                        atomicReference = (AtomicReference) this.f4395m;
                        atomicReference.notify();
                        return;
                    }
                    w0 w0Var2 = t1Var.f4264o;
                    t1.m(w0Var2);
                    w0Var2.f4339o.b("Failed to get app instance id");
                } else {
                    w0 w0Var3 = t1Var.f4264o;
                    t1.m(w0Var3);
                    w0Var3.f4344t.b("Analytics storage consent denied; will not get app instance id");
                    b3 b3Var2 = w3Var.f3875a.v;
                    t1.l(b3Var2);
                    b3Var2.f3813p.set(null);
                    g1 g1Var3 = t1Var.f4263n;
                    t1.k(g1Var3);
                    g1Var3.f3985p.o(null);
                    atomicReference2.set(null);
                }
                atomicReference2.notify();
            } catch (Throwable th) {
                ((AtomicReference) this.f4395m).notify();
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:150:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0307  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.x1.run():void");
    }

    public /* synthetic */ x1(Object obj, Object obj2, Object obj3, int i) {
        this.f4392a = i;
        this.f4395m = obj2;
        this.f4393b = obj3;
        this.f4394l = obj;
    }

    public /* synthetic */ x1(Object obj, Object obj2, Object obj3, int i, boolean z9) {
        this.f4392a = i;
        this.f4395m = obj;
        this.f4393b = obj2;
        this.f4394l = obj3;
    }

    public /* synthetic */ x1(Object obj, c5 c5Var, Object obj2, int i) {
        this.f4392a = i;
        this.f4394l = obj;
        this.f4393b = c5Var;
        this.f4395m = obj2;
    }
}
