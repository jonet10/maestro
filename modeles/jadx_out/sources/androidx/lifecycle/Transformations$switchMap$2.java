package androidx.lifecycle;

import androidx.arch.core.util.Function;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Transformations$switchMap$2 implements Observer {
    final /* synthetic */ MediatorLiveData $result;
    final /* synthetic */ Function $switchMapFunction;
    private LiveData liveData;

    public Transformations$switchMap$2(Function function, MediatorLiveData mediatorLiveData) {
        this.$switchMapFunction = function;
        this.$result = mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x onChanged$lambda$0(MediatorLiveData mediatorLiveData, Object obj) {
        mediatorLiveData.setValue(obj);
        return x.f8463a;
    }

    public final LiveData getLiveData() {
        return this.liveData;
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(Object obj) {
        LiveData liveData = (LiveData) this.$switchMapFunction.apply(obj);
        LiveData liveData2 = this.liveData;
        if (liveData2 == liveData) {
            return;
        }
        if (liveData2 != null) {
            this.$result.removeSource(liveData2);
        }
        this.liveData = liveData;
        if (liveData != null) {
            MediatorLiveData mediatorLiveData = this.$result;
            mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new c(mediatorLiveData, 2)));
        }
    }

    public final void setLiveData(LiveData liveData) {
        this.liveData = liveData;
    }
}
