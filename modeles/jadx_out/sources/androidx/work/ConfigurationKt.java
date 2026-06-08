package androidx.work;

import a4.x;
import androidx.tracing.Trace;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import o7.l0;
import o7.w;
import o7.x0;
import t6.h;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ConfigurationKt {
    public static final int DEFAULT_CONTENT_URI_TRIGGERS_WORKERS_LIMIT = 8;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [o7.w] */
    public static final Executor asExecutor(h hVar) {
        Executor y9;
        t6.e eVar = hVar != null ? (t6.e) hVar.get(t6.d.f10313a) : null;
        x0 x0Var = eVar instanceof w ? (w) eVar : null;
        if (x0Var == null) {
            return null;
        }
        x0 x0Var2 = x0Var instanceof x0 ? x0Var : null;
        return (x0Var2 == null || (y9 = x0Var2.y()) == null) ? new l0(x0Var) : y9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Executor createDefaultExecutor(final boolean z9) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ThreadFactory() { // from class: androidx.work.ConfigurationKt$createDefaultExecutor$factory$1
            private final AtomicInteger threadCount = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                runnable.getClass();
                StringBuilder t9 = x.t(z9 ? "WM.task-" : "androidx.work-");
                t9.append(this.threadCount.incrementAndGet());
                return new Thread(runnable, t9.toString());
            }
        });
        newFixedThreadPool.getClass();
        return newFixedThreadPool;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Tracer createDefaultTracer() {
        return new Tracer() { // from class: androidx.work.ConfigurationKt$createDefaultTracer$tracer$1
            @Override // androidx.work.Tracer
            public void beginAsyncSection(String str, int i) {
                str.getClass();
                Trace.beginAsyncSection(str, i);
            }

            @Override // androidx.work.Tracer
            public void beginSection(String str) {
                str.getClass();
                Trace.beginSection(str);
            }

            @Override // androidx.work.Tracer
            public void endAsyncSection(String str, int i) {
                str.getClass();
                Trace.endAsyncSection(str, i);
            }

            @Override // androidx.work.Tracer
            public void endSection() {
                Trace.endSection();
            }

            @Override // androidx.work.Tracer
            public boolean isEnabled() {
                return Trace.isEnabled();
            }
        };
    }
}
