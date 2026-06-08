package androidx.lifecycle;

import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import java.util.ArrayDeque;
import java.util.Queue;
import o7.m0;
import t7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DispatchQueue {
    private boolean finished;
    private boolean isDraining;
    private boolean paused = true;
    private final Queue<Runnable> queue = new ArrayDeque();

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void enqueue(Runnable runnable) {
        if (this.queue.offer(runnable)) {
            drainQueue();
        } else {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("cannot enqueue any more runnables");
        }
    }

    @MainThread
    public final boolean canRun() {
        return this.finished || !this.paused;
    }

    @AnyThread
    public final void dispatchAndEnqueue(t6.h hVar, final Runnable runnable) {
        hVar.getClass();
        runnable.getClass();
        v7.e eVar = m0.f8288a;
        p7.c cVar = n.f10348a.f8468l;
        if (cVar.isDispatchNeeded(hVar) || canRun()) {
            cVar.dispatch(hVar, new Runnable() { // from class: androidx.lifecycle.d
                @Override // java.lang.Runnable
                public final void run() {
                    DispatchQueue.this.enqueue(runnable);
                }
            });
        } else {
            enqueue(runnable);
        }
    }

    @MainThread
    public final void drainQueue() {
        if (this.isDraining) {
            return;
        }
        try {
            this.isDraining = true;
            while (!this.queue.isEmpty() && canRun()) {
                Runnable poll = this.queue.poll();
                if (poll != null) {
                    poll.run();
                }
            }
        } finally {
            this.isDraining = false;
        }
    }

    @MainThread
    public final void finish() {
        this.finished = true;
        drainQueue();
    }

    @MainThread
    public final void pause() {
        this.paused = true;
    }

    @MainThread
    public final void resume() {
        if (this.paused) {
            if (this.finished) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("Cannot resume a finished dispatcher");
            } else {
                this.paused = false;
                drainQueue();
            }
        }
    }
}
