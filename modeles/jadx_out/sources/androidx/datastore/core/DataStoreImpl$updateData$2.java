package androidx.datastore.core;

import androidx.datastore.core.Message;
import d7.p;
import o7.a0;
import o7.c0;
import o7.r;
import p6.x;
import t6.c;
import v6.e;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@e(c = "androidx.datastore.core.DataStoreImpl$updateData$2", f = "DataStoreImpl.kt", l = {169}, m = "invokeSuspend")
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DataStoreImpl$updateData$2 extends i implements p {
    final /* synthetic */ p $transform;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$updateData$2(DataStoreImpl<T> dataStoreImpl, p pVar, c cVar) {
        super(2, cVar);
        this.this$0 = dataStoreImpl;
        this.$transform = pVar;
    }

    @Override // v6.a
    public final c create(Object obj, c cVar) {
        DataStoreImpl$updateData$2 dataStoreImpl$updateData$2 = new DataStoreImpl$updateData$2(this.this$0, this.$transform, cVar);
        dataStoreImpl$updateData$2.L$0 = obj;
        return dataStoreImpl$updateData$2;
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, c cVar) {
        return ((DataStoreImpl$updateData$2) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        SimpleActor simpleActor;
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                p6.a.e(obj);
                return obj;
            }
            androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        p6.a.e(obj);
        a0 a0Var = (a0) this.L$0;
        r a8 = c0.a();
        Message.Update update = new Message.Update(this.$transform, a8, ((DataStoreImpl) this.this$0).inMemoryCache.getCurrentState(), a0Var.getCoroutineContext());
        simpleActor = ((DataStoreImpl) this.this$0).writeActor;
        simpleActor.offer(update);
        this.label = 1;
        Object w2 = a8.w(this);
        u6.a aVar = u6.a.f10762a;
        return w2 == aVar ? aVar : w2;
    }
}
