package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.RoomLambdaTrackingLiveData;
import j$.time.Duration;
import r7.k0;
import r7.m0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FlowLiveDataConversions {
    public static final <T> r7.h asFlow(LiveData<T> liveData) {
        liveData.getClass();
        return k0.g(k0.e(new FlowLiveDataConversions$asFlow$1(liveData, null)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> LiveData<T> asLiveData(r7.h hVar, t6.h hVar2, long j) {
        hVar.getClass();
        hVar2.getClass();
        RoomLambdaTrackingLiveData roomLambdaTrackingLiveData = (LiveData<T>) CoroutineLiveDataKt.liveData(hVar2, j, new FlowLiveDataConversions$asLiveData$1(hVar, null));
        if (hVar instanceof m0) {
            if (ArchTaskExecutor.getInstance().isMainThread()) {
                roomLambdaTrackingLiveData.setValue(((m0) hVar).getValue());
                return roomLambdaTrackingLiveData;
            }
            roomLambdaTrackingLiveData.postValue(((m0) hVar).getValue());
        }
        return roomLambdaTrackingLiveData;
    }

    public static /* synthetic */ LiveData asLiveData$default(r7.h hVar, t6.h hVar2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            hVar2 = t6.i.f10314a;
        }
        if ((i & 2) != 0) {
            j = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        }
        return asLiveData(hVar, hVar2, j);
    }

    public static /* synthetic */ LiveData asLiveData$default(r7.h hVar, Duration duration, t6.h hVar2, int i, Object obj) {
        if ((i & 2) != 0) {
            hVar2 = t6.i.f10314a;
        }
        return asLiveData(hVar, duration, hVar2);
    }

    public static final <T> LiveData<T> asLiveData(r7.h hVar, t6.h hVar2) {
        hVar.getClass();
        hVar2.getClass();
        return asLiveData$default(hVar, hVar2, 0L, 2, (Object) null);
    }

    public static final <T> LiveData<T> asLiveData(r7.h hVar) {
        hVar.getClass();
        return asLiveData$default(hVar, (t6.h) null, 0L, 3, (Object) null);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> asLiveData(r7.h hVar, Duration duration, t6.h hVar2) {
        hVar.getClass();
        duration.getClass();
        hVar2.getClass();
        return asLiveData(hVar, hVar2, Api26Impl.INSTANCE.toMillis(duration));
    }
}
