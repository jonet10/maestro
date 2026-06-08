package androidx.room;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.RoomTrackingLiveData", f = "RoomTrackingLiveData.android.kt", l = {82}, m = "refresh")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RoomTrackingLiveData$refresh$1 extends v6.c {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RoomTrackingLiveData<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomTrackingLiveData$refresh$1(RoomTrackingLiveData<T> roomTrackingLiveData, t6.c cVar) {
        super(cVar);
        this.this$0 = roomTrackingLiveData;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object refresh;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        refresh = this.this$0.refresh(this);
        return refresh;
    }
}
