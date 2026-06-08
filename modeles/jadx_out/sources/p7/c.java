package p7;

import a4.x;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import o7.e1;
import o7.h0;
import o7.l;
import o7.m0;
import o7.o0;
import o7.q1;
import o7.w;
import o7.x1;
import t6.h;
import t7.n;
import t7.o;
import v7.e;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends w implements h0 {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f8466a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f8467b;

    /* renamed from: l, reason: collision with root package name */
    public final c f8468l;

    public c(Handler handler, boolean z9) {
        this.f8466a = handler;
        this.f8467b = z9;
        this.f8468l = z9 ? this : new c(handler, true);
    }

    @Override // o7.w
    public final void dispatch(h hVar, Runnable runnable) {
        if (this.f8466a.post(runnable)) {
            return;
        }
        y(hVar, runnable);
    }

    @Override // o7.h0
    public final o0 e(long j, x1 x1Var, h hVar) {
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.f8466a.postDelayed(x1Var, j)) {
            return new androidx.datastore.core.a(1, this, x1Var);
        }
        y(hVar, x1Var);
        return q1.f8300a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.f8466a == this.f8466a && cVar.f8467b == this.f8467b;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f8466a) ^ (this.f8467b ? 1231 : 1237);
    }

    @Override // o7.h0
    public final void i(long j, l lVar) {
        m4.a aVar = new m4.a(lVar, this, 3, false);
        if (j > 4611686018427387903L) {
            j = 4611686018427387903L;
        }
        if (this.f8466a.postDelayed(aVar, j)) {
            lVar.u(new androidx.work.impl.model.a(9, this, aVar));
        } else {
            y(lVar.f8281n, aVar);
        }
    }

    @Override // o7.w
    public final boolean isDispatchNeeded(h hVar) {
        return (this.f8467b && kotlin.jvm.internal.l.a(Looper.myLooper(), this.f8466a.getLooper())) ? false : true;
    }

    @Override // o7.w
    public final w limitedParallelism(int i, String str) {
        t7.a.a(i);
        return str != null ? new o(this, str) : this;
    }

    @Override // o7.w
    public final String toString() {
        c cVar;
        String str;
        e eVar = m0.f8288a;
        c cVar2 = n.f10348a;
        if (this == cVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                cVar = cVar2.f8468l;
            } catch (UnsupportedOperationException unused) {
                cVar = null;
            }
            str = this == cVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String handler = this.f8466a.toString();
        return this.f8467b ? x.C(handler, ".immediate") : handler;
    }

    public final void y(h hVar, Runnable runnable) {
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        e1 e1Var = (e1) hVar.get(o7.x.f8327b);
        if (e1Var != null) {
            e1Var.c(cancellationException);
        }
        e eVar = m0.f8288a;
        v7.d.f10884a.dispatch(hVar, runnable);
    }
}
