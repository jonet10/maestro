package c1;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.collection.ArrayMap;
import androidx.lifecycle.CoroutineLiveDataKt;
import e1.a5;
import e1.b2;
import e1.b3;
import e1.j3;
import e1.m3;
import e1.q1;
import e1.r2;
import e1.t1;
import e1.w0;
import e1.x4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import k0.y;
import q2.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends c {

    /* renamed from: a, reason: collision with root package name */
    public final t1 f1180a;

    /* renamed from: b, reason: collision with root package name */
    public final b3 f1181b;

    public a(t1 t1Var) {
        y.g(t1Var);
        this.f1180a = t1Var;
        b3 b3Var = t1Var.v;
        t1.l(b3Var);
        this.f1181b = b3Var;
    }

    @Override // e1.c3
    public final void a(String str, String str2, Bundle bundle) {
        b3 b3Var = this.f1181b;
        b3Var.f3875a.f4269t.getClass();
        b3Var.l(str, str2, bundle, true, true, System.currentTimeMillis());
    }

    @Override // e1.c3
    public final String b() {
        m3 m3Var = this.f1181b.f3875a.f4270u;
        t1.l(m3Var);
        j3 j3Var = m3Var.f4120l;
        if (j3Var != null) {
            return j3Var.f4057a;
        }
        return null;
    }

    @Override // e1.c3
    public final String c() {
        m3 m3Var = this.f1181b.f3875a.f4270u;
        t1.l(m3Var);
        j3 j3Var = m3Var.f4120l;
        if (j3Var != null) {
            return j3Var.f4058b;
        }
        return null;
    }

    @Override // e1.c3
    public final void d(Bundle bundle) {
        b3 b3Var = this.f1181b;
        b3Var.f3875a.f4269t.getClass();
        b3Var.t(bundle, System.currentTimeMillis());
    }

    @Override // e1.c3
    public final void e(String str) {
        t1 t1Var = this.f1180a;
        e1.y yVar = t1Var.f4271w;
        t1.j(yVar);
        t1Var.f4269t.getClass();
        yVar.i(SystemClock.elapsedRealtime(), str);
    }

    @Override // e1.c3
    public final void f(String str) {
        t1 t1Var = this.f1180a;
        e1.y yVar = t1Var.f4271w;
        t1.j(yVar);
        t1Var.f4269t.getClass();
        yVar.h(SystemClock.elapsedRealtime(), str);
    }

    @Override // e1.c3
    public final long g() {
        a5 a5Var = this.f1180a.f4267r;
        t1.k(a5Var);
        return a5Var.d0();
    }

    @Override // e1.c3
    public final void h(String str, String str2, Bundle bundle) {
        b3 b3Var = this.f1180a.v;
        t1.l(b3Var);
        b3Var.u(str, str2, bundle);
    }

    @Override // e1.c3
    public final List i(String str, String str2) {
        b3 b3Var = this.f1181b;
        t1 t1Var = b3Var.f3875a;
        q1 q1Var = t1Var.f4265p;
        w0 w0Var = t1Var.f4264o;
        t1.m(q1Var);
        if (q1Var.m()) {
            t1.m(w0Var);
            w0Var.f4339o.b("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        if (e.g()) {
            t1.m(w0Var);
            w0Var.f4339o.b("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        q1 q1Var2 = t1Var.f4265p;
        t1.m(q1Var2);
        q1Var2.q(atomicReference, CoroutineLiveDataKt.DEFAULT_TIMEOUT, "get conditional user properties", new b2(b3Var, atomicReference, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return a5.W(list);
        }
        t1.m(w0Var);
        w0Var.f4339o.c(null, "Timed out waiting for get conditional user properties");
        return new ArrayList();
    }

    @Override // e1.c3
    public final int j(String str) {
        b3 b3Var = this.f1181b;
        b3Var.getClass();
        y.d(str);
        b3Var.f3875a.getClass();
        return 25;
    }

    @Override // e1.c3
    public final String k() {
        return (String) this.f1181b.f3813p.get();
    }

    @Override // e1.c3
    public final String l() {
        return this.f1181b.v();
    }

    @Override // e1.c3
    public final Map m(String str, String str2, boolean z9) {
        b3 b3Var = this.f1181b;
        t1 t1Var = b3Var.f3875a;
        q1 q1Var = t1Var.f4265p;
        w0 w0Var = t1Var.f4264o;
        t1.m(q1Var);
        if (q1Var.m()) {
            t1.m(w0Var);
            w0Var.f4339o.b("Cannot get user properties from analytics worker thread");
            return Collections.EMPTY_MAP;
        }
        if (e.g()) {
            t1.m(w0Var);
            w0Var.f4339o.b("Cannot get user properties from main thread");
            return Collections.EMPTY_MAP;
        }
        AtomicReference atomicReference = new AtomicReference();
        q1 q1Var2 = t1Var.f4265p;
        t1.m(q1Var2);
        q1Var2.q(atomicReference, CoroutineLiveDataKt.DEFAULT_TIMEOUT, "get user properties", new r2(b3Var, atomicReference, str, str2, z9));
        List<x4> list = (List) atomicReference.get();
        if (list == null) {
            t1.m(w0Var);
            w0Var.f4339o.c(Boolean.valueOf(z9), "Timed out waiting for handle get user properties, includeInternal");
            return Collections.EMPTY_MAP;
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (x4 x4Var : list) {
            Object c9 = x4Var.c();
            if (c9 != null) {
                arrayMap.put(x4Var.f4402b, c9);
            }
        }
        return arrayMap;
    }
}
