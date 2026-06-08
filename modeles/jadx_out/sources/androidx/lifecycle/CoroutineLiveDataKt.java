package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import d7.p;
import j$.time.Duration;
import o7.c0;
import o7.m0;
import t7.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CoroutineLiveDataKt {
    public static final long DEFAULT_TIMEOUT = 5000;

    public static final <T> Object addDisposableSource(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, t6.c cVar) {
        v7.e eVar = m0.f8288a;
        return c0.C(new CoroutineLiveDataKt$addDisposableSource$2(mediatorLiveData, liveData, null), n.f10348a.f8468l, cVar);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(Duration duration, t6.h hVar, p pVar) {
        duration.getClass();
        hVar.getClass();
        pVar.getClass();
        return new CoroutineLiveData(hVar, Api26Impl.INSTANCE.toMillis(duration), pVar);
    }

    public static /* synthetic */ LiveData liveData$default(t6.h hVar, long j, p pVar, int i, Object obj) {
        if ((i & 1) != 0) {
            hVar = t6.i.f10314a;
        }
        if ((i & 2) != 0) {
            j = DEFAULT_TIMEOUT;
        }
        return liveData(hVar, j, pVar);
    }

    public static /* synthetic */ LiveData liveData$default(Duration duration, t6.h hVar, p pVar, int i, Object obj) {
        if ((i & 2) != 0) {
            hVar = t6.i.f10314a;
        }
        return liveData(duration, hVar, pVar);
    }

    @RequiresApi(26)
    public static final <T> LiveData<T> liveData(Duration duration, p pVar) {
        duration.getClass();
        pVar.getClass();
        return liveData$default(duration, (t6.h) null, pVar, 2, (Object) null);
    }

    public static final <T> LiveData<T> liveData(t6.h hVar, p pVar) {
        hVar.getClass();
        pVar.getClass();
        return liveData$default(hVar, 0L, pVar, 2, (Object) null);
    }

    public static final <T> LiveData<T> liveData(t6.h hVar, long j, p pVar) {
        hVar.getClass();
        pVar.getClass();
        return new CoroutineLiveData(hVar, j, pVar);
    }

    public static final <T> LiveData<T> liveData(p pVar) {
        pVar.getClass();
        return liveData$default((t6.h) null, 0L, pVar, 3, (Object) null);
    }
}
