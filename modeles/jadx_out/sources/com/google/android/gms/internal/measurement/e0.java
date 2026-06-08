package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    public final y2.s f2546a;

    /* renamed from: b, reason: collision with root package name */
    public y2.s f2547b;

    /* renamed from: c, reason: collision with root package name */
    public final b5.m f2548c;

    /* renamed from: d, reason: collision with root package name */
    public final t f2549d;

    public e0() {
        y2.s sVar = new y2.s(3);
        this.f2546a = sVar;
        this.f2547b = ((y2.s) sVar.f11756l).L();
        this.f2548c = new b5.m(5);
        this.f2549d = new t(3);
        final int i = 1;
        Callable callable = new Callable(this) { // from class: com.google.android.gms.internal.measurement.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e0 f2484b;

            {
                this.f2484b = this;
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                switch (i) {
                    case 0:
                        return new k4(this.f2484b.f2548c);
                    default:
                        return new k4(this.f2484b.f2549d);
                }
            }
        };
        z5 z5Var = (z5) sVar.f11758n;
        ((HashMap) z5Var.f2934a).put("internal.registerCallback", callable);
        final int i6 = 0;
        ((HashMap) z5Var.f2934a).put("internal.eventLogger", new Callable(this) { // from class: com.google.android.gms.internal.measurement.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ e0 f2484b;

            {
                this.f2484b = this;
            }

            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                switch (i6) {
                    case 0:
                        return new k4(this.f2484b.f2548c);
                    default:
                        return new k4(this.f2484b.f2549d);
                }
            }
        });
    }

    public final boolean a(b bVar) {
        b5.m mVar = this.f2548c;
        try {
            mVar.f1061b = bVar;
            mVar.f1062l = bVar.clone();
            ((ArrayList) mVar.f1063m).clear();
            ((y2.s) this.f2546a.f11757m).N("runtime.counter", new g(Double.valueOf(0.0d)));
            this.f2549d.d(this.f2547b.L(), mVar);
            if (((b) mVar.f1062l).equals((b) mVar.f1061b)) {
                return !((ArrayList) mVar.f1063m).isEmpty();
            }
            return true;
        } catch (Throwable th) {
            throw new q0(th);
        }
    }

    public final void b(v3 v3Var) {
        h hVar;
        try {
            y2.s sVar = this.f2546a;
            this.f2547b = ((y2.s) sVar.f11756l).L();
            if (sVar.I(this.f2547b, (w3[]) v3Var.o().toArray(new w3[0])) instanceof f) {
                throw new IllegalStateException("Program loading failed");
            }
            for (u3 u3Var : v3Var.p().o()) {
                List p10 = u3Var.p();
                String o10 = u3Var.o();
                Iterator it = p10.iterator();
                while (it.hasNext()) {
                    n I = sVar.I(this.f2547b, (w3) it.next());
                    if (!(I instanceof k)) {
                        throw new IllegalArgumentException("Invalid rule definition");
                    }
                    y2.s sVar2 = this.f2547b;
                    if (sVar2.M(o10)) {
                        n P = sVar2.P(o10);
                        if (!(P instanceof h)) {
                            throw new IllegalStateException("Invalid function name: ".concat(String.valueOf(o10)));
                        }
                        hVar = (h) P;
                    } else {
                        hVar = null;
                    }
                    if (hVar == null) {
                        throw new IllegalStateException("Rule function is undefined: ".concat(String.valueOf(o10)));
                    }
                    hVar.a(this.f2547b, Collections.singletonList(I));
                }
            }
        } catch (Throwable th) {
            throw new q0(th);
        }
    }
}
