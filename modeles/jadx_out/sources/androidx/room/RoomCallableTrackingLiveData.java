package androidx.room;

import java.util.concurrent.Callable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RoomCallableTrackingLiveData<T> extends RoomTrackingLiveData<T> {
    private final Callable<T> callableFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomCallableTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z9, String[] strArr, Callable<T> callable) {
        super(roomDatabase, invalidationLiveDataContainer, z9, strArr, null);
        roomDatabase.getClass();
        invalidationLiveDataContainer.getClass();
        strArr.getClass();
        callable.getClass();
        this.callableFunction = callable;
    }

    @Override // androidx.room.RoomTrackingLiveData
    public Object compute(t6.c cVar) {
        return this.callableFunction.call();
    }
}
