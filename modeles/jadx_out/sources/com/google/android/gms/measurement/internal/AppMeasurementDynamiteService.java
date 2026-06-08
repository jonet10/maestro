package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.g;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import androidx.work.WorkRequest;
import b5.m;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.internal.measurement.j0;
import com.google.android.gms.internal.measurement.m0;
import com.google.android.gms.internal.measurement.o0;
import com.google.android.gms.internal.measurement.r0;
import com.google.android.gms.internal.measurement.t0;
import com.google.android.gms.internal.measurement.u0;
import e1.a5;
import e1.b2;
import e1.b3;
import e1.b5;
import e1.f3;
import e1.h3;
import e1.j3;
import e1.l2;
import e1.m3;
import e1.m4;
import e1.n0;
import e1.o4;
import e1.q1;
import e1.q2;
import e1.r1;
import e1.r2;
import e1.s2;
import e1.t;
import e1.t1;
import e1.u;
import e1.u2;
import e1.v2;
import e1.w0;
import e1.x2;
import e1.y;
import e1.z0;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import q2.e;
import s0.b;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@DynamiteApi
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class AppMeasurementDynamiteService extends j0 {
    public t1 i;
    public final ArrayMap j;

    public AppMeasurementDynamiteService() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        this.i = null;
        this.j = new ArrayMap();
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void beginAdUnitExposure(@NonNull String str, long j) throws RemoteException {
        c();
        y yVar = this.i.f4271w;
        t1.j(yVar);
        yVar.h(j, str);
    }

    public final void c() {
        if (this.i != null) {
            return;
        }
        a.i("Attempting to perform action before initialize.");
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void clearConditionalUserProperty(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        b3Var.u(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void clearMeasurementEnabled(long j) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        b3Var.h();
        q1 q1Var = b3Var.f3875a.f4265p;
        t1.m(q1Var);
        q1Var.p(new m1.a(b3Var, null, 8, false));
    }

    public final void d(String str, m0 m0Var) {
        c();
        a5 a5Var = this.i.f4267r;
        t1.k(a5Var);
        a5Var.P(str, m0Var);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void endAdUnitExposure(@NonNull String str, long j) throws RemoteException {
        c();
        y yVar = this.i.f4271w;
        t1.j(yVar);
        yVar.i(j, str);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void generateEventId(m0 m0Var) throws RemoteException {
        c();
        a5 a5Var = this.i.f4267r;
        t1.k(a5Var);
        long d02 = a5Var.d0();
        c();
        a5 a5Var2 = this.i.f4267r;
        t1.k(a5Var2);
        a5Var2.Q(m0Var, d02);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void getAppInstanceId(m0 m0Var) throws RemoteException {
        c();
        q1 q1Var = this.i.f4265p;
        t1.m(q1Var);
        q1Var.p(new r1(this, m0Var, 0));
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void getCachedAppInstanceId(m0 m0Var) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        d((String) b3Var.f3813p.get(), m0Var);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void getConditionalUserProperties(String str, String str2, m0 m0Var) throws RemoteException {
        c();
        q1 q1Var = this.i.f4265p;
        t1.m(q1Var);
        q1Var.p(new b2(4, this, m0Var, str2, str));
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void getCurrentScreenClass(m0 m0Var) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        m3 m3Var = b3Var.f3875a.f4270u;
        t1.l(m3Var);
        j3 j3Var = m3Var.f4120l;
        d(j3Var != null ? j3Var.f4058b : null, m0Var);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void getCurrentScreenName(m0 m0Var) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        m3 m3Var = b3Var.f3875a.f4270u;
        t1.l(m3Var);
        j3 j3Var = m3Var.f4120l;
        d(j3Var != null ? j3Var.f4057a : null, m0Var);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void getGmpAppId(m0 m0Var) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        d(b3Var.v(), m0Var);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void getMaxUserProperties(String str, m0 m0Var) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        k0.y.d(str);
        b3Var.f3875a.getClass();
        c();
        a5 a5Var = this.i.f4267r;
        t1.k(a5Var);
        a5Var.R(m0Var, 25);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void getSessionId(m0 m0Var) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        q1 q1Var = b3Var.f3875a.f4265p;
        t1.m(q1Var);
        q1Var.p(new m1.a(b3Var, m0Var));
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void getTestFlag(m0 m0Var, int i) throws RemoteException {
        c();
        if (i == 0) {
            a5 a5Var = this.i.f4267r;
            t1.k(a5Var);
            b3 b3Var = this.i.v;
            t1.l(b3Var);
            AtomicReference atomicReference = new AtomicReference();
            q1 q1Var = b3Var.f3875a.f4265p;
            t1.m(q1Var);
            a5Var.P((String) q1Var.q(atomicReference, 15000L, "String test flag value", new u2(b3Var, atomicReference, 1)), m0Var);
            return;
        }
        if (i == 1) {
            a5 a5Var2 = this.i.f4267r;
            t1.k(a5Var2);
            b3 b3Var2 = this.i.v;
            t1.l(b3Var2);
            AtomicReference atomicReference2 = new AtomicReference();
            q1 q1Var2 = b3Var2.f3875a.f4265p;
            t1.m(q1Var2);
            a5Var2.Q(m0Var, ((Long) q1Var2.q(atomicReference2, 15000L, "long test flag value", new u2(b3Var2, atomicReference2, 2))).longValue());
            return;
        }
        if (i == 2) {
            a5 a5Var3 = this.i.f4267r;
            t1.k(a5Var3);
            b3 b3Var3 = this.i.v;
            t1.l(b3Var3);
            AtomicReference atomicReference3 = new AtomicReference();
            q1 q1Var3 = b3Var3.f3875a.f4265p;
            t1.m(q1Var3);
            double doubleValue = ((Double) q1Var3.q(atomicReference3, 15000L, "double test flag value", new u2(b3Var3, atomicReference3, 4))).doubleValue();
            Bundle bundle = new Bundle();
            bundle.putDouble("r", doubleValue);
            try {
                m0Var.t(bundle);
                return;
            } catch (RemoteException e10) {
                w0 w0Var = a5Var3.f3875a.f4264o;
                t1.m(w0Var);
                w0Var.f4342r.c(e10, "Error returning double value to wrapper");
                return;
            }
        }
        if (i == 3) {
            a5 a5Var4 = this.i.f4267r;
            t1.k(a5Var4);
            b3 b3Var4 = this.i.v;
            t1.l(b3Var4);
            AtomicReference atomicReference4 = new AtomicReference();
            q1 q1Var4 = b3Var4.f3875a.f4265p;
            t1.m(q1Var4);
            a5Var4.R(m0Var, ((Integer) q1Var4.q(atomicReference4, 15000L, "int test flag value", new u2(b3Var4, atomicReference4, 3))).intValue());
            return;
        }
        if (i != 4) {
            return;
        }
        a5 a5Var5 = this.i.f4267r;
        t1.k(a5Var5);
        b3 b3Var5 = this.i.v;
        t1.l(b3Var5);
        AtomicReference atomicReference5 = new AtomicReference();
        q1 q1Var5 = b3Var5.f3875a.f4265p;
        t1.m(q1Var5);
        a5Var5.T(m0Var, ((Boolean) q1Var5.q(atomicReference5, 15000L, "boolean test flag value", new u2(b3Var5, atomicReference5, 0))).booleanValue());
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void getUserProperties(String str, String str2, boolean z9, m0 m0Var) throws RemoteException {
        c();
        q1 q1Var = this.i.f4265p;
        t1.m(q1Var);
        q1Var.p(new r2(this, m0Var, str, str2, z9));
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void initForTests(@NonNull Map map) throws RemoteException {
        c();
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void initialize(s0.a aVar, u0 u0Var, long j) throws RemoteException {
        t1 t1Var = this.i;
        if (t1Var == null) {
            Context context = (Context) b.J(aVar);
            k0.y.g(context);
            this.i = t1.s(context, u0Var, Long.valueOf(j));
        } else {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.b("Attempting to initialize multiple times");
        }
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void isDataCollectionEnabled(m0 m0Var) throws RemoteException {
        c();
        q1 q1Var = this.i.f4265p;
        t1.m(q1Var);
        q1Var.p(new r1(this, m0Var, 1));
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void logEvent(@NonNull String str, @NonNull String str2, @NonNull Bundle bundle, boolean z9, boolean z10, long j) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        b3Var.l(str, str2, bundle, z9, z10, j);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void logEventAndBundle(String str, String str2, Bundle bundle, m0 m0Var, long j) throws RemoteException {
        c();
        k0.y.d(str2);
        (bundle != null ? new Bundle(bundle) : new Bundle()).putString("_o", "app");
        u uVar = new u(str2, new t(bundle), "app", j);
        q1 q1Var = this.i.f4265p;
        t1.m(q1Var);
        q1Var.p(new b2(this, m0Var, uVar, str));
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void logHealthData(int i, @NonNull String str, @NonNull s0.a aVar, @NonNull s0.a aVar2, @NonNull s0.a aVar3) throws RemoteException {
        c();
        Object J = aVar == null ? null : b.J(aVar);
        Object J2 = aVar2 == null ? null : b.J(aVar2);
        Object J3 = aVar3 != null ? b.J(aVar3) : null;
        w0 w0Var = this.i.f4264o;
        t1.m(w0Var);
        w0Var.p(i, true, false, str, J, J2, J3);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void onActivityCreated(@NonNull s0.a aVar, @NonNull Bundle bundle, long j) throws RemoteException {
        c();
        Activity activity = (Activity) b.J(aVar);
        k0.y.g(activity);
        onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.w0.c(activity), bundle, j);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void onActivityCreatedByScionActivityInfo(com.google.android.gms.internal.measurement.w0 w0Var, Bundle bundle, long j) {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        x2 x2Var = b3Var.f3809l;
        if (x2Var != null) {
            b3 b3Var2 = this.i.v;
            t1.l(b3Var2);
            b3Var2.z();
            x2Var.j(w0Var, bundle);
        }
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void onActivityDestroyed(@NonNull s0.a aVar, long j) throws RemoteException {
        c();
        Activity activity = (Activity) b.J(aVar);
        k0.y.g(activity);
        onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.w0.c(activity), j);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void onActivityDestroyedByScionActivityInfo(com.google.android.gms.internal.measurement.w0 w0Var, long j) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        x2 x2Var = b3Var.f3809l;
        if (x2Var != null) {
            b3 b3Var2 = this.i.v;
            t1.l(b3Var2);
            b3Var2.z();
            x2Var.k(w0Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void onActivityPaused(@NonNull s0.a aVar, long j) throws RemoteException {
        c();
        Activity activity = (Activity) b.J(aVar);
        k0.y.g(activity);
        onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.w0.c(activity), j);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void onActivityPausedByScionActivityInfo(com.google.android.gms.internal.measurement.w0 w0Var, long j) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        x2 x2Var = b3Var.f3809l;
        if (x2Var != null) {
            b3 b3Var2 = this.i.v;
            t1.l(b3Var2);
            b3Var2.z();
            x2Var.l(w0Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void onActivityResumed(@NonNull s0.a aVar, long j) throws RemoteException {
        c();
        Activity activity = (Activity) b.J(aVar);
        k0.y.g(activity);
        onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.w0.c(activity), j);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void onActivityResumedByScionActivityInfo(com.google.android.gms.internal.measurement.w0 w0Var, long j) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        x2 x2Var = b3Var.f3809l;
        if (x2Var != null) {
            b3 b3Var2 = this.i.v;
            t1.l(b3Var2);
            b3Var2.z();
            x2Var.m(w0Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void onActivitySaveInstanceState(s0.a aVar, m0 m0Var, long j) throws RemoteException {
        c();
        Activity activity = (Activity) b.J(aVar);
        k0.y.g(activity);
        onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.w0.c(activity), m0Var, j);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void onActivitySaveInstanceStateByScionActivityInfo(com.google.android.gms.internal.measurement.w0 w0Var, m0 m0Var, long j) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        x2 x2Var = b3Var.f3809l;
        Bundle bundle = new Bundle();
        if (x2Var != null) {
            b3 b3Var2 = this.i.v;
            t1.l(b3Var2);
            b3Var2.z();
            x2Var.n(w0Var, bundle);
        }
        try {
            m0Var.t(bundle);
        } catch (RemoteException e10) {
            w0 w0Var2 = this.i.f4264o;
            t1.m(w0Var2);
            w0Var2.f4342r.c(e10, "Error returning bundle value to wrapper");
        }
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void onActivityStarted(@NonNull s0.a aVar, long j) throws RemoteException {
        c();
        Activity activity = (Activity) b.J(aVar);
        k0.y.g(activity);
        onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.w0.c(activity), j);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void onActivityStartedByScionActivityInfo(com.google.android.gms.internal.measurement.w0 w0Var, long j) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        if (b3Var.f3809l != null) {
            b3 b3Var2 = this.i.v;
            t1.l(b3Var2);
            b3Var2.z();
        }
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void onActivityStopped(@NonNull s0.a aVar, long j) throws RemoteException {
        c();
        Activity activity = (Activity) b.J(aVar);
        k0.y.g(activity);
        onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.w0.c(activity), j);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void onActivityStoppedByScionActivityInfo(com.google.android.gms.internal.measurement.w0 w0Var, long j) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        if (b3Var.f3809l != null) {
            b3 b3Var2 = this.i.v;
            t1.l(b3Var2);
            b3Var2.z();
        }
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void performAction(Bundle bundle, m0 m0Var, long j) throws RemoteException {
        c();
        m0Var.t(null);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void registerOnMeasurementEventListener(r0 r0Var) throws RemoteException {
        Object obj;
        c();
        ArrayMap arrayMap = this.j;
        synchronized (arrayMap) {
            try {
                obj = (l2) arrayMap.get(Integer.valueOf(r0Var.b()));
                if (obj == null) {
                    obj = new b5(this, r0Var);
                    arrayMap.put(Integer.valueOf(r0Var.b()), obj);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        b3Var.h();
        if (b3Var.f3811n.add(obj)) {
            return;
        }
        w0 w0Var = b3Var.f3875a.f4264o;
        t1.m(w0Var);
        w0Var.f4342r.b("OnEventListener already registered");
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void resetAnalyticsData(long j) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        b3Var.f3813p.set(null);
        q1 q1Var = b3Var.f3875a.f4265p;
        t1.m(q1Var);
        q1Var.p(new s2(b3Var, j, 1));
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void retrieveAndUploadBatches(o0 o0Var) {
        h3 h3Var;
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        b3Var.h();
        t1 t1Var = b3Var.f3875a;
        q1 q1Var = t1Var.f4265p;
        t1.m(q1Var);
        if (q1Var.m()) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.b("Cannot retrieve and upload batches from analytics worker thread");
            return;
        }
        q1 q1Var2 = t1Var.f4265p;
        t1.m(q1Var2);
        if (Thread.currentThread() == q1Var2.f4204m) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4339o.b("Cannot retrieve and upload batches from analytics network thread");
            return;
        }
        boolean g = e.g();
        w0 w0Var3 = t1Var.f4264o;
        if (g) {
            t1.m(w0Var3);
            w0Var3.f4339o.b("Cannot retrieve and upload batches from main thread");
            return;
        }
        t1.m(w0Var3);
        w0Var3.f4346w.b("[sgtm] Started client-side batch upload work.");
        boolean z9 = false;
        int i = 0;
        int i6 = 0;
        while (!z9) {
            w0 w0Var4 = t1Var.f4264o;
            t1.m(w0Var4);
            w0Var4.f4346w.b("[sgtm] Getting upload batches from service (FE)");
            AtomicReference atomicReference = new AtomicReference();
            q1 q1Var3 = t1Var.f4265p;
            t1.m(q1Var3);
            q1Var3.q(atomicReference, WorkRequest.MIN_BACKOFF_MILLIS, "[sgtm] Getting upload batches", new u2(b3Var, atomicReference, 6, false));
            o4 o4Var = (o4) atomicReference.get();
            if (o4Var == null) {
                break;
            }
            List list = o4Var.f4180a;
            if (list.isEmpty()) {
                break;
            }
            w0 w0Var5 = t1Var.f4264o;
            t1.m(w0Var5);
            w0Var5.f4346w.c(Integer.valueOf(list.size()), "[sgtm] Retrieved upload batches. count");
            i += list.size();
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z9 = false;
                    break;
                }
                m4 m4Var = (m4) it.next();
                try {
                    URL url = new URI(m4Var.f4132l).toURL();
                    AtomicReference atomicReference2 = new AtomicReference();
                    n0 r9 = b3Var.f3875a.r();
                    r9.h();
                    k0.y.g(r9.f4145p);
                    String str = r9.f4145p;
                    t1 t1Var2 = b3Var.f3875a;
                    w0 w0Var6 = t1Var2.f4264o;
                    t1.m(w0Var6);
                    e1.u0 u0Var = w0Var6.f4346w;
                    Long valueOf = Long.valueOf(m4Var.f4130a);
                    u0Var.e("[sgtm] Uploading data from app. row_id, url, uncompressed size", valueOf, m4Var.f4132l, Integer.valueOf(m4Var.f4131b.length));
                    if (!TextUtils.isEmpty(m4Var.f4136p)) {
                        w0 w0Var7 = t1Var2.f4264o;
                        t1.m(w0Var7);
                        w0Var7.f4346w.d(valueOf, "[sgtm] Uploading data from app. row_id", m4Var.f4136p);
                    }
                    HashMap hashMap = new HashMap();
                    Bundle bundle = m4Var.f4133m;
                    for (String str2 : bundle.keySet()) {
                        String string = bundle.getString(str2);
                        if (!TextUtils.isEmpty(string)) {
                            hashMap.put(str2, string);
                        }
                    }
                    f3 f3Var = t1Var2.f4272x;
                    t1.m(f3Var);
                    byte[] bArr = m4Var.f4131b;
                    m mVar = new m(b3Var, atomicReference2, m4Var, 9);
                    f3Var.i();
                    k0.y.g(url);
                    k0.y.g(bArr);
                    q1 q1Var4 = f3Var.f3875a.f4265p;
                    t1.m(q1Var4);
                    q1Var4.s(new z0(f3Var, str, url, bArr, hashMap, mVar));
                    try {
                        a5 a5Var = t1Var2.f4267r;
                        t1.k(a5Var);
                        t1 t1Var3 = a5Var.f3875a;
                        t1Var3.f4269t.getClass();
                        long currentTimeMillis = System.currentTimeMillis() + 60000;
                        synchronized (atomicReference2) {
                            for (long j = 60000; atomicReference2.get() == null && j > 0; j = currentTimeMillis - System.currentTimeMillis()) {
                                try {
                                    atomicReference2.wait(j);
                                    t1Var3.f4269t.getClass();
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        }
                    } catch (InterruptedException unused) {
                        w0 w0Var8 = b3Var.f3875a.f4264o;
                        t1.m(w0Var8);
                        w0Var8.f4342r.b("[sgtm] Interrupted waiting for uploading batch");
                    }
                    h3Var = atomicReference2.get() == null ? h3.UNKNOWN : (h3) atomicReference2.get();
                } catch (MalformedURLException | URISyntaxException e10) {
                    w0 w0Var9 = b3Var.f3875a.f4264o;
                    t1.m(w0Var9);
                    w0Var9.f4339o.e("[sgtm] Bad upload url for row_id", m4Var.f4132l, Long.valueOf(m4Var.f4130a), e10);
                    h3Var = h3.FAILURE;
                }
                if (h3Var != h3.SUCCESS) {
                    if (h3Var == h3.BACKOFF) {
                        z9 = true;
                        break;
                    }
                } else {
                    i6++;
                }
            }
        }
        w0 w0Var10 = t1Var.f4264o;
        t1.m(w0Var10);
        w0Var10.f4346w.d(Integer.valueOf(i), "[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(i6));
        try {
            o0Var.e();
        } catch (RemoteException e11) {
            t1 t1Var4 = this.i;
            k0.y.g(t1Var4);
            w0 w0Var11 = t1Var4.f4264o;
            t1.m(w0Var11);
            w0Var11.f4342r.c(e11, "Failed to call IDynamiteUploadBatchesCallback");
        }
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void setConditionalUserProperty(@NonNull Bundle bundle, long j) throws RemoteException {
        c();
        t1 t1Var = this.i;
        if (bundle == null) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.b("Conditional user property must not be null");
        } else {
            b3 b3Var = t1Var.v;
            t1.l(b3Var);
            b3Var.t(bundle, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void setConsentThirdParty(@NonNull Bundle bundle, long j) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        b3Var.A(bundle, -20, j);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void setCurrentScreen(@NonNull s0.a aVar, @NonNull String str, @NonNull String str2, long j) throws RemoteException {
        c();
        Activity activity = (Activity) b.J(aVar);
        k0.y.g(activity);
        setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.w0.c(activity), str, str2, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0086, code lost:
    
        if (r3 <= 500) goto L31;
     */
    @Override // com.google.android.gms.internal.measurement.k0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.w0 r6, java.lang.String r7, java.lang.String r8, long r9) throws android.os.RemoteException {
        /*
            r5 = this;
            r5.c()
            e1.t1 r9 = r5.i
            e1.m3 r9 = r9.f4270u
            e1.t1.l(r9)
            e1.t1 r10 = r9.f3875a
            e1.g r0 = r10.f4262m
            boolean r0 = r0.u()
            if (r0 != 0) goto L21
            e1.w0 r6 = r10.f4264o
            e1.t1.m(r6)
            e1.u0 r6 = r6.f4344t
            java.lang.String r7 = "setCurrentScreen cannot be called while screen reporting is disabled."
            r6.b(r7)
            return
        L21:
            e1.j3 r0 = r9.f4120l
            if (r0 != 0) goto L32
            e1.w0 r6 = r10.f4264o
            e1.t1.m(r6)
            e1.u0 r6 = r6.f4344t
            java.lang.String r7 = "setCurrentScreen cannot be called while no activity active"
            r6.b(r7)
            return
        L32:
            j$.util.concurrent.ConcurrentHashMap r1 = r9.f4123o
            int r2 = r6.f2882a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r3 = r1.get(r2)
            if (r3 != 0) goto L4d
            e1.w0 r6 = r10.f4264o
            e1.t1.m(r6)
            e1.u0 r6 = r6.f4344t
            java.lang.String r7 = "setCurrentScreen must be called with an activity in the activity lifecycle"
            r6.b(r7)
            return
        L4d:
            if (r8 != 0) goto L55
            java.lang.String r8 = r6.f2883b
            java.lang.String r8 = r9.n(r8)
        L55:
            java.lang.String r3 = r0.f4058b
            java.lang.String r0 = r0.f4057a
            boolean r3 = j$.util.Objects.equals(r3, r8)
            boolean r0 = j$.util.Objects.equals(r0, r7)
            if (r3 == 0) goto L73
            if (r0 != 0) goto L66
            goto L73
        L66:
            e1.w0 r6 = r10.f4264o
            e1.t1.m(r6)
            e1.u0 r6 = r6.f4344t
            java.lang.String r7 = "setCurrentScreen cannot be called with the same class and name"
            r6.b(r7)
            return
        L73:
            r0 = 500(0x1f4, float:7.0E-43)
            if (r7 == 0) goto L9e
            int r3 = r7.length()
            if (r3 <= 0) goto L89
            int r3 = r7.length()
            e1.g r4 = r10.f4262m
            r4.getClass()
            if (r3 > r0) goto L89
            goto L9e
        L89:
            e1.w0 r6 = r10.f4264o
            e1.t1.m(r6)
            e1.u0 r6 = r6.f4344t
            int r7 = r7.length()
            java.lang.String r8 = "Invalid screen name length in setCurrentScreen. Length"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6.c(r7, r8)
            return
        L9e:
            int r3 = r8.length()
            if (r3 <= 0) goto Ld9
            int r3 = r8.length()
            e1.g r4 = r10.f4262m
            r4.getClass()
            if (r3 > r0) goto Ld9
            e1.w0 r0 = r10.f4264o
            e1.t1.m(r0)
            e1.u0 r0 = r0.f4346w
            if (r7 != 0) goto Lbb
            java.lang.String r3 = "null"
            goto Lbc
        Lbb:
            r3 = r7
        Lbc:
            java.lang.String r4 = "Setting current screen to name, class"
            r0.d(r3, r4, r8)
            e1.j3 r0 = new e1.j3
            e1.a5 r10 = r10.f4267r
            e1.t1.k(r10)
            long r3 = r10.d0()
            r0.<init>(r3, r7, r8)
            r1.put(r2, r0)
            java.lang.String r6 = r6.f2883b
            r7 = 1
            r9.p(r6, r0, r7)
            return
        Ld9:
            e1.w0 r6 = r10.f4264o
            e1.t1.m(r6)
            e1.u0 r6 = r6.f4344t
            int r7 = r8.length()
            java.lang.String r8 = "Invalid class name length in setCurrentScreen. Length"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6.c(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.AppMeasurementDynamiteService.setCurrentScreenByScionActivityInfo(com.google.android.gms.internal.measurement.w0, java.lang.String, java.lang.String, long):void");
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void setDataCollectionEnabled(boolean z9) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        b3Var.h();
        q1 q1Var = b3Var.f3875a.f4265p;
        t1.m(q1Var);
        q1Var.p(new q2(b3Var, z9));
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void setDefaultEventParameters(@NonNull Bundle bundle) {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        q1 q1Var = b3Var.f3875a.f4265p;
        t1.m(q1Var);
        q1Var.p(new v2(b3Var, bundle2, 2));
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void setEventInterceptor(r0 r0Var) throws RemoteException {
        c();
        g gVar = new g(this, r0Var, 9, false);
        q1 q1Var = this.i.f4265p;
        t1.m(q1Var);
        boolean m10 = q1Var.m();
        t1 t1Var = this.i;
        if (!m10) {
            q1 q1Var2 = t1Var.f4265p;
            t1.m(q1Var2);
            q1Var2.p(new m1.a(this, gVar, 10, false));
            return;
        }
        b3 b3Var = t1Var.v;
        t1.l(b3Var);
        b3Var.g();
        b3Var.h();
        g gVar2 = b3Var.f3810m;
        if (gVar != gVar2) {
            k0.y.i(gVar2 == null, "EventInterceptor already set.");
        }
        b3Var.f3810m = gVar;
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void setInstanceIdProvider(t0 t0Var) throws RemoteException {
        c();
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void setMeasurementEnabled(boolean z9, long j) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        Boolean valueOf = Boolean.valueOf(z9);
        b3Var.h();
        q1 q1Var = b3Var.f3875a.f4265p;
        t1.m(q1Var);
        q1Var.p(new m1.a(b3Var, valueOf, 8, false));
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void setMinimumSessionDuration(long j) throws RemoteException {
        c();
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void setSessionTimeoutDuration(long j) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        q1 q1Var = b3Var.f3875a.f4265p;
        t1.m(q1Var);
        q1Var.p(new s2(b3Var, j, 0));
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void setSgtmDebugInfo(@NonNull Intent intent) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        t1 t1Var = b3Var.f3875a;
        Uri data = intent.getData();
        if (data == null) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4345u.b("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter == null || !queryParameter.equals("1")) {
            w0 w0Var2 = t1Var.f4264o;
            t1.m(w0Var2);
            w0Var2.f4345u.b("[sgtm] Preview Mode was not enabled.");
            t1Var.f4262m.f3978l = null;
            return;
        }
        String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
        if (TextUtils.isEmpty(queryParameter2)) {
            return;
        }
        w0 w0Var3 = t1Var.f4264o;
        t1.m(w0Var3);
        w0Var3.f4345u.c(queryParameter2, "[sgtm] Preview Mode was enabled. Using the sgtmPreviewKey: ");
        t1Var.f4262m.f3978l = queryParameter2;
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void setUserId(@NonNull String str, long j) throws RemoteException {
        c();
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        t1 t1Var = b3Var.f3875a;
        if (str != null && TextUtils.isEmpty(str)) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4342r.b("User ID must be non-empty or null");
        } else {
            q1 q1Var = t1Var.f4265p;
            t1.m(q1Var);
            q1Var.p(new m1.a(11, b3Var, str));
            b3Var.q(null, "_id", str, true, j);
        }
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull s0.a aVar, boolean z9, long j) throws RemoteException {
        c();
        Object J = b.J(aVar);
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        b3Var.q(str, str2, J, z9, j);
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void unregisterOnMeasurementEventListener(r0 r0Var) throws RemoteException {
        Object obj;
        c();
        ArrayMap arrayMap = this.j;
        synchronized (arrayMap) {
            obj = (l2) arrayMap.remove(Integer.valueOf(r0Var.b()));
        }
        if (obj == null) {
            obj = new b5(this, r0Var);
        }
        b3 b3Var = this.i.v;
        t1.l(b3Var);
        b3Var.h();
        if (b3Var.f3811n.remove(obj)) {
            return;
        }
        w0 w0Var = b3Var.f3875a.f4264o;
        t1.m(w0Var);
        w0Var.f4342r.b("OnEventListener had not been registered");
    }

    @Override // com.google.android.gms.internal.measurement.k0
    public void setConsent(@NonNull Bundle bundle, long j) throws RemoteException {
    }
}
