package androidx.datastore.core;

import androidx.datastore.core.Message;
import d7.p;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.DataStoreImpl$writeActor$3", f = "DataStoreImpl.kt", l = {207}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreImpl$writeActor$3 extends i implements p {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$writeActor$3(DataStoreImpl<T> dataStoreImpl, c cVar) {
        super(2, cVar);
        this.this$0 = dataStoreImpl;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        DataStoreImpl$writeActor$3 dataStoreImpl$writeActor$3 = new DataStoreImpl$writeActor$3(this.this$0, cVar);
        dataStoreImpl$writeActor$3.L$0 = obj;
        return dataStoreImpl$writeActor$3;
    }

    @Override // d7.p
    public final Object invoke(Message.Update<T> update, c cVar) {
        return ((DataStoreImpl$writeActor$3) create(update, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        Object handleUpdate;
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            Message.Update update = (Message.Update) this.L$0;
            DataStoreImpl<T> dataStoreImpl = this.this$0;
            this.label = 1;
            handleUpdate = dataStoreImpl.handleUpdate(update, this);
            u6.a aVar = u6.a.f10762a;
            if (handleUpdate == aVar) {
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
