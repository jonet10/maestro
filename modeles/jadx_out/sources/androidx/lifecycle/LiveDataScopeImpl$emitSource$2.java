package androidx.lifecycle;

import d7.p;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.lifecycle.LiveDataScopeImpl$emitSource$2", f = "CoroutineLiveData.kt", l = {94}, m = "invokeSuspend", v = 1)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LiveDataScopeImpl$emitSource$2 extends v6.i implements p {
    final /* synthetic */ LiveData<T> $source;
    int label;
    final /* synthetic */ LiveDataScopeImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveDataScopeImpl$emitSource$2(LiveDataScopeImpl<T> liveDataScopeImpl, LiveData<T> liveData, t6.c cVar) {
        super(2, cVar);
        this.this$0 = liveDataScopeImpl;
        this.$source = liveData;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new LiveDataScopeImpl$emitSource$2(this.this$0, this.$source, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((LiveDataScopeImpl$emitSource$2) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
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
        CoroutineLiveData target$lifecycle_livedata = this.this$0.getTarget$lifecycle_livedata();
        Object obj2 = this.$source;
        this.label = 1;
        Object emitSource$lifecycle_livedata = target$lifecycle_livedata.emitSource$lifecycle_livedata(obj2, this);
        u6.a aVar = u6.a.f10762a;
        return emitSource$lifecycle_livedata == aVar ? aVar : emitSource$lifecycle_livedata;
    }
}
