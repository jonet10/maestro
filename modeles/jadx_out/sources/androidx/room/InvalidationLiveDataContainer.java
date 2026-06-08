package androidx.room;

import androidx.lifecycle.LiveData;
import d7.l;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class InvalidationLiveDataContainer {
    private final RoomDatabase database;
    private final Set<LiveData<?>> liveDataSet;

    public InvalidationLiveDataContainer(RoomDatabase roomDatabase) {
        roomDatabase.getClass();
        this.database = roomDatabase;
        Set<LiveData<?>> newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.getClass();
        this.liveDataSet = newSetFromMap;
    }

    public final <T> LiveData<T> create(String[] strArr, boolean z9, Callable<T> callable) {
        strArr.getClass();
        callable.getClass();
        return new RoomCallableTrackingLiveData(this.database, this, z9, strArr, callable);
    }

    public final Set<LiveData<?>> getLiveDataSet$room_runtime_release() {
        return this.liveDataSet;
    }

    public final void onActive(LiveData<?> liveData) {
        liveData.getClass();
        this.liveDataSet.add(liveData);
    }

    public final void onInactive(LiveData<?> liveData) {
        liveData.getClass();
        this.liveDataSet.remove(liveData);
    }

    public final <T> LiveData<T> create(String[] strArr, boolean z9, l lVar) {
        strArr.getClass();
        lVar.getClass();
        return new RoomLambdaTrackingLiveData(this.database, this, z9, strArr, lVar);
    }
}
