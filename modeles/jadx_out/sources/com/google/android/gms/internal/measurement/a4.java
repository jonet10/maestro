package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import j$.util.Objects;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a4 extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2488a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2489b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a4(e2.d dVar) {
        super(null);
        Objects.requireNonNull(dVar);
        this.f2489b = dVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z9) {
        switch (this.f2488a) {
            case 0:
                ((AtomicBoolean) ((e2.d) this.f2489b).f4466b).set(true);
                return;
            default:
                f4 f4Var = (f4) this.f2489b;
                synchronized (f4Var.f) {
                    f4Var.g = null;
                    f4Var.f2573c.run();
                }
                synchronized (f4Var) {
                    try {
                        Iterator it = f4Var.h.iterator();
                        if (it.hasNext()) {
                            if (it.next() != null) {
                                throw new ClassCastException();
                            }
                            throw null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a4(f4 f4Var) {
        super(null);
        this.f2489b = f4Var;
    }
}
