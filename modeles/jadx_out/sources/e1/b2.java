package e1;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import j$.util.Objects;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class b2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3804a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Serializable f3805b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f3806l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f3807m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f3808n;

    public b2(b3 b3Var, AtomicReference atomicReference, String str, String str2) {
        this.f3804a = 3;
        this.f3806l = atomicReference;
        this.f3805b = str;
        this.f3807m = str2;
        Objects.requireNonNull(b3Var);
        this.f3808n = b3Var;
    }

    private final void a() {
        i0 i0Var;
        w3 w3Var = (w3) this.f3806l;
        AtomicReference atomicReference = (AtomicReference) this.f3805b;
        c5 c5Var = (c5) this.f3808n;
        n4 n4Var = (n4) this.f3807m;
        synchronized (atomicReference) {
            try {
                i0Var = w3Var.f4359m;
            } catch (RemoteException e10) {
                w0 w0Var = w3Var.f3875a.f4264o;
                t1.m(w0Var);
                w0Var.f4339o.c(e10, "[sgtm] Failed to get upload batches; remote exception");
                atomicReference.notifyAll();
            }
            if (i0Var != null) {
                i0Var.g(c5Var, n4Var, new p3(w3Var, atomicReference));
                w3Var.t();
            } else {
                w0 w0Var2 = w3Var.f3875a.f4264o;
                t1.m(w0Var2);
                w0Var2.f4339o.b("[sgtm] Failed to get upload batches; not connected to service");
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:90|91|(5:93|(1:95)|97|98|99)|101|(2:104|102)|105|106|107|108|(2:111|109)|112|113|(1:115)|116|98|99) */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x042a, code lost:
    
        r5.a().f4342r.c(r2, "Failed to parse queued batch. appId");
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x035b, code lost:
    
        if (java.lang.System.currentTimeMillis() >= (r7 + r9)) goto L90;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1160
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.b2.run():void");
    }

    public /* synthetic */ b2(c2 c2Var, Bundle bundle, String str, c5 c5Var) {
        this.f3804a = 2;
        this.f3806l = c2Var;
        this.f3807m = bundle;
        this.f3805b = str;
        this.f3808n = c5Var;
    }

    public /* synthetic */ b2(w3 w3Var, AtomicReference atomicReference, c5 c5Var, n4 n4Var) {
        this.f3804a = 7;
        this.f3806l = w3Var;
        this.f3805b = atomicReference;
        this.f3808n = c5Var;
        this.f3807m = n4Var;
    }

    public /* synthetic */ b2(Object obj, Serializable serializable, l0.a aVar, Object obj2, int i) {
        this.f3804a = i;
        this.f3806l = obj;
        this.f3805b = serializable;
        this.f3807m = aVar;
        this.f3808n = obj2;
    }

    public b2(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.m0 m0Var, u uVar, String str) {
        this.f3804a = 1;
        this.f3806l = m0Var;
        this.f3807m = uVar;
        this.f3805b = str;
        this.f3808n = appMeasurementDynamiteService;
    }

    public /* synthetic */ b2(int i, Object obj, Object obj2, Object obj3, String str) {
        this.f3804a = i;
        this.f3806l = obj2;
        this.f3805b = str;
        this.f3807m = obj3;
        this.f3808n = obj;
    }

    public b2(f0.i iVar, String str, String str2, Bundle bundle) {
        this.f3804a = 8;
        this.f3805b = str;
        this.f3806l = str2;
        this.f3807m = bundle;
        this.f3808n = iVar;
    }
}
