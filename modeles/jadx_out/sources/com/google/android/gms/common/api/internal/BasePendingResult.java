package com.google.android.gms.common.api.internal;

import a4.d;
import android.os.Looper;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import i0.g;
import i0.i;
import j0.j;
import j0.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@KeepName
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class BasePendingResult<R extends i> {
    public static final d j = new d(2);

    /* renamed from: e, reason: collision with root package name */
    public i f2482e;
    public Status f;
    public volatile boolean g;
    public boolean h;

    /* renamed from: a, reason: collision with root package name */
    public final Object f2478a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final CountDownLatch f2479b = new CountDownLatch(1);

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2480c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReference f2481d = new AtomicReference();
    public boolean i = false;

    public BasePendingResult(g gVar) {
        new j0.d(gVar != null ? ((o) gVar).f6519b.f : Looper.getMainLooper(), 4);
        new WeakReference(gVar);
    }

    public final void a(j jVar) {
        synchronized (this.f2478a) {
            try {
                if (d()) {
                    jVar.a(this.f);
                } else {
                    this.f2480c.add(jVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract i b(Status status);

    public final void c(Status status) {
        synchronized (this.f2478a) {
            try {
                if (!d()) {
                    e(b(status));
                    this.h = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean d() {
        return this.f2479b.getCount() == 0;
    }

    public final void e(i iVar) {
        synchronized (this.f2478a) {
            try {
                if (this.h) {
                    return;
                }
                d();
                y.i(!d(), "Results have already been set");
                y.i(!this.g, "Result has already been consumed");
                this.f2482e = iVar;
                this.f = iVar.b();
                this.f2479b.countDown();
                ArrayList arrayList = this.f2480c;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((j) arrayList.get(i)).a(this.f);
                }
                arrayList.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
