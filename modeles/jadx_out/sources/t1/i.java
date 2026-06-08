package t1;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i implements Executor {

    /* renamed from: o, reason: collision with root package name */
    public static final Logger f9527o = Logger.getLogger(i.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final Executor f9528a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f9529b = new ArrayDeque();

    /* renamed from: l, reason: collision with root package name */
    public int f9530l = 1;

    /* renamed from: m, reason: collision with root package name */
    public long f9531m = 0;

    /* renamed from: n, reason: collision with root package name */
    public final m4.a f9532n = new m4.a(this);

    public i(Executor executor) {
        y.g(executor);
        this.f9528a = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        y.g(runnable);
        synchronized (this.f9529b) {
            int i = this.f9530l;
            if (i != 4 && i != 3) {
                long j = this.f9531m;
                q0.b bVar = new q0.b(runnable, 2);
                this.f9529b.add(bVar);
                this.f9530l = 2;
                try {
                    this.f9528a.execute(this.f9532n);
                    if (this.f9530l != 2) {
                        return;
                    }
                    synchronized (this.f9529b) {
                        try {
                            if (this.f9531m == j && this.f9530l == 2) {
                                this.f9530l = 3;
                            }
                        } finally {
                        }
                    }
                    return;
                } catch (Error | RuntimeException e10) {
                    synchronized (this.f9529b) {
                        try {
                            int i6 = this.f9530l;
                            boolean z9 = true;
                            if ((i6 != 1 && i6 != 2) || !this.f9529b.removeLastOccurrence(bVar)) {
                                z9 = false;
                            }
                            if (!(e10 instanceof RejectedExecutionException) || z9) {
                                throw e10;
                            }
                        } finally {
                        }
                    }
                    return;
                }
            }
            this.f9529b.add(runnable);
        }
    }

    public final String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f9528a + "}";
    }
}
