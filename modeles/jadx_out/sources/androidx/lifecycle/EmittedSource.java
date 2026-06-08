package androidx.lifecycle;

import androidx.annotation.MainThread;
import o7.c0;
import o7.m0;
import o7.o0;
import p6.x;
import t7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class EmittedSource implements o0 {
    private boolean disposed;
    private final MediatorLiveData<?> mediator;
    private final LiveData<?> source;

    public EmittedSource(LiveData<?> liveData, MediatorLiveData<?> mediatorLiveData) {
        liveData.getClass();
        mediatorLiveData.getClass();
        this.source = liveData;
        this.mediator = mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void removeSource() {
        if (this.disposed) {
            return;
        }
        this.mediator.removeSource(this.source);
        this.disposed = true;
    }

    @Override // o7.o0
    public void dispose() {
        v7.e eVar = m0.f8288a;
        c0.s(c0.b(n.f10348a.f8468l), null, null, new EmittedSource$dispose$1(this, null), 3);
    }

    public final Object disposeNow(t6.c cVar) {
        v7.e eVar = m0.f8288a;
        Object C = c0.C(new EmittedSource$disposeNow$2(this, null), n.f10348a.f8468l, cVar);
        return C == u6.a.f10762a ? C : x.f8463a;
    }
}
