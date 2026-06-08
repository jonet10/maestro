package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class SynchronizedStartStopTokensImpl implements StartStopTokens {
    private final StartStopTokens delegate;
    private final Object lock;

    public SynchronizedStartStopTokensImpl(StartStopTokens startStopTokens) {
        startStopTokens.getClass();
        this.delegate = startStopTokens;
        this.lock = new Object();
    }

    @Override // androidx.work.impl.StartStopTokens
    public boolean contains(WorkGenerationalId workGenerationalId) {
        boolean contains;
        workGenerationalId.getClass();
        synchronized (this.lock) {
            contains = this.delegate.contains(workGenerationalId);
        }
        return contains;
    }

    @Override // androidx.work.impl.StartStopTokens
    public StartStopToken remove(WorkGenerationalId workGenerationalId) {
        StartStopToken remove;
        workGenerationalId.getClass();
        synchronized (this.lock) {
            remove = this.delegate.remove(workGenerationalId);
        }
        return remove;
    }

    @Override // androidx.work.impl.StartStopTokens
    public StartStopToken tokenFor(WorkGenerationalId workGenerationalId) {
        StartStopToken startStopToken;
        workGenerationalId.getClass();
        synchronized (this.lock) {
            startStopToken = this.delegate.tokenFor(workGenerationalId);
        }
        return startStopToken;
    }

    @Override // androidx.work.impl.StartStopTokens
    public final StartStopToken remove(WorkSpec workSpec) {
        int i = e.f575a;
        workSpec.getClass();
        return remove(WorkSpecKt.generationalId(workSpec));
    }

    @Override // androidx.work.impl.StartStopTokens
    public final StartStopToken tokenFor(WorkSpec workSpec) {
        int i = e.f575a;
        workSpec.getClass();
        return tokenFor(WorkSpecKt.generationalId(workSpec));
    }

    @Override // androidx.work.impl.StartStopTokens
    public List<StartStopToken> remove(String str) {
        List<StartStopToken> remove;
        str.getClass();
        synchronized (this.lock) {
            remove = this.delegate.remove(str);
        }
        return remove;
    }
}
