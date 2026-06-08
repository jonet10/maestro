package androidx.lifecycle;

import androidx.annotation.CheckResult;
import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;
import kotlin.jvm.internal.u;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Transformations {
    @CheckResult
    @MainThread
    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        MediatorLiveData mediatorLiveData;
        liveData.getClass();
        u uVar = new u();
        uVar.f7021a = true;
        if (liveData.isInitialized()) {
            uVar.f7021a = false;
            mediatorLiveData = new MediatorLiveData(liveData.getValue());
        } else {
            mediatorLiveData = new MediatorLiveData();
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new j(mediatorLiveData, uVar, 1)));
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x distinctUntilChanged$lambda$0(MediatorLiveData mediatorLiveData, u uVar, Object obj) {
        T value = mediatorLiveData.getValue();
        if (uVar.f7021a || ((value == 0 && obj != null) || (value != 0 && !value.equals(obj)))) {
            uVar.f7021a = false;
            mediatorLiveData.setValue(obj);
        }
        return x.f8463a;
    }

    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> map(LiveData<X> liveData, d7.l lVar) {
        liveData.getClass();
        lVar.getClass();
        MediatorLiveData mediatorLiveData = liveData.isInitialized() ? new MediatorLiveData(lVar.invoke(liveData.getValue())) : new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new j(mediatorLiveData, lVar, 0)));
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x map$lambda$0(MediatorLiveData mediatorLiveData, d7.l lVar, Object obj) {
        mediatorLiveData.setValue(lVar.invoke(obj));
        return x.f8463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x map$lambda$1(MediatorLiveData mediatorLiveData, Function function, Object obj) {
        mediatorLiveData.setValue(function.apply(obj));
        return x.f8463a;
    }

    @CheckResult
    @MainThread
    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, d7.l lVar) {
        MediatorLiveData mediatorLiveData;
        liveData.getClass();
        lVar.getClass();
        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
        if (liveData.isInitialized()) {
            LiveData liveData2 = (LiveData) lVar.invoke(liveData.getValue());
            mediatorLiveData = (liveData2 == null || !liveData2.isInitialized()) ? new MediatorLiveData() : new MediatorLiveData(liveData2.getValue());
        } else {
            mediatorLiveData = new MediatorLiveData();
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new i(lVar, xVar, mediatorLiveData, 0)));
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x switchMap$lambda$0(d7.l lVar, kotlin.jvm.internal.x xVar, MediatorLiveData mediatorLiveData, Object obj) {
        LiveData liveData = (LiveData) lVar.invoke(obj);
        Object obj2 = xVar.f7024a;
        if (obj2 != liveData) {
            if (obj2 != null) {
                mediatorLiveData.removeSource((LiveData) obj2);
            }
            xVar.f7024a = liveData;
            if (liveData != null) {
                mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new c(mediatorLiveData, 1)));
            }
        }
        return x.f8463a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x switchMap$lambda$0$0(MediatorLiveData mediatorLiveData, Object obj) {
        mediatorLiveData.setValue(obj);
        return x.f8463a;
    }

    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData map(LiveData liveData, Function function) {
        liveData.getClass();
        function.getClass();
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new j(mediatorLiveData, function, 2)));
        return mediatorLiveData;
    }

    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData switchMap(LiveData liveData, Function function) {
        liveData.getClass();
        function.getClass();
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$switchMap$2(function, mediatorLiveData));
        return mediatorLiveData;
    }
}
