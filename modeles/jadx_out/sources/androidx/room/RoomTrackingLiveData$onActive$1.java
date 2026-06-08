package androidx.room;

import d7.p;
import o7.a0;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.room.RoomTrackingLiveData$onActive$1", f = "RoomTrackingLiveData.android.kt", l = {123}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class RoomTrackingLiveData$onActive$1 extends i implements p {
    int label;
    final /* synthetic */ RoomTrackingLiveData<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomTrackingLiveData$onActive$1(RoomTrackingLiveData<T> roomTrackingLiveData, t6.c cVar) {
        super(2, cVar);
        this.this$0 = roomTrackingLiveData;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new RoomTrackingLiveData$onActive$1(this.this$0, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((RoomTrackingLiveData$onActive$1) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object refresh;
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            RoomTrackingLiveData<T> roomTrackingLiveData = this.this$0;
            this.label = 1;
            refresh = roomTrackingLiveData.refresh(this);
            u6.a aVar = u6.a.f10762a;
            if (refresh == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return x.f8463a;
    }
}
