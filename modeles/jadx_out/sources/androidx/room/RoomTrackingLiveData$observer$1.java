package androidx.room;

import a2.s;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.InvalidationTracker;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RoomTrackingLiveData$observer$1 extends InvalidationTracker.Observer {
    final /* synthetic */ RoomTrackingLiveData<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomTrackingLiveData$observer$1(String[] strArr, RoomTrackingLiveData<T> roomTrackingLiveData) {
        super(strArr);
        this.this$0 = roomTrackingLiveData;
    }

    @Override // androidx.room.InvalidationTracker.Observer
    public void onInvalidated(Set<String> set) {
        set.getClass();
        ArchTaskExecutor.getInstance().executeOnMainThread(new s(this.this$0, 2));
    }
}
