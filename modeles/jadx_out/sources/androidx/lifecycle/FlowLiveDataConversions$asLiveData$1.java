package androidx.lifecycle;

import d7.p;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", l = {78}, m = "invokeSuspend", v = 1)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FlowLiveDataConversions$asLiveData$1 extends v6.i implements p {
    final /* synthetic */ r7.h $this_asLiveData;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLiveDataConversions$asLiveData$1(r7.h hVar, t6.c cVar) {
        super(2, cVar);
        this.$this_asLiveData = hVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        FlowLiveDataConversions$asLiveData$1 flowLiveDataConversions$asLiveData$1 = new FlowLiveDataConversions$asLiveData$1(this.$this_asLiveData, cVar);
        flowLiveDataConversions$asLiveData$1.L$0 = obj;
        return flowLiveDataConversions$asLiveData$1;
    }

    @Override // d7.p
    public final Object invoke(LiveDataScope<T> liveDataScope, t6.c cVar) {
        return ((FlowLiveDataConversions$asLiveData$1) create(liveDataScope, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
            r7.h hVar = this.$this_asLiveData;
            r7.i iVar = new r7.i() { // from class: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1.1
                @Override // r7.i
                public final Object emit(T t9, t6.c cVar) {
                    Object emit = liveDataScope.emit(t9, cVar);
                    return emit == u6.a.f10762a ? emit : x.f8463a;
                }
            };
            this.label = 1;
            Object collect = hVar.collect(iVar, this);
            u6.a aVar = u6.a.f10762a;
            if (collect == aVar) {
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
