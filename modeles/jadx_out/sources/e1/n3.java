package e1;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n3 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4159a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4160b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f4161l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c5 f4162m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f4163n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ w3 f4164o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f4165p;

    public n3(w3 w3Var, String str, String str2, c5 c5Var, boolean z9, com.google.android.gms.internal.measurement.m0 m0Var) {
        this.f4160b = str;
        this.f4161l = str2;
        this.f4162m = c5Var;
        this.f4163n = z9;
        this.f4165p = m0Var;
        this.f4164o = w3Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a5 a5Var;
        i0 i0Var;
        t1 t1Var;
        AtomicReference atomicReference;
        w3 w3Var;
        i0 i0Var2;
        switch (this.f4159a) {
            case 0:
                String str = this.f4161l;
                String str2 = this.f4160b;
                com.google.android.gms.internal.measurement.m0 m0Var = (com.google.android.gms.internal.measurement.m0) this.f4165p;
                w3 w3Var2 = this.f4164o;
                Bundle bundle = new Bundle();
                try {
                    try {
                        i0Var = w3Var2.f4359m;
                        t1Var = w3Var2.f3875a;
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (RemoteException e10) {
                    e = e10;
                }
                if (i0Var == null) {
                    w0 w0Var = t1Var.f4264o;
                    t1.m(w0Var);
                    w0Var.f4339o.d(str2, "Failed to get user properties; not connected to service", str);
                    a5Var = t1Var.f4267r;
                    t1.k(a5Var);
                    a5Var.U(m0Var, bundle);
                    return;
                }
                List<x4> E = i0Var.E(str2, str, this.f4163n, this.f4162m);
                Bundle bundle2 = new Bundle();
                if (E != null) {
                    for (x4 x4Var : E) {
                        String str3 = x4Var.f4405n;
                        String str4 = x4Var.f4402b;
                        if (str3 != null) {
                            bundle2.putString(str4, str3);
                        } else {
                            Long l10 = x4Var.f4404m;
                            if (l10 != null) {
                                bundle2.putLong(str4, l10.longValue());
                            } else {
                                Double d10 = x4Var.f4407p;
                                if (d10 != null) {
                                    bundle2.putDouble(str4, d10.doubleValue());
                                }
                            }
                        }
                    }
                }
                try {
                    w3Var2.t();
                    a5 a5Var2 = t1Var.f4267r;
                    t1.k(a5Var2);
                    a5Var2.U(m0Var, bundle2);
                    return;
                } catch (RemoteException e11) {
                    e = e11;
                    bundle = bundle2;
                    w0 w0Var2 = w3Var2.f3875a.f4264o;
                    t1.m(w0Var2);
                    w0Var2.f4339o.d(str2, "Failed to get user properties; remote exception", e);
                    a5Var = w3Var2.f3875a.f4267r;
                    t1.k(a5Var);
                    a5Var.U(m0Var, bundle);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    bundle = bundle2;
                    a5 a5Var3 = w3Var2.f3875a.f4267r;
                    t1.k(a5Var3);
                    a5Var3.U(m0Var, bundle);
                    throw th;
                }
            default:
                AtomicReference atomicReference2 = (AtomicReference) this.f4165p;
                synchronized (atomicReference2) {
                    try {
                        try {
                            w3Var = this.f4164o;
                            i0Var2 = w3Var.f4359m;
                        } catch (RemoteException e12) {
                            w0 w0Var3 = this.f4164o.f3875a.f4264o;
                            t1.m(w0Var3);
                            w0Var3.f4339o.e("(legacy) Failed to get user properties; remote exception", null, this.f4160b, e12);
                            ((AtomicReference) this.f4165p).set(Collections.EMPTY_LIST);
                            atomicReference = (AtomicReference) this.f4165p;
                        }
                        if (i0Var2 == null) {
                            w0 w0Var4 = w3Var.f3875a.f4264o;
                            t1.m(w0Var4);
                            w0Var4.f4339o.e("(legacy) Failed to get user properties; not connected to service", null, this.f4160b, this.f4161l);
                            atomicReference2.set(Collections.EMPTY_LIST);
                            atomicReference2.notify();
                            return;
                        }
                        if (TextUtils.isEmpty(null)) {
                            atomicReference2.set(i0Var2.E(this.f4160b, this.f4161l, this.f4163n, this.f4162m));
                        } else {
                            atomicReference2.set(i0Var2.h(null, this.f4160b, this.f4161l, this.f4163n));
                        }
                        w3Var.t();
                        atomicReference = (AtomicReference) this.f4165p;
                        atomicReference.notify();
                        return;
                    } catch (Throwable th3) {
                        ((AtomicReference) this.f4165p).notify();
                        throw th3;
                    }
                }
        }
    }

    public n3(w3 w3Var, AtomicReference atomicReference, String str, String str2, c5 c5Var, boolean z9) {
        this.f4165p = atomicReference;
        this.f4160b = str;
        this.f4161l = str2;
        this.f4162m = c5Var;
        this.f4163n = z9;
        this.f4164o = w3Var;
    }
}
