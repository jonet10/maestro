package androidx.lifecycle;

import d7.p;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.lifecycle.LiveDataScopeImpl$emit$2", f = "CoroutineLiveData.kt", l = {100}, m = "invokeSuspend", v = 1)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LiveDataScopeImpl$emit$2 extends v6.i implements p {
    final /* synthetic */ T $value;
    int label;
    final /* synthetic */ LiveDataScopeImpl<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveDataScopeImpl$emit$2(LiveDataScopeImpl<T> liveDataScopeImpl, T t9, t6.c cVar) {
        super(2, cVar);
        this.this$0 = liveDataScopeImpl;
        this.$value = t9;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new LiveDataScopeImpl$emit$2(this.this$0, this.$value, cVar);
    }

    @Override // d7.p
    public final Object invoke(a0 a0Var, t6.c cVar) {
        return ((LiveDataScopeImpl$emit$2) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.label;
        if (i == 0) {
            p6.a.e(obj);
            CoroutineLiveData target$lifecycle_livedata = this.this$0.getTarget$lifecycle_livedata();
            this.label = 1;
            Object clearSource$lifecycle_livedata = target$lifecycle_livedata.clearSource$lifecycle_livedata(this);
            u6.a aVar = u6.a.f10762a;
            if (clearSource$lifecycle_livedata == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        this.this$0.getTarget$lifecycle_livedata().setValue(this.$value);
        return x.f8463a;
    }
}
