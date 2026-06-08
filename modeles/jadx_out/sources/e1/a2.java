package e1;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3760a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3761b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ c5 f3762l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f3763m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f3764n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f3765o;

    public /* synthetic */ a2(c2 c2Var, c5 c5Var, Bundle bundle, k0 k0Var, String str) {
        this.f3763m = c2Var;
        this.f3762l = c5Var;
        this.f3764n = bundle;
        this.f3765o = k0Var;
        this.f3761b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        w3 w3Var;
        i0 i0Var;
        a5 a5Var;
        i0 i0Var2;
        switch (this.f3760a) {
            case 0:
                c2 c2Var = (c2) this.f3763m;
                c5 c5Var = this.f3762l;
                Bundle bundle = (Bundle) this.f3764n;
                k0 k0Var = (k0) this.f3765o;
                String str = this.f3761b;
                u4 u4Var = c2Var.i;
                u4Var.B();
                try {
                    k0Var.x(u4Var.d0(bundle, c5Var));
                    return;
                } catch (RemoteException e10) {
                    u4Var.a().f4339o.d(str, "Failed to return trigger URIs for app", e10);
                    return;
                }
            case 1:
                AtomicReference atomicReference2 = (AtomicReference) this.f3763m;
                synchronized (atomicReference2) {
                    try {
                        try {
                            w3Var = (w3) this.f3765o;
                            i0Var = w3Var.f4359m;
                        } catch (Throwable th) {
                            ((AtomicReference) this.f3763m).notify();
                            throw th;
                        }
                    } catch (RemoteException e11) {
                        w0 w0Var = ((w3) this.f3765o).f3875a.f4264o;
                        t1.m(w0Var);
                        w0Var.f4339o.e("(legacy) Failed to get conditional properties; remote exception", null, this.f3761b, e11);
                        ((AtomicReference) this.f3763m).set(Collections.EMPTY_LIST);
                        atomicReference = (AtomicReference) this.f3763m;
                    }
                    if (i0Var == null) {
                        w0 w0Var2 = w3Var.f3875a.f4264o;
                        t1.m(w0Var2);
                        w0Var2.f4339o.e("(legacy) Failed to get conditional properties; not connected to service", null, this.f3761b, (String) this.f3764n);
                        atomicReference2.set(Collections.EMPTY_LIST);
                        atomicReference2.notify();
                        return;
                    }
                    if (TextUtils.isEmpty(null)) {
                        atomicReference2.set(i0Var.y(this.f3761b, (String) this.f3764n, this.f3762l));
                    } else {
                        atomicReference2.set(i0Var.o(null, this.f3761b, (String) this.f3764n));
                    }
                    w3Var.t();
                    atomicReference = (AtomicReference) this.f3763m;
                    atomicReference.notify();
                    return;
                }
            default:
                com.google.android.gms.internal.measurement.m0 m0Var = (com.google.android.gms.internal.measurement.m0) this.f3764n;
                String str2 = (String) this.f3763m;
                String str3 = this.f3761b;
                w3 w3Var2 = (w3) this.f3765o;
                ArrayList arrayList = new ArrayList();
                try {
                    try {
                        i0Var2 = w3Var2.f4359m;
                    } catch (Throwable th2) {
                        a5 a5Var2 = w3Var2.f3875a.f4267r;
                        t1.k(a5Var2);
                        a5Var2.V(m0Var, arrayList);
                        throw th2;
                    }
                } catch (RemoteException e12) {
                    w0 w0Var3 = w3Var2.f3875a.f4264o;
                    t1.m(w0Var3);
                    w0Var3.f4339o.e("Failed to get conditional properties; remote exception", str3, str2, e12);
                }
                if (i0Var2 != null) {
                    arrayList = a5.W(i0Var2.y(str3, str2, this.f3762l));
                    w3Var2.t();
                    a5Var = w3Var2.f3875a.f4267r;
                    t1.k(a5Var);
                    a5Var.V(m0Var, arrayList);
                    return;
                }
                t1 t1Var = w3Var2.f3875a;
                w0 w0Var4 = t1Var.f4264o;
                t1.m(w0Var4);
                w0Var4.f4339o.d(str3, "Failed to get conditional properties; not connected to service", str2);
                a5Var = t1Var.f4267r;
                t1.k(a5Var);
                a5Var.V(m0Var, arrayList);
                return;
        }
    }

    public a2(w3 w3Var, String str, String str2, c5 c5Var, com.google.android.gms.internal.measurement.m0 m0Var) {
        this.f3761b = str;
        this.f3763m = str2;
        this.f3762l = c5Var;
        this.f3764n = m0Var;
        this.f3765o = w3Var;
    }

    public a2(w3 w3Var, AtomicReference atomicReference, String str, String str2, c5 c5Var) {
        this.f3763m = atomicReference;
        this.f3761b = str;
        this.f3764n = str2;
        this.f3762l = c5Var;
        this.f3765o = w3Var;
    }
}
