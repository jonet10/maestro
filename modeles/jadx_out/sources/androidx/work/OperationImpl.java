package androidx.work;

import androidx.lifecycle.LiveData;
import androidx.work.Operation;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class OperationImpl implements Operation {
    private final m1.b future;
    private final LiveData<Operation.State> state;

    public OperationImpl(LiveData<Operation.State> liveData, m1.b bVar) {
        liveData.getClass();
        bVar.getClass();
        this.state = liveData;
        this.future = bVar;
    }

    @Override // androidx.work.Operation
    public m1.b getResult() {
        return this.future;
    }

    @Override // androidx.work.Operation
    public LiveData<Operation.State> getState() {
        return this.state;
    }
}
