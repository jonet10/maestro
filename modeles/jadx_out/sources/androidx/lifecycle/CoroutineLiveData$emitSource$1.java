package androidx.lifecycle;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@v6.e(c = "androidx.lifecycle.CoroutineLiveData", f = "CoroutineLiveData.kt", l = {221, 222}, m = "emitSource$lifecycle_livedata", v = 1)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class CoroutineLiveData$emitSource$1 extends v6.c {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CoroutineLiveData<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineLiveData$emitSource$1(CoroutineLiveData<T> coroutineLiveData, t6.c cVar) {
        super(cVar);
        this.this$0 = coroutineLiveData;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emitSource$lifecycle_livedata(null, this);
    }
}
