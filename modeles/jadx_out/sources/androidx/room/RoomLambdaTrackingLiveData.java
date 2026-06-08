package androidx.room;

import androidx.room.util.DBUtil;
import d7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RoomLambdaTrackingLiveData<T> extends RoomTrackingLiveData<T> {
    private final l lambdaFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomLambdaTrackingLiveData(RoomDatabase roomDatabase, InvalidationLiveDataContainer invalidationLiveDataContainer, boolean z9, String[] strArr, l lVar) {
        super(roomDatabase, invalidationLiveDataContainer, z9, strArr, null);
        roomDatabase.getClass();
        invalidationLiveDataContainer.getClass();
        strArr.getClass();
        lVar.getClass();
        this.lambdaFunction = lVar;
    }

    @Override // androidx.room.RoomTrackingLiveData
    public Object compute(t6.c cVar) {
        return DBUtil.performSuspending(getDatabase(), true, getInTransaction(), this.lambdaFunction, cVar);
    }
}
