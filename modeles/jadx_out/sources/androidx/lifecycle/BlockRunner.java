package androidx.lifecycle;

import androidx.annotation.MainThread;
import d7.p;
import o7.a0;
import o7.c0;
import o7.e1;
import o7.m0;
import t7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class BlockRunner<T> {
    private final p block;
    private e1 cancellationJob;
    private final CoroutineLiveData<T> liveData;
    private final d7.a onDone;
    private e1 runningJob;
    private final a0 scope;
    private final long timeoutInMs;

    public BlockRunner(CoroutineLiveData<T> coroutineLiveData, p pVar, long j, a0 a0Var, d7.a aVar) {
        coroutineLiveData.getClass();
        pVar.getClass();
        a0Var.getClass();
        aVar.getClass();
        this.liveData = coroutineLiveData;
        this.block = pVar;
        this.timeoutInMs = j;
        this.scope = a0Var;
        this.onDone = aVar;
    }

    @MainThread
    public final void cancel() {
        if (this.cancellationJob != null) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Cancel call cannot happen without a maybeRun");
            return;
        }
        a0 a0Var = this.scope;
        v7.e eVar = m0.f8288a;
        this.cancellationJob = c0.s(a0Var, n.f10348a.f8468l, null, new BlockRunner$cancel$1(this, null), 2);
    }

    @MainThread
    public final void maybeRun() {
        e1 e1Var = this.cancellationJob;
        if (e1Var != null) {
            e1Var.c(null);
        }
        this.cancellationJob = null;
        if (this.runningJob != null) {
            return;
        }
        this.runningJob = c0.s(this.scope, null, null, new BlockRunner$maybeRun$1(this, null), 3);
    }
}
